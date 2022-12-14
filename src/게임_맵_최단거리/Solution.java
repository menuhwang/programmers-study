package 게임_맵_최단거리;

import java.util.ArrayDeque;

public class Solution {
    static final Direction[] DIR = {
            Direction.RIGHT,
            Direction.DOWN,
            Direction.LEFT,
            Direction.UP
    };


    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(0, 0));

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            maps[pos.x][pos.y] = 0;
            for (Direction to : DIR) {
                int newX = pos.x + to.getDeltaX();
                int newY = pos.y + to.getDeltaY();
                if (newX < 0 || newY < 0 || newX >= maps.length || newY >= maps[0].length || maps[newX][newY] == 0) continue;
                if (visited[newX][newY] == 0) {
                    visited[newX][newY] = visited[pos.x][pos.y] + 1;
                    queue.offer(new Pos(newX, newY));
                }
            }
        }

        int answer = visited[maps.length - 1][maps[0].length - 1];
        return answer == 0 ? -1 : answer;
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

enum Direction {
    LEFT(new int[]{0, -1}),
    RIGHT(new int[]{0, 1}),
    UP(new int[]{-1, 0}),
    DOWN(new int[]{1, 0});

    private final int[] delta;

    Direction(int[] delta) {
        this.delta = delta;
    }

    public int getDeltaX() {
        return delta[0];
    }

    public int getDeltaY() {
        return delta[1];
    }
}
