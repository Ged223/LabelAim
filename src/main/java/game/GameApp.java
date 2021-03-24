package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.KeyTrigger;
import com.almasb.fxgl.input.Trigger;
import com.almasb.fxgl.input.TriggerListener;
import javafx.beans.property.StringProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;


import java.util.ArrayList;
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
        gameSettings.setVersion("0.0");
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
                System.out.println("Begin: " + trigger);
                if (trigger.isKey()) {
                    var keyTrigger = (KeyTrigger) trigger;
                    // key is being pressed now
                    var key = keyTrigger.getKey();
                    if (key.equals(KeyCode.SPACE)) {
                        shoot();
                    } else if (key.isLetterKey()) {
                        //get the written property
                        StringProperty written = getWorldProperties().stringProperty("written");
                        //append the pressed key
                        getWorldProperties().setValue("written", written.getValue() + key.toString());
                    }

                }
            }
        });
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("written", "");
        vars.put("enemyList", new ArrayList<Entity>());
    }

    @Override
    protected void initGame() { //method to initialize all entities at the start of the game
        getGameWorld().addEntityFactory(new OurFactory());
        spawn("player", 900, getAppHeight() / 2 - 20);
        run(() -> { //runs repeatedly
            spawn("enemy", FXGLMath.randomPoint(
                    new Rectangle2D(0, 20, 0, getAppHeight()-50))
                    //spawn enemy on a random point within the bounds(Rectangle2D)
            );
        }, millis(FXGL.random(500, 1500)));//set the interval of the run method


        runOnce(() -> {
            var input = getSceneService().getInput();
            input.rebind(input.getActionByName("Screenshot"), KeyCode.F12);
        }, seconds(0.1));
    }

    @Override
    protected void initPhysics() {
        super.initPhysics();
    }

    @Override
    protected void initUI() {
        //create a text to display written characters
        Text written = new Text();
        written.setTranslateX(900);
        written.setTranslateY(getAppHeight() / 2 + 40);
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
        for (Entity enemy : enemies) {
            if (enemy.getComponent(NameComponent.class).getName().equals(writtenName)) {
                enemy.removeFromWorld();
            }
        }
    }

}
