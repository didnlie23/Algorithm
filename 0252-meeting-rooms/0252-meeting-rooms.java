class Solution {

    public boolean canAttendMeetings(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) return true;
        Arrays.sort(
            intervals,
            new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            }
        );
        int end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] < end) return false;
            end = intervals[i][1];
        }
        return true;
    }
}
