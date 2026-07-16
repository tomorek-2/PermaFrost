package JavaCode.content;

import mindustry.Vars;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.meta.BuildVisibility;
import world.block.anything.HeatConveyor;
import world.block.anything.HeatDrill;
import world.block.anything.HeatWall;
import world.block.realHeat.BlockHeat;


public class PermaFrostContent extends Mod {
   public Block block;
   public static OreBlock nickelOre, chromiumOre;
   public  static Item chromium, nickel;
   public static  BlockHeat blockHeat;
   public static HeatConveyor heatConveyor;
   public static HeatDrill heatDrill;
   public static HeatWall heatWall;
    public static void load() {
chromium = new Item("chromium") {{
    cost = 2f;
    hardness = 2;
}};
nickel = new Item("nickel") {{
cost = 3f;
hardness = 2;
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
heatConveyor = new HeatConveyor("HeatConveyor") {{
   health = 20;
   category = Category.crafting;
   buildVisibility = BuildVisibility.shown;
    speed = 0.08f;
    displayedSpeed = 11f;
}};
heatDrill = new HeatDrill("HeatDrill") {{
    size = 3;
    consumePower(3f);
    health = 600;
    tier = 2;
    buildVisibility = BuildVisibility.shown;
    category = Category.production;
}};
heatWall = new HeatWall("HeatWall") {{
   health = 300;
   category = Category.defense;
   buildVisibility = BuildVisibility.shown;
}};
    }


    }