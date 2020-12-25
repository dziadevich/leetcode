package easy;

/*
https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class FindWinnerTicTacToe {
    public static void main(String[] args) {
        System.out.println(FindWinnerTicTacToe.tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}));
    }

    public static String tictactoe(int[][] moves) {

        int n = moves.length;

        // As board is of fixed size 3*3

        // rows
        int[] rows = new int[3];
        // columns
        int[] cols = new int[3];
        // left diagonal
        int dlr =0;
        // right diagonal
        int drl = 0;

        for(int i = 0; i<moves.length; i++){
            // Coordinates of moves by any player across the 3*3 board
            int r = moves[i][0];
            int c = moves[i][1];

            // Player 1
            if(i%2 == 0){
                rows[r]++;
                cols[c]++;
                // left diagonal condition if i==j
                if(r == c) dlr++;
                // right diagonal condition if i+j = 3-1
                if ((r+c)==(2)) drl++;


                if(rows[r] == 3 || cols[c] == 3 || dlr == 3 || drl == 3) return "A";
            } else{
                // Player 2
                rows[r]--;
                cols[c]--;
                if(r == c) dlr--;
                if ((r+c)==(2)) drl--;

                if(rows[r] == -3 || cols[c] == -3 || dlr == -3 || drl == -3) return "B";
            }
        }
        // 9 moves possible on 3*3 board; if all moves are made with no result
        if(n == 9) return "Draw";

        // Some moves are remaining
        return "Pending";
    }
}
