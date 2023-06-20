(ns streats.db.review)

(def review
  {:review/user-id
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}
   :review/rating
   {:db/valueType :db.type/number
    :db/cardinality :db.cardinality/one}
   :review/comment
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one}
   :review/truck
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}
   :review/venue
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}
   :review/dish
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}})