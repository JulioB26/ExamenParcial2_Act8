package package1;

import java.util.*;

import package1.persona.sujeto;

public class principal {
	
	    public static void main(String[] args) {
	       
	        List<sujeto> personas = new ArrayList<>();
	        int k=1;
	        
	        for (int i = 0; i < 10; i++) {
	        	
	        	
	        	personas.add(new sujeto());
	        	
	        }
	        
	   
	        for (sujeto sujeto : personas) {
	        	
	            System.out.println(k + ".-" + sujeto.obtenerNombre() + ": " + 
	            		           sujeto.utilizaLentes() + ", " + 
	            		           sujeto.utilizaBrackets() + ", " + 
	            		           sujeto.esMujer() + ", " + 
	            		           sujeto.tienePeloLargo());
	            k++;
	        }
	        
	    
	        int numLentes = 0;
	        int numBrackets = 0;
	        int numMujeres = 0;
	        int numPeloLargo = 0;
	        
	        for (sujeto sujeto : personas) {
	            if (sujeto.utilizaLentes()) {
	            	numLentes++;
	            }
	            if (sujeto.utilizaBrackets()) {
	            	numBrackets++;
	            }
	            if (sujeto.esMujer()) {
	            	numMujeres++;
	            }
	            if (sujeto.tienePeloLargo()) {
	            	numPeloLargo++;
	            }
	        }
	        
	        System.out.println("Numeros de personas con cada atributos:");
	        System.out.println("Con lentes: " + numLentes);
	        System.out.println("Con brackets: " + numBrackets);
	        System.out.println("Son mujeres: " + numMujeres);
	        System.out.println("Tienen el pelo largo: " + numPeloLargo);
	     
	        Random aleatorio = new Random();
	        int personaSeleccionada = aleatorio.nextInt(10);
	        sujeto personaQueAdivinar = personas.get(personaSeleccionada);
	        

	        List<sujeto> personasRestantes = new ArrayList<>(personas);
	        

	        Scanner scanner = new Scanner(System.in);
	        
	        for (int i = 0; i < 3; i++) {
	        	
	            System.out.println("Pregunta " + (i + 1) + ": Que atributo tiene la persona seleccionada?");
	            System.out.println("1. Lentes");
	            System.out.println("2. Brackets");
	            System.out.println("3. Es una mujer");
	            System.out.println("4. Tiene el pelo largo");
	            int atributoEscogido = scanner.nextInt();
	            switch (atributoEscogido) {
	                case 1:
	                	if(personaQueAdivinar.utilizaLentes()== true) {
	                		  System.out.println("La persona a adivinar usa lentes.");
	                		  personasRestantes.removeIf(sujeto -> !sujeto.utilizaLentes());
	                	}else {
	                		System.out.println("La persona a adivinar no usa lentes.");
	                	}
	                    break;
	                case 2:
	                	if(personaQueAdivinar.utilizaBrackets()== true) {
	                		  System.out.println("La persona a adivinar usa brackets.");
	                		  personasRestantes.removeIf(sujeto -> !sujeto.utilizaBrackets());
	                	}else {
	                		System.out.println("La persona a adivinar no usa brackets.");
	                	}
	                    break;
	                case 3:
	                	if(personaQueAdivinar.esMujer()== true) {
              		  	System.out.println("La persona a adivinar es mujer.");
              		  		personasRestantes.removeIf(sujeto -> !sujeto.esMujer());
	                	}else {
	                		System.out.println("La persona a adivinar no es mujer.");
	                	}
	                    break;
	                case 4:
	                	if(personaQueAdivinar.tienePeloLargo()== true) {
	                	System.out.println("La persona a adivinar tiene el pelo largo");
	                	personasRestantes.removeIf(sujeto -> !sujeto.tienePeloLargo());
                		}else {
                		System.out.println("La persona a adivinar no tiene el pelo largo.");
                		}
	                    break;
	                    
	                default:
	                    System.out.println("Entrada inválida, ingrese otra");
	                    i--;
	                    break;
	                     
	            }
	            
	            System.out.println("Participantes restantes:");
	            
	            for (sujeto sujeto : personasRestantes) {
    	        	
    	            System.out.println(sujeto.obtenerNombre());
    	        }
	        }
	        
	        System.out.println("Adivina a la persona escogida escribiendo su número (1-10):");
	        int personaEscogida = scanner.nextInt() - 1;
	        if (personaEscogida == personaSeleccionada) {
	            System.out.println("Felicidades, adivinaste!");
	        } else {
	            System.out.println("Lo sentimos, pero fallaste. La persona escogida era: " + personaQueAdivinar.obtenerNombre());
	        }
	    
	}
}
