package world.block.anything;

import JavaCode.ModomodrekMain;
import arc.math.geom.Point2;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.Vars;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.distribution.Conveyor;
import world.block.realHeat.BlockHeat;

public class HeatConveyor extends Conveyor {
    public HeatConveyor(String name) {
        super(name);
        update = true;
        sync = true;

    }
    @Override
    public void setBars() {
        super.setBars();
        addBar("LevelHeat", (HeatConveyor.HeatConveyorBuild entity) -> new Bar(
                () -> "Heat: " + ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y],
                () -> Pal.ammo,
                () -> ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y] / 100f

        ));

    }
    public class HeatConveyorBuild extends ConveyorBuild {
        int currentHeat;

@Override
        public void updateTile() {

    if (Vars.net.server() || !Vars.net.active()) {
        if (ModomodrekMain.HeatXYInt[tile.x][tile.y] <= 3f) {
return;
        } else {
            super.updateTile();
        }
    } else {
        if (ModomodrekMain.HeatXYInt[tile.x][tile.y] <= 3f)
            return;
        super.updateTile();
    }
        }

        @Override
        public void write(Writes write) {
            super.write(write);
            write.i(JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y]);
        }



        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);
            JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] = read.i();

        }


        @Override
        public void writeSync(Writes write) {

            super.writeSync(write);
            write.i(JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y]);
        }
            @Override
            public void readSync (Reads read,byte revision)
            {
                super.readSync(read, revision);
                JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] = read.i();
            }
        }
    }


