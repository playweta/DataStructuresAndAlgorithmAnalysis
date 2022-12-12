package may.leetcode;

/**
 * @author liubr
 * @date 2022/12/11 15:07 下午
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 */
public class Day028DetermineColorChessboardSquare {
	public static void main(String[] args) {
		System.out.println(new Day028DetermineColorChessboardSquare().squareIsWhite("c7"));
	}

	public boolean squareIsWhite(String coordinates) {
		return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 == 1;
	}
}
