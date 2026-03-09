package ro.ulbs.proiectaresoftware.students;

public class Student1 {

        int numarMatricol;
        String prenume;
        String nume;
        String formatiedeStudiu;

        public Student1(int numarMatricol, String prenume, String nume, String formatiedeStudiu) {
            this.numarMatricol = numarMatricol;
            this.prenume = prenume;
            this.nume = nume;
            this.formatiedeStudiu = formatiedeStudiu;
        }
        @Override
        public String toString(){
         return String.format("%01d %10s %10s %10s",numarMatricol,prenume,nume,formatiedeStudiu);
        }

    }


