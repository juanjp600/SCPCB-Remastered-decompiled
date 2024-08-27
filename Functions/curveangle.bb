Function curveangle#(arg0#, arg1#, arg2#)
    Local local0.fps_settings
    Local local1#
    local0 = (First fps_settings)
    If (0.0 = local0\Field3[$00]) Then
        Return arg1
    EndIf
    local1 = (wrapangle(arg0) - wrapangle(arg1))
    If (180.0 < local1) Then
        local1 = (local1 - 360.0)
    EndIf
    If (-180.0 > local1) Then
        local1 = (local1 + 360.0)
    EndIf
    Return wrapangle(((((1.0 / arg2) * local0\Field3[$00]) * local1) + arg1))
    Return 0.0
End Function
