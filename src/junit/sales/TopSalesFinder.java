package junit.sales;

import java.util.Arrays;


public class TopSalesFinder {

    SalesRecord record;
    SalesRecord[] records = new SalesRecord[0];


    public void registerSale(SalesRecord record) {
        this.record = record;
        addRecordToRecords(record);
        // store sales record for later analyses by findItemsSoldOver()
    }


    public String[] findItemsSoldOver(int amount) {
        String[] items = new String[0];

        for (SalesRecord salesRecord : records) {
            if (getTotalItemSales(records, salesRecord) > amount && !isStringAlreadyInArray(items, salesRecord.getProductId())){
                items = addItemStringToArray(items, salesRecord.getProductId());
            }
        }
        return items;
    }


    private boolean isStringAlreadyInArray(String[] items, String productId) {
        for (String item : items) {
            if (item.equals(productId)) {
                return true;
            }
        }
        return false;
    }


    private int getTotalItemSales(SalesRecord[] SalesRecords, SalesRecord record) {
        int total = 0;
        for (SalesRecord salesRecord : SalesRecords) {
            if (salesRecord.getProductId().equals(record.getProductId())){
                total += salesRecord.getProductPrice() * salesRecord.getItemsSold();
            }
        }
        return total;
    }


    private static String[] addItemStringToArray(String[] items, String item) {  //[a1,a2,a3]  lisan a4, saan [a1,a2,a3,a4]
        String[] increasedArray = new String[items.length + 1];
        //copy all elements from items Array to increasedArray:
        for (int i = 0; i < items.length; i++) {
            increasedArray[i] = items[i];
        }
        //place item in the end of the increasedArray:
        if (increasedArray.length == 1) {
            increasedArray[0] = item;
        }
        else {
            increasedArray[increasedArray.length - 1] = item;
        }
        return increasedArray;
    }


    private void addRecordToRecords(SalesRecord record) {
        SalesRecord[] increasedArray = new SalesRecord[records.length + 1];
        //copy all elements from items Array to increasedArray:
        for (int i = 0; i < records.length; i++) {
            increasedArray[i] = records[i];
        }
        //place item in the end of the increasedArray:
        if (increasedArray.length == 1) {
            increasedArray[0] = record;
        }
        else {
            increasedArray[increasedArray.length - 1] = record;
        }
        records = increasedArray;
    }


    @Override
    public String toString() {
        return "TopSalesFinder{" +
                "record=" + record +
                ", records=" + Arrays.toString(records) +
                '}';
    }
}


