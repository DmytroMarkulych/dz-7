package org.example;

public class Main {
    public static void main(String[] args) {
        for (SolarSystem planet : SolarSystem.values()) {
            System.out.printf(
                    "Planet: %s%nNumber: %d%nDistance from previous planet: %d million km%nDistance from Sun: %d million km%nRadius: %d km%nPrevious planet: %s%nNext planet: %s%n%n",
                    planet, planet.getNumber(), planet.getDistanceFromPreviousPlanet(),
                    planet.getDistanceFromSun(), planet.getRadius(),
                    (planet.getPreviousPlanet() == null) ? "None" : planet.getPreviousPlanet().name(),
                    (planet.getNextPlanet() == null) ? "None" : planet.getNextPlanet().name()
            );
        }
    }
}