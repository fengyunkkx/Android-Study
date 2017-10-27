package zyl.android.proj8;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.view.Menu;
import android.widget.Toast;

public class P5Activity extends Activity {
	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p5);
		tv = (TextView) findViewById(R.id.show);
		registerForContextMenu(tv);

	}

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuInflater inflator = new MenuInflater(this);
		inflator.inflate(R.menu.menu2, menu);
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.setHeaderTitle("请选择文字颜色：");

	}

	@Override
	public boolean onContextItemSelected(MenuItem item1) {
		switch (item1.getItemId()) {
		case R.id.color1:
			tv.setTextColor(Color.rgb(255, 0, 0));
			break;
		case R.id.color2:
			tv.setTextColor(Color.rgb(0, 255, 0));
			break;
		case R.id.color3:
			tv.setTextColor(Color.rgb(0, 0, 255));
			break;
			
			//三种颜色选项
			
		default:
			tv.setTextColor(Color.rgb(255, 255, 255));
		}
		return true;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item2) {
		if (item2.getGroupId() == R.id.setting) {
			if (item2.isChecked()) {
				item2.setChecked(false);
			} else {
				item2.setChecked(true);
			}
		}
		if (item2.getItemId() != R.id.item2) {
			Toast.makeText(P5Activity.this, item2.getTitle(), Toast.LENGTH_SHORT)
					.show();
		}
		return true;
	}

}
