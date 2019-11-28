package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigurationsUtil;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.Comparator;

public class JacksonToBean {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("JacksonToBean");
        ArrayList timeList = new ArrayList();
        FileUtil fileUtil = new FileUtil();

        long sum = 0L;
        double avg;
        String readFile = ConfigurationsUtil.getStringProperty(0, "read.file");
        int readNum = ConfigurationsUtil.getIntProperty(0, "read.num");
        for (int i = 0; i < 10; i++) {
            long time = fileUtil.saveWithJackson(readFile);
            timeList.add(time);
        }

        timeList.sort(new Comparator<Long>() {
            public int compare(Long l1, Long l2) {
                if (l1 < l2) {
                    return 1;
                }
                if (l1 > l2) {
                    return -1;
                }
                return 0;
            }
        });

        for (int i = 1; i < timeList.size() - 1; i++) {
//        System.out.println(timeList.get(i));
            sum += (long) (timeList.get(i));

        }
        avg = (double) sum / 8;
        System.out.println(avg);
        logger.error("处理" + readNum + "条数据,平均处理时间为" + avg + "毫秒");
    }

}

