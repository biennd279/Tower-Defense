package townerdefense.engine.entity.tile.map;

import javafx.scene.canvas.GraphicsContext;
import townerdefense.engine.GameConfig;
import townerdefense.engine.entity.Entity;
import townerdefense.engine.entity.other.Point;

import java.util.ArrayList;
import java.util.List;

public class WayPoint extends Entity {
    private List<Point> points;

    //WayPoint sample
    public WayPoint() {
        super(0, 0, 0, 0);
        this.points = new ArrayList<>();

        this.points.add(new Point(GameConfig.SPAWNER_DEFAULT_POSX, GameConfig.SPAWNER_DEFAULT_POSY));
        this.points.add(new Point(9 * GameConfig.SIZE_TILE_WIDTH, 3 * GameConfig.SIZE_TILE_HEIGHT));
        this.points.add(new Point(9 * GameConfig.SIZE_TILE_WIDTH, 9 * GameConfig.SIZE_TILE_HEIGHT));
        this.points.add(new Point(3 * GameConfig.SIZE_TILE_WIDTH, 9 * GameConfig.SIZE_TILE_HEIGHT));
        this.points.add(new Point(3 * GameConfig.SIZE_TILE_WIDTH, 16 * GameConfig.SIZE_TILE_HEIGHT));
        this.points.add(new Point(15 * GameConfig.SIZE_TILE_WIDTH, 16 * GameConfig.SIZE_TILE_HEIGHT));
        this.points.add(new Point(15 * GameConfig.SIZE_TILE_WIDTH, 3 * GameConfig.SIZE_TILE_HEIGHT));
        this.points.add(new Point(25 * GameConfig.SIZE_TILE_WIDTH, 3 * GameConfig.SIZE_TILE_HEIGHT));
        this.points.add(new Point(25 * GameConfig.SIZE_TILE_WIDTH, 16 * GameConfig.SIZE_TILE_HEIGHT));
        this.points.add(new Point(29 * GameConfig.SIZE_TILE_WIDTH, 16 * GameConfig.SIZE_TILE_HEIGHT));
    }

    //Todo Generate from Map
    public WayPoint(Map map) {
        this();
    }

    public WayPoint(List<Point> points) {
        this();
        this.points = points;
    }

    public boolean isCanGo(int x, int y, int a, int b) {
        return isExist(x + 1, y, a, b) || isExist(x, y + 1, a, b) || isExist(x - 1, y, a, b) || isExist(x, y - 1, a, b);
    }

    public boolean isExist(int x, int y, int a, int b) {
        return x < a && x >= 0 && y < b && y >= 0;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        this.points.forEach(point -> point.render(graphicsContext));
    }
}
