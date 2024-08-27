Function animate2#(arg0%, arg1#, arg2%, arg3%, arg4#, arg5%)
    Local local0#
    Local local1.fps_settings
    Local local2%
    local1 = (First fps_settings)
    If (0.0 < arg4) Then
        local0 = max(min(((local1\Field3[$00] * arg4) + arg1), (Float arg3)), (Float arg2))
        If (arg5 <> 0) Then
            If ((Float arg3) <= local0) Then
                local0 = (Float arg2)
            EndIf
        EndIf
    Else
        If (arg2 < arg3) Then
            local2 = arg2
            arg2 = arg3
            arg3 = local2
        EndIf
        If (arg5 <> 0) Then
            local0 = ((local1\Field3[$00] * arg4) + arg1)
            If ((Float arg3) > local0) Then
                local0 = (Float arg2)
            EndIf
            If ((Float arg2) < local0) Then
                local0 = (Float arg3)
            EndIf
        Else
            local0 = max(min(((local1\Field3[$00] * arg4) + arg1), (Float arg2)), (Float arg3))
        EndIf
    EndIf
    setanimtime(arg0, local0, $00)
    Return local0
    Return 0.0
End Function
