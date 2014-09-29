package trading.enums;

/**
 * Created by user on 9/29/14.
 */
/**
 * Created by user on 3/20/14.
 */
public enum CommonCompetitionNames {
    UEFA_CHAMPIONS_LEAGUE("UEFA Champions League"),
    UEFA_EUROPA_LEAGUE("UEFA Europa League"),
    BARCLAYS_PREMIER_LEAGUE("Barclays Premier League");

    private String competitionName;

    CommonCompetitionNames(String competitionName) {
        this.competitionName = competitionName;
    }

    public String GetCompetitionName() {
        return this.competitionName;
    }
}
