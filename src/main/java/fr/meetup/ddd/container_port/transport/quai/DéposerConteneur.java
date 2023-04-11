package fr.meetup.ddd.container_port.transport.quai;

import fr.meetup.ddd.container_port.transport.ConteneurRepository;
import fr.meetup.ddd.container_port.transport.EventPublisher;
import fr.meetup.ddd.container_port.transport.IdConteneur;
import fr.meetup.ddd.container_port.transport.IdQuai;

public final class DéposerConteneur {

    private final ConteneurRepository conteneurRepository;
    private final EventPublisher eventPublisher;

    public DéposerConteneur(ConteneurRepository conteneurRepository, EventPublisher eventPublisher) {
        this.conteneurRepository = conteneurRepository;
        this.eventPublisher = eventPublisher;
    }

    public void execute(IdConteneur idConteneur, IdQuai idQuai) {
        conteneurRepository.fromId(idConteneur)
                .ifPresent(conteneur -> {
                    ConteneurDéposé conteneurDéposé = conteneur.déposerConteneur(idQuai);
                    conteneurRepository.save(conteneur);
                    eventPublisher.publier(conteneurDéposé);
                });
    }
}
