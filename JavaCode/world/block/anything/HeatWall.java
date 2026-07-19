package world.block.anything;

import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.defense.Wall;
import world.block.realHeat.BlockHeat;

public class HeatWall extends Wall {


    public HeatWall(String name) {
        super(name);
        update = true;
        sync = true;
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

        public int currentHeat = 0;
        @Override
        public void updateTile() {
            if (Vars.net.server() || !Vars.net.active()) {
                if (timer(0, 20)) {
                    if (JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] > 0)
                        JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] -= 1f;
                    if (JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] >= 6f) {
                        super.updateTile();
                    }
                }
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
            JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y]     = read.i();

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
