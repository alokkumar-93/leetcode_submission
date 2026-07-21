class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        s="1"+s+"1";
        int totalone=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                totalone++;
            }
        }
        ArrayList<Integer> len = new ArrayList<>();
        ArrayList<Character> type = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int cnt=0;
            char ch = s.charAt(i);
            while(i<s.length()&&s.charAt(i)==ch){
                cnt++;
                i++;
            }
            type.add(ch);
            len.add(cnt);
        }
        int ans=totalone;
        for (int j = 1; j < type.size() - 1; j++) {
            if (type.get(j) == '1'&& type.get(j - 1) == '0'&& type.get(j + 1) == '0') {
                ans = Math.max(ans,totalone + len.get(j - 1) + len.get(j + 1));
            }
        }
        return ans-2;
    }
}