Null launcher
=============

Null launcher is a launcher that does nothing. Yes, really. It's useful when combined with Wave Launcher, Swapps, and similar.

After installing, press your home button. Then, depending on your Android version, either check the "Use by default" box and tap Null launcher, or tap Null launcher then tap "Always."

If you've accidentally switched to Null Launcher with no way to get out, pinch-zoom on the wallpaper and you can change back to your old launcher.


Compiling
=========

TL;DR : Just like every other Android project.


Debug
-----

To compile in debug mode, run this the first time:

    android update project -p .

And run this every time.

    ant clean
    ant debug


Release
-------

Making a release build is a bit harder, because you need a release key. A howto is available at <https://developer.android.com/tools/publishing/app-signing.html>. Here's an example for generating the key (only do this once):

    android update project -p . # Unless you've already done it, of course.
    keytool -genkey -keystore null_launcher.keystore -alias null_launcher -keyalg RSA -keysize 2048 -validity 10000
    echo "key.store=null_launcher.keystore" > ant.properties
    echo "key.alias=null_launcher" >> ant.properties

And to actually build the program:

    ant clean
    ant release

