public class Application {
    public static void main(String[] args) {
        CrearPersona crearPersona;

        try{
            crearPersona = new CrearPersona();
            crearPersona.mostrarDatos(crearPersona.openFile());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

