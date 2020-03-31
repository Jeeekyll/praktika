import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

public class SurnameComparator implements Comparator <Student> {
    @Override
    public int compare(Student s1, Student s2){
        return ComparisonChain.start()
                .compare(s1.getSurname(), s2.getSurname())
                .result();
    }
}

