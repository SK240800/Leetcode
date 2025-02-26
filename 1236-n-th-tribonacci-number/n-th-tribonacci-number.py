class Solution(object):

    def tribonacci(self,n):
        dp=[-1]*(n+1)
        dp[0]=0
        if n>0:
            dp[1]=1
        if n>1:
            dp[2]=1
        def h(n,dp):
            if dp[n]!=-1:
                return dp[n]
            else:
                for i in range(3,n+1):
                    dp[i]=dp[i-3]+dp[i-2]+dp[i-1]
            return dp[n] 
        return h(n,dp)