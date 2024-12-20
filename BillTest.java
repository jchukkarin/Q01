import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BillTest {


    @Test
    public void testWaterBillCalculation() {
        double lastWaterMeter = 100;
        double currentWaterMeter = 150;
        double waterRate = 5.0; 

      
        double waterUsage = currentWaterMeter - lastWaterMeter;
        double expectedWaterBill = waterUsage * waterRate;

        Bill bill = new Bill(expectedWaterBill, 0, 0); // บิลที่คำนวณ
        assertEquals(expectedWaterBill, bill.getWaterBill(), "ค่าน้ำคำนวณผิดพลาด");
    }

    
    @Test
    public void testElectricityBillCalculation() {
        double lastElectricityMeter = 200;
        double currentElectricityMeter = 250;
        double electricityRate = 6.0; // ค่าไฟฟ้าหน่วยละ 6 บาท

        // คำนวณการใช้ไฟ
        double electricityUsage = currentElectricityMeter - lastElectricityMeter;
        double expectedElectricityBill = electricityUsage * electricityRate;

        Bill bill = new Bill(0, expectedElectricityBill, 0); // บิลที่คำนวณ
        assertEquals(expectedElectricityBill, bill.getElectricityBill(), "ค่าไฟฟ้าคำนวณผิดพลาด");
            }
        
            private void assertEquals(double expectedElectricityBill, double electricityBill, String string) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
            }
        
            // ทดสอบการคำนวณค่าห้องพัก
    @Test
    public void testRoomRentCalculation() {
        double expectedRoomRent = 1500; // ค่าห้องพักสำหรับ Single Bed

        Bill bill = new Bill(0, 0, expectedRoomRent); // บิลที่คำนวณ
        assertEquals(expectedRoomRent, bill.getRoomRent(), "ค่าห้องพักคำนวณผิดพลาด");
    }

    // ทดสอบการคำนวณบิลทั้งหมด
    @Test
    public void testTotalBillCalculation() {
        double waterBill = 250;
        double electricityBill = 300;
        double roomRent = 1500;

        Bill bill = new Bill(waterBill, electricityBill, roomRent);

        // คำนวณบิลรวม
        double expectedTotalBill = waterBill + electricityBill + roomRent;
        assertEquals(expectedTotalBill, bill.getTotalBill(), "การคำนวณบิลทั้งหมดผิดพลาด");
    }
}
