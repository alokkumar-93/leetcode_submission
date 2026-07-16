class Solution {
    public long gcdSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
            nums[i]=gcd(nums[i],max);
        }
        Arrays.sort(nums);
        long sum=0;
        int left=0;
        int right=nums.length-1;
        while(left<right){
            sum+=gcd(nums[left],nums[right]);
            left++;
            right--;
        }
        return sum;
    }
    public int gcd(int a ,int b){
        while(b!=0){
            int temp = b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}