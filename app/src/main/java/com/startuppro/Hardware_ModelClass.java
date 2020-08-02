package com.startuppro;

public class Hardware_ModelClass {
    String Hardware_name;
    int Hardware_img;



    public Hardware_ModelClass(String hardware_name, int hardware_img) {
        Hardware_name = hardware_name;
        Hardware_img = hardware_img;
    }

    public String getHardware_name() {
        return Hardware_name;
    }

    public void setHardware_name(String hardware_name) {
        Hardware_name = hardware_name;
    }

    public int getHardware_img() {
        return Hardware_img;
    }

    public void setHardware_img(int hardware_img) {
        Hardware_img = hardware_img;
    }
}
