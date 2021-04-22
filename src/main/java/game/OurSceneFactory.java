package game;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;

public class OurSceneFactory extends SceneFactory {

    @Override
    public FXGLMenu newMainMenu() {
        return new OurMenu(MenuType.MAIN_MENU);
    }

    @Override
    public FXGLMenu newGameMenu() {
        return new OurMenu(MenuType.GAME_MENU);
    }

}
