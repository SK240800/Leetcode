class Solution(object):
    def minimumOperations(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def u(i):
            s=set()
            for num in nums[i:]:
                if num in s:
                    return False
                s.add(num)
            return True
        c=0
        for i in range(0,len(nums),3):
            if u(i):
                return c
            c+=1
        return c

        