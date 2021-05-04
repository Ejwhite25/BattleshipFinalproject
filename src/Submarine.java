public class Submarine {
    int xAxisCoordinate;
    int yAxisCoordinate;
    int[][] submarineArray;
    Controller controller = Controller.returnController();

    public Submarine(int x, int y) {
        this.xAxisCoordinate = x;
        this.yAxisCoordinate = y;
        submarineArray = new int[20][20];
    }

    void createShip(int playerID) {
        System.out.println("Setting up submarine\n");
        if (playerID == 1) {
            int row = controller.player1.getSubmarine().xAxisCoordinate;
            int col = controller.player1.getSubmarine().yAxisCoordinate;
                for (int i = col; i <= col + 3; i++) {
                    controller.player1.board1[row][i] = 1;
                    controller.player1.getSubmarine().submarineArray[row][i] = 1;
                }

        } else if (playerID == 2) {
            int row1 = controller.player2.getSubmarine().xAxisCoordinate;
            int col1 = controller.player2.getSubmarine().yAxisCoordinate;
            for (int i = col1; i <= col1 + 3; i++) {
                controller.player2.board1[row1][i] = 1;
                controller.player2.getSubmarine().submarineArray[row1][i] = 1;
            }
        }
    }

    public Boolean testHit(int playerId, int row, int col) {
        if (playerId == 1) {
            for (int[] ints : controller.player1.getSubmarine().submarineArray) {
                for (int anInt : ints) {
                    return anInt == controller.player1.getSubmarine().submarineArray[row][col];
                }
                return null;
            }
        }
        else if (playerId == 2) {
                for (int[] ints : controller.player2.getSubmarine().submarineArray) {
                    for (int anInt : ints) {
                        return anInt == controller.player2.getSubmarine().submarineArray[row][col];
                    }
                }

            }
            return null;
        }
    }


