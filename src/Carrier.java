public class Carrier {

    int[][] carrierArray;
    Controller controller = Controller.returnController();
    int xAxisCoordinate;
    int yAxisCoordinate;

    public Carrier(int x, int y){
        xAxisCoordinate = x;
        yAxisCoordinate = y;
        carrierArray = new int[20][20];
    }


    public int[][] getCarrierArray(){
        return carrierArray;
    }
    public boolean testCarrierHit(int playerId, int x, int y){
        if(playerId == 1){
            if(controller.player2.carrier.carrierArray[x][y] == 1){
                System.out.println("Detected");
                return true;
            }
            else{
                System.out.println("Detected");
                return false;
            }
        }
        else if(playerId == 2){
            if(controller.player1.carrier.carrierArray[x][y] == 1){
                System.out.println("Detected");
                return true;
            }
            else{
                System.out.println("Not Detected");
                return false;
            }

        }
        return true;

    }
    void createShip(int playerId){
        if(playerId == 1){
            int row = controller.player1.carrier.xAxisCoordinate;
            int col = controller.player1.carrier.yAxisCoordinate;
                for(int i = col; i <= col + 4; i++) {
                    controller.player1.board.board1[row][i-1] = 1;
                }
            }
        else if(playerId == 2){
            int row1 = controller.player2.carrier.xAxisCoordinate;
            int col1 = controller.player2.carrier.yAxisCoordinate;
            for(int i = col1; i <= col1+4; i++) {
                controller.player2.getCarrier().getCarrierArray()[row1][i-1] = 1;
            }



        }
    }
    public Boolean testHit(int playerId,int row, int col){
        if(playerId == 1)
            for (int[] ints : controller.player1.getCarrier().carrierArray) {
                for (int anInt : ints) {
                    System.out.println("Its matching");
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

