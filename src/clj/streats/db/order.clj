(ns streats.db.order)

(def order
  {:order/dish-id 
   {:db/cardinality :db.cardinality/one
    ;; should we refer to dish by uuid or with dish?
    :db/valueType :db.type/uuid}
   :order/truck-id
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/uuid}
   :order/user-id 
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/uuid}
   :order/ready?
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/boolean}
   :order/sold?
   {:db/cardinality :db.cardinality/one
    :db/valueType :db.type/boolean}})