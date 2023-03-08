package package1;

import java.util.Random;

public abstract class persona {

    public persona() {
      
    }

    public static class sujeto extends persona{
    	private String nombre;
    	private boolean utilizaLentes;
        private boolean utilizaBrackets;
        private boolean esMujer;
        private boolean tienePeloLargo;
        
    	public sujeto() {
    		this.nombre = generarnombreAleatorio();
    		this.utilizaLentes = generarBooleanoAleatorio();
    	    this.utilizaBrackets = generarBooleanoAleatorio();
    	    this.esMujer = generarBooleanoAleatorio();
    	    this.tienePeloLargo = generarBooleanoAleatorio();
    	    verificadorDeAtributos();
    	}
    	
    	public String obtenerNombre() {
            return nombre;
        }

        public boolean utilizaLentes() {
            return utilizaLentes;
        }

        public boolean utilizaBrackets() {
            return utilizaBrackets;
        }

        public boolean esMujer() {
            return esMujer;
        }

        public boolean tienePeloLargo() {
            return tienePeloLargo;
        }
        
        private boolean generarBooleanoAleatorio() {
            Random aleatorio = new Random();
            return aleatorio.nextBoolean();
        }

        private String generarnombreAleatorio() {
            Random aleatorio = new Random();
            String[] nombres = {"Jose", "Maria", "Antonio", "Jorge", "Sara", "David", "Ana", "Matias", "Sofía", "Joshua", "Jazmin", "Daniel", "Laura"};
            String[] apellidos ={"Garcia", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Perez"};
            
            String nombre = nombres[aleatorio.nextInt(nombres.length)];
            String apellido = apellidos[aleatorio.nextInt(apellidos.length)];
            
            return nombre + " " + apellido;
        }
        
        private void verificadorDeAtributos() {
            
            boolean[] atributos = {utilizaLentes, utilizaBrackets, esMujer, tienePeloLargo};
            
       
            int[] contadores = new int[4];
            for (int i = 0; i < atributos.length; i++) {
                int contador = 0;
                for (int j = 0; j < atributos.length; j++) {
                    if (atributos[j] == atributos[i]) {
                    	contador++;
                    }
                }
                contadores[i] = contador;
            }
            
           
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] == atributos.length) {
                	atributos[i] = !atributos[i];
                    break;
                }
            }
            
            utilizaLentes = atributos[0];
            utilizaBrackets = atributos[1];
            esMujer = atributos[2];
            tienePeloLargo = atributos[3];
        }
    }
}
