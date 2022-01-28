package yaboichips.crazycrew.core;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class CCKeybinds {

    public static KeyMapping USE_ITEM = new KeyMapping("Crazy Items", GLFW.GLFW_KEY_I, "Use Item");

    public static void register() {
        ClientRegistry.registerKeyBinding(USE_ITEM);
    }

}
