public class Controller {
    Player player1;
    Player player2;
    static boolean state = true;
    static Controller controller = new Controller();

    private Controller(){
        this.player1 = new Player();
        this.player2 = new Player();


    }
    public static Controller returnController(){
        return controller;
    }


}
