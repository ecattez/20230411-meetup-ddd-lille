package fr.meetup.ddd.container_port.transport;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConteneurTest {

    @Test
    void déposer_un_conteneur_sur_un_quai() {
        // given
        IdConteneur idConteneur = IdConteneur.of("C001");
        Conteneur conteneur = new Conteneur(idConteneur);

        // when
        IdQuai idQuai = IdQuai.of("Q001");
        ConteneurDéposé actualEvent = conteneur.déposerConteneur(idQuai);

        // then
        assertThat(conteneur.déposéSur()).contains(idQuai);
        assertThat(actualEvent.idConteneur()).isEqualTo(idConteneur);
        assertThat(actualEvent.idQuai()).isEqualTo(idQuai);
    }

}