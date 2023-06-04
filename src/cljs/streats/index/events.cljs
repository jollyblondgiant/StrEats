(ns streats.index.events
  (:require [re-frame.core :refer [reg-event-db]]))

(reg-event-db
 ::page
 (fn [db [_ page]]
   (assoc db :page page)))