package com.ks.recyclerbindingexample.models;


/**
 * Created by KHEMRAJ on 10/22/2018.
 */
public class ModelChild extends BaseModel {
    private String name;

    public ModelChild(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
