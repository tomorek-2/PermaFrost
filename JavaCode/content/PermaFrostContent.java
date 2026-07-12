package JavaCode.content;

import mindustry.Vars;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.meta.BuildVisibility;
import world.block.anything.HeatConveyor;
import world.block.realHeat.BlockHeat;


public class PermaFrostContent extends Mod {
   public Block block;
   public static OreBlock nickelOre, chromiumOre;
   public  static Item chromium, nickel;
   public static  BlockHeat blockHeat;
   public static HeatConveyor HeatConveyor;
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
blockHeat = new BlockHeat("BlockHeat") {{
    health = 10;
    category = Category.crafting;
    buildVisibility = BuildVisibility.shown;
}};
HeatConveyor = new HeatConveyor("HeatConveyor") {{
   health = 20;
   category = Category.crafting;
   buildVisibility = BuildVisibility.shown;
    speed = 0.08f;
    displayedSpeed = 11f;
}};

    }


    }