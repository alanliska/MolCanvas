// MolCanvas - simple molecule viewer & editor
// Copyright (c) 2025 J. Heyrovsky Institute of Physical Chemistry (Prague, Czech Republic), Alan Liska, Veronika Ruzickova
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
// The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package cz.jh.molcanvas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class ColorPicker extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

        SeekBar SeekBarAlpha;
        SeekBar SeekBarRed;
        SeekBar SeekBarGreen;
        SeekBar SeekBarBlue;
        TextView colorArea;
        Button ConfirmColor;
        public int Alpha;
        public int Red;
        public int Green;
        public int Blue;
        public int selCol;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getSupportActionBar().hide();
            setContentView(R.layout.colorpicker);

            SeekBarAlpha = (SeekBar) findViewById(R.id.seekBarAlpha);
            SeekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
            SeekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
            SeekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);
            colorArea = (TextView) findViewById(R.id.colorArea);
            SeekBarAlpha.setOnSeekBarChangeListener(this);
            SeekBarRed.setOnSeekBarChangeListener(this);
            SeekBarGreen.setOnSeekBarChangeListener(this);
            SeekBarBlue.setOnSeekBarChangeListener(this);

            ConfirmColor = (Button) findViewById(R.id.confirmColor);
            ConfirmColor.setOnClickListener(confirmButton);

            // the case when the initially displayed white color is picked but the seekbar position not changed
            selCol = Color.WHITE;
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
            Alpha = SeekBarAlpha.getProgress();
            Red = SeekBarRed.getProgress();
            Green = SeekBarGreen.getProgress();
            Blue = SeekBarBlue.getProgress();
            colorArea.setBackgroundColor(Color.argb(Alpha, Red, Green, Blue));
            selCol = Color.argb(Alpha,Red,Green,Blue);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            // nothing
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            // nothing
        }
        private View.OnClickListener confirmButton;

        {
            confirmButton = new View.OnClickListener() {

                public void onClick(View v) {
                    // TODO Auto-generated method stub //
                    Preferences.get().setIntValue(Preferences.get().getStringValue("changed_variable"),selCol);
                    Intent intent = new Intent(ColorPicker.this, Settings.class);
                    startActivity(intent);
                }
            };
        }
    }
