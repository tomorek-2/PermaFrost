package world.block.anything;

import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.production.Drill;

public class HeatDrill extends Drill {
    public HeatDrill(String name) {
        super(name);
update = true;
sync = true;
    }
    public void setBars() {
        super.setBars();
        addBar("LevelHeat", (HeatDrill.HeatDrillBuild entity) -> new Bar(
                () -> "Heat: " + JavaCode.ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y],
                () -> Pal.ammo,
                () -> JavaCode.ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y] / 100f

        ));

    }
public class HeatDrillBuild extends DrillBuild {
int  currentHeat;
    @Override
    public void updateTile() {

if(JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] >= 6f) {
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
