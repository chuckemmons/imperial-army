/**
 * 
 */
package code.challenge.empire;

import code.challenge.empire.army.Order;

/**
 * Leader Interface.
 * 
 * @author Chuck
 *
 */
public interface Leader {
    public Boolean giveOrder(Leadable object, Order order);
}
