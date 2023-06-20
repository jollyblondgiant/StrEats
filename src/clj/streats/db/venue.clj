(ns streats.db.venue
  (:require [streats.db.util :refer [geolocation]]))


(def venue
  {:venue/name
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/string}
   :venue/description
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/string}
   :venue/geolocation geolocation})