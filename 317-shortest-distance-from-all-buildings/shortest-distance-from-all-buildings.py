class Solution:
    def shortestDistance(self, grid: List[List[int]]) -> int:
        
        # iterate over matrix and store each building coordinates in a array and get the total building count
        # bfs from each building
        # search all 0s
        # --> update their value with [buildings visited, total travel distance (the path len from initial point)]
        # find the cell all buildings visited with the shortest travel distance
        # return shortest travel distance

        ROWS = len(grid)
        COLS = len(grid[0])

        totalBuildings = 0
        buildings = []

        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == 1:
                    buildings.append((i,j))
                    totalBuildings += 1
                if grid[i][j] == 0:
                    grid[i][j] = [0,0]          # turn 0 cells into [0,0]
        
        def bfs(point):
            initialRow, initialCol = point
            q = deque()
            q.append((initialRow,initialCol,0))
            visited = set()
            visited.add((initialRow,initialCol))
            dirs = [[-1,0],[1,0],[0,1],[0,-1]]
            while q:
                row, col, pathLen = q.popleft()
                for dr, dc in dirs:
                    newRow, newCol = row+dr, col+dc
                    if 0<=newRow<ROWS and 0<=newCol<COLS and (newRow,newCol) not in visited and grid[newRow][newCol] != 1 and grid[newRow][newCol] != 2:
                        grid[newRow][newCol][0] += 1                # Increment buildings that can get to this point
                        grid[newRow][newCol][1] += (pathLen + 1)    # Increment travelDistance of this point
                        q.append((newRow,newCol,pathLen + 1))
                        visited.add((newRow,newCol))
        
        for building in buildings:
            bfs(building)
        
        print(grid)

        shortestTravelDistance = float('inf')
        updated = False
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] != 1 and grid[i][j] != 2 and grid[i][j][0] == totalBuildings:
                    shortestTravelDistance = min(shortestTravelDistance,grid[i][j][1])
                    updated = True
        if updated:
            return shortestTravelDistance
        else:
            return -1
        