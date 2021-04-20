public class Destroyer {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] destroyerArray;

    public Destroyer(int x, int y){
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
    }
    
    void createShip(int playerID){
        Controller controller = new Controller();
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        if(playerID == 1){
            int row = Math.abs(controller.player1destroyer.xAxisCoordinate / 10);
            int col = controller.player1destroyer.xAxisCoordinate % 10;
            int lastRow = Math.abs(controller.player1destroyer.yAxisCoordinate / 10);
            int lastCol = controller.player1destroyer.yAxisCoordinate % 10;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++) {
                    controller.player1board.board[row-1][i-1] = 1;
                    controller.player1destroyer.destroyerArray[row-1][i-1] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    controller.player1board.board[i-1][col-1] = 1;
                    controller.player1destroyer.destroyerArray[i-1][col-1] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(controller.player2destroyer.xAxisCoordinate / 10);
            int col1 = controller.player2destroyer.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(controller.player2destroyer.yAxisCoordinate / 10);
            int lastCol1 = controller.player2destroyer.yAxisCoordinate % 10;;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    controller.player2board.board[row1-1][i-1] = 1;
                    controller.player2destroyer.destroyerArray[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    controller.player2board.board[i-1][col1-1] = 1;
                    controller.player2destroyer.destroyerArray[i-1][col1-1] = 1;
                }
            }

        }
    }//function th check through coordinates for loss.

}
