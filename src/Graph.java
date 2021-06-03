/**
 * @author Gabriel Alejandro Vicente Lorenzo
 */
public class Graph {

    private int n;
    private int[][] matriz;

    /**
     * Constructor de clase
     * @param n numero de nodos
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

    public void agregar(int i, int j){
        matriz[i][j] += 1;
    }

    public void remover(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }
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
    public int[][] retornar(){
        return matriz;
    }
    public int devolver(int a, int b){
        return matriz[a][b];
    }
}
