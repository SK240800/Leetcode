class Solution(object):
    def canPartition(self, nums):
        total = sum(nums)
        if total % 2 != 0:
            return False  # Can't divide an odd number evenly

        target = total // 2
        dp = [False] * (target + 1)
        dp[0] = True  # Sum 0 is always possible

        for num in nums:
            for i in range(target, num - 1, -1):  # Traverse backward to avoid overwriting
                dp[i] = dp[i] or dp[i - num]

        return dp[target]