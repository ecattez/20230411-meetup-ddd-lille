package fr.meetup.ddd.container_port.transport;

public class Service {
    public ConteneurDéposé déposerUnConteneur(IdConteneur idConteneur, NumeroQuai numeroQuai) {
        return new ConteneurDéposé(idConteneur, numeroQuai);
    }
}
