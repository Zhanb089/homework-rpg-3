package com.narxoz.rpg.loot;

import java.util.List;

public interface LootTable extends Cloneable{
    List<String> getDrops();
    LootTable clone();
}
