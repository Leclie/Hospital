package hospital;

import java.util.Scanner;

public class Hospital
{
    Doctor lor;
    Doctor hirurg;
    Doctor terapevt;
    MainDoctor mainDoc;
    Patient[] p;
    
    void open(Hospital hos)
    {
        this.mainDoc = new MainDoctor();
        this.lor = new Doctor("Sasha","sasha742");
        this.hirurg = new Doctor("Artem","artem742");
        this.terapevt = new Doctor("Ilya","ilya742");
        this.p = new Patient[15];
        
        String answer;
        do
        {
            System.out.println("1. main doctor");
            System.out.println("2. doctor");
            System.out.println("3. patient");
            System.out.println("4. exit");
            System.out.println("Ваш ответ:");
            
            Scanner in = new Scanner(System.in);
            answer = in.nextLine();
        
            switch(answer)
            {
                case "main doctor":
                    mainDoc.work(lor, hirurg, terapevt); break;
                case "doctor":
                    Doctor.work(lor, hirurg, terapevt); break;
                case "patient":
                    Patient.work(p, hos); break;
                default:
                    answer = "exit"; break;
            }
        }while(!"exit".equals(answer));
        System.out.println("Прощайте");
    }
}
