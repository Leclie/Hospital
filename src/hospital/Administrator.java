package hospital;

import java.util.Scanner;

public class Administrator
{
    static void registration(Patient[] p)
    {
        int i = 0;
        while(p[i] != null)
        {
            ++i;
        }
        p[i] = new Patient();
        System.out.println("Регистрация");
        System.out.println("Введите своё имя");
        Scanner in = new Scanner(System.in);
        p[i].name = in.nextLine();
        
        System.out.println("Придумайте свой код");
        Scanner in2 = new Scanner(System.in);
        p[i].code = in2.nextLine();
    }
    
   static void proverka(Doctor doc, Patient p)
   {
       int i = 0;
       while(doc.note[i] != null)
       {
           if(doc.note[i].endsWith(p.name))
           {
               System.out.println("У вас уже есть запись к этому врачу");
               return;
           }
       }
       String answer;
       boolean a = false;
       do
       {
           
           System.out.println("Введите дату в формате ГГ.ММ.ДД ЧЧ:ММ");
           Scanner in = new Scanner(System.in); 
           answer = in.nextLine();
           i = 0;
           while(doc.note[i] != null)
           {
             if(answer.startsWith(doc.note[i].substring(0, 8)))
             { if(Integer.parseInt(doc.note[i].substring(9, 11)) - Integer.parseInt(answer.substring(9, 11)) == 1)
               {
                   if(Integer.parseInt(answer.substring(12)) > 30)
                   {
                       System.out.println("Это время занято");
                   }
                   else
                   {
                       input(answer, doc, p);
                       a = true;
                   }
               }
               else if(Integer.parseInt(doc.note[i].substring(9, 11)) == Integer.parseInt(answer.substring(9, 11)))
               {
                   if(Integer.parseInt(answer.substring(12)) < 30 )
                   {
                       System.out.println("Это время занято");
                   }
                   else
                   {
                       input(answer, doc, p);
                       a = true;
                   }
               }
               else
               {
                       input(answer, doc, p);
                       a = true;
               }
             }
             else{input(answer, doc, p); a = true;}
             ++i;
           }
           
       }while(a == false);
   }
   
   public static void input(String answer, Doctor doc, Patient p)
   {
       System.out.println("Производится запись");
       int i = 0;
       while(doc.note[i] != null)
       {
           ++i;
       }
       doc.note[i] = answer + p.name;
   }
}
