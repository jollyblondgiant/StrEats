(ns streats.core
  (:require [streats.index.views :refer [index]]
            [reagent.dom :as rdom]
            [re-frame.core :refer [dispatch reg-event-db]]))

(enable-console-print!)

(defonce appdb {:page :index})

(reg-event-db 
 :init-db
 (fn [_ _]
   appdb))

(defn -main []
  (dispatch [:init-db])
  (rdom/render [index] (js/document.getElementById "app")))

(-main)