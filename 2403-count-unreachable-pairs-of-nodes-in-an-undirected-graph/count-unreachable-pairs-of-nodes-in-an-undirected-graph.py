class Solution(object):
    def countPairs(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """
        adj_list = {i: [] for i in range(n)}
        for u, v in edges:
            adj_list[u].append(v)
            adj_list[v].append(u)
    
        # Step 2: Perform DFS to find all connected components
        def dfs(node, component):
            visited.add(node)
            component.append(node)
            for neighbor in adj_list[node]:
                if neighbor not in visited:
                    dfs(neighbor, component)
    
        visited = set()
        components = []
    
        # Collect all connected components
        for i in range(n):
            if i not in visited:
                component = []
                dfs(i, component)
                components.append(len(component))  # Store size of the component
    
        # Step 3: Calculate the total number of possible pairs (n choose 2)
        total_pairs = n * (n - 1) // 2
    
        # Step 4: Calculate the number of reachable pairs within each component
        reachable_pairs = 0
        for size in components:
            reachable_pairs += size * (size - 1) // 2
    
        # Step 5: The number of unreachable pairs is total pairs minus reachable pairs
        return total_pairs - reachable_pairs

        

        