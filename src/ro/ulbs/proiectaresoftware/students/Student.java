package ro.ulbs.proiectaresoftware.students;

import java.util.Map;
import java.util.Objects;

public class Student {

        String numarMatricol;
        String prenume;
        String nume;
        String formatiedeStudiu;

        public Student(String numarMatricol, String prenume, String nume, String formatiedeStudiu) {
            this.numarMatricol = numarMatricol;
            this.prenume = prenume;
            this.nume = nume;
            this.formatiedeStudiu = formatiedeStudiu;
        }

    public String getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatiedeStudiu() {
        return formatiedeStudiu;
    }

    @Override
        public String toString(){
         return String.format("%10s %10s %10s %10s",numarMatricol,prenume,nume,formatiedeStudiu);
        }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(prenume, student.prenume) && Objects.equals(nume, student.nume) && Objects.equals(formatiedeStudiu, student.formatiedeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formatiedeStudiu);
    }


}


