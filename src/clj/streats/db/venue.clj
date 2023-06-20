(ns streats.db.venue
  (:require [streats.db.util :refer [geolocation]]))


(def venue
  {:venue/name
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/string}
   :venue/description
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/string}
   :venue/events
   {:db/cardinality :db.cardinality/many
    :db/valueType :db.type/ref}
   :venue/photos
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :venue/reviews
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :venue/favorites
   {:db/cardinality :db.cardinality/many
    :db/valueType  :db.type/ref}
   :venue/geolocation geolocation})