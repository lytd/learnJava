package td.learn.spring.common.demo.util;

public class StringUtil {
    public static String getFirstLower(String str){
        char[] letters=str.toCharArray();
        letters[0]+=32;
        return String.valueOf(letters);

    }
}
