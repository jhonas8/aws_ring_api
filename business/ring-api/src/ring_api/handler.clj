(ns ring-api.handler
  (:require
   [compojure.core :refer [defroutes GET]]
   [compojure.route :as route]
   [compojure.handler :as handler]
   [ring.middleware.json :refer [wrap-json-body wrap-json-response]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (wrap-json-body)
      (wrap-json-response)))
