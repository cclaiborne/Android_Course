package tcs.random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;
import android.widget.ScrollView;

public class TCSProjectActivity extends Activity {
	Random random = new Random();
	int count = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ScrollView scroller = new ScrollView(this);
        
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        TextView textView = new TextView(this);
        textView.setText("Click the button to generate a random number!");
        
        Button button = new Button(this);
        button.setText("Click me!");
        
        final TextView result = new TextView(this);
        result.setText("There is no result yet!");
        
        button.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		String result1 = "The result is: " + random.nextInt(10) + " (Count: " + count + ")";
        		String result2 = "\n" + result.getText();
        		if(count == 1)
        		    result.setText(result1);
        		else
        		    result.setText(result1 + result2); 

        		count++;
        	}
        });
        
        layout.addView(textView);
        layout.addView(button);
        layout.addView(result);
        scroller.addView(layout);
        this.setContentView(scroller);

    }
}