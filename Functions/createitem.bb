Function createitem.items(arg0$, arg1$, arg2#, arg3#, arg4#, arg5%, arg6%, arg7%, arg8#, arg9%)
    Local local0.items
    Local local1.itemtemplates
    Local local2.objects
    Local local3%
    local0 = (New items)
    local2 = (First objects)
    arg0 = lower(arg0)
    arg1 = lower(arg1)
    For local1 = Each itemtemplates
        If (lower(local1\Field0) = arg0) Then
            If (lower(local1\Field1) = arg1) Then
                local0\Field3 = local1
                local0\Field1 = createpivot($00)
                entityradius(local0\Field1, 0.01, 0.0)
                entitypickmode(local0\Field1, $01, $00)
                local0\Field2 = copyentity(local1\Field4, local0\Field1)
                local0\Field0 = local1\Field0
                showentity(local0\Field1)
                showentity(local0\Field2)
            EndIf
        EndIf
    Next
    local0\Field18 = $00
    If (local0\Field3 = Null) Then
        runtimeerror((((("Item template not found (" + arg0) + ", ") + arg1) + ")"))
    EndIf
    resetentity(local0\Field1)
    positionentity(local0\Field1, arg2, arg3, arg4, $01)
    rotateentity(local0\Field1, 0.0, (Float rand($168, $01)), 0.0, $00)
    local0\Field11 = entitydistance(collider, local0\Field1)
    local0\Field4 = 0.0
    If (arg1 = "cup") Then
        local0\Field5 = arg5
        local0\Field6 = arg6
        local0\Field7 = arg7
        local0\Field8 = arg8
        local3 = copyentity(local2\Field7[$00], $00)
        scaleentity(local3, local0\Field3\Field13, local0\Field3\Field13, local0\Field3\Field13, $01)
        positionentity(local3, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $00)
        entityparent(local3, local0\Field2, $01)
        entitycolor(local3, (Float arg5), (Float arg6), (Float arg7))
        If (0.0 > arg8) Then
            entityfx(local3, $01)
            entityalpha(local3, (Abs arg8))
        Else
            entityalpha(local3, (Abs arg8))
        EndIf
        entityshininess(local3, 1.0)
    EndIf
    local0\Field17 = local0\Field3\Field7
    If (((arg1 = "clipboard") And (arg9 = $00)) <> 0) Then
        arg9 = $0A
        setanimtime(local0\Field2, 17.0, $00)
        local0\Field17 = local0\Field3\Field8
    ElseIf (((arg1 = "wallet") And (arg9 = $00)) <> 0) Then
        arg9 = $0A
        setanimtime(local0\Field2, 0.0, $00)
    EndIf
    local0\Field23 = arg9
    local0\Field22 = (lastitemid + $01)
    lastitemid = local0\Field22
    Return local0
    Return Null
End Function
