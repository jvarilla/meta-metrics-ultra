package classpathmanageradapter;

import java.util.List;

public interface ClassPathManagerAdapter {
    boolean loadClasses(String pathToBinFolder);
    List<Class<?>> getClasses();
}
