class Solution {
    public int removeCoveredIntervals(int[][] nums) {
        int ans = nums.length;
        for(int i=0;i<nums.length;i++){
            boolean covered = false;
            for(int j=0;j<nums.length;j++){
                if(i==j)continue;
                int a = nums[i][0];
                int b = nums[i][1];
                int c = nums[j][0];
                int d = nums[j][1];
                if(c<=a&&b<=d&&(c < a || b < d)){
                    covered=true;
                    break;
                }
            }
            if(covered)ans--;
        }
        return ans;
    }
}