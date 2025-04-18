class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        current_string = "1"
        for _ in range(n - 1):
            next_string = ""
            j = 0
            k = 0
            while j < len(current_string):
                while (
                    k < len(current_string)
                    and current_string[k] == current_string[j]
                ):
                    k += 1
                next_string += str(k - j) + current_string[j]
                j = k
            current_string = next_string
        return current_string