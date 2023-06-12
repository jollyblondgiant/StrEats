(ns streats.index.views
  (:require [streats.index.events :as events]
            [streats.index.subs :as subs]
            [streats.db :as db]
            [streats.map.views :refer [map-page]]
            [streats.profile.views :refer [profile]]
            [streats.login.views :refer [login-page]]
            [streats.search.views :refer [search]]
            [streats.trucks.views :refer [trucks]]
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
            [reagent-mui.material.card-media :refer [card-media]]))


(defn splash-page
  []
  (fn []
    [container
     {:id :splash-page}
     [card 
      {:class "splash-card"}
      [card-media
       [:img 
        {:src "img/logo.png"
         :alt "streats logo"}]]]]))

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
        :on-click #(do
                     (dispatch [::events/toggle-menu])
                     (dispatch [::events/page page]))}
       title]])]))


(defn index
  []
  (let [page (subscribe [::subs/page])
        show-profile? (subscribe [::subs/show-profile?])
        show-search? (subscribe [::subs/show-search?])
        show-menu? (subscribe [::subs/show-menu?])
        show-trucks? (subscribe [::subs/show-trucks?])
        app-data (subscribe [::subs/data-loading?])]
    (fn []
      [container
       {:id "app-root"}
       [drawer
        {:class "bottom-drawer-splash"
         :anchor :bottom

         :open @app-data}
        [splash-page]]
       [drawer
        {:class "left-drawer"
         :anchor :left
         :on-click (fn [e] (when (->> e.target.className (re-find #"backdrop") some?)
                             (dispatch [::events/toggle-menu])))
         :open @show-menu?}
        [side-menu]]
       [drawer
        {:class "bottom-drawer small"
         :anchor :bottom
         :on-click (fn [e]
                     (when (->> e.target.className (re-find #"backdrop") some?
                                (and (string? e.target.className)))
                       (dispatch [::events/toggle-search])))
         :open @show-search?}
        [search]]
       [drawer
        {:class "bottom-drawer full"
         :anchor :bottom
         :on-click (fn [e]
                     (when (->> e.target.className (re-find #"backdrop") some?
                                (and (string? e.target.className)))
                       (dispatch [::events/toggle-trucks])))
         :open @show-trucks?}
        [trucks]]
       [drawer
        {:class "right-drawer"
         :anchor :right
         :on-click (fn [e] (when (->> e.target.className (re-find #"backdrop") some?)
                             (dispatch [::events/toggle-profile])))
         :open @show-profile?}
        [profile]]
       (condp = @page
         :login [login-page]
         [map-page])
       [navbot]])))