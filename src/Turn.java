public class Turn {
    int playerId;
    int firstCoordinate;
    int secondCoordinate;
    public Turn(int id,int row, int col,String shipType){
        playerId = id;
        firstCoordinate = row;
        secondCoordinate = col;
        shipType = "\0";

    }


    void testHit(Turn turn){
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();

    }


}
