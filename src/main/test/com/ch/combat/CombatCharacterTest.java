package com.ch.combat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    }
}