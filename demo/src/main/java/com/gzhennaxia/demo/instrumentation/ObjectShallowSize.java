package com.gzhennaxia.demo.instrumentation;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * http://libo9527.github.io/2020/09/17/Size-of-Object-in-Java/
 *
 * @author bo li
 * @date 2020-09-17 11:35
 */
public class ObjectShallowSize {

    private static Instrumentation inst;

    /**
     * @param agentArgs 是 premain 函数得到的程序参数，随同 “– javaagent”一起传入。
     *                  与 main 函数不同的是，这个参数是一个字符串而不是一个字符串数组，如果程序参数有多个，程序将自行解析这个字符串。
     * @param instP     是一个 java.lang.instrument.Instrumentation 的实例，由 JVM 自动传入。
     * @author bli@skystartrade.com
     * @date 2020-09-17 11:54
     */
    public static void premain(String agentArgs, Instrumentation instP) {
        inst = instP;
    }

    /**
     * 直接计算当前对象占用空间大小，包括
     * 当前类及超类的基本类型实例字段大小、
     * 引用类型实例字段引用大小、
     * 实例基本类型数组总占用空间、
     * 实例引用类型数组引用本身占用空间大小
     * <br>
     * 但是不包括超类继承下来的和当前类声明的实例引用字段的对象本身的大小、
     * 实例引用数组引用的对象本身的大小
     *
     * @author bli@skystartrade.com
     * @date 2020-09-17 17:09
     */
    public static long sizeOf(Object o) {
        return inst.getObjectSize(o);
    }

    /**
     * 递归计算当前对象占用空间总大小，包括当前类和超类的实例字段大小以及实例字段引用对象大小
     *
     * @author bli@skystartrade.com
     * @date 2020-09-17 17:12
     */
    public static long fullSizeOf(Object objP) throws IllegalAccessException {
        Set<Object> visited = new HashSet<Object>();
        // 双端队列（Double Ended Queue）
        Deque<Object> toBeQueue = new ArrayDeque<Object>();
        toBeQueue.add(objP);
        long size = 0L;
        while (toBeQueue.size() > 0) {
            Object obj = toBeQueue.poll();
            // sizeOf的时候已经计基本类型和引用的长度，包括数组
            size += skipObject(visited, obj) ? 0L : sizeOf(obj);
            Class<?> tmpObjClass = obj.getClass();
            if (tmpObjClass.isArray()) {
                // 基本类型名字长度是2，例如 int[] -> "[I"
                if (tmpObjClass.getName().length() > 2) {
                    for (int i = 0, len = Array.getLength(obj); i < len; i++) {
                        Object tmp = Array.get(obj, i);
                        if (tmp != null) {
                            // 非基本类型需要深度遍历其对象
                            toBeQueue.add(Array.get(obj, i));
                        }
                    }
                }
            } else {
                while (tmpObjClass != null) {
                    Field[] fields = tmpObjClass.getDeclaredFields();
                    for (Field field : fields) {
                        if (Modifier.isStatic(field.getModifiers())   //静态不计
                                || field.getType().isPrimitive()) {    //基本类型不重复计
                            continue;
                        }

                        field.setAccessible(true);
                        Object fieldValue = field.get(obj);
                        if (fieldValue == null) {
                            continue;
                        }
                        toBeQueue.add(fieldValue);
                    }
                    tmpObjClass = tmpObjClass.getSuperclass();
                }
            }
        }
        return size;
    }

    /**
     * String.intern的对象不计；
     * 计算过的不计，也避免死循环
     *
     * @author bli@skystartrade.com
     * @date 2020-09-17 17:15
     */
    private static boolean skipObject(Set<Object> visited, Object obj) {
        if (obj instanceof String && obj == ((String) obj).intern()) {
            return true;
        }
        return visited.contains(obj);
    }

}
