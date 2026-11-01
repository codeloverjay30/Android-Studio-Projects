package com.ks.recyclerbindingexample.multipleListExample;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ks.recyclerbindingexample.R;
import com.ks.recyclerbindingexample.callbacks.OnItemClickListener;
import com.ks.recyclerbindingexample.data.NameGenerator;
import com.ks.recyclerbindingexample.databinding.ActivityMultipleListBinding;
import com.ks.recyclerbindingexample.models.ModelChild;
import com.ks.recyclerbindingexample.models.ModelParent;
import com.ks.recyclerbindingexample.storage.StorageUtil;

import java.util.ArrayList;
import java.util.List;

public class MultipleListActivity extends AppCompatActivity {
    String TAG = "MultipleListActivity";

    ActivityMultipleListBinding binding;
    ArrayList<ModelParent> data = new ArrayList<ModelParent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = StorageUtil.singleton.data;
        Log.d(TAG,"onCreate method was called.");
        String data_json = new Gson().toJson(data);
        Log.d(TAG,"data_json:"+data_json);
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

        Log.d(TAG,"YA Done!!!");
    }

    public ArrayList<ModelParent> getParentList() {
        Log.d(TAG,"getParentList method was called.");
        ArrayList<ModelParent> parents = new ArrayList<ModelParent>();
        int size = data.size();
        Log.d(TAG,"In getParentList method call, let's dig in for loop");
        for(int i=0;i<size;i++) {
            Log.d(TAG,String.format("In getParentList method call,i:%d",i));
            String name = data.get(i).getParentName();
            parents.add(new ModelParent(name, null));
        }
        Log.d(TAG,"End of getParentList method call.");
        return parents;
    }

    public ArrayList<ModelChild> getChildrenList() {
        Log.d(TAG,"getChildrenList method was called.");
        ArrayList<ModelChild> parents = new ArrayList<ModelChild>();
        int size = data.size();
        Log.d(TAG,"In getChildrenList method call, let's dig in for loop");
        for (int i=0;i<size;i++) {
            Log.d(TAG,String.format("In getChildrenList method call,i:%d",i));
            List<ModelChild> modelChildren = data.get(i).getChildren();
            String name= "";
            for(int j=0;j<modelChildren.size();j++){
                if(j!=0){
                    name+=" , ";
                }
                name+=modelChildren.get(j).getName();
            }
            parents.add(new ModelChild(name));
        }
        Log.d(TAG,"End of getChildrenList method call.");
        return parents;
    }
}
