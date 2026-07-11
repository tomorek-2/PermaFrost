package JavaCode.content;

import mindustry.Vars;
import mindustry.mod.Mod;
import mindustry.type.Item;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;


public class PermaFrostContent extends Mod {
   public Block block;
   public static OreBlock nickelOre, chromiumOre;
   public  static Item chromium, nickel;
    public static void load() {
chromium = new Item("chromium") {{
    cost = 2f;
}};
nickel = new Item("nickel") {{
cost = 3f;
}};
nickelOre = new OreBlock("nickel-ore") {{
   variants = 3;
   itemDrop = nickel;
}};
chromiumOre = new OreBlock("chromium-ore") {{
variants = 3;
itemDrop = chromium;
}};



    }


    }