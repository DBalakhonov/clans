package dto;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class Clan {
    private final long id;
    private final String name;
    private final ConcurrentHashMap<String, InfoChangeGold> goldChanges;

    public Clan(long id, String name) {
        this.id = id;
        this.name = name;
        this.goldChanges = new ConcurrentHashMap<>();
    }

    public long getId() {
        return id;
    }

    public int getGold() {
        return goldChanges.values().stream().mapToInt(info -> info.addGold).sum();
    }

    public void addGold(String reason, int amount) {
        InfoChangeGold currentChange = goldChanges.computeIfAbsent(reason, k -> new InfoChangeGold());
        synchronized (currentChange) {
            currentChange.addGold += amount;
            currentChange.currentTime = LocalDateTime.now();
        }
    }

    public ConcurrentHashMap<String, InfoChangeGold> getGoldChanges() {
        return goldChanges;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goldChanges=" + goldChanges +
                '}';
    }
}
