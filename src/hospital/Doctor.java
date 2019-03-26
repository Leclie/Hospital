package hospital;

import java.util.Scanner;

public class Doctor
{
   String name;
   String code;
   String[] note = new String[10];
    
   
   public Doctor(String name, String code)
   {
       this.name = name;
       this.code = code;
   }
    static void work(Doctor lor, Doctor hirurg, Doctor terapevt)
    {
        System.out.println("Ваши записи");
        String answer;
        do
            {
                System.out.println("Введите свой код");
                System.out.println("Для выхода введите exit");
                Scanner in = new Scanner(System.in);
                answer = in.nextLine();
                switch(answer)
                {
                    case "sasha742": lor.out(); break;
                    case "artem742": hirurg.out(); break;
                    case "ilya742": terapevt.out(); break;
                    default:
                        System.out.println("Вы ввели неправильно");
                }
            }while(!"exit".equals(answer));
    }
    
    public void out()
    {
        int i = 0;
        System.out.println(this.name + ":");
        if(note[i] == null)
        {
            System.out.println("Нет записей");
        }
            while(note[i] != null)
        {
            System.out.println(note[i]);
            ++i;
        }
    }
}
