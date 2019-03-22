package hospital;

import java.util.Scanner;

public class Patient
{
    String code;
    String note;
    String name;
    
    static void work(Patient[] p)
    {
        System.out.println("Обслуживание пациента");
        System.out.println("Если вы новый пользователь введите new иначе введите свой код");
        System.out.println("Для выхода введите exit");
        String answer;
        
        do
        {
            Scanner in = new Scanner(System.in);
            answer = in.nextLine();
            
            if("new".equals(answer))
            {
                Patient.registration(p);
            }
            else
            {
                for(int i = 0; i < p.length; ++i)
                {
                    if(p[i].code.equals(answer))
                    {
                        p[i].welcome();
                        break;
                    }
                }
            }
        }while(!"exit".equals(answer));
    }
    
    static void registration(Patient[] p)
    {
        int i = 0;
        while(p[i] != null)
        {
            ++i;
        }
        
        System.out.println("Регистрация");
        System.out.println("Введите своё имя");
        Scanner in = new Scanner(System.in);
        p[i].name = in.nextLine();
        
        System.out.println("Придумайте свой код");
        Scanner in2 = new Scanner(System.in);
        p[i].code = in2.nextLine();
    }
    
    void welcome()
    {
        
    }
    
}
