(ns streats.environ
  (:require [aero.core :refer [read-config]]))

(def env
  (read-config "config.edn"))