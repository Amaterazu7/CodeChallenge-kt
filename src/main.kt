import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap
import kotlin.collections.Map
import kotlin.collections.set

/*
  Given a list of strings, list the most common letters in desc order:
      Example ::>> ["apple", "chicken", "cow", "cockroach", "ant", "beaver"] -> {c, a, b}
 */
class Solution {
    var letterMap = HashMap<String, Int>()

    fun findMostCommonStartLetters(input: ArrayList<String>) {
        for (`in` in input) {
            val lett = `in`.substring(0, 1)
            if (letterMap.containsKey(lett)) {
                letterMap[lett] = letterMap[lett]!! + 1
            } else {
                letterMap[lett] = 1
            }
        }

        val sortedMap = LinkedHashMap<String, Int>()

        letterMap.entries
            .stream()
            .sorted(java.util.Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEachOrdered { x: Map.Entry<String, Int> ->
                sortedMap[x.key] = x.value
            }
        println("StringMap  : $sortedMap")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val characterList = ArrayList<String>()
            characterList.add("apple")
            characterList.add("chicken")
            characterList.add("cow")
            characterList.add("cockroach")
            characterList.add("ant")
            characterList.add("beaver")

            Solution().findMostCommonStartLetters(characterList)
        }
    }
}