(ns streats.db.review)

(def review
  {:review/user-id
   {:db/valueType :db.type/uuid
    :db/cardinality :db.cardinality/one}
   :review/rating
   {:db/valueType :db.type/number
    :db/cardinality :db.cardinality/one}
   :review/comment
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one}
   ;; this can be a truck or dish id
   ;; or should each key be defined?
   :review/tag-id
   {:db/valueType :db.type/uuid
    :db/cardinality :db.cardinality/one}
   })