Function updateendings%()
    Local local0.events
    Local local1.npcs
    Local local2.rooms
    Local local3%
    Local local4%
    Local local5.particles
    Local local6.objects
    Local local7.fps_settings
    Local local9%
    Local local10.events
    Local local11.npcs
    Local local12%
    Local local13#
    Local local14.emitters
    Local local15#
    Local local16#
    Local local17.decals
    Local local18#
    local6 = (First objects)
    local7 = (First fps_settings)
    For local0 = Each events
        Select local0\Field0
            Case "gateb"
                If (playerroom = local0\Field1) Then
                    If ((1040.0 * roomscale) < entityy(collider, $00)) Then
                        For local2 = Each rooms
                            hideentity(local2\Field2)
                        Next
                        showentity(local0\Field1\Field2)
                        If (0.0 = local0\Field2) Then
                            drawloading($00, $01)
                            For local3 = $00 To $1F Step $01
                                If (local0\Field1\Field18[local3] <> $00) Then
                                    entityfx(local0\Field1\Field18[local3], $09)
                                EndIf
                            Next
                            For local1 = Each npcs
                                removenpc(local1)
                            Next
                            curr173 = Null
                            curr106 = Null
                            curr096 = Null
                            curr5131 = Null
                            curr650 = Null
                            camerafogmode(camera, $00)
                            secondarylighton = 1.0
                            drawloading($3C, $01)
                            drawloading($5A, $01)
                            local0\Field1\Field22[$00] = createnpc($10, local0\Field1\Field3, 100.0, local0\Field1\Field5)
                            local0\Field1\Field22[$00]\Field9 = 1.0
                            local0\Field1\Field22[$01] = createnpc($13, entityx(local0\Field1\Field19[$04], $01), (entityy(local0\Field1\Field19[$04], $01) + 0.2), entityz(local0\Field1\Field19[$04], $01))
                            local0\Field1\Field22[$01]\Field9 = 0.0
                            local0\Field1\Field22[$01]\Field10 = 10.0
                            local4 = createpivot($00)
                            positionentity(local4, entityx(local0\Field1\Field19[$00], $01), entityy(local0\Field1\Field19[$00], $01), entityz(local0\Field1\Field19[$00], $01), $00)
                            local0\Field1\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\exit1terrain.b3d"), local0\Field1\Field2)
                            scaleentity(local0\Field1\Field19[$00], roomscale, roomscale, roomscale, $01)
                            rotateentity(local0\Field1\Field19[$00], 0.0, (Float local0\Field1\Field6), 0.0, $01)
                            positionentity(local0\Field1\Field19[$00], entityx(local4, $00), entityy(local4, $00), entityz(local4, $00), $01)
                            freeentity(local4)
                            delay($64)
                            createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg(scplang_getphrase("events.gateconsole"), $FF, $00, $00, $00)
                            createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            sky = sky_createsky(scpmodding_processfilepath("GFX\map\sky\sky"), $00)
                            rotateentity(sky, 0.0, (Float (local0\Field1\Field6 - $5A)), 0.0, $00)
                            local0\Field2 = 1.0
                            For local1 = Each npcs
                                If (local1\Field5 = $14) Then
                                    removenpc(local1)
                                ElseIf (local1\Field5 = $1C) Then
                                    removenpc(local1)
                                EndIf
                            Next
                            drawloading($64, $01)
                        Else
                            updatesky()
                            If (((2.0 > local0\Field2) And (i_end\Field2 = "")) <> 0) Then
                                If (2.0 = local0\Field1\Field22[$00]\Field9) Then
                                    shouldplay = $06
                                Else
                                    local0\Field3 = ((local0\Field3 + local7\Field3[$00]) Mod 3600.0)
                                    positionentity(local0\Field1\Field22[$00]\Field4, (entityx(local0\Field1\Field2, $01) + ((cos((local0\Field3 / 10.0)) * 6000.0) * roomscale)), (14000.0 * roomscale), (entityz(local0\Field1\Field2, $01) + ((sin((local0\Field3 / 10.0)) * 6000.0) * roomscale)), $00)
                                    rotateentity(local0\Field1\Field22[$00]\Field4, 7.0, (local0\Field3 / 10.0), 20.0, $00)
                                    shouldplay = $05
                                EndIf
                                If ((320.0 * roomscale) > entitydistance(collider, local0\Field1\Field19[$0A])) Then
                                    local0\Field2 = 2.0
                                    local0\Field1\Field21[$02]\Field5 = $00
                                    local0\Field1\Field21[$02]\Field4 = $06
                                    local0\Field1\Field21[$03]\Field5 = $00
                                    local0\Field1\Field21[$03]\Field4 = $06
                                    local0\Field1\Field22[$02] = createnpc($10, entityx(local0\Field1\Field19[$09], $01), (entityy(local0\Field1\Field19[$09], $01) + 0.5), entityz(local0\Field1\Field19[$09], $01))
                                    local0\Field1\Field22[$02]\Field9 = 3.0
                                    local0\Field1\Field22[$03] = createnpc($10, entityx(local0\Field1\Field19[$07], $01), (entityy(local0\Field1\Field19[$07], $01) - 2.0), entityz(local0\Field1\Field19[$07], $01))
                                    local0\Field1\Field22[$03]\Field9 = 3.0
                                    local0\Field1\Field22[$00]\Field9 = 3.0
                                    playannouncement(scpmodding_processfilepath("SFX\Ending\GateB\682Battle.ogg"))
                                EndIf
                            Else
                                shouldplay = $06
                                local0\Field2 = (local0\Field2 + local7\Field3[$00])
                                If (2800.0 > local0\Field2) Then
                                    local0\Field1\Field22[$00]\Field33 = (entityx(local0\Field1\Field19[$0B], $01) + (sin(((Float millisecs2()) / 25.0)) * 3.0))
                                    local0\Field1\Field22[$00]\Field34 = ((entityy(local0\Field1\Field19[$0B], $01) + cos(((Float millisecs()) / 85.0))) + 9.0)
                                    local0\Field1\Field22[$00]\Field35 = (entityz(local0\Field1\Field19[$0B], $01) + (cos(((Float millisecs()) / 25.0)) * 3.0))
                                    local0\Field1\Field22[$02]\Field33 = (entityx(local0\Field1\Field19[$0B], $01) + (sin(((Float millisecs2()) / 23.0)) * 3.0))
                                    local0\Field1\Field22[$02]\Field34 = ((entityy(local0\Field1\Field19[$0B], $01) + cos(((Float millisecs()) / 83.0))) + 5.0)
                                    local0\Field1\Field22[$02]\Field35 = (entityz(local0\Field1\Field19[$0B], $01) + (cos(((Float millisecs()) / 23.0)) * 3.0))
                                    If (3.0 = local0\Field1\Field22[$03]\Field9) Then
                                        local0\Field1\Field22[$03]\Field33 = (entityx(local0\Field1\Field19[$0B], $01) + (sin(((Float millisecs2()) / 20.0)) * 3.0))
                                        local0\Field1\Field22[$03]\Field34 = ((entityy(local0\Field1\Field19[$0B], $01) + cos(((Float millisecs()) / 80.0))) + 3.5)
                                        local0\Field1\Field22[$03]\Field35 = (entityz(local0\Field1\Field19[$0B], $01) + (cos(((Float millisecs()) / 20.0)) * 3.0))
                                    EndIf
                                EndIf
                            EndIf
                            If (((42.0 < local0\Field2) And (2954.0 > local0\Field2)) <> 0) Then
                                If (49.0 > local0\Field2) Then
                                    camerashake = 0.5
                                ElseIf (((224.0 < local0\Field2) And (231.0 > local0\Field2)) <> 0) Then
                                    camerashake = 0.5
                                ElseIf (((427.0 < local0\Field2) And (434.0 > local0\Field2)) <> 0) Then
                                    camerashake = 0.5
                                ElseIf (((756.0 > local0\Field2) And (763.0 > local0\Field2)) <> 0) Then
                                    camerashake = 0.5
                                ElseIf (((847.0 < local0\Field2) And (861.0 > local0\Field2)) <> 0) Then
                                    camerashake = 1.0
                                ElseIf (((931.0 < local0\Field2) And (945.0 > local0\Field2)) <> 0) Then
                                    camerashake = 1.5
                                ElseIf (((1155.0 < local0\Field2) And (1295.0 > local0\Field2)) <> 0) Then
                                    camerashake = 3.0
                                ElseIf (((1505.0 < local0\Field2) And (1680.0 > local0\Field2)) <> 0) Then
                                    camerashake = 2.0
                                ElseIf (((1785.0 < local0\Field2) And (1890.0 > local0\Field2)) <> 0) Then
                                    camerashake = 2.0
                                ElseIf (((2170.0 < local0\Field2) And (2205.0 > local0\Field2)) <> 0) Then
                                    camerashake = 0.5
                                ElseIf (((2450.0 < local0\Field2) And (2555.0 > local0\Field2)) <> 0) Then
                                    camerashake = 1.5
                                    If (2450.0 >= (local0\Field2 - local7\Field3[$00])) Then
                                        local0\Field6 = streamsound_strict(scpmodding_processfilepath("SFX\Ending\GateB\DetonatingAlphaWarheads.ogg"), sfxvolume, $00)
                                        local0\Field12 = $01
                                    EndIf
                                ElseIf (((2765.0 < local0\Field2) And (2786.0 > local0\Field2)) <> 0) Then
                                    camerashake = 1.0
                                ElseIf (2940.0 < local0\Field2) Then
                                    camerashake = 0.5
                                    local0\Field1\Field22[$00]\Field33 = (entityx(local0\Field1\Field19[$13], $01) + 4.0)
                                    local0\Field1\Field22[$00]\Field34 = (entityy(local0\Field1\Field19[$13], $01) + 4.0)
                                    local0\Field1\Field22[$00]\Field35 = (entityz(local0\Field1\Field19[$13], $01) + 4.0)
                                    local0\Field1\Field22[$02]\Field33 = entityx(local0\Field1\Field19[$13], $01)
                                    local0\Field1\Field22[$02]\Field34 = entityy(local0\Field1\Field19[$13], $01)
                                    local0\Field1\Field22[$02]\Field35 = entityz(local0\Field1\Field19[$13], $01)
                                EndIf
                            EndIf
                            If (3150.0 <= local0\Field2) Then
                                If (5250.0 > local0\Field2) Then
                                    If (local0\Field7 = $00) Then
                                        local0\Field7 = streamsound_strict(scpmodding_processfilepath("SFX\Ending\GateB\Siren.ogg"), sfxvolume, $02)
                                        local0\Field13 = $01
                                    EndIf
                                ElseIf (i_end\Field2 = "") Then
                                    shouldplay = $42
                                    stopstream_strict(local0\Field6)
                                    stopstream_strict(local0\Field7)
                                    local9 = $01
                                    For local10 = Each events
                                        If (local10\Field0 = "room2nuke") Then
                                            local9 = (Int local10\Field2)
                                            Exit
                                        EndIf
                                    Next
                                    If (local9 = $01) Then
                                        explosiontimer = max(explosiontimer, 0.1)
                                        i_end\Field2 = "B2"
                                    Else
                                        playannouncement(scpmodding_processfilepath("SFX\Ending\GateB\AlphaWarheadsFail.ogg"))
                                        local0\Field2 = 5950.0
                                        i_end\Field2 = "B3"
                                    EndIf
                                ElseIf (i_end\Field2 = "B3") Then
                                    local0\Field1\Field22[$00]\Field33 = (entityx(local0\Field1\Field19[$0B], $01) + (sin(((Float millisecs2()) / 25.0)) * 3.0))
                                    local0\Field1\Field22[$00]\Field34 = ((entityy(local0\Field1\Field19[$0B], $01) + cos(((Float millisecs()) / 85.0))) + 9.0)
                                    local0\Field1\Field22[$00]\Field35 = (entityz(local0\Field1\Field19[$0B], $01) + (cos(((Float millisecs()) / 25.0)) * 3.0))
                                    local0\Field1\Field22[$02]\Field33 = (entityx(local0\Field1\Field19[$0B], $01) + (sin(((Float millisecs2()) / 23.0)) * 3.0))
                                    local0\Field1\Field22[$02]\Field34 = ((entityy(local0\Field1\Field19[$0B], $01) + cos(((Float millisecs()) / 83.0))) + 5.0)
                                    local0\Field1\Field22[$02]\Field35 = (entityz(local0\Field1\Field19[$0B], $01) + (cos(((Float millisecs()) / 23.0)) * 3.0))
                                    If (0.0 = local0\Field4) Then
                                        For local1 = Each npcs
                                            If (local1\Field5 = $1C) Then
                                                If (5.0 = local1\Field9) Then
                                                    local1\Field9 = 3.0
                                                    local1\Field37 = findpath(local1, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                                                    local1\Field38 = (Float (rand($0F, $14) * $46))
                                                    local1\Field26 = $5208
                                                EndIf
                                                If (3.0 > entitydistance(local1\Field4, collider)) Then
                                                    local1\Field9 = 5.0
                                                    local1\Field37 = $00
                                                    local1\Field38 = 0.0
                                                    local1\Field22 = 0.0
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                    For local1 = Each npcs
                                        If (local1\Field5 = $1C) Then
                                            If (((5.0 = local1\Field9) And (3.0 > entitydistance(local1\Field4, collider))) <> 0) Then
                                                If (0.0 = local0\Field4) Then
                                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateB\PlayerDetect.ogg")))
                                                    local0\Field4 = (local0\Field4 + local7\Field3[$00])
                                                    For local11 = Each npcs
                                                        If (local11\Field5 = local1\Field5) Then
                                                            local11\Field9 = 5.0
                                                            local11\Field37 = $00
                                                            local11\Field38 = 0.0
                                                            local11\Field22 = 0.0
                                                        EndIf
                                                    Next
                                                    Exit
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                    If (((0.0 < local0\Field4) And (1400.0 >= local0\Field4)) <> 0) Then
                                        local0\Field4 = (local0\Field4 + local7\Field3[$00])
                                        If (700.0 < local0\Field4) Then
                                            If (0.0 = local0\Field5) Then
                                                For local3 = $00 To $01 Step $01
                                                    local1 = createnpc($1C, (entityx(local0\Field1\Field19[$12], $01) + ((Float local3) * 0.4)), (entityy(local0\Field1\Field19[$12], $01) + 0.29), (entityz(local0\Field1\Field19[$12], $01) + ((Float local3) * 0.4)))
                                                Next
                                                local1 = createnpc($1C, entityx(local0\Field1\Field21[$02]\Field0, $01), (entityy(local0\Field1\Field21[$02]\Field0, $01) + 0.29), ((entityz(local0\Field1\Field21[$02]\Field0, $01) + entityz(local0\Field1\Field21[$03]\Field0, $01)) / 2.0))
                                                For local1 = Each npcs
                                                    If (local1\Field5 = $1C) Then
                                                        local1\Field26 = (Int (rnd(30.0, 35.0) * 70.0))
                                                        local1\Field9 = 3.0
                                                        local1\Field10 = 10.0
                                                        local1\Field33 = entityx(collider, $00)
                                                        local1\Field34 = entityy(collider, $00)
                                                        local1\Field35 = entityz(collider, $00)
                                                    EndIf
                                                Next
                                                local0\Field1\Field21[$05]\Field5 = $01
                                                unabletomove = $01
                                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateB\PlayerDetect.ogg")))
                                                local0\Field5 = 1.0
                                            Else
                                                shouldplay = $00
                                            EndIf
                                        ElseIf (((800.0 < local0\Field4) And (1400.0 >= local0\Field4)) <> 0) Then
                                            For local1 = Each npcs
                                                If (local1\Field5 = $1C) Then
                                                    local1\Field33 = entityx(collider, $00)
                                                    local1\Field34 = entityy(collider, $00)
                                                    local1\Field35 = entityz(collider, $00)
                                                    local1\Field53 = "spine"
                                                    local1\Field51 = $01
                                                    local1\Field52 = $01
                                                    local1\Field8 = $00
                                                    local1\Field44 = 0.0
                                                EndIf
                                            Next
                                        EndIf
                                    ElseIf (1300.0 <= local0\Field4) Then
                                        local12 = loadsprite(scpmodding_processfilepath("GFX\bloodsprite.png"), $03, $00)
                                        entityfx(local12, $0B)
                                        scalesprite(local12, 1.5, 1.5)
                                        currspeed = 0.0
                                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateB\Gunshot.ogg")))
                                        chs\Field0 = $00
                                        chs\Field1 = $00
                                        chs\Field3 = $00
                                        chs\Field2 = $00
                                        chs\Field4 = $00
                                        chs\Field5 = $00
                                        killtimer = -0.1
                                        deathmsg = ""
                                        kill($01, $00)
                                        blinktimer = -10.0
                                        For local1 = Each npcs
                                            If (local1\Field5 = $1C) Then
                                                removenpc(local1)
                                            EndIf
                                        Next
                                        removeevent(local0)
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                            If (1855.0 < local0\Field2) Then
                                If (local0\Field1\Field19[$0C] = $00) Then
                                    local0\Field1\Field19[$0C] = copyentity(local6\Field0[$21], $00)
                                    scaleentity(local0\Field1\Field19[$0C], 0.15, 0.15, 0.15, $00)
                                    local9 = (Int ((min((((entitydistance(local0\Field1\Field22[$03]\Field4, collider) / roomscale) - 3000.0) / 4.0), 1000.0) + 12192.0) * roomscale))
                                    positionentity(local0\Field1\Field19[$0C], entityx(local0\Field1\Field22[$03]\Field4, $00), (12192.0 * roomscale), entityz(local0\Field1\Field22[$03]\Field4, $00), $00)
                                    rotateentity(local0\Field1\Field19[$0C], 0.0, ((Float local0\Field1\Field6) + rnd(-10.0, 10.0)), 0.0, $01)
                                    turnentity(local0\Field1\Field19[$0C], 0.0, 0.0, 180.0, $00)
                                ElseIf (340.0 > wrapangle(entityroll(local0\Field1\Field19[$0C], $00))) Then
                                    local13 = wrapangle(entityroll(local0\Field1\Field19[$0C], $00))
                                    turnentity(local0\Field1\Field19[$0C], 0.0, 0.0, ((((Abs sin(local13)) * 2.0) + 5.0) * local7\Field3[$00]), $00)
                                    If (((270.0 > local13) And (270.0 <= wrapangle(entityroll(local0\Field1\Field19[$0C], $00)))) <> 0) Then
                                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Character\Apache\Crash1.ogg")))
                                        local0\Field1\Field22[$03]\Field9 = 4.0
                                        local0\Field1\Field22[$03]\Field10 = 1.0
                                        local0\Field1\Field22[$03]\Field33 = entityx(local0\Field1\Field19[$07], $01)
                                        local0\Field1\Field22[$03]\Field34 = (entityy(local0\Field1\Field19[$07], $01) - 2.5)
                                        local0\Field1\Field22[$03]\Field35 = entityz(local0\Field1\Field19[$07], $01)
                                        local14 = createemitter(entityx(local0\Field1\Field22[$03]\Field4, $00), entityy(local0\Field1\Field22[$03]\Field4, $00), entityz(local0\Field1\Field22[$03]\Field4, $00), $00)
                                        local14\Field7 = playerroom
                                        local14\Field10 = 45.0
                                        local14\Field4 = -0.18
                                        local14\Field5 = $190
                                        local14\Field11 = rnd(0.005, 0.007)
                                        local14\Field12 = -0.004
                                        turnentity(local14\Field0, (Float (($14 * local3) + $FFFFFFB0)), 0.0, 0.0, $00)
                                        entityparent(local14\Field0, local0\Field1\Field22[$03]\Field4, $01)
                                        If (particleamount > $00) Then
                                            For local3 = $00 To (((particleamount - $01) Shl $02) + $03) Step $01
                                                local5 = createparticle(entityx(local0\Field1\Field22[$03]\Field4, $00), entityy(local0\Field1\Field22[$03]\Field4, $00), entityz(local0\Field1\Field22[$03]\Field4, $00), $00, rnd(0.5, 1.0), -0.1, $C8)
                                                local5\Field8 = 0.01
                                                local5\Field15 = 0.01
                                                local5\Field6 = 1.0
                                                local5\Field14 = -0.005
                                                rotateentity(local5\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                                                moveentity(local5\Field1, 0.0, 0.0, 0.3)
                                            Next
                                            For local3 = $00 To (((particleamount - $01) * $06) + $06) Step $01
                                                local5 = createparticle(entityx(local0\Field1\Field22[$03]\Field4, $00), entityy(local0\Field1\Field22[$03]\Field4, $00), entityz(local0\Field1\Field22[$03]\Field4, $00), $00, 0.02, 0.003, $C8)
                                                local5\Field8 = 0.04
                                                local5\Field6 = 1.0
                                                local5\Field14 = -0.005
                                                rotateentity(local5\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                                            Next
                                        EndIf
                                    EndIf
                                Else
                                    hideentity(local0\Field1\Field19[$0C])
                                EndIf
                            EndIf
                        EndIf
                        hideentity(at\Field4[$00])
                        camerafogrange(camera, 5.0, 45.0)
                        local13 = max(sin(entityyaw(collider, $00)), 0.0)
                        camerafogcolor(camera, ((local13 * 50.0) + 200.0), ((local13 * 30.0) + 200.0), 200.0)
                        cameraclscolor(camera, ((local13 * 50.0) + 200.0), ((local13 * 30.0) + 200.0), 200.0)
                        camerarange(camera, 0.05, 60.0)
                        ambientlight(140.0, 140.0, 140.0)
                        If (particleamount > $00) Then
                            If (rand($03, $01) = $01) Then
                                local5 = createparticle((entityx(camera, $00) + rnd(-2.0, 2.0)), (entityy(camera, $00) + rnd(0.9, 2.0)), (entityz(camera, $00) + rnd(-2.0, 2.0)), $02, 0.006, 0.0, $12C)
                                local5\Field8 = rnd(0.002, 0.003)
                                rotateentity(local5\Field1, rnd(-20.0, 20.0), ((Float (local0\Field1\Field6 - $5A)) + rnd(-15.0, 15.0)), 0.0, $00)
                                local5\Field15 = -0.00001
                            EndIf
                        EndIf
                        If (1.0 <> local0\Field1\Field22[$01]\Field9) Then
                            If (((15.0 > entitydistance(local0\Field1\Field22[$01]\Field4, collider)) Or entityvisible(local0\Field1\Field22[$00]\Field4, collider)) <> 0) Then
                                local0\Field1\Field22[$01]\Field9 = 1.0
                                local0\Field1\Field22[$01]\Field11 = 1.0
                            EndIf
                        EndIf
                        If (((8.9 > entitydistance(local0\Field1\Field22[$01]\Field4, collider)) Or (16.9 > entitydistance(local0\Field1\Field19[$05], collider))) <> 0) Then
                            local0\Field1\Field22[$01]\Field11 = 0.0
                        Else
                            local0\Field1\Field22[$01]\Field11 = 1.0
                        EndIf
                    EndIf
                EndIf
            Case "gatea"
                If (playerroom = local0\Field1) Then
                    For local2 = Each rooms
                        hideentity(local2\Field2)
                    Next
                    showentity(local0\Field1\Field2)
                    If (0.0 = local0\Field2) Then
                        drawloading($00, $00)
                        local0\Field1\Field19[$00] = loadrmesh(scpmodding_processfilepath("GFX\map\gateatunnel_opt.rmesh"), Null)
                        positionentity(local0\Field1\Field19[$00], entityx(local0\Field1\Field2, $01), entityy(local0\Field1\Field2, $01), entityz(local0\Field1\Field2, $01), $00)
                        scaleentity(local0\Field1\Field19[$00], roomscale, roomscale, roomscale, $00)
                        entitytype(local0\Field1\Field19[$00], $01, $00)
                        entitypickmode(local0\Field1\Field19[$00], $03, $01)
                        entityparent(local0\Field1\Field19[$00], local0\Field1\Field2, $01)
                        drawloading($1E, $00)
                        For local3 = $00 To local0\Field1\Field28 Step $01
                            If (local0\Field1\Field18[local3] <> $00) Then
                                entityfx(local0\Field1\Field18[local3], $09)
                            EndIf
                        Next
                        For local1 = Each npcs
                            If ((((((local1 <> curr106) And (local1 <> curr173)) And (local1 <> curr650)) And (local1 <> curr096)) And (local1 <> curr5131)) <> 0) Then
                                removenpc(local1)
                            ElseIf (local1\Field5 = $1C) Then
                                removenpc(local1)
                            EndIf
                        Next
                        curr173\Field24 = 1.0
                        curr096 = Null
                        curr5131 = Null
                        curr650 = Null
                        curr096 = Null
                        camerafogmode(camera, $00)
                        secondarylighton = 1.0
                        hidedistance = 35.0
                        For local3 = $02 To $04 Step $01
                            local0\Field1\Field22[local3] = createnpc($10, local0\Field1\Field3, (local0\Field1\Field4 + 11.0), local0\Field1\Field5)
                            local0\Field1\Field22[local3]\Field9 = (Float (contained106 = $00))
                        Next
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg(scplang_getphrase("events.room0091"), $FF, $00, $00, $00)
                        createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        sky = sky_createsky(scpmodding_processfilepath("GFX\map\sky\sky"), $00)
                        rotateentity(sky, 0.0, (Float local0\Field1\Field6), 0.0, $00)
                        drawloading($3C, $00)
                        For local3 = $00 To $01 Step $01
                            local0\Field1\Field22[local3] = createnpc($13, entityx(local0\Field1\Field19[(local3 + $05)], $01), entityy(local0\Field1\Field19[(local3 + $05)], $01), entityz(local0\Field1\Field19[(local3 + $05)], $01))
                            local0\Field1\Field22[local3]\Field9 = 0.0
                            pointentity(local0\Field1\Field22[local3]\Field4, local0\Field1\Field19[$03], 0.0)
                        Next
                        For local3 = $07 To $08 Step $01
                            local0\Field1\Field22[local3] = createnpc($14, (entityx(local0\Field1\Field19[local3], $01) + 0.8), entityy(local0\Field1\Field19[local3], $01), (entityz(local0\Field1\Field19[local3], $01) + 0.8))
                            local0\Field1\Field22[local3]\Field9 = 5.0
                            local0\Field1\Field22[local3]\Field12 = $01
                            pointentity(local0\Field1\Field22[local3]\Field4, local0\Field1\Field19[$03], 0.0)
                        Next
                        For local3 = $05 To $06 Step $01
                            local0\Field1\Field22[local3] = createnpc($14, entityx(local0\Field1\Field19[(local3 + $02)], $01), entityy(local0\Field1\Field19[(local3 + $02)], $01), entityz(local0\Field1\Field19[(local3 + $02)], $01))
                            local0\Field1\Field22[local3]\Field9 = 5.0
                            local0\Field1\Field22[local3]\Field12 = $01
                            pointentity(local0\Field1\Field22[local3]\Field4, local0\Field1\Field19[$03], 0.0)
                        Next
                        If (contained106 <> 0) Then
                            local0\Field1\Field21[$02]\Field4 = $01
                            positionentity(local0\Field1\Field22[$05]\Field4, (entityx(local0\Field1\Field19[$0F], $01) + ((Float (local3 - $06)) * 0.2)), entityy(local0\Field1\Field19[$0F], $01), (entityz(local0\Field1\Field19[$0F], $01) + ((Float (local3 - $06)) * 0.2)), $01)
                            resetentity(local0\Field1\Field22[$05]\Field4)
                        EndIf
                        local15 = entityx(local0\Field1\Field19[$09], $01)
                        local16 = entityz(local0\Field1\Field19[$09], $01)
                        freeentity(local0\Field1\Field19[$09])
                        local0\Field1\Field19[$09] = loadmesh_strict(scpmodding_processfilepath("GFX\map\lightgunbase.b3d"), $00)
                        scaleentity(local0\Field1\Field19[$09], roomscale, roomscale, roomscale, $00)
                        entityfx(local0\Field1\Field19[$09], $00)
                        positionentity(local0\Field1\Field19[$09], local15, (local0\Field1\Field4 + (992.0 * roomscale)), local16, $00)
                        local0\Field1\Field19[$0A] = loadmesh_strict(scpmodding_processfilepath("GFX\map\lightgun.b3d"), $00)
                        entityfx(local0\Field1\Field19[$0A], $00)
                        scaleentity(local0\Field1\Field19[$0A], roomscale, roomscale, roomscale, $00)
                        positionentity(local0\Field1\Field19[$0A], local15, (local0\Field1\Field4 + (1280.0 * roomscale)), (local16 - (176.0 * roomscale)), $01)
                        entityparent(local0\Field1\Field19[$0A], local0\Field1\Field19[$09], $01)
                        rotateentity(local0\Field1\Field19[$09], 0.0, 48.0, 0.0, $00)
                        rotateentity(local0\Field1\Field19[$0A], 40.0, 0.0, 0.0, $00)
                        For local9 = $00 To $14 Step $01
                            For local3 = $00 To $01 Step $01
                                translateentity(local0\Field1\Field22[local3]\Field4, 0.0, -0.04, 0.0, $00)
                            Next
                            For local3 = $05 To $08 Step $01
                                translateentity(local0\Field1\Field22[local3]\Field4, 0.0, -0.04, 0.0, $00)
                            Next
                        Next
                        resetentity(collider)
                        local0\Field2 = 1.0
                        rotateentity(collider, 0.0, (entityyaw(collider, $00) + (Float (local0\Field1\Field6 + $B4))), 0.0, $00)
                        If (contained106 = $00) Then
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateA\106Escape.ogg")))
                        EndIf
                        drawloading($64, $00)
                    Else
                        shouldplay = $11
                        local0\Field2 = (local0\Field2 + local7\Field3[$00])
                        hideentity(at\Field4[$00])
                        camerafogrange(camera, 5.0, 30.0)
                        local13 = max(sin((entityyaw(collider, $00) + 90.0)), 0.0)
                        camerafogcolor(camera, ((local13 * 40.0) + 200.0), ((local13 * 20.0) + 200.0), 200.0)
                        cameraclscolor(camera, ((local13 * 40.0) + 200.0), ((local13 * 20.0) + 200.0), 200.0)
                        camerarange(camera, 0.05, 30.0)
                        ambientlight(140.0, 140.0, 140.0)
                        For local3 = $02 To $04 Step $01
                            If (local0\Field1\Field22[local3] <> Null) Then
                                If (2.0 > local0\Field1\Field22[local3]\Field9) Then
                                    positionentity(local0\Field1\Field22[local3]\Field4, (entityx(local0\Field1\Field19[$03], $01) + ((cos(((local0\Field2 / 10.0) + (Float ($78 * local3)))) * 6000.0) * roomscale)), (local0\Field1\Field4 + 11.0), (entityz(local0\Field1\Field19[$03], $01) + ((sin(((local0\Field2 / 10.0) + (Float ($78 * local3)))) * 6000.0) * roomscale)), $00)
                                    rotateentity(local0\Field1\Field22[local3]\Field4, 7.0, ((local0\Field2 / 10.0) + (Float ($78 * local3))), 20.0, $00)
                                EndIf
                            EndIf
                        Next
                        updatesky()
                        If (350.0 <= local0\Field2) Then
                            If (contained106 = $00) Then
                                If (350.0 > (local0\Field2 - local7\Field3[$00])) Then
                                    curr106\Field9 = -0.1
                                    setnpcframe(curr106, 110.0)
                                    positionentity(curr106\Field4, entityx(local0\Field1\Field19[$03], $01), (entityy(collider, $00) - 50.0), entityz(local0\Field1\Field19[$03], $01), $01)
                                    positionentity(curr106\Field0, entityx(local0\Field1\Field19[$03], $01), (entityy(collider, $00) - 50.0), entityz(local0\Field1\Field19[$03], $01), $01)
                                    local17 = createdecal($00, entityx(local0\Field1\Field19[$03], $01), (entityy(local0\Field1\Field19[$03], $01) + 0.01), entityz(local0\Field1\Field19[$03], $01), 90.0, (Float rand($168, $01)), 0.0)
                                    local17\Field2 = 0.05
                                    local17\Field1 = 0.001
                                    entityalpha(local17\Field0, 0.8)
                                    updatedecals()
                                    playsound_strict(horrorsfx($05))
                                    playsound_strict(decaysfx($00))
                                ElseIf (0.0 > curr106\Field9) Then
                                    hideentity(curr106\Field1)
                                    curr106\Field38 = 7000.0
                                    If (0.0 = curr106\Field11) Then
                                        If (curr106\Field37 <> $01) Then
                                            positionentity(curr106\Field4, entityx(local0\Field1\Field19[$03], $01), entityy(curr106\Field4, $00), entityz(local0\Field1\Field19[$03], $01), $01)
                                            If (-10.0 >= curr106\Field9) Then
                                                local18 = entityy(curr106\Field4, $00)
                                                positionentity(curr106\Field4, entityx(curr106\Field4, $00), entityy(local0\Field1\Field19[$03], $01), entityz(curr106\Field4, $00), $01)
                                                curr106\Field37 = findpath(curr106, entityx(local0\Field1\Field22[$05]\Field4, $01), entityy(local0\Field1\Field22[$05]\Field4, $01), entityz(local0\Field1\Field22[$05]\Field4, $01))
                                                curr106\Field38 = 14000.0
                                                positionentity(curr106\Field4, entityx(curr106\Field4, $00), local18, entityz(curr106\Field4, $00), $01)
                                                resetentity(curr106\Field4)
                                                curr106\Field39 = $01
                                            EndIf
                                        Else
                                            curr106\Field38 = 14000.0
                                            For local3 = $02 To $04 Step $01
                                                local0\Field1\Field22[local3]\Field9 = 3.0
                                                local0\Field1\Field22[local3]\Field33 = entityx(curr106\Field0, $01)
                                                local0\Field1\Field22[local3]\Field34 = (entityy(curr106\Field0, $01) + 5.0)
                                                local0\Field1\Field22[local3]\Field35 = entityz(curr106\Field0, $01)
                                            Next
                                            For local3 = $05 To $08 Step $01
                                                local0\Field1\Field22[local3]\Field9 = 5.0
                                                local0\Field1\Field22[local3]\Field33 = entityx(curr106\Field0, $01)
                                                local0\Field1\Field22[local3]\Field34 = (entityy(curr106\Field0, $01) + 0.4)
                                                local0\Field1\Field22[local3]\Field35 = entityz(curr106\Field0, $01)
                                            Next
                                            local4 = createpivot($00)
                                            positionentity(local4, entityx(local0\Field1\Field19[$0A], $01), entityy(local0\Field1\Field19[$0A], $01), entityz(local0\Field1\Field19[$0A], $01), $00)
                                            pointentity(local4, curr106\Field4, 0.0)
                                            rotateentity(local0\Field1\Field19[$09], 0.0, curveangle(entityyaw(local4, $00), entityyaw(local0\Field1\Field19[$09], $01), 150.0), 0.0, $01)
                                            rotateentity(local0\Field1\Field19[$0A], curveangle(entitypitch(local4, $00), entitypitch(local0\Field1\Field19[$0A], $01), 200.0), entityyaw(local0\Field1\Field19[$09], $01), 0.0, $01)
                                            freeentity(local4)
                                            If (0.0 < local7\Field3[$00]) Then
                                                If (((50.0 >= ((local0\Field2 - local7\Field3[$00]) Mod 100.0)) And (50.0 < (local0\Field2 Mod 100.0))) <> 0) Then
                                                    local17 = createdecal($00, entityx(curr106\Field4, $01), (entityy(local0\Field1\Field19[$03], $01) + 0.01), entityz(curr106\Field4, $01), 90.0, (Float rand($168, $01)), 0.0)
                                                    local17\Field2 = 0.2
                                                    local17\Field1 = 0.004
                                                    local17\Field9 = 90000.0
                                                    entityalpha(local17\Field0, 0.8)
                                                    updatedecals()
                                                    playsound2(oldmansfx(rand($00, $02)), camera, curr106\Field4, 2.0, 1.0)
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                    local18 = distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local0\Field1\Field19[$04], $01), entityz(local0\Field1\Field19[$04], $01))
                                    curr106\Field22 = curvevalue(0.0, curr106\Field22, max((5.0 * local18), 2.0))
                                    If (15.0 > local18) Then
                                        If (local0\Field7 = $00) Then
                                            local0\Field7 = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateA\Franklin.ogg")))
                                        EndIf
                                        If (0.4 > local18) Then
                                            curr106\Field37 = $00
                                            curr106\Field38 = 14000.0
                                            If (0.0 = curr106\Field11) Then
                                                setnpcframe(curr106, 259.0)
                                                If (local0\Field9 <> $00) Then
                                                    freesound_strict(local0\Field9)
                                                    local0\Field9 = $00
                                                EndIf
                                                loadeventsound(local0, scpmodding_processfilepath("SFX\Ending\GateA\106Retreat.ogg"), $00)
                                                local0\Field6 = playsound2(local0\Field9, camera, curr106\Field4, 35.0, 1.0)
                                            EndIf
                                            If (0.0 < local7\Field3[$00]) Then
                                                If (((50.0 >= ((local0\Field2 - local7\Field3[$00]) Mod 160.0)) And (50.0 < (local0\Field2 Mod 160.0))) <> 0) Then
                                                    local17 = createdecal($00, entityx(curr106\Field4, $01), (entityy(local0\Field1\Field19[$03], $01) + 0.01), entityz(curr106\Field4, $01), 90.0, (Float rand($168, $01)), 0.0)
                                                    local17\Field2 = 0.05
                                                    local17\Field1 = 0.004
                                                    local17\Field9 = 90000.0
                                                    entityalpha(local17\Field0, 0.8)
                                                    updatedecals()
                                                EndIf
                                            EndIf
                                            animatenpc(curr106, 259.0, 110.0, -0.1, $00)
                                            curr106\Field11 = (curr106\Field11 + local7\Field3[$00])
                                            positionentity(curr106\Field4, entityx(curr106\Field4, $01), curvevalue((entityy(local0\Field1\Field19[$03], $01) - (curr106\Field11 / 4500.0)), entityy(curr106\Field4, $01), 100.0), entityz(curr106\Field4, $01), $00)
                                            If (700.0 < curr106\Field11) Then
                                                curr106\Field9 = 100000.0
                                                local0\Field3 = 0.0
                                                For local3 = $05 To $08 Step $01
                                                    local0\Field1\Field22[local3]\Field9 = 1.0
                                                Next
                                                For local3 = $02 To $04 Step $01
                                                    local0\Field1\Field22[local3]\Field9 = 2.0
                                                Next
                                                hideentity(curr106\Field0)
                                            EndIf
                                        ElseIf (8.5 > local18) Then
                                            If (0.0 = local0\Field3) Then
                                                local0\Field7 = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateA\HIDTurret.ogg")))
                                                local0\Field3 = 1.0
                                            ElseIf (0.0 < local0\Field3) Then
                                                local0\Field3 = (local0\Field3 + local7\Field3[$00])
                                                If (525.0 <= local0\Field3) Then
                                                    If (525.0 > (local0\Field3 - local7\Field3[$00])) Then
                                                        local5 = createparticle(entityx(curr106\Field0, $01), (entityy(curr106\Field0, $01) + 0.4), entityz(curr106\Field0, $01), $04, 7.0, 0.0, $1D5)
                                                        local5\Field8 = 0.0
                                                        local5\Field6 = 1.0
                                                        entityparent(local5\Field1, curr106\Field4, $01)
                                                        local5 = createparticle(entityx(local0\Field1\Field19[$0A], $01), entityy(local0\Field1\Field19[$0A], $01), entityz(local0\Field1\Field19[$0A], $01), $04, 2.0, 0.0, $1D5)
                                                        rotateentity(local5\Field1, entitypitch(local0\Field1\Field19[$0A], $01), entityyaw(local0\Field1\Field19[$0A], $01), 0.0, $01)
                                                        moveentity(local5\Field1, 0.0, (92.0 * roomscale), (512.0 * roomscale))
                                                        local5\Field8 = 0.0
                                                        local5\Field6 = 1.0
                                                        entityparent(local5\Field1, local0\Field1\Field19[$0A], $01)
                                                    ElseIf (1001.0 > local0\Field3) Then
                                                        camerashake = 0.5
                                                        lightflash = (((Float entityinview(local0\Field1\Field19[$0A], camera)) * 0.5) + 0.3)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (particleamount > $00) Then
                                                For local3 = $00 To (rand($02, (((particleamount - $01) * $06) + $02)) - (Int local18)) Step $01
                                                    local5 = createparticle(entityx(curr106\Field0, $01), (entityy(curr106\Field0, $01) + rnd(0.4, 0.9)), entityz(curr106\Field0, $00), $00, 0.006, -0.002, $28)
                                                    local5\Field8 = 0.005
                                                    local5\Field6 = 0.8
                                                    local5\Field14 = -0.01
                                                    rotateentity(local5\Field1, (- rnd(70.0, 110.0)), rnd(360.0, 0.0), 0.0, $00)
                                                Next
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.0 = local0\Field4) Then
                                    If (1.0 > (Abs (entityy(collider, $00) - entityy(local0\Field1\Field19[$11], $01)))) Then
                                        If (12.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local0\Field1\Field19[$11], $01), entityz(local0\Field1\Field19[$11], $01))) Then
                                            curr106\Field9 = 100000.0
                                            hideentity(curr106\Field0)
                                            For local3 = $05 To $08 Step $01
                                                local0\Field1\Field22[local3]\Field9 = 3.0
                                                positionentity(local0\Field1\Field22[local3]\Field4, (entityx(local0\Field1\Field19[$0F], $01) + ((Float (local3 - $06)) * 0.3)), entityy(local0\Field1\Field19[$0F], $01), (entityz(local0\Field1\Field19[$0F], $01) + ((Float (local3 - $06)) * 0.3)), $01)
                                                resetentity(local0\Field1\Field22[local3]\Field4)
                                                local0\Field1\Field22[local3]\Field37 = findpath(local0\Field1\Field22[local3], entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
                                                local0\Field1\Field22[local3]\Field38 = 140.0
                                                local0\Field1\Field22[local3]\Field26 = $1B58
                                            Next
                                            local0\Field1\Field22[$05]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\ThereHeIs1.ogg"))
                                            playsound2(local0\Field1\Field22[$05]\Field16, camera, local0\Field1\Field22[$05]\Field4, 25.0, 1.0)
                                            local0\Field1\Field21[$02]\Field5 = $01
                                            For local3 = $02 To $04 Step $01
                                                removenpc(local0\Field1\Field22[local3])
                                                local0\Field1\Field22[local3] = Null
                                            Next
                                            local0\Field4 = 1.0
                                        EndIf
                                    EndIf
                                ElseIf (1.0 = local0\Field4) Then
                                    For local3 = $05 To $08 Step $01
                                        If (4.0 < entitydistance(local0\Field1\Field22[local3]\Field4, collider)) Then
                                            local0\Field1\Field22[local3]\Field9 = 3.0
                                        Else
                                            local0\Field1\Field22[local3]\Field9 = 1.0
                                        EndIf
                                    Next
                                    If (1.0 > (Abs (entityy(collider, $00) - entityy(local0\Field1\Field19[$11], $01)))) Then
                                        If (((7.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local0\Field1\Field19[$11], $01), entityz(local0\Field1\Field19[$11], $01))) And (0.0 = local0\Field5)) <> 0) Then
                                            For local3 = $09 To $0C Step $01
                                                local0\Field1\Field22[local3] = createnpc($1B, entityx(local0\Field1\Field19[(local3 + $08)], $01), (entityy(local0\Field1\Field19[(local3 + $08)], $01) + 0.4), entityz(local0\Field1\Field19[(local3 + $08)], $01))
                                            Next
                                            local0\Field6 = playsound2(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateA\Bell1.ogg")), camera, local0\Field1\Field22[$09]\Field4, 10.0, 1.0)
                                            local5 = createparticle(entityx(local0\Field1\Field19[$11], $01), entityy(camera, $01), entityz(local0\Field1\Field19[$11], $01), $04, 8.0, 0.0, $32)
                                            local5\Field8 = 0.15
                                            local5\Field6 = 0.5
                                            local5 = createparticle(entityx(local0\Field1\Field19[$11], $01), entityy(camera, $01), entityz(local0\Field1\Field19[$11], $01), $04, 8.0, 0.0, $32)
                                            local5\Field8 = 0.25
                                            local5\Field6 = 0.5
                                            pointentity(local5\Field1, collider, 0.0)
                                            camerashake = 1.0
                                            lightflash = 1.0
                                            local0\Field4 = 2.0
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field4 = (local0\Field4 + local7\Field3[$00])
                                    local0\Field5 = min((local0\Field5 + local7\Field3[$00]), 600.0)
                                    For local3 = $09 To $0C Step $01
                                        pointentity(local0\Field1\Field22[local3]\Field4, collider, 0.0)
                                        turnentity(local0\Field1\Field22[local3]\Field4, 0.0, (Float local0\Field1\Field6), 0.0, $00)
                                        If (((520.0 < local0\Field5) And (600.0 > local0\Field5)) <> 0) Then
                                            local0\Field1\Field22[$09]\Field9 = 1.0
                                        EndIf
                                    Next
                                    stamina = -5.0
                                    blurtimer = (sin((local0\Field4 * 0.7)) * 1000.0)
                                    If (0.0 = killtimer) Then
                                        camerazoom(camera, ((sin((local0\Field4 * 0.8)) * 0.2) + 1.0))
                                        local18 = entitydistance(collider, local0\Field1\Field19[$11])
                                        If (6.5 > local18) Then
                                            positionentity(collider, curvevalue(entityx(local0\Field1\Field19[$11], $01), entityx(collider, $00), (local18 * 80.0)), entityy(collider, $00), curvevalue(entityz(local0\Field1\Field19[$00], $01), entityz(collider, $00), (local18 * 80.0)), $00)
                                        EndIf
                                    EndIf
                                    If (((50.0 < local0\Field4) And (230.0 > local0\Field4)) <> 0) Then
                                        camerashake = (sin((local0\Field4 - 50.0)) * 3.0)
                                        turnentity(local0\Field1\Field19[$0D], 0.0, ((sin((local0\Field4 - 50.0)) * -0.85) * local7\Field3[$00]), 0.0, $01)
                                        turnentity(local0\Field1\Field19[$0E], 0.0, ((sin((local0\Field4 - 50.0)) * 0.85) * local7\Field3[$00]), 0.0, $01)
                                        For local3 = $05 To $08 Step $01
                                            positionentity(local0\Field1\Field22[local3]\Field4, curvevalue(entityx(local0\Field1\Field21[$02]\Field2, $01), entityx(local0\Field1\Field22[local3]\Field4, $01), 50.0), entityy(local0\Field1\Field22[local3]\Field4, $01), curvevalue(entityz(local0\Field1\Field21[$02]\Field2, $01), entityz(local0\Field1\Field22[local3]\Field4, $01), 50.0), $01)
                                            resetentity(local0\Field1\Field22[local3]\Field4)
                                        Next
                                    EndIf
                                    If (230.0 <= local0\Field4) Then
                                        If (230.0 > (local0\Field4 - local7\Field3[$00])) Then
                                            local0\Field6 = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateA\CI.ogg")))
                                        EndIf
                                        If (((channelplaying(local0\Field6) = $00) And (i_end\Field2 = "")) <> 0) Then
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateA\Bell2.ogg")))
                                            local5 = createparticle(entityx(local0\Field1\Field19[$11], $01), entityy(camera, $01), entityz(local0\Field1\Field19[$11], $01), $04, 8.0, 0.0, $32)
                                            local5\Field8 = 0.15
                                            local5\Field6 = 0.5
                                            local5 = createparticle(entityx(local0\Field1\Field19[$11], $01), entityy(camera, $01), entityz(local0\Field1\Field19[$11], $01), $04, 8.0, 0.0, $32)
                                            local5\Field8 = 0.25
                                            local5\Field6 = 0.5
                                            i_end\Field2 = "A1"
                                            chs\Field0 = $00
                                            chs\Field1 = $00
                                            chs\Field3 = $00
                                            chs\Field2 = $00
                                            chs\Field4 = $00
                                            chs\Field5 = $00
                                            killtimer = -0.1
                                            deathmsg = ""
                                            kill($00, $00)
                                        EndIf
                                        If (i_end\Field2 <> "") Then
                                            camerashake = curvevalue(2.0, camerashake, 10.0)
                                            lightflash = curvevalue(2.0, lightflash, 8.0)
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (0.0 = local0\Field3) Then
                                local0\Field3 = 1.0
                                For local3 = $05 To $08 Step $01
                                    local0\Field1\Field22[local3]\Field9 = 3.0
                                    local0\Field1\Field22[local3]\Field37 = findpath(local0\Field1\Field22[local3], ((entityx(local0\Field1\Field2, $00) - 1.0) + ((Float (local3 Mod $02)) * 2.0)), (entityy(collider, $00) + 0.2), (entityz(local0\Field1\Field2, $00) - ((Float (local3 Mod $02)) * 2.0)))
                                    local0\Field1\Field22[local3]\Field38 = (Float (rand($0F, $14) * $46))
                                    local0\Field1\Field22[local3]\Field26 = $5208
                                Next
                            Else
                                For local3 = $05 To $08 Step $01
                                    If (5.0 = local0\Field1\Field22[local3]\Field9) Then
                                        local0\Field1\Field22[local3]\Field33 = entityx(collider, $00)
                                        local0\Field1\Field22[local3]\Field34 = entityy(collider, $00)
                                        local0\Field1\Field22[local3]\Field35 = entityz(collider, $00)
                                    ElseIf (6.0 > entitydistance(local0\Field1\Field22[local3]\Field4, collider)) Then
                                        local0\Field1\Field22[local3]\Field9 = 5.0
                                        local0\Field1\Field22[local3]\Field22 = 0.0
                                    EndIf
                                Next
                                If (1.0 >= local0\Field3) Then
                                    For local3 = $05 To $08 Step $01
                                        If (5.0 = local0\Field1\Field22[local3]\Field9) Then
                                            For local9 = $05 To $08 Step $01
                                                local0\Field1\Field22[local9]\Field9 = 5.0
                                                local0\Field1\Field22[local9]\Field33 = entityx(collider, $00)
                                                local0\Field1\Field22[local9]\Field34 = entityy(collider, $00)
                                                local0\Field1\Field22[local9]\Field35 = entityz(collider, $00)
                                                local0\Field1\Field22[local9]\Field38 = (Float (rand($07, $0A) * $46))
                                                local0\Field1\Field22[local9]\Field25 = 2000.0
                                                unabletomove = $01
                                            Next
                                            If (1.0 = local0\Field3) Then
                                                local0\Field6 = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ending\GateA\STOPRIGHTTHERE.ogg")))
                                                local0\Field3 = 2.0
                                            EndIf
                                        Else
                                            local0\Field1\Field22[local3]\Field26 = $5208
                                            local0\Field1\Field22[local3]\Field25 = 2000.0
                                            local0\Field1\Field22[local3]\Field11 = 10150.0
                                        EndIf
                                    Next
                                Else
                                    shouldplay = $00
                                    currspeed = 0.0
                                    If (channelplaying(local0\Field6) = $00) Then
                                        playsound_strict(introsfx($09))
                                        i_end\Field2 = "A2"
                                        chs\Field0 = $00
                                        chs\Field1 = $00
                                        chs\Field3 = $00
                                        chs\Field2 = $00
                                        chs\Field4 = $00
                                        chs\Field5 = $00
                                        killtimer = -0.1
                                        deathmsg = ""
                                        kill($00, $00)
                                        blinktimer = -10.0
                                        removeevent(local0)
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideentity(local0\Field1\Field2)
                EndIf
        End Select
    Next
    If (0.0 < explosiontimer) Then
        explosiontimer = (local7\Field3[$00] + explosiontimer)
        If (140.0 > explosiontimer) Then
            If (5.0 > (explosiontimer - local7\Field3[$00])) Then
                explosionsfx = loadsound_strict(scpmodding_processfilepath("SFX\Ending\GateB\Nuke1.ogg"))
                playsound_strict(explosionsfx)
                camerashake = 10.0
                explosiontimer = 5.0
            EndIf
            camerashake = curvevalue((explosiontimer / 60.0), camerashake, 50.0)
        Else
            camerashake = min((explosiontimer / 20.0), 20.0)
            If (140.0 > (explosiontimer - local7\Field3[$00])) Then
                blinktimer = 1.0
                explosionsfx = loadsound_strict(scpmodding_processfilepath("SFX\Ending\GateB\Nuke2.ogg"))
                playsound_strict(explosionsfx)
                For local3 = $00 To (((particleamount + $01) * $0A) + $0A) Step $01
                    local5 = createparticle((entityx(collider, $00) + rnd(-0.5, 0.5)), (entityy(collider, $00) - rnd(0.2, 1.5)), (entityz(collider, $00) + rnd(-0.5, 0.5)), $00, rnd(0.2, 0.6), 0.0, $15E)
                    rotateentity(local5\Field1, -90.0, 0.0, 0.0, $01)
                    local5\Field8 = rnd(0.05, 0.07)
                Next
            EndIf
            lightflash = min(((explosiontimer - 140.0) / 10.0), 5.0)
            If (160.0 < explosiontimer) Then
                killtimer = min(killtimer, -0.1)
            EndIf
            If (500.0 < explosiontimer) Then
                explosiontimer = 0.0
            EndIf
            positionentity(collider, entityx(collider, $00), 200.0, entityz(collider, $00), $00)
        EndIf
    EndIf
    Return $00
End Function
