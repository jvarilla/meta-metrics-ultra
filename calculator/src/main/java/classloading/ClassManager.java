package classloading;


import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import dit.DitCalculator;
import dit.DitCalculatorImpl;
import dto.classsummary.dit.DitMetricsDto;
import dto.classsummary.interfaces.InterfacesMetricsDto;
import dto.classsummary.numfields.NumFieldsDto;
import dto.classsummary.wmc.WmcMetricsDto;
import interfaces.InterfacesCalculator;
import interfaces.InterfacesCalculatorImpl;
import numfields.NumFieldsCalculator;
import numfields.NumFieldsCalculatorImpl;
import wmc.WmcCalculator;
import wmc.WmcCalculatorImpl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class ClassManager {
    public void execute() throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        ImmutableSet<ClassPath.ClassInfo> classesOfThisProject =
                ClassPath.from(ClassManager.class.getClassLoader()).getAllClasses();
        // For gradle projects use build/classes/java/main
        File file = new File("C:\\Users\\jvari\\ProjectsJ\\SE433\\poc\\build\\classes\\java\\main");
        ClassLoader classLoader = new URLClassLoader(new URL[] {file.toURI().toURL()});
        Field f = ClassLoader.class.getDeclaredField("classes");
        f.setAccessible(true);
        ClassManager.class.getClassLoader();

        ImmutableSet<ClassPath.ClassInfo> classInfos = ClassPath.from(classLoader).getAllClasses();

        WmcCalculator wmcCalculator = new WmcCalculatorImpl();
        DitCalculator ditCalculator = new DitCalculatorImpl();
        InterfacesCalculator interfacesCalculator = new InterfacesCalculatorImpl();
        NumFieldsCalculator numFieldsCalculator = new NumFieldsCalculatorImpl();

        List<ClassPath.ClassInfo> classInfoList = classInfos.asList();

        classInfoList.stream().filter(classInfo -> !classesOfThisProject.contains(classInfo)).forEach(
                classInfo -> {
                    try {
                        Class theClass = classInfo.load();
                        WmcMetricsDto wmcMetricsDto = wmcCalculator.calculate(theClass);
                        DitMetricsDto ditMetricsDto = ditCalculator.calculate(theClass);
                        InterfacesMetricsDto interfacesMetricsDto = interfacesCalculator.calculate(theClass);
                        NumFieldsDto numFieldsDto = numFieldsCalculator.calculate(theClass);

                        System.out.println(theClass.getName());
                        System.out.println(wmcMetricsDto);
                        System.out.println(ditMetricsDto);
                        System.out.println(interfacesMetricsDto);
                        System.out.println(numFieldsDto);

                    } catch (Exception e) {
                        return;
                    }
                });
    }



    public ClassManager() throws IOException {
    }
}
