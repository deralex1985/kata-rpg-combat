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
        testee.receivedDamage(100);
        assertEquals(900, testee.getHealth());
        testee.receivedDamage(200);
        assertEquals(700, testee.getHealth());
    }

    @Test
    void healtOfCharacterShouldNeverBeNegative() {
        CombatCharacter testee = new CombatCharacter();
        testee.receivedDamage(500);
        assertEquals(500, testee.getHealth());
        testee.receivedDamage(500);
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
}