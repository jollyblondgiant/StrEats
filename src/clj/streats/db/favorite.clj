(ns streats.db.favorite)

(def favorite
  {:favorite/user-id
   {:db/valueType :db.type/uuid
    :db/cardinality :db.cardinality/one}
   ;this can be a truck, dish, or venue
   ;; or should it be stipulated as that list of acceptable keys?
   :favorite/tag-id
   {:db/valueType :db.type/uuid 
    :db/cardinality :db.cardinality/one}})