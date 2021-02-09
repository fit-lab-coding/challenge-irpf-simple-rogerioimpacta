package fit.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IrpfCalculator {
    private static Double exemptionValueExpected = 1903.98;

    public static Double calculateBaseSalary(double totalSalary) {
        var tax = totalSalary * 0.11;
        var baseSalary = totalSalary - tax;

        return baseSalary;
    }

    public static Double calculateExemption() {
        return exemptionValueExpected;
    }

    public static Double calculateDiscount(double baseSalary) {
        return (baseSalary - exemptionValueExpected);
    }

    public static Double calculateTaxLayer(double baseSalary) {
        if (baseSalary > exemptionValueExpected && baseSalary <= 2826.65) return 0.075;

        return 0.0;
    }

    public static double calculateIrpf(double totalSalary) {
        var salaryBase = calculateBaseSalary(totalSalary);

        var discountedValue = (salaryBase - exemptionValueExpected);

        Double result = (discountedValue * calculateTaxLayer(salaryBase));

        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }
}