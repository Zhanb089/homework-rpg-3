package com.narxoz.rpg;

import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.adapter.HeroCombatantAdapter;
import com.narxoz.rpg.battle.BattleEngine;
import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.component.IceComponentFactory;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.hero.Hero;
import com.narxoz.rpg.herofactory.HeroFactory;
import com.narxoz.rpg.herofactory.MageFactory;
import com.narxoz.rpg.herofactory.WarriorFactory;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Battle Engine Demo ===");

        IceComponentFactory iceFactory = new IceComponentFactory();
        List<Ability> iceAbilities = iceFactory.createAbilities();
        LootTable iceLoot = iceFactory.createLootTable();

        // Создаём героев через фактори
        HeroFactory mageFactory = new MageFactory();
        Hero mage = mageFactory.createHero("Jaina");

        HeroFactory warriorFactory = new WarriorFactory();
        Hero warrior = warriorFactory.createHero("Arthas");

        // Создаём врагов
        Enemy goblin = new BasicEnemyBuilder()
                .setName("Forest Goblin")
                .setHealth(200)
                .setDamage(50)
                .addAbility(iceAbilities.get(0))
                .setLootTable(iceLoot)
                .setAI("Cautious")
                .build();

        Enemy goblinClone = goblin.clone();
        goblinClone.setName("Goblin Raider");
        goblinClone.multiplyStats(1.5);

        HeroCombatantAdapter heroAdapter = new HeroCombatantAdapter(warrior);
        EnemyCombatantAdapter enemyAdapter = new EnemyCombatantAdapter(goblin);

        BattleEngine engine = new BattleEngine();
        engine.fight(heroAdapter,enemyAdapter);

        System.out.println("=== Demo Complete ===");
    }
}