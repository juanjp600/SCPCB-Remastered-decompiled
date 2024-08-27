Function createitemtemplate.itemtemplates(arg0$, arg1$, arg2$, arg3$, arg4$, arg5#, arg6$, arg7$, arg8%, arg9%)
    Local local0$
    Local local1$
    Local local2$
    Local local3$
    Local local4$
    Local local5.itemtemplates
    Local local6%
    Local local7.itemtemplates
    Local local8%
    local0 = scpmodding_processfilepath(arg2)
    local1 = scpmodding_processfilepath(arg3)
    local2 = scpmodding_processfilepath(arg4)
    local3 = scpmodding_processfilepath(arg6)
    local4 = scpmodding_processfilepath(arg7)
    local5 = (New itemtemplates)
    For local7 = Each itemtemplates
        If (((local7\Field5 = local0) And (local7\Field4 <> $00)) <> 0) Then
            local5\Field4 = copyentity(local7\Field4, $00)
            local5\Field6 = local7\Field5
            Exit
        EndIf
    Next
    If (local5\Field4 = $00) Then
        If (arg8 <> $00) Then
            local5\Field4 = loadanimmesh_strict(local0, $00)
            local5\Field12 = $01
        Else
            local5\Field4 = loadmesh_strict(local0, $00)
            local5\Field12 = $00
        EndIf
        local5\Field5 = local0
    EndIf
    local5\Field5 = local0
    If (local3 <> "") Then
        For local7 = Each itemtemplates
            If (((local7\Field15 = local3) And (local7\Field14 <> $00)) <> 0) Then
                local8 = local7\Field14
                Exit
            EndIf
        Next
        If (local8 = $00) Then
            local8 = loadtexture_strict(local3, arg9)
            local5\Field15 = local3
        EndIf
        entitytexture(local5\Field4, local8, $00, $00)
        local5\Field14 = local8
    EndIf
    local5\Field13 = arg5
    scaleentity(local5\Field4, arg5, arg5, arg5, $01)
    For local7 = Each itemtemplates
        If (((local7\Field9 = local1) And (local7\Field7 <> $00)) <> 0) Then
            local5\Field7 = local7\Field7
            If (local7\Field8 <> $00) Then
                local5\Field8 = local7\Field8
            EndIf
            Exit
        EndIf
    Next
    If (local5\Field7 = $00) Then
        local5\Field7 = loadimage_strict(local1)
        local5\Field9 = local1
        maskimage(local5\Field7, $FF, $00, $FF)
    EndIf
    If (local4 <> "") Then
        If (local5\Field8 = $00) Then
            local5\Field8 = loadimage_strict(local4)
            maskimage(local5\Field8, $FF, $00, $FF)
        EndIf
    Else
        local5\Field8 = $00
    EndIf
    local5\Field10 = local2
    local5\Field1 = arg1
    local5\Field0 = arg0
    local5\Field2 = $01
    hideentity(local5\Field4)
    Return local5
    Return Null
End Function
