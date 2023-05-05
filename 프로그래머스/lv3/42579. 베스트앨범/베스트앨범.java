import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, Integer> genreCount = new HashMap<>();
        List<Music> musics = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            genreCount.put(genres[i], 0);
            musics.add(new Music(i, genres[i], plays[i]));
        }
        
        Collections.sort(musics, (m1, m2) -> {
            if (!m1.getGenre().equals(m2.getGenre())) {
                return Integer.compare(count.get(m1.getGenre()), count.get(m2.getGenre())) * -1;
            }
            if (m1.getPlay() != m2.getPlay()) {
                return Integer.compare(m1.getPlay(), m2.getPlay()) * -1;
            }
            return Integer.compare(m1.getId(), m2.getId());
        });
        
        List<Integer> album = new ArrayList<>();
        for (Music m : musics) {
            String genre = m.getGenre();
            if (genreCount.get(genre) < 2) {
                genreCount.put(genre, genreCount.get(genre) + 1);
                album.add(m.getId());
            }
        }
        
        int[] answer = new int[album.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = album.get(i);
        }
        
        return answer;
    }
    
    static class Music {
        private int id;
        private String genre;
        private int play;
        
        Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
        
        int getId() {
            return id;
        }
        
        String getGenre() {
            return genre;
        }
        
        int getPlay() {
            return play;
        }
    }
}