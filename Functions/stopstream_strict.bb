Function stopstream_strict%(arg0%)
    Local local0.stream
    local0 = (Object.stream arg0)
    If (local0 = Null) Then
        createconsolemsg("Failed to stop stream Sound: Unknown Stream", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Return $00
    EndIf
    If (((local0\Field1 = $00) Or (local0\Field1 = $FFFFFFFF)) <> 0) Then
        createconsolemsg(("Failed to stop stream Sound: Return value " + (Str local0\Field1)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Return $00
    EndIf
    fsound_stopsound(local0\Field1)
    fsound_stream_stop(local0\Field0)
    fsound_stream_close(local0\Field0)
    Delete local0
    Return $00
End Function
