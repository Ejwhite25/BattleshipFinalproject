public class Board {
    public int[][] board;
    public int [][] board1;
    public int[][] board2;
    public int[][] board3;
    public Board(){
          board = new int[14][14];
          board1 = new int[14][14];
    }

    public void displayBoard(){
        for(int x =0; x < board.length; x++){
            for(int y = 0; x < board[x].length; y++){
                System.out.print(board[x][y]+" ");
                System.out.print(board1[x][y] + " ");
            }
          }
    }
    public void updateBoard(int x, int y){
        board[x][y] = '\0';
        board1[x][y] = '\0';
    }
}
