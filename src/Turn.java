public class Turn {
    int playerId;
    int firstCoordinate;
    int secondCoordinate;
    public Turn() {

    }

    public boolean testHit(int playerId, int x, int y) {
        if (playerId == 1) {
            if (Controller.returnController().player2.getBoard().board1[x][y] == 1) {
                System.out.println("There's been a hit");
                return true;
            } else {
                System.out.println("There's been a miss on player1");
                return false;
            }
        } else if (playerId == 2) {
            if (Controller.returnController().player1.getBoard().board1[x][y] == 1) {
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

