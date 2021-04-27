public class Destroyer {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] destroyerArray;

    public Destroyer(int x, int y){
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
        destroyerArray = new int[10][10];
    }


    void createShip(int playerID){
        if(playerID == 1){
            int row = Math.abs(Controller.player1destroyer.xAxisCoordinate / 10);
            int col = Controller.player1destroyer.xAxisCoordinate % 10;
            int lastRow = Math.abs(Controller.player1destroyer.yAxisCoordinate / 10);
            int lastCol = Controller.player1destroyer.yAxisCoordinate % 10;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++) {
                    Controller.player1board.board[row-1][i-1] = 1;
                    Controller.player1destroyer.destroyerArray[row-1][i-1] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    Controller.player1board.board[i-1][col-1] = 1;
                    Controller.player1destroyer.destroyerArray[i-1][col-1] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(Controller.player2destroyer.xAxisCoordinate / 10);
            int col1 = Controller.player2destroyer.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(Controller.player2destroyer.yAxisCoordinate / 10);
            int lastCol1 = Controller.player2destroyer.yAxisCoordinate % 10;;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    Controller.player2board.board[row1-1][i-1] = 1;
                    Controller.player2destroyer.destroyerArray[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    Controller.player2board.board[i-1][col1-1] = 1;
                    Controller.player2destroyer.destroyerArray[i-1][col1-1] = 1;
                }
            }

        }
    }
    public Boolean testHit(int playerId,int row, int col){
        if(playerId == 1)
            for (int[] ints : Controller.player1destroyer.destroyerArray) {
                for (int anInt : ints) {
                    return anInt == Controller.player1destroyer.destroyerArray[row][col];
                }
                return null;
            }
        else if(playerId == 2){
            for (int[] ints : Controller.player2battleship.battleShipArray) {
                for (int anInt : ints) {
                    return anInt == Controller.player2battleship.battleShipArray[row][col];
                }
            }

        }
        return null;
    }

}
