package zyl.android.projx;

import java.util.List;
import zyl.android.dao.FlagDAO;
import zyl.android.dao.InaccountDAO;
import zyl.android.dao.OutaccountDAO;
import zyl.android.model.Tb_flag;
import zyl.android.model.Tb_inaccount;
import zyl.android.model.Tb_outaccount;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ProjXShowinfo extends Activity {					// ���ݹ������
	public static final String FLAG = "id";
	Button btnoutinfo, btnininfo, btnflaginfo;
	ListView lvinfo;
	String strType = "";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projxshowinfo);

		lvinfo = (ListView) findViewById(R.id.lvinfo);
		btnoutinfo = (Button) findViewById(R.id.btnoutinfo);
		btnininfo = (Button) findViewById(R.id.btnininfo);
		btnflaginfo = (Button) findViewById(R.id.btnflaginfo);

		ShowInfo(R.id.btnoutinfo);

		btnoutinfo.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						ShowInfo(R.id.btnoutinfo);				// ��ʾ֧����Ϣ
					}
				});

		btnininfo.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						ShowInfo(R.id.btnininfo);				// ��ʾ������Ϣ
					}
				});
		btnflaginfo.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						ShowInfo(R.id.btnflaginfo);				// ��ʾ��ǩ��Ϣ
					}
				});

		
		
		lvinfo.setOnItemClickListener(new OnItemClickListener()
		{

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String strInfo = String.valueOf(((TextView) view).getText());		// ��¼��Ϣ
				String strid = strInfo.substring(0, strInfo.indexOf('|'));			// ȡ���
				Intent intent = null;
				if (strType == "btnoutinfo" | strType == "btnininfo") {				// �ж�֧����������
					intent = new Intent(ProjXShowinfo.this, ProjXInfoManage.class);
					intent.putExtra(FLAG, new String[] { strid, strType });			// ���ô�ֵ
				} else if (strType == "btnflaginfo") {								// �жϱ�ǩ��Ϣ
					intent = new Intent(ProjXShowinfo.this, ProjXFlagManage.class);
					intent.putExtra(FLAG, strid);									// ���ô�ֵ
				}
				startActivity(intent);
			}
		});
	}

	private void ShowInfo(int intType) {
		String[] strInfos = null;
		ArrayAdapter<String> arrayAdapter = null;
		switch (intType) {
		case R.id.btnoutinfo:
			strType = "btnoutinfo";
			OutaccountDAO outaccountinfo = new OutaccountDAO(ProjXShowinfo.this);
			List<Tb_outaccount> listoutinfos = outaccountinfo.getScrollData(0,
					(int) outaccountinfo.getCount());
			strInfos = new String[listoutinfos.size()];
			int i = 0;
			for (Tb_outaccount tb_outaccount : listoutinfos) {						// ����List���ͼ���
				// ��֧�������Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
				strInfos[i] = tb_outaccount.getid() + "|"
						+ tb_outaccount.getType() + " "
						+ String.valueOf(tb_outaccount.getMoney()) + "Ԫ     "
						+ tb_outaccount.getTime();
				i++;
			}
			break;
		case R.id.btnininfo:
			strType = "btnininfo";
			InaccountDAO inaccountinfo = new InaccountDAO(ProjXShowinfo.this);
			List<Tb_inaccount> listinfos = inaccountinfo.getScrollData(0,
					(int) inaccountinfo.getCount());
			strInfos = new String[listinfos.size()];
			int m = 0;
			for (Tb_inaccount tb_inaccount : listinfos) {							// ����List���ͼ���
				// �����������Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
				strInfos[m] = tb_inaccount.getid() + "|"
						+ tb_inaccount.getType() + " "
						+ String.valueOf(tb_inaccount.getMoney()) + "Ԫ     "
						+ tb_inaccount.getTime();
				m++;
			}
			break;
		case R.id.btnflaginfo:
			strType = "btnflaginfo";
			FlagDAO flaginfo = new FlagDAO(ProjXShowinfo.this);
			List<Tb_flag> listFlags = flaginfo.getScrollData(0,
					(int) flaginfo.getCount());
			strInfos = new String[listFlags.size()];
			int n = 0;
			for (Tb_flag tb_flag : listFlags) {										// ����List���ͼ���
				// ����ǩ�����Ϣ��ϳ�һ���ַ���

				// �洢���ַ����������Ӧλ��
				strInfos[n] = tb_flag.getid() + "|" + tb_flag.getFlag();
				if (strInfos[n].length() > 15)
					strInfos[n] = strInfos[n].substring(0, 15) + "����";
				n++;
			}
			break;
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
