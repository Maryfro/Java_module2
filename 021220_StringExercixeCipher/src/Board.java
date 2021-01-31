import java.util.Arrays;

public class Board {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(Arrays.toString(board.solve(3, new int[]{2, 1}, new int[]{1, 0, 2})));
        System.out.println(Arrays.toString(board.solve(3, new int[]{1, 2}, new int[]{2, 1, 0})));
        System.out.println(Arrays.toString(board.solve(4, new int[]{1, 2}, new int[]{0, 2, 1, 0})));
    }

    public int[] solve(int colQty, int[] rowSums, int[] columnsSums) {
        int[] res = new int[colQty * 2];
        for (int i = 0; i < columnsSums.length; i++) {
            if (columnsSums[columnsSums.length - 1 - i] == 2) {
                res[res.length - 1 - i] = 1;
                res[res.length / 2 - 1 - i] = 1;
            }
            if (columnsSums[columnsSums.length - 1 - i] == 0) {
                res[res.length - 1 - i] = 0;
                res[res.length / 2 - 1 - i] = 0;
            }
            if (columnsSums[columnsSums.length - 1 - i] == 1) {
                if (rowSums[0] > rowSums[rowSums.length - 1]) {
                    res[res.length / 2 - 1 - i] = 1;
                    res[res.length - 1 - i] = 0;
                } else {
                    res[res.length / 2 - 1 - i] = 0;
                    res[res.length - 1 - i] = 1;
                }
            }
        }
        return res;
    }


    /**
     * the method recovers the board 2*n
     *
     * @param columns sums in each column
     * @param p       sum in the first row
     * @param q       sum  in the second row
     * @return recovered board
     */
    public int[] solve2(int[] columns, int p, int q) {
        int[] res = new int[columns.length * 2];
        int width = columns.length;
        for (int i = width - 1; i >= 0; i--) {
            int columnSum = columns[i];
            if (columnSum == 0) {
                res[i] = res[i + width] = 0;
            } else if (columnSum == 2) {
                res[i] = res[i + width] = 1;
                p--;
                q--;
            } else if (p > q) {
                res[i] = 1;
                res[i + width] = 0;
                p--;
            } else {
                res[i] = 0;
                res[i + width] = 1;
                q--;
            }
        }
        return res;
    }
}

// 1.arr sum of row
//2. arr sum of col
//N - col, 2 rows

//if we have 0 in col -> in row 0, 0
//if we have 2 in col -> in row 1, 1;
//put 1 in row, where sum is bigger
//return arr  with length = 2*col;{1, 0, 1, 0, 0, 1}
// recursive or smaller task


