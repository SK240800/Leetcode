class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n=len(triangle[-1])
        for r in range(n-2,-1,-1):
            for c in range(r+1):
                triangle[r][c]+= min(triangle[r+1][c],triangle[r+1][c+1])
        return triangle[0][0]
        