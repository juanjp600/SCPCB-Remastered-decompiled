Function updatedeafplayer%()
    Local local0.fps_settings
    local0 = (First fps_settings)
    If (0.0 < deaftimer) Then
        deaftimer = (deaftimer - local0\Field3[$00])
        sfxvolume = 0.0
        If (0.0 < sfxvolume) Then
            controlsoundvolume()
        EndIf
    Else
        deaftimer = 0.0
        sfxvolume = prevsfxvolume
        If (deafplayer <> 0) Then
            controlsoundvolume()
        EndIf
        deafplayer = $00
    EndIf
    Return $00
End Function
