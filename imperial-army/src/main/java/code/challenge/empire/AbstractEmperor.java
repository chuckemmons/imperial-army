package code.challenge.empire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.challenge.empire.army.Order;
import code.challenge.empire.army.Rank;

/**
 * This class provides a skeletal implementation of the {@link Emperor}
 * interface to minimize the effort required to implement the interface. It also
 * makes implementations DRY (prevents code duplication since every Emperor must
 * have the rank Emperor).
 * 
 * @author Chuck
 *
 */
public abstract class AbstractEmperor implements Emperor {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEmperor.class.getSimpleName());

    // By definition, every Emperor has the rank of Emperor
    protected Rank rank;

    @Override
    public abstract String toString();

    /**
     * Give an order to a soldier.
     * 
     * @see code.challenge.empire.Emperor#giveOrder(code.challenge.empire.army.cadre.Soldier,
     *      code.challenge.empire.army.Order)
     */
    public Boolean giveOrder(Leadable soldier, Order order) {
        // Vanilla implementation of giving an order. Nothing exciting here.
        // Override it for fun!
        if (rank.cannotGive(order)) {
            LOGGER.warn("The {} will not give an order to {}!", this.toString(), order.toString());
            return false;
        }

        LOGGER.info("The {} is ordering a {} to {}!", this.toString(), soldier.toString(), order.toString());
        return soldier.takeOrder(order, rank);
    }

}
