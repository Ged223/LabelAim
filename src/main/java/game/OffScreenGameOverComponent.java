package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.getWorldProperties;

public class OffScreenGameOverComponent extends Component {
    @Override
    public void onAdded() {
        super.onAdded();
    }

    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        if (entity.getX() > 1024) {
            getWorldProperties().booleanProperty("isPaused").setValue(true);
            FXGL.getGameController().pauseEngine();
            Text text = new Text();
            text.setFont(new Font(60));
            text.setStroke(Color.WHITE);
            text.setStrokeWidth(1.5);
            text.setTranslateX(FXGL.getAppWidth() / 2 - 350);
            text.setTranslateY(FXGL.getAppHeight() / 2);
            text.setText("           GAME OVER\n press CTRL+R to restart");
            FXGL.getGameScene().addUINode(text);
        }
    }

    @Override
    public void onRemoved() {
        super.onRemoved();
    }
}
