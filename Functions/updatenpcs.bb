Function updatenpcs%()
    Local local0.npcs
    Local local1.npcs
    Local local2.doors
    Local local3.decals
    Local local4.rooms
    Local local5%
    Local local6%
    Local local7%
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13#
    Local local14#
    Local local15%
    Local local16$
    Local local17.fps_settings
    Local local18%
    Local local19#
    Local local21%
    Local local22%
    Local local23#
    Local local25.waypoints
    Local local26%
    Local local28%
    Local local29%
    Local local30.events
    Local local31%
    Local local32%
    Local local34%
    Local local36#
    Local local37.rooms
    Local local38#
    Local local42#
    Local local43#
    Local local44%
    Local local45.particles
    Local local46%
    Local local47.waypoints
    Local local48.waypoints
    Local local53.forest
    Local local55%
    Local local56%
    Local local58%
    Local local59%
    Local local60$
    Local local68#
    Local local70%
    Local local79%
    Local local80%
    Local local81%
    Local local82#
    Local local83#
    Local local84#
    Local local85#
    local17 = (First fps_settings)
    For local0 = Each npcs
        local0\Field58 = checkfornpcinfacility(local0)
        Select local0\Field5
            Case $08
                If (3.0 <> curr173\Field24) Then
                    local8 = entitydistance(local0\Field4, collider)
                    local0\Field11 = 1.0
                    If (2.0 > local0\Field24) Then
                        If (0.1 < local0\Field71) Then
                            local0\Field24 = 1.0
                            local0\Field71 = max((local0\Field71 - local17\Field3[$00]), 0.1)
                        ElseIf (0.1 = local0\Field71) Then
                            local0\Field24 = 0.0
                            local0\Field71 = 0.0
                        EndIf
                        positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.32), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                        If (0.0 = local0\Field24) Then
                            local21 = $00
                            local22 = $01
                            If (15.0 > local8) Then
                                If (10.0 > local8) Then
                                    If (entityvisible(local0\Field4, collider) <> 0) Then
                                        local21 = $01
                                        local0\Field33 = entityx(collider, $01)
                                        local0\Field34 = entityy(collider, $01)
                                        local0\Field35 = entityz(collider, $01)
                                    EndIf
                                EndIf
                                local23 = max(min((distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field28, local0\Field30) * 2.5), 1.0), 0.0)
                                local0\Field17 = loopsound2(stonedragsfx, local0\Field17, camera, local0\Field4, 10.0, local0\Field9)
                                local0\Field28 = entityx(local0\Field4, $00)
                                local0\Field30 = entityz(local0\Field4, $00)
                                If ((((-16.0 > blinktimer) Or (-6.0 < blinktimer)) And (isnvgblinking = $00)) <> 0) Then
                                    If (entityinview(local0\Field0, camera) <> 0) Then
                                        local22 = $00
                                    EndIf
                                EndIf
                            EndIf
                            If (chs\Field2 <> 0) Then
                                local22 = $01
                            EndIf
                            If (local22 = $00) Then
                                blurvolume = max(max(min(((4.0 - local8) / 6.0), 0.9), 0.1), blurvolume)
                                currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 15.0) * max(((3.5 - local8) / 3.5), 0.0)))
                                If ((((3.5 > local8) And ((millisecs2() - local0\Field26) > $EA60)) And local21) <> 0) Then
                                    playsound_strict(horrorsfx(rand($03, $04)))
                                    local0\Field26 = millisecs2()
                                EndIf
                                If (((1.5 > local8) And (rand($2BC, $01) = $01)) <> 0) Then
                                    playsound2(scp173sfx(rand($00, $02)), camera, local0\Field0, 10.0, 1.0)
                                EndIf
                                If ((((1.5 > local8) And (2.0 < local0\Field27)) And local21) <> 0) Then
                                    currcamerazoom = 40.0
                                    heartbeatrate = max(heartbeatrate, 140.0)
                                    heartbeatvolume = 0.5
                                    Select rand($09, $01)
                                        Case $01
                                            playsound_strict(horrorsfx($01))
                                        Case $02
                                            playsound_strict(horrorsfx($02))
                                        Case $03
                                            playsound_strict(horrorsfx($09))
                                        Case $04
                                            playsound_strict(horrorsfx($0A))
                                        Case $05
                                            playsound_strict(horrorsfx($0E))
                                        Case $06
                                            playsound_strict(horrorsfx($11))
                                        Case $07
                                            playsound_strict(horrorsfx($12))
                                        Case $08
                                            playsound_strict(horrorsfx($13))
                                        Case $09
                                            playsound_strict(horrorsfx($14))
                                    End Select
                                EndIf
                                local0\Field27 = local8
                                local0\Field9 = max(0.0, (local0\Field9 - (local17\Field3[$00] / 20.0)))
                            ElseIf (50.0 < local8) Then
                                If (rand($46, $01) = $01) Then
                                    If ((((playerroom\Field7\Field10 <> "gateb") And (playerroom\Field7\Field10 <> "gatea")) And (playerroom\Field7\Field10 <> "pocketdimension")) <> 0) Then
                                        For local25 = Each waypoints
                                            If (((local25\Field1 = Null) And (rand($05, $01) = $01)) <> 0) Then
                                                local11 = (Abs (entityx(collider, $00) - entityx(local25\Field0, $01)))
                                                If (((25.0 > local11) And (15.0 < local11)) <> 0) Then
                                                    local13 = (Abs (entityz(collider, $00) - entityz(local25\Field0, $01)))
                                                    If (((25.0 > local13) And (15.0 < local13)) <> 0) Then
                                                        positionentity(local0\Field4, entityx(local25\Field0, $01), (entityy(local25\Field0, $01) + 0.25), entityz(local25\Field0, $01), $00)
                                                        resetentity(local0\Field4)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            ElseIf (local8 > (hidedistance * 0.8)) Then
                                If (rand($46, $01) = $01) Then
                                    teleportcloser(local0)
                                EndIf
                            Else
                                local0\Field9 = curvevalue(local23, local0\Field9, 3.0)
                                If (rand($14, $01) = $01) Then
                                    For local2 = Each doors
                                        If (((((local2\Field4 = $00) And (local2\Field5 = $00)) And (local2\Field17 = "")) And (local2\Field12 = $00)) <> 0) Then
                                            For local7 = $00 To $01 Step $01
                                                If (local2\Field3[local7] <> $00) Then
                                                    If (0.5 > (Abs (entityx(local0\Field4, $00) - entityx(local2\Field3[local7], $00)))) Then
                                                        If (0.5 > (Abs (entityz(local0\Field4, $00) - entityz(local2\Field3[local7], $00)))) Then
                                                            If (((180.0 <= local2\Field7) Or (0.0 >= local2\Field7)) <> 0) Then
                                                                local26 = createpivot($00)
                                                                positionentity(local26, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.5), entityz(local0\Field4, $00), $00)
                                                                pointentity(local26, local2\Field3[local7], 0.0)
                                                                moveentity(local26, 0.0, 0.0, (local0\Field21 * 0.6))
                                                                If (entitypick(local26, 0.5) = local2\Field3[local7]) Then
                                                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\DoorOpen173.ogg")))
                                                                    usedoor(local2, $00, $01)
                                                                EndIf
                                                                freeentity(local26)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    Next
                                EndIf
                                If (chs\Field2 <> 0) Then
                                    local21 = $00
                                    local0\Field33 = 0.0
                                    local0\Field34 = 0.0
                                    local0\Field35 = 0.0
                                EndIf
                                If (local21 <> 0) Then
                                    If (0.65 > local8) Then
                                        If (((0.0 <= killtimer) And (chs\Field0 = $00)) <> 0) Then
                                            Select playerroom\Field7\Field10
                                                Case "lockroom","room2closets","room895"
                                                    deathmsg = scplang_getphrase("events.scp1731")
                                                Case "room173intro"
                                                    deathmsg = scplang_getphrase("events.scp1732")
                                                Case "room2doors"
                                                    deathmsg = ((chr($22) + scplang_getphrase("events.scp1733")) + chr($22))
                                                Default
                                                    deathmsg = scplang_getphrase("events.scp1734")
                                            End Select
                                            If (chs\Field0 = $00) Then
                                                local0\Field24 = 1.0
                                            EndIf
                                            playsound_strict(necksnapsfx(rand($00, $02)))
                                            If (rand($02, $01) = $01) Then
                                                turnentity(camera, 0.0, (Float rand($50, $64)), 0.0, $00)
                                            Else
                                                turnentity(camera, 0.0, (Float rand($FFFFFF9C, $FFFFFFB0)), 0.0, $00)
                                            EndIf
                                            kill($00, $00)
                                        EndIf
                                    Else
                                        pointentity(local0\Field4, collider, 0.0)
                                        rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $00)
                                        translateentity(local0\Field4, ((cos((entityyaw(local0\Field4, $00) + 90.0)) * local0\Field21) * local17\Field3[$00]), 0.0, ((sin((entityyaw(local0\Field4, $00) + 90.0)) * local0\Field21) * local17\Field3[$00]), $00)
                                    EndIf
                                ElseIf (0.0 <> local0\Field33) Then
                                    If (0.5 < distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field33, local0\Field35)) Then
                                        aligntovector(local0\Field4, (local0\Field33 - entityx(local0\Field4, $00)), 0.0, (local0\Field35 - entityz(local0\Field4, $00)), $03, 1.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field21 * local17\Field3[$00]))
                                        If (rand($1F4, $01) = $01) Then
                                            local0\Field33 = 0.0
                                            local0\Field34 = 0.0
                                            local0\Field35 = 0.0
                                        EndIf
                                    Else
                                        local0\Field33 = 0.0
                                        local0\Field34 = 0.0
                                        local0\Field35 = 0.0
                                    EndIf
                                Else
                                    If (rand($190, $01) = $01) Then
                                        rotateentity(local0\Field4, 0.0, rnd(360.0, 0.0), 10.0, $00)
                                    EndIf
                                    translateentity(local0\Field4, ((cos((entityyaw(local0\Field4, $00) + 90.0)) * local0\Field21) * local17\Field3[$00]), 0.0, ((sin((entityyaw(local0\Field4, $00) + 90.0)) * local0\Field21) * local17\Field3[$00]), $00)
                                EndIf
                            EndIf
                        EndIf
                        positionentity(local0\Field4, entityx(local0\Field4, $00), min(entityy(local0\Field4, $00), 0.35), entityz(local0\Field4, $00), $00)
                    Else
                        If (local0\Field31 <> Null) Then
                            local28 = $00
                            If (local8 > (hidedistance * 0.7)) Then
                                If (entityvisible(local0\Field0, collider) = $00) Then
                                    local28 = $01
                                EndIf
                            EndIf
                            If (local28 = $00) Then
                                pointentity(local0\Field0, local0\Field31\Field4, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                local8 = entitydistance(local0\Field4, local0\Field31\Field4)
                                moveentity(local0\Field4, 0.0, 0.0, ((local17\Field3[$00] * 0.016) * max(min((((local8 * 2.0) - 1.0) * 0.5), 1.0), -0.5)))
                                local0\Field44 = 1.0
                            Else
                                positionentity(local0\Field4, entityx(local0\Field31\Field4, $00), (entityy(local0\Field31\Field4, $00) + 0.3), entityz(local0\Field31\Field4, $00), $00)
                                resetentity(local0\Field4)
                                local0\Field7 = 0.0
                                local0\Field44 = 0.0
                            EndIf
                        EndIf
                        positionentity(local0\Field0, entityx(local0\Field4, $00), ((entityy(local0\Field4, $00) + 0.05) + (sin(((Float millisecs2()) * 0.08)) * 0.02)), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                        showentity(local0\Field1)
                        positionentity(local0\Field1, entityx(local0\Field4, $00), ((entityy(local0\Field4, $00) - 0.05) + (sin(((Float millisecs2()) * 0.08)) * 0.02)), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                    EndIf
                EndIf
            Case $07
                If (contained106 <> 0) Then
                    local0\Field24 = 1.0
                    hideentity(local0\Field0)
                    hideentity(local0\Field1)
                    positionentity(local0\Field0, 0.0, 500.0, 0.0, $01)
                Else
                    local8 = entitydistance(local0\Field4, collider)
                    local29 = $01
                    If (playerroom\Field7\Field10 = "dimension1499") Then
                        local29 = $00
                    EndIf
                    For local30 = Each events
                        If (local30\Field0 = "room860") Then
                            If (1.0 = local30\Field2) Then
                                local29 = $00
                            EndIf
                            Exit
                        EndIf
                    Next
                    If (((playerroom\Field7\Field10 = "room049") And ((-2848.0 * roomscale) >= entityy(collider, $00))) <> 0) Then
                        local29 = $00
                    EndIf
                    For local30 = Each events
                        If (local30\Field0 = "gatea") Then
                            If (0.0 <> local30\Field2) Then
                                local29 = $01
                                If (playerroom\Field7\Field10 = "dimension1499") Then
                                    local0\Field24 = 1.0
                                Else
                                    local0\Field24 = 0.0
                                EndIf
                            EndIf
                            Exit
                        EndIf
                    Next
                    If (((local29 = $00) And (0.0 >= local0\Field9)) <> 0) Then
                        local0\Field9 = (Float rand($55F0, $6978))
                        positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                    EndIf
                    If (((0.0 = local0\Field24) And local29) <> 0) Then
                        If (0.0 >= local0\Field9) Then
                            If (((entityy(collider, $00) - 20.0) - 0.55) > entityy(local0\Field4, $00)) Then
                                If (playerroom\Field7\Field13 = $00) Then
                                    local3 = createdecal($00, entityx(collider, $00), 0.01, entityz(collider, $00), 90.0, (Float rand($168, $01)), 0.0)
                                    local3\Field2 = 0.05
                                    local3\Field1 = 0.001
                                    entityalpha(local3\Field0, 0.8)
                                    updatedecals()
                                EndIf
                                local0\Field29 = entityy(collider, $00)
                                setanimtime(local0\Field0, 110.0, $00)
                                If (playerroom\Field7\Field10 <> "room895") Then
                                    positionentity(local0\Field4, entityx(collider, $00), (entityy(collider, $00) - 15.0), entityz(collider, $00), $00)
                                EndIf
                                playsound_strict(decaysfx($00))
                            EndIf
                            If (rand($1F4, $01) = $01) Then
                                playsound2(oldmansfx(rand($00, $02)), camera, local0\Field4, 10.0, 1.0)
                            EndIf
                            local0\Field17 = loopsound2(oldmansfx($04), local0\Field17, camera, local0\Field4, 8.0, 0.8)
                            If (-10.0 < local0\Field9) Then
                                shouldplay = $42
                                If (259.0 > local0\Field14) Then
                                    positionentity(local0\Field4, entityx(local0\Field4, $00), (local0\Field29 - 0.15), entityz(local0\Field4, $00), $00)
                                    pointentity(local0\Field0, collider, 0.0)
                                    rotateentity(local0\Field4, 0.0, curvevalue(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 100.0), 0.0, $01)
                                    animatenpc(local0, 110.0, 259.0, 0.15, $00)
                                Else
                                    local0\Field9 = -10.0
                                EndIf
                            Else
                                If (playerroom\Field7\Field10 <> "gatea") Then
                                    shouldplay = $0A
                                EndIf
                                local31 = $00
                                If (8.0 > local8) Then
                                    local31 = entityvisible(local0\Field4, collider)
                                EndIf
                                If (chs\Field2 <> 0) Then
                                    local31 = $00
                                EndIf
                                If (local31 <> 0) Then
                                    If (playerroom\Field7\Field10 <> "gatea") Then
                                        local0\Field38 = 0.0
                                    EndIf
                                    If (entityinview(local0\Field4, camera) <> 0) Then
                                        giveachievement($07, $01)
                                        blurvolume = max(max(min(((4.0 - local8) / 6.0), 0.9), 0.1), blurvolume)
                                        currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 20.0) * max(((4.0 - local8) / 4.0), 0.0)))
                                        If ((millisecs2() - local0\Field26) > $EA60) Then
                                            currcamerazoom = 40.0
                                            playsound_strict(horrorsfx($06))
                                            local0\Field26 = millisecs2()
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field9 = (local0\Field9 - local17\Field3[$00])
                                EndIf
                                If (0.8 < local8) Then
                                    If ((((((25.0 < local8) Or (playerroom\Field7\Field10 = "pocketdimension")) Or local31) Or (local0\Field37 <> $01)) And (playerroom\Field7\Field10 <> "gatea")) <> 0) Then
                                        If (((40.0 < local8) Or (playerroom\Field7\Field10 = "pocketdimension")) <> 0) Then
                                            translateentity(local0\Field4, 0.0, (((entityy(collider, $00) - 0.14) - entityy(local0\Field4, $00)) / 50.0), 0.0, $00)
                                        EndIf
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                        pointentity(local0\Field0, collider, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        If (0.0 <= killtimer) Then
                                            local14 = local0\Field14
                                            animatenpc(local0, 284.0, 333.0, (local0\Field22 * 43.0), $01)
                                            If (((286.0 >= local14) And (286.0 < local0\Field14)) <> 0) Then
                                                playsound2(step2sfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                                            ElseIf (((311.0 >= local14) And (311.0 < local0\Field14)) <> 0) Then
                                                playsound2(step2sfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                                            EndIf
                                        Else
                                            local0\Field22 = 0.0
                                        EndIf
                                        local0\Field38 = max((local0\Field38 - local17\Field3[$00]), 0.0)
                                        If (0.0 >= local0\Field38) Then
                                            local0\Field37 = findpath(local0, entityx(collider, $01), entityy(collider, $01), entityz(collider, $01))
                                            local0\Field38 = 700.0
                                        EndIf
                                    ElseIf (0.0 >= local0\Field38) Then
                                        local0\Field37 = findpath(local0, entityx(collider, $01), entityy(collider, $01), entityz(collider, $01))
                                        local0\Field38 = 700.0
                                        local0\Field22 = 0.0
                                    Else
                                        local0\Field38 = max((local0\Field38 - local17\Field3[$00]), 0.0)
                                        If (local0\Field37 = $02) Then
                                            local0\Field22 = 0.0
                                        ElseIf (local0\Field37 = $01) Then
                                            While (local0\Field36[local0\Field39] = Null)
                                                If (local0\Field39 > $13) Then
                                                    local0\Field39 = $00
                                                    local0\Field37 = $00
                                                    Exit
                                                Else
                                                    local0\Field39 = (local0\Field39 + $01)
                                                EndIf
                                            Wend
                                            If (local0\Field36[local0\Field39] <> Null) Then
                                                translateentity(local0\Field4, 0.0, (((entityy(local0\Field36[local0\Field39]\Field0, $01) - 0.11) - entityy(local0\Field4, $00)) / 50.0), 0.0, $00)
                                                pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                                local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), min(20.0, (local9 * 10.0))), 0.0, $00)
                                                local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                                local14 = animtime(local0\Field0)
                                                animatenpc(local0, 284.0, 333.0, (local0\Field22 * 43.0), $01)
                                                If (((286.0 >= local14) And (286.0 < local0\Field14)) <> 0) Then
                                                    playsound2(step2sfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                                                ElseIf (((311.0 >= local14) And (311.0 < local0\Field14)) <> 0) Then
                                                    playsound2(step2sfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                                                EndIf
                                                If (0.2 > local9) Then
                                                    local0\Field39 = (local0\Field39 + $01)
                                                EndIf
                                            EndIf
                                        ElseIf (local0\Field37 = $00) Then
                                            If (0.0 = local0\Field11) Then
                                                animatenpc(local0, 334.0, 494.0, 0.3, $01)
                                            EndIf
                                            local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                                        EndIf
                                    EndIf
                                ElseIf (((playerroom\Field7\Field10 <> "gatea") And (chs\Field2 = $00)) <> 0) Then
                                    If (0.5 < local8) Then
                                        local0\Field22 = curvevalue((local0\Field21 * 2.5), local0\Field22, 10.0)
                                    Else
                                        local0\Field22 = 0.0
                                    EndIf
                                    animatenpc(local0, 105.0, 110.0, 0.15, $00)
                                    If (((0.0 <= killtimer) And (0.0 <= falltimer)) <> 0) Then
                                        pointentity(local0\Field0, collider, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        If (((110.0 = ceil(local0\Field14)) And (chs\Field0 = $00)) <> 0) Then
                                            playsound_strict(damagesfx($01))
                                            playsound_strict(horrorsfx($05))
                                            If (playerroom\Field7\Field10 = "pocketdimension") Then
                                                deathmsg = scplang_getphrase("events.scp106")
                                                kill($00, $00)
                                            Else
                                                If (rand($02, $01) = $01) Then
                                                    playsound_strict(oldmansfx($03))
                                                Else
                                                    playsound_strict(oldmansfx($09))
                                                EndIf
                                                falltimer = min(-1.0, falltimer)
                                                positionentity(head, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
                                                resetentity(head)
                                                rotateentity(head, 0.0, (entityyaw(camera, $00) + (Float rand($FFFFFFD3, $2D))), 0.0, $00)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                            If ((Float rand($FFFFF254, $FFFFF448)) >= local0\Field9) Then
                                If ((entityinview(local0\Field0, camera) And (5.0 < local8)) = $00) Then
                                    local0\Field9 = (Float rand($55F0, $6978))
                                    positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                                EndIf
                            EndIf
                            If (-250.0 > falltimer) Then
                                movetopocketdimension()
                                local0\Field9 = 250.0
                            EndIf
                            If (0.0 = local0\Field25) Then
                                If (((((10.0 < local8) And (playerroom\Field7\Field10 <> "pocketdimension")) And (playerroom\Field7\Field10 <> "gatea")) And (-5.0 > local0\Field9)) <> 0) Then
                                    If (entityinview(local0\Field0, camera) = $00) Then
                                        turnentity(collider, 0.0, 180.0, 0.0, $00)
                                        local32 = entitypick(collider, 5.0)
                                        turnentity(collider, 0.0, 180.0, 0.0, $00)
                                        If (local32 <> $00) Then
                                            teleportentity(local0\Field4, pickedx(), pickedy(), pickedz(), local0\Field70, $00, 2.0, $00)
                                            pointentity(local0\Field4, collider, 0.0)
                                            rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                                            moveentity(local0\Field4, 0.0, 0.0, -2.0)
                                            If (rand($02, $01) = $01) Then
                                                playsound2(oldmansfx($03), camera, local0\Field4, 10.0, 1.0)
                                            Else
                                                playsound2(oldmansfx($09), camera, local0\Field4, 10.0, 1.0)
                                            EndIf
                                            local0\Field20 = playsound2(oldmansfx((rand($00, $02) + $06)), camera, local0\Field4, 10.0, 1.0)
                                            local0\Field38 = 0.0
                                            local0\Field25 = (700.0 / (Float (selecteddifficulty\Field5 + $01)))
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            local0\Field25 = max(0.0, (local0\Field25 - local17\Field3[$00]))
                            updatesoundorigin(local0\Field20, camera, local0\Field4, 10.0, 1.0)
                        Else
                            local0\Field22 = 0.0
                            moveentity(local0\Field4, 0.0, (((entityy(collider, $00) - 30.0) - entityy(local0\Field4, $00)) / 200.0), 0.0)
                            local0\Field7 = 0.0
                            local0\Field14 = 110.0
                            If (playerroom\Field7\Field13 = $00) Then
                                If (playerroom\Field7\Field10 <> "gatea") Then
                                    If (selecteddifficulty\Field3 <> 0) Then
                                        local0\Field9 = (local0\Field9 - (local17\Field3[$00] * 2.0))
                                    Else
                                        local0\Field9 = (local0\Field9 - local17\Field3[$00])
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        resetentity(local0\Field4)
                        local0\Field7 = 0.0
                        positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.15), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                        positionentity(local0\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                        rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                        moveentity(local0\Field1, 0.0, 0.946, -0.165)
                        If (((playerroom\Field7\Field10 = "pocketdimension") Or (playerroom\Field7\Field10 = "gatea")) <> 0) Then
                            hideentity(local0\Field1)
                        ElseIf (local8 < ((camerafogfar * lightvolume) * 0.6)) Then
                            hideentity(local0\Field1)
                        Else
                            showentity(local0\Field1)
                            entityalpha(local0\Field1, min((local8 - ((camerafogfar * lightvolume) * 0.6)), 1.0))
                        EndIf
                    Else
                        hideentity(local0\Field1)
                    EndIf
                EndIf
            Case $06
                local8 = entitydistance(collider, local0\Field4)
                Select local0\Field9
                    Case 0.0
                        If (8.0 > local8) Then
                            giveachievement($06, $01)
                            If (local0\Field17 = $00) Then
                                local0\Field17 = streamsound_strict(scpmodding_processfilepath("SFX\Music\096.ogg"), 0.0, $02)
                                local0\Field72 = $01
                            Else
                                updatestreamsoundorigin(local0\Field17, camera, local0\Field4, 8.0, 1.0)
                            EndIf
                            If (-1.0 = local0\Field11) Then
                                animatenpc(local0, 936.0, 1263.0, 0.1, $00)
                                If (1262.9 <= local0\Field14) Then
                                    local0\Field9 = 5.0
                                    local0\Field11 = 0.0
                                    local0\Field14 = 312.0
                                EndIf
                            Else
                                animatenpc(local0, 936.0, 1263.0, 0.1, $01)
                                If (420.0 > local0\Field11) Then
                                    local0\Field11 = (local0\Field11 + local17\Field3[$00])
                                ElseIf (rand($01, $05) = $01) Then
                                    local0\Field11 = -1.0
                                Else
                                    local0\Field11 = (Float (rand($00, $03) * $46))
                                EndIf
                            EndIf
                            local10 = wrapangle(deltayaw(local0\Field4, collider))
                            If (chs\Field2 = $00) Then
                                If (((90.0 > local10) Or (270.0 < local10)) <> 0) Then
                                    cameraproject(camera, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.25), entityz(local0\Field4, $00))
                                    If (((0.0 < projectedx()) And ((Float graphicwidth) > projectedx())) <> 0) Then
                                        If (((0.0 < projectedy()) And ((Float graphicheight) > projectedy())) <> 0) Then
                                            If (entityvisible(collider, local0\Field4) <> 0) Then
                                                If (((-16.0 > blinktimer) Or (-6.0 < blinktimer)) <> 0) Then
                                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\096\Triggered.ogg")))
                                                    currcamerazoom = 10.0
                                                    local0\Field14 = 194.0
                                                    stopstream_strict(local0\Field17)
                                                    local0\Field17 = $00
                                                    local0\Field16 = $00
                                                    local0\Field9 = 1.0
                                                    local0\Field11 = 0.0
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Case 4.0
                        currcamerazoom = curvevalue(max(currcamerazoom, ((sin(((Float millisecs2()) / 20.0)) + 1.0) * 10.0)), currcamerazoom, 8.0)
                        If (local0\Field31 = Null) Then
                            If (local0\Field17 = $00) Then
                                local0\Field17 = streamsound_strict(scpmodding_processfilepath("SFX\SCP\096\Scream.ogg"), 0.0, $02)
                                local0\Field72 = $01
                            Else
                                updatestreamsoundorigin(local0\Field17, camera, local0\Field4, 7.5, 1.0)
                            EndIf
                            If (local0\Field20 = $00) Then
                                local0\Field20 = streamsound_strict(scpmodding_processfilepath("SFX\Music\096Chase.ogg"), 0.0, $02)
                                local0\Field73 = $02
                            Else
                                setstreamvolume_strict(local0\Field20, (min(max((8.0 - local8), 0.6), 1.0) * sfxvolume))
                            EndIf
                        EndIf
                        If ((chs\Field2 And (local0\Field31 = Null)) <> 0) Then
                            local0\Field9 = 5.0
                        EndIf
                        If (0.0 <= killtimer) Then
                            If ((Float millisecs2()) > local0\Field11) Then
                                local0\Field26 = $00
                                If (local0\Field31 = Null) Then
                                    If (entityvisible(collider, local0\Field4) <> 0) Then
                                        local0\Field26 = $01
                                    EndIf
                                ElseIf (entityvisible(local0\Field31\Field4, local0\Field4) <> 0) Then
                                    local0\Field26 = $01
                                EndIf
                                local0\Field11 = (Float (millisecs2() + $BB8))
                            EndIf
                            If (local0\Field26 = $01) Then
                                local0\Field38 = max(210.0, local0\Field38)
                                local0\Field37 = $00
                                If (local0\Field31 <> Null) Then
                                    local8 = entitydistance(local0\Field31\Field4, local0\Field4)
                                EndIf
                                If (((2.8 > local8) Or (150.0 > local0\Field14)) <> 0) Then
                                    If (193.0 < local0\Field14) Then
                                        local0\Field14 = 2.0
                                    EndIf
                                    animatenpc(local0, 2.0, 193.0, 0.7, $01)
                                    If (1.0 < local8) Then
                                        local0\Field22 = curvevalue((local0\Field21 * 2.0), local0\Field22, 15.0)
                                    Else
                                        local0\Field22 = 0.0
                                        If (local0\Field31 = Null) Then
                                            If (chs\Field0 = $00) Then
                                                playsound_strict(damagesfx($04))
                                                local26 = createpivot($00)
                                                camerashake = 30.0
                                                blurtimer = 2000.0
                                                deathmsg = scplang_getphrase("events.scp096")
                                                kill($01, $00)
                                                killanim = $01
                                                For local7 = $00 To $06 Step $01
                                                    positionentity(local26, (entityx(collider, $00) + rnd(-0.1, 0.1)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.1, 0.1)), $00)
                                                    turnentity(local26, 90.0, 0.0, 0.0, $00)
                                                    entitypick(local26, 0.3)
                                                    local3 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
                                                    local3\Field2 = rnd(0.2, 0.6)
                                                    entityalpha(local3\Field0, 1.0)
                                                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                                                Next
                                                freeentity(local26)
                                            EndIf
                                        EndIf
                                    EndIf
                                    If (local0\Field31 = Null) Then
                                        pointentity(local0\Field4, collider, 0.0)
                                    Else
                                        pointentity(local0\Field4, local0\Field31\Field4, 0.0)
                                    EndIf
                                Else
                                    If (local0\Field31 = Null) Then
                                        pointentity(local0\Field0, collider, 0.0)
                                    Else
                                        pointentity(local0\Field0, local0\Field31\Field4, 0.0)
                                    EndIf
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 5.0), 0.0, $00)
                                    If (847.0 < local0\Field14) Then
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                    EndIf
                                    If (906.0 > local0\Field14) Then
                                        animatenpc(local0, 737.0, 906.0, (local0\Field21 * 8.0), $00)
                                    Else
                                        animatenpc(local0, 907.0, 935.0, (local0\Field22 * 8.0), $01)
                                    EndIf
                                EndIf
                                rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                            ElseIf (local0\Field37 = $01) Then
                                If (local0\Field36[local0\Field39] = Null) Then
                                    If (local0\Field39 > $13) Then
                                        local0\Field39 = $00
                                        local0\Field37 = $00
                                    Else
                                        local0\Field39 = (local0\Field39 + $01)
                                    EndIf
                                Else
                                    pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 5.0), 0.0, $00)
                                    If (847.0 < local0\Field14) Then
                                        local0\Field22 = curvevalue((local0\Field21 * 1.5), local0\Field22, 15.0)
                                    EndIf
                                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                    If (906.0 > local0\Field14) Then
                                        animatenpc(local0, 737.0, 906.0, (local0\Field21 * 8.0), $00)
                                    Else
                                        animatenpc(local0, 907.0, 935.0, (local0\Field22 * 8.0), $01)
                                    EndIf
                                    local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                    If (0.8 > local9) Then
                                        If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                            If (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                local0\Field36[local0\Field39]\Field1\Field5 = $01
                                                local0\Field36[local0\Field39]\Field1\Field8 = $01
                                                playsound2(opendoorfastsfx((Int rnd(0.0, 1.0))), camera, local0\Field36[local0\Field39]\Field1\Field0, 10.0, 1.0)
                                            EndIf
                                        EndIf
                                        If (0.7 > local9) Then
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    EndIf
                                EndIf
                            Else
                                animatenpc(local0, 1471.0, 1556.0, 0.1, $01)
                                local0\Field38 = max(0.0, (local0\Field38 - local17\Field3[$00]))
                                If (0.0 >= local0\Field38) Then
                                    If (local0\Field31 <> Null) Then
                                        local0\Field37 = findpath(local0, entityx(local0\Field31\Field4, $00), (entityy(local0\Field31\Field4, $00) + 0.2), entityz(local0\Field31\Field4, $00))
                                    Else
                                        local0\Field37 = findpath(local0, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
                                    EndIf
                                    local0\Field38 = 350.0
                                EndIf
                            EndIf
                            If (((32.0 < local8) Or (-50.0 > entityy(local0\Field4, $00))) <> 0) Then
                                If (rand($32, $01) = $01) Then
                                    teleportcloser(local0)
                                EndIf
                            EndIf
                        Else
                            animatenpc(local0, min(27.0, animtime(local0\Field0)), 193.0, 0.5, $01)
                        EndIf
                        If (24.0 < local8) Then
                            If (rand($32, $01) = $01) Then
                                For local25 = Each waypoints
                                    If (((local25\Field1 = Null) And (rand($05, $01) = $01)) <> 0) Then
                                        local11 = (Abs (entityx(local0\Field4, $00) - entityx(local25\Field0, $01)))
                                        If (((28.0 > local11) And (20.0 < local11)) <> 0) Then
                                            local13 = (Abs (entityz(local0\Field4, $00) - entityz(local25\Field0, $01)))
                                            If (((28.0 > local13) And (20.0 < local13)) <> 0) Then
                                                local0\Field37 = $00
                                                local0\Field38 = 0.0
                                                local0\Field39 = $00
                                                positionentity(local0\Field4, entityx(local25\Field0, $01), (entityy(local25\Field0, $01) + 0.25), entityz(local25\Field0, $01), $00)
                                                resetentity(local0\Field4)
                                                Exit
                                            EndIf
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        EndIf
                    Case 1.0,2.0,3.0
                        If (local0\Field17 = $00) Then
                            local0\Field17 = streamsound_strict(scpmodding_processfilepath("SFX\Music\096Angered.ogg"), 0.0, $02)
                            local0\Field72 = $01
                        Else
                            updatestreamsoundorigin(local0\Field17, camera, local0\Field4, 10.0, 1.0)
                        EndIf
                        If (1.0 = local0\Field9) Then
                            If (312.0 > local0\Field14) Then
                                animatenpc(local0, 193.0, 311.0, 0.3, $00)
                                If (310.9 < local0\Field14) Then
                                    local0\Field9 = 2.0
                                    local0\Field14 = 737.0
                                EndIf
                            ElseIf (((312.0 <= local0\Field14) And (422.0 >= local0\Field14)) <> 0) Then
                                animatenpc(local0, 312.0, 422.0, 0.3, $00)
                                If (421.9 < local0\Field14) Then
                                    local0\Field14 = 677.0
                                EndIf
                            Else
                                animatenpc(local0, 677.0, 736.0, 0.3, $00)
                                If (735.9 < local0\Field14) Then
                                    local0\Field9 = 2.0
                                    local0\Field14 = 737.0
                                EndIf
                            EndIf
                        ElseIf (2.0 = local0\Field9) Then
                            animatenpc(local0, 677.0, 737.0, 0.3, $00)
                            If (737.0 <= local0\Field14) Then
                                local0\Field9 = 3.0
                                local0\Field10 = 0.0
                            EndIf
                        ElseIf (3.0 = local0\Field9) Then
                            local0\Field10 = (local0\Field10 + local17\Field3[$00])
                            If (1820.0 < local0\Field10) Then
                                animatenpc(local0, 823.0, 847.0, (local0\Field21 * 5.0), $00)
                                If (846.9 < local0\Field14) Then
                                    local0\Field9 = 4.0
                                    stopstream_strict(local0\Field17)
                                    local0\Field17 = $00
                                EndIf
                            Else
                                animatenpc(local0, 1471.0, 1556.0, 0.4, $01)
                            EndIf
                        EndIf
                    Case 5.0
                        If (16.0 > local8) Then
                            If (4.0 > local8) Then
                                giveachievement($06, $01)
                            EndIf
                            If (local0\Field17 = $00) Then
                                local0\Field17 = streamsound_strict(scpmodding_processfilepath("SFX\Music\096.ogg"), 0.0, $02)
                                local0\Field72 = $01
                            Else
                                updatestreamsoundorigin(local0\Field17, camera, local0\Field4, 14.0, 1.0)
                            EndIf
                            If (422.0 <= local0\Field14) Then
                                local0\Field10 = (local0\Field10 + local17\Field3[$00])
                                If (1000.0 < local0\Field10) Then
                                    If (1600.0 < local0\Field10) Then
                                        local0\Field10 = (Float rand($00, $1F4))
                                    EndIf
                                    If (1382.0 > local0\Field14) Then
                                        local0\Field22 = curvevalue((local0\Field21 * 0.1), local0\Field22, 5.0)
                                        animatenpc(local0, 1369.0, 1382.0, (local0\Field22 * 45.0), $00)
                                    Else
                                        local0\Field22 = curvevalue((local0\Field21 * 0.1), local0\Field22, 5.0)
                                        animatenpc(local0, 1383.0, 1456.0, (local0\Field22 * 45.0), $01)
                                    EndIf
                                    If ((Float millisecs2()) > local0\Field11) Then
                                        local0\Field26 = $00
                                        If (entityvisible(collider, local0\Field4) <> 0) Then
                                            local0\Field26 = $01
                                        Else
                                            hideentity(local0\Field4)
                                            entitypick(local0\Field4, 1.5)
                                            If (pickedentity() <> $00) Then
                                                local0\Field15 = (entityyaw(local0\Field4, $00) + rnd(80.0, 110.0))
                                            EndIf
                                            showentity(local0\Field4)
                                        EndIf
                                        local0\Field11 = (Float (millisecs2() + $BB8))
                                    EndIf
                                    If (local0\Field26 <> 0) Then
                                        pointentity(local0\Field0, collider, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 130.0), 0.0, $00)
                                        If (1.5 > local8) Then
                                            local0\Field10 = 0.0
                                        EndIf
                                    Else
                                        rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 50.0), 0.0, $00)
                                    EndIf
                                ElseIf (472.0 < local0\Field14) Then
                                    local0\Field22 = curvevalue((local0\Field21 * 0.05), local0\Field22, 8.0)
                                    animatenpc(local0, 1383.0, 1469.0, (local0\Field22 * 45.0), $00)
                                    If (1468.9 <= local0\Field14) Then
                                        local0\Field14 = 423.0
                                    EndIf
                                Else
                                    local0\Field22 = curvevalue(0.0, local0\Field22, 4.0)
                                    animatenpc(local0, 423.0, 471.0, 0.2, $01)
                                EndIf
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                            Else
                                animatenpc(local0, 312.0, 422.0, 0.3, $00)
                            EndIf
                            local10 = wrapangle(deltayaw(local0\Field4, camera))
                            If (chs\Field2 = $00) Then
                                If (((55.0 > local10) Or (305.0 < local10)) <> 0) Then
                                    cameraproject(camera, entityx(local0\Field4, $00), ((entityy(collider, $00) + 1.16) - 0.25), entityz(local0\Field4, $00))
                                    If (((0.0 < projectedx()) And ((Float graphicwidth) > projectedx())) <> 0) Then
                                        If (((0.0 < projectedy()) And ((Float graphicheight) > projectedy())) <> 0) Then
                                            If (entityvisible(collider, local0\Field4) <> 0) Then
                                                If (((-16.0 > blinktimer) Or (-6.0 < blinktimer)) <> 0) Then
                                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\096\Triggered.ogg")))
                                                    currcamerazoom = 10.0
                                                    If (422.0 <= local0\Field14) Then
                                                        local0\Field14 = 677.0
                                                    EndIf
                                                    stopstream_strict(local0\Field17)
                                                    local0\Field17 = $00
                                                    local0\Field16 = $00
                                                    local0\Field9 = 2.0
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                End Select
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.03), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
            Case $03
                local14 = local0\Field14
                local8 = entitydistance(collider, local0\Field4)
                local0\Field49 = 1.0
                If (0.1 < local0\Field24) Then
                    If (playerroom\Field7\Field10 <> "room049") Then
                        local0\Field24 = max((local0\Field24 - ((Float (selecteddifficulty\Field3 + $01)) * local17\Field3[$00])), 0.1)
                    EndIf
                    local0\Field7 = 0.0
                    If (channelplaying(local0\Field17) <> 0) Then
                        stopchannel(local0\Field17)
                    EndIf
                    If (channelplaying(local0\Field20) <> 0) Then
                        stopchannel(local0\Field20)
                    EndIf
                    positionentity(local0\Field4, 0.0, -500.0, 0.0, $00)
                    positionentity(local0\Field0, 0.0, -500.0, 0.0, $00)
                Else
                    If (0.1 = local0\Field24) Then
                        If (playerinreachableroom($00) <> 0) Then
                            For local7 = $00 To $03 Step $01
                                If (playerroom\Field24[local7] <> Null) Then
                                    For local34 = $00 To $03 Step $01
                                        If (playerroom\Field24[local7]\Field24[local34] <> Null) Then
                                            teleportentity(local0\Field4, playerroom\Field24[local7]\Field24[local34]\Field3, 0.5, playerroom\Field24[local7]\Field24[local34]\Field5, local0\Field70, $01, 2.0, $00)
                                            Exit
                                        EndIf
                                    Next
                                    Exit
                                EndIf
                            Next
                            local0\Field24 = 0.0
                        EndIf
                    EndIf
                    Select local0\Field9
                        Case 0.0
                        Case 1.0
                            If (538.0 <= local0\Field14) Then
                                animatenpc(local0, 659.0, 538.0, -0.45, $00)
                                If (537.9 < local0\Field14) Then
                                    local0\Field14 = 37.0
                                EndIf
                            Else
                                animatenpc(local0, 37.0, 269.0, 0.7, $00)
                                If (268.9 < local0\Field14) Then
                                    local0\Field9 = 2.0
                                EndIf
                            EndIf
                        Case 2.0
                            If ((((local8 < (hidedistance * 2.0)) And (0.0 = local0\Field24)) And playerinreachableroom($01)) <> 0) Then
                                local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 10.0, 1.0)
                                local15 = menpcseesplayer(local0, $00)
                                If (((local15 = $01) Or (0.0 < local0\Field10)) <> 0) Then
                                    giveachievement($03, $01)
                                    If (((local0\Field12 <= $01) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                        If (local0\Field19 <> $00) Then
                                            freesound_strict(local0\Field19)
                                        EndIf
                                        local0\Field19 = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\049\Spotted" + (Str rand($01, $07))) + ".ogg")))
                                        local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                        local0\Field12 = $02
                                    EndIf
                                    local0\Field37 = $00
                                    local0\Field38 = 0.0
                                    local0\Field39 = $00
                                    If (local15 = $01) Then
                                        local0\Field10 = 140.0
                                    EndIf
                                    pointentity(local0\Field0, collider, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    If (0.5 > local8) Then
                                        If (wearinghazmat > $00) Then
                                            blurtimer = ((local17\Field3[$00] * 2.5) + blurtimer)
                                            If ((((250.0 < blurtimer) And (250.0 >= (blurtimer - (local17\Field3[$00] * 2.5)))) And (local0\Field12 <> $03)) <> 0) Then
                                                If (local0\Field20 <> $00) Then
                                                    stopchannel(local0\Field20)
                                                EndIf
                                                local0\Field20 = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\049\TakeOffHazmat.ogg")))
                                                local0\Field12 = $03
                                            ElseIf (500.0 <= blurtimer) Then
                                                For local7 = $00 To (maxitemamount - $01) Step $01
                                                    If (inventory(local7) <> Null) Then
                                                        If ((instr(inventory(local7)\Field3\Field1, "hazmatsuit", $01) And (wearinghazmat < $03)) <> 0) Then
                                                            If (3.0 > inventory(local7)\Field14) Then
                                                                inventory(local7)\Field14 = (inventory(local7)\Field14 + 1.0)
                                                                blurtimer = 260.0
                                                                camerashake = 2.0
                                                            Else
                                                                removeitem(inventory(local7))
                                                                wearinghazmat = $00
                                                            EndIf
                                                            Exit
                                                        EndIf
                                                    EndIf
                                                Next
                                            EndIf
                                        ElseIf (i_714\Field0 <> 0) Then
                                            blurtimer = ((local17\Field3[$00] * 2.5) + blurtimer)
                                            If ((((250.0 < blurtimer) And (250.0 >= (blurtimer - (local17\Field3[$00] * 2.5)))) And (local0\Field12 <> $03)) <> 0) Then
                                                If (local0\Field20 <> $00) Then
                                                    stopchannel(local0\Field20)
                                                EndIf
                                                local0\Field20 = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\049\714Equipped.ogg")))
                                                local0\Field12 = $03
                                            ElseIf (500.0 <= blurtimer) Then
                                                i_714\Field0 = $00
                                            EndIf
                                        ElseIf (((i_1033ru\Field2 > $00) And (i_1033ru\Field0 > $00)) <> 0) Then
                                            blurtimer = ((local17\Field3[$00] * 2.5) + blurtimer)
                                            If (((500.0 < blurtimer) And (500.0 >= (blurtimer - (local17\Field3[$00] * 2.5)))) <> 0) Then
                                                If (local0\Field12 <> $03) Then
                                                    local0\Field12 = $03
                                                EndIf
                                                playsound_strict(damagesfx1033ru(rand($00, $03)))
                                                blurtimer = 1.0
                                                lightflash = 0.2
                                            EndIf
                                        Else
                                            currcamerazoom = 20.0
                                            blurtimer = 500.0
                                            If (chs\Field0 = $00) Then
                                                If (playerroom\Field7\Field10 = "room049") Then
                                                    deathmsg = scplang_getphrase("events.scp0491")
                                                    For local30 = Each events
                                                        If (local30\Field0 = "room049") Then
                                                            local30\Field2 = -1.0
                                                            Exit
                                                        EndIf
                                                    Next
                                                Else
                                                    deathmsg = scplang_getphrase("events.scp0492")
                                                    kill($00, $00)
                                                EndIf
                                                playsound_strict(horrorsfx($0D))
                                                If (local0\Field19 <> $00) Then
                                                    freesound_strict(local0\Field19)
                                                EndIf
                                                local0\Field19 = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\049\Kidnap" + (Str rand($01, $02))) + ".ogg")))
                                                local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                                local0\Field9 = 3.0
                                            EndIf
                                        EndIf
                                    Else
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        If (local0\Field12 = $03) Then
                                            local0\Field12 = $02
                                        EndIf
                                        If (3.0 > local8) Then
                                            animatenpc(local0, max(min(animtime(local0\Field0), 428.0), 387.0), 463.0, (local0\Field22 * 38.0), $01)
                                        ElseIf (428.0 < local0\Field14) Then
                                            animatenpc(local0, min(animtime(local0\Field0), 463.0), 498.0, (local0\Field22 * 38.0), $00)
                                            If (497.9 < local0\Field14) Then
                                                local0\Field14 = 358.0
                                            EndIf
                                        Else
                                            animatenpc(local0, max(min(animtime(local0\Field0), 358.0), 346.0), 393.0, (local0\Field22 * 38.0), $01)
                                        EndIf
                                    EndIf
                                ElseIf (local0\Field37 = $01) Then
                                    While (local0\Field36[local0\Field39] = Null)
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                            Exit
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Wend
                                    If (local0\Field36[local0\Field39] <> Null) Then
                                        If (local0\Field39 > $00) Then
                                            If (local0\Field36[(local0\Field39 - $01)] <> Null) Then
                                                If (local0\Field36[(local0\Field39 - $01)]\Field1 <> Null) Then
                                                    If (local0\Field36[(local0\Field39 - $01)]\Field1\Field23 = $00) Then
                                                        If (0.3 < entitydistance(local0\Field36[(local0\Field39 - $01)]\Field0, local0\Field4)) Then
                                                            If (((local0\Field36[(local0\Field39 - $01)]\Field1\Field24 And local0\Field36[(local0\Field39 - $01)]\Field1\Field5) And ((local0\Field36[(local0\Field39 - $01)]\Field1\Field3[$00] <> $00) Or (local0\Field36[(local0\Field39 - $01)]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                                usedoor(local0\Field36[(local0\Field39 - $01)]\Field1, $00, $01)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                        If (0.6 > local9) Then
                                            local21 = $01
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                    If ((((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 <> $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) And (local0\Field36[local0\Field39]\Field1\Field5 = $00)) <> 0) Then
                                                        local21 = $00
                                                    ElseIf (((local0\Field36[local0\Field39]\Field1\Field5 = $00) And ((local0\Field36[local0\Field39]\Field1\Field3[$00] <> $00) Or (local0\Field36[local0\Field39]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                        usedoor(local0\Field36[local0\Field39]\Field1, $00, $01)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (((0.2 > local9) And local21) <> 0) Then
                                                local0\Field39 = (local0\Field39 + $01)
                                            ElseIf (((0.5 > local9) And (local21 = $00)) <> 0) Then
                                                local0\Field37 = $00
                                                local0\Field38 = 0.0
                                            EndIf
                                        EndIf
                                        animatenpc(local0, max(min(animtime(local0\Field0), 358.0), 346.0), 393.0, (local0\Field22 * 38.0), $01)
                                        If (((local0\Field12 = $00) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                            If (local0\Field19 <> $00) Then
                                                freesound_strict(local0\Field19)
                                            EndIf
                                            If (rand($1E, $01) = $01) Then
                                                local0\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\049\Searching7.ogg"))
                                            Else
                                                local0\Field19 = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\049\Searching" + (Str rand($01, $06))) + ".ogg")))
                                            EndIf
                                            local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                            local0\Field12 = $01
                                        EndIf
                                        If (((rand($258, $01) = $01) And (channelplaying(local0\Field20) = $00)) <> 0) Then
                                            local0\Field12 = $00
                                        EndIf
                                        If (local0\Field12 > $01) Then
                                            local0\Field12 = $01
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field38 = (local0\Field38 + local17\Field3[$00])
                                    If ((Float (($05 - (selecteddifficulty\Field3 Shl $01)) * $46)) < local0\Field38) Then
                                        local0\Field37 = findpath(local0, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                                        local0\Field38 = 0.0
                                        local0\Field11 = 0.0
                                        If (local0\Field37 <> $01) Then
                                            local36 = entitydistance(playerroom\Field2, local0\Field4)
                                            local37 = playerroom
                                            local38 = 0.0
                                            For local7 = $00 To $03 Step $01
                                                If (playerroom\Field24[local7] <> Null) Then
                                                    local38 = entitydistance(playerroom\Field24[local7]\Field2, local0\Field4)
                                                    If (local36 > local38) Then
                                                        local36 = local38
                                                        local37 = playerroom\Field24[local7]
                                                    EndIf
                                                EndIf
                                            Next
                                            local0\Field37 = findpath(local0, entityx(local37\Field2, $00), 0.5, entityz(local37\Field2, $00))
                                        EndIf
                                        While ((Int local0\Field11) < $03)
                                            If (local0\Field37 = $01) Then
                                                If (local0\Field36[$01] <> Null) Then
                                                    If (((local0\Field36[$02] = Null) And (0.4 > entitydistance(local0\Field36[$01]\Field0, local0\Field4))) <> 0) Then
                                                        local0\Field39 = $00
                                                        local0\Field37 = $00
                                                    EndIf
                                                EndIf
                                                If (((local0\Field36[$00] <> Null) And (local0\Field36[$01] = Null)) <> 0) Then
                                                    local0\Field39 = $00
                                                    local0\Field37 = $00
                                                EndIf
                                            EndIf
                                            If (local0\Field37 <> $01) Then
                                                local36 = 100.0
                                                local37 = playerroom
                                                local38 = 0.0
                                                For local7 = $00 To $03 Step $01
                                                    If (playerroom\Field24[local7] <> Null) Then
                                                        local38 = entitydistance(playerroom\Field24[local7]\Field2, local0\Field4)
                                                        If (local36 > local38) Then
                                                            local36 = local38
                                                            For local34 = $00 To $03 Step $01
                                                                If (playerroom\Field24[local7]\Field24[local34] <> Null) Then
                                                                    If (playerroom\Field24[local7]\Field24[local34] <> playerroom) Then
                                                                        local37 = playerroom\Field24[local7]\Field24[local34]
                                                                        Exit
                                                                    EndIf
                                                                EndIf
                                                            Next
                                                        EndIf
                                                    EndIf
                                                Next
                                                local0\Field37 = findpath(local0, entityx(local37\Field2, $00), 0.5, entityz(local37\Field2, $00))
                                            EndIf
                                            If (local0\Field37 = $01) Then
                                                If (local0\Field36[$01] <> Null) Then
                                                    If (local0\Field36[$01]\Field1 <> Null) Then
                                                        If ((((local0\Field36[$01]\Field1\Field4 Or (local0\Field36[$01]\Field1\Field12 <> $00)) Or (local0\Field36[$01]\Field1\Field17 <> "")) And (local0\Field36[$01]\Field1\Field5 = $00)) <> 0) Then
                                                            Repeat
                                                                If (local0\Field39 > $13) Then
                                                                    local0\Field39 = $00
                                                                    local0\Field37 = $00
                                                                    Exit
                                                                Else
                                                                    local0\Field39 = (local0\Field39 + $01)
                                                                EndIf
                                                                If (local0\Field36[local0\Field39] <> Null) Then
                                                                    If ((45.0 - (Abs deltayaw(local0\Field4, local0\Field36[$01]\Field0))) < (Abs deltayaw(local0\Field4, local0\Field36[local0\Field39]\Field0))) Then
                                                                        local0\Field11 = 3.0
                                                                        Exit
                                                                    EndIf
                                                                EndIf
                                                            Forever
                                                        Else
                                                            local0\Field11 = 3.0
                                                        EndIf
                                                    Else
                                                        local0\Field11 = 3.0
                                                    EndIf
                                                EndIf
                                            EndIf
                                            local0\Field11 = (local0\Field11 + 1.0)
                                        Wend
                                    EndIf
                                    animatenpc(local0, 269.0, 345.0, 0.2, $01)
                                EndIf
                                If (0.005 < local0\Field22) Then
                                    If ((((361.0 > local14) And (361.0 <= local0\Field14)) Or ((377.0 > local14) And (377.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($03, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0))
                                    ElseIf ((((431.0 > local14) And (431.0 <= local0\Field14)) Or ((447.0 > local14) And (447.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($03, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0))
                                    EndIf
                                EndIf
                                If (channelplaying(local0\Field20) <> 0) Then
                                    updatesoundorigin(local0\Field20, camera, local0\Field0, 10.0, 1.0)
                                EndIf
                            ElseIf (0.0 = local0\Field24) Then
                                If (channelplaying(local0\Field17) <> 0) Then
                                    stopchannel(local0\Field17)
                                EndIf
                                If ((playerinreachableroom($01) And (infacility = $01)) <> 0) Then
                                    If (rand($01, ($03 - selecteddifficulty\Field5)) = $01) Then
                                        teleportcloser(local0)
                                    Else
                                        local0\Field24 = 4200.0
                                    EndIf
                                EndIf
                            EndIf
                        Case 3.0
                            animatenpc(local0, 537.0, 660.0, 0.7, $00)
                            positionentity(local0\Field4, curvevalue(entityx(collider, $00), entityx(local0\Field4, $00), 20.0), entityy(local0\Field4, $00), curvevalue(entityz(collider, $00), entityz(local0\Field4, $00), 20.0), $00)
                            rotateentity(local0\Field4, 0.0, curveangle((entityyaw(collider, $00) - 180.0), entityyaw(local0\Field4, $00), 40.0), 0.0, $00)
                        Case 4.0
                            If (8.0 > local8) Then
                                animatenpc(local0, 18.0, 19.0, 0.05, $01)
                                pointentity(local0\Field0, collider, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 45.0), 0.0, $00)
                                local0\Field11 = 1.0
                            ElseIf (((local8 > (hidedistance * 0.8)) And (0.0 < local0\Field11)) <> 0) Then
                                local0\Field9 = 2.0
                                local0\Field11 = 0.0
                                For local4 = Each rooms
                                    If (4.0 > entitydistance(local4\Field2, local0\Field4)) Then
                                        teleportentity(local0\Field4, entityx(local4\Field2, $00), 0.1, entityz(local4\Field2, $00), local0\Field70, $01, 2.0, $00)
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Case 5.0
                            local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 10.0, 1.0)
                            local15 = menpcseesplayer(local0, $01)
                            If (local15 = $01) Then
                                local0\Field9 = 2.0
                                local0\Field37 = $00
                                local0\Field39 = $00
                                local0\Field38 = 0.0
                                local0\Field11 = 0.0
                                local0\Field10 = 140.0
                                local0\Field12 = $00
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\Room2SL049Spawn.ogg")))
                            ElseIf (((local15 = $02) And (0.0 < local0\Field11)) <> 0) Then
                                local0\Field37 = findpath(local0, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                            Else
                                If (6.0 = local0\Field11) Then
                                    If (hidedistance < entitydistance(local0\Field4, collider)) Then
                                        local0\Field9 = 2.0
                                        local0\Field37 = $00
                                        local0\Field39 = $00
                                        local0\Field38 = 0.0
                                        local0\Field11 = 0.0
                                        local0\Field12 = $00
                                    ElseIf (local0\Field37 <> $01) Then
                                        local0\Field37 = findpath(local0, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                                    EndIf
                                EndIf
                                If (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        If (local0\Field39 > $00) Then
                                            If (local0\Field36[(local0\Field39 - $01)] <> Null) Then
                                                If (local0\Field36[(local0\Field39 - $01)]\Field1 <> Null) Then
                                                    If (local0\Field36[(local0\Field39 - $01)]\Field1\Field12 = $00) Then
                                                        If (0.3 < entitydistance(local0\Field36[(local0\Field39 - $01)]\Field0, local0\Field4)) Then
                                                            If (local0\Field36[(local0\Field39 - $01)]\Field1\Field5 <> 0) Then
                                                                usedoor(local0\Field36[(local0\Field39 - $01)]\Field1, $00, $01)
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                        local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                        If (0.6 > local9) Then
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                    usedoor(local0\Field36[local0\Field39]\Field1, $00, $01)
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (0.2 > local9) Then
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                        animatenpc(local0, max(min(animtime(local0\Field0), 358.0), 346.0), 393.0, (local0\Field22 * 38.0), $01)
                                    EndIf
                                Else
                                    Select local0\Field12
                                        Case $00
                                            animatenpc(local0, 269.0, 345.0, 0.2, $01)
                                        Case $01
                                            animatenpc(local0, 661.0, 891.0, 0.4, $00)
                                        Case $02
                                            animatenpc(local0, 892.0, 1119.0, 0.4, $00)
                                    End Select
                                EndIf
                            EndIf
                            If (playerroom\Field7\Field10 = "room2sl") Then
                                shouldplay = $14
                            EndIf
                            If (0.005 < local0\Field22) Then
                                If ((((361.0 > local14) And (361.0 <= local0\Field14)) Or ((377.0 > local14) And (377.0 <= local0\Field14))) <> 0) Then
                                    playsound2(stepsfx($03, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0))
                                ElseIf ((((431.0 > local14) And (431.0 <= local0\Field14)) Or ((447.0 > local14) And (447.0 <= local0\Field14))) <> 0) Then
                                    playsound2(stepsfx($03, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0))
                                EndIf
                            EndIf
                            If (channelplaying(local0\Field20) <> 0) Then
                                updatesoundorigin(local0\Field20, camera, local0\Field0, 10.0, 1.0)
                            EndIf
                    End Select
                EndIf
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.22), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                local0\Field26 = (Int max(((Float local0\Field26) - local17\Field3[$00]), 0.0))
                local0\Field10 = max((local0\Field10 - local17\Field3[$00]), 0.0)
            Case $04
                If (4.0 > (Abs (entityy(collider, $00) - entityy(local0\Field4, $00)))) Then
                    local14 = local0\Field14
                    If (local0\Field48 = $00) Then
                        Select local0\Field9
                            Case 0.0
                                animatenpc(local0, 719.0, 777.0, 0.2, $00)
                                If (777.0 = local0\Field14) Then
                                    If (rand($2BC, $01) = $01) Then
                                        If (5.0 > entitydistance(collider, local0\Field4)) Then
                                            local0\Field14 = 719.0
                                        EndIf
                                    EndIf
                                EndIf
                            Case 1.0
                                If (682.0 <= local0\Field14) Then
                                    animatenpc(local0, 926.0, 935.0, 0.3, $00)
                                    If (935.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                Else
                                    animatenpc(local0, 155.0, 682.0, 1.1, $00)
                                EndIf
                            Case 2.0
                                If (0.0 > local0\Field11) Then
                                    If (5.0 > entitydistance(collider, local0\Field4)) Then
                                        If (entityvisible(collider, local0\Field4) <> 0) Then
                                            local0\Field10 = 350.0
                                        EndIf
                                    EndIf
                                    local0\Field11 = 210.0
                                Else
                                    local0\Field11 = (local0\Field11 - local17\Field3[$00])
                                EndIf
                                local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 6.0, 0.6)
                                If (((0.0 < local0\Field10) And (chs\Field2 = $00)) <> 0) Then
                                    local0\Field37 = $00
                                    local8 = entitydistance(collider, local0\Field4)
                                    pointentity(local0\Field0, collider, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                                    If (0.7 > local8) Then
                                        local0\Field9 = 3.0
                                        If (rand($02, $01) = $01) Then
                                            local0\Field14 = 2.0
                                        Else
                                            local0\Field14 = 66.0
                                        EndIf
                                    Else
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        animatenpc(local0, 936.0, 1017.0, (local0\Field22 * 60.0), $01)
                                    EndIf
                                    local0\Field10 = (local0\Field10 - local17\Field3[$00])
                                ElseIf (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        animatenpc(local0, 936.0, 1017.0, (local0\Field22 * 60.0), $01)
                                        animatenpc(local0, 936.0, 1017.0, (local0\Field22 * 60.0), $01)
                                        local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                        If (0.6 > local9) Then
                                            local21 = $01
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                    If (((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 > $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) <> 0) Then
                                                        local21 = $00
                                                    ElseIf (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                        usedoor(local0\Field36[local0\Field39]\Field1, $00, $01)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (((0.2 > local9) And local21) <> 0) Then
                                                local0\Field39 = (local0\Field39 + $01)
                                            ElseIf (((0.5 > local9) And (local21 = $00)) <> 0) Then
                                                local0\Field37 = $00
                                                local0\Field38 = 0.0
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field22 = 0.0
                                    animatenpc(local0, 778.0, 926.0, 0.1, $01)
                                    local0\Field38 = (local0\Field38 - local17\Field3[$00])
                                    If (350.0 > local0\Field38) Then
                                        local0\Field38 = ((rnd(1.0, (Float ((selecteddifficulty\Field3 Shl $01) + $02))) * local17\Field3[$00]) + local0\Field38)
                                    Else
                                        local0\Field37 = findpath(local0, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                                        local0\Field38 = 0.0
                                    EndIf
                                EndIf
                                If (0.005 < local0\Field22) Then
                                    If ((((977.0 > local14) And (977.0 <= local0\Field14)) Or ((1010.0 < local14) And (940.0 > local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                                    EndIf
                                EndIf
                            Case 3.0
                                If (chs\Field2 <> 0) Then
                                    local0\Field9 = 2.0
                                EndIf
                                If (66.0 > local0\Field14) Then
                                    animatenpc(local0, 2.0, 65.0, 0.7, $00)
                                    If (((23.0 > local14) And (23.0 <= local0\Field14)) <> 0) Then
                                        If (1.1 > entitydistance(local0\Field4, collider)) Then
                                            If (60.0 >= (Abs deltayaw(local0\Field4, collider))) Then
                                                playsound_strict(damagesfx(rand($05, $08)))
                                                If (i_1033ru\Field0 = $00) Then
                                                    injuries = (rnd(0.4, 1.0) + injuries)
                                                Else
                                                    damage1033ru($14)
                                                    local0\Field61 = (local0\Field61 - $14)
                                                    If (local0\Field61 <= $00) Then
                                                        local0\Field48 = $01
                                                    EndIf
                                                EndIf
                                                If (3.0 < injuries) Then
                                                    deathmsg = scplang_getphrase("events.scp0493")
                                                    kill($01, $00)
                                                EndIf
                                            EndIf
                                        EndIf
                                    ElseIf (65.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                Else
                                    animatenpc(local0, 66.0, 132.0, 0.7, $00)
                                    If (((90.0 > local14) And (90.0 <= local0\Field14)) <> 0) Then
                                        If (1.1 > entitydistance(local0\Field4, collider)) Then
                                            If (60.0 >= (Abs deltayaw(local0\Field4, collider))) Then
                                                playsound_strict(damagesfx(rand($05, $08)))
                                                If (i_1033ru\Field0 = $00) Then
                                                    injuries = (rnd(0.4, 1.0) + injuries)
                                                Else
                                                    damage1033ru($14)
                                                    local0\Field61 = (local0\Field61 - $14)
                                                    If (local0\Field61 <= $00) Then
                                                        local0\Field48 = $01
                                                    EndIf
                                                EndIf
                                                If (3.0 < injuries) Then
                                                    deathmsg = scplang_getphrase("events.scp0493")
                                                    kill($01, $00)
                                                EndIf
                                            EndIf
                                        EndIf
                                    ElseIf (132.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                EndIf
                        End Select
                    Else
                        If (local0\Field17 <> $00) Then
                            stopchannel(local0\Field17)
                            local0\Field17 = $00
                            freesound_strict(local0\Field16)
                            local0\Field16 = $00
                        EndIf
                        animatenpc(local0, 1035.0, 1072.0, 0.3, $00)
                    EndIf
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                    rotateentity(local0\Field0, -90.0, entityyaw(local0\Field4, $00), 0.0, $00)
                EndIf
            Case $13
                local14 = local0\Field14
                local0\Field53 = ""
                local0\Field51 = $00
                local0\Field52 = $00
                local0\Field57 = "Guard"
                Select local0\Field9
                    Case 1.0
                        If (((((39.0 > local0\Field14) Or ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Or ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Or (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0)
                            EndIf
                        EndIf
                        If (0.0 <= killtimer) Then
                            local8 = entitydistance(local0\Field4, collider)
                            local42 = (((Float selecteddifficulty\Field3) * 0.5) + 0.4)
                            local43 = 11.0
                            If (playerroom\Field7\Field10 = "gateb") Then
                                local43 = 21.0
                                local42 = 0.0
                                If (rand($01, ($08 - (selecteddifficulty\Field3 Shl $02))) < $02) Then
                                    local42 = 0.03
                                EndIf
                                local42 = ((0.5 - (currspeed * 20.0)) + local42)
                            EndIf
                            If (local43 > local8) Then
                                local26 = createpivot($00)
                                positionentity(local26, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                pointentity(local26, collider, 0.0)
                                rotateentity(local26, min(entitypitch(local26, $00), 20.0), entityyaw(local26, $00), 0.0, $00)
                                rotateentity(local0\Field4, curveangle(entitypitch(local26, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local26, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                positionentity(local26, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                                pointentity(local26, collider, 0.0)
                                rotateentity(local26, min(entitypitch(local26, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                                If (0.0 = local0\Field25) Then
                                    entitypick(local26, local8)
                                    If (((pickedentity() = collider) Or (1.0 = local0\Field11)) <> 0) Then
                                        local44 = $00
                                        If (playerroom\Field7\Field10 = "room173") Then
                                            deathmsg = scplang_getphrase("events.introdeath")
                                            local44 = $01
                                        ElseIf (playerroom\Field7\Field10 = "gateb") Then
                                            deathmsg = ((chr($22) + scplang_getphrase("events.gatebdeath")) + chr($22))
                                        Else
                                            deathmsg = ""
                                        EndIf
                                        playsound2(gunshotsfx, camera, local0\Field4, 35.0, 1.0)
                                        rotateentity(local26, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                                        positionentity(local26, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                        moveentity(local26, 0.0632, 0.84925, 0.5451)
                                        pointentity(local26, collider, 0.0)
                                        shoot(entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), local42, $01, local44)
                                        local0\Field25 = 7.0
                                    Else
                                        local0\Field22 = local0\Field21
                                    EndIf
                                EndIf
                                If (((0.0 < local0\Field25) And (7.0 >= local0\Field25)) <> 0) Then
                                    animatenpc(local0, 245.0, 248.0, 0.35, $01)
                                ElseIf (302.0 > local0\Field14) Then
                                    animatenpc(local0, 302.0, 344.0, 0.35, $01)
                                EndIf
                                freeentity(local26)
                            Else
                                animatenpc(local0, 302.0, 344.0, 0.35, $01)
                            EndIf
                            local0\Field51 = $01
                            If (10.0 = local0\Field10) Then
                                local0\Field53 = "Chest"
                                local0\Field52 = $03
                            Else
                                local0\Field53 = "Chest"
                                local0\Field52 = $00
                            EndIf
                        Else
                            local0\Field9 = 0.0
                        EndIf
                    Case 2.0
                        animatenpc(local0, 245.0, 248.0, 0.35, $01)
                        If (0.0 = local0\Field25) Then
                            playsound2(gunshotsfx, camera, local0\Field4, 20.0, 1.0)
                            local45 = createparticle(entityx(local0\Field0, $01), entityy(local0\Field0, $01), entityz(local0\Field0, $01), $01, 0.2, 0.0, $05)
                            positionentity(local45\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            rotateentity(local45\Field1, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                            moveentity(local45\Field1, 0.0632, 0.84925, 0.5451)
                            local0\Field25 = 7.0
                        EndIf
                    Case 3.0
                        If (local0\Field37 = $02) Then
                            local0\Field9 = 0.0
                            local0\Field22 = 0.0
                        ElseIf (local0\Field37 = $01) Then
                            If (local0\Field36[local0\Field39] = Null) Then
                                If (local0\Field39 > $13) Then
                                    local0\Field39 = $00
                                    local0\Field37 = $00
                                Else
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            Else
                                pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                animatenpc(local0, 1.0, 38.0, (local0\Field22 * 40.0), $01)
                                local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                If (0.2 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            EndIf
                        Else
                            local0\Field22 = 0.0
                            local0\Field9 = 4.0
                        EndIf
                    Case 4.0
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        If (rand($190, $01) = $01) Then
                            local0\Field15 = rnd(-180.0, 180.0)
                        EndIf
                        rotateentity(local0\Field4, 0.0, curveangle((local0\Field15 + (sin((Float (millisecs2() / $32))) * 2.0)), entityyaw(local0\Field4, $00), 150.0), 0.0, $01)
                        local8 = entitydistance(local0\Field4, collider)
                        If (15.0 > local8) Then
                            If (90.0 > wrapangle((entityyaw(local0\Field4, $00) - deltayaw(local0\Field4, collider)))) Then
                                If (entityvisible(local26, collider) <> 0) Then
                                    local0\Field9 = 1.0
                                EndIf
                            EndIf
                        EndIf
                    Case 5.0
                        rotateentity(local0\Field4, 0.0, curveangle((vectoryaw((local0\Field33 - entityx(local0\Field4, $00)), 0.0, (local0\Field35 - entityz(local0\Field4, $00))) + local0\Field15), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                        local8 = distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field33, local0\Field35)
                        animatenpc(local0, 1.0, 38.0, (local0\Field22 * 40.0), $01)
                        If (((2.0 < local8) Or (1.0 > local8)) <> 0) Then
                            local0\Field22 = curvevalue(((local0\Field21 * (Sgn (local8 - 1.5))) * 0.75), local0\Field22, 10.0)
                        Else
                            local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                        EndIf
                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                    Case 7.0
                        If (local0\Field75 = $01) Then
                            animatenpc(local0, 623.0, 747.0, 0.2, $01)
                        Else
                            animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        EndIf
                    Case 8.0
                    Case 9.0
                        If (local0\Field75 = $01) Then
                            animatenpc(local0, 623.0, 747.0, 0.2, $01)
                        Else
                            animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        EndIf
                        local0\Field53 = "head"
                        local0\Field51 = $01
                        local0\Field52 = $00
                        local0\Field15 = entityyaw(local0\Field4, $00)
                    Case 10.0
                        animatenpc(local0, 1.0, 38.0, (local0\Field22 * 40.0), $01)
                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                    Case 11.0
                        local19 = entitydistance(collider, local0\Field4)
                        If (local0\Field75 = $01) Then
                            If (((((787.0 > local0\Field14) Or ((824.0 < local0\Field14) And (867.0 > local0\Field14))) Or ((870.0 < local0\Field14) And (884.0 > local0\Field14))) Or (939.0 < local0\Field14)) <> 0) Then
                                animatenpc(local0, 927.0, 939.0, 0.2, $00)
                                If (883.0 <= local0\Field14) Then
                                    setnpcframe(local0, 884.0)
                                EndIf
                            EndIf
                        ElseIf (((((39.0 > local0\Field14) Or ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Or ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Or (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0)
                            EndIf
                        EndIf
                        If (0.0 <= killtimer) Then
                            local8 = entitydistance(local0\Field4, collider)
                            local46 = $00
                            If (11.0 > local8) Then
                                If (entityvisible(local0\Field4, collider) <> 0) Then
                                    local46 = $01
                                EndIf
                            EndIf
                            If (local46 <> 0) Then
                                local26 = createpivot($00)
                                positionentity(local26, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                pointentity(local26, collider, 0.0)
                                rotateentity(local26, min(entitypitch(local26, $00), 20.0), entityyaw(local26, $00), 0.0, $00)
                                rotateentity(local0\Field4, curveangle(entitypitch(local26, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local26, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                positionentity(local26, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                                pointentity(local26, collider, 0.0)
                                rotateentity(local26, min(entitypitch(local26, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                                If (0.0 = local0\Field25) Then
                                    entitypick(local26, local8)
                                    If (((pickedentity() = collider) Or (1.0 = local0\Field11)) <> 0) Then
                                        local44 = $00
                                        deathmsg = ""
                                        playsound2(gunshotsfx, camera, local0\Field4, 35.0, 1.0)
                                        rotateentity(local26, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $01)
                                        positionentity(local26, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                                        moveentity(local26, 0.0632, 0.84925, 0.5451)
                                        pointentity(local26, collider, 0.0)
                                        shoot(entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), ((25.0 / local19) * (1.0 / local19)), $01, local44)
                                        local0\Field25 = 7.0
                                    Else
                                        local0\Field22 = local0\Field21
                                    EndIf
                                EndIf
                                If (((0.0 < local0\Field25) And (7.0 >= local0\Field25)) <> 0) Then
                                    If (local0\Field75 = $01) Then
                                        animatenpc(local0, 867.0, 870.0, 0.35, $01)
                                    Else
                                        animatenpc(local0, 245.0, 248.0, 0.35, $01)
                                    EndIf
                                ElseIf (local0\Field75 = $01) Then
                                    If (884.0 > local0\Field14) Then
                                        animatenpc(local0, 884.0, 926.0, 0.35, $01)
                                    EndIf
                                ElseIf (302.0 > local0\Field14) Then
                                    animatenpc(local0, 302.0, 344.0, 0.35, $01)
                                EndIf
                                freeentity(local26)
                            Else
                                If (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        If (local0\Field75 = $01) Then
                                            animatenpc(local0, 787.0, 823.0, (local0\Field22 * 40.0), $01)
                                        Else
                                            animatenpc(local0, 39.0, 76.0, (local0\Field22 * 40.0), $01)
                                        EndIf
                                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                        If (0.2 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    EndIf
                                Else
                                    If (0.0 = local0\Field38) Then
                                        local0\Field37 = findpath(local0, entityx(collider, $00), (entityy(collider, $00) + 0.5), entityz(collider, $00))
                                    EndIf
                                    local47 = Null
                                    For local48 = Each waypoints
                                        If (2.0 > entitydistance(local48\Field0, collider)) Then
                                            local47 = local48
                                            Exit
                                        EndIf
                                    Next
                                    If (local47 <> Null) Then
                                        local0\Field38 = 1.0
                                        If (entityvisible(local47\Field0, local0\Field4) <> 0) Then
                                            If (0.0 < (Abs deltayaw(local0\Field4, local47\Field0))) Then
                                                pointentity(local0\Field0, local47\Field0, 0.0)
                                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                            EndIf
                                        EndIf
                                    Else
                                        local0\Field38 = 0.0
                                    EndIf
                                    If (1.0 = local0\Field38) Then
                                        If (local0\Field75 = $01) Then
                                            animatenpc(local0, 787.0, 823.0, (local0\Field22 * 40.0), $01)
                                        Else
                                            animatenpc(local0, 39.0, 76.0, (local0\Field22 * 40.0), $01)
                                        EndIf
                                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                    EndIf
                                EndIf
                                If (((43.0 > local14) And (43.0 <= local0\Field14)) <> 0) Then
                                    playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                                ElseIf (((61.0 > local14) And (61.0 <= local0\Field14)) <> 0) Then
                                    playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                                EndIf
                            EndIf
                        Else
                            local0\Field9 = 0.0
                        EndIf
                    Case 12.0
                        If (((((39.0 > local0\Field14) Or ((76.0 < local0\Field14) And (245.0 > local0\Field14))) Or ((248.0 < local0\Field14) And (302.0 > local0\Field14))) Or (344.0 < local0\Field14)) <> 0) Then
                            animatenpc(local0, 345.0, 357.0, 0.2, $00)
                            If (356.0 <= local0\Field14) Then
                                setnpcframe(local0, 302.0)
                            EndIf
                        EndIf
                        If (345.0 > local0\Field14) Then
                            animatenpc(local0, 302.0, 344.0, 0.35, $01)
                        EndIf
                        local26 = createpivot($00)
                        positionentity(local26, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                        If (1.0 = local0\Field10) Then
                            pointentity(local26, collider, 0.0)
                        Else
                            rotateentity(local26, 0.0, local0\Field15, 0.0, $00)
                        EndIf
                        rotateentity(local26, min(entitypitch(local26, $00), 20.0), entityyaw(local26, $00), 0.0, $00)
                        rotateentity(local0\Field4, curveangle(entitypitch(local26, $00), entitypitch(local0\Field4, $00), 10.0), curveangle(entityyaw(local26, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                        positionentity(local26, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                        If (1.0 = local0\Field10) Then
                            pointentity(local26, collider, 0.0)
                            local0\Field51 = $01
                            local0\Field53 = "Chest"
                            local0\Field52 = $00
                        Else
                            rotateentity(local26, 0.0, local0\Field15, 0.0, $00)
                        EndIf
                        rotateentity(local26, min(entitypitch(local26, $00), 40.0), entityyaw(local0\Field4, $00), 0.0, $00)
                        freeentity(local26)
                        updatesoundorigin(local0\Field17, camera, local0\Field4, 20.0, 1.0)
                    Case 13.0
                        animatenpc(local0, 202.0, 244.0, 0.35, $01)
                    Case 14.0
                        If (local0\Field37 = $02) Then
                            local0\Field9 = 13.0
                            local0\Field22 = 0.0
                        ElseIf (local0\Field37 = $01) Then
                            If (local0\Field36[local0\Field39] = Null) Then
                                If (local0\Field39 > $13) Then
                                    local0\Field39 = $00
                                    local0\Field37 = $00
                                Else
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            Else
                                pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                animatenpc(local0, 39.0, 76.0, (local0\Field22 * 40.0), $01)
                                local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                If (0.2 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            EndIf
                        Else
                            local0\Field22 = 0.0
                            local0\Field9 = 13.0
                        EndIf
                        If (((43.0 > local14) And (43.0 <= local0\Field14)) <> 0) Then
                            playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                        ElseIf (((61.0 > local14) And (61.0 <= local0\Field14)) <> 0) Then
                            playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                        EndIf
                    Default
                        If (rand($190, $01) = $01) Then
                            local0\Field12 = (Int rnd(-30.0, 30.0))
                        EndIf
                        local0\Field37 = $00
                        animatenpc(local0, 77.0, 201.0, 0.2, $01)
                        rotateentity(local0\Field4, 0.0, curveangle(((local0\Field15 + (Float local0\Field12)) + (sin((Float (millisecs2() / $32))) * 2.0)), entityyaw(local0\Field4, $00), 50.0), 0.0, $01)
                End Select
                If (0.01 < local0\Field22) Then
                    If (((5.0 > local14) And (5.0 <= local0\Field14)) <> 0) Then
                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                    ElseIf (((23.0 > local14) And (23.0 <= local0\Field14)) <> 0) Then
                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.5, 0.7))
                    EndIf
                EndIf
                If (((286.5 < local0\Field14) And (288.5 > local0\Field14)) <> 0) Then
                    local0\Field48 = $01
                EndIf
                local0\Field25 = max(0.0, (local0\Field25 - local17\Field3[$00]))
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) + 180.0), 0.0, $00)
            Case $14
                updatemtfunit(local0)
            Case $12,$11
                rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
                local14 = animtime(local0\Field0)
                Select local0\Field9
                    Case 0.0
                        local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                        animate2(local0\Field0, animtime(local0\Field0), $D2, $EB, 0.1, $01)
                    Case 1.0
                        If (1.0 = local0\Field10) Then
                            local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                        Else
                            local0\Field22 = curvevalue(0.015, local0\Field22, 5.0)
                        EndIf
                        animate2(local0\Field0, animtime(local0\Field0), $EC, $104, (local0\Field22 * 18.0), $01)
                    Case 2.0
                        local0\Field22 = curvevalue(0.03, local0\Field22, 5.0)
                        animate2(local0\Field0, animtime(local0\Field0), $12D, $13F, (local0\Field22 * 18.0), $01)
                End Select
                If (2.0 <> local0\Field10) Then
                    If (1.0 = local0\Field9) Then
                        If (0.01 < local0\Field22) Then
                            If (((244.0 > local14) And (244.0 <= animtime(local0\Field0))) <> 0) Then
                                playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                            ElseIf (((256.0 > local14) And (256.0 <= animtime(local0\Field0))) <> 0) Then
                                playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                            EndIf
                        EndIf
                    ElseIf (2.0 = local0\Field9) Then
                        If (0.01 < local0\Field22) Then
                            If (((309.0 > local14) And (309.0 <= animtime(local0\Field0))) <> 0) Then
                                playsound2(stepsfx(getstepsound(local0\Field4), $01, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                            ElseIf (((319.0 >= local14) And (301.0 >= animtime(local0\Field0))) <> 0) Then
                                playsound2(stepsfx(getstepsound(local0\Field4), $01, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (((((19.0 = local0\Field14) Or (60.0 = local0\Field14)) Or (629.0 = local0\Field14)) Or (676.0 = local0\Field14)) <> 0) Then
                    local0\Field48 = $01
                EndIf
                If (((((19.0 = animtime(local0\Field0)) Or (60.0 = animtime(local0\Field0))) Or (629.0 = animtime(local0\Field0))) Or (676.0 = animtime(local0\Field0))) <> 0) Then
                    local0\Field48 = $01
                EndIf
                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.32), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
            Case $0A
                If (playerroom\Field7\Field10 <> "pocketdimension") Then
                    If ((Int local0\Field24) <> 0) Then
                        hideentity(local0\Field0)
                        hideentity(local0\Field1)
                        If (rand($C8, $01) = $01) Then
                            For local25 = Each waypoints
                                If (local25\Field2 <> playerroom) Then
                                    local11 = (Abs (entityx(collider, $00) - entityx(local25\Field0, $01)))
                                    If (((3.0 < local11) And (9.0 > local11)) <> 0) Then
                                        local13 = (Abs (entityz(collider, $00) - entityz(local25\Field0, $01)))
                                        If (((3.0 < local13) And (9.0 > local13)) <> 0) Then
                                            positionentity(local0\Field4, entityx(local25\Field0, $01), entityy(local25\Field0, $01), entityz(local25\Field0, $01), $00)
                                            positionentity(local0\Field0, entityx(local25\Field0, $01), entityy(local25\Field0, $01), entityz(local25\Field0, $01), $00)
                                            resetentity(local0\Field4)
                                            showentity(local0\Field0)
                                            showentity(local0\Field1)
                                            local0\Field26 = $00
                                            local0\Field36[$00] = local25
                                            local0\Field24 = 0.0
                                            local0\Field10 = (Float (rand($0F, $14) * $46))
                                            local0\Field9 = max((Float rand($FFFFFFFF, $02)), 0.0)
                                            local0\Field12 = rand($00, $01)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    Else
                        local8 = entitydistance(collider, local0\Field4)
                        local0\Field28 = curvevalue(0.0, local0\Field28, 10.0)
                        local0\Field30 = curvevalue(0.0, local0\Field30, 10.0)
                        If (rand($64, $01) = $01) Then
                            If (rand($05, $01) = $01) Then
                                local0\Field28 = ((entityx(collider, $00) - entityx(local0\Field4, $00)) * 0.9)
                                local0\Field30 = ((entityz(collider, $00) - entityz(local0\Field4, $00)) * 0.9)
                            Else
                                local0\Field28 = rnd(0.1, 0.5)
                                local0\Field30 = rnd(0.1, 0.5)
                            EndIf
                        EndIf
                        local21 = (Int rnd(-1.0, 1.0))
                        positionentity(local0\Field1, (entityx(local0\Field4, $00) + (local0\Field28 * (Float local21))), ((entityy(local0\Field4, $00) - 0.2) + (sin((Float (((millisecs2() Sar $03) - $2D) Mod $168))) * 0.05)), (entityz(local0\Field4, $00) + (local0\Field30 * (Float local21))), $00)
                        rotateentity(local0\Field1, 0.0, entityyaw(local0\Field0, $00), 0.0, $00)
                        If (floor(local0\Field14) <> floor(animtime(local0\Field1))) Then
                            setanimtime(local0\Field1, local0\Field14, $00)
                        EndIf
                        If (0.0 = local0\Field9) Then
                            If (local0\Field12 = $00) Then
                                animatenpc(local0, 2.0, 74.0, 0.2, $01)
                            Else
                                animatenpc(local0, 75.0, 124.0, 0.2, $01)
                            EndIf
                            If (local0\Field26 <> 0) Then
                                pointentity(local0\Field1, collider, 0.0)
                                rotateentity(local0\Field0, 0.0, curveangle(entityyaw(local0\Field1, $00), entityyaw(local0\Field0, $00), 40.0), 0.0, $00)
                                If (4.0 > local8) Then
                                    local0\Field9 = (Float rand($01, $02))
                                EndIf
                            ElseIf (((6.0 > local8) And (rand($05, $01) = $01)) <> 0) Then
                                If (entityinview(local0\Field4, camera) <> 0) Then
                                    If (entityvisible(collider, local0\Field4) <> 0) Then
                                        local0\Field26 = $01
                                        playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\513\Bell" + (Str rand($02, $04))) + ".ogg"))))
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf (local0\Field36[$00] = Null) Then
                            For local25 = Each waypoints
                                local11 = (Abs (entityx(local0\Field4, $01) - entityx(local25\Field0, $01)))
                                If (((8.0 > local11) And (1.0 < local11)) <> 0) Then
                                    local13 = (Abs (entityz(local0\Field4, $01) - entityz(local25\Field0, $01)))
                                    If (((8.0 > local13) And (1.0 < local13)) <> 0) Then
                                        If (local8 < entitydistance(collider, local25\Field0)) Then
                                            local0\Field36[$00] = local25
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local0\Field36[$00] = Null) Then
                                local0\Field24 = 1.0
                                local0\Field10 = 0.0
                            EndIf
                        ElseIf (1.0 < entitydistance(local0\Field4, local0\Field36[$00]\Field0)) Then
                            pointentity(local0\Field0, local0\Field36[$00]\Field0, 0.0)
                            rotateentity(local0\Field4, curveangle(entitypitch(local0\Field0, $00), entitypitch(local0\Field4, $00), 15.0), curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 15.0), 0.0, $01)
                            local0\Field22 = curvevalue((max(((7.0 - local8) / 7.0), 0.0) * 0.05), local0\Field22, 15.0)
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                            If (rand($C8, $01) = $01) Then
                                moveentity(local0\Field4, 0.0, 0.0, 0.5)
                            EndIf
                            rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                        Else
                            For local7 = $00 To $04 Step $01
                                If (local0\Field36[$00]\Field4[local7] <> Null) Then
                                    If (local8 < entitydistance(collider, local0\Field36[$00]\Field4[local7]\Field0)) Then
                                        If (local0\Field26 = $00) Then
                                            If (entityinview(local0\Field4, camera) <> 0) Then
                                                If (entityvisible(collider, local0\Field4) <> 0) Then
                                                    local0\Field26 = $01
                                                    playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\513\Bell" + (Str rand($02, $04))) + ".ogg"))))
                                                EndIf
                                            EndIf
                                        EndIf
                                        local0\Field36[$00] = local0\Field36[$00]\Field4[local7]
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (local0\Field36[$00] = Null) Then
                                local0\Field10 = 0.0
                            EndIf
                        EndIf
                        positionentity(local0\Field0, entityx(local0\Field4, $00), ((entityy(local0\Field4, $00) - 0.2) + (sin((Float ((millisecs2() Sar $03) Mod $168))) * 0.1)), entityz(local0\Field4, $00), $00)
                        Select local0\Field9
                            Case 1.0
                                If (local0\Field12 = $00) Then
                                    animatenpc(local0, 125.0, 194.0, (local0\Field22 * 20.0), $01)
                                Else
                                    animatenpc(local0, 195.0, 264.0, (local0\Field22 * 20.0), $01)
                                EndIf
                                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                            Case 2.0
                                If (local0\Field12 = $00) Then
                                    animatenpc(local0, 2.0, 74.0, 0.2, $01)
                                Else
                                    animatenpc(local0, 75.0, 124.0, 0.2, $01)
                                EndIf
                                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                        End Select
                        If (0.0 < local0\Field10) Then
                            If (4.0 > local8) Then
                                local0\Field10 = (local0\Field10 - (local17\Field3[$00] * 4.0))
                            EndIf
                            local0\Field10 = (local0\Field10 - local17\Field3[$00])
                        Else
                            local0\Field36[$00] = Null
                            local0\Field24 = 1.0
                            local0\Field10 = 0.0
                        EndIf
                    EndIf
                EndIf
                local0\Field7 = 0.0
                resetentity(local0\Field4)
            Case $09
                local16 = playerroom\Field7\Field10
                If (((local16 <> "pocketdimension") And (local16 <> "dimension1499")) <> 0) Then
                    If ((Int local0\Field24) <> 0) Then
                        hideentity(local0\Field0)
                        If (((rand($32, $01) = $01) And ((-5.0 > blinktimer) And (-15.0 < blinktimer))) <> 0) Then
                            showentity(local0\Field0)
                            local10 = (entityyaw(collider, $00) + rnd(-90.0, 90.0))
                            local8 = rnd(1.5, 2.0)
                            positionentity(local0\Field4, (entityx(collider, $00) + (sin(local10) * local8)), (entityy(collider, $00) + 0.2), (entityz(collider, $00) + (cos(local10) * local8)), $00)
                            local0\Field24 = 0.0
                            local0\Field9 = (Float rand($14, $3C))
                            If (rand($12C, $01) = $01) Then
                                playsound2(rustlesfx(rand($00, $06)), camera, local0\Field0, 8.0, rnd(0.0, 0.2))
                            EndIf
                        EndIf
                    Else
                        positionentity(local0\Field0, (entityx(local0\Field4, $00) + rnd(-0.005, 0.005)), ((entityy(local0\Field4, $00) + 0.3) + (0.1 * sin((Float (millisecs2() Sar $01))))), (entityz(local0\Field4, $00) + rnd(-0.005, 0.005)), $00)
                        rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), (Float ((millisecs2() / $05) Mod $168)), $00)
                        animatenpc(local0, 1.0, 14.0, 1.2, $01)
                        If (entityinview(local0\Field0, camera) <> 0) Then
                            giveachievement($0B, $01)
                            If (rand($1E, $01) = $01) Then
                                If (channelplaying(local0\Field17) = $00) Then
                                    If (entityvisible(camera, local0\Field0) <> 0) Then
                                        local0\Field17 = playsound2(rustlesfx(rand($00, $06)), camera, local0\Field0, 8.0, 0.3)
                                    EndIf
                                EndIf
                            EndIf
                            local21 = createpivot($00)
                            positionentity(local21, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                            pointentity(local21, local0\Field4, 0.0)
                            local10 = wrapangle((entityyaw(collider, $00) - entityyaw(local21, $00)))
                            If (180.0 > local10) Then
                                rotateentity(local0\Field4, 0.0, (entityyaw(collider, $00) - 80.0), 0.0, $00)
                            Else
                                rotateentity(local0\Field4, 0.0, (entityyaw(collider, $00) + 80.0), 0.0, $00)
                            EndIf
                            freeentity(local21)
                            moveentity(local0\Field4, 0.0, 0.0, (local17\Field3[$00] * 0.03))
                            local0\Field9 = (local0\Field9 - local17\Field3[$00])
                        EndIf
                        local0\Field9 = (local0\Field9 - (local17\Field3[$00] / 80.0))
                        If (0.0 >= local0\Field9) Then
                            local0\Field24 = 1.0
                        EndIf
                    EndIf
                EndIf
                local0\Field7 = 0.0
                resetentity(local0\Field4)
            Case $10
                local8 = entitydistance(collider, local0\Field4)
                If (60.0 > local8) Then
                    If (playerroom\Field7\Field10 = "gateb") Then
                        local9 = max(min((entitydistance(local0\Field4, playerroom\Field19[$03]) / (8000.0 * roomscale)), 1.0), 0.0)
                    Else
                        local9 = 1.0
                    EndIf
                    local0\Field17 = loopsound2(apachesfx, local0\Field17, camera, local0\Field4, 25.0, local9)
                EndIf
                local0\Field7 = 0.0
                Select local0\Field9
                    Case 0.0,1.0
                        turnentity(local0\Field1, 0.0, (local17\Field3[$00] * 20.0), 0.0, $00)
                        turnentity(local0\Field2, (local17\Field3[$00] * 20.0), 0.0, 0.0, $00)
                        If (((1.0 = local0\Field9) And (chs\Field2 = $00)) <> 0) Then
                            If (30.0 > (Abs (entityx(collider, $00) - entityx(local0\Field4, $00)))) Then
                                If (30.0 > (Abs (entityz(collider, $00) - entityz(local0\Field4, $00)))) Then
                                    If (20.0 > (Abs (entityy(collider, $00) - entityy(local0\Field4, $00)))) Then
                                        If (rand($14, $01) = $01) Then
                                            If (entityvisible(collider, local0\Field4) <> 0) Then
                                                local0\Field9 = 2.0
                                                playsound2(alarmsfx($02), camera, local0\Field4, 50.0, 1.0)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Case 2.0,3.0
                        If (2.0 = local0\Field9) Then
                            local18 = collider
                        ElseIf (3.0 = local0\Field9) Then
                            local18 = createpivot($00)
                            positionentity(local18, local0\Field33, local0\Field34, local0\Field35, $01)
                        EndIf
                        If ((chs\Field2 And (2.0 = local0\Field9)) <> 0) Then
                            local0\Field9 = 1.0
                        EndIf
                        turnentity(local0\Field1, 0.0, (local17\Field3[$00] * 20.0), 0.0, $00)
                        turnentity(local0\Field2, (local17\Field3[$00] * 20.0), 0.0, 0.0, $00)
                        If (55.0 > (Abs (entityx(local18, $00) - entityx(local0\Field4, $00)))) Then
                            If (55.0 > (Abs (entityz(local18, $00) - entityz(local0\Field4, $00)))) Then
                                If (20.0 > (Abs (entityy(local18, $00) - entityy(local0\Field4, $00)))) Then
                                    pointentity(local0\Field0, local18, 0.0)
                                    rotateentity(local0\Field4, curveangle(min(wrapangle(entitypitch(local0\Field0, $00)), 40.0), entitypitch(local0\Field4, $00), 40.0), curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 90.0), entityroll(local0\Field4, $00), $01)
                                    positionentity(local0\Field4, entityx(local0\Field4, $00), curvevalue((entityy(local18, $00) + 8.0), entityy(local0\Field4, $00), 70.0), entityz(local0\Field4, $00), $00)
                                    local8 = distance(entityx(local18, $00), entityz(local18, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))
                                    local0\Field22 = curvevalue((min((local8 - 6.5), 6.5) * 0.008), local0\Field22, 50.0)
                                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                    If (0.0 = local0\Field38) Then
                                        local0\Field37 = entityvisible(local0\Field4, local18)
                                        local0\Field38 = (Float rand($64, $C8))
                                    Else
                                        local0\Field38 = min((local0\Field38 - local17\Field3[$00]), 0.0)
                                    EndIf
                                    If (local0\Field37 = $01) Then
                                        rotateentity(local0\Field4, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), curveangle(0.0, entityroll(local0\Field4, $00), 40.0), $01)
                                        If (0.0 >= local0\Field25) Then
                                            If (20.0 > local8) Then
                                                local26 = createpivot($00)
                                                positionentity(local26, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                                rotateentity(local26, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $00)
                                                moveentity(local26, 0.0, (1.0 / 4.831696), 1.675444)
                                                pointentity(local26, local18, 0.0)
                                                If (10.0 > wrapangle((entityyaw(local26, $00) - entityyaw(local0\Field4, $00)))) Then
                                                    playsound2(gunshot2sfx, camera, local0\Field4, 20.0, 1.0)
                                                    If (playerroom\Field7\Field10 = "gateb") Then
                                                        deathmsg = ((chr($22) + scplang_getphrase("events.gatebdeath2")) + chr($22))
                                                    Else
                                                        deathmsg = ((chr($22) + scplang_getphrase("events.gateadeath")) + chr($22))
                                                    EndIf
                                                    shoot(entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), (((10.0 / local8) * (1.0 / local8)) * (Float (2.0 = local0\Field9))), (2.0 = local0\Field9), $00)
                                                    local0\Field25 = 5.0
                                                EndIf
                                                freeentity(local26)
                                            EndIf
                                        EndIf
                                    Else
                                        rotateentity(local0\Field4, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), curveangle(-20.0, entityroll(local0\Field4, $00), 40.0), $01)
                                    EndIf
                                    moveentity(local0\Field4, ((- entityroll(local0\Field4, $00)) * 0.002), 0.0, 0.0)
                                    local0\Field25 = (local0\Field25 - local17\Field3[$00])
                                EndIf
                            EndIf
                        EndIf
                        If (3.0 = local0\Field9) Then
                            freeentity(local18)
                        EndIf
                    Case 4.0
                        If (300.0 > local0\Field10) Then
                            turnentity(local0\Field1, 0.0, (local17\Field3[$00] * 20.0), 0.0, $00)
                            turnentity(local0\Field2, (local17\Field3[$00] * 20.0), 0.0, 0.0, $00)
                            turnentity(local0\Field4, 0.0, ((- local17\Field3[$00]) * 7.0), 0.0, $00)
                            local0\Field10 = (local0\Field10 + (local17\Field3[$00] * 0.3))
                            local18 = createpivot($00)
                            positionentity(local18, local0\Field33, local0\Field34, local0\Field35, $01)
                            pointentity(local0\Field0, local18, 0.0)
                            moveentity(local0\Field0, 0.0, 0.0, ((local17\Field3[$00] * 0.001) * local0\Field10))
                            positionentity(local0\Field4, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            If (0.3 > entitydistance(local0\Field0, local18)) Then
                                camerashake = max(camerashake, 3.0)
                                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\Character\Apache\Crash" + (Str rand($01, $02))) + ".ogg"))))
                                local0\Field9 = 5.0
                            EndIf
                            freeentity(local18)
                        EndIf
                End Select
                positionentity(local0\Field0, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
            Case $02
                local8 = entitydistance(local0\Field4, collider)
                If (hidedistance > local8) Then
                    If (local0\Field48 = $00) Then
                        Select local0\Field9
                            Case 0.0
                                If (283.0 < local0\Field14) Then
                                    heartbeatvolume = max(curvevalue(1.0, heartbeatvolume, 50.0), heartbeatvolume)
                                    heartbeatrate = max(curvevalue(130.0, heartbeatrate, 100.0), heartbeatrate)
                                    pointentity(local0\Field0, collider, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 25.0), 0.0, $00)
                                    animatenpc(local0, 283.0, 389.0, 0.3, $00)
                                    If (388.0 < local0\Field14) Then
                                        local0\Field9 = 1.0
                                        freesound_strict(local0\Field19)
                                        local0\Field19 = $00
                                    EndIf
                                ElseIf (2.5 > local8) Then
                                    setnpcframe(local0, 284.0)
                                    local0\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\Room\035Chamber\TentacleSpawn.ogg"))
                                    playsound_strict(local0\Field19)
                                EndIf
                            Case 1.0
                                If (local0\Field19 = $00) Then
                                    freesound_strict(local0\Field19)
                                    local0\Field19 = $00
                                    local0\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\Room\035Chamber\TentacleIdle.ogg"))
                                EndIf
                                local0\Field20 = loopsound2(local0\Field19, local0\Field20, camera, local0\Field4, 10.0, 1.0)
                                If (((1.8 > local8) And (chs\Field2 = $00)) <> 0) Then
                                    If (20.0 > (Abs deltayaw(local0\Field4, collider))) Then
                                        local0\Field9 = 2.0
                                        If (local0\Field16 <> $00) Then
                                            freesound_strict(local0\Field16)
                                            local0\Field16 = $00
                                        EndIf
                                    EndIf
                                EndIf
                                pointentity(local0\Field0, collider, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 25.0), 0.0, $00)
                                animatenpc(local0, 33.0, 174.0, 0.3, $01)
                            Case 2.0
                                If (((33.0 < local0\Field14) And (174.0 > local0\Field14)) <> 0) Then
                                    animatenpc(local0, 33.0, 174.0, 2.0, $00)
                                Else
                                    pointentity(local0\Field0, collider, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    If (33.0 < local0\Field14) Then
                                        If (local0\Field19 <> $00) Then
                                            freesound_strict(local0\Field19)
                                            local0\Field19 = $00
                                        EndIf
                                        local0\Field14 = 2.0
                                        local0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\035Chamber\TentacleAttack" + (Str rand($01, $02))) + ".ogg")))
                                        playsound_strict(local0\Field16)
                                    EndIf
                                    animatenpc(local0, 2.0, 32.0, 0.3, $00)
                                    If (((5.0 <= local0\Field14) And (6.0 > local0\Field14)) <> 0) Then
                                        If (1.8 > local8) Then
                                            If (20.0 > (Abs deltayaw(local0\Field4, collider))) Then
                                                If (wearinghazmat <> 0) Then
                                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\General\BodyFall.ogg")))
                                                    blurtimer = 100.0
                                                    If (i_1033ru\Field0 = $00) Then
                                                        injuries = (rnd(0.5, 0.0) + injuries)
                                                    Else
                                                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $14))
                                                        local0\Field61 = (local0\Field61 - $1E)
                                                        If (local0\Field61 <= $00) Then
                                                            local0\Field48 = $01
                                                        EndIf
                                                    EndIf
                                                Else
                                                    blurtimer = 100.0
                                                    playsound_strict(damagesfx(rand($02, $03)))
                                                    If (i_1033ru\Field0 = $00) Then
                                                        injuries = (rnd(1.0, 1.5) + injuries)
                                                    Else
                                                        damage1033ru($14)
                                                        local0\Field61 = (local0\Field61 - $22)
                                                        If (local0\Field61 <= $00) Then
                                                            local0\Field48 = $01
                                                        EndIf
                                                    EndIf
                                                    If (3.0 < injuries) Then
                                                        If (playerroom\Field7\Field10 = "room2offices") Then
                                                            deathmsg = ((chr($22) + scplang_getphrase("events.scp0351")) + chr($22))
                                                        Else
                                                            deathmsg = ((chr($22) + scplang_getphrase("events.scp0352")) + chr($22))
                                                        EndIf
                                                        kill($01, $00)
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                        local0\Field14 = 6.0
                                    ElseIf (32.0 = local0\Field14) Then
                                        local0\Field9 = 1.0
                                        local0\Field14 = 173.0
                                    EndIf
                                EndIf
                        End Select
                    Else
                        animatenpc(local0, 515.0, 551.0, 0.15, $00)
                        If (551.0 <= local0\Field14) Then
                            hideentity(local0\Field0)
                            hideentity(local0\Field4)
                        EndIf
                    EndIf
                EndIf
                positionentity(local0\Field0, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, (entitypitch(local0\Field4, $00) - 90.0), (entityyaw(local0\Field4, $00) - 180.0), entityroll(local0\Field4, $00), $01)
                local0\Field7 = 0.0
                resetentity(local0\Field4)
            Case $0B
                If (playerroom\Field7\Field10 = "room860") Then
                    local53 = playerroom\Field11
                    local8 = entitydistance(collider, local0\Field4)
                    If (forestnpc <> $00) Then
                        If (1.0 = forestnpcdata[$02]) Then
                            showentity(forestnpc)
                            If (1.0 <> local0\Field9) Then
                                If ((((-8.0 > blinktimer) And (-12.0 < blinktimer)) Or (entityinview(forestnpc, camera) = $00)) <> 0) Then
                                    forestnpcdata[$02] = 0.0
                                    hideentity(forestnpc)
                                EndIf
                            EndIf
                        Else
                            hideentity(forestnpc)
                        EndIf
                    EndIf
                    Select local0\Field9
                        Case 0.0
                            hideentity(local0\Field4)
                            hideentity(local0\Field0)
                            hideentity(local0\Field1)
                            local0\Field10 = 0.0
                            positionentity(local0\Field4, 0.0, -100.0, 0.0, $00)
                        Case 1.0
                            local0\Field7 = 0.0
                            If (-100.0 >= entityy(local0\Field4, $00)) Then
                                tformpoint(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00, local53\Field5)
                                local11 = floor(((tformedx() + 6.0) / 12.0))
                                local13 = floor(((tformedz() + 6.0) / 12.0))
                                For local55 = (Int max((local11 - 1.0), 1.0)) To (Int min((local11 + 1.0), 10.0)) Step $02
                                    For local56 = (Int max((local13 - 1.0), 1.0)) To (Int min((local13 + 1.0), 10.0)) Step $02
                                        If (local53\Field3[((local56 * $0A) + local55)] = $00) Then
                                            tformpoint(((((Float local55) + local11) / 2.0) * 12.0), 0.0, ((((Float local56) + local13) / 2.0) * 12.0), local53\Field5, $00)
                                            If (entityinview(local0\Field4, camera) <> 0) Then
                                                positionentity(local0\Field4, 0.0, -110.0, 0.0, $00)
                                            Else
                                                positionentity(local0\Field4, tformedx(), (entityy(local53\Field5, $01) + 2.3), tformedz(), $00)
                                                local55 = $0A
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                Next
                                If (-100.0 < entityy(local0\Field4, $00)) Then
                                    playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 15.0, 0.5)
                                    If (1.0 <> forestnpcdata[$02]) Then
                                        forestnpcdata[$02] = 0.0
                                    EndIf
                                    Select rand($03, $01)
                                        Case $01
                                            pointentity(local0\Field4, collider, 0.0)
                                            local0\Field14 = 2.0
                                        Case $02
                                            pointentity(local0\Field4, collider, 0.0)
                                            local0\Field14 = 201.0
                                        Case $03
                                            pointentity(local0\Field4, collider, 0.0)
                                            turnentity(local0\Field4, 0.0, 90.0, 0.0, $00)
                                            local0\Field14 = 299.0
                                    End Select
                                    local0\Field10 = 0.0
                                EndIf
                            Else
                                showentity(local0\Field0)
                                showentity(local0\Field4)
                                positionentity(local0\Field4, entityx(local0\Field4, $00), (entityy(local53\Field5, $01) + 2.3), entityz(local0\Field4, $00), $00)
                                If (forestnpc <> $00) Then
                                    If (0.0 = forestnpcdata[$02]) Then
                                        local58 = $00
                                        local59 = $00
                                        For local7 = $00 To (maxitemamount - $01) Step $01
                                            If (inventory(local7) <> Null) Then
                                                local60 = inventory(local7)\Field3\Field0
                                                If ((((local60 = "Log #1") Or (local60 = "Log #2")) Or (local60 = "Log #3")) <> 0) Then
                                                    local59 = (local59 + $01)
                                                    local58 = (local58 + ($0A * local59))
                                                EndIf
                                            EndIf
                                        Next
                                        If (rand($01, ($35C - local58)) = $01) Then
                                            showentity(forestnpc)
                                            forestnpcdata[$02] = 1.0
                                            If (rand($02, $01) = $01) Then
                                                forestnpcdata[$00] = 0.0
                                            Else
                                                forestnpcdata[$00] = 2.0
                                            EndIf
                                            forestnpcdata[$01] = 0.0
                                            positionentity(forestnpc, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.5), entityz(local0\Field4, $00), $00)
                                            rotateentity(forestnpc, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                                            moveentity(forestnpc, 0.75, 0.0, 0.0)
                                            rotateentity(forestnpc, 0.0, 0.0, 0.0, $00)
                                            entitytexture(forestnpc, at\Field1[$02], (Int forestnpcdata[$00]), $00)
                                        Else
                                            forestnpcdata[$02] = 2.0
                                        EndIf
                                    ElseIf (1.0 = forestnpcdata[$02]) Then
                                        If (0.0 = forestnpcdata[$01]) Then
                                            If (rand($C8, $01) = $01) Then
                                                forestnpcdata[$01] = local17\Field3[$00]
                                                entitytexture(forestnpc, at\Field1[$02], (Int (forestnpcdata[$00] + 1.0)), $00)
                                            EndIf
                                        ElseIf (((0.0 < forestnpcdata[$01]) And (5.0 > forestnpcdata[$01])) <> 0) Then
                                            forestnpcdata[$01] = min((local17\Field3[$00] + forestnpcdata[$01]), 5.0)
                                        Else
                                            forestnpcdata[$01] = 0.0
                                            entitytexture(forestnpc, at\Field1[$02], (Int forestnpcdata[$00]), $00)
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.0 = local0\Field10) Then
                                    If (entityinview(local0\Field4, camera) <> 0) Then
                                        local0\Field10 = 1.0
                                        If (rand($08, $01) = $01) Then
                                            playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\860\Cancer" + (Str rand($00, $02))) + ".ogg"))), camera, local0\Field4, 20.0, 1.0)
                                        EndIf
                                    EndIf
                                ElseIf (199.0 >= local0\Field14) Then
                                    animatenpc(local0, 2.0, 199.0, 0.5, $00)
                                    If (199.0 = local0\Field14) Then
                                        local0\Field14 = 298.0
                                        playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 15.0, 1.0)
                                    EndIf
                                ElseIf (297.0 >= local0\Field14) Then
                                    pointentity(local0\Field4, collider, 0.0)
                                    animatenpc(local0, 200.0, 297.0, 0.5, $00)
                                    If (297.0 = local0\Field14) Then
                                        local0\Field14 = 298.0
                                        playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 15.0, 1.0)
                                    EndIf
                                Else
                                    local10 = curveangle(point_direction(entityx(local0\Field4, $00), entityz(local0\Field4, $00), entityx(collider, $00), entityz(collider, $00)), (entityyaw(local0\Field4, $00) + 90.0), 20.0)
                                    rotateentity(local0\Field4, 0.0, (local10 - 90.0), 0.0, $01)
                                    animatenpc(local0, 298.0, 316.0, (local0\Field22 * 10.0), $01)
                                    local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                    If (15.0 < local8) Then
                                        positionentity(local0\Field4, 0.0, -110.0, 0.0, $00)
                                        local0\Field9 = 0.0
                                        local0\Field10 = 0.0
                                    EndIf
                                EndIf
                            EndIf
                            resetentity(local0\Field4)
                        Case 2.0
                            showentity(local0\Field0)
                            showentity(local0\Field4)
                            local14 = local0\Field14
                            If (-100.0 >= entityy(local0\Field4, $00)) Then
                                tformpoint(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00, local53\Field5)
                                local11 = floor(((tformedx() + 6.0) / 12.0))
                                local13 = floor(((tformedz() + 6.0) / 12.0))
                                For local55 = (Int max((local11 - 1.0), 1.0)) To (Int min((local11 + 1.0), 10.0)) Step $01
                                    For local56 = (Int max((local13 - 1.0), 1.0)) To (Int min((local13 + 1.0), 10.0)) Step $01
                                        If ((((local53\Field3[((local56 * $0A) + local55)] > $00) And ((local11 <> (Float local55)) Or (local13 <> (Float local56)))) And ((local11 = (Float local55)) Or (local13 = (Float local56)))) <> 0) Then
                                            tformpoint(((Float local55) * 12.0), 0.0, ((Float local56) * 12.0), local53\Field5, $00)
                                            positionentity(local0\Field4, tformedx(), (entityy(local53\Field5, $01) + 1.0), tformedz(), $00)
                                            If (entityinview(local0\Field4, camera) <> 0) Then
                                                blinktimer = -10.0
                                            Else
                                                local55 = $0A
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                Next
                            Else
                                local10 = curveangle((Float find860angle(local0, local53)), (entityyaw(local0\Field4, $00) + 90.0), 80.0)
                                rotateentity(local0\Field4, 0.0, (local10 - 90.0), 0.0, $01)
                                local0\Field22 = curvevalue((local0\Field21 * 0.3), local0\Field22, 50.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                animatenpc(local0, 494.0, 569.0, (local0\Field22 * 25.0), $01)
                                If (0.0 = local0\Field10) Then
                                    If (8.0 > local8) Then
                                        If (entityinview(local0\Field4, camera) <> 0) Then
                                            playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\860\Chase" + (Str rand($01, $02))) + ".ogg"))))
                                            playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\860\Cancer" + (Str rand($00, $02))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                            local0\Field10 = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.03 < currspeed) Then
                                    local0\Field11 = (local0\Field11 + local17\Field3[$00])
                                    If (local0\Field11 > rnd(5000.0, 0.0)) Then
                                        local21 = $01
                                        If (local0\Field17 <> $00) Then
                                            If (channelplaying(local0\Field17) <> 0) Then
                                                local21 = $00
                                            EndIf
                                        EndIf
                                        If (local21 <> 0) Then
                                            local0\Field17 = playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\860\Cancer" + (Str rand($00, $02))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field11 = max((local0\Field11 - local17\Field3[$00]), 0.0)
                                EndIf
                                If (((4.5 > local8) Or (rnd(200.0, 250.0) < local0\Field11)) <> 0) Then
                                    local0\Field17 = playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\860\Cancer" + (Str rand($03, $05))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                    local0\Field9 = 3.0
                                EndIf
                                If (20.0 < local8) Then
                                    local0\Field9 = 0.0
                                    local0\Field10 = 0.0
                                    positionentity(local0\Field4, 0.0, -110.0, 0.0, $00)
                                EndIf
                            EndIf
                            If ((((533.0 > local14) And (533.0 <= local0\Field14)) Or ((568.0 < local14) And (2.0 > local0\Field14))) <> 0) Then
                                playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 15.0, 0.6)
                            EndIf
                        Case 3.0
                            showentity(local0\Field0)
                            showentity(local0\Field4)
                            local14 = local0\Field14
                            local10 = curveangle((Float find860angle(local0, local53)), (entityyaw(local0\Field4, $00) + 90.0), 40.0)
                            rotateentity(local0\Field4, 0.0, (local10 - 90.0), 0.0, $01)
                            If (local0\Field16 = $00) Then
                                local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\General\Slash1.ogg"))
                            EndIf
                            If (local0\Field19 = $00) Then
                                local0\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\General\Slash2.ogg"))
                            EndIf
                            If ((((1.1 > local8) Or ((451.0 < local0\Field14) And (493.0 > local0\Field14))) Or (0.0 > killtimer)) <> 0) Then
                                deathmsg = ""
                                local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                                animatenpc(local0, 451.0, 493.0, 0.5, $00)
                                If (((461.0 > local14) And (461.0 <= local0\Field14)) <> 0) Then
                                    If (0.0 <= killtimer) Then
                                        kill($01, $00)
                                        killanim = $00
                                    EndIf
                                    playsound_strict(local0\Field16)
                                EndIf
                                If (((476.0 > local14) And (476.0 <= local0\Field14)) <> 0) Then
                                    playsound_strict(local0\Field19)
                                EndIf
                                If (((486.0 > local14) And (486.0 <= local0\Field14)) <> 0) Then
                                    playsound_strict(local0\Field19)
                                EndIf
                            Else
                                local0\Field22 = curvevalue((local0\Field21 * 0.8), local0\Field22, 10.0)
                                animatenpc(local0, 298.0, 316.0, (local0\Field22 * 10.0), $01)
                                If (((307.0 > local14) And (307.0 <= local0\Field14)) <> 0) Then
                                    playsound2(step2sfx(rand($03, $05)), camera, local0\Field4, 10.0, 1.0)
                                EndIf
                            EndIf
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                    End Select
                    If (0.0 <> local0\Field9) Then
                        rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                        positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.1), entityz(local0\Field4, $00), $00)
                        rotateentity(local0\Field0, (entitypitch(local0\Field4, $00) - 90.0), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
                        If (8.0 < local8) Then
                            showentity(local0\Field1)
                            entityalpha(local0\Field1, min((local8 - 8.0), 1.0))
                            positionentity(local0\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                            moveentity(local0\Field1, 0.0, 0.75, -0.825)
                            local26 = createpivot($00)
                            positionentity(local26, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                            pointentity(local26, local0\Field1, 0.0)
                            moveentity(local26, 0.0, 0.0, 8.0)
                            positionentity(local0\Field1, entityx(local26, $00), entityy(local26, $00), entityz(local26, $00), $00)
                            freeentity(local26)
                        Else
                            hideentity(local0\Field1)
                        EndIf
                    EndIf
                EndIf
            Case $0C
                If (playerroom\Field7\Field10 <> "room3storage") Then
                    local0\Field9 = 66.0
                EndIf
                If (66.0 > local0\Field9) Then
                    Select local0\Field9
                        Case 0.0
                            animatenpc(local0, 290.0, 405.0, 0.1, $01)
                        Case 1.0
                            If (((644.0 <= local0\Field14) And (683.0 > local0\Field14)) <> 0) Then
                                local0\Field22 = curvevalue((local0\Field21 * 0.05), local0\Field22, 10.0)
                                animatenpc(local0, 644.0, 683.0, ((local0\Field22 * 28.0) * 4.0), $00)
                                If (682.0 <= local0\Field14) Then
                                    local0\Field14 = 175.0
                                EndIf
                            Else
                                local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                                animatenpc(local0, 175.0, 297.0, 0.22, $00)
                                If (296.0 <= local0\Field14) Then
                                    local0\Field9 = 2.0
                                EndIf
                            EndIf
                            local0\Field26 = $00
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                        Case 2.0
                            local0\Field10 = max(local0\Field10, (Float (local0\Field12 - $03)))
                            local8 = entitydistance(local0\Field4, playerroom\Field19[(Int local0\Field10)])
                            local0\Field22 = curvevalue(((local0\Field21 * 0.3) * min(local8, 1.0)), local0\Field22, 10.0)
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                            local14 = local0\Field14
                            animatenpc(local0, 644.0, 683.0, (local0\Field22 * 28.0), $01)
                            If ((((664.0 > local14) And (664.0 <= local0\Field14)) Or ((673.0 < local14) And (654.0 > local0\Field14))) <> 0) Then
                                playsound2(stepsfx($04, $00, rand($00, $03)), camera, local0\Field4, 12.0, 1.0)
                                If (rand($0A, $01) = $01) Then
                                    local21 = $00
                                    If (local0\Field17 = $00) Then
                                        local21 = $01
                                    ElseIf (channelplaying(local0\Field17) = $00) Then
                                        local21 = $01
                                    EndIf
                                    If (local21 <> 0) Then
                                        If (local0\Field16 <> $00) Then
                                            freesound_strict(local0\Field16)
                                            local0\Field16 = $00
                                        EndIf
                                        local0\Field16 = loadsound_strict(scpmodding_processfilepath((((("SFX\SCP\939\" + (Str (local0\Field6 Mod $03))) + "Lure") + (Str rand($01, $0A))) + ".ogg")))
                                        local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 10.0, 1.0)
                                    EndIf
                                EndIf
                            EndIf
                            pointentity(local0\Field0, playerroom\Field19[(Int local0\Field10)], 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                            If (0.4 > local8) Then
                                local0\Field10 = (local0\Field10 + 1.0)
                                If ((Float local0\Field12) < local0\Field10) Then
                                    local0\Field10 = (Float (local0\Field12 - $03))
                                EndIf
                                local0\Field9 = 1.0
                            EndIf
                        Case 3.0
                            If (entityvisible(collider, local0\Field4) <> 0) Then
                                If (local0\Field19 = $00) Then
                                    local0\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\General\Slash1.ogg"))
                                EndIf
                                local0\Field33 = entityx(collider, $00)
                                local0\Field35 = entityz(collider, $00)
                                local0\Field26 = $46
                            EndIf
                            If (((local0\Field26 > $00) And (chs\Field2 = $00)) <> 0) Then
                                local14 = local0\Field14
                                If (((18.0 <= local0\Field14) And (68.0 > local0\Field14)) <> 0) Then
                                    local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                                    animatenpc(local0, 18.0, 68.0, 0.5, $01)
                                    local21 = $00
                                    If (((24.0 > local14) And (24.0 <= local0\Field14)) <> 0) Then
                                        local21 = $01
                                    ElseIf (((57.0 > local14) And (57.0 <= local0\Field14)) <> 0) Then
                                        local21 = $01
                                    EndIf
                                    If (local21 <> 0) Then
                                        If (1.5 > distance(local0\Field33, local0\Field35, entityx(local0\Field4, $00), entityz(local0\Field4, $00))) Then
                                            playsound_strict(local0\Field19)
                                            blurtimer = 500.0
                                            If (i_1033ru\Field0 = $00) Then
                                                injuries = ((rnd(1.5, 2.5) + injuries) - ((Float wearingvest) * 0.5))
                                            Else
                                                damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $14))
                                            EndIf
                                        Else
                                            local0\Field14 = 449.0
                                        EndIf
                                    EndIf
                                    If (4.0 < injuries) Then
                                        deathmsg = ((chr($22) + scplang_getphrase("events.scp939")) + chr($22))
                                        kill($01, $00)
                                        If (chs\Field0 = $00) Then
                                            local0\Field9 = 5.0
                                        EndIf
                                    EndIf
                                ElseIf (local0\Field26 = $46) Then
                                    local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                    animatenpc(local0, 449.0, 464.0, (local0\Field22 * 6.0), $01)
                                    If ((((452.0 > local14) And (452.0 <= local0\Field14)) Or ((459.0 > local14) And (459.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($01, $01, rand($00, $07)), camera, local0\Field4, 12.0, 1.0)
                                    EndIf
                                    If (1.1 > distance(local0\Field33, local0\Field35, entityx(local0\Field4, $00), entityz(local0\Field4, $00))) Then
                                        local0\Field14 = 18.0
                                    EndIf
                                Else
                                    local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                                    animatenpc(local0, 175.0, 297.0, (local0\Field22 * 5.0), $01)
                                EndIf
                                local10 = vectoryaw((local0\Field33 - entityx(local0\Field4, $00)), 0.0, (local0\Field35 - entityz(local0\Field4, $00)))
                                rotateentity(local0\Field4, 0.0, curveangle(local10, entityyaw(local0\Field4, $00), 15.0), 0.0, $00)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                local0\Field26 = (Int ((Float local0\Field26) - local17\Field3[$00]))
                            Else
                                local0\Field9 = 2.0
                            EndIf
                        Case 5.0
                            If (68.0 > local0\Field14) Then
                                animatenpc(local0, 18.0, 68.0, 0.5, $00)
                            Else
                                animatenpc(local0, 464.0, 473.0, 0.5, $00)
                            EndIf
                    End Select
                    If ((((3.0 > local0\Field9) And (chs\Field2 = $00)) And (local0\Field50 = $00)) <> 0) Then
                        local8 = entitydistance(local0\Field4, collider)
                        If (4.0 > local8) Then
                            local8 = (local8 - (Float entityvisible(collider, local0\Field4)))
                        EndIf
                        If (((local8 < (playersoundvolume * 1.2)) Or (1.5 > local8)) <> 0) Then
                            If (0.0 = local0\Field11) Then
                                If (local0\Field16 <> $00) Then
                                    freesound_strict(local0\Field16)
                                    local0\Field16 = $00
                                EndIf
                                local0\Field16 = loadsound_strict(scpmodding_processfilepath((((("SFX\SCP\939\" + (Str (local0\Field6 Mod $03))) + "Attack") + (Str rand($01, $03))) + ".ogg")))
                                local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 10.0, 1.0)
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\939\Attack.ogg")))
                                local0\Field11 = 1.0
                            EndIf
                            local0\Field9 = 3.0
                        ElseIf (local8 < (playersoundvolume * 1.6)) Then
                            If (((1.0 <> local0\Field9) And (0.0 >= local0\Field25)) <> 0) Then
                                If (local0\Field16 <> $00) Then
                                    freesound_strict(local0\Field16)
                                    local0\Field16 = $00
                                EndIf
                                local0\Field16 = loadsound_strict(scpmodding_processfilepath((((("SFX\SCP\939\" + (Str (local0\Field6 Mod $03))) + "Alert") + (Str rand($01, $03))) + ".ogg")))
                                local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 10.0, 1.0)
                                local0\Field14 = 175.0
                                local0\Field25 = 210.0
                            EndIf
                            local0\Field9 = 1.0
                        EndIf
                        local0\Field25 = (local0\Field25 - local17\Field3[$00])
                    EndIf
                    rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.28), entityz(local0\Field4, $00), $00)
                    rotateentity(local0\Field0, (entitypitch(local0\Field4, $00) - 90.0), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
                EndIf
            Case $05
                local8 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))
                If (6.0 > entitydistance(collider, local0\Field4)) Then
                    giveachievement($27, $01)
                EndIf
                Select local0\Field9
                    Case 0.0
                        If (20.0 < local8) Then
                            animatenpc(local0, 451.0, 612.0, 0.2, $01)
                            If ((Float millisecs2()) > local0\Field10) Then
                                For local25 = Each waypoints
                                    If (local25\Field1 = Null) Then
                                        If (4.0 > (Abs (entityx(local25\Field0, $01) - entityx(local0\Field4, $00)))) Then
                                            If (4.0 > (Abs (entityz(local25\Field0, $01) - entityz(local0\Field4, $00)))) Then
                                                positionentity(local0\Field4, entityx(local25\Field0, $01), (entityy(local25\Field0, $01) + 0.3), entityz(local25\Field0, $01), $00)
                                                resetentity(local0\Field4)
                                                Exit
                                            EndIf
                                        EndIf
                                    EndIf
                                Next
                                local0\Field10 = (Float (millisecs2() + $1388))
                            EndIf
                        ElseIf (8.0 > local8) Then
                            local0\Field27 = rnd(1.0, 2.5)
                            local0\Field9 = 1.0
                        EndIf
                    Case 1.0
                        If (451.0 > local0\Field14) Then
                            local10 = wrapangle(curveangle((deltayaw(local0\Field4, collider) - 180.0), ((animtime(local0\Field0) - 2.0) / 1.2445), 15.0))
                            setnpcframe(local0, ((local10 * 1.2445) + 2.0))
                        Else
                            animatenpc(local0, 636.0, 646.0, 0.4, $00)
                            If (646.0 = local0\Field14) Then
                                setnpcframe(local0, 2.0)
                            EndIf
                        EndIf
                        local8 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))
                        If (rand($2BC, $01) = $01) Then
                            playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\066\Eric" + (Str rand($01, $03))) + ".ogg"))), camera, local0\Field4, 8.0, 1.0)
                        EndIf
                        If (local8 < (local0\Field27 + 1.0)) Then
                            local0\Field9 = (Float rand($02, $03))
                        EndIf
                    Case 2.0
                        If (647.0 > local0\Field14) Then
                            local10 = curveangle(0.0, ((animtime(local0\Field0) - 2.0) / 1.2445), 5.0)
                            If (((5.0 > local10) Or (355.0 < local10)) <> 0) Then
                                setnpcframe(local0, 647.0)
                            Else
                                setnpcframe(local0, ((local10 * 1.2445) + 2.0))
                            EndIf
                        ElseIf (683.0 = local0\Field14) Then
                            If (0.0 = local0\Field10) Then
                                If (rand($02, $01) = $01) Then
                                    playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\066\Eric" + (Str rand($01, $03))) + ".ogg"))), camera, local0\Field4, 8.0, 1.0)
                                Else
                                    playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\066\Notes" + (Str rand($01, $06))) + ".ogg"))), camera, local0\Field4, 8.0, 1.0)
                                EndIf
                                Select rand($01, $06)
                                    Case $01
                                        If (local0\Field19 = $00) Then
                                            local0\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\066\Beethoven.ogg"))
                                        EndIf
                                        local0\Field20 = playsound2(local0\Field19, camera, local0\Field4, 10.0, 1.0)
                                        deaftimer = (Float (((selecteddifficulty\Field3 * $0F) + $2D) * $46))
                                        deafplayer = $01
                                        camerashake = 10.0
                                    Case $02
                                        local0\Field11 = (Float rand($2BC, $578))
                                    Case $03
                                        For local2 = Each doors
                                            If ((((local2\Field4 = $00) And (local2\Field12 = $00)) And (local2\Field17 = "")) <> 0) Then
                                                If (16.0 > (Abs (entityx(local2\Field2, $00) - entityx(local0\Field4, $00)))) Then
                                                    If (16.0 > (Abs (entityz(local2\Field2, $00) - entityz(local0\Field4, $00)))) Then
                                                        usedoor(local2, $00, $01)
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    Case $04
                                        If (playerroom\Field7\Field13 = $00) Then
                                            camerashake = 5.0
                                            local3 = createdecal($01, entityx(local0\Field4, $00), 0.01, entityz(local0\Field4, $00), 90.0, (Float rand($168, $01)), 0.0)
                                            local3\Field2 = 0.3
                                            updatedecals()
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\General\BodyFall.ogg")))
                                            If (0.8 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))) Then
                                                If (i_1033ru\Field0 = $00) Then
                                                    injuries = (rnd(0.3, 0.5) + injuries)
                                                Else
                                                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                                                EndIf
                                            EndIf
                                        EndIf
                                End Select
                            EndIf
                            local0\Field10 = (local0\Field10 + local17\Field3[$00])
                            If (70.0 < local0\Field10) Then
                                local0\Field9 = 3.0
                                local0\Field10 = 0.0
                            EndIf
                        Else
                            local0\Field22 = curvevalue((local0\Field21 * 1.5), local0\Field22, 10.0)
                            pointentity(local0\Field0, collider, 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle((entityyaw(local0\Field0, $00) - 180.0), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                            animatenpc(local0, 647.0, 683.0, (local0\Field22 * 25.0), $00)
                            moveentity(local0\Field4, 0.0, 0.0, ((- local0\Field22) * local17\Field3[$00]))
                        EndIf
                    Case 3.0
                        pointentity(local0\Field0, collider, 0.0)
                        local10 = curveangle(((entityyaw(local0\Field0, $00) + local0\Field15) - 180.0), entityyaw(local0\Field4, $00), 10.0)
                        rotateentity(local0\Field4, 0.0, local10, 0.0, $00)
                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                        If (rand($64, $01) = $01) Then
                            local0\Field15 = rnd(-20.0, 20.0)
                        EndIf
                        local0\Field10 = (local0\Field10 + local17\Field3[$00])
                        If (250.0 < local0\Field10) Then
                            animatenpc(local0, 684.0, 647.0, ((- local0\Field22) * 25.0), $00)
                            If (647.0 = local0\Field14) Then
                                local0\Field9 = 0.0
                                local0\Field10 = 0.0
                            EndIf
                        Else
                            animatenpc(local0, 684.0, 647.0, ((- local0\Field22) * 25.0), $01)
                        EndIf
                End Select
                If (1.0 < local0\Field9) Then
                    If (local0\Field16 = $00) Then
                        local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\066\Rolling.ogg"))
                    EndIf
                    If (local0\Field17 <> $00) Then
                        If (channelplaying(local0\Field17) <> 0) Then
                            local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 20.0, 1.0)
                        EndIf
                    Else
                        local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 20.0, 1.0)
                    EndIf
                EndIf
                If (0.0 < local0\Field11) Then
                    local0\Field11 = (local0\Field11 - local17\Field3[$00])
                    lightvolume = (templightvolume - (min(max((local0\Field11 / 500.0), 0.01), 0.6) * templightvolume))
                    heartbeatrate = max(heartbeatrate, 130.0)
                    heartbeatvolume = max(heartbeatvolume, min((local0\Field11 / 1000.0), 1.0))
                EndIf
                If (channelplaying(local0\Field20) <> 0) Then
                    updatesoundorigin2(local0\Field20, camera, local0\Field4, 20.0, 1.0)
                    blurtimer = max(((5.0 - local8) * 300.0), 0.0)
                EndIf
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, (entitypitch(local0\Field4, $00) - 90.0), entityyaw(local0\Field4, $00), 0.0, $00)
            Case $0D
                local8 = entitydistance(local0\Field4, collider)
                If (-1.0 < local0\Field9) Then
                    If (hidedistance > local8) Then
                        local14 = local0\Field14
                        If (local0\Field16 > $00) Then
                            local21 = $00
                            If (0.0 < local0\Field9) Then
                                local21 = $01
                            EndIf
                            local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, camera, 10.0, (Float local21))
                        EndIf
                        local21 = (Int rnd(-1.0, 1.0))
                        positionentity(local0\Field0, entityx(local0\Field4, $01), (entityy(local0\Field4, $01) - 0.2), entityz(local0\Field4, $01), $00)
                        rotateentity(local0\Field0, -90.0, entityyaw(local0\Field4, $00), 0.0, $00)
                        If (wearingnightvision = $00) Then
                            hideentity(local0\Field0)
                            If ((((1.0 > local8) And (0.0 >= local0\Field25)) And (0.0 >= msgtimer)) <> 0) Then
                                Select rand($06, $01)
                                    Case $01
                                        msg = scplang_getphrase("events.scp9661")
                                    Case $02
                                        msg = ((chr($22) + scplang_getphrase("events.scp9662")) + chr($22))
                                    Case $03
                                        msg = scplang_getphrase("events.scp9663")
                                    Case $04
                                        msg = ((chr($22) + scplang_getphrase("events.scp9664")) + chr($22))
                                    Case $05
                                        msg = scplang_getphrase("events.scp9665")
                                    Case $06
                                        msg = scplang_getphrase("events.scp9666")
                                End Select
                                local0\Field25 = 1400.0
                                msgtimer = 560.0
                            EndIf
                            local0\Field25 = (local0\Field25 - local17\Field3[$00])
                        Else
                            showentity(local0\Field0)
                        EndIf
                        If (350.0 < local0\Field11) Then
                            If (1000.0 > local0\Field11) Then
                                For local1 = Each npcs
                                    If (local1\Field5 = local0\Field5) Then
                                        local1\Field11 = 1000.0
                                    EndIf
                                Next
                            EndIf
                            local0\Field9 = max(local0\Field9, 8.0)
                            local0\Field11 = 1000.0
                        EndIf
                        If (10.0 > stamina) Then
                            local0\Field11 = (local0\Field11 + local17\Field3[$00])
                        ElseIf (900.0 > local0\Field11) Then
                            local0\Field11 = max((local0\Field11 - (local17\Field3[$00] * 0.2)), 0.0)
                        EndIf
                        If (10.0 <> local0\Field9) Then
                            local0\Field26 = $00
                        EndIf
                        Select local0\Field9
                            Case 0.0
                                If (556.0 < local0\Field14) Then
                                    animatenpc(local0, 628.0, 652.0, 0.25, $00)
                                    If (651.0 < local0\Field14) Then
                                        setnpcframe(local0, 2.0)
                                    EndIf
                                Else
                                    animatenpc(local0, 2.0, 214.0, 0.25, $00)
                                    If (213.0 < local0\Field14) Then
                                        If (((rand($03, $01) = $01) And (4.0 > local8)) <> 0) Then
                                            local0\Field9 = (Float rand($01, $04))
                                        Else
                                            local0\Field9 = (Float rand($05, $06))
                                        EndIf
                                    EndIf
                                    If (2.0 > local8) Then
                                        local0\Field9 = (Float rand($01, $04))
                                    EndIf
                                EndIf
                                local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                                moveentity(local0\Field4, 0.0, 0.0, local0\Field22)
                            Case 1.0,2.0
                                animatenpc(local0, 214.0, 257.0, 0.25, $00)
                                If (256.0 < local0\Field14) Then
                                    local0\Field9 = 0.0
                                EndIf
                                If (((228.0 < local0\Field14) And (228.0 >= local14)) <> 0) Then
                                    playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\966\Echo" + (Str rand($01, $03))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                EndIf
                                local10 = vectoryaw((entityx(collider, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(collider, $00) - entityz(local0\Field4, $00)))
                                rotateentity(local0\Field4, 0.0, curveangle(local10, entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                If (900.0 > local0\Field11) Then
                                    blurtimer = (((sin((Float (millisecs2() / $32))) + 1.0) * 200.0) / local8)
                                    If (wearingnightvision > $00) Then
                                        giveachievement($16, $01)
                                    EndIf
                                    If (((((i_714\Field0 = $00) And (wearinggasmask < $03)) And (wearinghazmat < $03)) And (16.0 > local8)) <> 0) Then
                                        blinkeffect = max(blinkeffect, 1.5)
                                        blinkeffecttimer = 1000.0
                                        staminaeffect = 2.0
                                        staminaeffecttimer = 1000.0
                                        If (((0.0 >= msgtimer) And (1.5 > staminaeffect)) <> 0) Then
                                            Select rand($04, $01)
                                                Case $01
                                                    msg = scplang_getphrase("events.scp9667")
                                                Case $02
                                                    msg = ((chr($22) + scplang_getphrase("events.scp9668")) + chr($22))
                                                Case $03
                                                    msg = ((chr($22) + scplang_getphrase("events.scp9669")) + chr($22))
                                                Case $04
                                                    msg = scplang_getphrase("events.scp96610")
                                            End Select
                                            msgtimer = 490.0
                                        EndIf
                                    EndIf
                                EndIf
                            Case 3.0,4.0
                                If (3.0 = local0\Field9) Then
                                    animatenpc(local0, 257.0, 332.0, 0.25, $00)
                                    If (331.0 < local0\Field14) Then
                                        local0\Field9 = 0.0
                                    EndIf
                                Else
                                    animatenpc(local0, 332.0, 457.0, 0.25, $00)
                                    If (456.0 < local0\Field14) Then
                                        local0\Field9 = 0.0
                                    EndIf
                                EndIf
                                If ((((((((271.0 < local0\Field14) And (271.0 >= local14)) Or (354.0 < local0\Field14)) Or (314.0 < local0\Field14)) And (314.0 >= local14)) Or (301.0 < local0\Field14)) And (301.0 >= local14)) <> 0) Then
                                    playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\966\Idle" + (Str rand($01, $03))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                EndIf
                                local10 = vectoryaw((entityx(collider, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(collider, $00) - entityz(local0\Field4, $00)))
                                rotateentity(local0\Field4, 0.0, curveangle(local10, entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                            Case 5.0,6.0,8.0
                                If (((580.0 > local0\Field14) And (214.0 < local0\Field14)) <> 0) Then
                                    animatenpc(local0, 556.0, 580.0, 0.25, $00)
                                Else
                                    If (0.0 < local0\Field22) Then
                                        animatenpc(local0, 580.0, 628.0, (local0\Field22 * 25.0), $01)
                                    Else
                                        animatenpc(local0, 2.0, 214.0, 0.25, $01)
                                    EndIf
                                    If ((((8.0 = local0\Field9) And (32.0 > local8)) And (chs\Field2 = $00)) <> 0) Then
                                        If (0.0 >= local0\Field38) Then
                                            local0\Field37 = findpath(local0, entityx(collider, $01), entityy(collider, $01), entityz(collider, $01))
                                            local0\Field38 = 400.0
                                            local0\Field22 = 0.0
                                        EndIf
                                        local0\Field38 = max((local0\Field38 - local17\Field3[$00]), 0.0)
                                        If (entityvisible(local0\Field4, collider) = $00) Then
                                            If (local0\Field37 = $02) Then
                                                local0\Field22 = 0.0
                                                setnpcframe(local0, 2.0)
                                            ElseIf (local0\Field37 = $01) Then
                                                If (local0\Field36[local0\Field39] = Null) Then
                                                    If (local0\Field39 > $13) Then
                                                        local0\Field39 = $00
                                                        local0\Field37 = $00
                                                    Else
                                                        local0\Field39 = (local0\Field39 + $01)
                                                    EndIf
                                                Else
                                                    local0\Field15 = vectoryaw((entityx(local0\Field36[local0\Field39]\Field0, $01) - entityx(local0\Field4, $00)), 0.0, (entityz(local0\Field36[local0\Field39]\Field0, $01) - entityz(local0\Field4, $00)))
                                                    local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                                    local21 = $01
                                                    If (0.8 > local9) Then
                                                        If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                            If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                                If ((((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 <> $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) And (local0\Field36[local0\Field39]\Field1\Field5 = $00)) <> 0) Then
                                                                    local21 = $00
                                                                ElseIf (((local0\Field36[local0\Field39]\Field1\Field5 = $00) And ((local0\Field36[local0\Field39]\Field1\Field3[$00] <> $00) Or (local0\Field36[local0\Field39]\Field1\Field3[$01] <> $00))) <> 0) Then
                                                                    usedoor(local0\Field36[local0\Field39]\Field1, $00, $01)
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                        If (0.3 > local9) Then
                                                            local0\Field39 = (local0\Field39 + $01)
                                                        EndIf
                                                    EndIf
                                                    If (local21 = $00) Then
                                                        local0\Field37 = $00
                                                        local0\Field39 = $00
                                                        local0\Field38 = 400.0
                                                    EndIf
                                                EndIf
                                                local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                            ElseIf (local0\Field37 = $00) Then
                                                local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                                            EndIf
                                        Else
                                            local0\Field15 = vectoryaw((entityx(collider, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(collider, $00) - entityz(local0\Field4, $00)))
                                            local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                            If (1.0 > local8) Then
                                                local0\Field9 = 10.0
                                            EndIf
                                        EndIf
                                    Else
                                        If ((((Float millisecs2()) > local0\Field10) And (16.0 > local8)) <> 0) Then
                                            hideentity(local0\Field4)
                                            entitypick(local0\Field4, 1.5)
                                            If (pickedentity() <> $00) Then
                                                local0\Field15 = (entityyaw(local0\Field4, $00) + rnd(80.0, 110.0))
                                            EndIf
                                            showentity(local0\Field4)
                                            local0\Field10 = (Float (millisecs2() + $3E8))
                                            If (rand($05, $01) = $01) Then
                                                local0\Field9 = 0.0
                                            EndIf
                                        EndIf
                                        local0\Field22 = curvevalue((local0\Field21 * 0.5), local0\Field22, 20.0)
                                    EndIf
                                    If ((((604.0 > local14) And (604.0 <= local0\Field14)) Or ((627.0 > local14) And (627.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($04, $00, rand($00, $03)), camera, local0\Field4, 7.0, rnd(0.5, 0.7))
                                    EndIf
                                    rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                EndIf
                            Case 10.0
                                If (local0\Field26 = $00) Then
                                    playsound2(loadtempsound(scpmodding_processfilepath((("SFX\SCP\966\Echo" + (Str rand($01, $03))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                    local0\Field26 = $01
                                EndIf
                                If (557.0 < local0\Field14) Then
                                    animatenpc(local0, 628.0, 652.0, 0.25, $00)
                                    If (651.0 < local0\Field14) Then
                                        Select rand($03, $01)
                                            Case $01
                                                setnpcframe(local0, 458.0)
                                            Case $02
                                                setnpcframe(local0, 488.0)
                                            Case $03
                                                setnpcframe(local0, 518.0)
                                        End Select
                                    EndIf
                                ElseIf (487.0 >= local0\Field14) Then
                                    animatenpc(local0, 458.0, 487.0, 0.3, $00)
                                    If (486.0 < local0\Field14) Then
                                        local0\Field9 = 8.0
                                    EndIf
                                ElseIf (517.0 >= local0\Field14) Then
                                    animatenpc(local0, 488.0, 517.0, 0.3, $00)
                                    If (516.0 < local0\Field14) Then
                                        local0\Field9 = 8.0
                                    EndIf
                                ElseIf (557.0 >= local0\Field14) Then
                                    animatenpc(local0, 518.0, 557.0, 0.3, $00)
                                    If (556.0 < local0\Field14) Then
                                        local0\Field9 = 8.0
                                    EndIf
                                EndIf
                                If (1.0 > local8) Then
                                    If (((((((470.0 < local0\Field14) And (470.0 >= local14)) Or (500.0 < local0\Field14)) And (500.0 >= local14)) Or (527.0 < local0\Field14)) And (527.0 >= local14)) <> 0) Then
                                        playsound2(loadtempsound(scpmodding_processfilepath((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                        If (i_1033ru\Field0 = $00) Then
                                            injuries = (rnd(0.5, 1.0) + injuries)
                                        Else
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $14))
                                        EndIf
                                    EndIf
                                EndIf
                                local0\Field15 = vectoryaw((entityx(collider, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(collider, $00) - entityz(local0\Field4, $00)))
                                rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                        End Select
                    Else
                        hideentity(local0\Field0)
                        If (rand($258, $01) = $01) Then
                            teleportcloser(local0)
                        EndIf
                    EndIf
                EndIf
            Case $0E
                local68 = local0\Field9
                If (1.0 = local68) Then
                    local0\Field37 = findpath(local0, local0\Field33, (local0\Field34 + 0.1), local0\Field35)
                EndIf
            Case $0F
                local14 = local0\Field14
                If (((0.0 = local0\Field24) And ((hidedistance * 3.0) > entitydistance(local0\Field4, collider))) <> 0) Then
                    If (local0\Field12 = $00) Then
                        If (((0.0 = local0\Field9) Or (2.0 = local0\Field9)) <> 0) Then
                            For local1 = Each npcs
                                If (((local1\Field5 = local0\Field5) And (local1 <> local0)) <> 0) Then
                                    If (((0.0 <> local1\Field9) And (2.0 <> local1\Field9)) <> 0) Then
                                        If (local1\Field12 = $00) Then
                                            local0\Field9 = 1.0
                                            local0\Field10 = 0.0
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                    Select local0\Field9
                        Case 0.0
                            If (local0\Field12 = $00) Then
                                If (0.0 = local0\Field22) Then
                                    If (0.0 = local0\Field25) Then
                                        If ((rnd(1.0, 3.0) * 500.0) > local0\Field10) Then
                                            local0\Field22 = 0.0
                                            local0\Field10 = (local0\Field10 + local17\Field3[$00])
                                        ElseIf (0.0 = local0\Field22) Then
                                            local0\Field22 = (local0\Field22 + 0.0001)
                                        EndIf
                                    ElseIf (1500.0 > local0\Field10) Then
                                        local0\Field22 = 0.0
                                        local0\Field10 = (local0\Field10 + local17\Field3[$00])
                                    Else
                                        If (local0\Field31 <> Null) Then
                                            If (local0\Field31\Field31 <> Null) Then
                                                local0\Field31\Field31 = Null
                                            EndIf
                                            local0\Field31\Field25 = 0.0
                                            local0\Field31\Field15 = (local0\Field31\Field15 + rnd(-45.0, 45.0))
                                            local0\Field31 = Null
                                            local0\Field25 = 0.0
                                            local0\Field15 = (local0\Field15 + rnd(-45.0, 45.0))
                                        EndIf
                                        If (0.0 = local0\Field22) Then
                                            local0\Field22 = (local0\Field22 + 0.0001)
                                        EndIf
                                    EndIf
                                Else
                                    If (local0\Field31 <> Null) Then
                                        local0\Field10 = 0.0
                                    EndIf
                                    If ((rnd(1.0, 3.0) * 10000.0) > local0\Field10) Then
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                        local0\Field10 = (local0\Field10 + local17\Field3[$00])
                                    Else
                                        local0\Field22 = curvevalue(0.0, local0\Field22, 50.0)
                                    EndIf
                                    rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    If (local0\Field31 = Null) Then
                                        If (rand($C8, $01) = $01) Then
                                            local0\Field15 = (local0\Field15 + rnd(-45.0, 45.0))
                                        EndIf
                                        hideentity(local0\Field4)
                                        entitypick(local0\Field4, 1.5)
                                        If (pickedentity() <> $00) Then
                                            local0\Field15 = (entityyaw(local0\Field4, $00) + rnd(80.0, 110.0))
                                        EndIf
                                        showentity(local0\Field4)
                                    Else
                                        local0\Field15 = (deltayaw(local0\Field4, local0\Field31\Field4) + entityyaw(local0\Field4, $00))
                                        If (1.5 > entitydistance(local0\Field4, local0\Field31\Field4)) Then
                                            local0\Field22 = 0.0
                                            local0\Field31\Field22 = 0.0
                                            local0\Field25 = 1.0
                                            local0\Field31\Field25 = 1.0
                                            local21 = rand($00, $02)
                                            If (local21 = $00) Then
                                                setnpcframe(local0, 296.0)
                                            ElseIf (local21 = $01) Then
                                                setnpcframe(local0, 856.0)
                                            Else
                                                setnpcframe(local0, 905.0)
                                            EndIf
                                            local21 = rand($00, $02)
                                            If (local21 = $00) Then
                                                setnpcframe(local0\Field31, 296.0)
                                            ElseIf (local21 = $01) Then
                                                setnpcframe(local0\Field31, 856.0)
                                            Else
                                                setnpcframe(local0\Field31, 905.0)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Else
                                rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                            EndIf
                            If (0.0 = local0\Field22) Then
                                If (((0.0 = local0\Field25) And (local0\Field12 <> $02)) <> 0) Then
                                    animatenpc(local0, 296.0, 320.0, 0.2, $01)
                                ElseIf (((0.0 = local0\Field25) And (local0\Field12 = $02)) <> 0) Then
                                    If (532.5 >= local0\Field14) Then
                                        animatenpc(local0, 509.0, 533.0, 0.2, $00)
                                    ElseIf (((533.5 < local0\Field14) And (600.5 >= local0\Field14)) <> 0) Then
                                        animatenpc(local0, 534.0, 601.0, 0.2, $00)
                                    Else
                                        local21 = rand($00, $01)
                                        If (local21 = $00) Then
                                            setnpcframe(local0, 509.0)
                                        Else
                                            setnpcframe(local0, 534.0)
                                        EndIf
                                    EndIf
                                ElseIf (local0\Field12 = $02) Then
                                    animatenpc(local0, 713.0, 855.0, 0.2, $00)
                                    If (833.5 < local0\Field14) Then
                                        pointentity(local0\Field0, collider, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(local0\Field15, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    EndIf
                                ElseIf (local0\Field12 = $01) Then
                                    animatenpc(local0, 602.0, 712.0, 0.2, $00)
                                    If (711.5 < local0\Field14) Then
                                        local0\Field25 = 0.0
                                    EndIf
                                ElseIf (319.5 >= local0\Field14) Then
                                    animatenpc(local0, 296.0, 320.0, 0.2, $00)
                                ElseIf (((320.5 < local0\Field14) And (903.5 > local0\Field14)) <> 0) Then
                                    animatenpc(local0, 856.0, 904.0, 0.2, $00)
                                ElseIf (((904.5 < local0\Field14) And (952.5 > local0\Field14)) <> 0) Then
                                    animatenpc(local0, 905.0, 953.0, 0.2, $00)
                                Else
                                    local21 = rand($00, $02)
                                    If (local21 = $00) Then
                                        setnpcframe(local0, 296.0)
                                    ElseIf (local21 = $01) Then
                                        setnpcframe(local0, 856.0)
                                    Else
                                        setnpcframe(local0, 905.0)
                                    EndIf
                                EndIf
                            Else
                                If ((local0\Field6 Mod $02) = $00) Then
                                    animatenpc(local0, 1.0, 62.0, (local0\Field22 * 28.0), $01)
                                Else
                                    animatenpc(local0, 100.0, 167.0, (local0\Field22 * 28.0), $01)
                                EndIf
                                If (local0\Field12 = $00) Then
                                    If (local0\Field31 = Null) Then
                                        If (rand($01, $4B0) = $01) Then
                                            For local1 = Each npcs
                                                If (local1 <> local0) Then
                                                    If (local1\Field5 = local0\Field5) Then
                                                        If (local1\Field31 = Null) Then
                                                            If (local1\Field12 = $00) Then
                                                                If (20.0 > entitydistance(local0\Field4, local1\Field4)) Then
                                                                    local0\Field31 = local1
                                                                    local1\Field31 = local0
                                                                    local0\Field31\Field22 = (local0\Field31\Field22 + 0.0001)
                                                                    Exit
                                                                EndIf
                                                            EndIf
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If (((local0\Field31 = Null) And (local0\Field12 = $00)) <> 0) Then
                                If (rand($1388, $01) = $01) Then
                                    local0\Field9 = 2.0
                                    local0\Field10 = 0.0
                                    If (channelplaying(local0\Field17) = $00) Then
                                        local8 = entitydistance(local0\Field4, collider)
                                        If (20.0 > local8) Then
                                            If (local0\Field16 <> $00) Then
                                                freesound_strict(local0\Field16)
                                                local0\Field16 = $00
                                            EndIf
                                            local0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\SCP\1499\Idle" + (Str rand($01, $04))) + ".ogg")))
                                            local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 20.0, 1.0)
                                        EndIf
                                    EndIf
                                EndIf
                                If ((((local0\Field6 Mod $02) = $00) And (local70 = $00)) <> 0) Then
                                    local8 = entitydistance(local0\Field4, collider)
                                    If (10.0 > local8) Then
                                        If (entityvisible(local0\Field4, collider) <> 0) Then
                                            local0\Field9 = 2.0
                                            If (5.0 > local8) Then
                                                If (local0\Field16 <> $00) Then
                                                    freesound_strict(local0\Field16)
                                                    local0\Field16 = $00
                                                EndIf
                                                local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1499\Triggered.ogg"))
                                                local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 20.0, 1.0)
                                                local0\Field10 = 1.0
                                                For local1 = Each npcs
                                                    If (((local1\Field5 = local0\Field5) And (local1 <> local0)) <> 0) Then
                                                        If (local1\Field12 = $00) Then
                                                            local1\Field9 = 1.0
                                                            local1\Field10 = 0.0
                                                        EndIf
                                                    EndIf
                                                Next
                                            Else
                                                local0\Field10 = 0.0
                                            EndIf
                                            local0\Field14 = 203.0
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (local0\Field12 = $01) Then
                                local8 = entitydistance(local0\Field4, collider)
                                If (local70 = $00) Then
                                    If (4.0 > local8) Then
                                        If (entityvisible(local0\Field4, collider) <> 0) Then
                                            If (local0\Field16 <> $00) Then
                                                freesound_strict(local0\Field16)
                                                local0\Field16 = $00
                                            EndIf
                                            local0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1499\Triggered.ogg"))
                                            local0\Field17 = playsound2(local0\Field16, camera, local0\Field4, 20.0, 1.0)
                                            local0\Field9 = 1.0
                                            local0\Field14 = 203.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Case 1.0
                            If (local70 <> 0) Then
                                local0\Field9 = 0.0
                            EndIf
                            If (((playerroom\Field7\Field10 = "dimension1499") And (local0\Field12 = $00)) <> 0) Then
                                shouldplay = $13
                            EndIf
                            pointentity(local0\Field0, collider, 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                            local8 = entitydistance(local0\Field4, collider)
                            If (0.0 = local0\Field10) Then
                                If (local0\Field12 = $01) Then
                                    local0\Field22 = curvevalue((local0\Field21 * 2.0), local0\Field22, 10.0)
                                    If (local0\Field31 <> Null) Then
                                        local0\Field31\Field9 = 1.0
                                    EndIf
                                Else
                                    local0\Field22 = curvevalue((local0\Field21 * 1.75), local0\Field22, 10.0)
                                EndIf
                                If ((local0\Field6 Mod $02) = $00) Then
                                    animatenpc(local0, 1.0, 62.0, (local0\Field22 * 28.0), $01)
                                Else
                                    animatenpc(local0, 100.0, 167.0, (local0\Field22 * 28.0), $01)
                                EndIf
                            EndIf
                            If (0.75 > local8) Then
                                If (((((((local0\Field6 Mod $02) = $00) Or (1.0 = local0\Field11)) Or (local0\Field12 = $01)) Or (local0\Field12 = $03)) Or (local0\Field12 = $04)) <> 0) Then
                                    local0\Field10 = (Float rand($01, $02))
                                    local0\Field9 = 3.0
                                    If (1.0 = local0\Field10) Then
                                        setnpcframe(local0, 63.0)
                                    Else
                                        setnpcframe(local0, 168.0)
                                    EndIf
                                Else
                                    local0\Field9 = 4.0
                                EndIf
                            EndIf
                        Case 2.0
                            local0\Field22 = 0.0
                            animatenpc(local0, 203.0, 295.0, 0.1, $00)
                            If (294.0 < local0\Field14) Then
                                local0\Field9 = local0\Field10
                            EndIf
                        Case 3.0
                            local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                            local8 = entitydistance(local0\Field4, collider)
                            If (1.0 = local0\Field10) Then
                                animatenpc(local0, 63.0, 100.0, 0.6, $00)
                                If (((89.0 > local14) And (89.0 <= local0\Field14)) <> 0) Then
                                    If (((0.85 < local8) Or (60.0 < (Abs deltayaw(local0\Field4, collider)))) = 0) Then
                                        If (i_1033ru\Field0 = $00) Then
                                            injuries = (rnd(0.75, 1.5) + injuries)
                                        Else
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $14))
                                        EndIf
                                        playsound2(loadtempsound(scpmodding_processfilepath((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                        If (10.0 < injuries) Then
                                            kill($01, $00)
                                            If (playerroom\Field7\Field10 = "dimension1499") Then
                                                deathmsg = scplang_getphrase("events.scp14991")
                                            Else
                                                deathmsg = scplang_getphrase("events.scp14992")
                                            EndIf
                                        EndIf
                                    EndIf
                                ElseIf (99.0 <= local0\Field14) Then
                                    local0\Field10 = 0.0
                                    local0\Field9 = 1.0
                                EndIf
                            Else
                                animatenpc(local0, 168.0, 202.0, 0.6, $00)
                                If (((189.0 > local14) And (189.0 <= local0\Field14)) <> 0) Then
                                    If (((0.85 < local8) Or (60.0 < (Abs deltayaw(local0\Field4, collider)))) = 0) Then
                                        If (i_1033ru\Field0 = $00) Then
                                            injuries = (rnd(0.75, 1.5) + injuries)
                                        Else
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $14))
                                        EndIf
                                        playsound2(loadtempsound(scpmodding_processfilepath((("SFX\General\Slash" + (Str rand($01, $02))) + ".ogg"))), camera, local0\Field4, 10.0, 1.0)
                                        If (10.0 < injuries) Then
                                            kill($01, $00)
                                            If (playerroom\Field7\Field10 = "dimension1499") Then
                                                deathmsg = scplang_getphrase("events.scp14991")
                                            Else
                                                deathmsg = scplang_getphrase("events.scp14992")
                                            EndIf
                                        EndIf
                                    EndIf
                                ElseIf (201.0 <= local0\Field14) Then
                                    local0\Field10 = 0.0
                                    local0\Field9 = 1.0
                                EndIf
                            EndIf
                        Case 4.0
                            local8 = entitydistance(local0\Field4, collider)
                            local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                            animatenpc(local0, 296.0, 320.0, 0.2, $01)
                            pointentity(local0\Field0, collider, 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                            If (0.85 < local8) Then
                                local0\Field9 = 1.0
                            EndIf
                    End Select
                    If (((local0\Field17 <> $00) And channelplaying(local0\Field17)) <> 0) Then
                        updatesoundorigin(local0\Field17, camera, local0\Field4, 20.0, 1.0)
                    EndIf
                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                    rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                    showentity(local0\Field0)
                Else
                    hideentity(local0\Field0)
                EndIf
            Case $01
                If (local0\Field48 = $00) Then
                    If (0.0 = local0\Field9) Then
                        entitytype(local0\Field4, $06, $00)
                    Else
                        entitytype(local0\Field4, $02, $00)
                    EndIf
                    local14 = local0\Field14
                    local0\Field49 = 1.0
                    Select local0\Field9
                        Case 0.0
                            setnpcframe(local0, 11.0)
                        Case 1.0
                            animatenpc(local0, 11.0, 32.0, 0.1, $00)
                            If (29.0 <= local0\Field14) Then
                                local0\Field9 = 2.0
                            EndIf
                        Case 2.0
                            local15 = menpcseesplayer(local0, $00)
                            If (((local15 = $01) Or (0.0 < local0\Field10)) <> 0) Then
                                If (local15 = $01) Then
                                    local0\Field10 = 140.0
                                Else
                                    local0\Field10 = max((local0\Field10 - local17\Field3[$00]), 0.0)
                                EndIf
                                pointentity(local0\Field0, collider, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                animatenpc(local0, 64.0, 93.0, (local0\Field22 * 30.0), $01)
                                local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                If (1.0 > entitydistance(local0\Field4, collider)) Then
                                    If (60.0 >= (Abs deltayaw(local0\Field4, collider))) Then
                                        local0\Field9 = 3.0
                                    EndIf
                                EndIf
                                local0\Field38 = 0.0
                                local0\Field37 = $00
                                local0\Field39 = $00
                                local0\Field11 = 0.0
                            Else
                                If (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                        animatenpc(local0, 64.0, 93.0, (local0\Field22 * 30.0), $01)
                                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                        If (0.6 > local9) Then
                                            local21 = $01
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                    If (((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 > $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) <> 0) Then
                                                        local21 = $00
                                                    ElseIf (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                        usedoor(local0\Field36[local0\Field39]\Field1, $00, $01)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (((0.2 > local9) And local21) <> 0) Then
                                                local0\Field39 = (local0\Field39 + $01)
                                            ElseIf (((0.5 > local9) And (local21 = $00)) <> 0) Then
                                                local0\Field37 = $00
                                                local0\Field38 = 0.0
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    animatenpc(local0, 323.0, 344.0, 0.2, $01)
                                    local0\Field22 = 0.0
                                    If (350.0 > local0\Field38) Then
                                        local0\Field38 = ((rnd(1.0, (Float ((selecteddifficulty\Field3 Shl $01) + $02))) * local17\Field3[$00]) + local0\Field38)
                                    Else
                                        local0\Field37 = findpath(local0, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                                        local0\Field38 = 0.0
                                    EndIf
                                EndIf
                                If (hidedistance < entitydistance(local0\Field4, collider)) Then
                                    If ((Float (((selecteddifficulty\Field3 * $0A) + $0F) * $46)) > local0\Field11) Then
                                        local0\Field11 = (local0\Field11 + local17\Field3[$00])
                                    Else
                                        local0\Field11 = 25200.0
                                        local0\Field9 = 4.0
                                    EndIf
                                EndIf
                            EndIf
                            If (0.005 < local0\Field22) Then
                                If ((((80.0 > local14) And (80.0 <= local0\Field14)) Or ((92.0 < local14) And (65.0 > local0\Field14))) <> 0) Then
                                    playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                                EndIf
                            EndIf
                            local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 10.0, 1.0)
                        Case 3.0
                            animatenpc(local0, 126.0, 165.0, 0.4, $00)
                            If (((146.0 <= local0\Field14) And (146.0 > local14)) <> 0) Then
                                If (1.1 > entitydistance(local0\Field4, collider)) Then
                                    If (60.0 >= (Abs deltayaw(local0\Field4, collider))) Then
                                        playsound_strict(damagesfx(rand($05, $08)))
                                        If (wearinghazmat = $00) Then
                                            i_008\Field0 = (i_008\Field0 + (Float ((selecteddifficulty\Field3 Shl $00) + $01)))
                                        EndIf
                                        If (i_1033ru\Field0 = $00) Then
                                            injuries = (rnd(0.4, 1.0) + injuries)
                                        Else
                                            damage1033ru($14)
                                            local0\Field61 = (local0\Field61 - $18)
                                            If (local0\Field61 <= $00) Then
                                                local0\Field48 = $01
                                            EndIf
                                        EndIf
                                        deathmsg = scplang_getphrase("events.scp0081")
                                    EndIf
                                EndIf
                            ElseIf (164.0 <= local0\Field14) Then
                                If (1.1 > entitydistance(local0\Field4, collider)) Then
                                    If (60.0 >= (Abs deltayaw(local0\Field4, collider))) Then
                                        setnpcframe(local0, 126.0)
                                    Else
                                        local0\Field9 = 2.0
                                    EndIf
                                Else
                                    local0\Field9 = 2.0
                                EndIf
                            EndIf
                        Case 4.0
                            hideentity(local0\Field0)
                            hideentity(local0\Field4)
                            local0\Field7 = 0.0
                            positionentity(local0\Field4, 0.0, 500.0, 0.0, $00)
                            resetentity(local0\Field4)
                            If (0.0 < local0\Field24) Then
                                local0\Field24 = max((local0\Field24 - ((Float ((selecteddifficulty\Field3 Shl $00) + $01)) * local17\Field3[$00])), 0.0)
                            ElseIf (playerinreachableroom($00) <> 0) Then
                                If (rand(($32 - (selecteddifficulty\Field3 * $14)), $01) = $01) Then
                                    showentity(local0\Field4)
                                    showentity(local0\Field0)
                                    For local25 = Each waypoints
                                        If ((((local25\Field1 = Null) And (hidedistance > local25\Field2\Field8)) And (rand($03, $01) = $01)) <> 0) Then
                                            If (entitydistance(collider, local0\Field4) > entitydistance(local25\Field2\Field2, local0\Field4)) Then
                                                local11 = (Abs (entityx(local0\Field4, $00) - entityx(local25\Field0, $01)))
                                                If (((12.0 > local11) And (4.0 < local11)) <> 0) Then
                                                    local13 = (Abs (entityz(local0\Field4, $00) - entityz(local25\Field0, $01)))
                                                    If (((12.0 > local13) And (4.0 < local13)) <> 0) Then
                                                        If (4.0 < local25\Field2\Field8) Then
                                                            positionentity(local0\Field4, entityx(local25\Field0, $01), (entityy(local25\Field0, $01) + 0.25), entityz(local25\Field0, $01), $00)
                                                            resetentity(local0\Field4)
                                                            local0\Field37 = $00
                                                            local0\Field38 = 0.0
                                                            local0\Field39 = $00
                                                            Exit
                                                        EndIf
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                    local0\Field9 = 2.0
                                    local0\Field11 = 0.0
                                EndIf
                            EndIf
                    End Select
                Else
                    If (local0\Field17 <> $00) Then
                        stopchannel(local0\Field17)
                        local0\Field17 = $00
                        freesound_strict(local0\Field16)
                        local0\Field16 = $00
                    EndIf
                    animatenpc(local0, 344.0, 363.0, 0.5, $00)
                EndIf
                rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
            Case $16
                If (4.0 > (Abs (entityy(collider, $00) - entityy(local0\Field4, $00)))) Then
                    local14 = local0\Field14
                    If (local0\Field48 = $00) Then
                        Select local0\Field9
                            Case 0.0
                                animatenpc(local0, 719.0, 777.0, 0.2, $00)
                                If (777.0 = local0\Field14) Then
                                    If (rand($2BC, $01) = $01) Then
                                        If (5.0 > entitydistance(collider, local0\Field4)) Then
                                            local0\Field14 = 719.0
                                        EndIf
                                    EndIf
                                EndIf
                            Case 1.0
                                If (682.0 <= local0\Field14) Then
                                    animatenpc(local0, 926.0, 935.0, 0.3, $00)
                                    If (935.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                Else
                                    animatenpc(local0, 155.0, 682.0, 1.1, $00)
                                EndIf
                            Case 2.0
                                If (0.0 > local0\Field11) Then
                                    If (5.0 > entitydistance(collider, local0\Field4)) Then
                                        If (entityvisible(collider, local0\Field4) <> 0) Then
                                            local0\Field10 = 350.0
                                        EndIf
                                    EndIf
                                    local0\Field11 = 210.0
                                Else
                                    local0\Field11 = (local0\Field11 - local17\Field3[$00])
                                EndIf
                                local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 6.0, 0.6)
                                If (((0.0 < local0\Field10) And (chs\Field2 = $00)) <> 0) Then
                                    local0\Field37 = $00
                                    local8 = entitydistance(collider, local0\Field4)
                                    pointentity(local0\Field0, collider, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                                    If (0.7 > local8) Then
                                        local0\Field9 = 3.0
                                        If (rand($02, $01) = $01) Then
                                            local0\Field14 = 2.0
                                        Else
                                            local0\Field14 = 66.0
                                        EndIf
                                    Else
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        animatenpc(local0, 936.0, 1017.0, (local0\Field22 * 60.0), $01)
                                    EndIf
                                    local0\Field10 = (local0\Field10 - local17\Field3[$00])
                                ElseIf (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        animatenpc(local0, 936.0, 1017.0, (local0\Field22 * 60.0), $01)
                                        animatenpc(local0, 936.0, 1017.0, (local0\Field22 * 60.0), $01)
                                        local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                        If (0.6 > local9) Then
                                            local21 = $01
                                            If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                    If (((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 > $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) <> 0) Then
                                                        local21 = $00
                                                    ElseIf (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                        usedoor(local0\Field36[local0\Field39]\Field1, $00, $01)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            If (((0.2 > local9) And local21) <> 0) Then
                                                local0\Field39 = (local0\Field39 + $01)
                                            ElseIf (((0.5 > local9) And (local21 = $00)) <> 0) Then
                                                local0\Field37 = $00
                                                local0\Field38 = 0.0
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field22 = 0.0
                                    animatenpc(local0, 778.0, 926.0, 0.1, $01)
                                    local0\Field38 = (local0\Field38 - local17\Field3[$00])
                                    If (350.0 > local0\Field38) Then
                                        local0\Field38 = ((rnd(1.0, (Float ((selecteddifficulty\Field3 Shl $01) + $02))) * local17\Field3[$00]) + local0\Field38)
                                    Else
                                        local0\Field37 = findpath(local0, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                                        local0\Field38 = 0.0
                                    EndIf
                                EndIf
                                If (hidedistance < entitydistance(local0\Field4, collider)) Then
                                    If ((Float (((selecteddifficulty\Field3 * $0A) + $0F) * $46)) > local0\Field11) Then
                                        local0\Field11 = (local0\Field11 + local17\Field3[$00])
                                    Else
                                        local0\Field11 = 210.0
                                        local0\Field9 = 4.0
                                    EndIf
                                EndIf
                                If (0.005 < local0\Field22) Then
                                    If ((((977.0 > local14) And (977.0 <= local0\Field14)) Or ((1010.0 < local14) And (940.0 > local0\Field14))) <> 0) Then
                                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                                    EndIf
                                EndIf
                            Case 3.0
                                If (chs\Field2 <> 0) Then
                                    local0\Field9 = 2.0
                                EndIf
                                If (66.0 > local0\Field14) Then
                                    animatenpc(local0, 2.0, 65.0, 0.7, $00)
                                    If (((23.0 > local14) And (23.0 <= local0\Field14)) <> 0) Then
                                        If (1.1 > entitydistance(local0\Field4, collider)) Then
                                            If (60.0 >= (Abs deltayaw(local0\Field4, collider))) Then
                                                playsound_strict(damagesfx(rand($05, $08)))
                                                If (i_1033ru\Field0 = $00) Then
                                                    injuries = (rnd(0.4, 1.0) + injuries)
                                                Else
                                                    damage1033ru($14)
                                                    local0\Field61 = (local0\Field61 - $18)
                                                    If (local0\Field61 <= $00) Then
                                                        local0\Field48 = $01
                                                    EndIf
                                                EndIf
                                                If (3.0 < injuries) Then
                                                    deathmsg = scplang_getphrase("events.scp0082")
                                                    kill($01, $00)
                                                EndIf
                                            EndIf
                                        EndIf
                                    ElseIf (65.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                Else
                                    animatenpc(local0, 66.0, 132.0, 0.7, $00)
                                    If (((90.0 > local14) And (90.0 <= local0\Field14)) <> 0) Then
                                        If (1.1 > entitydistance(local0\Field4, collider)) Then
                                            If (60.0 >= (Abs deltayaw(local0\Field4, collider))) Then
                                                playsound_strict(damagesfx(rand($05, $08)))
                                                If (i_1033ru\Field0 = $00) Then
                                                    injuries = (rnd(0.4, 1.0) + injuries)
                                                Else
                                                    damage1033ru($14)
                                                    local0\Field61 = (local0\Field61 - $18)
                                                    If (local0\Field61 <= $00) Then
                                                        local0\Field48 = $01
                                                    EndIf
                                                EndIf
                                                If (3.0 < injuries) Then
                                                    deathmsg = scplang_getphrase("events.scp0082")
                                                    kill($01, $00)
                                                EndIf
                                            EndIf
                                        EndIf
                                    ElseIf (132.0 = local0\Field14) Then
                                        local0\Field9 = 2.0
                                    EndIf
                                EndIf
                        End Select
                    Else
                        If (local0\Field17 <> $00) Then
                            stopchannel(local0\Field17)
                            local0\Field17 = $00
                            freesound_strict(local0\Field16)
                            local0\Field16 = $00
                        EndIf
                        animatenpc(local0, 1035.0, 1072.0, 0.3, $00)
                    EndIf
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                    rotateentity(local0\Field0, -90.0, entityyaw(local0\Field4, $00), 0.0, $00)
                EndIf
            Case $1A
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.32), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                local26 = createpivot($00)
                positionentity(local26, entityx(collider, $01), entityy(collider, $01), entityz(collider, $01), $00)
                rotateentity(local26, 0.0, entityyaw(collider, $01), 0.0, $00)
                turnentity(local26, 0.0, 180.0, 0.0, $00)
                entitypick(local26, 1.0)
                freeentity(local26)
                local8 = entitydistance(local0\Field4, collider)
                If (0.0 = local0\Field24) Then
                    If (15.0 > local8) Then
                        If (10.0 > local8) Then
                            If (entityvisible(local0\Field4, collider) <> 0) Then
                                shouldplay = $1B
                                heartbeatrate = max(heartbeatrate, 140.0)
                                heartbeatvolume = 1.0
                                local0\Field33 = entityx(collider, $01)
                                local0\Field34 = entityy(collider, $01)
                                local0\Field35 = entityz(collider, $01)
                            EndIf
                        EndIf
                        local0\Field28 = entityx(local0\Field4, $00)
                        local0\Field30 = entityz(local0\Field4, $00)
                    EndIf
                    If (pickedentity() = $00) Then
                        If ((((-16.0 > blinktimer) Or (isnvgblinking = $01)) And entityvisible(local0\Field0, camera)) <> 0) Then
                            rotateentity(local0\Field4, 0.0, (entityyaw(collider, $00) - 180.0), 0.0, $00)
                            positionentity(local0\Field4, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                            moveentity(local0\Field4, 0.0, 0.0, 1.5)
                            resetentity(local0\Field4)
                            moveentity(local0\Field4, 0.0, 0.5, 0.0)
                            Select rand($05, $01)
                                Case $01
                                    setnpcframe(local0, 1.0)
                                Case $02
                                    setnpcframe(local0, 5.0)
                                Case $03
                                    setnpcframe(local0, 7.0)
                                Case $04
                                    setnpcframe(local0, 9.0)
                                Case $05
                                    setnpcframe(local0, 11.0)
                            End Select
                        ElseIf (((entityinview(local0\Field0, camera) = $00) And entityvisible(local0\Field0, camera)) <> 0) Then
                            pointentity(local0\Field4, collider, 0.0)
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field21 * local17\Field3[$00]))
                            Select rand($05, $01)
                                Case $01
                                    setnpcframe(local0, 1.0)
                                Case $02
                                    setnpcframe(local0, 5.0)
                                Case $03
                                    setnpcframe(local0, 7.0)
                                Case $04
                                    setnpcframe(local0, 9.0)
                                Case $05
                                    setnpcframe(local0, 11.0)
                            End Select
                        ElseIf ((((entityvisible(local0\Field0, camera) = $00) And entityinview(local0\Field0, camera)) And (8.0 < local8)) <> 0) Then
                            positionentity(local0\Field4, entityx(collider, $00), (entityy(collider, $00) + 0.25), entityz(collider, $00), $00)
                            resetentity(local0\Field4)
                            rotateentity(local0\Field4, 0.0, (entityyaw(collider, $00) - 180.0), 0.0, $00)
                            positionentity(local0\Field4, entityx(collider, $00), (entityy(collider, $00) + 0.25), entityz(collider, $00), $00)
                            moveentity(local0\Field4, 0.0, 0.0, 1.5)
                        ElseIf ((((entityvisible(local0\Field0, camera) = $00) And (entityinview(local0\Field0, camera) = $00)) And (8.0 < local8)) <> 0) Then
                            positionentity(local0\Field4, entityx(collider, $00), (entityy(collider, $00) + 0.25), entityz(collider, $00), $00)
                            resetentity(local0\Field4)
                            rotateentity(local0\Field4, 0.0, (entityyaw(collider, $00) - 180.0), 0.0, $00)
                            positionentity(local0\Field4, entityx(collider, $00), (entityy(collider, $00) + 0.25), entityz(collider, $00), $00)
                            moveentity(local0\Field4, 0.0, 0.0, 0.8)
                        EndIf
                    EndIf
                    For local30 = Each events
                        If (((((((playerroom\Field7\Field10 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00))) Or (playerroom\Field7\Field10 = "gatea")) Or (playerroom\Field7\Field10 = "pocketdimension")) Or (playerroom\Field7\Field10 = "dimension1499")) Or ((playerroom\Field7\Field10 = "room860") And (1.0 = local30\Field2))) <> 0) Then
                            hideentity(local0\Field0)
                            hideentity(local0\Field4)
                            local0\Field24 = 1.0
                        EndIf
                    Next
                EndIf
            Case $19
                If (playerroom\Field7\Field10 <> "room457") Then
                    local0\Field9 = 3.0
                EndIf
                local14 = local0\Field14
                If (3.0 > local0\Field9) Then
                    If (contained457 = $00) Then
                        Select local0\Field9
                            Case 0.0
                                If (local0\Field37 = $01) Then
                                    If (local0\Field36[local0\Field39] = Null) Then
                                        If (local0\Field39 > $13) Then
                                            local0\Field39 = $00
                                            local0\Field37 = $00
                                        Else
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    Else
                                        pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                        animatenpc(local0, 284.0, 333.0, (local0\Field22 * 43.0), $01)
                                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        If (0.3 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                            local0\Field39 = (local0\Field39 + $01)
                                        EndIf
                                    EndIf
                                    If (6.0 > entitydistance(local0\Field4, collider)) Then
                                        If (entityvisible(local0\Field4, collider) <> 0) Then
                                            local0\Field9 = 0.0
                                        EndIf
                                    EndIf
                                ElseIf (493.0 > local0\Field14) Then
                                    local0\Field22 = 0.0
                                    animatenpc(local0, 334.0, 494.0, 0.4, $01)
                                Else
                                    local0\Field37 = findpath(local0, entityx(local0\Field76, $01), entityy(local0\Field76, $01), entityz(local0\Field76, $01))
                                EndIf
                                If (((4.0 > entitydistance(local0\Field4, collider)) And (chs\Field2 = $00)) <> 0) Then
                                    If (entityvisible(local0\Field4, collider) <> 0) Then
                                        local0\Field26 = $1F4
                                        local0\Field9 = 1.0
                                        local0\Field37 = $00
                                        local0\Field11 = 0.0
                                    EndIf
                                EndIf
                            Case 1.0
                                If (local0\Field26 > $00) Then
                                    If (0.0 = local0\Field11) Then
                                        local0\Field17 = playsound_strict(local0\Field16)
                                        local0\Field11 = 1.0
                                    EndIf
                                    local0\Field22 = local0\Field21
                                    moveentity(local0\Field4, 0.0, 0.0, ((local0\Field22 * 2.0) * local17\Field3[$00]))
                                    animatenpc(local0, 284.0, 333.0, (local0\Field22 * 60.0), $01)
                                    local10 = vectoryaw((entityx(collider, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(collider, $00) - entityz(local0\Field4, $00)))
                                    rotateentity(local0\Field4, 0.0, curveangle(local10, entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                                    If (6.0 > entitydistance(local0\Field4, collider)) Then
                                        If (entityvisible(local0\Field4, collider) <> 0) Then
                                            local0\Field26 = $1F4
                                            If (0.6 > entitydistance(local0\Field4, collider)) Then
                                                If (0.5 < entitydistance(local0\Field4, collider)) Then
                                                    local0\Field22 = curvevalue((local0\Field21 * 2.5), local0\Field22, 10.0)
                                                Else
                                                    local0\Field22 = 0.0
                                                EndIf
                                                animatenpc(local0, 105.0, 110.0, 0.15, $00)
                                                If (((0.0 <= killtimer) And (chs\Field0 = $00)) <> 0) Then
                                                    pointentity(local0\Field0, collider, 0.0)
                                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                                    If (((110.0 = ceil(local0\Field14)) And (chs\Field0 = $00)) <> 0) Then
                                                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\294\Burn.ogg")))
                                                        kill($00, $01)
                                                        deathmsg = scplang_getphrase("events.scp457")
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    local0\Field9 = 0.0
                                    local0\Field37 = $00
                                EndIf
                        End Select
                    Else
                        animatenpc(local0, 334.0, 494.0, 0.4, $01)
                    EndIf
                    If ((chs\Field2 And (1.0 = local0\Field9)) <> 0) Then
                        local0\Field9 = 0.0
                    EndIf
                    local45 = createparticle(entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00, rnd(0.2, 0.3), -0.2, $3C)
                    positionentity(local45\Field1, (entityx(local0\Field4, $01) + rnd(-0.5, 0.5)), entityy(local0\Field4, $01), (entityz(local0\Field4, $01) + rnd(-0.5, 0.5)), $00)
                    local45\Field15 = 0.0098
                    local45\Field14 = rnd((1.0 / -400.0), -0.003)
                    local45\Field8 = 0.004
                    rotateentity(local45\Field1, 90.0, 0.0, 0.0, $00)
                    entitytexture(local45\Field0, at\Field2[$09], $00, $00)
                    local45 = createparticle(entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00, rnd(0.2, 0.3), -0.2, $41)
                    positionentity(local45\Field1, (entityx(local0\Field4, $01) + rnd(-0.5, 0.5)), entityy(local0\Field4, $01), (entityz(local0\Field4, $01) + rnd(-0.5, 0.5)), $00)
                    local45\Field15 = 0.00059
                    local45\Field14 = rnd((1.0 / -400.0), -0.003)
                    local45\Field8 = 0.0007
                    rotateentity(local45\Field1, 90.0, 0.0, 0.0, $00)
                    local0\Field26 = (Int max(0.0, ((Float local0\Field26) - local17\Field3[$00])))
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                    rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                    local0\Field17 = loopsound2(firesfx, local0\Field17, camera, local0\Field4, 10.0, 0.9)
                    If (((286.0 >= local14) And (286.0 < local0\Field14)) <> 0) Then
                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                    ElseIf (((311.0 >= local14) And (311.0 < local0\Field14)) <> 0) Then
                        playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0))
                    EndIf
                EndIf
            Case $17
                If (4.0 > (Abs (entityy(collider, $00) - entityy(local0\Field4, $00)))) Then
                    local14 = local0\Field14
                    If (local0\Field48 = $00) Then
                        Select local0\Field9
                            Case 0.0
                            Case 1.0
                                animatenpc(local0, 3.0, 30.0, 0.1, $00)
                                If (30.0 = local0\Field14) Then
                                    local0\Field9 = 2.0
                                EndIf
                            Case 2.0
                                If (0.0 > local0\Field11) Then
                                    If (5.0 > entitydistance(collider, local0\Field4)) Then
                                        If (entityvisible(collider, local0\Field4) <> 0) Then
                                            local0\Field10 = 350.0
                                        EndIf
                                    EndIf
                                    local0\Field11 = 210.0
                                Else
                                    local0\Field11 = (local0\Field11 - local17\Field3[$00])
                                EndIf
                                If (((0.0 < local0\Field10) And (chs\Field2 = $00)) <> 0) Then
                                    local8 = entitydistance(collider, local0\Field4)
                                    pointentity(local0\Field0, collider, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                                    If (0.7 > local8) Then
                                        local0\Field9 = 3.0
                                        local0\Field14 = 127.0
                                    Else
                                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                        If (3.0 > local8) Then
                                            animatenpc(local0, min(animtime(local0\Field0), 95.0), 124.0, (local0\Field22 * 30.0), $01)
                                        Else
                                            animatenpc(local0, 64.0, 93.0, (local0\Field22 * 30.0), $01)
                                        EndIf
                                    EndIf
                                    local0\Field10 = (local0\Field10 - local17\Field3[$00])
                                Else
                                    local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, local0\Field4, 6.0, 0.6)
                                    If (local0\Field37 = $01) Then
                                        If (local0\Field36[local0\Field39] = Null) Then
                                            If (local0\Field39 > $13) Then
                                                local0\Field39 = $00
                                                local0\Field37 = $00
                                            Else
                                                local0\Field39 = (local0\Field39 + $01)
                                            EndIf
                                        Else
                                            pointentity(local0\Field0, local0\Field36[local0\Field39]\Field0, 0.0)
                                            rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 30.0), 0.0, $00)
                                            local0\Field22 = curvevalue(local0\Field21, local0\Field22, 20.0)
                                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                                            animatenpc(local0, 64.0, 93.0, (local0\Field22 * 30.0), $01)
                                            local9 = entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)
                                            If (0.6 > local9) Then
                                                local21 = $01
                                                If (local0\Field36[local0\Field39]\Field1 <> Null) Then
                                                    If (local0\Field36[local0\Field39]\Field1\Field23 = $00) Then
                                                        If (((local0\Field36[local0\Field39]\Field1\Field4 Or (local0\Field36[local0\Field39]\Field1\Field12 > $00)) Or (local0\Field36[local0\Field39]\Field1\Field17 <> "")) <> 0) Then
                                                            local21 = $00
                                                        ElseIf (local0\Field36[local0\Field39]\Field1\Field5 = $00) Then
                                                            usedoor(local0\Field36[local0\Field39]\Field1, $00, $01)
                                                        EndIf
                                                    EndIf
                                                EndIf
                                                If (((0.2 > local9) And local21) <> 0) Then
                                                    local0\Field39 = (local0\Field39 + $01)
                                                ElseIf (((0.5 > local9) And (local21 = $00)) <> 0) Then
                                                    local0\Field37 = $00
                                                    local0\Field38 = 0.0
                                                EndIf
                                            EndIf
                                        EndIf
                                    Else
                                        local0\Field22 = 0.0
                                        animatenpc(local0, 590.0, 599.0, 0.1, $01)
                                        local0\Field38 = (local0\Field38 - local17\Field3[$00])
                                        If (350.0 > local0\Field38) Then
                                            local0\Field38 = ((rnd(1.0, (Float ((selecteddifficulty\Field3 Shl $01) + $02))) * local17\Field3[$00]) + local0\Field38)
                                        Else
                                            local0\Field37 = findpath(local0, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                                            local0\Field38 = 0.0
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.0 < local0\Field22) Then
                                    If ((((65.0 > local14) And (65.0 <= local0\Field14)) Or ((80.0 > local14) And (80.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                                    ElseIf ((((93.0 > local14) And (93.0 <= local0\Field14)) Or ((109.0 > local14) And (109.0 <= local0\Field14))) <> 0) Then
                                        playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                                    ElseIf (((123.0 > local14) And (123.0 <= local0\Field14)) <> 0) Then
                                        playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                                    EndIf
                                EndIf
                            Case 3.0
                                If (chs\Field2 <> 0) Then
                                    local0\Field9 = 2.0
                                EndIf
                                animatenpc(local0, 127.0, 165.0, 0.7, $00)
                                If (((146.0 > local14) And (146.0 <= local0\Field14)) <> 0) Then
                                    If (1.1 > entitydistance(local0\Field4, collider)) Then
                                        If (60.0 >= (Abs deltayaw(local0\Field4, collider))) Then
                                            playsound_strict(damagesfx(rand($02, $03)))
                                            If (i_1033ru\Field0 = $00) Then
                                                injuries = (rnd(0.4, 1.0) + injuries)
                                            Else
                                                damage1033ru($14)
                                                local0\Field61 = (local0\Field61 - $14)
                                                If (local0\Field61 <= $00) Then
                                                    local0\Field48 = $01
                                                EndIf
                                            EndIf
                                            If (3.0 < injuries) Then
                                                deathmsg = scplang_getphrase("events.scp0493")
                                                kill($01, $00)
                                            EndIf
                                        EndIf
                                    EndIf
                                ElseIf (164.0 < local0\Field14) Then
                                    local0\Field9 = 2.0
                                EndIf
                        End Select
                    Else
                        If (local0\Field17 <> $00) Then
                            stopchannel(local0\Field17)
                            local0\Field17 = $00
                            freesound_strict(local0\Field16)
                            local0\Field16 = $00
                        EndIf
                        animatenpc(local0, 600.0, 619.0, 0.5, $00)
                        If (618.0 <= local0\Field14) Then
                            local0\Field14 = 619.0
                        EndIf
                    EndIf
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.2), entityz(local0\Field4, $00), $00)
                    rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                EndIf
            Case $18
                local8 = entitydistance(local0\Field4, collider)
                If (local0\Field16 > $00) Then
                    local21 = $00
                    If (0.0 < local0\Field9) Then
                        local21 = $01
                    EndIf
                    local0\Field17 = loopsound2(local0\Field16, local0\Field17, camera, camera, 10.0, (Float local21))
                EndIf
                local21 = (Int rnd(-1.0, 1.0))
                positionentity(local0\Field0, (entityx(local0\Field4, $01) + (local0\Field28 * (Float local21))), (entityy(local0\Field4, $01) - 0.2), (entityz(local0\Field4, $01) + (local0\Field30 * (Float local21))), $00)
                rotateentity(local0\Field0, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                local0\Field28 = curvevalue(0.0, local0\Field28, 10.0)
                local0\Field30 = curvevalue(0.0, local0\Field30, 10.0)
                If (rand($C8, $01) = $01) Then
                    If (rand($05, $01) = $01) Then
                        local0\Field28 = ((entityx(collider, $00) - entityx(local0\Field4, $00)) * 0.9)
                        local0\Field30 = ((entityz(collider, $00) - entityz(local0\Field4, $00)) * 0.9)
                    Else
                        local0\Field28 = rnd(0.1, 0.5)
                        local0\Field30 = rnd(0.1, 0.5)
                    EndIf
                EndIf
                If (((i_178\Field0 <> $01) And (0.0 = local0\Field11)) <> 0) Then
                    If (0.0 < local0\Field9) Then
                        entityalpha(local0\Field0, 0.0)
                        local0\Field9 = max((local0\Field9 - local17\Field3[$00]), 0.0)
                    EndIf
                ElseIf (0.0 = local0\Field11) Then
                    entityalpha(local0\Field0, (((Float rand($00, $01)) / 2.0) + 0.5))
                Else
                    entityalpha(local0\Field0, ((sin((local0\Field14 * 6.0)) / 2.0) + 0.5))
                EndIf
                If (0.0 = local0\Field9) Then
                    If (0.0 = local0\Field25) Then
                        animatenpc(local0, 206.0, 240.0, 0.1, $01)
                        If (240.0 <= local0\Field14) Then
                            local0\Field25 = 1.0
                        EndIf
                    Else
                        animatenpc(local0, 206.0, 240.0, -0.1, $01)
                        If (206.0 >= local0\Field14) Then
                            local0\Field25 = 0.0
                        EndIf
                    EndIf
                    local10 = vectoryaw((entityx(collider, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(collider, $00) - entityz(local0\Field4, $00)))
                    rotateentity(local0\Field4, 0.0, curveangle(local10, entityyaw(local0\Field4, $00), 20.0), 0.0, $00)
                    For local1 = Each npcs
                        If (((local1\Field5 = local0\Field5) And (local0 <> local1)) <> 0) Then
                            If (0.0 < local1\Field9) Then
                                local0\Field9 = 1.0
                            EndIf
                            If (0.0 < local1\Field11) Then
                                local0\Field11 = 1.0
                            EndIf
                        EndIf
                        If (0.0 <> local0\Field9) Then
                            Exit
                        EndIf
                    Next
                    If (((1.0 > local8) And entityinview(local0\Field0, camera)) <> 0) Then
                        local0\Field10 = (local0\Field10 + local17\Field3[$00])
                    ElseIf (entitycollided(local0\Field4, $02) = collider) Then
                        local0\Field10 = 50.0
                    Else
                        local0\Field10 = max((local0\Field10 - local17\Field3[$00]), 0.0)
                    EndIf
                    If (50.0 <= local0\Field10) Then
                        local0\Field9 = 1.0
                    EndIf
                EndIf
                If (0.0 < local0\Field9) Then
                    If (0.0 = local0\Field11) Then
                        For local1 = Each npcs
                            If (((local1\Field5 = local0\Field5) And (local0 <> local1)) <> 0) Then
                                If (0.0 < local1\Field11) Then
                                    local0\Field11 = 1.0
                                EndIf
                            EndIf
                            If (0.0 <> local0\Field11) Then
                                Exit
                            EndIf
                        Next
                    EndIf
                    If (((i_178\Field0 = $01) Or (0.0 < local0\Field11)) <> 0) Then
                        local0\Field9 = min((local0\Field9 + local17\Field3[$00]), 300.0)
                    Else
                        local0\Field9 = max((local0\Field9 - local17\Field3[$00]), 0.0)
                    EndIf
                    If (0.0 >= local0\Field38) Then
                        local0\Field37 = findpath(local0, entityx(collider, $01), entityy(collider, $01), entityz(collider, $01))
                        local0\Field38 = 400.0
                        local0\Field22 = 0.0
                    EndIf
                    local0\Field38 = max((local0\Field38 - local17\Field3[$00]), 0.0)
                    If (entityvisible(local0\Field4, collider) = $00) Then
                        If (local0\Field37 = $02) Then
                            local0\Field22 = 0.0
                            local0\Field14 = 15.0
                        ElseIf (local0\Field37 = $01) Then
                            If (local0\Field36[local0\Field39] = Null) Then
                                If (local0\Field39 > $13) Then
                                    local0\Field39 = $00
                                    local0\Field37 = $00
                                Else
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            Else
                                local10 = vectoryaw((entityx(local0\Field36[local0\Field39]\Field0, $01) - entityx(local0\Field4, $00)), 0.0, (entityz(local0\Field36[local0\Field39]\Field0, $01) - entityz(local0\Field4, $00)))
                                rotateentity(local0\Field4, 0.0, curveangle(local10, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                                If (0.2 > entitydistance(local0\Field4, local0\Field36[local0\Field39]\Field0)) Then
                                    local0\Field39 = (local0\Field39 + $01)
                                EndIf
                            EndIf
                        ElseIf (local0\Field37 = $00) Then
                            local0\Field22 = curvevalue(0.0, local0\Field22, 10.0)
                        EndIf
                    Else
                        local10 = vectoryaw((entityx(collider, $00) - entityx(local0\Field4, $00)), 0.0, (entityz(collider, $00) - entityz(local0\Field4, $00)))
                        rotateentity(local0\Field4, 0.0, curveangle(local10, entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                        local0\Field22 = curvevalue(local0\Field21, local0\Field22, 10.0)
                    EndIf
                    If (0.3 < local8) Then
                        moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                        If (2.0 > local8) Then
                            animatenpc(local0, min(animtime(local0\Field0), 95.0), 124.0, (local0\Field22 * 10.0), $01)
                        Else
                            animatenpc(local0, 64.0, 93.0, (local0\Field22 * 10.0), $01)
                        EndIf
                        For local2 = Each doors
                            If ((((1.25 > entitydistance(local0\Field4, local2\Field0)) And (local2\Field17 <> "ABCD")) And (entitycollided(local0\Field4, $05) = $00)) <> 0) Then
                                local0\Field7 = 0.0
                                resetentity(local0\Field4)
                            EndIf
                        Next
                    EndIf
                    If (0.4 > local8) Then
                        If (((65.0 <= local0\Field10) And (0.0 <= killtimer)) <> 0) Then
                            playsound_strict(damagesfx(rand($02, $03)))
                            If (i_1033ru\Field0 = $00) Then
                                injuries = (rnd(0.4, 0.8) + injuries)
                            Else
                                damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $14))
                            EndIf
                            If (4.0 <= injuries) Then
                                If (0.0 = local0\Field11) Then
                                    deathmsg = scplang_getphrase("events.scp1781")
                                Else
                                    deathmsg = scplang_getphrase("events.scp1782")
                                EndIf
                                kill($01, $00)
                            EndIf
                            local0\Field10 = 0.0
                        Else
                            local0\Field10 = (local0\Field10 + local17\Field3[$00])
                        EndIf
                    EndIf
                EndIf
            Case $1C
                updatemtf2unit(local0)
            Case $1B
                local14 = animtime(local0\Field0)
                Select local0\Field9
                    Case 0.0
                        local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                        animate2(local0\Field0, animtime(local0\Field0), $02, $AF, 0.1, $01)
                    Case 1.0
                        If (1.0 = local0\Field10) Then
                            local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                        Else
                            local0\Field22 = curvevalue(0.015, local0\Field22, 5.0)
                        EndIf
                        animate2(local0\Field0, animtime(local0\Field0), $B0, $D2, (local0\Field22 * 18.0), $01)
                End Select
                If (0.01 < local0\Field22) Then
                    If (((180.0 > local14) And (180.0 <= animtime(local0\Field0))) <> 0) Then
                        playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($02, $00)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                    ElseIf (((195.0 > local14) And (195.0 <= animtime(local0\Field0))) <> 0) Then
                        playsound2(stepsfx(getstepsound(local0\Field4), $00, rand($02, $00)), camera, local0\Field4, 8.0, rnd(0.3, 0.5))
                    EndIf
                EndIf
                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.32), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
            Case $1D
                Select local0\Field9
                    Case 0.0
                        local0\Field22 = curvevalue(0.0, local0\Field22, 5.0)
                    Case 1.0
                        local0\Field22 = curvevalue((local0\Field21 * 0.7), local0\Field22, 20.0)
                        animate2(local0\Field0, animtime(local0\Field0), $01, $14, (local0\Field22 * 18.0), $01)
                End Select
                If (0.0 = local0\Field9) Then
                    If (channelplaying(local0\Field20) = $01) Then
                        stopchannel(local0\Field20)
                    EndIf
                    local0\Field17 = loopsound2(vehiclesfx($01), local0\Field17, camera, local0\Field4, 13.0, 1.0)
                ElseIf (1.0 = local0\Field9) Then
                    If (channelplaying(local0\Field17) = $01) Then
                        stopchannel(local0\Field17)
                    EndIf
                    local0\Field20 = loopsound2(vehiclesfx($00), local0\Field20, camera, local0\Field4, 13.0, 1.0)
                EndIf
                moveentity(local0\Field4, 0.0, 0.0, (local0\Field22 * local17\Field3[$00]))
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.32), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
        End Select
        If (local0\Field48 <> 0) Then
            entitytype(local0\Field4, $06, $00)
        EndIf
        local79 = (Int distance(entityx(collider, $00), entityz(collider, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00)))
        If ((((Float local79) < (hidedistance * 0.7)) Or (local0\Field5 = $0F)) <> 0) Then
            If (local0\Field58 = infacility) Then
                translateentity(local0\Field4, 0.0, local0\Field7, 0.0, $00)
                local80 = $00
                For local7 = $01 To countcollisions(local0\Field4) Step $01
                    If ((entityy(local0\Field4, $00) - 0.01) > collisiony(local0\Field4, local7)) Then
                        local80 = $01
                        Exit
                    EndIf
                Next
                If (local80 = $01) Then
                    local0\Field7 = 0.0
                ElseIf (shouldentitiesfall <> 0) Then
                    local81 = $00
                    If (local0\Field58 = $01) Then
                        If (playerroom\Field7\Field10 <> "room173intro") Then
                            For local30 = Each events
                                If (local30\Field0 = "room860") Then
                                    If (1.0 = local30\Field2) Then
                                        local81 = $01
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        Else
                            local81 = $01
                        EndIf
                        If (local81 = $00) Then
                            For local4 = Each rooms
                                If (((((0.0 <> local4\Field49) Or (0.0 <> local4\Field46)) Or (0.0 <> local4\Field51)) Or (0.0 <> local4\Field48)) <> 0) Then
                                    local82 = local4\Field49
                                    local83 = local4\Field46
                                    local84 = local4\Field51
                                    local85 = local4\Field48
                                Else
                                    local82 = 4.0
                                    local83 = 0.0
                                    local84 = 4.0
                                    local85 = 0.0
                                EndIf
                                If ((Abs (local82 - local83)) >= (Abs (entityx(local0\Field4, $00) - entityx(local4\Field2, $00)))) Then
                                    If ((Abs (local84 - local85)) >= (Abs (entityz(local0\Field4, $00) - entityz(local4\Field2, $00)))) Then
                                        If (local4 = playerroom) Then
                                            local81 = $01
                                            Exit
                                        EndIf
                                        If (isroomadjacent(playerroom, local4) <> 0) Then
                                            local81 = $01
                                            Exit
                                        EndIf
                                        For local7 = $00 To $03 Step $01
                                            If (isroomadjacent(playerroom\Field24[local7], local4) <> 0) Then
                                                local81 = $01
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    Else
                        local81 = $01
                    EndIf
                    If (local81 <> 0) Then
                        local0\Field7 = max((local0\Field7 - ((local17\Field3[$00] * 0.005) * local0\Field44)), (- local0\Field45))
                    ElseIf (0.0 < local0\Field74) Then
                        local0\Field7 = 0.0
                    Else
                        local0\Field7 = max((local0\Field7 - ((local17\Field3[$00] * 0.005) * local0\Field44)), (- local0\Field45))
                    EndIf
                Else
                    local0\Field7 = 0.0
                EndIf
            Else
                local0\Field7 = 0.0
            EndIf
        Else
            local0\Field7 = 0.0
        EndIf
    Next
    If (((0.0 < mtf_camerachecktimer) And (6300.0 > mtf_camerachecktimer)) <> 0) Then
        mtf_camerachecktimer = (local17\Field3[$00] + mtf_camerachecktimer)
    ElseIf (6300.0 <= mtf_camerachecktimer) Then
        mtf_camerachecktimer = 0.0
        If (playerdetected = $00) Then
            If (mtf_cameracheckdetected <> 0) Then
                playannouncement(scpmodding_processfilepath((("SFX\Character\MTF\AnnouncCameraFound" + (Str rand($01, $02))) + ".ogg")))
                playerdetected = $01
                mtf_camerachecktimer = 4200.0
            Else
                playannouncement(scpmodding_processfilepath("SFX\Character\MTF\AnnouncCameraNoFound.ogg"))
            EndIf
        EndIf
        mtf_cameracheckdetected = $00
        If (0.0 = mtf_camerachecktimer) Then
            playerdetected = $00
        EndIf
    EndIf
    Return $00
End Function
