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
public class ChineseHorsemanTest {

    ChineseHorseman horseman = new ChineseHorseman(ChineseRank.CONSCRIPT);

    @Test
    public void testGetRankEquals() {
        assertEquals(ChineseRank.CONSCRIPT, horseman.getRank());
    }

    @Test
    public void testGetRankNotSame() {
        assertNotSame(ChineseRank.EMPEROR, horseman.getRank());
    }

    @Test
    public void testKnowsHorse() {
        StableMaster stableMaster = new StandardStableMaster();
        Horse horse = new StandardHorse();
        stableMaster.assignHorse(horse, horseman);
        assertEquals(horseman.getHorse(), horse);
        assertEquals(horse.getOwner(), horseman);
    }

    @Test
    public void testEmperorOrderedFightToTheDeath() {
        Boolean foughtToTheDeath = horseman.takeOrder(ChineseOrder.FIGHT_TO_THE_DEATH, ChineseRank.EMPEROR);
        assertTrue(foughtToTheDeath);
    }

    @Test
    public void testLiutenantOrderedFightToTheDeath() {
        Boolean foughtToTheDeath = horseman.takeOrder(ChineseOrder.FIGHT_TO_THE_DEATH, ChineseRank.CONSCRIPT);
        assertFalse(foughtToTheDeath);
    }

    @Test
    public void testEmperorOrderedShootDistantFoe() {
        Boolean shotAtDistantFoe = horseman.takeOrder(ChineseOrder.SHOOT_DISTANT_FOE, ChineseRank.EMPEROR);
        assertFalse(shotAtDistantFoe);
    }

    @Test
    public void testCaptainOrderedShootDistantFoe() {
        Boolean shotAtDistantFoe = horseman.takeOrder(ChineseOrder.SHOOT_DISTANT_FOE, ChineseRank.RECRUIT);
        assertFalse(shotAtDistantFoe);
    }

    @Test
    public void testEmperorOrderedTrampleEnemiesInPath() {
        Boolean trampledEnemiesInPath = horseman.takeOrder(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, ChineseRank.EMPEROR);
        assertTrue(trampledEnemiesInPath);
    }

    @Test
    public void testSargentOrderedTrampleEnemiesInPath() {
        Boolean trampledEnemiesInPath = horseman.takeOrder(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, ChineseRank.CONSCRIPT);
        assertFalse(trampledEnemiesInPath);
    }

    @Test
    public void testEmperorOrderedLeadTheCharge() {
        Boolean leadTheCharge = horseman.takeOrder(ChineseOrder.LEAD_THE_CHARGE, ChineseRank.EMPEROR);
        assertFalse(leadTheCharge);
    }

    @Test
    public void testMajorOrderedLeadTheCharge() {
        Boolean leadTheCharge = horseman.takeOrder(ChineseOrder.LEAD_THE_CHARGE, ChineseRank.RECRUIT);
        assertFalse(leadTheCharge);
    }
}
