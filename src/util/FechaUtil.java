package util;

import java.time.Duration;
import java.time.LocalDateTime;

public class FechaUtil {

    public static String ahora() {
        return LocalDateTime.now().toString();
    }

    public static long calcularMinutos(String entrada, String salida) {
        LocalDateTime e = LocalDateTime.parse(entrada);
        LocalDateTime s = LocalDateTime.parse(salida);
        return Duration.between(e, s).toMinutes();
    }
}
