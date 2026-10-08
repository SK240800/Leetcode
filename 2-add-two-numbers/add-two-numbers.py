# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        d=ListNode()
        res= d

        t= c=0

        while l1 or l2 or c:
            t=c

            if l1:
                t+=l1.val
                l1=l1.next
            if l2:
                t+=l2.val
                l2=l2.next
            num= t%10
            c=t//10
            d.next=ListNode(num)
            d=d.next
        return res.next

        