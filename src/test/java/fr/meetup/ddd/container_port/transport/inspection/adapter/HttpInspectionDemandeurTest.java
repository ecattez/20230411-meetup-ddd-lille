package fr.meetup.ddd.container_port.transport.inspection.adapter;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.noContent;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static fr.meetup.ddd.container_port.transport.TransportFixtures.ID_CONTENEUR;
import static fr.meetup.ddd.container_port.transport.TransportFixtures.ID_QUAI;

@WireMockTest(httpPort = 8083)
@ExtendWith(MockitoExtension.class)
class HttpInspectionDemandeurTest {

    @Spy
    InspectionHttpClient inspectionHttpClient = InspectionHttpClient.baseUrl("http://localhost:8083");

    @InjectMocks
    HttpInspectionDemandeur httpInspectionDemandeur;

    @Test
    void deleguer_inspection_a_la_solution_saas() {
        stubFor(post("/inspections").willReturn(noContent()));

        httpInspectionDemandeur.demanderInspection(ID_CONTENEUR, ID_QUAI);

        verify(postRequestedFor(urlEqualTo("/inspections"))
                .withRequestBody(equalToJson("""
                        {
                        "port_id": "PORT_ABCD",
                        "port_contact_email": "transport@port-de-dunkerque.com",
                        "container_number": "C001",
                        "dock_number": "Q001"
                        }
                        """)));
    }
}