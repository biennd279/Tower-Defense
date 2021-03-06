package townerdefense.engine.entity.bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import townerdefense.engine.GameConfig;
import townerdefense.engine.entity.DestroyableEntity;
import townerdefense.engine.entity.Entity;
import townerdefense.engine.entity.UpdatableEntity;
import townerdefense.engine.entity.enemy.Enemy;
import townerdefense.engine.entity.other.Point;

public abstract class Bullet extends Entity implements UpdatableEntity, DestroyableEntity {
    double alpha;
    private double speed;
    private double damage;
    private Enemy enemy;
    private double theta = 0;

    Bullet(Enemy enemy, double posX, double posY, double with, double height, double speed, double damage) {
        super(posX, posY, with, height);
        this.speed = speed;
        this.damage = damage;
        this.enemy = enemy;
    }

    void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    @Override
    public void update(int deltaTime) {
        double deltaDistance = this.speed * deltaTime / GameConfig.NPS;
        if (!enemy.isDestroy()) {

            double deltaX = enemy.getCenterPosX() - this.posX;
            double deltaY = enemy.getCenterPosY() - this.posY;
            theta = Math.atan2(deltaY, deltaX);
            alpha = Math.toDegrees(Math.PI / 2 + theta);
            this.posX += deltaDistance * Math.cos(theta);
            this.posY += deltaDistance * Math.sin(theta);
        } else {
            this.posX += deltaDistance * Math.cos(theta);
            this.posY += deltaDistance * Math.sin(theta);
        }

    }

    @Override
    public boolean isDestroy() {
        return enemy.isDestroy()
                || Point.getDistance(this.getCenterPosX(), this.getCenterPosY(),
                enemy.getCenterPosX(), enemy.getCenterPosY()) <= GameConfig.SIZE_TILE_WIDTH;
    }

    @Override
    public void onDestroy() {
        enemy.onAttacked(this.damage);
    }
}
