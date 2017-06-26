//2017-6-26
//试题编号：	201312-5
//试题名称：	I’m stuck!
//时间限制：	1.0s
//内存限制：	256.0MB
//问题描述：	
//问题描述
//　　给定一个R行C列的地图，地图的每一个方格可能是'#', '+', '-', '|', '.', 'S', 'T'七个字符中的一个，分别表示如下意思：
//　　'#': 任何时候玩家都不能移动到此方格；
//　　'+': 当玩家到达这一方格后，下一步可以向上下左右四个方向相邻的任意一个非'#'方格移动一格；
//　　'-': 当玩家到达这一方格后，下一步可以向左右两个方向相邻的一个非'#'方格移动一格；
//　　'|': 当玩家到达这一方格后，下一步可以向上下两个方向相邻的一个非'#'方格移动一格；
//　　'.': 当玩家到达这一方格后，下一步只能向下移动一格。如果下面相邻的方格为'#'，则玩家不能再移动；
//　　'S': 玩家的初始位置，地图中只会有一个初始位置。玩家到达这一方格后，下一步可以向上下左右四个方向相邻的任意一个非'#'方格移动一格；
//　　'T': 玩家的目标位置，地图中只会有一个目标位置。玩家到达这一方格后，可以选择完成任务，也可以选择不完成任务继续移动。如果继续移动下一步可以向上下左右四个方向相邻的任意一个非'#'方格移动一格。
//　　此外，玩家不能移动出地图。
//　　请找出满足下面两个性质的方格个数：
//　　1. 玩家可以从初始位置移动到此方格；
//　　2. 玩家不可以从此方格移动到目标位置。
//输入格式
//　　输入的第一行包括两个整数R 和C，分别表示地图的行和列数。(1 ≤ R, C ≤ 50)。
//　　接下来的R行每行都包含C个字符。它们表示地图的格子。地图上恰好有一个'S'和一个'T'。
//输出格式
//　　如果玩家在初始位置就已经不能到达终点了，就输出“I'm stuck!”（不含双引号）。否则的话，输出满足性质的方格的个数。
//样例输入
//5 5
//--+-+
//..|#.
//..|##
//S-+-T
//####.
//样例输出
//2
//样例说明
//　　如果把满足性质的方格在地图上用'X'标记出来的话，地图如下所示：
//　　--+-+
//　　..|#X
//　　..|##
//　　S-+-T
//　　####X

package Stuck;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		Scanner fin = new Scanner(System.in);
		int R = fin.nextInt();
		int C = fin.nextInt();
		fin.nextLine();
		int[][] board = new int[R + 2][C + 2];
		int rowStart = 0, colStart = 0, rowEnd = 0, colEnd = 0;
		for (int i = 1; i <= R; ++i) {
			String line = fin.nextLine();
			for (int j = 1; j <= C; ++j) {
				char c = line.charAt(j - 1);
				switch (c) {
				case '#':
					break;
				case '-':
					board[i][j] = 5;
					break;
				case '|':
					board[i][j] = 0xA;
					break;
				case '+':
				case 'S':
				case 'T':
					board[i][j] = 0xF;
					break;
				case '.':
					board[i][j] = 0x8;
					break;
				default:
					break;
				}
				if (c == 'S') {
					rowStart = i;
					colStart = j;
				} else if (c == 'T') {
					rowEnd = i;
					colEnd = j;
				}
			}
		}
		int[] dr = new int[] { 0, -1, 0, 1 };
		int[] dc = new int[] { 1, 0, -1, 0 };
		// Scan 1: find all cells which can reach T
		boolean[][] visited = new boolean[R + 2][C + 2];
		boolean[][] canReachT = new boolean[R + 2][C + 2];
		initVisited(visited);
		canReachT[rowEnd][colEnd] = true;
		visited[rowEnd][colEnd] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(rowEnd);
		queue.add(colEnd);
		while (!queue.isEmpty()) {
			int r = queue.remove();
			int c = queue.remove();
			for (int i = 0; i < 4; ++i) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (visited[nr][nc])
					continue;
				if ((board[nr][nc] & (1 << ((i + 2) % 4))) != 0) {
					canReachT[nr][nc] = true;
					queue.add(nr);
					queue.add(nc);
					visited[nr][nc] = true;
				}
			}
		}
		/*
		 * for (int i = 1; i <= R; ++i) { for (int j = 1; j <= C; ++j) { if
		 * (canReachT[i][j]) { System.out.println("i = " + i + ", j = " + j); }
		 * } }
		 */
		if (!canReachT[rowStart][colStart]) {
			System.out.println("I'm stuck!");
			return;
		}
		// Scan 2: get result
		boolean[][] rCanReach = new boolean[R + 2][C + 2];
		initVisited(visited);
		queue.clear();
		visited[rowStart][colStart] = true;
		rCanReach[rowStart][colStart] = true;
		queue.add(rowStart);
		queue.add(colStart);
		while (!queue.isEmpty()) {
			int r = queue.remove();
			int c = queue.remove();
			for (int i = 0; i < 4; ++i) {
				if ((board[r][c] & (1 << i)) == 0)
					continue;
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (visited[nr][nc])
					continue;
				if (board[nr][nc] == 0)
					continue;
				rCanReach[nr][nc] = true;
				queue.add(nr);
				queue.add(nc);
				visited[nr][nc] = true;
			}
		}
		int result = 0;
		for (int i = 1; i <= R; ++i) {
			for (int j = 1; j <= C; ++j) {
				/*
				 * if (rCanReach[i][j]) { System.out.println("i = " + i +
				 * ", j = " + j); }
				 */
				if (rCanReach[i][j] && (!canReachT[i][j]))
					++result;
			}
		}
		System.out.println(result);
	}

	private void initVisited(boolean[][] visited) {
		int R = visited.length - 2;
		int C = visited[0].length - 2;
		for (int i = 0; i <= R + 1; ++i) {
			visited[i][0] = true;
			visited[i][C + 1] = true;
		}
		for (int j = 0; j <= C + 1; ++j) {
			visited[0][j] = true;
			visited[R + 1][j] = true;
		}
		for (int i = 1; i <= R; ++i) {
			for (int j = 1; j <= C; ++j) {
				visited[i][j] = false;

			}

		}

	}
}