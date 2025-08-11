package SarkazIS.monsters;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.MonsterStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class AgginiOfNila extends AbstractMonster {
    public static final String ID = "SarkazIS:AgginiOfNila";
    public static final MonsterStrings monsterStrings = CardCrawlGame.languagePack.getMonsterStrings(ID);
    public static final String NAME = monsterStrings.NAME;
    public static final String IMAGE = "SarkazIS/images/monsters/AgginiOfNila.png";
    public int damage;
    AbstractMonster quiLon;
    public AgginiOfNila(float x, float y) {
        super(NAME, ID, 28, 20.0F, 0, 160.0F, 160.0F, IMAGE, x, y);
    }

    @Override
    public void takeTurn() {
        getMove(0);
    }

    @Override
    protected void getMove(int i) {
        setMove((byte) 1, Intent.UNKNOWN);
    }
}