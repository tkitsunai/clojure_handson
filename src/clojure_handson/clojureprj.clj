(ns clojure-handson.function)


;; マルチアリティ関数
(defn messenger
  ([] (messenger "hello world"))
  ([msg] (println msg)))

;; 可変長引数関数
;; whoはリストで渡ってくる
(defn hello [greeting & who]
  (println greeting who))

;; 無名関数
;; ((fn [message] (println message)) "HI")
;; 無名じゃない無名関数
;; ((fn tes [message] (println message)) "HI")

;; defn = def + fn

;; 無名関数 別の書き方
;; (fn [x] (+ 6 x)) same as (#(+ 6 %) 1)
;; (fn [x y] (+ x y)) same as (#(+ %1 %2) 1 2)
;; (fn [x y & zs] (println x y zs)) same as (#(println %1 %2 %&) 1 2 3 4)

;; 合算
(defn sum-all [ns]
  (apply + ns))
