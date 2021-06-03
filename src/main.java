/**
 * @author Gabriel Alejandro Vicente Lorenzo
 * Hoja de trabajo 10 CC2003 Seccion 10
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        vista view =  new vista();
        Floyd cam = new Floyd();

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
        System.out.println("Lo que hay en el guategrafo.txt\n");
        try{
            FileReader r = new FileReader("guategrafo.txt");
            BufferedReader buffer = new BufferedReader(r);

            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                System.out.println(temp);
                String[] data = temp.split(" ");
                Conexion conectando  =  new Conexion(data[0],data[1],data[2]);
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
                Conexion conectando  =  new Conexion(data[0],data[1],data[2]);
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
        System.out.println("\nNombres de las ciudades con el numero de vertice asignado\n");
        for (int i=0;i<ciudades.size();i++){
            System.out.print(ciudades.get(i)+"\t");
            System.out.print(ciudades.indexOf(ciudades.get(i)));
            System.out.println();
        }

        System.out.println("\nMatriz de adyacencia entre ciudades\n");

        matriz.imprimir_normal();

        System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

        matriz.imprimir();

        System.out.println(cam.algoritmoFloyd(ciudades,matriz.retornar()));


        boolean ciclo = true;
        while (ciclo==true){
            view.titulo();

            int opcion = view.menu_opcion();

            if(opcion==1){
                /**
                 * como la distancia no cambia, se toma como si la distancia fuera tanto de origen a destino como de destino a origen
                 */
                System.out.println("Este método se recomienda solo usar una vez, ya que");
                System.out.println("Otra segunda correccion borrar todos los nuevos cambios realizados");
                System.out.println("Ingrese la ciudadd destino");
                String origen = scan.nextLine();

                System.out.println("Ingrese la ciudad origen");
                String destino = scan.nextLine();

                System.out.println("Ingrese la cantidad de km");
                int km = Integer.parseInt(scan.nextLine());

                if (!ciudades.contains(origen)){
                    ciudades.add(origen);
                }

                //corroborando el vertice de la ciudad 2
                if (!ciudades.contains(destino)){
                    ciudades.add(destino);
                }
                matriz = new Graph(ciudades.size());

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
                        Conexion conectando  =  new Conexion(data[0],data[1],data[2]);
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

                for (int i=0;i<km;i++){
                    matriz.agregar(ciudades.indexOf(origen),ciudades.indexOf(destino));
                    matriz.agregar(ciudades.indexOf(destino),ciudades.indexOf(origen));
                }
                System.out.println("Se ha agregado a la matriz");

                System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

                matriz.imprimir();

            }else if(opcion==2){
                Floyd cam2 = new Floyd();
                System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

                matriz.imprimir();
                System.out.println(cam2.algoritmoFloyd2(ciudades,matriz.retornar()));
            }else if (opcion==3){
                Floyd cam3 = new Floyd();
                System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

                matriz.imprimir();
                System.out.println(cam3.algoritmoFloyd(ciudades,matriz.retornar()));

            }else if (opcion==4){
                System.out.println("Saliendo");
                ciclo=false;
            }
        }
    }
}
