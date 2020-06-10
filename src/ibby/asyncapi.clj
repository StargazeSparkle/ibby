(ns ibby.asyncapi
  (:require [ibby.http :as http]
            [ibby.config :refer [config]]
            [com.wsscode.async.async-clj :refer :all]))

(defn edit
  [query-map pass fail]
  (go-promise
    (<! (http/async-post query-map config pass fail))))

(defn replace-content
  [page-name options pass fail]
  (def query-map {:action "edit"
                  :title  page-name
                  :text   (:content options)
                  :token  (:token options)
                  :format "json"})
  (edit query-map pass fail))