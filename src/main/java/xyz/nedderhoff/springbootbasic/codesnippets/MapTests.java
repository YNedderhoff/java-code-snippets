package xyz.nedderhoff.springbootbasic.codesnippets;

import java.util.HashMap;
import java.util.Map;

public class MapTests {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        System.out.println(map.get("test"));
    }
}
