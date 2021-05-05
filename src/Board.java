import java.util.TreeMap;
public class Board {
    public int[][] board1;
    public int[][] board2;



    public Board(){
        board1 = new int[20][20];
        board2 = new int[20][20];
    }

    public void updateBoard(String type,int x , int y){
        if(type.equals("hit")){
            board2[x][y] = 1;
        }
        else if(type.equals("miss")){
            board2[x][y] = '0';
        }
    }

    public void createShip(int x,int y){
        int row = x;
        int col = y;
        for(int i =col; i < col + 4; i++){
            board1[row][i-1] = 1;
        }
        System.out.println("X:" + x);
        System.out.println("Y:" + y);
    }

    public boolean testHit(int x, int y){
        if(board1[x][y] == 1){
            board1[x][y] = 5;
            System.out.println("Its a hit!");
            return true;
        }
        else{
            System.out.println("It's a miss");
            return false;
        }
    }


    public void displayBoard(GUIController guiController) {
        StringBuilder grid = new StringBuilder();
        StringBuilder grid1 = new StringBuilder();
        for(int x = 0; x < board1.length; x++) {
            grid.append(x);
            for (int y =0; y < board1[x].length; y++){
                grid.append(y);
                grid.append("[").append(board1[x][y]).append("]");
                grid.append(" ");
            }
            grid.append("\n");
        }
        guiController.gui.board1Area.setText(String.valueOf(grid));
        for(int i =0; i < board2.length; i++){
            for(int j =0; j < board2[i].length; j++){
                grid1.append("[").append(board2[i][j]).append("]");
                grid.append(" ");
            }
            grid1.append("\n");
        }
        guiController.gui.board2Area.setText(String.valueOf(grid1));

    }

}
