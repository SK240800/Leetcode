class Solution(object):
    def mostPoints(self, questions):
        n = len(questions)
        dp = [0] * n
        dp[-1] = questions[-1][0]
        
        for i in range(n - 2, -1, -1):
            dp[i] = questions[i][0]
            sk = questions[i][1]
            if i + sk + 1 < n:
                dp[i] += dp[i + sk + 1]

            dp[i] = max(dp[i], dp[i + 1])
        
        return dp[0]
        
        