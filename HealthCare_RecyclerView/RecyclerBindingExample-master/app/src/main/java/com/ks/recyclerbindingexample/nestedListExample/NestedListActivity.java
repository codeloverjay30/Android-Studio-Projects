package com.ks.recyclerbindingexample.nestedListExample;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;
import com.ks.recyclerbindingexample.R;
import com.ks.recyclerbindingexample.callbacks.OnItemClickListener;
import com.ks.recyclerbindingexample.data.NameGenerator;
import com.ks.recyclerbindingexample.databinding.ActivityNestedListBinding;
import com.ks.recyclerbindingexample.models.ModelChild;
import com.ks.recyclerbindingexample.models.ModelParent;
import com.ks.recyclerbindingexample.multipleListExample.MultipleListActivity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NestedListActivity extends AppCompatActivity {
    String TAG = "NestedListActivity";

    ArrayList<String> permissions = new ArrayList<>();

    ActivityNestedListBinding binding;
    ArrayList<ModelParent> data = new ArrayList<ModelParent>();

    Bundle bundle;
    Bundle dummy_bundle = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        permissions.add("WRITE_EXTERNAL_STORAGE");
        permissions.add("READ_EXTERNAL_STORAGE");

        for(int i=0;i<permissions.size();i++) {
            Log.d(TAG,"permission["+String.valueOf(i)+"]:"+permissions.get(i));
        }
        requestPermissions(permissions.toArray(new String[permissions.size()]),
                PERMISSION_GRANTED);
        if(androidx.core.content.ContextCompat.checkSelfPermission(this,WRITE_EXTERNAL_STORAGE)==PERMISSION_GRANTED){
            Log.d(TAG,"WRITE_EXTERNAL_STORAGE is PERMISSION_GRANTED.");
        }else{
            Log.d(TAG,"WRITE_EXTERNAL_STORAGE is NOT PERMISSION_GRANTED.");
        }
        if(androidx.core.content.ContextCompat.checkSelfPermission(this,READ_EXTERNAL_STORAGE)==PERMISSION_GRANTED){
            Log.d(TAG,"READ_EXTERNAL_STORAGE is PERMISSION_GRANTED.");
        }else{
            Log.d(TAG,"READ_EXTERNAL_STORAGE is NOT PERMISSION_GRANTED.");
        }

        bundle = savedInstanceState;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nested_list);
        binding.setActivity(this);
        data = generateData();
        binding.setParentList(data);
        binding.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object object) {
                if (object instanceof ModelParent) {
                    ModelParent parent = (ModelParent) object;
                    Toast.makeText(NestedListActivity.this, parent.getParentName(), Toast.LENGTH_SHORT).show();
                } else if (object instanceof ModelChild) {
                    ModelChild child = (ModelChild) object;
                    Toast.makeText(NestedListActivity.this, child.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int getParentIndex(ArrayList<ModelParent> modelParents,String parent){
        int size = modelParents.size();
        for(int i=0;i<size;i++) {
            ModelParent modelParent = modelParents.get(i);
            if(Objects.equals(modelParent.getParentName(), parent)) {
                return i;
            }
        }
        return -1;
    }
    private int getChildrenIndex(ArrayList<ModelChild> modelChildren,String child){
        int size = modelChildren.size();
        for(int i=0;i<size;i++) {
            ModelChild modelChild = modelChildren.get(i);
            if(Objects.equals(modelChild.getName(), child)) {
                return i;
            }
        }
        return -1;
    }

    public void addAnItem(View view){
        try {
            ArrayList<ModelChild> modelChildren = new ArrayList<ModelChild>();
            String parent;
            String child;
            EditText parent_edittext = findViewById(R.id.parent);
            EditText child_edittext = findViewById(R.id.child);
            String parent_text = String.valueOf(parent_edittext.getText());
            String child_text = String.valueOf(child_edittext.getText());
            parent = parent_text;
            child = child_text;
            if (!(!parent.isEmpty() && !child.isEmpty())) {
                Log.e(TAG, "Either parent or child is empty.");
                return;
            }
            int parentIndex = this.getParentIndex(data, parent);
            if (parentIndex == -1) {
                modelChildren = new ArrayList<ModelChild>();
                modelChildren.add(new ModelChild(child));
                data.add(new ModelParent(parent, modelChildren));
                Log.d(TAG, "parentIndex == -1 is true");
                print_list(modelChildren);
            } else {
                modelChildren = (ArrayList<ModelChild>) data.get(parentIndex).getChildren();
                Log.d(TAG, "parentIndex == -1 is false");
                int childIndex = this.getChildrenIndex(modelChildren, child);
                if (childIndex == -1) {
                    modelChildren.add(new ModelChild(child));
                    data.get(parentIndex).setChildren(modelChildren);
                } else {
                    Log.e(TAG, "Duplicate modelchildren is NOT allowed.");
                    return;
                }
                print_list(modelChildren);
                //String data_key = new Gson().toJson(data);
                //StorageUtil.singleton.data = data;
            }
            this.write_file();
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }
    private void write_file() throws IOException {
        String sampledata_directory = "C:\\Users\\40843\\AndroidStudioProjects\\HealthCare_RecyclerView\\RecyclerBindingExample-master\\app\\sampledata";
        String sampledata_filename = sampledata_directory+"\\"+"sampledata.txt";
        String data_key = new Gson().toJson(data);
        File file = new File(sampledata_filename);
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        writer.print(data_key);
        writer.close();
    }
    private void print_list(List<ModelChild> modelChildren){
        Log.d(TAG,"print_list method was called.");
        int size = modelChildren.size();
        ModelChild modelChild;
        for(int i=0;i<size;i++){
            modelChild = modelChildren.get(i);
            Log.d(TAG,modelChild.getName());
        }
        Log.d(TAG,"End of print_list method call.");
    }
    private ArrayList<ModelParent> generateData() {
        ArrayList<ModelParent> parents = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Pair<String, List<String>> pair = NameGenerator.getDummyParentChildrenPair();
            ArrayList<ModelChild> children = new ArrayList<>();
            for (String child : pair.second) {
                children.add(new ModelChild(child));
            }
            parents.add(new ModelParent(pair.first, children));
        }
        return parents;
    }

    public void openMultipleListActivity(View view) {
        //Log.d(TAG,"StorageUtil.singleton.data:"+StorageUtil.singleton.data);
        startActivity(new Intent(this, MultipleListActivity.class));
    }
}
