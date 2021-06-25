public class Inventory {
    private int damage, armor;
    private boolean wood, water, food;

    public Inventory() {
        this.food = false;
        this.wood = false;
        this.water = false;
        this.damage = 0;
        this.armor = 0;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean hasGotEveryItem() {
        return this.water && this.wood && this.food;
    }
}
