class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l= len(nums)
        L,R,A=[0]*l,[0]*l,[0]*l

        L[0]=1
        for i in range(1,l):
            L[i]=nums[i-1]*L[i-1]

        R[-1]=1
        for i in range(-2,-l-1,-1):
            R[i]=nums[i+1]*R[i+1]

        for i in range(l):
            A[i] = L[i] * R[i]

        return A
        