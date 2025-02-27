class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        # prev = [1]
        # for i in range(1, rowIndex + 1):
        #     curr = [1] * (i + 1)
        #     for j in range(1, i):
        #         curr[j] = prev[j - 1] + prev[j]
        #     prev = curr
        # return prev
        row = [1] * (rowIndex + 1)
        for i in range(2, rowIndex + 1):
            for j in range(i - 1, 0, -1):
                row[j] += row[j - 1]
        
        return row
        