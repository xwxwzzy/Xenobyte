package forgefuck.team.xenobyte.module.MODS;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import forgefuck.team.xenobyte.api.module.CheatModule;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.MouseEvent;

public class MekOpener extends CheatModule {
    
    @SubscribeEvent public void mouseEvent(MouseEvent e) {
        if (e.button == 1 && e.buttonstate) {
            TileEntity checkTile = utils.tile();
            try {
                if (Class.forName("mekanism.common.tile.TileEntityBasicBlock").isInstance(checkTile)) {
                    if (Class.forName("mekanism.common.tile.TileEntityPersonalChest").isInstance(checkTile)) {
                        utils.sendPacket("MEK", (byte) 2, 1, true, utils.coords(checkTile), utils.worldId());
                    } else {
                        int guiId = (int) Class.forName("mekanism.common.CommonProxy").getMethod("getGuiId", Block.class, int.class).invoke(Class.forName("mekanism.common.Mekanism").getField("proxy").get(null), checkTile.blockType, checkTile.blockMetadata);
                        utils.sendPacket("MEK", (byte) 18, utils.coords(checkTile), utils.worldId(), 0, guiId, 0);
                    }
                    e.setCanceled(true);
                } else if (Class.forName("mekanism.common.tile.TileEntityDigitalMiner").isInstance(checkTile)) {
                    utils.sendPacket("MEK", (byte) 19, 2, utils.coords(checkTile), utils.worldId(), 0, 0);
                    e.setCanceled(true);
                }
            } catch(Exception ex) {}
        }
    }
    
    @Override public String moduleDesc() {
        return "Открывашка некоторых блоков (даже приватных) из Mekanism по ПКМ в привате";
    }

    @Override public boolean isWorking() {
        return Loader.isModLoaded("Mekanism");
    }

}
