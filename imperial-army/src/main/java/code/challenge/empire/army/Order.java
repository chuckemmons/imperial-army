/**
 * 
 */
package code.challenge.empire.army;

import java.util.Set;

/**
 * @author Chuck
 *
 */
public interface Order {

    public Set<Rank> reservedForRanks();

    public Boolean isReserved();
}
