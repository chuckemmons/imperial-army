/**
 * 
 */
package code.challenge.empire.army.cadre;

import code.challenge.empire.army.ChineseOrder;
import code.challenge.empire.army.ChineseRank;

/**
 * @author Chuck
 *
 */
public class ChineseSoldier extends AbstractSoldier {

    // maybe a weapon would be nice?

    public ChineseSoldier(ChineseRank rank) {
        this.rank = rank;
        addOrderActionMethodName(ChineseOrder.FIGHT_TO_THE_DEATH, "fightToTheDeath");
    }

    // Add anything else that a ChineseSoldier may do that other's don't.
    // Examples may include cleaning the stables, sweeping the floor, etc.. Make
    // sure that <code>ordersToActionMethods</code> is updated if there are
    // orders associated. And for the love of God, keep the action methods
    // private. A soldier only acts if given orders or decides on his own!

    @Override
    public String toString() {
        return "Chinese soldier";
    }
}
