(ns streats.map.events
  (:require [re-frame.core :refer [reg-event-db reg-event-fx dispatch]]
            [goog.dom :as dom]
            [goog.net.jsloader :as jsloader]))


(reg-event-db
 :init-map
 (fn [db _]
   (jsloader/load (:gmaps-api-string db) ; Replace YOUR_API_KEY with your actual API key
                  (fn []
                    (let [Map (.Map js/google.maps (dom/getElement "map"))
                          options {:center {:lat -34.397 :lng 150.644}
                                   :zoom 8}
                          map-instance (Map (dom/getElement "map") options)]
                      (dispatch [:set-map map-instance]))))
 db))

(reg-event-db
 :set-map
 (fn [db [_ map-instance]]
   (assoc db :map map-instance)))