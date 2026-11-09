package in.marshalltech.web;

import in.marshalltech.enquiry.EnquiryForm;
import in.marshalltech.enquiry.EnquiryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    private final EnquiryService enquiryService;

    public ContactController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new EnquiryForm());
        }
        return "contact";
    }

    @PostMapping("/contact")
    public String submit(
            @Valid @ModelAttribute("form") EnquiryForm form,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (form.isHoneypotFilled()) {
            redirectAttributes.addFlashAttribute("sent", true);
            return "redirect:/contact";
        }
        if (result.hasErrors()) {
            return "contact";
        }
        enquiryService.save(form);
        redirectAttributes.addFlashAttribute("sent", true);
        return "redirect:/contact";
    }
}
