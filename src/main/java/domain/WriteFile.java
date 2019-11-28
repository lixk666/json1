package domain;

import utils.ConfigurationsUtil;
import utils.FileUtil;

public class WriteFile {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        String writeFile = ConfigurationsUtil.getStringProperty(0, "write.file");
        Integer writeNum = ConfigurationsUtil.getIntProperty(0, "write.num");
//        System.out.println(writeFile);
        fileUtil.save(writeFile,writeNum);
    }
}
