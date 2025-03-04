class Solution(object):
    def mergeArrays(self, nums1, nums2):
        """
        :type nums1: List[List[int]]
        :type nums2: List[List[int]]
        :rtype: List[List[int]]
        """
        h={}
        for i,j in nums1:
                h[i]=j
        for i,j in nums2:
            if i in h:
                h[i]=j+h[i]
            else:
                h[i]=j
        return sorted(h.items(), key=lambda item: item[0])

                        