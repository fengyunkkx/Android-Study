package zyl.android.proj2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;



public class P203Activity extends Activity{

	private android.widget.CompoundButton.OnCheckedChangeListener checkBox_listener=new android.widget.CompoundButton.OnCheckedChangeListener() {			
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		}
		
	};
	
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p203);

		/*单选框*/

		final RadioGroup sex = (RadioGroup)findViewById(R.id.radioGroup1);

		/*
		Button button=(Button)findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				for(int i=0;i<sex.getChildCount();i++){
					RadioButton r=(RadioButton)sex.getChildAt(i);
					if(r.isChecked()){
						r.getText();
						break;						
					}
				}				
			}
		});
		
		*/
		
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
						
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for(int i = 0 ; i < sex.getChildCount();i++){
					RadioButton r = (RadioButton) sex.getChildAt(i);
					if(r.isChecked()){
						Log.i("单选按钮","性别："+ r.getText());	
						Toast.makeText(P203Activity.this,"你的性别是："+ r.getText(),Toast.LENGTH_SHORT).show();

						break;
					}
				}
			}
			
		});
		
		/*复选框*/

		Button button2 = (Button)findViewById(R.id.button2);
		
		final CheckBox like1=(CheckBox)findViewById(R.id.like1);
		final CheckBox like2=(CheckBox)findViewById(R.id.like2);
		final CheckBox like3=(CheckBox)findViewById(R.id.like3);
	

				
		like1.setOnCheckedChangeListener(checkBox_listener);
		like2.setOnCheckedChangeListener(checkBox_listener);
		like3.setOnCheckedChangeListener(checkBox_listener);

		button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String like="";
				if(like1.isChecked())
					like+=like1.getText().toString()+"";
				if(like2.isChecked())
					like+=like2.getText().toString()+"";
				if(like3.isChecked())
					like+=like3.getText().toString()+"";
				
				Toast.makeText(P203Activity.this,"你的兴趣是："+ like1.isChecked() + "、" + like2.isChecked() + "、" + like3.isChecked(),Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				
			}
		});
		
	}
		

		/*

		RadioGroup sex=(RadioGroup)findViewById(R.id.radioGroup1);
		sex.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				RadioButton r=(RadioButton)findViewById(checkedId);
				r.getText();
			}
		});
		
		public void buttonclick1 (View view){
			Toast.makeText(P203Activity.this,"你选择的性别是：r",Toast.LENGTH_SHORT).show();
		}
		

		
		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
						
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for(int i = 0 ; i < sex.getChildCount();i++){
					RadioButton r = (RadioButton) sex.getChildAt(i);
					if(r.isChecked()){
						Log.i("单选按钮","性别："+ r.getText());
						break;
					}
				}
			}
		});
				*/
	
	

		
		
	
	
		
		
		
	}
	

