package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface Enemy {
    String getName();
    void setName(String name);

    int getHealth();
    int getDamage();

    void multiplyStats(double multiplier);

    List<Ability> getAbilities();
    LootTable getLootTable();
    String getAIBehavior();

    void displayInfo();

    Enemy clone();
}
