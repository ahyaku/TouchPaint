package com.app.ahyaku.touchpaint;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import android.view.View;

/**
 * Created by ahyaku on 2015/02/22.
 */
public class GestureListener extends View implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private static final String DEBUG_TAG = "GestureListener";
    public GestureDetectorCompat mDetector;

    public GestureListener(Context context){
        super(context);
        /** For Gesture Detection **/
        {
            // Instantiate the gesture detector with the
            // application context and an implementation of
            // GestureDetector.OnGestureListener
            mDetector = new GestureDetectorCompat(context, this);
            // Set the gesture detector as the double tap
            // listener.
            mDetector.setOnDoubleTapListener(this);
        }

        Log.d(DEBUG_TAG, "GestureListener() End!!");

    }

/*    public void init(Context context) {
        *//** For Gesture Detection **//*
        {
            // Instantiate the gesture detector with the
            // application context and an implementation of
            // GestureDetector.OnGestureListener
            mDetector = new GestureDetectorCompat(context, this);
            // Set the gesture detector as the double tap
            // listener.
            mDetector.setOnDoubleTapListener(this);
        }

        Log.d(DEBUG_TAG, "onCreate() End!!");
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event){
        {
            final int action = event.getAction();

            /*
             * Switch on the action. The action is extracted from the event by
             * applying the MotionEvent.ACTION_MASK. Alternatively a call to
             * event.getActionMasked() would yield in the action as well.
             */
            switch (action & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_DOWN: {
                    // first pressed gesture has started

                /*
                 * Only one touch event is stored in the MotionEvent. Extract
                 * the pointer identifier of this touch from the first index
                 * within the MotionEvent object.
                 */
                    int id = event.getPointerId(0);

                    /*
                    TouchHistory data = TouchHistory.obtain(event.getX(0), event.getY(0),
                            event.getPressure(0));
                    data.label = "id: " + 0;
                    */
                /*
                 * Store the data under its pointer identifier. The pointer
                 * number stays consistent for the duration of a gesture,
                 * accounting for other pointers going up or down.
                 */
                    /*
                    mTouches.put(id, data);

                    mHasTouch = true;
                    */
                    break;
                }

                case MotionEvent.ACTION_POINTER_DOWN: {
                /*
                 * A non-primary pointer has gone down, after an event for the
                 * primary pointer (ACTION_DOWN) has already been received.
                 */

                /*
                 * The MotionEvent object contains multiple pointers. Need to
                 * extract the index at which the data for this particular event
                 * is stored.
                 */
                    int index = event.getActionIndex();
                    int id = event.getPointerId(index);

                    /*
                    TouchHistory data = TouchHistory.obtain(event.getX(index), event.getY(index),
                            event.getPressure(index));
                    data.label = "id: " + id;
                    */

                /*
                 * Store the data under its pointer identifier. The index of
                 * this pointer can change over multiple events, but this
                 * pointer is always identified by the same identifier for this
                 * active gesture.
                 */
                    /*
                    mTouches.put(id, data);
                    */

                    break;
                }

                case MotionEvent.ACTION_UP: {
                /*
                 * Final pointer has gone up and has ended the last pressed
                 * gesture.
                 */

                /*
                 * Extract the pointer identifier for the only event stored in
                 * the MotionEvent object and remove it from the list of active
                 * touches.
                 */
                    int id = event.getPointerId(0);

                    /*
                    TouchHistory data = mTouches.get(id);
                    mTouches.remove(id);
                    data.recycle();
                    */

                    /*
                    mHasTouch = false;
                    */

                    break;
                }

                case MotionEvent.ACTION_POINTER_UP: {
                /*
                 * A non-primary pointer has gone up and other pointers are
                 * still active.
                 */

                /*
                 * The MotionEvent object contains multiple pointers. Need to
                 * extract the index at which the data for this particular event
                 * is stored.
                 */
                    int index = event.getActionIndex();
                    int id = event.getPointerId(index);

                    /*
                    TouchHistory data = mTouches.get(id);
                    mTouches.remove(id);
                    data.recycle();
                    */

                    break;
                }

                case MotionEvent.ACTION_MOVE: {
                /*
                 * A change event happened during a pressed gesture. (Between
                 * ACTION_DOWN and ACTION_UP or ACTION_POINTER_DOWN and
                 * ACTION_POINTER_UP)
                 */

                /*
                 * Loop through all active pointers contained within this event.
                 * Data for each pointer is stored in a MotionEvent at an index
                 * (starting from 0 up to the number of active pointers). This
                 * loop goes through each of these active pointers, extracts its
                 * data (position and pressure) and updates its stored data. A
                 * pointer is identified by its pointer number which stays
                 * constant across touch events as long as it remains active.
                 * This identifier is used to keep track of a pointer across
                 * events.
                 */
/*
                    for (int index = 0; index < event.getPointerCount(); index++) {
                        // get pointer id for data stored at this index
                        int id = event.getPointerId(index);

                        */
/*
                        // get the data stored externally about this pointer.
                        TouchHistory data = mTouches.get(id);

                        // add previous position to history and add new values
                        data.addHistory(data.x, data.y);
                        data.setTouch(event.getX(index), event.getY(index),
                                event.getPressure(index));
                        *//*


                    }
*/

                    Log.d(DEBUG_TAG, "ACTION_MOVE");
                    break;
                }
            }
        }


        /** For GestureDetector ? **/
        {
            this.mDetector.onTouchEvent(event);
            // Be sure to call the superclass implementation
//            return super.onTouchEvent(event);
            return true;
        }
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + e1.toString()+e2.toString());
        //Log.d(DEBUG_TAG, "onScroll: [x,y]=[" + distanceX + ", " + distanceY + "]");

//        mGraphicsView.setTouchPos(e2.getX(), e2.getY());
//        //mGraphicsView.setWillNotDraw(false);
//        mGraphicsView.invalidate();

        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }
}
