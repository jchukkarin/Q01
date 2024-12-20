import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input information for the bill
        System.out.println("===== ระบบเก็บบิลค่าน้ำ ค่าไฟ ค่าห้องพัก =====");

        // Input for water meter readings
        System.out.print("กรุณากรอกการอ่านมิเตอร์น้ำครั้งก่อน: ");
        double lastWaterMeter = scanner.nextDouble();
        System.out.print("กรุณากรอกการอ่านมิเตอร์น้ำปัจจุบัน: ");
        double currentWaterMeter = scanner.nextDouble();

        // Check if the current water meter reading is less than the last
        if (currentWaterMeter < lastWaterMeter) {
            System.out.println("ข้อผิดพลาด: การอ่านมิเตอร์น้ำปัจจุบันต้องมากกว่าหรือเท่ากับการอ่านมิเตอร์น้ำครั้งก่อน");
            return; // Exit the program if the reading is incorrect
        }

        // Input for electricity meter readings
        System.out.print("กรุณากรอกการอ่านมิเตอร์ไฟฟ้าครั้งก่อน: ");
        double lastElectricityMeter = scanner.nextDouble();
        System.out.print("กรุณากรอกการอ่านมิเตอร์ไฟฟ้าปัจจุบัน: ");
        double currentElectricityMeter = scanner.nextDouble();

  
        if (currentElectricityMeter < lastElectricityMeter) {
            System.out.println("ข้อผิดพลาด: การอ่านมิเตอร์ไฟฟ้าปัจจุบันต้องมากกว่าหรือเท่ากับการอ่านมิเตอร์ไฟฟ้าครั้งก่อน");
            return; 
        }

        System.out.println("กรุณาเลือกประเภทห้องพัก:");
        System.out.println("1. Single Bed");
        System.out.println("2. Double Bed");
        int roomTypeChoice = scanner.nextInt();
        double roomRent = 0;

        // Determine room rent based on user choice
        if (roomTypeChoice == 1) {
            roomRent = 1500;  // Single Bed
        } else if (roomTypeChoice == 2) {
            roomRent = 2000;  // Double Bed
        } else {
            System.out.println("ข้อผิดพลาด: กรุณาเลือกประเภทห้องพักที่ถูกต้อง");
            return; // Exit the program if an invalid choice is made
        }

        // Calculate water and electricity bills based on usage
        double waterUsage = currentWaterMeter - lastWaterMeter;
        double electricityUsage = currentElectricityMeter - lastElectricityMeter;

        // Calculate the bills with the provided rates
        double waterBill = waterUsage * 5.0; // Rate for water: 5 บาท per unit
        double electricityBill = electricityUsage * 6.0; // Rate for electricity: 6 บาท per unit

        // Create Bill object
        Bill bill = new Bill(waterBill, electricityBill, roomRent);

        // Display the total bill
        System.out.println("\n===== บิลทั้งหมด =====");
        System.out.println("ค่าน้ำ: " + bill.getWaterBill() + " บาท");
        System.out.println("ค่าไฟ: " + bill.getElectricityBill() + " บาท");
        System.out.println("ค่าห้องพัก: " + bill.getRoomRent() + " บาท");
        System.out.println("รวมทั้งหมด: " + bill.getTotalBill() + " บาท");

        scanner.close();
    }
}

class Bill {
    private double waterBill;
    private double electricityBill;
    private double roomRent;

    // Constructor
    public Bill(double waterBill, double electricityBill, double roomRent) {
        this.waterBill = waterBill;
        this.electricityBill = electricityBill;
        this.roomRent = roomRent;
    }

    // Methods to get the bills
    public double getWaterBill() {
        return waterBill;
    }

    public double getElectricityBill() {
        return electricityBill;
    }

    public double getRoomRent() {
        return roomRent;
    }

    // Method to calculate total bill
    public double getTotalBill() {
        return waterBill + electricityBill + roomRent;
    }
}