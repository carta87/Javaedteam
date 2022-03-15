package FuncionalLambda;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Fecha {

    public static void main(String[] args) {
        LocalDate fecha = LocalDate.of(2022, Month.MARCH, 7);
        LocalTime hora = LocalTime.of(15, 49);
        LocalDateTime fechaHora = LocalDateTime.of(fecha,hora);//trabaja si fuera dos objectos

        System.out.println(fechaHora);

        fechaHora.minusHours(1);//no modifica por que es inmutable
        System.out.println(fechaHora);

        fechaHora = fechaHora.minusHours(1);//igualarlo.... cuando lo modifico se crea un nuevo objecto
        System.out.println(fechaHora);

        Period duracion = Period.ofDays(1);//reducir un dia
        fechaHora = fechaHora.minus(duracion);
        System.out.println();

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(formatter.format(fechaHora));// 6/3/22 14:49

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM dd yyyy");
        System.out.println(formatter1.format(fechaHora));      //  02 06 2022
    }
}
