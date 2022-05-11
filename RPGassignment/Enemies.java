package RPGassignment;
public class Enemies {
    private String name;
    private int maxEnemyHealth;
    private int enemyAttackDamage;

    public Enemies(String newName, int newMaxEnemyHealth, int newEnemyAttackDamage) {

        name = newName;
        maxEnemyHealth =newMaxEnemyHealth;
        enemyAttackDamage = newEnemyAttackDamage;
    }
    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public String getName() {
        return name;
    }
}

