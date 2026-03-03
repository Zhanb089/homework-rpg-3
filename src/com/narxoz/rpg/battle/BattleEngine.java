package com.narxoz.rpg.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class BattleEngine {
    private static BattleEngine instance;
    private Random random = new Random(1L);

    private BattleEngine() {
    }

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public BattleEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public void reset() {
        // TODO: reset any battle state if you add it
    }

    public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB) {
    EncounterResult result = new EncounterResult();
    int round = 0;

    // Создаём копии списков, чтобы можно было удалять павших
    List<Combatant> attackers = new ArrayList<>(teamA);
    List<Combatant> defenders = new ArrayList<>(teamB);

        while (!attackers.isEmpty() && !defenders.isEmpty()) {
            round++;
            result.addLog("=== Round " + round + " ===");

            // Команда A атакует команду B
            for (int i = 0; i < attackers.size(); i++) {
                Combatant attacker = attackers.get(i);
                if (!attacker.isAlive()) continue;
                if (defenders.isEmpty()) break;

                // Цель выбирается случайно
                Combatant target = defenders.get(random.nextInt(defenders.size()));
                int damage = attacker.getAttackPower();
                target.takeDamage(damage);
                result.addLog(attacker.getName() + " hits " + target.getName() + " for " + damage + " damage.");

                // Проверяем, жив ли target
                if (!target.isAlive()) {
                    result.addLog(target.getName() + " has been defeated!");
                    defenders.remove(target);
                }
            }

            // Команда B атакует команду A
            for (int i = 0; i < defenders.size(); i++) {
                Combatant attacker = defenders.get(i);
                if (!attacker.isAlive()) continue;
                if (attackers.isEmpty()) break;

                Combatant target = attackers.get(random.nextInt(attackers.size()));
                int damage = attacker.getAttackPower();
                target.takeDamage(damage);
                result.addLog(attacker.getName() + " hits " + target.getName() + " for " + damage + " damage.");

                if (!target.isAlive()) {
                    result.addLog(target.getName() + " has been defeated!");
                    attackers.remove(target);
                }
            }
        }

        result.setRounds(round);
        if (attackers.isEmpty()) result.setWinner("Enemies");
        else result.setWinner("Heroes");

        return result;
    }
}
