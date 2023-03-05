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
        fillField(fieldOne, '-');
        fillField(fieldTwo, '-');

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
        System.out.println("             Y ");
        System.out.println("X 0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < field.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void startGame(String playerOne, String playerTwo, char[][] fieldOne, char[][] fieldTwo) {
        System.out.println(playerOne + " move first");
        while (true) {
            playerMakeStep(fieldOne, playerOne); // playerOne делает ход
            printField(fieldOne, playerOne);
            if (isPlayerWin(fieldOne)) {
                System.out.println(playerOne + " WIN");
                break;
            }
            //----------------------------------
            playerMakeStep(fieldTwo, playerTwo); // playerTwo делает ход
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

    private static void playerMakeStep(char[][] field, String player) {
        System.out.println(player + " Enter the coordinates X and Y to move, which must be two integers from 0 to " + (FIELD_SIZE - 1) + ", using a space ");
        int x = Integer.parseInt(scanner.next());
        int y = Integer.parseInt(scanner.next());
        if (field[x][y] == 'S') {
            System.out.println(player + " hit the ship ");
        } else if (field[x][y] == '-' || field[x][y] == '*') {
            System.out.println(player + " missed it ");
        }
        field[x][y] = '*';

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
                    System.out.println(player + " Enter the coordinate X and Y of " + shipCount + " ship(s) with " + shipDeck + " deck(s) " + '\n' +
                            "coordinate must be two integers from 0 to " + (FIELD_SIZE - 1) + ", using a space ");
                    x = Integer.parseInt(scanner.next());
                    y = Integer.parseInt(scanner.next());
                    System.out.println("Enter the direction of ships, which must be integer 1-horizon, 2-vertical");
                    direction = scanner.nextInt();

                    resultCheck = validationCoordinate(field, x, y, direction, shipDeck);
                    if (!resultCheck) {
                        System.out.println("These coordinates " + x + " " + y + " are  wrong enter other coordinates ");
                    }

                }
                // fill field by ship

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
        // true  - can make step  // false - cant
        // 1-horizon, 2-vertical

        boolean result = false;
        if (direction == 1) { // 1-horizon
            int sumaS = 0;
            // check field border
            if ((y + shipDeck) > (FIELD_SIZE - 1)) {
          //     System.out.println("x + shipDeck) > (FIELD_SIZE - 1)  X=" + x + ", Y=" + y + "shipDeck" + shipDeck + "< result false");
                result = false;
            } else {
                for (int k = 0; k < shipDeck; k++) {
                    // check current cell is empty
                    sumaS = (field[x][y + shipDeck - k - 1] == 'S' ? sumaS + 1 : sumaS);
                    if (x - 1 >= 0) {
                        // check next cell is empty
                        sumaS = (field[x - 1][y + shipDeck - k - 1] == 'S' ? sumaS + 1 : sumaS);
                    }
                    if (x + 1 <= 9) {
                        sumaS = (field[x + 1][y + shipDeck - k - 1] == 'S' ? sumaS + 1 : sumaS);
                    }
                    if (y - 1 >= 0 && k == 0 && x - 1 >= 0 && x + 1 <= 9) {
                        sumaS = (field[x - 1][y - 1] == 'S' ? sumaS + 1 : sumaS);
                        sumaS = (field[x + 0][y - 1] == 'S' ? sumaS + 1 : sumaS);
                        sumaS = (field[x + 1][y - 1] == 'S' ? sumaS + 1 : sumaS);
                    }
                    if (y + 1 <= 9 && k == (shipDeck - 1) && x - 1 >= 0 && x + 1 <= 9) {
                        sumaS = (field[x - 1][y + shipDeck - k - 1] == 'S' ? sumaS + 1 : sumaS);
                        sumaS = (field[x + 0][y + shipDeck - k - 1] == 'S' ? sumaS + 1 : sumaS);
                        sumaS = (field[x + 1][y + shipDeck - k - 1] == 'S' ? sumaS + 1 : sumaS);
                    }
                    // y + shipDeck - shipDeck - 1 - 1


                    result = (sumaS == 0 ? true : false);
         //           System.out.println("!!!!!  X=" + x + ", k=" + k + "shipDeck" + shipDeck + ",  sumaS" + sumaS + "result" + result);
                }
            }
        }

        if (direction == 2) { // 2-vertical
            int sumaS = 0;
            if ((x + shipDeck) > (FIELD_SIZE - 1)) {
                //System.out.println("(y + shipDeck) > (FIELD_SIZE - 1)  X=" + x + ", Y=" + y + "shipDeck" + shipDeck + "< result false");
                result = false;
            } else {
                for (int l = 0; l < shipDeck; l++) {
                    sumaS = (field[x + shipDeck - l - 1][y] == 'S' ? sumaS + 1 : sumaS);
                    if (y - 1 >= 0) {
                        sumaS = (field[x + shipDeck - l - 1][y - 1] == 'S' ? sumaS + 1 : sumaS);
                    }
                    if (y + 1 <= 9) {
                        sumaS = (field[x + shipDeck - l - 1][y + 1] == 'S' ? sumaS + 1 : sumaS);
                    }

                    if (x - 1 >= 0 && l == 0 && y - 1 >= 0 && y + 1 <= 9) {
                        sumaS = (field[x - 1][y + 1] == 'S' ? sumaS + 1 : sumaS);
                        sumaS = (field[x - 1][y + 0] == 'S' ? sumaS + 1 : sumaS);
                        sumaS = (field[x - 1][y - 1] == 'S' ? sumaS + 1 : sumaS);
                    }
                    if (x + 1 <= 9 && l == (shipDeck - 1) && y - 1 >= 0 && y + 1 <= 9) {
                        sumaS = (field[x + shipDeck - l - 1][y - 1] == 'S' ? sumaS + 1 : sumaS);
                        sumaS = (field[x + shipDeck - l - 1][y + 0] == 'S' ? sumaS + 1 : sumaS);
                        sumaS = (field[x + shipDeck - l - 1][y + 1] == 'S' ? sumaS + 1 : sumaS);
                    }
                    //System.out.println("!!!!! y=" + y + ", l=" + l + "shipDeck" + shipDeck + ",  sumaS" + sumaS);
                    result = (sumaS == 0 ? true : false);

                }

            }


        }
        //System.out.println("validationCoordinate Last result " + result);
        return result;

    }




}
