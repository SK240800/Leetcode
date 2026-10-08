class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map={}
        for i in range(len(nums)):
            x=target - nums[i]
            if x in map:
                return [i,map[x]]
            map[nums[i]]=i
        return []
            

        