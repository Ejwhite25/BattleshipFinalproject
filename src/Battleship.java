public class Battleship {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] battleShipArray;
    Controller controller = Controller.returnController();

    public Battleship(int x, int y) {
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
        this.battleShipArray = new int[20][20];
    }

    void createShip(int playerID) {
        System.out.println("Setting up battleship for Player" + playerID);
        if (playerID == 1) {
            int row = controller.player1.getBattleship().xAxisCoordinate;
            int col = controller.player1.getBattleship().yAxisCoordinate;
            int lastCol = controller.player1.getBattleship().yAxisCoordinate;
                for (int i = col; i <= lastCol + 4; i++) {
                    controller.player1.getBoard().board1[row][i] = 1;
                    controller.player1.getBattleship().battleShipArray[row][i] = 1;
                }
            }
        else if (playerID == 2) {
            int row1 = controller.player2.getBattleship().xAxisCoordinate;
            int col1 = controller.player2.getBattleship().xAxisCoordinate;
            int lastCol1 = controller.player2.getBattleship().yAxisCoordinate;
            for (int i = col1; i <= lastCol1 + 4; i++) {
                controller.player2.getBoard().board1[row1][i] = 1;
                controller.player2.getBattleship().battleShipArray[row1][i] = 1;
            }
        }
    }




    public Boolean testHit(int playerId, int row, int col) {
        if (playerId == 1) {
            for (int[] ints : controller.player1.getBattleship().battleShipArray) {
                for (int anInt : ints) {
                    return anInt == controller.player1.getBattleship().battleShipArray[row][col];
                }
            }
        }
        else if (playerId == 2) {
                for (int[] ints : controller.player2.getBattleship().battleShipArray) {
                    for (int anInt : ints) {
                        return anInt == controller.player2.getBattleship().battleShipArray[row][col];
                    }
                }

            }
            return null;
        }
    }