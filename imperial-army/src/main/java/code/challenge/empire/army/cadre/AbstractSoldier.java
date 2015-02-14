/**
 * 
 */
package code.challenge.empire.army.cadre;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.challenge.empire.army.Order;
import code.challenge.empire.army.Rank;
import code.challenge.system.utils.ReflectionUtils;

/**
 * @author Chuck
 *
 */
public abstract class AbstractSoldier implements Soldier {
    private static final Logger LOGGER = LoggerFactory.getLogger(Soldier.class.getSimpleName());

    protected Rank rank;

    /**
     * map the orders that can be performed to action methods defined below.
     * Note: Currently only supports no-arg action methods returning Boolean to
     * indicating if the action was performed. (action methods should be private
     * to encapsulate behavior, but will still run if not).
     */
    protected Map<Order, String> ordersToActionMethods = new HashMap<Order, String>();

    public Map<Order, String> getOrdersToActionMethods() {
        return ordersToActionMethods;
    }

    protected Boolean addOrderActionMethodName(Order order, String actionMethodName) {
        if (ordersToActionMethods.containsKey(order)) {
            LOGGER.debug("The {} already has an action method for order {}.", this.getClass().getName(), order);
            return false;
        } else {
            String previousValue = ordersToActionMethods.put(order, actionMethodName);
            if (previousValue == null) {
                // no previous mapping
                LOGGER.debug("The order-action [{}-{}] method mapping added for {}.", order.toString(),
                        actionMethodName, this.getClass().getName());
            } else {
                // previously mapped order-action method
                LOGGER.error("The action method value in {} was changed from {} to {} for order: {}.", this.getClass()
                        .getSimpleName(), previousValue, actionMethodName, order.toString());
            }
            return true;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see code.challenge.empire.army.cadre.Soldier#getRank()
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Take an order and do it if able.
     * 
     * @return <code>true</code> if the order was carried out.
     * @see code.challenge.empire.army.cadre.Soldier#takeOrder(code.challenge.empire
     *      .army.cadre.Order, code.challenge.empire.army.cadre.Rank)
     */
    public Boolean takeOrder(Order order, Rank rankOfOrderGiver) {
        if (ordersToActionMethods.containsKey(order)) {
            if (rankOfOrderGiver.cannotGive(order)) {
                LOGGER.warn("{}s can not give {}s an order to {}. The {} declines.", rankOfOrderGiver, this.toString(),
                        order, this.toString());
                return false;
            } else {
                return performOrder(order);
            }
        } else {
            LOGGER.warn("The {} cannot {}!", this.toString(), order.toString());
            return false;
        }
    }

    /**
     * Action method to fight to the death.
     * 
     * @return <code>true</code> if action was carried out. <code>false</code>
     *         otherwise.
     */
    protected Boolean fightToTheDeath() {
        LOGGER.info("The {} is fighting to the death!", this.toString());
        return true;
    }

    private Boolean performOrder(Order order) {
        String methodName = ordersToActionMethods.get(order);

        Method method = ReflectionUtils.getMethod(this.getClass(), methodName);
        if (method == null) {
            LOGGER.warn("The {} cannot {}!", this.toString(), order.toString());
            return false;
        }

        Boolean orderPerformed = (Boolean) ReflectionUtils.invokeMethod(method, this);
        if (orderPerformed == null) {
            // should never get here. If it happens, it's a system error.
            LOGGER.error("The {} is unable to perform the {} order!", this.toString(), order.toString());
            return false;
        }

        return orderPerformed;
    }

}
