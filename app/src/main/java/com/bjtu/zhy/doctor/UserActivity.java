package com.bjtu.zhy.doctor;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.bjtu.zhy.doctor.databinding.ActivityUserBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 2017/4/12.
 */

public class UserActivity extends AppCompatActivity {

	private List<UserBean> beanList;    // user data

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActivityUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user);

		// show user info
		// TODO: 2017/5/3 example data should be changed to server data
		beanList = new ArrayList<>();
		beanList.add(new UserBean("用户姓名：", ""));
		beanList.add(new UserBean("证件号码：", ""));
		beanList.add(new UserBean("联系方式：", ""));
		beanList.add(new UserBean("所患疾病：", ""));
		beanList.add(new UserBean("主治医师：", ""));

		MainListAdapter listAdapter = new MainListAdapter<>(UserActivity.this, beanList, R.layout.user_listview_item, BR.item);

		// data binding
		binding.setAdapter(listAdapter);
	}

	public void buttonClick(View v) {
		Log.i("点击保存按钮", "点击事件");

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("是否保存？")
				.setCancelable(false)
				.setPositiveButton("是", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO: 2017/5/3 network operation
						// TODO: 2017/5/3 exit present activity
					}
				})
				.setNegativeButton("否", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (null != this.getCurrentFocus()) {
			InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
		}

		return super.onTouchEvent(event);
	}
}
