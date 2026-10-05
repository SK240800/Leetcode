class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        minP = [float("inf")] * (k+1)
        maxP = [0] *(k+1)

        for p in prices:
            for i in range(1,k+1):
                minP[i] = min(minP[i], p-maxP[i-1])
                maxP[i]=max(maxP[i],p-minP[i])
        return maxP[k]


        