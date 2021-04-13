public class Destroyer {
    int xAxisCoordinate;
    int yAxisCoordinate;

    public Destroyer(){
        xAxisCoordinate = 0;
        yAxisCoordinate = 0;
    }
    
    void createShip(int playerID){
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        if(playerID == 1){
            int row = Math.abs(player1.destroyer.xAxisCoordinate / 10);
            int col = player1.destroyer.xAxisCoordinate % 10;
            int lastRow = Math.abs(player1.destroyer.yAxisCoordinate / 10);
            int lastCol = player1.destroyer.yAxisCoordinate % 10;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++) {
                    player1.board.board[row-1][i-1] = 1;
                    player1.board.board1[row-1][i-1] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    player1.board.board[i-1][col-1] = 1;
                    player1.board.board1[i-1][col-1] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(player2.destroyer.xAxisCoordinate / 10);
            int col1 = player2.destroyer.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(player2.destroyer.yAxisCoordinate / 10);
            int lastCol1 = player2.destroyer.yAxisCoordinate % 10;;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    player2.board.board[row1-1][i-1] = 1;
                    player2.board.board1[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    player1.board.board[i-1][col1-1] = 1;
                    player1.board.board1[i-1][col1-1] = 1;
                }
            }

        }
    }
}
