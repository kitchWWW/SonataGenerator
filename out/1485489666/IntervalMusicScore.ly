%#(set-global-staff-size 10)

\header{
	tagline = "" 
	title = "Interval Music"
	subtitle="#
1485489666
"
}

\paper{
  indent = 2\cm
  left-margin = 1.5\cm
  right-margin = 1.5\cm
  top-margin = 2\cm
  bottom-margin = 1.5\cm
  ragged-last-bottom = ##t
  print-all-headers = ##t
  print-page-number = ##f
}

\score{
\header{
	tagline = "" 
	title = "  "
	subtitle="  "
}
 \new  StaffGroup  <<

\new Staff \with {
    instrumentName = #"
Guitar
"
	midiInstrument = "Acoustic Guitar (nylon)"
  }
\absolute {
\clef
"treble_8"

c'4 

	\bar "|."

}


>>
\layout{}
\midi{}
}

