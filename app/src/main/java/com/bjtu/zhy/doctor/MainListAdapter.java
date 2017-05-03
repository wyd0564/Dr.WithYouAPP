package com.bjtu.zhy.doctor;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

/**
 * Created by zhy on 2017/4/11.
 */
interface EditInfoListener {
	void show();
	void hide();
}

public class MainListAdapter<T> extends BaseAdapter {
	private List<T> list;
	private Context context;
	private int layoutId;
	private int variableId;
	private EditInfoListener editInfoListener = null;

	public MainListAdapter(Context context, List<T> list, int layoutId, int variableId) {
		this.context = context;
		this.list = list;
		this.layoutId = layoutId;
		this.variableId = variableId;
	}

	public void setEditInfoListener(EditInfoListener listener) {
		editInfoListener = listener;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewDataBinding binding = null;

		if (convertView == null) {
			binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false);
		} else {
			binding = DataBindingUtil.getBinding(convertView);
		}

		binding.setVariable(variableId, list.get(position));

		View v = binding.getRoot();
		EditText editText = (EditText) v.findViewById(R.id.detailTextView);

		if (editInfoListener != null) {
			editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					if (!hasFocus) {
						// show show button
						editInfoListener.show();
					} else {
						editInfoListener.hide();
					}
				}
			});
		}

		return v;
	}


}
