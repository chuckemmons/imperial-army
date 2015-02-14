/**
 * 
 */
package code.challenge.empire.army;

import java.util.Set;

/**
 * @author Chuck
 *
 */
public abstract class AbstractRank implements Rank {
    protected String prettyPrintName;

    /**
     * @param order
     * @return <code>true</code> only if this rank can give the order.
     */
    public Boolean canGive(Order order) {

        if (order.isReserved()) {
            Set<Rank> ranksForReservedOrder = order.reservedForRanks();
            return (ranksForReservedOrder == null) ? false : ranksForReservedOrder.contains(this);
        }

        // Normally, a rank can give orders to lower ranks. If this was in the
        // requirements, the rank of the soldier to receive the order would be
        // passed in, and a check would be done here instead of simply returning
        // false below.

        // This will never be hit because the requirements explicitly state all
        // orders come from the Emperor. (Hence, they are ALL reserved).
        return false;

    }

    public Boolean cannotGive(Order order) {
        return !canGive(order);
    }

    @Override
    public String toString() {
        return prettyPrintName;
    }

}
