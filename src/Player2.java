public class Player2 {
    Carrier carrier;
    Destroyer destroyer;
    Battleship battleship;
    Submarine submarine;
    Board board;
    public Player2(){
       submarine = new Submarine();
       carrier = new Carrier();
       battleship = new Battleship();
       destroyer = new Destroyer();
       board = new Board();
    }
}