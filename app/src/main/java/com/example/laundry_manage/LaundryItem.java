package com.example.laundry_manage;
import java.io.Serializable;

public class LaundryItem implements Serializable {
    private int[] quantity= new int[]{0,0};
    private int bill;
    private int statuscode;

    public LaundryItem( int[] qty) {
        for(int i=0;i<qty.length;i++)
        {
            (this.quantity)[i]=qty[i];
            bill=0;
            calcbill();
            statuscode=0;
        }


    }

    public void calcbill(){

        for(int j=0;j<quantity.length;j++)
        {
            bill=bill+(10*quantity[j]);
        }

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



