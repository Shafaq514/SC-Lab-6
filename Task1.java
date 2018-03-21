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
public class Task1 {
    private String[][] data;
    Task1()
    {
        data=new String[6][3];
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++){
                data[i][j]=null;
            }
        }
    }
    public Float print(){
        Float min=4.0f,max=0.0f,sum=0.0f;
        for(int i=0;i<6;i++){
            System.out.println("Name: "+data[i][0]+", Reg. No.: "+data[i][1]+", CGPA:"+data[i][2]+"\n");
            if(min>Float.parseFloat(data[i][2]))
            {
                min=Float.parseFloat(data[i][2]);
            }
            if(max<Float.parseFloat(data[i][2]))
            {
                max=Float.parseFloat(data[i][2]);
            }
            sum=sum+Float.parseFloat(data[i][2]);
        }
        System.out.println("Minimum CGPA: "+min+", Maximum CGPA: "+max+", Average CGPA: "+sum/6+"\n");
        return sum/6;
    }
    public void fill()
    {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<6;i++){
            System.out.println("Enter Student's name:");
            data[i][0]=sc.next();
            do{
            System.out.println("Enter Student's Registration Number:");
            data[i][1]=sc.next();
            }while((CheckDuplicate(data[i][1],i)));
            do{
            System.out.println("Enter Student's CGPA:");
            data[i][2]=sc.next();
            }while(!(validateCGPA(data[i][2])));
        }
    }
    private boolean validateCGPA(String cgpa){
        Float c=Float.parseFloat(cgpa);
        boolean result=false;
        if(c>=0.00&&c<=4.00)
            result=true;
        return result;
    }
    private boolean CheckDuplicate(String reg,int row)
    {
        boolean result=false;
        int r=Integer.parseInt(reg);
        for(int i=0;i<row;i++)
        {
            int r1=Integer.parseInt(data[i][1]);
            if(r1==r)
            {
                result=true;
            }
            }
        return result;
    }
    public void printLess(Float avg)
    {
        for(int i=0;i<6;i++)
        {
            if(Float.parseFloat(data[i][2])<avg)
            {
                System.out.println("Name: "+data[i][0]+"\n");
            }
        }
    }
    public boolean validateName(String name)
    {
        boolean res=false;
        for(int i=0;i<6;i++)
        {
            if(name.equals(data[i][0]))
            {
                res=true;
                System.out.println("Student's CGPA is: "+data[i][2]+" and rank is: "+CalculateRank(Float.parseFloat(data[i][2]))+"out of 6\n");
                break;
            }
        }
        if(res==false){
            res=validateReg(name);
        }
        return res;
    }
    public boolean validateReg(String re)
    {
        int reg=0;
        boolean res=false;
        try{
        reg=Integer.parseInt(re);}
        catch(Exception ex){
            return res;
        }
        for(int i=0;i<6;i++)
        {
            if(reg==Integer.parseInt(data[i][1]))
            {
                res=true;
                System.out.println("Student's CGPA is: "+data[i][2]+" and rank is: "+CalculateRank(Float.parseFloat(data[i][2]))+"out of 6\n");
                break;
            }
        }
        return res;
    }
    private int CalculateRank(Float cgpa){
        int rank=1;
        for(int i=0;i<6;i++)
        {
            if(cgpa<Float.parseFloat(data[i][2]))
            {
                rank=rank+1;
            }
        }
        return rank;
    }
}
