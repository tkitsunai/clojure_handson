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

;thread macro


;normal version
(defn transform [person]
  (update (assoc person :hair-color :gray) :age inc))

;thread first
(defn transform* [person]
  (-> person
      (assoc :hair-color :gray)
      (update :age inc)))

;normal version
(defn calculate []
  (reduce + (map #(* % %) (filter odd? (range 10)))))

;thread last version
(defn calculate* []
  (->> (range 10)
       (filter odd? ,,,)
       (map #(* % %) ,,,)
       (reduce + ,,,)))

;練習 osssans (spacemacs keybinds)
;ctrl+c, ctrl+f, t, l
(defn practice-ossans []
  (->> ossans
       (map #(update % :age inc))
       (reduce #(conj %1 (:age %2)) [])
       (let [ossans [{:name "おっさんA" :age 39} {:name "おっさんB" :age 50}]]))
  )


;分配束縛
(def my-line [[5 10] [10 20]])
(defn doDestructuring []
  (let [p1 (first my-line)
        p2 (second my-line)
        x1 (first p1)
        y1 (second p1)
        x2 (first p2)
        y2 (second p2)]
    (println "Line from (" x1 "," y1 ") to (" x2 ", " y2 ")"))
  )

;Destructuring Associative
(def client {:name "Super Co."
             :location "Philadelphia"
             :description "The worldwide leader in plastic tableware."})

(defn destructureAssociative1 []
  (let [name (:name client)
        location (:location client)
        description (:description client)]
    (println name location "-" description))
  )

(defn destructureAssociative2 []
  (let [{name :name
         location :location
         description :description} client]
    (println name location "-" description))
  )

;using keys!!!
(defn usingKeys []
  (let [{:keys [name location description]} client]
    (println name location "-" description))
  )

;Associative strs
(def string-keys {"first-name" "Joe" "last-name" "Smith"})
(defn strsKeys []
  (let [{:strs [first-name last-name]} string-keys]
    (println first-name last-name))
  )

(def human {:person/name "Franklin"
            :person/age 25
            :hobby/hobbies "running"})

(defn humanKeysBinding []
  (let [{:keys [hobby/hobbies]
         :person/keys [name age]
         :or {age 0}} human]
    (println name "is" age "and likes" hobbies))
  )
