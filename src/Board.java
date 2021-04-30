public class Board {
    public int[][] board;
    public int[][] board1;
    GUIController guiController = new GUIController();
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
        for(int x =1; x < board.length; x++){
            for(int y = 1; x < board1.length; y++){
                guiController.gui.board1Area.setText("[" +board[x][y]+ "]");
                guiController.gui.board2Area.setText("[" +board1[x][y]+ "]");
            }
          }
    }
}
