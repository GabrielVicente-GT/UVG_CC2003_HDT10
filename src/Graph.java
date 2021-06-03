/**
 * @author Gabriel Alejandro Vicente Lorenzo
 * Referencia de https://www.youtube.com/watch?v=KwWu9sXdnaY
 */
public class Graph {

    private int n;
    private int[][] matriz;

    /**
     * Constructor de clase
     * @param n cantidad
     */
    public Graph(int n) {
        this.n = n;
        matriz = new int[this.n][this.n];
        //se inicializa matriz en 0
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = 0;
            }
        }
    }

    /**
     * agregar
     * @param i cantidad
     * @param j cantidad
     */
    public void agregar(int i, int j){
        matriz[i][j] += 1;
    }

    /**
     * remover
     * @param i ubicacion
     * @param j ubicacion
     */
    public void remover(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }

    /**
     * impresion de matriz normal con 0
     */
    public void imprimir_normal(){

        for(int i=0; i< n; i++){
            System.out.print("||\t");
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("||");
            System.out.println();
        }
    }

    /**
     * matriz con infinitos
     */
    public void imprimir(){
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if (matriz[i][j]==0){
                    matriz[i][j]=999999;
                }
            }

        }
        for(int i=0; i< n; i++){
            System.out.print("||\t");
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("||");
            System.out.println();
        }
    }

    /**
     * retornar
     * @return retorna matriz
     */
    public int[][] retornar(){
        return matriz;
    }

    /**
     * devuelve km
     * @param a ubicacion
     * @param b ubicacion
     * @return km
     */
    public int devolver(int a, int b){
        return matriz[a][b];
    }
}
