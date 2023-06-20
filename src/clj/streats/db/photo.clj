(ns streats.db.photo)

(def photo
  {:photo/filename 
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "filename"}
   :photo/comment
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "description or caption"}
    ;; should we keep this generic or define that it can be one of truck or dish etc?
    :photo/tag-id
    {:db/valueType :db.type/uuid
     :db/cardinality :db.cardinality/one
     :db/doc "associated truck/dish/venue-id"}})