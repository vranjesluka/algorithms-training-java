package codility;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class Amazon1_BattleshipGame {

    public String solution(int N, String S, String T) {
        // write your code in Java SE 8
        String[] shipsDescriptions = S.split(",");
        Ship[] ships = new Ship[shipsDescriptions.length];
        for (int i = 0; i < shipsDescriptions.length; i++) {
            ships[i] = new Ship(shipsDescriptions[i]);
        }
        String[] hitsDescriptions = T.split(" ");
        for (String hitDescription : hitsDescriptions) {
            Coordinate hitCoordinate = new Coordinate(hitDescription);
            for (Ship ship : ships) {
                ship.takeHit(hitCoordinate);
            }
        }
        int numOfSunkShips = 0;
        int numOfHitShips = 0;
        for (Ship ship : ships) {
            if (ship.isSunk()) {
                numOfSunkShips++;
            } else if (ship.isHit()) {
                numOfHitShips++;
            }
        }
        return numOfSunkShips + "," + numOfHitShips;
    }

    class Ship {
        private final Coordinate leftUp;
        private final Coordinate rightDown;
        private short numOfHits = 0;

        Ship(String description) {
            String[] corners = description.split(" ");
            leftUp = new Coordinate(corners[0]);
            rightDown = new Coordinate(corners[1]);
        }

        private boolean isSunk() {
            int numOfCells = getNumOfCells();
            return numOfHits >= numOfCells;
        }

        private boolean isHit() {
            return numOfHits > 0;
        }

        private void takeHit(Coordinate hitCoordinate) {
            if (isInside(hitCoordinate)) {
                numOfHits++;
            }
        }

        private int getNumOfCells() {
            return (rightDown.row - leftUp.row + 1) * (rightDown.column - leftUp.column + 1);
        }

        private boolean isInside(Coordinate hitCoordinate) {
            return hitCoordinate.row >= leftUp.row && hitCoordinate.row <= rightDown.row
                    && hitCoordinate.column >= leftUp.column && hitCoordinate.column <= rightDown.column;
        }
    }

    class Coordinate {
        private final char column;
        private final short row;

        Coordinate(String coordinateString) {
            this.column = coordinateString.charAt(coordinateString.length() - 1);
            this.row = Short.parseShort(coordinateString.substring(0, coordinateString.length() - 1));
        }
    }

    public static void main(String[] args) {
        Amazon1_BattleshipGame solution = new Amazon1_BattleshipGame();
        System.out.println(solution.solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));
    }
}
