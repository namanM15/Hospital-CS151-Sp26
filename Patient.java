public class Patient extends Person {
    private String medicalHistory;
    private boolean admitted;

    public void admitPatient() {
        admitted = true;
        System.out.println(getName() + " has been admitted.");
    }

    public void dischargePatient() {
        admitted = false;
        System.out.println(getName() + " has been discharged.");
    }

    public void updateMedicalHistory(String history) {
        if (history != null && !history.isEmpty()) {
            medicalHistory = history;
        }
    }

    public void viewPatientStatus() {
        System.out.println("Patient: " + getName());
        System.out.println("Admitted: " + admitted);
        System.out.println("Medical History: " + medicalHistory);
    }
}
