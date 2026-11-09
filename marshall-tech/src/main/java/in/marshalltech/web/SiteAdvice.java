package in.marshalltech.web;

import in.marshalltech.content.SiteCatalog;
import java.time.Year;
import java.time.ZoneId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class SiteAdvice {

    private final SiteCatalog catalog;
    private final String publicUrl;

    public SiteAdvice(SiteCatalog catalog, @Value("${app.public-url}") String publicUrl) {
        this.catalog = catalog;
        this.publicUrl = publicUrl.endsWith("/") ? publicUrl.substring(0, publicUrl.length() - 1) : publicUrl;
    }

    @ModelAttribute("site")
    public SiteCatalog site() {
        return catalog;
    }

    @ModelAttribute("publicUrl")
    public String publicUrl() {
        return publicUrl;
    }

    @ModelAttribute("year")
    public int year() {
        return Year.now(ZoneId.of("Asia/Kolkata")).getValue();
    }
}
