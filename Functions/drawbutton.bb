Function drawbutton%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7%)
    Local local0%
    Local local1.fonts
    local0 = $00
    local1 = (First fonts)
    drawframe(arg0, arg1, arg2, arg3, $00, $00)
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        color($1E, $1E, $1E)
        If (((mousehit1 And (arg6 = $00)) Or (mouseup1 And arg6)) <> 0) Then
            local0 = $01
            playsound_strict(buttonsfx)
        EndIf
        rect((arg0 + $04), (arg1 + $04), (arg2 - $08), (arg3 - $08), $01)
    Else
        color($00, $00, $00)
    EndIf
    color($FF, $FF, $FF)
    If (arg5 <> 0) Then
        aasetfont(local1\Field0[$01])
    Else
        aasetfont(local1\Field0[$00])
    EndIf
    aatext(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01, 1.0)
    Return local0
    Return $00
End Function
