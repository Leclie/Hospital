package hospital;

import java.util.Scanner;

public class MainDoctor
{
    String code = "cerf742";
    String name = "Andrew";
    
    void work(Doctor lor, Doctor hirurg, Doctor terapevt)
    {
        System.out.println("Работа главного врача");
        String answer;
        do
            {
                System.out.println("Записи какого врача вы зотите посмотреть?");
                System.out.println("Для выхода введите exit");
                Scanner in = new Scanner(System.in);
                answer = in.nextLine();
                switch(answer)
                {
                    case "Sasha": lor.out(); break;
                    case "Artem": hirurg.out(); break;
                    case "Ilya": terapevt.out(); break;
                    case "all": lor.out(); hirurg.out(); terapevt.out(); break;
                    default:
                        System.out.println("Вы ввели неправильно"); break;
                }
            }while(!"exit".equals(answer));
    }
}
