package classpathmanageradapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classpath Manager Adapter")
class ClassPathManagerAdapterImplTest {
    ClassPathManagerAdapter classPathManagerAdapter;

    @BeforeEach
    void setUp() {
        classPathManagerAdapter = new ClassPathManagerAdapterImpl();
    }

    @Test
    @DisplayName("Should not load anything if directory is empty")
    void loadJavaClassesFromEmptyDirectory() {
        try {
            ClassLoader classLoader = ClassPathManagerAdapter.class.getClassLoader();
            String pathToTestFiles = new File(
                    Objects.requireNonNull(classLoader.getResource(
                            "classpathmanageradapter/testclasses/emptydirectory"))
                            .getFile()).getPath();

            boolean successfullyRan = classPathManagerAdapter.loadClasses(pathToTestFiles);

            assertTrue(successfullyRan);

            assertEquals(0, classPathManagerAdapter.getClasses().size());
            assertEquals(0, classPathManagerAdapter.getEnums().size());
            assertEquals(0, classPathManagerAdapter.getInterfaces().size());

        } catch (Exception exception) {
            exception.printStackTrace();
            fail("An error occurred that should have not");
        }
    }

    @Test
    @DisplayName("Should only load java into the class loader and only add classes to the class list")
    void loadOnlyJavaFiles() {
        try {
            ClassLoader classLoader = ClassPathManagerAdapter.class.getClassLoader();
            String pathToTestFiles = new File(
                    Objects.requireNonNull(classLoader.getResource(
                            "classpathmanageradapter/testclasses"))
                            .getFile()).getPath();

            boolean successfullyRan = classPathManagerAdapter.loadClasses(pathToTestFiles);

            List<String> loadedClassNames = classPathManagerAdapter.getClasses().stream()
                                            .map(Class::getName).collect(Collectors.toList());

            List<String> loadedEnumNames = classPathManagerAdapter.getEnums().stream()
                    .map(Class::getName).collect(Collectors.toList());

            List<String> loadedInterfaceNames = classPathManagerAdapter.getInterfaces().stream()
                    .map(Class::getName).collect(Collectors.toList());

            assertTrue(successfullyRan);

            assertEquals(3, classPathManagerAdapter.getClasses().size());
            assertTrue(loadedClassNames.contains("classpathmanagerresource.TestClass1"));
            assertTrue(loadedClassNames.contains("classpathmanagerresource.TestClass2"));
            assertTrue(loadedClassNames.contains("classpathmanagerresource.TestClass3"));

            assertEquals(1, classPathManagerAdapter.getEnums().size());
            assertTrue(loadedEnumNames.contains("classpathmanagerresource.Enum1"));

            assertEquals(1, classPathManagerAdapter.getInterfaces().size());
            assertTrue(loadedInterfaceNames.contains("classpathmanagerresource.Interface1"));

        } catch (Exception exception) {
            exception.printStackTrace();
            fail("An error occurred that should have not");
        }
    }
}