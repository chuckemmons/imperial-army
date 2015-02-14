/**
 * 
 */
package code.challenge.empire.army.cadre;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.challenge.empire.army.ChineseOrder;
import code.challenge.empire.army.ChineseRank;
import code.challenge.empire.army.supply.ammunition.Arrow;

/**
 * Default implementation of an Archer.
 * 
 * @author Chuck
 *
 */
public class ChineseArcher extends ChineseSoldier implements Archer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChineseArcher.class.getSimpleName());

    private Collection<Arrow> sheath = new ArrayList<Arrow>();

    public ChineseArcher(ChineseRank rank) {
        super(rank);
        addOrderActionMethodName(ChineseOrder.SHOOT_DISTANT_FOE, "shootDistantFoe");

    }

    // Add anything else that a ChineseArcher may do that other's don't.
    // Examples may include fletching arrows, finding feathers, etc.. Make
    // sure that <code>ordersToActionMethods</code> is updated if there are
    // orders associated. And for the love of God, keep the action methods
    // private. An soldier only acts if given orders or decides on his own!

    public int getNumberOfRemainingArrows() {
        return sheath.size();
    }

    /**
     * Action method to shoot distant foe.
     * 
     * @return <code>true</code> if action was carried out. <code>false</code>
     *         otherwise.
     */
    protected Boolean shootDistantFoe() {
        LOGGER.info("The {} is shooting at a distant foe!", this.toString());
        return true;
    }

    @Override
    public String toString() {
        return "Chinese archer";
    }

}
