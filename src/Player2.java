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

    boolean testShip(String ship,int row, int col){
        switch (ship){
            case "Battleship" -> {
                for (int[] ints : Controller.player2battleship.battleShipArray) {
                    for (int anInt : ints) {
                        return anInt == Controller.player2battleship.battleShipArray[row][col];
                    }
                }
            }
            case "Carrier" -> {
                for (int[] ints : Controller.player2carrier.carrierArray) {
                    for (int anInt : ints) {
                        return anInt == Controller.player2carrier.carrierArray[row][col];
                    }
                }
            }
            case "Submarine" -> {
                for (int[] ints : Controller.player2submarine.submarineArray) {
                    for (int anInt : ints) {
                        return anInt == Controller.player2submarine.submarineArray[row][col];
                    }
                }
            }
            case "Destroyer" -> {
                for (int[] ints : Controller.player2destroyer.destroyerArray) {
                    for (int anInt : ints) {
                        return anInt == Controller.player2destroyer.destroyerArray[row][col];
                    }
                }
            }
        }
        return false;
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
