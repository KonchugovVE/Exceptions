
public class DateException extends Exception {

    
    public DateException(){

    }


    public void dateDayException( ){
        System.out.println("Введено больше дней , чем возможно в этом месяце");
    }

    public void dateYaerException( ){
        System.out.println("Введен будущий год");
    }


    public void dateMnException() {
        System.out.println("Введеный месяц больше текущего");
    }


    public void invalidDateFormat() {
        System.out.println("Введеный формат даты, не соответсвует заданной");
    }
}
