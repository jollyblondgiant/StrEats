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
   :dish/menu
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc "ID of associated Menu"}
   :dish/photos
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :dish/reviews
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :dish/orders
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :dish/favorites
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}})