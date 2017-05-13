#!/bin/bash
timestamp=$(date +%s)
echo "starting run script, with timestamp:"
echo $timestamp
mkdir out/$timestamp
find . -name "*.class" -type f -delete
javac runner.java
echo "Completed compile portion"

java runner $timestamp 55 1 1 1
echo "Completed run"
cd out/$timestamp

/Applications/Lilypond.app/Contents/Resources/bin/lilypond PianoSonataScore.ly
open PianoSonataScore.pdf
open PianoSonataScore.midi
cd ..
cd ..
find . -name "*.class" -type f -delete

