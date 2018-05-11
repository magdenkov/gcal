import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ServerAuth {

    // https://developers.google.com/identity/protocols/OpenIDConnect#setredirecturi

    public static void main(String[] args) {
        ServletRequest request = new ServletRequest() {
            @Override
            public Object getAttribute(String name) {
                return null;
            }

            @Override
            public Enumeration getAttributeNames() {
                return null;
            }

            @Override
            public String getCharacterEncoding() {
                return null;
            }

            @Override
            public void setCharacterEncoding(String env) throws UnsupportedEncodingException {

            }

            @Override
            public int getContentLength() {
                return 0;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public ServletInputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public String getParameter(String name) {
                return null;
            }

            @Override
            public Enumeration getParameterNames() {
                return null;
            }

            @Override
            public String[] getParameterValues(String name) {
                return new String[0];
            }

            @Override
            public Map getParameterMap() {
                return null;
            }

            @Override
            public String getProtocol() {
                return null;
            }

            @Override
            public String getScheme() {
                return null;
            }

            @Override
            public String getServerName() {
                return null;
            }

            @Override
            public int getServerPort() {
                return 0;
            }

            @Override
            public BufferedReader getReader() throws IOException {
                return null;
            }

            @Override
            public String getRemoteAddr() {
                return null;
            }

            @Override
            public String getRemoteHost() {
                return null;
            }

            @Override
            public void setAttribute(String name, Object o) {

            }

            @Override
            public void removeAttribute(String name) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }

            @Override
            public Enumeration getLocales() {
                return null;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public RequestDispatcher getRequestDispatcher(String path) {
                return null;
            }

            @Override
            public String getRealPath(String path) {
                return null;
            }

            @Override
            public int getRemotePort() {
                return 0;
            }

            @Override
            public String getLocalName() {
                return null;
            }

            @Override
            public String getLocalAddr() {
                return null;
            }

            @Override
            public int getLocalPort() {
                return 0;
            }
        };

        // Create a state token to prevent request forgery.
        // Store it in the session for later validation.
//        String state = new BigInteger(130, new SecureRandom()).toString(32);
//        request.session().attribute("state", state);
//        // Read index.html into memory, and set the client ID,
//        // token state, and application name in the HTML before serving it.
//        return new Scanner(new File("index.html"), "UTF-8")
//                .useDelimiter("\\A").next()
//                .replaceAll("[{]{2}\\s*CLIENT_ID\\s*[}]{2}", CLIENT_ID)
//                .replaceAll("[{]{2}\\s*STATE\\s*[}]{2}", state)
//                .replaceAll("[{]{2}\\s*APPLICATION_NAME\\s*[}]{2}",
//                        APPLICATION_NAME);
//
//    }
//
//    // Ensure that there is no request forgery going on, and that the user
//    // sending us this connect request is the user that was supposed to.
//  if (!request.queryParams("state").equals(
//            request.session().attribute("state"))) {
//        response.status(401);
//        return GSON.toJson("Invalid state parameter.");
    }
}



