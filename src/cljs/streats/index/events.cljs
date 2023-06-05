(ns streats.index.events
  (:require [re-frame.core :refer [reg-event-db]]))

(reg-event-db
 ::page
 (fn [db [_ page]]
   (assoc db :page page)))


(reg-event-db
 ::logout
 (fn [db _]
   (-> db
       (dissoc :user)
       (assoc :page :index))))


(reg-event-db
 ::login
 (fn [db _]
   (assoc db :user :apollo)))


(reg-event-db
 ::toggle-menu
 (fn [db _]
   (update db :show-menu? not)))

(reg-event-db
 ::toggle-profile
 (fn [db _]
   (update db :show-profile? not)))

(reg-event-db
 ::toggle-search
 (fn [db _]
   (update db :show-search? not)))