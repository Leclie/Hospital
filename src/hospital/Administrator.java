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
           ++i;
       }
       String answer;
       do
       {
           
           System.out.println("Введите дату в формате ГГ.ММ.ДД ЧЧ:ММ");
           Scanner in3 = new Scanner(System.in); 
           answer = in3.nextLine();
           
           if(Integer.parseInt(answer.substring(9, 11)) > 20 || Integer.parseInt(answer.substring(9, 11)) < 8)
           {
               System.out.println("В это время больница закрыта!");
               return;
           }
           
           
           boolean spasenie = false;
           i = 0;
           System.out.println("Проверка записей");
           while(doc.note[i] != null && !"exit".equals(answer))
           {
               if(answer.startsWith(doc.note[i].substring(0, 8)))
             { if(Math.abs(Integer.parseInt(doc.note[i].substring(9, 11)) - Integer.parseInt(answer.substring(9, 11))) == 1)
               {
                   if(Math.abs(Integer.parseInt(answer.substring(12)) - Integer.parseInt(doc.note[i].substring(12, 14))) > 30)
                   {
                       spasenie = true;
                   }
               }
               else if(Integer.parseInt(doc.note[i].substring(9, 11)) == Integer.parseInt(answer.substring(9, 11)))
               {
                   if(Math.abs(Integer.parseInt(answer.substring(12)) - Integer.parseInt(doc.note[i].substring(12, 14))) < 30 )
                   {
                       spasenie = true;
                   }
               }
             }
             ++i;
           }
           if(doc.note[0] == null && !"exit".equals(answer)) {System.out.println("Это время свободно"); input(answer, doc, p); return;}
           if(!spasenie)
           {
               System.out.println("Это время свободно");
               input(answer, doc, p); 
               return;
           }
           else
           {
               System.out.println("Это время занято");
           }
       }while(!"exit".equals(answer));
   }
   
   public static void input(String answer, Doctor doc, Patient p)
   {
       System.out.println("Производится запись");
       int i = 0;
       while(doc.note[i] != null)
       {
           ++i;
       }
       doc.note[i] = answer + " " + p.name;
   }
}
