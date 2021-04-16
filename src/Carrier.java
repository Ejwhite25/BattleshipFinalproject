public class Carrier {

    public int xAxisCoordinate;
    public int yAxisCoordinate;
    public int[][] carrierArray;

    public Carrier(int xAxisCoordinate,int yAxisCoordinate){
        this.xAxisCoordinate = xAxisCoordinate;
        this.yAxisCoordinate = yAxisCoordinate;

    }


    
    void createShip(int playerID){
        Controller controller = new Controller();
        if(playerID == 1){
            int row = Math.abs( controller.player1carrier.xAxisCoordinate/ 10);
            int col = controller.player1carrier.xAxisCoordinate % 10;
            int lastRow = Math.abs(controller.player1carrier.yAxisCoordinate / 10);
            int lastCol = controller.player1carrier.yAxisCoordinate % 10;;
            if (col == lastCol) {
                for(int i = col; i <= lastCol; i++) {
                    controller.player1board.board[row-1][i-1] = 1;
                    controller.player1carrier.carrierArray[row-1][i-1] = 1;
                }
            }
            else if(row == lastRow){
                for(int i = row; i <= lastRow; i++){
                    controller.player1board.board[i-1][col-1] = 1;
                    controller.player1carrier.carrierArray[i-1][col-1] = 1;
                }
            }

        }
        else if(playerID == 2){
            int row1 = Math.abs(controller.player2carrier.xAxisCoordinate / 10);
            int col1 = controller.player2carrier.xAxisCoordinate % 10;
            int lastRow1 = Math.abs(controller.player2carrier.yAxisCoordinate / 10);
            int lastCol1 = controller.player2carrier.yAxisCoordinate % 10;
            if (col1 == lastCol1) {
                for(int i = col1; i <= lastCol1; i++) {
                    controller.player2board.board[row1-1][i-1] = 1;
                    controller.player2carrier.carrierArray[row1-1][i-1] = 1;
                }
            }
            else if(row1 == lastRow1){
                for(int i = row1; i <= lastRow1; i++){
                    controller.player2board.board[i-1][col1-1] = 1;
                    controller.player2carrier.carrierArray[i-1][col1-1] = 1;
                }
            }

        }
    }
}

