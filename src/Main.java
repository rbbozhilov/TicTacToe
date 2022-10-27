import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        char player = 'X';
        while (true) {
            System.out.println("player " + player);
            System.out.print("x=");
            int x = sc.nextInt();
            System.out.print("y=");
            int y = sc.nextInt();
            if (x<0||x>=board[0].length||y<0||y>=board.length) {
                System.out.println("wrong move!");
                continue;
            }
            if (board[y][x] != 0) {
                System.out.println("position taken!");
                continue;
            }
            board[y][x] = player;
            printBoard(board);

            if (checkWinner(board, player)) {
                System.out.println(player + " is winner");
                break;
            }

            if (player == 'X') {
                player = '0';
            } else {
                player = 'X';
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i=0;i<board.length;i++) {
            System.out.print("|");
            for (int j=0;j<board[i].length;j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static boolean checkWinner(char[][] board, char player) {
        for (int i=0;i<board.length;i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }


        for (int i=0;i<board.length;i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}