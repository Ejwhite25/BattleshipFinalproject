public class Player1 {
    Carrier carrier;
    Destroyer destroyer;
    Battleship battleship;
    Submarine submarine;
    Board board;
    public Player1(){

    }

    public void setSubmarine(Submarine subSet){

        this.submarine = subSet;
    }
    public Submarine getSubmarine(){
        return this.submarine;
    }

    public void setBattleship(Battleship battleshipSet) {
        this.battleship = battleshipSet;
    }

    public Battleship getBattleship() {
        return battleship;
    }

    public void setCarrier(Carrier carrierSet) {
       this.carrier = carrierSet;

    }

    public Carrier getCarrier() {
        return this.carrier;
    }

    public void setDestroyer(Destroyer destroyer) {
        this.destroyer = destroyer;
    }

    public Destroyer getDestroyer() {
        return destroyer;
    }
    public void setBoard(Board board){
        this.board = board;
    }
    public Board getBoard(){
        return board;
    }
}
