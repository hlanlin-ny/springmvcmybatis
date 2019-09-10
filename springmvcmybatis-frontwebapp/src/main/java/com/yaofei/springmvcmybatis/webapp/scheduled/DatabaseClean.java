package com.yaofei.springmvcmybatis.webapp.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DatabaseClean {

    private static Logger logger = LoggerFactory.getLogger(DatabaseClean.class);

    @Scheduled(cron = "0 0 3 * * *")
    public void execute() {
        Thread thread = new Thread();
        logger.info("DatabaseClean Thread- started");
        thread.start();
    }

    class DatabaseCleanTask implements Runnable {

//		private static final long DAY = 1000 * 24 * 60 * 60;
//		private static final int retention = 0;
//		private final FastDateFormat fastDateFormat = FastDateFormat
//				.getInstance("yyyy-MM-dd HH:mm:ss");

        @Override
        public void run() {
            try {
//				int period = 7;
//				Calendar calendar = Calendar.getInstance();
//				int hour = calendar.get(Calendar.HOUR_OF_DAY);
//				int minute = calendar.get(Calendar.MINUTE);
//				int second = calendar.get(Calendar.SECOND);
//				int millisecond = calendar.get(Calendar.MILLISECOND);
//				long today = calendar.getTime().getTime() - hour * 60 * 60
//						* 1000 - minute * 60 * 1000 - second * 1000
//						- millisecond;
//				System.out.println(new Date(today));
//				long DataChange_LasTime = today - period * DAY;
//				String date = fastDateFormat
//						.format(new Date(DataChange_LasTime));

                logger.info("清除完成");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("清除发生异常", e);
            }
        }
    }
}
