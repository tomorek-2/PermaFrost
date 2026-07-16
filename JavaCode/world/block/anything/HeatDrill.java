package world.block.anything;

import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.production.Drill;

public class HeatDrill extends Drill {
    public HeatDrill(String name) {
        super(name);
update = true;

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
        @Override
    public void updateTile() {
if(JavaCode.ModomodrekMain.HeatXYInt[tile.x][tile.y] >= 6f) {
    super.updateTile();

}
        }

}
}
