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

/**
 * @author Chuck
 *
 */
public class ChineseArcherTest {

    ChineseArcher archer = new ChineseArcher(ChineseRank.CONSCRIPT);

    @Test
    public void testGetRankEquals() {
        assertEquals(ChineseRank.CONSCRIPT, archer.getRank());
    }

    @Test
    public void testGetRankNotSame() {
        assertNotSame(ChineseRank.EMPEROR, archer.getRank());
    }

    @Test
    public void testGetNumberOfRemainingArrowsEmpty() {
        // always empty, there are no arrows to be found and no way to pick them
        // up! Let alone, nothing to shoot them with.
        assertEquals(archer.getNumberOfRemainingArrows(), 0);
    }

    @Test
    public void testEmperorOrderedFightToTheDeath() {
        Boolean foughtToTheDeath = archer.takeOrder(ChineseOrder.FIGHT_TO_THE_DEATH, ChineseRank.EMPEROR);
        assertTrue(foughtToTheDeath);
    }

    @Test
    public void testLiutenantChineseOrderedFightToTheDeath() {
        Boolean foughtToTheDeath = archer.takeOrder(ChineseOrder.FIGHT_TO_THE_DEATH, ChineseRank.CONSCRIPT);
        assertFalse(foughtToTheDeath);
    }

    @Test
    public void testEmperorOrderedShootDistantFoe() {
        Boolean shotAtDistantFoe = archer.takeOrder(ChineseOrder.SHOOT_DISTANT_FOE, ChineseRank.EMPEROR);
        assertTrue(shotAtDistantFoe);
    }

    @Test
    public void testCaptainOrderedShootDistantFoe() {
        Boolean shotAtDistantFoe = archer.takeOrder(ChineseOrder.SHOOT_DISTANT_FOE, ChineseRank.RECRUIT);
        assertFalse(shotAtDistantFoe);
    }

    @Test
    public void testEmperorOrderedTrampleEnemiesInPath() {
        Boolean trampledEnemiesInPath = archer.takeOrder(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, ChineseRank.EMPEROR);
        assertFalse(trampledEnemiesInPath);
    }

    @Test
    public void testSargentOrderedTrampleEnemiesInPath() {
        Boolean trampledEnemiesInPath = archer.takeOrder(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, ChineseRank.CONSCRIPT);
        assertFalse(trampledEnemiesInPath);
    }

    @Test
    public void testEmperorOrderedLeadTheCharge() {
        Boolean leadTheCharge = archer.takeOrder(ChineseOrder.LEAD_THE_CHARGE, ChineseRank.EMPEROR);
        assertFalse(leadTheCharge);
    }

    @Test
    public void testMajorOrderedLeadTheCharge() {
        Boolean leadTheCharge = archer.takeOrder(ChineseOrder.LEAD_THE_CHARGE, ChineseRank.RECRUIT);
        assertFalse(leadTheCharge);
    }
}
