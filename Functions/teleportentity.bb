Function teleportentity%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5%, arg6#, arg7%)
    Local local0%
    Local local1%
    local0 = createpivot($00)
    positionentity(local0, arg1, (arg2 + 0.05), arg3, arg5)
    If (arg7 = $00) Then
        rotateentity(local0, 90.0, 0.0, 0.0, $00)
    Else
        rotateentity(local0, -90.0, 0.0, 0.0, $00)
    EndIf
    local1 = entitypick(local0, arg6)
    If (local1 <> $00) Then
        If (arg7 = $00) Then
            positionentity(arg0, arg1, ((pickedy() + arg4) + 0.02), arg3, arg5)
        Else
            positionentity(arg0, arg1, ((pickedy() + arg4) - 0.02), arg3, arg5)
        EndIf
    Else
        positionentity(arg0, arg1, arg2, arg3, arg5)
    EndIf
    freeentity(local0)
    resetentity(arg0)
    Return $00
End Function
