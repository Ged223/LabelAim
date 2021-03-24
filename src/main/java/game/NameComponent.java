package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class NameComponent extends Component {

    private String name;
    private Text nameText = new Text();

    public NameComponent(){

    }


    @Override
    public void onAdded() {
        name = generateName();
        nameText.setText(name);
        FXGL.getGameScene().addUINode(nameText);
    }

    @Override
    public void onUpdate(double tpf) {
        int centerPixelsAmount = (name.length()-4)*3;
        nameText.setTranslateX(entity.getX()-(centerPixelsAmount));
        nameText.setTranslateY(entity.getY()+(entity.getHeight()*2.3));
    }

    @Override
    public void onRemoved() {
        FXGL.getGameScene().removeUINode(nameText);
    }

    private String generateName(){
        char letter = (char) FXGL.random(65,90);
        return Character.toString(letter);
    }

    public String getName() {
        return name;
    }
}
