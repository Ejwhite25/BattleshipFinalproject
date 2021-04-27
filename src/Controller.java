public class Controller {
    Player1 player1;
    Player2 player2;
    Carrier player1carrier;
    Destroyer player1destroyer;
    Destroyer player2destroyer;
    Submarine player1submarine;
    Submarine player2submarine;
    Battleship player1battleship;
    Battleship player2battleship;
    Carrier player2carrier;
    Board player1board;
    Board player2board;

    public Controller(){
        player1 = new Player1();
        player2 = new Player2();

    }
}
