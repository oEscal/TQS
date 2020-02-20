package stock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;


// SEMPRE QUE SE USA MOCKITO
@ExtendWith(MockitoExtension.class)
class StockPortfolioTest {

    // quando se usam mocks não é necessário inicializar nada, isso é feito automáticamente

    @InjectMocks
    private StockPortfolio portfolio;         // SuT

    @Mock
    private ITStockMarket market;

    @Test
    void test1() {
        portfolio.setMarket_service(market);

        // isto é dizer ao mock como se deve comportar
        when(market.getPrice("EBAY")).thenReturn(6.0);
        when(market.getPrice("MSFT")).thenReturn(7.0);

        portfolio.addStock(new Stock("EBAY", 2));
        portfolio.addStock(new Stock("MSFT", 4));

        double result = portfolio.getTotalValue();


        assertThat(result, equalTo(13.0));
    }
}