/**
 * 
 */
package code.challenge.empire.army.cadre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.challenge.empire.army.ChineseOrder;
import code.challenge.empire.army.ChineseRank;
import code.challenge.empire.army.stable.animal.Horse;

/**
 * @author Chuck
 *
 */
public class ChineseHorseman extends ChineseSoldier implements Horseman {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChineseHorseman.class.getSimpleName());

    private Horse horse;

    public ChineseHorseman(ChineseRank rank) {
        super(rank);
        addOrderActionMethodName(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, "trampleEnemiesInPath");
    }

    /*----------------------*
     * Begin action methods *
     * ---------------------*/

    /**
     * Action method to trample some enemies.
     * 
     * @return <code>true</code> if action was carried out. <code>false</code>
     *         otherwise.
     */
    protected Boolean trampleEnemiesInPath() {
        LOGGER.info("The {} is trampling enemies in thier path!", this.toString());
        return true;
    }

    @Override
    public String toString() {
        return "Chinese horseman";
    }

    public Horse getHorse() {
        return horse;
    }

    public Boolean receiveHorse(Horse horse) {
        if (this.horse == null) {
            this.horse = horse;
            LOGGER.info("The {} accepts the {}.", this.toString(), horse.toString());
            return true;
        }
        LOGGER.info("The {} refuses the {}. He already has a {}.", this.toString(), horse.toString(),
                this.horse.toString());
        return false;
    }
}
