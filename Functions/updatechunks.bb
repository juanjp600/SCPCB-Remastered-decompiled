Function updatechunks%(arg0.rooms, arg1%, arg2%)
    Local local0.chunk
    Local local1$
    Local local2%
    Local local3#
    Local local4#
    Local local5.chunk
    Local local6#
    Local local7.npcs
    Local local8%
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17.events
    local11 = 120.0
    local9 = (Float (Int (entityx(collider, $00) / 40.0)))
    local10 = (Float (Int (entityz(collider, $00) / 40.0)))
    local6 = entityy(playerroom\Field2, $00)
    local3 = ((local9 * 40.0) + (- local11))
    local4 = ((local10 * 40.0) + (- local11))
    local12 = $00
    local13 = getiniint(scpmodding_processfilepath("Data\1499chunks.INI"), "general", "count", $00)
    Repeat
        local14 = $00
        For local0 = Each chunk
            If (local3 = local0\Field1) Then
                If (local4 = local0\Field2) Then
                    local14 = $01
                    Exit
                EndIf
            EndIf
        Next
        If (local14 = $00) Then
            local12 = chunkdata((Int (Abs (((local3 + 32.0) / 40.0) Mod 64.0))), (Int (Abs (((local4 + 32.0) / 40.0) Mod 64.0))))
            local5 = createchunk(local12, local3, local6, local4, $00)
            local5\Field5 = $00
        EndIf
        local3 = (local3 + 40.0)
        If (local3 > ((local9 * 40.0) + local11)) Then
            local4 = (local4 + 40.0)
            local3 = ((local9 * 40.0) + (- local11))
        EndIf
    Until (local4 > ((local10 * 40.0) + local11))
    For local0 = Each chunk
        If (local0\Field5 = $00) Then
            If (local11 < distance(entityx(collider, $00), entityz(collider, $00), entityx(local0\Field6, $00), entityz(local0\Field6, $00))) Then
                freeentity(local0\Field6)
                Delete local0
            EndIf
        EndIf
    Next
    local15 = $00
    For local7 = Each npcs
        If (local7\Field5 = $0F) Then
            local15 = (local15 + $01)
        EndIf
    Next
    local16 = $40
    For local17 = Each events
        If (local17\Field1 = playerroom) Then
            If (local17\Field1\Field22[$00] <> Null) Then
                local16 = $10
                Exit
            EndIf
        EndIf
    Next
    If (local15 < local16) Then
        Select rand($01, $08)
            Case $01
                local7 = createnpc($0F, (entityx(collider, $00) + rnd(40.0, 80.0)), (entityy(playerroom\Field2, $00) + 0.5), (entityz(collider, $00) + rnd(40.0, 80.0)))
            Case $02
                local7 = createnpc($0F, (entityx(collider, $00) + rnd(40.0, 80.0)), (entityy(playerroom\Field2, $00) + 0.5), (entityz(collider, $00) + rnd(-40.0, 40.0)))
            Case $03
                local7 = createnpc($0F, (entityx(collider, $00) + rnd(40.0, 80.0)), (entityy(playerroom\Field2, $00) + 0.5), (entityz(collider, $00) + rnd(-40.0, -80.0)))
            Case $04
                local7 = createnpc($0F, (entityx(collider, $00) + rnd(-40.0, 40.0)), (entityy(playerroom\Field2, $00) + 0.5), (entityz(collider, $00) + rnd(-40.0, -80.0)))
            Case $05
                local7 = createnpc($0F, (entityx(collider, $00) + rnd(-40.0, -80.0)), (entityy(playerroom\Field2, $00) + 0.5), (entityz(collider, $00) + rnd(-40.0, -80.0)))
            Case $06
                local7 = createnpc($0F, (entityx(collider, $00) + rnd(-40.0, -80.0)), (entityy(playerroom\Field2, $00) + 0.5), (entityz(collider, $00) + rnd(-40.0, 40.0)))
            Case $07
                local7 = createnpc($0F, (entityx(collider, $00) + rnd(-40.0, -80.0)), (entityy(playerroom\Field2, $00) + 0.5), (entityz(collider, $00) + rnd(40.0, 80.0)))
            Case $08
                local7 = createnpc($0F, (entityx(collider, $00) + rnd(-40.0, 40.0)), (entityy(playerroom\Field2, $00) + 0.5), (entityz(collider, $00) + rnd(40.0, 80.0)))
        End Select
        If (rand($02, $01) = $01) Then
            local7\Field10 = 1500.0
        EndIf
        local7\Field15 = rnd(360.0, 0.0)
    Else
        For local7 = Each npcs
            If (local7\Field5 = $0F) Then
                If (local7\Field12 = $00) Then
                    If (((local11 < entitydistance(local7\Field4, collider)) Or ((entityy(playerroom\Field2, $00) - 5.0) > entityy(local7\Field4, $00))) <> 0) Then
                        removenpc(local7)
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    Return $00
End Function
