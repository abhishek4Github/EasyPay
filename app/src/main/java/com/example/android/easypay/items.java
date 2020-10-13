package com.example.android.easypay;

public class items {

   // String id;
    String name;
    String weight;
    String cost;

    public items(){

    }

    public items(String name, String weight, String cost) {
        //this.id = id;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

   // public String getid() {
     //   return id;
    //}

    public String getname() {
        return name;
    }

    public String getweight() {
        return weight;
    }

    public String getcost() {
        return cost;
    }

    //public void setId(String id) {
      //  this.id = id;
    //}

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
