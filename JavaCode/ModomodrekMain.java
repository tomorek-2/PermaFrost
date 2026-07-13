package JavaCode;

import arc.Events;
import arc.input.KeyCode;
import arc.math.geom.Point2;
import arc.struct.IntIntMap;
import arc.struct.IntSeq;
import arc.struct.ObjectIntMap;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class ModomodrekMain extends Mod {
int sizeXHeat = 2000;
    int sizeYHeat = 2000;
    public static int[][] HeatXYInt = new int[2000][2000];
    @Override
    public void init() {
if(!Vars.headless) {
    Events.run(EventType.Trigger.update, () -> {
        if (arc.Core.input.keyDown(KeyCode.f2)) Vars.mods.getMod("permafrost").meta.hidden = true;
    });
}
        Events.on(EventType.WorldLoadEvent.class, event -> {
         //  HeatXYInt = new int[Vars.world.width()][Vars.world.height()];
            HeatXYInt = new int[sizeXHeat++][sizeYHeat++];
        });

    }
    @Override
    public void loadContent() {
        JavaCode.content.PermaFrostContent.load();
    }
}
