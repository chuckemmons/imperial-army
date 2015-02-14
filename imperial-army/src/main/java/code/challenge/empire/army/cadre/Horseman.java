/**
 * 
 */
package code.challenge.empire.army.cadre;

import code.challenge.empire.army.stable.animal.Horse;

/**
 * @author dotcee
 *
 */
public interface Horseman {

    /**
     * @return The horseman's horse. <code>null</code> if the horseman doesn't
     *         have a horse.
     */
    public Horse getHorse();

    /**
     * @return <code>true</code> if the horseman takes the horse.
     */
    public Boolean receiveHorse(Horse horse);
}
