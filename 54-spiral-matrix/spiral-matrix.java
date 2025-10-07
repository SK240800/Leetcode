class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int up =0;
        int left = 0;
        int right = c-1;
        int down = r -1;

        while(result.size()<r*c){
            for(int col =left; col<=right;col++){
                result.add(matrix[up][col]);
            }
            for(int row= up+1;row<=down;row++){
                result.add(matrix[row][right]);
            }
            if (up != down) {
                for (int col = right - 1; col >= left; col--) {
                result.add(matrix[down][col]);
                }
            }
            if(left!=right){
                for(int row =down-1;row>up;row--){
                result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return result;
        
    }
}