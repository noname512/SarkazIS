package SarkazIS;

import SarkazIS.TreeHole.TreeHoleSarkaz;
import basemod.*;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.screens.custom.CustomMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import TreeHole.mod.TreeHoleBase;
import TreeHole.mod.TreeHoleMod;

import java.nio.charset.StandardCharsets;
import java.util.*;

@SpireInitializer
public class SarkazIS implements EditRelicsSubscriber, EditStringsSubscriber, PostBattleSubscriber, PostInitializeSubscriber, PostDungeonInitializeSubscriber, AddCustomModeModsSubscriber, OnStartBattleSubscriber, OnPlayerLoseBlockSubscriber, RelicGetSubscriber {

    private static final Logger logger = LogManager.getLogger(SarkazIS.class.getName());
    public static String MOD_ID = "SarkazIS";

    public boolean isDemo = false;

    public SarkazIS() {
        BaseMod.subscribe(this);
    }

    @SuppressWarnings("unused")
    public static void initialize() {
        new SarkazIS();
    }

    @Override
    public void receivePostInitialize() {
    }

    private void initializeEvents() {
//        BaseMod.addEvent(new AddEventParams.Builder(Encounter.ID, Encounter.class).
//                eventType(EventUtils.EventType.ONE_TIME).
//                endsWithRewardsUI(false).
//                spawnCondition(() -> false).
//                create());
    }

    @Override
    public void receivePostDungeonInitialize() {
        TreeHoleMod.registerTreeHole("samirg:TheSami", (TreeHoleBase)new TreeHoleSarkaz());
    }

    @Override
    public void receiveCustomModeMods(List<CustomMod> modList) {
    }

    @Override
    public int receiveOnPlayerLoseBlock(int cnt) {
        return cnt;
    }

    @Override
    public void receiveOnBattleStart(AbstractRoom room) {}

    @Override
    public void receivePostBattle(final AbstractRoom p0) {}

    @Override
    public void receiveRelicGet(AbstractRelic r) {}

    @Override
    public void receiveEditRelics() {
        // common.
//        BaseMod.addRelic(new BagOfIdeas(), RelicType.SHARED);

        // uncommon.

        // rare.

        // event.
    }

    @Override
    public void receiveEditStrings() {
        String lang = getLang();
        String relicStrings = Gdx.files.internal("resources/SarkazIS/strings/" + lang + "/relics.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        String powerStrings = Gdx.files.internal("resources/SarkazIS/strings/" + lang + "/powers.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);
        String monsterStrings = Gdx.files.internal("resources/SarkazIS/strings/" + lang + "/monsters.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(MonsterStrings.class, monsterStrings);
    }

    private String getLang() {
//        String lang = "eng";
//        if (Settings.language == Settings.GameLanguage.ZHS || Settings.language == Settings.GameLanguage.ZHT) {
//            lang = "zhs";
//        }
//        return lang;
        return "zhs";
    }
}