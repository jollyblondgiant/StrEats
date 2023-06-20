(ns streats.db.favorite)

(def favorite
  {:favorite/user-id
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one}
   :favorite/truck
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}
   :favorite/venue
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}
   :favorite/dish
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}})