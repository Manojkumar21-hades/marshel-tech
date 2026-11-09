$jdk = "C:\Program Files\JetBrains\IntelliJ IDEA 2026.3\jbr"
if (-not $env:JAVA_HOME -and (Test-Path "$jdk\bin\java.exe")) {
    $env:JAVA_HOME = $jdk
}
if ($env:JAVA_HOME) {
    $env:Path = "$env:JAVA_HOME\bin;" + $env:Path
}

Set-Location (Split-Path $PSScriptRoot -Parent)
& .\mvnw.cmd spring-boot:run
