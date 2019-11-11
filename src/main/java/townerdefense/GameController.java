package townerdefense;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import townerdefense.entity.Entity;
import townerdefense.entity.enemy.Enemy;
import townerdefense.entity.enemy.NormalEnemy;
import townerdefense.entity.other.Point;
import townerdefense.entity.tile.Spawner;
import townerdefense.entity.tile.Target;
import townerdefense.entity.tile.map.Map;
import townerdefense.entity.tile.map.WayPoint;
import townerdefense.entity.tile.tower.NormalTower;

import java.util.List;

public class GameController extends AnimationTimer {

    public static List<Point> points;
    private final GraphicsContext graphicsContext;
    private final GameField gameField;
    private final Map map;
    private final WayPoint wayPoint;
    private final Spawner spawner;
    private long lastTime;


    public GameController(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        //Todo: init Game field with GameStage and get return this
        //GameStage gameStage = new GameStage();
        //this.gameField = gameStage.getGameField()
        //Todo: comment this code after finish before code
        this.map = new Map();
        this.wayPoint = new WayPoint();
        this.spawner = new Spawner();
        points = wayPoint.getPoints();

        this.gameField = new GameField();

        this.gameField.addAllEntity(map.getListTile());
        //this.gameField.addEntity(this.wayPoint);
        this.gameField.addEntity(this.spawner);
        this.gameField.addEntity(new Target());
        this.gameField.addEntity(new NormalTower());
        //this.gameField.addEntity(new NormalEnemy());
        this.spawner.addEnemy(new NormalEnemy());
        this.spawner.addEnemy(new NormalEnemy());
        this.spawner.addEnemy(new NormalEnemy());
        this.spawner.addEnemy(new NormalEnemy());
    }

    @Override
    public void handle(long now) {
        int deltaTime = (int) (now - lastTime);

        this.gameField.updateEnemy(deltaTime);

        this.render();

        this.graphicsContext.setFill(Color.GOLD);
        this.graphicsContext.fillText(String.format("%f", (double) GameConfig.NPS / deltaTime), 10, 20);

        this.lastTime = now;
    }

    @Override
    public void start() {
        super.start();
        this.lastTime = System.nanoTime();
    }

    public void render() {
        for(Entity entity : gameField.getListEntries()) {
            entity.render(this.graphicsContext);
        }
    }
}
