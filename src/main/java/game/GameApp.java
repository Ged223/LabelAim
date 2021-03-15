package game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

import java.util.Map;

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
        FXGL.getGameWorld().addEntityFactory(new OurFactory());
        FXGL.spawn("player",900,FXGL.getAppHeight()/2-20);
        FXGL.spawn("enemy",100,100);
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
