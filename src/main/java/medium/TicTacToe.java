package medium;

/*
https://leetcode.com/problemset/all/?search=348
 */
public class TicTacToe {
    public static void main(String[] args) {


    }

    public TicTacToe(int n) {
        rows = new int[n];
        columns = new int[n];
    }

    private int[] rows;
    private int[] columns;
    private int diagonalSum;
    private int antiDiagonalSum;

    public int move(int row, int col, int player) {
        int playerValue = player == 1 ? 1 : -1;
        if (row == col) {
            diagonalSum += playerValue;
        }
        if (col == columns.length - row) {
            antiDiagonalSum += playerValue;
        }
        rows[row] = playerValue;
        columns[col] = playerValue;

        if (Math.abs(diagonalSum) == 3 || Math.abs(antiDiagonalSum) == 3
                || Math.abs(rows[row]) == 3 ||Math.abs(columns[col]) == 3)
            return player;

            return 0;
    }
}
