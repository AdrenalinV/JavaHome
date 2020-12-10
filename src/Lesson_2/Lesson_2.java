package Lesson_2;

public class Lesson_2 {
    public static void main(String[] args) {
        lessonItem_1();
        System.out.println();
        lessonItem_2();
        System.out.println();
        lessonItem_3();
        System.out.println();
        lessonItem_4();
        System.out.println();
        lessonItem_5();
        System.out.println("Задание_6");
        int[] in_array1 = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("Проверяемый массив:");
        printArray(in_array1);
        System.out.println(lessonItem_6(in_array1));
        int[] in_array2 = new int[]{1, 1, 1, 2, 1};
        System.out.println("Проверяемый массив:");
        printArray(in_array2);
        System.out.println(lessonItem_6(in_array2));
        int[] in_array3 = new int[]{1, 1, 1, 1, 2, 5};
        System.out.println("Проверяемый массив:");
        printArray(in_array3);
        System.out.println(lessonItem_6(in_array3));
        System.out.println();
        System.out.println("Задание_7");
        int[] array=new int[]{1,2,3,4,5,6};
        System.out.println("Исходный массив:");
        printArray(array);
        array= lessonItem_7(2,array);
        System.out.println("После смещения на 2");
        printArray(array);
        System.out.println();
        int[] array2=new int[]{1,2,3,4,5,6};
        System.out.println("Исходный массив:");
        printArray(array2);
        array2= lessonItem_7(-2,array2);
        System.out.println("После смещения на -2");
        printArray(array2);
    }

    /*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */
    public static void lessonItem_1() {
        System.out.println("Задание_1");
        System.out.println("Исходный массив:");
        byte[] array = new byte[]{1, 0, 1, 0, 1, 1, 0, 0, 1, 1};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println();
        System.out.println("Преобразованный массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }

    }

    /*
    2. Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    */
    public static void lessonItem_2() {
        System.out.println("Задание_2");
        System.out.println("Заполненный массив:");
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
            System.out.print(array[i] + "\t");
        }

    }

    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */
    public static void lessonItem_3() {
        System.out.println("Задание_3");
        System.out.println("Исходный массив:");
        System.out.println("1\t5\t3\t2\t11\t4\t5\t2\t4\t8\t9\t1");
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Преобразованный массив:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
            System.out.print(array[i] + "\t");
        }
    }

    /*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
     и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    public static void lessonItem_4() {
        System.out.println("Задание_4");
        int[][] array = new int[8][8];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || j == array[i].length - i - 1) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /*
    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    */
    public static void lessonItem_5() {
        System.out.println("Задание_5");
        int min = 0, max = 0;
        int[] array = new int[]{12, 13, 45, 765, -123, 345, 67, 987, -12, 0, 13};
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (!flag) {
                min = array[i];
                max = array[i];
                flag = true;
            }
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("min = " + min + "\tmax = " + max);
    }

    /*
    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     граница показана символами ||, эти символы в массив не входят.
     */
    public static Boolean lessonItem_6(int[] array) {
        long sumL = 0, sumR = 0;
        for (int i = 0; i < array.length; i++) {
            sumR += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            sumL += array[i];
            sumR -= array[i];
            if (sumR == sumL) {
                return true;
            }
        }
        return false;
    }
    /*
    7. **** Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.
    */
    public static int[] lessonItem_7( int n,int[] array){
        if (n>0){
            for (int i = 0; i <n ; i++) {
                int tmp = 0;
                for (int j = array.length-1; j >=0; j--) {
                    if(j==array.length-1){
                        tmp=array[array.length-1];
                    }else{
                        array[j+1]=array[j];
                    }
                }
                array[0]=tmp;
            }
        }else{
            n*=-1;
            for (int i = 0; i <n ; i++) {
                int tmp = 0;
                for (int j = 0; j <array.length; j++) {
                    if(j==0){
                        tmp=array[j];
                    }else{
                        array[j-1]=array[j];
                    }
                }
                array[array.length-1]=tmp;
            }
        }
        return array;
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }
}
