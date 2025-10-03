import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MarioClone extends Application {
  private double playerX = 50, playerY = 300;
  private double velocityY = 0;
  private boolean onGround = true;
  private final double gravity = 0.5;
  private final double jumpPower = -10;
  private final double speed = 5;
  private boolean moveLeft = false, moveRight = false;
  private boolean hasPower = false;

  private Image playerImage = new Image("player.png");
  private Image background = new Image("background.png");
  private Image platformImage = new Image("platform.png");
  private Image enemyImage = new Image("enemy.png");
  private Image powerUpImage = new Image("powerup.png");

  private List<Platform> platforms = new ArrayList<>();
  private List<Enemy> enemies = new ArrayList<>();
  private List<PowerUp> powerUps = new ArrayList<>();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Canvas canvas = new Canvas(800, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    platforms.add(new Platform(100, 250, 100, 20));
    platforms.add(new Platform(300, 200, 150, 20));
    platforms.add(new Platform(500, 150, 100, 20));

    enemies.add(new Enemy(400, 300));
    powerUps.add(new PowerUp(600, 250));

    Scene scene = new Scene(new StackPane(canvas));
    scene.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.LEFT) moveLeft = true;
      if (e.getCode() == KeyCode.RIGHT) moveRight = true;
      if (e.getCode() == KeyCode.SPACE && onGround) {
        velocityY = jumpPower;
        onGround = false;
      }
    });
    scene.setOnKeyReleased(e -> {
      if (e.getCode() == KeyCode.LEFT) moveLeft = false;
      if (e.getCode() == KeyCode.RIGHT) moveRight = false;
    });

    new AnimationTimer() {
      public void handle(long now) {
        update();
        draw(gc);
      }
    }.start();

    stage.setScene(scene);
    stage.setTitle("Mario Clone");
    stage.show();
  }

  private void update() {
    if (moveLeft) playerX -= speed;
    if (moveRight) playerX += speed;

    velocityY += gravity;
    playerY += velocityY;

    for (Platform platform : platforms) {
      if (playerY + 50 >= platform.y && playerY + 50 <= platform.y + 10 && playerX + 50 > platform.x && playerX < platform.x + platform.width) {
        playerY = platform.y - 50;
        velocityY = 0;
        onGround = true;
      }
    }

    if (playerY >= 350) {
      playerY = 350;
      velocityY = 0;
      onGround = true;
    }

    Iterator<PowerUp> iterator = powerUps.iterator();
    while (iterator.hasNext()) {
      PowerUp powerUp = iterator.next();
      if (playerX < powerUp.x + 20 && playerX + 50 > powerUp.x && playerY < powerUp.y + 20 && playerY + 50 > powerUp.y) {
        hasPower = true;
        iterator.remove();
      }
    }
  }

  private void draw(GraphicsContext gc) {
    gc.clearRect(0, 0, 800, 400);
    gc.drawImage(background, 0, 0, 800, 400);
    gc.drawImage(playerImage, playerX, playerY, 50, 50);

    for (Platform platform : platforms) {
      gc.drawImage(platformImage, platform.x, platform.y, platform.width, platform.height);
    }

    for (Enemy enemy : enemies) {
      gc.drawImage(enemyImage, enemy.x, enemy.y, 40, 40);
    }

    for (PowerUp powerUp : powerUps) {
      gc.drawImage(powerUpImage, powerUp.x, powerUp.y, 20, 20);
    }
  }

  private static class Platform {
    double x, y, width, height;

    Platform(double x, double y, double width, double height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }
  }

  private static class Enemy {
    double x, y;

    Enemy(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  private static class PowerUp {
    double x, y;

    PowerUp(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }
}
