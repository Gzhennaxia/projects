import java.lang.instrument.Instrumentation;

/**
 * @author bo li
 * @date 2020-09-17 11:35
 */
public class ObjectShallowSize {

    private static Instrumentation inst;

    /**
     * @param agentArgs 是 premain 函数得到的程序参数，随同 “– javaagent”一起传入。
     * 与 main 函数不同的是，这个参数是一个字符串而不是一个字符串数组，如果程序参数有多个，程序将自行解析这个字符串。
     * @param instP 是一个 java.lang.instrument.Instrumentation 的实例，由 JVM 自动传入。
     *
     * @author bli@skystartrade.com
     * @date 2020-09-17 11:54
     */
    public static void premain(String agentArgs, Instrumentation instP) {
        inst = instP;
    }

    public static long sizeOf(Object o) {
        return inst.getObjectSize(o);
    }
}
