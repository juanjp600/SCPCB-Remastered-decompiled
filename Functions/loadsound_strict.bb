Function loadsound_strict%(arg0$)
    Local local0.sound
    local0 = (New sound)
    local0\Field1 = arg0
    local0\Field0 = $00
    local0\Field3 = $00
    If (enablesfxrelease = $00) Then
        If (local0\Field0 = $00) Then
            local0\Field0 = loadsound(local0\Field1)
        EndIf
    EndIf
    Return (Handle local0)
    Return $00
End Function
