import java.util.Arrays;
import java.util.TreeMap;
public class Board {
    public int[][] board1 = null;
    public int[][] board2;
    public Board() {
        board1 = new int[20][20];
        board2 = new int[20][20];
    }

    public void updateBoard(String type, int x, int y) {
        if (type.equals("hit")) {
            board2[x][y] = 1;
        } else if (type.equals("miss")) {
            board2[x][y] = '0';
        }
    }


    public boolean testHit(int x, int y) {
        if (board1[x][y] == 1) {
            board1[x][y] = 5;
            System.out.println("Its a hit!");
            return true;
        } else {
            System.out.println("It's a miss");
            return false;
        }
    }

}
