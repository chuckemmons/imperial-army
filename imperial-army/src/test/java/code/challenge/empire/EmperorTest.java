package code.challenge.empire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.challenge.empire.army.ChineseOrder;
import code.challenge.empire.army.ChineseRank;
import code.challenge.empire.army.cadre.ChineseSoldier;
import code.challenge.empire.army.cadre.Soldier;

public class EmperorTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmperorTest.class.getSimpleName());

    Emperor emperor = new EmperorOfChina();

    @Test
    public void testGiveSoldierOrders() {
        Soldier soldier = new ChineseSoldier(ChineseRank.CONSCRIPT);

        Boolean foughtToDeath = emperor.giveOrder(soldier, ChineseOrder.FIGHT_TO_THE_DEATH);
        // should happen (izza soldier)
        assertTrue(foughtToDeath);

        LOGGER.info("");

        Boolean shotDistantFoe = emperor.giveOrder(soldier, ChineseOrder.SHOOT_DISTANT_FOE);
        // can't happen (notta soldier)
        assertFalse(shotDistantFoe);

        LOGGER.info("");

        Boolean trampledEnemiesInPath = emperor.giveOrder(soldier, ChineseOrder.TRAMPLE_ENEMIES_IN_PATH);
        // can't happen (notta horsemen)
        assertFalse(trampledEnemiesInPath);

        LOGGER.info("");

        Boolean leadTheCharge = emperor.giveOrder(soldier, ChineseOrder.LEAD_THE_CHARGE);
        // can't happen (not flying rain of fire)
        assertFalse(leadTheCharge);
    }

}
