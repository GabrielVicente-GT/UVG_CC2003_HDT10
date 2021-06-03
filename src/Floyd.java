/**
 * @author Gabriel Alejandro Vicente Lorenzo
 */
import java.util.ArrayList;

public class Floyd {
    public String algoritmoFloyd (ArrayList<String> nombres, int[][] matriz){
        int vertices = matriz.length;
        int MatrizAdyacencia[][] =matriz;
        String caminos [][]=new String[vertices][vertices];
        String caminosAuxiliares[][]=new String[vertices][vertices];
        String caminoRecorrido="",cadena="",caminitos="";
        int i,j,k;
        float temporal1,temporal2,temporal3,temporal4,minimo;
        for (i = 0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                caminos[i][j] = "";
                caminosAuxiliares[i][j]="";
            }

        }
        for (k=0;k<vertices;k++){
            for (i=0;i<vertices;i++){
                for (j=0;j<vertices;j++){
                    temporal1 = MatrizAdyacencia[i][j];
                    temporal2 = MatrizAdyacencia[i][k];
                    temporal3 = MatrizAdyacencia[k][j];
                    temporal4 = temporal2 +temporal3;

                    minimo = Math.min(temporal1,temporal4);
                    if (temporal1!=temporal4){
                        if (minimo==temporal4){
                            caminoRecorrido = "";
                            caminosAuxiliares[i][j] = k + "";
                            caminos[i][j]=caminosR(i,k,caminosAuxiliares,caminoRecorrido)+ (k) ;
                        }

                    }
                    MatrizAdyacencia[i][j] = (int) minimo;

                }

            }

        }

        for (i=0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                cadena = cadena + "[" + MatrizAdyacencia[i][j]+"]";
            }
            cadena = cadena + "\n";
        }

        for (i=0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                if (MatrizAdyacencia[i][j]!=1000000){
                    if(i !=j){
                        if(caminos[i][j].equals("")){
                            caminitos += "De ("+nombres.get(i)+"-->"+nombres.get(j)+") Irse por...("+nombres.get(i)+", "+nombres.get(j)+")\n";
                        }else{
                            caminitos +="de ("+ nombres.get(i)+"---->"+nombres.get(j)+") irse por...("+(i)+", "+(caminos[i][j]) + ", " +(j)+")\n";
                        }
                    }
                }
            }
            cadena = cadena + "\n";
        }




        return "\n LOS DIFERENTES CAMINOS MAS CORTOS ENTRE VERTICES SON:\n"+caminitos;
    }


    public String caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido) {
        if(caminosAuxiliares[i][k].equals("")){
            return "";
        }else{
            caminoRecorrido +=caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorrido)+(Integer.parseInt(caminosAuxiliares[i][k].toString()))+", ";
            return caminoRecorrido;
        }
    }

}
