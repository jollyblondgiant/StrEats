(ns streats.trucks.events
  (:require [re-frame.core :refer [reg-event-db]]
            [streats.db :as db]))


(reg-event-db
 ::close-trucks
 (fn [db _]
   (-> db
       (update :show-trucks? not)
       (update :show-search? not))))