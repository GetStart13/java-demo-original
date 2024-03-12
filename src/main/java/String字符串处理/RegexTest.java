package String字符串处理;


import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * <p> 2023/6/26 </p>
 * 正则练习
 *
 * @author Fqq
 */
 class RegexTest {

    /**
     * 通过正则提取字符串中的子串
     */
     void extract() {
        String input = "domain=localhost; path=com/fqq/one; value=null path=com/fqq/two; ";
        String regex = "path=[^;]+;";

        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println("匹配到的字符：" + group);
        } else {
            System.out.println("未匹配到字符");
        }
    }

    /**
     * 移除所有 XMl 标签，但不匹配带斜杠的大小括号
     */
    static void replaceTest() {
        String string = "<>eezf,.'</>  ua98e< fef> \\<wewq\\> fgrh</a>";
        String result = string.replaceAll("(?<!\\\\)<[^>]*(?<!\\\\)>", "");
        System.out.println(result);
    }

    /**
     * 对匹配到的字符并做增强
     */
    static void replace() {
        String string = "提取尖括号的字符，《java》";
        String replaced = string.replaceAll("(《.*》)", "你在看$1");
        System.out.println("增强匹配： " + replaced);
    }

    /**
     * 在一个表达式中，通过 \${数字} 反引用其子表达式，重用子表达式匹配到的结果
     */
    static void backreferenceTest() {
        String str = "match the same word in a sentence, in the same pattern.";
        String result = str.replaceFirst("(\\b\\w+\\b)[\\s\\S]*\\1",
                ">>> this is match duplicates word: {$1} <<<");
        System.out.println(result);
    }

    static void matchConsecutiveChineseTest() {
        String str = "this is some 中文开头 =》 中文结尾 need to match";
        String regex = "[\\u4e00-\\u9fa5]+.*[\\u4e00-\\u9fa5]";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        Stream<MatchResult> results = matcher.results();
        // 匹配结果是 流，如果流已经被处理，再次调用将失效
        results.forEach(matchResult -> {
            String group = matchResult.group();
            System.out.println(group);
        });
        // 这里因为流已经被处理，因此调用失效
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println("match Chinese: " + group);
        }
    }
}
