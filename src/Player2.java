import java.util.ArrayList;

public class Player2 {
    Carrier carrier;
    Destroyer destroyer;
    Battleship battleship;
    Submarine submarine;
    Board board;
    ArrayList<String> shipsPlayer2 = new ArrayList<String>(4);
    public Player2(){
        shipsPlayer2.add("Carrier");
        shipsPlayer2.add("Destroyer");
        shipsPlayer2.add("Battleship");
        shipsPlayer2.add("Submarine");

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
    
    void markShipHit(int x, int y){
        ArrayList<String> ships = new ArrayList<String>(4);
        ships.add("Carrier");
        ships.add("Destroyer");
        ships.add("Battleship");
        ships.add("Submarine");
        for(String ship : ships){
            switch(ship){
                case "Carrier" -> {
                    if(Controller.player2carrier.testHit(2,x,y)){
                        Controller.player2carrier.carrierArray[x][y] = '\0';
                    }
                }

                case "Battleship" -> {
                    if(Controller.player2battleship.testHit(2,x,y)){
                        Controller.player2battleship.battleShipArray[x][y] = '\0';
                    }

                }
                case "Destroyer" ->{
                    if(Controller.player2destroyer.testHit(2,x,y)){
                        Controller.player2destroyer.destroyerArray[x][y] ='\0';
                    }
                }
                case "Submarine" ->{
                    if(Controller.player2submarine.testHit(2,x,y)){
                        Controller.player2submarine.submarineArray[x][y] = '\0';
                    }
                }

            }
        }
    }
}
