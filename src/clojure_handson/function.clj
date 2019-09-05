(ns clojure-handson.clojureprj)

(defn messenger
  ([] (messenger "hello world"))
  ([msg] (println msg)))

(defn make-hello [name]
  (let [msg (str "Hello, " name)]
    (fn []
      (print msg))))

(def hello-kitsunai
  (make-hello "kitsunai"))

(defn make-thingy [z]
  (fn [& _] z))

(defn opposite [f]
  (fn [& args]
    (not (apply f args))))

(defn keisan1 [] (Math/cos Math/PI))

(defn keisan2 [x] (+ (Math/pow (Math/sin x) 2) (Math/pow (Math/cos x) 2)))

(defn collection-count []
  (count {:a "1"}))

;間違っているassoc
(defn incorrect-assoc [m]
  (assoc m :y 10)
  (assoc m :z 20))

(defn correct-assoc [m]
  ((assoc m :z 20) (assoc m :y 10)))
