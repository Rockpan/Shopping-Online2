package com.shopping.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopping_online.R;
import com.shopping.control.DragLayout;
import com.shopping.control.DragLayout.DragListener;
import com.shopping.fragment.BuyedpageFragment;
import com.shopping.fragment.HomepageFragment;
import com.shopping.fragment.NewspageFragment;

@SuppressLint("NewApi")
public class MainActivity extends BaseActivity implements OnClickListener,
		OnItemClickListener {

	private Context ctx;

	private TextView main_title;// 顶部标题
	private TextView tv_home, tv_friends, tv_issue;// 底部的三个按钮
	private Fragment f_home, f_buyed, f_news; // 三个要加载的fragment界面
	private FragmentManager fragmentManager;
	private DragLayout dragLayout;
	private ListView menuListView;// 菜单列表
	private ImageButton menuSettingBtn;// 菜单呼出按钮
	private LinearLayout menu_header;
	private LinearLayout menu_setting;
	private RelativeLayout title_layout;// 标题栏的布局
	private List<Map<String, Object>> data;// 菜单栏的数据
	private long exitTime = 0;

	// 菜单的文字
	private String[] texts = { "购物车", "我的订单", "我的收藏", "我的地址" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.ctx = this;
		initViews();

		setTabSelection(0);
	}

	/**
	 * 初始化
	 */
	private void initViews() {
		title_layout = (RelativeLayout) findViewById(R.id.title_layout);
		main_title = (TextView) findViewById(R.id.main_title);
		tv_home = (TextView) findViewById(R.id.HomePage);
		tv_friends = (TextView) findViewById(R.id.BuyedPage);
		tv_issue = (TextView) findViewById(R.id.NewsPage);
		tv_home.setOnClickListener(this);
		tv_friends.setOnClickListener(this);
		tv_issue.setOnClickListener(this);

		menuSettingBtn = (ImageButton) findViewById(R.id.menu_imgbtn);
		menu_header = (LinearLayout) findViewById(R.id.menu_header);
		menu_setting = (LinearLayout) findViewById(R.id.menu_setting);
		menuSettingBtn.setOnClickListener(this);
		menu_header.setOnClickListener(this);
		menu_setting.setOnClickListener(this);

		/**
		 * 菜单，包括数据的准备，适配器的加载
		 */
		menuListView = (ListView) findViewById(R.id.menu_listview);
		data = getListData();
		menuListView.setAdapter(new SimpleAdapter(ctx, data,
				R.layout.activity_menulist_item, new String[] { "text" },
				new int[] { R.id.menu_text }));
		menuListView.setOnItemClickListener(this);

		/**
		 * 实现菜单的打开和关闭
		 */
		dragLayout = (DragLayout) findViewById(R.id.dl);
		dragLayout.setDragListener(new DragListener() {

			@Override
			public void onOpen() {

			}

			@Override
			public void onDrag(float percent) {

			}

			@Override
			public void onClose() {

			}
		});
	}

	/**
	 * 准备数据
	 */
	private List<Map<String, Object>> getListData() {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Map<String, Object> item;
		for (int i = 0; i < texts.length; i++) {
			item = new HashMap<String, Object>();
			item.put("text", texts[i]);
			data.add(item);
		}
		return data;
	}

	/**
	 * 设置显示界面
	 * 
	 * @param i
	 *            界面的索引
	 */
	private void setTabSelection(int i) {
		resetBtn();
		fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();

		hideFragment(transaction);
		switch (i) {
		case 0:
			main_title.setText(getResources().getString(R.string.homepage));
			tv_home.setTextColor(getResources().getColor(R.color.normal_color));
			if (f_buyed == null) {
				f_buyed = new BuyedpageFragment();
				transaction.add(R.id.fl_replace, f_buyed);
				transaction.hide(f_buyed);
			}
			if (f_news == null) {
				f_news = new NewspageFragment();
				transaction.add(R.id.fl_replace, f_news);
				transaction.hide(f_news);
			}
			if (f_home == null) {
				f_home = new HomepageFragment();
				transaction.add(R.id.fl_replace, f_home);
			} else {
				transaction.show(f_home);
			}
			break;
		case 1:
			main_title.setText(getResources().getString(R.string.friendspage));
			tv_friends.setTextColor(getResources().getColor(
					R.color.normal_color));
			if (f_buyed == null) {
				f_buyed = new BuyedpageFragment();
				transaction.add(R.id.fl_replace, f_buyed);
				transaction.hide(f_buyed);
			} else {
				transaction.show(f_buyed);
			}
			break;
		case 2:
			main_title.setText(getResources().getString(R.string.activitypage));
			tv_issue.setTextColor(getResources().getColor(R.color.normal_color));
			if (f_news == null) {
				f_news = new NewspageFragment();
				transaction.add(R.id.fl_replace, f_news);
			} else {
				transaction.show(f_news);
			}
			break;

		}
		transaction.commit();
	}

	/**
	 * 用于隐藏fragment界面
	 * 
	 * @param transaction
	 */
	private void hideFragment(FragmentTransaction transaction) {
		if (f_home != null) {
			transaction.hide(f_home);
		}
		if (f_buyed != null) {
			transaction.hide(f_buyed);
		}
		if (f_news != null) {
			transaction.hide(f_news);
		}
	}

	/**
	 * 每次点击按钮时，重置按钮
	 */
	private void resetBtn() {
		tv_home.setTextColor(getResources().getColor(R.color.black));
		tv_friends.setTextColor(getResources().getColor(R.color.black));
		tv_issue.setTextColor(getResources().getColor(R.color.black));
	}

	/**
	 * 防止在进行add/hide/show等操作是出现重叠现象
	 */
	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
		if (f_home == null && fragment instanceof HomepageFragment) {
			f_home = (HomepageFragment) fragment;
		}
		if (f_buyed == null && f_buyed instanceof BuyedpageFragment) {
			f_buyed = (BuyedpageFragment) fragment;
		}
		if (f_news == null && fragment instanceof NewspageFragment) {
			f_news = (NewspageFragment) fragment;
		}
	}

	/**
	 * 按钮点击事件
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.HomePage:
			setTabSelection(0);
			break;
		case R.id.BuyedPage:
			setTabSelection(1);
			break;
		case R.id.NewsPage:
			setTabSelection(2);
			break;
		case R.id.menu_header:
			Toast.makeText(ctx, "个人界面", Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_setting:
			Toast.makeText(ctx, "设置界面", Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_imgbtn:
			dragLayout.open();
			break;
		}
	}

	/**
	 * 菜单里list的点击事件
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			Toast.makeText(ctx, "购物车界面", Toast.LENGTH_SHORT).show();
			break;

		case 1:
			Toast.makeText(ctx, "我的订单界面", Toast.LENGTH_SHORT).show();
			break;

		case 2:
			Toast.makeText(ctx, "我的收藏界面", Toast.LENGTH_SHORT).show();
			break;

		case 3:
			Toast.makeText(ctx, "我的地址界面", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}

	}

	/**
	 * 监听手机上的BACK键
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {

			if ((System.currentTimeMillis() - exitTime) > 2000) // System.currentTimeMillis()无论何时调用，肯定大于2000
			{
				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
