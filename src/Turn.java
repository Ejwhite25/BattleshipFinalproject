import java.util.ArrayList;

public class Turn {
    int playerId;
    int firstCoordinate;
    int secondCoordinate;

    public Turn(int id, int row, int col) {
        playerId = id;
        firstCoordinate = row;
        secondCoordinate = col;

    }



    boolean testHit(Turn turn) {
        if (turn.playerId == 1) {
            if (Controller.player2board.board[turn.firstCoordinate][turn.secondCoordinate] == 1) {
                Controller.player2board.board[turn.firstCoordinate][turn.secondCoordinate] = 0;
                Controller.player1board.board1[turn.firstCoordinate][turn.secondCoordinate] = 0;
                Controller.player2.markShipHit(turn.firstCoordinate, turn.secondCoordinate);
                return true;
            } else {
                Controller.player1board.board1[turn.firstCoordinate][turn.secondCoordinate] = '\0';
                return false;
            }
        } else if (turn.playerId == 2) {
            if (Controller.player1board.board[turn.firstCoordinate][turn.secondCoordinate] == 1) {
                Controller.player1board.board[turn.firstCoordinate][turn.secondCoordinate] = 0;
                Controller.player2board.board1[turn.firstCoordinate][turn.secondCoordinate] = 0;
                Controller.player1.markShipHit(turn.firstCoordinate, turn.secondCoordinate);
                return true;
            } else {
                Controller.player2board.board1[turn.firstCoordinate][turn.secondCoordinate] = '\0';
                return false;

            }
        }
        return false;
    }
}
