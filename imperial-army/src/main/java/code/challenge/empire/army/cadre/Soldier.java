/**
 * 
 */
package code.challenge.empire.army.cadre;

import code.challenge.empire.Leadable;
import code.challenge.empire.army.Rank;

/**
 * @author dotcee
 *
 */
public interface Soldier extends Leadable {
    // would also be a Leader, but requirements don't specify at this time.

    /** A soldier knows thier rank. */
    public Rank getRank();

}
