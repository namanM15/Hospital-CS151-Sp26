public class Bill implements Billable {
    private static int billCount = 0;
    public static final int MAX_BILLS = 100;

    private int billId;
    private double amount;
    private boolean isPaid;
    private boolean isOverdue;

    public Bill(int billId, double amount) {
        if (billCount >= MAX_BILLS) {
            System.out.println("Cannot create more than 100 bills.");
            this.billId = -1;
            this.amount = 0;
            this.isPaid = false;
            this.isOverdue = false;
            return;
        }

        billCount++;

        if (billId <= 0) {
            System.out.println("Invalid bill ID. Setting default ID to 1.");
            this.billId = 1;
        } else {
            this.billId = billId;
        }

        if (amount < 0) {
            System.out.println("Invalid amount. Setting amount to 0.");
            this.amount = 0;
        } else {
            this.amount = amount;
        }

        this.isPaid = false;
        this.isOverdue = false;
    }

    public void payBill() {
        if (isPaid) {
            System.out.println("Bill is already fully paid.");
        } else {
            isPaid = true;
            amount = 0;
            System.out.println("Bill paid successfully.");
        }
    }

    public void addCharge(double extra) {
        if (extra <= 0) {
            System.out.println("Charge must be greater than 0.");
            return;
        }

        if (isPaid) {
            System.out.println("Cannot add charge to a fully paid bill.");
            return;
        }

        amount += extra;
        System.out.println("Charge added successfully.");
    }

    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Discount must be between 0 and 100.");
            return;
        }

        double discountAmount = amount * (percent / 100.0);
        amount -= discountAmount;

        if (amount < 0) {
            amount = 0;
        }

        if (amount == 0) {
            isPaid = true;
        }

        System.out.println("Discount applied. New balance: $" + amount);
    }

    public void markAsOverdue() {
        if (isPaid) {
            System.out.println("Paid bill cannot be marked overdue.");
        } else {
            isOverdue = true;
            System.out.println("Bill marked as overdue.");
        }
    }

    public boolean hasBalance() {
        return amount > 0;
    }

    public void clearOverdueStatus() {
        if (isPaid) {
            isOverdue = false;
            System.out.println("Overdue status cleared.");
        } else {
            System.out.println("Bill must be paid before clearing overdue status.");
        }
    }

    public void displayBill() {
        System.out.println("Bill ID: " + billId);
        System.out.println("Remaining Amount: $" + amount);
        System.out.println("Paid: " + isPaid);
        System.out.println("Overdue: " + isOverdue);
    }

    public int getBillId() {
        return billId;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public static int getBillCount() {
        return billCount;
    }

    public void setBillId(int billId) {
        if (billId > 0) {
            this.billId = billId;
        } else {
            System.out.println("Invalid bill ID.");
        }
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
            if (amount > 0) {
                isPaid = false;
            }
        } else {
            System.out.println("Amount cannot be negative.");
        }
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setOverdue(boolean overdue) {
        isOverdue = overdue;
    }

    @Override
    public String toString() {
        return "Bill ID: " + billId
                + ", Amount: $" + amount
                + ", Paid: " + isPaid
                + ", Overdue: " + isOverdue;
    }
}