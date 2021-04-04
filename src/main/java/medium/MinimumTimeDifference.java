package medium;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/minimum-time-difference/
 */
public class MinimumTimeDifference {
    public static void main(String[] args) {
        System.out.println(new MinimumTimeDifference().findMinDifference(Arrays.asList("00:00","23:59","00:00")));
    }

    public int findMinDifference(List<String> timePoints) {
        if(timePoints == null || timePoints.size() == 0){
            return 0;
        }

        int[] time = new int[2881];
        int minDifference = 721;
        int minMinute = 2881;

        for (String timePoint : timePoints) {
            int minutes = (timePoint.charAt(0) - '0') * 10;
            minutes += (timePoint.charAt(1) - '0');
            minutes *= 60;
            minutes += (timePoint.charAt(3) - '0') * 10;
            minutes += (timePoint.charAt(4) - '0');

            time[minutes] += 1;
            time[minutes + 1440] += 1;
            if (time[minutes] == 2) {
                return 0;
            }
            if (minMinute > minutes) {
                minMinute = minutes;
            }
        }

        for(int j = minMinute+1;j<2881;j++){
            int currentDifference;
            if(time[j] == 1){
                currentDifference = j - minMinute;
                minMinute = j;
                if(currentDifference < minDifference){
                    minDifference = currentDifference;
                }
            }
        }
        return minDifference;
    }
}
