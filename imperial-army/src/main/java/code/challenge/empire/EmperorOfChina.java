/**
 * 
 */
package code.challenge.empire;

import code.challenge.empire.army.ChineseRank;

/**
 * The Emperor of China implementation.
 * 
 * @author Chuck
 *
 */
public class EmperorOfChina extends AbstractEmperor {
    // Nothing to add yet. Just a standard Emperor at this point.

    public EmperorOfChina() {
        super();
        this.rank = ChineseRank.EMPEROR;
    }

    @Override
    public String toString() {
        return "Emperor of China";
    }

}
