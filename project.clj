(defproject streats "0.1.0"
  :description "An App to connect Food Trucks and the people who love them"
  :url "https://apogeni.us"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :dependencies [[org.clojure/clojure "1.10.3"]
                 [aero "1.1.6"]

                 ;;server deps
                 [metosin/reitit "0.7.0-alpha4"]
                 [ring/ring-core "1.10.0"]
                 [metosin/ring-http-response "0.9.3"]
                 [ring/ring-jetty-adapter "1.10.0"]
                 [cheshire "5.11.0"]

                 ;;client deps
                 [reagent "1.2.0"]
                 [cljs-http "0.1.46"]
                 [re-frame "1.3.0"]
                 
                 [arttuka/reagent-material-ui "5.11.12-0"]
                 ]
  
  :main ^:skip-aot streats.core
  :source-paths ["src/clj" "src/cljs"]
  :resource-paths ["resources" "target"]
  :css-dirs ["resources/public"]
  :aliases {"fig" ["trampoline" "run" "-m" "figwheel.main"]
            "figwheel" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]}
  :profiles {:dev {:dependencies  [[org.clojure/clojurescript "1.11.60"]
                                   [thheller/shadow-cljs "2.23.3"]
                                   [org.clojure/google-closure-library "0.0-20230227-c7c0a541"]
                                   [com.google.javascript/closure-compiler-unshaded "v20230411"]
                                   [org.clojure/core.async "1.5.648"]]
                   :resource-paths ["target"]
                   :clean-targets ^{:protect false} ["target"]}
             :uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
