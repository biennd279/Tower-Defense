package townerdefense.engine;

import townerdefense.engine.entity.DestroyableEntity;
import townerdefense.engine.entity.Entity;
import townerdefense.engine.entity.SpawnableEntity;
import townerdefense.engine.entity.UpdatableEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameField implements Serializable {
    private List<Entity> entities;
    private List<Entity> spawnedEntity = new ArrayList<>();
    private List<Entity> destroyEntity = new ArrayList<>();

    public GameField() {
        this.entities = new ArrayList<>();
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void removeAllEntity(Collection<Entity> entities) {
        this.entities.removeAll(entities);
    }

    public void addEntity(Entity entity) {
        System.out.println("Add Entity");
        entities.add(entity);
    }

    public void addAllEntity(Collection<? extends Entity> entities) {
        this.entities.addAll(entities);
    }

    public Collection<Entity> getListEntries() {
        return entities;
    }

    //Todo update all enemy
    public void updateEnemy(int deltaTime) {
        //Step by step update game field
        //1. Update state
        //2. Update destroyable entity
        //3. Update spawnalbe entity


        //Update state
        this.entities.forEach(entity -> {
            if (entity instanceof UpdatableEntity) {
                ((UpdatableEntity) entity).update(deltaTime);
                //System.out.println(deltaTime);
            }
        });
        //Update destroyable entity
        this.entities.forEach(entity -> {
            if (entity instanceof DestroyableEntity && ((DestroyableEntity) entity).isDestroy()) {
                destroyEntity.add(entity);
            }
        });

        destroyEntity.forEach(entity -> ((DestroyableEntity) entity).onDestroy());
        this.entities.removeAll(destroyEntity);
        destroyEntity.clear();
        //Update spawnalbe entity
        this.entities.forEach(entity -> {
            if (entity instanceof SpawnableEntity) {

                if (((SpawnableEntity) entity).hasEntityToSpawn(deltaTime)) {
                    spawnedEntity.add(((SpawnableEntity) entity).spawn(deltaTime));
                } else if (((SpawnableEntity) entity).hasEntitiesToSpawn(deltaTime)) {
                    spawnedEntity.addAll(((SpawnableEntity) entity).spawnAll(deltaTime));
                }
            }
        });
        //Add them to game field
        this.entities.addAll(spawnedEntity);
        spawnedEntity.clear();
    }
}
