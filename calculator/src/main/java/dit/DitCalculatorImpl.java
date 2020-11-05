package dit;

import java.util.ArrayList;
import java.util.List;

public class DitCalculatorImpl implements DitCalculator{
    public DitCalculatorImpl() { }

    @Override
    public DitMetricsDto calculate(Class classToAnalyze) {
        DitMetricsDto results = new DitMetricsDto();
        List<String> ancestors = new ArrayList<>();
        Class currentClass = classToAnalyze;
        Class parent = currentClass.getSuperclass();
        int numAncestors = -1;

        while (!currentClass.equals(Object.class)) {
            numAncestors++;
            currentClass = parent;
            parent = currentClass.getSuperclass();

            if (!currentClass.equals(Object.class)) {
                ancestors.add(currentClass.getName());
            }
        }

        results.setAncestors(ancestors);
        results.setValue(numAncestors);

        return results;
    }
}
