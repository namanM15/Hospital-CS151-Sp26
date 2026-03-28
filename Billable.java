public interface Billable {
    void addCharge(double amount) throws InvalidAmountException, InvalidOperationException;
    void applyDiscount(double percent) throws InvalidAmountException;
    void payBill() throws InvalidOperationException;
    boolean hasBalance();
}