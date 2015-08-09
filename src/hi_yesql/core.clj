(ns hi-yesql.core
  (:require [yesql.core :as yes]))

(def db-spec {:classname "com.mysql.jdbc.Driver"
              :subprotocol "mysql"
              :subname "//localhost:3306/test"
              :user "root"
              :password ""})

(yes/defquery select-foo "sql/select.sql")

(defn -main
  "Javaで言う public static void main(String[] args)"
  [& args]
  (println "-- start.")
  (let [result (select-foo {:param1 "foo" :param2 123} {:connection db-spec})]
    (println (first result)))
  (println "-- finish.")
  )
