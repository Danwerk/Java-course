package poly.installments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstallmentGenerator {

    public List<Installment> generateRowsFor(
            Integer amount, LocalDate periodStart, LocalDate periodEnd) {
        List<Installment> result = new ArrayList<>();
        if (amount < 3) {
            Installment inst = new Installment(amount, periodStart);
            result.add(inst);
        }


        return result;
    }


    public int amountOfMonthsInGivenPeriod(String periodStart, String periodEnd) {
        List<String> startMonth = Arrays.asList(periodStart.split("-"));

        List<String> endMonth = Arrays.asList(periodEnd.split("-"));

        int result = Integer.parseInt(endMonth.get(1)) - Integer.parseInt(startMonth.get(1)) + 1;

        System.out.println(result);

        return result;
    }


    public List<String> datesInGivenPeriod(String periodStart, String periodEnd, int periods) {
        List<String> dates = new ArrayList<>();
        dates.add(periodStart);

        String year = Arrays.asList(periodStart.split("-")).get(0);
        String month = Arrays.asList(periodStart.split("-")).get(1);
        String day = String.format("%02d", 1);

        for (int i = 0; i < periods - 1; i++) {

            String date = "";

            month = String.format("%02d", Integer.parseInt(month) + 1);

            date = year + "-" + month + "-" + day;

            dates.add(date);
        }
        System.out.println(dates);

        return dates;
    }

    public int amountOfPayingPeriods(LocalDate periodStart, LocalDate periodEnd) {
        return 0;
    }

    public static void main(String[] args) {
        InstallmentGenerator ig = new InstallmentGenerator();
        ig.amountOfMonthsInGivenPeriod("2020-04-04", "2020-06-07");
        ig.datesInGivenPeriod("2020-04-04", "2020-06-07", 3); //2020-04-04, 2020-05-01, 2020-06-01
    }
}
