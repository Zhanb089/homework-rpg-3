package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class Goblin extends BasicEnemy {
    public Goblin(String name,
                  int health,
                  int damage,
                  List<Ability> abilities,
                  LootTable lootTable,
                  String aiBehavior) {
        super(name, health, damage, abilities, lootTable, aiBehavior);
    }
}
