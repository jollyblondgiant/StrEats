(ns streats.map.events
  (:require [re-frame.core :refer [reg-event-db reg-event-fx dispatch]]
            [goog.dom :as dom]
            [goog.net.jsloader :as jsloader]
            [streats.db :as db]))


(reg-event-db
 ::current-position
 (fn [db [_ pos]]
   (assoc db :current-position pos)))


(reg-event-db
 ::set-trucks
 (fn [db [_ res]]
   (prn "fetched trucks. adding to db")
   (-> db
       (dissoc :loading)
       (assoc :trucks []))))


(reg-event-db
 ::get-trucks
 (fn [db _]
   (prn "fetching trucks based on search filters and client geolocation...")
   (assoc db :loading true)
   (dispatch [::set-trucks nil])))


