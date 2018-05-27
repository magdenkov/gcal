import java.time.*;

public class TestZonedDateTime {


    public static void main(String[] args) {
         LocalDate ld = LocalDate.parse("2018-05-17");
        String nowTimeString = "12:34:56";
        LocalTime lt = LocalTime.parse(nowTimeString);

        OffsetDateTime zonedDateTime = OffsetDateTime.of(ld, lt , ZoneOffset.of("-07"));
//                ZoneId.of("UTC-07"));

        System.out.println(zonedDateTime.toString());
        System.out.println(zonedDateTime.plusHours(1).toString());



    }



}
