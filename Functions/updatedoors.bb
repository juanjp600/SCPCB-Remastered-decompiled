Function updatedoors%()
    Local local0.fps_settings
    Local local1%
    Local local2.doors
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local10%
    Local local12%
    Local local13.particles
    local0 = (First fps_settings)
    If (0.0 >= updatedoorstimer) Then
        For local2 = Each doors
            local6 = (Abs (entityx(collider, $00) - entityx(local2\Field0, $01)))
            local7 = (Abs (entityz(collider, $00) - entityz(local2\Field0, $01)))
            local2\Field15 = (local6 + local7)
            If ((hidedistance * 2.0) < local2\Field15) Then
                If (local2\Field0 <> $00) Then
                    hideentity(local2\Field0)
                EndIf
                If (local2\Field2 <> $00) Then
                    hideentity(local2\Field2)
                EndIf
                If (local2\Field1 <> $00) Then
                    hideentity(local2\Field1)
                EndIf
                If (local2\Field3[$00] <> $00) Then
                    hideentity(local2\Field3[$00])
                EndIf
                If (local2\Field3[$01] <> $00) Then
                    hideentity(local2\Field3[$01])
                EndIf
            Else
                If (local2\Field0 <> $00) Then
                    showentity(local2\Field0)
                EndIf
                If (local2\Field2 <> $00) Then
                    showentity(local2\Field2)
                EndIf
                If (local2\Field1 <> $00) Then
                    showentity(local2\Field1)
                EndIf
                If (local2\Field3[$00] <> $00) Then
                    showentity(local2\Field3[$00])
                EndIf
                If (local2\Field3[$01] <> $00) Then
                    showentity(local2\Field3[$01])
                EndIf
            EndIf
            If (playerroom\Field7\Field10 = "room2sl") Then
                If (validroom2slcamroom(local2\Field13) <> 0) Then
                    If (local2\Field0 <> $00) Then
                        showentity(local2\Field0)
                    EndIf
                    If (local2\Field2 <> $00) Then
                        showentity(local2\Field2)
                    EndIf
                    If (local2\Field1 <> $00) Then
                        showentity(local2\Field1)
                    EndIf
                    If (local2\Field3[$00] <> $00) Then
                        showentity(local2\Field3[$00])
                    EndIf
                    If (local2\Field3[$01] <> $00) Then
                        showentity(local2\Field3[$01])
                    EndIf
                EndIf
            EndIf
        Next
        updatedoorstimer = 30.0
    Else
        updatedoorstimer = max((updatedoorstimer - local0\Field3[$00]), 0.0)
    EndIf
    closestbutton = $00
    closestdoor = Null
    For local2 = Each doors
        If ((((hidedistance * 2.0) > local2\Field15) Or (local2\Field23 > $00)) <> 0) Then
            If ((((180.0 <= local2\Field7) Or (0.0 >= local2\Field7)) And (grabbedentity = $00)) <> 0) Then
                For local1 = $00 To $01 Step $01
                    If (local2\Field3[local1] <> $00) Then
                        If (1.0 > (Abs (entityx(collider, $00) - entityx(local2\Field3[local1], $01)))) Then
                            If (1.0 > (Abs (entityz(collider, $00) - entityz(local2\Field3[local1], $01)))) Then
                                local5 = distance(entityx(collider, $01), entityz(collider, $01), entityx(local2\Field3[local1], $01), entityz(local2\Field3[local1], $01))
                                If (0.7 > local5) Then
                                    local8 = createpivot($00)
                                    positionentity(local8, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local8, local2\Field3[local1], 0.0)
                                    If (entitypick(local8, 0.6) = local2\Field3[local1]) Then
                                        If (closestbutton = $00) Then
                                            closestbutton = local2\Field3[local1]
                                            closestdoor = local2
                                        ElseIf (local5 < entitydistance(collider, closestbutton)) Then
                                            closestbutton = local2\Field3[local1]
                                            closestdoor = local2
                                        EndIf
                                    EndIf
                                    freeentity(local8)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
            If (local2\Field5 <> 0) Then
                If (180.0 > local2\Field7) Then
                    Select local2\Field9
                        Case $00
                            local2\Field7 = min(180.0, (((local0\Field3[$00] * 2.0) * (Float (local2\Field8 + $01))) + local2\Field7))
                            moveentity(local2\Field0, (((sin(local2\Field7) * (Float ((local2\Field8 Shl $01) + $01))) * local0\Field3[$00]) / 80.0), 0.0, 0.0)
                            If (local2\Field1 <> $00) Then
                                moveentity(local2\Field1, (((sin(local2\Field7) * (Float (local2\Field8 + $01))) * local0\Field3[$00]) / 80.0), 0.0, 0.0)
                            EndIf
                        Case $01
                            local2\Field7 = min(180.0, (local2\Field7 + (local0\Field3[$00] * 0.8)))
                            moveentity(local2\Field0, ((sin(local2\Field7) * local0\Field3[$00]) / 180.0), 0.0, 0.0)
                            If (local2\Field1 <> $00) Then
                                moveentity(local2\Field1, (((- sin(local2\Field7)) * local0\Field3[$00]) / 180.0), 0.0, 0.0)
                            EndIf
                        Case $02
                            local2\Field7 = min(180.0, (((local0\Field3[$00] * 2.0) * (Float (local2\Field8 + $01))) + local2\Field7))
                            moveentity(local2\Field0, (((sin(local2\Field7) * (Float (local2\Field8 + $01))) * local0\Field3[$00]) / 85.0), 0.0, 0.0)
                            If (local2\Field1 <> $00) Then
                                moveentity(local2\Field1, (((sin(local2\Field7) * (Float ((local2\Field8 Shl $01) + $01))) * local0\Field3[$00]) / 120.0), 0.0, 0.0)
                            EndIf
                        Case $03
                            local2\Field7 = min(180.0, (((local0\Field3[$00] * 2.0) * (Float (local2\Field8 + $01))) + local2\Field7))
                            moveentity(local2\Field0, (((sin(local2\Field7) * (Float ((local2\Field8 Shl $01) + $01))) * local0\Field3[$00]) / 162.0), 0.0, 0.0)
                            If (local2\Field1 <> $00) Then
                                moveentity(local2\Field1, (((sin(local2\Field7) * (Float ((local2\Field8 Shl $01) + $01))) * local0\Field3[$00]) / 162.0), 0.0, 0.0)
                            EndIf
                        Case $04
                            local2\Field7 = min(180.0, (local2\Field7 + (local0\Field3[$00] * 1.4)))
                            moveentity(local2\Field0, ((sin(local2\Field7) * local0\Field3[$00]) / 114.0), 0.0, 0.0)
                    End Select
                Else
                    local2\Field8 = $00
                    resetentity(local2\Field0)
                    If (local2\Field1 <> $00) Then
                        resetentity(local2\Field1)
                    EndIf
                    If (0.0 < local2\Field11) Then
                        local2\Field11 = max(0.0, (local2\Field11 - local0\Field3[$00]))
                        If (((110.0 < (local2\Field11 + local0\Field3[$00])) And (110.0 >= local2\Field11)) <> 0) Then
                            local2\Field16 = playsound2(cautionsfx, camera, local2\Field0, 10.0, 1.0)
                        EndIf
                        If (local2\Field9 = $01) Then
                            local10 = rand($00, $01)
                        Else
                            local10 = rand($00, $02)
                        EndIf
                        If (0.0 = local2\Field11) Then
                            local2\Field5 = (local2\Field5 = $00)
                            local2\Field16 = playsound2(closedoorsfx(local2\Field9, local10), camera, local2\Field0, 10.0, 1.0)
                        EndIf
                    EndIf
                    If ((local2\Field21 And (remotedooron = $01)) <> 0) Then
                        If (2.1 > entitydistance(camera, local2\Field0)) Then
                            If (((((i_714\Field0 = $01) = $00) And ((wearinggasmask = $03) = $00)) And ((wearinghazmat = $03) = $00)) <> 0) Then
                                playsound_strict(horrorsfx($07))
                            EndIf
                            local2\Field5 = $00
                            local2\Field16 = playsound2(closedoorsfx((Int min((Float local2\Field9), 1.0)), rand($00, $02)), camera, local2\Field0, 10.0, 1.0)
                            local2\Field21 = $00
                        EndIf
                    EndIf
                EndIf
            ElseIf (0.0 < local2\Field7) Then
                Select local2\Field9
                    Case $00
                        local2\Field7 = max(0.0, (local2\Field7 - ((local0\Field3[$00] * 2.0) * (Float (local2\Field8 + $01)))))
                        moveentity(local2\Field0, (((sin(local2\Field7) * (- local0\Field3[$00])) * (Float (local2\Field8 + $01))) / 80.0), 0.0, 0.0)
                        If (local2\Field1 <> $00) Then
                            moveentity(local2\Field1, (((sin(local2\Field7) * (Float (local2\Field8 + $01))) * (- local0\Field3[$00])) / 80.0), 0.0, 0.0)
                        EndIf
                    Case $01
                        local2\Field7 = max(0.0, (local2\Field7 - (local0\Field3[$00] * 0.8)))
                        moveentity(local2\Field0, ((sin(local2\Field7) * (- local0\Field3[$00])) / 180.0), 0.0, 0.0)
                        If (local2\Field1 <> $00) Then
                            moveentity(local2\Field1, ((sin(local2\Field7) * local0\Field3[$00]) / 180.0), 0.0, 0.0)
                        EndIf
                        If (((15.0 > local2\Field7) And (15.0 <= (local2\Field7 + local0\Field3[$00]))) <> 0) Then
                            If (particleamount = $02) Then
                                For local1 = $00 To rand($4B, $63) Step $01
                                    local12 = createpivot($00)
                                    positionentity(local12, (entityx(local2\Field2, $01) + rnd(-0.2, 0.2)), (entityy(local2\Field2, $01) + rnd(0.0, 1.2)), (entityz(local2\Field2, $01) + rnd(-0.2, 0.2)), $00)
                                    rotateentity(local12, 0.0, rnd(360.0, 0.0), 0.0, $00)
                                    local13 = createparticle(entityx(local12, $00), entityy(local12, $00), entityz(local12, $00), $02, 0.002, 0.0, $12C)
                                    local13\Field8 = 0.005
                                    rotateentity(local13\Field1, rnd(-20.0, 20.0), rnd(360.0, 0.0), 0.0, $00)
                                    local13\Field15 = -0.00001
                                    local13\Field7 = 0.01
                                    scalesprite(local13\Field0, local13\Field7, local13\Field7)
                                    local13\Field14 = -0.01
                                    entityorder(local13\Field0, $FFFFFFFF)
                                    freeentity(local12)
                                Next
                            EndIf
                        EndIf
                    Case $02
                        local2\Field7 = max(0.0, (local2\Field7 - ((local0\Field3[$00] * 2.0) * (Float (local2\Field8 + $01)))))
                        moveentity(local2\Field0, (((sin(local2\Field7) * (- local0\Field3[$00])) * (Float (local2\Field8 + $01))) / 85.0), 0.0, 0.0)
                        If (local2\Field1 <> $00) Then
                            moveentity(local2\Field1, (((sin(local2\Field7) * (Float (local2\Field8 + $01))) * (- local0\Field3[$00])) / 120.0), 0.0, 0.0)
                        EndIf
                    Case $03
                        local2\Field7 = max(0.0, (local2\Field7 - ((local0\Field3[$00] * 2.0) * (Float (local2\Field8 + $01)))))
                        moveentity(local2\Field0, (((sin(local2\Field7) * (- local0\Field3[$00])) * (Float (local2\Field8 + $01))) / 162.0), 0.0, 0.0)
                        If (local2\Field1 <> $00) Then
                            moveentity(local2\Field1, (((sin(local2\Field7) * (Float (local2\Field8 + $01))) * (- local0\Field3[$00])) / 162.0), 0.0, 0.0)
                        EndIf
                    Case $04
                        local2\Field7 = min(180.0, (local2\Field7 - (local0\Field3[$00] * 1.4)))
                        moveentity(local2\Field0, ((sin(local2\Field7) * (- local0\Field3[$00])) / 114.0), 0.0, 0.0)
                End Select
                If (((local2\Field6 = $00) Or (local2\Field6 = $B4)) <> 0) Then
                    If (0.15 > (Abs (entityz(local2\Field2, $01) - entityz(collider, $00)))) Then
                        If (((Float ((local2\Field9 Shl $01) + $01)) * 0.7) > (Abs (entityx(local2\Field2, $01) - entityx(collider, $00)))) Then
                            local4 = curvevalue((((Sgn (entityz(collider, $00) - entityz(local2\Field2, $01))) * 0.15) + entityz(local2\Field2, $01)), entityz(collider, $00), 5.0)
                            positionentity(collider, entityx(collider, $00), entityy(collider, $00), local4, $00)
                        EndIf
                    EndIf
                ElseIf (0.15 > (Abs (entityx(local2\Field2, $01) - entityx(collider, $00)))) Then
                    If (((Float ((local2\Field9 Shl $01) + $01)) * 0.7) > (Abs (entityz(local2\Field2, $01) - entityz(collider, $00)))) Then
                        local3 = curvevalue((((Sgn (entityx(collider, $00) - entityx(local2\Field2, $01))) * 0.15) + entityx(local2\Field2, $01)), entityx(collider, $00), 5.0)
                        positionentity(collider, local3, entityy(collider, $00), entityz(collider, $00), $00)
                    EndIf
                EndIf
                If (local2\Field26 <> $00) Then
                    showentity(local2\Field26)
                EndIf
            Else
                local2\Field8 = $00
                positionentity(local2\Field0, entityx(local2\Field2, $01), entityy(local2\Field2, $01), entityz(local2\Field2, $01), $00)
                If (local2\Field1 <> $00) Then
                    positionentity(local2\Field1, entityx(local2\Field2, $01), entityy(local2\Field2, $01), entityz(local2\Field2, $01), $00)
                EndIf
                If (((local2\Field1 <> $00) And (local2\Field9 = $00)) <> 0) Then
                    moveentity(local2\Field0, 0.0, 0.0, (8.0 * roomscale))
                    moveentity(local2\Field1, 0.0, 0.0, (8.0 * roomscale))
                EndIf
                If (local2\Field26 <> $00) Then
                    hideentity(local2\Field26)
                EndIf
            EndIf
        EndIf
        updatesoundorigin(local2\Field16, camera, local2\Field2, 10.0, 1.0)
        If (local2\Field26 <> $00) Then
            If (debughud <> 0) Then
                entityalpha(local2\Field26, 0.5)
            Else
                entityalpha(local2\Field26, 0.0)
            EndIf
        EndIf
    Next
    Return $00
End Function
