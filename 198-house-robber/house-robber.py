class Solution(object):
    def __init__(self):
        self.memo = {}
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.memo={}
        return self.r(0,nums)
    def r(self,i,nums):
        if i >=len(nums):
            return 0
        
        if i in self.memo:
            return self.memo[i] 

        ans= max(self.r(i+1,nums),self.r(i+2,nums)+nums[i])
        self.memo[i]=ans
        return ans