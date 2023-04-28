package com.ch.combat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatCharacterTest {

    @Test
    void shouldReturnCorrectInitializedClass() {
        CombatCharacter testee = new CombatCharacter();

        assertEquals(1000, testee.getHealth());
        assertEquals(1, testee.getLevel());
        assertTrue(testee.isAlive());
    }

    @Test
    void healtOfCharacterShouldBeLoweredAfterDamage() {
        CombatCharacter testee = new CombatCharacter();
        CombatCharacter opponent = new CombatCharacter();
        testee.receivedDamage(100, opponent);
        assertEquals(900, testee.getHealth());
        testee.receivedDamage(200, opponent);
        assertEquals(700, testee.getHealth());
    }

    @Test
    void healtOfCharacterShouldNeverBeNegative() {
        CombatCharacter testee = new CombatCharacter();
        CombatCharacter opponent = new CombatCharacter();
        testee.receivedDamage(500, opponent);
        assertEquals(500, testee.getHealth());
        testee.receivedDamage(500, opponent);
        assertEquals(0, testee.getHealth());
        assertFalse(testee.isAlive());
    }

    @Test
    void deadCharacterShouldNotBeHealed() {
        CombatCharacter testee = new CombatCharacter();
        testee.setAlive(false);
        testee.setHealth(0);
        testee.heal(500);
        assertEquals(0, testee.getHealth());
        assertFalse(testee.isAlive());
    }

    @Test
    void characterShouldBeHealed() {
        CombatCharacter testee = new CombatCharacter();
        testee.setHealth(100);
        testee.heal(500);
        assertEquals(600, testee.getHealth());
        assertTrue(testee.isAlive());
    }

    @Test
    void characterHealthShouldNotExceed1000Points() {
        CombatCharacter testee = new CombatCharacter();
        testee.setHealth(800);
        testee.heal(500);
        assertEquals(1000, testee.getHealth());
        assertTrue(testee.isAlive());
    }
}