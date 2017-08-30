(ns conan.reporter.console-reporter
  (:require [conan.reporter.prediction-reporter :as r]))

(defrecord ConsoleReporter []
  r/PredictionReporter
  (report [self profile->prediction]
    (let [print-prediction (fn [[profile prediction]] (prn (format "%s -> anomaly detected: %s" (name profile) prediction)))]
      (dorun (map print-prediction profile->prediction)))))