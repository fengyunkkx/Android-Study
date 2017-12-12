package zyl.android.projx;

import java.util.List;

import zyl.android.dao.OutaccountDAO;
import zyl.android.model.Tb_outaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ProjXOutaccountinfo extends Activity {		// ֧���������
	public static final String FLAG = "id";
	ListView lvinfo;
	String strType = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projxoutaccountinfo);
		lvinfo = (ListView) findViewById(R.id.lvoutaccountinfo);

		ShowInfo(R.id.btnoutinfo);

		lvinfo.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String strInfo = String.valueOf(((TextView) view).getText());
				String strid = strInfo.substring(0, strInfo.indexOf('|'));
				Intent intent = new Intent(ProjXOutaccountinfo.this,
						ProjXInfoManage.class);
				intent.putExtra(FLAG, new String[] { strid, strType });
				startActivity(intent);
			}
		});
	}

	private void ShowInfo(int intType) {
		String[] strInfos = null;
		ArrayAdapter<String> arrayAdapter = null;
		strType = "btnoutinfo";
		OutaccountDAO outaccountinfo = new OutaccountDAO(ProjXOutaccountinfo.this);
		List<Tb_outaccount> listoutinfos = outaccountinfo.getScrollData(0,
				(int) outaccountinfo.getCount());
		strInfos = new String[listoutinfos.size()];
		int i = 0;
		for (Tb_outaccount tb_outaccount : listoutinfos) {						// ��֧�������Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
			strInfos[i] = tb_outaccount.getid() + "|" + tb_outaccount.getType()
					+ " " + String.valueOf(tb_outaccount.getMoney()) + "Ԫ     "
					+ tb_outaccount.getTime();
			i++;
		}
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, strInfos);
		lvinfo.setAdapter(arrayAdapter);
	}

	protected void onRestart() {
		super.onRestart();
		ShowInfo(R.id.btnoutinfo);
	}
}