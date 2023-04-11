package fr.meetup.ddd.container_port.transport;

import java.util.Optional;

// Repo
public interface ConteneurRepository {
    Optional<Conteneur> findById(IdConteneur idConteneur);
}
