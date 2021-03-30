package medium;

import java.util.*;

/*
    https://leetcode.com/problems/open-the-lock/
 */
public class OpentheLock {

    private static String initializedValue = "0000";

    public int openLock(String[] deadends, String target) {

        // Declare a dead end SET in order to compare the value
        Set<String> deadEndsSet = new HashSet<String>(Arrays.asList(deadends));

        // Check if string 0000 match target
        if (initializedValue.equals(target)) {
            return 0;
        }

        // Check if string 0000 match deadends
        if (deadEndsSet.contains(initializedValue)) {
            //		System.out.println("A " + deadEndsSet.contains(initializedValue));
            //		System.out.println("A " + initializedValue);
            return -1;
        }

        // Declare a visited Set in order to do the duplication check
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(initializedValue);

        // 1. Declare an queue for operating BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(initializedValue);

        int step = 0;

        // 2. looping
        while (!queue.isEmpty()) {

            step++;

            // 3. declare the queue size and refresh it after the iteration of outer for-loop
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {

                // 4. Dequeue by using built-in method, poll()
                String strValue = queue.poll();

                // This step is critical, this function is going to return all the posibilities of
                // current step. For example, if the value start from 0000, then the first operation's
                // possibilities can be these eight, 1000, 0100, 0010, 0001, 9000, 0900, 0090, 0009
                List<String> allPossibilities = getAllPossibilities(strValue, deadEndsSet, visitedSet);

                // Then, this loop will Enqueue these first time result above into queue,
                // and then calculate each possibilities.
                for (String value : allPossibilities) {

                    // 5. Enqueue  by using built-in method, add()
                    queue.add(value);

                    if (value.equals(target)) {
                        return step;
                    }
                }
            }
        }

        return -1;
    }


    // This function is used to return the all possibilities of current step.
    private List<String> getAllPossibilities(String strValue, Set<String> deadEndsSet, Set<String> visitedSet) {

        // Used to collect those possibilities
        List<String> allPossibleList = new ArrayList<String>();

        // The wheel number is 4 is because we can only modify the wheel for 4 times
        for (int wheelNumber = 0; wheelNumber < 4; wheelNumber++) {

            // The array needs to be reset each wheel without modification of original strValue.
            // Because, each step, like we turn the wheel from 0 to 9, 9 to 0, 1 to 2, 2 to 1, etc.,
            // needs the status of current step, which is - strValue.
            char[] tempClone = strValue.toCharArray().clone();

            // 1st operation is to turn the wheel down-ward, like 0 -> 9, 3 - > 2, or 8 -> 7
            if (tempClone[wheelNumber] == '0') {
                tempClone[wheelNumber] = '9';
            } else {
                tempClone[wheelNumber] = (char) ((int) tempClone[wheelNumber] - 1);
            }

            // Convert the modified array to string
            String tempString = new String(tempClone);

            // TRICKY PART : we could not use the visitedSet.contains() here because it will TLE.
            // Thus, on the other hand, we need to use the add(), which will return true if element
            // isn't exist and return false if element is already exist.
            if (!deadEndsSet.contains(tempString) && visitedSet.add(tempString)) {
                allPossibleList.add(tempString);
            }

            // 2nd operation is to turn the wheel up-ward, like 0 -> 1, 5 -> 6, or 8 -> 9
            if (strValue.toCharArray()[wheelNumber] < '9') {

                // Reset the temp, because the value is wrong if we don't do the reset. For example,
                // the down-ward might changer the array to this 7 0 0 0, and then, to this step,
                // the up-ward will change the 7 0 0 0 to 8 0 0 0. However, the correct value should
                // be 9 0 0 0, cuz the original is 8 0 0 0, and the result we expect after turing
                // up-ward and down-ward should be 7 0 0 0 and 9 0 0 0
                tempClone = strValue.toCharArray().clone();

                tempClone[wheelNumber] = (char) ((int) tempClone[wheelNumber] + 1);

                tempString = new String(tempClone);

                if (!deadEndsSet.contains(tempString) && visitedSet.add(tempString)) {
                    allPossibleList.add(tempString);
                }
            }

        }

        return allPossibleList;
    }
}
