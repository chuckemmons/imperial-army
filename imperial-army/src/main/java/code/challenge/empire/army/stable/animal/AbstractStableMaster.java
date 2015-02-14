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
public abstract class AbstractStableMaster implements StableMaster {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractStableMaster.class.getSimpleName());

    public Boolean assignHorse(Horse horse, Horseman horseman) {
        LOGGER.info("The {} attempts to assign the {} to the {}.", this.toString(), horse.toString(),
                horseman.toString());
        if (horse.assignToOwner(horseman)) {
            LOGGER.info("The {} saddles up the {} and high-fives the {}.", this.toString(), horse.toString(),
                    horseman.toString());
            return true;
        }
        LOGGER.info("The {} grumbles something about how he can't PAY someone to get rid of the mangy {}.",
                this.toString(), horse.toString());
        return false;
    }
}
