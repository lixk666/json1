package utils;

import cn.JsonObject;
import com.alibaba.fastjson.JSON;
import common.JsonMapper;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FileUtil {
    public static java.util.List<JsonObject> list = new ArrayList<JsonObject>();
    public static java.util.List<String> listStr = new ArrayList<String>();
    public static final JsonMapper jsonMapper = new JsonMapper();

    public void save(String path, int num) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = new File(path);
        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < num; i++) {
                oos.writeObject(new JsonObject());
            }
            //括号内参数为要保存java对象
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用jackson方式解析对象=》json
     *
     * @param path
     * @return
     */
    public long openWithJackson(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        long time = 0L;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            if (list.size() == 0) {
                System.out.println("读取文件中的数据");
                while (fileInputStream.available() > 0) {
                    list.add((JsonObject) objectInputStream.readObject());
                }
            }

            System.out.println("读取内存中的数据");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
                JsonObject object = list.get(i);
                //这是用fastjson
//                JSON.toJSONString(object);
                //这是用jackson
                jsonMapper.toJson(object);
            }
            time = (System.currentTimeMillis() - startTime);
//            System.out.println("处理"+list.size()+"条数据总共用了" + time + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return time;
        }

    }

    /**
     * 使用fastjson方式解析对象=》json
     *
     * @param path
     * @return
     */
    public long openWithFastjson(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        long time = 0L;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            if (list.size() == 0) {
                System.out.println("读取文件中的数据");
                while (fileInputStream.available() > 0) {
                    list.add((JsonObject) objectInputStream.readObject());
                }
            }

            System.out.println("读取内存中的数据");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
                JsonObject object = list.get(i);
                //这是用fastjson
                JSON.toJSONString(object);
                //这是用jackson
//                jsonMapper.toJson(object);
            }
            time = (System.currentTimeMillis() - startTime);
//            System.out.println("处理"+list.size()+"条数据总共用了" + time + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return time;
        }

    }

    /**
     * 使用fastjson将json=》对象
     *
     * @param path
     * @return
     */
    public long saveWithFastjson(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        long time = 0L;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            if (list.size() == 0) {
                System.out.println("读取文件中的数据");
                while (fileInputStream.available() > 0) {
                    list.add((JsonObject) objectInputStream.readObject());
                }
            }

            System.out.println("读取内存中的数据");
//如果listStr中有数据，就不用重新再从文件中读一次
            if (listStr.size() == 0) {
                for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
                    JsonObject object = list.get(i);
                    //这是用fastjson
                    String json = JSON.toJSONString(object);
                    listStr.add(json);
                    //这是用jackson
//                jsonMapper.toJson(object);
                }
            }

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < listStr.size(); i++) {
                String json = listStr.get(i);
                //TODO 使用fastjson解析json=》对象
                JSON.parseObject(json, JsonObject.class);
            }
            time = (System.currentTimeMillis() - startTime);
//            System.out.println("处理"+list.size()+"条数据总共用了" + time + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return time;
        }

    }


    /**
     * 使用jackson将json=》对象
     *
     * @param path
     * @return
     */
    public long saveWithJackson(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        long time = 0L;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            if (list.size() == 0) {
                System.out.println("读取文件中的数据");
                while (fileInputStream.available() > 0) {
                    list.add((JsonObject) objectInputStream.readObject());
                }
            }

            System.out.println("读取内存中的数据");
//如果listStr中有数据，就不用重新再从文件中读一次
            if (listStr.size() == 0) {
                for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
                    JsonObject object = list.get(i);
                    //这是用fastjson
                    String json = JSON.toJSONString(object);
                    listStr.add(json);
                    //这是用jackson
//                jsonMapper.toJson(object);
                }
            }

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < listStr.size(); i++) {
                String json = listStr.get(i);
                //TODO 使用jackson解析json=》对象
                jsonMapper.fromJson(json,JsonObject.class);
            }
            time = (System.currentTimeMillis() - startTime);
//            System.out.println("处理"+list.size()+"条数据总共用了" + time + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return time;
        }

    }

}
