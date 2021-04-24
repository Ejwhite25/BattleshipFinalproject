public class Turn {
    int playerId;
    int firstCoordinate;
    int secondCoordinate;
    public Turn(int id,int row, int col){
        playerId = id;
        firstCoordinate = row;
        secondCoordinate = col;

    }


    void testHit(Turn turn){
        Controller controller = new Controller();
        if(turn.playerId == 1){
            if(controller.player2board.board[turn.firstCoordinate][turn.secondCoordinate] == 1){

            }
        }
        else if(turn.playerId == 2){
            
        }



    }


}
