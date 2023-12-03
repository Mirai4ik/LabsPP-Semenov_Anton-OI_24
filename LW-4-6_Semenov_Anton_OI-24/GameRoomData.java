import java.io.Serializable;
import java.util.List;

public class GameRoomData implements Serializable {
    List<Toy> toys;
    double balance;

    public GameRoomData(List<Toy> toys, double balance) {
        this.toys = toys;
        this.balance = balance;
    }
}
