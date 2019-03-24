package hospital;

import java.util.Scanner;

public class Patient
{
    String code;
    String name;
    
    static void work(Patient[] p, Hospital hos)
    {
        
        String answer;
            
            System.out.println("Обслуживание пациента");
            do
            {
                System.out.println("Если вы новый пользователь введите new иначе введите свой код");
                System.out.println("Для выхода введите exit");
                Scanner in = new Scanner(System.in);
                answer = in.nextLine();
                if("new".equals(answer))
                {
                    Administrator.registration(p);
                }
                else if(!"exit".equals(answer))
                {
                    boolean find = false;
                    for(int i = 0; i < p.length; ++i)
                    {
                        if(p[i] != null && p[i].code.equals(answer))
                        {
                            p[i].welcome(hos);
                            find = true;
                        }    
                    
                    }
                    if(!find)
                    {
                        System.out.println("Мы ничего не нашли");
                        Administrator.registration(p);
                    }
                }
            }while(!"exit".equals(answer));
    }
    
    
    
    void welcome(Hospital hos)
    {
        System.out.println("Добро пожаловать " + this.name);
        String answer;
        do
        {
            System.out.println("Выберите врача:");
            Scanner in = new Scanner(System.in);
            answer = in.nextLine();
            switch(answer)
            {
                case "lor": Administrator.proverka(hos.lor, this); break;
                case "terapevt": Administrator.proverka(hos.terapevt, this); break;
                case "hirurg": Administrator.proverka(hos.hirurg, this); break;
                case "exit": break; 
                default:
                    System.out.println("Такого врача нет, выберите снова, если хотите выйти введите exit");
            }
        }while(!"exit".equals(answer));
    }
    
}
