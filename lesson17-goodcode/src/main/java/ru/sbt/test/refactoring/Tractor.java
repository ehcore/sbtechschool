package ru.sbt.test.refactoring;

public class Tractor {

    private int[] position = new int[] { 0, 0 };
    private final int[] field = new int[] { 5, 5 };
    private Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        if ("F".equals(command)) {
            moveForwards();
        } else if ("T".equals(command)) {
            turnClockwise();
        }
    }

    private void moveForwards() {
        if (isOrientationNorth()) {
            position = changePosition(0,1);
        } else if (isOrientationEast()) {
            position = changePosition(1,0);
        } else if (isOrientationSouth()) {
            position = changePosition(0,-1);
        } else if (isOrientationWest()) {
            position = changePosition(-1,0);
        }
        if (isTractorOutsideField(position[0],position[1])) {
            throw new TractorInDitchException();
        }
    }

    private void turnClockwise() {
        if (isOrientationNorth()) {
            setOrientation(Orientation.EAST);
        } else if (isOrientationEast()) {
            setOrientation(Orientation.SOUTH);
        } else if (isOrientationSouth()) {
            setOrientation(Orientation.WEST);
        } else if (isOrientationWest()) {
            setOrientation(Orientation.NORTH);
        }
    }

    private void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }

    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[1];
    }

    public Orientation getOrientation() {
        return orientation;
    }

    private boolean isOrientationNorth(){
        return orientation == Orientation.NORTH;
    }

    private boolean isOrientationEast(){
        return orientation == Orientation.EAST;
    }

    private boolean isOrientationSouth(){
        return orientation == Orientation.SOUTH;
    }

    private boolean isOrientationWest(){
        return orientation == Orientation.WEST;
    }

    private int[] changePosition(int dx, int dy){
        return new int[]{position[0] + dx, position[1] + dy};
    }

    private boolean isTractorOutsideField(int x, int y){
        return  ((x > field[0]) || (y > field[1]));
    }

}
