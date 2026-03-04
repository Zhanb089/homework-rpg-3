package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class IceLootTable implements LootTable{
     private final List<String> drops = Arrays.asList(
            "Frost Blade", "Ice Shield", "Frozen Core"
    );

    @Override
    public List<String> getDrops() {
        return drops;
    }

    @Override
    public LootTable clone() {
        return new IceLootTable();
    }
}
