package SarkazIS.TreeHole;

import TreeHole.mod.TreeHoleBase;
import TreeHole.save.TreeHoleSave;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.saveAndContinue.SaveFile;
import encountermod.events.Encounter;
import com.megacrit.cardcrawl.random.Random;

import java.util.ArrayList;

public class TreeHoleSarkaz extends TreeHoleBase {
    //初始化层级
    @Override
    //currentType即树洞类型，用来作区分
    public AbstractDungeon getDungeon(AbstractPlayer abstractPlayer, ArrayList<String> arrayList, int i) {
        return (AbstractDungeon)new SakazHole(abstractPlayer, arrayList);
    }

    @Override
    //加载层级
    public AbstractDungeon getDungeon(AbstractPlayer abstractPlayer, SaveFile saveFile, int i) {
        return (AbstractDungeon)new SakazHole(abstractPlayer, saveFile);
    }

    @Override
    //根据树洞类型决定是否是BOSS层级，这里主要是决定BOSS是否渲染
    public boolean isBoss(int type) {
        return false; // TODO
    }

    @Override
    //树洞内BOSS房进入坐标Y（如不你不了解这是什么就填你BOSS结点的Y坐标-1）
    public int getBossEnterY(int type) {
        return 15; // TODO
    }

    @Override
    //层级名称（用以载入树洞场景时的UI显示）如：深处
    public String getLevelName(int type) {
        return (CardCrawlGame.languagePack.getUIString("samirg:TreeHole")).TEXT[1];
    }

    @Override
    //层级标题（用以载入树洞场景时的UI显示）如：第三幕、终幕
    public String getLevelNum(int type) {
        return (CardCrawlGame.languagePack.getUIString("samirg:TreeHole")).TEXT[0];
    }

    @Override
    //地图长度修正，参考值为 -560F*Settings.scale
    public float getMapSize(int type) {
        return -380.0F * Settings.scale;
    }

    @Override
    //滚动限制修正，由于树洞层级长度与普通层级不同，会有此限制，参考值为 -350F*Settings.scale
    public float getScrollLimit(int type) {
        return -650.0F * Settings.scale;
    }

    @Override
    //多种树洞mod启用时，这个选项用以跳转到你的事件，因此需要写一段选项描述
    public String getEnterOption() {
        return (CardCrawlGame.languagePack.getUIString("samirg:TreeHole")).TEXT[2];
    }

    @Override
    //进入事件，在树洞选择你mod的树洞时，会跳转到这个事件，同时提供一个独立的随机数生成器用来决定currentType生成
    public AbstractEvent treeHoleEnterEvent(Random random) {
        return new Encounter(); // TODO: (AbstractEvent)new TreeHoleEvent(random);
    }

    @Override
    //从树洞离开后，会返回到这个事件
    public AbstractEvent treeHoleOuterEvent(Random random) {
        return new Encounter(); // TODO: (AbstractEvent)new TreeHoleOutEvent(random);
    }

    @Override
    //是否启用终幕 TheEnding 的结局树洞
    public boolean enableTheEndingTreeHole() {
        return false;
    }

    @Override
    //进入树洞后调用的内容，默认进洞不回复生命，你可以在这里使用 AbstractDungeon.player.heal(amt);
    public void triggerWhenEnterTreeHole(int type) {
    }

    @Override
    //保存类的Class 用来读写json
    public Class<?> getSaveClass() {
        return null;
    }

    @Override
    //保存时传入（你需要把你mod中保存对象返回）
    public TreeHoleSave saveTreeHoleSave() {
        return null;
    }

    @Override
    //读取时获取（你需要在你mod中保存该对象）
    public void loadTreeHoleSave(TreeHoleSave save) {

    }
}
