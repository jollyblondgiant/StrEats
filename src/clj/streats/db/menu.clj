(ns streats.db.menu)

(def menu
  {:menu/name
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Truck Name"}
   :menu/active?
   {:db/valueType :db.type/boolean
    :db/cardinality :db.cardinality/one
    :db/doc "toggle active menu"}
   :menu/description
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Menu description"}
   ;; should this include an collection of dishes? uuids or dishes?
   ;; ought this to be a uuid or a full truck?
   :menu/truck
   {:db/valueType :db.type/uuid
    :db/cardinality :db.cardinality/one
    :db/doc "ID of associated truck"}})