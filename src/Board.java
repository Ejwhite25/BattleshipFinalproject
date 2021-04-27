public class Board {
    public int[][] board;
    public int[][] board1;
    public Board(int[][] boardSet,int[][] boardSet1){
        this.board = boardSet;
        this.board1 = boardSet1;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return this.board;

    }

    public void displayBoard(){
        for(int x =0; x < board.length; x++){
            for(int y = 0; x < board[x].length; y++){
                System.out.print("[" +board[x][y]+ "]");
                System.out.print("[" +board1[x][y]+ "]");
            }
          }
    }
    public void updateBoard(int x, int y){
        board[x][y] = '\0';
        board1[x][y] = '\0';
    }
}
