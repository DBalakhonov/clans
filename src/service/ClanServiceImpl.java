package service;

import dto.Clan;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClanServiceImpl implements ClanService {
    private final ConcurrentHashMap<Long, Clan> clans;
    private final Lock lock;

    public ClanServiceImpl() {
        this.clans = new ConcurrentHashMap<>();
        this.lock = new ReentrantLock();
    }

    public Clan get(long clanId) {
        return clans.computeIfAbsent(clanId, id -> new Clan(id, "Clan " + id));
    }

    public void save(Clan clan) {
        lock.lock();
        try {
            System.out.println("Saving clan: " + clan.getId() + ", Gold: " + clan.getGold());
        } finally {
            lock.unlock();
        }
    }
}
