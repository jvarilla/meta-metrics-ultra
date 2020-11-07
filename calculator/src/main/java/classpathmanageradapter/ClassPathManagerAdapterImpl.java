package classpathmanageradapter;


import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassPathManagerAdapterImpl implements ClassPathManagerAdapter {
    private List<Class<?>> loadedClasses;
    private List<Class<?>> loadedEnums;
    private List<Class<?>> loadedInterfaces;

    private ImmutableSet<ClassPath.ClassInfo> classesOfThisProject;

    public ClassPathManagerAdapterImpl() {
        this.loadedClasses = new ArrayList<Class<?>>();
    }

    @Override
    public boolean loadClasses(String pathToBinFolder) {
        try {
            this.classesOfThisProject =
                    ClassPath.from(getClass().getClassLoader()).getAllClasses();

            File binDirectory = new File(pathToBinFolder);
            ClassLoader classLoader = new URLClassLoader(new URL[] {binDirectory .toURI().toURL()});

            ImmutableSet<ClassPath.ClassInfo> classInfos = ClassPath.from(classLoader).getAllClasses();
            List<ClassPath.ClassInfo> classInfoList = classInfos.asList();

            List<Class<?>> allLoadedJavaCode = classInfoList.stream().filter(classInfo -> {
                return !this.classesOfThisProject.contains(classInfo);
            }).map(ClassPath.ClassInfo::load).collect(Collectors.toList());

            this.loadedClasses = allLoadedJavaCode.stream().filter(clazz -> {
                return !clazz.isInterface() && !clazz.isEnum();
            }).collect(Collectors.toList());

            this.loadedEnums = allLoadedJavaCode.stream().filter(Class::isEnum)
                                    .collect(Collectors.toList());

            this.loadedInterfaces = allLoadedJavaCode.stream().filter(Class::isInterface)
                                    .collect(Collectors.toList());

            return true;

        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<Class<?>> getClasses() {
        return this.loadedClasses;
    }

    @Override
    public List<Class<?>> getEnums() {
        return this.loadedEnums;
    }

    @Override
    public List<Class<?>> getInterfaces() {
        return this.loadedInterfaces;
    }
}
