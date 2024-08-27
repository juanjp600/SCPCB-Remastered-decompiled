Function curvevalue#(arg0#, arg1#, arg2#)
    Local local0.fps_settings
    local0 = (First fps_settings)
    If (0.0 = local0\Field3[$00]) Then
        Return arg1
    EndIf
    If (arg1 > arg0) Then
        Return max(((((1.0 / arg2) * local0\Field3[$00]) * (arg0 - arg1)) + arg1), arg0)
    Else
        Return min(((((1.0 / arg2) * local0\Field3[$00]) * (arg0 - arg1)) + arg1), arg0)
    EndIf
    Return 0.0
End Function
