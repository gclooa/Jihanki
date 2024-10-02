package looa.jihanki;

import looa.jihanki.block.ModBlocks;
import looa.jihanki.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jihanki implements ModInitializer {
	public static final String MOD_ID = "jihanki";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Jihanki!");
		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(
					new Identifier(MOD_ID, "jihanki_ctm"),
					modContainer,
					Text.translatable("resourcePack.jihanki.jihanki_ctm.name"),
					ResourcePackActivationType.DEFAULT_ENABLED);
		});
		ModItems.initialize();
		ModBlocks.initialize();
	}
}