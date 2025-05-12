package main.FigurePainter;

public class FigurePainter {

    void figureOne(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    void figureOne(int n) {
        figureOne(n, '*');
    }


    void figureTwo() {
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void figureThree() {
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= (5 - i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void figureFour() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void figureFive() {
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i + 1; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("  ");
            }
            for (int j = 4; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


}
