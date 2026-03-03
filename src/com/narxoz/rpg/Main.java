package com.narxoz.rpg;

import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.adapter.HeroCombatantAdapter;
import com.narxoz.rpg.battle.BattleEngine;
import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.battle.EncounterResult;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.hero.Mage;
import com.narxoz.rpg.hero.Warrior;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Battle Engine Demo ===");

        // Создаём героев
        Warrior warrior = new Warrior("Arthas");
        Mage mage = new Mage("Jaina");

        // Создаём врагов
        Goblin goblin1 = new Goblin();
        Goblin goblin2 = new Goblin();

        // Оборачиваем в Adapter
        List<Combatant> heroes = new ArrayList<>();
        heroes.add(new HeroCombatantAdapter(warrior));
        heroes.add(new HeroCombatantAdapter(mage));

        List<Combatant> enemies = new ArrayList<>();
        enemies.add(new EnemyCombatantAdapter(goblin1));
        enemies.add(new EnemyCombatantAdapter(goblin2));

        // Проверяем Singleton BattleEngine
        BattleEngine engineA = BattleEngine.getInstance();
        BattleEngine engineB = BattleEngine.getInstance();
        System.out.println("Same BattleEngine instance? " + (engineA == engineB));
        System.out.println();

        // Устанавливаем фиксированное семя для предсказуемости
        engineA.setRandomSeed(42L);

        // Запускаем битву
        EncounterResult result = engineA.runEncounter(heroes, enemies);

        // Вывод результатов
        System.out.println("=== Battle Summary ===");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Battle Log:");
        for (String line : result.getBattleLog()) {
            System.out.println(line);
        }

        System.out.println("=== Demo Complete ===");
    }
}