(ns streats.core
  (:require [streats.index.views :refer [index]]
            [reagent.dom :as rdom]
            [streats.db :refer [appdb]]
            [re-frame.core :refer [dispatch reg-event-db]]))

(enable-console-print!)



(reg-event-db 
 :init-db
 (fn [_ _]
   appdb))



(defn -main []
  (dispatch [:init-db])
  (rdom/render [index] (js/document.getElementById "app")))

(-main)