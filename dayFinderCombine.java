import java.util.Scanner;

public class dayFinderCombine {
    public static void main(String[] args) {
        
        // declaration anf initialization of variables.
        int n; 
        int date, year;
        String month; 
        double day;  
        String days;
        int y; 
        int c;
        double mod; 
        int monthNumber = 0;
        int dayNumber = 0;
        String[] months = {"march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "january", "february"};
        String[] weekdays = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"}; 


        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("enter 1 : to find day of a particular date of an year \nenter 2 : to find if a date present in that day of an year"); 
            n = sc.nextInt(); 

            switch (n) {

                case 1:

                // scanner input from users for all the required variables. 
                System.out.println("enter the date : ");
                date = sc.nextInt(); 
                System.out.println("enter the month : ");
                month = sc.next();
                System.out.println("enter the year : ");
                year = sc.nextInt();

                // finds out the corresponding month number using months array. 
                for(int i=0; i<months.length; i++){
                    if(month.equals(months[i])){
                        monthNumber = i+1; 
                    }
                }

                // if monthnumber > 10 then the previous year is considered for the further process. 
                if(monthNumber >= 10){
                    year--; 
                }
            
                // main modulo algorithm. 
                y = year%100; 
                c = (year - y)/100; 
                day = (date + (Math.floor(2.6 * monthNumber - 0.2)) - 2*c + y + (Math.floor(c/4)) + (Math.floor(y/4))) % 7; 
                
                // comparing the number you got in day and comparing it with weekdays[i] and return the weekday. 
                for(int j=0; j<weekdays.length; j++){
                    if(day == j) {
                        System.out.println("the day at which " + date + " /" + month + " /" + year + " is " + weekdays[j]);
                    }
                }
                break;
            
                case 2: 

                // scanner input from users for all the required variables.
                System.out.println("enter the date : ");
                date = sc.nextInt(); 
                System.out.println("enter the day : ");
                days = sc.next();
                System.out.println("enter the year : ");
                year = sc.nextInt();

                // to find the corresponding day number. 
                for(int i=0; i<weekdays.length; i++){
                    if(days.equals(weekdays[i])){
                        dayNumber = i;
                        System.out.println(dayNumber); 
                        break; 
                    }
                }

                // runs through the months array and finds out the month which satisfies the modulo equation.  
                for(int i=0; i<months.length; i++) {

                    // since the array starts from march. this if condition runs only till the loop reaches 10th element of the array. 
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

                    } 
                    
                    // this else condition is executed when the loop enters the 11th and above element. 
                    else {
                        year--; 
                        y = year % 100; 
                        c = (year - y)/100; 
                        mod = (date + (Math.floor(2.6 * (i+1) - 0.2)) - 2*c + y + (Math.floor(c/4)) + (Math.floor(y/4))) % 7;
                        if(mod == dayNumber) {
                            System.out.println(months[i]);
                            break;
                        }
                    }
                }
                break; 

                default: System.out.println("wrong input!");
                break;
            }
        }
    }
}
