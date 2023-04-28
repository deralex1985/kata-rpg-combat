package com.ch.combat;

public class CombatCharacter {

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

    public void receivedDamage(int damage) {
        if (damage >= health) {
            health = 0;
            alive = false;
        } else {
            health -= damage;
        }
    }

    public void heal(int healthPoints) {
        health = Math.min(health+healthPoints, MAX_POINTS);
    }
}
