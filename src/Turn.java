public class Turn {
    int playerId;
    int firstCoordinate;
    int secondCoordinate;
    Controller controller = Controller.returnController();

    public Turn(int id, int row, int col) {
        playerId = id;
        firstCoordinate = row;
        secondCoordinate = col;

    }

    public boolean testHit(int playerId, int x, int y) {
        if (playerId == 1) {
            if (controller.player2.board1[x][y] == 1) {
                System.out.println("There's been a hit");
                return true;
            } else {
                System.out.println("There's been a miss");
                return false;
            }
        } else if (playerId == 2) {
            if (controller.player1.board1[x][y]  == 1) {
                System.out.println("There's been a hit!");
                return true;

            } else {
                System.out.println("There's been a miss");
                return false;
            }
        }
        return false;
    }
}

