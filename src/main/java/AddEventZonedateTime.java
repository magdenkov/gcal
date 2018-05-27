import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddEventZonedateTime {
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
        InputStream in = AddEventZonedateTime.class.getResourceAsStream(CLIENT_SECRET_DIR);

//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(CREDENTIALS_FOLDER)))
//                .setAccessType("offline")
//                .build();
//        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("102772055220932283143");

        GoogleCredential credential = GoogleCredential
                .fromStream(in)
                .createScoped(SCOPES);

        return credential;


    }



    public static void main(String... args) throws IOException, GeneralSecurityException {
//        String calendarId = "denis.magdenkov@mynd.co";
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final Credential credentials = getCredentials(HTTP_TRANSPORT);



        // list calendar
        // create calendar

        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName("mynd-task-calendar")
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

        calendar.setTimeZone("PDT");
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
                .setSummary("Testing api from console UTCtime")
//                .setColorId("#fa573c")
                .setLocation("800 Howard St., San Francisco, CA 94103")
                .setDescription("A chance to hear more about Google's developer products.");

//        DateTime startDateTime = new DateTime("2018-05-15T09:00:00z");
        DateTime startDateTime = new DateTime("2018-05-19");
        EventDateTime start = new EventDateTime()
//                .setDateTime(startDateTime)
                .setDate(startDateTime)
                .setTimeZone("UTC");
        event.setStart(start);

//        DateTime endDateTime = new DateTime("2018-05-15T17:00:00z");
        DateTime endDateTime = new DateTime("2018-05-19");
        EventDateTime end = new EventDateTime()
//                .setDateTime(endDateTime)
                .setDate(endDateTime)
                .setTimeZone("UTC");
        event.setEnd(end);


        EventAttendee[] attendees = new EventAttendee[] {
                new EventAttendee().setEmail("denis.magdenkov@mynd.co"),
//                new EventAttendee().setEmail("ivan.arkhipov@mynd.co"),
//                new EventAttendee().setEmail("eugene.udovychenko@mynd.co"),
        };
        event.setAttendees(Arrays.asList(attendees));

//        event.setId("01234789abcdefaaghijk");


        event = service.events().insert("11fkfmncv5qdnlifgs5m55m460@group.calendar.google.com", event).execute();
        System.out.printf("Event created: %s\n", event.getHtmlLink());
        System.out.printf("Event IF: %s\n", event.getId());
        System.out.printf("Event : %s\n", event.getColorId());
        System.out.printf("Event " +  event);

// https://developers.google.com/calendar/create-events


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