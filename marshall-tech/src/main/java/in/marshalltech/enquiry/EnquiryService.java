package in.marshalltech.enquiry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnquiryService {

    private static final Logger log = LoggerFactory.getLogger(EnquiryService.class);

    private final EnquiryRepository repository;

    public EnquiryService(EnquiryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save(EnquiryForm form) {
        String city = form.getCity() == null ? "" : form.getCity().trim();
        repository.save(new Enquiry(
                form.getName().trim(),
                form.getPhone().trim(),
                form.getEmail().trim(),
                city,
                form.getInterest().trim(),
                form.getMessage().trim()));
        log.info("Stored a contact enquiry");
    }
}
