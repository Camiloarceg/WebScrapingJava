import java.util.*;

class Nota {
    int index;
    String note;
    Map<String, String> properties; // Aquí estará la duración

    public Nota(int index, String note, Map<String, String> properties) {
        this.index = index;
        this.note = note;
        this.properties = properties;
    }

    public String getDuration() {
        return properties.get("duration");
    }
}

public class Exercise1 {

    public static void main(String[] args) {
        // Simulación del input (tal como viene en el enunciado)
        Nota n1 = new Nota(1, "sol", Map.of("duration", "1/4"));
        Nota n2 = new Nota(3, "fa", Map.of("duration", "1/2"));
        Nota n3 = new Nota(2, "si", Map.of("duration", "1/4"));

        Nota[] arr = new Nota[]{n1, n2, n3};

        validarNotas(arr);
        List<Nota> ordenadas = ordenarNotas(arr);
        imprimirNotas(ordenadas);
    }

    public static void validarNotas(Nota[] notas) {
        String[] notasValidas = {"do", "re", "mi", "fa", "sol", "la", "si"};
        String[] duracionesValidas = {"1", "1/2", "1/4"};
        double sumDuracion = 0;

        for (Nota nota : notas) {
            // Validar nombre de la nota
            if (!Arrays.asList(notasValidas).contains(nota.note.toLowerCase())) {
                throw new RuntimeException("Nota inválida: " + nota.note);
            }

            // Validar duración
            String duracion = nota.getDuration();
            if (!Arrays.asList(duracionesValidas).contains(duracion)) {
                throw new RuntimeException("Duración inválida: " + duracion);
            }

            sumDuracion += convertirFraccion(duracion);
        }

        if (sumDuracion != 1.0) {
            throw new RuntimeException("La suma de las duraciones debe ser igual a 1.0");
        }
    }

    public static List<Nota> ordenarNotas(Nota[] notas) {
        List<Nota> lista = new ArrayList<>(Arrays.asList(notas));

        // Usamos Collections.sort con un Comparator explícito
        Collections.sort(lista, new Comparator<Nota>() {
            @Override
            public int compare(Nota n1, Nota n2) {
                return Integer.compare(n1.index, n2.index);
            }
        });

        return lista;
    }

    public static void imprimirNotas(List<Nota> lista) {
        // Encontramos el ancho máximo de duración y nota para alinear
        int maxDuracion = 0;
        int maxNota = 0;
        for (Nota nota : lista) {
            if (nota.getDuration().length() > maxDuracion) maxDuracion = nota.getDuration().length();
            if (nota.note.length() > maxNota) maxNota = nota.note.length();
        }

        StringBuilder duraciones = new StringBuilder();
        StringBuilder notas = new StringBuilder();

        for (Nota nota : lista) {
            duraciones.append("| ").append(alinear(nota.getDuration(), maxDuracion)).append(" ");
            notas.append("| ").append(alinear(nota.note, maxNota)).append(" ");
        }

        duraciones.append("|");
        notas.append("|");

        System.out.println(duraciones);
        System.out.println(notas);
    }

    public static String alinear(String texto, int ancho) {
        // Alinea el texto a la izquierda y completa con espacios
        StringBuilder sb = new StringBuilder(texto);
        while (sb.length() < ancho) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static double convertirFraccion(String fraccion) {
        if (fraccion.equals("1")) return 1.0;
        if (fraccion.equals("1/2")) return 0.5;
        if (fraccion.equals("1/4")) return 0.25;
        throw new RuntimeException("Fracción inválida: " + fraccion);
    }
}
