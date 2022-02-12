package yaboichips.crazycrew;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yaboichips.crazycrew.client.models.*;
import yaboichips.crazycrew.client.renderers.*;
import yaboichips.crazycrew.common.entites.Chadwick;
import yaboichips.crazycrew.common.entites.TheWhip;
import yaboichips.crazycrew.common.entites.Waifu;
import yaboichips.crazycrew.core.CCEntities;
import yaboichips.crazycrew.core.CCItems;
import yaboichips.crazycrew.core.CCKeybinds;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

import static yaboichips.crazycrew.CrazyCrew.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public final class CrazyCrew {

    public static final String MOD_ID = "crazycrew";
    private static final Logger LOGGER = LogManager.getLogger();

    public CrazyCrew() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addListener(this::registerEntityRenderers);
        modEventBus.addListener(this::entityAttributes);
        modEventBus.addListener(this::bakeLayers);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static @Nonnull
    ResourceLocation createResource(final String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public void bakeLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TheWhipModel.LAYER_LOCATION, TheWhipModel::createBodyLayer);
        event.registerLayerDefinition(ThrowingKnifeModel.LAYER_LOCATION, ThrowingKnifeModel::createBodyLayer);
        event.registerLayerDefinition(WaifuModel.LAYER_LOCATION, WaifuModel::createBodyLayer);
        event.registerLayerDefinition(ChadwickModel.LAYER_LOCATION, ChadwickModel::createBodyLayer);
        event.registerLayerDefinition(BulletModel.LAYER_LOCATION, BulletModel::createBodyLayer);

    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers renderer) {
        renderer.registerEntityRenderer(CCEntities.WHIP, TheWhipRenderer::new);
        renderer.registerEntityRenderer(CCEntities.THROWING_KNIFE, ThrowingKnifeRenderer::new);
        renderer.registerEntityRenderer(CCEntities.PIE, ThrownItemRenderer::new);
        renderer.registerEntityRenderer(CCEntities.WAIFU, WaifuRenderer::new);
        renderer.registerEntityRenderer(CCEntities.CHADWICK, ChadwickRenderer::new);
        renderer.registerEntityRenderer(CCEntities.BULLET, BulletRenderer::new);

    }

    public void entityAttributes(final EntityAttributeCreationEvent event) {
        event.put(CCEntities.WHIP, TheWhip.createAttributes().build());
        event.put(CCEntities.WAIFU, Waifu.createAttributes().build());
        event.put(CCEntities.CHADWICK, Chadwick.createAttributes().build());
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("CrazyCrew: Loadup stage: PREINIT");
    }

    private void doClientStuff(FMLClientSetupEvent event) {
        CCKeybinds.register();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(MOD_ID, "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }


    private void processIMC(final InterModProcessEvent event) {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    /**
     * - Me (`Sweater, `Pie, `Zod Swod)
     * - Johnny (`Lightning Sword, `Ketchup Chips, `Waifu)
     * <p>
     * - Billy (`Chadwick, `Luck Sword, `Macaroons)
     * - Jared (`Golden Cheeze-Its, `Ocarina, `Fire Sword)
     * <p>
     * - Cole (`Smart Car, `Claymore Sword, `Celery Sticks)
     * - Ruby (`Lil Boost Sword (thot slayer), `Onigiri (sat and strength), Paladins Necklace (milk))
     * <p>
     * - Logan (`Space Helmet (double jump), Freeze Dried Ice Cream, `Lightsaber)
     * - Jake (`Speed Boots WHEEEEE (lightning maybe), `Chocolate Milk, 'Throwing Knife)
     * <p>
     * - Sam (`Coffee, `Stick of Sadness, `Hair Dye (invis))
     * <p>
     * - Taede (`Gun (Phantom AK-47 thing), `Ninja Smoke Bomb, `Stimpack?)
     * - James (`Uno Reverse Card, `Chicken Strips, Minigun?)
     **/

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("CrazyCrew: Loadup stage: SRVSTART");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("CrazyCrew: Loadup stage: Registering blocks");
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            LOGGER.debug("CrazyCrew: Loadup stage:  Registering items...");
            CCItems.init();
            CCItems.items.forEach(item -> event.getRegistry().register(item));
            CCItems.items.clear();
            CCItems.items = null;
            LOGGER.info("CrazyCrew: Items registered!");
        }

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
            LOGGER.debug("CrazyCrew: Loadup Stage: Preparing Entities");
            CCEntities.init();
            CCEntities.entities.forEach(entityType -> event.getRegistry().register(entityType));
            CCEntities.entities.clear();
            CCEntities.entities = null;
            LOGGER.info("Entities registered!");
        }
    }
}
