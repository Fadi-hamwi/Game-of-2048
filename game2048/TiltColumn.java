package game2048;

public class TiltColumn {
    private static int emptyTilesNumber;
    private static int lastNonEmptyTileValue;
    private static Board gameBoard;
    private static int currentScore;
    private static boolean hasMergeHappened;

    public static int startTiltingAndUpdatingScore(Board gameBoard, int col) {
        setTheInitialsToStartTilting(gameBoard);
        tilt(col);
        return currentScore;
    }

    private static void setTheInitialsToStartTilting(Board board) {
        emptyTilesNumber = 0;
        lastNonEmptyTileValue = 0;
        gameBoard = board;
        currentScore = 0;
        hasMergeHappened = false;
    }
    /**
     * Iterate rows of Board from Top to bottom
     * And for each tile we compute its correct index after tilting it.
     * Then we move the tile to that location (merge could happen if the two tiles has the same values)
     */
    public static void tilt(int col) {
        for(int row = gameBoard.size()-1; row >= 0; row--) {
            Tile currentTile = gameBoard.tile(col, row);
            computeTileIndxAfterTilting(currentTile);
            moveAndUpdateScoreIfMerged(currentTile, col, row);
        }
    }
    /**
     * If the tile is empty it means it's an additional space the next non-empty tile has to jump over.
     * And when tile is not empty we check merge possibility :
     * If the merge could happen we add one additional space since we are mergeing two tiles into one.
     * And Lastly we change the last value.*/
    private static void computeTileIndxAfterTilting(Tile tile) {
        if(isEmptyTile(tile)) {
            emptyTilesNumber++;
        }else {
            // when merge happens one additional empty space will be added.
            hasMergeHappened = (lastNonEmptyTileValue == tile.value());
            lastNonEmptyTileValue = tile.value();
        }
    }
    /**
     * First We can't move an empty tile (forbidden)
     * If there is an opportunity for merge :
     * we update the score and reset the initials for a possible merge in the next time (2 merges maximum per column)
     * Lastly we move the tile to the specified location.*/
    private static void moveAndUpdateScoreIfMerged(Tile tile, int col, int row) {
        if(isEmptyTile(tile)) return;
        if(hasMergeHappened) {
            updateScore();
            resetMergeInitialsAfterMerge();
        }
        gameBoard.move(col, emptyTilesNumber+row, tile);
    }

    private static boolean isEmptyTile(Tile tile) {
        return tile == null;
    }

    private static void updateScore() {
        currentScore += 2* lastNonEmptyTileValue;
    }
    /**
     * Since we can't merge the same tile twice in the same tilt.
     * We need to reset merge initials after every merge.
     */
    private static void resetMergeInitialsAfterMerge() {
        hasMergeHappened = false;
        lastNonEmptyTileValue = 0;
        emptyTilesNumber += 1; // since merge creates one additional empty space.
    }
}
