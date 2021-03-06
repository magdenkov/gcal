import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;
import com.google.common.io.CharSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarUpdateTimeZone {
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FOLDER = "credentials"; // Directory to store user credentials.

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved credentials/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);
//    private static final String CLIENT_SECRET_DIR = "client_secret.json";
//    private static final String CLIENT_SECRET_DIR = "client_secret2.json";
//    private static final String CLIENT_SECRET_DIR = "client_service_secret.json";
    private static final String CLIENT_SECRET_DIR = "client_secret3.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If there is no client_secret.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
//        InputStream in =
//                CalendarUpdateTimeZone.class.getResourceAsStream(CLIENT_SECRET_DIR);

//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(CREDENTIALS_FOLDER)))
//                .setAccessType("offline")
//                .build();
//        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("102772055220932283143");

        GoogleCredential credential = GoogleCredential
                .fromStream(new ByteArrayInputStream(googleKey.getBytes()))
//                .fromStream(in)
                .createScoped(SCOPES);

        return credential;


    }

    static final String googleKey = "{\n" +
            "  \"type\": \"service_account\",\n" +
            "  \"project_id\": \"tranquil-tiger-203809\",\n" +
            "  \"private_key_id\": \"6fd2b625a52415be0e2520011416ef354472f1a7\",\n" +
            "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDnFTPKFdLtcd+M\\n1TMPOyYMPGIPNMJS28Y9xAufzri9cCRGOwEEG/je5dv/nuuQU1ExqgnTEfou6Xwl\\n275ak1hpjNEyMSrchVg8thNJreIENObH4Ih8koRAzacJnnAYG6jjvCe52KC2nRAV\\nogN4G9rAaWdnYir9Jw/LypYnoAiclzfEYB+cv3tUHCjjzOKDF+OQUHaCywly8KA8\\njDlYJg4z9d1Q80wsMs0lBp+1pEnLZvBPeOoxUYyv8CqK7KwgRa5Y8zNmxoLJDUxc\\njB7i/ONQ7EUGJUBXm3/dhxpchFoZUcKY7GrCkpO3W5d+1nnJiRvX+aLslv2UTNLW\\nMOJAHi59AgMBAAECggEAAZKpwVEexVbs8PD26yfE4jT3mcltACFxIJ4W9+48jZ65\\npLglr2rbj2zYs01YPTEL/cKFVOSNo5rfEte4J+PZ+0xLsrSsyyjS9m6X5iJImQ6s\\na1oMo8hud9jsoFmTd+2ZckFFhfPCyxxbk4XiaJKPusRvudYZfTjBSScIeo6+7H7e\\nZmvpFDyyoye7pEElRLYXWobmgwn1OAU30j31PYYIKetdZpbebZEhryhFwTcDj0x0\\n6R6Pg5qOg/TIMZ57aeLqBUzPcIEzWJMoHqheWc5yTRdwg0dQaLR7SPCCWeTrfCuN\\n40sApY+z0h1trtr+YKK4cFwunj9M6s30qRXOherFMwKBgQD5bTUIP9OUg6KWbLjM\\nQczirkg9dHSou8ZCDlRQKTcQtoUTVxA4dJNUlyyu9mUfl2/c7wU0wcYWoITyp22q\\nSsytHeMMkCWH4vkaqfhrtLhpJH+co1Ye0klXeya4g9MCz7SCEbq2cx767Aic07O6\\nIVyiypy0DV5h71PdVKUwaBdXKwKBgQDtLDx53fgtUR1g+94YdsLSe6KF454mdmd5\\ntz+mxqtRK0Z51A8WPD0kos5LPcSAUx0m9o3pkHOTrM+tz0rmjIUxpq1+NSu1M0OL\\nplAUKrib28qlcSvFo4d3dLTyXfsJDbS2yK3ZMAI0n1SDTs8Qr2Rquf83xy6OHWy3\\neFTyBgE89wKBgQCs2iKbUegljsfY6QVz/9Gl8dN8Sz0hRefSFS4W00km2uYEDhze\\nkuMbBxzfLz/LEd5ixH3eHr9RJPKdWqwkDGwlOIYFScvIjOHGua2/rmDx9Go/Oe5P\\ns7lB18Vwr2JHG3vje7fiAougpnwdepSd08rnwfOwz2buBbYfty43CpvKOwKBgQCs\\nuxToZKLEzlipM4ZTJttI1EZPYLDjrkQ6Px2aZwKKQQw42hqKxSB6uB+qaLfeBaor\\noFFGk6+5E5jFKz2PnzO6L3wXeL32X/mHkX6s0VhWGsMBruSEMk8MzvChu5SCyXqd\\nzJXgobhZftjcMN9ZdYOavw+DHgtn8UImdPrYsUrhjQKBgQDhfI22q/OAmkAgZqdh\\n8qh7cqIDfUJgbUmOf2kvu3Dj3Ik7ANnCfRliYs/7q5O/w7VIfuQdP1FpEay1q3vi\\naWRfkspRJ4Bb273ZH1zVNoaX6iSWXQvbHSLQLVVPrXcgcp7lI+L+KEBRW8oe0Pcf\\nNJPwFc5EjjVHtPrb3RWNbaHHUg==\\n-----END PRIVATE KEY-----\\n\",\n" +
            "  \"client_email\": \"mynd-task-calendar@tranquil-tiger-203809.iam.gserviceaccount.com\",\n" +
            "  \"client_id\": \"104406961321859201975\",\n" +
            "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
            "  \"token_uri\": \"https://accounts.google.com/o/oauth2/token\",\n" +
            "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
            "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/mynd-task-calendar%40tranquil-tiger-203809.iam.gserviceaccount.com\"\n" +
            "}";


    static final String keyApi = "AIzaSyAuCtHmkmjLQz3simsqGjGWCMM1ICQyhrc";

    public static void main(String... args) throws IOException, GeneralSecurityException {
//        String calendarId = "denis.magdenkov@mynd.co";
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final Credential credentials = getCredentials(HTTP_TRANSPORT);



        // list calendar
        // create calendar

//        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, null)
                .setApplicationName("mynd-task-calendar")
//                .setK
                .build();

        // List the next 10 events from the primary calendar.
//        DateTime now = new DateTime(System.currentTimeMillis());
//        Events events = service.events().list(calendarId)
//                .setMaxResults(10)
//                .setTimeMin(now)
//                .setOrderBy("startTime")
//                .setSingleEvents(true)
//                .execute();
//        List<Event> items = events.getItems();
//        if (items.isEmpty()) {
//            System.out.println("No upcoming events found.");
//        } else {
//            System.out.println("Upcoming events");
//            for (Event event : items) {
//                DateTime start = event.getStart().getDateTime();
//                if (start == null) {
//                    start = event.getStart().getDate();
//                }
//                System.out.printf("%s (%s)\n", event.getSummary(), start);
//            }
//        }



        // Refer to the Java quickstart on how to setup the environment:
// https://developers.google.com/calendar/quickstart/java
// Change the scope to CalendarScopes.CALENDAR and delete any stored
// credentials.

        String pageToken = null;
        String calendarGeneratedId = null;
        do {
            CalendarList calendarList = service.calendarList().list().setPageToken(pageToken).execute();
            List<CalendarListEntry> items = calendarList.getItems();

            System.out.println("Amount of calendars   " + items.size());

            for (CalendarListEntry calendarListEntry : items) {
                System.out.println("CAl summary " + calendarListEntry.getSummary());
                System.out.println("CAl ID " + calendarListEntry.getId());
                System.out.println("Time zone " + calendarListEntry.getTimeZone());
                calendarGeneratedId = calendarListEntry.getId();
            }
            pageToken = calendarList.getNextPageToken();
        } while (pageToken != null);


        com.google.api.services.calendar.model.Calendar calendar =
                   service.calendars().get(calendarGeneratedId).execute();
//        service.calendars().clear(calendarGeneratedId).execute();

//        clearAllEventsInCalendarByCalId(service, pageToken, calendarGeneratedId);

        calendar.setTimeZone(null);
        calendar.setSummary("Mynd tasks due dates");
        com.google.api.services.calendar.model.Calendar updatedCalendar =
                service.calendars().update(calendar.getId(), calendar).execute();

        System.out.println(updatedCalendar.getEtag());






//        String eventText = "Appointment at Somewhere on June 3rd 10am-10:25am";
//        Event createdEvent =
//                service.events()
//                        .quickAdd(calendarGeneratedId, "qucik add")
//                        .setSendNotifications(true)
//                        .setText(eventText)
//                        .execute();
//        System.out.println("Quick added event id" + createdEvent.getId());
//        EventAttendee[] attendees2 = new EventAttendee[] {
//                new EventAttendee().setEmail("denis.magdenkov@mynd.co"),
////                new EventAttendee().setEmail("ivan.arkhipov@mynd.co"),
////                new EventAttendee().setEmail("eugene.udovychenko@mynd.co"),
//        };
//        createdEvent.setAttendees(Arrays.asList(attendees2));
//        service.events().update(calendarGeneratedId, createdEvent.getId(), createdEvent).execute();



        // Iterate over the events in the specified calendar
//        System.out.println("*************Printing events of calendar*****");
//        String pageToken1 = null;
//        do {
//            Events events = service.events().list(calendarGeneratedId).setPageToken(pageToken1).execute();
//            List<Event> items = events.getItems();
//            for (Event event : items) {
//                System.out.println(event.getSummary());
//                if (event.getAttendees() != null) {
//                    System.out.println(event.getAttendees().stream().map(att -> att.toString()).collect(Collectors.joining(",")));
//                } else {
//                    System.out.println("event does not have attendities");
//                }
//            }
//            pageToken1 = events.getNextPageToken();
//        } while (pageToken1 != null);
//
//        System.out.println("*************END OF EVENTS IN current calendar*****");

        // Create a new calendar
        //createANewCalendar(service);



        // Create a new calendar list entry
//        CalendarListEntry calendarListEntry = new CalendarListEntry();
//        calendarListEntry.setId("tasksCalendarIDgfgfgjflgjfgkjfkjgfdjgm;lfdjkgfdkgfdkgkfgfdgfdkgfdgdfg");
//
//// Insert the new calendar list entry
//        CalendarListEntry createdCalendarListEntry = service.calendarList().insert(calendarListEntry).execute();
//
//        System.out.println("Calendar summary " +  createdCalendarListEntry.getSummary());



        Event event = new Event()
                .setSummary("date time format")
                .setColorId("11")
                .setKind("calendar#event")
                .setLocation("800 Howard St., San Francisco, CA 94103")
                .setDescription("A chance to hear more about Google's developer products.FUUCKCKC");


//        LocalDate dueDate = LocalDate.parse("2018-05-20");
//        LocalTime dueTime = LocalTime.parse("18:15");
//
////        String pattern = "yyyy-MM-dd'T'HH:mm:ssXXX";
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        OffsetDateTime startttItm =  OffsetDateTime.of(dueDate, dueTime, ZoneOffset.of("-07")).minusHours(1);
//        String formatted = simpleDateFormat.format(startttItm);


//        System.out.println("start time   " + formatted);

        DateTime startDateTime = new DateTime("2018-05-23T09:34:56-07:00");
//        DateTime startDateTime = new DateTime(formatted);
//        DateTime startDateTime = new DateTime("2018-05-18");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
//                .setDate(startDateTime);
//                .setTimeZone("America/Los_Angeles");
                .setTimeZone("Europe/Zurich");
        event.setStart(start);

        DateTime endDateTime = new DateTime("2018-05-23T19:34:56");
//        DateTime endDateTime = new DateTime("2018-05-19");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
//                .setDate(endDateTime);
//                .setTimeZone("America/Los_Angeles");
                .setTimeZone("Europe/Zurich");
        event.setEnd(end);


        EventAttendee[] attendees = new EventAttendee[] {
                new EventAttendee().setEmail("denis.magdenkov@mynd.co"),
//                new EventAttendee().setEmail("magdenkov@gmail.com"),
//                new EventAttendee().setEmail("ivan.arkhipov@mynd.co"),
//                new EventAttendee().setEmail("eugene.udovychenko@mynd.co"),
        };
        event.setAttendees(Arrays.asList(attendees));

        final String eventId = "1vdnq8ns98hajsso1";
//        event.setId(eventId);
        event.setLocation("location 3434");
        event.setHtmlLink("https://tasks.staging.mynd.ws/tasks/q6vr57rli04naj3t");
//        event.setCreator(Event.Creator())


        final String calendarId = "11fkfmncv5qdnlifgs5m55m460@group.calendar.google.com";
//        event = service.events().insert(calendarId, event).execute();
        event.setColorId("7");
        // here uncomment
//        event = service.events().insert(calendarId, event).execute();
        clearAllEventsInCalendarByCalId(service, calendarGeneratedId);



//        System.out.printf("Event created: %s\n", event.getHtmlLink());
//        System.out.printf("Event IF: %s\n", event.getId());
//        System.out.printf("Event colloer id : %s\n", event.getColorId());
//        System.out.printf("Event itself " +  event);
//        System.out.println();
        event.equals(event);


//        try {
//            Event eventGEt = service.events().get(calendarId, eventId + "12" ).execute();
//            System.out.printf("Event created: %s\n", event.getHtmlLink());
//            System.out.printf("Event IF: %s\n", event.getId());
//            System.out.printf("Event colloer id : %s\n", event.getColorId());
//            System.out.printf("Event itself " +  event);
//            System.out.println();
//            System.out.println("eventGet " + eventGEt);
//        } catch (GoogleJsonResponseException googleJsonResponseException) {
//            System.out.println("CODE " + googleJsonResponseException.getDetails().getCode());
//            System.err.println("event not found" + googleJsonResponseException);
//        }
// https://developers.google.com/calendar/create-events


    }

    private static void clearAllEventsInCalendarByCalId(Calendar service, String calendarGeneratedId) throws IOException {
        System.out.println("getting all events");
        String pageTokenToClean = null;
        do {
            Events events = service.events().list(calendarGeneratedId).setPageToken(pageTokenToClean).execute();
            List<Event> items = events.getItems();
            for (Event event : items) {
                System.out.println(event.getSummary());
                System.out.println(event);
//                service.events().delete(calendarGeneratedId, event.getId()).execute();

            }
            pageTokenToClean = events.getNextPageToken();
        } while (pageTokenToClean != null);

        System.out.println("Finish getting all events ");
    }

    private static void createANewCalendar(Calendar service) throws IOException {
        com.google.api.services.calendar.model.Calendar calendar = new com.google.api.services.calendar.model.Calendar();
        calendar.setSummary("calendarSummary");
        calendar.setTimeZone("America/Los_Angeles");

// Insert the new calendar
        com.google.api.services.calendar.model.Calendar createdCalendar = service.calendars().insert(calendar).execute();

        System.out.println(createdCalendar.getId());
    }
}