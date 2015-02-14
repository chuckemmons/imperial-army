/**
 * 
 */
package code.challenge.empire.army.stable.animal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.challenge.empire.army.cadre.Horseman;

/**
 * @author Chuck
 *
 */
public abstract class AbstractHorse implements Horse {
    private static final Logger LOGGER = LoggerFactory.getLogger(Horse.class.getSimpleName());

    private Horseman owner;

    public Horseman getOwner() {
        return this.owner;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * code.challenge.empire.army.stable.animal.Horse#assignToOwner(code.challenge
     * .code.challenge.empire.army.cadre.Horseman)
     */
    public Boolean assignToOwner(Horseman horseman) {
        if (this.owner == null && horseman.receiveHorse(this)) {
            this.owner = horseman;
            LOGGER.info("The {} accepts it's new {} owner.", this.toString(), horseman.toString());
            return true;
        }
        LOGGER.info("The {} rejects a new {} owner.", this.toString(), horseman.toString());
        return false;
    }
}
