public class Submarine {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] submarineArray;

    public Submarine(int x,int y){
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
        submarineArray = new int[10][10];
    }

    void createShip(int playerID){
        if(playerID == 1){
            int row = Math.abs(Controller.player1submarine.xAxisCoordinate / 10);
            int col = Controller.player1submarine.xAxisCoordinate % 10;
            int lastRow = Math.abs(Controller.player1submarine.yAxisCoordinate / 10);
            int lastCol = Controller.player1submarine.yAxisCoordinate % 10;;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++) {
                    Controller.player1board.board[row][i] = 1;
                    Controller.player2submarine.submarineArray[row][i] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    Controller.player1board.board[i][col] = 1;
                    Controller.player2submarine.submarineArray[i][col] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(Controller.player2submarine.xAxisCoordinate / 10);
            int col1 = Controller.player2submarine.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(Controller.player2submarine.yAxisCoordinate / 10);
            int lastCol1 = Controller.player2submarine.yAxisCoordinate % 10;;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    Controller.player2board.board[row1-1][i-1] = 1;
                    Controller.player2submarine.submarineArray[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    Controller.player2board.board[i-1][col1-1] = 1;
                    Controller.player2submarine.submarineArray[i-1][col1-1] = 1;
                }
            }

        }
    }
}
