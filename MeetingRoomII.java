import java.util.Arrays;
import java.util.PriorityQueue;
//TC : O(n log n)
//SC : O(n)

/*
The solution sorts all meeting intervals by their start times to process them in chronological
order. It uses a min-heap (priority queue) to track the end times of ongoing meetings.
For each meeting, if the earliest ending meeting is done (i.e., its end time ≤ current start time),
 it reuses that room by removing it from the heap. Then, it adds the current meeting’s end time
 to the heap, representing an active room.
The size of the heap at the end gives the minimum number of meeting rooms required.
* */
class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0] - b[0]);
        PriorityQueue<Integer> ans=new PriorityQueue<>();

        ans.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0] >= ans.peek())
            {
                ans.poll();
            }
            ans.add(intervals[i][1]);
        }

        return ans.size();
    }
}