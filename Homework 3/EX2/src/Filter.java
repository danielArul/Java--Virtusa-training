import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args){
        filterWithStream();
    }





        static void filterWithStream(){
            List<Student> students=Student.getStudent().stream().filter(s->s.getName().length()<=6).collect(Collectors.toList());
            System.out.println(students);
        }

        void printStudentsWithShortNames(){

            List<Student> students = Student.getStudent();

            for (Student student : students) {
                if (student.getName().length() <= 5) {
                    System.out.println(student.getName());
                }
            }
        }
    }
}
