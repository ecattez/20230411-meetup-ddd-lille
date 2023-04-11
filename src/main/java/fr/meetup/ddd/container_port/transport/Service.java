package fr.meetup.ddd.container_port.transport;

public class Service {

    private final ConteneurRepository conteneurRepository;

    public Service(ConteneurRepository conteneurRepository) {
        this.conteneurRepository = conteneurRepository;
    }

    public Object déposerUnConteneur(DéposerConteneur commande) {
        return conteneurRepository.findById(commande.idConteneur())
                .<Object>map(conteneur -> new ConteneurDéposé(commande.idConteneur(), commande.numeroQuai()))
                .orElse(new ConteneurNaPasEteTrouvé(commande.idConteneur()));
    }
}
