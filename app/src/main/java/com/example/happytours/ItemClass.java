package com.example.happytours;

public class ItemClass {
        String colour,ID,status,model;
        int Iimage;

    public ItemClass(String colour, String ID, String status, String model, int iimage) {

        this.colour = colour;
        this.ID = ID;
        this.status = status;
        this.model = model;
        Iimage = iimage;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getIimage() {
        return Iimage;
    }

    public void setIimage(int iimage) {
        Iimage = iimage;
    }
}
