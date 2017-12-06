import java.util.*;

class tic_tac_toe
{
    public static void main(String sk[])
    {
        Scanner sc = new Scanner(System.in);

        char ar1[] = {' ',' ',' '};
        char ar2[] = {' ',' ',' '};
        char ar3[] = {' ',' ',' '};

        //char cross=(char)215; //215 is the ASCII code of cross
        //char ar1[] = {cross,cross,'0'};
        //char ar2[] = {cross,'0','0'};
        //char ar3[] = {'0',cross,cross};

        skeleton(ar1,ar2,ar3);
        int check=ask();

        if (check == 1)
        {
            System.out.println("\u000C");
            skeleton(ar1,ar2,ar3);
            play(ar1,ar2,ar3);
        }
        else if (check == -1)
        {
            System.out.println("\n\n\t\t\t\t\t GOODBYEEE!!!");
        }
    }

    static void play(char ar1[],char ar2[],char ar3[])
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        char cross=(char)215; //215 is the ASCII code of cross
        int u_col,u_row,c_col=-1,c_row=-1;
        String ch="";
        char user,comp;
        System.out.println("Choose your weapon :: "+cross+" or 0");

        for (;;)
        {
            System.out.println("Press 1 for "+cross+" and 0 for 0");
            ch=sc.next();
            if (ch.equals("1") || ch.equals("0"))
            {
                if(ch.equals("1"))
                {
                    comp='0';
                    user=cross;
                    break;
                }
                else
                {
                    comp=cross;
                    user='0';
                    break;
                }
            }
            System.out.println("Wrong Choice.\nPlease enter again.");
        }
        System.out.println("User : "+user+" Computer : "+comp);
        System.out.println("\t\t\t\t\tLET'S PLAY");
        try
        {
            Thread.sleep(1500);
        }
        catch(InterruptedException e)
        {
            System.out.println("Main Thread Interrupted!");
        }
        System.out.println("\u000C");
        skeleton(ar1,ar2,ar3);

        for (;;)
        {
            //user's turn
            System.out.println("Where do you want to put your "+user);
            for(;;)
            {
                for (;;)
                {
                    System.out.print("Enter row number : ");
                    u_row=sc.nextInt();
                    if(u_row>0 && u_row<4)
                    {
                        break;
                    }
                    System.out.println("Wrong Choice.\nPlease enter again.");
                }
                for (;;)
                {
                    System.out.print("Enter column number : ");
                    u_col=sc.nextInt();
                    if(u_col>0 && u_col<4)
                    {
                        break;
                    }
                    System.out.println("Wrong Choice.\nPlease enter again.");
                }
                if (u_row == 1)
                {
                    if (ar1[u_col-1] == ' ')
                    {
                        ar1[u_col-1]=user;
                        break;
                    }
                }
                else if (u_row == 2)
                {
                    if (ar2[u_col-1] == ' ')
                    {
                        ar2[u_col-1]=user;
                        break;
                    }
                }
                else if (u_row == 3)
                {
                    if (ar3[u_col-1] == ' ')
                    {
                        ar3[u_col-1]=user;
                        break;
                    }
                }
                System.out.println("Wrong Choice.\nPlease enter again.");
            }
            skeleton(ar1,ar2,ar3);
            if (check(user,comp,ar1,ar2,ar3) == 1)
            {
                quit(1);
                break;
            }
            else if (check(user,comp,ar1,ar2,ar3) == 0)
            {
                quit(0);
                break;
            }
            else if (check(user,comp,ar1,ar2,ar3) == -1 && isover(user,comp,ar1,ar2,ar3) == true)
            {
                quit(-1);
                break;
            }

            System.out.println("\n~~~~Computer's Turn~~~~\n");
            //computer's turn
            compturn(rand,comp,user,c_row,c_col,ar1,ar2,ar3);
            skeleton(ar1,ar2,ar3);
            check(user,comp,ar1,ar2,ar3);
            if (check(user,comp,ar1,ar2,ar3) == 1)
            {
                quit(1);
                break;
            }
            else if (check(user,comp,ar1,ar2,ar3) == 0)
            {
                quit(0);
                break;
            }
            else if (check(user,comp,ar1,ar2,ar3) == -1 && isover(user,comp,ar1,ar2,ar3) == true)
            {
                quit(-1);
                break;
            }

        }
    }

    static void compturn(Random rand,char comp,char user,int c_row,int c_col,char ar1[],char ar2[],char ar3[])
    {
        for(;;)
        {
            //comp favour
            //horizontal maching
            if (ar1[0] == ar1[1] && ar1[0] == comp && ar1[2] == ' ')
            {
                ar1[2]=comp;
                break;
            }
            else if (ar1[0] == ar1[2] && ar1[0] == comp && ar1[1] == ' ')
            {
                ar1[1]=comp;
                break;
            }
            else if (ar1[1] == ar1[2] && ar1[1] == comp && ar1[0] == ' ')
            {
                ar1[0]=comp;
                break;
            }
            else if (ar2[0] == ar2[1] && ar2[0] == comp && ar2[2] == ' ')
            { 
                ar2[2]=comp;
                break;
            }
            else if (ar2[0] == ar2[2] && ar2[0] == comp && ar2[1] == ' ')
            {
                ar2[1]=comp;
                break;
            }
            else if (ar2[1] == ar2[2] && ar2[1] == comp && ar2[0] == ' ')
            {
                ar2[0]=comp;
                break;
            }
            else if (ar3[0] == ar3[1] && ar3[0] == comp && ar3[2] == ' ')
            {
                ar3[2]=comp;
                break;
            }
            else if (ar3[0] == ar3[2] && ar3[0] == comp && ar3[1] == ' ')
            {
                ar3[1]=comp;
                break;
            }
            else if (ar3[1] == ar3[2] && ar3[1] == comp && ar3[0] == ' ')
            {
                ar3[0]=comp;
                break;
            }
            //diagonal maching
            else if (ar1[0] == ar2[1] && ar1[0] == comp && ar3[2] == ' ')
            {
                ar3[2]=comp;
                break;
            }
            else if (ar1[0] == ar3[2] && ar1[0] == comp && ar2[1] == ' ')
            {
                ar2[1]=comp;
                break;
            }
            else if (ar2[1] == ar3[2] && ar2[1] == comp && ar1[0] == ' ')
            {
                ar1[0]=comp;
                break;
            }
            else if (ar3[0] == ar2[1] && ar3[0] == comp && ar1[2] == ' ')
            {
                ar1[2]=comp;
                break;
            }
            else if (ar3[0] == ar1[2] && ar3[0] == comp && ar2[1] == ' ')
            {
                ar2[1]=comp;
                break;
            }
            else if (ar2[1] == ar1[2] && ar2[1] == comp && ar3[0] == ' ')
            {
                ar3[0]=comp;
                break;
            }
            //vertical maching
            else if (ar1[0] == ar2[0] && ar1[0] == comp && ar3[0] == ' ')
            {
                ar3[0]=comp;
                break;
            }
            else if (ar1[0] == ar3[0] && ar1[0] == comp && ar2[0] == ' ')
            {
                ar2[0]=comp;
                break;
            }
            else if (ar2[0] == ar3[0] && ar2[0] == comp && ar1[0] == ' ')
            {
                ar1[0]=comp;
                break;
            }
            else if (ar1[1] == ar2[1] && ar1[1] == comp && ar3[1] == ' ')
            {
                ar3[1]=comp;
                break;
            }
            else if (ar1[1] == ar3[1] && ar1[1] == comp && ar2[1] == ' ')
            {
                ar2[1]=comp;
                break;
            }
            else if (ar2[1] == ar3[1] && ar2[1] == comp && ar1[1] == ' ')
            {
                ar1[1]=comp;
                break;
            }
            else if (ar1[2] == ar2[2] && ar1[2] == comp && ar3[2] == ' ')
            {
                ar3[2]=comp;
                break;
            }
            else if (ar1[2] == ar3[2] && ar1[2] == comp && ar2[2] == ' ')
            {
                ar2[2]=comp;
                break;
            }
            else if (ar2[2] == ar3[2] && ar2[2] == comp && ar1[2] == ' ')
            {
                ar1[2]=comp;
                break;
            }
            
            
            //not comp favour
            //horizontal maching
            
            
            else if (ar1[0] == ar1[1] && ar1[0] == user && ar1[2] == ' ')
            {
                ar1[2]=comp;
                break;
            }
            else if (ar1[0] == ar1[2] && ar1[0] == user && ar1[1] == ' ')
            {
                ar1[1]=comp;
                break;
            }
            else if (ar1[1] == ar1[2] && ar1[1] == user && ar1[0] == ' ')
            {
                ar1[0]=comp;
                break;
            }
            else if (ar2[0] == ar2[1] && ar2[0] == user && ar2[2] == ' ')
            { 
                ar2[2]=comp;
                break;
            }
            else if (ar2[0] == ar2[2] && ar2[0] == user && ar2[1] == ' ')
            {
                ar2[1]=comp;
                break;
            }
            else if (ar2[1] == ar2[2] && ar2[1] == user && ar2[0] == ' ')
            {
                ar2[0]=comp;
                break;
            }
            else if (ar3[0] == ar3[1] && ar3[0] == user && ar3[2] == ' ')
            {
                ar3[2]=comp;
                break;
            }
            else if (ar3[0] == ar3[2] && ar3[0] == user && ar3[1] == ' ')
            {
                ar3[1]=comp;
                break;
            }
            else if (ar3[1] == ar3[2] && ar3[1] == user && ar3[0] == ' ')
            {
                ar3[0]=comp;
                break;
            }
            //diagonal maching
            else if (ar1[0] == ar2[1] && ar1[0] == user && ar3[2] == ' ')
            {
                ar3[2]=comp;
                break;
            }
            else if (ar1[0] == ar3[2] && ar1[0] == user && ar2[1] == ' ')
            {
                ar2[1]=comp;
                break;
            }
            else if (ar2[1] == ar3[2] && ar2[1] == user && ar1[0] == ' ')
            {
                ar1[0]=comp;
                break;
            }
            else if (ar3[0] == ar2[1] && ar3[0] == user && ar1[2] == ' ')
            {
                ar1[2]=comp;
                break;
            }
            else if (ar3[0] == ar1[2] && ar3[0] == user && ar2[1] == ' ')
            {
                ar2[1]=comp;
                break;
            }
            else if (ar2[1] == ar1[2] && ar2[1] == user && ar3[0] == ' ')
            {
                ar3[0]=comp;
                break;
            }
            //vertical maching
            else if (ar1[0] == ar2[0] && ar1[0] == user && ar3[0] == ' ')
            {
                ar3[0]=comp;
                break;
            }
            else if (ar1[0] == ar3[0] && ar1[0] == user && ar2[0] == ' ')
            {
                ar2[0]=comp;
                break;
            }
            else if (ar2[0] == ar3[0] && ar2[0] == user && ar1[0] == ' ')
            {
                ar1[0]=comp;
                break;
            }
            else if (ar1[1] == ar2[1] && ar1[1] == user && ar3[1] == ' ')
            {
                ar3[1]=comp;
                break;
            }
            else if (ar1[1] == ar3[1] && ar1[1] == user && ar2[1] == ' ')
            {
                ar2[1]=comp;
                break;
            }
            else if (ar2[1] == ar3[1] && ar2[1] == user && ar1[1] == ' ')
            {
                ar1[1]=comp;
                break;
            }
            else if (ar1[2] == ar2[2] && ar1[2] == user && ar3[2] == ' ')
            {
                ar3[2]=comp;
                break;
            }
            else if (ar1[2] == ar3[2] && ar1[2] == user && ar2[2] == ' ')
            {
                ar2[2]=comp;
                break;
            }
            else if (ar2[2] == ar3[2] && ar2[2] == user && ar1[2] == ' ')
            {
                ar1[2]=comp;
                break;
            }
            //let it guess
            else
            {
                for(;;)
                {
                    c_row=rand.nextInt(3)+1;
                    c_col=rand.nextInt(3)+1;
                    if (c_row == 1)
                    {
                        if (ar1[c_col-1] == ' ')
                        {
                            ar1[c_col-1]=comp;
                            break;
                        }
                    }
                    else if (c_row == 2)
                    {
                        if (ar2[c_col-1] == ' ')
                        {
                            ar2[c_col-1]=comp;
                            break;
                        }
                    }
                    else if (c_row == 3)
                    {
                        if (ar3[c_col-1] == ' ')
                        {
                            ar3[c_col-1]=comp;
                            break;
                        }
                    }
                }
                break;
            }
        }
        try
        {
            Thread.sleep(1500);
        }
        catch(InterruptedException e)
        {
            System.out.println("Main Thread Interrupted!");
        }
    }

    static int check(char user,char comp,char ar1[],char ar2[],char ar3[])
    {
        if (ar1[0] == ar1[1] && ar1[0] == ar1[2])
        {
            if (ar1[0] == user)
                return 1;
            else if (ar1[0] == comp)
                return 0;
            else
                return 2;
        }
        else if (ar2[0] == ar2[1] && ar2[0] == ar2[2])
        {
            if (ar2[0] == user)
                return 1;
            else if (ar2[0] == comp)
                return 0;
            else
                return 2;
        }
        else if (ar3[0] == ar3[1] && ar3[0] == ar3[2])
        {
            if (ar3[0] == user)
                return 1;
            else if (ar3[0] == comp)
                return 0;
            else
                return 2;
        }
        else if (ar1[0] == ar2[0] && ar1[0] == ar3[0])
        {
            if (ar1[0] == user)
                return 1;
            else if (ar1[0] == comp)
                return 0;
            else
                return 2;
        }
        else if (ar1[1] == ar2[1] && ar1[1] == ar3[1])
        {
            if (ar1[1] == user)
                return 1;
            else if (ar1[1] == comp)
                return 0;
            else
                return 2;
        }
        else if (ar1[2] == ar2[2] && ar1[2] == ar3[2])
        {
            if (ar1[2] == user)
                return 1;
            else if (ar1[2] == comp)
                return 0;
            else
                return 2;
        }
        else if(ar1[0] == ar2[1] && ar1[0] == ar3[2])
        {
            if (ar1[0] == user)
                return 1;
            else if (ar1[0] == comp)
                return 0;
            else
                return 2;
        }
        else if(ar1[2] == ar2[1] && ar1[2] == ar3[0])
        {
            if (ar1[2] == user)
                return 1;
            else if (ar1[2] == comp)
                return 0;
            else
                return 2;
        }
        else
        {
            return -1;
        }

    }

    static boolean isover(char user,char comp,char ar1[],char ar2[],char ar3[])
    {
        int i,c=0,d=0;
        for (i=0;i<3;i++)
        {
            if (ar1[i] == user || ar1[i] == comp)
                c++;
        }
        if (c == 3)
            d++;
        c=0;
        for (i=0;i<3;i++)
        {
            if (ar2[i] == user || ar2[i] == comp)
                c++;
        }
        if (c == 3)
            d++;
        c=0;
        for (i=0;i<3;i++)
        {
            if (ar3[i] == user || ar3[i] == comp)
                c++;
        }
        if (c == 3)
            d++;
        if (d == 3)
            return true;
        else
            return false;

    }

    static void quit(int x)
    {
        if (x == 1)
            System.out.println("CONGRATULATIONS!! YOU WON THE GAME!!");
        else if (x == 0)
            System.out.println("OOPS!! YOU LOST WHILE THE COMPUTER WON!!");
        else
            System.out.println("IT'S A DRAW!!");
    }

    static int ask()
    {
        Scanner sc = new Scanner(System.in);
        String ch;
        for(;;)
        {
            System.out.println("Do You Want to Play(Y/N) : ");
            ch=sc.next();
            if(ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("N"))
            {
                if(ch.equalsIgnoreCase("Y"))
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            System.out.println("\nYou Entered Wrong Choice!!\nPlease Enter Again");
        }
    }

    static void skeleton(char ar1[],char ar2[],char ar3[])
    {
        int i;

        System.out.println("\t\t\t\t\tTIC-TAC-TOE");
        System.out.println();
        System.out.print("\t\t\t\t\t ");
        for (i=0;i<2;i++)
        {
            System.out.print(ar1[i]+" | ");
        }
        System.out.println(ar1[i]);
        System.out.println("\t\t\t\t\t ---------");
        System.out.print("\t\t\t\t\t ");
        for (i=0;i<2;i++)
        {
            System.out.print(ar2[i]+" | ");
        }
        System.out.println(ar2[i]);
        System.out.println("\t\t\t\t\t ---------");
        System.out.print("\t\t\t\t\t ");
        for (i=0;i<2;i++)
        {
            System.out.print(ar3[i]+" | ");
        }
        System.out.println(ar3[i]);
    }
}