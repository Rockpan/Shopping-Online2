package com.shopping.control;

import com.shopping.control.DragLayout.Status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Activity������㲼�֣�Э���˵�������Ӧ
 * 
 * @author Administrator
 * 
 */
public class MyRelativeLayout extends LinearLayout {

	private DragLayout dragLayout;

	public MyRelativeLayout(Context context) {
		super(context);
	}

	public MyRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DragLayout getDragLayout() {
		return dragLayout;
	}

	public void setDragLayout(DragLayout dragLayout) {
		this.dragLayout = dragLayout;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (dragLayout.getStatus() != Status.Close) {
			return true;
		}
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (dragLayout.getStatus() != Status.Close) {
			if (event.getAction() == MotionEvent.ACTION_UP) {
				dragLayout.close();
			}
			return true;
		}
		return super.onTouchEvent(event);
	}

}
