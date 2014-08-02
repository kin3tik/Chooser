package com.jameskvwhite.chooser;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main extends Activity {

    private Random rand;
    private List<Button> choices;

    public Main() {
        rand = new Random();
        choices = new ArrayList<Button>();
    }

    public void btnPick_click(View view) {
        if(!choices.isEmpty()) {
            int pick = rand.nextInt(choices.size());
            Button choice = choices.get(pick);

            choice.setBackgroundColor(Color.BLACK);
        }
    }

    public void btnAdd_click(View view) {
        Button b = getStyledButton();

        EditText input = (EditText)findViewById(R.id.etInput);
        if(!input.getText().toString().equals("")) {
            b.setText(input.getText());

            LinearLayout layout = (LinearLayout)findViewById(R.id.layoutTop);
            layout.addView(b);
            choices.add(b);
            input.setText("");
        }
    }

    private Button getStyledButton() {
        Button b = new Button(getApplicationContext(), null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.setMargins(0, 0, 0, Util.toDP(this, 7));
        b.setMinimumWidth(Util.toDP(this, 250));
        b.setLayoutParams(params);
        b.setBackgroundColor(Colour.GREEN_DARK.getValue());
        b.setId(Util.generateViewId());
        return b;
    }

    //=============================================================
    // OVERRIDES
    //=============================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //savedInstanceState.putBoolean("MyBoolean", true);
        //save choices
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
        //load choices
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
