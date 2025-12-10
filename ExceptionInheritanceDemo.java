import java.util.Scanner;
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}


class Father {
    int fatherAge;

    
    public Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        this.fatherAge = age;
    }
}


class Son extends Father {
    int sonAge;

    
    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge); // Call Father constructor

        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative!");
        }

        if (sonAge >= super.fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to Father's age!");
        }

        this.sonAge = sonAge;
    }
}


public class ExceptionInheritanceDemo {
    public static void main(String[] args) {
        int fage, sage;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter father'sage: ");
        fage=sc.nextInt();
        System.out.println("Enter Son's age: ");
        sage=sc.nextInt();
        try {
            Son s=new Son(fage,sage);
        }
        catch(WrongAge e){
            System.out.println("Exception caught "+e.getMessage());
        }
        try {
            Father s=new Father(fage);
        }
        catch(WrongAge a){
            System.out.println("Exception caught "+a.getMessage());
        }
    }
}