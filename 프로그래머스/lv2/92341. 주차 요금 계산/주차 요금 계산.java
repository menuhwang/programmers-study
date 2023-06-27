import java.util.*;

class Solution {
    public long[] solution(int[] fees, String[] records) {
        Parking parking = Parking.init(fees);
        parking.open(records);
        
        return parking.close();
    }
    
    static class Parking {
        private final int basicTime;
        private final int basicCharge;
        private final int unitTime;
        private final int unitCharge;
        
        private final Map<String, Car> cars;
        private final TreeMap<String, Integer> times;
        
        Parking(int[] fees) {
            this.cars = new HashMap<>();
            this.times = new TreeMap<>();
            
            this.basicTime = fees[0];
            this.basicCharge = fees[1];
            this.unitTime = fees[2];
            this.unitCharge = fees[3];
        }
        
        static Parking init(int[] fees) {
            return new Parking(fees);
        }
        
        void open(String[] records) {
            for (String recordStr : records) {
                Record record = new Record(recordStr);
                if (record.isIn()) {
                    Car car = Car.in(record);
                    in(car);
                    continue;
                }
                
                out(record);
            }
        }
        
        void in(Car car) {
            this.cars.put(car.getId(), car);
        }
        
        void out(Record record) {
            String carId = record.getCarId();
            int inTime = cars.get(carId).getInTime();
            int outTime = record.getTime();
            
            out(carId, inTime, outTime);
        }
        
        void out(String carId, int inTime, int outTime) {
            int duration = outTime - inTime;
            
            int prevDuration = times.getOrDefault(carId, 0);
            times.put(carId, prevDuration + duration);
            cars.remove(carId);
        }
        
        long calculate(int minutes) {
            if (minutes <= basicTime) return basicCharge;
            int overTime = minutes - basicTime;
            int unit = (overTime % unitTime == 0) ? overTime / unitTime : (overTime / unitTime) + 1;
            return basicCharge + unit * unitCharge;
        }
        
        long[] close() {
            forceOut();
            long[] result = new long[times.size()];
            for (int i = 0; i < result.length; i++) {
                int minutes = times.pollFirstEntry().getValue();                    
                result[i] = calculate(minutes);
            }
            return result;
        }
        
        void forceOut() {
            for (String carId : Set.copyOf(cars.keySet())) {
                Car car = cars.get(carId);
                out(car.getId(), car.getInTime(), 23 * 60 + 59);
            }
        }
    }
    
    static class Car {
        private final String id;
        private final Record in;
        
        Car(String id, Record in) {
            this.id = id;
            this.in = in;
        }
        
        static Car in(Record inRecord) {
            return new Car(inRecord.getCarId(), inRecord);
        }
        
        int out(Record outRecord) {
            return outRecord.getTime() - in.getTime();
        }
        
        String getId() {
            return id;
        }
        
        int getInTime() {
            return in.getTime();
        }
    }
    
    static class Record {
        private String carId;
        private int time;
        private boolean in;
        
        Record(String data) {
            String[] split = data.split(":|\\s");
            this.time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            this.carId = split[2];
            this.in = split[3].equals("IN");
        }
        
        String getCarId() {
            return carId;
        }
        
        int getTime() {
            return time;
        }
        
        boolean isIn() {
            return in;
        }
    }
}