package inheritance.analyser;

import java.util.List;

public final class TaxFreeSalesAnalyser extends AbstractTaxSalesAnalyser {

    public TaxFreeSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double taxRate() {
        return 0.0;
    }

    @Override
    protected Double exceptionTaxRate() {
        return 0.0;
    }


}
