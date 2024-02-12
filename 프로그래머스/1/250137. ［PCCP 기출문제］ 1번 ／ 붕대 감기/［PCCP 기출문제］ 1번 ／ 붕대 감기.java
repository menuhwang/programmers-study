class Solution {
    private static int bandageTime;
    private static int bandageTickRecovery;
    private static int bandageBouseRecovery;
    
    private static int playerMaxHealth;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        playerMaxHealth = health;
            
        bandageTime = bandage[0];
        bandageTickRecovery = bandage[1];
        bandageBouseRecovery = bandage[2];
        
        int end = attacks[attacks.length - 1][0];
        
        Player player = new Player();
        
        int attackIdx = 0;
        for (int t = 0; t <= end; t++) {
            int[] attack = attacks[attackIdx];
            if (t == attack[0]) {
                player.takeDamage(attack[1]);
                attackIdx++;
            } else {
                player.useBandage();
            }
        }
        
        return player.getHealth();
    }
    
    static class Player {
        private int health;
        private int bandageTick;
        
        Player() {
            this.health = playerMaxHealth;
        }
        
        void useBandage() {
            if (isDead())
                return;
            
            health = Math.min(playerMaxHealth, health + bandageTickRecovery);
            bandageTick++;
            
            if (bandageTick == bandageTime) {
                health = Math.min(playerMaxHealth, health + bandageBouseRecovery);
                bandageTick = 0;
            }
        }
        
        void takeDamage(int damage) {
            if (isDead())
                return;
            
            bandageTick = 0;
            health = Math.max(0, health - damage);
        }
        
        int getHealth() {
            if (isDead())
                return -1;
            
            return health;
        }
        
        private boolean isDead() {
            return health <= 0;
        }
    }
}