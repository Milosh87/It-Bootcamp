package inheritanceDomaci;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Covek c1 = new Covek("Milos", "Mijatovic", 1987);
		System.out.println(c1);
		Student s1 = new Student("Pera","Petrovic", 1982, 3, 6.12);
		System.out.println(s1);
		Zaposleni z1 = new Zaposleni("Pera", "Peric", 1895, 1920, 45000);
		System.out.println(z1);
		Nastavnik n1 = new Nastavnik("Nastavnik", "Nastavnikovic", 1954, 1980, 80000, "Matematika", new String []{"Matematika", "Informatika", "Fizika"});
		System.out.println(n1);
		StudentOsnovnih so1 = new StudentOsnovnih("Student", "Osnovnih", 1987, 4, 9.5, "Informatika");
		System.out.println(so1);
		StudentMasterStudija sm1 = new StudentMasterStudija("Student", "Masterovic", 1985, 3, 8.88, "Bankarstvo");
		System.out.println(sm1);
		Profesor p1 = new Profesor("Profesor", "Profesorovic", 1940, 1968, 120000, "Fizika", new String [] {"Fizika", "Hemija", "Matematika"}, "Docent");
		System.out.println(p1);
		Asistent a1 = new Asistent("Asistent", "Asistentovic", 1980, 2015, 90000, "Engleski", new String [] {"Ruski", "Engleski", "Francuski"}, "Engleski");
		System.out.println(a1);
		Sluzbenik sl1 = new Sluzbenik("Sluzbenik", "Sluzbenkovic", 1980, 2016, 60000, "Studentska sluzba");
		System.out.println(sl1);

	}

}
