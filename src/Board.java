public class Board {
    int[][] board;
    int[][] board1;
    public Board(){

    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;

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
