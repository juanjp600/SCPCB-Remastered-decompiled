Function millisecs2%()
    Local local0%
    local0 = millisecs()
    If (local0 < $00) Then
        local0 = (local0 + $80000000)
    EndIf
    Return local0
    Return $00
End Function
