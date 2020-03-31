import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class WeightComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return ComparisonChain.start()
                .compare(s1.getWeight(), s2.getWeight())
                .result();
    }
}
