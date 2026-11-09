# Marshall Tech

Company site for Marshall Tech: custom home automation, lighting, security, water, and power. Studios in Rathinapuri, Coimbatore and Grace Hill, Coonoor.

Spring Boot 4.1, Thymeleaf, and an H2 database for contact notes. Java 21 or newer.

## Pages

| Page | Path |
| --- | --- |
| Home | `/` |
| About | `/about` |
| Projects & Solutions | `/projects` |
| Gallery | `/gallery` |
| Contact | `/contact` |

## Run

From this folder:

```powershell
.\mvnw.cmd spring-boot:run
```

Then open http://localhost:8080

If `java` is not on your PATH, set `JAVA_HOME` to a JDK 21 or newer. The IntelliJ runtime on this PC is enough:

```powershell
$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2026.3\jbr"
$env:Path = "$env:JAVA_HOME\bin;" + $env:Path
.\mvnw.cmd spring-boot:run
```

`scripts\run.ps1` does the same thing when that JDK is installed.

## Contact notes

The contact form checks the fields and stores each note in `data/marshalltech.mv.db`. That folder is created on first submit and is not part of the source.

The H2 console is off. To look at notes on your own machine, set `spring.h2.console.enabled=true` in `src/main/resources/application.properties`, restart, and open http://localhost:8080/h2

- JDBC URL: `jdbc:h2:file:./data/marshalltech`
- User: `sa`
- Password: empty

Turn the console off again before the site is reachable from the network.

## Photographs and copy

The photographs are concept studies of the kind of house the studio designs. Each one is captioned that way. They are not pictures of a named client project. Replace the files in `src/main/resources/static/images` when real project photos are ready, and keep the names, or change the paths in `SiteCatalog`.

Names, phones, email, `marshallin.in`, both addresses, the ISO 9001:2015 line, and the service list come from the Marshall Tech card and service sheet. Project patterns describe ways of working. They are not a list of completed jobs.
