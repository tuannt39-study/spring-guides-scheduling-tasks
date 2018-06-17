package vn.its.gsschedulingtasks.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000) // Chạy lặp sau mỗi fixedRate. Không cần quan tâm task trước đó đã kết thúc hay chưa.
    public void reportCurrentTimeRate() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 2000) // Thực hiện task đầu tiên sau initialDelay . Thực hiện task sau fixedDelay khi task trước đó kết thúc.
    public void reportCurrentTimeDelay() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron="0 20 1 * * MON-THU", zone="America/Los_Angeles") // Task được thực thi vào 1h 20 phút các ngày thứ 2, 3, 4, 5. zone chỉ định múi giờ, mặc định lấy theo múi giờ của Server.
    public void doScheduledWork() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

}
