package world.block.anything;

import JavaCode.ModomodrekMain;
import arc.math.geom.Point2;
import mindustry.world.blocks.distribution.Conveyor;

public class HeatConveyor extends Conveyor {
    public HeatConveyor(String name) {
        super(name);
        update = true;
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

