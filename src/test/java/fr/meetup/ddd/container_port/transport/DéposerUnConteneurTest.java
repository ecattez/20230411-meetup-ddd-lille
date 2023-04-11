package fr.meetup.ddd.container_port.transport;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DéposerUnConteneurTest {

    @Test
    void déposer_un_conteneur() {
        Service service = new Service();
        IdConteneur idConteneur = new IdConteneur("8");
        NumeroQuai numeroQuai = new NumeroQuai("12");
        ConteneurDéposé evenement = service.déposerUnConteneur(idConteneur, numeroQuai);

        assertThat(evenement.idConteneur().value()).isEqualTo("8");
        assertThat(evenement.numeroQuai().value()).isEqualTo("12");
    }
}
