package cn.zz.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class FoodInfo extends ListActivity {
	Button image=null;
	Button back=null;
	TextView foodinfo=null;
	//String[] efood={"黄连","荞麦","雀肉"};
	//String [] efoodinfo={"猪肉多脂，酸寒滑腻。若中药配方中以黄莲为主时，应忌食猪肉，不然会降低药效，且容易引起腹泻。","《食疗本草》 记载：荞麦难消，动热风，不宜多食。由于荞麦面气味甘平而寒，猪肝多脂，两者都是不易消化之物，所以不宜同食。",
	        //"同食会消化不良。","猪肝中的铜会加速豆芽中的维生素C氧化，失去其营养价值，因此猪肝不宜与豆芽、西红柿、山楂等富含维生素C的食物同食。"};
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.foodinfo);
	Bundle bundle=getIntent().getExtras();
	int drawable=bundle.getInt("drawable");
	String foodname=bundle.getString("foodname");
	String efoodname=bundle.getString("efoodnema");
	String foodinfos=bundle.getString("foodinfo");
	//String[] efood={"黄连","荞麦","雀肉"};
	String[] efood=bundle.getStringArray("efood");
	String[] efoodinfo=bundle.getStringArray("efoodinfo");
	image=(Button)findViewById(R.id.Button);
	image.setBackgroundResource(drawable);
	image.setText(foodname);
	foodinfo=(TextView)findViewById(R.id.TextView03);
	foodinfo.setText(foodinfos);
	back=(Button)findViewById(R.id.backbutton);
	back.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button b=(Button)v;
			b.setBackgroundResource(R.drawable.btn_back_active);
			Intent intent=new Intent(FoodInfo.this, FoodListView.class);
			startActivity(intent);
		}
	});
	List<Map<String, Object>> data=new ArrayList<Map<String,Object>>();
	for(int i=0;i<efood.length;i++){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("TextView04", efood[i]);
		map.put("TextView05", efoodinfo[i]);
		data.add(map);
	}
	SimpleAdapter adapter=new SimpleAdapter(this, data, R.layout.ex_foodinfo,new String[]{"TextView04","TextView05"} , new int[]{R.id.TextView04,R.id.TextView05});
	setListAdapter(adapter);
}
}
