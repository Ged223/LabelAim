package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class NameComponent extends Component {
    private NameProvider nameProvider;
    private String name;
    private Text nameText = new Text();

    public NameComponent() {
        nameText.setStroke(Color.WHITE);
        nameProvider = new NameProvider();
    }

    @Override
    public void onAdded() {
        name = nameProvider.nextName();
        nameText.setText(name);
        FXGL.getGameScene().addUINode(nameText);
    }

    @Override
    public void onUpdate(double tpf) {
        int centerPixelsAmount = (name.length() - 15) * 3;
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
