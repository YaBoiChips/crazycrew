package yaboichips.crazycrew.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import yaboichips.crazycrew.CrazyCrew;

import java.util.ArrayList;
import java.util.List;

public class CCItems {

    public static List<Item> items = new ArrayList<>();

    public static final CreativeModeTab TWEAKS_TAB = new CreativeModeTab(CrazyCrew.MOD_ID) {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.APPLE);
        }
    };


    public static Item createItem(Item item, String id) {
        return createItem(item, CrazyCrew.createResource(id));
    }

    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
            item.setRegistryName(id);

            items.add(item);

            return item;
        } else return null;
    }

    public static void init() {
    }
}
