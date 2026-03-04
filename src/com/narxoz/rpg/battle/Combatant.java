package com.narxoz.rpg.battle;

public interface Combatant {
    String getName();

    int attack();

    void takeDamage(int damage);

    boolean isAlive();

    int getHealth();
}
