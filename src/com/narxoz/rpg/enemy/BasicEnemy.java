package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class BasicEnemy implements Enemy {
    private String name;
    private int health;
    private int damage;
    private List<Ability> abilities;
    private LootTable lootTable;
    private String aiBehavior;

    public BasicEnemy(String name,
                      int health,
                      int damage,
                      List<Ability> abilities,
                      LootTable lootTable,
                      String aiBehavior) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public int getHealth() { return health; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public List<Ability> getAbilities() { return abilities; }

    @Override
    public LootTable getLootTable() { return lootTable; }

    @Override
    public String getAIBehavior() { return aiBehavior; }

    @Override
    public void multiplyStats(double multiplier) {
        health = (int)(health * multiplier);
        damage = (int)(damage * multiplier);
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability ability : abilities) {
            clonedAbilities.add(ability.clone());
        }

        return new BasicEnemy(
                name,
                health,
                damage,
                clonedAbilities,
                lootTable != null ? lootTable.clone() : null,
                aiBehavior
        );
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Enemy: " + name + " ===");
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Abilities: " + abilities.size());
        System.out.println("AI: " + aiBehavior);
        System.out.println();
    }
}
