package medium;

public class Search2DMatrix {

    public static void main(String[] args) {
        System.out.println(new Search2DMatrix()
                .searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            int midpoint_element = matrix[midpoint / columns][midpoint % columns];
            if (midpoint_element == target)
                return true;
            else if (target < midpoint_element) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
        }

        return false;
    }
}
