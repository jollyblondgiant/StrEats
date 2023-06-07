(ns streats.search.views
  (:require [streats.search.events :as events]
            [streats.search.subs :as subs]
            [re-frame.core :refer [subscribe dispatch]]
            [reagent.core :as r]
            [reagent-mui.material.container :refer [container]]
            [reagent-mui.material.card :refer [card]]
            [reagent-mui.material.input :refer [input]]
            [reagent-mui.material.slider :refer [slider]]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.material.input-adornment :refer [input-adornment]]
            [reagent-mui.material.icon-button :refer [icon-button]]
            [reagent-mui.icons.search :refer [search] :rename {search search-icon}]
            [reagent-mui.icons.close :refer [close]]
            [reagent-mui.icons.local-shipping :refer [local-shipping]]
            [reagent-mui.material.icon-button :refer [icon-button]]))




(defn search
  []

  (let [radius (r/atom [0 5])
        search-keys (r/atom [])
        search-input (r/atom "")]
    (fn []
      [container
      [card
       {:class "expand-search"}
       [icon-button
        {:on-click #(do
                      (dispatch [::events/toggle-search])
                      (dispatch [::events/toggle-trucks]))}
       [local-shipping]]]
       [card
        {:class "search"}
        [input
         {:id "search-input"
          :full-width true
          :value @search-input
          :on-change #(reset! search-input (-> % .-target .-value))
          :end-adornment (r/as-element [input-adornment {:position :end
                                                       :on-click #(reset! search-keys (conj @search-keys @search-input))}
                                      [icon-button [search-icon]]])}]
        [slider
         {:value @radius
          :size :small
          :label "Radius"
          :on-change #(reset! radius (-> % .-target .-value))}]

        (for [idx (-> @search-keys count range)
              :let [term (nth @search-keys idx)]]
          [card
           {:class "search-key"}
           [close
            {:on-click #(reset! search-keys (into (subvec @search-keys 0 idx) (subvec @search-keys (inc idx))))}]
           [typography
            term]])]])))