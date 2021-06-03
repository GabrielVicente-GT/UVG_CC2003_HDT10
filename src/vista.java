/***
 * @author Gabriel Alejandro Vicente Lorenzo 20498
 */
import java.util.Scanner;

class vista{
    Scanner scan;

    public vista(){
        scan = new Scanner(System.in);
    }

    /***
     * presionar para continuar
     */
    public void press_enter(){
        System.out.println("Presione ENTER para el siguiente paciente...");
        scan.nextLine();
    }
    /***
     * menu para elegir opcion
     * @return numero seleccionado segun la opcion
     */
    public int menu_opcion(){
        boolean verificador=false;
        int opcion=-1;
        do{
            System.out.println(" ---> Elija que opcion realizar");
            System.out.println("	1.  Agregar");
            System.out.println("	2.  Ver matriz de Floyd");
            System.out.println("	3.  Ver rutas cortas");
            System.out.println("	4.  Salir");


            try{

                opcion = Integer.parseInt(scan.nextLine());


            }catch(Exception e){
                System.out.println("ese no es un numero entero");
            }

            if(opcion<1||opcion>4){
                System.out.println("esa no es una opcion\n");
            }else{
                verificador=true;
            }
        }while(verificador==false);

        return opcion;
    }

    /**
     * Impresion del titulo
     */

    public void titulo(){
        System.out.println("\n______________________-----------------------------------______________________");
        System.out.println("______________________--------- Mejor que Waze ---------______________________");
        System.out.println("______________________-----------------------------------______________________");
        System.out.println();;
    }


}