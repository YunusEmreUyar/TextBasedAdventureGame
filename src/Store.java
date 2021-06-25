public class Store extends NormalLoc{

    Store(Player player){
        super(player, "Store");

    }

    @Override
    public boolean getLocationFeature(Player player) {
        System.out.println("Your money: " + player.getMoney());
        System.out.println("1->Weapon\n2->Armor\n3->Exit");
        int storeSelection = in.nextInt();
        switch (storeSelection) {
            case 1 -> {
                buyWeapon();
            }
            case 2 -> {
                buyArmor();
            }
            default -> {
                System.out.println("Thanks for visiting.");
            }
        }

        return true;
    }
    public void buyWeapon() {
        System.out.println("1-> Sword: damage: 2 cost: 25");
        System.out.println("2-> Bow: damage: 4 cost: 35");
        System.out.println("3-> Double daggers: damage: 7 cost: 45");
        int weaponSelection = in.nextInt();

        switch (weaponSelection) {
            case 1 -> {
                if (player.getMoney()>= 25) {
                    player.getInventory().setDamage(2);
                    player.setMoney(player.getMoney()-25);
                } else {
                    System.out.println("Money not enough.");
                }
            }
            case 2 -> {
                if (player.getMoney()>= 35) {
                    player.getInventory().setDamage(4);
                    player.setMoney(player.getMoney()-35);
                } else {
                    System.out.println("Money not enough.");
                }
            }
            case 3 -> {
                if (player.getMoney()>= 45) {
                    player.getInventory().setDamage(7);
                    player.setMoney(player.getMoney()-45);
                } else {
                    System.out.println("Money not enough.");
                }
            }
            default -> {
                System.out.println("Thanks for visiting.");
            }
        }


    }
    public void buyArmor() {
        System.out.println("1-> Light: damage: 1 cost: 25");
        System.out.println("2-> Medium: damage: 3 cost: 35");
        System.out.println("3-> Heavy: damage: 5 cost: 45");
        int armorSelection = in.nextInt();
        switch (armorSelection) {
            case 1 -> {
                if (player.getMoney()>= 25) {
                    player.getInventory().setArmor(1);
                    player.setMoney(player.getMoney()-45);
                } else {
                    System.out.println("Money not enough.");
                }
            }
            case 2 -> {
                if (player.getMoney()>= 35) {
                    player.getInventory().setArmor(3);
                    player.setMoney(player.getMoney()-35);
                } else {
                    System.out.println("Money not enough.");
                }
            }
            case 3 -> {
                if (player.getMoney()>= 45) {
                    player.getInventory().setArmor(5);
                    player.setMoney(player.getMoney()-45);
                } else {
                    System.out.println("Money not enough.");
                }
            }
            default -> {
                System.out.println("Thanks for visiting.");
            }
        }
    }
}
