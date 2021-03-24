package game;

import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.entityBuilder;

public class OurFactory implements EntityFactory {

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        return entityBuilder(data)
                .viewWithBBox(new Rectangle(40, 40, Color.BLUE))
                .build();
    }

    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        return entityBuilder(data)
                .viewWithBBox(new Rectangle(30, 15, Color.RED))
                .with(new ProjectileComponent(new Point2D(1, 0),200))
                .with(new NameComponent())
                .build();
    }

}
