import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @org.junit.jupiter.api.Test
    void agregar() {
        Graph matriz = new Graph(2);
        matriz.agregar(0,1);
        matriz.agregar(0,1);
        matriz.agregar(0,1);
        assertEquals(3, matriz.devolver(0,1));
    }
}