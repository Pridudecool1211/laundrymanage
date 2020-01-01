package com.example.laundry_manage;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.io.Serializable;

public class LaundryItem implements Serializable {
    private int[] quantity= new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//change
    private int bill;
    private int statuscode;

    private String date;




    public LaundryItem( int[] qty,String date) {
        for(int i=0;i<qty.length;i++)//for date
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
        this.date=date;




    }

    public void calcbill(){

        bill=(quantity[0]+quantity[1]+quantity[3]+quantity[4]+quantity[5]+quantity[6]+quantity[8]+quantity[10]+quantity[15]+quantity[16])*10+(quantity[7]+quantity[13])*20+quantity[14]*30+quantity[12]*170+quantity[11]*50+quantity[2]*15+quantity[9]*7;

    }



    public String returndate()
    {
        return this.date;
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



