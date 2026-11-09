package in.marshalltech.enquiry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "enquiries")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 32)
    private String phone;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(length = 80)
    private String city;

    @Column(nullable = false, length = 80)
    private String interest;

    @Column(nullable = false, length = 1200)
    private String message;

    @Column(nullable = false)
    private Instant createdAt;

    protected Enquiry() {}

    public Enquiry(String name, String phone, String email, String city, String interest, String message) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.interest = interest;
        this.message = message;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getInterest() {
        return interest;
    }

    public String getMessage() {
        return message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
