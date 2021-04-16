public class Player2 {
    Carrier carrier;
    Destroyer destroyer;
    Battleship battleship;
    Submarine submarine;
    Board board;
    public Player2(){

    }

    public void setDestroyer(Destroyer destroyer) {
        this.destroyer = destroyer;
    }

    public void setSubmarine(Submarine submarine) {
        this.submarine = submarine;
    }

    public Submarine getSubmarine() {
        return submarine;
    }

    public Destroyer getDestroyer() {
        return destroyer;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setBattleship(Battleship battleship) {
        this.battleship = battleship;
    }

    public Battleship getBattleship() {
        return battleship;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
}
