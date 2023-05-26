(defproject ring-api "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [compojure "1.7.0"]
                 [ring/ring-core "1.10.0"]
                 [ring/ring-json "0.5.1"]
                 [clojure.jdbc/clojure.jdbc-c3p0 "0.3.4"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [cheshire "5.11.0"]
                 [environ "1.2.0"]
                 [com.taoensso/faraday "1.12.0" :exclusions [org.clojure/tools.reader]]]
  :plugins [[lein-ring "0.12.6"]]
  :ring {:handler ring-api.handler/app}
  :profiles
  {:dev {:dependencies [[ring/ring-mock "0.4.0"]]}})
