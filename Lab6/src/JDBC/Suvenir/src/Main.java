//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        QueryExecutor.getSouvenirsByManufacturer("ManufacturerName");
        QueryExecutor.getSouvenirsByCountry("CountryName");
        QueryExecutor.getManufacturersByPrice(100.00);
        QueryExecutor.getManufacturersBySouvenirAndYear("SouvenirName", 2022);

        DataModifier.deleteManufacturerAndSouvenirs(1);
    }
}