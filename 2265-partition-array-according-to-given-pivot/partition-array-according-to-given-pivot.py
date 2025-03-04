class Solution(object):
    def pivotArray(self, nums, pivot):
        """
        :type nums: List[int]
        :type pivot: int
        :rtype: List[int]
        """
        l=[]
        r=[]
        n=[]
        for i in nums:
            if i==pivot:
                n.append(pivot)
            elif i < pivot:
                l.append(i)
            else:
                r.append(i)
        return l + n +r


        