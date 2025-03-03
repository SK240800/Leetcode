class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n=len(matrix)

        for i in range(n-2,-1,-1):
            for j in range(n):
                mb=float("inf")
                for x in range(n):
                    if x!=j:
                        mb=min(mb,matrix[i+1][x])
                matrix[i][j]+=mb
        return min(matrix[0])
        