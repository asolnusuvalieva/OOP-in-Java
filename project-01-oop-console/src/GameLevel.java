public class GameLevel {
    private static final int MINES_FOR_BEGINNER = 10;
    private static final int MINES_FOR_INTERMEDIATE = 40;
    private static final int MINES_FOR_EXPERT = 99;

    private static final int FIELD_WIDTH_FOR_BEGINNER = 8;
    private static final int FIELD_HEIGHT_FOR_BEGINNER = 8;

    private static final int FIELD_WIDTH_FOR_INTERMEDIATE = 16;
    private static final int FIELD_HEIGHT_FOR_INTERMEDIATE = 16;

    private static final int FIELD_WIDTH_FOR_EXPERT = 24;
    private static final int FIELD_HEIGHT_FOR_EXPERT = 24;

    private final int MINES;
    private final int FIELD_WIDTH;
    private final int FIELD_HEIGHT;

    public int getMINES() {
        return MINES;
    }

    public int getFIELD_WIDTH() {
        return FIELD_WIDTH;
    }

    public int getFIELD_HEIGHT() {
        return FIELD_HEIGHT;
    }

    public GameLevel(int difficulty){
        switch (difficulty){
            case 1:
                MINES = MINES_FOR_BEGINNER;
                FIELD_WIDTH = FIELD_WIDTH_FOR_BEGINNER;
                FIELD_HEIGHT = FIELD_HEIGHT_FOR_BEGINNER;
                break;
            case 2:
                MINES = MINES_FOR_INTERMEDIATE;
                FIELD_WIDTH = FIELD_WIDTH_FOR_INTERMEDIATE;
                FIELD_HEIGHT = FIELD_HEIGHT_FOR_INTERMEDIATE;
                break;
            case 3:
            default:
                MINES = MINES_FOR_EXPERT;
                FIELD_WIDTH = FIELD_WIDTH_FOR_EXPERT;
                FIELD_HEIGHT = FIELD_HEIGHT_FOR_EXPERT;
        }
    }
}
