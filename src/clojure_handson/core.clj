
(ns clojure-handson.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn test []
  (try
    (/ 2 0)
    (catch ArithmeticException e
      "divide by zero")
    (finally
      (println "cleanup"))))

(defmulti whisky :type)

(defmethod whisky :scotch
  [_]
  "名実ともにウイスキーの代表格。自然豊かな土地には100以上の蒸溜所があり、個性豊かなウイスキーを育みます。")

(defmethod whisky :irish
  [_]
  "“ウイスキーの元祖”とも言われ、古い歴史を持つアイリッシュウイスキー。")

(defmethod whisky :default
  [_]
  "これはウイスキーではない")


(defmulti responseStatus :status)

(defmethod responseStatus 200
  [_]
  "OK")

(defmethod responseStatus 404
  [_]
  "Not Found")
