package SarkazIS.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EndBattleAction extends AbstractGameAction {
    private static final Logger logger = LogManager.getLogger(EndBattleAction.class.getName());
    public EndBattleAction(float time) {
        this.duration = time;
    }
    public void update() {
        this.tickDuration();
        if (this.isDone) {
            AbstractDungeon.getCurrRoom().endBattle();
        }
    }
}
