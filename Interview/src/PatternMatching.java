import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {
    public static boolean isMatch(String s, String p) {

        Pattern pattern = Pattern.compile(p);
        Matcher match = pattern.matcher(s);

        boolean bool = match.matches();
        return bool;
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(isMatch(s,p));
    }
}
