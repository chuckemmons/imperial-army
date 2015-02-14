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
 * 
 * @author Chuck
 *
 */
public class FlyingRainOfFireMember extends ChineseSoldier implements Horseman, Archer {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlyingRainOfFireMember.class.getSimpleName());

    private ChineseHorseman horseman;
    private ChineseArcher archer;

    public FlyingRainOfFireMember(ChineseRank rank) {
        super(rank);
        this.horseman = new ChineseHorseman(rank);
        this.archer = new ChineseArcher(rank);
        addOrderActionMethodName(ChineseOrder.LEAD_THE_CHARGE, "leadTheCharge");
        addOrderActionMethodName(ChineseOrder.SHOOT_DISTANT_FOE, "shootDistantFoe");
        addOrderActionMethodName(ChineseOrder.TRAMPLE_ENEMIES_IN_PATH, "trampleEnemiesInPath");
    }

    /*
     * (non-Javadoc)
     * 
     * @see code.challenge.empire.army.cadre.Horseman#getHorse()
     */
    public Horse getHorse() {
        return horseman.getHorse();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * code.challenge.empire.army.cadre.Horseman#assignHorse(code.challenge.
     * code.challenge.empire.army.stable.animal.Horse)
     */
    public Boolean receiveHorse(Horse horse) {
        return horseman.receiveHorse(horse);
    }

    /*
     * (non-Javadoc)
     * 
     * @see code.challenge.empire.army.cadre.Archer#getNumberOfRemainingArrows()
     */
    public int getNumberOfRemainingArrows() {
        return archer.getNumberOfRemainingArrows();
    }

    /**
     * Action method to lead the charge.
     * 
     * @return <code>true</code> if action was carried out. <code>false</code>
     *         otherwise.
     */
    @SuppressWarnings("unused")
    // untrue - this is called via reflection. To be sure, check the
    // ordersToActionMethods mapping above.
    private Boolean leadTheCharge() {
        LOGGER.info("The {} is leading the charge!", this.toString());
        return true;
    }

    /**
     * Action method to shoot distant foe.
     * 
     * @return <code>true</code> if action was carried out. <code>false</code>
     *         otherwise.
     */
    protected Boolean shootDistantFoe() {
        return this.archer.shootDistantFoe();
        /*
         * LOGGER.info("The {} is shooting at a distant foe!", this.toString());
         * return true;
         */
    }

    /**
     * Action method to trample some enemies.
     * 
     * @return <code>true</code> if action was carried out. <code>false</code>
     *         otherwise.
     */
    protected Boolean trampleEnemiesInPath() {
        return this.horseman.trampleEnemiesInPath();
        /*
         * LOGGER.info("The {} is trampling enemies in thier path!",
         * this.toString()); return true;
         */
    }

    @Override
    public String toString() {
        return "Flying Rain of Fire member";
    }

}
