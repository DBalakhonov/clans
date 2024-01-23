import dto.Clan;
import service.ClanService;
import service.ClanServiceImpl;
import service.TaskService;
import service.UserAddGoldService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClanService clanService = new ClanServiceImpl();
        UserAddGoldService userAddGoldService = new UserAddGoldService(clanService);
        TaskService taskService = new TaskService(clanService);
        Clan clan = clanService.get(1);
        System.out.println("Clan Gold: " + clan.getGold());
        Thread userThread1 = new Thread(() -> userAddGoldService.addGoldToClan(1, 1, 100));
        Thread userThread2 = new Thread(() -> userAddGoldService.addGoldToClan(2, 1, 50));

        Thread taskThread1 = new Thread(() -> taskService.completeTask(1, 1, 200));

        Thread taskThread2 = new Thread(() -> taskService.completeTask(1, 2, 150));

        userThread1.start();
        userThread2.start();
        taskThread1.start();
        taskThread2.start();

        userThread1.join();
        userThread2.join();
        taskThread1.join();
        taskThread2.join();

        System.out.println(clan.getGoldChanges());

        clanService.save(clan);
    }
}