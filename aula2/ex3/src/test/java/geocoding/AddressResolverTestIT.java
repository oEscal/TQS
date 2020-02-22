package geocoding;

import org.apache.http.client.utils.URIBuilder;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AddressResolverTestIT {

    AddressResolver addressResolver;

    @Test
    void testFindAddressForLocation() throws URISyntaxException, IOException, ParseException {

        Address returned_address = addressResolver.findAddressForLocation(40.6318, -8.658);

        Address expected_address = new Address(
                null,
                "Parque Estacionamento da Reitoria - Univerisdade de Aveiro",
                "Glória e Vera Cruz",
                "Centro",
                "3810-193"
        );

        assertThat(returned_address, is(expected_address));
    }

    @Test
    void testValidCoordinates() throws URISyntaxException, IOException, ParseException {
        Assertions.assertThrows(NoSuchFieldError.class, () -> addressResolver.findAddressForLocation(10, 10));
    }
}