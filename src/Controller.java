public class Controller {
    Player player1;
    Player player2;
    static boolean state = true;
    static boolean state1 = true;
    static Controller controller = new Controller();

    private Controller(){
        this.player1 = new Player(1);
        this.player2 = new Player(2);


    }
    public static Controller returnController(){
        return controller;
    }


}
