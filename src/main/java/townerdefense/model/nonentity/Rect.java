package townerdefense.model.nonentity;

import javafx.scene.canvas.GraphicsContext;

public class Rect extends NonEntity {

    public Rect(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.strokeRect(posX, posY, this.width, this.height);
    }
}
