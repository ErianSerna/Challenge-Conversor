public class Moneda {
    private double conversionResult;
    private double conversionRate;

    public Moneda(double conversionResult, double conversionRate) {
        this.conversionResult = conversionResult;
        this.conversionRate = conversionRate;
    }

    public Moneda(Conversion conv) {
        this.conversionResult = conv.conversion_result();
        this.conversionRate = conv.conversion_rate();
    }


    public double getConversionResult() {
        return conversionResult;
    }

    public double getConversionRate() {
        return conversionRate;
    }
}
