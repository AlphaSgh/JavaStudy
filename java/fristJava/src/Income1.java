abstract class Income1 {
    protected double income;
    public Income1(double income) {
        this.income = income;
    }
    public abstract double getTax();
}
class otherIncome extends Income1 {
    public otherIncome(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return this.income * 0.1;
    }
}
class Salary1 extends Income1{
    public Salary1(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (this.income < 5000) {
            return 0;
        }
        return (this.income - 5000) * 0.2;
    }
}
class StateSalary extends Income1 {
    public StateSalary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}