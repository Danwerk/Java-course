package inheritance.analyser;

import java.util.List;

public final class FlatTaxSalesAnalyser extends AbstractTaxSalesAnalyser {

    public FlatTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double taxRate() {
        return 0.2;
    }

    @Override
    protected Double exceptionTaxRate() {
        return 0.2;
    }


}
