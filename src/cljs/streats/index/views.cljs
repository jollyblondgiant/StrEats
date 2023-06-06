(ns streats.index.views
  (:require [streats.index.events :as events]
            [streats.index.subs :as subs]
            [streats.db :as db]
            [streats.map.views :refer [map-component]]
            [streats.profile.views :refer [profile]]
            [streats.login.views :refer [login-page]]
            [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch]]
            [goog.string :as gstring]
            [goog.string.format]
            [reagent-mui.material.app-bar :refer [app-bar]]
            [reagent-mui.material.box :refer [box]]
            [reagent-mui.material.toolbar :refer [toolbar]]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.material.button :refer [button]]
            [reagent-mui.material.icon-button :refer [icon-button]]
            [reagent-mui.icons.menu :as menu-icon]
            [reagent-mui.icons.account-circle :refer [account-circle]]
            [reagent-mui.icons.location-on :refer [location-on]]
            [reagent-mui.icons.search :refer [search]]
            [reagent-mui.material.menu :refer [menu]]
            [reagent-mui.material.menu-item :refer [menu-item]]
            [reagent-mui.material.bottom-navigation :refer [bottom-navigation]]
            [reagent-mui.material.bottom-navigation-action :refer [bottom-navigation-action]]
            [reagent-mui.material.paper :refer [paper]]
            [reagent-mui.material.drawer :refer [drawer]]
            [reagent-mui.material.box :refer [box]]))






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
          :icon (r/as-element [menu-icon/menu])}]
        [bottom-navigation-action
         {:on-click #(dispatch [::events/toggle-search])
          :label (r/as-element [search])}]
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
    [:<>
     (for [[page title] db/pages]
      [typography
       {:sx {:color :white}
        :font-family "Helvetica Neue"
        :variant :h3
        :on-click #(dispatch [::events/page page])}
       title])]))


(defn index
  []
  (let [page (subscribe [::subs/page])
        show-profile? (subscribe [::subs/show-profile?])
        show-search? (subscribe [::subs/show-search?])
        show-menu? (subscribe [::subs/show-menu?])]
    (fn []
      [:<>
       ;;[navbar]
       [drawer
        {:anchor :left
         :on-click #(dispatch [::events/toggle-menu])
         :open @show-menu?}
        [side-menu]]
        [drawer
         {:anchor :bottom
          :on-click #(dispatch [::events/toggle-search])
          :open @show-search?}
         "Search"]
       [drawer
        {:anchor :right
         :on-click #(dispatch [::events/toggle-profile])
         :open @show-profile?}
        [profile]]
       (condp = @page
         :index [index-page]
         :login [login-page]
         [:div (gstring/format "This is the %s page" (get db/pages @page "Blank"))])
       [navbot]])))