package com.moka.Enum;

/**
 * @author lkq
 * @date 2018/10/11
 */
public enum UpStateEnum {

    WSB(0, "未上报"),
    YSB(1, "已上报"),
    NSB(2, "无需上报");
    
    public Integer key;
    public String value;

    UpStateEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }



    public static UpStateEnum getValue(int key){
        for (UpStateEnum tag: UpStateEnum.values()) {
            if(tag.key == key){
                return tag;
            }
        }
        return null;
    }
}
