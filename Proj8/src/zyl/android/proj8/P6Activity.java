package zyl.android.proj8;


import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.TextView;


public class P6Activity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p6);

		XmlResourceParser xrp=getResources().getXml(R.xml.xmlfile);
		StringBuilder sb=new StringBuilder("");
		try {
			while(xrp.getEventType()!=XmlResourceParser.END_DOCUMENT){
				if(xrp.getEventType()==XmlResourceParser.START_TAG){
					String tagName=xrp.getName();
					if(tagName.equals("customer")){
						sb.append("’À∫≈£∫"+xrp.getAttributeValue(0)+"   ");
						sb.append("\n");
						sb.append("√‹¬Î£∫"+xrp.getAttributeValue(1)+"   ");
						sb.append("\n");
						sb.append("◊¢≤·” œ‰£∫"+xrp.getAttributeValue(2));
						sb.append("\n");
						sb.append("\n");
					}
				}
				xrp.next();
			}
			TextView tv=(TextView)findViewById(R.id.show);
			tv.setText(sb.toString());
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

