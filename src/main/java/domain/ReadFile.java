package domain;

import file.FileUtil;

public class ReadFile {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        fileUtil.open("D:\\idea\\projects\\json1\\src\\main\\java\\common\\a.json");
    }
}
