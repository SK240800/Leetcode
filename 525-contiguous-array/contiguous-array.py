class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dic ={}
        dic[0]=-1
        ans=0
        count =0

        for i in range(len(nums)):
            if nums[i]==1:
                count+=1
            else:
                count-=1
            if count in dic:
                ans=max(ans,i-dic[count])
            else:
                dic[count]=i
        return ans


        