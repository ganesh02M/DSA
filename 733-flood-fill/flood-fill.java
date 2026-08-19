class Solution {
   public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int oldColor = image[sr][sc];
    if (oldColor != color) fill(image, sr, sc, oldColor, color);
    return image;
}
private void fill(int[][] image, int r, int c, int oldColor, int newColor) {
    if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != oldColor) return;
    image[r][c] = newColor;
    fill(image, r+1, c, oldColor, newColor); fill(image, r-1, c, oldColor, newColor);
    fill(image, r, c+1, oldColor, newColor); fill(image, r, c-1, oldColor, newColor);
}
}