package com.app.ahyaku.touchpaint;

import android.gesture.GestureOverlayView;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

//import com.app.ahyaku.touchpaint.GestureListener;

import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;
import android.content.Context;

import com.app.ahyaku.touchpaint.GraphicsView;

public class MainActivity extends ActionBarActivity {
//public class MainActivity extends ActionBarActivity implements
//        GestureDetector.OnGestureListener,
//        GestureDetector.OnDoubleTapListener{

    static final String TAG = "MainActivity";

   // private final GestureListener mListener;

//    private static final String DEBUG_TAG = "Gestures";
//    public GestureDetectorCompat mDetector;

    public GraphicsView mGraphicsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        /** For Gesture Detection **/
//        {
//            // Instantiate the gesture detector with the
//            // application context and an implementation of
//            // GestureDetector.OnGestureListener
//            mDetector = new GestureDetectorCompat(this,this);
//            // Set the gesture detector as the double tap
//            // listener.
//            mDetector.setOnDoubleTapListener(this);
//        }

        mGraphicsView = new GraphicsView(this);
        //mGraphicsView.setWillNotDraw(false);
        Log.d(TAG, "onCreate() End!!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    // Called when the activity is first created
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
    }
*/

//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//        {
//            final int action = event.getAction();
//
//            /*
//             * Switch on the action. The action is extracted from the event by
//             * applying the MotionEvent.ACTION_MASK. Alternatively a call to
//             * event.getActionMasked() would yield in the action as well.
//             */
//            switch (action & MotionEvent.ACTION_MASK) {
//
//                case MotionEvent.ACTION_DOWN: {
//                    // first pressed gesture has started
//
//                /*
//                 * Only one touch event is stored in the MotionEvent. Extract
//                 * the pointer identifier of this touch from the first index
//                 * within the MotionEvent object.
//                 */
//                    int id = event.getPointerId(0);
//
//                    /*
//                    TouchHistory data = TouchHistory.obtain(event.getX(0), event.getY(0),
//                            event.getPressure(0));
//                    data.label = "id: " + 0;
//                    */
//                /*
//                 * Store the data under its pointer identifier. The pointer
//                 * number stays consistent for the duration of a gesture,
//                 * accounting for other pointers going up or down.
//                 */
//                    /*
//                    mTouches.put(id, data);
//
//                    mHasTouch = true;
//                    */
//                    break;
//                }
//
//                case MotionEvent.ACTION_POINTER_DOWN: {
//                /*
//                 * A non-primary pointer has gone down, after an event for the
//                 * primary pointer (ACTION_DOWN) has already been received.
//                 */
//
//                /*
//                 * The MotionEvent object contains multiple pointers. Need to
//                 * extract the index at which the data for this particular event
//                 * is stored.
//                 */
//                    int index = event.getActionIndex();
//                    int id = event.getPointerId(index);
//
//                    /*
//                    TouchHistory data = TouchHistory.obtain(event.getX(index), event.getY(index),
//                            event.getPressure(index));
//                    data.label = "id: " + id;
//                    */
//
//                /*
//                 * Store the data under its pointer identifier. The index of
//                 * this pointer can change over multiple events, but this
//                 * pointer is always identified by the same identifier for this
//                 * active gesture.
//                 */
//                    /*
//                    mTouches.put(id, data);
//                    */
//
//                    break;
//                }
//
//                case MotionEvent.ACTION_UP: {
//                /*
//                 * Final pointer has gone up and has ended the last pressed
//                 * gesture.
//                 */
//
//                /*
//                 * Extract the pointer identifier for the only event stored in
//                 * the MotionEvent object and remove it from the list of active
//                 * touches.
//                 */
//                    int id = event.getPointerId(0);
//
//                    /*
//                    TouchHistory data = mTouches.get(id);
//                    mTouches.remove(id);
//                    data.recycle();
//                    */
//
//                    /*
//                    mHasTouch = false;
//                    */
//
//                    break;
//                }
//
//                case MotionEvent.ACTION_POINTER_UP: {
//                /*
//                 * A non-primary pointer has gone up and other pointers are
//                 * still active.
//                 */
//
//                /*
//                 * The MotionEvent object contains multiple pointers. Need to
//                 * extract the index at which the data for this particular event
//                 * is stored.
//                 */
//                    int index = event.getActionIndex();
//                    int id = event.getPointerId(index);
//
//                    /*
//                    TouchHistory data = mTouches.get(id);
//                    mTouches.remove(id);
//                    data.recycle();
//                    */
//
//                    break;
//                }
//
//                case MotionEvent.ACTION_MOVE: {
//                /*
//                 * A change event happened during a pressed gesture. (Between
//                 * ACTION_DOWN and ACTION_UP or ACTION_POINTER_DOWN and
//                 * ACTION_POINTER_UP)
//                 */
//
//                /*
//                 * Loop through all active pointers contained within this event.
//                 * Data for each pointer is stored in a MotionEvent at an index
//                 * (starting from 0 up to the number of active pointers). This
//                 * loop goes through each of these active pointers, extracts its
//                 * data (position and pressure) and updates its stored data. A
//                 * pointer is identified by its pointer number which stays
//                 * constant across touch events as long as it remains active.
//                 * This identifier is used to keep track of a pointer across
//                 * events.
//                 */
///*
//                    for (int index = 0; index < event.getPointerCount(); index++) {
//                        // get pointer id for data stored at this index
//                        int id = event.getPointerId(index);
//
//                        */
///*
//                        // get the data stored externally about this pointer.
//                        TouchHistory data = mTouches.get(id);
//
//                        // add previous position to history and add new values
//                        data.addHistory(data.x, data.y);
//                        data.setTouch(event.getX(index), event.getY(index),
//                                event.getPressure(index));
//                        *//*
//
//
//                    }
//*/
//
//                    Log.d(DEBUG_TAG, "ACTION_MOVE");
//                    break;
//                }
//            }
//        }
//
//
//        /** For GestureDetector ? **/
//        {
//            this.mDetector.onTouchEvent(event);
//            // Be sure to call the superclass implementation
//            return super.onTouchEvent(event);
//        }
//    }
//
//    @Override
//    public boolean onDown(MotionEvent event) {
//        Log.d(DEBUG_TAG,"onDown: " + event.toString());
//        return true;
//    }
//
//    @Override
//    public boolean onFling(MotionEvent event1, MotionEvent event2,
//                           float velocityX, float velocityY) {
//        Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
//        return true;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent event) {
//        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
//                            float distanceY) {
//        Log.d(DEBUG_TAG, "onScroll: " + e1.toString()+e2.toString());
//        //Log.d(DEBUG_TAG, "onScroll: [x,y]=[" + distanceX + ", " + distanceY + "]");
//
//        mGraphicsView.setTouchPos(e2.getX(), e2.getY());
//        //mGraphicsView.setWillNotDraw(false);
//        mGraphicsView.invalidate();
//
//        return true;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent event) {
//        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent event) {
//        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
//        return true;
//    }
//
//    @Override
//    public boolean onDoubleTap(MotionEvent event) {
//        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
//        return true;
//    }
//
//    @Override
//    public boolean onDoubleTapEvent(MotionEvent event) {
//        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
//        return true;
//    }
//
//    @Override
//    public boolean onSingleTapConfirmed(MotionEvent event) {
//        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
//        return true;
//    }
}
