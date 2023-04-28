package com.ch.combat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatCharacterTest {

    @Test
    void shouldReturnCorrectInitializedClass() {
        Melee testee = new Melee();

        assertEquals(1000, testee.getHealth());
        assertEquals(1, testee.getLevel());
        assertTrue(testee.isAlive());
    }

    @Test
    void healtOfCharacterShouldBeLoweredAfterDamage() {
        Melee testee = new Melee();
        Melee opponent = new Melee();
        testee.receivedDamage(100, opponent, 0);
        assertEquals(900, testee.getHealth());
        testee.receivedDamage(200, opponent, 0);
        assertEquals(700, testee.getHealth());
    }

    @Test
    void healtOfCharacterShouldNeverBeNegative() {
        Melee testee = new Melee();
        Melee opponent = new Melee();
        testee.receivedDamage(500, opponent, 0);
        assertEquals(500, testee.getHealth());
        testee.receivedDamage(500, opponent, 0);
        assertEquals(0, testee.getHealth());
        assertFalse(testee.isAlive());
    }

    @Test
    void charachterShouldNotBeAbleToDamageItself() {
        Melee testee = new Melee();
        testee.receivedDamage(2000, testee, 0);
        assertEquals(1000, testee.getHealth());
        assertTrue(testee.isAlive());
    }

    @Test
    void deadCharacterShouldNotBeHealed() {
        Melee testee = new Melee();
        testee.setAlive(false);
        testee.setHealth(0);
        testee.heal(500, testee);
        assertEquals(0, testee.getHealth());
        assertFalse(testee.isAlive());
    }

    @Test
    void characterShouldBeHealedIfSelf() {
        Melee testee = new Melee();
        testee.setHealth(100);
        testee.heal(500, testee);
        assertEquals(600, testee.getHealth());
        assertTrue(testee.isAlive());
    }

    @Test
    void characterShouldNotBeHealedByOthers() {
        Melee testee = new Melee();
        Melee opponent = new Melee();
        testee.setHealth(100);
        testee.heal(500, opponent);
        assertEquals(100, testee.getHealth());
        assertTrue(testee.isAlive());
    }

    @Test
    void characterHealthShouldNotExceed1000Points() {
        Melee testee = new Melee();
        testee.setHealth(800);
        testee.heal(500, testee);
        assertEquals(1000, testee.getHealth());
        assertTrue(testee.isAlive());
    }

    @Test
    void ifAttackerIs5LevelsHigherDamageEffectShouldBeReducedBy50Percent() {
        Melee testee = new Melee();
        Melee opponent = new Melee();
        opponent.setLevel(6);
        testee.receivedDamage(500, opponent, 0);
        assertEquals(750, testee.getHealth());
    }

    @Test
    void ifAttackerIs5LevelsLowerDamageEffectShouldBeIncreasedBy50Percent() {
        Melee testee = new Melee();
        Melee opponent = new Melee();
        testee.setLevel(6);
        testee.receivedDamage(200, opponent, 0);
        assertEquals(700, testee.getHealth());
    }

    @Test
    void ifAttackIsOutOfRangeForMeleeNoDamageIsApplied() {
        Melee testee = new Melee();
        Melee opponent = new Melee();
        testee.receivedDamage(200, opponent, 5);
        assertEquals(1000, testee.getHealth());
    }

    @Test
    void ifAttackIsOutOfRangeForRangedNoDamageIsApplied() {
        Melee testee = new Melee();
        Ranged opponent = new Ranged();
        testee.receivedDamage(200, opponent, 21);
        assertEquals(1000, testee.getHealth());
    }

    @Test
    void ifAttackIsExactRangeOfRangeCharacterDamageIsApplied() {
        Melee testee = new Melee();
        Ranged opponent = new Ranged();
        testee.receivedDamage(200, opponent, 20);
        assertEquals(800, testee.getHealth());
    }
}