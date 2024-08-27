Function createdoor.doors(arg0%, arg1#, arg2#, arg3#, arg4#, arg5.rooms, arg6%, arg7%, arg8%, arg9$, arg10%)
    Local local0.doors
    Local local1%
    Local local2%
    Local local3.objects
    Local local4.doors
    local3 = (First objects)
    If (arg5 <> Null) Then
        local1 = arg5\Field2
    EndIf
    local0 = (New doors)
    If (arg7 = $01) Then
        local0\Field0 = copyentity(local3\Field3[$05], $00)
        scaleentity(local0\Field0, (55.0 * roomscale), (55.0 * roomscale), (55.0 * roomscale), $00)
        local0\Field1 = copyentity(local3\Field3[$06], $00)
        scaleentity(local0\Field1, (55.0 * roomscale), (55.0 * roomscale), (55.0 * roomscale), $00)
        local0\Field2 = copyentity(local3\Field3[$04], $00)
        scaleentity(local0\Field2, roomscale, roomscale, roomscale, $00)
        entitytype(local0\Field2, $01, $00)
        entityalpha(local0\Field2, 0.0)
    ElseIf (arg7 = $02) Then
        local0\Field0 = copyentity(local3\Field3[$02], $00)
        scaleentity(local0\Field0, roomscale, roomscale, roomscale, $00)
        local0\Field1 = copyentity(local3\Field3[$03], $00)
        scaleentity(local0\Field1, roomscale, roomscale, roomscale, $00)
        local0\Field2 = copyentity(local3\Field3[$01], $00)
    ElseIf (arg7 = $03) Then
        For local4 = Each doors
            If (((local4 <> local0) And (local4\Field9 = $03)) <> 0) Then
                local0\Field0 = copyentity(local4\Field0, $00)
                local0\Field1 = copyentity(local4\Field1, $00)
                scaleentity(local0\Field0, roomscale, roomscale, roomscale, $00)
                scaleentity(local0\Field1, roomscale, roomscale, roomscale, $00)
                Exit
            EndIf
        Next
        If (local0\Field0 = $00) Then
            local0\Field0 = copyentity(local3\Field3[$07], $00)
            local0\Field1 = copyentity(local0\Field0, $00)
            scaleentity(local0\Field0, roomscale, roomscale, roomscale, $00)
            scaleentity(local0\Field1, roomscale, roomscale, roomscale, $00)
        EndIf
        local0\Field2 = copyentity(local3\Field3[$01], $00)
    Else
        local0\Field0 = copyentity(local3\Field3[$00], $00)
        scaleentity(local0\Field0, ((204.0 * roomscale) / meshwidth(local0\Field0)), ((312.0 * roomscale) / meshheight(local0\Field0)), ((16.0 * roomscale) / meshdepth(local0\Field0)), $00)
        local0\Field2 = copyentity(local3\Field3[$01], $00)
        local0\Field1 = copyentity(local3\Field3[$00], $00)
        scaleentity(local0\Field1, ((204.0 * roomscale) / meshwidth(local0\Field0)), ((312.0 * roomscale) / meshheight(local0\Field0)), ((16.0 * roomscale) / meshdepth(local0\Field0)), $00)
    EndIf
    positionentity(local0\Field2, arg1, arg2, arg3, $00)
    scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
    entitypickmode(local0\Field2, $02, $01)
    entitytype(local0\Field0, $01, $00)
    entitytype(local0\Field1, $01, $00)
    local0\Field18 = doortempid
    doortempid = (doortempid + $01)
    local0\Field12 = arg8
    local0\Field17 = arg9
    local0\Field19 = arg0
    local0\Field20 = $42
    For local2 = $00 To $01 Step $01
        If (arg9 <> "") Then
            local0\Field3[local2] = copyentity(local3\Field4[$02], $00)
            entityfx(local0\Field3[local2], $01)
        ElseIf (arg8 > $00) Then
            local0\Field3[local2] = copyentity(local3\Field4[$01], $00)
        ElseIf (arg8 < $00) Then
            local0\Field3[local2] = copyentity(local3\Field4[$03], $00)
        ElseIf (arg7 = $03) Then
            local0\Field3[local2] = copyentity(local3\Field4[$04], $00)
        ElseIf ((arg7 = $03) = $00) Then
            local0\Field3[local2] = copyentity(local3\Field4[$00], $00)
        EndIf
        scaleentity(local0\Field3[local2], 0.03, 0.03, 0.03, $00)
    Next
    If (arg7 = $01) Then
        positionentity(local0\Field3[$00], (arg1 - (432.0 * roomscale)), (arg2 + 0.7), ((192.0 * roomscale) + arg3), $00)
        positionentity(local0\Field3[$01], ((432.0 * roomscale) + arg1), (arg2 + 0.7), (arg3 - (192.0 * roomscale)), $00)
        rotateentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
        rotateentity(local0\Field3[$01], 0.0, 270.0, 0.0, $00)
    Else
        positionentity(local0\Field3[$00], (arg1 + 0.6), (arg2 + 0.7), (arg3 - 0.1), $00)
        positionentity(local0\Field3[$01], (arg1 - 0.6), (arg2 + 0.7), (arg3 + 0.1), $00)
        rotateentity(local0\Field3[$01], 0.0, 180.0, 0.0, $00)
    EndIf
    entityparent(local0\Field3[$00], local0\Field2, $01)
    entityparent(local0\Field3[$01], local0\Field2, $01)
    entitypickmode(local0\Field3[$00], $02, $01)
    entitypickmode(local0\Field3[$01], $02, $01)
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    rotateentity(local0\Field0, 0.0, arg4, 0.0, $00)
    rotateentity(local0\Field2, 0.0, arg4, 0.0, $00)
    If (local0\Field1 <> $00) Then
        positionentity(local0\Field1, arg1, arg2, arg3, $00)
        If (arg7 = $01) Then
            rotateentity(local0\Field1, 0.0, arg4, 0.0, $00)
        Else
            rotateentity(local0\Field1, 0.0, (arg4 + 180.0), 0.0, $00)
        EndIf
        entityparent(local0\Field1, local1, $01)
    EndIf
    entityparent(local0\Field2, local1, $01)
    entityparent(local0\Field0, local1, $01)
    local0\Field6 = (Int arg4)
    local0\Field5 = arg6
    entitypickmode(local0\Field0, $02, $01)
    If (local0\Field1 <> $00) Then
        entitypickmode(local0\Field1, $02, $01)
    EndIf
    entitypickmode(local0\Field2, $02, $01)
    If (((local0\Field5 And (arg7 = $00)) And (rand($08, $01) = $01)) <> 0) Then
        local0\Field21 = $01
    EndIf
    local0\Field9 = arg7
    local0\Field13 = arg5
    local0\Field24 = $01
    If (arg10 <> 0) Then
        For local4 = Each doors
            If (local4 <> local0) Then
                If (local4\Field26 <> $00) Then
                    local0\Field26 = copyentity(local4\Field26, local0\Field2)
                    entityalpha(local0\Field26, 0.0)
                    entityfx(local0\Field26, $01)
                    entitytype(local0\Field26, $01, $00)
                    entitycolor(local0\Field26, 255.0, 0.0, 0.0)
                    hideentity(local0\Field26)
                    Exit
                EndIf
            EndIf
        Next
        If (local0\Field26 = $00) Then
            local0\Field26 = copyentity(local3\Field3[$0A], $00)
            entityparent(local0\Field26, local0\Field2, $01)
            entityalpha(local0\Field26, 0.0)
            entityfx(local0\Field26, $01)
            entitytype(local0\Field26, $01, $00)
            entitycolor(local0\Field26, 255.0, 0.0, 0.0)
            hideentity(local0\Field26)
        EndIf
    EndIf
    Return local0
    Return Null
End Function
