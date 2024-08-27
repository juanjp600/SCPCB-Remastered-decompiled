Function playannouncement%(arg0$)
    If (intercomstreamchn <> $00) Then
        stopstream_strict(intercomstreamchn)
        intercomstreamchn = $00
    EndIf
    intercomstreamchn = streamsound_strict(arg0, sfxvolume, $00)
    Return $00
End Function
