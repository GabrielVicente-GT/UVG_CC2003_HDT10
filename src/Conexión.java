/**
 * @author Gabriel Alejandro Vicente Lorenzo
 */

public class Conexión {
    String ciudad1 = "";
    String ciudad2 = "";
    int km = 0;

    public Conexión(String a, String b, String c){
        ciudad1 = a;
        ciudad2 = b;
        km = Integer.parseInt(c);
    }

    @Override
    public String toString() {
        return "Conexión{" +
                "ciudad1='" + ciudad1 + '\'' +
                ", ciudad2='" + ciudad2 + '\'' +
                ", km=" + km +
                '}';
    }
}
