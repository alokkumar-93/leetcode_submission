class Solution {
    int par[];
    int rank[];
    public int find(int x){
        if(par[x]==x)return x;
        return par[x]=find(par[x]);
    }
    public void union(int a ,int b){
        int para=find(a);
        int parb=find(b);
        if(rank[para]==rank[parb]){
            par[a]=b;
            rank[b]++;
        }
        else if(rank[para]>rank[parb]){
            par[b]=a;
            rank[a]++;
        }
        else{
            par[a]=b;
            rank[b]++;
        }
        return;
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        par=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<n;i++){
            rank[i]=1;
            par[i]=i;
        }
        for(int i=1 ;i<nums.length;i++){
            if(Math.abs(nums[i]-nums[i-1])<=maxDiff){
                union(i,i-1);
            }
        }
        boolean result[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int par_Src=find(queries[i][0]);
            int par_des=find(queries[i][1]);
            if(par_Src==par_des)result[i]=true;
            else result[i]=false;
        }
        return result;
    }
}