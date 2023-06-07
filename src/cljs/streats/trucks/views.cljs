(ns streats.trucks.views
  (:require [streats.trucks.events :as events]
            [streats.trucks.subs :as subs]
            [re-frame.core :refer [subscribe dispatch]]
            [reagent.core :as r]
            [reagent-mui.material.container :refer [container]]
            [reagent-mui.material.card :refer [card]]
            [reagent-mui.material.icon-button :refer [icon-button]]
            [reagent-mui.icons.keyboard-arrow-down :refer [keyboard-arrow-down]]))

(defn trucks
  []
  (fn []
    [container
     {:class :trucks}
     [card
      {:class "minimize-trucks"}
      [icon-button
       {:on-click #(dispatch [::events/close-trucks])}
       [keyboard-arrow-down]]]]))