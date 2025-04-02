class Solution(object):
    def maximumTripletValue(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        r=0
        for k in range(2,n):
            m=nums[0]
            for j in range(1,k):
                r=max(r,(m - nums[j]) * nums[k])
                m=max(m,nums[j])
        return r