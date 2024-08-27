Function updateitems%()
    Local local0%
    Local local1.items
    Local local2.items
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    Local local7%
    Local local8%
    Local local9.fps_settings
    Local local10%
    Local local11%
    Local local12#
    local9 = (First fps_settings)
    local10 = (Int (hidedistance * 0.5))
    local11 = $00
    closestitem = Null
    For local1 = Each items
        local1\Field16 = $00
        If (local1\Field15 = $00) Then
            If ((Float millisecs2()) > local1\Field12) Then
                local1\Field11 = entitydistance(camera, local1\Field1)
                local1\Field12 = (Float (millisecs2() + $2BC))
                If ((Float local10) > local1\Field11) Then
                    showentity(local1\Field1)
                EndIf
            EndIf
            If ((Float local10) > local1\Field11) Then
                showentity(local1\Field1)
                If (1.2 > local1\Field11) Then
                    If (closestitem = Null) Then
                        If (entityinview(local1\Field2, camera) <> 0) Then
                            If (entityvisible(local1\Field1, camera) <> 0) Then
                                closestitem = local1
                            EndIf
                        EndIf
                    ElseIf (((closestitem = local1) Or (entitydistance(camera, closestitem\Field1) > local1\Field11)) <> 0) Then
                        If (entityinview(local1\Field2, camera) <> 0) Then
                            If (entityvisible(local1\Field1, camera) <> 0) Then
                                closestitem = local1
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (entitycollided(local1\Field1, $01) <> 0) Then
                    local1\Field4 = 0.0
                    local1\Field19 = 0.0
                    local1\Field20 = 0.0
                ElseIf (shouldentitiesfall <> 0) Then
                    local8 = linepick(entityx(local1\Field1, $00), entityy(local1\Field1, $00), entityz(local1\Field1, $00), 0.0, -10.0, 0.0, 0.0)
                    If (local8 <> 0) Then
                        local1\Field4 = (local1\Field4 - (local9\Field3[$00] * 0.0004))
                        translateentity(local1\Field1, (local1\Field19 * local9\Field3[$00]), (local1\Field4 * local9\Field3[$00]), (local1\Field20 * local9\Field3[$00]), $00)
                        If (local1\Field18 <> 0) Then
                            resetentity(local1\Field1)
                        EndIf
                    Else
                        local1\Field4 = 0.0
                        local1\Field19 = 0.0
                        local1\Field20 = 0.0
                    EndIf
                Else
                    local1\Field4 = 0.0
                    local1\Field19 = 0.0
                    local1\Field20 = 0.0
                EndIf
                If (((Float local10) * 0.2) > local1\Field11) Then
                    For local2 = Each items
                        If ((((local1 <> local2) And (local2\Field15 = $00)) And (((Float local10) * 0.2) > local2\Field11)) <> 0) Then
                            local3 = (entityx(local2\Field1, $01) - entityx(local1\Field1, $01))
                            local4 = (entityy(local2\Field1, $01) - entityy(local1\Field1, $01))
                            local5 = (entityz(local2\Field1, $01) - entityz(local1\Field1, $01))
                            local12 = ((local3 * local3) + (local5 * local5))
                            If (((0.07 > local12) And (0.25 > (Abs local4))) <> 0) Then
                                If (playerroom\Field7\Field10 <> "room2storage") Then
                                    local3 = ((0.07 - local12) * local3)
                                    local5 = ((0.07 - local12) * local5)
                                    While (0.001 > ((Abs local3) + (Abs local5)))
                                        local3 = (rnd(-0.002, 0.002) + local3)
                                        local5 = (rnd(-0.002, 0.002) + local5)
                                    Wend
                                    translateentity(local2\Field1, local3, 0.0, local5, $00)
                                    translateentity(local1\Field1, (- local3), 0.0, (- local5), $00)
                                EndIf
                            EndIf
                        EndIf
                    Next
                EndIf
            Else
                hideentity(local1\Field1)
            EndIf
        Else
            local1\Field4 = 0.0
            local1\Field19 = 0.0
            local1\Field20 = 0.0
        EndIf
        local11 = $00
    Next
    If (closestitem <> Null) Then
        If (mousehit1 <> 0) Then
            pickitem(closestitem)
        EndIf
    EndIf
    Return $00
End Function
