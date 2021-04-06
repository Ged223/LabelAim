package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.util.Duration;

public class PlayerAnimationComponent extends Component {
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalk;

    public PlayerAnimationComponent() {
        animIdle = new AnimationChannel(FXGL.image("player_animation.png"), 3, 154, 121, Duration.seconds(1), 0, 0);
        animWalk = new AnimationChannel(FXGL.image("player_animation.png"), 3, 154, 121, Duration.seconds(1), 0, 2);
        texture = new AnimatedTexture(animIdle);
    }

    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(new Point2D(77, 60));
        entity.getViewComponent().addChild(texture);
        entity.setScaleX(-1);
    }

    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        if (texture.getAnimationChannel() == animIdle)
            texture.loopAnimationChannel(animWalk);
    }

}
