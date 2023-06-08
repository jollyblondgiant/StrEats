(ns streats.core
  (:require [streats.index.views :refer [index]]
            [reagent.dom :as rdom]
            [streats.db :refer [appdb]]
            [re-frame.core :refer [dispatch dispatch-sync reg-event-db reg-event-fx]]
            [streats.db :as db]))

(enable-console-print!)


(reg-event-db
 :data-loaded
 (fn [db _]
   (-> db
       (dissoc :loading)
       (assoc :page :map))))

(reg-event-db
 :get-mapstring
 (fn [db _]
   (when-let [mapstring (db/map-string)]
     (assoc db :gmaps-api-string mapstring))))

(reg-event-db 
 :init-db
 (fn [_ _]
   (dispatch-sync [:get-mapstring])
   
   {:loading true}))


(defn -main []
  (dispatch [:init-db])
  (rdom/render [index] (js/document.getElementById "app")))

(-main)