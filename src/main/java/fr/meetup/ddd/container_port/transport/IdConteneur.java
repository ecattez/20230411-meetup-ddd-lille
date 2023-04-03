package fr.meetup.ddd.container_port.transport;

public record IdConteneur(String value) {

    public static IdConteneur of(String value) {
        return new IdConteneur(value);
    }

}
