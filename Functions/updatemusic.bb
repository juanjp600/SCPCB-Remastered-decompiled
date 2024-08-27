Function updatemusic%()
    Local local0.fps_settings
    local0 = (First fps_settings)
    If (consoleflush <> 0) Then
        If (channelplaying(consolemusplay) = $00) Then
            consolemusplay = playsound(consolemusflush)
        EndIf
    ElseIf (playcustommusic = $00) Then
        If (nowplaying <> shouldplay) Then
            currmusicvolume = max((currmusicvolume - (local0\Field3[$00] / 250.0)), 0.0)
            If (0.0 = currmusicvolume) Then
                If (nowplaying < $42) Then
                    stopstream_strict(musicchn)
                EndIf
                nowplaying = shouldplay
                musicchn = $00
                currmusic = $00
            EndIf
        Else
            currmusicvolume = (((musicvolume - currmusicvolume) * (local0\Field3[$00] * 0.1)) + currmusicvolume)
        EndIf
        If (nowplaying < $42) Then
            If (currmusic = $00) Then
                musicchn = streamsound_strict(scpmodding_processfilepath((("SFX\Music\" + music(nowplaying)) + ".ogg")), 0.0, $02)
                currmusic = $01
            EndIf
            setstreamvolume_strict(musicchn, currmusicvolume)
        EndIf
    ElseIf (((0.0 < local0\Field3[$00]) Or (optionsmenu = $02)) <> 0) Then
        If (channelplaying(musicchn) = $00) Then
            musicchn = playsound_strict(custommusic)
        EndIf
        channelvolume(musicchn, (1.0 * musicvolume))
    EndIf
    Return $00
End Function
