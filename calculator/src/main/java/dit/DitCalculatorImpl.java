package dit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DitCalculatorImpl implements DitCalculator{
    public DitCalculatorImpl() { }

    @Override
    public DitMetricsDto calculate(Class<?> clazz) {
        DitMetricsDto results = new DitMetricsDto();
        List<String> ancestorsClassNames;
        List<Class<?>> ancestors = this.getAncestors(clazz);
        ancestorsClassNames = ancestors.stream().map(Class::getName)
                                        .collect(Collectors.toList());

        results.setAncestors(ancestorsClassNames);
        results.setValue(ancestors.size());

        return results;
    }

    @Override
    public List<Class<?>> getAncestors(Class<?> clazz) {
        List<Class<?>> ancestors = new ArrayList<Class<?>>();

        Class<?> currentClass = clazz;
        Class<?> parent = currentClass.getSuperclass();
        int numAncestors = -1;

        while (!currentClass.equals(Object.class)) {
            numAncestors++;
            currentClass = parent;
            parent = currentClass.getSuperclass();

            if (!currentClass.equals(Object.class)) {
                ancestors.add(currentClass);
            }
        }

        return ancestors;
    }
}
