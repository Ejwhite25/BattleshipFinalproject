public class Turn {
    int playerId;
    int firstCoordinate;
    int secondCoordinate;
    Controller controller = Controller.returnController();

    public Turn(int id, int row, int col) {
        playerId = id;
        firstCoordinate = row;
        secondCoordinate = col;

    }
}

