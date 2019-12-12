(ns clojure-handson.ring-handson)

(defn handler [{:keys [uri] :as req}]
  {:status 200
   :body nil
   :headers {"content-type" "text/html"}}
)

(defn wrap-exclamation [handler]
  (fn [req]
    (let [res (handler req)]
      (update res :body str "!"))))

(defn f [req]
  {:body "Hello"})

(def f' (wrap-exclamation f))

(defn foo-handler [req]
  {:status 200 :body "foo"})

(defn bar-handler [req]
  {:status 200 :body "bar"})

(defn routing2 []
  (fn [{:keys [uri request-method] :as req}]
    (condp = [uri request-method]
      ["/foo" :get] (foo-handler req)
      ["/bar" :get] (bar-handler req)
      {:status 404})))

(def routes
  {"/foo" {:get foo-handler}
   "/bar" {:get bar-handler}})

(defn routing [routes]
  (fn [{:keys [uri request-method] :as req}]
    (if-let [handler (get-in routes [uri request-method])]
      (handler req)
      {:status 404})))

(def app (routing2))

;; (app {:uri "/bar" :request-method :get}) => {:status 200, :body "bar"}
;; (app {:uri "/foo" :request-method :get}) => {:status 200, :body "foo"}
;; (app {:uri "/bar" :request-method :put}) => {:status 404}
