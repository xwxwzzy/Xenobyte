package forgefuck.team.xenobyte.module.NONE;

import org.lwjgl.input.Keyboard;

import forgefuck.team.xenobyte.api.module.PerformMode;
import forgefuck.team.xenobyte.api.module.PerformSource;
import forgefuck.team.xenobyte.api.module.CheatModule;
import forgefuck.team.xenobyte.gui.click.XenoGuiScreen;

public class XenoGui extends CheatModule {
    
    @Override public void onPreInit() {
        setKeyBind(Keyboard.KEY_B);
    }
    
    @Override public PerformMode performMode() {
        return PerformMode.SINGLE;
    }
    
    @Override public void onPerform(PerformSource type) {
        utils.openGui(new XenoGuiScreen(moduleHandler()), true);
    }
    
    @Override public boolean allowStateMessages() {
        return false;
    }

}