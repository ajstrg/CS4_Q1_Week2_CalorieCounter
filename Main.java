import java.util.Scanner;
import java.util.HashMap;


class Exercise {

  int day;
  float hours;
  String type;
  
  static HashMap<String, Integer> calorie_burn = new HashMap<String, Integer>();

  public static boolean check_activity(String a) {

    calorie_burn.put("cycle", 700);
    calorie_burn.put("walk", 300);
    calorie_burn.put("swim", 550);

    if (calorie_burn.containsKey(a)) {

      return true;

    } else {

      return false;

    }

  }


  public static boolean check_duration(float hours) {

    if (hours > 0 && hours <= 24) {

      return true;

    } else {

      return false;

    }

  }


  public static int get_calories(String activity) {

    return calorie_burn.get(activity);

  }

}


class Person {

  String name;
  int day_num = 0;
  float weekly_kcal = 0;


  public Person(String n) {

    name = n;

  }


  public void log_weekly_exercise() {

    ////// CHANGE THE CODE BELOW TO SOLVE THE PROBLEM

    boolean restart_application = true;
    Scanner input = new Scanner(System.in);
    
    do {
        
      String ans;
      float hours;
      
      System.out.println("");
      System.out.println("Day " + (day_num + 1) + ": ");
  
  
      System.out.print("What will you do today? ");
  
      String activity = input.nextLine();
  
      boolean valid = Exercise.check_activity(activity);
  
      if (valid) {
  
        System.out.print("For how many hours will you " + activity + "? ");
        hours = input.nextFloat();
        input.nextLine();
  
        valid = Exercise.check_duration(hours);
  
  
        if (valid) {
  
          float calories = Exercise.get_calories(activity) * hours;
          weekly_kcal += calories;
          System.out.println("You burned " + calories + " kcal.");
          System.out.println("");
  
        }
        
        else {
  
          System.out.println("Invalid input.");
          System.out.println("");
  
        }
  
  
      }
      
      else {
  
        System.out.println("Invalid input.");
        System.out.println("");
  
      }
  
      day_num++;
      
  
      if (day_num == 7) { // day7
  
        System.out.println("Total calories burned this week: " + weekly_kcal + " kcal");
  
        // reset the array
  
        day_num = 0;
        weekly_kcal = 0;
  
        System.out.print("Restart application? (yes/no): ");
        ans = input.nextLine();
        boolean isYes = ans.contains("no");
  
        if (isYes)
        {
          restart_application = false;
        }
  
      }
  
  
      /////// CHANGE THE CODE ABOVE TO SOLVE THE PROBLEM
  
  
    } while (restart_application == true);
  }

}

class Main {

  public static void main(String[] args) {

    Person p = new Person("Mike");

    p.log_weekly_exercise();

  }

}
