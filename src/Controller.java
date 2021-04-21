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
        this.player1 = new Player1();
        this.player2 = new Player2();
        this.player1battleship = player1.getBattleship();
        this.player2battleship = player2.getBattleship();
        this.player1destroyer = player1.getDestroyer();
        this.player1destroyer = player2.getDestroyer();
        this.player1submarine = player1.getSubmarine();
        this.player2submarine = player2.getSubmarine();
        this.player1carrier = player1.getCarrier();
        this.player2carrier = player2.getCarrier();
        this.player1board = player1.getBoard();
        this.player2board = player2.getBoard();
    }
}
