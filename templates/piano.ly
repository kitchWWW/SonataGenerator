%#(set-global-staff-size 10)

\header{
	tagline = "" 
	title = "Piano Sonata"
	composer = "Brian Ellis"
	subtitle="#
%timeStamp
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

upper = \absolute  {
%part0
}


lower = \absolute {
  \clef bass
%part1
}
\score {

\header{
	tagline = "" 
	title = "  "
	subtitle="  "
	composer = ""
}

  \new PianoStaff \with { instrumentName = #"Piano" }
  <<
    \new Staff = "upper" \upper
    \new Staff = "lower" \lower
  >>
  \layout { }
  \midi { }
}