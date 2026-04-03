package com.narxoz.rpg.battle;

public final class BattleEngine {
    
    private static BattleEngine instance;

    private BattleEngine() {}

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public void fight(Combatant a, Combatant b) {
        System.out.println("Battle Start: " + a.getName() + " vs " + b.getName());
        
        while (a.isAlive() && b.isAlive()) {
            b.takeDamage(a.attack());
            System.out.println(a.getName() + " hits " + b.getName() + " | HP: " + b.getHealth());

            if (!b.isAlive()) break;

            a.takeDamage(b.attack());
            System.out.println(b.getName() + " hits " + a.getName() + " | HP: " + a.getHealth());
        }

        System.out.println("Winner: " + (a.isAlive() ? a.getName() : b.getName()));
    }
}