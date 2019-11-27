package file;

import java.io.*;
import java.util.ArrayList;

import cn.JsonObject;

public class FileUtil {
    public FileUtil() {
    }

    public void save(String path,int num){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = new File(path);
        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            for (int i =0;i<num;i++){
                oos.writeObject(new JsonObject());
            }
   //括号内参数为要保存java对象
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void open(String path){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        java.util.List<JsonObject> list = new ArrayList<JsonObject>();
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (fileInputStream.available() > 0) {
                list.add((JsonObject) objectInputStream.readObject());
            }
            System.out.println("读取~");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
