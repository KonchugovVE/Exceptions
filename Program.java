import java.util.Scanner;

public class Program {
    Scanner scanner;

    String person;

    boolean flag;

    SaveFile sF;

    Verification verification;

    public Program (){
        scanner = new Scanner(System.in);
        flag = false;
        sF = new SaveFile();
        verification = new Verification();

    }

    public String enterAString() {

        System.out.println("Введите: Фамилия Имя Отчество дата рождения(формата dd.mm.yyyy)");
        System.out.println(
                "номертелефона(целое беззнаковое число без форматирования) пол(символ латиницей f(женский) или m(мужской))");
        System.out.println("Данные вводите через пробел");

        person = scanner.nextLine();
        return person;
    }

    

    public void work() {

        while (flag!= true) {
            person = enterAString();
            if (verification.inputCheck(verification.inputValidation(person), person)) {
                flag = sF.saveFile(person);
            }
        }

    }

}
