/**
 * 
 */
package code.challenge.empire.army;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chuck
 *
 */
public abstract class AbstractOrder implements Order {
    protected String prettyPrintName;
    protected static Set<Rank> reservedRanks = new HashSet<Rank>();

    /*
     * (non-Javadoc)
     * 
     * @see code.challenge.empire.army.Order#getRanksForReservedOrder()
     */
    public Set<Rank> reservedForRanks() {
        return reservedRanks;
    }

    /*
     * (non-Javadoc)
     * 
     * @see code.challenge.empire.army.Order#isReserved()
     */
    public Boolean isReserved() {
        return !reservedRanks.isEmpty();
    }

    @Override
    public String toString() {
        return prettyPrintName;
    }

}
