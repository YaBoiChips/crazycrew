package yaboichips.crazycrew.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.common.items.Denki;
import yaboichips.crazycrew.common.items.DrinkItem;
import yaboichips.crazycrew.common.items.FireSword;

import java.util.ArrayList;
import java.util.List;

public class CCItems {

    public static List<Item> items = new ArrayList<>();

    public static final CreativeModeTab TAB = new CreativeModeTab(CrazyCrew.MOD_ID) {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.APPLE);
        }
    };
    public static final Item DENKI = createItem(new Denki(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "denki");
    public static final Item FIRE_SWORD = createItem(new FireSword(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "fire_sword");


    public static final Item CELERY = createItem(new Item(new Item.Properties().food(CCFood.CELERY).tab(TAB)), "celery");
    public static final Item MACAROONS = createItem(new Item(new Item.Properties().food(CCFood.MACAROONS).tab(TAB)), "macaroons");
    public static final Item GOLDEN_CHEEZE_ITS = createItem(new Item(new Item.Properties().food(CCFood.GOLDEN_CHEEZE_ITS).tab(TAB)), "golden_cheeze_its");
    public static final Item KETCHUP_CHIPS = createItem(new Item(new Item.Properties().food(CCFood.KETCHUP_CHIPS).tab(TAB)), "ketchup_chips");
    public static final Item PIE = createItem(new Item(new Item.Properties().food(CCFood.PIE).tab(TAB)), "pie");
    public static final Item STIMPACK = createItem(new Item(new Item.Properties().food(CCFood.STIMPACK).tab(TAB)), "stimpack");
    public static final Item COFFEE = createItem(new DrinkItem(new Item.Properties().food(CCFood.COFFEE).tab(TAB)), "coffee");
    public static final Item CHICKEN_STRIPS = createItem(new Item(new Item.Properties().food(CCFood.CHICKEN_STRIPS).tab(TAB)), "chicken_strips");
    public static final Item LOBSTER_BISQUE = createItem(new BowlFoodItem(new Item.Properties().food(CCFood.LOBSTER_BISQUE).tab(TAB)), "lobster_bisque");
    public static final Item FREEZE_DRIED_ICE_CREAM = createItem(new Item(new Item.Properties().food(CCFood.FREEZE_DRIED_ICE_CREAM).tab(TAB)), "freeze_dried_ice_cream");
    public static final Item ONIGIRI = createItem(new Item(new Item.Properties().food(CCFood.ONIGIRI).tab(TAB)), "onigiri");
    public static final Item CHOCKOLATE_MILK = createItem(new DrinkItem(new Item.Properties().food(CCFood.CHOCKOLATE_MILK).tab(TAB)), "chocolate_milk");

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
