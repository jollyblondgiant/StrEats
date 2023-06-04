(ns streats.index.views
  (:require [streats.index.events :as events]
            [streats.index.subs :as subs]
            [streats.map.views :refer [map-component]]
            [re-frame.core :refer [subscribe dispatch]]
            [goog.string :as gstring]
            [goog.string.format]
            [reagent-mui.material.app-bar :refer [app-bar]]
            [reagent-mui.material.box :refer [box]]
            [reagent-mui.material.toolbar :refer [toolbar]]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.material.button :refer [button]]
            [reagent-mui.material.icon-button :refer [icon-button]]
            [reagent-mui.icons.menu :refer [menu]]))


(defn navbar []
  (fn []
    [box {:sx {:flex-grow 1}}
     [app-bar {:position :static}
      [toolbar
       [icon-button {:size :large
                     :edge :start
                     :color :inherit
                     :aria-label "menu"
                     :sx {:mr 2}}
        [menu]]
       [typography {:variant "h6"
                    :component :div
                    :sx {:flex-grow 1}}
        "News"]
       [button {:color :inherit}
        "Login"]]]]))


(defn index-page []
  (let [page (subscribe [::subs/page])]
    (fn []
      [map-component])))


(defn index []
  (let [page (subscribe [::subs/page])]
    (fn []
      [:<> 
       [navbar]
       (condp = @page
         :index [index-page]
         [:<>])])))