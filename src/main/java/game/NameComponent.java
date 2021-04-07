package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.ui.FontFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.getAssetLoader;

public class NameComponent extends Component {
    private String name;
    private Text nameText = new Text();
    private FontFactory gameFont;

    public NameComponent() {

    }

    @Override
    public void onAdded() {
        name = NameProvider.nextName();
        gameFont = getAssetLoader().loadFont("ARCADECLASSIC.TTF");
        nameText.setFont(gameFont.newFont(25));
        nameText.setFill(Color.WHITE);
        nameText.setStroke(Color.BLACK);
        nameText.setStrokeWidth(0.2);
        nameText.setText(name);
        FXGL.getGameScene().addUINode(nameText);

    }

    @Override
    public void onUpdate(double tpf) {
        int centerPixelsAmount = (name.length() - 13) * 3;
        nameText.setTranslateX(entity.getX() - (centerPixelsAmount));
        nameText.setTranslateY(entity.getY() + (120));
    }

    @Override
    public void onRemoved() {
        FXGL.getGameScene().removeUINode(nameText);
    }

    private String generateName() { //not used anymore, generates random A-Z letter
        char letter = (char) FXGL.random(65, 90);
        return Character.toString(letter);
    }

    public String getName() {
        return name;
    }


}
