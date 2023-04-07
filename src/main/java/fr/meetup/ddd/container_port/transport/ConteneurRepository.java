package fr.meetup.ddd.container_port.transport;

import java.util.Optional;

public interface ConteneurRepository {

    Optional<Conteneur> fromId(IdConteneur idConteneur);

    void save(Conteneur conteneur);
}
