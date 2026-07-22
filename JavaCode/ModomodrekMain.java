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
import mindustry.gen.Icon;
import mindustry.mod.Mod;

public class ModomodrekMain extends Mod {
int sizeXHeat = 2000;
boolean InitHiddenMod = false;
    int sizeYHeat = 1750;
    arc.util.Timer timer = new arc.util.Timer();
    public static int[][] HeatXYInt = new int[50][50];
    @Override
    public void init() {
if(!Vars.headless) {
    if(!InitHiddenMod) {

          timer.schedule(() -> {
            InitHiddenMod = true;
            if (arc.Core.input.keyDown(KeyCode.f2)) {
                Vars.mods.getMod("permafrost").meta.hidden = true;
                timer.clear();
            }
        }, 5f, 0.20f);
    }
}

      /*  Events.on(EventType.WorldLoadEndEvent.class, event -> {
          HeatXYInt = new int[Vars.world.width()][Vars.world.height()];
          //  HeatXYInt = new int[sizeXHeat++][sizeYHeat++];
        }); */
Events.on(EventType.ClientLoadEvent.class, event -> {
    Vars.ui.settings.addCategory("КалькуляторUI", Icon.powerOld, table -> {
        JavaCode.ModomodrekUI.showCalculate(table);
    });
    });


    }
    @Override
    public void loadContent() {
    //    JavaCode.content.PermaFrostContent.load();
    }

}
