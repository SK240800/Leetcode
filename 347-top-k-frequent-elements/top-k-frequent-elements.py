class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        # h={}
        # for i in nums:
        #     if i in h:
        #         h[i]+=1
        #     else:
        #         h[i]=1
        # h=dict(sorted(h.items(),key=lambda x:x[1], reverse=True))
        # r=list(h.keys())[:k]
        # return r
        from collections import Counter
        # O(1) time 
        if k == len(nums):
            return nums
        
        # 1. Build hash map: character and how often it appears
        # O(N) time
        count = Counter(nums)   
        # 2-3. Build heap of top k frequent elements and
        # convert it into an output array
        # O(N log k) time
        return heapq.nlargest(k, count.keys(), key=count.get) 


            


        