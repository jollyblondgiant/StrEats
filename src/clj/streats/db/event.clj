(ns streats.db.event)

(def event
  {:event/datetime
   {:db/valueType :db.type/instant
    :db/cardinality :db.cardinality/one}
   :event/trucks 
   {:db/value :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/doc "a list of trucks attending event"}
   :event/venue
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}})