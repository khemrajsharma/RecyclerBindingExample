package com.ks.recyclerbindingexample.multipleListExample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ks.recyclerbindingexample.R;
import com.ks.recyclerbindingexample.callbacks.OnItemClickListener;
import com.ks.recyclerbindingexample.data.NameGenerator;
import com.ks.recyclerbindingexample.databinding.ActivityMultipleListBinding;
import com.ks.recyclerbindingexample.models.ModelChild;
import com.ks.recyclerbindingexample.models.ModelParent;

import java.util.ArrayList;
import java.util.List;

public class MultipleListActivity extends AppCompatActivity {
    ActivityMultipleListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_multiple_list);
        binding.setListParent(getParentList());
        binding.setListChild(getChildrenList());
        binding.setOnItemClickParent(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object object) {
                if (object instanceof ModelParent) {
                    ModelParent parent = (ModelParent) object;
                    Toast.makeText(MultipleListActivity.this, parent.getParentName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.setOnItemClickChild(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object object) {
                if (object instanceof ModelChild) {
                    ModelChild child = (ModelChild) object;
                    Toast.makeText(MultipleListActivity.this, child.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public List<ModelParent> getParentList() {
        List<String> list = NameGenerator.getDummyParentList();
        List<ModelParent> parents = new ArrayList<>();
        for (String name : list) {
            parents.add(new ModelParent(name, null));
        }
        return parents;
    }

    public List<ModelChild> getChildrenList() {
        List<String> list = NameGenerator.getDummyChildrenList();
        List<ModelChild> parents = new ArrayList<>();
        for (String name : list) {
            parents.add(new ModelChild(name));
        }
        return parents;
    }
}
