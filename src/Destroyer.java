public class Destroyer {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] destroyerArray;
    Controller controller = Controller.returnController();

    public Destroyer(int x, int y){
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
        destroyerArray = new int[20][20];
    }


    void createShip(int playerID){
        System.out.println("Setting up destroyer");
        if(playerID == 1){
            int row = controller.player1.getDestroyer().xAxisCoordinate;
            int col = controller.player1.getDestroyer().xAxisCoordinate;
            int lastCol = controller.player1.getDestroyer().yAxisCoordinate;
            for(int i = col; i <= lastCol + 4; i++) {
                controller.player1.getBoard().board1[row][i] = 1;
                controller.player1.getDestroyer().destroyerArray[row][i] = 1;
            }
        }
        else if(playerID == 2){
            int row1 = controller.player2.getDestroyer().xAxisCoordinate;
            int col1 = controller.player2.getDestroyer().yAxisCoordinate;
                for(int i = col1; i <= col1 + 4; i++) {
                   controller.player2.getBoard().board1[row1][i] = 1;
                   controller.player2.getDestroyer().destroyerArray[row1][i] = 1;
                }
            }

        }
    public Boolean testHit(int playerId,int row, int col){
        if(playerId == 1)
            for (int[] ints : controller.player1.getDestroyer().destroyerArray) {
                for (int anInt : ints) {
                    return anInt == controller.player1.getDestroyer().destroyerArray[row][col];
                }
                return null;
            }
        else if(playerId == 2){
            for (int[] ints : controller.player2.getBattleship().battleShipArray) {
                for (int anInt : ints) {
                    return anInt == controller.player2.getBattleship().battleShipArray[row][col];
                }
            }

        }
        return null;
    }

}
