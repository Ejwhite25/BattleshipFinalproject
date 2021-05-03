public class Board {
    public int[][] board;
    public int[][] board1;
    boolean boatBool;

    public Board() {

    }

    public void setBoard(int[][] board,int board1[][]) {
        this.board = board;
        this.board1 = board1;
    }

    public int[][] getBoard() {
        return this.board;
    }
    public int[][] getboard1(){
        return this.board1;
    }

    public void displayBoard(GUIController guiController) {
        StringBuilder grid = new StringBuilder();
        StringBuilder grid1 = new StringBuilder();
        for(int x = 0; x < board.length; x++) {
            grid.append(x);
            for (int y =0; y < board[x].length; y++){
                grid.append("[").append(board[x][y]).append("]");
            }
            grid.append("\n");
        }
        guiController.gui.board1Area.setText(String.valueOf(grid));
        for(int i =0; i < board1.length; i++){
            for(int j =0; j < board1[i].length; j++){
                grid1.append("[").append(board1[i][j]).append("]");
            }
            grid1.append("\n");
        }
        guiController.gui.board2Area.setText(String.valueOf(grid1));

    }

}
