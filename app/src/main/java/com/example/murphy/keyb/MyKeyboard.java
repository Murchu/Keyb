package com.example.murphy.keyb;

/**
 * Created by murphy on 26/11/2015.
 */

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

public class MyKeyboard extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener{

    private KeyboardView kv;
    private Keyboard keyboard;
    private static final int KEYCODE_SYM = -7;
    private static final int KEYCODE_MORE_SYM = -8;
    private boolean caps = false;


    @Override
    public View onCreateInputView() {
        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        switchKeyboard(R.xml.arabic);
        return kv;
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();

        switch (primaryCode){
            case Keyboard.KEYCODE_MODE_CHANGE:
                switchKeyboard(R.xml.arabic);
                break;
            case Keyboard.KEYCODE_ALT:
                switchKeyboard(R.xml.qwerty);
                break;
             case Keyboard.KEYCODE_CANCEL:
               switchKeyboard(R.xml.hebrew);
                 break;
            case MyKeyboard.KEYCODE_SYM:
                 switchKeyboard(R.xml.sym_numbers);
                 break;
            case MyKeyboard.KEYCODE_MORE_SYM:
                switchKeyboard(R.xml.more_symbols);
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
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


    }

    private void switchKeyboard(int keyboardRes) {
        keyboard = new Keyboard(this, keyboardRes);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
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