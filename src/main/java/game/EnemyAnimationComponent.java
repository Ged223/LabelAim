package game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.getSceneService;
import static com.almasb.fxgl.dsl.FXGL.runOnce;
import static javafx.util.Duration.seconds;

public class EnemyAnimationComponent extends Component {
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animBoom;

    public EnemyAnimationComponent() {
        animBoom = new AnimationChannel(FXGL.image("enemy_animation.png"), 4, 104, 103, Duration.seconds(1.5), 0, 3);
        animIdle = new AnimationChannel(FXGL.image("enemy_animation.png"), 4, 104, 103, Duration.seconds(1), 0, 0);

        texture = new AnimatedTexture(animIdle);
    }

    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(new Point2D(52, 52));
        entity.getViewComponent().addChild(texture);
        entity.setScaleX(1);
    }

    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);
    }

    public void onDeath() {
        entity.getComponent(ProjectileComponent.class).setSpeed(0);
        texture.playAnimationChannel(animBoom);
        FXGL.play("explosion.wav");
        runOnce(() -> {
            entity.removeFromWorld();
        }, seconds(1.5));
    }
}
