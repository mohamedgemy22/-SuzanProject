package com.enggemy22.myapplication;

public class Uploads {
    private  String  mName;
    private  String mPhone;
    private  String mAdress;
    private  String mImage;

    public Uploads() {
    }

    public Uploads(String mName, String mPhone, String mAdress, String mImage) {
          if(mName.trim().equals("") && mPhone.trim().equals("")&& mAdress.trim().equals(""))
          {
           mName.equals("No name");
           mPhone.equals("No phone");
           mAdress.equals("No Adress");
          }else {
              this.mName = mName;
              this.mPhone = mPhone;
              this.mAdress = mAdress;
              this.mImage = mImage;
          }
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmAdress() {
        return mAdress;
    }

    public void setmAdress(String mAdress) {
        this.mAdress = mAdress;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
