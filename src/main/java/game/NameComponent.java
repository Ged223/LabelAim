package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.text.Text;


public class NameComponent extends Component {

    private String name;
    private Text nameText = new Text();

    public NameComponent(){

    }

    @Override
    public void onAdded() {
        name = "namePlaceholder";
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
        super.onRemoved();
    }
}
