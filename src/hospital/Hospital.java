package hospital;

import java.util.Scanner;

public class Hospital
{
    Administrator admin;
    Doctor doc;
    MainDoctor mainDoc;
    Patient[] p;
    
    void open()
    {
        this.mainDoc = new MainDoctor();
        this.doc = new Doctor();
        this.admin = new Administrator();
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
            answer= in.nextLine();
        
            switch(answer)
            {
                case "main doctor":
                    mainDoc.work(); break;
                case "doctor":
                    doc.work(); break;
                case "patient":
                    Patient.work(p); break;
                default:
                    answer = "exit"; break;
            }
        }while(!"exit".equals(answer));
        System.out.println("Прощайте");
    }
}
