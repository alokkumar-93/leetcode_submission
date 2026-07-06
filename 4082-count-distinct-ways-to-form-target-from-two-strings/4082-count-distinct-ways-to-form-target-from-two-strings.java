class Solution {
    public static int dp[][][][];
    int Mod = 1000000007;
    public int helper(int pos,int idx1,int idx2,int mask,String str1,String str2,String target){
        if(pos==target.length()){
            if(mask==3)return 1;
            else return 0;
        }
        if (idx1 > str1.length() || idx2 > str2.length())return 0;
        if(dp[pos][idx1][idx2][mask]!=-1){
            return dp[pos][idx1][idx2][mask];
        }
        int ans =0;
        for(int i = idx1;i<str1.length();i++){
            if(str1.charAt(i)==target.charAt(pos)){
                ans=(ans+helper(pos+1,i+1,idx2,mask|1,str1,str2,target))%Mod;
            }
        }
        for(int j = idx2;j<str2.length();j++){
            if(str2.charAt(j)==target.charAt(pos)){
                ans=(ans+helper(pos+1,idx1,j+1,mask|2,str1,str2,target))%Mod;
            }
        }
        dp[pos][idx1][idx2][mask]=ans;
        return ans;
    }
    public int interleaveCharacters(String word1, String word2, String target) {
        dp=new int[target.length()+1][word1.length()+1][word2.length()+1][4];
        for (int[][][] a : dp)for (int[][] b : a)for (int[] c : b)Arrays.fill(c, -1);
        return helper(0,0,0,0,word1,word2,target);
    }
}