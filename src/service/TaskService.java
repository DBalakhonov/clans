package service;

import dto.Clan;

public class TaskService {
    private final ClanService clans;

    public TaskService(ClanService clans) {
        this.clans = clans;
    }

    public void completeTask(long clanId, long taskId, int gold) {
        if(gold>0) {
            Clan clan = clans.get(clanId);
            clan.addGold("CompleteTask " + taskId, gold);
        }
    }
}
