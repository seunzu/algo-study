package 베스트앨범;

import java.util.*;

class Song implements Comparable<Song> {
    int idx, plays;

    public Song (int idx, int plays) {
        this.idx = idx;
        this.plays = plays;
    }

    @Override
    public int compareTo(Song o) {
        if (this.plays == o.plays) return this.idx - o.idx;
        return o.plays - this.plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlaySum = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlaySum.put(genres[i], genrePlaySum.getOrDefault(genres[i], 0) + plays[i]);
            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<String> genreOrder = new ArrayList<>(genrePlaySum.keySet());
        genreOrder.sort((a, b) -> genrePlaySum.get(b) - genrePlaySum.get(a));

        List<Integer> result = new ArrayList<>();

        for (String g : genreOrder) {
            List<Song> list = genreSongs.get(g);
            Collections.sort(list);

            for (int i = 0; i < Math.min(2, list.size()); i++) {
                result.add(list.get(i).idx);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}