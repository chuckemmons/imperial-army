/**
 * 
 */
package code.challenge.empire.army;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Chuck
 *
 */
public class ChineseRankTest {

    @Test
    public void testRecruitOutRanksConscript() {
        assertTrue(ChineseRank.RECRUIT.outRanks(ChineseRank.CONSCRIPT));
    }

    @Test
    public void testEmperorOutRanksConscript() {
        assertTrue(ChineseRank.EMPEROR.outRanks(ChineseRank.CONSCRIPT));
    }

    @Test
    public void testEmperorOutRanksRecruit() {
        assertTrue(ChineseRank.EMPEROR.outRanks(ChineseRank.RECRUIT));
    }

    @Test
    public void testConscriptDoesntOutRankRecruit() {
        assertFalse(ChineseRank.CONSCRIPT.outRanks(ChineseRank.RECRUIT));
    }
}
