public interface IncomeInterface {
    double getTax();
}
class salaryInter implements IncomeInterface {
    double salary;
    public salaryInter(double salary) {
        this.salary = salary;
    }

    @Override
    public double getTax() {
        if (this.salary < 5000) {
            return 0;
        }
        return (this.salary - 5000) * 0.2;
    }
}
class otherIncomeInter implements IncomeInterface {
    double otherIncome;
    public otherIncomeInter(double otherIncome) {
        this.otherIncome = otherIncome;
    }

    @Override
    public double getTax() {
        return this.otherIncome * 0.1;
    }
}
class noTax implements IncomeInterface {
    double noTaxIncome;
    public noTax(double noTaxIncome) {
        this.noTaxIncome = noTaxIncome;
    }

    @Override
    public double getTax() {
        return 0;
    }
}
