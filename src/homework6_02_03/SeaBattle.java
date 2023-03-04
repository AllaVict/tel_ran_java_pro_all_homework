package homework6_02_03;

import java.util.Scanner;

public class SeaBattle {
    /**
     * Описание задания.
     * 1--- уровень сложности: Морской бой Консольное приложение.
     * 2---Одновременно в игре могут участвовать только два человека.
     * 3---Игроки вводят имена.
     * 4---У каждого игрока есть своё поле - квадрат 10х10 клеток
     * 5---По очереди расставляют свои корабли.
     * 6---4 однопалубных корабля,
     * 7---3 двухпалубных,
     * 8---2 трехпалубных,
     * 9---1 четырёхпалубный.
     * <p>
     * 10---Корабли можно располагать только по горизонтали или по вертикали.
     * 11---Между кораблями должна быть минимум одна клетка
     * 12---Игроки не видят расположение кораблей друг друга.
     * 13---Начинается игра. Первый игрок делает выстрел, сообщая нашему приложению координаты
     * предполагаемой цели - номер клетки по горизонтали и номер клетки по вертикали.
     * 15---Если выстрел первого игрока оказался удачным, и он поразил цель, то возможно два варианта
     * развития событий.
     * 16---Первый вариант: в указанной игроком клетки находится корабль, то, если корабль
     * однопалубный, игрок "убил" корабль, если не однопалубный, то ранил. Следующий ход за
     * первым игроком.
     * 17---Второй вариант: игрок не попал ни в какой корабль, ход переходит второму игроку.
     * Таким образом, возвращаемся в пункт 8, передавая ход друг другу, игроки пытаются как можно
     * раньше уничтожить корабли друг друга. Тот, кто первым, уничтожит все корабли - победитель.
     * Печатаем поздравление и выход из игры.
     **/
    private static final int FIELD_SIZE = 10;
    // {countDeck, countShip}
    private static final int[][] SHIPS = {{4, 1}, {3, 2}, {2, 3}, {1, 4}};
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Add input players name from scanner
        System.out.println("Enter name of first player ");
        String playerOne = scanner.nextLine();
        System.out.println("Enter name of second player ");
        String playerTwo = scanner.nextLine();

        char[][] fieldOne = new char[FIELD_SIZE][FIELD_SIZE];
        char[][] fieldTwo = new char[FIELD_SIZE][FIELD_SIZE];
        fillField(fieldOne, 'o');
        fillField(fieldTwo, 'o');

        // Add ships on field
        fillPlayerField(fieldOne, playerOne);
        // Add ships on field
        fillPlayerField(fieldTwo, playerTwo);

        startGame(playerOne, playerTwo, fieldOne, fieldTwo);

    }

    private static void fillField(char[][] field, char charik) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = charik;
            }
            System.out.println();
        }

    }

    private static void printField(char[][] field, String player) {
        System.out.println("Field of player  " + player + "");
        //       System.out.println(Arrays.deepToString(field));
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < field.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void startGame(String playerOne, String playerTwo, char[][] fieldOne, char[][] fieldTwo) {
        System.out.println(playerOne + " move first");
        while (true) {
            makePlayerMove(fieldOne, playerOne); // playerOne делает ход
            printField(fieldOne, playerOne);
            if (isPlayerWin(fieldOne)) {
                System.out.println(playerOne + " WIN");
                break;
            }
            //----------------------------------
            makePlayerMove(fieldTwo, playerTwo); // playerTwo делает ход
            printField(fieldTwo, playerTwo);
            if (isPlayerWin(fieldTwo)) {
                System.out.println(playerTwo + " WIN");
                break;
            }

        }
        System.out.println("Game is over!");
    }

    private static boolean isPlayerWin(char[][] field) {
        //true  - WIN =S not presents  // false -notWIN = S presents
        boolean result = false;
        int sumaS = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                sumaS = (field[i][j] == 'S' ? sumaS + 1 : sumaS);
                //System.out.println(field[i][j] + " sumaS " + sumaS);
                result = (sumaS > 0 ? false : true);
            }
        }

        //System.out.println("Last result " + result);
        return result;
    }

    private static void makePlayerMove(char[][] field, String player) {
        System.out.println(player + " Enter the coordinates to move, which must be two integers from 0 to " + (FIELD_SIZE - 1) + ", using a space ");
        int x = Integer.parseInt(scanner.next());
        int y = Integer.parseInt(scanner.next());
        if (field[x][y] == 'S') {
            System.out.println(player + " hit the ship ");
        } else if (field[x][y] == 'o' || field[x][y] == 'X') {
            System.out.println(player + " missed it ");
        }
        field[x][y] = 'X';

    }

    private static void fillPlayerField(char[][] field, String player) {
//        // {countDeck, countShip}
        for (int i = 0; i < SHIPS.length; i++) { //
            int shipCount = SHIPS[i][1]; //
            for (int j = 0; j < shipCount; j++) {
                int shipDeck = SHIPS[i][0];
                boolean resultCheck = false;
                int x = 0;
                int y = 0;
                int direction = 0;

                while (!resultCheck) {
                    // ask first (x,y)
                    // ask direction (1-horizon, 1-vertical)
                    System.out.println(player + " Enter the coordinate of " + shipCount + " ship(s) with " + shipDeck + " deck(s) " + '\n' +
                            "coordinate must be two integers from 0 to " + (FIELD_SIZE - 1) + ", using a space ");
                    x = Integer.parseInt(scanner.next());
                    y = Integer.parseInt(scanner.next());
                    if (shipDeck > 0) {
                        System.out.println("Enter the direction of ships, which must be integer 1-horizon, 2-vertical");
                        direction = scanner.nextInt();
                    }

                    resultCheck = validationCoordinate(field, x, y, direction, shipDeck);
                    if (!resultCheck) {
                        System.out.println("These coordinates " + x + " " + y + " are  wrong enter other coordinates ");
                    }

                }
                // fill field by ship
                fillByShip(field, shipDeck, x, y, direction);
                printField(field, player);

            }

        }


    }

    private static void fillByShip(char[][] field, int shipDeck, int x, int y, int direction) {
        if (shipDeck > 0) { // shipDeck=4, 3, 2, 1
            if (direction == 1) { // 1- horizon
                for (int l = 0; l < shipDeck; l++) {
                    field[x][y + shipDeck - l - 1] = 'S';
                }
            } else if (direction == 2) { // 2-vertical
                for (int k = 0; k < shipDeck; k++) {
                    field[x + shipDeck - k - 1][y] = 'S';
                }
            }
        }
    }

    private static boolean validationCoordinate(char[][] field, int x, int y, int direction, int shipDeck) {
        // check field border
        //true  - S not presents  // false -S presents
        boolean result = false;
        int sumaS = 0;
        if (shipDeck > 0) { // shipDeck=4, 3, 2, 1
            if (direction == 1) { // 1-vertical
                for (int k = 0; k < shipDeck; k++) {
                    sumaS = (field[x + shipDeck - k - 1][y] == 'S' ? sumaS + 1 : sumaS);
                    //System.out.println(field[i][j] + " sumaS " + sumaS);
                    result = (sumaS > 0 ? false : true);
                }
            } else if (direction == 2) { // 2-horizon
                for (int l = 0; l < shipDeck; l++) {
                    sumaS = (field[x][y + shipDeck - l - 1] == 'S' ? sumaS + 1 : sumaS);
                    result = (sumaS > 0 ? false : true);
                }

            }
        }

        System.out.println("validationCoordinate Last result " + result);
        return result;

    }


}
