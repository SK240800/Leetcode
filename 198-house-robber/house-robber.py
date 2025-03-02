class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n= len(nums)
        if n==0:
            return 0
        if n==1:
            return nums[0]
        dp=[0 for _ in range(n+1)]

        dp[1]=nums[0]
        dp[2]=max(nums[0],nums[1])

        for i in range(3,n+1):
            dp[i]=max(dp[i-1],dp[i-2]+nums[i-1])
        return max(dp[n],dp[n-1])