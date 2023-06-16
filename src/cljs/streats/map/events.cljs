(ns streats.map.events
  (:require [re-frame.core :refer [reg-event-db reg-event-fx dispatch]]
            [goog.dom :as dom]
            [goog.net.jsloader :as jsloader]))


(reg-event-db
 ::current-position
 (fn [db [_ pos]]
   (assoc db :current-position pos)))