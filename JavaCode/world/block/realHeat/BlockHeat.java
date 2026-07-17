package world.block.realHeat;

import JavaCode.ModomodrekMain;
import arc.Core;
import arc.math.Mathf;
import arc.math.geom.Point2;
import arc.struct.EnumSet;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.graphics.Pal;
import mindustry.type.Item;
import mindustry.ui.Bar;
import mindustry.world.Block;
import mindustry.world.Build;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;
import world.block.anything.HeatWall;

public class BlockHeat extends Block {
    public BlockHeat(String name){
        super(name);
        hasItems = true;
        solid = true;
        update = true;
        sync = true;
        destructible = true;
        separateItemCapacity = true;
        group = BlockGroup.transportation;
        flags = EnumSet.of(BlockFlag.storage);
        allowResupply = true;
        envEnabled = Env.any;
        drawCached = true;
        drawDynamic = false;
    }
    @Override
    public void setBars() {
        super.setBars();
                addBar("LevelHeat", (BlockHeatBuildIng entity) -> new Bar(
                        () -> "Heat: " + ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y],
                        () -> Pal.ammo,
                        () -> ModomodrekMain.HeatXYInt[entity.tile.x][entity.tile.y] / 100f

                ));

    }
    public class BlockHeatBuildIng extends Building {

        @Override
        public void updateTile() {
            if (timer(0, 10)) {
                int xblock = tile.x;
                int yblock = tile.y;
int xx;
int xy;
                for (int i = 0; i < 500; i += 8) {
                    for (int x = 0; x < 10; x++) {
                        float xd = Mathf.cosDeg(i) * x + xblock;
                        float yd = Mathf.sinDeg(i) * x + yblock;

                        int xdint = (int) xd;
                        int ydint = (int) yd;


                        int Heat = 10 - x;

                        if (xdint > -1 && ydint > -1) {
                            if(xdint < Vars.world.width() && ydint < Vars.world.height()) {
                                if (Heat >= ModomodrekMain.HeatXYInt[xdint][ydint]) {
                                    Building build = Vars.world.build(xdint, ydint);

                                    if (build != null && build instanceof HeatWall.HeatWallBuilding) {
                                        float xd001 = Mathf.cosDeg(i) * (xx=x-1) + xblock;
                                        float yd001 = Mathf.sinDeg(i) * (xy=x-1) + yblock;

                                        int xdint001 = (int) xd001;
                                        int ydint001 = (int) yd001;
                                        if(xdint001 < Vars.world.width() && ydint001 < Vars.world.height() && xdint001 > -1 && ydint001 > -1) {
                                          int
                                            heat001 = Heat + 1;
                                            ModomodrekMain.HeatXYInt[xdint001][ydint001] = heat001;
                                        }
                                            break;

                                    }

                                    ModomodrekMain.HeatXYInt[xdint][ydint] = Heat;
                                }
                            }
                        }
                    }
                }

            }
        }

public void onRemoved(){

    for(int i = 0; i < 500; i += 8) {
        for(int x = 0; x < 10; x++) {
            float xd = Mathf.cosDeg(i) * x + tile.x;
            float yd = Mathf.sinDeg(i) * x + tile.y;

            int xdint = (int) xd;
            int ydint = (int) yd;



            //  ModomodrekMain.HeatMap.put(new Point2(xdint, ydint), Heat);
            if(xdint > -1 && ydint > -1) {
if(xdint < Vars.world.width() && ydint < Vars.world.height()) {


    ModomodrekMain.HeatXYInt[xdint][ydint] = 0;
}
            }
        }
    }
    super.onRemoved();
}

    }
}
