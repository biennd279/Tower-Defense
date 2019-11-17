package townerdefense.engine;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.util.Duration;
import javafx.animation.Interpolator;
import javafx.animation.Transition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameConfig {
    //TODO: All settings
    //Unit
    public static final int SIZE_UNIT = 36;
    //Size of Tile
    public static final int SIZE_TILE_WIDTH = SIZE_UNIT;
    public static final int SIZE_TILE_HEIGHT = SIZE_UNIT;
    //Number of tile in
    public static final int NUMBER_TILE_IN_HORIZONTAL = 30;
    public static final int NUMBER_TILE_IN_VERTICAL = 20;
    //Size of Screen
    public static final int SCREEN_WIDTH = 1200;
    public static final int SCREEN_HEIGHT = 860;
    //1200 - 1080 = 120
    //860 - 720 = 140
    //Size of Stage
    public static final int STAGE_WIDTH = NUMBER_TILE_IN_HORIZONTAL * SIZE_TILE_WIDTH;
    public static final int STAGE_HEIGHT = NUMBER_TILE_IN_VERTICAL * SIZE_TILE_HEIGHT;
    //Name of Game
    public static final String GAME_TITLE = "Tower Defense";
    //FPS
    public static final int FPS = 60;
    //nanosecond per second
    public static final int NPS = 1000000000;
    //nanosecond per frame
    public static final int NPF = NPS / FPS;
    //Enemy Config
    public static final int NORMAL_ENEMY_WIDTH = SIZE_UNIT;
    public static final int NORMAL_ENEMY_HEIGHT = SIZE_UNIT;


    public static final int NORMAL_ENEMY_HEALTH_MAX = 100;
    public static final int NORMAL_ENEMY_SPEED = 250;
    public static final int NORMAL_ENEMY_ARMOR = 30;
    public static final int NORMAL_ENEMY_REWARD = 1; //Gold ?


    public static final long SMALLER_ENEMY_HEALTH = 50;
    public static final long SMALLER_ENEMY_ARMOR = 10;
    public static final double SMALLER_ENEMY_SPEED = 200;
    public static final long SMALLER_ENEMY_REWARD = 2;


    public static final long TANKER_ENEMY_HEALTH = 300;
    public static final long TANKER_ENEMY_ARMOR = 50;
    public static final double TANKER_ENEMY_SPEED = 150;
    public static final long TANKER_ENEMY_REWARD = 3;


    public static final long BOSS_ENEMY_HEALTH = 500;
    public static final long BOSS_ENEMY_ARMOR = 80;
    public static final double BOSS_ENEMY_SPEED = 150;
    public static final long BOSS_ENEMY_REWARD = 10;

    //Spawner Config
    public static final int SPAWNER_WIDTH = SIZE_UNIT;
    public static final int SPAWNER_HEIGHT = SIZE_UNIT;
    public static final int SPAWNER_DEFAULT_POSX = 0;
    public static final int SPAWNER_DEFAULT_POSY = SIZE_TILE_HEIGHT;
    public static final double SPAWNER_SPEED_SPAWN = 1.0;
    //Target Config
    public static final int TARGET_WIDTH = SIZE_UNIT;
    public static final int TARGET_HEIGHT = SIZE_UNIT;
    public static final int TARGET_DEFAULT_POSX = 9 * SIZE_TILE_WIDTH;
    public static final int TARGET_DEFAULT_POSY = 9 * SIZE_TILE_HEIGHT;
    //Tower Config
    public static final int TOWER_DEFAULT_POSX = 1 * SIZE_TILE_WIDTH;
    public static final int TOWER_DEFAULT_POSY = 4 * SIZE_TILE_HEIGHT;
    public static final int TOWER_WIDTH = SIZE_TILE_WIDTH;
    public static final int TOWER_HEIGHT = SIZE_TILE_HEIGHT;
    //public static final double TOWER_SPEED_BULLET = 1500;
    public static final double TOWER_SPEED = 2.5; //Attack per Second
    public static final int TOWER_DAMAGE = 20;
    public static final int TOWER_RANGE = 700;

    public static final double BEAM_TOWER_SPEED = 1.3; //Attack per Second
    public static final int BEAM_TOWER_DAMAGE = 30;

    public static final double ROCKET_TOWER_SPEED = 1.5; //Attack per Second
    public static final int ROCKET_TOWER_DAMAGE = 50;
    public static final int ROCKET_TOWER_RANGE = 700;



    //bullet config
    public static final int BULLET_WIDTH = 8;
    public static final int BULLET_HEIGHT = 20;
    public static final int BULLET_SPEED = 900;//pixel per second

    public static final int BEAM_WIDTH = STAGE_WIDTH;
    public static final int BEAM_HEIGHT = SIZE_UNIT;

    public static final int ROCKET_WIDTH = 20;
    public static final int ROCKET_HEIGHT = 45;
    public static final int ROCKET_SPEED = 400;


    //Image
    public static Image IM0, IM1, IM2, IM3, IM4, IM5, IM6, IMEnemy,
            IMTower, IMTower1,IMBlank,IMBullet,IMAnimationWp,IMExplosion,
            IMBeamTower,IMBeam,IMRoketTower,IMRoket,IMBoss,IMTankEnemy,IMPlane;

    static {

        try {
            IM0 = new Image(new FileInputStream("assets/0.png"));
            IM1 = new Image(new FileInputStream("assets/1.png"));
            IM2 = new Image(new FileInputStream("assets/2.png"));
            IM3 = new Image(new FileInputStream("assets/3.png"));
            IM4 = new Image(new FileInputStream("assets/4.png"));
            IM5 = new Image(new FileInputStream("assets/5.png"));
            IM6 = new Image(new FileInputStream("assets/6.png"));
            IMEnemy = new Image(new FileInputStream("assets/enemy.png"));
            IMTower = new Image(new FileInputStream("assets/tower.png"));
            IMTower1 = cropImage(IMTower, 0, 0, 4, 4);
            IMBlank = cropImage(new Image( new FileInputStream("assets/towers_walls_blank.png")),0,0,6,5);
            IMBullet = new Image( new FileInputStream("assets/bullet.png"));
            IMAnimationWp = new Image(new FileInputStream("assets/turret_01_mk1.png"));
            IMExplosion = new Image(new FileInputStream("assets/explosion.png"));
            IMBeamTower = cropImage(IMTower,0,1,4,4);
            IMBeam = new Image(new FileInputStream("assets/beam.png"));
            IMRoketTower = cropImage(IMTower,3,3,4,4);
            IMRoket = new Image(new FileInputStream("assets/rocket.png"));
            IMBoss = new Image(new FileInputStream("assets/FinalBoss.png"));
            IMTankEnemy = new Image(new FileInputStream("assets/TankEnemy.png"));
            IMPlane = new Image(new FileInputStream("assets/plane.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //Make it can not declaration


    public static Image cropImage(Image image, int x, int y, int a, int b) {
        int W = (int) image.getWidth() / a;
        int H = (int) image.getHeight() / b;
        int pX = x * W;
        int pY = y * H;
        PixelReader reader = image.getPixelReader();
        WritableImage newImage = new WritableImage(reader, pX, pY, W, H);
        return newImage;
    }


}