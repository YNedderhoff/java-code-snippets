package xyz.nedderhoff.springbootbasic.springapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum MyEnum {
    FIRST("first", "mytopic"),
    SECOND("second"),
    THIRD("third");

    private String value;
    private String topic;
    private static final List<String> stringValues;

    static {
        stringValues = Arrays.stream(MyEnum.values())
                .map(MyEnum::getValue)
                .collect(Collectors.toList());
    }

    private static Map<String, MyEnum> stingToEnumMap;

    static {
        stingToEnumMap = Arrays.stream(MyEnum.values())
                .collect(Collectors.toMap(MyEnum::getValue, e -> e));
    }

    MyEnum(String value) {
        this.value = value;
    }

    MyEnum(String value, String topic) {
        this.value = value;
        this.topic = topic;
    }

    public String getValue() {
        return value;
    }

    public String getTopic() {
        return topic;
    }

    public static List<String> getStringValues() {
        return stringValues;
    }

    public static MyEnum getEnumByString(String name) {
        return stingToEnumMap.get(name);
    }
}
