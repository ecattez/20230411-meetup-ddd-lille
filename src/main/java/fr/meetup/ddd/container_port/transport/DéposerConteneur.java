package fr.meetup.ddd.container_port.transport;

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
                    eventPublisher.publish(conteneurDéposé);
                });
    }
}
