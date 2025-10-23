class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // visited matrix to mark all 'O's connected to the boundary
        boolean[][] vis = new boolean[m][n];

        // 1. DFS from first/last columns
        for(int i =0;i<m;i++){
            if(board[i][0] == 'O' && vis[i][0] == false){
                dfs(i,0,board,vis);
            }
            if(board[i][n-1] == 'O' && vis[i][n-1] == false){
                dfs(i,n-1,board,vis);
            }
        }
        // 2. DFS from first/last rows
        for(int j = 0;j<n;j++){
            if(board[0][j] == 'O' && vis[0][j] == false){
                dfs(0,j,board,vis);
            }
            if(board[m-1][j] == 'O' && vis[m-1][j] == false){
                dfs(m-1,j,board,vis);
            }
        }

        // 3. Flip surrounded 'O's
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                // Flip 'O' if it's not marked as visited (i.e., not connected to border)
                if(board[i][j] == 'O' && vis[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(int i, int j, char[][] board, boolean[][] vis){
        int m = board.length;
        int n = board[0].length;

        // Base case: out of bounds, already visited, or 'X'
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j] == true || board[i][j] == 'X'){
            return;
        }
        
        vis[i][j] = true;

        // DFS in all 4 directions
        dfs(i+1,j,board,vis);
        dfs(i,j+1,board,vis);
        dfs(i-1,j,board,vis);
        dfs(i,j-1,board,vis);
    }
}