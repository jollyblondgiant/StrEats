(ns streats.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(enable-console-print!)


(defn app []
  (let []
    (fn []
      [:div "Howdy!"])))

(defn ^:export run []
  (rdom/render [app] (js/document.getElementById "app")))