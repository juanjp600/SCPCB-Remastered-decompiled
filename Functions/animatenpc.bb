Function animatenpc%(arg0.npcs, arg1#, arg2#, arg3#, arg4%)
    Local local0#
    Local local1.fps_settings
    Local local2%
    local1 = (First fps_settings)
    If (0.0 < arg3) Then
        local0 = max(min((arg0\Field14 + (local1\Field3[$00] * arg3)), arg2), arg1)
        If ((arg4 And (arg2 <= local0)) <> 0) Then
            local0 = arg1
        EndIf
    Else
        If (arg2 > arg1) Then
            local2 = (Int arg1)
            arg1 = arg2
            arg2 = (Float local2)
        EndIf
        If (arg4 <> 0) Then
            local0 = (arg0\Field14 + (local1\Field3[$00] * arg3))
            If (arg2 > local0) Then
                local0 = arg1
            ElseIf (arg1 < local0) Then
                local0 = arg2
            EndIf
        Else
            local0 = max(min((arg0\Field14 + (local1\Field3[$00] * arg3)), arg1), arg2)
        EndIf
    EndIf
    setnpcframe(arg0, local0)
    Return $00
End Function
