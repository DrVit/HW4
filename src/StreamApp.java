import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {
// Первое задание
    List<String> uniqCourseNames(Stream<Student> studentStream) {
        return studentStream
                .map(x -> x.getAllCourses())
                .flatMap(x -> x.stream())
                .map(course -> course.courseName())
                .distinct()
                .collect(Collectors.toList());
    }

// Второе задание
    List<String> knowledgeNames(Stream<Student> studentStream) {
        return studentStream
                .map(x -> x.getAllCourses().size())
                .sorted((x1, x2) -> x2 - x1)
                .limit(3)
                .map() // так и не догнал к чему его преобразовать
                .collect(Collectors.toList());
    }

// Третье задание

    Map<List<Course>, Student> getStudentMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getAllCourses, student -> student));
    }

    interface Student {
        String getName();

        List<Course> getAllCourses();
    }

    interface Course {
        String courseName();
    }
}
