public class FindWord {

    public static void main(String[] args) {
        String word = "ABCCED";
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

       boolean found = false;
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    found = searchWord(word, board, i, j, 0);
                    if(found) {
                     break;
                    }
                }
            }
            if(found) {
                break;
            }
        }

        System.out.println(found);
    }

    private static boolean searchWord(String word, char[][] board, int row, int col, int index) {

        if (word.length() == index) {
            return true;
        }

        if(row <0 || col <0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '*';

        boolean foundword =  searchWord(word, board, row+1, col, index+1)
                || searchWord(word, board, row-1, col, index+1)
                || searchWord(word, board, row, col+1, index+1)
                || searchWord(word, board, row, col-1, index+1);

        board[row][col] = temp;

        return foundword;
    }
}
