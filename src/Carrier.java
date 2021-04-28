public class Carrier {

    public int xAxisCoordinate;
    public int yAxisCoordinate;
    public int[][] carrierArray;

    public Carrier(int x,int y){
        xAxisCoordinate = x;
        yAxisCoordinate = y;
        carrierArray = new int[10][10];
    }


    
    void createShip(int playerId){
        if(playerId == 1){
            int row = Math.abs(Controller.player1carrier.xAxisCoordinate/10);
            int col = Controller.player1carrier.xAxisCoordinate % 10;
            int lastRow = Math.abs(Controller.player1carrier.yAxisCoordinate/10);
            int lastCol = Controller.player1carrier.yAxisCoordinate % 10;
            if (row == lastRow) {
                for(int i = col; i <= lastCol; i++) {
                    Controller.player1board.board[row][i] = 1;
                    Controller.player1carrier.carrierArray[row][i] = 1;
                }
            }
            else if(col == lastCol){
                for(int i = row; i <= lastRow; i++){
                    Controller.player1board.board[i][col] = 1;
                    Controller.player1carrier.carrierArray[i][col] = 1;
                }
            }

        }
        else if(playerId == 2){
            int row1 = Math.abs(Controller.player2carrier.xAxisCoordinate / 10);
            int col1 = Controller.player2carrier.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(Controller.player2carrier.yAxisCoordinate / 10);
            int lastCol1 = Controller.player2carrier.yAxisCoordinate % 10;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    Controller.player2board.board1[row1-1][i-1] = 1;
                    Controller.player2carrier.carrierArray[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    Controller.player2board.board1[i-1][col1-1] = 1;
                    Controller.player2carrier.carrierArray[i-1][col1-1] = 1;
                }
            }

        }
    }
    public Boolean testHit(int playerId,int row, int col){
        if(playerId == 1)
            for (int[] ints : Controller.player1carrier.carrierArray) {
                for (int anInt : ints) {
                    return anInt == Controller.player1carrier.carrierArray[row][col];
                }
                return null;
            }
        else if(playerId == 2){
            for (int[] ints : Controller.player2carrier.carrierArray) {
                for (int anInt : ints) {
                    return anInt == Controller.player2carrier.carrierArray[row][col];
                }
            }

        }
        return null;
    }
}

