(ns ring-api.dynamo
  (:require [environ.core :refer [env]]
            [taoensso.faraday :as far]))

(def dynamo-config {:access-key (or (env :access-key) "")
                    :secret-key (or (env :secret-key) "")})

(defn get-environment []
  (or (env :environment) ""))

(defn merge-config-for-environment [environment dynamo-config]
  (cond
    (= environment "dev") (merge dynamo-config {:endpoint "http://localhost:8000"})
    :else dynamo-config))

(defn print-tables []
  (let [tables (far/list-tables (-> dynamo-config
                                    (merge-config-for-environment (get-environment))))]
    (println tables)))
