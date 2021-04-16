public class Battleship {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] battleShipArray;

    public Battleship(int x,int y) {
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
    }

    void createShip(int playerID) {
        Controller controller = new Controller();
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        if(playerID == 1){
        int row = Math.abs(controller.player1battleship.xAxisCoordinate / 10);
        int col = controller.player1battleship.xAxisCoordinate % 10;
        int lastRow = Math.abs(controller.player1battleship.yAxisCoordinate / 10);
        int lastCol = controller.player1battleship.yAxisCoordinate % 10;;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++) {
                    controller.player1board.board[row-1][i-1] = 1;
                    controller.player1.battleship.battleShipArray[row-1][i-1] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    controller.player1board.board[i-1][col-1] = 1;
                    controller.player1battleship.battleShipArray[i-1][col-1] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(controller.player2battleship.xAxisCoordinate / 10);
            int col1 = controller.player2battleship.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(controller.player2battleship.yAxisCoordinate / 10);
            int lastCol1 = controller.player2battleship.yAxisCoordinate % 10;;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    controller.player2board.board[row1-1][i-1] = 1;
                    controller.player2.battleship.battleShipArray[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    controller.player2board.board[i-1][col1-1] = 1;
                    controller.player2battleship.battleShipArray[i-1][col1-1] = 1;
                }
            }

        }
    }
    void updateShip(int x, int y){
        battleShipArray[x][y] = '\0';
    }


    public Boolean testHit(int playerId,int row, int col){
        Controller controller = new Controller();
        if(playerId == 1)
        for (int[] ints : controller.player1battleship.battleShipArray) {
            for (int anInt : ints) {
                return anInt == controller.player1battleship.battleShipArray[row][col];
            }
            return null;
        }
        else if(playerId == 2){
            for (int[] ints : controller.player2battleship.battleShipArray) {
                for (int anInt : ints) {
                    return anInt == controller.player2battleship.battleShipArray[row][col];
                }
            }

        }
        return null;
    }
}