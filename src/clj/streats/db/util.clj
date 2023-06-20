(ns streats.db.util)

(def geolocation
  {:geo/latitude 
   {:db/valueType :db.type/float
    :db/cardinality :db.cardinality/one}
   :geo/longitude 
   {:db/valueType :db.type/float
    :db/cardinality :db.cardinality/one}})
