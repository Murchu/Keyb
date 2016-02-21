package com.example.murphy.keyb;

/**
 * Created by murphy on 26/11/2015.
 */

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

public class MyKeyboard extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener{

    private KeyboardView cKeyBoardView;
    private Keyboard keyboard;

    private boolean caps = false;
    private KeyboardView mInputView;






    @Override
    public View onCreateInputView() {
        cKeyBoardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.arabic);
        cKeyBoardView.setOnKeyboardActionListener(this);
        return cKeyBoardView;
    }



    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {

      /* InputConnection ic = getCurrentInputConnection();

        int cKeyboardState = R.integer.keyboard_qwerty;


        switch (primaryCode){
            case Keyboard.KEYCODE_ALT:
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                cKeyBoardView.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                char code = (char) primaryCode;
                if(Character.isLetter(code) && caps) {
                    code = Character.toUpperCase(code);
                }
                ic.commitText(String.valueOf(code), 1);
        }


*/
        if( primaryCode == Keyboard.KEYCODE_DELETE ) {
            keyboard = new Keyboard(this, R.integer.keyboard_arabic);
            cKeyBoardView.setKeyboard(keyboard);
        }
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}

