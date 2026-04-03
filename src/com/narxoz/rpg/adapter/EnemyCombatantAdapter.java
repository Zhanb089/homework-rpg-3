package com.narxoz.rpg.adapter;

import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.enemy.Enemy;

public class EnemyCombatantAdapter implements Combatant {
    
    private final Enemy enemy;
    private int currentHealth;

    public EnemyCombatantAdapter(Enemy enemy) {
        this.enemy = enemy;
        this.currentHealth = enemy.getHealth();
    }

    @Override
    public String getName() {
        return enemy.getName();
    }

    @Override
    public int attack() {
        return enemy.getDamage();
    }

    @Override
    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }

    @Override
    public int getHealth() {
        return currentHealth;
    }
}
