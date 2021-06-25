import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    int charSelection, locationSelection;
    boolean running = true;

    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the adventure game.");
        System.out.println("1- Samurai: Damage: 5, Health: 21, Money: 15");
        System.out.println("2- Archer: Damage: 7, Health: 18, Money: 20");
        System.out.println("3- Chivalry: Damage: 8, Health: 24, Money: 5");
        System.out.print("Please select your character: ");
        charSelection = in.nextInt();
        player = new Player(charSelection);
        System.out.println();
        System.out.println(player.toString());
        System.out.println();
        while (running) {
            System.out.println();
            System.out.println("Where you want to go?");
            System.out.println("1- Cave\n2- Forest\n3-River\n4-Store\n5-Safehouse");
            locationSelection = in.nextInt();
            if(locationSelection<1 || locationSelection>5) {
                System.out.print("Please enter valid number: ");
                locationSelection=in.nextInt();
            }
            switch (locationSelection) {
                case 1 -> {
                    if (!player.getInventory().isFood()){
                        location = new Cave(player);
                    }else {
                        System.out.println("You already cleared the Cave.");
                    }
                }
                case 2 -> {
                    if (!player.getInventory().isWater()){
                        location = new River(player);
                    }else {
                        System.out.println("You already cleared the River.");
                    }
                }
                case 3 -> {
                    if (!player.getInventory().isWood()){
                        location = new Forest(player);
                    }else {
                        System.out.println("You already cleared the Forest.");
                    }
                }
                case 4 -> {
                    location = new Store(player);
                }
                default -> {
                    location = new SafeHouse(player);
                    if(player.getInventory().hasGotEveryItem()) {
                        running = false;
                        System.out.println("You collected all items!");
                        System.out.println("You won the game!!!");
                    }
                }
            }
            location.getLocationFeature(player);

        }
        in.close();
    }
}
