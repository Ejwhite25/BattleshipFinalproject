import java.util.ArrayList;

public class Player {
    public Carrier carrier;
    Destroyer destroyer;
    Battleship battleship;
    Board board;
    Submarine submarine;
    ArrayList<String> ships = new ArrayList<String>(4);
    public Player(){
            ships.add("Carrier");
            ships.add("Destroyer");
            ships.add("Battleship");
            ships.add("Submarine");

    }

    public void setSubmarine(Submarine subSet){
        submarine = subSet;
    }
    public Submarine getSubmarine(){
        return submarine;
    }

    public void setBattleship(Battleship battleshipSet) {
        battleship = battleshipSet;
    }

    public Battleship getBattleship() {
        return battleship;
    }

    public void setCarrier(Carrier carrierSet) {
       carrier = carrierSet;

    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setDestroyer(Destroyer destroyerSet) {
       destroyer = destroyerSet;

    }

    public Destroyer getDestroyer() {
        return destroyer;
    }

    public void setBoard(Board boardSet){
        board = boardSet;
    }

    public Board getBoard(){
        return board;

    }

    public boolean testHit(Turn turn) {
            if(board.board1[turn.firstCoordinate][turn.secondCoordinate] == 1){
                board.board1[turn.firstCoordinate][turn.secondCoordinate] = 0;
                return true;
            }
            else{
                return false;
        }
    }



    boolean testShip(String ship,int row, int col){
        switch (ship){
            case "Battleship" -> {
                for (int[] ints : battleship.battleShipArray) {
                    for (int anInt : ints) {
                        return anInt == battleship.battleShipArray[row][col];
                    }
                }
            }
            case "Carrier" -> {
                for (int[] ints : carrier.carrierArray) {
                    for (int anInt : ints) {
                        return anInt == carrier.carrierArray[row][col];
                    }
                }
            }
            case "Submarine" -> {
                for (int[] ints : submarine.submarineArray) {
                    for (int anInt : ints) {
                        return anInt == submarine.submarineArray[row][col];
                    }
                }
            }
            case "Destroyer" -> {
                for (int[] ints : destroyer.destroyerArray) {
                    for (int anInt : ints) {
                        return anInt == destroyer.destroyerArray[row][col];
                    }
                }
            }
        }
        return false;
    }

    void markShipHit(int x, int y){
        for(String ship : ships){
            switch(ship){
                case "Carrier" -> {
                    if(carrier.testHit(1,x,y)){
                        carrier.carrierArray[x][y] = 0;
                        Server.player1shipHit = "Carrier";

                    }
                }

                case "Battleship" -> {
                    if(battleship.testHit(1,x,y)){
                        battleship.battleShipArray[x][y] = 0;
                        Server.player1shipHit="Battleship";
                    }

                }
                case "Destroyer" ->{
                    if(destroyer.testHit(1,x,y)){
                        destroyer.destroyerArray[x][y] = 0;
                        Server.player1shipHit="Destroyer";
                    }
                }
                case "Submarine" ->{
                    if(submarine.testHit(1,x,y)){
                        submarine.submarineArray[x][y] = 0;
                        Server.player1shipHit="Submarine";
                    }
                }

            }
        }
    }

}
