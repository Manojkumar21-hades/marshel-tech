package in.marshalltech.content;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Facts taken from the Marshall Tech card and service sheet.
 * Project patterns are ways of working, not named client jobs.
 */
@Component
public class SiteCatalog {

    private final Company company;
    private final List<Offering> services;
    private final List<Solution> solutions;
    private final List<Pattern> patterns;
    private final List<GalleryItem> gallery;
    private final List<String> interests;
    private final List<Pin> pins;
    private final List<Step> steps;
    private final List<Scene> scenes;

    public SiteCatalog() {
        company = new Company(
                "Marshall Tech",
                "Inspiring Innovation",
                "LEDs, Controllers, Sensors & Much More",
                "marshalltech13@gmail.com",
                "marshallin.in",
                "https://marshallin.in",
                List.of(
                        new Phone("94428 91189", "+919442891189"),
                        new Phone("94430 22037", "+919443022037")),
                List.of(
                        new Studio(
                                "Coimbatore",
                                "41/1 Murugan Nagar, 2nd Street, Rathinapuri, Coimbatore.",
                                "https://www.google.com/maps/search/?api=1&query=41/1+Murugan+Nagar+2nd+Street+Rathinapuri+Coimbatore"),
                        new Studio(
                                "Coonoor, Nilgiris",
                                "67, Muthu Pillai Line, Grace Hill, Coonoor, Nilgiris.",
                                "https://www.google.com/maps/search/?api=1&query=67+Muthu+Pillai+Line+Grace+Hill+Coonoor+Nilgiris")));

        services = List.of(
                new Offering(
                        "electrical",
                        "Electrical & Plumbing Services",
                        "The points, pipes, and routes the rest of the house depends on. Planned so a later sensor or pump does not mean opening the same wall twice."),
                new Offering(
                        "whole-home",
                        "Automation Products",
                        "Controllers, sensors, and the panels that tie a house together. Scenes are written for your rooms, not copied from a stock list."),
                new Offering(
                        "cameras",
                        "Security Systems & CCTV",
                        "Cameras, a video door, and locks, with the recorder kept somewhere sensible. See the gate from the phone, and still keep a key."),
                new Offering(
                        "lighting",
                        "LED Lights, LED TV & Panels",
                        "Cove light, panels, and screens, dimmed as the day changes. A room that is comfortable at noon and quiet at night."),
                new Offering(
                        "power",
                        "Inverter (UPS) & Solar Products",
                        "The circuits you actually need stay on when the grid drops. Where the roof can take it, solar cuts the power you buy."),
                new Offering(
                        "water",
                        "RO & UV Systems & Pumps",
                        "Purifiers, UV, and pumps that stop when the tank is full and hold when the sump runs dry."),
                new Offering(
                        "appliances",
                        "Home Appliances",
                        "Kitchen, laundry, and utility chosen with the electrical plan, so the appliances and the automation belong to the same drawing."));

        solutions = List.of(
                new Solution(
                        "whole-home",
                        "Whole-home control",
                        "One way to run the house",
                        "Lights, locks, shades, cameras, and the pump answer to the same scenes. A panel by the door. The phone when you are away.",
                        List.of(
                                "Goodnight, away, and arrive scenes written for your routine",
                                "A wall panel and a phone view of the same house",
                                "Room-by-room control where a whole-house scene is too much",
                                "A handover that shows every scene, not only the wiring")),
                new Solution(
                        "lighting",
                        "Lighting scenes",
                        "LED light, panels, screens",
                        "Cove, task, and panel light on drivers sized for the room. Evening is a scene, not a row of switches left half on.",
                        List.of(
                                "Dimming per room, with a bright scene for work and a low scene for night",
                                "LED panels and feature light where a false ceiling can take them",
                                "Porch and passage light that can stay on after the hall sleeps",
                                "TV and screen points planned with the viewing seat, not after the plaster")),
                new Solution(
                        "access",
                        "Locks & video door",
                        "Who comes in",
                        "A lock on the main door, a video door phone, and a scene that locks up when you leave. Mechanical entry stays in place.",
                        List.of(
                                "Smart lock with a key override",
                                "Video door phone at the gate or the flat door",
                                "A leaving scene that locks the doors you choose",
                                "Codes for family, with a way to remove one later")),
                new Solution(
                        "cameras",
                        "Cameras & recording",
                        "See the gate",
                        "Cameras where they can actually see: gate, porch, parking, and the side that is dark. The recorder gets power and a proper spot.",
                        List.of(
                                "Outdoor cameras with a view that was checked on site",
                                "Recording kept on the premises",
                                "Phone viewing when you are away",
                                "Cabling routes agreed before the walls close")),
                new Solution(
                        "shades",
                        "Shades",
                        "Light, without the glare",
                        "Motorized curtains for the rooms that take the afternoon sun. One control, instead of a cord in every window.",
                        List.of(
                                "Sheer and blackout where the room needs both",
                                "A morning scene and an afternoon scene",
                                "Manual override if the power is out",
                                "Tracks chosen for the lintel you already have")),
                new Solution(
                        "water",
                        "Water line",
                        "Save water",
                        "The sump, the tank, the pump, and the purifier treated as one line. The pump stops when the tank is full. It does not run a dry sump.",
                        List.of(
                                "Overhead tank and sump sensing",
                                "Dry-run protection on the pump",
                                "RO and UV sized for the household",
                                "A simple alert when the line needs a look")),
                new Solution(
                        "power",
                        "Backup & solar",
                        "Save energy",
                        "An inverter on the circuits that matter, and solar where the roof, the shade, and the bill justify it. The utility room is drawn, not improvised.",
                        List.of(
                                "Essential circuits listed before the inverter is chosen",
                                "Battery and inverter mounted with clear cable routes",
                                "Solar on roofs that can carry it",
                                "A changeover you can explain to the next electrician")),
                new Solution(
                        "electrical",
                        "Electrical & plumbing base",
                        "Under the automation",
                        "Distribution, points, and pipes done so the automation has somewhere honest to live. This is the work a smart panel cannot replace.",
                        List.of(
                                "Distribution and circuit planning",
                                "Points for light, fan, appliance, and data",
                                "Pump and purifier plumbing",
                                "Space left for a later controller")));

        patterns = List.of(
                new Pattern(
                        "The evening house",
                        "Coimbatore",
                        "A family home where the front door is the control. One scene for the end of the day.",
                        "/images/hero.jpg",
                        "A concept study of a villa at dusk.",
                        List.of(
                                "Hall and rooms drop to a night scene",
                                "Porch light stays on",
                                "Main door locks",
                                "Gate camera is live on the phone")),
                new Pattern(
                        "The hill house",
                        "Nilgiris",
                        "A house that has to respect the power cut and the water tank before it respects the mood lighting.",
                        "/images/solar.jpg",
                        "A concept study of rooftop solar above the hills.",
                        List.of(
                                "Inverter covering lights, the router, and one fridge point",
                                "Pump logic for a tank on an uneven supply",
                                "Solar if the roof faces the right way",
                                "Sensors that still make sense in a cooler, wetter season")),
                new Pattern(
                        "The apartment",
                        "A smaller plan",
                        "Less ceiling to open, and a door that is shared with a landing. The useful work is concentrated.",
                        "/images/living.jpg",
                        "A concept study of layered LED lighting in a living room.",
                        List.of(
                                "Smart switches where a full rewire is not on the table",
                                "Video door phone at the flat door",
                                "RO under the sink",
                                "Lighting scenes that do not need a new false ceiling everywhere")),
                new Pattern(
                        "The utility room",
                        "The room that keeps the house up",
                        "Inverter, pump, purifier, and distribution in one orderly corner, labeled for the next service visit.",
                        "/images/water.jpg",
                        "A concept study of a purifier and pump installation.",
                        List.of(
                                "Cable routes in trunking, not loose loops",
                                "Pump and tank logic with dry-run protection",
                                "Inverter on a listed set of circuits",
                                "Labels a stranger can read")));

        gallery = List.of(
                new GalleryItem("Evening house", "Concept study of a villa at dusk, with light along the path and in the rooms.", "Lighting", "/images/hero.jpg"),
                new GalleryItem("Door lock", "Concept study of a smart lock on a timber door, with a key still part of the plan.", "Security", "/images/lock.jpg"),
                new GalleryItem("Dining light", "Concept study of a linear LED pendant and cove light over a dining table.", "Lighting", "/images/dining.jpg"),
                new GalleryItem("Gate camera", "Concept study of a camera under the eave, aimed at the approach to the house.", "Security", "/images/cctv.jpg"),
                new GalleryItem("Living room", "Concept study of cove lighting in a living room after dark.", "Lighting", "/images/living.jpg"),
                new GalleryItem("Rooftop solar", "Concept study of a solar array on a tiled roof, with hills behind it.", "Power", "/images/solar.jpg"),
                new GalleryItem("Water line", "Concept study of a purifier and pump, piped and left accessible.", "Water", "/images/water.jpg"),
                new GalleryItem("Bedroom shades", "Concept study of full-height curtains for a room that takes the morning sun.", "Comfort", "/images/shades.jpg"),
                new GalleryItem("Inverter wall", "Concept study of an inverter and cabinet with the cables dressed.", "Power", "/images/inverter.jpg"),
                new GalleryItem("Wall panel", "Concept study of a wall panel and a phone in the passage.", "Control", "/images/panel.jpg"));

        var interestList = new ArrayList<String>();
        services.forEach(service -> interestList.add(service.name()));
        interestList.add("A whole-home plan");
        interestList.add("Not sure yet");
        interests = List.copyOf(interestList);

        pins = List.of(
                new Pin("01", "Lights"),
                new Pin("02", "Shades"),
                new Pin("03", "Security panel"),
                new Pin("04", "Image sensor"),
                new Pin("05", "Thermostats"),
                new Pin("06", "Activity sensors"),
                new Pin("07", "Water valve"),
                new Pin("08", "Solar panels"),
                new Pin("09", "Video cameras"),
                new Pin("10", "Pet tracker"),
                new Pin("11", "Garage door"),
                new Pin("12", "Door locks"));

        steps = List.of(
                new Step("01", "Listen", "Rooms, routines, and what should stay manual. A plan or a few photos are enough to start."),
                new Step("02", "Draw", "Scenes, circuits, and the utility corner. You see what is in the job before the walls close."),
                new Step("03", "Install", "Electrical, plumbing, and the automation together, so one trade is not undoing another."),
                new Step("04", "Hand over", "Every scene demonstrated. Labels in the utility room. A number to call when something needs a change."));

        scenes = List.of(
                new Scene("Goodnight", "Hall dims, bedrooms settle, the main door locks, the porch stays lit."),
                new Scene("Away", "Chosen lights off, locks on, cameras live, the pump left to its own logic."),
                new Scene("Arrive", "Passage and living room to an evening level. The video door is a glance, not a hunt."),
                new Scene("Tank full", "The pump stops. If the sump is dry, it does not keep trying."));
    }

    public Company getCompany() {
        return company;
    }

    public List<Offering> getServices() {
        return services;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public List<GalleryItem> getGallery() {
        return gallery;
    }

    public List<String> getInterests() {
        return interests;
    }

    public List<String> getGalleryCategories() {
        return gallery.stream().map(GalleryItem::category).distinct().toList();
    }

    public List<Pin> getPins() {
        return pins;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public record Phone(String display, String tel) {}

    public record Studio(String name, String lines, String mapUrl) {}

    public record Company(
            String name,
            String tagline,
            String descriptor,
            String email,
            String websiteLabel,
            String websiteUrl,
            List<Phone> phones,
            List<Studio> studios) {}

    public record Offering(String slug, String name, String summary) {}

    public record Solution(String id, String name, String kicker, String summary, List<String> includes) {}

    public record Pattern(String title, String place, String summary, String image, String imageAlt, List<String> points) {}

    public record GalleryItem(String title, String caption, String category, String image) {}

    public record Pin(String number, String label) {}

    public record Step(String number, String title, String summary) {}

    public record Scene(String name, String summary) {}
}
