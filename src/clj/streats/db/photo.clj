(ns streats.db.photo)

(def photo
  {:photo/filename
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "filename"}
   :photo/comment
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "description or caption"}
   :photo/truck
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc "associated truck-id"}
   :photo/dish
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc "associated dish-id"}
   :photo/venue
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc "associated venue-id"}})