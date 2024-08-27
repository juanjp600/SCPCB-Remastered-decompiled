Function streamsound_strict%(arg0$, arg1#, arg2%)
    Local local0.stream
    If (filetype(arg0) <> $01) Then
        createconsolemsg((((("Sound " + chr($22)) + arg0) + chr($22)) + " not found."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        If (consoleopening <> 0) Then
            consoleopen = $01
        EndIf
        Return $00
    EndIf
    local0 = (New stream)
    local0\Field0 = fsound_stream_open(arg0, arg2, $00)
    If (local0\Field0 = $00) Then
        createconsolemsg(((("Failed to stream Sound (returned 0): " + chr($22)) + arg0) + chr($22)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        If (consoleopening <> 0) Then
            consoleopen = $01
        EndIf
        Return $00
    EndIf
    local0\Field1 = fsound_stream_play($FFFFFFFF, local0\Field0)
    If (local0\Field1 = $FFFFFFFF) Then
        createconsolemsg(((("Failed to stream Sound (returned -1): " + chr($22)) + arg0) + chr($22)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        If (consoleopening <> 0) Then
            consoleopen = $01
        EndIf
        Return $FFFFFFFF
    EndIf
    fsound_setvolume(local0\Field1, (Int (arg1 * 255.0)))
    fsound_setpaused(local0\Field1, $00)
    Return (Handle local0)
    Return $00
End Function
