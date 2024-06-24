/**
118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.
**/

class Solution {
    public List<Integer> generateNCR(int row) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        int res = 1;
        for (int i = 0; i < row; i++) {
            res *= row - i;
            res /= i + 1;
            temp.add(res);
        }
        return temp;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            res.add(generateNCR(i - 1));
        }
        return res;
    }
}
