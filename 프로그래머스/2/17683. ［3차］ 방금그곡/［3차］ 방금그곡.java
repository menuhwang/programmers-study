import java.util.*;

class Solution {
    static class Music {
        int start;
        int end;
        String title;
        StringBuilder melody;
        
        Music(int start, int end, String title, String melody) {
            this.start = start;
            this.end = end;
            this.title = title;
            this.melody = new StringBuilder(melody);
            while (this.melody.length() < end - start) {
                this.melody.append(this.melody);
            }
            this.melody.setLength(end - start);
        }
        
        public int getPlayTime() {
            return end - start;
        }
        
        public boolean equals(String m) {
            return this.melody.indexOf(m) > -1;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        m = m.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b") // 문제 오류 B#은 존재하지 않음
            ;
        
        List<Music> musics = new ArrayList<>();
        
        for (String info : musicinfos) {
            musics.add(parseMusic(info));
        }
        
        musics.sort((m1, m2) -> {
            int result = -Integer.compare(m1.getPlayTime(), m2.getPlayTime());
            
            if (result == 0) {
                result = Integer.compare(m1.start, m2.start);
            }
            
            return result;
        });
        
        for (Music music : musics) {
            if (music.equals(m))
                return music.title;
        }
    
        return "(None)";
    }
    
    static Music parseMusic(String info) {
        String[] infoArr = info.split(",");
        String[] startTime = infoArr[0].split(":");
        String[] endTime = infoArr[1].split(":");
        String title = infoArr[2];
        String melody = infoArr[3].replaceAll("C#", "c")
                    .replaceAll("D#", "d")
                    .replaceAll("F#", "f")
                    .replaceAll("G#", "g")
                    .replaceAll("A#", "a")
                    .replaceAll("B#", "b") // 문제 오류 B#은 존재하지 않음
            ;
        
        int start = 60 * Integer.parseInt(startTime[0]) + Integer.parseInt(startTime[1]);
        int end = 60 * Integer.parseInt(endTime[0]) + Integer.parseInt(endTime[1]);
        
        return new Music(start, end, title, melody);
    }
}