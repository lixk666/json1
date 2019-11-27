package domain;

import file.FileUtil;

public class WriteFile {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        fileUtil.save("D:\\idea\\projects\\json1\\src\\main\\java\\common\\a.json",10);
    }
}
