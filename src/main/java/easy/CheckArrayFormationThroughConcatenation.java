package easy;

public class CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {

    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int piecesCount = 0;

        for (int[] piece : pieces) {

            // track how many pieces we processed
            piecesCount += piece.length;

            int k = -1;

            // search arr to find index of first item of current piece
            while (k + 1 < arr.length && arr[++k] != piece[0]) {
            }

            // look for pieces sequence in place
            for (int j = 0; j < piece.length; j++) {
                if ((k + j) >= arr.length || piece[j] != arr[k + j]) {
                    return false;
                }
            }

        }

        return arr.length == piecesCount;
    }
}
