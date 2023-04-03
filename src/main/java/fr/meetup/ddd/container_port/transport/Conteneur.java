package fr.meetup.ddd.container_port.transport;

import java.util.Optional;

public class Conteneur {

    private final IdConteneur id;
    private IdQuai déposéSur;

    public Conteneur(IdConteneur id) {
        this.id = id;
    }

    public Optional<IdQuai> déposéSur() {
        return Optional.ofNullable(déposéSur);
    }

    public ConteneurDéposé déposerConteneur(IdQuai idQuai) {
        this.déposéSur = idQuai;

        return ConteneurDéposé.of(id, déposéSur);
    }


}
