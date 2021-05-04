public class Carrier {

    int[][] carrierArray;
    Controller controller = Controller.returnController();
    private int xAxisCoordinate;
    private int yAxisCoordinate;

    public Carrier(int x, int y){
        xAxisCoordinate = x;
        yAxisCoordinate = y;
        carrierArray = new int[20][20];
    }
    void createShip(int playerId){
        System.out.println("Setting up carrier");
        if(playerId == 1){
            int row = controller.player1.getCarrier().xAxisCoordinate;
            int col = controller.player1.getCarrier().yAxisCoordinate;
                for(int i = col; i <= col + 5; i++) {
                    controller.player1.board1[row][i] = 1;
                    controller.player1.carrier.carrierArray[row][i] = 1;
                }
            }
        else if(playerId == 2){
            int row1 = controller.player2.getCarrier().xAxisCoordinate;
            int col1 = controller.player2.getCarrier().yAxisCoordinate;
            for(int i = col1; i <= col1+5; i++) {
                System.out.println("PLayer 2 X:" + row1);
                System.out.println("Player 2 Y:" + i);
                controller.player2.board1[row1][i] = 1;
                controller.player2.getCarrier().carrierArray[row1][i] = 1;
            }


        }
    }
    public Boolean testHit(int playerId,int row, int col){
        if(playerId == 1)
            for (int[] ints : controller.player1.getCarrier().carrierArray) {
                for (int anInt : ints) {
                    return anInt == controller.player1.getCarrier().carrierArray[row][col];
                }
                return null;
            }
        else if(playerId == 2){
            for (int[] ints : controller.player2.getCarrier().carrierArray) {
                for (int anInt : ints) {
                    return anInt == controller.player2.getCarrier().carrierArray[row][col];
                }
            }

        }
        return null;
    }
}

