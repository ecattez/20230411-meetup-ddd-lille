package fr.meetup.ddd.container_port.transport;

public record ConteneurDéposé(IdConteneur idConteneur, IdQuai idQuai) {

    public static ConteneurDéposé of(IdConteneur idConteneur, IdQuai idQuai) {
        return new ConteneurDéposé(idConteneur, idQuai);
    }

}
