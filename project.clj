(defproject streats "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]

                 ;;server deps
                 [metosin/reitit "0.7.0-alpha4"]
                 [ring/ring-core "1.10.0"]
                 [ring/ring-jetty-adapter "1.10.0"]

                 ;;client deps
                 [reagent "1.2.0"]
                 [re-frame "1.3.0"]
                 [cljsjs/react "17.0.2-0"]
                 [cljsjs/react-dom "17.0.2-0"]
                 [arttuka/reagent-material-ui "5.11.12-0"]]
  :main ^:skip-aot streats.core
  :source-paths ["src/clj" "src/cljs"]
  :resource-paths ["resources"]
  :css-dirs ["resources/public"]
  :aliases {"fig" ["trampoline" "run" "-m" "figwheel.main"]
            "figwheel" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]}
  :profiles {:dev {:dependencies  [[org.clojure/clojurescript "1.11.60"]
                                   [com.bhauman/figwheel-main "0.2.18"]
                                   [com.bhauman/rebel-readline-cljs "0.1.4"]]
                   :resource-paths ["target"]
                   :clean-targets ^{:protect false} ["target"]}
             :uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
