/*
 * This file is a part of Null Launcher.
 * Copyright 2013 Michael Howell <michael@notriddle.com>
 *
 * Null Launcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Null Launcher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Null Launcher. If not, see <http://www.gnu.org/licenses/>.
 */

package com.notriddle.null_launcer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ScaleGestureDetector;

public class Home extends Activity implements ScaleGestureDetector.OnScaleGestureListener,
											  GestureDetector.OnGestureListener, View.OnTouchListener {
	ScaleGestureDetector mGesture;
	GestureDetector ltGesture;
	/** Called when the activity is first created. */
	@Override public void onCreate(Bundle state) {
		super.onCreate(null);
		mGesture = new ScaleGestureDetector(this, this);
		ltGesture = new GestureDetector(this, this);
		ltGesture.setIsLongpressEnabled(true);
		findViewById(android.R.id.content).setOnTouchListener(this);
		findViewById(android.R.id.content).setClickable(true);
		findViewById(android.R.id.content).setLongClickable(true);
	}
	@Override public void onStop() {
		super.onStop();
		Process.sendSignal(Process.myPid(), 9);
	}
	@Override public void onBackPressed() {
	}
	@Override protected void onRestoreInstanceState(Bundle state) {
	}
	@Override protected void onSaveInstanceState(Bundle state) {
	}
	@Override public boolean onTouch(View v, MotionEvent e) {
		boolean result = mGesture.onTouchEvent(e);
		boolean result2 = ltGesture.onTouchEvent(e);
		return result || result2;
	}
	@Override public boolean onScale(ScaleGestureDetector gesture) {
		boolean go = gesture.getScaleFactor() <= 0.5 || gesture.getScaleFactor() >= 1.5;
		if (go) {
			changeLauncher();
		}
		return go;
	}
	@Override public boolean onScaleBegin(ScaleGestureDetector gesture) {
		return true;
	}
	@Override public void onScaleEnd(ScaleGestureDetector gesture) {
	}
	private void changeLauncher() {
		getPackageManager().clearPackagePreferredActivities(getPackageName());
		Intent i = new Intent(Intent.ACTION_MAIN);
		i.addCategory(Intent.CATEGORY_HOME);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(i);
	}

	@Override
	public boolean onDown(MotionEvent motionEvent) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent motionEvent) {

	}

	@Override
	public boolean onSingleTapUp(MotionEvent motionEvent) {
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
		return false;
	}

	@Override
	public void onLongPress(MotionEvent motionEvent) {
		Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
		startActivity(Intent.createChooser(intent, "Select Wallpaper"));
	}

	@Override
	public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
		return false;
	}
}
