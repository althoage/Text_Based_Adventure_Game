package RPGassignment;
//For My project I made a text-based fighting game with multiple classes.

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        //Enemy creator!
        Enemies[] enemyArray;
        enemyArray = new Enemies[3];
        enemyArray[0]= new Enemies("Dragon", 200, 50);
        enemyArray[1] = new Enemies("Assassin", 50, 30);
        enemyArray[2] = new Enemies("Goblin", 30,15);
        Player p = new Player();

        final int MAX_POTIONS = 6;





        int healthPotions = p.getNumHealthPotions();

        System.out.println("Welcome to the dungeon");

        GAME:
        while(true) {
            System.out.println("-----------------------------------------");
            //Randomize enemies that spawn in
            int rnd = new Random().nextInt(enemyArray.length);
            int enemyHealth = enemyArray[rnd].getMaxEnemyHealth();


            System.out.println("\t# A(n) " + enemyArray[rnd].getName() + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour Health: " + p.getPlayerHealth());
                System.out.println("\t" + enemyArray[rnd].getName() + "'s Health: " + enemyHealth);
                System.out.println("What would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = scan.nextLine();

                if (input.equals("1")) {

                    int damageDealt = rand.nextInt(p.getAttackDamage());
                    int damageTaken = rand.nextInt(enemyArray[rnd].getEnemyAttackDamage());
                    if(rand.nextInt(100) < p.getCRITICAL_HIT_CHANCE()) {
                        damageDealt = damageDealt *3;
                        System.out.println("\t> Critical hit!!");
                    }

                    enemyHealth -= damageDealt;
                    p.setPlayerHealth(p.getPlayerHealth()-damageTaken);
                    boolean overPowered = (enemyHealth < 1);

                    System.out.println("\t> You strike the " + enemyArray[rnd].getName() + " for " + damageDealt + " damage.");
                    if (overPowered) {
                        p.setPlayerHealth(p.getPlayerHealth() + damageTaken);
                        System.out.println("\t No damage taken!");
                    } else {
                        System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                    }
                    if (p.getPlayerHealth() < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;

                    }
                } else if (input.equals("2")) {
                    p.heal();
                } else if (input.equals("3")) {
                    System.out.println("\t You run away from the " + enemyArray[rnd].getName() + "!");
                    continue GAME;
                } else {
                    System.out.println("Invalid command.");
                }
            }
            if (p.getPlayerHealth() < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("-------------------------------------");
            System.out.println("# The " + enemyArray[rnd].getName() + " was defeated! #");
            System.out.println("#You have " + p.getPlayerHealth() + " health left.#");
            if(p.isDropped()) {
                System.out.println("# The " + enemyArray[rnd].getName() + " dropped a health potion! #");
                if (healthPotions < MAX_POTIONS) {
                    healthPotions++;
                } else {
                    System.out.println("Max potions have been reached!");
                }

                System.out.println("# You now have " + healthPotions + " health potion(s). #");

            }
            System.out.println("-------------------------------------");
            System.out.println("What would you like to do next?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input1 = scan.nextLine();

            while(!input1.equals("1") && !input1.equals("2")) {
                System.out.println("Invalid command!");
                input1 = scan.nextLine();
            }
            if (input1.equals("1")) {
                System.out.println("You continue on your adventure...");
            } else {
                System.out.println("You exit the dungeon, successful from your adventures.");
                break;
            }

        }
        System.out.println("##################");
        System.out.println("Thanks for playing!");
        System.out.println("##################");


    }
}
