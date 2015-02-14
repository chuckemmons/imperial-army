/**
 * 
 */
package code.challenge.empire.army;

/**
 * @author Chuck
 *
 */
public interface Rank {
    public Boolean canGive(Order order);

    public Boolean cannotGive(Order order);
}
