(ns streats.db.truck
  (:require [streats.db.util :refer [geolocation]]))

(def truck
  {:truck/name 
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Truck Name"}
   :truck/logo 
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "The filename of the truck logo"}
   :truck/description 
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Something Interesting about the truck"}
   :truck/cuisine
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/many
    :db/doc "a collection of string keywords for searching and filtering"}
   :truck/menus
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/many}
   :truck/reviews 
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :truck/events
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/many}
   :truck/photos
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :truck/orders
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :truck/favorites
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :truck/geolocation geolocation})