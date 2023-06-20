(ns streats.core
  (:require [streats.index.views :refer [index]]
            [reagent.dom :as rdom]
            [clojure.core.async :as async]
            [cljs-http.client :as http]
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
 :init-db
 (fn [_ _]
   {:loading true}))


(defn -main []
  ;;(dispatch [:init-db])
  (rdom/render [index] (js/document.getElementById "app")))

(-main)

