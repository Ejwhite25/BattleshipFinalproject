import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    Destroyer destroyer;
    Battleship battleship;
    Submarine submarine;
    Board board;
    int[][] board1;
    Turn turn;
    int playerId;
    boolean guiState;
    Carrier carrier;
    ArrayList<String> ships = new ArrayList<String>(4);
    public Player(int playerIdSet){
            board1 = new int[20][20];
            playerId = playerIdSet;
            board = new Board();
            turn = new Turn();
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

    public void setDestroyer(Destroyer destroyerSet) {
       destroyer = destroyerSet;

    }
    public void setCarrier(Carrier carrierSet){
        carrier = carrierSet;
    }

    public Carrier getCarrier(){
        return carrier;
    }

    public Destroyer getDestroyer() {
        return destroyer;
    }
    public Board getBoard(){
        return board;
    }

    public void setUp(){
        for (String ship : ships) {
            int x;
            int y;
            switch (ship) {
                case "Destroyer" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if (board.board1[x][y] == 0) {
                        Destroyer destroyer = new Destroyer(x, y);
                         setDestroyer(destroyer);
                         getDestroyer().createShip(playerId);
                    } else {
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);

                    }
                }
                case "Carrier" -> {
                    x = (int) (Math.random() * (9) + 1);
                    y = (int) (Math.random() * (9) + 1);
                    if (board.board1[x][y] == 0) {
                        Carrier carrier = new Carrier(x, y);
                        setCarrier(carrier);
                        getCarrier().createShip(playerId);
                    } else {
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);

                    }
                }
                case "Battleship" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if (board.board1[x][y] == 0) {
                        System.out.println("X:" + x);
                        System.out.println("Y:" + y);
                        Battleship battleship = new Battleship(x, y);
                        setBattleship(battleship);
                        getBattleship().createShip(playerId);
                    } else {
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);
                    }
                }
                case "Submarine" -> {
                    x = (int) (Math.random() * (9) + 0);
                    y = (int) (Math.random() * (9) + 0);
                    if (board.board1[x][y] == 0) {
                        System.out.println("X:" + x);
                        System.out.println("Y:" + y);
                        Submarine submarine = new Submarine(x, y);
                        setSubmarine(submarine);
                        getSubmarine().createShip(playerId);
                    } else {
                        x = (int) (Math.random() * (9) + 0);
                        y = (int) (Math.random() * (9) + 0);
                        System.out.println("Error checking...\n");
                    }

                }
            }
        }
    }

    public void printBoard(){
        System.out.println("Attempting to print");
        for(int x = 0; x < board.board1.length; x++) {
            for (int y =0; y < board.board1[x].length; y++){
              System.out.println(board.board1[x][y]);
            }
        }
    }

    public void displayBoard(GUIController guiController) {
        StringBuilder grid = new StringBuilder();
        StringBuilder grid1 = new StringBuilder();
        for(int x = 0; x < board.board1.length; x++) {
            grid.append(x);
            for (int y =0; y < board.board1[x].length; y++){
                grid.append("[").append(board.board1[x][y]).append("]");
                grid.append(" ");
            }
            grid.append("\n");
        }
        guiController.gui.board1Area.setText(String.valueOf(grid));
        for(int i =0; i < board.board2.length; i++){
            for(int j =0; j < board.board2.length; j++){
                grid1.append("[").append(board.board2[i][j]).append("]");
                grid.append(" ");
            }
            grid1.append("\n");
        }
        guiController.gui.board2Area.setText(String.valueOf(grid1));

    }





    public boolean testShip(String ship,int row, int col){
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
                /*case "Carrier" -> {
                    if(carrier.testHit(1,x,y)){
                        carrier.carrierArray[x][y] = 0;
                        Server.player1shipHit = "Carrier";

                    }
                }*/

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
