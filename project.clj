(defproject drone-remote-cljs "0.1.0-SNAPSHOT"
  :description "A ClojureScript control dashboard for the AR Drone 2.0"
  :url "https://github.com/GeorgiCodes/drone-remote-cljs"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj" "src/cljs"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2069"]
                 [clj-drone "0.1.9"]
                 [cljs-ajax "0.2.6"]
                 [domina "1.0.2"]
                 [ring/ring-json "0.3.1"]
                 [cheshire "5.3.1"]]

  :ring {:handler drone-remote-cljs.core/handler}

   ;; cljsbuild options configuration
  :cljsbuild {:builds
              [{;; CLJS source code path
                :source-paths ["src/cljs"]

                ;; Google Closure (CLS) options configuration
                :compiler {;; CLS generated JS script filename
                           :output-to "resources/public/js/main.js"

                           ;; minimal JS optimization directive
                           :optimizations :whitespace

                           ;; generated JS code prettyfication
                           :pretty-print true}}]})
