(ns ring-api.dynamo
  (:require [env.core :refer [env]]
            [taoensso.faraday :as far]))

(def dynamo-config {:access-key (or (env :access-key) "")
                    :secret-key (or (env :secret-key) "")})

(defn print-tables []
  (let [tables (far/list-tables dynamo-config)]
    (println tables)))
