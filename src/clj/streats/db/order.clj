(ns streats.db.order)

(def order
  {:order/dish-id 
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}
   :order/truck-id
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}
   :order/user-id 
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}
   :order/ready?
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/boolean}
   :order/sold?
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/boolean}})