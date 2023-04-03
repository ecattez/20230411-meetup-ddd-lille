package fr.meetup.ddd.container_port.transport;

public record IdQuai(String value) {

    public static IdQuai of(String value) {
        return new IdQuai(value);
    }
}
