/**
 * 
 */
package code.challenge.empire.army.cadre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.challenge.empire.army.ChineseOrder;
import code.challenge.empire.army.ChineseRank;
import code.challenge.empire.army.stable.animal.Horse;
import code.challenge.empire.army.stable.animal.StableMaster;
import code.challenge.empire.army.stable.animal.StandardHorse;
import code.challenge.empire.army.stable.animal.StandardStableMaster;

/**
 * @author Chuck
 *
 */
public class FlyingRainOfFireMemberTest {

    FlyingRainOfFireMember frofMember = new FlyingRainOfFireMember(ChineseRank.CONSCRIPT);

    @Test
    public void testGetRankEquals() {
        assertEquals(ChineseRank.CONSCRIPT, frofMember.getRank());
    }

    @Test
    public void testGetRankNotSame() {
        assertNotSame(ChineseRank.EMPEROR, frofMember.getRank());
    }

    @Test
    public void testKnowsHorse() {
        StableMaster stableMaster = new StandardStableMaster();
        Horse horse = new StandardHorse();
        stableMaster.assignHorse(horse, frofMember);
        assertEquals(frofMember.getHorse(), horse);
        assertEquals(horse.getOwner(), frofMember);
    }

    @Test
    public void testGetNumberOfRemainingArrowsEmpty() {
        // always empty, there are no arrows to be found and no way to pick them
        // up! Let alone, nothing to shoot them with.
        assertEquals(frofMember.getNumberOfRemainingArrows(), 0);
    }

    @Test
    public void testEmperorOrderedFightToTheDeath() {
        Boolean foughtToTheDeath = frofMember.takeOrder(ChineseOrder.FIGHT_TO_THE_DEATH, ChineseRank.EMPEROR);
        assertTrue(foughtToTheDeath);
    }

    @Test
    public void testLiutenantOrderedFightToTheDeath() {
        Boolean foughtToTheDeath = frofMember.takeOrder(ChineseOrder.FIGHT_TO_THE_DEATH, ChineseRank.CONSCRIPT);
        assertFalse(foughtToTheDeath);
    }

    @Test
    public void testEmperorOrderedShootDistantFoe() {
        Boolean shotAtDistantFoe = frofMember.takeOrder(ChineseOrder.SHOOT_DISTANT_FOE, ChineseRank.EMPEROR);
        assertTrue(shotAtDistantFoe);
    }

    @Test
    public void testCaptainOrderedShootDistantFoe() {
        Boolean shotAtDistantFoe = frofMember.takeOrder(ChineseOrder.SHOOT_DISTANT_FOE, ChineseRank.RECRUIT);
        assertFalse(shotAtDistantFoe);
    }

    @Test
    public void testEmperorOrderedTrampleEnemiesInPath() {
        Boolean trampledEnemiesInPath = frofMember.takeOrder(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, ChineseRank.EMPEROR);
        assertTrue(trampledEnemiesInPath);
    }

    @Test
    public void testSargentOrderedTrampleEnemiesInPath() {
        Boolean trampledEnemiesInPath = frofMember.takeOrder(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH,
                ChineseRank.CONSCRIPT);
        assertFalse(trampledEnemiesInPath);
    }

    @Test
    public void testEmperorOrderedLeadTheCharge() {
        Boolean leadTheCharge = frofMember.takeOrder(ChineseOrder.LEAD_THE_CHARGE, ChineseRank.EMPEROR);
        assertTrue(leadTheCharge);
    }

    @Test
    public void testMajorOrderedLeadTheCharge() {
        Boolean leadTheCharge = frofMember.takeOrder(ChineseOrder.LEAD_THE_CHARGE, ChineseRank.RECRUIT);
        assertFalse(leadTheCharge);
    }
}
