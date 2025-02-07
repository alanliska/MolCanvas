// MolCanvas - simple molecule viewer & editor
// Copyright (c) 2025 J. Heyrovsky Institute of Physical Chemistry (Prague, Czech Republic), Alan Liska, Veronika Ruzickova
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
// The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package cz.jh.molcanvas;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class Spannables {
    public static Spannable colorized(final String text) {
        SpannableString spannable = new SpannableString(text);

        String[] words_red = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-" };
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                spannable.setSpan(new ForegroundColorSpan(argb_red), start, start + word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                substringStart = start + word.length();
            }
        }

        String[] words_comment = { "#", "!" };
        Integer argb_comment = Color.parseColor("#058a47");
        for (String word : words_comment) {
            int substringStart = 0;
            int start;
            while ((start = text.indexOf(word, substringStart)) >= 0) {
                int endOfLine = text.indexOf("\n", start);
                if (endOfLine != -1) {
                    spannable.setSpan(new ForegroundColorSpan(argb_comment), start, endOfLine,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    substringStart = endOfLine;
                } else {
                    spannable.setSpan(new ForegroundColorSpan(argb_comment), start, text.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    substringStart = start + word.length();
                }
            }
        }
        return spannable;
    }
}
