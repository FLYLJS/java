package com;

/**
 * @author Administrator
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        //系统类加载器  jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //扩展类加载器 jdk.internal.loader.ClassLoaders$PlatformClassLoader@10f87f48
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        //引导类加载器  null
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        //自定义类加载器  jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //String类的类加载器  null
        //使用引导类加载器进行加载   --->Java核心类库都是使用引导类加载器进行加载的
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);
    }
}
