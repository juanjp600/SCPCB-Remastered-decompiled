Function setstreampaused_strict%(arg0%, arg1%)
    Local local0.stream
    local0 = (Object.stream arg0)
    If (local0 = Null) Then
        createconsolemsg("Failed to pause/unpause stream Sound: Unknown Stream", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Return $00
    EndIf
    If (((local0\Field1 = $00) Or (local0\Field1 = $FFFFFFFF)) <> 0) Then
        createconsolemsg(("Failed to pause/unpause stream Sound: Return value " + (Str local0\Field1)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        Return $00
    EndIf
    fsound_setpaused(local0\Field1, arg1)
    Return $00
End Function
