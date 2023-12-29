import java.util.*;

class Solution {
    enum Command {
        ENTER("%s님이 들어왔습니다."),
        LEAVE("%s님이 나갔습니다."),
        CHANGE(null);
        
        String messageFormat;
        
        Command(String messageFormat) {
            this.messageFormat = messageFormat;
        }
    }
    
    class Log {
        Command command;
        String uid;
        
        Log(Command command, String uid) {
            this.command = command;
            this.uid = uid;
        }
    }
    
    public String[] solution(String[] record) {
        Map<String, String> sessionStorage = new HashMap<>();
        List<Log> logs = new ArrayList<>();
        
        for (String rec : record) {
            String[] packet = rec.split(" ", 2);
            
            Command cmd = Command.valueOf(packet[0].toUpperCase());
            String uid = null;
            String nickname = null;
            switch (cmd) {
                case LEAVE:
                    uid = packet[1];
                    break;
                    
                case ENTER:
                case CHANGE:
                    String[] arg = packet[1].split(" ");
                    uid = arg[0];
                    nickname = arg[1];
                    sessionStorage.put(uid, nickname);
                    break;
            }
            
            if (cmd != Command.CHANGE)
                logs.add(new Log(cmd, uid));
        }
        
        String[] answer = new String[logs.size()];
        for (int i = 0; i < answer.length; i++) {
            Log log = logs.get(i);
            answer[i] = String.format(log.command.messageFormat, sessionStorage.get(log.uid));
        }
        
        return answer;
    }
}