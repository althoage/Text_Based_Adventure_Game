package RPGassignment;

import java.util.Random;

public class Player {
    private int playerHealth = 100;
    private int AttackDamage = 30;
    private int numHealthPotions = 3;
    final int CRITICAL_HIT_CHANCE = 15; //Percentage
   public void heal() {
       if (numHealthPotions > 0) {
           int healthPotionHealAmount = 25;
           playerHealth += healthPotionHealAmount;
           setPlayerHealth(playerHealth);
           numHealthPotions--;
           System.out.println("\t Health potion consumed. \t\nHealth: " + playerHealth);
           System.out.println("\tYou have " + numHealthPotions + " left.");
       } else {
           System.out.println("\t> You have no health potions left!");
       }
   }
   public boolean isDropped() {
       Random rand = new Random();
       //Percentage
       int healthPotionDropChance = 30;
       if(rand.nextInt(100) < healthPotionDropChance)
           return true;
       else {
           return false;
       }
   }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getAttackDamage() {
       if( isDropped()) {
           AttackDamage = AttackDamage * 3;
        } else {
       }
        return AttackDamage;
    }

    public int getNumHealthPotions() {
        return numHealthPotions;
    }

    public int getCRITICAL_HIT_CHANCE() {
        return CRITICAL_HIT_CHANCE;
    }
}
