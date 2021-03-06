import java.util.Scanner;
import java.util.Random;

public abstract class Location {
    Scanner in = new Scanner(System.in);
    protected Player player;
    protected String name;

    Location(Player player) {
        this.player = player;
    }

    public abstract boolean getLocationFeature(Player player);

    

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
