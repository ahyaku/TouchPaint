package com.app.ahyaku.touchpaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ahyaku on 2015/02/21.
 */
public class GraphicsView extends View{
    private static final String DEBUG_TAG = "Gestures";
    private static final float CIRCLE_SIZE = 10.0f;
    static final String TAG = "GraphicsView";
    private TouchData mTouchData;

    Paint mPaint;
    Path mPath;
    private boolean mClearView;

    private class TouchData{
        float x;
        float y;
    }

    public GraphicsView(Context context){
        super(context);
    }

    public GraphicsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchData = new TouchData();
        mTouchData.x = 0.0f;
        mTouchData.y = 0.0f;
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        //setWillNotDraw(false);

        mPaint.setStrokeWidth(10);
        mPaint.setPathEffect(null);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();
        mClearView = false;

        Log.d(TAG, "GraphicsView() End!!");
    }

    public GraphicsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (false) {
            /*
            // Canvas background color depends on whether there is an active touch
            if (mHasTouch) {
                canvas.drawColor(BACKGROUND_ACTIVE);
            } else {
                // draw inactive border
                canvas.drawRect(mBorderWidth, mBorderWidth, getWidth() - mBorderWidth, getHeight()
                        - mBorderWidth, mBorderPaint);
            }

            // loop through all active touches and draw them
            for (int i = 0; i < mTouches.size(); i++) {

                // get the pointer id and associated data for this index
                int id = mTouches.keyAt(i);
                TouchHistory data = mTouches.valueAt(i);

                // draw the data and its history to the canvas
                drawCircle(canvas, id, data);
            }
            */
        }else{
            //canvas.drawColor(Color.WHITE);
/*
            mPaint = new Paint();
            mPaint.setColor(Color.BLUE);
*/
            //canvas.drawCircle(100.0f, 100.0f, 100.0f, mPaint);
            Log.d(TAG, "[mTouchData.x,mTouchData.y] = [" + mTouchData.x + ", " + mTouchData.y + "]");
            //canvas.drawCircle(mTouchData.x, mTouchData.y, CIRCLE_SIZE, mPaint);

            //mPath.moveTo(mTouchData.x - 10.0f, mTouchData.y - 10.0f);
            //mPath.lineTo(mTouchData.x, mTouchData.y);
            //mPath.addCircle(mTouchData.x, mTouchData.y, CIRCLE_SIZE, Path.Direction.CW);
            mPath.close();
//            mPaint = new Paint();

//            mClearView = false;
            if(mClearView){
//                canvas.drawColor(Color.WHITE);
                mPath.reset();
//                mClearView = false;
            }else{
                canvas.drawPath(mPath, mPaint);
            }
            //canvas.drawPath(mPath, mPaint);


            //canvas.drawCircle(100.0f, 100.0f, 0.5f, mPaint);
            //canvas.drawCircle(mTouchData.x, mTouchData.y, 20.0f, mPaint);
        }

//        Log.d(DEBUG_TAG, "onDraw()");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
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

                    getPosition(event);
                    if(mClearView){
                        return false;
                    }
                    mPath.moveTo(mTouchData.x, mTouchData.y);
                    Log.d(DEBUG_TAG, "ACTION_DOWN");
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

                    Log.d(DEBUG_TAG, "ACTION_POINTER_DOWN");
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


                    getPosition(event);
                    if(mClearView){
                        mClearView = false;
                    }
//                    mPath.lineTo(mTouchData.x, mTouchData.y);
                    Log.d(DEBUG_TAG, "ACTION_UP");
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

                    Log.d(DEBUG_TAG, "ACTION_POINTER_UP");
//                    if(mClearView){
//                        return false;
//                    }
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

                    getPosition(event);
                    if(mClearView){
                        return false;
                    }

                    mPath.lineTo(mTouchData.x, mTouchData.y);
                    mPath.moveTo(mTouchData.x, mTouchData.y);
                    Log.d(DEBUG_TAG, "ACTION_MOVE");
                    break;
                }
            }

        }

        this.postInvalidate();

        /** For GestureDetector ? **/
//        {
//            this.mDetector.onTouchEvent(event);
//            // Be sure to call the superclass implementation
//            return super.onTouchEvent(event);
//        }

//        return super.onTouchEvent(event);
        return true;
    }

    void getPosition(MotionEvent event){
        final int pointerCount = event.getPointerCount();
//        Log.d(DEBUG_TAG, "At time " +  event.getEventTime());
        for (int p = 0; p < pointerCount; p++) {
//            Log.d(DEBUG_TAG, "  pointer " + event.getPointerId(p) + ": (" + event.getX(p) + "," + event.getY(p) + ")");
            if( p==0 ){
                mTouchData.x = event.getX(p);
                mTouchData.y = event.getY(p);
            };
            if(p > 0){
                mClearView = true;
            }
//            Log.d(DEBUG_TAG, "  mClearView =  " + mClearView + ", pointerCount = " + pointerCount);
        }
    }
}
