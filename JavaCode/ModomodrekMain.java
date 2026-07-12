package JavaCode;

import arc.math.geom.Point2;
import arc.struct.IntSeq;
import arc.struct.ObjectIntMap;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.mod.Mod;

public class ModomodrekMain extends Mod {
    public static ObjectIntMap<Point2> HeatMap = new ObjectIntMap<>();
    @Override
    public void init() {
        Vars.mods.getMod("tomodrek").meta.hidden = true;
    }
    @Override
    public void loadContent() {
        JavaCode.content.PermaFrostContent.load();
    }
}
