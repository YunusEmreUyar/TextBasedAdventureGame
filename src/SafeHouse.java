public class SafeHouse extends NormalLoc{

    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean getLocationFeature(Player player) {
        if (player.getId() == 1) {
            player.setHealth(21);
        } else if (player.getId()==2) {
            player.setHealth(18);
        } else {
            player.setHealth(24);
        }
        System.out.println("Your Hp is full now.");
        return true;
    }

}
