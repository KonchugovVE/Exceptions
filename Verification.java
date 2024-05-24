import java.time.LocalDate;
import java.util.FormatterClosedException;
import java.util.zip.DataFormatException;





public class Verification {

    int codeError;



    public Verification() {
        codeError = 3;
    }

    private Integer zeroAtTheBeginning(String num){
        System.out.println(num);
        if(num.indexOf(0)==0){
            int number = Integer.parseInt(String.valueOf(num.charAt(1)));
            return number;
        }else{
            int number = Integer.parseInt(num);
            return number;
        }

        

    }

    private boolean isNumeric(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean inputValidation(String person) {
        String[] pers = person.split(" ");

        if (pers.length > 6) {
            codeError = 1;
        } else if (pers.length < 6) {
            codeError = 2;
        } else {
            codeError = 0;
        }

        if (codeError == 1) {
            System.out.println("Вы ввели больше значений чем нужно. Повторите ввод");
            return false;
        } else if (codeError == 2) {
            System.out.println("Вы ввели меньше значений чем нужно. Повторите ввод");
            return false;
        }

        return true;

    }



    public boolean inputCheck(boolean bool, String person) {
        if (bool) {
            String[] pers = person.split(" ");

            if (isNumeric(pers[0]) && isNumeric(pers[1]) && isNumeric(pers[2])) {
                try {
                    throw new FormatterClosedException();
                } catch (FormatterClosedException e) {
                    System.out.println("Ввод данных Ф.И.О не корректны, попробуйте снова");

                }
                return false;
            }
            if ((pers[3]).matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                
                String[] date = pers[3].split("\\.");
                
                int day = zeroAtTheBeginning(date[0]);
                int mn = zeroAtTheBeginning(date[1]);
                int yaer = Integer.parseInt(date[2]);
                int daysInAMonth = 0;
                LocalDate currentDate = LocalDate.now();

                if (yaer % 4 == 0 && mn == 2) {
                    daysInAMonth = 29;
                } else if (yaer % 4 != 0 && mn == 2) {
                    daysInAMonth = 28;
                } else if (mn < 8 && mn % 2 != 0 && mn != 2) {
                    daysInAMonth = 31;
                } else if (mn > 7 && mn < 12 && mn != 2 && mn % 2 == 0) {
                    daysInAMonth = 31;
                } else {
                    daysInAMonth = 30;
                }

                if (yaer > currentDate.getYear()) {
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dateYaerException();
                    }
                    return false;
                } else if (yaer == currentDate.getYear() && mn > currentDate.getMonthValue()) {
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dateMnException();
                    }
                    return false;
                } else if (day > daysInAMonth ||yaer == currentDate.getYear() && mn == currentDate.getMonthValue() && day > currentDate.getDayOfMonth()) {
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dateDayException();
                    }
                    return false;
                }}else{
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                         e.invalidDateFormat();
                    }
                    return false;
                }
            if (isNumeric(pers[4]) != true) {
                try {
                    throw new DataFormatException();
                } catch (DataFormatException e) {
                    System.out.println("Номер телефона должен содержать цифры");
                }
                return false;
                }
            
            if (pers[5].length() != 1) {
                try {
                    throw new GenderException();
                } catch (GenderException e) {
                    e.genderException();
                    System.out.println("упс");
                }
                return false;
            } else if (pers[5].matches("[f,m]+") != true ) {
                try {
                    throw new GenderException();
                } catch (GenderException e) {
                    e.genderException();
                }
                return false;
            }

            }else {
            return false;
        }
        return true;
    }

}
