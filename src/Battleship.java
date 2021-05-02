public class Battleship {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] battleShipArray;

    public Battleship(int x,int y) {
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
        battleShipArray = new int[10][10];
    }

    void createShip(int playerID) {
        if(playerID == 1){
        int row = Math.abs(Controller.player1battleship.xAxisCoordinate / 10);
        int col = Controller.player1battleship.xAxisCoordinate % 10;
        int lastRow = Math.abs(Controller.player1battleship.yAxisCoordinate / 10);
        int lastCol = Controller.player1battleship.yAxisCoordinate % 10;;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++){
                    //Error checking on this.
                    Controller.player1board.board[row][i] = 1;
                    Controller.player1.battleship.battleShipArray[row][i] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    Controller.player1board.board[i][col] = 1;
                    Controller.player1battleship.battleShipArray[i][col] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(Controller.player2battleship.xAxisCoordinate / 10);
            int col1 = Controller.player2battleship.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(Controller.player2battleship.yAxisCoordinate / 10);
            int lastCol1 = Controller.player2battleship.yAxisCoordinate % 10;;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    Controller.player2board.board[row1][i] = 1;
                    Controller.player2.battleship.battleShipArray[row1][i] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    Controller.player2board.board[i][col1] = 1;
                    Controller.player2battleship.battleShipArray[i][col1] = 1;
                }
            }

        }
    }
    void updateShip(int x, int y){
        battleShipArray[x][y] = '\0';
    }


    public Boolean testHit(int playerId,int row, int col){
        if(playerId == 1)
        for (int[] ints : Controller.player1battleship.battleShipArray) {
            for (int anInt : ints) {
                return anInt == Controller.player1battleship.battleShipArray[row][col];
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