class Solution(object):
    def maximumTripletValue(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # n=len(nums)
        # dp=[0]*n
        # r=0
        # for j in range(1,n-1):
        #     dp[j-1]=max(nums[:j])
        #     dp[j+1]=max(nums[j+1:n])
        #     r=max(r,(dp[j-1]-nums[j])*dp[j+1])
        # return r

        n= len(nums)
        pm=[0]*n
        sm=[0]*n
        r=0
        for i in range(1,n):
            pm[i]=max(pm[i-1],nums[i-1])
            sm[n-1-i]=max(sm[n-i],nums[n-i])
        for j in range(1,n-1):
            r=max(r,(pm[j]-nums[j])*sm[j])
        return r

        