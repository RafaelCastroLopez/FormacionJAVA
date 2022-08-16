import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearPersona{
    /* ClasePersona p1 = new ClasePersona();
    ClasePersona p2 = new ClasePersona();
    ClasePersona p3 = new ClasePersona();
    ClasePersona p4 = new ClasePersona();
    ClasePersona p5 = new ClasePersona();

    p1.setNombre("Jesus");
    p1.setPoblacion("Logroño");
    p1.setEdad(41);

    p2.setNombre("Andres");
    p2.setPoblacion("Madrid");
    p2.setEdad(19);

    p3.setNombre("Angel Mari");
    p3.setPoblacion("Valencia");
    p3.setEdad(null);

    p4.setNombre("Laura Saenz");
    p4.setPoblacion("");
    p4.setEdad(23);

    p5.setNombre("Maria Calvo");
    p5.setPoblacion("");
    p5.setEdad(38);

    List<ClasePersona> personas = new ArrayList();
    personas.add(p1);
    personas.add(p2);
    personas.add(p3);
    personas.add(p4);
    personas.add(p5);
    */
    public List<ClasePersona> personas;

    public CrearPersona() throws FileNotFoundException { //Constructor de CrearPersona
        personas = new ArrayList<>();

    }

    public List<ClasePersona> openFile() throws FileNotFoundException{
        List<String> persona = new ArrayList<>();
        File f = new File("src/datos.txt");
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] person = s.split(":");
            ClasePersona p = new ClasePersona();
            p.setNombre(person[0]);
            p.setPoblacion(person[1]);
            p.setEdad(person.length>2
                    ?Integer.parseInt(person[2]):0);
            personas.add(p);
        }
        return personas;
    }


    public void mostrarDatos(List<ClasePersona> aFiltrar) {
        aFiltrar.forEach(p-> System.out.println("nombre:" + p.getNombre() + ". Poblacion:" + p.getPoblacion() + ". Edad: " + p.getEdad()));
        System.out.println("separacion de listas");
        aFiltrar.stream().filter(p->p.getEdad()<25)
                .forEach(p-> System.out.println("nombre..." + p.getNombre() + " con edad " + p.getEdad()));
    }
}



