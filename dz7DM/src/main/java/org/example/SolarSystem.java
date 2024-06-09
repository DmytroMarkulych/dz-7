package org.example;

public enum SolarSystem {
    MERCURY(0, 2439, null),
    VENUS(50, 6052, MERCURY),
    EARTH(41, 6371, VENUS),
    MARS(78, 3390, EARTH),
    JUPITER(550, 71492, MARS),
    SATURN(650, 60268, JUPITER),
    URANUS(1447, 25559, SATURN),
    NEPTUNE(1620, 24764, URANUS);

    private final int number;
    private final int distanceFromPreviousPlanet;
    private final int distanceFromSun;
    private final int radius;
    private final SolarSystem previousPlanet;
    private SolarSystem nextPlanet;

    SolarSystem(int distanceFromPreviousPlanet, int radius, SolarSystem previousPlanet) {
        this.number = ordinal() + 1;
        this.distanceFromPreviousPlanet = distanceFromPreviousPlanet;
        this.distanceFromSun = (previousPlanet == null) ? distanceFromPreviousPlanet : previousPlanet.getDistanceFromSun() + distanceFromPreviousPlanet;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
        if (previousPlanet != null) {
            previousPlanet.nextPlanet = this;
        }
        this.nextPlanet = null;
    }

    public int getNumber() {
        return number;
    }

    public int getDistanceFromPreviousPlanet() {
        return distanceFromPreviousPlanet;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRadius() {
        return radius;
    }

    public SolarSystem getPreviousPlanet() {
        return previousPlanet;
    }

    public SolarSystem getNextPlanet() {
        return nextPlanet;
    }

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
