class Solution(object):
    def applyOperations(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        c=0
        l=[]
        for i in range(len(nums)-1):
            if nums[i]==nums[i+1]:
                nums[i]=2*nums[i]
                nums[i+1]=0
        for i in range(len(nums)):
            if nums[i]!=0:
                l.append(nums[i])
            else:
                c+=1
        l=l+([0]*c)
        return l
        

            





