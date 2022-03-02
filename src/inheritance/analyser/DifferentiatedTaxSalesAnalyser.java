package inheritance.analyser;

import java.util.List;

public final class DifferentiatedTaxSalesAnalyser extends AbstractTaxSalesAnalyser {

    public DifferentiatedTaxSalesAnalyser(List<SalesRecord> records) {
        super(records);
    }

    @Override
    protected Double taxRate() {
        return 0.2;
    }

    @Override
    protected Double exceptionTaxRate() {
        return 0.1;
    }
}


