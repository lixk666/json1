package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigurationsUtil;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("all")
public class ReadFileFastjson {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        ArrayList timeList = new ArrayList();
        long sum =0L;
        double avg=0.0d;
        Logger logger = LoggerFactory.getLogger("ReadFileFastjson");
        String readFile = ConfigurationsUtil.getStringProperty(0, "read.file");
        int readNum = ConfigurationsUtil.getIntProperty(0, "read.num");


        //处理多次，并将时间保存到list中，最后求平均值
        for (int i =0;i<10;i++){
        //读取文件
        long time = fileUtil.openWithFastjson(readFile);
        timeList.add(time);
        }
        //排序一下，方便之后将最长时间和最短时间去掉求平均值
    timeList.sort(new Comparator<Long>() {
        public int compare(Long l1, Long l2) {
            if (l1 < l2){
                return 1;
            }
            if (l1 > l2){
                return -1;
            }
            return 0;
        }
    });

    for (int i=1;i<timeList.size()-1;i++){
//        System.out.println(timeList.get(i));
        sum += (long) (timeList.get(i));

    }
        avg=(double) sum / 8;
        System.out.println(avg);
        logger.error("处理"+readNum+"条数据,平均处理时间为" + avg + "毫秒");
    }
}
