package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.audio.Music;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.KeyTrigger;
import com.almasb.fxgl.input.Trigger;
import com.almasb.fxgl.input.TriggerListener;
import com.almasb.fxgl.ui.FontFactory;
import javafx.beans.property.StringProperty;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import com.almasb.fxgl.dsl.views.SelfScrollingBackgroundView;

import java.util.List;
import java.util.Map;

import static com.almasb.fxgl.dsl.FXGL.*;
import static javafx.util.Duration.millis;
import static javafx.util.Duration.seconds;

public class GameApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(1024);
        gameSettings.setHeight(576);
        gameSettings.setTitle("LabelAim");
        gameSettings.setVersion("0.1");
        gameSettings.setSceneFactory(new OurSceneFactory());

        NameProvider.loadWordsFromFile();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void onPreInit() {
        super.onPreInit();

    }

    @Override
    protected void initInput() {
        //listen for any generic trigger event
        getInput().addTriggerListener(new TriggerListener() {
            @Override
            protected void onActionBegin(Trigger trigger) {
                if (getWorldProperties().booleanProperty("isPaused").getValue() == false) {
                    System.out.println("Begin: " + trigger);
                    if (trigger.isKey()) {
                        var keyTrigger = (KeyTrigger) trigger;
                        // key is being pressed now
                        var key = keyTrigger.getKey();

                        //get the written property
                        StringProperty written = getWorldProperties().stringProperty("written");

                        if (key.equals(KeyCode.SPACE) || key.equals(KeyCode.ENTER)) {
                            shoot();
                        } else if (key.equals(KeyCode.BACK_SPACE) && written.getValue().length() > 0) {
                            //remove last character in string
                            FXGL.play("keypress.wav");
                            getWorldProperties().setValue("written", written.getValue().substring(0, written.getValue().length() - 1));
                        } else if (key.isLetterKey()) {
                            //append the pressed key
                            FXGL.play("keypress.wav");
                            getWorldProperties().setValue("written", written.getValue() + key.toString());
                        } else if (key.equals(KeyCode.NUMPAD0)){
                            if(getWorldProperties().getBoolean("isMusicOn")){
                                FXGL.getAudioPlayer().stopAllMusic();
                                getWorldProperties().setValue("isMusicOn",false);
                            }else{
                                //music
                                Music music = FXGL.getAssetLoader().loadMusic("loop.wav");
                                FXGL.getAudioPlayer().loopMusic(music);
                                getWorldProperties().setValue("isMusicOn",true);
                            }
                        }

                    }
                }
            }
        });
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("written", "");
        vars.put("isPaused", false);
        vars.put("score", "0");
        vars.put("speedOfNewEnemies", 100);
        vars.put("isMusicOn",true);
    }

    @Override
    protected void initGame() { //method to initialize all entities at the start of the game
        FXGL.getGameController().resumeEngine();
        NameProvider.nextWordIndex = 0;
        getWorldProperties().booleanProperty("isPaused").setValue(false);
        getGameWorld().addEntityFactory(new OurFactory());
        spawn("player", 850, getAppHeight() / 2 - 20);

        //music
        Music music = FXGL.getAssetLoader().loadMusic("loop.wav");
        FXGL.getAudioPlayer().loopMusic(music);

        spawnEnemies(1000);

        runOnce(() -> {
            var input = getSceneService().getInput();
            input.rebind(input.getActionByName("Screenshot"), KeyCode.F12);
        }, seconds(0.1));
    }

    protected void spawnEnemies(int interval) {
        runOnce(() -> {
            //spawn enemy on a random point within the bounds(Rectangle2D)
            spawn("enemy", FXGLMath.randomPoint(new Rectangle2D(0, 20, 0, getAppHeight() - 150)));
            if (interval <= 500) {
                spawnEnemies(interval);
                System.out.println("Interval is at fastest possible value: " + interval + "ms");
            } else {
                spawnEnemies(interval - 2);
                System.out.println("Interval is now: " + (interval - 2));
                getWorldProperties().setValue("speedOfNewEnemies", getWorldProperties().getInt("speedOfNewEnemies") + 1);
            }
        }, millis(interval));//set the delay of spawning the run method
    }

    @Override
    protected void initPhysics() {
        super.initPhysics();
    }

    @Override
    protected void initUI() {
        FontFactory gameFont = getAssetLoader().loadFont("ARCADECLASSIC.TTF");
        //score display
        Text scoreText = new Text();
        scoreText.textProperty().bind(FXGL.getWorldProperties().stringProperty("score"));
        scoreText.setTranslateX(50);
        scoreText.setTranslateY(50);
        scoreText.setStroke(Color.BLACK);
        scoreText.setFill(Color.WHITE);
        scoreText.strokeWidthProperty().setValue(1.1);
        scoreText.setFont(gameFont.newFont(30));
        getGameScene().addUINode(scoreText);

        //background layers
        entityBuilder()
                .view(new SelfScrollingBackgroundView(FXGL.image("background.png"), 1024, 576, Orientation.HORIZONTAL, 0))
                .zIndex(-5)
                .buildAndAttach();
        entityBuilder()
                .view(new SelfScrollingBackgroundView(FXGL.image("starsTiny.png"), 1011, 557, Orientation.HORIZONTAL, -16.1))
                .zIndex(-4)
                .buildAndAttach();
        entityBuilder()
                .view(new SelfScrollingBackgroundView(FXGL.image("starsSmall.png"), 966, 562, Orientation.HORIZONTAL, -26.1))
                .zIndex(-3)
                .buildAndAttach();
        entityBuilder()
                .view(new SelfScrollingBackgroundView(FXGL.image("starsMedium.png"), 996, 540, Orientation.HORIZONTAL, -42.0))
                .zIndex(-2)
                .buildAndAttach();
        entityBuilder()
                .view(new SelfScrollingBackgroundView(FXGL.image("starsLarge.png"), 872, 549, Orientation.HORIZONTAL, -68.1))
                .zIndex(-1)
                .buildAndAttach();
        //create a text to display written characters
        Text written = new Text();
        written.setStroke(Color.BLACK);
        written.setFill(Color.WHITE);
        written.strokeWidthProperty().setValue(1.5);
        written.setFont(gameFont.newFont(50));
        written.setTranslateX(getAppWidth() / 2 - 100);
        written.setTranslateY(getAppHeight() - 20);
        //bind so that it always displays the value of the world property "written"
        written.textProperty().bind(FXGL.getWorldProperties().stringProperty("written"));
        getGameScene().addUINode(written);//add to the scene graph
    }

    @Override
    protected void onUpdate(double tpf) {
        super.onUpdate(tpf);
    }

    private void shoot() {
        String writtenName = getWorldProperties().getValue("written");
        getWorldProperties().setValue("written", "");

        List<Entity> enemies = getGameWorld().getEntitiesByType(EntityType.ENEMY);
        boolean foundAtLeastOneEnemy = false;
        for (Entity enemy : enemies) {
            if (enemy.getComponent(NameComponent.class).getName().equals(writtenName)) {
                enemy.getComponent(EnemyAnimationComponent.class).onDeath();
                foundAtLeastOneEnemy = true;

                //score += 1;
                getWorldProperties().setValue(
                        "score", Integer.toString((Integer.parseInt(getWorldProperties().getString("score")) + 1))
                );
            }
        }
        if (!foundAtLeastOneEnemy) {
            FXGL.play("beep-error.wav");
        }
    }

    protected void asiScore() {
        FontFactory gameFont = getAssetLoader().loadFont("ARCADECLASSIC.TTF");


    }

}
