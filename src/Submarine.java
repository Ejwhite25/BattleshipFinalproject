public class Submarine {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] submarineArray;

    public Submarine(int x,int y){
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
    }

    void createShip(int playerID){
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        if(playerID == 1){
            int row = Math.abs(player1.submarine.xAxisCoordinate / 10);
            int col = player1.submarine.xAxisCoordinate % 10;
            int lastRow = Math.abs(player1.submarine.yAxisCoordinate / 10);
            int lastCol = player1.submarine.yAxisCoordinate % 10;;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++) {
                    player1.board.board[row-1][i-1] = 1;
                    player1.submarine.submarineArray[row-1][i-1] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    player1.board.board[i-1][col-1] = 1;
                    player1.submarine.submarineArray[i-1][col-1] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(player2.submarine.xAxisCoordinate / 10);
            int col1 = player2.submarine.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(player2.submarine.yAxisCoordinate / 10);
            int lastCol1 = player2.submarine.yAxisCoordinate % 10;;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    player2.board.board[row1-1][i-1] = 1;
                    player2.submarine.submarineArray[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    player2.board.board[i-1][col1-1] = 1;
                    player2.submarine.submarineArray[i-1][col1-1] = 1;
                }
            }

        }
    }
}
