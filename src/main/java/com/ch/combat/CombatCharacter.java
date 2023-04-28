package com.ch.combat;

public class CombatCharacter {
    private static final int MIN_LEVEL_DIFFERENCE_FOR_DAMAGE_REDUCTION = 5;
    private static final int DAMAGE_REDUCTION_FACTOR = 2;
    private final int MAX_POINTS = 1000;
    private int health;
    private int level;
    private boolean alive;

    public CombatCharacter() {
        this.health = 1000;
        this.level = 1;
        this.alive = true;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void receivedDamage(int damage, CombatCharacter actor) {
        if(actor==this){
            return;
        }
        int levelAdjustedDamage = getLevelAdjustedDamage(damage, actor);
        health = Math.max(health - levelAdjustedDamage, 0);
        alive = health > 0;
    }

    private int getLevelAdjustedDamage(int damage, CombatCharacter actor) {
        if (actor.getLevel() < this.getLevel()+ MIN_LEVEL_DIFFERENCE_FOR_DAMAGE_REDUCTION) {
            return damage;
        }
        return damage / DAMAGE_REDUCTION_FACTOR;
    }

    public void heal(int healthPoints, CombatCharacter actor) {
        if (actor != this) {
            return;
        }
        if (alive) {
            health = Math.min(health + healthPoints, MAX_POINTS);
        }
    }
}
