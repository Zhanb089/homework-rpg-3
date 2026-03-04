package com.narxoz.rpg.combat;

public interface  Ability extends Clonable {
    String getName();
    int getPower();
    String getDescription();
    Ability clone();
}
