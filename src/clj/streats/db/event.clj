(ns streats.db.event)

(def event
  {:event/datetime 
   {:db/valueType :db.type/instant
    :db/cardinality :db.cardinality/one}
   :event/trucks 
   ;; how to represent a collection of trucks?
   ;; what is the correct type here?
   {:db/value :db.type/enumeration
    :db/cardinality :db.cardinality/many
    :db/doc "a list of trucks attending event"}
   :event/venue 
   {:db/cardinality :db.cardinality/one
    ;; should this be an id that represents a venue, or is a venue?
    :db/valueType :db.value/uuid}})