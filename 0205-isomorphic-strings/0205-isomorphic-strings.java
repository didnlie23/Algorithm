class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] frontToBack = new int[256];
        Arrays.fill(frontToBack, -1);
        int[] backToFront = new int[256];
        Arrays.fill(backToFront, -1);
        int length = s.length();
        for(int i=0;i<length;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (frontToBack[c1] == -1 && backToFront[c2] == -1){
                frontToBack[c1] = c2;
                backToFront[c2] = c1;
            }else if (!(frontToBack[c1] == c2 && backToFront[c2] == c1)){
                return false;
            }
        }
        return true;
    }
}