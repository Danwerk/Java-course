package inheritance.analyser;

import java.util.List;

abstract sealed class AbstractTaxSalesAnalyser permits DifferentiatedTaxSalesAnalyser, FlatTaxSalesAnalyser, TaxFreeSalesAnalyser {
    List<SalesRecord> salesRecords;
    abstract Double taxRate();  // tavaline tax rate ehk 20%
    abstract Double exceptionTaxRate();  // special tax rate ehk 10%

    public AbstractTaxSalesAnalyser(List<SalesRecord> records) {  // konstruktor
        this.salesRecords = records;
    }


    protected Double getTotalSales() {
        double result = 0.0;
        for (SalesRecord salesRecord : salesRecords) {
            result += salesRecord.getItemsSold() * itemPrice(salesRecord);
        }
        return result;
    }

    protected Double getTotalSalesByProductId(String id) {
        double result = 0.0;
        for (SalesRecord salesRecord : salesRecords) {
            if (salesRecord.getProductId().equals(id)) {
                result += itemPrice(salesRecord) * salesRecord.getItemsSold();
            }
        }
        return result;
    }

    protected String getIdOfMostPopularItem() {
        int maxRate = 0;
        String topItem = "";
        for (SalesRecord salesRecord : salesRecords) {
            if (salesRecord.getItemsSold() > maxRate) {
                maxRate = salesRecord.getItemsSold();
                topItem = salesRecord.getProductId();
            }
        }
        return topItem;
    }

    protected String getIdOfItemWithLargestTotalSales() {  //tagastab produkti id millest on saadud kõige suuremat tulu.
        Double largestSale = 0.0;
        String topItem = "";
        for (SalesRecord salesRecord : salesRecords) {
            if (getTotalSalesByProductId(salesRecord.getProductId()) > largestSale) {
                largestSale = getTotalSalesByProductId(salesRecord.getProductId());
                topItem = salesRecord.getProductId();
            }
        }
        return topItem;
    }

    protected Double itemPrice(SalesRecord salesRecord) {
        if (!salesRecord.hasReducedRate()) {
            return salesRecord.getProductPrice() / (taxRate() + 1);
        }
        else {
            return salesRecord.getProductPrice() / (exceptionTaxRate() + 1);
        }

    }
}
