package com.ks.nestedrecyclerbindingexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.ks.nestedrecyclerbindingexample.callbacks.OnItemClickListener;
import com.ks.nestedrecyclerbindingexample.data.NameGenerator;
import com.ks.nestedrecyclerbindingexample.databinding.ActivityMainBinding;
import com.ks.nestedrecyclerbindingexample.models.ModelChild;
import com.ks.nestedrecyclerbindingexample.models.ModelParent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setParentList(generateData());
        binding.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object object) {
                if (object instanceof ModelParent) {
                    ModelParent parent = (ModelParent) object;
                    Toast.makeText(MainActivity.this, parent.getParentName(), Toast.LENGTH_SHORT).show();
                } else if (object instanceof ModelChild) {
                    ModelChild child = (ModelChild) object;
                    Toast.makeText(MainActivity.this, child.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private ArrayList<ModelParent> generateData() {
        ArrayList<ModelParent> parents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Pair<String, List<String>> pair = NameGenerator.getDummyParentChildrenPair();
            ArrayList<ModelChild> children = new ArrayList<>();
            for (String child : pair.second) {
                children.add(new ModelChild(child));
            }
            parents.add(new ModelParent(pair.first, children));
        }
        return parents;
    }
}
