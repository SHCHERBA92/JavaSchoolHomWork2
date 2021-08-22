package WorkWithFile;

import java.io.*;
import java.util.*;

public class MainFile {
    public static void main(String[] args) {
    final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        final String RESET = "\033[0m";  // Text Reset

        /**
         * Считал текст из файла
         * */
        GetText getText = new GetText("./text.txt");
        StringBuilder text = getText.getText();

        /////////////////////////////////////////////////////
        //////////////////////////////////////////
        /////////////////////////////////////////

        /**
         * Конвертирую текст в список стрингов
         * */

        String textSingle = text.toString();
        // Разбиваю по символу пробела

        textSingle = textSingle.replace(","," ");
        textSingle = textSingle.replace(";"," ");
        textSingle = textSingle.replace("!"," ");
        textSingle = textSingle.replace("."," ");
        textSingle = textSingle.replace("?"," ");
        textSingle = textSingle.replace("..."," ");

        System.out.println("====================");
        System.out.println("====================");
        System.out.println("====================");

        System.out.println(GREEN_BOLD_BRIGHT + textSingle);

        System.out.println("====================");
        System.out.println("====================");
        System.out.println("====================");

        List<String> stringsLine = new ArrayList<>(Arrays.asList(textSingle.split(" ")));
        // убираю
        for (int i = 0; i < stringsLine.size(); i++)
        {
            stringsLine.set(i,stringsLine.get(i).toLowerCase());
            stringsLine.set(i,stringsLine.get(i).trim());
            stringsLine.remove(" ");
            stringsLine.remove("");
        }

        System.out.println(RED_BACKGROUND_BRIGHT + "\t\t\t Список из слов текста".toUpperCase());
        System.out.println(RESET);
        Iterator<String> stringIterator = stringsLine.iterator();
        while (stringIterator.hasNext())
        {
            System.out.println(stringIterator.next().toString());
        }

        Set<String> stringSet = new LinkedHashSet<>(stringsLine);

        System.out.println("Количество слов в файле : " + stringsLine.size());
        //stringSet.forEach(System.out::println);   - вывод различныйх слов
        System.out.println( "Количество различных слов в файле : " + stringSet.size());

        System.out.println("==============================");
        System.out.println("==============================");
        System.out.println("==============================");

        stringSet = new TreeSet<String>(stringSet);

        for (int j = 0; j < stringsLine.size(); j++)
        {
            System.out.println( "Слово " + "\"" + stringsLine.get(j)+ "\"" + " встречается " + " = "
                    + GREEN_BOLD_BRIGHT + Collections.frequency(stringsLine,stringsLine.get(j)) + " раз" + RESET);
        }


        /***
         * Отсортированный список по количеству букв в слове и по алфавиту
         */

        System.out.println( RED_BACKGROUND_BRIGHT + "\t\t\tОтсортированный список по количеству букв в слове и по алфавиту".toUpperCase());
        System.out.println(RESET);

        stringsLine = new LinkedList<String>(stringSet);

        //Collections.sort(stringsLine,new ClassForComparbleToSize());

        List<String> soertedList = stringsLine.stream().sorted((o1, o2) -> {
            if (o1.length() == o2.length())
            {
                return o1.compareTo(o2);
            }
            else if(o1.length() > o2.length())
            {
                return 1;
            }
            else {return -1;}
        }).toList();

        soertedList.forEach(System.out::println);

        /***
         * Инвертируем список и выведим его
         */

        System.out.println( "\n" + RED_BACKGROUND_BRIGHT + "\t\t\tВыведите на экран все строки файла в обратном порядке" + RESET);

        List<String> stringListFraza = new ArrayList<>(Arrays.asList(text.toString().split("\n"))) ;
        Collections.reverse(stringListFraza);
        stringListFraza.forEach(System.out::println);

        /***
         * Создали свой итератор в классе Iter который выводит список в обратном направлении
         * в качестве коллекции взяли коллекцию выше, которая уже была инвертированна.
         */
        System.out.println("\n" + RED_BACKGROUND_BRIGHT + "\t\t\tРеализуйте свой Iterator для обхода списка в обратном порядке" + RESET);

        Iter myIterator = new Iter(stringListFraza);
        while (myIterator.hasNext())
        {
            System.out.println(myIterator.next());
        }


        /***
         * Возьмем старый указатель и переназначем его на новый экземпляр коллекции
         */
        stringListFraza = new ArrayList<>(Arrays.asList(text.toString().split("\n"))) ;

        System.out.println("\n" + RED_BACKGROUND_BRIGHT + "\t\t\tВыведите на экран строки, номера которых задаются пользователем в произвольном порядке" + RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер строки : ");
        String numberLine = "";// = scanner.nextLine();

        while (!(numberLine.equals("STOP")))    // Пока пользователь не напишет слово STOP
        {
            numberLine = scanner.nextLine();
            try {
                if ((Integer.parseInt(numberLine) >= 0) && (Integer.parseInt(numberLine) < stringListFraza.size()))
                {
                    System.out.println(stringListFraza.get(Integer.parseInt(numberLine)));
                }
                else {
                    System.out.println("Введите число от 0 до " + (stringListFraza.size()-1));
                }
            }catch (NumberFormatException numberFormatException)
            {
                System.err.print("Введите число от 0 до " + (stringListFraza.size()-1) + " : ");
                continue;
            }

            System.out.print("Введите номер строки : ");


        }

    }
}
