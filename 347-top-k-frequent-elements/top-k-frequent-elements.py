class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        h={}
        ans=[]
        for i in nums:
            h[i]=1+h.get(i,0)
        
        si=sorted(h.items(),key=lambda x:x[1], reverse=True)

        for i in range(k):
            ans.append(si[i][0])
        
        return ans
   



            


        