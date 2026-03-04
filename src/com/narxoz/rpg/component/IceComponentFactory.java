package com.narxoz.rpg.component;

import java.util.List;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.IceAbility;
import com.narxoz.rpg.loot.IceLootTable;
import com.narxoz.rpg.loot.LootTable;

public class IceComponentFactory implements EnemyComponentFactory{
    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new IceAbility("Frost Nova", 100),
                new IceAbility("Blizzard", 180)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new IceLootTable();
    }

    @Override
    public String createAIBehavior() {
        return "Defensive Ice AI";
    }
}
