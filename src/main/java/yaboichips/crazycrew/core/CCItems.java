package yaboichips.crazycrew.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.common.items.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class CCItems {

    public static List<Item> items = new ArrayList<>();

    @Contract("null, !null -> fail; _, null -> null")
    public static @Nullable Item createItem(Item item, String id) {
        return createItem(item, CrazyCrew.createResource(id));
    }

    public static final @NotNull CreativeModeTab TAB = new CreativeModeTab(CrazyCrew.MOD_ID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new @NotNull ItemStack(MACARON);
        }
    };

    @Contract("null, !null -> fail; _, null -> null")
    public static @Nullable Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
            item.setRegistryName(id);

            items.add(item);

            return item;
        } else return null;
    }

    public static void init() {
    }

    public static final Item WAIFU_SPAWN_EGG = createItem(new SpawnEggItem(CCEntities.WAIFU, 0x500E0EFF, 0x3D2D2AFF, new Item.Properties().tab(TAB)), "waifu_spawn_egg");
    public static final Item CHADWICK_SPAWN_EGG = createItem(new SpawnEggItem(CCEntities.CHADWICK, 0x50E0EFF, 0x3D2D2AF, new Item.Properties().tab(TAB)), "chadwick_spawn_egg");


    public static final Item DENKI = createItem(new Denki(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "denki");
    public static final Item FIRE_SWORD = createItem(new FireSword(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "fire_sword");
    public static final Item LUCK_SWORD = createItem(new LuckSword(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "luck_sword");
    public static final Item ZOD_SWOD = createItem(new ZodSwod(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "zod_swod");
    public static final Item THOT_SLAYER = createItem(new ThotSlayer(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "thot_slayer");
    public static final Item STICK_OF_SADNESS = createItem(new StickOfSadness(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "stick_of_sadness");
    public static final Item CLAYMORE_SWORD = createItem(new SwordItem(Tiers.DIAMOND, 7, -3.8F, new Item.Properties().tab(TAB)), "claymore_sword");
    public static final Item UNO_REVERSE_CARD = createItem(new UnoReverseCard(new Item.Properties().tab(TAB)), "uno_reverse_card");
    public static final Item ZOOMY_BOOTS = createItem(new ZoomyBoots(CCArmors.JAKE, EquipmentSlot.FEET, new Item.Properties().tab(TAB)), "zoomy_boots");
    public static final Item COL_MUSTARD = createItem(new ColMustard(CCArmors.CHIPS, EquipmentSlot.CHEST, new Item.Properties().tab(TAB)), "col_mustard");
    public static final Item SPACE_HELMET = createItem(new SpaceHelmet(CCArmors.LOGAN, EquipmentSlot.HEAD, new Item.Properties().tab(TAB)), "space_helmet");
    public static final Item HAIR_DYE = createItem(new HairDye(new Item.Properties().tab(TAB)), "hair_dye");
    public static final Item OCARINA = createItem(new Ocarina(new Item.Properties().tab(TAB)), "ocarina");
    public static final Item SMOKE_BOMB = createItem(new SmokeBomb(new Item.Properties().tab(TAB)), "smoke_bomb");
    public static final Item THE_WHIP = createItem(new CarItem(new Item.Properties().tab(TAB)), "the_whip");
    public static final Item KEY = createItem(new Item(new Item.Properties().tab(TAB)), "key");
    public static final Item THROWING_KNIFE = createItem(new ThrowingKnife(Tiers.DIAMOND, 2, -2.4F, new Item.Properties().tab(TAB)), "throwing_knife");
    public static final Item SABER = createItem(new SaberItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(TAB)), "saber");
    public static final Item SABER_HANDLE = createItem(new SaberHandle(new Item.Properties().tab(TAB)), "saber_handle");
    public static final Item BULLET = createItem(new Item(new Item.Properties().tab(TAB)), "bullet");
    public static final Item GUN = createItem(new GunItem(new Item.Properties().tab(TAB)), "gun");
    public static final Item PALADINS_NECKLACE = createItem(new PaladinsNecklace(new Item.Properties().tab(TAB)), "paladins_necklace");


    public static final Item CELERY = createItem(new Item(new Item.Properties().food(CCFood.CELERY).tab(TAB)), "celery");
    public static final Item MACARON = createItem(new Item(new Item.Properties().food(CCFood.MACARON).tab(TAB)), "macaron");
    public static final Item GOLDEN_CHEEZE_ITS = createItem(new Item(new Item.Properties().food(CCFood.GOLDEN_CHEEZE_ITS).tab(TAB)), "golden_cheeze_its");
    public static final Item KETCHUP_CHIPS = createItem(new Item(new Item.Properties().food(CCFood.KETCHUP_CHIPS).tab(TAB)), "ketchup_chips");
    public static final Item PIE = createItem(new PieItem(new Item.Properties().food(CCFood.PIE).tab(TAB)), "pie");
    public static final Item STIMPACK = createItem(new Item(new Item.Properties().food(CCFood.STIMPACK).tab(TAB)), "stimpack");
    public static final Item COFFEE = createItem(new DrinkItem(new Item.Properties().food(CCFood.COFFEE).tab(TAB)), "coffee");
    public static final Item CHICKEN_STRIPS = createItem(new Item(new Item.Properties().food(CCFood.CHICKEN_STRIPS).tab(TAB)), "chicken_strips");
    public static final Item FREEZE_DRIED_ICE_CREAM = createItem(new Item(new Item.Properties().food(CCFood.FREEZE_DRIED_ICE_CREAM).tab(TAB)), "freeze_dried_ice_cream");
    public static final Item ONIGIRI = createItem(new Item(new Item.Properties().food(CCFood.ONIGIRI).tab(TAB)), "onigiri");
    public static final Item CHOCKOLATE_MILK = createItem(new DrinkItem(new Item.Properties().food(CCFood.CHOCKOLATE_MILK).tab(TAB)), "chocolate_milk");

    public static final Item MACARON_COOKIE = createItem(new Item(new Item.Properties().tab(TAB)), "macaron_cookie");
    public static final Item MACARON_FILLING = createItem(new Item(new Item.Properties().tab(TAB)), "macaron_filling");


}
