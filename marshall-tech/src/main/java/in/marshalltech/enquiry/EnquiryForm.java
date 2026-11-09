package in.marshalltech.enquiry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EnquiryForm {

    @NotBlank(message = "Tell us your name.")
    @Size(max = 80, message = "Name must be 80 characters or fewer.")
    private String name;

    @NotBlank(message = "Enter a mobile number we can call.")
    @Pattern(
            regexp = "^(?:\\+91[\\s-]?)?[6-9](?:\\d[\\s-]?){9}$",
            message = "Use a 10-digit mobile number, for example 94428 91189.")
    private String phone;

    @NotBlank(message = "Enter an email address.")
    @Email(message = "That email address does not look complete.")
    @Size(max = 120, message = "Email must be 120 characters or fewer.")
    private String email;

    @Size(max = 80, message = "City must be 80 characters or fewer.")
    private String city;

    @NotBlank(message = "Choose what you want to talk about.")
    @Size(max = 80)
    private String interest;

    @NotBlank(message = "Add a sentence about the house.")
    @Size(min = 12, max = 1200, message = "Keep the note between 12 and 1200 characters.")
    private String message;

    private String faxNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public boolean isHoneypotFilled() {
        return faxNumber != null && !faxNumber.isBlank();
    }
}
