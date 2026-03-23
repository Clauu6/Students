package ro.ulbs.proiectaresoftware.students;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static boolean prezent(Student student, List<Student> studenti)
    {
/*
        //boolean gasit;
        if(student != studenti )

           return false;

return true;
*/

 return studenti.contains(student);

    }
    public static boolean prezentset(Student student, Set<Student> set)
    {

        return set.contains(student);

    }

    static void main() {
        List<Student> studenti=new ArrayList();
        System.out.println("nr de studenti din lista este : "+ studenti.size());
        Student s1=new Student("112","Ioan","Popa","TI21/1");
        Student s2=new Student("112","Maria","Oprea","TI21/1");
        Student s3=new Student("120","Alis","Popa","TI21/2");
        Student s4=new Student("122","Mihai","Vercedea","TI22/1");
        Student s5=new Student("122","Eugen","Uritescu","TI22/2");

        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);
        studenti.add(s5);

        System.out.println("nr de studenti din lista este : "+ studenti.size());
        System.out.println("Este prezent ?");
        System.out.println(prezent(new Student("112","Ioan","Popa","TI21/1"),studenti));

        Set<Student> set=new HashSet<>(studenti);
        System.out.println(prezentset(new Student("112","Ioan","Popa","TI21/1"),set));
/*
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
*/


        afiseaza(studenti);

    }

    private static void afiseaza(List<Student> studenti) {
        for(Student s: studenti)  // este un iterator
            System.out.println(s);
    }

}
