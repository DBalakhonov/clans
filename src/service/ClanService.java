package service;

import dto.Clan;

public interface ClanService {
    Clan get(long clanId);

    void save(Clan clan);
}
