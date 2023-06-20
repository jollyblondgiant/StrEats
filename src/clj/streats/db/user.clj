(ns streats.db.user)

(def user
  {:user/username
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "a unique username"}
   :user/email
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "user's email address"}
   :user/password
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "a hashed password"}
   :user/avatar
   {:db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "the filename to the users's current avatar"}})