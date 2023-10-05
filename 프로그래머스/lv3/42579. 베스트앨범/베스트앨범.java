import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();

        Map<String, Integer> genreAndPlay = new HashMap<>();
        Map<String, List<Music>> genreAndMusic = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!genreAndPlay.containsKey(genres[i])) {
                genreAndPlay.put(genres[i], 0);
                genreAndMusic.put(genres[i], new LinkedList<>());
            }
            genreAndPlay.put(genres[i], genreAndPlay.get(genres[i]) + plays[i]);
            genreAndMusic.get(genres[i]).add(new Music(i, plays[i]));
        }

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(genreAndPlay.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> entry : entries) {
            List<Music> musics = genreAndMusic.get(entry.getKey());
            Collections.sort(musics);

            int num = Math.min(2, musics.size());
            for (int i = 0; i < num; i++) {
                result.add(musics.get(i).id);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = result.get(i);

        return answer;
    }

    static class Music implements Comparable<Music> {
        private final int id;
        private final int play;

        Music(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Music m) {
            int result = Integer.compare(play, m.play) * -1;
            if (result == 0)
                result = Integer.compare(id, m.id);
            return result;
        }
    }
}