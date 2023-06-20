(ns streats.db.dish)

(def dish
  {:dish/name
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Dish Name"}
   :dish/description
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Dish Description"}
   :dish/price
   {:db/valueType :db.type/float
    :db/cardinality :db.cardinality/one
    :db/doc "Dish Price"}
   ;; shoudl this stay uuid or be a full menu?
   :dish/menu-id
   {:db/valueType :db.type/uuid
    :db/cardinality :db.cardinality/one
    :db/doc "ID of associated Menu"}})