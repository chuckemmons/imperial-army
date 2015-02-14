/**
 * 
 */
package code.challenge.empire;

import code.challenge.empire.army.Order;
import code.challenge.empire.army.Rank;

/**
 * @author Chuck
 *
 */
public interface Leadable {

    /**
     * @return <code>true</code> only if the order is carried out.
     *         <code>false</code> otherwise.
     */
    public Boolean takeOrder(Order order, Rank rankOfOrderGiver);
}
