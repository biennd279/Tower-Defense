package townerdefense.engine;


import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class GameConfig {
    //TODO: All settings
    //Unit
    public static final int SIZE_UNIT = 36;
    //Size of Tile
    public static final int SIZE_TILE_WIDTH = SIZE_UNIT;
    public static final int SIZE_TILE_HEIGHT = SIZE_UNIT;
    //Number of tile in
    public static final int NUMBER_TILE_IN_HORIZONTAL = 30;
    public static final int NUMBER_TILE_IN_VERTICAL = 22;
    //Size of Screen
    public static final int SCREEN_WIDTH = 1366;
    public static final int SCREEN_HEIGHT = 792;
    //1200 - 1080 = 120
    //720 - 72 = 648
    //Size of pick tower pick (Square)
    public static final int SIZE_SQUARE_IN_BAR = 140;
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


    public static final int NORMAL_ENEMY_WIDTH = (int) (SIZE_UNIT * 1.5);
    public static final int NORMAL_ENEMY_HEIGHT = (int) (SIZE_UNIT * 1.5);
    public static final int NORMAL_ENEMY_HEALTH_MAX = 100;
    public static final int NORMAL_ENEMY_SPEED = 250;
    public static final int NORMAL_ENEMY_ARMOR = 20;
    public static final int NORMAL_ENEMY_REWARD = 4; //Gold ?

    public static final long SMALLER_ENEMY_WIDTH = SIZE_UNIT * 3;
    public static final long SMALLER_ENEMY_HEIGHT = SIZE_UNIT * 3;
    public static final long SMALLER_ENEMY_HEALTH = 50;
    public static final long SMALLER_ENEMY_ARMOR = 10;
    public static final double SMALLER_ENEMY_SPEED = 150;
    public static final long SMALLER_ENEMY_REWARD = 6;


    public static final long TANKER_ENEMY_WIDTH = SIZE_UNIT * 2;
    public static final long TANKER_ENEMY_HEIGHT = SIZE_UNIT * 2;
    public static final long TANKER_ENEMY_HEALTH = 300;
    public static final long TANKER_ENEMY_ARMOR = 30;
    public static final double TANKER_ENEMY_SPEED = 150;
    public static final long TANKER_ENEMY_REWARD = 9;

    public static final long BOSS_ENEMY_WIDTH = SIZE_UNIT * 2;
    public static final long BOSS_ENEMY_HEIGHT = SIZE_UNIT * 2;
    public static final long BOSS_ENEMY_HEALTH = 500;
    public static final long BOSS_ENEMY_ARMOR = 55;
    public static final double BOSS_ENEMY_SPEED = 150;
    public static final long BOSS_ENEMY_REWARD = 30;

    //Spawner Config
    public static final int SPAWNER_WIDTH = SIZE_UNIT;
    public static final int SPAWNER_HEIGHT = SIZE_UNIT;
    public static final int SPAWNER_DEFAULT_POSX = 0;
    public static final int SPAWNER_DEFAULT_POSY = 3 * SIZE_TILE_HEIGHT;
    public static final double SPAWNER_SPEED_SPAWN = 1.0;
    //Target Config
    public static final int TARGET_WIDTH = SIZE_UNIT;
    public static final int TARGET_HEIGHT = SIZE_UNIT;
    public static final int TARGET_DEFAULT_POSX = 29 * SIZE_TILE_WIDTH;
    public static final int TARGET_DEFAULT_POSY = 16 * SIZE_TILE_HEIGHT;
    //Tower Config
    public static final int TOWER_DEFAULT_POSX = SIZE_TILE_WIDTH;
    public static final int TOWER_DEFAULT_POSY = 5 * SIZE_TILE_HEIGHT;
    public static final int TOWER_WIDTH = SIZE_TILE_WIDTH;
    public static final int TOWER_HEIGHT = SIZE_TILE_HEIGHT;
    public static final double TOWER_SPEED = 2.5; //Attack per Second
    public static final int TOWER_DAMAGE = 20;
    public static final int TOWER_RANGE = 300;
    public static final int TOWER_PRICE = 25;

    public static final double BEAM_TOWER_SPEED = 4.5; //Attack per Second
    public static final int BEAM_TOWER_DAMAGE = 15;
    public static final int BEAM_TOWER_RANGE = 400;
    public static final int BEAM_TOWER_PRICE = 75;

    public static final double ROCKET_TOWER_SPEED = 0.50; //Attack per Second
    public static final int ROCKET_TOWER_DAMAGE = 200;
    public static final int ROCKET_TOWER_RANGE = 500;
    public static final int ROCKET_TOWER_PRICE = 100;

    public static final double MACHINE_GUN_TOWER_SPEED = 1.5; //Attack per Second
    public static final int MACHINE_GUN_TOWER_DAMAGE = 9;
    public static final int MACHINE_GUN_TOWER_RANGE = 200;
    public static final int MACHINE_GUN_TOWER_PRICE = 50;

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
    public static Image IM_1, IMRoad, IM1, IM2, IM3, IM4, IM5, IMMountain, IM10, IMEnemy,
            IMTower, IMTower1, IMBlank, IMBullet, IMAnimationWp, IMExplosion,
            IMBeamTower, IMBeam, IMRocketTower, IMRocket, IMBoss, IMTankEnemy, IMPlane, IMMachineGunTower;

    static {
        IMRoad = new Image(GameConfig.class.getResource("/assets/road.png").toExternalForm());
        IMMountain = new Image(GameConfig.class.getResource("/assets/mountain.png").toExternalForm());
        IMEnemy = new Image(GameConfig.class.getResource("/assets/enemy.png").toExternalForm());
        IMTower = new Image(GameConfig.class.getResource("/assets/tower.png").toExternalForm());
        IMTower1 = cropImage(IMTower, 0, 0, 4, 4);
        IMBlank = cropImage(new Image(GameConfig.class.getResource("/assets/towers_walls_blank.png").toExternalForm()), 0, 0, 6, 5);
        IMBullet = new Image(GameConfig.class.getResource("/assets/bullet.png").toExternalForm());
        IMAnimationWp = new Image(GameConfig.class.getResource("/assets/turret_01_mk1.png").toExternalForm());
        IMExplosion = new Image(GameConfig.class.getResource("/assets/explosion.png").toExternalForm());
        IMBeamTower = cropImage(IMTower, 0, 1, 4, 4);
        IMBeam = new Image(GameConfig.class.getResource("/assets/beam.png").toExternalForm());
        IMRocketTower = cropImage(IMTower, 3, 3, 4, 4);
        IMRocket = new Image(GameConfig.class.getResource("/assets/rocket.png").toExternalForm());
        IMBoss = new Image(GameConfig.class.getResource("/assets/FinalBoss.png").toExternalForm());
        IMTankEnemy = new Image(GameConfig.class.getResource("/assets/TankEnemy.png").toExternalForm());
        IMPlane = new Image(GameConfig.class.getResource("/assets/plane.png").toExternalForm());
        IMMachineGunTower = cropImage(IMTower, 3, 0, 4, 4);

    }

    //Make it can not declaration


    private static Image cropImage(Image image, int x, int y, int a, int b) {
        int W = (int) image.getWidth() / a;
        int H = (int) image.getHeight() / b;
        int pX = x * W;
        int pY = y * H;
        PixelReader reader = image.getPixelReader();
        WritableImage newImage = new WritableImage(reader, pX, pY, W, H);
        return newImage;
    }


}
