package com.narxoz.rpg.herofactory;

import com.narxoz.rpg.hero.Hero;
import com.narxoz.rpg.hero.Mage;

public class MageFactory implements HeroFactory{
    @Override
    public Hero createHero(String name) {
        return new Mage(name);
    }
}
