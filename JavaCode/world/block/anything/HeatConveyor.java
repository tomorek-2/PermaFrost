package world.block.anything;

import JavaCode.ModomodrekMain;
import arc.math.geom.Point2;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.distribution.Conveyor;
import world.block.realHeat.BlockHeat;

public class HeatConveyor extends Conveyor {
    public HeatConveyor(String name) {
        super(name);
        update = true;
    }
    @Override
    public void setBars() {
        super.setBars();
        addBar("LevelHeat", (HeatConveyor.HeatConveyorBuild entity) -> new Bar(
                () -> "Heat: " + ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y],
                () -> Pal.ammo,
                () -> ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y] / 10f

        ));

    }
    public class HeatConveyorBuild extends ConveyorBuild {
public void updateTile() {
    //super.updateTile();
    if(ModomodrekMain.HeatXYInt[tile.x][tile.y] <= 3f) {
        return;
    }
    super.updateTile();
}

    }
    }

