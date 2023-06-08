(ns streats.core
  (:require [streats.index.views :refer [index]]
            [reagent.dom :as rdom]
            [streats.db :refer [appdb]]
            [re-frame.core :refer [dispatch dispatch-sync reg-event-db reg-event-fx]]))

(enable-console-print!)


(reg-event-db
 :data-loaded
 (fn [db _]
   (dissoc db :loading)))

(reg-event-db 
 :init-db
 (fn [_ _]
   (js/setTimeout #(dispatch [:data-loaded]) 3000)
   {:loading true}))


(defn -main []
  (dispatch-sync [:init-db])
  (rdom/render [index] (js/document.getElementById "app"))
  )

(-main)