/**
 * 
 */
package code.challenge.empire.army;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chuck
 *
 */
public final class ChineseOrder extends AbstractOrder {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChineseOrder.class);

    public static final ChineseOrder FIGHT_TO_THE_DEATH = new ChineseOrder(Value.FIGHT_TO_THE_DEATH);
    public static final ChineseOrder TRAMPLE_ENEMIES_IN_PATH = new ChineseOrder(Value.TRAMPLE_ENEMIES_IN_PATH);
    public static final ChineseOrder SHOOT_DISTANT_FOE = new ChineseOrder(Value.SHOOT_DISTANT_FOE);
    public static final ChineseOrder LEAD_THE_CHARGE = new ChineseOrder(Value.LEAD_THE_CHARGE);

    private ChineseOrder(Value value) {
        init(value);
    }

    private static enum Value {
        FIGHT_TO_THE_DEATH("fight to the death"), TRAMPLE_ENEMIES_IN_PATH("trample enemies in path"), SHOOT_DISTANT_FOE(
                "shoot distant foe"), LEAD_THE_CHARGE("lead the charge");

        private final String prettyPrintName;

        private Value(String prettyPrintName) {
            this.prettyPrintName = prettyPrintName;
        }
    }

    private void init(Value value) {
        this.prettyPrintName = value.prettyPrintName;

        Set<Rank> ranksToAdd = new HashSet<Rank>();
        switch (value) {
        // only the Emperor of China is said to be able to give orders at this
        // time.
        case FIGHT_TO_THE_DEATH:
            ranksToAdd.addAll(Arrays.asList(new ChineseRank[] { ChineseRank.EMPEROR }));
            break;
        case TRAMPLE_ENEMIES_IN_PATH:
            ranksToAdd.addAll(Arrays.asList(new ChineseRank[] { ChineseRank.EMPEROR }));
            break;
        case SHOOT_DISTANT_FOE:
            ranksToAdd.addAll(Arrays.asList(new ChineseRank[] { ChineseRank.EMPEROR }));
            break;
        case LEAD_THE_CHARGE:
            ranksToAdd.addAll(Arrays.asList(new ChineseRank[] { ChineseRank.EMPEROR }));
            break;
        default:
            // if you see this, then add the value to the switch statement
            // above.
            LOGGER.debug("Unable to initialize {} with the value of {}.", this.getClass().getName(), value.name());
        }
        reservedRanks.addAll(ranksToAdd);
    }
}
