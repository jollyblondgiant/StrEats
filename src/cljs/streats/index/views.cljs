(ns streats.index.views
  (:require [streats.index.events :as events]
            [streats.index.subs :as subs]
            [streats.db :as db]
            [streats.map.views :refer [map-component]]
            [streats.profile.views :refer [profile]]
            [streats.login.views :refer [login-page]]
            [streats.search.views :refer [search]]
            [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch]]
            [goog.string :as gstring]
            [goog.string.format]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.icons.menu :refer [menu] :rename {menu menu*}]
            [reagent-mui.icons.account-circle :refer [account-circle]]
            [reagent-mui.icons.search :refer [search] :rename {search search*}]
            [reagent-mui.material.bottom-navigation :refer [bottom-navigation]]
            [reagent-mui.material.bottom-navigation-action :refer [bottom-navigation-action]]
            [reagent-mui.material.paper :refer [paper]]
            [reagent-mui.material.drawer :refer [drawer]]
            [reagent-mui.material.container :refer [container]]
            [reagent-mui.material.card :refer [card]]
            [reagent-mui.material.card-content :refer [card-content]]))






(defn navbot
  []
  (fn [] 
    (let [selected (r/atom nil)]
      [paper {:sx {:flex-grow 1
                   :position :fixed
                   :bottom 0
                   :left 0
                   :right 0}}
       [bottom-navigation {:show-labels true
                           :value @selected
                           :on-change (fn [e] (reset! selected e.target))}
        [bottom-navigation-action
         {:on-click #(dispatch [::events/toggle-menu])
          :icon (r/as-element [menu*])}]
        [bottom-navigation-action
         {:on-click #(dispatch [::events/toggle-search])
          :label (r/as-element [search*])}]
        [bottom-navigation-action
         {:on-click #(dispatch [::events/toggle-profile])
          :label (r/as-element [account-circle])}]]])))


(defn index-page
  []
  (let [page (subscribe [::subs/page])]
    (fn []
      [map-component])))

(defn side-menu
  []
  (fn []
    [container
     {:class "menu"}
     (for [[page title] db/pages]
       ^{:key page}
      [card
       {:class "menu-item primary"}
       [typography
       {:sx {:color :white}
        :font-family "Helvetica Neue"
        :variant :h3
        :on-click #(dispatch [::events/page page])}
       title]])]))


(defn index
  []
  (let [page (subscribe [::subs/page])
        show-profile? (subscribe [::subs/show-profile?])
        show-search? (subscribe [::subs/show-search?])
        show-menu? (subscribe [::subs/show-menu?])]
    (fn []
      [container
       [drawer
        {:class "left-drawer"
         :anchor :left
         :on-click #(dispatch [::events/toggle-menu])
         :open @show-menu?}
        [side-menu]]
        [drawer
         {:class "bottom-drawer small"
          :anchor :bottom
          :on-click #(dispatch [::events/toggle-search])
          :open @show-search?}
         [search]]
       [drawer
        {:class "right-drawer"
         :anchor :right
         :on-click #(dispatch [::events/toggle-profile])
         :open @show-profile?}
        [profile]]
       (condp = @page
         :index [index-page]
         :login [login-page]
         [:div (gstring/format "This is the %s page" (get db/pages @page "Blank"))])
       [navbot]])))