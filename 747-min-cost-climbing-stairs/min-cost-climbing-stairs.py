class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        # if len(cost) == 0:
        #     return 0
        # if len(cost) == 1:
        #     return cost[0]
        # if len(cost) == 2:
        #     return min(cost[0], cost[1])
        
        # return min(cost[0] + self.minCostClimbingStairs(cost[2:]), cost[1] + self.minCostClimbingStairs(cost[3:]))
        n=len(cost)
        if n<=0:
            return 0
        if n==2:
            return min(cost[1],cost[0])

        dp=[0 for _ in range(n+1)]
        dp[1]=cost[0]
        dp[2]=cost[1]

        for i in range(3,n+1):
            dp[i]=cost[i-1]+min(dp[i-1],dp[i-2])
            
        return min(dp[n-1],dp[n]) 