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
public class ChineseSoldierTest {

    Soldier soldier = new ChineseSoldier(ChineseRank.CONSCRIPT);

    @Test
    public void testGetRankEquals() {
        assertEquals(ChineseRank.CONSCRIPT, soldier.getRank());
    }

    @Test
    public void testGetRankNotSame() {
        assertNotSame(ChineseRank.EMPEROR, soldier.getRank());
    }

    @Test
    public void testEmperorOrderedFightToTheDeath() {
        Boolean foughtToTheDeath = soldier.takeOrder(ChineseOrder.FIGHT_TO_THE_DEATH, ChineseRank.EMPEROR);
        assertTrue(foughtToTheDeath);
    }

    @Test
    public void testLiutenantOrderedFightToTheDeath() {
        Boolean foughtToTheDeath = soldier.takeOrder(ChineseOrder.FIGHT_TO_THE_DEATH, ChineseRank.CONSCRIPT);
        assertFalse(foughtToTheDeath);
    }

    @Test
    public void testEmperorOrderedShootDistantFoe() {
        Boolean shotAtDistantFoe = soldier.takeOrder(ChineseOrder.SHOOT_DISTANT_FOE, ChineseRank.EMPEROR);
        assertFalse(shotAtDistantFoe);
    }

    @Test
    public void testCaptainOrderedShootDistantFoe() {
        Boolean shotAtDistantFoe = soldier.takeOrder(ChineseOrder.SHOOT_DISTANT_FOE, ChineseRank.RECRUIT);
        assertFalse(shotAtDistantFoe);
    }

    @Test
    public void testEmperorOrderedTrampleEnemiesInPath() {
        Boolean trampledEnemiesInPath = soldier.takeOrder(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, ChineseRank.EMPEROR);
        assertFalse(trampledEnemiesInPath);
    }

    @Test
    public void testSargentOrderedTrampleEnemiesInPath() {
        Boolean trampledEnemiesInPath = soldier.takeOrder(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, ChineseRank.CONSCRIPT);
        assertFalse(trampledEnemiesInPath);
    }

    @Test
    public void testEmperorOrderedLeadTheCharge() {
        Boolean leadTheCharge = soldier.takeOrder(ChineseOrder.LEAD_THE_CHARGE, ChineseRank.EMPEROR);
        assertFalse(leadTheCharge);
    }

    @Test
    public void testMajorOrderedLeadTheCharge() {
        Boolean leadTheCharge = soldier.takeOrder(ChineseOrder.LEAD_THE_CHARGE, ChineseRank.RECRUIT);
        assertFalse(leadTheCharge);
    }
}
