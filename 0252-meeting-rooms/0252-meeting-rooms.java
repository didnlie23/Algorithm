class Solution {

    public boolean canAttendMeetings(int[][] intervals) {
        boolean[] have_a_schedule = new boolean[1000000];
        int length = intervals.length;
        for (int i = 0; i < length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = start; j < end; j++) {
                if (have_a_schedule[j]) return false;
                have_a_schedule[j] = true;
            }
        }
        return true;
    }
}
