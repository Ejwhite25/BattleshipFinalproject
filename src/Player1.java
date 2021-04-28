import java.util.ArrayList;

public class Player1 {
    Carrier carrier;
    Destroyer destroyer;
    Battleship battleship;
    Submarine submarine;
    Board board;
    ArrayList<String> shipsPlayer1 = new ArrayList<String>(4);
    public Player1(){
        shipsPlayer1.add("Carrier");
        shipsPlayer1.add("Destroyer");
        shipsPlayer1.add("Battleship");
        shipsPlayer1.add("Submarine");
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

    void markShipHit(int x, int y){
        for(String ship : shipsPlayer1){
            switch(ship){
                case "Carrier" -> {
                    if(Controller.player1carrier.testHit(1,x,y)){
                        Controller.player1carrier.carrierArray[x][y] = 0;

                    }
                }

                case "Battleship" -> {
                    if(Controller.player1battleship.testHit(1,x,y)){
                        Controller.player1battleship.battleShipArray[x][y] = 0;
                    }

                }
                case "Destroyer" ->{
                    if(Controller.player1destroyer.testHit(1,x,y)){
                        Controller.player1destroyer.destroyerArray[x][y] = 0;
                    }
                }
                case "Submarine" ->{
                    if(Controller.player1submarine.testHit(1,x,y)){
                        Controller.player1submarine.submarineArray[x][y] = 0;
                    }
                }

            }
        }
    }

}
