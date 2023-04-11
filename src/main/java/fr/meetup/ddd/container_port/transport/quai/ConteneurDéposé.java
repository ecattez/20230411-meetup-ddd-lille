package fr.meetup.ddd.container_port.transport.quai;

import fr.meetup.ddd.container_port.transport.IdConteneur;
import fr.meetup.ddd.container_port.transport.IdQuai;

public record ConteneurDéposé(IdConteneur idConteneur, IdQuai idQuai) {

    public static ConteneurDéposé of(IdConteneur idConteneur, IdQuai idQuai) {
        return new ConteneurDéposé(idConteneur, idQuai);
    }

}
