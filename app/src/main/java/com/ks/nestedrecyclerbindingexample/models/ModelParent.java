package com.ks.nestedrecyclerbindingexample.models;

import java.util.List;

/**
 * Created by KHEMRAJ on 10/22/2018.
 */
public class ModelParent extends BaseModel {
    private String parentName;
    private List<ModelChild> children;
    public ModelParent(String day, List<ModelChild> children) {
        this.parentName = day;
        this.children = children;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<ModelChild> getChildren() {
        return children;
    }

    public void setChildren(List<ModelChild> children) {
        this.children = children;
    }

}
