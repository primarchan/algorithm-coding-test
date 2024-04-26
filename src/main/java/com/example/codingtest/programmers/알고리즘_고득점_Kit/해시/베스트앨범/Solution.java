package com.example.codingtest.programmers.알고리즘_고득점_Kit.해시.베스트앨범;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();

        // 장르별 총 재생수와 노래별 재생 정보 수집
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            genreSongs.computeIfAbsent(genres[i], k -> new PriorityQueue<>())
                    .add(new Song(i, plays[i]));
        }

        // 장르별 총 재생수를 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        Collections.sort(sortedGenres, (a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> bestAlbum = new ArrayList<>();
        // 각 장르별로 가장 많이 재생된 노래 2개씩 선정
        for (String genre : sortedGenres) {
            PriorityQueue<Song> songs = genreSongs.get(genre);
            for (int i = 0; i < 2 && !songs.isEmpty(); i++) {
                bestAlbum.add(songs.poll().id);
            }
        }

        // 결과 반환
        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }

    class Song implements Comparable<Song> {
        int id;
        int plays;

        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song other) {
            if (this.plays == other.plays) {
                return this.id - other.id; // 재생 수가 같다면 고유 번호가 낮은 노래 먼저
            }
            return other.plays - this.plays; // 재생 수가 많은 노래 먼저
        }
    }

}
