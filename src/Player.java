public class Player {
    private int id;
    private int damage;
    private int money;
    private int health;
    private Inventory inventory = new Inventory();

    public Player(int id) {
        this.id = id;
        switch (id) {
            case 1 -> {
                this.damage = 5;
                this.money = 15;
                this.health = 21;
            }
            case 2 -> {
                this.damage = 7;
                this.money = 20;
                this.health = 18;
            }
            case 3 -> {
                this.damage = 8;
                this.money = 5;
                this.health = 24;
            }
        }
    }
    public String toString() {
        String val = "Your stats are:";
        val += "\n\t Damage: " + getDamage();
        val += "\n\t Health: " + getHealth();
        val += "\n\t Money: " + getMoney();
        return val;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage + this.inventory.getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health+this.inventory.getArmor();
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
