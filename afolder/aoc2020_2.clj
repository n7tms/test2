;; Advent of Code 2020
;; Day 2

; Again, many thanks to Fred Overflow for the "tutorial"
;; I made a change here to play with magit.
;; another change just for good measure


(ns aoc2020-2.core
  (:gen-class)
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

;(def filename "pwds-test.txt")
(def filename "pwds.txt")


(def sample "15-16 p: ppppppppppplppppp")

(defn parse-line
  [line]
    (let [[_ min max ch password]
        (re-matches #"(\d+)-(\d+) (\w): (\w+)" line)]
    {:min  (Integer/parseInt min)
     :max (Integer/parseInt max)
     :ch (nth ch 0)
     :pwd password})
)

(defn read-database [filename]
  (with-open [rdr (io/reader filename)]
    (->> rdr
         line-seq
         (mapv parse-line))) 
)

(defn valid-password? [{:keys [min max ch pwd]}]
  (let [times (->> pwd
                   (filter #(= ch %))
                   count)]
    (<= min times max))
)

(defn p2-valid-password? [{:keys [min max ch pwd]}]
  (not=
       (= ch (nth pwd (dec min)))
       (= ch (nth pwd (dec max)))
  )
)


(defn part1 []
  (->> filename
       read-database
       (filter valid-password?)
       count)
)

(defn part2 []
  (->> filename
       read-database
       (filter p2-valid-password?)
       count)
)

(defn -main
  "Advent of Code: Day 2   https://adventofcode.com/2020/day/2"
  [& args]

  (case (first args)
    1 (part1)
    2 (part2)
   (println "Missing argument!\nEnter either 1 or 2 to specify a part to run.
Usage: (-main #) where # is the part you want to execute.")
  )
)

;; Thanks to https://www.youtube.com/watch?v=m8lX3B6R8qY for the help.
