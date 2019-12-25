package com.example.laundry_manage;
import java.io.Serializable;

public class LaundryItem implements Serializable {
    private int[] quantity= new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int bill;
    private int statuscode;

    public LaundryItem( int[] qty) {
        for(int i=0;i<qty.length;i++)
        {
            if(qty[i]!=0) {
                (this.quantity)[i] = qty[i];
            }
            else
            {
                (this.quantity)[i] = 0;
            }
        }
        statuscode = 0;
        bill = 0;
        calcbill();


    }

    public void calcbill(){

        bill=(quantity[0]+quantity[1]+quantity[3]+quantity[4]+quantity[5]+quantity[6]+quantity[8]+quantity[10]+quantity[15]+quantity[16])*10+(quantity[7]+quantity[13])*20+quantity[14]*30+quantity[12]*170+quantity[11]*50+quantity[2]*15+quantity[9]*7;

    }





public int returnbill()
{
    return bill;
}




    public int[] getquantity() {
        return quantity;
    }

    public void setstatuscode(int val)
    {
        statuscode=val;
    }
    public int getstatuscode(){
        return statuscode;
    }


  //  public void setquantity(int price) {
        //this.quantity = quantity;
   // }
}



