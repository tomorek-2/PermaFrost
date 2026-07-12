package world.block.realHeat;

import JavaCode.ModomodrekMain;
import arc.math.Mathf;
import arc.math.geom.Point2;
import arc.struct.EnumSet;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.world.Block;
import mindustry.world.Build;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;

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
    public class BlockHeatBuildIng extends Building {

        @Override
        public void updateTile(){
            int xblock = tile.x;
            int yblock = tile.y;

            for(int i = 0; i < 700; i += 3) {
                for(int x = 0; x < 10; x++) {
                    float xd = Mathf.cosDeg(i) * x + xblock;
                    float yd = Mathf.sinDeg(i) * x + yblock;

                    int xdint = (int) xd;
                    int ydint = (int) yd;


                    int Heat = 10 - x;
                  //  ModomodrekMain.HeatMap.put(new Point2(xdint, ydint), Heat);
                    if(xdint > -1 && ydint > -1) {

if(Heat >= ModomodrekMain.HeatXYInt[xdint][ydint]) {


    ModomodrekMain.HeatXYInt[xdint][ydint] = Heat;
}
                    }
                }
            }

        }
public void onRemoved(){
    for(int i = 0; i < 700; i += 3) {
        for(int x = 0; x < 10; x++) {
            float xd = Mathf.cosDeg(i) * x + tile.x;
            float yd = Mathf.sinDeg(i) * x + tile.y;

            int xdint = (int) xd;
            int ydint = (int) yd;



            //  ModomodrekMain.HeatMap.put(new Point2(xdint, ydint), Heat);
            if(xdint > -1 && ydint > -1) {




                    ModomodrekMain.HeatXYInt[xdint][ydint] = 0;

            }
        }
    }
}

    }
}
