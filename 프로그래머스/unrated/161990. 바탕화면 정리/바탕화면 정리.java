class Solution {
    public int[] solution(String[] wallpaper) {
        // wallpaper의 index 는 x좌표 : 세로
        // wallpaper element의 문자 index 는 y좌표 : 가로
        
        // List에 파일의 세로좌표 lux시작, rdx시작 + 1 2개, 가로 좌표 luy indexOf rdy lastIndexOf + 1 2개를 담는다.
        // 그 줄에 파일이 있는 경우에만
        // ux는 최소값 rdx는 최대값 luy는 최소값 rdy는 최대값을 가져온다.
        // 반환한다.
        
        int lux = 50;
        int luy = 50;
        int rdx = 0;
        int rdy = 0;
        
        for (int x = 0; x < wallpaper.length; x++) {
            String row = wallpaper[x];
            if (row.contains("#")) {
                lux = Math.min(lux, x);
                luy = Math.min(luy, row.indexOf("#"));
                rdx = Math.max(rdx, x + 1);
                rdy = Math.max(rdy, row.lastIndexOf("#") + 1);
            }
        }
        
        return new int[]{lux, luy, rdx, rdy};
    }
}