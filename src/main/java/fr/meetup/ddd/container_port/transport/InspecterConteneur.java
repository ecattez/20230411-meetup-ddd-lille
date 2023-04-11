package fr.meetup.ddd.container_port.transport;

public class InspecterConteneur {

    private final ConteneurRepository conteneurRepository;
    private final ServiceDInspection serviceDInspection;
    private final IdConteneur idConteneur;

    public InspecterConteneur(ConteneurRepository conteneurRepository, ServiceDInspection serviceDInspection, IdConteneur idConteneur) {
        this.conteneurRepository = conteneurRepository;
        this.serviceDInspection = serviceDInspection;
        this.idConteneur = idConteneur;
    }

    public void execute() {
        conteneurRepository.findById(idConteneur)
                .ifPresent(serviceDInspection::inspecter);
    }
}
