package ro.ulbs.proiectaresoftware.students;

import java.util.*;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
List<Student> studenti=new ArrayList<>();
Map<Student,Integer> note=new HashMap<>();

    //@org.junit.jupiter.api.Test
    void DateleStudentilor()
    {
       Student student1=new Student(null,"Ioan","Popa","TI22/1");
        Student student2=new Student("113","Maria","Oprea","TI21/1");
        Student student3=new Student("120","Alis","Popa","TI21/2");
        Student student4=new Student("122","Eugen","Uritescu","TI22/2");

        studenti.add(student1);
        studenti.add(student2);
        studenti.add(student3);
        studenti.add(student4);

        for(int i=0;i<4;i++)
        {
            Integer nota=i+6;
            note.put(studenti.get(i),nota);
        }

    }

    public static Integer getNota(Student student,Map<Student,Integer> note )
    {
        if(student.getNumarMatricol()==null)
        {
            return null;
        }

        return note.get(student);
        //sau

    }
    /*

    @Test
    public void ReturneazaNULLDacaNuAreNrMatricol() {
     DateleStudentilor();
     //assertNull(getNota(studenti.getFirst(),note));
        Integer rezultat = getNota(studenti.get(0), note);

        assertNull(rezultat);
    }




    @Test
    public void ReturneazaDaDacaEPrezent() {
            // 1. Arrange (Pregătim datele)
            DateleStudentilor();
            Student studentDeCautat = studenti.get(1); // Maria Oprea, care este prezentă

            // 2. Act (Acțiunea - verificăm prezența în mapă sau listă)
            boolean estePrezent = note.containsKey(studentDeCautat);

            // 3. Assert (Verificăm dacă rezultatul este cel așteptat)
            // assertTrue verifică dacă valoarea este true
            assertTrue(estePrezent);


    }
*/

    // --- SECTIUNEA GET NOTA (4 TESTE) ---

    @Test
    void testGetNota_StudentExistent() {
        DateleStudentilor();
        Integer nota = getNota(studenti.get(0), note);
        assertEquals(null, nota);
    }

    @Test
    void testGetNota_StudentInexistent() {
        DateleStudentilor();
        Student sInexistent = new Student("999", "Gigel", "Fries", "TI");
        Integer nota = getNota(sInexistent, note);
        assertNull(nota);
    }

    @Test
    void testGetNota_MatricolNull() {
        DateleStudentilor();
        Student sNull = new Student(null, "Fara", "Numar", "TI");
        // Metoda ta actuala va da NullPointerException daca nu verifici numarMatricol
        Integer nota = getNota(sNull, note);
        assertNull(nota);
    }

    @Test
    void testGetNota_NotaMaxime() {
        DateleStudentilor();
        Integer nota = getNota(studenti.get(1), note);
        assertEquals(7, nota);
    }

    // --- SECTIUNEA PREZENTA (3 TESTE) ---

    @Test
    void testPrezent_EsteInLista() {
        DateleStudentilor();
        Student s = studenti.get(0);
        assertTrue(Application.prezent(s, studenti), "Studentul ar trebui sa fie gasit in lista");
    }

    @Test
    void testPrezent_NuEsteInLista() {
        DateleStudentilor();
        Student sInexistent = new Student("999", "Test", "Test", "TI");
        assertFalse(Application.prezent(sInexistent, studenti), "Studentul nu ar trebui sa fie in lista");
    }

    @Test
    void testPrezentSet_VerificareSet() {
        DateleStudentilor();
        Set<Student> setStudenti = new HashSet<>(studenti);
        assertTrue(Application.prezentset(studenti.get(2), setStudenti));
    }

    // --- SECTIUNEA SORTARE (2 TESTE) ---

    @Test
    void testSortareDupaNume_VerificareOrdine() {
        DateleStudentilor();

        // Inainte: Popa (Ioan), Oprea (Maria), Popa (Alis)
        Application.sortareDupaNume(studenti);

        // Dupa sortare: Oprea, Popa, Popa
        assertEquals("Oprea", studenti.get(0).getNume());
        assertEquals("Popa", studenti.get(1).getNume());
    }

    @Test
    void testSortareDupaNume_ListaGoaie() {
        DateleStudentilor();
        List<Student> listaGoala = new ArrayList<>();
        assertFalse(Application.sortareDupaNume(listaGoala), "Ar trebui sa returneze false si sa nu crape");
    }
}