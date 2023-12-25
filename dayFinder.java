import java.util.Scanner; 
public class dayFinder {
    public static void main(String[] args) {

        // declaration anf initialization of variables.
        int date, year;
        String month; 
        double day;  
        int y; 
        int c;
        int monthNumber = 0;

        try (// scanner input from users for all the required variables. 
        Scanner sc = new Scanner(System.in)) {
            System.out.println("enter the date : ");
            date = sc.nextInt(); 
            System.out.println("enter the month : ");
            month = sc.next();
            System.out.println("enter the year : ");
            year = sc.nextInt();
        } 
        // a string array of all the months starting from march as 1st month. 
        String[] months = {"march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "january", "february"};
        for(int i=0; i<months.length; i++){
            if(month.equals(months[i])){
                monthNumber = i+1; 
            }
        }
        System.out.println(monthNumber);

        // if monthnumber > 10 then the previous year is considered for the further process. 
        if(monthNumber >= 10){
            year--; 
        }
        
        // main modulo algorithm. 
        y = year%100; 
        System.out.println("modulo of year :" + y);
        c = (year - y)/100; 
        System.out.println("c : " + c);
        day = (date + (Math.floor(2.6 * monthNumber - 0.2)) - 2*c + y + (Math.floor(c/4)) + (Math.floor(y/4))) % 7; 
        System.out.println(day);

        // comparing the number you got in day and comparing it with weekdays[i] and return the weekday. 
        String[] weekdays = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"}; 
        for(int j=0; j<weekdays.length; j++){
            if(day == j) {
                System.out.println("" + weekdays[j]);
            }
        }
    }
}
 