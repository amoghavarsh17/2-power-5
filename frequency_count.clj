;;cerner_2^5_2020
(ns frequency_count)
(use '[clojure.string :refer [split triml]])

(defn split-on-space [s]
  "a function to split the file contnent into a vector of strings"
  (split (triml s) #"\s+"))

(defn frequencies-by
  "a function to fetch the frequencies of each word in the collection"
  [coll]
  (let [gp (group-by identity coll)]
    (zipmap (keys gp)  (map #(count (second %)) gp))))

(defn example-fn []
  (def file-contents (slurp "/<USER-PATH>/2-power-5/frequency_count.clj")) ;;Replace <USER-PATH> with the relative/exact path to this namespace
  (println "Number of Characters in this file: " (count file-contents))
  (println "Number of Words in this file: " (count (split-on-space file-contents)))
  (println "Frequencies of each words in this file: " (frequencies-by (split-on-space file-contents))))

(example-fn)
