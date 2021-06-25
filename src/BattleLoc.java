import java.util.Random;

public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;

    BattleLoc(Obstacle obstacle, Player player, String name, String award) {
        super(player);
        this.obstacle = obstacle;
        this.award = award;
        this.name = name;
    }

    @Override
    public boolean getLocationFeature(Player player) {
        Random r = new Random();
        int obstacleCounter = 1 + r.nextInt(3);
        System.out.println(obstacleCounter + " " + obstacle.getName() + "(s) here. Their damage is " + obstacle.getDamage());
        System.out.println("Are you gonna fight them all or escape? (1->Yes, 2->No)");
        int duelSelection = in.nextInt();
        if(duelSelection==1) {
            enterCombat(obstacleCounter);
        } else if (duelSelection==2) {
            return true;
        } else {
            System.out.println("You entered wrong input. Please try again...");
            duelSelection = in.nextInt();
        }
        return true;
    }

    public void enterCombat(int obstacleCount) {
        for (int i=0; i<obstacleCount; i++) {
            while(player.getHealth()>0 && obstacle.getHealth()>0) {
                if (whoIsFirst() == 1) {
                    obstacle.setHealth(obstacle.getHealth() - player.getDamage());
                    System.out.println("You hit " + player.getDamage());
                    player.setHealth(player.getHealth() - obstacle.getDamage());
                    System.out.println(obstacle.getName() + " hit you " + obstacle.getDamage());
                } else {
                    player.setHealth(player.getHealth() - obstacle.getDamage());
                    System.out.println(obstacle.getName() + " hit you " + obstacle.getDamage());
                    obstacle.setHealth(obstacle.getHealth() - player.getDamage());
                    System.out.println("You hit " + player.getDamage());
                }
            }
        }
        if (player.getHealth()<=0) {
            System.out.println("You lose");
            System.exit(0);
        } else if (obstacle.getHealth()<=0) {
            System.out.println("You won the fight and gain "+ obstacle.getAward()*obstacleCount + " coins.");
            player.setMoney(player.getMoney()+ obstacleCount*obstacle.getAward());
            if (this.award.equals("Food") && !player.getInventory().isFood()) {
                System.out.println("Congratulations, you won Food!");
                player.getInventory().setFood(true);
            } else if (this.award.equals("Water") && !player.getInventory().isWater()){
                System.out.println("Congratulations, you won Water!");
                player.getInventory().setWater(true);
            } else if (this.award.equals("Wood") && !player.getInventory().isWood()) {
                System.out.println("Congratulations, you won Wood!");
                player.getInventory().setWood(true);
            }
        }

    }

}
