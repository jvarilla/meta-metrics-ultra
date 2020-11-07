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
    private ImmutableSet<ClassPath.ClassInfo> classesOfThisProject;

    public ClassPathManagerAdapterImpl() {
        this.loadedClasses = new ArrayList<Class<?>>();
    }

    @Override
    public boolean loadClasses(String pathToBinFolder) {
        try {
//            File file = new File("C:\\Users\\jvari\\ProjectsJ\\SE433\\poc\\build\\classes\\java\\main");
            this.classesOfThisProject =
                    ClassPath.from(getClass().getClassLoader()).getAllClasses();
            File binDirectory = new File(pathToBinFolder);
            ClassLoader classLoader = new URLClassLoader(new URL[] {binDirectory .toURI().toURL()});
            getClass().getClassLoader();
            ImmutableSet<ClassPath.ClassInfo> classInfos = ClassPath.from(classLoader).getAllClasses();
            List<ClassPath.ClassInfo> classInfoList = classInfos.asList();


            this.loadedClasses = classInfoList.stream().filter(classInfo -> {
                return !this.classesOfThisProject.contains(classInfo);
            }).map(ClassPath.ClassInfo::load).filter(clazz -> !clazz.isInterface() && !clazz.isEnum()).collect(Collectors.toList());
            return true;

        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<Class<?>> getClasses() {
        return this.loadedClasses;
    }
}
