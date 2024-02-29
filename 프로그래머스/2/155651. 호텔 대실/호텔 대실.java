import java.util.*;

class Solution {
    static class Reservation implements Comparable<Reservation> {
        int entry;
        int exit;
        
        Reservation(int entry, int exit) {
            this.entry = entry;
            this.exit = exit;
        }
        
        public boolean overlap(Reservation r) {
            return !(r.exit <= this.entry || r.entry >= this.exit);
        }
        
        @Override
        public int compareTo(Reservation r) {
            return Integer.compare(this.exit, r.exit);
        }
    }
    
    static final int CLEANING = 10;
    
    public int solution(String[][] book_time) {
        List<Reservation> reservations = new ArrayList<>();
        for (String[] reservation : book_time) {
            String[] entryTime = reservation[0].split(":");
            String[] exitTime = reservation[1].split(":");
            
            int entry = 60 * Integer.parseInt(entryTime[0]) + Integer.parseInt(entryTime[1]);
            int exit = 60 * Integer.parseInt(exitTime[0]) + Integer.parseInt(exitTime[1]) + CLEANING;
            
            reservations.add(new Reservation(entry, exit));
        }
        
        reservations.sort(Comparator.reverseOrder());
        
        
        List<List<Reservation>> rooms = new ArrayList<>();
        
        rooms.add(new ArrayList<>(List.of(reservations.get(0))));
        
        for (int i = 1; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            boolean booking = false;
            for (List<Reservation> room : rooms) {
                Reservation last = room.get(room.size() - 1);
                if (!last.overlap(reservation)) {
                    booking = true;
                    room.add(reservation);
                    break;
                }
            }
            if (!booking) {
                rooms.add(new ArrayList<>(List.of(reservation)));
            }
        }
        
        return rooms.size();
    }
}