/**
 * 
 */
package code.challenge.empire.army.stable.animal;

import code.challenge.empire.army.cadre.Horseman;

/**
 * Horse interface as mentioned in requirements.
 * 
 * @author dotcee
 *
 */
public interface Horse {
    public Horseman getOwner();

    public Boolean assignToOwner(Horseman horseman);
}
