class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        ml = left =0
        count={}

        for right , c in enumerate(s):
            count[c] = 1+count.get(c,0)
            while count[c] >1:
                count[s[left]]-=1
                left+=1
            ml = max(ml,right-left+1)
        return ml
        