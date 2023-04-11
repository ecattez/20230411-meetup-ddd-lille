package fr.meetup.ddd.container_port.transport.inspection;

import fr.meetup.ddd.container_port.transport.EventPublisher;
import fr.meetup.ddd.container_port.transport.quai.ConteneurDéposé;

public final class DemanderInspection {

    private final InspectionDemandeur inspectionDemandeur;

    public DemanderInspection(EventPublisher eventPublisher, InspectionDemandeur inspectionDemandeur) {
        this.inspectionDemandeur = inspectionDemandeur;

        eventPublisher.souscrireA(ConteneurDéposé.class, this::execute);
    }

    public void execute(ConteneurDéposé conteneurDéposé) {
        inspectionDemandeur.demanderInspection(conteneurDéposé.idConteneur(), conteneurDéposé.idQuai());
    }
}
