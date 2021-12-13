package lk.docker.practice.utils;

import lk.docker.practice.serviceImpl.DataIngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@EnableScheduling
@Configuration
public class Scheduler {

    @Autowired
    DataIngestionService dataIngestionService;

    @Scheduled(fixedRate = 10000)
    public void scheduleIngestion()
    {
        System.out.println("Scheduling task with thread :"+Thread.currentThread().getName()+" at time "+(new Date()));
        dataIngestionService.ingestData();
    }

}
