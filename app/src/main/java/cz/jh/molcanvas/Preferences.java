// MolCanvas - simple molecule viewer & editor
// Copyright (c) 2025 J. Heyrovsky Institute of Physical Chemistry (Prague, Czech Republic), Alan Liska, Veronika Ruzickova
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
// The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package cz.jh.molcanvas;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class Preferences extends AppCompatActivity {
    private static Preferences prefInstance;
    private final SharedPreferences mPrefs;

    public static Preferences get() {
        if (prefInstance == null) {
            prefInstance = new Preferences();
        }
        return prefInstance;
    }

    public Preferences() {
        mPrefs = MainActivity.get().getSharedPreferences("Prefs", 0);
    }

    public void setValue(String variable,float value) {
        mPrefs.edit().putFloat(variable, value).apply();
    }

    public void setIntValue(String variable,int value) {
        mPrefs.edit().putInt(variable, value).apply();
    }

    public void setStringValue(String variable,String value) {
        mPrefs.edit().putString(variable, value).apply();
    }

    public float getValue(String variable) {
        return mPrefs.getFloat(variable, 0);
    }

    public int getIntValue(String variable) {
        return mPrefs.getInt(variable, 0);
    }

    public String getStringValue(String variable) {
        return mPrefs.getString(variable, "");
    }
}
