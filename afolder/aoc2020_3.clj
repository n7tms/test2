(ns aoc2020-3.core
  (:gen-class)
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

;; Sample terrain
; ..##.......
; #...#...#..
; .#....#..#.
; ..#.#...#.#
; .#...##..#.
; ..#.##.....
; .#.#.#....#
; .#........#
; #.##...#...
; #...##....#
; .#..#...#.#


(defn read-lines [filename]
  (with-open [rdr (io/reader filename)]
    (->> rdr
         line-seq
         vec)))

;(def terrain (read-lines "03-test.txt")) ;; for testing
(def terrain (read-lines "03.txt"))



(defn navigate [terrain steps-right]
(let [width (count (nth terrain 0))
      columns (iterate #(mod (+ steps-right %1) width) 0)
      pos (map nth terrain columns)
      trees (filter #(= \# %1) pos)]
     (count trees))

  )


(defn part1 []
(let [width (count (nth terrain 0))
      columns (iterate #(mod (+ 3 %1) width) 0)
      spots (map nth terrain columns)
      trees (filter #(= \# %1) spots)]
     (count trees))
  )



(defn part2 [] 
  (*
   (navigate terrain 1)
   (navigate terrain 3)
   (navigate terrain 5)
   (navigate terrain 7)
   (navigate (take-nth 2 terrain) 1)
  )
)



(defn -main
  "Advent of Code: Day 3"
  [& args]

  (case (first args)
    1 (part1)
    2 (part2)
   (println "Missing argument!\nEnter either 1 or 2 to specify a part to run.
Usage: (-main #) where # is the part you want to execute.")
  )

)

;; Thanks to Fred Overflow for assistance.



