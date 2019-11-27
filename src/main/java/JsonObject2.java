import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 样本对象
 *
 */
public class JsonObject2 implements Serializable {
    private static final long serialVersionUID = -1520171788566678009L;

    private Boolean fieldBoolean;
    private Integer fieldInt;
    private Long fieldLong;
    private Double fieldDouble;
    private Long fieldDate;
    private String fieldStr;
    private List<String> fieldList;
    private Map<String, Object> FIELDMAP;
//    private Map<String, Object> fieldMap;


    /**
     * 随机样本
     */
    public JsonObject2() {
        Random random = new Random();

        fieldBoolean = random.nextBoolean();
        fieldInt = random.nextInt();
        fieldLong = random.nextLong();
        fieldDouble = random.nextDouble();
        fieldDate = System.currentTimeMillis();
        fieldStr = DataBuilder.randomString();

        fieldList = DataBuilder.randomStringList();

        FIELDMAP = DataBuilder.randomMap();
    }


    public Boolean getFieldBoolean() {
        return fieldBoolean;
    }

    public void setFieldBoolean(Boolean fieldBoolean) {
        this.fieldBoolean = fieldBoolean;
    }

    public Integer getFieldInt() {
        return fieldInt;
    }

    public void setFieldInt(Integer fieldInt) {
        this.fieldInt = fieldInt;
    }

    public Long getFieldLong() {
        return fieldLong;
    }

    public void setFieldLong(Long fieldLong) {
        this.fieldLong = fieldLong;
    }

    public Double getFieldDouble() {
        return fieldDouble;
    }

    public void setFieldDouble(Double fieldDouble) {
        this.fieldDouble = fieldDouble;
    }



    public String getFieldStr() {
        return fieldStr;
    }

    public void setFieldStr(String fieldStr) {
        this.fieldStr = fieldStr;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }
    public Map<String, Object> getFIELDMAP() {
        return FIELDMAP;
    }

    public void setFIELDMAP(Map<String, Object> FIELDMAP) {
        this.FIELDMAP = FIELDMAP;
    }

    @Override
    public String toString() {
        return "JsonObject{" +
                "fieldBoolean=" + fieldBoolean +
                ", fieldInt=" + fieldInt +
                ", fieldLong=" + fieldLong +
                ", fieldDouble=" + fieldDouble +
                ", fieldDate=" + fieldDate +
                ", fieldStr='" + fieldStr + '\'' +
                ", fieldList=" + fieldList +
                ", FIELDMAP=" + FIELDMAP +
                '}';
    }
}