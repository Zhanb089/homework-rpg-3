package com.narxoz.rpg.combat;

public interface  Ability extends Cloneable {
    String getName();
    int getPower();
    String getDescription();
    Ability clone();
}
