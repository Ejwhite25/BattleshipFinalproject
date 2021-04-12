public class Board {
    public int[][] board;
    public int[][] board2;
    public Board(){
          board = new int[14][14];
          board2 = new int[14][14];
    }
    public void constructBoard(String shipType,int playerId){
                Carrier carrier = new Carrier();
                Carrier player2carrier = new Carrier();
            switch(shipType){
                case "Carrier":
                    if(playerId == 1) {

                    }

            }
    }

    public void displayBoard(){
        for(int x =0; x < board.length; x++){
            for(int y = 0; x < board[x].length; y++){
                System.out.print(board[x][y]+" ");
            }
        }
    }
    public void updateBoard(int x, int y ){
        board[x][y] = '\0';
    }
}
