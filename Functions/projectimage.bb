Function projectimage%(arg0%, arg1#, arg2#, arg3%, arg4%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5%
    Local local6%
    local0 = (Float imagewidth(arg0))
    local1 = (Float imageheight(arg0))
    If (2048.0 < local0) Then
        local0 = 2048.0
    EndIf
    If (2048.0 < local1) Then
        local1 = 2048.0
    EndIf
    If (1.0 > local0) Then
        local0 = 1.0
    EndIf
    If (1.0 > local1) Then
        local1 = 1.0
    EndIf
    If (2048.0 < arg1) Then
        arg1 = 2048.0
    EndIf
    If (2048.0 < arg2) Then
        arg2 = 2048.0
    EndIf
    If (1.0 > arg1) Then
        arg1 = 1.0
    EndIf
    If (1.0 > arg2) Then
        arg2 = 1.0
    EndIf
    local2 = (arg1 / local0)
    local3 = (arg2 / local1)
    local4 = (2048.0 / (Float realgraphicwidth))
    local5 = (Int (1024.0 - (local0 / 2.0)))
    local6 = (Int (1024.0 - (local1 / 2.0)))
    copyrect($00, $00, (Int local0), (Int local1), local5, local6, imagebuffer(arg0, $00), texturebuffer(arg4, $00))
    scaleentity(arg3, (local2 * local4), (local3 * local4), 0.0001, $00)
    renderworld(1.0)
    Return $00
End Function
