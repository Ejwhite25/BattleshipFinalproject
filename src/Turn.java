import java.util.ArrayList;

public class Turn {
    int playerId;
    int firstCoordinate;
    int secondCoordinate;
    Controller controller = new Controller();
    public Turn(int id,int row, int col) {
        playerId = id;
        firstCoordinate = row;
        secondCoordinate = col;

    }

    void testHit(Turn turn){
        if(turn.playerId == 1){
            if(controller.player2board.board[turn.firstCoordinate][turn.secondCoordinate] == 1){
                controller.player2board.board[turn.firstCoordinate][turn.secondCoordinate] = 0;
                controller.player1board.board1[turn.firstCoordinate][turn.secondCoordinate] = 0;

            }
            else{
                controller.player1board.board1[turn.firstCoordinate][turn.secondCoordinate] = '\0';
            }
        }
        else if(turn.playerId == 2){
            if(controller.player1board.board[turn.firstCoordinate][turn.secondCoordinate] == 1){
                controller.player1board.board[turn.firstCoordinate][turn.secondCoordinate] = 0;
                controller.player2board.board1[turn.firstCoordinate][turn.secondCoordinate] = 0;
            }
            else{
                controller.player2board.board1[turn.firstCoordinate][turn.secondCoordinate] = '\0';

            }
        }



    }


}
