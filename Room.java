public class Room {
    private static int roomCount = 0;
    public static final int MAX_ROOMS = 100;

    private int roomNumber;
    private boolean isOccupied;
    private String type;
    private boolean underMaintenance;
    private Patient assignedPatient;

    public Room(int roomNumber, String type) {
        if (roomCount >= MAX_ROOMS) {
            System.out.println("Cannot create more than 100 rooms.");
            this.roomNumber = -1;
            this.type = "Invalid";
            this.isOccupied = false;
            this.underMaintenance = false;
            this.assignedPatient = null;
            return;
        }

        roomCount++;

        if (roomNumber <= 0) {
            System.out.println("Invalid room number. Setting default room number to 1.");
            this.roomNumber = 1;
        } else {
            this.roomNumber = roomNumber;
        }

        if (type == null || type.trim().isEmpty()) {
            System.out.println("Invalid room type. Setting type to General.");
            this.type = "General";
        } else {
            this.type = type;
        }

        this.isOccupied = false;
        this.underMaintenance = false;
        this.assignedPatient = null;
    }

    public void assignPatient(Patient patient) {
        if (underMaintenance) {
            System.out.println("Room is under maintenance and cannot be assigned.");
        } else if (isOccupied) {
            System.out.println("Room already occupied.");
        } else if (patient == null) {
            System.out.println("Cannot assign a null patient.");
        } else {
            assignedPatient = patient;
            isOccupied = true;
            System.out.println("Patient assigned to room " + roomNumber + ".");
        }
    }

    public void vacateRoom() {
        if (!isOccupied) {
            System.out.println("Room is already empty.");
        } else {
            assignedPatient = null;
            isOccupied = false;
            System.out.println("Room is now empty.");
        }
    }

    public void transferPatient(Room newRoom) {
        if (assignedPatient == null) {
            System.out.println("No patient to transfer.");
        } else if (newRoom == null) {
            System.out.println("Target room does not exist.");
        } else if (!newRoom.isAvailable()) {
            System.out.println("Target room is not available.");
        } else {
            newRoom.assignPatient(assignedPatient);
            assignedPatient = null;
            isOccupied = false;
            System.out.println("Patient transferred to room " + newRoom.getRoomNumber() + ".");
        }
    }

    public void markUnderMaintenance() {
        if (isOccupied) {
            System.out.println("Cannot put occupied room under maintenance.");
        } else {
            underMaintenance = true;
            System.out.println("Room " + roomNumber + " is now under maintenance.");
        }
    }

    public void releaseMaintenance() {
        underMaintenance = false;
        System.out.println("Room " + roomNumber + " is now available.");
    }

    public boolean isAvailable() {
        return !isOccupied && !underMaintenance;
    }

    public boolean hasPatient() {
        return assignedPatient != null;
    }

    public void changeRoomType(String newType) {
        if (newType == null || newType.trim().isEmpty()) {
            System.out.println("Invalid room type.");
        } else if (isOccupied) {
            System.out.println("Cannot change type while room is occupied.");
        } else {
            type = newType;
            System.out.println("Room type updated successfully.");
        }
    }

    public void displayRoomInfo() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Type: " + type);
        System.out.println("Occupied: " + isOccupied);
        System.out.println("Under Maintenance: " + underMaintenance);

        if (assignedPatient != null) {
            System.out.println("Assigned Patient: " + assignedPatient.getName());
        } else {
            System.out.println("Assigned Patient: None");
        }
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getType() {
        return type;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    public Patient getAssignedPatient() {
        return assignedPatient;
    }

    public static int getRoomCount() {
        return roomCount;
    }

    public void setRoomNumber(int roomNumber) {
        if (roomNumber > 0) {
            this.roomNumber = roomNumber;
        } else {
            System.out.println("Invalid room number.");
        }
    }

    public void setType(String type) {
        if (type != null && !type.trim().isEmpty()) {
            this.type = type;
        } else {
            System.out.println("Invalid room type.");
        }
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setUnderMaintenance(boolean underMaintenance) {
        this.underMaintenance = underMaintenance;
    }

    @Override
    public String toString() {
        String patientName = "None";
        if (assignedPatient != null) {
            patientName = assignedPatient.getName();
        }

        return "Room Number: " + roomNumber
                + ", Type: " + type
                + ", Occupied: " + isOccupied
                + ", Under Maintenance: " + underMaintenance
                + ", Assigned Patient: " + patientName;
    }
}