/*author:conowen
* date:2012.4.2
* MySimpleCursorAdapter
*/
package com.qjjc.test;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class MySimpleAdapter extends SimpleAdapter {



public MySimpleAdapter(Context context,
			List<? extends Map<String, ?>> data, int resource, String[] from,
			int[] to) {
		super(context, data, resource, from, to);
		// TODO Auto-generated constructor stub
	}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
// listviewÿ�εõ�һ��item����Ҫviewȥ���ƣ�ͨ��getView�����õ�view
// positionΪitem�����
View view = null;
if (convertView != null) {
view = convertView;
// ʹ�û����view,��Լ�ڴ�
// ��listview��item����ʱ���϶�����סһ����item������ס��item��view����convertView�����š�
// ���������ص�֮ǰ����ס��itemʱ��ֱ��ʹ��convertView����������ȥnew view()

} else {
view = super.getView(position, convertView, parent);

}

int[] colors = { Color.WHITE, Color.rgb(219, 238, 244) };//RGB��ɫ

view.setBackgroundColor(colors[position % 2]);// ÿ��item֮����ɫ��ͬ

return super.getView(position, view, parent);
}

}