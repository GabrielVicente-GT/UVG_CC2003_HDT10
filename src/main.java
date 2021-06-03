/**
 * @author Gabriel Alejandro Vicente Lorenzo
 * Hoja de trabajo 10 CC2003 Seccion 10
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        System.out.println("\n______________________-----------------------------------______________________");
        System.out.println("______________________--------- Mejor que Waze ---------______________________");
        System.out.println("______________________-----------------------------------______________________");
        System.out.println();

        /**
         * guarda la posicion de la
         */

        ArrayList<String> ciudades = new ArrayList<String>();

        /**
         * se lee el archivo txt para saber el espacio de la matriz
         */

        try{
            FileReader r = new FileReader("guategrafo.txt");
            BufferedReader buffer = new BufferedReader(r);

            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                String[] data = temp.split(" ");
                Conexión conectando  =  new Conexión(data[0],data[1],data[2]);
                //corroborando el vertice de la ciudad 1
                if (!ciudades.contains(conectando.ciudad1)){
                    ciudades.add(conectando.ciudad1);
                }

                //corroborando el vertice de la ciudad 2
                if (!ciudades.contains(conectando.ciudad2)){
                    ciudades.add(conectando.ciudad2);
                }

            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }
        /**
         * se instancia la matriz y se llena con los datos asignados
         */

        Graph matriz = new Graph(ciudades.size());

        try{
            FileReader r = new FileReader("guategrafo.txt");
            BufferedReader buffer = new BufferedReader(r);

            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                String[] data = temp.split(" ");
                Conexión conectando  =  new Conexión(data[0],data[1],data[2]);
                //corroborando el vertice de la ciudad 1
                if (!ciudades.contains(conectando.ciudad1)){
                    ciudades.add(conectando.ciudad1);
                }

                //corroborando el vertice de la ciudad 2
                if (!ciudades.contains(conectando.ciudad2)){
                    ciudades.add(conectando.ciudad2);
                }

                for (int i=0;i<conectando.km;i++){
                    matriz.agregar(ciudades.indexOf(conectando.ciudad1), ciudades.indexOf(conectando.ciudad2));
                    matriz.agregar(ciudades.indexOf(conectando.ciudad2), ciudades.indexOf(conectando.ciudad1));
                }

            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }
        System.out.println("Nombres de las ciudades con el numero de vertice asignado\n");
        for (int i=0;i<ciudades.size();i++){
            System.out.print(ciudades.get(i)+"\t");
            System.out.print(ciudades.indexOf(ciudades.get(i)));
            System.out.println();
        }

        System.out.println("\nMatriz de adyacencia entre ciudades\n");

        matriz.imprimir_normal();

        System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

        matriz.imprimir();


        Floyd cam = new Floyd();

        System.out.println(cam.algoritmoFloyd(ciudades,matriz.retornar()));
    }
}
