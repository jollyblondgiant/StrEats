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
   ;; should this be handled thus or like menus are?
   :truck/cuisine
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/many
    :db/doc "a collection of string keywords for searching and filtering"}
   ;;should we add a collection of menus here, or let menus refer to this?
   :truck/geolocation geolocation})