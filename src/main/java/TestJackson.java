import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJackson {
//    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final JsonMapper OBJECT_MAPPER = new JsonMapper();
    JsonMapper jsonMapper= new JsonMapper();
    public static void main(String[] args) throws Exception {
        //这里我们生成jsonObject
        JsonObject jsonObject = new JsonObject();
        System.out.println(jsonObject + "\n");
        String jackson = null;
        String json = null;

        //TODO JSON

        json = JSON.toJSONString(jsonObject,false);
        System.out.println(json);
        JsonObject jsonObject12 = JSON.parseObject(json, JsonObject.class);
        System.out.println(jsonObject12);
//        System.out.println(s);

        //TODO JACKSON
        jackson = OBJECT_MAPPER.toJson(jsonObject);
        System.out.println(jackson);
        JsonObject jsonObject11 = OBJECT_MAPPER.readValue(jackson, JsonObject.class);
        System.out.println(jsonObject11);

        return;
    }

}
