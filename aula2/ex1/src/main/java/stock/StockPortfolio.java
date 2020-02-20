package stock;

import java.util.ArrayList;
import java.util.List;

public class StockPortfolio {

    private String name;
    private List<Stock> stocks;
    private ITStockMarket market_service;

    public StockPortfolio(String name) {
        this.name = name;
        this.stocks = new ArrayList<Stock>();
    }

    public ITStockMarket getMarket_service() {
        return market_service;
    }

    public void setMarket_service(ITStockMarket market_service) {
        this.market_service = market_service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalValue() {
        double total = 0;
        for (int i = 0; i < this.stocks.size(); i++)
            total += this.market_service.getPrice(this.stocks.get(i).getName());
        return total;
    }

    public void addStock(Stock new_stock) {
        this.stocks.add(new_stock);
    }
}
