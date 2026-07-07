class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int S_row=0;
        int S_col=0;
        while(S_row<=row && S_col<=col){
            for(int i = S_col;i<=col;i++){
                ans.add(matrix[S_row][i]);
            }
            S_row++;
            for(int i = S_row;i<=row;i++){
                ans.add(matrix[i][col]);
            }
            col--;
            if(S_row<=row){
                for(int i = col;i>=S_col;i--){
                    ans.add(matrix[row][i]);
                }
                row--;
            }
            if(S_col<=col){
                for(int i=row;i>=S_row;i--){
                    ans.add(matrix[i][S_col]);
                }
                S_col++;
            }
        }
        return ans;
    }
}