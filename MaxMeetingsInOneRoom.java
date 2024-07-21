class Solution 
{
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        int order;
        
        public Meeting(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }
        
        @Override
        public int compareTo(Meeting meeting) {
            return Integer.compare(end, meeting.end);
        }
    }

    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }
        Collections.sort(meetings);
        
        int count = 1;
        int lastEndTime = meetings.get(0).end;
        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > lastEndTime) {
                lastEndTime = meetings.get(i).end;
                count++;
            }
        }
        
        return count;
    }
}
