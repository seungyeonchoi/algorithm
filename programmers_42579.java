import java.util.*;
public class programmers_42579 {

    /*
     * 프로그래머스 42579 베스트앨범  https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
     * 자료구조: 해시맵, 우선순위큐
     *
     */
    class Solution {
        class genre{
            String name;
            int plays = 0;
            PriorityQueue<song> songs = new PriorityQueue<>((a,b)->{
                if(a.play == b.play) return a.num - b.num;
                return b.play - a.play;
            });
            public genre(String name, Vector<song> songs){
                this.name = name;
                for(song s: songs){
                    this.songs.offer(s);
                    plays += s.play;
                }
            }
        }
        class song{
            int num;
            int play;
            public song(int num, int play){
                this.num = num;
                this.play = play;
            }
        }

        public Integer[] solution(String[] genres, int[] plays) {
            Integer[] answer = {};
            Map<String, Vector<song>> map = new HashMap<>();
            for(int i = 0; i<genres.length;i++){
                if(!map.containsKey(genres[i])){
                    map.put(genres[i], new Vector<song>());
                }
                map.get(genres[i]).add(new song(i,plays[i]));
            }
            PriorityQueue<genre> pq = new PriorityQueue<>((a,b)->{
                return b.plays - a.plays;
            });
            for(String name: map.keySet()){
                pq.offer(new genre(name,map.get(name)));
            }
            Vector<Integer> ans = new Vector<>();
            while(!pq.isEmpty()){
                genre g = pq.poll();
                ans.add(g.songs.poll().num);
                if(!g.songs.isEmpty()){
                    ans.add(g.songs.poll().num);
                }
            }
            answer = new Integer[ans.size()];
            ans.toArray(answer);
            return answer;
        }
    }
}
