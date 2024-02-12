import java.util.*;

class Solution {
    public int solution(String[] names, String[] gifts) {
        Map<String, Friend> friendMap = new HashMap<>();
        for (String name : names) {
            friendMap.put(name, new Friend(name));
        }
        
        for (String gift : gifts) {
            String[] fromTo = gift.split(" ");
            String fromName = fromTo[0];
            String toName = fromTo[1];
            
            Friend from = friendMap.get(fromName);
            Friend to = friendMap.get(toName);
            
            from.give(to);
            to.get(from);
        }
        
        Collection<Friend> friends = friendMap.values();
        int answer = 0;
        
        for (Friend friend : friends) {
            answer = Math.max(answer, friend.nextMonthGift(friends));
        }
        
        return answer;
    }
    
    static class Friend {
        private String name;
        private int giftIndex;
        private final Map<Friend, Integer> gave = new HashMap<>();
        private final Map<Friend, Integer> got = new HashMap<>();
        
        Friend(String name) {
            this.name = name;
        }
        
        void give(Friend to) {
            gave.compute(to, (k, v) -> v == null ? 1 : v + 1);
            giftIndex++;
        }
        
        void get(Friend from) {
            got.compute(from, (k, v) -> v == null ? 1 : v + 1);
            giftIndex--;
        }
        
        int nextMonthGift(Collection<Friend> friends) {
            int result = 0;
            for (Friend friend : friends) {
                if (name.equals(friend.name))
                    continue;
                
                result += getGiftFrom(friend);
            }
            
            return result;
        }
        
        int getGiftFrom(Friend friend) {
            int gaveGift = gave.getOrDefault(friend, 0);
            int gotGift = got.getOrDefault(friend, 0);
            
            if (gotGift < gaveGift) {
                return 1;
            } else if (gotGift == gaveGift && giftIndex > friend.giftIndex) {
                return 1;
            }
            
            return 0;
        }
    }
}