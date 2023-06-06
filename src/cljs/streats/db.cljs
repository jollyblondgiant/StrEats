(ns streats.db)

(defonce appdb {})

(defonce pages
  {:home "Home"
   :search "Search"
   :profile "Profile"
   :review "Review"
   :trucks "Trucks"
   :truck "Truck"
   :truck-menu "Menu"
   :food-item "Dish"})

(defonce apollo {:username "apollo"
                 :id -1
                 :email "apollo@streats.com"
                 :avatar "img/apollo.jpg"})