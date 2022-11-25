public class Income {
    protected double incom;
    public Income(double incom) {
        this.incom = incom;
    }
    public double getTax() {
        return incom * 0.1;
    }
}
class Salary extends Income {
    public Salary(double incom) {
        super(incom);
    }
    @Override
    public double getTax() {
        if (incom <= 5000) {
            return 0;
        }
        return (incom - 5000) * 0.2;
    }
}
class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }
    @Override
    public double getTax() {
        return 0;
    }
}
