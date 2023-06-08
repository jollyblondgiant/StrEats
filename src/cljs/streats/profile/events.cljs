(ns streats.profile.events
  (:require [streats.db :as db]
            [re-frame.core :refer [reg-event-db]]))


(reg-event-db
 ::logout
 (fn [db _]
   (-> db
       (dissoc :user)
       (assoc :page :index))))


(reg-event-db
 ::login
 (fn [db _]
   (assoc db :user db/apollo)))


(reg-event-db
 ::page
 (fn [db [_ page]]
   (assoc db :page page)))

(reg-event-db
 ::toggle-profile
 (fn [db _]
   (update db :show-profile? not)))

