(ns streats.db.menu)

(def menu
  {:menu/name
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "menu Name"}
   :menu/active?
   {:db/valueType :db.type/boolean
    :db/cardinality :db.cardinality/one
    :db/doc "toggle active menu"}
   :menu/description
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Menu description"}
   :menu/dishes
   {:db/cardinality :db.cardinality/many
    :db/valueType :db.type/ref}
   :menu/truck
   {:db/valueType :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc "ID of associated truck"}})