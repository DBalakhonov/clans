package service;

import dto.Clan;

public class UserAddGoldService {
    private final ClanService clans;

    public UserAddGoldService(ClanService clans) {
        this.clans = clans;
    }

    public void addGoldToClan(long userId, long clanId, int gold) {
        Clan clan = clans.get(clanId);
        clan.addGold("UserAddGold " + userId, gold);
    }
}

