public class Controller {
    Player player1;
    Player player2;
    static boolean state = true;
    private static Controller controller = new Controller();

    private Controller(){
        player1 = new Player();
        player2 = new Player();

    }
    public static Controller returnController(){
        return controller;
    }


}
