package com.narxoz.rpg.HeroFactory;

import com.narxoz.rpg.hero.Hero;
import com.narxoz.rpg.hero.Warrior;

public class WarriorFactory implements heroFactory{

    @Override
    public Hero createHero(String name) {
        return new Warrior(name);
    }
    
}
