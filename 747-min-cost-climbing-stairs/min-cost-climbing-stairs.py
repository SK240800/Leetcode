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
        minimum_cost = [0] * (len(cost) + 1)
        for i in range(2, len(cost) + 1):
            take_one_step = minimum_cost[i - 1] + cost[i - 1]
            take_two_steps = minimum_cost[i - 2] + cost[i - 2]
            minimum_cost[i] = min(take_one_step, take_two_steps)
        return minimum_cost[-1]
        