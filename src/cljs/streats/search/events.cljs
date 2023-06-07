(ns streats.search.events
  (:require [re-frame.core :refer [reg-event-db]]))

(reg-event-db
 ::toggle-trucks
 (fn [db _]
   (update db :show-trucks? not)))

(reg-event-db
 ::toggle-search
 (fn [db _]
   (update db :show-search? not)))