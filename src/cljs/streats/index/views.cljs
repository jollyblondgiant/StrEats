(ns streats.index.views
  (:require [streats.index.events :as events]
            [streats.index.subs :as subs]
            [streats.map.views :refer [map-component]]
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


(def pages 
  {:home "Home"
   :search "Search"
   :profile "Profile"
   :review "Review"
   :trucks "Trucks"
   :truck "Truck"
   :truck-menu "Menu"
   :food-item "Dish"})

(defn navbar 
  []
  (fn []
    (let [menu-anchor (r/atom nil)
          profile-anchor (r/atom nil)]
      [box {:sx {:flex-grow 1}}
       [app-bar {:position :static}
        [toolbar {:class :primary}
         [icon-button {:size :large
                       :edge :start
                       :color :inherit
                       :aria-label "menu"
                       :sx {:mr 2}
                       :on-click (fn [e]
                                   (dispatch [::events/toggle-menu])
                                   (reset! menu-anchor e.target))}
          [menu-icon/menu]]
         (when @(subscribe [::subs/show-menu?])
           [menu {:id :nav-menu
                  :anchor-el @menu-anchor
                  :keep-mounted true
                  :anchor-origin {:vertical :top
                                  :horizontal :left}
                  :transform-origin {:vertical :top
                                     :horizontal :left}
                  :open @(subscribe [::subs/show-menu?])
                  :on-close #(reset! menu-anchor nil)}
            (for [[page title] pages]
              [menu-item
               {:on-click (fn [_]
                            (dispatch [::events/page page])
                            (dispatch [::events/toggle-menu])
                            (reset! menu-anchor nil))}
               title])])
         [typography {:variant "h6"
                      :component :div
                      :sx {:flex-grow 1}}
          "StrEats"]
         [icon-button {:color :inherit
                       :on-click (fn [e]
                                   (dispatch [::events/toggle-profile])
                                   (reset! profile-anchor e.target))}
          [account-circle]]
         (when @(subscribe [::subs/show-profile?])
           [menu {:id :nav-menu
                  :anchor-el @profile-anchor
                  :keep-mounted true
                  :anchor-origin {:vertical :top
                                  :horizontal :right}
                  :transform-origin {:vertical :top
                                     :horizontal :right}
                  :open @(subscribe [::subs/show-profile?])}

            (when-not @(subscribe [::subs/user])
              [menu-item
               {:on-click (fn [_]
                            (dispatch [::events/toggle-profile])
                            (dispatch [::events/page :index])
                            (dispatch [::events/login])
                            (reset! profile-anchor nil))}
               "Sign In"])
            (when-not @(subscribe [::subs/user])
              [menu-item
               {:on-click (fn [_]
                            (dispatch [::events/toggle-profile])
                            (reset! profile-anchor nil))}
               "Sign Up"])
            (when @(subscribe [::subs/user])
              [menu-item
               {:on-click (fn [_]
                            (dispatch [::events/toggle-profile])
                            (dispatch [::events/page :profile])
                            (reset! profile-anchor nil))}
               "Profile"])
            (when @(subscribe [::subs/user])
              [menu-item
               {:on-click (fn [_]
                            (dispatch [::events/toggle-profile])
                            (dispatch [::events/logout])
                            (dispatch [::events/page :index]))}
               "Log Out"])])]]])))


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
       "Menu"]
        [drawer
         {:anchor :bottom
          :on-click #(dispatch [::events/toggle-search])
          :open @show-search?}
         "Search"]
       [drawer
        {:anchor :right
         :on-click #(dispatch [::events/toggle-profile])
         :open @show-profile?}
        "Profile"]
       (condp = @page
         :index [index-page]
         :login [login-page]
         [:div (gstring/format "This is the %s page" (get pages @page "Blank"))])
       [navbot]])))