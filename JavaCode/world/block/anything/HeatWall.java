package world.block.anything;

import mindustry.gen.Building;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.defense.Wall;
import world.block.realHeat.BlockHeat;

public class HeatWall extends Wall {


    public HeatWall(String name) {
        super(name);
        update = true;
    }

    @Override
    public void setBars() {
        super.setBars();
        addBar("LevelHeat", (HeatWallBuilding entity) -> new Bar(
                () -> "Heat: " + JavaCode.ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y],
                () -> Pal.ammo,
                () -> JavaCode.ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y] / 100f

        ));
    }

    public class HeatWallBuilding extends WallBuild {
        @Override
        public void updateTile() {
            if (timer(0, 20)) {
                if(JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] > 0) JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] -= 1f;
                if (JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] >= 6f) {
                    super.updateTile();
                }
            }
        }
    }
}
