public abstract class NormalLoc extends Location{
    protected String name;

    NormalLoc(Player player, String name) {
        super(player);
        this.name = name;
    }
}
