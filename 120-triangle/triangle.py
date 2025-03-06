class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n=len(triangle[-1])
        for r in range(n-2,-1,-1):
            for c in range(r+1):
                mb=triangle[r+1][c]
                mb= min(mb,triangle[r+1][c+1])
                triangle[r][c]+=mb
        return triangle[0][0]
        