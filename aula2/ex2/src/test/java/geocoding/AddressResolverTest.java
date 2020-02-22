package geocoding;

import org.apache.http.client.utils.URIBuilder;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Formatter;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @InjectMocks
    AddressResolver addressResolver;

    @Mock
    TqsHttpClient tqsHttpClient;

    @Test
    void testFindAddressForLocation() throws URISyntaxException, IOException, ParseException {

        when(tqsHttpClient.get(createLinkString(10, 10))).thenReturn("{\n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"providedLocation\": {\n" +
                "                \"latLng\": {\n" +
                "                    \"lat\": 10,\n" +
                "                    \"lng\": 10\n" +
                "                }\n" +
                "            },\n" +
                "            \"locations\": [\n" +
                "                {\n" +
                "                    \"street\": \"Parque Estacionamento da Reitoria - Univerisdade de Aveiro\",\n" +
                "                    \"adminArea5\": \"Glória e Vera Cruz\",\n" +
                "                    \"adminArea3\": \"Centro\",\n" +
                "                    \"postalCode\": \"3810-193\",\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}");

        Address returned_address = addressResolver.findAddressForLocation(10, 10);

        Address expected_address = new Address(
                null,
                "Parque Estacionamento da Reitoria - Univerisdade de Aveiro",
                "Glória e Vera Cruz",
                "Centro",
                "3810-193"
        );

        assertThat(returned_address, is(expected_address));
    }

    void testValidCoordinates() {

    }

    private static String createLinkString(double lat, double lnt) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder("http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", (new Formatter()).format(Locale.US, "%.6f,%.6f", lat, lnt).toString() );
        uriBuilder.addParameter("includeRoadMetadata", "true" );
        return uriBuilder.build().toString();
    }
}