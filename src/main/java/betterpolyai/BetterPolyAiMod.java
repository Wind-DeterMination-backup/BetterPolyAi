package betterpolyai;

import arc.Events;
import betterpolyai.features.PolyAiFeature;
import mindustry.game.EventType;
import mindustry.gen.Icon;
import mindustry.mod.Mod;

import static mindustry.Vars.ui;

public class BetterPolyAiMod extends Mod {

    private static boolean settingsAdded;

    @Override
    public void init() {
        PolyAiFeature.init();

        Events.on(EventType.ClientLoadEvent.class, e -> {
            if (settingsAdded) return;
            settingsAdded = true;

            GithubUpdateCheck.applyDefaults();

            ui.settings.addCategory("@settings.betterpolyai", Icon.units, PolyAiFeature::buildSettings);
            GithubUpdateCheck.checkOnce();
        });
    }
}
