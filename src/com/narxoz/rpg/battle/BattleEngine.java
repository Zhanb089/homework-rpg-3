package com.narxoz.rpg.battle;

public final class BattleEngine {
    public void fight(Combatant a, Combatant b) {

        System.out.println("Battle: " + a.getName() + " vs " + b.getName());
        System.out.println();

        while (a.isAlive() && b.isAlive()) {

            b.takeDamage(a.attack());
            System.out.println(a.getName() + " hits " + b.getName()
                    + " | " + b.getName() + " HP: " + b.getHealth());

            if (!b.isAlive()) break;

            a.takeDamage(b.attack());
            System.out.println(b.getName() + " hits " + a.getName()
                    + " | " + a.getName() + " HP: " + a.getHealth());

            System.out.println();
        }

        System.out.println("Winner: " +
                (a.isAlive() ? a.getName() : b.getName()));
    }
}
