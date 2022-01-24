package yaboichips.crazycrew;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

import static yaboichips.crazycrew.CrazyCrew.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class CrazyCrew {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "crazycrew";

    public CrazyCrew() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
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

    /********** TODO ************/
    /**
     - Me (Sweater, Pie, Drumstick)
     - Billy (Chadwick, Luck Sword, Macaroons)
     - Jared (Golden Cheeze-Its, Ocarina, Fire Sword)
     - Johnny (Lightning Sword, Ketchup Chips, Waifu)
     - Cole (Smart Car, Claymore Sword, Celery Sticks)
     - Ruby (Lil Boost Sword (thot slayer), Onigiri (sat and strength), Paladins Necklace (milk))
     - Logan (Space Helmet (double jump), Freeze Dried Ice Cream, LightSaber)
     - Cam (Grappling Hook, Lobster Bisque, Colapsable Sword)
     - James (Uno Reverse Card, Chicken Strips, Minigun?)
     - Sam (Coffee, Stick of Sadness, Hair Dye (invis))
     - Taede (Gun (Phantom AK-47 thing), Ninja Smoke Bomb, Stimpack?)
     **/

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("HELLO from Register Block");
        }
    }
}
