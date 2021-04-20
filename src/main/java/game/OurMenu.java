package game;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.ui.FontFactory;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.getAssetLoader;

public class OurMenu extends FXGLMenu {
    public OurMenu(MenuType type){
        super(type);

        //customizing menu here
        Text menuText = new Text();
        menuText.setTranslateX((getAppWidth()/2)-300);
        menuText.setTranslateY(getAppHeight()/2);
        menuText.setStroke(Color.BLACK);
        menuText.setFill(Color.WHITE);
        FontFactory gameFont = getAssetLoader().loadFont("ARCADECLASSIC.TTF");
        menuText.setFont(gameFont.newFont(50));
        menuText.setText("                               PAUSED\npress  ESC  to  resume game");
        menuText.strokeWidthProperty().setValue(1.1);
        Texture texture = FXGL.getAssetLoader().loadTexture("GameMenuBackground.png");
        getContentRoot().getChildren().addAll(texture,menuText);
    }
}
