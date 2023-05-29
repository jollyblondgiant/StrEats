(ns streats.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(enable-console-print!)

(prn "Code Loads")


(defn app []
 [:p "hello there"])

(defn -main []
  (rdom/render app (js/document.getElementById "app")))

(-main)