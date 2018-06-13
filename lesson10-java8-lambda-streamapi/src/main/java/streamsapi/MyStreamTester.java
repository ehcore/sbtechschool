package streamsapi;

import java.util.*;

public class MyStreamTester {
    public static void main(String[] args) {
        List<String> list = MyStream.of(Arrays.asList("aaa","bbb","ccc"))
                .filter(a->"aaa".equals(a))
                .collect();
    }
}
