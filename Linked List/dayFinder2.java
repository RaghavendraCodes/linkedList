import java.util.Scanner;

public class dayFinder2 {
    public static void main(String[] args) {
        int date, year;
        String days;  
        int y; 
        int c;
        double mod; 
        int dayNumber = 0;

        // scanner input from users for all the required variables. 
        try (
        Scanner sc = new Scanner(System.in)) {
            System.out.println("enter the date : ");
            date = sc.nextInt(); 
            System.out.println("enter the day : ");
            days = sc.next();
            System.out.println("enter the year : ");
            year = sc.nextInt();
        } 

        // to find the corresponding day number. 
        String[] weekdays = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"}; 
        for(int i=0; i<weekdays.length; i++){
            if(days.equals(weekdays[i])){
                dayNumber = i;
                System.out.println(dayNumber); 
                break; 
            }
        }

        String[] months = {"march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "january", "february"};

        for(int i=0; i<months.length; i++) {
            if(i <= 10) {
                y = year % 100; 
                System.out.println("modulo of year :" + y);
                c = (year - y)/100; 
                System.out.println("c : " + c);
                mod = (date + (Math.floor(2.6 * (i+1) - 0.2)) - 2*c + y + (Math.floor(c/4)) + (Math.floor(y/4))) % 7;
                System.out.println(mod);
                if(mod == dayNumber) {
                    System.out.println(months[i]);
                    break; 
                }
            } else {
                year--; 
                y = year % 100; 
                System.out.println("modulo of year :" + y);
                c = (year - y)/100; 
                System.out.println("c : " + c);
                mod = (date + (Math.floor(2.6 * (i+1) - 0.2)) - 2*c + y + (Math.floor(c/4)) + (Math.floor(y/4))) % 7;
                System.out.println(mod);
                if(mod == dayNumber) {
                    System.out.println(months[i]);
                    break;
            }
        }
    }
}
}
