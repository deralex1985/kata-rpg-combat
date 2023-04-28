package com.ch.combat;

public class CombatCharacter {
    private int health;
    private int level;
    private boolean alive;

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

    public CombatCharacter() {
        this.health = 1000;
        this.level = 1;
        this.alive = true;
    }

    public void receivedDamage(int damage){
        health = 900;
    }
}
