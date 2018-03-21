/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sclab6;
import java.util.Scanner;
/**
 *
 * @author hyousaf.bese15seecs
 */
public class SCLab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Task1 t1=new Task1();
        t1.fill();
        Float avg=t1.print();
        t1.printLess(avg);
        Scanner sc=new Scanner(System.in);
        int search=1;
        boolean loop=true;
        do
        {
            System.out.println("Do You want to search? Enter 1 for yes and 0 for no;");
            search=sc.nextInt();
            if(search==1)
            {
                loop=true;
                System.out.println("Enter Student's name or registration number");
                String n=sc.next();
                if(t1.validateName(n))
                {
                    
                }
                else
                {
                    System.out.println("Student Does not exists");
            }}
                else
                {
                        loop=false;
                        }
            }while(loop);
    }
    
}
