package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGL.*;

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
        super.initInput();
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        super.initGameVars(vars);
    }

    @Override
    protected void initGame() { //method to initialize all entities at the start of the game
        getGameWorld().addEntityFactory(new OurFactory());
        spawn("player", 900, getAppHeight() / 2 - 20);

        run(() -> { //runs repeatedly
            spawn("enemy", FXGLMath.randomPoint(
                    new Rectangle2D(0, 0, 0, getAppHeight()))
                    //spawn enemy on a random point within the bounds(Rectangle2D)
            );
        }, Duration.seconds(1));//set the interval of the run method
    }

    @Override
    protected void initPhysics() {
        super.initPhysics();
    }

    @Override
    protected void initUI() {
        super.initUI();
    }

    @Override
    protected void onUpdate(double tpf) {
        super.onUpdate(tpf);
    }
}
