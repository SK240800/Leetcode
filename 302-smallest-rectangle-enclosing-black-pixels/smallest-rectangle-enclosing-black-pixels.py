class Solution(object):
    def find_first(self, image, start, end, check_func):
        while start + 1 < end:
            mid = (start + end) // 2
            if check_func(image, mid):
                end = mid
            else:
                start = mid
        # check last two items
        if check_func(image, start):
            return start
        return end
    
    def find_last(self, image, start, end, check_func):
        while start + 1 < end:
            mid = (start + end) // 2
            if check_func(image, mid):
                start = mid
            else:
                end = mid
        if check_func(image, end):
            return end
        return start
    
    def check_row(self, image, row):
        for i in range(len(image[0])):
            if image[row][i] == '1':
                return True
        return False
    
    def check_col(self, image, col):
        for i in range(len(image)):
            if image[i][col] == '1':
                return True
        return False
    
    def minArea(self, image, x, y):
        
        row, col = len(image), len(image[0])
        left = self.find_first(image, 0, y, self.check_col)
        right = self.find_last(image, y, col - 1, self.check_col)
        top = self.find_first(image, 0, x, self.check_row)
        bottom = self.find_last(image, x, row - 1, self.check_row)
        
        return (bottom - top + 1) * (right - left + 1)