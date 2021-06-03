/**
 * @author Gabriel Alejandro Vicente Lorenzo
 */

public class Conexion {
    String ciudad1 = "";
    String ciudad2 = "";
    int km = 0;

    /**
     * constructor de conexion
     * @param a origen
     * @param b destino
     * @param c km
     */
    public Conexion(String a, String b, String c){
        ciudad1 = a;
        ciudad2 = b;
        km = Integer.parseInt(c);
    }

    /**
     * impresiond el string
     * @return string
     */
    @Override
    public String toString() {
        return "Conexión{" +
                "ciudad1='" + ciudad1 + '\'' +
                ", ciudad2='" + ciudad2 + '\'' +
                ", km=" + km +
                '}';
    }
}
