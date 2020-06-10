(defproject ibby "0.1.0-SNAPSHOT"
  :description "ibby (lowercase) is a project aimed at creating a MediaWiki client in Clojure that targets the Fandom installations."
  :url "https://github.com/StargazeSparkle/ibby"
  :license {:name "GPL-3.0"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "1.0.0"]
                 [clj-http "3.10.1"]]
  :main ^:skip-aot ibby.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
