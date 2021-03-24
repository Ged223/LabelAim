package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.util.Duration;

public class EnemyAnimationComponent extends Component {
    private AnimatedTexture texture;
    private AnimationChannel animIdle;

    public EnemyAnimationComponent() {
        animIdle = new AnimationChannel(FXGL.image("enemy_animation.png"), 4, 104, 103, Duration.seconds(1), 0, 0);

        texture = new AnimatedTexture(animIdle);
    }

    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(new Point2D(16, 21));
        entity.getViewComponent().addChild(texture);
        entity.setScaleX(1);
    }

    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        texture.loopAnimationChannel(animIdle);
    }
}
