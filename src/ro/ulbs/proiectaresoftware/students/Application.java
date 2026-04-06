package ro.ulbs.proiectaresoftware.students;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Application {
    public static boolean prezent(Student student, List<Student> studenti) {
/*
        //boolean gasit;
        if(student != studenti )
           return false;
return true;
*/
        return studenti.contains(student);

    }

    public static boolean prezentset(Student student, Set<Student> set) {
        return set.contains(student);
    }

    public static List<Student> citireFisier(String numeFisier) {
        String numarMatricol, nume, prenume, Formatie;
        List<Student> studenti = new ArrayList<>();
        FileInputStream f = null;
        try {
            f = new FileInputStream(numeFisier);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {

            String linie = sc.nextLine();
            String date[] = linie.split(",");
            numarMatricol = date[0];
            nume = date[1];
            prenume = date[2];
            Formatie = date[3];
            Student student = new Student(numarMatricol, nume, prenume, Formatie);
            studenti.add(student);
        }
        sc.close();
        return studenti;

    }

    public static boolean sortareDupaNume(List<Student> listastudent)
    {
        for(int i=0;i<listastudent.size()-1;i++)
        {
            for(int j=i+1;j< listastudent.size();j++)
            {
                Student student1=listastudent.get(i);
                Student student2=listastudent.get(j);

                if(student1.getNume().compareTo(student2.getNume())>0)
                {
                    listastudent.set(i,student2);
                    listastudent.set(j,student1);
                }
            }
        }
        return false;
    }

/*
    public static boolean sortareDupaFormatiesiPrenume(List<Student> listastudent)
    {
        for(int i=0;i<listastudent.size()-1;i++)
        {
            for(int j=i+1;j< listastudent.size();j++)
            {
                Student student1=listastudent.get(i);
                Student student2=listastudent.get(j);

                if(student1.getFormatiedeStudiu().compareTo(student2.getFormatiedeStudiu())==0)
                {
                    if(student1.getNume().compareTo(student2.getNume())==0)
                    {

                        if(student1.getPrenume().compareTo(student2.getPrenume())==0)
                        {
                            listastudent.set(i,student2);
                            listastudent.set(j,student1);
                        }
                        else {
                            listastudent.set(i, student2);
                            listastudent.set(j, student1);
                        }
                    }
                    else {
                        listastudent.set(i, student2);
                        listastudent.set(j, student1);
                    }
                }
            }
        }
        return false;
    }

 */


    private static void sortareDupaFormatiesiNume(List<Student> studenti) {
        Collections.sort(studenti, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getFormatiedeStudiu().equals(s2.getFormatiedeStudiu())) {
                    if (s1.getNume().equals(s2.getNume())) {
                        if (s1.getPrenume().equals(s2.getPrenume())) {
                            return s1.getNumarMatricol().compareTo(s2.getNumarMatricol());
                        } else return s1.getPrenume().compareTo(s2.getPrenume());
                    } else return s1.getNume().compareTo(s2.getNume());
                }
                else return s1.getFormatiedeStudiu().compareTo(s2.getFormatiedeStudiu());
            }

        });

    }

    public static Map<String,Integer> citireNote(String numeFisier) {
        String numarMatricol,nota;

        Map<String,Integer> note=new HashMap<>() ;  //= new Map<>()
        FileInputStream f = null;
        try {
            f = new FileInputStream(numeFisier);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner sc = new Scanner(f);

        while (sc.hasNext()) {
            String linie = sc.nextLine();
            String date[] = linie.split(",");
            numarMatricol = date[0];
            nota = date[1];
            note.put(numarMatricol,Integer.parseInt(nota));

        }
        sc.close();
        return note;

    }

    public static Integer getNota(Student student,Map<Student,Integer> note )
    {
        return(note.get(student.getNumarMatricol()));
        //sau

    }

    private static Map<Student,Integer> mapareNote(Map<String,Integer>note,List<Student>lista)
    {
        Map<Student,Integer> mapare=new HashMap<>() ;
        for(Student s:lista)
        {
            mapare.put(s,note.get(s.getNumarMatricol()));
            System.out.println(s.getNumarMatricol()+" "+mapare.get(s));
        }

        return mapare;


    }

    static void main() {
        List<Student> studenti = citireFisier("studenti.cvs");  //getstudents()

        Map<String,Integer> note=citireNote("Note.cvs");

        Map<Student,Integer> noteStudenti=mapareNote(note,studenti);

        System.out.println("Nota studentului "+studenti.get(1).getNumarMatricol()+": "+noteStudenti.get(studenti.get(1)));
        Student s=new Student(null,"Ioan","Popa","TI22/1");
        Integer nota2=getNota(s,noteStudenti);
        System.out.println("nota studentului :"+nota2);


        System.out.println("nr de studenti din lista este : " + studenti.size());
        System.out.println("Este prezent ?");
        System.out.println(prezent(new Student("112", "Ioan", "Popa", "TI21/1"), studenti));

        Set<Student> set = new HashSet<>(studenti);
        System.out.println(prezentset(new Student("112", "Ioan", "Popa", "TI21/1"), set));
        afiseaza(studenti);
        System.out.println("Sortare dupa Nume ");
        System.out.println(sortareDupaNume(studenti));
        afiseaza(studenti);
        //sortareDupaFormatiesiNume(studenti);
        //afiseaza(studenti);
/*
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
*/
        //afiseaza(studenti);
    }

    private static List<Student> getStudents() {
        List<Student> studenti = new ArrayList();
        System.out.println("nr de studenti din lista este : " + studenti.size());
        Student s1 = new Student("112", "Ioan", "Popa", "TI22/1");
        Student s2 = new Student("112", "Maria", "Oprea", "TI21/1");
        Student s3 = new Student("120", "Alis", "Popa", "TI21/2");
        Student s4 = new Student("122", "Mihai", "Vercedea", "TI23/1");
        Student s5 = new Student("122", "Eugen", "Uritescu", "TI22/2");

        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);
        studenti.add(s5);
        return studenti;
    }

    private static void afiseaza(List<Student> studenti) {
        for (Student s : studenti)  // este un iterator
            System.out.println(s);
    }

}
