/**
 * 
 */
package code.challenge.empire.army;

/**
 * @author Chuck
 *
 */
public final class ChineseRank extends AbstractRank {

    public static final ChineseRank EMPEROR = new ChineseRank(Value.EMPEROR);
    public static final ChineseRank RECRUIT = new ChineseRank(Value.RECRUIT);
    public static final ChineseRank CONSCRIPT = new ChineseRank(Value.CONSCRIPT);

    private Value value;

    private ChineseRank(Value value) {
        this.prettyPrintName = value.prettyPrintName;
        this.value = value;
    }

    private enum Value {
        // Initially used enums for the ranks. However, there is a need to
        CONSCRIPT("Conscript"), RECRUIT("Recruit"), EMPEROR("Emperor");

        private final String prettyPrintName;

        private Value(String prettyPrintName) {
            this.prettyPrintName = prettyPrintName;
        }
    }

    public Boolean outRanks(ChineseRank rank) {
        return value.compareTo(rank.value) > 0;
    }

}
