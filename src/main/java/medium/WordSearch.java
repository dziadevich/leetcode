package medium;

public class WordSearch {

    public static void main(String[] args) {
        System.out.println(new WordSearch()
                .exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
                        "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int index,  int i, int j){
        if(index == word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean result = dfs(board, word, index + 1, i-1, j) ||
                dfs(board, word, index + 1, i+1, j) ||
                dfs(board, word, index + 1, i, j-1) ||
                dfs(board, word, index + 1, i, j+1);

        board[i][j] = temp;
        return result;
    }
}
