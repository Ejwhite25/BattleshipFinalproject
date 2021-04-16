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
        player1battleship = player1.getBattleship();
        player2battleship = player2.getBattleship();
        player1destroyer = player1.getDestroyer();
        player1destroyer = player2.getDestroyer();
        player1submarine = player1.getSubmarine();
        player2submarine = player2.getSubmarine();
        player1carrier = player1.getCarrier();
        player2carrier = player2.getCarrier();
        player1board = player1.getBoard();
        player2board = player2.getBoard();
    }
}
