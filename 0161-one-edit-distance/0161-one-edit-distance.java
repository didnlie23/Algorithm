class Solution {

       public boolean isOneEditDistance(String s, String t) {
        int beforeLength = s.length();
        int afterLength = t.length();
        if (Math.abs(beforeLength - afterLength) > 1) return false;
        boolean oneDistance = false;
        int beforeIndex = 0;
        if (beforeLength == afterLength) {
            while (beforeIndex < beforeLength) {
                if (s.charAt(beforeIndex) != t.charAt(beforeIndex)) {
                    if (!oneDistance) oneDistance = true;
                    else return false;
                }
                beforeIndex++;
            }
            return oneDistance;
        } else if (beforeLength > afterLength) { // delete
            int afterIndex = 0;
            while (afterIndex < afterLength) {
                if (s.charAt(beforeIndex) != t.charAt(afterIndex)) {
                    if (!oneDistance) {
                        afterIndex--;
                        oneDistance = true;
                    } else return false;
                }
                beforeIndex++;
                afterIndex++;
            }
        } else { // after
            int afterIndex = 0;
            while (beforeIndex < beforeLength) {
                if (s.charAt(beforeIndex) != t.charAt(afterIndex)) {
                    if (!oneDistance) {
                        beforeIndex--;
                        oneDistance = true;
                    }
                    else return false;
                } beforeIndex++;
                afterIndex++;
            }
        } return true;
    }
}
