package in.marshalltech;

import static org.assertj.core.api.Assertions.assertThat;

import in.marshalltech.enquiry.EnquiryRepository;
import java.net.CookieManager;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SiteFlowTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EnquiryRepository enquiries;

    private HttpClient http;

    @BeforeEach
    void setUp() {
        http = HttpClient.newBuilder()
                .cookieHandler(new CookieManager())
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    @Test
    void pagesRenderTheBrief() throws Exception {
        assertThat(page("/")).contains("We automate", "We welcome customization", "94428 91189", "Rathinapuri");
        assertThat(page("/about")).contains("ISO 9001:2015", "Save water", "Grace Hill");
        assertThat(page("/projects")).contains("Whole-home control", "The hill house", "Home appliances");
        assertThat(page("/gallery")).contains("Concept studies", "Door lock");
        assertThat(page("/contact")).contains("Murugan Nagar", "marshalltech13@gmail.com");
        HttpResponse<String> missing = http.send(get("/does-not-exist"), HttpResponse.BodyHandlers.ofString());
        assertThat(missing.statusCode()).isEqualTo(404);
        assertThat(missing.body()).contains("not on this site");
        assertThat(status("/css/site.css")).isEqualTo(200);
        assertThat(status("/images/hero.jpg")).isEqualTo(200);
    }

    @Test
    void contactStoresANoteAndRejectsABlankForm() throws Exception {
        long before = enquiries.count();

        String invalid = post(form("", "", "", "", ""));
        assertThat(invalid).contains("Tell us your name.");
        assertThat(enquiries.count()).isEqualTo(before);

        String saved = post(form(
                "Asha",
                "94428 91189",
                "asha@example.com",
                "A whole-home plan",
                "We want lights, a lock, and pump control for a new house in Rathinapuri."));
        assertThat(saved).contains("We have your note");
        assertThat(enquiries.count()).isEqualTo(before + 1);

        Map<String, String> spam = form(
                "Asha",
                "94430 22037",
                "asha@example.com",
                "Not sure yet",
                "This note should be discarded by the honeypot.");
        spam.put("faxNumber", "spam");
        String ignored = post(spam);
        assertThat(ignored).contains("We have your note");
        assertThat(enquiries.count()).isEqualTo(before + 1);
    }

    private String page(String path) throws Exception {
        HttpResponse<String> response = http.send(get(path), HttpResponse.BodyHandlers.ofString());
        assertThat(response.statusCode()).isEqualTo(200);
        return response.body();
    }

    private int status(String path) throws Exception {
        return http.send(get(path), HttpResponse.BodyHandlers.discarding()).statusCode();
    }

    private String post(Map<String, String> form) throws Exception {
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:" + port + "/contact"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(encode(form)))
                .build();
        return http.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

    private HttpRequest get(String path) {
        return HttpRequest.newBuilder(URI.create("http://localhost:" + port + path))
                .header("Accept", "text/html")
                .GET()
                .build();
    }

    private static Map<String, String> form(String name, String phone, String email, String interest, String message) {
        Map<String, String> form = new LinkedHashMap<>();
        form.put("name", name);
        form.put("phone", phone);
        form.put("email", email);
        form.put("city", "Coimbatore");
        form.put("interest", interest);
        form.put("message", message);
        return form;
    }

    private static String encode(Map<String, String> form) {
        StringBuilder body = new StringBuilder();
        form.forEach((key, value) -> {
            if (!body.isEmpty()) {
                body.append('&');
            }
            body.append(URLEncoder.encode(key, StandardCharsets.UTF_8));
            body.append('=');
            body.append(URLEncoder.encode(value, StandardCharsets.UTF_8));
        });
        return body.toString();
    }
}
