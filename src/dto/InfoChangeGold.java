package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class InfoChangeGold {
    int addGold;
    LocalDateTime currentTime;

    public InfoChangeGold() {
        this.addGold = 0;
        this.currentTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedDateTime = currentTime.format(formatter);
        return "addGold=" + addGold + ", currentTime=" + formattedDateTime;
    }
}
