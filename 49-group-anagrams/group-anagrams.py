class Solution(object):
    def groupAnagrams(self, words):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        anagrams ={}

        for eachWord in words:
            sorted_word = ''.join(sorted(eachWord))
            if sorted_word in anagrams:
                anagrams[sorted_word].append(eachWord)
            else:
                anagrams[sorted_word] = [eachWord]

        return list(anagrams.values())
        