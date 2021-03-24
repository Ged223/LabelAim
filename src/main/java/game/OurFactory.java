package game;

import com.almasb.fxgl.dsl.components.OffscreenCleanComponent;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.entityBuilder;

public class OurFactory implements EntityFactory {

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        return entityBuilder(data)
                .type(EntityType.PLAYER)
                //.viewWithBBox(new Rectangle(40, 40, Color.BLUE))
                .with(new PlayerAnimationComponent())
                .build();
    }

    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        return entityBuilder(data)
                .type(EntityType.ENEMY)
                //.viewWithBBox(new Rectangle(30, 15, Color.RED))
                .with(new EnemyAnimationComponent())
                .with(new ProjectileComponent(new Point2D(1, 0),120))
                .with(new NameComponent())
                .with(new OffscreenCleanComponent())
                .build();
    }

}
