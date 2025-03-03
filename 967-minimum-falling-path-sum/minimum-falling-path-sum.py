class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
    #     m, n = len(A), len(A[0])

    #     if m == 1 or n == 1:
    #         return A[0][0]

    #     dp = [[float('inf')] * n for _ in range(m)]
    #     ans = float('inf')

    #     for i in range(len(A)):
    #         ans = min(ans, self.minFallingPathSumHelper(A, 0, i, dp))

    #     return ans

    # def minFallingPathSumHelper(self, A, row, col, dp):
    #     m, n = len(A), len(A[0])

    #     if dp[row][col] != float('inf'):
    #         return dp[row][col]

    #     if row == m - 1:
    #         return A[row][col]

    #     left = right = float('inf')

    #     if col > 0:
    #         left = self.minFallingPathSumHelper(A, row + 1, col - 1, dp)

    #     straight = self.minFallingPathSumHelper(A, row + 1, col, dp)

    #     if col < n - 1:
    #         right = self.minFallingPathSumHelper(A, row + 1, col + 1, dp)

    #     dp[row][col] = min(left, min(straight, right)) + A[row][col]

    #     return dp[row][col]

        n = len(matrix)
        
        # Start from the second to last row and move upwards
        for row in range(n - 2, -1, -1):
            for col in range(n):
                # Initialize the minimum value for the current cell
                min_below = matrix[row + 1][col]
                
                # Check diagonal left
                if col > 0:
                    min_below = min(min_below, matrix[row + 1][col - 1])
                
                # Check diagonal right
                if col < n - 1:
                    min_below = min(min_below, matrix[row + 1][col + 1])
                
                # Update the current cell with the minimum path sum
                matrix[row][col] += min_below
        
        # The top row now contains the minimum falling path sum
        return min(matrix[0])



            