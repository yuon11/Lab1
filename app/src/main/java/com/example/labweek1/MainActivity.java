package com.example.labweek1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddNew(View view) {

        LinearLayout r = (LinearLayout) (view.getParent());

        // EditText textString = r.findViewById(R.id.edittxtview);
        EditText textString = (EditText) r.getChildAt(0);
        String text = textString.getText().toString();


        if (text.equals("H")){
            Log.i("Add Horizontal", "Add horizon. buttons");
            AddNewHorizontal();
        }
        else{
            Log.i("Add EditText", "Add EditText object");
            AddNewEditText(view, text);
        }
    }

    private void AddNewEditText(View view, String buttnTxt) {
        // Create Linear LAyout
        //
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(0,5,0,0);
        ll.setWeightSum(3);

        // Create other Two View Objects
        //
        EditText editText=new EditText(this);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT,2f);
        editText.setLayoutParams(params);
        Button b=new Button(this);
        LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        b.setLayoutParams(params2);

        // Get TExt Content
        //
        // System.out.print(editText.getText());
        b.setText(buttnTxt);

        // Add View Objects to layout view group
        //
        ll.addView(editText);
        ll.addView(b);

        // Dynamically register onClick listener... is this a lambda?
        //
        Log.i("Button OnClick", "Creating on click listener");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the click handler here
                // View newView = (View) ll;
                AddNew(v);
            }
        });

        // To add this ViewGroup object (ll) into the root ViewGroup
        //
        LinearLayout main_container=findViewById(R.id.mainContainer);
        main_container.addView(ll);
    }

    public void onHorizontalButtonClick(View view) {
        //  Create the new button and add it to the linear layout element
        //
        LinearLayout ll = (LinearLayout) (view.getParent());

        Button newBttn=new Button(ll.getContext());
        Integer count=ll.getChildCount()+1;
        newBttn.setText(count.toString());
        newBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Create the new button and add it to the linear layout element
                //
                onHorizontalButtonClick(v);
            }
        });
        ll.addView(newBttn);
    }

    public void AddNewHorizontal() {
        // Create the horizontal scroll view group
        //
        HorizontalScrollView horizontalScrollView= new HorizontalScrollView(this);
        LinearLayout.LayoutParams scrollViewParams = new
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        horizontalScrollView.setLayoutParams(scrollViewParams);

        //  Create the linear layout view group.
        //
        final LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(0,5,0,0);

        //  Create the new button and add it to the linear layout element
        //
        Button b=new Button(this);
        Integer count=ll.getChildCount()+1;
        b.setText(count.toString());
        ll.addView(b);

        // Dynamically register onClick listener... is this a lambda?
        //
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Create the new button and add it to the linear layout element
                //
                onHorizontalButtonClick(v);
            }
        });

        //  Insert the linear layout into the horizontal scroll and the horizontal scroll into the mainContainer
        //
        LinearLayout main_container= (LinearLayout) findViewById(R.id.mainContainer);
        horizontalScrollView.addView(ll);
        main_container.addView(horizontalScrollView);
    }

    public void AddNewInLandscape(View view) {
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.su_logo);
        LinearLayout ll=findViewById(R.id.main_container);
        ll.addView(imageView);
    }
}