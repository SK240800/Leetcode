class Solution(object):
    def maximumTripletValue(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        r=0
        for i in range(n):
            for j in range(i+1,n):
                for k in range(j+1,n):
                    r=max(r,(nums[i] - nums[j]) * nums[k])
        return r