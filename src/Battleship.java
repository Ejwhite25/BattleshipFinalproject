public class Battleship {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] battleShipArray;

    public Battleship() {
        battleShipArray = new int[4][4];
        xAxisCoordinate = 0;
        yAxisCoordinate = 0;


    }

    void createShip(int playerID) {
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        if(playerID == 1){
        int row = Math.abs(player1.battleship.xAxisCoordinate / 10);
        int col = player1.battleship.xAxisCoordinate % 10;
        int lastRow = Math.abs(player1.battleship.yAxisCoordinate / 10);
        int lastCol = player1.battleship.yAxisCoordinate % 10;;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++) {
                    player1.board.board[row-1][i-1] = 1;
                    player1.board.board1[row-1][i-1] = 1;
                    player1.battleship.battleShipArray[row-1][i-1] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    player1.board.board[i-1][col-1] = 1;
                    player1.board.board1[i-1][col-1] = 1;
                    player1.battleship.battleShipArray[i-1][col-1] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(player2.battleship.xAxisCoordinate / 10);
            int col1 = player2.battleship.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(player2.battleship.yAxisCoordinate / 10);
            int lastCol1 = player2.battleship.yAxisCoordinate % 10;;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    player2.board.board[row1-1][i-1] = 1;
                    player2.board.board1[row1-1][i-1] = 1;
                    player2.battleship.battleShipArray[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    player2.board.board[i-1][col1-1] = 1;
                    player2.board.board1[i-1][col1-1] = 1;
                    player2.battleship.battleShipArray[i-1][col1-1] = 1;
                }
            }

        }
    }
    void updateShip(int x, int y){
        battleShipArray[x][y] = '\0';
    }


    public Boolean testHit(int playerId,int row, int col){
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        if(playerId == 1)
        for (int[] ints : player1.battleship.battleShipArray) {
            for (int anInt : ints) {
                return anInt == player1.battleship.battleShipArray[row][col];
            }
            return null;
        }
        else if(playerId == 2){
            for (int[] ints : player2.battleship.battleShipArray) {
                for (int anInt : ints) {
                    return anInt == player2.battleship.battleShipArray[row][col];
                }
            }

        }
        return null;
    }
}