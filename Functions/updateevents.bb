Function updateevents%()
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    Local local7.particles
    Local local8.npcs
    Local local9.rooms
    Local local10.events
    Local local11.events
    Local local12.items
    Local local13.items
    Local local14.emitters
    Local local15.securitycams
    Local local16%
    Local local17$
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22.objects
    Local local23.fps_settings
    Local local27#
    Local local28.doors
    Local local29.waypoints
    Local local30.decals
    Local local31#
    Local local32%
    Local local33#
    Local local34#
    Local local35#
    Local local36.rooms
    Local local37%
    Local local40%
    Local local41%
    Local local42%
    Local local43%
    Local local44%
    Local local45%[7]
    Local local46$
    Local local47%
    Local local48%
    Local local49%
    Local local50%
    Local local51.doors
    Local local52%
    Local local53%
    Local local54%
    Local local55%
    Local local56%
    Local local57%
    Local local58%
    Local local60%
    Local local61%
    Local local62%
    Local local63%
    Local local64%
    Local local65%
    Local local68.waypoints
    Local local71.waypoints
    Local local72.decals
    Local local73%
    Local local74$
    Local local75.itemtemplates
    Local local76%
    Local local77%
    Local local78%
    Local local79%
    Local local80$
    Local local82%
    Local local83%
    Local local85%
    Local local86%
    Local local88.forest
    Local local89#
    Local local91%
    Local local92#
    Local local93%
    Local local94$
    Local local95%
    Local local98%
    Local local100#
    Local local101#
    Local local104%
    Local local105%
    Local local106%
    Local local107$
    Local local109%
    Local local110%
    Local local113%
    Local local114%
    Local local115#
    Local local116#
    Local local117%
    Local local118%
    Local local119%
    Local local121#
    Local local122#
    Local local123%
    Local local125.dummy1499
    Local local126%
    Local local127%
    Local local128#
    local17 = ""
    local22 = (First objects)
    local23 = (First fps_settings)
    currstepsfx = $00
    updaterooms()
    For local10 = Each events
        Select local10\Field0
            Case "gateb"
                If (remotedooron = $00) Then
                    local10\Field1\Field21[$04]\Field4 = $01
                ElseIf ((remotedooron And (0.0 = local10\Field4)) <> 0) Then
                    local10\Field1\Field21[$04]\Field4 = $00
                    If (local10\Field1\Field21[$04]\Field5 <> 0) Then
                        If (((50.0 < local10\Field1\Field21[$04]\Field7) Or (0.5 > entitydistance(collider, local10\Field1\Field21[$04]\Field2))) <> 0) Then
                            local10\Field1\Field21[$04]\Field7 = min(local10\Field1\Field21[$04]\Field7, 50.0)
                            local10\Field1\Field21[$04]\Field5 = $00
                            playsound2(loadtempsound(scpmodding_processfilepath("SFX\Door\DoorError.ogg")), camera, local10\Field1\Field21[$04]\Field2, 10.0, 1.0)
                        EndIf
                    EndIf
                Else
                    local10\Field1\Field21[$04]\Field4 = $00
                    If (curr096 <> Null) Then
                        If (((0.0 = curr096\Field9) Or (5.0 = curr096\Field9)) <> 0) Then
                            local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$08], local10\Field1\Field19[$09], local10, $01)
                        Else
                            local10\Field3 = update096elevatorevent(local10, local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field19[$08])
                        EndIf
                    Else
                        local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$08], local10\Field1\Field19[$09], local10, $01)
                    EndIf
                    entityalpha(at\Field4[$00], 1.0)
                EndIf
            Case "room173"
                If (local10\Field1\Field21[$05] = Null) Then
                    For local1 = $00 To $03 Step $01
                        If (local10\Field1\Field25[local1] <> Null) Then
                            local10\Field1\Field21[$05] = local10\Field1\Field25[local1]
                            local10\Field1\Field21[$05]\Field5 = $01
                            Exit
                        EndIf
                    Next
                EndIf
                If (0.0 = local10\Field2) Then
                    If (playerroom = local10\Field1) Then
                        local10\Field1\Field21[$02]\Field5 = $01
                        showentity(at\Field4[$00])
                        ambientlight((Float brightness), (Float brightness), (Float brightness))
                        camerafogrange(camera, camerafognear, camerafogfar)
                        camerafogmode(camera, $01)
                        If (selecteddifficulty\Field4 = $00) Then
                            msg = ((((scplang_getphrase("events.press") + " ") + keyname(key_save)) + " ") + scplang_getphrase("events.room173save"))
                            msgtimer = 280.0
                        ElseIf (selecteddifficulty\Field4 = $02) Then
                            msg = scplang_getphrase("events.room173monitor")
                            msgtimer = 560.0
                        EndIf
                        curr173\Field24 = 0.0
                        While (180.0 > local10\Field1\Field21[$01]\Field7)
                            local10\Field1\Field21[$01]\Field7 = min(180.0, (local10\Field1\Field21[$01]\Field7 + 0.8))
                            moveentity(local10\Field1\Field21[$01]\Field0, (sin(local10\Field1\Field21[$01]\Field7) / 180.0), 0.0, 0.0)
                            moveentity(local10\Field1\Field21[$01]\Field1, ((- sin(local10\Field1\Field21[$01]\Field7)) / 180.0), 0.0, 0.0)
                        Wend
                        If (local10\Field1\Field22[$00] <> Null) Then
                            setnpcframe(local10\Field1\Field22[$00], 74.0)
                            local10\Field1\Field22[$00]\Field9 = 8.0
                        EndIf
                        If (local10\Field1\Field22[$01] = Null) Then
                            local10\Field1\Field22[$01] = createnpc($12, 0.0, 0.0, 0.0)
                            changenpctextureid(local10\Field1\Field22[$01], $03)
                        EndIf
                        positionentity(local10\Field1\Field22[$01]\Field4, local10\Field1\Field3, 0.5, (local10\Field1\Field5 - 1.0), $01)
                        resetentity(local10\Field1\Field22[$01]\Field4)
                        setnpcframe(local10\Field1\Field22[$01], 210.0)
                        If (local10\Field1\Field22[$02] = Null) Then
                            local10\Field1\Field22[$02] = createnpc($13, 0.0, 0.0, 0.0)
                        EndIf
                        positionentity(local10\Field1\Field22[$02]\Field4, local10\Field1\Field3, 0.5, (local10\Field1\Field5 + (528.0 * roomscale)), $01)
                        resetentity(local10\Field1\Field22[$02]\Field4)
                        local10\Field1\Field22[$02]\Field9 = 7.0
                        pointentity(local10\Field1\Field22[$02]\Field4, local10\Field1\Field22[$01]\Field4, 0.0)
                        If (local10\Field1\Field22[$00] = Null) Then
                            local10\Field1\Field22[$03] = createnpc($13, entityx(local10\Field1\Field19[$02], $01), entityy(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01))
                            rotateentity(local10\Field1\Field22[$03]\Field4, 0.0, 90.0, 0.0, $00)
                            setnpcframe(local10\Field1\Field22[$03], 286.0)
                            local10\Field1\Field22[$03]\Field9 = 8.0
                            moveentity(local10\Field1\Field22[$03]\Field4, 1.0, 0.0, 0.0)
                            local10\Field1\Field22[$04] = createnpc($12, entityx(local10\Field1\Field19[$03], $01), 0.52, entityz(local10\Field1\Field19[$03], $01))
                            setnpcframe(local10\Field1\Field22[$04], 676.0)
                            local10\Field1\Field22[$04]\Field9 = 3.0
                            rotateentity(local10\Field1\Field22[$04]\Field4, 0.0, 270.0, 0.0, $00)
                            moveentity(local10\Field1\Field22[$04]\Field4, 0.0, 0.0, 2.65)
                            local10\Field1\Field22[$05] = createnpc($12, entityx(local10\Field1\Field19[$04], $01), 0.52, entityz(local10\Field1\Field19[$04], $01))
                            changenpctextureid(local10\Field1\Field22[$05], $05)
                            setnpcframe(local10\Field1\Field22[$05], 629.0)
                            local10\Field1\Field22[$05]\Field9 = 3.0
                            rotateentity(local10\Field1\Field22[$05]\Field4, 0.0, 270.0, 0.0, $00)
                            moveentity(local10\Field1\Field22[$05]\Field4, 0.25, 0.0, 3.0)
                            rotateentity(local10\Field1\Field22[$05]\Field4, 0.0, 0.0, 0.0, $00)
                            local18 = (entityx(local10\Field1\Field2, $01) + (3712.0 * roomscale))
                            local19 = (384.0 * roomscale)
                            local20 = (entityz(local10\Field1\Field2, $01) + (1312.0 * roomscale))
                            For local1 = $03 To $05 Step $01
                                positionentity(local10\Field1\Field22[local1]\Field4, ((entityx(local10\Field1\Field22[local1]\Field4, $00) - entityx(local10\Field1\Field2, $00)) + local18), ((entityy(local10\Field1\Field22[local1]\Field4, $00) + local19) + 0.4), ((entityz(local10\Field1\Field22[local1]\Field4, $00) - entityz(local10\Field1\Field2, $00)) + local20), $00)
                                resetentity(local10\Field1\Field22[local1]\Field4)
                            Next
                        EndIf
                        local10\Field2 = 1.0
                    EndIf
                Else
                    If (local10\Field1\Field22[$00] <> Null) Then
                        animatenpc(local10\Field1\Field22[$00], 249.0, 286.0, 0.4, $00)
                    EndIf
                    local17 = checktriggers()
                    If (local17 = "173scene_timer") Then
                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                    ElseIf (local17 = "173scene_activated") Then
                        local10\Field2 = max(local10\Field2, 500.0)
                    EndIf
                    If (850.0 > local10\Field2) Then
                        positionentity(curr173\Field4, (local10\Field1\Field3 + (32.0 * roomscale)), 0.31, (local10\Field1\Field5 + (1072.0 * roomscale)), $01)
                        hideentity(curr173\Field0)
                    EndIf
                    If (500.0 <= local10\Field2) Then
                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                        If (0.0 = local10\Field3) Then
                            cansave = $00
                            showentity(curr173\Field0)
                            If (((900.0 < local10\Field2) And local10\Field1\Field21[$05]\Field5) <> 0) Then
                                If (900.0 >= (local10\Field2 - local23\Field3[$00])) Then
                                    local10\Field1\Field22[$01]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\WhatThe.ogg"))
                                    local10\Field1\Field22[$01]\Field17 = playsound2(local10\Field1\Field22[$01]\Field16, camera, local10\Field1\Field22[$01]\Field4, 10.0, 1.0)
                                EndIf
                                local10\Field1\Field22[$01]\Field9 = 3.0
                                local10\Field1\Field22[$01]\Field22 = curvevalue(-0.008, local10\Field1\Field22[$01]\Field22, 5.0)
                                animatenpc(local10\Field1\Field22[$01], 260.0, 236.0, (local10\Field1\Field22[$01]\Field22 * 18.0), $01)
                                rotateentity(local10\Field1\Field22[$01]\Field4, 0.0, 0.0, 0.0, $00)
                                If (1075.0 < local10\Field2) Then
                                    If (1.0 <> local10\Field1\Field22[$02]\Field9) Then
                                        local10\Field1\Field22[$02]\Field22 = curvevalue(-0.012, local10\Field1\Field22[$02]\Field22, 5.0)
                                        animatenpc(local10\Field1\Field22[$02], 39.0, 76.0, (local10\Field1\Field22[$02]\Field22 * 40.0), $01)
                                        moveentity(local10\Field1\Field22[$02]\Field4, 0.0, 0.0, (local10\Field1\Field22[$02]\Field22 * local23\Field3[$00]))
                                        local10\Field1\Field22[$02]\Field9 = 8.0
                                        If (local10\Field1\Field5 > entityz(local10\Field1\Field22[$02]\Field4, $00)) Then
                                            pointentity(local10\Field1\Field22[$02]\Field0, local10\Field1\Field22[$01]\Field4, 0.0)
                                            rotateentity(local10\Field1\Field22[$02]\Field4, 0.0, curveangle((entityyaw(local10\Field1\Field22[$02]\Field0, $00) - 180.0), entityyaw(local10\Field1\Field22[$02]\Field4, $00), 15.0), 0.0, $00)
                                        Else
                                            rotateentity(local10\Field1\Field22[$02]\Field4, 0.0, 0.0, 0.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                                If (1180.0 > local10\Field2) Then
                                    positionentity(curr173\Field4, (local10\Field1\Field3 + (32.0 * roomscale)), 0.31, (local10\Field1\Field5 + (1072.0 * roomscale)), $01)
                                    rotateentity(curr173\Field4, 0.0, 190.0, 0.0, $00)
                                    If (((970.0 < local10\Field2) And (1075.0 > local10\Field2)) <> 0) Then
                                        animatenpc(local10\Field1\Field22[$02], 1539.0, 1553.0, 0.2, $00)
                                        pointentity(local10\Field1\Field22[$02]\Field0, curr173\Field4, 0.0)
                                        rotateentity(local10\Field1\Field22[$02]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$02]\Field0, $00), entityyaw(local10\Field1\Field22[$02]\Field4, $00), 15.0), 0.0, $00)
                                    EndIf
                                Else
                                    If (1180.0 > (local10\Field2 - local23\Field3[$00])) Then
                                        playsound_strict(introsfx($0B))
                                        lightblink = 3.0
                                        playsound2(stonedragsfx, camera, curr173\Field4, 10.0, 1.0)
                                        pointentity(curr173\Field4, local10\Field1\Field22[$02]\Field4, 0.0)
                                        If ((320.0 * roomscale) > entityy(collider, $00)) Then
                                            blinktimer = -10.0
                                        EndIf
                                    EndIf
                                    positionentity(curr173\Field4, (local10\Field1\Field3 - (96.0 * roomscale)), 0.31, (local10\Field1\Field5 + (592.0 * roomscale)), $01)
                                    rotateentity(curr173\Field4, 0.0, 190.0, 0.0, $00)
                                    If (((1.0 <> local10\Field1\Field22[$02]\Field9) And (0.0 <= killtimer)) <> 0) Then
                                        If (entityz(local10\Field1\Field22[$02]\Field4, $00) < (local10\Field1\Field5 - (1150.0 * roomscale))) Then
                                            local10\Field1\Field21[$05]\Field5 = $00
                                            lightblink = 3.0
                                            playsound_strict(introsfx($0B))
                                            blinktimer = -10.0
                                            playsound2(stonedragsfx, camera, curr173\Field4, 10.0, 1.0)
                                            If (((2.5 > entitydistance(curr173\Field4, collider)) And (1.0 > (Abs (entityy(collider, $00) - entityy(curr173\Field4, $00))))) <> 0) Then
                                                positionentity(curr173\Field4, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                            Else
                                                positionentity(curr173\Field4, 0.0, 0.0, 0.0, $00)
                                            EndIf
                                            resetentity(curr173\Field4)
                                            msg = ((((scplang_getphrase("events.hold") + " ") + keyname(key_sprint)) + " ") + scplang_getphrase("events.room173run"))
                                            msgtimer = 560.0
                                        EndIf
                                    EndIf
                                EndIf
                                If ((((local17 = "173scene_end") And entityvisible(local10\Field1\Field22[$02]\Field4, collider)) And (chs\Field2 = $00)) <> 0) Then
                                    local10\Field1\Field22[$02]\Field9 = 1.0
                                    local10\Field1\Field22[$02]\Field11 = 1.0
                                ElseIf (((1.0 = local10\Field1\Field22[$02]\Field9) And (entityvisible(local10\Field1\Field22[$02]\Field4, collider) = $00)) <> 0) Then
                                    local10\Field1\Field22[$02]\Field9 = 0.0
                                    local10\Field1\Field22[$02]\Field11 = 0.0
                                EndIf
                                If (1.0 = local10\Field1\Field22[$02]\Field9) Then
                                    local10\Field1\Field21[$05]\Field5 = $01
                                EndIf
                            Else
                                cansave = $01
                                If (1.0 <> local10\Field1\Field22[$02]\Field9) Then
                                    If (entityx(collider, $00) < (local10\Field1\Field3 + (1384.0 * roomscale))) Then
                                        local10\Field2 = max(local10\Field2, 900.0)
                                    EndIf
                                    If (0.0 = local10\Field1\Field21[$05]\Field7) Then
                                        If (local10\Field1\Field22[$01] <> Null) Then
                                            removenpc(local10\Field1\Field22[$01])
                                        EndIf
                                        If (local10\Field1\Field22[$02] <> Null) Then
                                            removenpc(local10\Field1\Field22[$02])
                                        EndIf
                                        local10\Field3 = 1.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        positionentity(local10\Field1\Field19[$00], entityx(local10\Field1\Field19[$00], $01), ((- max((local10\Field2 - 1300.0), 0.0)) / 4500.0), entityz(local10\Field1\Field19[$00], $01), $01)
                        rotateentity(local10\Field1\Field19[$00], ((- max((local10\Field2 - 1320.0), 0.0)) / 130.0), 0.0, ((- max((local10\Field2 - 1300.0), 0.0)) / 40.0), $01)
                        positionentity(local10\Field1\Field19[$01], entityx(local10\Field1\Field19[$01], $01), ((- max((local10\Field2 - 1800.0), 0.0)) / 5000.0), entityz(local10\Field1\Field19[$01], $01), $01)
                        rotateentity(local10\Field1\Field19[$01], ((- max((local10\Field2 - 2040.0), 0.0)) / 135.0), 0.0, ((- max((local10\Field2 - 2040.0), 0.0)) / 43.0), $01)
                        If (2.5 > entitydistance(local10\Field1\Field19[$00], collider)) Then
                            If (rand($12C, $01) = $02) Then
                                playsound2(decaysfx(rand($01, $03)), camera, local10\Field1\Field19[$00], 3.0, 1.0)
                            EndIf
                        EndIf
                    EndIf
                    If (2000.0 > local10\Field2) Then
                        If (local10\Field6 = $00) Then
                            local10\Field6 = playsound_strict(alarmsfx($00))
                        ElseIf (channelplaying(local10\Field6) = $00) Then
                            local10\Field6 = playsound_strict(alarmsfx($00))
                        EndIf
                    EndIf
                    If (11.0 > local10\Field4) Then
                        If (channelplaying(local10\Field7) = $00) Then
                            local10\Field4 = (local10\Field4 + 1.0)
                            If (local10\Field10 <> $00) Then
                                freesound_strict(local10\Field10)
                                local10\Field10 = $00
                            EndIf
                            local10\Field10 = loadsound_strict(scpmodding_processfilepath((("SFX\Alarm\Alarm2_" + (Str (Int local10\Field4))) + ".ogg")))
                            local10\Field7 = playsound_strict(local10\Field10)
                        ElseIf ((Int local10\Field4) = $08) Then
                            camerashake = 1.0
                        EndIf
                    EndIf
                    If (((300.0 < (local10\Field2 Mod 600.0)) And (300.0 > ((local10\Field2 + local23\Field3[$00]) Mod 600.0))) <> 0) Then
                        local1 = (Int (floor(((local10\Field2 - 5000.0) / 600.0)) + 1.0))
                        If (local1 = $00) Then
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\Intro\PA\Scripted\Scripted6.ogg")))
                        EndIf
                        If (((local1 > $00) And (local1 < $1B)) <> 0) Then
                            If (commotionstate(local1) = $00) Then
                                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\Room\Intro\Commotion\Commotion" + (Str local1)) + ".ogg"))))
                                commotionstate(local1) = $01
                            EndIf
                        EndIf
                        If (local1 > $1B) Then
                            If (local10\Field1\Field22[$00] <> Null) Then
                                removenpc(local10\Field1\Field22[$00])
                            EndIf
                            freeentity(local10\Field1\Field19[$00])
                            freeentity(local10\Field1\Field19[$01])
                            local10\Field1\Field19[$00] = $00
                            local10\Field1\Field19[$01] = $00
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room173intro"
                If (playerroom = local10\Field1) Then
                    For local9 = Each rooms
                        hideentity(local9\Field2)
                    Next
                    showentity(local10\Field1\Field2)
                EndIf
                If (((0.0 <= killtimer) And (0.0 = local10\Field3)) <> 0) Then
                    playerzone = $00
                    If (0.0 < local10\Field4) Then
                        shouldplay = $0D
                        currspeed = min((currspeed - (((0.008 / entitydistance(local10\Field1\Field22[$03]\Field4, collider)) * currspeed) * local23\Field3[$00])), currspeed)
                        If (170.0 > local10\Field4) Then
                            If (1.0 = local10\Field4) Then
                                positionentity(camera, local18, local19, local20, $00)
                                hideentity(collider)
                                positionentity(collider, local18, 0.302, local20, $00)
                                rotateentity(camera, -70.0, 0.0, 0.0, $00)
                                currmusicvolume = musicvolume
                                stopstream_strict(musicchn)
                                musicchn = streamsound_strict(scpmodding_processfilepath((("SFX\Music\" + music($0D)) + ".ogg")), currmusicvolume, $02)
                                nowplaying = shouldplay
                                playsound_strict(introsfx($0B))
                                blurtimer = 500.0
                                showentity(at\Field4[$0E])
                                entityalpha(at\Field4[$0E], 0.5)
                                createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                                createconsolemsg(scplang_getphrase("events.room173introconsole"), $FF, $00, $00, $00)
                                createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            EndIf
                            If (3.0 > local10\Field4) Then
                                local10\Field4 = (local10\Field4 + (local23\Field3[$00] / 100.0))
                            ElseIf (((15.0 > local10\Field4) Or (50.0 <= local10\Field4)) <> 0) Then
                                local10\Field4 = (local10\Field4 + (local23\Field3[$00] / 30.0))
                            EndIf
                            If (15.0 > local10\Field4) Then
                                local18 = (entityx(local10\Field1\Field2, $00) - (4248.0 * roomscale))
                                local19 = (136.0 * roomscale)
                                local20 = (entityz(local10\Field1\Field2, $00) + (8.0 * roomscale))
                                If (((3.7 > (local10\Field4 - (local23\Field3[$00] / 30.0))) And (3.7 < local10\Field4)) <> 0) Then
                                    playsound2(introsfx($13), camera, collider, 8.0, 0.5)
                                EndIf
                                If (((9.3 > (local10\Field4 - (local23\Field3[$00] / 30.0))) And (9.3 < local10\Field4)) <> 0) Then
                                    playsound2(introsfx($14), camera, collider, 8.0, 0.5)
                                EndIf
                                If (14.0 > local10\Field4) Then
                                    mouse_x_speed_1 = 0.0
                                    mouse_y_speed_1 = 0.0
                                    If (((12.0 > (local10\Field4 - (local23\Field3[$00] / 30.0))) And (12.0 < local10\Field4)) <> 0) Then
                                        playsound2(stepsfx($00, $00, $00), camera, collider, 8.0, 0.3)
                                    EndIf
                                    showentity(at\Field4[$0E])
                                    entityalpha(at\Field4[$0E], (0.9 - (local10\Field4 / 2.0)))
                                    local18 = ((((entityx(local10\Field1\Field2, $00) - (4072.0 * roomscale)) - local18) * max(((local10\Field4 - 10.0) / 4.0), 0.0)) + local18)
                                    If (10.0 > local10\Field4) Then
                                        local19 = ((min(max(((local10\Field4 - 3.0) / 5.0), 0.0), 1.0) * 0.2) + local19)
                                    Else
                                        local19 = (((0.902 - (local19 + 0.2)) * max(((local10\Field4 - 10.0) / 4.0), 0.0)) + (local19 + 0.2))
                                    EndIf
                                    local20 = ((((entityz(local10\Field1\Field2, $00) + (104.0 * roomscale)) - local20) * min(max(((local10\Field4 - 3.0) / 5.0), 0.0), 1.0)) + local20)
                                    rotateentity(camera, (((min(max(((local10\Field4 - 3.0) / 5.0), 0.0), 1.0) * 70.0) + -70.0) + (sin((local10\Field4 * 12.857)) * 5.0)), (max(((local10\Field4 - 10.0) / 4.0), 0.0) * -60.0), (sin((local10\Field4 * 25.7)) * 8.0), $00)
                                    positionentity(camera, local18, local19, local20, $00)
                                    hideentity(collider)
                                    positionentity(collider, local18, 0.302, local20, $00)
                                    dropspeed = 0.0
                                Else
                                    hideentity(at\Field4[$0E])
                                    positionentity(collider, entityx(collider, $00), 0.302, entityz(collider, $00), $00)
                                    resetentity(collider)
                                    showentity(collider)
                                    dropspeed = 0.0
                                    local10\Field4 = 15.0
                                    msg = scplang_getphrase("events.room173intropaper")
                                    msgtimer = 490.0
                                EndIf
                                user_camera_pitch = 0.0
                                rotateentity(collider, 0.0, entityyaw(camera, $00), 0.0, $00)
                            ElseIf (40.0 > local10\Field4) Then
                                If (inventory($00) <> Null) Then
                                    msg = ((((scplang_getphrase("events.press") + " ") + keyname(key_inv)) + " ") + scplang_getphrase("events.room173introinventory"))
                                    msgtimer = 490.0
                                    local10\Field4 = 40.0
                                    Exit
                                EndIf
                            EndIf
                            If (selecteditem <> Null) Then
                                local10\Field4 = (local10\Field4 + (local23\Field3[$00] / 5.0))
                            EndIf
                        ElseIf (((150.0 <= local10\Field4) And (700.0 > local10\Field4)) <> 0) Then
                            If (7.0 = local10\Field1\Field22[$03]\Field9) Then
                                If (local10\Field1\Field22[$03]\Field19 = $00) Then
                                    local10\Field1\Field22[$03]\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Guard\Ulgrin\BeforeDoorOpen.ogg"))
                                    local10\Field1\Field22[$03]\Field20 = playsound2(local10\Field1\Field22[$03]\Field19, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                EndIf
                                updatesoundorigin(local10\Field1\Field22[$03]\Field20, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                If (channelplaying(local10\Field1\Field22[$03]\Field20) = $00) Then
                                    local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Guard\Ulgrin\ExitCell.ogg"))
                                    local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                    local10\Field1\Field22[$03]\Field9 = 9.0
                                    local10\Field1\Field22[$04]\Field9 = 9.0
                                    local10\Field1\Field22[$05]\Field9 = 9.0
                                    local10\Field1\Field21[$06]\Field4 = $00
                                    usedoor(local10\Field1\Field21[$06], $00, $01)
                                    local10\Field1\Field21[$06]\Field4 = $01
                                EndIf
                            Else
                                freesound_strict(local10\Field1\Field22[$03]\Field19)
                                local10\Field4 = min((local10\Field4 + (local23\Field3[$00] / 4.0)), 699.0)
                                If (1.5 < distance(entityx(collider, $00), entityz(collider, $00), (playerroom\Field3 - (4096.0 * roomscale)), (playerroom\Field5 + (192.0 * roomscale)))) Then
                                    If (270.0 < local10\Field4) Then
                                        If (local10\Field1\Field22[$03]\Field17 <> $00) Then
                                            If (channelplaying(local10\Field1\Field22[$03]\Field17) <> 0) Then
                                                stopchannel(local10\Field1\Field22[$03]\Field17)
                                            EndIf
                                        EndIf
                                        freesound_strict(local10\Field1\Field22[$03]\Field16)
                                        local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Ulgrin\Escort" + (Str rand($01, $02))) + ".ogg")))
                                        local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                        local10\Field1\Field22[$03]\Field37 = findpath(local10\Field1\Field22[$03], (playerroom\Field3 - (320.0 * roomscale)), 0.3, (playerroom\Field5 - (704.0 * roomscale)))
                                        local10\Field1\Field22[$04]\Field37 = findpath(local10\Field1\Field22[$04], (playerroom\Field3 - (320.0 * roomscale)), 0.3, (playerroom\Field5 - (704.0 * roomscale)))
                                        local10\Field4 = 710.0
                                        local10\Field1\Field21[$06]\Field4 = $00
                                        usedoor(local10\Field1\Field21[$06], $00, $01)
                                        local10\Field1\Field21[$06]\Field4 = $01
                                    EndIf
                                Else
                                    local10\Field1\Field22[$03]\Field9 = 9.0
                                    If (((350.0 > (local10\Field4 - (local23\Field3[$00] / 4.0))) And (350.0 <= local10\Field4)) <> 0) Then
                                        freesound_strict(local10\Field1\Field22[$03]\Field16)
                                        local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Ulgrin\ExitCellRefuse" + (Str rand($01, $02))) + ".ogg")))
                                        local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                    ElseIf (((550.0 > (local10\Field4 - (local23\Field3[$00] / 4.0))) And (550.0 <= local10\Field4)) <> 0) Then
                                        freesound_strict(local10\Field1\Field22[$03]\Field16)
                                        local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Ulgrin\CellGas" + (Str rand($01, $02))) + ".ogg")))
                                        local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                    ElseIf (630.0 < local10\Field4) Then
                                        positionentity(collider, entityx(collider, $00), entityy(collider, $00), min(entityz(collider, $00), (entityz(local10\Field1\Field2, $01) + (490.0 * roomscale))), $00)
                                        If (local10\Field1\Field21[$06]\Field5 = $01) Then
                                            local10\Field1\Field21[$06]\Field4 = $00
                                            usedoor(local10\Field1\Field21[$06], $00, $01)
                                            local10\Field1\Field21[$06]\Field4 = $01
                                            local14 = createemitter((playerroom\Field3 - (4000.0 * roomscale)), (373.0 * roomscale), (playerroom\Field5 + (204.0 * roomscale)), $00)
                                            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                                            local14\Field10 = 7.0
                                            local14\Field9 = 0.03
                                            local14\Field11 = 0.003
                                            local14\Field7 = playerroom
                                            local14 = createemitter((playerroom\Field3 - (4192.0 * roomscale)), (373.0 * roomscale), (playerroom\Field5 + (204.0 * roomscale)), $00)
                                            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                                            local14\Field10 = 7.0
                                            local14\Field9 = 0.03
                                            local14\Field11 = 0.003
                                            local14\Field7 = playerroom
                                        EndIf
                                        eyeirritation = max(((local23\Field3[$00] * 4.0) + eyeirritation), 1.0)
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf (800.0 > local10\Field4) Then
                            local10\Field4 = (local10\Field4 + (local23\Field3[$00] / 4.0))
                            If (11.0 <> local10\Field1\Field22[$05]\Field9) Then
                                If (((5.0 < entitydistance(local10\Field1\Field22[$03]\Field4, local10\Field1\Field22[$05]\Field4)) And (Int entitydistance(local10\Field1\Field22[$04]\Field4, local10\Field1\Field22[$05]\Field4))) <> 0) Then
                                    If (3.5 > entitydistance(local10\Field1\Field22[$05]\Field4, collider)) Then
                                        local10\Field1\Field22[$05]\Field9 = 11.0
                                        local10\Field1\Field22[$05]\Field11 = 1.0
                                        local10\Field1\Field22[$05]\Field20 = playsound2(local10\Field1\Field22[$05]\Field19, camera, local10\Field1\Field22[$05]\Field4, 10.0, 1.0)
                                        local10\Field1\Field22[$05]\Field25 = 210.0
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf (900.0 > local10\Field4) Then
                            local10\Field1\Field22[$04]\Field15 = 0.0
                            If (((entityx(collider, $00) < (entityx(local10\Field1\Field2, $01) - (5376.0 * roomscale))) And (local10\Field15 = "")) <> 0) Then
                                If (rand($03, $01) = $01) Then
                                    local10\Field15 = (("Scripted\Scripted" + (Str rand($01, $05))) + ".ogg|Off.ogg|")
                                Else
                                    local10\Field15 = (("1\Attention" + (Str rand($01, $02))) + ".ogg")
                                    Select rand($03, $01)
                                        Case $01
                                            local4 = "Crew"
                                            local10\Field15 = (((local10\Field15 + "|2\Crew") + (Str rand($00, $05))) + ".ogg")
                                        Case $02
                                            local4 = "Scientist"
                                            local10\Field15 = (((local10\Field15 + "|2\Scientist") + (Str rand($00, $13))) + ".ogg")
                                        Case $03
                                            local4 = "Security"
                                            local10\Field15 = (((local10\Field15 + "|2\Security") + (Str rand($00, $05))) + ".ogg")
                                    End Select
                                    If (((rand($02, $01) = $01) And (local4 = "Scientist")) <> 0) Then
                                        local10\Field15 = (local10\Field15 + "|3\Callonline.ogg")
                                        local10\Field15 = (((local10\Field15 + "|Numbers\") + (Str rand($01, $09))) + ".ogg")
                                        If (rand($02, $01) = $01) Then
                                            local10\Field15 = (((local10\Field15 + "|Numbers\") + (Str rand($01, $09))) + ".ogg")
                                        EndIf
                                    Else
                                        local10\Field15 = (((local10\Field15 + "|3\Report") + (Str rand($00, $01))) + ".ogg")
                                        Select local4
                                            Case "Crew"
                                                local10\Field15 = (((local10\Field15 + "|4\Crew") + (Str rand($00, $06))) + ".ogg")
                                                If (rand($02, $01) = $01) Then
                                                    local10\Field15 = (((local10\Field15 + "|5\Crew") + (Str rand($00, $06))) + ".ogg")
                                                EndIf
                                            Case "Scientist"
                                                local10\Field15 = (((local10\Field15 + "|4\Scientist") + (Str rand($00, $07))) + ".ogg")
                                                If (rand($02, $01) = $01) Then
                                                    local10\Field15 = (local10\Field15 + "|5\Scientist0.ogg")
                                                EndIf
                                            Case "Security"
                                                local10\Field15 = (((local10\Field15 + "|4\Security") + (Str rand($00, $05))) + ".ogg")
                                                If (rand($02, $01) = $01) Then
                                                    local10\Field15 = (((local10\Field15 + "|5\Security") + (Str rand($01, $02))) + ".ogg")
                                                EndIf
                                        End Select
                                    EndIf
                                    local10\Field15 = (local10\Field15 + "|Off.ogg|")
                                EndIf
                            EndIf
                            If (local10\Field1\Field22[$06] <> Null) Then
                                If (0.0 = local10\Field1\Field22[$06]\Field9) Then
                                    If (local10\Field1\Field21[$07]\Field5 <> 0) Then
                                        If (5.0 > distance(entityx(collider, $00), entityz(collider, $00), (entityx(local10\Field1\Field2, $01) - (3328.0 * roomscale)), (entityz(local10\Field1\Field2, $01) - (1232.0 * roomscale)))) Then
                                            local10\Field1\Field22[$06]\Field9 = 1.0
                                            If (local10\Field15 = "done") Then
                                                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\Room\Intro\PA\Scripted\Announcement" + (Str rand($01, $07))) + ".ogg"))))
                                            EndIf
                                        EndIf
                                    EndIf
                                ElseIf (entityz(local10\Field1\Field22[$06]\Field4, $00) > (entityz(local10\Field1\Field2, $01) - (64.0 * roomscale))) Then
                                    rotateentity(local10\Field1\Field22[$06]\Field4, 0.0, curveangle(90.0, entityyaw(local10\Field1\Field22[$06]\Field4, $00), 15.0), 0.0, $00)
                                    If (local10\Field1\Field21[$07]\Field5 <> 0) Then
                                        usedoor(local10\Field1\Field21[$07], $00, $01)
                                    EndIf
                                    If (1.0 > local10\Field1\Field21[$07]\Field7) Then
                                        local10\Field1\Field22[$06]\Field9 = 0.0
                                    EndIf
                                EndIf
                            EndIf
                            If (local10\Field1\Field22[$08] <> Null) Then
                                If (7.0 = local10\Field1\Field22[$08]\Field9) Then
                                    If (2.5 > distance(entityx(collider, $00), entityz(collider, $00), (entityx(local10\Field1\Field2, $01) - (6688.0 * roomscale)), (entityz(local10\Field1\Field2, $01) - (1252.0 * roomscale)))) Then
                                        local10\Field1\Field22[$08]\Field9 = 10.0
                                        local10\Field1\Field22[$09]\Field9 = 1.0
                                        local10\Field1\Field22[$0A]\Field9 = 10.0
                                        local10\Field1\Field22[$0B]\Field9 = 1.0
                                    EndIf
                                ElseIf (entityx(local10\Field1\Field22[$08]\Field4, $00) < (entityx(local10\Field1\Field2, $01) - (7100.0 * roomscale))) Then
                                    For local1 = $08 To $0A Step $01
                                        local10\Field1\Field22[local1]\Field9 = 0.0
                                        If (local10\Field1\Field22[local1] <> Null) Then
                                            removenpc(local10\Field1\Field22[local1])
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                            If (local10\Field1\Field22[$0B] <> Null) Then
                                If (entityx(local10\Field1\Field22[$0B]\Field4, $00) > (entityx(local10\Field1\Field2, $01) - (1200.0 * roomscale))) Then
                                    local10\Field1\Field22[$0B]\Field9 = 0.0
                                    removenpc(local10\Field1\Field22[$0B])
                                EndIf
                            EndIf
                            local10\Field1\Field22[$05]\Field17 = loopsound2(local10\Field1\Field22[$05]\Field16, local10\Field1\Field22[$05]\Field17, camera, local10\Field1\Field22[$05]\Field0, 2.0, 0.5)
                            If (((local10\Field15 <> "") And (local10\Field15 <> "done")) <> 0) Then
                                If (local10\Field6 = $00) Then
                                    local10\Field6 = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\Intro\PA\On.ogg")))
                                EndIf
                                If (channelplaying(local10\Field6) = $00) Then
                                    local4 = left(local10\Field15, (instr(local10\Field15, "|", $01) - $01))
                                    local10\Field6 = playsound_strict(loadtempsound(scpmodding_processfilepath(("SFX\Room\Intro\PA\" + local4))))
                                    local10\Field15 = right(local10\Field15, ((len(local10\Field15) - len(local4)) - $01))
                                    If (local10\Field15 = "") Then
                                        freesound_strict(local10\Field1\Field22[$03]\Field16)
                                        local2 = rand($01, $05)
                                        local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Conversation" + (Str local2)) + "a.ogg")))
                                        local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                        local10\Field1\Field22[$04]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Conversation" + (Str local2)) + "b.ogg")))
                                        local10\Field1\Field22[$04]\Field17 = playsound2(local10\Field1\Field22[$04]\Field16, camera, local10\Field1\Field22[$04]\Field4, 10.0, 1.0)
                                        local10\Field15 = "done"
                                    EndIf
                                EndIf
                            EndIf
                            local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field22[$03]\Field4, $00), entityz(local10\Field1\Field22[$03]\Field4, $00))
                            If (3.0 > local0) Then
                                local10\Field1\Field22[$03]\Field11 = min(max((local10\Field1\Field22[$03]\Field11 - local23\Field3[$00]), 0.0), 50.0)
                            Else
                                local10\Field1\Field22[$03]\Field11 = max((local10\Field1\Field22[$03]\Field11 + local23\Field3[$00]), 50.0)
                                If ((((560.0 <= local10\Field1\Field22[$03]\Field11) And (560.0 > (local10\Field1\Field22[$03]\Field11 - local23\Field3[$00]))) And (7.0 = local10\Field1\Field22[$03]\Field9)) <> 0) Then
                                    If (local10\Field1\Field22[$04]\Field17 <> $00) Then
                                        If (channelplaying(local10\Field1\Field22[$04]\Field17) <> 0) Then
                                            stopchannel(local10\Field1\Field22[$04]\Field17)
                                        EndIf
                                    EndIf
                                    If (2.0 > local10\Field1\Field22[$03]\Field10) Then
                                        freesound_strict(local10\Field1\Field22[$03]\Field16)
                                        local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Ulgrin\EscortRefuse" + (Str rand($01, $02))) + ".ogg")))
                                        local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                        local10\Field1\Field22[$03]\Field11 = 50.0
                                        local10\Field1\Field22[$03]\Field10 = 3.0
                                    ElseIf (3.0 = local10\Field1\Field22[$03]\Field10) Then
                                        freesound_strict(local10\Field1\Field22[$03]\Field16)
                                        local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Ulgrin\EscortPissedOff" + (Str rand($01, $02))) + ".ogg")))
                                        local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                        local10\Field1\Field22[$03]\Field11 = 50.0
                                        local10\Field1\Field22[$03]\Field10 = 4.0
                                    ElseIf (4.0 = local10\Field1\Field22[$03]\Field10) Then
                                        freesound_strict(local10\Field1\Field22[$03]\Field16)
                                        local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Ulgrin\EscortKill" + (Str rand($01, $02))) + ".ogg")))
                                        local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                        local10\Field1\Field22[$03]\Field11 = 225.0
                                        local10\Field1\Field22[$03]\Field10 = 5.0
                                    ElseIf (5.0 = local10\Field1\Field22[$03]\Field10) Then
                                        local10\Field1\Field22[$03]\Field9 = 11.0
                                        local10\Field1\Field22[$04]\Field9 = 11.0
                                        local10\Field1\Field22[$05]\Field9 = 11.0
                                        local10\Field1\Field22[$03]\Field11 = 1.0
                                        local10\Field1\Field22[$04]\Field11 = 1.0
                                        local10\Field1\Field22[$05]\Field11 = 1.0
                                    EndIf
                                EndIf
                                If (11.0 <> local10\Field1\Field22[$05]\Field9) Then
                                    If (((5.0 < entitydistance(local10\Field1\Field22[$03]\Field4, local10\Field1\Field22[$05]\Field4)) And (Int entitydistance(local10\Field1\Field22[$04]\Field4, local10\Field1\Field22[$05]\Field4))) <> 0) Then
                                        If (3.5 > entitydistance(local10\Field1\Field22[$05]\Field4, collider)) Then
                                            local10\Field1\Field22[$05]\Field9 = 11.0
                                            local10\Field1\Field22[$05]\Field11 = 1.0
                                            local10\Field1\Field22[$05]\Field20 = playsound2(local10\Field1\Field22[$05]\Field19, camera, local10\Field1\Field22[$05]\Field4, 10.0, 1.0)
                                            local10\Field1\Field22[$05]\Field25 = 210.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If (11.0 = local10\Field1\Field22[$05]\Field9) Then
                                updatesoundorigin(local10\Field1\Field22[$05]\Field20, camera, local10\Field1\Field22[$05]\Field4, 10.0, 1.0)
                            EndIf
                            If (11.0 <> local10\Field1\Field22[$03]\Field9) Then
                                If (local0 < min(max((4.0 - (local10\Field1\Field22[$03]\Field11 * 0.05)), 1.5), 4.0)) Then
                                    If (local10\Field1\Field22[$03]\Field37 <> $01) Then
                                        local10\Field1\Field22[$03]\Field9 = 7.0
                                        pointentity(local10\Field1\Field22[$03]\Field0, collider, 0.0)
                                        rotateentity(local10\Field1\Field22[$03]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field22[$03]\Field0, $00), entityyaw(local10\Field1\Field22[$03]\Field4, $00), 20.0), 0.0, $01)
                                        If (local10\Field1\Field22[$03]\Field37 = $02) Then
                                            local10\Field1\Field22[$03]\Field37 = findpath(local10\Field1\Field22[$03], (playerroom\Field3 - (320.0 * roomscale)), 0.3, (playerroom\Field5 - (704.0 * roomscale)))
                                            local10\Field1\Field22[$04]\Field37 = findpath(local10\Field1\Field22[$04], (playerroom\Field3 - (320.0 * roomscale)), 0.3, (playerroom\Field5 - (704.0 * roomscale)))
                                            local10\Field1\Field22[$03]\Field9 = 3.0
                                        EndIf
                                    Else
                                        local10\Field1\Field22[$03]\Field9 = 3.0
                                    EndIf
                                Else
                                    local10\Field1\Field22[$03]\Field9 = 7.0
                                    pointentity(local10\Field1\Field22[$03]\Field0, collider, 0.0)
                                    rotateentity(local10\Field1\Field22[$03]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field22[$03]\Field0, $00), entityyaw(local10\Field1\Field22[$03]\Field4, $00), 20.0), 0.0, $01)
                                    If (5.5 < local0) Then
                                        local10\Field1\Field22[$03]\Field37 = $02
                                        If (0.0 = local10\Field1\Field22[$03]\Field10) Then
                                            freesound_strict(local10\Field1\Field22[$03]\Field16)
                                            local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Guard\Ulgrin\EscortRun.ogg"))
                                            local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                            playsound2(local10\Field9, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                            local10\Field1\Field22[$03]\Field10 = 1.0
                                        EndIf
                                        local10\Field1\Field22[$03]\Field9 = 5.0
                                        local10\Field1\Field22[$03]\Field33 = entityx(collider, $00)
                                        local10\Field1\Field22[$03]\Field34 = entityy(collider, $00)
                                        local10\Field1\Field22[$03]\Field35 = entityz(collider, $00)
                                    EndIf
                                EndIf
                                local0 = entitydistance(collider, local10\Field1\Field22[$04]\Field4)
                                If (((1.5 < local0) And (entitydistance(local10\Field1\Field22[$03]\Field4, collider) < entitydistance(local10\Field1\Field22[$03]\Field4, local10\Field1\Field22[$04]\Field4))) <> 0) Then
                                    local10\Field1\Field22[$04]\Field9 = 3.0
                                Else
                                    local10\Field1\Field22[$04]\Field9 = 5.0
                                    local10\Field1\Field22[$04]\Field33 = entityx(collider, $00)
                                    local10\Field1\Field22[$04]\Field34 = entityy(collider, $00)
                                    local10\Field1\Field22[$04]\Field35 = entityz(collider, $00)
                                EndIf
                            EndIf
                            local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field21[$02]\Field2, $01), entityz(local10\Field1\Field21[$02]\Field2, $01))
                            If (((4.5 > distance(entityx(local10\Field1\Field22[$03]\Field4, $00), entityz(local10\Field1\Field22[$03]\Field4, $00), entityx(local10\Field1\Field21[$02]\Field2, $01), entityz(local10\Field1\Field21[$02]\Field2, $01))) And (5.0 > local0)) <> 0) Then
                                local10\Field1\Field22[$00] = createnpc($13, entityx(local10\Field1\Field19[$00], $01), entityy(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01))
                                local10\Field1\Field22[$00]\Field15 = 180.0
                                local10\Field1\Field22[$01] = createnpc($12, entityx(local10\Field1\Field19[$01], $01), 0.5, entityz(local10\Field1\Field19[$01], $01))
                                pointentity(local10\Field1\Field22[$01]\Field4, local10\Field1\Field19[$05], 0.0)
                                local10\Field1\Field22[$02] = createnpc($12, entityx(local10\Field1\Field19[$02], $01), 0.5, entityz(local10\Field1\Field19[$02], $01))
                                pointentity(local10\Field1\Field22[$02]\Field4, local10\Field1\Field19[$05], 0.0)
                                changenpctextureid(local10\Field1\Field22[$02], $05)
                                local10\Field1\Field22[$03]\Field9 = 9.0
                                If (local10\Field1\Field22[$07]\Field17 <> $00) Then
                                    If (channelplaying(local10\Field1\Field22[$07]\Field17) <> 0) Then
                                        stopchannel(local10\Field1\Field22[$07]\Field17)
                                        freesound_strict(local10\Field1\Field22[$07]\Field16)
                                        local10\Field1\Field22[$07]\Field16 = $00
                                    EndIf
                                EndIf
                                freeentity(local10\Field1\Field19[$09])
                                local10\Field1\Field19[$09] = $00
                                freeentity(local10\Field1\Field19[$0A])
                                local10\Field1\Field19[$0A] = $00
                                If (local10\Field1\Field22[$05] <> Null) Then
                                    removenpc(local10\Field1\Field22[$05])
                                EndIf
                                freesound_strict(local10\Field1\Field22[$03]\Field16)
                                local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Ulgrin\EscortDone" + (Str rand($01, $05))) + ".ogg")))
                                local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                positionentity(local10\Field1\Field22[$06]\Field4, (entityx(local10\Field1\Field2, $01) - (1190.0 * roomscale)), (450.0 * roomscale), (entityz(local10\Field1\Field2, $01) + (456.0 * roomscale)), $01)
                                resetentity(local10\Field1\Field22[$06]\Field4)
                                pointentity(local10\Field1\Field22[$06]\Field4, local10\Field1\Field2, 0.0)
                                local10\Field1\Field22[$06]\Field22 = 0.0
                                local10\Field1\Field22[$06]\Field9 = 0.0
                                local10\Field4 = 905.0
                                local10\Field1\Field21[$03]\Field4 = $00
                                usedoor(local10\Field1\Field21[$03], $00, $01)
                                local10\Field1\Field21[$03]\Field4 = $01
                                local10\Field1\Field22[$04]\Field9 = 9.0
                            EndIf
                        ElseIf (905.0 >= local10\Field4) Then
                            If (((channelplaying(local10\Field1\Field22[$03]\Field17) = $00) And (358.0 > local10\Field1\Field22[$03]\Field14)) <> 0) Then
                                local10\Field1\Field22[$03]\Field9 = 8.0
                                freesound_strict(local10\Field1\Field22[$03]\Field16)
                                local10\Field1\Field22[$03]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Guard\Ulgrin\OhAndByTheWay.ogg"))
                                local10\Field1\Field22[$03]\Field17 = playsound2(local10\Field1\Field22[$03]\Field16, camera, local10\Field1\Field22[$03]\Field4, 10.0, 1.0)
                                setnpcframe(local10\Field1\Field22[$03], 358.0)
                            ElseIf (358.0 <= local10\Field1\Field22[$03]\Field14) Then
                                pointentity(local10\Field1\Field22[$03]\Field4, collider, 0.0)
                                rotateentity(local10\Field1\Field22[$03]\Field4, 0.0, entityyaw(local10\Field1\Field22[$03]\Field4, $00), 0.0, $00)
                                If (481.5 >= local10\Field1\Field22[$03]\Field14) Then
                                    local27 = local10\Field1\Field22[$03]\Field14
                                    animatenpc(local10\Field1\Field22[$03], 358.0, 482.0, 0.4, $00)
                                Else
                                    animatenpc(local10\Field1\Field22[$03], 483.0, 607.0, 0.2, $01)
                                    If (1.5 > entitydistance(collider, local10\Field1\Field22[$03]\Field4)) Then
                                        If (entityinview(local10\Field1\Field22[$03]\Field0, camera) <> 0) Then
                                            drawhandicon = $01
                                            If (mousehit1 <> 0) Then
                                                selecteditem = createitem("Document SCP-173", "paper", 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                                entitytype(selecteditem\Field1, $03, $00)
                                                pickitem(selecteditem)
                                                local10\Field1\Field21[$02]\Field4 = $00
                                                usedoor(local10\Field1\Field21[$02], $00, $01)
                                                local10\Field1\Field21[$02]\Field4 = $01
                                                local10\Field4 = 910.0
                                                setnpcframe(local10\Field1\Field22[$03], 608.0)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf (((620.5 >= local10\Field1\Field22[$03]\Field14) And (8.0 = local10\Field1\Field22[$03]\Field9)) <> 0) Then
                            animatenpc(local10\Field1\Field22[$03], 608.0, 621.0, 0.4, $00)
                        Else
                            local10\Field1\Field22[$03]\Field15 = entityyaw(local10\Field1\Field22[$03]\Field4, $00)
                            local10\Field1\Field22[$03]\Field9 = 9.0
                            local10\Field1\Field22[$04]\Field9 = 9.0
                            If (4.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))) Then
                                local10\Field1\Field21[$02]\Field4 = $00
                                usedoor(local10\Field1\Field21[$02], $00, $01)
                                local10\Field1\Field21[$02]\Field4 = $01
                                local10\Field4 = 0.0
                                local10\Field1\Field22[$03]\Field9 = 0.0
                                local10\Field1\Field22[$04]\Field9 = 0.0
                                usedoor(local10\Field1\Field21[$01], $00, $01)
                            EndIf
                        EndIf
                        If (local10\Field1\Field22[$07] <> Null) Then
                            rotateentity(local10\Field1\Field22[$07]\Field4, 0.0, ((sin((Float (millisecs2() / $14))) * 3.0) + 180.0), 0.0, $01)
                            positionentity(local10\Field1\Field22[$07]\Field4, (entityx(local10\Field1\Field2, $01) - (3361.0 * roomscale)), (-315.0 * roomscale), (entityz(local10\Field1\Field2, $01) - (2165.0 * roomscale)), $00)
                            resetentity(local10\Field1\Field22[$07]\Field4)
                            local10\Field1\Field22[$07]\Field9 = 6.0
                            setnpcframe(local10\Field1\Field22[$07], 182.0)
                            If (((1.0 = local10\Field1\Field22[$06]\Field9) And (local10\Field1\Field22[$07]\Field16 <> $00)) <> 0) Then
                                If (local10\Field1\Field22[$07]\Field17 <> $00) Then
                                    If (channelplaying(local10\Field1\Field22[$07]\Field17) = $00) Then
                                        freesound_strict(local10\Field1\Field22[$07]\Field16)
                                        local10\Field1\Field22[$07]\Field16 = $00
                                    EndIf
                                EndIf
                                If (local10\Field1\Field22[$07]\Field16 <> $00) Then
                                    local10\Field1\Field22[$07]\Field17 = loopsound2(local10\Field1\Field22[$07]\Field16, local10\Field1\Field22[$07]\Field17, camera, local10\Field1\Field22[$07]\Field4, 7.0, 1.0)
                                EndIf
                            EndIf
                        EndIf
                        For local1 = $03 To $04 Step $01
                            If (local10\Field1\Field22[local1]\Field16 <> $00) Then
                                If (channelplaying(local10\Field1\Field22[local1]\Field17) = $00) Then
                                    freesound_strict(local10\Field1\Field22[local1]\Field16)
                                    local10\Field1\Field22[local1]\Field16 = $00
                                Else
                                    local10\Field1\Field22[local1]\Field17 = loopsound2(local10\Field1\Field22[local1]\Field16, local10\Field1\Field22[local1]\Field17, camera, local10\Field1\Field22[local1]\Field4, 10.0, 1.0)
                                EndIf
                            EndIf
                        Next
                    Else
                        If (introsfx($12) <> $00) Then
                            local10\Field7 = loopsound2(introsfx($12), local10\Field7, camera, local10\Field1\Field19[$04], 6.0, 1.0)
                        EndIf
                        If (0.0 = local10\Field2) Then
                            If (playerroom = local10\Field1) Then
                                introsfx($00) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Scientist\Franklin\EnterChamber.ogg"))
                                introsfx($01) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Scientist\Franklin\Approach173.ogg"))
                                introsfx($02) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Scientist\Franklin\Problem.ogg"))
                                For local1 = $04 To $06 Step $01
                                    introsfx(local1) = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Scientist\Franklin\Refuse" + (Str (local1 - $03))) + ".ogg")))
                                Next
                                introsfx($10) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Horror.ogg"))
                                introsfx($11) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\See173.ogg"))
                                introsfx($12) = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\173Chamber.ogg"))
                                For local1 = $13 To $14 Step $01
                                    introsfx(local1) = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Ew" + (Str (local1 - $12))) + ".ogg")))
                                Next
                                curr173\Field24 = 1.0
                                local10\Field1\Field22[$03] = createnpc($13, ((local10\Field1\Field3 - (4096.0 * roomscale)) + rnd(-0.3, 0.3)), 0.3, (local10\Field1\Field5 + ((Float rand($35C, $380)) * roomscale)))
                                rotateentity(local10\Field1\Field22[$03]\Field4, 0.0, (Float (local10\Field1\Field6 + $B4)), 0.0, $00)
                                local10\Field1\Field22[$03]\Field9 = 7.0
                                local10\Field1\Field22[$04] = createnpc($13, (local10\Field1\Field3 - (3840.0 * roomscale)), 0.3, (local10\Field1\Field5 + (768.0 * roomscale)))
                                rotateentity(local10\Field1\Field22[$04]\Field4, 0.0, (Float (local10\Field1\Field6 + $87)), 0.0, $00)
                                local10\Field1\Field22[$04]\Field9 = 7.0
                                local10\Field1\Field22[$05] = createnpc($13, (local10\Field1\Field3 - (8288.0 * roomscale)), 0.3, (local10\Field1\Field5 + (1096.0 * roomscale)))
                                local10\Field1\Field22[$05]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Music" + (Str rand($01, $05))) + ".ogg")))
                                rotateentity(local10\Field1\Field22[$05]\Field4, 0.0, (Float (local10\Field1\Field6 + $B4)), 0.0, $01)
                                local10\Field1\Field22[$05]\Field75 = $01
                                local10\Field1\Field22[$05]\Field9 = 7.0
                                local10\Field1\Field22[$05]\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Guard\PlayerEscape.ogg"))
                                local10\Field1\Field22[$06] = createnpc($12, (local10\Field1\Field3 - (3712.0 * roomscale)), -0.3, (local10\Field1\Field5 - (2208.0 * roomscale)))
                                changenpctextureid(local10\Field1\Field22[$06], $03)
                                local10\Field1\Field22[$07] = createnpc($12, (local10\Field1\Field3 - (3712.0 * roomscale)), -0.3, (local10\Field1\Field5 - (2208.0 * roomscale)))
                                local10\Field1\Field22[$07]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Scientist\Conversation.ogg"))
                                changenpctextureid(local10\Field1\Field22[$07], $02)
                                local3 = createpivot($00)
                                rotateentity(local3, 90.0, 0.0, 0.0, $00)
                                local10\Field1\Field22[$08] = createnpc($13, (local10\Field1\Field3 - (3800.0 * roomscale)), 1.0, (local10\Field1\Field5 - (3900.0 * roomscale)))
                                local10\Field1\Field22[$08]\Field9 = 7.0
                                local10\Field1\Field22[$09] = createnpc($12, (local10\Field1\Field3 - (4000.0 * roomscale)), 1.1, (local10\Field1\Field5 - (3900.0 * roomscale)))
                                local10\Field1\Field22[$09]\Field10 = 1.0
                                changenpctextureid(local10\Field1\Field22[$09], $0A)
                                local10\Field1\Field22[$0A] = createnpc($13, (local10\Field1\Field3 - (4200.0 * roomscale)), 1.0, (local10\Field1\Field5 - (3900.0 * roomscale)))
                                local10\Field1\Field22[$0A]\Field9 = 7.0
                                local10\Field1\Field22[$0B] = createnpc($1D, entityx(local10\Field1\Field19[$0B], $01), entityy(local10\Field1\Field19[$0B], $01), entityz(local10\Field1\Field19[$0B], $01))
                                local10\Field1\Field22[$0B]\Field9 = 0.0
                                For local1 = $08 To $0B Step $01
                                    positionentity(local3, entityx(local10\Field1\Field22[local1]\Field4, $00), entityy(local10\Field1\Field22[local1]\Field4, $00), entityz(local10\Field1\Field22[local1]\Field4, $00), $00)
                                    entitypick(local3, 20.0)
                                    If (pickedentity() <> $00) Then
                                        positionentity(local10\Field1\Field22[local1]\Field4, pickedx(), pickedy(), pickedz(), $01)
                                        aligntovector(local10\Field1\Field22[local1]\Field4, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                                        rotateentity(local10\Field1\Field22[$08]\Field4, 0.0, 90.0, 0.0, $00)
                                        rotateentity(local10\Field1\Field22[$09]\Field4, 0.0, 90.0, 0.0, $00)
                                        rotateentity(local10\Field1\Field22[$0A]\Field4, 0.0, 90.0, 0.0, $00)
                                        rotateentity(local10\Field1\Field22[$0B]\Field4, 0.0, -90.0, 0.0, $00)
                                    EndIf
                                Next
                                freeentity(local3)
                                positionentity(curr173\Field4, entityx(local10\Field1\Field19[$05], $01), 0.5, entityz(local10\Field1\Field19[$05], $01), $00)
                                resetentity(curr173\Field4)
                                positionentity(collider, (playerroom\Field3 - (4096.0 * roomscale)), 0.3, (playerroom\Field5 + (192.0 * roomscale)), $00)
                                resetentity(collider)
                                local10\Field2 = 1.0
                                local10\Field4 = 1.0
                            EndIf
                        ElseIf (10000.0 > local10\Field2) Then
                            If (local10\Field1\Field22[$06]\Field17 <> $00) Then
                                If (channelplaying(local10\Field1\Field22[$06]\Field17) <> 0) Then
                                    local10\Field1\Field22[$06]\Field9 = 6.0
                                    If (325.0 <= animtime(local10\Field1\Field22[$06]\Field0)) Then
                                        animate2(local10\Field1\Field22[$06]\Field0, animtime(local10\Field1\Field22[$06]\Field0), $146, $148, 0.02, $00)
                                    Else
                                        animate2(local10\Field1\Field22[$06]\Field0, animtime(local10\Field1\Field22[$06]\Field0), $140, $148, 0.05, $00)
                                    EndIf
                                Else
                                    animate2(local10\Field1\Field22[$06]\Field0, animtime(local10\Field1\Field22[$06]\Field0), $148, $140, -0.02, $00)
                                EndIf
                            EndIf
                            If (introsfx($11) <> $00) Then
                                If (entityvisible(curr173\Field4, collider) <> 0) Then
                                    If (entityinview(curr173\Field0, camera) <> 0) Then
                                        msg = ((((scplang_getphrase("events.press") + " ") + keyname(key_blink)) + " ") + scplang_getphrase("events.room173introblink"))
                                        msgtimer = 280.0
                                        playsound_strict(introsfx($11))
                                        introsfx($11) = $00
                                    EndIf
                                EndIf
                            EndIf
                            local10\Field2 = min((local10\Field2 + (local23\Field3[$00] / 3.0)), 5000.0)
                            If (((130.0 <= local10\Field2) And (130.0 > (local10\Field2 - (local23\Field3[$00] / 3.0)))) <> 0) Then
                                local10\Field1\Field22[$06]\Field17 = playsound_strict(introsfx($00))
                            ElseIf (230.0 < local10\Field2) Then
                                local2 = $01
                                For local1 = $01 To $02 Step $01
                                    If (0.3 < distance(entityx(local10\Field1\Field22[local1]\Field4, $00), entityz(local10\Field1\Field22[local1]\Field4, $00), entityx(local10\Field1\Field19[(local1 + $02)], $01), entityz(local10\Field1\Field19[(local1 + $02)], $01))) Then
                                        pointentity(local10\Field1\Field22[local1]\Field0, local10\Field1\Field19[(local1 + $02)], 0.0)
                                        rotateentity(local10\Field1\Field22[local1]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field22[local1]\Field0, $00), entityyaw(local10\Field1\Field22[local1]\Field4, $00), 15.0), 0.0, $00)
                                        If ((Float ((local1 * $1E) + $C8)) < local10\Field2) Then
                                            local10\Field1\Field22[local1]\Field9 = 1.0
                                        EndIf
                                        local2 = $00
                                    Else
                                        local10\Field1\Field22[local1]\Field9 = 0.0
                                        pointentity(local10\Field1\Field22[local1]\Field0, local10\Field1\Field19[$05], 0.0)
                                        rotateentity(local10\Field1\Field22[local1]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field22[local1]\Field0, $00), entityyaw(local10\Field1\Field22[local1]\Field4, $00), 15.0), 0.0, $00)
                                    EndIf
                                Next
                                If (entityx(collider, $00) < (entityx(local10\Field1\Field2, $00) + (408.0 * roomscale))) Then
                                    If (((450.0 <= local10\Field2) And (450.0 > (local10\Field2 - (local23\Field3[$00] / 3.0)))) <> 0) Then
                                        local10\Field1\Field22[$06]\Field17 = playsound_strict(introsfx($04))
                                    ElseIf (((650.0 <= local10\Field2) And (650.0 > (local10\Field2 - (local23\Field3[$00] / 3.0)))) <> 0) Then
                                        local10\Field1\Field22[$06]\Field17 = playsound_strict(introsfx($05))
                                    ElseIf (((850.0 <= local10\Field2) And (850.0 > (local10\Field2 - (local23\Field3[$00] / 3.0)))) <> 0) Then
                                        usedoor(local10\Field1\Field21[$01], $00, $01)
                                        local10\Field1\Field22[$06]\Field17 = playsound_strict(introsfx($06))
                                    ElseIf (1000.0 < local10\Field2) Then
                                        local10\Field1\Field22[$00]\Field9 = 1.0
                                        local10\Field1\Field22[$00]\Field10 = 10.0
                                        local10\Field1\Field22[$00]\Field11 = 1.0
                                        local10\Field1\Field22[$03]\Field9 = 11.0
                                        local10\Field1\Field21[$02]\Field4 = $00
                                        usedoor(local10\Field1\Field21[$02], $00, $01)
                                        local10\Field1\Field21[$02]\Field4 = $01
                                        local10\Field3 = 1.0
                                        Exit
                                    EndIf
                                    If (850.0 < local10\Field2) Then
                                        positionentity(collider, min(entityx(collider, $00), (entityx(local10\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                                    EndIf
                                ElseIf (local2 = $01) Then
                                    local10\Field2 = 10000.0
                                    usedoor(local10\Field1\Field21[$01], $00, $01)
                                EndIf
                            EndIf
                            local10\Field1\Field22[$06]\Field9 = 7.0
                            pointentity(local10\Field1\Field22[$06]\Field0, collider, 0.0)
                            rotateentity(local10\Field1\Field22[$06]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field22[$06]\Field0, $00), entityyaw(local10\Field1\Field22[$06]\Field4, $00), 20.0), 0.0, $01)
                            positionentity(curr173\Field4, entityx(local10\Field1\Field19[$05], $01), entityy(curr173\Field4, $00), entityz(local10\Field1\Field19[$05], $01), $00)
                            rotateentity(curr173\Field4, 0.0, 0.0, 0.0, $01)
                            resetentity(curr173\Field4)
                        ElseIf (14000.0 > local10\Field2) Then
                            local10\Field2 = min((local10\Field2 + local23\Field3[$00]), 13000.0)
                            If (10300.0 > local10\Field2) Then
                                positionentity(collider, max(entityx(collider, $00), (entityx(local10\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                            EndIf
                            local10\Field1\Field22[$06]\Field9 = 6.0
                            pointentity(local10\Field1\Field22[$06]\Field0, curr173\Field4, 0.0)
                            rotateentity(local10\Field1\Field22[$06]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field22[$06]\Field0, $00), entityyaw(local10\Field1\Field22[$06]\Field4, $00), 50.0), 0.0, $01)
                            If (((10300.0 <= local10\Field2) And (10300.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                local10\Field6 = playsound_strict(introsfx($01))
                                positionentity(collider, max(entityx(collider, $00), (entityx(local10\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                            ElseIf (((10440.0 <= local10\Field2) And (10440.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                usedoor(local10\Field1\Field21[$01], $00, $01)
                                local10\Field6 = playsound_strict(introsfx($07))
                            ElseIf (((10740.0 <= local10\Field2) And (10740.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                local10\Field6 = playsound_strict(introsfx($02))
                            ElseIf (((11145.0 <= local10\Field2) And (11145.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                local10\Field6 = playsound_strict(introsfx($0A))
                                local10\Field1\Field22[$01]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\ClassD\DontLikeThis.ogg"))
                                playsound2(local10\Field1\Field22[$01]\Field16, camera, local10\Field1\Field22[$02]\Field4, 10.0, 1.0)
                            ElseIf (((11561.0 <= local10\Field2) And (11561.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                local10\Field2 = 14000.0
                                playsound_strict(introsfx($10))
                                local10\Field1\Field22[$02]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\ClassD\Breen.ogg"))
                                playsound2(local10\Field1\Field22[$02]\Field16, camera, local10\Field1\Field22[$01]\Field4, 10.0, 1.0)
                            EndIf
                            If (((10440.0 <= local10\Field2) And (11561.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                If (entityx(local10\Field1\Field21[$01]\Field2, $01) > entityx(collider, $00)) Then
                                    If (12.0 <> local10\Field1\Field22[$00]\Field9) Then
                                        local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Balcony\Alert" + (Str rand($01, $02))) + ".ogg")))
                                        local10\Field1\Field22[$00]\Field17 = playsound2(local10\Field1\Field22[$00]\Field16, camera, local10\Field1\Field22[$00]\Field4, 20.0, 1.0)
                                        local10\Field1\Field22[$00]\Field9 = 12.0
                                        local10\Field1\Field22[$00]\Field10 = 1.0
                                    EndIf
                                EndIf
                            EndIf
                            If (10300.0 < local10\Field2) Then
                                If (10560.0 < local10\Field2) Then
                                    If (10750.0 > local10\Field2) Then
                                        local10\Field1\Field22[$01]\Field9 = 1.0
                                        local10\Field1\Field22[$01]\Field22 = 0.005
                                    Else
                                        local10\Field1\Field22[$01]\Field9 = 0.0
                                        local10\Field1\Field22[$01]\Field22 = curvevalue(0.0, local10\Field1\Field22[$01]\Field22, 10.0)
                                    EndIf
                                EndIf
                                If (325.0 <= animtime(local10\Field1\Field22[$06]\Field0)) Then
                                    animate2(local10\Field1\Field22[$06]\Field0, animtime(local10\Field1\Field22[$06]\Field0), $146, $148, 0.02, $00)
                                Else
                                    animate2(local10\Field1\Field22[$06]\Field0, animtime(local10\Field1\Field22[$06]\Field0), $140, $148, 0.05, $00)
                                EndIf
                            EndIf
                            positionentity(curr173\Field4, entityx(local10\Field1\Field19[$05], $01), entityy(curr173\Field4, $00), entityz(local10\Field1\Field19[$05], $01), $00)
                            rotateentity(curr173\Field4, 0.0, 0.0, 0.0, $01)
                            resetentity(curr173\Field4)
                        ElseIf (20000.0 > local10\Field2) Then
                            local3 = createpivot($00)
                            positionentity(local3, entityx(camera, $00), (entityy(curr173\Field4, $01) - 0.05), entityz(camera, $00), $00)
                            pointentity(local3, curr173\Field4, 0.0)
                            rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local3, $00), entityyaw(collider, $00), 40.0), 0.0, $00)
                            turnentity(local3, 90.0, 0.0, 0.0, $00)
                            user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), 40.0)
                            user_camera_pitch = (user_camera_pitch - 90.0)
                            freeentity(local3)
                            local10\Field1\Field22[$06]\Field9 = 6.0
                            pointentity(local10\Field1\Field22[$06]\Field0, curr173\Field4, 0.0)
                            rotateentity(local10\Field1\Field22[$06]\Field4, 0.0, curvevalue(entityyaw(local10\Field1\Field22[$06]\Field0, $00), entityyaw(local10\Field1\Field22[$06]\Field4, $00), 20.0), 0.0, $01)
                            animate2(local10\Field1\Field22[$06]\Field0, animtime(local10\Field1\Field22[$06]\Field0), $165, $17D, 0.05, $01)
                            local10\Field2 = min((local10\Field2 + local23\Field3[$00]), 19000.0)
                            If (14100.0 > local10\Field2) Then
                                If (14060.0 > local10\Field2) Then
                                    blinktimer = max((((14000.0 - local10\Field2) / 2.0) - rnd(0.0, 1.0)), -10.0)
                                    If (-10.0 = blinktimer) Then
                                        pointentity(curr173\Field4, local10\Field1\Field22[$01]\Field0, 0.0)
                                        rotateentity(curr173\Field4, 0.0, entityyaw(curr173\Field4, $00), 0.0, $00)
                                        moveentity(curr173\Field4, 0.0, 0.0, ((curr173\Field21 * 0.6) * local23\Field3[$00]))
                                        curr173\Field17 = loopsound2(stonedragsfx, curr173\Field17, camera, curr173\Field4, 10.0, curr173\Field9)
                                        curr173\Field9 = curvevalue(1.0, curr173\Field9, 3.0)
                                    Else
                                        curr173\Field9 = max(0.0, (curr173\Field9 - (local23\Field3[$00] / 20.0)))
                                    EndIf
                                ElseIf (14065.0 > local10\Field2) Then
                                    blinktimer = -10.0
                                    If (0.0 = local10\Field1\Field22[$01]\Field9) Then
                                        playsound2(necksnapsfx(rand($00, $02)), camera, curr173\Field4, 10.0, 1.0)
                                    EndIf
                                    setanimtime(local10\Field1\Field22[$01]\Field0, 0.0, $00)
                                    local10\Field1\Field22[$01]\Field9 = 6.0
                                    positionentity(curr173\Field4, entityx(local10\Field1\Field22[$01]\Field0, $00), entityy(curr173\Field4, $00), entityz(local10\Field1\Field22[$01]\Field0, $00), $00)
                                    resetentity(curr173\Field4)
                                    pointentity(curr173\Field4, local10\Field1\Field22[$02]\Field4, 0.0)
                                    local10\Field1\Field22[$02]\Field9 = 3.0
                                    rotateentity(local10\Field1\Field22[$02]\Field4, 0.0, entityyaw(local10\Field1\Field22[$02]\Field4, $00), 0.0, $00)
                                    animate2(local10\Field1\Field22[$02]\Field0, animtime(local10\Field1\Field22[$02]\Field0), $196, $17E, -0.15, $01)
                                    moveentity(local10\Field1\Field22[$02]\Field4, 0.0, 0.0, (local23\Field3[$00] * -0.01))
                                    local10\Field1\Field22[$00]\Field9 = 12.0
                                    If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                        stopchannel(local10\Field1\Field22[$00]\Field17)
                                        freesound_strict(local10\Field1\Field22[$00]\Field16)
                                        local10\Field1\Field22[$00]\Field16 = $00
                                    EndIf
                                    local10\Field1\Field22[$00]\Field15 = 180.0
                                    local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\Intro\Guard\Balcony\WTF" + (Str rand($01, $02))) + ".ogg")))
                                    local10\Field1\Field22[$00]\Field17 = playsound2(local10\Field1\Field22[$00]\Field16, camera, local10\Field1\Field22[$00]\Field4, 20.0, 1.0)
                                    local10\Field1\Field22[$00]\Field10 = 0.0
                                Else
                                    animate2(local10\Field1\Field22[$01]\Field0, animtime(local10\Field1\Field22[$01]\Field0), $276, $2A4, 0.5, $00)
                                    If (675.0 <= animtime(local10\Field1\Field22[$01]\Field0)) Then
                                        setnpcframe(local10\Field1\Field22[$01], 676.0)
                                    EndIf
                                    If (local10\Field1\Field22[$02]\Field16 = $00) Then
                                        local10\Field1\Field22[$02]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\ClassD\Gasp.ogg"))
                                        playsound2(local10\Field1\Field22[$02]\Field16, camera, local10\Field1\Field22[$02]\Field4, 8.0, 1.0)
                                    EndIf
                                EndIf
                                If (((14080.0 < local10\Field2) And (14080.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                    playsound_strict(introsfx($0C))
                                EndIf
                                camerashake = 3.0
                            ElseIf (14200.0 > local10\Field2) Then
                                animate2(local10\Field1\Field22[$01]\Field0, animtime(local10\Field1\Field22[$01]\Field0), $276, $2A4, 0.5, $00)
                                If (675.0 <= animtime(local10\Field1\Field22[$01]\Field0)) Then
                                    setnpcframe(local10\Field1\Field22[$01], 676.0)
                                EndIf
                                local10\Field1\Field22[$00]\Field9 = 8.0
                                If (14105.0 < local10\Field2) Then
                                    If (6.0 <> local10\Field1\Field22[$02]\Field9) Then
                                        playsound2(necksnapsfx($01), camera, local10\Field1\Field22[$02]\Field4, 8.0, 1.0)
                                    EndIf
                                    local10\Field1\Field22[$02]\Field9 = 6.0
                                    positionentity(curr173\Field4, entityx(local10\Field1\Field22[$02]\Field0, $00), entityy(curr173\Field4, $00), entityz(local10\Field1\Field22[$02]\Field0, $00), $00)
                                    resetentity(curr173\Field4)
                                    pointentity(curr173\Field4, collider, 0.0)
                                EndIf
                                If (14130.0 > local10\Field2) Then
                                    setanimtime(local10\Field1\Field22[$02]\Field0, 591.0, $00)
                                    blinktimer = -10.0
                                    lightblink = 1.0
                                Else
                                    animate2(local10\Field1\Field22[$02]\Field0, animtime(local10\Field1\Field22[$02]\Field0), $22B, $275, 0.5, $00)
                                    If (628.0 <= animtime(local10\Field1\Field22[$02]\Field0)) Then
                                        setnpcframe(local10\Field1\Field22[$02], 629.0)
                                    EndIf
                                    curr173\Field24 = 0.0
                                EndIf
                                If (((14100.0 < local10\Field2) And (14100.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                    playsound_strict(introsfx($08))
                                EndIf
                                If (14150.0 > local10\Field2) Then
                                    camerashake = 5.0
                                EndIf
                            Else
                                animate2(local10\Field1\Field22[$02]\Field0, animtime(local10\Field1\Field22[$02]\Field0), $242, $275, 0.5, $00)
                                If (628.0 <= animtime(local10\Field1\Field22[$02]\Field0)) Then
                                    setnpcframe(local10\Field1\Field22[$02], 629.0)
                                EndIf
                                If (14300.0 < local10\Field2) Then
                                    If (((14600.0 < local10\Field2) And (14700.0 > local10\Field2)) <> 0) Then
                                        blinktimer = -10.0
                                        lightblink = 1.0
                                    EndIf
                                    If (entityx(collider, $00) < (entityx(local10\Field1\Field2, $00) + (448.0 * roomscale))) Then
                                        local10\Field2 = 20000.0
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf (30000.0 > local10\Field2) Then
                            local10\Field2 = min((local10\Field2 + local23\Field3[$00]), 30000.0)
                            If (20100.0 > local10\Field2) Then
                                camerashake = 2.0
                            ElseIf (20200.0 > local10\Field2) Then
                                If (((20105.0 < local10\Field2) And (20105.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                    playsound_strict(introsfx($09))
                                    positionentity(local10\Field1\Field22[$00]\Field4, (entityx(local10\Field1\Field2, $00) - (160.0 * roomscale)), (entityy(local10\Field1\Field22[$00]\Field4, $00) + 0.1), (entityz(local10\Field1\Field2, $00) + (1280.0 * roomscale)), $00)
                                    resetentity(local10\Field1\Field22[$00]\Field4)
                                    If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                        stopchannel(local10\Field1\Field22[$00]\Field17)
                                        freesound_strict(local10\Field1\Field22[$00]\Field16)
                                        local10\Field1\Field22[$00]\Field16 = $00
                                    EndIf
                                    local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Intro\Guard\Balcony\OhSh.ogg"))
                                    local10\Field1\Field22[$00]\Field17 = playsound2(local10\Field1\Field22[$00]\Field16, camera, local10\Field1\Field22[$00]\Field4, 20.0, 1.0)
                                EndIf
                                If (20105.0 < local10\Field2) Then
                                    curr173\Field24 = 1.0
                                    pointentity(local10\Field1\Field22[$00]\Field4, curr173\Field0, 0.0)
                                    positionentity(curr173\Field4, (entityx(local10\Field1\Field2, $00) - (608.0 * roomscale)), (entityy(local10\Field1\Field2, $00) + (480.0 * roomscale)), (entityz(local10\Field1\Field2, $00) + (1312.0 * roomscale)), $00)
                                    resetentity(curr173\Field4)
                                    pointentity(curr173\Field4, local10\Field1\Field22[$00]\Field4, 0.0)
                                EndIf
                                blinktimer = -10.0
                                lightblink = 1.0
                                camerashake = 3.0
                            ElseIf (20300.0 > local10\Field2) Then
                                pointentity(local10\Field1\Field22[$00]\Field4, curr173\Field4, 0.0)
                                moveentity(local10\Field1\Field22[$00]\Field4, 0.0, 0.0, -0.002)
                                local10\Field1\Field22[$00]\Field9 = 2.0
                                updatesoundorigin(local10\Field1\Field22[$00]\Field17, camera, local10\Field1\Field22[$00]\Field4, 20.0, 1.0)
                                If (((20260.0 < local10\Field2) And (20260.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                    playsound_strict(introsfx($0C))
                                EndIf
                            ElseIf (20300.0 > (local10\Field2 - local23\Field3[$00])) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                                camerashake = 3.0
                                playsound_strict(introsfx($0B))
                                playsound2(necksnapsfx($01), camera, local10\Field1\Field22[$00]\Field4, 8.0, 1.0)
                                curr173\Field24 = 0.0
                                local10\Field6 = playsound_strict(introsfx($0F))
                                positionentity(curr173\Field4, (entityx(playerroom\Field2, $00) - (400.0 * roomscale)), 100.0, (entityz(playerroom\Field2, $00) + (1072.0 * roomscale)), $00)
                                resetentity(curr173\Field4)
                                For local9 = Each rooms
                                    If (local9\Field7\Field10 = "room173") Then
                                        playerroom = local9
                                        local18 = (entityx(local9\Field2, $01) + (3712.0 * roomscale))
                                        local19 = (384.0 * roomscale)
                                        local20 = (entityz(local9\Field2, $01) + (1312.0 * roomscale))
                                        positionentity(collider, ((entityx(collider, $00) - entityx(local10\Field1\Field2, $00)) + local18), ((entityy(collider, $00) + local19) + 0.4), ((entityz(collider, $00) - entityz(local10\Field1\Field2, $00)) + local20), $00)
                                        dropspeed = 0.0
                                        resetentity(collider)
                                        For local1 = $00 To $02 Step $01
                                            positionentity(local10\Field1\Field22[local1]\Field4, ((entityx(local10\Field1\Field22[local1]\Field4, $00) - entityx(local10\Field1\Field2, $00)) + local18), ((entityy(local10\Field1\Field22[local1]\Field4, $00) + local19) + 0.4), ((entityz(local10\Field1\Field22[local1]\Field4, $00) - entityz(local10\Field1\Field2, $00)) + local20), $00)
                                            resetentity(local10\Field1\Field22[local1]\Field4)
                                        Next
                                        shouldplay = $00
                                        For local1 = $00 To $09 Step $01
                                            freesound_strict(introsfx(local1))
                                        Next
                                        For local1 = $10 To $12 Step $01
                                            freesound_strict(introsfx(local1))
                                        Next
                                        local9\Field22[$00] = local10\Field1\Field22[$00]
                                        local9\Field22[$00]\Field9 = 8.0
                                        For local28 = Each doors
                                            If (local28\Field13 = local10\Field1) Then
                                                removedoor(local28)
                                            EndIf
                                        Next
                                        For local29 = Each waypoints
                                            If (local29\Field2 = local10\Field1) Then
                                                freeentity(local29\Field0)
                                                Delete local29
                                            EndIf
                                        Next
                                        For local1 = $03 To $04 Step $01
                                            removenpc(local10\Field1\Field22[local1])
                                        Next
                                        local9\Field22[$01] = local10\Field1\Field22[$06]
                                        freeentity(local10\Field1\Field2)
                                        Delete local10\Field1
                                        For local15 = Each securitycams
                                            If (local15\Field19 = local10\Field1) Then
                                                Delete local15
                                            EndIf
                                        Next
                                        showentity(at\Field4[$00])
                                        ambientlight((Float brightness), (Float brightness), (Float brightness))
                                        camerafogrange(camera, camerafognear, camerafogfar)
                                        camerafogmode(camera, $01)
                                        local10\Field3 = 1.0
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        EndIf
                    EndIf
                Else
                    If (0.0 > killtimer) Then
                        If (1.0 = local10\Field1\Field22[$03]\Field9) Then
                            loadeventsound(local10, scpmodding_processfilepath("SFX\Room\Intro\Guard\Ulgrin\EscortTerminated.ogg"), $00)
                            playsound_strict(local10\Field9)
                        EndIf
                    EndIf
                    For local1 = $00 To $06 Step $01
                        If (introsfx(local1) <> $00) Then
                            freesound_strict(introsfx(local1))
                            introsfx(local1) = $00
                        EndIf
                    Next
                    freesound_strict(introsfx($10))
                    introsfx($10) = $00
                    local10\Field3 = 1.0
                EndIf
                If (playerroom = local10\Field1) Then
                    If (10.0 <= local10\Field2) Then
                        camerarange(camera, 0.05, 15.0)
                        If (local10\Field1\Field22[$07] <> Null) Then
                            removenpc(local10\Field1\Field22[$07])
                        EndIf
                    Else
                        camerarange(camera, 0.05, 40.0)
                    EndIf
                    camerafogmode(camera, $00)
                    ambientlight(140.0, 140.0, 140.0)
                    hideentity(at\Field4[$00])
                    lightvolume = 4.0
                    templightvolume = 4.0
                Else
                    removeevent(local10)
                EndIf
            Case "buttghost"
                If (playerroom = local10\Field1) Then
                    If (1.8 > entitydistance(collider, local10\Field1\Field19[$00])) Then
                        If (0.0 = local10\Field2) Then
                            giveachievement($11, $01)
                            local10\Field6 = playsound2(buttghostsfx, camera, local10\Field1\Field19[$00], 10.0, 1.0)
                            local10\Field2 = 1.0
                        ElseIf (channelplaying(local10\Field6) = $00) Then
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "checkpoint"
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field3) Then
                        If (local10\Field1\Field5 > entityz(collider, $00)) Then
                            If (playerzone = $01) Then
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ambient\ToZone2.ogg")))
                            Else
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ambient\ToZone3.ogg")))
                            EndIf
                            local10\Field3 = 1.0
                        EndIf
                    EndIf
                    If (0.0 = local10\Field4) Then
                        If (rand($02, $01) = $01) Then
                            giveachievement($19, $01)
                            local10\Field1\Field19[$01] = copyentity(local22\Field0[$1C], $00)
                            scaleentity(local10\Field1\Field19[$01], 0.05, 0.05, 0.05, $00)
                            positionentity(local10\Field1\Field19[$01], entityx(local10\Field1\Field19[$00], $01), entityy(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01), $00)
                            setanimtime(local10\Field1\Field19[$01], 267.0, $00)
                        EndIf
                        local10\Field4 = 1.0
                    ElseIf (local10\Field1\Field19[$01] <> $00) Then
                        If (1.0 = local10\Field4) Then
                            pointentity(local10\Field1\Field19[$01], collider, 0.0)
                            rotateentity(local10\Field1\Field19[$01], -90.0, entityyaw(local10\Field1\Field19[$01], $00), 0.0, $00)
                            local21 = wrapangle(deltayaw(collider, local10\Field1\Field19[$01]))
                            If (((40.0 > local21) Or (320.0 < local21)) <> 0) Then
                                local10\Field4 = 2.0
                            EndIf
                        ElseIf (2.0 = local10\Field4) Then
                            pointentity(local10\Field1\Field19[$01], collider, 0.0)
                            rotateentity(local10\Field1\Field19[$01], -90.0, entityyaw(local10\Field1\Field19[$01], $00), 0.0, $00)
                            animate2(local10\Field1\Field19[$01], animtime(local10\Field1\Field19[$01]), $10B, $11B, 0.3, $00)
                            If (283.0 = animtime(local10\Field1\Field19[$01])) Then
                                local10\Field4 = 3.0
                            EndIf
                        ElseIf (3.0 = local10\Field4) Then
                            animate2(local10\Field1\Field19[$01], animtime(local10\Field1\Field19[$01]), $11B, $10B, -0.2, $00)
                            If (267.0 = animtime(local10\Field1\Field19[$01])) Then
                                local10\Field4 = 4.0
                            EndIf
                        ElseIf (4.0 = local10\Field4) Then
                            local21 = wrapangle(deltayaw(collider, local10\Field1\Field19[$01]))
                            If (((90.0 < local21) And (270.0 > local21)) <> 0) Then
                                freeentity(local10\Field1\Field19[$01])
                                local10\Field1\Field19[$01] = $00
                                local10\Field4 = 5.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (local10\Field1\Field7\Field10 = "checkpoint2") Then
                    For local11 = Each events
                        If (local11\Field0 = "room008") Then
                            If (2.0 = local11\Field2) Then
                                If (local10\Field1\Field21[$00]\Field4 <> 0) Then
                                    turncheckpointmonitorsoff($01)
                                    local10\Field1\Field21[$00]\Field4 = $00
                                    local10\Field1\Field21[$01]\Field4 = $00
                                EndIf
                            ElseIf (12.0 > local10\Field1\Field8) Then
                                updatecheckpointmonitors($01)
                                local10\Field1\Field21[$00]\Field4 = $01
                                local10\Field1\Field21[$01]\Field4 = $01
                            EndIf
                        EndIf
                    Next
                Else
                    For local11 = Each events
                        If (local11\Field0 = "room2sl") Then
                            If (0.0 = local11\Field4) Then
                                If (12.0 > local10\Field1\Field8) Then
                                    turncheckpointmonitorsoff($00)
                                    local10\Field1\Field21[$00]\Field4 = $00
                                    local10\Field1\Field21[$01]\Field4 = $00
                                EndIf
                            ElseIf (12.0 > local10\Field1\Field8) Then
                                updatecheckpointmonitors($00)
                                local10\Field1\Field21[$00]\Field4 = $01
                                local10\Field1\Field21[$01]\Field4 = $01
                            EndIf
                        EndIf
                    Next
                EndIf
                If (local10\Field2 <> (Float local10\Field1\Field21[$00]\Field5)) Then
                    If (local10\Field9 = $00) Then
                        loadeventsound(local10, scpmodding_processfilepath("SFX\Door\DoorCheckpoint.ogg"), $00)
                    EndIf
                    local10\Field6 = playsound2(local10\Field9, camera, local10\Field1\Field21[$00]\Field0, 10.0, 1.0)
                    local10\Field7 = playsound2(local10\Field9, camera, local10\Field1\Field21[$01]\Field0, 10.0, 1.0)
                EndIf
                local10\Field2 = (Float local10\Field1\Field21[$00]\Field5)
                If (channelplaying(local10\Field6) <> 0) Then
                    updatesoundorigin(local10\Field6, camera, local10\Field1\Field21[$00]\Field0, 10.0, 1.0)
                EndIf
                If (channelplaying(local10\Field7) <> 0) Then
                    updatesoundorigin(local10\Field7, camera, local10\Field1\Field21[$01]\Field0, 10.0, 1.0)
                EndIf
            Case "room895","room895_106"
                If ((Float millisecs2()) > local10\Field2) Then
                    If (playerzone > $00) Then
                        If (0.0 < entitypitch(local10\Field1\Field20[$00], $01)) Then
                            For local15 = Each securitycams
                                If ((((local15\Field21 = $00) And (local15\Field19\Field7\Field10 <> "room106")) And (local15\Field19\Field7\Field10 <> "room205")) <> 0) Then
                                    local15\Field21 = $02
                                EndIf
                                If (local15\Field19 = local10\Field1) Then
                                    local15\Field7 = $01
                                EndIf
                            Next
                        Else
                            For local15 = Each securitycams
                                If (local15\Field21 <> $01) Then
                                    local15\Field21 = $00
                                EndIf
                                If (local15\Field19 = local10\Field1) Then
                                    local15\Field7 = $00
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local10\Field2 = (Float (millisecs2() + $BB8))
                EndIf
                If (playerroom = local10\Field1) Then
                    coffindistance = entitydistance(collider, local10\Field1\Field19[$01])
                    If (1.5 > coffindistance) Then
                        giveachievement($13, $01)
                        If ((((contained106 = $00) And (local10\Field0 = "room895_106")) And (0.0 = local10\Field3)) <> 0) Then
                            local30 = createdecal($00, entityx(local10\Field1\Field19[$01], $01), (-1531.0 * roomscale), entityz(local10\Field1\Field19[$01], $01), 90.0, (Float rand($168, $01)), 0.0)
                            local30\Field2 = 0.05
                            local30\Field1 = 0.001
                            entityalpha(local30\Field0, 0.8)
                            updatedecals()
                            If (0.0 < curr106\Field9) Then
                                positionentity(curr106\Field4, entityx(local10\Field1\Field19[$01], $01), (-10240.0 * roomscale), entityz(local10\Field1\Field19[$01], $01), $00)
                                curr106\Field9 = -0.1
                                showentity(curr106\Field0)
                                local10\Field3 = 1.0
                            EndIf
                        EndIf
                    ElseIf (3.0 > coffindistance) Then
                        If (local10\Field1\Field22[$00] = Null) Then
                            local10\Field1\Field22[$00] = createnpc($13, local10\Field1\Field3, local10\Field1\Field4, local10\Field1\Field5)
                            rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $5A)), 0.0, $00)
                            local10\Field1\Field22[$00]\Field9 = 8.0
                            setnpcframe(local10\Field1\Field22[$00], 270.0)
                            local10\Field1\Field22[$00]\Field44 = 0.0
                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\895Chamber\GuardIdle" + (Str rand($01, $03))) + ".ogg")))
                            local10\Field1\Field22[$00]\Field17 = playsound2(local10\Field1\Field22[$00]\Field16, camera, local10\Field1\Field22[$00]\Field4, 10.0, 1.0)
                            local10\Field1\Field22[$00]\Field48 = $01
                            local10\Field1\Field22[$00]\Field74 = 0.0
                        EndIf
                    ElseIf (5.0 < coffindistance) Then
                        If (local10\Field1\Field22[$00] <> Null) Then
                            If (local10\Field1\Field22[$00]\Field12 = $00) Then
                                If (channelplaying(local10\Field1\Field22[$00]\Field17) <> 0) Then
                                    stopchannel(local10\Field1\Field22[$00]\Field17)
                                EndIf
                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Room\895Chamber\GuardScream" + (Str rand($01, $03))) + ".ogg")))
                                local10\Field1\Field22[$00]\Field17 = playsound2(local10\Field1\Field22[$00]\Field16, camera, local10\Field1\Field22[$00]\Field4, 100.0, 1.0)
                                local10\Field1\Field22[$00]\Field12 = $01
                                local10\Field1\Field22[$00]\Field10 = 0.0
                            EndIf
                        EndIf
                    EndIf
                    If (local10\Field1\Field22[$00] <> Null) Then
                        updatesoundorigin(local10\Field1\Field22[$00]\Field17, camera, local10\Field1\Field22[$00]\Field4, 100.0, 1.0)
                        If (local10\Field1\Field22[$00]\Field12 = $00) Then
                            local10\Field1\Field22[$00]\Field44 = 0.0
                        ElseIf (local10\Field1\Field22[$00]\Field12 = $01) Then
                            If (70.0 > local10\Field1\Field22[$00]\Field10) Then
                                local10\Field1\Field22[$00]\Field10 = (local10\Field1\Field22[$00]\Field10 + local23\Field3[$00])
                                local10\Field1\Field22[$00]\Field44 = 0.0
                            Else
                                local10\Field1\Field22[$00]\Field44 = 1.0
                            EndIf
                            If (((-1531.0 * roomscale) + 0.35) < entityy(local10\Field1\Field22[$00]\Field4, $00)) Then
                                local0 = entitydistance(collider, local10\Field1\Field22[$00]\Field4)
                                If (0.8 > local0) Then
                                    local31 = point_direction(entityx(collider, $01), entityz(collider, $01), entityx(local10\Field1\Field22[$00]\Field4, $01), entityz(local10\Field1\Field22[$00]\Field4, $01))
                                    translateentity(collider, ((cos(((- local31) + 90.0)) * (local0 - 0.8)) * (local0 - 0.8)), 0.0, ((sin(((- local31) + 90.0)) * (local0 - 0.8)) * (local0 - 0.8)), $00)
                                EndIf
                                If (0.6 < entityy(local10\Field1\Field22[$00]\Field4, $00)) Then
                                    entitytype(local10\Field1\Field22[$00]\Field4, $00, $00)
                                EndIf
                            Else
                                local10\Field2 = (local10\Field2 + local23\Field3[$00])
                                animatenpc(local10\Field1\Field22[$00], 270.0, 286.0, 0.4, $00)
                                If (local10\Field9 = $00) Then
                                    loadeventsound(local10, scpmodding_processfilepath("SFX\General\BodyFall.ogg"), $00)
                                    local10\Field6 = playsound_strict(local10\Field9)
                                    local30 = createdecal($03, entityx(local10\Field1\Field2, $00), (-1531.0 * roomscale), entityz(local10\Field1\Field2, $00), 90.0, (Float rand($168, $01)), 0.0)
                                    local30\Field2 = 0.4
                                    scalesprite(local30\Field0, local30\Field2, local30\Field2)
                                    updatedecals()
                                EndIf
                                If (286.0 = local10\Field1\Field22[$00]\Field14) Then
                                    local10\Field1\Field22[$00]\Field12 = $02
                                EndIf
                            EndIf
                            If (local10\Field1\Field22[$00]\Field20 = $00) Then
                                local10\Field1\Field22[$00]\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\Room\895Chamber\GuardRadio.ogg"))
                                local10\Field1\Field22[$00]\Field20 = loopsound2(local10\Field1\Field22[$00]\Field19, local10\Field1\Field22[$00]\Field20, camera, local10\Field1\Field22[$00]\Field4, 5.0, 1.0)
                            EndIf
                        ElseIf (local10\Field1\Field22[$00]\Field12 = $02) Then
                            If (((channelplaying(local10\Field6) = $00) And (local10\Field9 <> $00)) <> 0) Then
                                freesound_strict(local10\Field9)
                                local10\Field9 = $00
                                local10\Field6 = $00
                            EndIf
                            If (((channelplaying(local10\Field1\Field22[$00]\Field17) = $00) And (local10\Field1\Field22[$00]\Field16 <> $00)) <> 0) Then
                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                local10\Field1\Field22[$00]\Field16 = $00
                                local10\Field1\Field22[$00]\Field17 = $00
                            EndIf
                            If (local10\Field1\Field22[$00]\Field19 = $00) Then
                                local10\Field1\Field22[$00]\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\Room\895Chamber\GuardRadio.ogg"))
                            EndIf
                            local10\Field1\Field22[$00]\Field20 = loopsound2(local10\Field1\Field22[$00]\Field19, local10\Field1\Field22[$00]\Field20, camera, local10\Field1\Field22[$00]\Field4, 5.0, 1.0)
                        EndIf
                    EndIf
                    If (wearingnightvision > $00) Then
                        local32 = $00
                        For local1 = $00 To (maxitemamount - $01) Step $01
                            If (inventory(local1) <> Null) Then
                                If (((((wearingnightvision = $01) And (inventory(local1)\Field3\Field1 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field3\Field1 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field3\Field1 = "finenvgoggles"))) <> 0) Then
                                    If (((0.0 < inventory(local1)\Field13) Or (wearingnightvision = $03)) <> 0) Then
                                        local32 = $01
                                        Exit
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If ((((4.0 > coffindistance) And local32) And (i_714\Field0 = $00)) <> 0) Then
                            local33 = point_direction(entityx(collider, $01), entityz(collider, $01), entityx(local10\Field1\Field19[$01], $01), entityz(local10\Field1\Field19[$01], $01))
                            local34 = entityyaw(collider, $00)
                            local35 = angledist(((local33 + 90.0) + sin(wrapangle((local10\Field4 / 10.0)))), local34)
                            turnentity(collider, 0.0, (local35 / 4.0), 0.0, $01)
                            local33 = (Abs point_distance(entityx(collider, $01), entityz(collider, $01), entityx(local10\Field1\Field19[$01], $01), entityz(local10\Field1\Field19[$01], $01)))
                            local34 = (min(max(((2.0 - local33) / 2.0), 0.0), 1.0) * -60.0)
                            user_camera_pitch = ((user_camera_pitch * 0.8) + (local34 * 0.2))
                            sanity = (sanity - ((local23\Field3[$00] * 1.1) / (Float wearingnightvision)))
                            restoresanity = $00
                            blurtimer = (sin((Float (millisecs2() / $0A))) * (Abs sanity))
                            If (0.0 > vomittimer) Then
                                restoresanity = $00
                                sanity = -1010.0
                            EndIf
                            If (-1000.0 > sanity) Then
                                If (wearingnightvision > $01) Then
                                    deathmsg = ((chr($22) + scplang_getphrase("events.room895nvg")) + chr($22))
                                Else
                                    deathmsg = ((chr($22) + scplang_getphrase("events.room895nvg2")) + chr($22))
                                EndIf
                                entitytexture(at\Field4[$03], at\Field5[$03], $00, $00)
                                If (-10.0 > vomittimer) Then
                                    kill($00, $00)
                                EndIf
                            ElseIf (-800.0 > sanity) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(at\Field4[$03], at\Field5[$03], $00, $00)
                                EndIf
                                If (rand($06, $01) < $05) Then
                                    entitytexture(at\Field4[$03], at\Field1[rand($0A, $14)], $00, $00)
                                    For local1 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local1) <> Null) Then
                                            If (((((wearingnightvision = $01) And (inventory(local1)\Field3\Field1 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field3\Field1 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field3\Field1 = "finenvgoggles"))) <> 0) Then
                                                If (1.0 = inventory(local1)\Field14) Then
                                                    playsound_strict(horrorsfx($01))
                                                EndIf
                                                inventory(local1)\Field14 = 2.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                blurtimer = 1000.0
                                If (0.0 = vomittimer) Then
                                    vomittimer = 1.0
                                EndIf
                            ElseIf (-500.0 > sanity) Then
                                If (rand($07, $01) = $01) Then
                                    entitytexture(at\Field4[$03], at\Field5[$03], $00, $00)
                                EndIf
                                If (rand($32, $01) = $01) Then
                                    entitytexture(at\Field4[$03], at\Field1[rand($0A, $14)], $00, $00)
                                    For local1 = $00 To (maxitemamount - $01) Step $01
                                        If (inventory(local1) <> Null) Then
                                            If (((((wearingnightvision = $01) And (inventory(local1)\Field3\Field1 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field3\Field1 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field3\Field1 = "finenvgoggles"))) <> 0) Then
                                                If (0.0 = inventory(local1)\Field14) Then
                                                    playsound_strict(horrorsfx($00))
                                                EndIf
                                                inventory(local1)\Field14 = 1.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            Else
                                entitytexture(at\Field4[$03], at\Field5[$03], $00, $00)
                                For local1 = $00 To (maxitemamount - $01) Step $01
                                    If (inventory(local1) <> Null) Then
                                        If (((((wearingnightvision = $01) And (inventory(local1)\Field3\Field1 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local1)\Field3\Field1 = "supernv"))) Or ((wearingnightvision = $03) And (inventory(local1)\Field3\Field1 = "finenvgoggles"))) <> 0) Then
                                            inventory(local1)\Field14 = 0.0
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                        EndIf
                    EndIf
                    If ((((wearingnightvision > $00) And local32) And (10.0 > entitydistance(collider, local10\Field1\Field19[$01]))) <> 0) Then
                        If (local10\Field11 = $00) Then
                            local10\Field11 = loadsound_strict(scpmodding_processfilepath("SFX\Room\895Chamber\NVG.ogg"))
                        EndIf
                        local10\Field8 = loopsound2(local10\Field11, local10\Field8, camera, local10\Field1\Field19[$01], 5.0, 1.0)
                    Else
                        freesound_strict(local10\Field11)
                        local10\Field11 = $00
                    EndIf
                    If (0.0 < local10\Field4) Then
                        local10\Field4 = max((local10\Field4 - local23\Field3[$00]), 0.0)
                    EndIf
                    If (0.0 = local10\Field4) Then
                        local10\Field4 = -1.0
                        entitytexture(at\Field4[$03], at\Field5[$03], $00, $00)
                        If (wearingnightvision = $01) Then
                            entitycolor(at\Field4[$03], 0.0, 255.0, 0.0)
                        ElseIf (wearingnightvision = $02) Then
                            entitycolor(at\Field4[$03], 0.0, 100.0, 255.0)
                        EndIf
                    EndIf
                    shouldplay = $42
                    If (updatelever(local10\Field1\Field20[$00], $00) <> 0) Then
                        For local15 = Each securitycams
                            If (((local15\Field21 = $00) And (local15\Field19\Field7\Field10 <> "room106")) <> 0) Then
                                local15\Field21 = $02
                            EndIf
                            If (local15\Field21 = $01) Then
                                entityblend(local15\Field10, $03)
                            EndIf
                            If (local15\Field19 = local10\Field1) Then
                                local15\Field7 = $01
                            EndIf
                        Next
                    Else
                        For local15 = Each securitycams
                            If (local15\Field21 <> $01) Then
                                local15\Field21 = $00
                            EndIf
                            If (local15\Field21 = $01) Then
                                entityblend(local15\Field10, $00)
                            EndIf
                            If (local15\Field19 = local10\Field1) Then
                                local15\Field7 = $00
                            EndIf
                        Next
                    EndIf
                Else
                    coffindistance = local10\Field1\Field8
                EndIf
            Case "endroom106"
                If (contained106 = $00) Then
                    If (0.0 = local10\Field2) Then
                        If (((8.0 > local10\Field1\Field8) And (0.0 < local10\Field1\Field8)) <> 0) Then
                            If (0.0 > curr106\Field9) Then
                                removeevent(local10)
                            Else
                                local10\Field1\Field21[$00]\Field5 = $01
                                local10\Field1\Field22[$00] = createnpc($12, entityx(local10\Field1\Field21[$00]\Field0, $01), 0.5, entityz(local10\Field1\Field21[$00]\Field0, $01))
                                changenpctextureid(local10\Field1\Field22[$00], $04)
                                pointentity(local10\Field1\Field22[$00]\Field4, local10\Field1\Field2, 0.0)
                                rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, entityyaw(local10\Field1\Field22[$00]\Field4, $00), 0.0, $01)
                                moveentity(local10\Field1\Field22[$00]\Field4, 0.0, 0.0, 0.5)
                                local10\Field1\Field21[$00]\Field5 = $00
                                playsound2(loadtempsound(scpmodding_processfilepath("SFX\Door\EndroomDoor.ogg")), camera, local10\Field1\Field2, 15.0, 1.0)
                                local10\Field2 = 1.0
                            EndIf
                        EndIf
                    ElseIf (1.0 = local10\Field2) Then
                        If (playerroom = local10\Field1) Then
                            local10\Field1\Field22[$00]\Field9 = 1.0
                            local10\Field2 = 2.0
                            local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Character\Janitor\106Abduct.ogg"))
                            playsound_strict(local10\Field9)
                            If (local10\Field6 <> $00) Then
                                stopchannel(local10\Field6)
                            EndIf
                        ElseIf (8.0 > local10\Field1\Field8) Then
                            If (local10\Field9 = $00) Then
                                local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Character\Janitor\Idle.ogg"))
                            EndIf
                            local10\Field6 = loopsound2(local10\Field9, local10\Field6, camera, local10\Field1\Field22[$00]\Field0, 15.0, 1.0)
                        EndIf
                    ElseIf (2.0 = local10\Field2) Then
                        local0 = entitydistance(local10\Field1\Field22[$00]\Field4, local10\Field1\Field2)
                        If (1.5 > local0) Then
                            local30 = createdecal($00, entityx(local10\Field1\Field2, $00), 0.01, entityz(local10\Field1\Field2, $00), 90.0, (Float rand($168, $01)), 0.0)
                            local30\Field2 = 0.05
                            local30\Field1 = 0.008
                            local30\Field9 = 10000.0
                            updatedecals()
                            local10\Field2 = 3.0
                        EndIf
                    Else
                        local0 = distance(entityx(local10\Field1\Field22[$00]\Field4, $00), entityz(local10\Field1\Field22[$00]\Field4, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))
                        positionentity(curr106\Field0, entityx(local10\Field1\Field2, $01), 0.0, entityz(local10\Field1\Field2, $01), $00)
                        pointentity(curr106\Field0, local10\Field1\Field22[$00]\Field4, 0.0)
                        rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field0, $00), 0.0, $01)
                        curr106\Field24 = 1.0
                        If (0.4 > local0) Then
                            If (1.0 = local10\Field1\Field22[$00]\Field9) Then
                                setnpcframe(local10\Field1\Field22[$00], 41.0)
                            EndIf
                            local10\Field2 = (local10\Field2 + (local23\Field3[$00] / 2.0))
                            local10\Field1\Field22[$00]\Field9 = 6.0
                            local10\Field1\Field22[$00]\Field22 = curvevalue(0.0, local10\Field1\Field22[$00]\Field22, 25.0)
                            positionentity(local10\Field1\Field22[$00]\Field4, curvevalue(entityx(local10\Field1\Field2, $01), entityx(local10\Field1\Field22[$00]\Field4, $00), 25.0), (0.3 - (local10\Field2 / 70.0)), curvevalue(entityz(local10\Field1\Field2, $01), entityz(local10\Field1\Field22[$00]\Field4, $00), 25.0), $00)
                            resetentity(local10\Field1\Field22[$00]\Field4)
                            animatenpc(local10\Field1\Field22[$00], 41.0, 58.0, 0.1, $00)
                            animatenpc(curr106, 206.0, 112.0, -1.0, $00)
                        Else
                            animatenpc(curr106, 112.0, 206.0, 1.5, $00)
                        EndIf
                        currspeed = min((currspeed - (((0.15 / entitydistance(local10\Field1\Field22[$00]\Field4, collider)) * currspeed) * local23\Field3[$00])), currspeed)
                        If (100.0 < local10\Field2) Then
                            positionentity(curr106\Field0, entityx(curr106\Field4, $00), -100.0, entityz(curr106\Field4, $00), $01)
                            positionentity(curr106\Field4, entityx(curr106\Field4, $00), -100.0, entityz(curr106\Field4, $00), $01)
                            curr106\Field24 = 0.0
                            If (2.5 > entitydistance(collider, local10\Field1\Field2)) Then
                                curr106\Field9 = -0.1
                            EndIf
                            removenpc(local10\Field1\Field22[$00])
                            removeevent(local10)
                        EndIf
                    EndIf
                Else
                    removeevent(local10)
                EndIf
            Case "gateaentrance"
                If (playerroom = local10\Field1) Then
                    If (remotedooron = $00) Then
                        local10\Field1\Field21[$01]\Field4 = $01
                    ElseIf ((remotedooron And (0.0 = local10\Field4)) <> 0) Then
                        local10\Field1\Field21[$01]\Field4 = $00
                        If (local10\Field1\Field21[$01]\Field5 <> 0) Then
                            If (((50.0 < local10\Field1\Field21[$01]\Field7) Or (0.5 > entitydistance(collider, local10\Field1\Field21[$01]\Field2))) <> 0) Then
                                local10\Field1\Field21[$01]\Field7 = min(local10\Field1\Field21[$01]\Field7, 50.0)
                                local10\Field1\Field21[$01]\Field5 = $00
                                playsound2(loadtempsound(scpmodding_processfilepath("SFX\Door\DoorError.ogg")), camera, local10\Field1\Field21[$01]\Field2, 10.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        local10\Field1\Field21[$01]\Field4 = $00
                        local36 = Null
                        For local9 = Each rooms
                            If (local9\Field7\Field10 = "gatea") Then
                                local36 = local9
                                Exit
                            EndIf
                        Next
                        If (curr096 <> Null) Then
                            If (((0.0 = curr096\Field9) Or (5.0 = curr096\Field9)) <> 0) Then
                                local10\Field2 = updateelevators(local10\Field2, local10\Field1\Field21[$00], local36\Field21[$01], local10\Field1\Field19[$00], local10\Field1\Field19[$01], local10, $01)
                            Else
                                local10\Field2 = update096elevatorevent(local10, local10\Field2, local10\Field1\Field21[$00], local10\Field1\Field19[$00])
                            EndIf
                        Else
                            local10\Field2 = updateelevators(local10\Field2, local10\Field1\Field21[$00], local36\Field21[$01], local10\Field1\Field19[$00], local10\Field1\Field19[$01], local10, $01)
                        EndIf
                        If (contained106 = $00) Then
                            If (((-1.5 > local10\Field2) And (-1.5 <= (local10\Field2 + local23\Field3[$00]))) <> 0) Then
                                If (rand($02, $01) = $01) Then
                                    playsound_strict(oldmansfx($03))
                                Else
                                    playsound_strict(oldmansfx($09))
                                EndIf
                            EndIf
                        EndIf
                        If (4.0 > entitydistance(collider, local10\Field1\Field19[$01])) Then
                            local36\Field21[$01]\Field4 = $01
                            playerroom = local36
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "lockroom173"
                If (((6.0 > local10\Field1\Field8) And (0.0 < local10\Field1\Field8)) <> 0) Then
                    If (1.0 < curr173\Field24) Then
                        removeevent(local10)
                    ElseIf (((entityinview(curr173\Field4, camera) = $00) Or (15.0 < entitydistance(curr173\Field4, collider))) <> 0) Then
                        positionentity(curr173\Field4, (local10\Field1\Field3 + (cos((Float (local10\Field1\Field6 + $87))) * 2.0)), 0.6, (local10\Field1\Field5 + (sin((Float (local10\Field1\Field6 + $87))) * 2.0)), $00)
                        resetentity(curr173\Field4)
                        removeevent(local10)
                    EndIf
                EndIf
            Case "lockroom096"
                If (playerroom = local10\Field1) Then
                    If (curr096 = Null) Then
                        curr096 = createnpc($06, entityx(local10\Field1\Field2, $01), 0.3, entityz(local10\Field1\Field2, $01))
                        rotateentity(curr096\Field4, 0.0, (Float (local10\Field1\Field6 + $2D)), 0.0, $01)
                    EndIf
                    removeevent(local10)
                EndIf
            Case "room372"
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field2) Then
                        If (local10\Field1\Field21[$00]\Field5 = $01) Then
                            playsound_strict(rustlesfx(rand($00, $06)))
                            createnpc($09, 0.0, 0.0, 0.0)
                            local10\Field2 = 1.0
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "pocketdimension"
                If (playerroom = local10\Field1) Then
                    showentity(local10\Field1\Field2)
                    playerfallingpickdistance = 0.0
                    injuries = ((local23\Field3[$00] * 0.00005) + injuries)
                    prevsecondarylighton = secondarylighton
                    secondarylighton = 1.0
                    If ((((2000.0 * roomscale) > entityy(collider, $00)) Or ((2608.0 * roomscale) < entityy(collider, $00))) <> 0) Then
                        currstepsfx = $01
                    EndIf
                    If (local10\Field9 = $00) Then
                        loadeventsound(local10, scpmodding_processfilepath("SFX\Room\PocketDimension\Rumble.ogg"), $00)
                    EndIf
                    If (local10\Field10 = $00) Then
                        local10\Field10 = loadeventsound(local10, scpmodding_processfilepath("SFX\Room\PocketDimension\PrisonVoices.ogg"), $01)
                    EndIf
                    If (0.0 = local10\Field2) Then
                        camerafogcolor(camera, 0.0, 0.0, 0.0)
                        cameraclscolor(camera, 0.0, 0.0, 0.0)
                        local10\Field2 = 0.1
                    EndIf
                    If (((((2000.0 * roomscale) > entityy(collider, $00)) Or (0.0 = local10\Field4)) Or ((2608.0 * roomscale) < entityy(collider, $00))) <> 0) Then
                        shouldplay = $03
                    Else
                        shouldplay = $00
                    EndIf
                    scaleentity(local10\Field1\Field2, roomscale, (((sin((local10\Field2 / 14.0)) * 0.2) + 1.0) * roomscale), roomscale, $00)
                    For local1 = $00 To $07 Step $01
                        scaleentity(local10\Field1\Field19[local1], (((Abs (sin(((local10\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.0) * roomscale), (((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    Next
                    scaleentity(local10\Field1\Field19[$09], (((Abs (sin(((local10\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    local10\Field2 = (local10\Field2 + local23\Field3[$00])
                    If (0.0 = local10\Field3) Then
                        local10\Field1\Field21[$00]\Field5 = $00
                        local10\Field1\Field21[$01]\Field5 = $00
                        If (0.0 < curr106\Field9) Then
                            local21 = ((local10\Field2 / 10.0) Mod 360.0)
                            positionentity(curr106\Field4, entityx(local10\Field1\Field2, $00), ((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.4) + 0.55), entityx(local10\Field1\Field2, $00), $00)
                            rotateentity(curr106\Field4, 0.0, local21, 0.0, $00)
                            moveentity(curr106\Field4, 0.0, 0.0, (6.0 - sin((local10\Field2 / 10.0))))
                            animatenpc(curr106, 55.0, 104.0, 0.5, $01)
                            rotateentity(curr106\Field4, 0.0, (local21 + 90.0), 0.0, $00)
                            curr106\Field24 = 1.0
                            showentity(curr106\Field0)
                            showentity(curr106\Field4)
                            resetentity(curr106\Field4)
                            curr106\Field44 = 0.0
                            curr106\Field7 = 0.0
                            positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                            rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                            If (4550.0 < local10\Field2) Then
                                If (rand($320, $01) = $01) Then
                                    playsound_strict(horrorsfx($08))
                                    curr106\Field9 = -0.1
                                    curr106\Field24 = 0.0
                                    local10\Field2 = 601.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (0.3 > entitydistance(collider, curr106\Field4)) Then
                        curr106\Field24 = 0.0
                        curr106\Field9 = -10.0
                    EndIf
                    If (1.0 = local10\Field3) Then
                        positionentity(local10\Field1\Field19[$09], (entityx(local10\Field1\Field19[$08], $01) + (3384.0 * roomscale)), 0.0, entityz(local10\Field1\Field19[$08], $01), $00)
                        translateentity(local10\Field1\Field19[$09], (cos((local10\Field2 * 0.8)) * 5.0), 0.0, (sin((local10\Field2 * 1.6)) * 4.0), $01)
                        rotateentity(local10\Field1\Field19[$09], 0.0, (local10\Field2 * 2.0), 0.0, $00)
                        positionentity(local10\Field1\Field19[$0A], entityx(local10\Field1\Field19[$08], $01), 0.0, (entityz(local10\Field1\Field19[$08], $01) + (3384.0 * roomscale)), $00)
                        translateentity(local10\Field1\Field19[$0A], (sin((local10\Field2 * 1.6)) * 4.0), 0.0, (cos((local10\Field2 * 0.8)) * 5.0), $01)
                        rotateentity(local10\Field1\Field19[$0A], 0.0, (local10\Field2 * 2.0), 0.0, $00)
                        If (((1.0 = local10\Field4) Or (2.0 = local10\Field4)) <> 0) Then
                            If (((1.0 = local10\Field4) And ((150.0 < local10\Field1\Field21[$00]\Field7) Or (150.0 < local10\Field1\Field21[$01]\Field7))) <> 0) Then
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Horror\Horror16.ogg")))
                                blurtimer = 800.0
                                local10\Field4 = 2.0
                            EndIf
                            If (5.0 > entityy(collider, $00)) Then
                                local10\Field4 = 0.0
                            EndIf
                        ElseIf (6.0 < entityy(collider, $00)) Then
                            shouldplay = $0F
                            camerafogcolor(camera, 38.0, 55.0, 47.0)
                            cameraclscolor(camera, 38.0, 55.0, 47.0)
                            If (entityx(local10\Field1\Field19[$14], $01) < (entityx(local10\Field1\Field19[$08], $01) - (4000.0 * roomscale))) Then
                                local10\Field7 = playsound_strict(local10\Field10)
                                positionentity(local10\Field1\Field19[$14], (entityx(collider, $01) + (4000.0 * roomscale)), 12.0, entityz(collider, $01), $00)
                            EndIf
                            moveentity(collider, 0.0, (min((12.0 - entityy(collider, $00)), 0.0) * local23\Field3[$00]), 0.0)
                            local18 = (((- local23\Field3[$00]) * roomscale) * 4.0)
                            local19 = ((17.0 - ((Abs (entityx(collider, $00) - entityx(local10\Field1\Field19[$14], $00))) * 0.5)) - entityy(local10\Field1\Field19[$14], $00))
                            local20 = (entityz(collider, $01) - entityz(local10\Field1\Field19[$14], $00))
                            translateentity(local10\Field1\Field19[$14], local18, local19, local20, $01)
                            rotateentity(local10\Field1\Field19[$14], (-90.0 - ((entityx(collider, $00) - entityx(local10\Field1\Field19[$14], $00)) * 1.5)), -90.0, 0.0, $01)
                            local37 = $00
                            For local1 = $00 To $02 Step $01
                                Select local1
                                    Case $00
                                        local18 = (-1452.0 * roomscale)
                                        local20 = (-37.0 * roomscale)
                                    Case $01
                                        local18 = (-121.0 * roomscale)
                                        local20 = (188.0 * roomscale)
                                    Case $02
                                        local18 = (1223.0 * roomscale)
                                        local20 = (-196.0 * roomscale)
                                End Select
                                local18 = (entityx(local10\Field1\Field19[$08], $01) + local18)
                                local20 = (entityz(local10\Field1\Field19[$08], $01) + local20)
                                If ((200.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), local18, local20)) Then
                                    local37 = $01
                                    Exit
                                EndIf
                            Next
                            local0 = entitydistance(collider, local10\Field1\Field19[$14])
                            If (((local10\Field7 <> $00) And channelplaying(local10\Field7)) <> 0) Then
                                local10\Field7 = loopsound2(local10\Field10, local10\Field7, camera, camera, 10.0, (((Float (local37 = $00)) * 0.6) + 0.3))
                            EndIf
                            If (local37 <> 0) Then
                                entitytexture(local10\Field1\Field19[$14], local10\Field1\Field19[$12], $00, $00)
                            ElseIf (8.0 > local0) Then
                                local10\Field6 = loopsound2(local10\Field9, local10\Field6, camera, local10\Field1\Field19[$14], 8.0, 1.0)
                                entitytexture(local10\Field1\Field19[$14], local10\Field1\Field19[$13], $00, $00)
                                injuries = ((((8.0 - local0) * local23\Field3[$00]) * 0.0003) + injuries)
                                If (7.0 > local0) Then
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local3, local10\Field1\Field19[$14], 0.0)
                                    turnentity(local3, 90.0, 0.0, 0.0, $00)
                                    user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), 10.0)
                                    user_camera_pitch = (user_camera_pitch - 90.0)
                                    rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local3, $00), entityyaw(collider, $00), 10.0), 0.0, $00)
                                    freeentity(local3)
                                EndIf
                            EndIf
                            camerashake = max(((((Float (local37 = $00)) * 4.0) + 4.0) - local0), 0.0)
                            If (8.5 > entityy(collider, $00)) Then
                                loadeventsound(local10, scpmodding_processfilepath("SFX\Room\PocketDimension\Rumble.ogg"), $00)
                                loadeventsound(local10, scpmodding_processfilepath("SFX\Room\PocketDimension\PrisonVoices.ogg"), $01)
                                blurtimer = 1500.0
                                local10\Field3 = 1.0
                                blinktimer = -10.0
                                positionentity(collider, (entityx(local10\Field1\Field19[$08], $01) - (400.0 * roomscale)), (-304.0 * roomscale), entityz(local10\Field1\Field19[$08], $01), $00)
                                resetentity(collider)
                                camerafogcolor(camera, 0.0, 0.0, 0.0)
                                cameraclscolor(camera, 0.0, 0.0, 0.0)
                            EndIf
                        Else
                            local10\Field4 = 0.0
                            For local1 = $09 To $0A Step $01
                                local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))
                                If (6.0 > local0) Then
                                    If (local0 < (100.0 * roomscale)) Then
                                        local3 = createpivot($00)
                                        positionentity(local3, entityx(local10\Field1\Field19[local1], $01), entityy(collider, $00), entityz(local10\Field1\Field19[local1], $01), $00)
                                        pointentity(local3, collider, 0.0)
                                        rotateentity(local3, 0.0, (Float ((Int (entityyaw(local3, $00) / 90.0)) * $5A)), 0.0, $01)
                                        moveentity(local3, 0.0, 0.0, (100.0 * roomscale))
                                        positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                        freeentity(local3)
                                        If (0.0 = killtimer) Then
                                            deathmsg = scplang_getphrase("events.pocketdimension")
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\PocketDimension\Impact.ogg")))
                                            killtimer = -1.0
                                        EndIf
                                    EndIf
                                    If (1000.0 > (Float local10\Field15)) Then
                                        local10\Field6 = loopsound2(local10\Field9, local10\Field6, camera, local10\Field1\Field19[local1], 6.0, 1.0)
                                    EndIf
                                EndIf
                            Next
                            local3 = createpivot($00)
                            positionentity(local3, (entityx(local10\Field1\Field19[$08], $01) - (1536.0 * roomscale)), (500.0 * roomscale), (entityz(local10\Field1\Field19[$08], $01) + (608.0 * roomscale)), $00)
                            If (5.0 > entitydistance(local3, collider)) Then
                                local10\Field7 = loopsound2(local10\Field10, local10\Field7, camera, local3, 3.0, 1.0)
                            EndIf
                            freeentity(local3)
                            showentity(local10\Field1\Field19[$11])
                            positionentity(local10\Field1\Field19[$11], entityx(local10\Field1\Field19[$08], $01), (1376.0 * roomscale), (entityz(local10\Field1\Field19[$08], $01) - (2848.0 * roomscale)), $00)
                            pointentity(local10\Field1\Field19[$11], collider, 0.0)
                            turnentity(local10\Field1\Field19[$11], 0.0, 180.0, 0.0, $00)
                            local2 = (Int entitydistance(collider, local10\Field1\Field19[$11]))
                            If ((Float local2) < (2000.0 * roomscale)) Then
                                injuries = ((local23\Field3[$00] / 4000.0) + injuries)
                                local10\Field15 = (Str ((Float local10\Field15) + (local23\Field3[$00] / 1000.0)))
                                If (((1.0 < (Float local10\Field15)) And (1000.0 > (Float local10\Field15))) <> 0) Then
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\PocketDimension\Kneel.ogg")))
                                    loadeventsound(local10, scpmodding_processfilepath("SFX\Room\PocketDimension\Screech.ogg"), $00)
                                    local10\Field15 = "1000.0"
                                EndIf
                                sanity = max((sanity - ((local23\Field3[$00] / (Float local2)) / 8.0)), -1000.0)
                                currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 15.0) * max(((6.0 - (Float local2)) / 6.0), 0.0)))
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local3, local10\Field1\Field19[$11], 0.0)
                                turnentity(local3, 90.0, 0.0, 0.0, $00)
                                user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 15.0), 500.0))
                                user_camera_pitch = (user_camera_pitch - 90.0)
                                rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local3, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 15.0), 500.0)), 0.0, $00)
                                freeentity(local3)
                                If (crouch <> 0) Then
                                    blinktimer = -10.0
                                    positionentity(collider, (entityx(local10\Field1\Field19[$08], $01) - (1344.0 * roomscale)), (2944.0 * roomscale), (entityz(local10\Field1\Field19[$08], $01) - (1184.0 * roomscale)), $00)
                                    resetentity(collider)
                                    crouch = $00
                                    loadeventsound(local10, scpmodding_processfilepath("SFX\Room\PocketDimension\Explosion.ogg"), $00)
                                    loadeventsound(local10, scpmodding_processfilepath("SFX\Room\PocketDimension\TrenchPlane.ogg"), $01)
                                    positionentity(local10\Field1\Field19[$14], (entityx(local10\Field1\Field19[$08], $01) - 1000.0), 0.0, 0.0, $01)
                                    local10\Field15 = "0.0"
                                EndIf
                            ElseIf ((-180.0 * roomscale) > entityy(collider, $00)) Then
                                local2 = (Int distance(entityx(collider, $00), entityz(collider, $00), (entityx(local10\Field1\Field19[$08], $01) + (1024.0 * roomscale)), entityz(local10\Field1\Field19[$08], $01)))
                                If ((Float local2) < (640.0 * roomscale)) Then
                                    blurtimer = (((640.0 * roomscale) - (Float local2)) * 3000.0)
                                    local10\Field7 = loopsound2(decaysfx(rand($01, $03)), local10\Field7, camera, collider, 2.0, ((((640.0 * roomscale) - (Float local2)) * (Abs currspeed)) * 100.0))
                                    currspeed = curvevalue(0.0, currspeed, (Float (local2 * $0A)))
                                    If ((Float local2) < (130.0 * roomscale)) Then
                                        For local9 = Each rooms
                                            If (local9\Field7\Field10 = "room2shaft") Then
                                                giveachievement($22, $01)
                                                local10\Field2 = 0.0
                                                local10\Field3 = 0.0
                                                secondarylighton = prevsecondarylighton
                                                prevsecondarylighton = 0.0
                                                blinktimer = -10.0
                                                lightblink = 5.0
                                                blurtimer = 1500.0
                                                playerroom = local9
                                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\PocketDimension\Exit.ogg")))
                                                teleportentity(collider, entityx(local9\Field19[$00], $01), 0.4, entityz(local9\Field19[$00], $01), 0.3, $01, 2.0, $00)
                                                updaterooms()
                                                updatedoors()
                                                curr106\Field9 = 10000.0
                                                curr106\Field24 = 0.0
                                                local30 = createdecal($00, entityx(local9\Field19[$00], $01), entityy(local9\Field19[$00], $01), entityz(local9\Field19[$00], $01), 270.0, (Float rand($168, $01)), 0.0)
                                                teleportentity(local30\Field0, entityx(local9\Field19[$00], $01), (entityy(local9\Field19[$00], $01) + 0.6), entityz(local9\Field19[$00], $01), 0.0, $01, 4.0, $01)
                                                For local11 = Each events
                                                    If (local11\Field0 = "room2sl") Then
                                                        local11\Field4 = 0.0
                                                        updatelever(local11\Field1\Field20[$00], $00)
                                                        rotateentity(local11\Field1\Field20[$00], 0.0, entityyaw(local11\Field1\Field20[$00], $00), 0.0, $00)
                                                        turncheckpointmonitorsoff($00)
                                                        Exit
                                                    EndIf
                                                Next
                                                Exit
                                                Return $00
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If ((-1600.0 * roomscale) > entityy(collider, $00)) Then
                            If ((4750.0 * roomscale) < entitydistance(collider, local10\Field1\Field19[$08])) Then
                                camerafogcolor(camera, 0.0, 0.0, 0.0)
                                cameraclscolor(camera, 0.0, 0.0, 0.0)
                                dropspeed = 0.0
                                blurtimer = 500.0
                                blurtimer = 1500.0
                                positionentity(collider, entityx(local10\Field1\Field2, $01), 0.4, entityx(local10\Field1\Field2, $01), $00)
                                For local9 = Each rooms
                                    If (local9\Field7\Field10 = "room106") Then
                                        local10\Field2 = 0.0
                                        local10\Field3 = 0.0
                                        teleportentity(collider, entityx(local9\Field19[$0A], $01), 0.4, entityz(local9\Field19[$0A], $01), 0.3, $01, 2.0, $00)
                                        giveachievement($22, $01)
                                        secondarylighton = prevsecondarylighton
                                        prevsecondarylighton = 0.0
                                        curr106\Field9 = 10000.0
                                        curr106\Field24 = 0.0
                                        For local11 = Each events
                                            If (local11\Field0 = "room2sl") Then
                                                local11\Field4 = 0.0
                                                updatelever(local11\Field1\Field20[$00], $00)
                                                rotateentity(local11\Field1\Field20[$00], 0.0, entityyaw(local11\Field1\Field20[$00], $00), 0.0, $00)
                                                turncheckpointmonitorsoff($00)
                                                Exit
                                            EndIf
                                        Next
                                        Exit
                                        Return $00
                                    EndIf
                                Next
                                resetentity(collider)
                                local10\Field3 = 0.0
                                updatedoorstimer = 0.0
                                updatedoors()
                                updaterooms()
                            Else
                                If (0.0 <= killtimer) Then
                                    playsound_strict(horrorsfx($08))
                                    deathmsg = scplang_getphrase("events.pocketdimension2")
                                EndIf
                                killtimer = min(-1.0, killtimer)
                                blurtimer = 3000.0
                            EndIf
                        EndIf
                        updatedoorstimer = 0.0
                        updatedoors()
                        updaterooms()
                    ElseIf (0.0 = local10\Field3) Then
                        local0 = entitydistance(collider, local10\Field1\Field2)
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($19, $01)
                                Case $01,$02,$03,$04
                                    If (rand($02, $01) = $01) Then
                                        playsound_strict(oldmansfx($03))
                                    Else
                                        playsound_strict(oldmansfx($09))
                                    EndIf
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local3, local10\Field1\Field2, 0.0)
                                    moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    resetentity(collider)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local10\Field1\Field19[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local10\Field1\Field19[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    freeentity(local3)
                                Case $05,$06,$07,$08,$09,$0A
                                    local10\Field3 = 1.0
                                    blinktimer = -10.0
                                    If (rand($02, $01) = $01) Then
                                        playsound_strict(oldmansfx($03))
                                    Else
                                        playsound_strict(oldmansfx($09))
                                    EndIf
                                    positionentity(collider, entityx(local10\Field1\Field19[$08], $01), 0.5, entityz(local10\Field1\Field19[$08], $01), $00)
                                    resetentity(collider)
                                Case $0B,$0C
                                    blurtimer = 500.0
                                    positionentity(collider, entityx(local10\Field1\Field2, $00), 0.5, entityz(local10\Field1\Field2, $00), $00)
                                Case $0D,$0E,$0F
                                    blurtimer = 1500.0
                                    local10\Field3 = 1.0
                                    blinktimer = -10.0
                                    positionentity(collider, (entityx(local10\Field1\Field19[$08], $01) - (400.0 * roomscale)), (-304.0 * roomscale), entityz(local10\Field1\Field19[$08], $01), $00)
                                    resetentity(collider)
                                Case $10,$11,$12,$13
                                    blurtimer = 1500.0
                                    For local9 = Each rooms
                                        If (local9\Field7\Field10 = "tunnel") Then
                                            giveachievement($22, $01)
                                            local10\Field2 = 0.0
                                            local10\Field3 = 0.0
                                            secondarylighton = prevsecondarylighton
                                            prevsecondarylighton = 0.0
                                            teleportentity(collider, entityx(local9\Field2, $01), 0.4, entityz(local9\Field2, $01), 0.3, $01, 2.0, $00)
                                            curr106\Field9 = 250.0
                                            curr106\Field24 = 0.0
                                            For local11 = Each events
                                                If (local11\Field0 = "room2sl") Then
                                                    local11\Field4 = 0.0
                                                    updatelever(local11\Field1\Field20[$00], $00)
                                                    rotateentity(local11\Field1\Field20[$00], 0.0, entityyaw(local11\Field1\Field20[$00], $00), 0.0, $00)
                                                    turncheckpointmonitorsoff($00)
                                                    Exit
                                                EndIf
                                            Next
                                            Exit
                                            Return $00
                                        EndIf
                                    Next
                                Case $14,$15,$16
                                    blinktimer = -10.0
                                    positionentity(collider, entityx(local10\Field1\Field19[$0C], $01), 0.6, entityz(local10\Field1\Field19[$0C], $01), $00)
                                    resetentity(collider)
                                    local10\Field3 = 15.0
                                Case $17,$18,$19
                                    blurtimer = 1500.0
                                    local10\Field3 = 1.0
                                    local10\Field4 = 1.0
                                    blinktimer = -10.0
                                    If (rand($02, $01) = $01) Then
                                        playsound_strict(oldmansfx($03))
                                    Else
                                        playsound_strict(oldmansfx($09))
                                    EndIf
                                    positionentity(collider, entityx(local10\Field1\Field19[$08], $01), (2288.0 * roomscale), entityz(local10\Field1\Field19[$08], $01), $00)
                                    resetentity(collider)
                            End Select
                            updatedoorstimer = 0.0
                            updatedoors()
                            updaterooms()
                        EndIf
                    Else
                        camerafogcolor(camera, 19.0, 27.5, 23.5)
                        cameraclscolor(camera, 19.0, 27.5, 23.5)
                        If (particleamount > $00) Then
                            If (rand($320, $01) = $01) Then
                                local21 = (entityyaw(camera, $01) + rnd(150.0, 210.0))
                                local7 = createparticle((entityx(collider, $00) + (cos(local21) * 7.5)), 0.0, (entityz(collider, $00) + (sin(local21) * 7.5)), $03, 4.0, 0.0, $9C4)
                                entityblend(local7\Field0, $02)
                                local7\Field8 = 0.01
                                local7\Field15 = 0.0
                                pointentity(local7\Field1, camera, 0.0)
                                turnentity(local7\Field1, 0.0, 145.0, 0.0, $01)
                                turnentity(local7\Field1, (Float rand($0A, $14)), 0.0, 0.0, $01)
                            EndIf
                        EndIf
                        If (12.0 < local10\Field3) Then
                            curr106\Field24 = 1.0
                            positionentity(curr106\Field4, entityx(local10\Field1\Field19[(Int local10\Field3)], $01), 0.27, entityz(local10\Field1\Field19[(Int local10\Field3)], $01), $00)
                            pointentity(curr106\Field4, camera, 0.0)
                            turnentity(curr106\Field4, 0.0, (sin((Float (millisecs2() / $14))) * 6.0), 0.0, $01)
                            moveentity(curr106\Field4, 0.0, 0.0, (sin((Float (millisecs2() / $0F))) * 0.06))
                            showentity(curr106\Field0)
                            showentity(curr106\Field4)
                            resetentity(curr106\Field4)
                            curr106\Field44 = 0.0
                            curr106\Field7 = 0.0
                            positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                            rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                            If (((rand($2EE, $01) = $01) And (12.0 < local10\Field3)) <> 0) Then
                                blinktimer = -10.0
                                local10\Field3 = (local10\Field3 - 1.0)
                                playsound_strict(horrorsfx($08))
                            EndIf
                            If (12.0 = local10\Field3) Then
                                camerashake = 1.0
                                positionentity(curr106\Field4, entityx(local10\Field1\Field19[(Int local10\Field3)], $01), -1.0, entityz(local10\Field1\Field19[(Int local10\Field3)], $01), $00)
                                curr106\Field9 = -10.0
                                resetentity(curr106\Field4)
                            EndIf
                        Else
                            curr106\Field9 = -10.0
                            curr106\Field24 = 0.0
                        EndIf
                        If ((-1600.0 * roomscale) > entityy(collider, $00)) Then
                            If ((144.0 * roomscale) > distance(entityx(local10\Field1\Field19[$10], $01), entityz(local10\Field1\Field19[$10], $01), entityx(collider, $00), entityz(collider, $00))) Then
                                camerafogcolor(camera, 0.0, 0.0, 0.0)
                                cameraclscolor(camera, 0.0, 0.0, 0.0)
                                dropspeed = 0.0
                                blurtimer = 500.0
                                positionentity(collider, entityx(local10\Field1\Field2, $00), 0.5, entityz(local10\Field1\Field2, $00), $00)
                                resetentity(collider)
                                local10\Field3 = 0.0
                                updatedoorstimer = 0.0
                                updatedoors()
                                updaterooms()
                            Else
                                If (0.0 <= killtimer) Then
                                    playsound_strict(horrorsfx($08))
                                EndIf
                                killtimer = min(-1.0, killtimer)
                                blurtimer = 3000.0
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideentity(local10\Field1\Field2)
                    local10\Field2 = 0.0
                    local10\Field3 = 0.0
                    local10\Field4 = 0.0
                    local10\Field15 = "0.0"
                EndIf
            Case "room2cafeteria"
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field2) Then
                        If (curr066 = Null) Then
                            curr066 = createnpc($05, entityx(local10\Field1\Field19[$02], $01), entityy(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01))
                        Else
                            positionentity(curr066\Field4, entityx(local10\Field1\Field19[$02], $01), entityy(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01), $01)
                        EndIf
                        resetentity(curr066\Field4)
                        local10\Field2 = 1.0
                    EndIf
                    If (using294 = $00) Then
                        If (1.5 > entitydistance(local10\Field1\Field19[$00], collider)) Then
                            giveachievement($0A, $01)
                            If (entityinview(local10\Field1\Field19[$00], camera) <> 0) Then
                                drawhandicon = $01
                                If (mousehit1 <> 0) Then
                                    local2 = $01
                                    For local12 = Each items
                                        If (local12\Field15 = $00) Then
                                            If (0.0 = (entityx(local12\Field1, $00) - entityx(local10\Field1\Field19[$01], $01))) Then
                                                If (0.0 = (entityz(local12\Field1, $00) - entityz(local10\Field1\Field19[$01], $01))) Then
                                                    local2 = $00
                                                    Exit
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                    local40 = $00
                                    If (2.0 > local10\Field3) Then
                                        If (selecteditem <> Null) Then
                                            If (((selecteditem\Field3\Field1 = "25ct") Or (selecteditem\Field3\Field1 = "coin")) <> 0) Then
                                                removeitem(selecteditem)
                                                selecteditem = Null
                                                local10\Field3 = (local10\Field3 + 1.0)
                                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\294\Coin_Drop.ogg")))
                                                local40 = $01
                                            EndIf
                                        EndIf
                                    EndIf
                                    If (2.0 = local10\Field3) Then
                                        using294 = local2
                                        If (using294 <> 0) Then
                                            mousehit1 = $00
                                        EndIf
                                    ElseIf (((1.0 = local10\Field3) And (local40 = $00)) <> 0) Then
                                        using294 = $00
                                        msg = scplang_getphrase("events.cafe1")
                                        msgtimer = 350.0
                                    ElseIf (local40 = $00) Then
                                        using294 = $00
                                        msg = scplang_getphrase("events.cafe2")
                                        msgtimer = 350.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2ccont"
                If (playerroom = local10\Field1) Then
                    entitypick(camera, 1.5)
                    If (pickedentity() = local10\Field1\Field19[$03]) Then
                        If (0.0 = local10\Field2) Then
                            local10\Field2 = max(local10\Field2, 1.0)
                            playsound_strict(horrorsfx($07))
                            playsound_strict(leversfx)
                        EndIf
                    EndIf
                    updatelever(local10\Field1\Field19[$01], $00)
                    local41 = (Int local10\Field3)
                    local10\Field3 = (Float updatelever(local10\Field1\Field19[$03], $00))
                    If ((((Float local41) <> local10\Field3) And (0.0 < local10\Field2)) <> 0) Then
                        playsound2(lightsfx, camera, local10\Field1\Field19[$03], 10.0, 1.0)
                    EndIf
                    If ((Int local10\Field3) <> 0) Then
                        secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                    Else
                        secondarylighton = curvevalue(0.0, secondarylighton, 10.0)
                    EndIf
                    remotedooron = updatelever(local10\Field1\Field19[$05], $00)
                    If (((0.0 < local10\Field2) And (200.0 > local10\Field2)) <> 0) Then
                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                        rotateentity(local10\Field1\Field19[$03], curvevalue(-85.0, entitypitch(local10\Field1\Field19[$03], $00), 5.0), entityyaw(local10\Field1\Field19[$03], $00), 0.0, $00)
                    EndIf
                EndIf
            Case "room2Ccont"
                If (playerroom = local10\Field1) Then
                    entitypick(camera, 1.5)
                    If (pickedentity() = local10\Field1\Field19[$03]) Then
                        If (0.0 = local10\Field2) Then
                            local10\Field2 = max(local10\Field2, 1.0)
                            playsound_strict(horrorsfx($07))
                            playsound_strict(leversfx)
                        EndIf
                    EndIf
                    updatelever(local10\Field1\Field19[$01], $00)
                    local42 = (Int local10\Field3)
                    local10\Field3 = (Float updatelever(local10\Field1\Field19[$03], $00))
                    If ((((Float local42) <> local10\Field3) And (0.0 < local10\Field2)) <> 0) Then
                        playsound2(lightsfx, camera, local10\Field1\Field19[$03], 10.0, 1.0)
                    EndIf
                    If ((Int local10\Field3) <> 0) Then
                        secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                    Else
                        secondarylighton = curvevalue(0.0, secondarylighton, 10.0)
                    EndIf
                    remotedooron = updatelever(local10\Field1\Field19[$05], $00)
                    If (((0.0 < local10\Field2) And (200.0 > local10\Field2)) <> 0) Then
                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                        rotateentity(local10\Field1\Field19[$03], curvevalue(-85.0, entitypitch(local10\Field1\Field19[$03], $00), 5.0), entityyaw(local10\Field1\Field19[$03], $00), 0.0, $00)
                    EndIf
                EndIf
            Case "room2closets"
                If (0.0 = local10\Field2) Then
                    If (((playerroom = local10\Field1) And (2.0 > curr173\Field24)) <> 0) Then
                        If (((local10\Field15 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field15 = "load0"
                        EndIf
                    EndIf
                Else
                    local10\Field2 = (local10\Field2 + local23\Field3[$00])
                    If (245.0 > local10\Field2) Then
                        rotateentity(local10\Field1\Field22[$01]\Field4, 0.0, curveangle((Float (local10\Field1\Field6 + $5A)), entityyaw(local10\Field1\Field22[$01]\Field4, $00), 100.0), 0.0, $01)
                        local10\Field1\Field22[$00]\Field9 = 1.0
                        If (((224.0 < local10\Field2) And (224.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                            playsound2(introsfx($0F), camera, local10\Field1\Field2, 15.0, 1.0)
                        EndIf
                    ElseIf (455.0 > local10\Field2) Then
                        If (245.0 > (local10\Field2 - local23\Field3[$00])) Then
                            local10\Field1\Field22[$00]\Field9 = 0.0
                            local10\Field1\Field22[$01]\Field17 = playsound2(local10\Field1\Field22[$01]\Field16, camera, local10\Field1\Field22[$01]\Field4, 12.0, 1.0)
                        EndIf
                        If (315.0 < local10\Field2) Then
                            pointentity(local10\Field1\Field22[$00]\Field0, local10\Field1\Field2, 0.0)
                            rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$00]\Field0, $00), entityyaw(local10\Field1\Field22[$00]\Field4, $00), 30.0), 0.0, $01)
                        EndIf
                        pointentity(local10\Field1\Field22[$01]\Field0, local10\Field1\Field2, 0.0)
                        turnentity(local10\Field1\Field22[$01]\Field0, 0.0, (sin(local10\Field2) * 5.0), 0.0, $00)
                        rotateentity(local10\Field1\Field22[$01]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$01]\Field0, $00), entityyaw(local10\Field1\Field22[$01]\Field4, $00), 30.0), 0.0, $01)
                    Else
                        If (455.0 > (local10\Field2 - local23\Field3[$00])) Then
                            playsound_strict(horrorsfx($00))
                            playsound_strict(lightsfx)
                            lightblink = 8.0
                        EndIf
                        If (((539.0 < local10\Field2) And (539.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                            playsound2(necksnapsfx($00), camera, local10\Field1\Field22[$00]\Field4, 8.0, 1.0)
                            If (wearingnightvision <> 0) Then
                                blinktimer = -11.0
                                positionentity(curr173\Field4, entityx(local10\Field1\Field22[$00]\Field4, $01), (entityy(local10\Field1\Field22[$00]\Field4, $01) + 0.1), entityz(local10\Field1\Field22[$00]\Field4, $01), $00)
                                pointentity(curr173\Field4, local10\Field1\Field22[$00]\Field4, 0.0)
                                resetentity(curr173\Field4)
                                curr173\Field24 = 1.0
                            Else
                                local10\Field1\Field22[$00]\Field9 = 6.0
                                setnpcframe(local10\Field1\Field22[$00], 629.0)
                            EndIf
                        EndIf
                        If (((560.0 < local10\Field2) And (560.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                            playsound2(necksnapsfx($01), camera, local10\Field1\Field22[$01]\Field4, 8.0, 1.0)
                            If (wearingnightvision <> 0) Then
                                blinktimer = -11.0
                                positionentity(curr173\Field4, entityx(local10\Field1\Field22[$01]\Field4, $01), (entityy(local10\Field1\Field22[$01]\Field4, $01) + 0.1), entityz(local10\Field1\Field22[$01]\Field4, $01), $00)
                                pointentity(curr173\Field4, local10\Field1\Field22[$00]\Field4, 0.0)
                                resetentity(curr173\Field4)
                                curr173\Field24 = 1.0
                            Else
                                local10\Field1\Field22[$01]\Field9 = 8.0
                                setnpcframe(local10\Field1\Field22[$01], 676.0)
                            EndIf
                        EndIf
                        If (wearingnightvision <> 0) Then
                            If (525.0 < local10\Field2) Then
                                animate2(local10\Field1\Field22[$00]\Field0, animtime(local10\Field1\Field22[$00]\Field0), $22B, $275, 0.5, $00)
                                If (628.0 <= animtime(local10\Field1\Field22[$00]\Field0)) Then
                                    setnpcframe(local10\Field1\Field22[$00], 629.0)
                                EndIf
                                local10\Field1\Field22[$00]\Field9 = 6.0
                            EndIf
                            If (((560.0 < local10\Field2) And (667.45 > local10\Field2)) <> 0) Then
                                animate2(local10\Field1\Field22[$01]\Field0, animtime(local10\Field1\Field22[$01]\Field0), $276, $2A4, 0.5, $00)
                                If (675.0 <= animtime(local10\Field1\Field22[$01]\Field0)) Then
                                    setnpcframe(local10\Field1\Field22[$01], 676.0)
                                EndIf
                                local10\Field1\Field22[$01]\Field9 = 8.0
                            EndIf
                        EndIf
                        If (((637.0 < local10\Field2) And (637.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                            local12 = createitem("Wallet", "wallet", entityx(local10\Field1\Field19[$02], $01), entityy(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01), $00, $00, $00, 1.0, $00)
                            entitytype(local12\Field1, $03, $00)
                            pointentity(local12\Field1, local10\Field1\Field22[$00]\Field4, 0.0)
                            rotateentity(local12\Field1, 0.0, (Float rand($168, $01)), 0.0, $00)
                            teleportentity(local12\Field1, entityx(local12\Field1, $00), entityy(local12\Field1, $00), entityz(local12\Field1, $00), -0.02, $01, 10.0, $00)
                            For local1 = $00 To $01 Step $01
                                local13 = createitem("Quarter", "25ct", 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00)
                                local13\Field15 = $01
                                local13\Field16 = $FFFFFFFF
                                local13\Field3\Field3 = $01
                                local12\Field21[local1] = local13
                                hideentity(local13\Field1)
                                entitytype(local13\Field1, $03, $00)
                            Next
                        EndIf
                        If (700.0 < local10\Field2) Then
                            If (wearingnightvision <> 0) Then
                                blinktimer = -11.0
                            EndIf
                            positionentity(curr173\Field4, ((entityx(local10\Field1\Field19[$00], $01) + entityx(local10\Field1\Field19[$01], $01)) / 2.0), entityy(local10\Field1\Field19[$00], $01), ((entityz(local10\Field1\Field19[$00], $01) + entityz(local10\Field1\Field19[$01], $01)) / 2.0), $00)
                            pointentity(curr173\Field4, collider, 0.0)
                            resetentity(curr173\Field4)
                            curr173\Field24 = 0.0
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room2doors173"
                If (playerroom = local10\Field1) Then
                    If (((0.0 = local10\Field2) And (0.0 = curr173\Field24)) <> 0) Then
                        If (entityinview(curr173\Field0, camera) = $00) Then
                            local10\Field2 = 1.0
                            positionentity(curr173\Field4, entityx(local10\Field1\Field19[$00], $01), 0.5, entityz(local10\Field1\Field19[$00], $01), $00)
                            resetentity(curr173\Field4)
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room2elevator"
                If (0.0 = local10\Field2) Then
                    If (((8.0 > local10\Field1\Field8) And (0.0 < local10\Field1\Field8)) <> 0) Then
                        local10\Field1\Field22[$00] = createnpc($13, entityx(local10\Field1\Field2, $01), 0.5, entityz(local10\Field1\Field2, $01))
                        pointentity(local10\Field1\Field22[$00]\Field4, collider, 0.0)
                        rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, entityyaw(local10\Field1\Field22[$00]\Field4, $00), 0.0, $01)
                        local10\Field2 = 1.0
                    EndIf
                ElseIf (1.0 = local10\Field2) Then
                    If (((5.0 > local10\Field1\Field8) Or (rand($2BC, $01) = $01)) <> 0) Then
                        local10\Field2 = 2.0
                        local10\Field1\Field22[$00]\Field9 = 5.0
                        local10\Field1\Field22[$00]\Field33 = entityx(local10\Field1\Field19[$01], $01)
                        local10\Field1\Field22[$00]\Field34 = entityy(local10\Field1\Field19[$01], $01)
                        local10\Field1\Field22[$00]\Field35 = entityz(local10\Field1\Field19[$01], $01)
                    EndIf
                ElseIf (2.0 = local10\Field2) Then
                    If (2.0 > entitydistance(local10\Field1\Field22[$00]\Field4, local10\Field1\Field19[$01])) Then
                        local10\Field1\Field21[$00]\Field5 = $00
                        playsound2(closedoorsfx($03, $00), camera, local10\Field1\Field21[$00]\Field0, 8.0, 1.0)
                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\Room2ElevatorDeath.ogg")))
                        local10\Field2 = 2.05
                    EndIf
                ElseIf (910.0 > local10\Field2) Then
                    local10\Field2 = (local10\Field2 + local23\Field3[$00])
                    If (((469.0 < local10\Field2) And (518.0 > local10\Field2)) <> 0) Then
                        camerashake = (7.4 - (local10\Field2 / 70.0))
                    ElseIf (((602.0 < local10\Field2) And (742.0 > local10\Field2)) <> 0) Then
                        camerashake = (10.6 - (local10\Field2 / 70.0))
                    ElseIf (882.0 < local10\Field2) Then
                        camerashake = 0.0
                        If (((882.0 > (local10\Field2 - local23\Field3[$00])) And (local10\Field1\Field22[$00] <> Null)) <> 0) Then
                            removenpc(local10\Field1\Field22[$00])
                            local10\Field1\Field22[$00] = Null
                            local30 = createdecal($03, entityx(local10\Field1\Field19[$00], $01), 0.0005, entityz(local10\Field1\Field19[$00], $01), 90.0, rnd(360.0, 0.0), 0.0)
                            local30 = createdecal($11, entityx(local10\Field1\Field19[$00], $01), 0.002, entityz(local10\Field1\Field19[$00], $01), 90.0, rnd(360.0, 0.0), 0.0)
                            local30\Field2 = 0.5
                            local30 = createdecal($03, entityx(local10\Field1\Field19[$01], $01), entityy(local10\Field1\Field19[$01], $01), entityz(local10\Field1\Field19[$01], $01), 0.0, (Float (local10\Field1\Field6 + $10E)), 0.0)
                            local30\Field2 = 0.9
                        EndIf
                        local10\Field1\Field21[$00]\Field4 = $00
                    EndIf
                ElseIf (local10\Field1\Field21[$00]\Field5 <> 0) Then
                    local10\Field1\Field21[$00]\Field4 = $01
                    removeevent(local10)
                EndIf
            Case "room2elevator2"
                If (((8.0 > local10\Field1\Field8) And (0.0 < local10\Field1\Field8)) <> 0) Then
                    local30 = createdecal($03, entityx(local10\Field1\Field19[$00], $01), 0.0005, entityz(local10\Field1\Field19[$00], $01), 90.0, rnd(360.0, 0.0), 0.0)
                    local10\Field1\Field22[$00] = createnpc($12, entityx(local10\Field1\Field19[$00], $01), 0.5, entityz(local10\Field1\Field19[$00], $01))
                    changenpctextureid(local10\Field1\Field22[$00], $00)
                    rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (entityyaw(local10\Field1\Field2, $00) - 80.0), 0.0, $01)
                    setnpcframe(local10\Field1\Field22[$00], 19.0)
                    local10\Field1\Field22[$00]\Field9 = 8.0
                    removeevent(local10)
                EndIf
            Case "room2fan"
                If (playerroom = local10\Field1) Then
                    turnentity(local10\Field1\Field19[$00], (local10\Field4 * local23\Field3[$00]), 0.0, 0.0, $00)
                    If (0.01 < local10\Field4) Then
                        local10\Field1\Field9 = loopsound2(roomambience[$09], local10\Field1\Field9, camera, local10\Field1\Field19[$00], 5.0, (local10\Field4 / 4.0))
                    EndIf
                    local10\Field4 = curvevalue((local10\Field3 * 5.0), local10\Field4, 150.0)
                EndIf
                If (16.0 > local10\Field1\Field8) Then
                    If (0.0 > local10\Field2) Then
                        local10\Field2 = (Float (rand($0F, $1E) * $46))
                        local2 = (Int local10\Field3)
                        local10\Field3 = (Float rand($00, $01))
                        If (playerroom <> local10\Field1) Then
                            local10\Field4 = (local10\Field3 * 5.0)
                        ElseIf (((local2 = $00) And (1.0 = local10\Field3)) <> 0) Then
                            playsound2(loadtempsound(scpmodding_processfilepath("SFX\Ambient\Room ambience\FanOn.ogg")), camera, local10\Field1\Field19[$00], 8.0, 1.0)
                        ElseIf (((local2 = $01) And (0.0 = local10\Field3)) <> 0) Then
                            playsound2(loadtempsound(scpmodding_processfilepath("SFX\Ambient\Room ambience\FanOff.ogg")), camera, local10\Field1\Field19[$00], 8.0, 1.0)
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 - local23\Field3[$00])
                    EndIf
                EndIf
            Case "room2nuke"
                If (playerroom = local10\Field1) Then
                    local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$04], local10\Field1\Field19[$05], local10, $01)
                    local10\Field2 = (Float updatelever(local10\Field1\Field19[$01], $00))
                    updatelever(local10\Field1\Field19[$03], $00)
                EndIf
                If (0.0 = local10\Field4) Then
                    local10\Field1\Field22[$00] = createnpc($12, entityx(local10\Field1\Field19[$06], $01), 0.5, entityz(local10\Field1\Field19[$06], $01))
                    turnentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $5A)), 0.0, $00)
                    changenpctextureid(local10\Field1\Field22[$00], $09)
                    local10\Field1\Field22[$00]\Field9 = 3.0
                    setnpcframe(local10\Field1\Field22[$00], 40.0)
                    local10\Field1\Field22[$00]\Field48 = $01
                    local10\Field4 = 1.0
                EndIf
            Case "room2offices2"
                If (playerroom = local10\Field1) Then
                    If (((-8.0 > blinktimer) And (-12.0 < blinktimer)) <> 0) Then
                        local2 = rand($01, $04)
                        giveachievement($35, $01)
                        positionentity(local10\Field1\Field19[$00], entityx(local10\Field1\Field19[local2], $01), entityy(local10\Field1\Field19[local2], $01), entityz(local10\Field1\Field19[local2], $01), $01)
                        rotateentity(local10\Field1\Field19[$00], 0.0, rnd(360.0, 0.0), 0.0, $00)
                    EndIf
                EndIf
            Case "room2offices3"
                If (playerroom = local10\Field1) Then
                    local10\Field2 = (local10\Field2 + local23\Field3[$00])
                    If (700.0 < local10\Field2) Then
                        If (0.5 < entitydistance(local10\Field1\Field21[$00]\Field0, collider)) Then
                            If (entityinview(local10\Field1\Field21[$00]\Field0, camera) = $00) Then
                                local10\Field1\Field21[$00]\Field5 = $01
                                removeevent(local10)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2tesla"
                local2 = $01
                If (((245.0 < local10\Field3) And (6300.0 > local10\Field3)) <> 0) Then
                    local2 = $00
                EndIf
                If (((local2 And (entityy(local10\Field1\Field2, $01) < entityy(collider, $01))) And (4.0 > entityy(collider, $01))) <> 0) Then
                    If (local10\Field9 = $00) Then
                        local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Tesla\Shock.ogg"))
                    EndIf
                    If (0.0 = local10\Field2) Then
                        If (8.0 > local10\Field1\Field8) Then
                            hideentity(local10\Field1\Field19[$03])
                            If ((millisecs2() Mod $5DC) < $320) Then
                                showentity(local10\Field1\Field19[$04])
                            Else
                                hideentity(local10\Field1\Field19[$04])
                            EndIf
                            If (local10\Field6 = $00) Then
                                local10\Field6 = playsound2(teslaidlesfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                            ElseIf (channelplaying(local10\Field6) = $00) Then
                                local10\Field6 = playsound2(teslaidlesfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                            EndIf
                            For local1 = $00 To $02 Step $01
                                If ((300.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                    If (0.0 <= killtimer) Then
                                        playersoundvolume = max(8.0, playersoundvolume)
                                        stopchannel(local10\Field6)
                                        local10\Field6 = playsound2(teslaactivatesfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                                        local10\Field2 = 1.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            local43 = $01
                            For local11 = Each events
                                If (((local11\Field0 = local10\Field0) And (local11 <> local10)) <> 0) Then
                                    If (local11\Field15 <> "") Then
                                        local43 = $00
                                        local10\Field15 = "done"
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            local44 = $00
                            If (local43 <> 0) Then
                                If (((local10\Field15 = "") And (playerroom = local10\Field1)) <> 0) Then
                                    If (entitydistance(local10\Field1\Field19[$06], collider) > entitydistance(local10\Field1\Field19[$05], collider)) Then
                                        local44 = $06
                                    Else
                                        local44 = $05
                                    EndIf
                                    local10\Field1\Field22[$00] = createnpc($11, entityx(local10\Field1\Field19[local44], $01), 0.5, entityz(local10\Field1\Field19[local44], $01))
                                    pointentity(local10\Field1\Field22[$00]\Field4, local10\Field1\Field19[$02], 0.0)
                                    local10\Field1\Field22[$00]\Field9 = 2.0
                                    local10\Field15 = "step1"
                                    local10\Field2 = 0.0
                                    local10\Field3 = 0.0
                                    local10\Field4 = 0.0
                                EndIf
                            EndIf
                        Else
                            hideentity(local10\Field1\Field19[$04])
                        EndIf
                        If (((-10.0 > curr106\Field9) And (0.0 = local10\Field2)) <> 0) Then
                            For local1 = $00 To $02 Step $01
                                If ((300.0 * roomscale) > distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                    If (0.0 <= killtimer) Then
                                        stopchannel(local10\Field6)
                                        local10\Field6 = playsound2(teslaactivatesfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                                        hideentity(local10\Field1\Field19[$04])
                                        local10\Field2 = 1.0
                                        curr106\Field9 = (Float (rand($0A, $0D) * $1068))
                                        giveachievement($24, $01)
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                        For local8 = Each npcs
                            If (local8\Field5 = $06) Then
                                If (((4.0 = local8\Field9) And (0.0 = local10\Field2)) <> 0) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(local8\Field4, $00), entityz(local8\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                            If (0.0 <= killtimer) Then
                                                stopchannel(local10\Field6)
                                                local10\Field6 = playsound2(teslaactivatesfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                                                hideentity(local10\Field1\Field19[$04])
                                                local10\Field2 = 1.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        Next
                        For local8 = Each npcs
                            If (local8\Field5 = $03) Then
                                If (0.0 = local10\Field2) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(local8\Field4, $00), entityz(local8\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                            If (0.0 <= killtimer) Then
                                                stopchannel(local10\Field6)
                                                local10\Field6 = playsound2(teslaactivatesfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                                                hideentity(local10\Field1\Field19[$04])
                                                local10\Field2 = 1.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        Next
                        For local8 = Each npcs
                            If (((((local8\Field5 = $04) Or (local8\Field5 = $17)) Or (local8\Field5 = $01)) Or (local8\Field5 = $16)) <> 0) Then
                                If ((((1.0 < local8\Field9) And (0.0 = local10\Field2)) And (local8\Field48 = $00)) <> 0) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(local8\Field4, $00), entityz(local8\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                            If (0.0 <= killtimer) Then
                                                stopchannel(local10\Field6)
                                                local10\Field6 = playsound2(teslaactivatesfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                                                hideentity(local10\Field1\Field19[$04])
                                                local10\Field2 = 1.0
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        Next
                    Else
                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                        If (40.0 >= local10\Field2) Then
                            hideentity(local10\Field1\Field19[$03])
                            If ((millisecs2() Mod $64) < $32) Then
                                showentity(local10\Field1\Field19[$04])
                            Else
                                hideentity(local10\Field1\Field19[$04])
                            EndIf
                        Else
                            If (2.0 > local10\Field1\Field8) Then
                                If (40.0 >= (local10\Field2 - local23\Field3[$00])) Then
                                    playsound_strict(local10\Field9)
                                EndIf
                            ElseIf (40.0 >= (local10\Field2 - local23\Field3[$00])) Then
                                playsound2(local10\Field9, camera, local10\Field1\Field19[$02], 10.0, 1.0)
                            EndIf
                            If (70.0 > local10\Field2) Then
                                If (0.0 <= killtimer) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                            showentity(at\Field4[$0E])
                                            lightflash = 0.4
                                            camerashake = 1.0
                                            kill($00, $00)
                                            deathmsg = ("Subject D-9341 " + scplang_getphrase("events.tesla"))
                                        EndIf
                                    Next
                                EndIf
                                If (local10\Field15 = "step1") Then
                                    local10\Field1\Field22[$00]\Field9 = 3.0
                                EndIf
                                If (-10.0 > curr106\Field9) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                            showentity(at\Field4[$0E])
                                            If (playerroom = local10\Field1) Then
                                                lightflash = 0.3
                                            EndIf
                                            If (particleamount > $00) Then
                                                For local1 = $00 To (((particleamount - $01) * $05) + $05) Step $01
                                                    local7 = createparticle(entityx(curr106\Field4, $01), entityy(curr106\Field4, $01), entityz(curr106\Field4, $01), $00, 0.015, -0.2, $FA)
                                                    local7\Field7 = 0.03
                                                    local7\Field10 = -0.2
                                                    local7\Field16 = 200.0
                                                    local7\Field15 = 0.005
                                                    local7\Field8 = 0.001
                                                    rotateentity(local7\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                                Next
                                            EndIf
                                            curr106\Field9 = -20000.0
                                            translateentity(curr106\Field4, 0.0, -50.0, 0.0, $01)
                                        EndIf
                                    Next
                                EndIf
                                For local8 = Each npcs
                                    If (local8\Field5 = $06) Then
                                        If (4.0 = local8\Field9) Then
                                            For local1 = $00 To $02 Step $01
                                                If ((200.0 * roomscale) > distance(entityx(local8\Field4, $00), entityz(local8\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                                    showentity(at\Field4[$0E])
                                                    If (playerroom = local10\Field1) Then
                                                        lightflash = 0.3
                                                    EndIf
                                                    If (particleamount > $00) Then
                                                        For local1 = $00 To (((particleamount - $01) * $05) + $05) Step $01
                                                            local7 = createparticle(entityx(local8\Field4, $01), entityy(local8\Field4, $01), entityz(local8\Field4, $01), $00, 0.015, -0.2, $FA)
                                                            local7\Field7 = 0.03
                                                            local7\Field10 = -0.2
                                                            local7\Field16 = 200.0
                                                            local7\Field15 = 0.005
                                                            local7\Field8 = 0.001
                                                            rotateentity(local7\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                                        Next
                                                    EndIf
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                Next
                                For local8 = Each npcs
                                    If (local8\Field5 = $03) Then
                                        For local1 = $00 To $02 Step $01
                                            If ((200.0 * roomscale) > distance(entityx(local8\Field4, $00), entityz(local8\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                                showentity(at\Field4[$0E])
                                                If (playerroom = local10\Field1) Then
                                                    lightflash = 0.3
                                                EndIf
                                                If (particleamount > $00) Then
                                                    For local1 = $00 To (((particleamount - $01) * $05) + $05) Step $01
                                                        local7 = createparticle(entityx(local8\Field4, $01), entityy(local8\Field4, $01), entityz(local8\Field4, $01), $00, 0.015, -0.2, $FA)
                                                        local7\Field7 = 0.03
                                                        local7\Field10 = -0.2
                                                        local7\Field16 = 200.0
                                                        local7\Field15 = 0.005
                                                        local7\Field8 = 0.001
                                                        rotateentity(local7\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                                    Next
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                Next
                                For local8 = Each npcs
                                    If (((((local8\Field5 = $04) Or (local8\Field5 = $17)) Or (local8\Field5 = $01)) Or (local8\Field5 = $16)) <> 0) Then
                                        If (((1.0 < local8\Field9) And (local8\Field48 = $00)) <> 0) Then
                                            For local1 = $00 To $02 Step $01
                                                If ((200.0 * roomscale) > distance(entityx(local8\Field4, $00), entityz(local8\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                                    showentity(at\Field4[$0E])
                                                    If (playerroom = local10\Field1) Then
                                                        lightflash = 0.3
                                                    EndIf
                                                    If (particleamount > $00) Then
                                                        For local1 = $00 To (((particleamount - $01) * $05) + $05) Step $01
                                                            local7 = createparticle(entityx(local8\Field4, $01), entityy(local8\Field4, $01), entityz(local8\Field4, $01), $00, 0.015, -0.2, $FA)
                                                            local7\Field7 = 0.03
                                                            local7\Field10 = -0.2
                                                            local7\Field16 = 200.0
                                                            local7\Field15 = 0.005
                                                            local7\Field8 = 0.001
                                                            rotateentity(local7\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                                        Next
                                                    EndIf
                                                    local8\Field48 = $01
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                Next
                                hideentity(local10\Field1\Field19[$03])
                                hideentity(local10\Field1\Field19[$04])
                                If (rand($05, $01) < $05) Then
                                    positiontexture(at\Field5[$0F], 0.0, rnd(0.0, 1.0))
                                    showentity(local10\Field1\Field19[$03])
                                EndIf
                            Else
                                If (70.0 > (local10\Field2 - local23\Field3[$00])) Then
                                    stopchannel(local10\Field6)
                                    local10\Field6 = playsound2(teslapowerupsfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                                EndIf
                                hideentity(local10\Field1\Field19[$03])
                                If (150.0 < local10\Field2) Then
                                    local10\Field2 = 0.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideentity(local10\Field1\Field19[$04])
                EndIf
                If (local10\Field1\Field22[$00] <> Null) Then
                    If (((local10\Field15 = "step1") And (3.0 <> local10\Field1\Field22[$00]\Field9)) <> 0) Then
                        If (0.0 = local10\Field2) Then
                            For local1 = $00 To $02 Step $01
                                If ((400.0 * roomscale) > distance(entityx(local10\Field1\Field22[$00]\Field4, $00), entityz(local10\Field1\Field22[$00]\Field4, $00), entityx(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01))) Then
                                    stopchannel(local10\Field6)
                                    local10\Field6 = playsound2(teslaactivatesfx, camera, local10\Field1\Field19[$03], 4.0, 0.5)
                                    hideentity(local10\Field1\Field19[$04])
                                    local10\Field2 = 1.0
                                    Exit
                                EndIf
                            Next
                        EndIf
                    ElseIf (((local10\Field15 = "step1") And (3.0 = local10\Field1\Field22[$00]\Field9)) <> 0) Then
                        local10\Field1\Field22[$00]\Field22 = 0.0
                        animatenpc(local10\Field1\Field22[$00], 41.0, 60.0, 0.5, $00)
                        If (60.0 = local10\Field1\Field22[$00]\Field14) Then
                            local10\Field1\Field22[$00]\Field48 = $01
                            local10\Field15 = "step2"
                            setnpcframe(local10\Field1\Field22[$00], 57.0)
                        EndIf
                    ElseIf (local10\Field15 = "step2") Then
                        animatenpc(local10\Field1\Field22[$00], 57.0, 60.0, 0.5, $00)
                        If (60.0 = local10\Field1\Field22[$00]\Field14) Then
                            local10\Field15 = "0"
                        EndIf
                    ElseIf ((((local10\Field15 <> "") And (local10\Field15 <> "step1")) And (local10\Field15 <> "done")) <> 0) Then
                        If (700.0 > (Float local10\Field15)) Then
                            If (particleamount > $00) Then
                                If (rand(($14 - ((particleamount - $01) * $0A)), $01) = $01) Then
                                    local7 = createparticle(entityx(local10\Field1\Field22[$00]\Field4, $00), (entityy(local10\Field1\Field22[$00]\Field0, $00) + 0.05), entityz(local10\Field1\Field22[$00]\Field4, $00), $00, 0.05, 0.0, $3C)
                                    local7\Field8 = 0.002
                                    rotateentity(local7\Field1, 0.0, entityyaw(local10\Field1\Field22[$00]\Field4, $00), 0.0, $00)
                                    moveentity(local7\Field1, rnd(-0.1, 0.1), 0.0, (rnd(0.0, 0.5) + 0.1))
                                    rotateentity(local7\Field1, -90.0, entityyaw(local10\Field1\Field22[$00]\Field4, $00), 0.0, $00)
                                    local7\Field14 = -0.02
                                EndIf
                            EndIf
                            local10\Field15 = (Str ((Float local10\Field15) + local23\Field3[$00]))
                        Else
                            local10\Field15 = "done"
                        EndIf
                    EndIf
                EndIf
                If (((playerroom\Field7\Field10 <> "pocketdimension") And (playerroom\Field7\Field10 <> "room860")) <> 0) Then
                    If (0.0 = local10\Field3) Then
                        If (0.0 >= local10\Field4) Then
                            local2 = $00
                            For local8 = Each npcs
                                If (local8\Field5 = $14) Then
                                    If (4.0 > (Abs (entityx(local8\Field4, $00) - entityx(local10\Field1\Field2, $01)))) Then
                                        If (4.0 > (Abs (entityz(local8\Field4, $00) - entityz(local10\Field1\Field2, $01)))) Then
                                            local2 = $01
                                            If (0.0 = local10\Field3) Then
                                                local8\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\Tesla0.ogg"))
                                                playmtfsound(local8\Field16, local8)
                                                local8\Field24 = 700.0
                                                local10\Field3 = 7000.0
                                            EndIf
                                        EndIf
                                    EndIf
                                ElseIf (local8\Field5 = $1C) Then
                                    If (4.0 > (Abs (entityx(local8\Field4, $00) - entityx(local10\Field1\Field2, $01)))) Then
                                        If (4.0 > (Abs (entityz(local8\Field4, $00) - entityz(local10\Field1\Field2, $01)))) Then
                                            local2 = $01
                                            If (0.0 = local10\Field3) Then
                                                local8\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF2\Tesla0.ogg"))
                                                playmtfsound(local8\Field16, local8)
                                                local8\Field24 = 700.0
                                                local10\Field3 = 7000.0
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local2 = $00) Then
                                local10\Field3 = 245.0
                            EndIf
                            local10\Field4 = (local10\Field4 + 140.0)
                        Else
                            local10\Field4 = (local10\Field4 - local23\Field3[$00])
                        EndIf
                    Else
                        If (((6440.0 <= local10\Field3) And (6440.0 > (local10\Field3 - local23\Field3[$00]))) <> 0) Then
                            playannouncement(scpmodding_processfilepath((("SFX\Character\MTF\Tesla" + (Str rand($01, $03))) + ".ogg")))
                        EndIf
                        local10\Field3 = max((local10\Field3 - local23\Field3[$00]), 0.0)
                    EndIf
                EndIf
            Case "room2trick"
                If (playerroom = local10\Field1) Then
                    If (2.0 > entitydistance(local10\Field1\Field2, collider)) Then
                        If (((6.0 > entitydistance(collider, curr173\Field0)) Or (6.0 > entitydistance(collider, curr106\Field0))) <> 0) Then
                            removeevent(local10)
                        Else
                            local3 = createpivot($00)
                            positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                            pointentity(local3, local10\Field1\Field2, 0.0)
                            rotateentity(local3, 0.0, entityyaw(local3, $00), 0.0, $01)
                            moveentity(local3, 0.0, 0.0, (entitydistance(local3, local10\Field1\Field2) * 2.0))
                            blinktimer = -10.0
                            playsound_strict(horrorsfx($0B))
                            positionentity(collider, entityx(local3, $00), (entityy(local3, $00) + 0.05), entityz(local3, $00), $00)
                            updateworld(1.0)
                            turnentity(collider, 0.0, 180.0, 0.0, $00)
                            freeentity(local3)
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room2tunnel"
                If (((8.0 <= entityy(collider, $01)) And (12.0 >= entityy(collider, $01))) <> 0) Then
                    If ((((local10\Field1\Field3 - 6.0) <= entityx(collider, $01)) And (((local10\Field1\Field3 + 38.0) + 6.0) >= entityx(collider, $01))) <> 0) Then
                        If ((((local10\Field1\Field5 - 6.0) <= entityz(collider, $01)) And (((local10\Field1\Field5 + 38.0) + 6.0) >= entityz(collider, $01))) <> 0) Then
                            playerroom = local10\Field1
                        EndIf
                    EndIf
                EndIf
                If (playerroom = local10\Field1) Then
                    If (i_zone\Field2 <> 0) Then
                        If (local10\Field1\Field23\Field2[$00] = $00) Then
                            placegrid_mapcreator(local10\Field1)
                        EndIf
                    EndIf
                    If (local10\Field1\Field23 = Null) Then
                        local10\Field1\Field23 = (New grids)
                        local56 = rndseed()
                        seedrnd(generateseednumber(randomseed))
                        local57 = (rand($00, $01) Shl $01)
                        local54 = (rand($FFFFFFFE, $02) + $09)
                        local55 = (rand($FFFFFFFE, $02) + $09)
                        local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $01
                        If (local57 = $02) Then
                            local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] = $01
                        Else
                            local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] = $01
                        EndIf
                        local58 = $02
                        While (local58 < $64)
                            local52 = (rand($01, $05) Shl rand($01, $02))
                            For local1 = $01 To local52 Step $01
                                local53 = $01
                                Select local57
                                    Case $00
                                        If (local54 < ($11 - (local1 Mod $02))) Then
                                            local54 = (local54 + $01)
                                        Else
                                            local53 = $00
                                        EndIf
                                    Case $01
                                        If (local55 < ($11 - (local1 Mod $02))) Then
                                            local55 = (local55 + $01)
                                        Else
                                            local53 = $00
                                        EndIf
                                    Case $02
                                        If (local54 > ((local1 Mod $02) + $01)) Then
                                            local54 = (local54 - $01)
                                        Else
                                            local53 = $00
                                        EndIf
                                    Case $03
                                        If (local55 > ((local1 Mod $02) + $01)) Then
                                            local55 = (local55 - $01)
                                        Else
                                            local53 = $00
                                        EndIf
                                End Select
                                If (local53 <> 0) Then
                                    If (local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $00) Then
                                        local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $01
                                        local58 = (local58 + $01)
                                    EndIf
                                Else
                                    Exit
                                EndIf
                            Next
                            local57 = (local57 + ((rand($00, $01) Shl $01) - $01))
                            While (local57 < $00)
                                local57 = (local57 + $04)
                            Wend
                            While (local57 > $03)
                                local57 = (local57 - $04)
                            Wend
                        Wend
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field23\Field0[((local55 * $13) + local54)] > $00) Then
                                    local10\Field1\Field23\Field0[((local55 * $13) + local54)] = ((((local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] > $00) + (local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)] > $00)) + (local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] > $00)) + (local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] > $00))
                                EndIf
                            Next
                        Next
                        local60 = $12
                        local61 = $00
                        For local54 = $00 To local60 Step $01
                            For local55 = $00 To $12 Step $01
                                If (local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] > $00) Then
                                    local60 = local54
                                    If (((local10\Field1\Field23\Field0[((local54 + $01) + ((local55 + $01) * $13))] < $03) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $03)) <> 0) Then
                                        local61 = $01
                                        If (rand($00, $01) = $01) Then
                                            local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] = (local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] + $01)
                                            local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $07
                                            local61 = $00
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local61 <> 0) Then
                                local54 = (local54 - $01)
                            EndIf
                        Next
                        local62 = $FFFFFFFF
                        local65 = $FFFFFFFF
                        local62 = $FFFFFFFF
                        local65 = $FFFFFFFF
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $02) Then
                                    If (((local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] > $00) And (local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] > $00)) <> 0) Then
                                        If (((local62 = $FFFFFFFF) Or (local64 = $FFFFFFFF)) <> 0) Then
                                            If (((((local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] < $03) And (local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] < $03)) And (local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)] < $03)) And (local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] < $03)) <> 0) Then
                                                If (((((local10\Field1\Field23\Field0[((local54 - $01) + ((local55 - $01) * $13))] < $01) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field23\Field0[((local54 - $01) + ((local55 + $01) * $13))] < $01)) <> 0) Then
                                                    local62 = local54
                                                    local64 = local55
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (((((local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] < $03) And (local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] < $03)) And (local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)] < $03)) And (local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] < $03)) <> 0) Then
                                            If (((((local10\Field1\Field23\Field0[((local54 - $01) + ((local55 - $01) * $13))] < $01) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field23\Field0[((local54 - $01) + ((local55 + $01) * $13))] < $01)) <> 0) Then
                                                local63 = local54
                                                local65 = local55
                                            EndIf
                                        EndIf
                                    ElseIf (((local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] > $00) And (local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)] > $00)) <> 0) Then
                                        If (((local62 = $FFFFFFFF) Or (local64 = $FFFFFFFF)) <> 0) Then
                                            If (((((local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] < $03) And (local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] < $03)) And (local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)] < $03)) And (local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] < $03)) <> 0) Then
                                                If (((((local10\Field1\Field23\Field0[((local54 - $01) + ((local55 - $01) * $13))] < $01) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field23\Field0[((local54 - $01) + ((local55 + $01) * $13))] < $01)) <> 0) Then
                                                    local62 = local54
                                                    local64 = local55
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (((((local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] < $03) And (local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] < $03)) And (local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)] < $03)) And (local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] < $03)) <> 0) Then
                                            If (((((local10\Field1\Field23\Field0[((local54 - $01) + ((local55 - $01) * $13))] < $01) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field23\Field0[((local54 + $01) + ((local55 - $01) * $13))] < $01)) And (local10\Field1\Field23\Field0[((local54 - $01) + ((local55 + $01) * $13))] < $01)) <> 0) Then
                                                local63 = local54
                                                local65 = local55
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        If (((local63 = local62) And (local65 = local64)) <> 0) Then
                            runtimeerror("The maintenance tunnels could not be generated properly!")
                        EndIf
                        For local1 = $00 To $06 Step $01
                            local45[local1] = copyentity(local22\Field1[local1], $00)
                            hideentity(local45[local1])
                        Next
                        freetexturecache()
                        local52 = $00
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field23\Field0[((local55 * $13) + local54)] > $00) Then
                                    Select local10\Field1\Field23\Field0[((local55 * $13) + local54)]
                                        Case $01,$07
                                            local52 = copyentity(local45[(local10\Field1\Field23\Field0[((local55 * $13) + local54)] - $01)], $00)
                                            If (local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] > $00) Then
                                                rotateentity(local52, 0.0, 90.0, 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $01
                                            ElseIf (local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] > $00) Then
                                                rotateentity(local52, 0.0, 270.0, 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $03
                                            ElseIf (local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] > $00) Then
                                                rotateentity(local52, 0.0, 180.0, 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $02
                                            Else
                                                rotateentity(local52, 0.0, 0.0, 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $00
                                            EndIf
                                        Case $02
                                            If ((((local54 = local62) And (local55 = local64)) Or ((local54 = local63) And (local55 = local65))) <> 0) Then
                                                local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $06
                                            EndIf
                                            If (((local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] > $00) And (local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] > $00)) <> 0) Then
                                                local52 = copyentity(local45[(local10\Field1\Field23\Field0[((local55 * $13) + local54)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local53 = rand($00, $01)
                                                rotateentity(local52, 0.0, (((Float local53) * 180.0) + 90.0), 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = ((local53 Shl $01) + $01)
                                            ElseIf (((local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] > $00) And (local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)] > $00)) <> 0) Then
                                                local52 = copyentity(local45[(local10\Field1\Field23\Field0[((local55 * $13) + local54)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local53 = rand($00, $01)
                                                rotateentity(local52, 0.0, ((Float local53) * 180.0), 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = (local53 Shl $01)
                                            Else
                                                local52 = copyentity(local45[local10\Field1\Field23\Field0[((local55 * $13) + local54)]], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local47 = local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)]
                                                local48 = local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)]
                                                local49 = local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))]
                                                local50 = local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))]
                                                If (((local47 > $00) And (local49 > $00)) <> 0) Then
                                                    rotateentity(local52, 0.0, 0.0, 0.0, $00)
                                                    local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $00
                                                ElseIf (((local47 > $00) And (local50 > $00)) <> 0) Then
                                                    rotateentity(local52, 0.0, 90.0, 0.0, $00)
                                                    local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $01
                                                ElseIf (((local48 > $00) And (local49 > $00)) <> 0) Then
                                                    rotateentity(local52, 0.0, 270.0, 0.0, $00)
                                                    local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $03
                                                Else
                                                    rotateentity(local52, 0.0, 180.0, 0.0, $00)
                                                    local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $02
                                                EndIf
                                            EndIf
                                            If (((local54 = local62) And (local55 = local64)) <> 0) Then
                                                local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $05
                                            EndIf
                                        Case $03
                                            local52 = copyentity(local45[local10\Field1\Field23\Field0[((local55 * $13) + local54)]], $00)
                                            local47 = local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)]
                                            local48 = local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)]
                                            local49 = local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))]
                                            local50 = local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))]
                                            If ((((local47 > $00) And (local49 > $00)) And (local50 > $00)) <> 0) Then
                                                rotateentity(local52, 0.0, 90.0, 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $01
                                            ElseIf ((((local48 > $00) And (local49 > $00)) And (local50 > $00)) <> 0) Then
                                                rotateentity(local52, 0.0, 270.0, 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $03
                                            ElseIf ((((local49 > $00) And (local47 > $00)) And (local48 > $00)) <> 0) Then
                                                rotateentity(local52, 0.0, 0.0, 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $00
                                            Else
                                                rotateentity(local52, 0.0, 180.0, 0.0, $00)
                                                local10\Field1\Field23\Field1[((local55 * $13) + local54)] = $02
                                            EndIf
                                        Case $04
                                            local52 = copyentity(local45[local10\Field1\Field23\Field0[((local55 * $13) + local54)]], $00)
                                            local53 = rand($00, $03)
                                            rotateentity(local52, 0.0, ((Float local53) * 90.0), 0.0, $00)
                                            local10\Field1\Field23\Field1[((local55 * $13) + local54)] = local53
                                    End Select
                                    scaleentity(local52, roomscale, roomscale, roomscale, $01)
                                    positionentity(local52, (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                    Select local10\Field1\Field23\Field0[((local55 * $13) + local54)]
                                        Case $01
                                            addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $03,$04
                                            addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $07
                                            addlight(Null, (((local10\Field1\Field3 + ((Float local54) * 2.0)) - ((sin(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local52, $01)) * 16.0) * roomscale)), ((396.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((cos(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local52, $01)) * 16.0) * roomscale)), $02, (500.0 * roomscale), $FF, $C8, $C8)
                                            local12 = createitem("SCP-500-01", "scp500pill", (((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * -208.0) * roomscale)) - ((sin(entityyaw(local52, $01)) * 1226.0) * roomscale)), ((80.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * -208.0) * roomscale)) + ((cos(entityyaw(local52, $01)) * 1226.0) * roomscale)), $00, $00, $00, 1.0, $00)
                                            entitytype(local12\Field1, $03, $00)
                                            local12 = createitem("Night Vision Goggles", "nvgoggles", (((local10\Field1\Field3 + ((Float local54) * 2.0)) - ((sin(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local52, $01)) * 16.0) * roomscale)), ((80.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((cos(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local52, $01)) * 16.0) * roomscale)), $00, $00, $00, 1.0, $00)
                                            entitytype(local12\Field1, $03, $00)
                                    End Select
                                    If (((local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $06) Or (local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $05)) <> 0) Then
                                        local51 = createdoor(local10\Field1\Field0, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 240.0) * roomscale)), 8.0, ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 240.0) * roomscale)), (entityyaw(local52, $01) + 90.0), Null, $00, $03, $00, "", $00)
                                        positionentity(local51\Field3[$00], (entityx(local51\Field3[$00], $01) + (cos(entityyaw(local52, $01)) * 0.05)), entityy(local51\Field3[$00], $01), (entityz(local51\Field3[$00], $01) + (sin(entityyaw(local52, $01)) * 0.05)), $01)
                                        addlight(Null, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 555.0) * roomscale)), ((469.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 555.0) * roomscale)), $02, (600.0 * roomscale), $FF, $FF, $FF)
                                        local53 = createpivot($00)
                                        rotateentity(local53, 0.0, (entityyaw(local52, $01) + 180.0), 0.0, $01)
                                        positionentity(local53, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 552.0) * roomscale)), ((240.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 552.0) * roomscale)), $00)
                                        If (local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $06) Then
                                            If (local10\Field1\Field21[$01] = Null) Then
                                                local51\Field5 = (local10\Field1\Field21[$00]\Field5 = $00)
                                                local10\Field1\Field21[$01] = local51
                                            Else
                                                removedoor(local51)
                                            EndIf
                                            If (local10\Field1\Field19[$03] = $00) Then
                                                local10\Field1\Field19[$03] = local53
                                                positionentity(local10\Field1\Field19[$01], (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                            Else
                                                freeentity(local53)
                                            EndIf
                                        Else
                                            If (local10\Field1\Field21[$03] = Null) Then
                                                local51\Field5 = (local10\Field1\Field21[$02]\Field5 = $00)
                                                local10\Field1\Field21[$03] = local51
                                            Else
                                                removedoor(local51)
                                            EndIf
                                            If (local10\Field1\Field19[$05] = $00) Then
                                                local10\Field1\Field19[$05] = local53
                                                positionentity(local10\Field1\Field19[$00], (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                            Else
                                                freeentity(local53)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local10\Field1\Field23\Field3[((local55 * $13) + local54)] = local52
                                    local68 = createwaypoint((local10\Field1\Field3 + ((Float local54) * 2.0)), 8.2, (local10\Field1\Field5 + ((Float local55) * 2.0)), Null, local10\Field1)
                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)] = local68
                                    If (local55 < $12) Then
                                        If (local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local55 > $00) Then
                                        If (local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local54 > $00) Then
                                        If (local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local54 < $12) Then
                                        If (local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        For local1 = $00 To $06 Step $01
                            local10\Field1\Field23\Field2[local1] = local45[local1]
                        Next
                        positionentity(local10\Field1\Field19[$00], (local10\Field1\Field3 + ((Float local62) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local64) * 2.0)), $01)
                        positionentity(local10\Field1\Field19[$01], (local10\Field1\Field3 + ((Float local63) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local65) * 2.0)), $01)
                    ElseIf (local10\Field1\Field23\Field2[$00] = $00) Then
                        For local1 = $00 To $06 Step $01
                            local45[local1] = copyentity(local22\Field1[local1], $00)
                            hideentity(local45[local1])
                        Next
                        freetexturecache()
                        local52 = $00
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field23\Field0[((local55 * $13) + local54)] > $00) Then
                                    Select local10\Field1\Field23\Field0[((local55 * $13) + local54)]
                                        Case $01,$07
                                            local52 = copyentity(local45[(local10\Field1\Field23\Field0[((local55 * $13) + local54)] - $01)], $00)
                                        Case $02
                                            If (((local10\Field1\Field23\Field0[((local54 + $01) + (local55 * $13))] > $00) And (local10\Field1\Field23\Field0[((local54 - $01) + (local55 * $13))] > $00)) <> 0) Then
                                                local52 = copyentity(local45[(local10\Field1\Field23\Field0[((local55 * $13) + local54)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            ElseIf (((local10\Field1\Field23\Field0[(((local55 + $01) * $13) + local54)] > $00) And (local10\Field1\Field23\Field0[(((local55 - $01) * $13) + local54)] > $00)) <> 0) Then
                                                local52 = copyentity(local45[(local10\Field1\Field23\Field0[((local55 * $13) + local54)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            Else
                                                local52 = copyentity(local45[local10\Field1\Field23\Field0[((local55 * $13) + local54)]], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            EndIf
                                        Case $03,$04
                                            local52 = copyentity(local45[local10\Field1\Field23\Field0[((local55 * $13) + local54)]], $00)
                                        Case $05,$06
                                            local52 = copyentity(local45[$05], $00)
                                    End Select
                                    scaleentity(local52, roomscale, roomscale, roomscale, $01)
                                    rotateentity(local52, 0.0, ((Float local10\Field1\Field23\Field1[((local55 * $13) + local54)]) * 90.0), 0.0, $00)
                                    positionentity(local52, (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                    Select local10\Field1\Field23\Field0[((local55 * $13) + local54)]
                                        Case $01,$05,$06
                                            addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $03,$04
                                            addlight(Null, (local10\Field1\Field3 + ((Float local54) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local55) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $07
                                            addlight(Null, (((local10\Field1\Field3 + ((Float local54) * 2.0)) - ((sin(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local52, $01)) * 16.0) * roomscale)), ((396.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((cos(entityyaw(local52, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local52, $01)) * 16.0) * roomscale)), $02, (500.0 * roomscale), $FF, $C8, $C8)
                                    End Select
                                    If (((local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $06) Or (local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $05)) <> 0) Then
                                        local51 = createdoor(local10\Field1\Field0, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 240.0) * roomscale)), 8.0, ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 240.0) * roomscale)), (entityyaw(local52, $01) + 90.0), Null, $00, $03, $00, "", $00)
                                        positionentity(local51\Field3[$00], (entityx(local51\Field3[$00], $01) + (cos(entityyaw(local52, $01)) * 0.05)), (entityy(local51\Field3[$00], $01) + 0.0), (entityz(local51\Field3[$00], $01) + (sin(entityyaw(local52, $01)) * 0.05)), $01)
                                        addlight(Null, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 555.0) * roomscale)), ((469.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 555.0) * roomscale)), $02, (600.0 * roomscale), $FF, $FF, $FF)
                                        local53 = createpivot($00)
                                        rotateentity(local53, 0.0, (entityyaw(local52, $01) + 180.0), 0.0, $01)
                                        positionentity(local53, ((local10\Field1\Field3 + ((Float local54) * 2.0)) + ((cos(entityyaw(local52, $01)) * 552.0) * roomscale)), ((240.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local55) * 2.0)) + ((sin(entityyaw(local52, $01)) * 552.0) * roomscale)), $00)
                                        If (local10\Field1\Field23\Field0[((local55 * $13) + local54)] = $06) Then
                                            If (local10\Field1\Field21[$01] = Null) Then
                                                local51\Field5 = (local10\Field1\Field21[$00]\Field5 = $00)
                                                local10\Field1\Field21[$01] = local51
                                            Else
                                                removedoor(local51)
                                            EndIf
                                            If (local10\Field1\Field19[$03] = $00) Then
                                                local10\Field1\Field19[$03] = local53
                                                positionentity(local10\Field1\Field19[$01], (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                            Else
                                                freeentity(local53)
                                            EndIf
                                        Else
                                            If (local10\Field1\Field21[$03] = Null) Then
                                                local51\Field5 = (local10\Field1\Field21[$02]\Field5 = $00)
                                                local10\Field1\Field21[$03] = local51
                                            Else
                                                removedoor(local51)
                                            EndIf
                                            If (local10\Field1\Field19[$05] = $00) Then
                                                local10\Field1\Field19[$05] = local53
                                                positionentity(local10\Field1\Field19[$00], (local10\Field1\Field3 + ((Float local54) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local55) * 2.0)), $01)
                                            Else
                                                freeentity(local53)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local10\Field1\Field23\Field3[((local55 * $13) + local54)] = local52
                                    local68 = createwaypoint((local10\Field1\Field3 + ((Float local54) * 2.0)), 8.2, (local10\Field1\Field5 + ((Float local55) * 2.0)), Null, local10\Field1)
                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)] = local68
                                    If (local55 < $12) Then
                                        If (local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field23\Field4[(((local55 + $01) * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local55 > $00) Then
                                        If (local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field23\Field4[(((local55 - $01) * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local54 > $00) Then
                                        If (local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field23\Field4[((local54 - $01) + (local55 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local54 < $12) Then
                                        If (local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field0, local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]
                                                    local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field23\Field4[((local55 * $13) + local54)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]\Field4[local1] = local10\Field1\Field23\Field4[((local55 * $13) + local54)]
                                                    local10\Field1\Field23\Field4[((local54 + $01) + (local55 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        For local1 = $00 To $06 Step $01
                            local10\Field1\Field23\Field2[local1] = local45[local1]
                        Next
                        seedrnd(local56)
                        For local12 = Each items
                            If (((((((8.0 <= entityy(local12\Field1, $01)) And (12.0 >= entityy(local12\Field1, $01))) And ((local10\Field1\Field3 - 6.0) <= entityx(local12\Field1, $01))) And (((local10\Field1\Field3 + 38.0) + 6.0) >= entityx(local12\Field1, $01))) And ((local10\Field1\Field5 - 6.0) <= entityz(local12\Field1, $01))) And (((local10\Field1\Field5 + 38.0) + 6.0) >= entityz(local12\Field1, $01))) <> 0) Then
                                translateentity(local12\Field1, 0.0, 0.3, 0.0, $01)
                                resetentity(local12\Field1)
                            EndIf
                        Next
                    EndIf
                    If (4.0 < entityy(collider, $01)) Then
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field23\Field3[((local55 * $13) + local54)] <> $00) Then
                                    showentity(local10\Field1\Field23\Field3[((local55 * $13) + local54)])
                                EndIf
                            Next
                        Next
                        For local9 = Each rooms
                            If (local9 <> local10\Field1) Then
                                hideentity(local9\Field2)
                            EndIf
                        Next
                        entityalpha(getchild(local10\Field1\Field2, $02), 0.0)
                        shouldplay = $1A
                        If (0.0 = local10\Field2) Then
                            If (entitydistance(collider, local10\Field1\Field19[$01]) > entitydistance(collider, local10\Field1\Field19[$00])) Then
                                local2 = $00
                            Else
                                local2 = $01
                            EndIf
                            local10\Field2 = 2.0
                            If (contained106 = $00) Then
                                local30 = createdecal($00, entityx(local10\Field1\Field19[local2], $01), (entityy(local10\Field1\Field19[local2], $01) + 0.05), entityz(local10\Field1\Field19[local2], $01), 90.0, (Float rand($168, $01)), 0.0)
                                local30\Field2 = 0.05
                                local30\Field1 = 0.001
                                entityalpha(local30\Field0, 0.8)
                                updatedecals()
                                positionentity(curr106\Field4, entityx(local10\Field1\Field19[local2], $01), (entityy(collider, $01) - 3.0), entityz(local10\Field1\Field19[local2], $01), $00)
                                setanimtime(curr106\Field0, 110.0, $00)
                                curr106\Field9 = -0.1
                                curr106\Field29 = entityy(collider, $00)
                            EndIf
                            For local1 = $00 To $01 Step $01
                                local71 = Null
                                For local18 = ((Float local1) * 72.2) To 360.0 Step 1.0
                                    If (((rand($02, $01) = $01) And (local10\Field1\Field23\Field4[(Int local18)] <> Null)) <> 0) Then
                                        local71 = local10\Field1\Field23\Field4[(Int local18)]
                                        local18 = 361.0
                                    EndIf
                                Next
                                If (local71 <> Null) Then
                                    local10\Field1\Field22[local1] = createnpc($0D, entityx(local71\Field0, $01), entityy(local71\Field0, $01), entityz(local71\Field0, $01))
                                EndIf
                            Next
                        EndIf
                    Else
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field23\Field3[((local55 * $13) + local54)] <> $00) Then
                                    hideentity(local10\Field1\Field23\Field3[((local55 * $13) + local54)])
                                EndIf
                            Next
                        Next
                    EndIf
                    local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$02], local10\Field1\Field19[$03], local10, $00)
                    local10\Field4 = updateelevators(local10\Field4, local10\Field1\Field21[$02], local10\Field1\Field21[$03], local10\Field1\Field19[$04], local10\Field1\Field19[$05], local10, $00)
                ElseIf (local10\Field1\Field23 <> Null) Then
                    If (local10\Field1\Field23\Field2[$00] <> $00) Then
                        For local55 = $00 To $12 Step $01
                            For local54 = $00 To $12 Step $01
                                If (local10\Field1\Field23\Field3[((local55 * $13) + local54)] <> $00) Then
                                    hideentity(local10\Field1\Field23\Field3[((local55 * $13) + local54)])
                                EndIf
                            Next
                        Next
                    EndIf
                EndIf
            Case "room2pipes106"
                If (contained106 = $00) Then
                    If (0.0 = local10\Field2) Then
                        If (playerroom = local10\Field1) Then
                            local10\Field2 = 1.0
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 + (local23\Field3[$00] * 0.7))
                        If (50.0 > local10\Field2) Then
                            curr106\Field24 = 1.0
                            positionentity(curr106\Field4, entityx(local10\Field1\Field19[$00], $01), (entityy(collider, $00) - 0.15), entityz(local10\Field1\Field19[$00], $01), $00)
                            pointentity(curr106\Field4, local10\Field1\Field19[$01], 0.0)
                            moveentity(curr106\Field4, 0.0, 0.0, ((entitydistance(local10\Field1\Field19[$00], local10\Field1\Field19[$01]) * 0.5) * (local10\Field2 / 50.0)))
                            animatenpc(curr106, 284.0, 333.0, 0.7, $01)
                        ElseIf (200.0 > local10\Field2) Then
                            curr106\Field24 = 1.0
                            animatenpc(curr106, 334.0, 494.0, 0.2, $01)
                            positionentity(curr106\Field4, ((entityx(local10\Field1\Field19[$00], $01) + entityx(local10\Field1\Field19[$01], $01)) / 2.0), (entityy(collider, $00) - 0.15), ((entityz(local10\Field1\Field19[$00], $01) + entityz(local10\Field1\Field19[$01], $01)) / 2.0), $00)
                            rotateentity(curr106\Field4, 0.0, curvevalue(local10\Field2, entityyaw(curr106\Field4, $00), 30.0), 0.0, $01)
                            If (4.0 > entitydistance(curr106\Field4, collider)) Then
                                local3 = createpivot($00)
                                positionentity(local3, entityx(curr106\Field4, $00), entityy(curr106\Field4, $00), entityz(curr106\Field4, $00), $00)
                                pointentity(local3, collider, 0.0)
                                If (80.0 > wrapangle((entityyaw(local3, $00) - entityyaw(curr106\Field4, $00)))) Then
                                    curr106\Field9 = -11.0
                                    curr106\Field24 = 0.0
                                    playsound_strict(horrorsfx($0A))
                                    local10\Field2 = 260.0
                                EndIf
                                freeentity(local3)
                            EndIf
                        ElseIf (250.0 > local10\Field2) Then
                            curr106\Field24 = 1.0
                            positionentity(curr106\Field4, entityx(local10\Field1\Field19[$00], $01), (entityy(collider, $00) - 0.15), entityz(local10\Field1\Field19[$00], $01), $00)
                            pointentity(curr106\Field4, local10\Field1\Field19[$01], 0.0)
                            moveentity(curr106\Field4, 0.0, 0.0, (entitydistance(local10\Field1\Field19[$00], local10\Field1\Field19[$01]) * ((local10\Field2 - 150.0) / 100.0)))
                            animatenpc(curr106, 284.0, 333.0, 0.7, $01)
                        EndIf
                        resetentity(curr106\Field4)
                        positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                        rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                        If (((0.3 < (local10\Field2 / 250.0)) And (0.3 >= ((local10\Field2 - (local23\Field3[$00] * 0.7)) / 250.0))) <> 0) Then
                            local10\Field6 = playsound_strict(horrorsfx($15))
                            blurtimer = 800.0
                            local72 = createdecal($00, entityx(local10\Field1\Field19[$02], $01), entityy(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01), 0.0, (Float (local10\Field1\Field6 - $5A)), rnd(360.0, 0.0))
                            local72\Field9 = 90000.0
                            local72\Field5 = 0.01
                            local72\Field4 = 0.005
                            local72\Field2 = 0.1
                            local72\Field1 = 0.003
                        EndIf
                        If (((0.65 < (local10\Field2 / 250.0)) And (0.65 >= ((local10\Field2 - (local23\Field3[$00] * 0.7)) / 250.0))) <> 0) Then
                            local72 = createdecal($00, entityx(local10\Field1\Field19[$03], $01), entityy(local10\Field1\Field19[$03], $01), entityz(local10\Field1\Field19[$03], $01), 0.0, (Float (local10\Field1\Field6 + $5A)), rnd(360.0, 0.0))
                            local72\Field9 = 90000.0
                            local72\Field5 = 0.01
                            local72\Field4 = 0.005
                            local72\Field2 = 0.1
                            local72\Field1 = 0.003
                        EndIf
                        If (250.0 < local10\Field2) Then
                            curr106\Field24 = 0.0
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room2pit106"
                If (((contained106 = $00) And (0.0 < curr106\Field9)) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (playerroom = local10\Field1) Then
                            local10\Field2 = 1.0
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 + 1.0)
                        positionentity(curr106\Field4, entityx(local10\Field1\Field19[$07], $01), entityy(local10\Field1\Field19[$07], $01), entityz(local10\Field1\Field19[$07], $01), $00)
                        resetentity(curr106\Field4)
                        pointentity(curr106\Field4, camera, 0.0)
                        turnentity(curr106\Field4, 0.0, (sin((Float (millisecs2() / $14))) * 6.0), 0.0, $01)
                        moveentity(curr106\Field4, 0.0, 0.0, (sin((Float (millisecs2() / $0F))) * 0.06))
                        positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                        rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                        curr106\Field24 = 1.0
                        animatenpc(curr106, 334.0, 494.0, 0.3, $01)
                        If (800.0 < local10\Field2) Then
                            If (-5.0 > blinktimer) Then
                                curr106\Field24 = 0.0
                                removeevent(local10)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2pit"
                If (0.0 = curr173\Field24) Then
                    If (((8.0 > local10\Field1\Field8) And (0.0 < local10\Field1\Field8)) <> 0) Then
                        If (((entityvisible(curr173\Field4, camera) = $00) And (entityvisible(local10\Field1\Field19[$06], camera) = $00)) <> 0) Then
                            positionentity(curr173\Field4, entityx(local10\Field1\Field19[$06], $01), 0.5, entityz(local10\Field1\Field19[$06], $01), $00)
                            resetentity(curr173\Field4)
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room3pitduck"
                If (playerroom = local10\Field1) Then
                    If (local10\Field1\Field19[$02] = $00) Then
                        local10\Field1\Field19[$02] = copyentity(local22\Field0[$1E], $00)
                        scaleentity(local10\Field1\Field19[$02], 0.07, 0.07, 0.07, $00)
                        local73 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\duck(3).png"), $01)
                        entitytexture(local10\Field1\Field19[$02], local73, $00, $00)
                        freetexture(local73)
                        positionentity(local10\Field1\Field19[$02], entityx(local10\Field1\Field19[$00], $01), entityy(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01), $00)
                        pointentity(local10\Field1\Field19[$02], local10\Field1\Field2, 0.0)
                        rotateentity(local10\Field1\Field19[$02], 0.0, entityyaw(local10\Field1\Field19[$02], $01), 0.0, $01)
                        loadeventsound(local10, scpmodding_processfilepath("SFX\SCP\Joke\Saxophone.ogg"), $00)
                    ElseIf (entityinview(local10\Field1\Field19[$02], camera) = $00) Then
                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                        If (((rand($C8, $01) = $01) And (300.0 < local10\Field2)) <> 0) Then
                            local10\Field2 = 0.0
                            local10\Field6 = playsound2(local10\Field9, camera, local10\Field1\Field19[$02], 6.0, 1.0)
                            giveachievement($35, $01)
                        EndIf
                    ElseIf (local10\Field6 <> $00) Then
                        If (channelplaying(local10\Field6) <> 0) Then
                            stopchannel(local10\Field6)
                        EndIf
                    EndIf
                EndIf
            Case "room3pit1048"
                If (playerroom = local10\Field1) Then
                    If (local10\Field1\Field19[$02] = $00) Then
                        local10\Field1\Field19[$02] = copyentity(local22\Field0[$1D], $00)
                        scaleentity(local10\Field1\Field19[$02], 0.05, 0.05, 0.05, $00)
                        setanimtime(local10\Field1\Field19[$02], 414.0, $00)
                        local74 = scpmodding_processfilepath((("GFX\items\1048\1048_" + (Str rand($01, $1A))) + ".png"))
                        For local75 = Each itemtemplates
                            If (local75\Field0 = "Drawing") Then
                                If (local75\Field11 <> $00) Then
                                    freeimage(local75\Field11)
                                EndIf
                                local75\Field11 = loadimage_strict(local74)
                                maskimage(local75\Field11, $FF, $00, $FF)
                                local75\Field10 = local74
                                Exit
                            EndIf
                        Next
                        local73 = loadtexture_strict(local74, $01)
                        local76 = loadbrush_strict(local74, $01, 1.0, 1.0)
                        For local1 = $01 To countsurfaces(local10\Field1\Field19[$02]) Step $01
                            local77 = getsurface(local10\Field1\Field19[$02], local1)
                            local78 = getsurfacebrush(local77)
                            local79 = getbrushtexture(local78, $00)
                            local80 = strippath(texturename(local79))
                            If (lower(local80) = "1048_1.png") Then
                                paintsurface(local77, local76)
                            EndIf
                            freebrush(local78)
                        Next
                        freetexture(local73)
                        freebrush(local76)
                        positionentity(local10\Field1\Field19[$02], entityx(local10\Field1\Field19[$00], $01), entityy(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01), $00)
                    Else
                        pointentity(local10\Field1\Field19[$02], collider, 0.0)
                        rotateentity(local10\Field1\Field19[$02], -90.0, entityyaw(local10\Field1\Field19[$02], $01), 0.0, $01)
                        If (0.0 = local10\Field2) Then
                            If (3.0 > entitydistance(collider, local10\Field1\Field19[$02])) Then
                                If (entityinview(local10\Field1\Field19[$02], camera) <> 0) Then
                                    local10\Field2 = 1.0
                                    giveachievement($19, $01)
                                EndIf
                            EndIf
                        ElseIf (1.0 = local10\Field2) Then
                            animate2(local10\Field1\Field19[$02], animtime(local10\Field1\Field19[$02]), $01, $CD, 0.5, $00)
                            If (205.0 = animtime(local10\Field1\Field19[$02])) Then
                                local10\Field2 = 2.0
                            EndIf
                        ElseIf (2.0 = local10\Field2) Then
                            animate2(local10\Field1\Field19[$02], animtime(local10\Field1\Field19[$02]), $CD, $161, 1.0, $01)
                            If (1.5 > entitydistance(collider, local10\Field1\Field19[$02])) Then
                                drawhandicon = $01
                                If (mousehit1 <> 0) Then
                                    If (itemamount >= maxitemamount) Then
                                        msg = scplang_getphrase("events.moreitems")
                                        msgtimer = 350.0
                                    Else
                                        selecteditem = createitem("Drawing", "paper", 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                        entitytype(selecteditem\Field1, $03, $00)
                                        pickitem(selecteditem)
                                        freeentity(local10\Field1\Field19[$02])
                                        local10\Field1\Field19[$02] = $00
                                        local10\Field2 = 3.0
                                        removeevent(local10)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2poffices2"
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field2) Then
                        If (local10\Field1\Field21[$00]\Field5 = $01) Then
                            If (180.0 = local10\Field1\Field21[$00]\Field7) Then
                                local10\Field2 = 1.0
                                playsound_strict(horrorsfx($05))
                            EndIf
                        ElseIf (((1.5 > entitydistance(collider, local10\Field1\Field21[$00]\Field0)) And remotedooron) <> 0) Then
                            local10\Field1\Field21[$00]\Field5 = $01
                        EndIf
                    ElseIf (2.1 > entitydistance(local10\Field1\Field19[$00], collider)) Then
                        currstepsfx = $01
                        heartbeatvolume = curvevalue(0.5, heartbeatvolume, 5.0)
                        heartbeatrate = curvevalue(120.0, heartbeatrate, 150.0)
                        local10\Field6 = loopsound2(oldmansfx($04), local10\Field6, camera, local10\Field1\Field2, 5.0, 0.3)
                        curr106\Field9 = (curr106\Field9 - (local23\Field3[$00] * 3.0))
                    EndIf
                EndIf
            Case "room2servers"
                If (0.0 = local10\Field2) Then
                    If (playerroom = local10\Field1) Then
                        usedoor(local10\Field1\Field21[$00], $00, $01)
                        local10\Field1\Field21[$00]\Field4 = $01
                        usedoor(local10\Field1\Field21[$01], $00, $01)
                        local10\Field1\Field21[$01]\Field4 = $01
                        If (curr096 = Null) Then
                            curr096 = createnpc($06, entityx(local10\Field1\Field19[$06], $01), (entityy(local10\Field1\Field19[$06], $01) + 0.1), entityz(local10\Field1\Field19[$06], $01))
                        Else
                            positionentity(curr096\Field4, entityx(local10\Field1\Field19[$06], $01), (entityy(local10\Field1\Field19[$06], $01) + 0.1), entityz(local10\Field1\Field19[$06], $01), $01)
                        EndIf
                        rotateentity(curr096\Field4, 0.0, (Float (local10\Field1\Field6 + $10E)), 0.0, $01)
                        resetentity(curr096\Field4)
                        curr096\Field9 = 6.0
                        curr096\Field10 = 700.0
                        loadeventsound(local10, scpmodding_processfilepath("SFX\Character\Guard\096ServerRoom1.ogg"), $00)
                        local10\Field6 = playsound_strict(local10\Field9)
                        local10\Field1\Field22[$00] = createnpc($13, entityx(local10\Field1\Field19[$07], $01), entityy(local10\Field1\Field19[$07], $01), entityz(local10\Field1\Field19[$07], $01))
                        giveachievement($06, $01)
                        local10\Field2 = 1.0
                    EndIf
                ElseIf (3150.0 > local10\Field2) Then
                    If (((rand($C8, $01) < $05) And (playerroom = local10\Field1)) <> 0) Then
                        lightblink = rnd(1.0, 2.0)
                        If (rand($05, $01) = $01) Then
                            playsound2(introsfx(rand($0A, $0C)), camera, local10\Field1\Field2, 8.0, rnd(0.1, 0.3))
                        EndIf
                    EndIf
                    local10\Field2 = min((local10\Field2 + local23\Field3[$00]), 3010.0)
                    If (local10\Field1\Field22[$00] <> Null) Then
                        curr096\Field31 = local10\Field1\Field22[$00]
                        If (560.0 > local10\Field2) Then
                            animatenpc(curr096, 472.0, 520.0, 0.25, $01)
                            pointentity(local10\Field1\Field22[$00]\Field4, curr096\Field4, 0.0)
                        ElseIf (((560.0 <= local10\Field2) And (700.0 > local10\Field2)) <> 0) Then
                            If (entitydistance(collider, local10\Field1\Field21[$01]\Field2) > entitydistance(collider, local10\Field1\Field21[$00]\Field2)) Then
                                animatenpc(curr096, 521.0, 555.0, 0.25, $00)
                                If (554.5 <= curr096\Field14) Then
                                    local10\Field2 = 700.0
                                    curr096\Field14 = 677.0
                                    setnpcframe(curr096, curr096\Field14)
                                    curr096\Field9 = 1.0
                                    turnentity(curr096\Field4, 0.0, 180.0, 0.0, $00)
                                    moveentity(curr096\Field4, 0.0, 0.0, 0.3)
                                EndIf
                            Else
                                animatenpc(curr096, 556.0, 590.0, 0.25, $00)
                                If (589.5 <= curr096\Field14) Then
                                    local10\Field2 = 700.0
                                    curr096\Field14 = 677.0
                                    setnpcframe(curr096, curr096\Field14)
                                    curr096\Field9 = 1.0
                                    turnentity(curr096\Field4, 0.0, 180.0, 0.0, $00)
                                    moveentity(curr096\Field4, 0.0, 0.0, 0.3)
                                EndIf
                            EndIf
                            pointentity(local10\Field1\Field22[$00]\Field4, curr096\Field4, 0.0)
                        ElseIf (((700.0 <= local10\Field2) And (1400.0 > local10\Field2)) <> 0) Then
                            curr096\Field9 = min(max(1.0, curr096\Field9), 3.0)
                            curr096\Field10 = max(curr096\Field10, 840.0)
                            If (1050.0 >= (local10\Field2 - local23\Field3[$00])) Then
                                If (1050.0 < local10\Field2) Then
                                    local10\Field1\Field22[$00]\Field9 = 14.0
                                    local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], entityx(curr096\Field4, $01), 0.4, entityz(curr096\Field4, $01))
                                    local10\Field1\Field22[$00]\Field38 = 300.0
                                Else
                                    pointentity(local10\Field1\Field22[$00]\Field4, curr096\Field4, 0.0)
                                EndIf
                            EndIf
                            If (entityvisible(local10\Field1\Field22[$00]\Field4, curr096\Field4) <> 0) Then
                                local10\Field1\Field21[$02]\Field5 = $00
                                local10\Field1\Field22[$00]\Field9 = 13.0
                                pointentity(local10\Field1\Field22[$00]\Field0, curr096\Field4, 0.0)
                                rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$00]\Field0, $00), entityyaw(local10\Field1\Field22[$00]\Field4, $00), 30.0), 0.0, $00)
                            EndIf
                        ElseIf (4.0 = curr096\Field9) Then
                            curr096\Field26 = $01
                            local10\Field1\Field22[$00]\Field9 = 2.0
                            pointentity(local10\Field1\Field22[$00]\Field0, curr096\Field4, 0.0)
                            rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$00]\Field0, $00), entityyaw(local10\Field1\Field22[$00]\Field4, $00), 30.0), 0.0, $00)
                            If (playerroom = local10\Field1) Then
                                lightblink = (local10\Field1\Field22[$00]\Field25 + rnd(0.5, 2.0))
                            EndIf
                            curr096\Field31 = local10\Field1\Field22[$00]
                        Else
                            If (1540.0 < local10\Field2) Then
                                curr096\Field9 = 4.0
                            EndIf
                            If (13.0 = local10\Field1\Field22[$00]\Field9) Then
                                local10\Field1\Field22[$00]\Field9 = 14.0
                                local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], entityx(local10\Field1\Field2, $01), 0.4, entityz(local10\Field1\Field2, $01))
                                local10\Field1\Field22[$00]\Field38 = 300.0
                                local10\Field1\Field22[$00]\Field21 = (local10\Field1\Field22[$00]\Field21 * 1.8)
                            EndIf
                        EndIf
                        If (((25.0 < animtime(curr096\Field0)) And (150.0 > animtime(curr096\Field0))) <> 0) Then
                            freesound_strict(local10\Field9)
                            local10\Field9 = $00
                            If (playerroom <> local10\Field1) Then
                                local10\Field11 = loadsound_strict(scpmodding_processfilepath("SFX\Character\Guard\096ServerRoom2.ogg"))
                            Else
                                local10\Field11 = loadsound_strict(scpmodding_processfilepath("SFX\Character\Guard\096ServerRoom3.ogg"))
                            EndIf
                            local10\Field8 = playsound_strict(local10\Field11)
                            curr096\Field22 = 0.0
                            For local1 = $00 To $06 Step $01
                                If (((local10\Field1\Field6 = $00) Or (local10\Field1\Field6 = $B4)) <> 0) Then
                                    local30 = createdecal(rand($02, $03), (local10\Field1\Field3 - ((rnd(197.0, 199.0) * cos((Float local10\Field1\Field6))) * roomscale)), 1.0, (local10\Field1\Field5 + ((140.0 * (Float (local1 - $03))) * roomscale)), 0.0, (Float (local10\Field1\Field6 + $5A)), rnd(360.0, 0.0))
                                    local30\Field2 = rnd(0.8, 0.85)
                                    local30\Field1 = 0.001
                                    local30 = createdecal(rand($02, $03), (local10\Field1\Field3 - ((rnd(197.0, 199.0) * cos((Float local10\Field1\Field6))) * roomscale)), 1.0, (local10\Field1\Field5 + ((140.0 * (Float (local1 - $03))) * roomscale)), 0.0, (Float (local10\Field1\Field6 - $5A)), rnd(360.0, 0.0))
                                    local30\Field2 = rnd(0.8, 0.85)
                                    local30\Field1 = 0.001
                                Else
                                    local30 = createdecal(rand($02, $03), (local10\Field1\Field3 + ((140.0 * (Float (local1 - $03))) * roomscale)), 1.0, ((local10\Field1\Field5 - ((rnd(197.0, 199.0) * sin((Float local10\Field1\Field6))) * roomscale)) - rnd(0.001, 0.003)), 0.0, (Float (local10\Field1\Field6 + $5A)), rnd(360.0, 0.0))
                                    local30\Field2 = rnd(0.8, 0.85)
                                    local30\Field1 = 0.001
                                    local30 = createdecal(rand($02, $03), (local10\Field1\Field3 + ((140.0 * (Float (local1 - $03))) * roomscale)), 1.0, ((local10\Field1\Field5 - ((rnd(197.0, 199.0) * sin((Float local10\Field1\Field6))) * roomscale)) - rnd(0.001, 0.003)), 0.0, (Float (local10\Field1\Field6 - $5A)), rnd(360.0, 0.0))
                                    local30\Field2 = rnd(0.8, 0.85)
                                    local30\Field1 = 0.001
                                EndIf
                                local30 = createdecal(rand($02, $03), (entityx(local10\Field1\Field22[$00]\Field4, $00) + rnd(-2.0, 2.0)), rnd(0.001, 0.003), (entityz(local10\Field1\Field22[$00]\Field4, $00) + rnd(-2.0, 2.0)), 90.0, rnd(360.0, 0.0), 0.0)
                            Next
                            local30\Field2 = rnd(0.5, 0.7)
                            scalesprite(local30\Field0, local30\Field2, local30\Field2)
                            curr096\Field9 = 5.0
                            stopstream_strict(curr096\Field17)
                            curr096\Field17 = $00
                            removenpc(local10\Field1\Field22[$00])
                            local10\Field1\Field22[$00] = Null
                        EndIf
                    Else
                        If (((2800.0 <= local10\Field2) And (2800.0 > (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                            local10\Field1\Field21[$00]\Field4 = $00
                            local10\Field1\Field21[$01]\Field4 = $00
                            freesound_strict(local10\Field11)
                            local10\Field11 = $00
                            usedoor(local10\Field1\Field21[$00], $00, $01)
                            usedoor(local10\Field1\Field21[$01], $00, $01)
                            local10\Field1\Field21[$00]\Field4 = $01
                            local10\Field1\Field21[$01]\Field4 = $01
                        EndIf
                        If (playerroom = local10\Field1) Then
                            If (local10\Field6 <> $00) Then
                                If (channelplaying(local10\Field6) <> 0) Then
                                    lightblink = rnd(0.5, 6.0)
                                    If (rand($32, $01) = $01) Then
                                        playsound2(introsfx(rand($0A, $0C)), camera, local10\Field1\Field2, 8.0, rnd(0.1, 0.3))
                                    EndIf
                                EndIf
                            EndIf
                            If (((local10\Field1\Field6 = $00) Or (local10\Field1\Field6 = $B4)) <> 0) Then
                                If (1.3 < (Abs (entityx(collider, $00) - entityx(local10\Field1\Field2, $01)))) Then
                                    local10\Field2 = 3500.0
                                    local10\Field9 = $00
                                EndIf
                            ElseIf (1.3 < (Abs (entityz(collider, $00) - entityz(local10\Field1\Field2, $01)))) Then
                                local10\Field2 = 3500.0
                                local10\Field9 = $00
                            EndIf
                        EndIf
                    EndIf
                ElseIf (playerroom = local10\Field1) Then
                    local2 = updatelever(local10\Field1\Field19[$01], $00)
                    local18 = (Float updatelever(local10\Field1\Field19[$03], $00))
                    local20 = (Float updatelever(local10\Field1\Field19[$05], $00))
                    If ((Int local18) <> 0) Then
                        local10\Field3 = min(1.0, (local10\Field3 + (local23\Field3[$00] / 350.0)))
                        If ((Int local20) <> 0) Then
                            If (local10\Field10 = $00) Then
                                loadeventsound(local10, scpmodding_processfilepath("SFX\General\GeneratorOn.ogg"), $01)
                            EndIf
                            local10\Field4 = min(1.0, (local10\Field4 + (local23\Field3[$00] / 450.0)))
                        Else
                            local10\Field4 = min(0.0, (local10\Field4 - (local23\Field3[$00] / 450.0)))
                        EndIf
                    Else
                        local10\Field3 = max(0.0, (local10\Field3 - (local23\Field3[$00] / 350.0)))
                        local10\Field4 = max(0.0, (local10\Field4 - (local23\Field3[$00] / 450.0)))
                    EndIf
                    If (0.0 < local10\Field3) Then
                        local10\Field6 = loopsound2(roomambience[$08], local10\Field6, camera, local10\Field1\Field19[$03], 5.0, (local10\Field3 * 0.8))
                    EndIf
                    If (0.0 < local10\Field4) Then
                        local10\Field7 = loopsound2(local10\Field10, local10\Field7, camera, local10\Field1\Field19[$05], 6.0, local10\Field4)
                    EndIf
                    If ((((local2 = $00) And (Int local18)) And (Int local20)) <> 0) Then
                        local10\Field1\Field21[$00]\Field4 = $00
                        local10\Field1\Field21[$01]\Field4 = $00
                    Else
                        If (rand($C8, $01) < $05) Then
                            lightblink = rnd(0.5, 1.0)
                        EndIf
                        If (local10\Field1\Field21[$00]\Field5 <> 0) Then
                            local10\Field1\Field21[$00]\Field4 = $00
                            usedoor(local10\Field1\Field21[$00], $00, $01)
                        EndIf
                        If (local10\Field1\Field21[$01]\Field5 <> 0) Then
                            local10\Field1\Field21[$01]\Field4 = $00
                            usedoor(local10\Field1\Field21[$01], $00, $01)
                        EndIf
                        local10\Field1\Field21[$00]\Field4 = $01
                        local10\Field1\Field21[$01]\Field4 = $01
                    EndIf
                EndIf
            Case "room2storage"
                If (playerroom = local10\Field1) Then
                    If (0.0 >= local10\Field3) Then
                        local10\Field1\Field21[$01]\Field4 = $00
                        local10\Field1\Field21[$04]\Field4 = $00
                        If (((8.0 > entitydistance(collider, curr173\Field0)) Or (8.0 > entitydistance(collider, curr106\Field0))) <> 0) Then
                            local10\Field1\Field21[$01]\Field4 = $01
                            local10\Field1\Field21[$04]\Field4 = $01
                        Else
                            For local8 = Each npcs
                                If (((local8\Field5 = $14) Or (local8\Field5 = $1C)) <> 0) Then
                                    If (8.0 > entitydistance(collider, curr173\Field0)) Then
                                        local10\Field1\Field21[$01]\Field4 = $01
                                        local10\Field1\Field21[$04]\Field4 = $01
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                        local10\Field3 = 350.0
                    Else
                        local10\Field3 = (local10\Field3 - local23\Field3[$00])
                    EndIf
                    lightvolume = (templightvolume * 0.5)
                    tformpoint(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00, local10\Field1\Field2)
                    local2 = $00
                    If (730.0 < tformedx()) Then
                        giveachievement($17, $01)
                        updateworld(1.0)
                        tformpoint(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00, local10\Field1\Field2)
                        For local1 = $01 To $02 Step $01
                            local10\Field1\Field21[local1]\Field5 = local10\Field1\Field21[(local1 + $02)]\Field5
                            local10\Field1\Field21[local1]\Field7 = local10\Field1\Field21[(local1 + $02)]\Field7
                            positionentity(local10\Field1\Field21[local1]\Field0, entityx(local10\Field1\Field21[(local1 + $02)]\Field0, $00), entityy(local10\Field1\Field21[(local1 + $02)]\Field0, $00), entityz(local10\Field1\Field21[(local1 + $02)]\Field0, $00), $00)
                            positionentity(local10\Field1\Field21[local1]\Field1, entityx(local10\Field1\Field21[(local1 + $02)]\Field1, $00), entityy(local10\Field1\Field21[(local1 + $02)]\Field1, $00), entityz(local10\Field1\Field21[(local1 + $02)]\Field1, $00), $00)
                            local10\Field1\Field21[(local1 + $02)]\Field5 = $00
                            local10\Field1\Field21[(local1 + $02)]\Field7 = 0.0
                            positionentity(local10\Field1\Field21[(local1 + $02)]\Field0, entityx(local10\Field1\Field21[$00]\Field0, $00), entityy(local10\Field1\Field21[$00]\Field0, $00), entityz(local10\Field1\Field21[$00]\Field0, $00), $00)
                            positionentity(local10\Field1\Field21[(local1 + $02)]\Field1, entityx(local10\Field1\Field21[$00]\Field1, $00), entityy(local10\Field1\Field21[$00]\Field1, $00), entityz(local10\Field1\Field21[$00]\Field1, $00), $00)
                        Next
                        tformpoint((tformedx() - 1024.0), tformedy(), tformedz(), local10\Field1\Field2, $00)
                        hideentity(collider)
                        positionentity(collider, tformedx(), entityy(collider, $00), tformedz(), $01)
                        showentity(collider)
                        local2 = $01
                    ElseIf (-730.0 > tformedx()) Then
                        giveachievement($17, $01)
                        updateworld(1.0)
                        tformpoint(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00, local10\Field1\Field2)
                        For local1 = $01 To $02 Step $01
                            local10\Field1\Field21[(local1 + $02)]\Field5 = local10\Field1\Field21[local1]\Field5
                            local10\Field1\Field21[(local1 + $02)]\Field7 = local10\Field1\Field21[local1]\Field7
                            positionentity(local10\Field1\Field21[(local1 + $02)]\Field0, entityx(local10\Field1\Field21[local1]\Field0, $00), entityy(local10\Field1\Field21[local1]\Field0, $00), entityz(local10\Field1\Field21[local1]\Field0, $00), $00)
                            positionentity(local10\Field1\Field21[(local1 + $02)]\Field1, entityx(local10\Field1\Field21[local1]\Field1, $00), entityy(local10\Field1\Field21[local1]\Field1, $00), entityz(local10\Field1\Field21[local1]\Field1, $00), $00)
                            local10\Field1\Field21[local1]\Field5 = $00
                            local10\Field1\Field21[local1]\Field7 = 0.0
                            positionentity(local10\Field1\Field21[local1]\Field0, entityx(local10\Field1\Field21[$00]\Field0, $00), entityy(local10\Field1\Field21[$00]\Field0, $00), entityz(local10\Field1\Field21[$00]\Field0, $00), $00)
                            positionentity(local10\Field1\Field21[local1]\Field1, entityx(local10\Field1\Field21[$00]\Field1, $00), entityy(local10\Field1\Field21[$00]\Field1, $00), entityz(local10\Field1\Field21[$00]\Field1, $00), $00)
                        Next
                        tformpoint((tformedx() + 1024.0), tformedy(), tformedz(), local10\Field1\Field2, $00)
                        hideentity(collider)
                        positionentity(collider, tformedx(), entityy(collider, $00), tformedz(), $01)
                        showentity(collider)
                        local2 = $01
                    EndIf
                    If (local2 = $01) Then
                        local10\Field2 = (local10\Field2 + 1.0)
                        For local12 = Each items
                            If (5.0 > entitydistance(local12\Field1, collider)) Then
                                tformpoint(entityx(local12\Field1, $00), entityy(local12\Field1, $00), entityz(local12\Field1, $00), $00, local10\Field1\Field2)
                                local18 = tformedx()
                                local19 = tformedy()
                                local20 = tformedz()
                                If (264.0 < tformedx()) Then
                                    tformpoint((local18 - 1024.0), local19, local20, local10\Field1\Field2, $00)
                                    positionentity(local12\Field1, tformedx(), tformedy(), tformedz(), $00)
                                    resetentity(local12\Field1)
                                ElseIf (-264.0 > tformedx()) Then
                                    tformpoint((local18 + 1024.0), local19, local20, local10\Field1\Field2, $00)
                                    positionentity(local12\Field1, tformedx(), tformedy(), tformedz(), $00)
                                    resetentity(local12\Field1)
                                EndIf
                            EndIf
                        Next
                        Select local10\Field2
                            Case 2.0
                                local1 = rand(maxitemamount, $01)
                                If (inventory(local1) <> Null) Then
                                    removeitem(inventory(local1))
                                EndIf
                            Case 5.0
                                If (i_1033ru\Field0 = $00) Then
                                    injuries = (injuries + 0.3)
                                Else
                                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                                EndIf
                            Case 10.0
                                local30 = createdecal($03, (entityx(local10\Field1\Field2, $00) + ((cos((Float (local10\Field1\Field6 - $5A))) * 760.0) * roomscale)), 0.0005, (entityz(local10\Field1\Field2, $00) + ((sin((Float (local10\Field1\Field6 - $5A))) * 760.0) * roomscale)), 90.0, rnd(360.0, 0.0), 0.0)
                            Case 14.0
                                For local1 = $00 To (maxitemamount - $01) Step $01
                                    If (inventory(local1) <> Null) Then
                                        If (inventory(local1)\Field3\Field1 = "paper") Then
                                            removeitem(inventory(local1))
                                            For local75 = Each itemtemplates
                                                If (((local75\Field1 = "paper") And (rand($06, $01) = $01)) <> 0) Then
                                                    inventory(local1) = createitem(local75\Field0, local75\Field1, 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00)
                                                    hideentity(inventory(local1)\Field1)
                                                    inventory(local1)\Field15 = $01
                                                    Exit
                                                EndIf
                                            Next
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            Case 18.0
                                tformpoint(-344.0, 176.0, 272.0, local10\Field1\Field2, $00)
                                local12 = createitem("Strange Note", "paper", tformedx(), tformedy(), tformedz(), $00, $00, $00, 1.0, $00)
                                entitytype(local12\Field1, $03, $00)
                            Case 25.0
                                local10\Field1\Field22[$00] = createnpc($12, (entityx(local10\Field1\Field2, $00) + ((cos((Float (local10\Field1\Field6 - $5A))) * 760.0) * roomscale)), 0.35, (entityz(local10\Field1\Field2, $00) + ((sin((Float (local10\Field1\Field6 - $5A))) * 760.0) * roomscale)))
                                rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 - $C8)), 0.0, $01)
                                changenpctextureid(local10\Field1\Field22[$00], $01)
                                setanimtime(local10\Field1\Field22[$00]\Field0, 80.0, $00)
                                local10\Field1\Field22[$00]\Field9 = 10.0
                            Case 30.0
                                local1 = rand($00, (maxitemamount - $01))
                                If (inventory(local1) <> Null) Then
                                    removeitem(inventory(local1))
                                EndIf
                                inventory(local1) = createitem("Strange Note", "paper", 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00)
                                hideentity(inventory(local1)\Field1)
                                inventory(local1)\Field15 = $01
                            Case 35.0
                                For local1 = $00 To $03 Step $01
                                    local30 = createdecal($11, (local10\Field1\Field3 + rnd(-2.0, 2.0)), (700.0 * roomscale), (local10\Field1\Field5 + rnd(-2.0, 2.0)), 270.0, (Float rand($168, $01)), 0.0)
                                    local30\Field2 = 0.05
                                    local30\Field1 = 0.0005
                                    entityalpha(local30\Field0, 0.8)
                                    updatedecals()
                                Next
                            Case 40.0
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\radio\franklin4.ogg")))
                            Case 50.0
                                local10\Field1\Field22[$01] = createnpc($13, (entityx(local10\Field1\Field2, $00) + ((cos((Float (local10\Field1\Field6 + $5A))) * 600.0) * roomscale)), 0.35, (entityz(local10\Field1\Field2, $00) + ((sin((Float (local10\Field1\Field6 + $5A))) * 600.0) * roomscale)))
                                local10\Field1\Field22[$01]\Field9 = 7.0
                            Case 52.0
                                If (local10\Field1\Field22[$01] <> Null) Then
                                    removenpc(local10\Field1\Field22[$01])
                                    local10\Field1\Field22[$01] = Null
                                EndIf
                            Case 60.0
                                If (local82 = $00) Then
                                    local83 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_173_h.pt"), $01)
                                    entitytexture(curr173\Field0, local83, $00, $00)
                                    freetexture(local83)
                                EndIf
                        End Select
                        If (rand($0A, $01) = $01) Then
                            local2 = rand($00, $02)
                            playsound_strict(ambientsfx(local2, rand($00, (ambientsfxamount(local2) - $01))))
                        EndIf
                    Else
                        If (local10\Field1\Field22[$00] <> Null) Then
                            If (3.0 > entitydistance(collider, local10\Field1\Field22[$00]\Field4)) Then
                                If (entityinview(local10\Field1\Field22[$00]\Field0, camera) <> 0) Then
                                    currcamerazoom = ((sin(((Float millisecs2()) / 20.0)) + 1.0) * 15.0)
                                    heartbeatvolume = max(curvevalue(0.3, heartbeatvolume, 2.0), heartbeatvolume)
                                    heartbeatrate = max(heartbeatrate, 120.0)
                                EndIf
                            EndIf
                        EndIf
                        If (local10\Field1\Field22[$01] <> Null) Then
                            pointentity(local10\Field1\Field22[$01]\Field0, collider, 0.0)
                            rotateentity(local10\Field1\Field22[$01]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$01]\Field0, $00), entityyaw(local10\Field1\Field22[$01]\Field4, $00), 35.0), 0.0, $00)
                        EndIf
                        For local12 = Each items
                            If ((((local12\Field16 = $01) And (264.0 > (Abs tformedx()))) Or (local12\Field16 = $FFFFFFFF)) <> 0) Then
                                tformpoint(entityx(local12\Field1, $00), entityy(local12\Field1, $00), entityz(local12\Field1, $00), $00, local10\Field1\Field2)
                                local18 = tformedx()
                                local19 = tformedy()
                                local20 = tformedz()
                                If (local12\Field16 = $01) Then
                                    For local1 = $FFFFFFFF To $01 Step $02
                                        tformpoint((local18 + (Float (local1 Shl $0A))), local19, local20, local10\Field1\Field2, $00)
                                        local13 = createitem(local12\Field0, local12\Field3\Field1, tformedx(), entityy(local12\Field1, $00), tformedz(), $00, $00, $00, 1.0, $00)
                                        rotateentity(local13\Field1, entitypitch(local12\Field1, $00), entityyaw(local12\Field1, $00), 0.0, $00)
                                        entitytype(local13\Field1, $03, $00)
                                    Next
                                Else
                                    For local13 = Each items
                                        If (((local13 <> local12) And (15.0 > local13\Field11)) <> 0) Then
                                            tformpoint(entityx(local13\Field1, $00), entityy(local13\Field1, $00), entityz(local13\Field1, $00), $00, local10\Field1\Field2)
                                            If (local20 = tformedz()) Then
                                                removeitem(local13)
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (26.0 < local10\Field2) Then
                    If (8.0 > (Abs (entityx(collider, $00) - local10\Field1\Field3))) Then
                        If (8.0 > (Abs (entityz(collider, $00) - local10\Field1\Field5))) Then
                            If (local10\Field9 = $00) Then
                                local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\970\Corpse.ogg"))
                            EndIf
                            local10\Field6 = loopsound2(local10\Field9, local10\Field6, camera, local10\Field1\Field22[$00]\Field0, 10.0, 1.0)
                            If (30.0 > local10\Field2) Then
                                lightvolume = (templightvolume * 0.4)
                            ElseIf (60.0 < local10\Field2) Then
                                animatenpc(local10\Field1\Field22[$00], 80.0, 61.0, -0.02, $00)
                                local10\Field1\Field22[$00]\Field7 = 0.0
                                local19 = curvevalue(((sin(((Float millisecs2()) / 20.0)) * 0.1) + 1.5), entityy(local10\Field1\Field22[$00]\Field4, $00), 50.0)
                                positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field22[$00]\Field4, $00), local19, entityz(local10\Field1\Field22[$00]\Field4, $00), $00)
                                turnentity(local10\Field1\Field22[$00]\Field4, 0.0, (local23\Field3[$00] * 0.1), 0.0, $00)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room3door"
                If (playerroom = local10\Field1) Then
                    If (2.5 > entitydistance(local10\Field1\Field2, collider)) Then
                        For local28 = Each doors
                            If (2.0 > (Abs (entityx(local28\Field0, $01) - entityx(collider, $00)))) Then
                                If (2.0 > (Abs (entityz(local28\Field0, $01) - entityz(collider, $00)))) Then
                                    If (entityinview(local28\Field0, camera) = $00) Then
                                        If (local28\Field5 <> 0) Then
                                            local28\Field5 = $00
                                            local28\Field7 = 0.0
                                            blurtimer = 100.0
                                            camerashake = 3.0
                                        EndIf
                                    EndIf
                                    Exit
                                EndIf
                            EndIf
                        Next
                        removeevent(local10)
                    EndIf
                EndIf
            Case "room3servers"
                If (playerroom = local10\Field1) Then
                    If (((0.0 = local10\Field4) And (0.0 = curr173\Field24)) <> 0) Then
                        If (-10.0 > blinktimer) Then
                            local2 = rand($00, $02)
                            positionentity(curr173\Field4, entityx(local10\Field1\Field19[local2], $01), entityy(local10\Field1\Field19[local2], $01), entityz(local10\Field1\Field19[local2], $01), $00)
                            resetentity(curr173\Field4)
                            local10\Field4 = 1.0
                        EndIf
                    EndIf
                    If (local10\Field1\Field19[$03] > $00) Then
                        If (((-8.0 > blinktimer) And (-12.0 < blinktimer)) <> 0) Then
                            pointentity(local10\Field1\Field19[$03], camera, 0.0)
                            rotateentity(local10\Field1\Field19[$03], 0.0, entityyaw(local10\Field1\Field19[$03], $01), 0.0, $01)
                        EndIf
                        If (0.0 = local10\Field3) Then
                            local10\Field2 = curvevalue(0.0, local10\Field2, 15.0)
                            If (rand($320, $01) = $01) Then
                                local10\Field3 = 1.0
                            EndIf
                        Else
                            local10\Field2 = (local10\Field2 + (local23\Field3[$00] * 0.5))
                            If (360.0 < local10\Field2) Then
                                local10\Field2 = 0.0
                            EndIf
                            If (rand($4B0, $01) = $01) Then
                                local10\Field3 = 0.0
                            EndIf
                        EndIf
                        positionentity(local10\Field1\Field19[$03], entityx(local10\Field1\Field19[$03], $01), (((-608.0 * roomscale) + 0.05) + (sin((local10\Field2 + 270.0)) * 0.05)), entityz(local10\Field1\Field19[$03], $01), $01)
                    EndIf
                EndIf
            Case "room3storage"
                If (playerroom = local10\Field1) Then
                    local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$00], local10\Field1\Field19[$01], local10, $01)
                    local10\Field4 = updateelevators(local10\Field4, local10\Field1\Field21[$02], local10\Field1\Field21[$03], local10\Field1\Field19[$02], local10\Field1\Field19[$03], local10, $01)
                    If ((-4600.0 * roomscale) > entityy(collider, $00)) Then
                        For local9 = Each rooms
                            hideentity(local9\Field2)
                        Next
                        showentity(local10\Field1\Field2)
                        giveachievement($15, $01)
                        shouldplay = $07
                        If (((((local10\Field1\Field22[$00] = Null) Or (local10\Field1\Field22[$01] = Null)) Or (local10\Field1\Field22[$02] = Null)) Or (local10\Field1\Field22[$03] = Null)) <> 0) Then
                            If (quickloadpercent = $FFFFFFFF) Then
                                quickloadpercent = $00
                                quickload_currevent = local10
                            EndIf
                        Else
                            If (0.0 = local10\Field2) Then
                                positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field19[$04], $01), (entityy(local10\Field1\Field19[$04], $01) + 0.2), entityz(local10\Field1\Field19[$04], $01), $00)
                                resetentity(local10\Field1\Field22[$00]\Field4)
                                local10\Field1\Field22[$00]\Field9 = 2.0
                                local10\Field1\Field22[$00]\Field10 = 5.0
                                local10\Field1\Field22[$00]\Field12 = $07
                                positionentity(local10\Field1\Field22[$01]\Field4, entityx(local10\Field1\Field19[$09], $01), (entityy(local10\Field1\Field19[$09], $01) + 0.2), entityz(local10\Field1\Field19[$09], $01), $00)
                                resetentity(local10\Field1\Field22[$01]\Field4)
                                local10\Field1\Field22[$01]\Field9 = 2.0
                                local10\Field1\Field22[$01]\Field10 = 10.0
                                local10\Field1\Field22[$01]\Field12 = $0C
                                positionentity(local10\Field1\Field22[$02]\Field4, entityx(local10\Field1\Field19[$0D], $01), (entityy(local10\Field1\Field19[$0D], $01) + 0.2), entityz(local10\Field1\Field19[$0D], $01), $00)
                                resetentity(local10\Field1\Field22[$02]\Field4)
                                local10\Field1\Field22[$02]\Field9 = 2.0
                                local10\Field1\Field22[$02]\Field10 = 14.0
                                local10\Field1\Field22[$02]\Field12 = $10
                                positionentity(local10\Field1\Field22[$03]\Field4, entityx(local10\Field1\Field19[$06], $01), (entityy(local10\Field1\Field19[$06], $01) + 0.2), entityz(local10\Field1\Field19[$06], $01), $00)
                                resetentity(local10\Field1\Field22[$03]\Field4)
                                local10\Field1\Field22[$03]\Field9 = 2.0
                                local10\Field1\Field22[$03]\Field10 = 7.0
                                local10\Field1\Field22[$03]\Field12 = $07
                                local10\Field2 = 1.0
                            EndIf
                            If (local10\Field1\Field21[$04]\Field5 = $00) Then
                                If (updatelever(local10\Field1\Field20[$00], $00) <> 0) Then
                                    local10\Field1\Field21[$04]\Field5 = $01
                                    If (local10\Field10 <> $00) Then
                                        freesound_strict(local10\Field10)
                                        local10\Field10 = $00
                                    EndIf
                                    local10\Field10 = loadsound_strict(scpmodding_processfilepath("SFX\Door\Door2Open1_dist.ogg"))
                                    local10\Field7 = playsound2(local10\Field10, camera, local10\Field1\Field21[$04]\Field0, 400.0, 1.0)
                                EndIf
                                If (updatelever(local10\Field1\Field20[$01], $00) <> 0) Then
                                    local10\Field1\Field21[$04]\Field5 = $01
                                    If (local10\Field10 <> $00) Then
                                        freesound_strict(local10\Field10)
                                        local10\Field10 = $00
                                    EndIf
                                    local10\Field10 = loadsound_strict(scpmodding_processfilepath("SFX\Door\Door2Open1_dist.ogg"))
                                    local10\Field7 = playsound2(local10\Field10, camera, local10\Field1\Field21[$04]\Field0, 400.0, 1.0)
                                EndIf
                            EndIf
                            updatelever(local10\Field1\Field20[$00], local10\Field1\Field21[$04]\Field5)
                            updatelever(local10\Field1\Field20[$01], local10\Field1\Field21[$04]\Field5)
                            local10\Field1\Field22[$00]\Field50 = $00
                            local10\Field1\Field22[$02]\Field50 = $00
                            local10\Field1\Field22[$03]\Field50 = $00
                            local17 = checktriggers()
                            Select local17
                                Case "939-1_fix"
                                    local10\Field1\Field22[$00]\Field50 = $01
                                    local10\Field1\Field22[$03]\Field50 = $01
                                Case "939-3_fix"
                                    local10\Field1\Field22[$02]\Field50 = $01
                            End Select
                            If (channelplaying(local10\Field7) <> 0) Then
                                updatesoundorigin(local10\Field7, camera, local10\Field1\Field21[$04]\Field0, 400.0, 1.0)
                            EndIf
                            playerfallingpickdistance = 0.0
                            If (((((-6400.0 * roomscale) > entityy(collider, $00)) And (0.0 <= killtimer)) And (0.0 <= falltimer)) <> 0) Then
                                deathmsg = ""
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\PocketDimension\Impact.ogg")))
                                killtimer = -1.0
                            EndIf
                        EndIf
                    Else
                        local10\Field2 = 0.0
                        If (local10\Field1\Field22[$00] <> Null) Then
                            local10\Field1\Field22[$00]\Field9 = 66.0
                        EndIf
                        If (local10\Field1\Field22[$01] <> Null) Then
                            local10\Field1\Field22[$01]\Field9 = 66.0
                        EndIf
                        If (local10\Field1\Field22[$02] <> Null) Then
                            local10\Field1\Field22[$02]\Field9 = 66.0
                        EndIf
                        If (local10\Field1\Field22[$03] <> Null) Then
                            local10\Field1\Field22[$03]\Field9 = 66.0
                        EndIf
                    EndIf
                Else
                    If (local10\Field1\Field22[$00] <> Null) Then
                        local10\Field1\Field22[$00]\Field9 = 66.0
                    EndIf
                    If (local10\Field1\Field22[$01] <> Null) Then
                        local10\Field1\Field22[$01]\Field9 = 66.0
                    EndIf
                    If (local10\Field1\Field22[$02] <> Null) Then
                        local10\Field1\Field22[$02]\Field9 = 66.0
                    EndIf
                    If (local10\Field1\Field22[$03] <> Null) Then
                        local10\Field1\Field22[$03]\Field9 = 66.0
                    EndIf
                EndIf
            Case "room3tunnel"
                If (0.0 = local10\Field2) Then
                    local10\Field1\Field22[$00] = createnpc($13, entityx(local10\Field1\Field19[$00], $01), (entityy(local10\Field1\Field19[$00], $01) + 0.5), entityz(local10\Field1\Field19[$00], $01))
                    pointentity(local10\Field1\Field22[$00]\Field4, local10\Field1\Field2, 0.0)
                    rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (entityyaw(local10\Field1\Field22[$00]\Field4, $00) + rnd(-20.0, 20.0)), 0.0, $01)
                    setnpcframe(local10\Field1\Field22[$00], 288.0)
                    local10\Field1\Field22[$00]\Field9 = 8.0
                    local10\Field2 = 1.0
                    removeevent(local10)
                EndIf
            Case "room4"
                If ((Float millisecs2()) > local10\Field2) Then
                    If (playerroom <> local10\Field1) Then
                        If (16.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))) Then
                            For local8 = Each npcs
                                If (local8\Field5 = $03) Then
                                    If (((2.0 = local8\Field9) And (16.0 < entitydistance(collider, local8\Field4))) <> 0) Then
                                        tformvector(368.0, 528.0, 176.0, local10\Field1\Field2, $00)
                                        positionentity(local8\Field4, (entityx(local10\Field1\Field2, $00) + tformedx()), tformedy(), (entityz(local10\Field1\Field2, $00) + tformedz()), $00)
                                        resetentity(local8\Field4)
                                        local8\Field37 = $00
                                        local8\Field9 = 4.0
                                        local8\Field10 = 0.0
                                        local8\Field11 = 0.0
                                        removeevent(local10)
                                    EndIf
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                    If (local10 <> Null) Then
                        local10\Field2 = (Float (millisecs2() + $1388))
                    EndIf
                EndIf
            Case "room012"
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field2) Then
                        If (((2.5 > entitydistance(collider, local10\Field1\Field21[$00]\Field0)) And remotedooron) <> 0) Then
                            giveachievement($01, $01)
                            playsound_strict(horrorsfx($07))
                            playsound2(leversfx, camera, local10\Field1\Field21[$00]\Field0, 10.0, 1.0)
                            local10\Field2 = 1.0
                            local10\Field1\Field21[$00]\Field4 = $00
                            usedoor(local10\Field1\Field21[$00], $00, $01)
                            local10\Field1\Field21[$00]\Field4 = $01
                        EndIf
                    Else
                        If (local10\Field9 = $00) Then
                            loadeventsound(local10, scpmodding_processfilepath("SFX\Music\Room012Golgotha.ogg"), $00)
                        EndIf
                        If ((-50.0 * roomscale) > entityy(collider, $00)) Then
                            local10\Field6 = loopsound2(local10\Field9, local10\Field6, camera, local10\Field1\Field19[$03], 5.0, 1.0)
                        EndIf
                        If (local10\Field10 = $00) Then
                            loadeventsound(local10, scpmodding_processfilepath("SFX\Music\Room012.ogg"), $01)
                        EndIf
                        If (90.0 > local10\Field2) Then
                            local10\Field2 = curvevalue(90.0, local10\Field2, 500.0)
                        EndIf
                        positionentity(local10\Field1\Field19[$02], entityx(local10\Field1\Field19[$02], $01), ((-130.0 - (sin(local10\Field2) * 448.0)) * roomscale), entityz(local10\Field1\Field19[$02], $01), $01)
                        If (((0.0 < local10\Field3) And (200.0 > local10\Field3)) <> 0) Then
                            local10\Field3 = (local10\Field3 + local23\Field3[$00])
                            rotateentity(local10\Field1\Field19[$01], curvevalue(85.0, entitypitch(local10\Field1\Field19[$01], $00), 5.0), entityyaw(local10\Field1\Field19[$01], $00), 0.0, $00)
                        Else
                            local10\Field3 = (local10\Field3 + local23\Field3[$00])
                            If (250.0 > local10\Field3) Then
                                showentity(local10\Field1\Field19[$03])
                            Else
                                hideentity(local10\Field1\Field19[$03])
                                If (300.0 < local10\Field3) Then
                                    local10\Field3 = 200.0
                                EndIf
                            EndIf
                        EndIf
                        If ((((i_714\Field0 = $00) And (wearinggasmask < $03)) And (wearinghazmat < $03)) <> 0) Then
                            If (entityvisible(local10\Field1\Field19[$02], camera) <> 0) Then
                                local10\Field7 = loopsound2(local10\Field10, local10\Field7, camera, local10\Field1\Field19[$03], 10.0, (local10\Field4 / 6020.0))
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), (entityy(local10\Field1\Field19[$02], $01) - 0.05), entityz(camera, $00), $00)
                                pointentity(local3, local10\Field1\Field19[$02], 0.0)
                                rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local3, $00), entityyaw(collider, $00), (80.0 - (local10\Field4 / 200.0))), 0.0, $00)
                                turnentity(local3, 90.0, 0.0, 0.0, $00)
                                user_camera_pitch = curveangle((entitypitch(local3, $00) + 25.0), (user_camera_pitch + 90.0), (80.0 - (local10\Field4 / 200.0)))
                                user_camera_pitch = (user_camera_pitch - 90.0)
                                local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01))
                                heartbeatrate = 150.0
                                heartbeatvolume = (max((3.0 - local0), 0.0) / 3.0)
                                blurvolume = max((((2.0 - local0) * (local10\Field4 / 800.0)) * sin((((Float millisecs2()) / 20.0) + 1.0))), blurvolume)
                                currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 8.0) * max((3.0 - local0), 0.0)))
                                If (breathchn <> $00) Then
                                    If (channelplaying(breathchn) <> 0) Then
                                        stopchannel(breathchn)
                                    EndIf
                                EndIf
                                If (0.6 > local0) Then
                                    local10\Field4 = min((local10\Field4 + local23\Field3[$00]), 6020.0)
                                    If (((70.0 < local10\Field4) And (70.0 >= (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\012\Speech1.ogg")))
                                    ElseIf (((910.0 < local10\Field4) And (910.0 >= (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                        If (i_1033ru\Field0 = $00) Then
                                            msg = scplang_getphrase("events.room0121")
                                            msgtimer = 490.0
                                            injuries = (injuries + 0.5)
                                            playsound_strict(loadtempsound("SFX\SCP\012\Speech2.ogg"))
                                        Else
                                            msg = scplang_getphrase("events.room0122")
                                            msgtimer = 490.0
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\012\Speech2.ogg")))
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                                        EndIf
                                    ElseIf (((2170.0 < local10\Field4) And (2170.0 >= (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                        If (i_1033ru\Field0 = $00) Then
                                            local73 = loadtexture_strict(scpmodding_processfilepath("GFX\map\scp-012_1.png"), $01)
                                            entitytexture(local10\Field1\Field19[$04], local73, $00, $01)
                                            freetexture(local73)
                                            msg = scplang_getphrase("events.room0123")
                                            msgtimer = 490.0
                                            injuries = max(injuries, 1.5)
                                            playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\012\Speech" + (Str rand($03, $04))) + ".ogg"))))
                                        Else
                                            msg = scplang_getphrase("events.room0124")
                                            msgtimer = 490.0
                                            playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\012\Speech" + (Str rand($03, $04))) + ".ogg"))))
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                                        EndIf
                                    ElseIf (((3430.0 < local10\Field4) And (3430.0 >= (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                        If (i_1033ru\Field0 = $00) Then
                                            msg = scplang_getphrase("events.room0125")
                                            msgtimer = 560.0
                                            injuries = (injuries + 0.3)
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\012\Speech5.ogg")))
                                        Else
                                            msg = scplang_getphrase("events.room0126")
                                            msgtimer = 560.0
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\012\Speech5.ogg")))
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                                        EndIf
                                    ElseIf (((4410.0 < local10\Field4) And (4410.0 >= (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                        If (i_1033ru\Field0 = $00) Then
                                            local73 = loadtexture_strict(scpmodding_processfilepath("GFX\map\scp-012_2.png"), $01)
                                            entitytexture(local10\Field1\Field19[$04], local73, $00, $01)
                                            freetexture(local73)
                                            injuries = (injuries + 0.5)
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\012\Speech6.ogg")))
                                        Else
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                                        EndIf
                                    ElseIf (((5180.0 < local10\Field4) And (5180.0 >= (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                        If (i_1033ru\Field0 = $00) Then
                                            local73 = loadtexture_strict(scpmodding_processfilepath("GFX\map\scp-012_3.png"), $01)
                                            entitytexture(local10\Field1\Field19[$04], local73, $00, $01)
                                            freetexture(local73)
                                            msg = scplang_getphrase("events.room0127")
                                            msgtimer = 490.0
                                            injuries = (injuries + 0.8)
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\012\Speech7.ogg")))
                                            crouch = $01
                                            local30 = createdecal($11, entityx(collider, $00), ((-768.0 * roomscale) + 0.01), entityz(collider, $00), 90.0, rnd(360.0, 0.0), 0.0)
                                            local30\Field2 = 0.1
                                            local30\Field3 = 0.45
                                            local30\Field1 = 0.0002
                                            updatedecals()
                                        Else
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                                        EndIf
                                    ElseIf (((5950.0 < local10\Field4) And (5950.0 >= (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                        If (i_1033ru\Field0 = $00) Then
                                            deathmsg = ("Subject D-9341" + scplang_getphrase("events.room0128"))
                                            kill($01, $00)
                                        Else
                                            local10\Field4 = 1.0
                                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                                        EndIf
                                    EndIf
                                    rotateentity(collider, entitypitch(collider, $00), curveangle(((sin((local10\Field4 * (local10\Field4 / 2000.0))) * (local10\Field4 / 300.0)) + entityyaw(collider, $00)), entityyaw(collider, $00), 80.0), 0.0, $00)
                                Else
                                    local21 = wrapangle((entityyaw(local3, $00) - entityyaw(collider, $00)))
                                    If (40.0 > local21) Then
                                        forcemove = ((40.0 - local21) * 0.02)
                                    ElseIf (310.0 < local21) Then
                                        forcemove = ((40.0 - (Abs (360.0 - local21))) * 0.02)
                                    EndIf
                                EndIf
                                freeentity(local3)
                            ElseIf (((4.5 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field21[$00]\Field2, $00), entityz(local10\Field1\Field21[$00]\Field2, $00))) And (-2.5 > entityy(collider, $00))) <> 0) Then
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), entityy(collider, $00), entityz(camera, $00), $00)
                                pointentity(local3, local10\Field1\Field21[$00]\Field2, 0.0)
                                user_camera_pitch = curveangle(90.0, (user_camera_pitch + 90.0), 100.0)
                                user_camera_pitch = (user_camera_pitch - 90.0)
                                rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local3, $00), entityyaw(collider, $00), 150.0), 0.0, $00)
                                local21 = wrapangle((entityyaw(local3, $00) - entityyaw(collider, $00)))
                                If (40.0 > local21) Then
                                    forcemove = ((40.0 - local21) * 0.008)
                                ElseIf (310.0 < local21) Then
                                    forcemove = ((40.0 - (Abs (360.0 - local21))) * 0.008)
                                EndIf
                                freeentity(local3)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room035"
                If (playerroom = local10\Field1) Then
                    shouldplay = $20
                    If (0.0 = local10\Field2) Then
                        If (2.0 > entitydistance(collider, local10\Field1\Field19[$03])) Then
                            local8 = createnpc($12, entityx(local10\Field1\Field19[$04], $01), 0.5, entityz(local10\Field1\Field19[$04], $01))
                            local8\Field23 = scpmodding_processfilepath("GFX\npcs\scp_035_victim.png")
                            local8\Field64 = scpmodding_processfilepath("GFX\npcs\scp_035.b3d")
                            hideentity(local8\Field0)
                            setanimtime(local8\Field0, 501.0, $00)
                            local8\Field14 = 501.0
                            local8\Field9 = 6.0
                            local10\Field2 = 1.0
                        EndIf
                    ElseIf (0.0 < local10\Field2) Then
                        If (local10\Field1\Field22[$00] = Null) Then
                            For local8 = Each npcs
                                If (local8\Field23 = scpmodding_processfilepath("GFX\npcs\scp_035_victim.png")) Then
                                    local10\Field1\Field22[$00] = local8
                                    local2 = (Int local10\Field1\Field22[$00]\Field14)
                                    freeentity(local10\Field1\Field22[$00]\Field0)
                                    local10\Field1\Field22[$00]\Field0 = copyentity(local22\Field0[$20], $00)
                                    local18 = (0.5 / meshwidth(local10\Field1\Field22[$00]\Field0))
                                    local10\Field1\Field22[$00]\Field65 = local18
                                    local10\Field1\Field22[$00]\Field66 = local18
                                    local10\Field1\Field22[$00]\Field67 = local18
                                    scaleentity(local10\Field1\Field22[$00]\Field0, local18, local18, local18, $00)
                                    setanimtime(local10\Field1\Field22[$00]\Field0, (Float local2), $00)
                                    showentity(local10\Field1\Field22[$00]\Field0)
                                    rotateentity(local8\Field4, 0.0, (Float (local10\Field1\Field6 + $10E)), 0.0, $01)
                                    Exit
                                EndIf
                            Next
                        EndIf
                        If (local10\Field1\Field22[$00]\Field17 <> $00) Then
                            If (channelplaying(local10\Field1\Field22[$00]\Field17) <> 0) Then
                                local10\Field1\Field22[$00]\Field17 = loopsound2(local10\Field1\Field22[$00]\Field16, local10\Field1\Field22[$00]\Field17, camera, local10\Field1\Field2, 6.0, 1.0)
                            EndIf
                        EndIf
                        If (1.0 = local10\Field2) Then
                            If (1.2 > entitydistance(collider, local10\Field1\Field19[$03])) Then
                                If (entityinview(local10\Field1\Field22[$00]\Field0, camera) <> 0) Then
                                    giveachievement($02, $01)
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\035\GetUp.ogg")))
                                    local10\Field2 = 1.5
                                EndIf
                            EndIf
                        Else
                            If (local10\Field1\Field21[$03]\Field5 <> 0) Then
                                local10\Field3 = max(local10\Field3, 1.0)
                            EndIf
                            If (updatelever(local10\Field1\Field20[$00], (20.0 = local10\Field3)) = $00) Then
                                local2 = updatelever(local10\Field1\Field20[$01], $00)
                                If ((local2 Or ((1750.0 < local10\Field4) And (3500.0 > local10\Field4))) <> 0) Then
                                    If (local2 <> 0) Then
                                        positionentity(local10\Field1\Field19[$05], entityx(local10\Field1\Field19[$05], $01), (424.0 * roomscale), entityz(local10\Field1\Field19[$05], $01), $01)
                                        positionentity(local10\Field1\Field19[$06], entityx(local10\Field1\Field19[$06], $01), (424.0 * roomscale), entityz(local10\Field1\Field19[$06], $01), $01)
                                    Else
                                        positionentity(local10\Field1\Field19[$05], entityx(local10\Field1\Field19[$05], $01), 10.0, entityz(local10\Field1\Field19[$05], $01), $01)
                                        positionentity(local10\Field1\Field19[$06], entityx(local10\Field1\Field19[$06], $01), 10.0, entityz(local10\Field1\Field19[$06], $01), $01)
                                    EndIf
                                    If (-2100.0 < local10\Field4) Then
                                        local10\Field4 = ((Abs local10\Field4) + local23\Field3[$00])
                                        If (((1.0 < local10\Field4) And (1.0 >= (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                            local10\Field1\Field22[$00]\Field9 = 0.0
                                            If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                local10\Field1\Field22[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Gased1.ogg"))
                                            local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                        ElseIf (((1050.0 < local10\Field4) And (1750.0 > local10\Field4)) <> 0) Then
                                            If (1050.0 >= (local10\Field4 - local23\Field3[$00])) Then
                                                If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                    local10\Field1\Field22[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Gased2.ogg"))
                                                local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                                setnpcframe(local10\Field1\Field22[$00], 553.0)
                                            EndIf
                                            local10\Field1\Field22[$00]\Field9 = 6.0
                                            animatenpc(local10\Field1\Field22[$00], 553.0, 529.0, -0.12, $00)
                                        ElseIf (((1750.0 < local10\Field4) And (2450.0 > local10\Field4)) <> 0) Then
                                            local10\Field1\Field22[$00]\Field9 = 6.0
                                            animatenpc(local10\Field1\Field22[$00], 529.0, 524.0, -0.08, $00)
                                        ElseIf (2450.0 < local10\Field4) Then
                                            If (6.0 = local10\Field1\Field22[$00]\Field9) Then
                                                sanity = ((sin((animtime(local10\Field1\Field22[$00]\Field0) - 524.0)) * -150.0) * 9.0)
                                                animatenpc(local10\Field1\Field22[$00], 524.0, 553.0, 0.08, $00)
                                                If (553.0 = local10\Field1\Field22[$00]\Field14) Then
                                                    local10\Field1\Field22[$00]\Field9 = 0.0
                                                EndIf
                                            EndIf
                                            If (2450.0 >= (local10\Field4 - local23\Field3[$00])) Then
                                                If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                    local10\Field1\Field22[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\GasedKilled1.ogg"))
                                                local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\035\KilledGetUp.ogg")))
                                                local10\Field2 = 4200.0
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    If (6.0 = local10\Field1\Field22[$00]\Field9) Then
                                        If (((501.0 <= local10\Field1\Field22[$00]\Field14) And (523.0 >= local10\Field1\Field22[$00]\Field14)) <> 0) Then
                                            local10\Field1\Field22[$00]\Field14 = animate2(local10\Field1\Field22[$00]\Field0, animtime(local10\Field1\Field22[$00]\Field0), $1F5, $20B, 0.08, $00)
                                            If (523.0 = local10\Field1\Field22[$00]\Field14) Then
                                                local10\Field1\Field22[$00]\Field9 = 0.0
                                            EndIf
                                        EndIf
                                        If (((524.0 <= local10\Field1\Field22[$00]\Field14) And (553.0 >= local10\Field1\Field22[$00]\Field14)) <> 0) Then
                                            local10\Field1\Field22[$00]\Field14 = animate2(local10\Field1\Field22[$00]\Field0, animtime(local10\Field1\Field22[$00]\Field0), $20C, $229, 0.08, $00)
                                            If (553.0 = local10\Field1\Field22[$00]\Field14) Then
                                                local10\Field1\Field22[$00]\Field9 = 0.0
                                            EndIf
                                        EndIf
                                    EndIf
                                    positionentity(local10\Field1\Field19[$05], entityx(local10\Field1\Field19[$05], $01), 10.0, entityz(local10\Field1\Field19[$05], $01), $01)
                                    positionentity(local10\Field1\Field19[$06], entityx(local10\Field1\Field19[$06], $01), 10.0, entityz(local10\Field1\Field19[$06], $01), $01)
                                    If (0.0 = local10\Field1\Field22[$00]\Field9) Then
                                        pointentity(local10\Field1\Field22[$00]\Field0, collider, 0.0)
                                        rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$00]\Field0, $00), entityyaw(local10\Field1\Field22[$00]\Field4, $00), 15.0), 0.0, $00)
                                        If (rand($1F4, $01) = $01) Then
                                            If (2.0 < entitydistance(local10\Field1\Field22[$00]\Field4, local10\Field1\Field19[$04])) Then
                                                local10\Field1\Field22[$00]\Field10 = 1.0
                                            Else
                                                local10\Field1\Field22[$00]\Field10 = 0.0
                                            EndIf
                                            local10\Field1\Field22[$00]\Field9 = 1.0
                                        EndIf
                                    ElseIf (1.0 = local10\Field1\Field22[$00]\Field9) Then
                                        If (1.0 = local10\Field1\Field22[$00]\Field10) Then
                                            pointentity(local10\Field1\Field22[$00]\Field0, local10\Field1\Field19[$04], 0.0)
                                            If (0.2 > entitydistance(local10\Field1\Field22[$00]\Field4, local10\Field1\Field19[$04])) Then
                                                local10\Field1\Field22[$00]\Field9 = 0.0
                                            EndIf
                                        Else
                                            rotateentity(local10\Field1\Field22[$00]\Field0, 0.0, (Float (local10\Field1\Field6 - $B4)), 0.0, $01)
                                            If (2.0 < entitydistance(local10\Field1\Field22[$00]\Field4, local10\Field1\Field19[$04])) Then
                                                local10\Field1\Field22[$00]\Field9 = 0.0
                                            EndIf
                                        EndIf
                                        rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$00]\Field0, $00), entityyaw(local10\Field1\Field22[$00]\Field4, $00), 15.0), 0.0, $00)
                                    EndIf
                                    If (0.0 < local10\Field4) Then
                                        local10\Field4 = (- local10\Field4)
                                        If (-2450.0 > local10\Field4) Then
                                            If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                local10\Field1\Field22[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\GasedKilled2.ogg"))
                                            local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                            local10\Field2 = 4200.0
                                        Else
                                            If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                local10\Field1\Field22[$00]\Field16 = $00
                                            EndIf
                                            If (-1400.0 > local10\Field4) Then
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\GasedStop2.ogg"))
                                            Else
                                                local10\Field4 = -1470.0
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\GasedStop1.ogg"))
                                            EndIf
                                            local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                            local10\Field2 = 4270.0
                                        EndIf
                                    Else
                                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                                        If (((280.0 < local10\Field2) And (280.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                            If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                local10\Field1\Field22[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Help1.ogg"))
                                            local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                            local10\Field2 = 700.0
                                        ElseIf (((1400.0 < local10\Field2) And (1400.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                            If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                local10\Field1\Field22[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Help2.ogg"))
                                            local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                        ElseIf (((2800.0 < local10\Field2) And (2800.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                            If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                local10\Field1\Field22[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Idle1.ogg"))
                                            local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                        ElseIf (((3500.0 < local10\Field2) And (3500.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                            If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                local10\Field1\Field22[$00]\Field16 = $00
                                            EndIf
                                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Idle2.ogg"))
                                            local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                        ElseIf (((5600.0 < local10\Field2) And (5600.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                            If ((Int local10\Field3) <> 0) Then
                                                local10\Field2 = 9100.0
                                            ElseIf (-2100.0 > local10\Field4) Then
                                                If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                    local10\Field1\Field22[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\GasedCloset.ogg"))
                                                local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                            ElseIf (0.0 = local10\Field4) Then
                                                If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                    local10\Field1\Field22[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Closet1.ogg"))
                                                local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                            Else
                                                If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                    local10\Field1\Field22[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\GasedCloset.ogg"))
                                                local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                            EndIf
                                        ElseIf (5600.0 < local10\Field2) Then
                                            If ((Int local10\Field3) <> 0) Then
                                                local10\Field2 = max(local10\Field2, 7000.0)
                                            EndIf
                                            If (((7700.0 < local10\Field2) And (7700.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                                If ((Int local10\Field3) <> 0) Then
                                                    If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                        freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                        local10\Field1\Field22[$00]\Field16 = $00
                                                    EndIf
                                                    local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Closet2.ogg"))
                                                    local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                                    local10\Field2 = 9100.0
                                                Else
                                                    If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                        freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                        local10\Field1\Field22[$00]\Field16 = $00
                                                    EndIf
                                                    local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Idle3.ogg"))
                                                    local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                                EndIf
                                            ElseIf (((8750.0 < local10\Field2) And (8750.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                                If ((Int local10\Field3) <> 0) Then
                                                    If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                        freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                        local10\Field1\Field22[$00]\Field16 = $00
                                                    EndIf
                                                    local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Closet2.ogg"))
                                                    local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                                Else
                                                    If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                        freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                        local10\Field1\Field22[$00]\Field16 = $00
                                                    EndIf
                                                    local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Idle4.ogg"))
                                                    local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                                EndIf
                                            ElseIf (((10500.0 < local10\Field2) And (10500.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                                If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                    local10\Field1\Field22[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Idle5.ogg"))
                                                local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                            ElseIf (((14000.0 < local10\Field2) And (14000.0 >= (local10\Field2 - local23\Field3[$00]))) <> 0) Then
                                                If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                                    freesound_strict(local10\Field1\Field22[$00]\Field16)
                                                    local10\Field1\Field22[$00]\Field16 = $00
                                                EndIf
                                                local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Idle6.ogg"))
                                                local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Else
                                If (10.0 > local10\Field3) Then
                                    local10\Field1\Field21[$02]\Field5 = $00
                                    local10\Field1\Field21[$02]\Field4 = $01
                                    If (local10\Field1\Field21[$01]\Field5 = $00) Then
                                        local10\Field1\Field21[$00]\Field4 = $00
                                        local10\Field1\Field21[$01]\Field4 = $00
                                        usedoor(local10\Field1\Field21[$01], $01, $01)
                                        local10\Field1\Field21[$00]\Field4 = $01
                                        local10\Field1\Field21[$01]\Field4 = $01
                                    EndIf
                                    If (0.0 = local10\Field4) Then
                                        If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                            freesound_strict(local10\Field1\Field22[$00]\Field16)
                                            local10\Field1\Field22[$00]\Field16 = $00
                                        EndIf
                                        local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\Escape.ogg"))
                                        local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                    ElseIf (2450.0 < (Abs local10\Field4)) Then
                                        If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                            freesound_strict(local10\Field1\Field22[$00]\Field16)
                                            local10\Field1\Field22[$00]\Field16 = $00
                                        EndIf
                                        local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\KilledEscape.ogg"))
                                        local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                    Else
                                        If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                            freesound_strict(local10\Field1\Field22[$00]\Field16)
                                            local10\Field1\Field22[$00]\Field16 = $00
                                        EndIf
                                        local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\035\GasedEscape.ogg"))
                                        local10\Field1\Field22[$00]\Field17 = playsound_strict(local10\Field1\Field22[$00]\Field16)
                                    EndIf
                                    local10\Field3 = 20.0
                                EndIf
                                If (20.0 = local10\Field3) Then
                                    local0 = entitydistance(local10\Field1\Field21[$00]\Field2, local10\Field1\Field22[$00]\Field4)
                                    local10\Field1\Field22[$00]\Field9 = 1.0
                                    If (2.5 < local0) Then
                                        pointentity(local10\Field1\Field22[$00]\Field0, local10\Field1\Field21[$01]\Field2, 0.0)
                                        rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$00]\Field0, $00), entityyaw(local10\Field1\Field22[$00]\Field4, $00), 15.0), 0.0, $00)
                                    ElseIf (0.7 < local0) Then
                                        If (channelplaying(local10\Field1\Field22[$00]\Field17) <> 0) Then
                                            local10\Field1\Field22[$00]\Field9 = 0.0
                                            pointentity(local10\Field1\Field22[$00]\Field0, collider, 0.0)
                                            rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$00]\Field0, $00), entityyaw(local10\Field1\Field22[$00]\Field4, $00), 15.0), 0.0, $00)
                                        Else
                                            pointentity(local10\Field1\Field22[$00]\Field0, local10\Field1\Field21[$00]\Field2, 0.0)
                                            rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, curveangle(entityyaw(local10\Field1\Field22[$00]\Field0, $00), entityyaw(local10\Field1\Field22[$00]\Field4, $00), 15.0), 0.0, $00)
                                        EndIf
                                    Else
                                        removenpc(local10\Field1\Field22[$00])
                                        local10\Field1\Field22[$00] = Null
                                        local10\Field2 = -1.0
                                        local10\Field3 = 0.0
                                        local10\Field4 = 0.0
                                        local10\Field1\Field21[$00]\Field4 = $00
                                        local10\Field1\Field21[$01]\Field4 = $00
                                        local10\Field1\Field21[$02]\Field4 = $00
                                        usedoor(local10\Field1\Field21[$01], $00, $01)
                                        For local28 = Each doors
                                            If (local28\Field9 = $02) Then
                                                If (4.5 > (Abs (entityx(local10\Field1\Field2, $00) - entityx(local28\Field2, $01)))) Then
                                                    If (4.5 > (Abs (entityz(local10\Field1\Field2, $00) - entityz(local28\Field2, $01)))) Then
                                                        usedoor(local28, $00, $01)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Else
                        If (updatelever(local10\Field1\Field20[$01], $00) <> 0) Then
                            positionentity(local10\Field1\Field19[$05], entityx(local10\Field1\Field19[$05], $01), (424.0 * roomscale), entityz(local10\Field1\Field19[$05], $01), $01)
                            positionentity(local10\Field1\Field19[$06], entityx(local10\Field1\Field19[$06], $01), (424.0 * roomscale), entityz(local10\Field1\Field19[$06], $01), $01)
                        Else
                            positionentity(local10\Field1\Field19[$05], entityx(local10\Field1\Field19[$05], $01), 10.0, entityz(local10\Field1\Field19[$05], $01), $01)
                            positionentity(local10\Field1\Field19[$06], entityx(local10\Field1\Field19[$06], $01), 10.0, entityz(local10\Field1\Field19[$06], $01), $01)
                        EndIf
                        local2 = $00
                        If (entityx(collider, $00) > min(entityx(local10\Field1\Field19[$07], $01), entityx(local10\Field1\Field19[$08], $01))) Then
                            If (entityx(collider, $00) < max(entityx(local10\Field1\Field19[$07], $01), entityx(local10\Field1\Field19[$08], $01))) Then
                                If (entityz(collider, $00) > min(entityz(local10\Field1\Field19[$07], $01), entityz(local10\Field1\Field19[$08], $01))) Then
                                    If (entityz(collider, $00) < max(entityz(local10\Field1\Field19[$07], $01), entityz(local10\Field1\Field19[$08], $01))) Then
                                        shouldplay = $00
                                        If (local10\Field1\Field22[$00] = Null) Then
                                            If (local10\Field1\Field22[$00] = Null) Then
                                                local10\Field1\Field22[$00] = createnpc($02, 0.0, 0.0, 0.0)
                                            EndIf
                                        EndIf
                                        positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field19[$04], $01), 0.1, entityz(local10\Field1\Field19[$04], $01), $00)
                                        If (0.0 < local10\Field1\Field22[$00]\Field9) Then
                                            If (local10\Field1\Field22[$01] = Null) Then
                                                If (local10\Field1\Field22[$01] = Null) Then
                                                    local10\Field1\Field22[$01] = createnpc($02, 0.0, 0.0, 0.0)
                                                EndIf
                                            EndIf
                                        EndIf
                                        stamina = curvevalue(min(60.0, stamina), stamina, 20.0)
                                        local2 = $01
                                        If (local10\Field9 = $00) Then
                                            loadeventsound(local10, scpmodding_processfilepath("SFX\Room\035Chamber\Whispers1.ogg"), $00)
                                        EndIf
                                        If (local10\Field10 = $00) Then
                                            loadeventsound(local10, scpmodding_processfilepath("SFX\Room\035Chamber\Whispers2.ogg"), $01)
                                        EndIf
                                        local10\Field3 = min((local10\Field3 + (local23\Field3[$00] / 6000.0)), 1.0)
                                        local10\Field4 = curvevalue(local10\Field3, local10\Field4, 50.0)
                                        If ((((i_714\Field0 = $00) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                                            sanity = (sanity - (local23\Field3[$00] * 1.1))
                                            blurtimer = (sin((Float (millisecs2() / $0A))) * (Abs sanity))
                                        EndIf
                                        If (wearinghazmat = $00) Then
                                            injuries = ((local23\Field3[$00] / 5000.0) + injuries)
                                        Else
                                            injuries = ((local23\Field3[$00] / 10000.0) + injuries)
                                        EndIf
                                        If (((0.0 > killtimer) And (100.0 <= bloodloss)) <> 0) Then
                                            deathmsg = scplang_getphrase("events.room035")
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        If (local10\Field1\Field22[$01] <> Null) Then
                            positionentity(local10\Field1\Field22[$01]\Field4, entityx(local10\Field1\Field2, $01), 0.1, entityz(local10\Field1\Field2, $01), $00)
                            local21 = wrapangle((entityyaw(local10\Field1\Field22[$01]\Field4, $00) - (Float local10\Field1\Field6)))
                            If (90.0 < local21) Then
                                If (225.0 > local21) Then
                                    rotateentity(local10\Field1\Field22[$01]\Field4, 0.0, (Float ((local10\Field1\Field6 - $59) - $B4)), 0.0, $00)
                                Else
                                    rotateentity(local10\Field1\Field22[$01]\Field4, 0.0, (Float (local10\Field1\Field6 - $01)), 0.0, $00)
                                EndIf
                            EndIf
                        EndIf
                        If (local2 = $00) Then
                            local10\Field3 = max((local10\Field3 - (local23\Field3[$00] / 2000.0)), 0.0)
                            local10\Field4 = max((local10\Field4 - (local23\Field3[$00] / 100.0)), 0.0)
                        EndIf
                        If (((((0.0 < local10\Field4) And (i_714\Field0 = $00)) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                            local10\Field6 = loopsound2(local10\Field9, local10\Field6, camera, local10\Field1\Field2, 10.0, local10\Field4)
                            local10\Field7 = loopsound2(local10\Field10, local10\Field7, camera, local10\Field1\Field2, 10.0, ((local10\Field4 - 0.5) * 2.0))
                        EndIf
                    EndIf
                ElseIf (0.0 = local10\Field2) Then
                    If (local10\Field9 = $00) Then
                        If (20.0 > entitydistance(collider, local10\Field1\Field2)) Then
                            loadeventsound(local10, scpmodding_processfilepath("SFX\Room\035Chamber\InProximity.ogg"), $00)
                            playsound_strict(local10\Field9)
                        EndIf
                    EndIf
                ElseIf (0.0 > local10\Field2) Then
                    For local1 = $00 To $01 Step $01
                        If (local10\Field1\Field22[local1] <> Null) Then
                            removenpc(local10\Field1\Field22[local1])
                            local10\Field1\Field22[local1] = Null
                        EndIf
                    Next
                EndIf
            Case "room049"
                If (playerroom = local10\Field1) Then
                    If ((-2848.0 * roomscale) < entityy(collider, $00)) Then
                        local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$00], local10\Field1\Field19[$01], local10, $01)
                        local10\Field4 = updateelevators(local10\Field4, local10\Field1\Field21[$02], local10\Field1\Field21[$03], local10\Field1\Field19[$02], local10\Field1\Field19[$03], local10, $01)
                    Else
                        shouldplay = $19
                        For local9 = Each rooms
                            hideentity(local9\Field2)
                        Next
                        showentity(local10\Field1\Field2)
                        If (0.0 = local10\Field2) Then
                            If (((local10\Field15 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                                quickloadpercent = $00
                                quickload_currevent = local10
                                local10\Field15 = "load0"
                            EndIf
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\Blackout.ogg")))
                            If (entitydistance(local10\Field1\Field19[$0C], collider) > entitydistance(local10\Field1\Field19[$0B], collider)) Then
                                local12 = createitem("Research Sector-02 Scheme", "paper", entityx(local10\Field1\Field19[$0B], $01), entityy(local10\Field1\Field19[$0B], $01), entityz(local10\Field1\Field19[$0B], $01), $00, $00, $00, 1.0, $00)
                                entitytype(local12\Field1, $03, $00)
                            Else
                                local12 = createitem("Research Sector-02 Scheme", "paper", entityx(local10\Field1\Field19[$0C], $01), entityy(local10\Field1\Field19[$0C], $01), entityz(local10\Field1\Field19[$0C], $01), $00, $00, $00, 1.0, $00)
                                entitytype(local12\Field1, $03, $00)
                            EndIf
                        ElseIf (0.0 < local10\Field2) Then
                            If (0.0 < entitypitch(local10\Field1\Field19[$09], $01)) Then
                                local85 = $01
                            Else
                                local85 = $00
                            EndIf
                            local2 = (updatelever(local10\Field1\Field19[$07], $00) = $00)
                            local18 = (Float updatelever(local10\Field1\Field19[$09], $00))
                            local10\Field1\Field21[$01]\Field4 = $01
                            local10\Field1\Field21[$03]\Field4 = $01
                            local10\Field1\Field21[$01]\Field23 = $00
                            local10\Field1\Field21[$03]\Field23 = $00
                            If (local18 <> (Float local85)) Then
                                If (0.0 = local18) Then
                                    playsound_strict(lightsfx)
                                Else
                                    playsound_strict(teslapowerupsfx)
                                EndIf
                            EndIf
                            If (70.0 <= local10\Field2) Then
                                If ((Int local18) <> 0) Then
                                    shouldplay = $08
                                    local10\Field2 = max(local10\Field2, 12600.0)
                                    secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                                    If (local10\Field10 = $00) Then
                                        loadeventsound(local10, scpmodding_processfilepath("SFX\Ambient\Room ambience\FuelPump.ogg"), $01)
                                    EndIf
                                    local10\Field7 = loopsound2(local10\Field10, local10\Field7, camera, local10\Field1\Field19[$0A], 6.0, 1.0)
                                    For local1 = $04 To $06 Step $01
                                        local10\Field1\Field21[local1]\Field4 = $00
                                    Next
                                Else
                                    secondarylighton = curvevalue(0.0, secondarylighton, 10.0)
                                    If (channelplaying(local10\Field7) <> 0) Then
                                        stopchannel(local10\Field7)
                                    EndIf
                                    For local1 = $04 To $06 Step $01
                                        local10\Field1\Field21[local1]\Field4 = $01
                                    Next
                                EndIf
                            Else
                                local10\Field2 = min((local10\Field2 + local23\Field3[$00]), 70.0)
                            EndIf
                            If ((local2 And (Int local18)) <> 0) Then
                                local10\Field1\Field21[$01]\Field4 = $00
                                local10\Field1\Field21[$03]\Field4 = $00
                                local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$00], local10\Field1\Field19[$01], local10, $01)
                                local10\Field4 = updateelevators(local10\Field4, local10\Field1\Field21[$02], local10\Field1\Field21[$03], local10\Field1\Field19[$02], local10\Field1\Field19[$03], local10, $01)
                                If (0.0 < local10\Field1\Field22[$00]\Field24) Then
                                    local1 = $00
                                    If (3.0 > entitydistance(collider, local10\Field1\Field21[$01]\Field2)) Then
                                        local1 = $01
                                    ElseIf (3.0 > entitydistance(collider, local10\Field1\Field21[$03]\Field2)) Then
                                        local1 = $03
                                    EndIf
                                    If (local1 > $00) Then
                                        positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field19[local1], $01), entityy(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01), $00)
                                        resetentity(local10\Field1\Field22[$00]\Field4)
                                        playsound2(elevatorbeepsfx, camera, local10\Field1\Field19[local1], 4.0, 1.0)
                                        local10\Field1\Field21[local1]\Field4 = $00
                                        usedoor(local10\Field1\Field21[local1], $00, $01)
                                        local10\Field1\Field21[(local1 - $01)]\Field5 = $00
                                        local10\Field1\Field21[local1]\Field5 = $01
                                        local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                                        If (local10\Field1\Field22[$00]\Field19 <> $00) Then
                                            freesound_strict(local10\Field1\Field22[$00]\Field19)
                                        EndIf
                                        local10\Field1\Field22[$00]\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\049\DetectedInChamber.ogg"))
                                        local10\Field1\Field22[$00]\Field20 = loopsound2(local10\Field1\Field22[$00]\Field19, local10\Field1\Field22[$00]\Field20, camera, local10\Field1\Field22[$00]\Field0, 10.0, 1.0)
                                        local10\Field1\Field22[$00]\Field24 = 0.0
                                        local10\Field1\Field22[$00]\Field68 = $00
                                        local10\Field1\Field22[$00]\Field12 = $02
                                        local10\Field1\Field22[$00]\Field9 = 2.0
                                    EndIf
                                EndIf
                            EndIf
                            If (13300.0 > local10\Field2) Then
                                If (12600.0 <= local10\Field2) Then
                                    local10\Field1\Field21[$01]\Field5 = $00
                                    local10\Field1\Field21[$03]\Field5 = $00
                                    local10\Field1\Field21[$00]\Field5 = $01
                                    local10\Field1\Field21[$02]\Field5 = $01
                                    local10\Field2 = 13300.0
                                EndIf
                            ElseIf (16800.0 > local10\Field2) Then
                                For local8 = Each npcs
                                    If ((((local8\Field5 = $04) Or (local8\Field5 = $17)) And (0.0 = local8\Field9)) <> 0) Then
                                        local8\Field9 = 1.0
                                        setnpcframe(local8, 155.0)
                                    EndIf
                                Next
                                local10\Field2 = 16870.0
                            EndIf
                        EndIf
                    EndIf
                Else
                    local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$00], local10\Field1\Field19[$01], local10, $01)
                    local10\Field4 = updateelevators(local10\Field4, local10\Field1\Field21[$02], local10\Field1\Field21[$03], local10\Field1\Field19[$02], local10\Field1\Field19[$03], local10, $01)
                EndIf
                If (0.0 > local10\Field2) Then
                    If (-280.0 < local10\Field2) Then
                        i_008\Field0 = 0.0
                        If (0.0 <= falltimer) Then
                            falltimer = min(-1.0, falltimer)
                            positionentity(head, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
                            resetentity(head)
                            rotateentity(head, 0.0, (entityyaw(camera, $00) + (Float rand($FFFFFFD3, $2D))), 0.0, $00)
                        ElseIf (-230.0 > falltimer) Then
                            falltimer = -231.0
                            blinktimer = 0.0
                            local10\Field2 = (local10\Field2 - local23\Field3[$00])
                            If (-280.0 >= local10\Field2) Then
                                updatedoorstimer = 0.0
                                updatedoors()
                                updaterooms()
                                showentity(collider)
                                dropspeed = 0.0
                                blinktimer = -10.0
                                falltimer = 0.0
                                positionentity(collider, entityx(local10\Field1\Field2, $01), (entityy(local10\Field1\Field19[$05], $01) + 0.2), entityz(local10\Field1\Field2, $01), $00)
                                resetentity(collider)
                                positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field19[$00], $01), entityy(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01), $01)
                                resetentity(local10\Field1\Field22[$00]\Field4)
                                For local8 = Each npcs
                                    If (((local8\Field5 = $04) Or (local8\Field5 = $17)) <> 0) Then
                                        positionentity(local8\Field4, entityx(local10\Field1\Field19[$04], $01), entityy(local10\Field1\Field19[$04], $01), entityz(local10\Field1\Field19[$04], $01), $01)
                                        resetentity(local8\Field4)
                                        local8\Field9 = 4.0
                                    EndIf
                                Next
                                local8 = createnpc($14, entityx(local10\Field1\Field19[$05], $01), (entityy(local10\Field1\Field19[$05], $01) + 0.2), entityz(local10\Field1\Field19[$05], $01))
                                local8\Field9 = 6.0
                                local8\Field25 = 420.0
                                pointentity(local8\Field4, collider, 0.0)
                                local10\Field1\Field22[$01] = local8
                                local8 = createnpc($14, entityx(local10\Field1\Field19[$05], $01), (entityy(local10\Field1\Field19[$05], $01) + 0.2), entityz(local10\Field1\Field19[$05], $01))
                                local8\Field9 = 6.0
                                local8\Field25 = (rnd(15.0, 30.0) + 420.0)
                                rotateentity(local8\Field4, 0.0, entityyaw(local10\Field1\Field22[$01]\Field4, $00), 0.0, $00)
                                moveentity(local8\Field4, 0.5, 0.0, 0.0)
                                pointentity(local8\Field4, collider, 0.0)
                                local8 = createnpc($14, entityx(local10\Field1\Field19[$05], $01), (entityy(local10\Field1\Field19[$05], $01) + 0.2), entityz(local10\Field1\Field19[$05], $01))
                                local8\Field9 = 6.0
                                local8\Field25 = (rnd(15.0, 30.0) + 420.0)
                                rotateentity(local8\Field4, 0.0, entityyaw(local10\Field1\Field22[$01]\Field4, $00), 0.0, $00)
                                local8\Field10 = entityyaw(local8\Field4, $00)
                                moveentity(local8\Field4, -0.65, 0.0, 0.0)
                                moveentity(local10\Field1\Field22[$01]\Field4, 0.0, 0.0, 0.1)
                                pointentity(collider, local10\Field1\Field22[$01]\Field4, 0.0)
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Character\MTF\049\Player0492_1.ogg")))
                                loadeventsound(local10, scpmodding_processfilepath("SFX\SCP\049_2\Breath.ogg"), $00)
                                i_008\Field1 = $01
                            EndIf
                        EndIf
                    Else
                        blurtimer = 800.0
                        forcemove = 0.5
                        injuries = max(2.0, injuries)
                        bloodloss = 0.0
                        i_008\Field0 = 0.0
                        local3 = createpivot($00)
                        positionentity(local3, entityx(local10\Field1\Field22[$01]\Field4, $00), (entityy(local10\Field1\Field22[$01]\Field4, $00) + 0.2), entityz(local10\Field1\Field22[$01]\Field4, $00), $00)
                        pointentity(collider, local10\Field1\Field22[$01]\Field4, 0.0)
                        pointentity(camera, local3, entityroll(camera, $00))
                        freeentity(local3)
                        If (0.0 > killtimer) Then
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Character\MTF\049\Player0492_2.ogg")))
                            removeevent(local10)
                        ElseIf (local10\Field6 = $00) Then
                            local10\Field6 = playsound_strict(local10\Field9)
                        ElseIf (channelplaying(local10\Field6) = $00) Then
                            local10\Field6 = playsound_strict(local10\Field9)
                        EndIf
                    EndIf
                EndIf
            Case "room079"
                If (playerroom = local10\Field1) Then
                    If ((-9500.0 * roomscale) > entityy(collider, $00)) Then
                        For local9 = Each rooms
                            hideentity(local9\Field2)
                        Next
                        showentity(local10\Field1\Field2)
                        If (0.0 = local10\Field2) Then
                            local10\Field1\Field22[$00] = createnpc($13, entityx(local10\Field1\Field19[$02], $01), (entityy(local10\Field1\Field19[$02], $01) + 0.5), entityz(local10\Field1\Field19[$02], $01))
                            pointentity(local10\Field1\Field22[$00]\Field4, local10\Field1\Field2, 0.0)
                            rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, entityyaw(local10\Field1\Field22[$00]\Field4, $00), 0.0, $01)
                            setnpcframe(local10\Field1\Field22[$00], 288.0)
                            local10\Field1\Field22[$00]\Field9 = 8.0
                            local10\Field2 = 1.0
                        EndIf
                        shouldplay = $04
                        If (remotedooron <> 0) Then
                            If (local10\Field1\Field21[$00]\Field5 <> 0) Then
                                If (((50.0 < local10\Field1\Field21[$00]\Field7) Or (0.5 > entitydistance(collider, local10\Field1\Field21[$00]\Field2))) <> 0) Then
                                    local10\Field1\Field21[$00]\Field7 = min(local10\Field1\Field21[$00]\Field7, 50.0)
                                    local10\Field1\Field21[$00]\Field5 = $00
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\DoorError.ogg")))
                                EndIf
                            EndIf
                        ElseIf (10000.0 > local10\Field2) Then
                            If (1.0 = local10\Field2) Then
                                local10\Field2 = 2.0
                            ElseIf (2.0 = local10\Field2) Then
                                If (3.0 > entitydistance(local10\Field1\Field19[$00], collider)) Then
                                    giveachievement($05, $01)
                                    local10\Field2 = 3.0
                                    local10\Field3 = 1.0
                                    local10\Field8 = streamsound_strict(scpmodding_processfilepath("SFX\SCP\079\Speech.ogg"), sfxvolume, $00)
                                    local10\Field14 = $01
                                EndIf
                            ElseIf (2000.0 > local10\Field2) Then
                                If (isstreamplaying_strict(local10\Field8) <> 0) Then
                                    If (rand($04, $01) = $01) Then
                                        entitytexture(local10\Field1\Field19[$01], at\Field1[rand($03, $08)], $00, $00)
                                        showentity(local10\Field1\Field19[$01])
                                    ElseIf (rand($0C, $01) = $01) Then
                                        hideentity(local10\Field1\Field19[$01])
                                    EndIf
                                Else
                                    If (local10\Field8 <> $00) Then
                                        stopstream_strict(local10\Field8)
                                        local10\Field8 = $00
                                    EndIf
                                    entitytexture(local10\Field1\Field19[$01], at\Field1[$09], $00, $00)
                                    showentity(local10\Field1\Field19[$01])
                                    local10\Field2 = (local10\Field2 + local23\Field3[$00])
                                EndIf
                            ElseIf (2.5 > entitydistance(local10\Field1\Field19[$00], collider)) Then
                                local10\Field2 = 10001.0
                                If (local10\Field8 <> $00) Then
                                    stopstream_strict(local10\Field8)
                                    local10\Field8 = $00
                                EndIf
                                local10\Field8 = streamsound_strict(scpmodding_processfilepath("SFX\SCP\079\Refuse.ogg"), sfxvolume, $00)
                            EndIf
                        ElseIf (local10\Field8 <> $00) Then
                            If (isstreamplaying_strict(local10\Field8) = $00) Then
                                local10\Field8 = $00
                                entitytexture(local10\Field1\Field19[$01], at\Field1[$09], $00, $00)
                                showentity(local10\Field1\Field19[$01])
                            ElseIf (rand($04, $01) = $01) Then
                                entitytexture(local10\Field1\Field19[$01], at\Field1[rand($03, $08)], $00, $00)
                                showentity(local10\Field1\Field19[$01])
                            ElseIf (rand($0C, $01) = $01) Then
                                hideentity(local10\Field1\Field19[$01])
                            EndIf
                        EndIf
                    EndIf
                    local10\Field5 = updateelevators(local10\Field5, local10\Field1\Field21[$01], local10\Field1\Field21[$02], local10\Field1\Field19[$03], local10\Field1\Field19[$04], local10, $01)
                EndIf
                If (1.0 = local10\Field3) Then
                    If (remotedooron <> 0) Then
                        If (local10\Field8 <> $00) Then
                            stopstream_strict(local10\Field8)
                            local10\Field8 = $00
                        EndIf
                        local10\Field8 = streamsound_strict(scpmodding_processfilepath("SFX\SCP\079\GateB.ogg"), sfxvolume, $00)
                        local10\Field14 = $01
                        local10\Field3 = 2.0
                        For local11 = Each events
                            If (((local11\Field0 = "gateb") Or (local11\Field0 = "gateaentrance")) <> 0) Then
                                local11\Field4 = 1.0
                            EndIf
                        Next
                    EndIf
                EndIf
            Case "room106"
                If (soundtransmission <> 0) Then
                    If (1.0 = local10\Field2) Then
                        local10\Field4 = min((local10\Field4 + local23\Field3[$00]), 4000.0)
                    EndIf
                    If (channelplaying(local10\Field8) = $00) Then
                        local10\Field8 = playsound_strict(radiostatic)
                    EndIf
                EndIf
                If (local10\Field1\Field22[$00] = Null) Then
                    tformpoint(1088.0, -5900.0, 1728.0, local10\Field1\Field2, $00)
                    local10\Field1\Field22[$00] = createnpc($12, tformedx(), tformedy(), tformedz())
                    turnentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $5A)), 0.0, $01)
                    local10\Field1\Field22[$00]\Field68 = $01
                EndIf
                If (playerroom = local10\Field1) Then
                    If (local10\Field1\Field22[$00] <> Null) Then
                        If ((-6900.0 * roomscale) > entityy(collider, $00)) Then
                            For local9 = Each rooms
                                hideentity(local9\Field2)
                            Next
                            showentity(local10\Field1\Field2)
                            shouldplay = $21
                            local10\Field1\Field22[$00]\Field9 = 6.0
                            If (0.0 = local10\Field1\Field22[$00]\Field24) Then
                                animatenpc(local10\Field1\Field22[$00], 17.0, 19.0, 0.01, $00)
                                If (19.0 = local10\Field1\Field22[$00]\Field14) Then
                                    local10\Field1\Field22[$00]\Field24 = 1.0
                                EndIf
                            Else
                                animatenpc(local10\Field1\Field22[$00], 19.0, 17.0, -0.01, $00)
                                If (17.0 = local10\Field1\Field22[$00]\Field14) Then
                                    local10\Field1\Field22[$00]\Field24 = 0.0
                                EndIf
                            EndIf
                            positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field19[$05], $01), (entityy(local10\Field1\Field19[$05], $01) + 0.1), entityz(local10\Field1\Field19[$05], $01), $01)
                            rotateentity(local10\Field1\Field22[$00]\Field4, entitypitch(local10\Field1\Field19[$05], $01), entityyaw(local10\Field1\Field19[$05], $01), 0.0, $01)
                            resetentity(local10\Field1\Field22[$00]\Field4)
                            local2 = (Int local10\Field3)
                            local86 = updatelever(local10\Field1\Field19[$01], (((-8318.0 * roomscale) > entityy(local10\Field1\Field19[$06], $01)) And ((-8603.0 * roomscale) < entityy(local10\Field1\Field19[$06], $01))))
                            If (((grabbedentity = local10\Field1\Field19[$01]) And (drawhandicon = $01)) <> 0) Then
                                local10\Field3 = (Float local86)
                            EndIf
                            If ((Float local2) <> local10\Field3) Then
                                If (0.0 = local10\Field3) Then
                                    playsound_strict(magnetdownsfx)
                                Else
                                    playsound_strict(magnetupsfx)
                                EndIf
                            EndIf
                            If ((((3200.0 < local10\Field4) Or (2500.0 > local10\Field4)) Or (1.0 <> local10\Field2)) <> 0) Then
                                soundtransmission = updatelever(local10\Field1\Field19[$03], $00)
                            EndIf
                            If (soundtransmission = $00) Then
                                If (local10\Field7 <> $00) Then
                                    If (channelplaying(local10\Field7) <> 0) Then
                                        stopchannel(local10\Field7)
                                    EndIf
                                EndIf
                                If (local10\Field8 <> $00) Then
                                    If (channelplaying(local10\Field8) <> 0) Then
                                        stopchannel(local10\Field8)
                                    EndIf
                                EndIf
                            EndIf
                            If (0.0 = local10\Field2) Then
                                If ((soundtransmission And (rand($64, $01) = $01)) <> 0) Then
                                    If (local10\Field7 = $00) Then
                                        loadeventsound(local10, scpmodding_processfilepath((("SFX\Character\LureSubject\Idle" + (Str rand($01, $06))) + ".ogg")), $01)
                                        local10\Field7 = playsound_strict(local10\Field10)
                                    EndIf
                                    If (channelplaying(local10\Field7) = $00) Then
                                        loadeventsound(local10, scpmodding_processfilepath((("SFX\Character\LureSubject\Idle" + (Str rand($01, $06))) + ".ogg")), $01)
                                        local10\Field7 = playsound_strict(local10\Field10)
                                    EndIf
                                EndIf
                                If (soundtransmission <> 0) Then
                                    updatebutton(local10\Field1\Field19[$04])
                                    If (((closestbutton = local10\Field1\Field19[$04]) And mousehit1) <> 0) Then
                                        local10\Field2 = 1.0
                                        If (soundtransmission = $01) Then
                                            If (local10\Field7 <> $00) Then
                                                If (channelplaying(local10\Field7) <> 0) Then
                                                    stopchannel(local10\Field7)
                                                EndIf
                                            EndIf
                                            femurbreakersfx = loadsound_strict(scpmodding_processfilepath("SFX\Room\106Chamber\FemurBreaker.ogg"))
                                            local10\Field7 = playsound_strict(femurbreakersfx)
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (1.0 = local10\Field2) Then
                                If ((soundtransmission And (2000.0 > local10\Field4)) <> 0) Then
                                    If (local10\Field7 = $00) Then
                                        loadeventsound(local10, scpmodding_processfilepath("SFX\Character\LureSubject\Sniffling.ogg"), $01)
                                        local10\Field7 = playsound_strict(local10\Field10)
                                    EndIf
                                    If (channelplaying(local10\Field7) = $00) Then
                                        loadeventsound(local10, scpmodding_processfilepath("SFX\Character\LureSubject\Sniffling.ogg"), $01)
                                        local10\Field7 = playsound_strict(local10\Field10)
                                    EndIf
                                EndIf
                                If (2500.0 <= local10\Field4) Then
                                    If (((1.0 = local10\Field3) And (2500.0 > (local10\Field4 - local23\Field3[$00]))) <> 0) Then
                                        positionentity(curr106\Field4, entityx(local10\Field1\Field19[$06], $01), entityy(local10\Field1\Field19[$06], $01), entityz(local10\Field1\Field19[$06], $01), $00)
                                        contained106 = $00
                                        showentity(curr106\Field0)
                                        curr106\Field24 = 0.0
                                        curr106\Field9 = -11.0
                                        local10\Field2 = 2.0
                                        Exit
                                    EndIf
                                    shouldplay = $0A
                                    positionentity(curr106\Field4, entityx(local10\Field1\Field19[$05], $01), ((((min((local10\Field4 - 2500.0), 800.0) / 320.0) * 108.0) + -6628.0) * roomscale), entityz(local10\Field1\Field19[$05], $01), $00)
                                    hideentity(curr106\Field1)
                                    rotateentity(curr106\Field4, 0.0, (entityyaw(local10\Field1\Field19[$05], $01) + 180.0), 0.0, $01)
                                    curr106\Field9 = -11.0
                                    animatenpc(curr106, 206.0, 250.0, 0.1, $01)
                                    curr106\Field24 = 1.0
                                    If (2500.0 > (local10\Field4 - local23\Field3[$00])) Then
                                        local72 = createdecal($00, entityx(local10\Field1\Field19[$05], $01), (-6392.0 * roomscale), entityz(local10\Field1\Field19[$05], $01), 90.0, 0.0, rnd(360.0, 0.0))
                                        local72\Field9 = 90000.0
                                        local72\Field5 = 0.01
                                        local72\Field4 = 0.005
                                        local72\Field2 = 0.1
                                        local72\Field1 = 0.003
                                        If (local10\Field7 <> $00) Then
                                            If (channelplaying(local10\Field7) <> 0) Then
                                                stopchannel(local10\Field7)
                                            EndIf
                                        EndIf
                                        loadeventsound(local10, scpmodding_processfilepath("SFX\Character\LureSubject\106Bait.ogg"), $01)
                                        local10\Field7 = playsound_strict(local10\Field10)
                                    ElseIf (((2900.0 > (local10\Field4 - local23\Field3[$00])) And (2900.0 <= local10\Field4)) <> 0) Then
                                        If (femurbreakersfx <> $00) Then
                                            freesound_strict(femurbreakersfx)
                                            femurbreakersfx = $00
                                        EndIf
                                        local72 = createdecal($00, entityx(local10\Field1\Field19[$07], $01), entityy(local10\Field1\Field19[$07], $01), entityz(local10\Field1\Field19[$07], $01), 0.0, 0.0, 0.0)
                                        rotateentity(local72\Field0, (entitypitch(local10\Field1\Field19[$07], $01) + (Float rand($0A, $14))), (entityyaw(local10\Field1\Field19[$07], $01) + 30.0), entityroll(local72\Field0, $00), $00)
                                        moveentity(local72\Field0, 0.0, 0.05, 0.2)
                                        rotateentity(local72\Field0, entitypitch(local10\Field1\Field19[$07], $01), entityyaw(local10\Field1\Field19[$07], $01), entityroll(local72\Field0, $00), $00)
                                        entityparent(local72\Field0, local10\Field1\Field19[$07], $01)
                                        local72\Field9 = 90000.0
                                        local72\Field5 = 0.01
                                        local72\Field4 = 0.005
                                        local72\Field2 = 0.05
                                        local72\Field1 = 0.002
                                    ElseIf (3200.0 < local10\Field4) Then
                                        If (1.0 = local10\Field3) Then
                                            contained106 = $01
                                        Else
                                            positionentity(curr106\Field4, entityx(local10\Field1\Field19[$06], $01), entityy(local10\Field1\Field19[$06], $01), entityz(local10\Field1\Field19[$06], $01), $00)
                                            contained106 = $00
                                            showentity(curr106\Field0)
                                            curr106\Field24 = 0.0
                                            curr106\Field9 = -11.0
                                            local10\Field2 = 2.0
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If ((Int local10\Field3) <> 0) Then
                                positionentity(local10\Field1\Field19[$06], entityx(local10\Field1\Field19[$06], $01), curvevalue(((-8308.0 * roomscale) + (sin(((Float millisecs2()) * 0.04)) * 0.07)), entityy(local10\Field1\Field19[$06], $01), 200.0), entityz(local10\Field1\Field19[$06], $01), $01)
                                rotateentity(local10\Field1\Field19[$06], sin(((Float millisecs2()) * 0.03)), entityyaw(local10\Field1\Field19[$06], $01), (- sin(((Float millisecs2()) * 0.025))), $01)
                            Else
                                positionentity(local10\Field1\Field19[$06], entityx(local10\Field1\Field19[$06], $01), curvevalue((-8608.0 * roomscale), entityy(local10\Field1\Field19[$06], $01), 200.0), entityz(local10\Field1\Field19[$06], $01), $01)
                                rotateentity(local10\Field1\Field19[$06], 0.0, entityyaw(local10\Field1\Field19[$06], $01), 0.0, $01)
                            EndIf
                        EndIf
                    EndIf
                    local10\Field5 = updateelevators(local10\Field5, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$0B], local10\Field1\Field19[$0C], local10, $01)
                ElseIf (((playerroom\Field7\Field10 = "pocketdimension") Or (playerroom\Field7\Field10 = "dimension1499")) <> 0) Then
                    If (local10\Field7 <> $00) Then
                        If (channelplaying(local10\Field7) <> 0) Then
                            stopchannel(local10\Field7)
                        EndIf
                    EndIf
                    If (local10\Field8 <> $00) Then
                        If (channelplaying(local10\Field8) <> 0) Then
                            stopchannel(local10\Field8)
                        EndIf
                    EndIf
                ElseIf (playerroom\Field7\Field10 = "room860") Then
                    For local11 = Each events
                        If (local11\Field0 = "room860") Then
                            If (1.0 = local11\Field2) Then
                                If (local10\Field7 <> $00) Then
                                    If (channelplaying(local10\Field7) <> 0) Then
                                        stopchannel(local10\Field7)
                                    EndIf
                                EndIf
                                If (local10\Field8 <> $00) Then
                                    If (channelplaying(local10\Field8) <> 0) Then
                                        stopchannel(local10\Field8)
                                    EndIf
                                EndIf
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
            Case "room205"
                If (playerroom = local10\Field1) Then
                    If (((0.0 = local10\Field2) Or (local10\Field15 <> "loaddone")) <> 0) Then
                        If (((local10\Field15 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field15 = "load0"
                        EndIf
                        If (local10\Field1\Field19[$03] <> $00) Then
                            hideentity(local10\Field1\Field19[$03])
                            hideentity(local10\Field1\Field19[$04])
                            hideentity(local10\Field1\Field19[$05])
                            hideentity(local10\Field1\Field19[$06])
                        EndIf
                        If (local10\Field1\Field21[$01]\Field5 = $01) Then
                            local10\Field2 = 1.0
                            giveachievement($09, $01)
                        EndIf
                    Else
                        shouldplay = $10
                        If (65.0 > local10\Field2) Then
                            If (2.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01))) Then
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\205\Enter.ogg")))
                                local10\Field2 = max(local10\Field2, 65.0)
                                showentity(local10\Field1\Field19[$03])
                                showentity(local10\Field1\Field19[$04])
                                showentity(local10\Field1\Field19[$05])
                                hideentity(local10\Field1\Field19[$06])
                                setanimtime(local10\Field1\Field19[$03], 492.0, $00)
                                setanimtime(local10\Field1\Field19[$04], 434.0, $00)
                                setanimtime(local10\Field1\Field19[$05], 434.0, $00)
                                local10\Field1\Field21[$00]\Field5 = $00
                            EndIf
                            If (7.0 < local10\Field2) Then
                                If (rand($00, $12C) = $01) Then
                                    local10\Field1\Field21[$00]\Field5 = (local10\Field1\Field21[$00]\Field5 = $00)
                                EndIf
                            EndIf
                            local10\Field3 = (local10\Field3 + local23\Field3[$00])
                        EndIf
                        Select local10\Field2
                            Case 1.0
                                showentity(local10\Field1\Field19[$01])
                                hideentity(local10\Field1\Field19[$05])
                                hideentity(local10\Field1\Field19[$04])
                                hideentity(local10\Field1\Field19[$03])
                                showentity(local10\Field1\Field19[$06])
                                animate2(local10\Field1\Field19[$06], animtime(local10\Field1\Field19[$06]), $20E, $212, 0.2, $01)
                                If (1400.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 3.0
                                showentity(local10\Field1\Field19[$01])
                                hideentity(local10\Field1\Field19[$05])
                                hideentity(local10\Field1\Field19[$04])
                                hideentity(local10\Field1\Field19[$03])
                                showentity(local10\Field1\Field19[$06])
                                animate2(local10\Field1\Field19[$06], animtime(local10\Field1\Field19[$06]), $179, $20D, 0.2, $01)
                                If (2100.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 5.0
                                showentity(local10\Field1\Field19[$01])
                                hideentity(local10\Field1\Field19[$05])
                                hideentity(local10\Field1\Field19[$04])
                                hideentity(local10\Field1\Field19[$03])
                                showentity(local10\Field1\Field19[$06])
                                animate2(local10\Field1\Field19[$06], animtime(local10\Field1\Field19[$06]), $E4, $178, 0.2, $01)
                                If (2800.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound2(loadtempsound(scpmodding_processfilepath("SFX\SCP\205\Horror.ogg")), camera, local10\Field1\Field19[$06], 10.0, 0.3)
                                EndIf
                            Case 7.0
                                showentity(local10\Field1\Field19[$01])
                                showentity(local10\Field1\Field19[$06])
                                hideentity(local10\Field1\Field19[$04])
                                hideentity(local10\Field1\Field19[$03])
                                showentity(local10\Field1\Field19[$05])
                                animate2(local10\Field1\Field19[$05], animtime(local10\Field1\Field19[$05]), $1F4, $288, 0.2, $01)
                                If (4200.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound2(loadtempsound(scpmodding_processfilepath("SFX\SCP\205\Horror.ogg")), camera, local10\Field1\Field19[$06], 10.0, 0.5)
                                EndIf
                            Case 9.0
                                showentity(local10\Field1\Field19[$01])
                                showentity(local10\Field1\Field19[$06])
                                showentity(local10\Field1\Field19[$05])
                                hideentity(local10\Field1\Field19[$03])
                                showentity(local10\Field1\Field19[$04])
                                animate2(local10\Field1\Field19[$04], animtime(local10\Field1\Field19[$04]), $02, $C8, 0.2, $01)
                                animate2(local10\Field1\Field19[$05], animtime(local10\Field1\Field19[$05]), $04, $7D, 0.2, $01)
                                If (5600.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\205\Horror.ogg")))
                                EndIf
                            Case 11.0
                                showentity(local10\Field1\Field19[$01])
                                showentity(local10\Field1\Field19[$06])
                                showentity(local10\Field1\Field19[$05])
                                showentity(local10\Field1\Field19[$04])
                                showentity(local10\Field1\Field19[$03])
                                animate2(local10\Field1\Field19[$03], animtime(local10\Field1\Field19[$03]), $02, $E2, 0.2, $01)
                                animate2(local10\Field1\Field19[$04], animtime(local10\Field1\Field19[$04]), $02, $C8, 0.2, $01)
                                animate2(local10\Field1\Field19[$05], animtime(local10\Field1\Field19[$05]), $04, $7D, 0.2, $01)
                                If (5950.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 13.0
                                showentity(local10\Field1\Field19[$01])
                                showentity(local10\Field1\Field19[$06])
                                showentity(local10\Field1\Field19[$05])
                                showentity(local10\Field1\Field19[$04])
                                showentity(local10\Field1\Field19[$03])
                                If (227.0 <> animtime(local10\Field1\Field19[$06])) Then
                                    setanimtime(local10\Field1\Field19[$06], 227.0, $00)
                                EndIf
                                animate2(local10\Field1\Field19[$03], animtime(local10\Field1\Field19[$03]), $02, $1EB, 0.05, $01)
                                animate2(local10\Field1\Field19[$04], animtime(local10\Field1\Field19[$04]), $C5, $1B1, 0.05, $01)
                                animate2(local10\Field1\Field19[$05], animtime(local10\Field1\Field19[$05]), $02, $1B1, 0.05, $01)
                            Case 66.0
                                showentity(local10\Field1\Field19[$01])
                                animate2(local10\Field1\Field19[$03], animtime(local10\Field1\Field19[$03]), $1EC, $216, 0.1, $00)
                                animate2(local10\Field1\Field19[$04], animtime(local10\Field1\Field19[$04]), $1B2, $1D2, 0.1, $00)
                                animate2(local10\Field1\Field19[$05], animtime(local10\Field1\Field19[$05]), $1B2, $1EE, 0.1, $00)
                                If (515.0 < animtime(local10\Field1\Field19[$03])) Then
                                    If (533.0 < animtime(local10\Field1\Field19[$03])) Then
                                        local10\Field2 = 67.0
                                        local10\Field3 = 0.0
                                        local10\Field4 = 0.0
                                        hideentity(local10\Field1\Field19[$01])
                                    EndIf
                                EndIf
                            Case 67.0
                                If (rand($96, $01) = $01) Then
                                    deathmsg = scplang_getphrase("events.room205")
                                    playsound_strict(damagesfx(rand($02, $03)))
                                    If (i_1033ru\Field0 = $00) Then
                                        injuries = (rnd(0.4, 0.8) + injuries)
                                    Else
                                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $14))
                                    EndIf
                                    camerashake = 0.5
                                    local10\Field3 = rnd(-0.1, 0.1)
                                    local10\Field4 = rnd(-0.1, 0.1)
                                    If (5.0 < injuries) Then
                                        kill($00, $00)
                                    EndIf
                                EndIf
                                translateentity(collider, local10\Field3, 0.0, local10\Field4, $00)
                                local10\Field3 = curvevalue(local10\Field3, 0.0, 10.0)
                                local10\Field4 = curvevalue(local10\Field4, 0.0, 10.0)
                            Default
                                If (rand($03, $01) = $01) Then
                                    hideentity(local10\Field1\Field19[$01])
                                Else
                                    showentity(local10\Field1\Field19[$01])
                                EndIf
                                local10\Field4 = (local10\Field4 + local23\Field3[$00])
                                If (50.0 < local10\Field4) Then
                                    showentity(local10\Field1\Field19[$01])
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    local10\Field4 = 0.0
                                EndIf
                        End Select
                    EndIf
                ElseIf (local10\Field1\Field19[$03] <> $00) Then
                    hideentity(local10\Field1\Field19[$03])
                    hideentity(local10\Field1\Field19[$04])
                    hideentity(local10\Field1\Field19[$05])
                    hideentity(local10\Field1\Field19[$06])
                Else
                    local10\Field2 = 0.0
                    local10\Field15 = ""
                EndIf
            Case "room860"
                local88 = local10\Field1\Field11
                If (((playerroom = local10\Field1) And (local88 <> Null)) <> 0) Then
                    If (1.0 = local10\Field2) Then
                        For local9 = Each rooms
                            hideentity(local9\Field2)
                        Next
                        showentity(local10\Field1\Field2)
                        currstepsfx = $02
                        curr106\Field24 = 1.0
                        updateforest(local88, collider)
                        If (((local10\Field15 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field15 = "load0"
                        EndIf
                        If (local10\Field1\Field22[$00] <> Null) Then
                            If ((((1.0 = local10\Field1\Field22[$00]\Field10) And (1.0 < local10\Field1\Field22[$00]\Field9)) Or (2.0 < local10\Field1\Field22[$00]\Field9)) <> 0) Then
                                shouldplay = $0C
                            Else
                                shouldplay = $09
                            EndIf
                        EndIf
                        If (chs\Field1 = $00) Then
                            If (28.5 >= entityy(collider, $00)) Then
                                kill($01, $00)
                                blinktimer = -2.0
                            ElseIf ((entityy(local88\Field5, $01) + 0.5) < entityy(collider, $00)) Then
                                moveentity(collider, 0.0, (((entityy(local88\Field5, $01) + 0.5) - entityy(collider, $00)) * local23\Field3[$00]), 0.0)
                            EndIf
                        EndIf
                        If (local10\Field1\Field22[$00] <> Null) Then
                            If (((0.0 = local10\Field1\Field22[$00]\Field9) Or (20.0 < entitydistance(collider, local10\Field1\Field22[$00]\Field4))) <> 0) Then
                                local10\Field4 = (((1.0 + currspeed) * local23\Field3[$00]) + local10\Field4)
                                If (((10.0 > (local10\Field4 Mod 500.0)) And (490.0 < ((local10\Field4 - local23\Field3[$00]) Mod 500.0))) <> 0) Then
                                    If ((((Float ($BB8 - (selecteddifficulty\Field3 * $1F4))) < local10\Field4) And (local10\Field4 > rnd((Float ((selecteddifficulty\Field3 * $1F4) + $2710)), 0.0))) <> 0) Then
                                        local10\Field1\Field22[$00]\Field9 = 2.0
                                        positionentity(local10\Field1\Field22[$00]\Field4, 0.0, -110.0, 0.0, $00)
                                        local10\Field4 = (local10\Field4 - rnd(1000.0, (Float ($7D0 - (selecteddifficulty\Field3 * $1F4)))))
                                    Else
                                        local10\Field1\Field22[$00]\Field9 = 1.0
                                        positionentity(local10\Field1\Field22[$00]\Field4, 0.0, -110.0, 0.0, $00)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        For local1 = $00 To $01 Step $01
                            If (0.5 > entitydistance(local88\Field6[local1], collider)) Then
                                If (entityinview(local88\Field6[local1], camera) <> 0) Then
                                    drawhandicon = $01
                                    If (mousehit1 <> 0) Then
                                        If ((Float local1) = local10\Field3) Then
                                            blinktimer = -10.0
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\WoodenDoorOpen.ogg")))
                                            rotateentity(local10\Field1\Field19[$03], 0.0, 0.0, 0.0, $00)
                                            rotateentity(local10\Field1\Field19[$04], 0.0, 180.0, 0.0, $00)
                                            positionentity(collider, entityx(local10\Field1\Field19[$02], $01), 0.5, entityz(local10\Field1\Field19[$02], $01), $00)
                                            rotateentity(collider, 0.0, (entityyaw(local10\Field1\Field2, $01) + (local10\Field3 * 180.0)), 0.0, $00)
                                            moveentity(collider, 0.0, 0.0, 1.5)
                                            resetentity(collider)
                                            updatedoorstimer = 0.0
                                            updatedoors()
                                            secondarylighton = prevsecondarylighton
                                            local10\Field2 = 0.0
                                            local10\Field4 = 0.0
                                        Else
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\WoodenDoorBudge.ogg")))
                                            msg = scplang_getphrase("events.room860")
                                            msgtimer = 350.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If (local10\Field1\Field22[$00] <> Null) Then
                            local18 = max((1.0 - (local10\Field1\Field22[$00]\Field11 / 300.0)), 0.1)
                        Else
                            local18 = 2.0
                        EndIf
                        If (debughud = $00) Then
                            cameraclscolor(camera, (98.0 * local18), (133.0 * local18), (162.0 * local18))
                            camerarange(camera, roomscale, 8.5)
                            camerafogrange(camera, 0.5, 8.0)
                            camerafogcolor(camera, (98.0 * local18), (133.0 * local18), (162.0 * local18))
                        EndIf
                    Else
                        If (contained106 = $00) Then
                            curr106\Field24 = 0.0
                        EndIf
                        If (0.0 = entityyaw(local10\Field1\Field19[$03], $00)) Then
                            hideentity(local88\Field5)
                            If (1.0 > (Abs distance(entityx(local10\Field1\Field19[$03], $01), entityz(local10\Field1\Field19[$03], $01), entityx(collider, $01), entityz(collider, $01)))) Then
                                drawhandicon = $01
                                If (selecteditem = Null) Then
                                    If (mousehit1 <> 0) Then
                                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\WoodenDoorBudge.ogg")))
                                        msg = scplang_getphrase("events.room860")
                                        msgtimer = 350.0
                                    EndIf
                                ElseIf (selecteditem\Field3\Field1 = "scp860") Then
                                    drawhandicon = $01
                                    If (mousehit1 <> 0) Then
                                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\WoodenDoorOpen.ogg")))
                                        showentity(local88\Field5)
                                        selecteditem = Null
                                        blinktimer = -10.0
                                        local10\Field2 = 1.0
                                        local10\Field4 = 0.0
                                        If (local10\Field1\Field22[$00] <> Null) Then
                                            local10\Field1\Field22[$00]\Field9 = 0.0
                                        EndIf
                                        prevsecondarylighton = secondarylighton
                                        secondarylighton = 1.0
                                        local3 = createpivot($00)
                                        positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                        pointentity(local3, local10\Field1\Field2, 0.0)
                                        local89 = wrapangle((entityyaw(local3, $00) - entityyaw(local10\Field1\Field2, $01)))
                                        If (((90.0 < local89) And (270.0 > local89)) <> 0) Then
                                            positionentity(collider, entityx(local88\Field6[$00], $01), ((entityy(local88\Field6[$00], $01) + entityy(collider, $01)) + 0.5), entityz(local88\Field6[$00], $01), $01)
                                            rotateentity(collider, 0.0, (entityyaw(local88\Field6[$00], $01) - 180.0), 0.0, $01)
                                            moveentity(collider, -0.5, 0.0, 0.5)
                                            local10\Field3 = 1.0
                                        Else
                                            positionentity(collider, entityx(local88\Field6[$01], $01), ((entityy(local88\Field6[$01], $01) + entityy(collider, $01)) + 0.5), entityz(local88\Field6[$01], $01), $01)
                                            rotateentity(collider, 0.0, (entityyaw(local88\Field6[$01], $01) - 180.0), 0.0, $01)
                                            moveentity(collider, -0.5, 0.0, 0.5)
                                            local10\Field3 = 0.0
                                        EndIf
                                        freeentity(local3)
                                        resetentity(collider)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                ElseIf (local88 = Null) Then
                    removeevent(local10)
                ElseIf (local88\Field5 <> $00) Then
                    hideentity(local88\Field5)
                EndIf
            Case "room966"
                If (playerroom = local10\Field1) Then
                    Select local10\Field2
                        Case 0.0
                            If (quickloadpercent = $FFFFFFFF) Then
                                lightblink = 5.0
                                local10\Field2 = 1.0
                                playsound_strict(lightsfx)
                                quickloadpercent = $00
                                quickload_currevent = local10
                            EndIf
                        Case 2.0
                            local10\Field2 = 2.0
                            removeevent(local10)
                    End Select
                EndIf
            Case "room1123"
                If (playerroom = local10\Field1) Then
                    If (((0.9 > entitydistance(collider, local10\Field1\Field19[$03])) Or ((0.0 < local10\Field2) And (7.0 > local10\Field2))) <> 0) Then
                        If (((((i_714\Field0 = $01) = $00) Or ((wearinghazmat = $03) = $00)) Or ((wearinggasmask = $03) = $00)) <> 0) Then
                            If (0.0 = local10\Field2) Then
                                blurtimer = 1000.0
                            EndIf
                            camerashake = 1.0
                            local10\Field8 = loopsound2(ambient1123sfx, local10\Field8, camera, collider, 4.0, 4.0)
                        EndIf
                    EndIf
                    If (((0.0 < local10\Field2) And (7.0 > local10\Field2)) <> 0) Then
                        cansave = $00
                    EndIf
                    If (1.0 = local10\Field2) Then
                        previnjuries = injuries
                        prevbloodloss = bloodloss
                        prevsecondarylighton = secondarylighton
                        secondarylighton = 1.0
                        local10\Field1\Field22[$00] = createnpc($12, entityx(local10\Field1\Field19[$06], $01), entityy(local10\Field1\Field19[$06], $01), entityz(local10\Field1\Field19[$06], $01))
                        local91 = copyentity(local22\Field0[$1B], $00)
                        local92 = (0.5 / meshwidth(local91))
                        freeentity(local10\Field1\Field22[$00]\Field0)
                        local10\Field1\Field22[$00]\Field0 = copyentity(local91, $00)
                        scaleentity(local10\Field1\Field22[$00]\Field0, local92, local92, local92, $00)
                        freeentity(local91)
                        positionentity(collider, entityx(local10\Field1\Field19[$04], $01), entityy(local10\Field1\Field19[$04], $01), entityz(local10\Field1\Field19[$04], $01), $01)
                        resetentity(collider)
                        camerashake = 1.0
                        blurtimer = 1200.0
                        injuries = 1.0
                        local10\Field2 = 2.0
                    ElseIf (2.0 = local10\Field2) Then
                        local10\Field3 = (local10\Field3 + local23\Field3[$00])
                        pointentity(local10\Field1\Field22[$00]\Field4, collider, 0.0)
                        blurtimer = max(blurtimer, 100.0)
                        If (((200.0 < local10\Field3) And (200.0 >= (local10\Field3 - local23\Field3[$00]))) <> 0) Then
                            local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Music\Room1123.ogg"))
                            local10\Field6 = playsound_strict(local10\Field9)
                        EndIf
                        If (1000.0 < local10\Field3) Then
                            If (local10\Field10 = $00) Then
                                local10\Field10 = loadsound_strict(scpmodding_processfilepath("SFX\Door\1123DoorOpen.ogg"))
                                local10\Field7 = playsound_strict(local10\Field10)
                            EndIf
                            rotateentity(local10\Field1\Field19[$0B], 0.0, curveangle(10.0, entityyaw(local10\Field1\Field19[$0B], $00), 40.0), 0.0, $00)
                            If (((1040.0 <= local10\Field3) And (1040.0 > (local10\Field3 - local23\Field3[$00]))) <> 0) Then
                                playsound2(loadtempsound(scpmodding_processfilepath("SFX\SCP\1123\Officer1.ogg")), camera, local10\Field1\Field22[$00]\Field0, 10.0, 1.0)
                            ElseIf (((1400.0 <= local10\Field3) And (1400.0 > (local10\Field3 - local23\Field3[$00]))) <> 0) Then
                                playsound2(loadtempsound(scpmodding_processfilepath("SFX\SCP\1123\Officer2.ogg")), camera, local10\Field1\Field22[$00]\Field0, 10.0, 1.0)
                            EndIf
                            local10\Field1\Field22[$00]\Field9 = 3.0
                            animatenpc(local10\Field1\Field22[$00], 3.0, 26.0, 0.2, $01)
                            If ((392.0 * roomscale) < entitydistance(collider, local10\Field1\Field19[$04])) Then
                                blinktimer = -10.0
                                blurtimer = 500.0
                                positionentity(collider, entityx(local10\Field1\Field19[$05], $01), entityy(local10\Field1\Field19[$05], $01), entityz(local10\Field1\Field19[$05], $01), $01)
                                rotateentity(collider, 0.0, (entityyaw(local10\Field1\Field2, $01) + 180.0), 0.0, $00)
                                resetentity(collider)
                                local10\Field2 = 3.0
                            EndIf
                        EndIf
                    ElseIf (3.0 = local10\Field2) Then
                        If (160.0 < local10\Field1\Field21[$00]\Field7) Then
                            If (local10\Field9 = $00) Then
                                local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Music\Room1123.ogg"))
                            EndIf
                            local10\Field6 = playsound_strict(local10\Field9)
                            positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field19[$07], $01), entityy(local10\Field1\Field19[$07], $01), entityz(local10\Field1\Field19[$07], $01), $00)
                            resetentity(local10\Field1\Field22[$00]\Field4)
                            local10\Field2 = 4.0
                        EndIf
                    ElseIf (4.0 = local10\Field2) Then
                        tformpoint(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00, local10\Field1\Field2)
                        If (((256.0 > tformedx()) And (-480.0 < tformedz())) <> 0) Then
                            local10\Field1\Field21[$00]\Field5 = $00
                        EndIf
                        If (0.0 = entityyaw(local10\Field1\Field19[$0D], $00)) Then
                            If (1.0 > entitydistance(collider, local10\Field1\Field19[$0C])) Then
                                drawhandicon = $01
                                If (mousehit1 <> 0) Then
                                    rotateentity(local10\Field1\Field19[$0D], 0.0, 1.0, 0.0, $00)
                                    rotateentity(local10\Field1\Field19[$0B], 0.0, 90.0, 0.0, $00)
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\1123\Horror.ogg")))
                                EndIf
                            EndIf
                        Else
                            rotateentity(local10\Field1\Field19[$0D], 0.0, curveangle(90.0, entityyaw(local10\Field1\Field19[$0D], $00), 40.0), 0.0, $00)
                            If (30.0 < entityyaw(local10\Field1\Field19[$0D], $00)) Then
                                local10\Field1\Field22[$00]\Field9 = 3.0
                                pointentity(local10\Field1\Field22[$00]\Field4, collider, 0.0)
                                animatenpc(local10\Field1\Field22[$00], 27.0, 54.0, 0.5, $00)
                                If (54.0 <= local10\Field1\Field22[$00]\Field14) Then
                                    local10\Field2 = 5.0
                                    local10\Field3 = 0.0
                                    positionentity(collider, entityx(local10\Field1\Field2, $01), 0.3, entityz(local10\Field1\Field2, $01), $01)
                                    resetentity(collider)
                                    blinktimer = -10.0
                                    blurtimer = 500.0
                                    injuries = 1.5
                                    bloodloss = 70.0
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (5.0 = local10\Field2) Then
                        local10\Field3 = (local10\Field3 + local23\Field3[$00])
                        If (500.0 < local10\Field3) Then
                            rotateentity(local10\Field1\Field19[$09], 0.0, 90.0, 0.0, $00)
                            rotateentity(local10\Field1\Field19[$0D], 0.0, 0.0, 0.0, $00)
                            local18 = ((entityx(local10\Field1\Field19[$08], $01) + entityx(local10\Field1\Field19[$0C], $01)) / 2.0)
                            local19 = entityy(local10\Field1\Field19[$05], $01)
                            local20 = ((entityz(local10\Field1\Field19[$08], $01) + entityz(local10\Field1\Field19[$0C], $01)) / 2.0)
                            positionentity(collider, local18, local19, local20, $01)
                            resetentity(collider)
                            local18 = ((entityx(collider, $01) + entityx(local10\Field1\Field19[$0C], $01)) / 2.0)
                            local20 = ((entityz(collider, $01) + entityz(local10\Field1\Field19[$0C], $01)) / 2.0)
                            positionentity(local10\Field1\Field22[$00]\Field4, local18, (local19 + 0.2), local20, $00)
                            resetentity(local10\Field1\Field22[$00]\Field4)
                            injuries = 1.5
                            bloodloss = 70.0
                            blinktimer = -10.0
                            local30 = createdecal($03, entityx(collider, $00), ((512.0 * roomscale) + 0.0005), entityz(collider, $00), 90.0, rnd(360.0, 0.0), 0.0)
                            local30\Field2 = 0.5
                            scalesprite(local30\Field0, local30\Field2, local30\Field2)
                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1123\Officer3.ogg"))
                            local10\Field2 = 6.0
                        EndIf
                    ElseIf (6.0 = local10\Field2) Then
                        pointentity(local10\Field1\Field22[$00]\Field4, collider, 0.0)
                        animatenpc(local10\Field1\Field22[$00], 75.0, 128.0, 0.04, $01)
                        If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                            If (local10\Field1\Field22[$00]\Field17 <> $00) Then
                                If (channelplaying(local10\Field1\Field22[$00]\Field17) = $00) Then
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\1123\Gunshot.ogg")))
                                    local10\Field2 = 7.0
                                    freesound_strict(local10\Field1\Field22[$00]\Field16)
                                    local10\Field1\Field22[$00]\Field16 = $00
                                EndIf
                            EndIf
                            If (local10\Field1\Field22[$00]\Field16 <> $00) Then
                                local10\Field1\Field22[$00]\Field17 = loopsound2(local10\Field1\Field22[$00]\Field16, local10\Field1\Field22[$00]\Field17, camera, local10\Field1\Field22[$00]\Field4, 7.0, 1.0)
                            EndIf
                        EndIf
                    ElseIf (7.0 = local10\Field2) Then
                        positionentity(collider, entityx(local10\Field1\Field2, $01), 0.3, entityz(local10\Field1\Field2, $01), $01)
                        resetentity(collider)
                        showentity(at\Field4[$0E])
                        lightflash = 6.0
                        blurtimer = 500.0
                        injuries = previnjuries
                        bloodloss = prevbloodloss
                        secondarylighton = prevsecondarylighton
                        rotateentity(local10\Field1\Field19[$09], 0.0, 0.0, 0.0, $00)
                        previnjuries = 0.0
                        prevbloodloss = 0.0
                        prevsecondarylighton = 0.0
                        crouch = $00
                        cansave = $01
                        For local1 = $00 To (maxitemamount - $01) Step $01
                            If (inventory(local1) <> Null) Then
                                If (inventory(local1)\Field3\Field0 = "Leaflet") Then
                                    removeitem(inventory(local1))
                                    Exit
                                EndIf
                            EndIf
                        Next
                        giveachievement($1A, $01)
                        removenpc(local10\Field1\Field22[$00])
                        removeevent(local10)
                    EndIf
                EndIf
            Case "room2testroom"
                If (0.0 = local10\Field2) Then
                    If (playerroom = local10\Field1) Then
                        local10\Field1\Field19[$07] = copyentity(local22\Field0[$1C], $00)
                        scaleentity(local10\Field1\Field19[$07], 0.05, 0.05, 0.05, $00)
                        tformpoint(entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00, local10\Field1\Field2)
                        If (0.0 = tformedz()) Then
                            local2 = $FFFFFFFF
                        Else
                            local2 = (Int (- (Sgn tformedz())))
                        EndIf
                        tformpoint(-720.0, 0.0, (Float ($330 * local2)), local10\Field1\Field2, $00)
                        positionentity(local10\Field1\Field19[$07], tformedx(), 0.0, tformedz(), $00)
                        rotateentity(local10\Field1\Field19[$07], -90.0, (Float (local10\Field1\Field6 - $5A)), 0.0, $00)
                        setanimtime(local10\Field1\Field19[$07], 297.0, $00)
                        local10\Field2 = 1.0
                    EndIf
                ElseIf (1.0 = local10\Field2) Then
                    If (local10\Field1\Field19[$07] <> $00) Then
                        animate2(local10\Field1\Field19[$07], animtime(local10\Field1\Field19[$07]), $11C, $127, 0.3, $01)
                        moveentity(local10\Field1\Field19[$07], 0.0, (local23\Field3[$00] * -0.008), 0.0)
                        tformpoint(entityx(local10\Field1\Field19[$07], $00), entityy(local10\Field1\Field19[$07], $00), entityz(local10\Field1\Field19[$07], $00), $00, local10\Field1\Field2)
                        If (((725.0 < (Abs tformedx())) Or (local10\Field1\Field21[$00]\Field5 = $01)) <> 0) Then
                            freeentity(local10\Field1\Field19[$07])
                            local10\Field1\Field19[$07] = $00
                            local10\Field2 = 2.0
                        EndIf
                    EndIf
                EndIf
                If (playerroom = local10\Field1) Then
                    If (2.0 = local10\Field2) Then
                        If (((2.5 > entitydistance(collider, local10\Field1\Field19[$06])) And (0.0 < local10\Field2)) <> 0) Then
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\079\TestroomWarning.ogg")))
                            For local1 = $00 To $05 Step $01
                                local14 = createemitter(entityx(local10\Field1\Field19[local1], $01), entityy(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01), $00)
                                turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                                local14\Field10 = 5.0
                                local14\Field9 = 0.042
                                local14\Field11 = (1.0 / 400.0)
                            Next
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "tunnel2smoke"
                If (playerroom = local10\Field1) Then
                    If (3.5 > local10\Field1\Field8) Then
                        playsound2(burstsfx, camera, local10\Field1\Field2, 10.0, 1.0)
                        For local1 = $00 To $01 Step $01
                            local14 = createemitter(entityx(local10\Field1\Field19[local1], $01), entityy(local10\Field1\Field19[local1], $01), entityz(local10\Field1\Field19[local1], $01), $00)
                            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                            entityparent(local14\Field0, local10\Field1\Field2, $01)
                            local14\Field1 = 0.05
                            local14\Field10 = 10.0
                            local14\Field9 = 0.06
                            local14\Field11 = 0.007
                            For local20 = 0.0 To ceil((3.3333 * (Float (particleamount + $01)))) Step 1.0
                                local7 = createparticle(entityx(local14\Field0, $01), (448.0 * roomscale), entityz(local14\Field0, $01), rand(local14\Field2, local14\Field3), local14\Field1, local14\Field4, local14\Field5)
                                local7\Field8 = local14\Field9
                                rotateentity(local7\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                local7\Field7 = 0.05
                                local7\Field15 = 0.008
                            Next
                        Next
                        removeevent(local10)
                    EndIf
                EndIf
            Case "tunnel2"
                If (playerroom = local10\Field1) Then
                    If (1.0 < curr173\Field24) Then
                        removeevent(local10)
                        Exit
                    ElseIf (0.0 = local10\Field2) Then
                        If (3.5 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))) Then
                            playsound_strict(lightsfx)
                            lightblink = (rnd(0.0, 1.0) * (local10\Field2 / 200.0))
                            local10\Field2 = 1.0
                        EndIf
                    EndIf
                EndIf
                If (((0.0 < local10\Field2) And (200.0 > local10\Field2)) <> 0) Then
                    blinktimer = -10.0
                    If (30.0 < local10\Field2) Then
                        lightblink = 1.0
                        If (30.0 >= (local10\Field2 - local23\Field3[$00])) Then
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ambient\General\Ambient3.ogg")))
                        EndIf
                    EndIf
                    If (((100.0 >= (local10\Field2 - local23\Field3[$00])) And (100.0 < local10\Field2)) <> 0) Then
                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Ambient\General\Ambient6.ogg")))
                        positionentity(curr173\Field4, entityx(local10\Field1\Field2, $00), 0.6, entityz(local10\Field1\Field2, $00), $00)
                        resetentity(curr173\Field4)
                        curr173\Field24 = 1.0
                    EndIf
                    lightblink = 1.0
                    local10\Field2 = (local10\Field2 + local23\Field3[$00])
                ElseIf (0.0 <> local10\Field2) Then
                    blinktimer = blinkfreq
                    curr173\Field24 = 0.0
                    removeevent(local10)
                EndIf
            Case "tunnel106"
                If (0.0 = local10\Field2) Then
                    If (((5.0 > local10\Field1\Field8) And (0.0 < local10\Field1\Field8)) <> 0) Then
                        If (0.0 <= curr106\Field9) Then
                            local10\Field2 = 1.0
                        ElseIf ((((-10.0 >= curr106\Field9) And (5.0 < entitydistance(curr106\Field4, collider))) And (entityinview(curr106\Field0, camera) = $00)) <> 0) Then
                            local10\Field2 = 1.0
                            local10\Field3 = 1.0
                        EndIf
                    ElseIf (contained106 <> 0) Then
                        removeevent(local10)
                    EndIf
                ElseIf (1.0 = local10\Field2) Then
                    If (((3.0 > local10\Field1\Field8) Or (rand($1B58, $01) = $01)) <> 0) Then
                        local10\Field2 = 2.0
                        local72 = createdecal($00, entityx(local10\Field1\Field2, $00), (445.0 * roomscale), entityz(local10\Field1\Field2, $00), -90.0, (Float rand($168, $01)), 0.0)
                        local72\Field2 = rnd(0.5, 0.7)
                        entityalpha(local72\Field0, 0.7)
                        local72\Field8 = $01
                        scalesprite(local72\Field0, local72\Field2, local72\Field2)
                        entityalpha(local72\Field0, rnd(0.7, 0.85))
                        playsound_strict(horrorsfx($0A))
                    ElseIf (8.0 < local10\Field1\Field8) Then
                        If (rand($05, $01) = $01) Then
                            curr106\Field24 = 0.0
                            removeevent(local10)
                        Else
                            curr106\Field24 = 0.0
                            curr106\Field9 = -10000.0
                            removeevent(local10)
                        EndIf
                    EndIf
                Else
                    If (1.0 = local10\Field3) Then
                        shouldplay = $0A
                    EndIf
                    local10\Field2 = (local10\Field2 + local23\Field3[$00])
                    If (180.0 >= local10\Field2) Then
                        positionentity(curr106\Field4, entityx(local10\Field1\Field2, $01), ((entityy(collider, $00) + 1.0) - min((sin(local10\Field2) * 1.5), 1.1)), entityz(local10\Field1\Field2, $01), $01)
                        pointentity(curr106\Field4, camera, 0.0)
                        animatenpc(curr106, 55.0, 104.0, 0.1, $01)
                        curr106\Field24 = 1.0
                        curr106\Field9 = 1.0
                        resetentity(curr106\Field4)
                        curr106\Field7 = 0.0
                        positionentity(curr106\Field0, entityx(curr106\Field4, $00), (entityy(curr106\Field4, $00) - 0.15), entityz(curr106\Field4, $00), $00)
                        rotateentity(curr106\Field0, 0.0, entityyaw(curr106\Field4, $00), 0.0, $00)
                        showentity(curr106\Field0)
                    ElseIf (((180.0 < local10\Field2) And (300.0 > local10\Field2)) <> 0) Then
                        curr106\Field24 = 0.0
                        curr106\Field9 = -10.0
                        positionentity(curr106\Field4, entityx(local10\Field1\Field2, $01), -3.0, entityz(local10\Field1\Field2, $01), $01)
                        curr106\Field38 = 700.0
                        curr106\Field37 = $00
                        curr106\Field39 = $00
                        local30 = createdecal($00, entityx(local10\Field1\Field2, $01), 0.01, entityz(local10\Field1\Field2, $01), 90.0, (Float rand($168, $01)), 0.0)
                        local30\Field2 = 0.05
                        local30\Field1 = 0.01
                        entityalpha(local30\Field0, 0.8)
                        updatedecals()
                        local10\Field2 = 300.0
                    ElseIf (800.0 > local10\Field2) Then
                        If ((entityy(collider, $00) - 0.05) <= entityy(curr106\Field4, $00)) Then
                            removeevent(local10)
                        Else
                            translateentity(curr106\Field4, 0.0, (((entityy(collider, $01) - 0.11) - entityy(curr106\Field4, $00)) / 50.0), 0.0, $00)
                            If (-0.1 > entityy(curr106\Field4, $00)) Then
                                curr106\Field22 = 0.0
                            EndIf
                        EndIf
                    Else
                        removeevent(local10)
                    EndIf
                EndIf
            Case "room2testroom2_173"
                If (playerroom = local10\Field1) Then
                    If (0.0 = curr173\Field24) Then
                        If (0.0 = local10\Field2) Then
                            If (local10\Field1\Field21[$00]\Field5 = $01) Then
                                positionentity(curr173\Field4, entityx(local10\Field1\Field19[$00], $01), 0.5, entityz(local10\Field1\Field19[$00], $01), $00)
                                resetentity(curr173\Field4)
                                local10\Field2 = 1.0
                            EndIf
                        Else
                            If (local10\Field1\Field19[$02] = $00) Then
                                local93 = loadtexture_strict(scpmodding_processfilepath("GFX\map\glass.png"), $03)
                                local10\Field1\Field19[$02] = createsprite($00)
                                entitytexture(local10\Field1\Field19[$02], local93, $00, $00)
                                spriteviewmode(local10\Field1\Field19[$02], $02)
                                scalesprite(local10\Field1\Field19[$02], ((182.0 * roomscale) * 0.5), ((192.0 * roomscale) * 0.5))
                                local3 = createpivot(local10\Field1\Field2)
                                positionentity(local3, -632.0, 224.0, -208.0, $00)
                                positionentity(local10\Field1\Field19[$02], entityx(local3, $01), entityy(local3, $01), entityz(local3, $01), $00)
                                freeentity(local3)
                                rotateentity(local10\Field1\Field19[$02], 0.0, (Float local10\Field1\Field6), 0.0, $00)
                                turnentity(local10\Field1\Field19[$02], 0.0, 180.0, 0.0, $00)
                                entityparent(local10\Field1\Field19[$02], local10\Field1\Field2, $01)
                                freetexture(local93)
                            EndIf
                            showentity(local10\Field1\Field19[$02])
                            local10\Field2 = (local10\Field2 + 1.0)
                            local0 = entitydistance(collider, local10\Field1\Field19[$01])
                            If (1.0 > local0) Then
                                local10\Field2 = max(local10\Field2, 840.0)
                            ElseIf (1.4 < local0) Then
                                If (((840.0 < local10\Field2) And (-10.0 >= blinktimer)) <> 0) Then
                                    If (5.0 < entitydistance(curr173\Field4, local10\Field1\Field19[$00])) Then
                                        removeevent(local10)
                                    Else
                                        playsound2(loadtempsound(scpmodding_processfilepath("SFX\General\GlassBreak.ogg")), camera, curr173\Field0, 10.0, 1.0)
                                        freeentity(local10\Field1\Field19[$02])
                                        local10\Field1\Field19[$02] = $00
                                        positionentity(curr173\Field4, entityx(local10\Field1\Field19[$01], $01), 0.5, entityz(local10\Field1\Field19[$01], $01), $00)
                                        resetentity(curr173\Field4)
                                        removeevent(local10)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "toiletguard"
                If (0.0 = local10\Field2) Then
                    If (((8.0 > local10\Field1\Field8) And (0.0 < local10\Field1\Field8)) <> 0) Then
                        local10\Field2 = 1.0
                    EndIf
                ElseIf (1.0 = local10\Field2) Then
                    local10\Field1\Field22[$00] = createnpc($13, entityx(local10\Field1\Field19[$01], $01), (entityy(local10\Field1\Field19[$01], $01) + 0.5), entityz(local10\Field1\Field19[$01], $01))
                    pointentity(local10\Field1\Field22[$00]\Field4, local10\Field1\Field2, 0.0)
                    rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (entityyaw(local10\Field1\Field22[$00]\Field4, $00) - 20.0), 0.0, $01)
                    setnpcframe(local10\Field1\Field22[$00], 287.0)
                    local10\Field1\Field22[$00]\Field9 = 8.0
                    local10\Field2 = 2.0
                Else
                    If (local10\Field9 = $00) Then
                        local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Character\Guard\SuicideGuard1.ogg"))
                    EndIf
                    If (((15.0 > local10\Field1\Field8) And (4.0 <= local10\Field1\Field8)) <> 0) Then
                        local10\Field6 = loopsound2(local10\Field9, local10\Field6, camera, local10\Field1\Field22[$00]\Field4, 15.0, 1.0)
                    ElseIf (((4.0 > local10\Field1\Field8) And (1.0 < playersoundvolume)) <> 0) Then
                        If (0.0 = local10\Field3) Then
                            local30 = createdecal($03, entityx(local10\Field1\Field19[$02], $01), entityy(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01), 0.0, (Float (local10\Field1\Field6 + $10E)), 0.0)
                            local30\Field2 = 0.3
                            scalesprite(local30\Field0, local30\Field2, local30\Field2)
                            local10\Field3 = 1.0
                        EndIf
                        If (local10\Field7 = $00) Then
                            stopchannel(local10\Field6)
                            freesound_strict(local10\Field9)
                            local10\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\Guard\SuicideGuard2.ogg"))
                            local10\Field7 = playsound2(local10\Field1\Field22[$00]\Field16, camera, local10\Field1\Field22[$00]\Field4, 15.0, 1.0)
                        EndIf
                        updatesoundorigin(local10\Field7, camera, local10\Field1\Field22[$00]\Field4, 15.0, 1.0)
                        If (channelplaying(local10\Field7) = $00) Then
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room008"
                If (playerroom = local10\Field1) Then
                    If ((-4496.0 * roomscale) > entityy(collider, $00)) Then
                        For local9 = Each rooms
                            hideentity(local9\Field2)
                        Next
                        showentity(local10\Field1\Field2)
                        giveachievement($00, $01)
                        If (0.0 = local10\Field2) Then
                            If (((2.0 > curr173\Field24) And (hidedistance < entitydistance(curr173\Field4, collider))) <> 0) Then
                                positionentity(curr173\Field4, entityx(local10\Field1\Field19[$03], $01), entityy(local10\Field1\Field19[$03], $01), entityz(local10\Field1\Field19[$03], $01), $01)
                                resetentity(curr173\Field4)
                            EndIf
                            local10\Field2 = 1.0
                        ElseIf (1.0 = local10\Field2) Then
                            If (3.1 > entitydistance(local10\Field1\Field19[$01], collider)) Then
                                local10\Field6 = loopsound2(alarmsfx($00), local10\Field6, camera, local10\Field1\Field19[$00], 5.0, 1.0)
                            EndIf
                            If ((millisecs2() Mod $3E8) < $1F4) Then
                                showentity(local10\Field1\Field19[$05])
                            Else
                                hideentity(local10\Field1\Field19[$05])
                            EndIf
                            local0 = entitydistance(collider, local10\Field1\Field19[$00])
                            If (2.0 > local0) Then
                                local10\Field1\Field21[$00]\Field4 = $01
                                local10\Field1\Field21[$01]\Field4 = $01
                                If (0.0 = local10\Field3) Then
                                    showentity(local10\Field1\Field19[$02])
                                    If (3.0 > entitydistance(curr173\Field4, local10\Field1\Field19[$04])) Then
                                        If ((((-10.0 > blinktimer) Or (entityinview(curr173\Field0, camera) = $00)) And (0.0 = curr173\Field24)) <> 0) Then
                                            positionentity(curr173\Field4, entityx(local10\Field1\Field19[$04], $01), entityy(local10\Field1\Field19[$04], $01), entityz(local10\Field1\Field19[$04], $01), $01)
                                            resetentity(curr173\Field4)
                                            hideentity(local10\Field1\Field19[$02])
                                            If (wearinghazmat = $00) Then
                                                If (i_1033ru\Field0 = $00) Then
                                                    injuries = (injuries + 0.1)
                                                    msg = scplang_getphrase("events.room0081")
                                                Else
                                                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                                                    msg = scplang_getphrase("events.room0082")
                                                EndIf
                                                If (0.0 = i_008\Field0) Then
                                                    i_008\Field0 = 1.0
                                                EndIf
                                                msgtimer = 560.0
                                            EndIf
                                            playsound2(loadtempsound(scpmodding_processfilepath("SFX\General\GlassBreak.ogg")), camera, local10\Field1\Field19[$00], 10.0, 1.0)
                                            local10\Field3 = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                                If (1.0 > local0) Then
                                    If (entityinview(local10\Field1\Field19[$00], camera) <> 0) Then
                                        drawhandicon = $01
                                        If (mousedown1 <> 0) Then
                                            drawarrowicon($02) = $01
                                            rotateentity(local10\Field1\Field20[$00], max(min((entitypitch(local10\Field1\Field20[$00], $00) + max(min((- mouse_y_speed_1), 10.0), -10.0)), 89.0), 35.0), entityyaw(local10\Field1\Field20[$00], $00), 0.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                                If (((wearinghazmat = $00) And (0.0 < bloodloss)) <> 0) Then
                                    If (0.0 = i_008\Field0) Then
                                        i_008\Field0 = 1.0
                                    EndIf
                                EndIf
                            EndIf
                            If (40.0 > entitypitch(local10\Field1\Field20[$00], $01)) Then
                                local10\Field2 = 2.0
                                playsound_strict(leversfx)
                            Else
                                local7 = createparticle(entityx(local10\Field1\Field19[$00], $01), entityy(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01), $06, 0.02, -0.12, $C8)
                                rotateentity(local7\Field1, -90.0, 0.0, 0.0, $01)
                                turnentity(local7\Field1, rnd(-26.0, 26.0), rnd(-26.0, 26.0), rnd(360.0, 0.0), $00)
                                local7\Field15 = 0.012
                                local7\Field14 = -0.015
                            EndIf
                        Else
                            hideentity(local10\Field1\Field19[$05])
                            local10\Field1\Field21[$00]\Field4 = $00
                            local10\Field1\Field21[$01]\Field4 = $00
                            local10\Field1\Field21[$02]\Field4 = $00
                            rotateentity(local10\Field1\Field20[$00], curveangle(1.0, entitypitch(local10\Field1\Field20[$00], $01), 15.0), entityyaw(local10\Field1\Field20[$00], $01), 0.0, $01)
                        EndIf
                    EndIf
                    local10\Field4 = updateelevators(local10\Field4, local10\Field1\Field21[$03], local10\Field1\Field21[$04], local10\Field1\Field19[$08], local10\Field1\Field19[$09], local10, $01)
                EndIf
            Case "106victim","classdvictim1","classdvictim2","janitorvictim"
                If (contained106 = $00) Then
                    If (playerroom = local10\Field1) Then
                        If (0.0 = local10\Field2) Then
                            local30 = createdecal($00, entityx(local10\Field1\Field2, $00), (799.0 * roomscale), entityz(local10\Field1\Field2, $00), -90.0, (Float rand($168, $01)), 0.0)
                            local30\Field2 = 0.05
                            local30\Field1 = 0.0015
                            entityalpha(local30\Field0, 0.8)
                            updatedecals()
                            playsound2(decaysfx($03), camera, local30\Field0, 15.0, 1.0)
                            local10\Field2 = 1.0
                        EndIf
                    EndIf
                    If (0.0 < local10\Field2) Then
                        If (local10\Field1\Field22[$00] = Null) Then
                            local10\Field2 = (local10\Field2 + local23\Field3[$00])
                        EndIf
                        If (200.0 < local10\Field2) Then
                            If (local10\Field1\Field22[$00] = Null) Then
                                local10\Field1\Field22[$00] = createnpc($12, entityx(local10\Field1\Field2, $00), (900.0 * roomscale), entityz(local10\Field1\Field2, $00))
                                rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                                If (local10\Field0 = "106victim") Then
                                    changenpctextureid(local10\Field1\Field22[$00], $07)
                                ElseIf (local10\Field0 = "classdvictim1") Then
                                    changenpctextureid(local10\Field1\Field22[$00], $0B)
                                ElseIf (local10\Field0 = "classdvictim2") Then
                                    changenpctextureid(local10\Field1\Field22[$00], $0C)
                                ElseIf (local10\Field0 = "janitorvictim") Then
                                    changenpctextureid(local10\Field1\Field22[$00], $0D)
                                EndIf
                                local10\Field1\Field22[$00]\Field9 = 6.0
                                playsound_strict(horrorsfx($00))
                                playsound2(decaysfx($02), camera, local10\Field1\Field22[$00]\Field4, 15.0, 1.0)
                            EndIf
                            local10\Field1\Field22[$00]\Field74 = 0.0
                            entitytype(local10\Field1\Field22[$00]\Field4, $02, $00)
                            If (0.35 < entityy(local10\Field1\Field22[$00]\Field4, $00)) Then
                                animatenpc(local10\Field1\Field22[$00], 1.0, 10.0, 0.12, $00)
                                local0 = entitydistance(collider, local10\Field1\Field22[$00]\Field4)
                                If (0.8 > local0) Then
                                    local31 = point_direction(entityx(collider, $01), entityz(collider, $01), entityx(local10\Field1\Field22[$00]\Field4, $01), entityz(local10\Field1\Field22[$00]\Field4, $01))
                                    translateentity(collider, ((cos(((- local31) + 90.0)) * (local0 - 0.8)) * (local0 - 0.8)), 0.0, ((sin(((- local31) + 90.0)) * (local0 - 0.8)) * (local0 - 0.8)), $00)
                                EndIf
                                If (0.6 < entityy(local10\Field1\Field22[$00]\Field4, $00)) Then
                                    entitytype(local10\Field1\Field22[$00]\Field4, $00, $00)
                                EndIf
                            Else
                                local10\Field2 = (local10\Field2 + local23\Field3[$00])
                                animatenpc(local10\Field1\Field22[$00], 11.0, 19.0, 0.25, $00)
                                If (local10\Field9 = $00) Then
                                    loadeventsound(local10, scpmodding_processfilepath("SFX\General\BodyFall.ogg"), $00)
                                    playsound_strict(local10\Field9)
                                    local30 = createdecal($00, entityx(local10\Field1\Field2, $00), 0.001, entityz(local10\Field1\Field2, $00), 90.0, (Float rand($168, $01)), 0.0)
                                    local30\Field2 = 0.4
                                    entityalpha(local30\Field0, 0.8)
                                    updatedecals()
                                EndIf
                                If (400.0 < local10\Field2) Then
                                    If (local10\Field9 <> $00) Then
                                        freesound_strict(local10\Field9)
                                        local10\Field9 = $00
                                    EndIf
                                    removeevent(local10)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "106sinkhole"
                If (0.0 = local10\Field2) Then
                    local30 = createdecal($00, (entityx(local10\Field1\Field2, $00) + rnd(-0.5, 0.5)), 0.01, (entityz(local10\Field1\Field2, $00) + rnd(-0.5, 0.5)), 90.0, (Float rand($168, $01)), 0.0)
                    local30\Field2 = 2.5
                    scalesprite(local30\Field0, local30\Field2, local30\Field2)
                    local10\Field2 = 1.0
                ElseIf (playerroom = local10\Field1) Then
                    If (local10\Field9 = $00) Then
                        local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Sinkhole.ogg"))
                    Else
                        local10\Field6 = loopsound2(local10\Field9, local10\Field6, camera, local10\Field1\Field2, 4.5, 1.5)
                    EndIf
                    local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))
                    If (2.0 > local0) Then
                        currstepsfx = $01
                        currspeed = curvevalue(0.0, currspeed, max((local0 * 50.0), 1.0))
                        crouchstate = ((2.0 - local0) / 2.0)
                        If (0.5 > local0) Then
                            If (0.0 = local10\Field3) Then
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Room\SinkholeFall.ogg")))
                            EndIf
                            currspeed = curvevalue(0.0, currspeed, max((local0 * 50.0), 1.0))
                            local18 = curvevalue(entityx(local10\Field1\Field2, $00), entityx(collider, $00), 10.0)
                            local19 = curvevalue((entityy(local10\Field1\Field2, $00) - local10\Field3), entityy(collider, $00), 25.0)
                            local20 = curvevalue(entityz(local10\Field1\Field2, $00), entityz(collider, $00), 10.0)
                            positionentity(collider, local18, local19, local20, $01)
                            dropspeed = 0.0
                            resetentity(collider)
                            local10\Field3 = min((local10\Field3 + (local23\Field3[$00] / 200.0)), 2.0)
                            lightblink = min((local10\Field3 * 5.0), 10.0)
                            blurtimer = (local10\Field3 * 500.0)
                            If (2.0 = local10\Field3) Then
                                movetopocketdimension()
                            EndIf
                        EndIf
                    EndIf
                Else
                    local10\Field3 = 0.0
                EndIf
            Case "682roar"
                If (0.0 = local10\Field2) Then
                    If (playerroom = local10\Field1) Then
                        local10\Field2 = (Float (rand($12C, $3E8) * $46))
                    EndIf
                ElseIf (((((playerroom\Field7\Field10 <> "pocketdimension") And (playerroom\Field7\Field10 <> "room860")) And (playerroom\Field7\Field10 <> "room1123")) And (playerroom\Field7\Field10 <> "dimension1499")) <> 0) Then
                    local10\Field2 = (local10\Field2 - local23\Field3[$00])
                    If (1190.0 > local10\Field2) Then
                        If (1190.0 <= (local10\Field2 + local23\Field3[$00])) Then
                            loadeventsound(local10, scpmodding_processfilepath("SFX\SCP\682\Roar.ogg"), $00)
                            local10\Field6 = playsound_strict(local10\Field9)
                        EndIf
                        If (980.0 < local10\Field2) Then
                            camerashake = 0.5
                        EndIf
                        If (((665.0 > local10\Field2) And (420.0 < local10\Field2)) <> 0) Then
                            camerashake = 2.0
                        EndIf
                        If (70.0 > local10\Field2) Then
                            If (local10\Field9 <> $00) Then
                                freesound_strict(local10\Field9)
                            EndIf
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room914"
                If (playerroom = local10\Field1) Then
                    If ((local10\Field1\Field21[$02]\Field5 Or local10\Field1\Field21[$03]\Field5) <> 0) Then
                        giveachievement($14, $01)
                        local10\Field3 = 1.0
                    EndIf
                    If (1.0 = local10\Field3) Then
                        shouldplay = $16
                    EndIf
                    entitypick(camera, 1.0)
                    If (pickedentity() = local10\Field1\Field19[$00]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field19[$00]
                        EndIf
                    ElseIf (pickedentity() = local10\Field1\Field19[$01]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field19[$01]
                        EndIf
                    EndIf
                    If ((mousedown1 Or mousehit1) <> 0) Then
                        If (grabbedentity <> $00) Then
                            If (grabbedentity = local10\Field1\Field19[$00]) Then
                                If (0.0 = local10\Field2) Then
                                    drawhandicon = $01
                                    turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_leverturn) * 2.5), $00)
                                    local21 = wrapangle(entityroll(local10\Field1\Field19[$00], $00))
                                    If (181.0 < local21) Then
                                        drawarrowicon($03) = $01
                                    EndIf
                                    drawarrowicon($01) = $01
                                    If (90.0 > local21) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 361.0, $00)
                                    ElseIf (180.0 > local21) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 180.0, $00)
                                    EndIf
                                    If (((181.0 > local21) And (90.0 < local21)) <> 0) Then
                                        For local12 = Each items
                                            If (((local12\Field1 <> $00) And (local12\Field15 = $00)) <> 0) Then
                                                If (200.0 > (Abs (entityx(local12\Field1, $00) - (local10\Field1\Field3 - (712.0 * roomscale))))) Then
                                                    If (104.0 > (Abs (entityy(local12\Field1, $00) - (local10\Field1\Field4 + (648.0 * roomscale))))) Then
                                                        local10\Field2 = 1.0
                                                        local10\Field6 = playsound2(machinesfx, camera, local10\Field1\Field19[$01], 10.0, 1.0)
                                                        local10\Field1\Field21[$01]\Field16 = playsound2(loadtempsound(scpmodding_processfilepath("SFX\SCP\914\DoorClose.ogg")), camera, local10\Field1\Field21[$01]\Field0, 10.0, 1.0)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            ElseIf (grabbedentity = local10\Field1\Field19[$01]) Then
                                If (0.0 = local10\Field2) Then
                                    drawhandicon = $01
                                    turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_leverturn) * 2.5), $00)
                                    local21 = wrapangle(entityroll(local10\Field1\Field19[$01], $00))
                                    drawarrowicon($03) = $01
                                    drawarrowicon($01) = $01
                                    If (90.0 < local21) Then
                                        If (180.0 > local21) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 90.0, $00)
                                        ElseIf (270.0 > local21) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 270.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Else
                        grabbedentity = $00
                    EndIf
                    local94 = ""
                    If (grabbedentity <> local10\Field1\Field19[$01]) Then
                        local21 = wrapangle(entityroll(local10\Field1\Field19[$01], $00))
                        If (22.5 > local21) Then
                            local21 = 0.0
                            local94 = "1:1"
                        ElseIf (67.5 > local21) Then
                            local21 = 40.0
                            local94 = "coarse"
                        ElseIf (180.0 > local21) Then
                            local21 = 90.0
                            local94 = "rough"
                        ElseIf (337.5 < local21) Then
                            local21 = -1.0
                            local94 = "1:1"
                        ElseIf (292.5 < local21) Then
                            local21 = -40.0
                            local94 = "fine"
                        Else
                            local21 = -90.0
                            local94 = "very fine"
                        EndIf
                        rotateentity(local10\Field1\Field19[$01], 0.0, 0.0, curvevalue(local21, entityroll(local10\Field1\Field19[$01], $00), 20.0), $00)
                    EndIf
                    For local1 = $00 To $01 Step $01
                        If (grabbedentity = local10\Field1\Field19[local1]) Then
                            If (entityinview(local10\Field1\Field19[local1], camera) = $00) Then
                                grabbedentity = $00
                            ElseIf (1.0 < entitydistance(local10\Field1\Field19[local1], camera)) Then
                                grabbedentity = $00
                            EndIf
                        EndIf
                    Next
                    If (0.0 < local10\Field2) Then
                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                        local10\Field1\Field21[$01]\Field5 = $00
                        If (140.0 < local10\Field2) Then
                            If (local10\Field1\Field21[$00]\Field5 = $01) Then
                                local10\Field1\Field21[$00]\Field16 = playsound2(loadtempsound(scpmodding_processfilepath("SFX\SCP\914\DoorClose.ogg")), camera, local10\Field1\Field21[$00]\Field0, 10.0, 1.0)
                            EndIf
                            local10\Field1\Field21[$00]\Field5 = $00
                        EndIf
                        If ((170.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01))) Then
                            If (((local94 = "rough") Or (local94 = "coarse")) <> 0) Then
                                If (((182.0 < local10\Field2) And (182.0 > (local10\Field2 - (Float local95)))) <> 0) Then
                                    playsound_strict(death914sfx)
                                EndIf
                            EndIf
                            If (210.0 < local10\Field2) Then
                                Select local94
                                    Case "rough"
                                        killtimer = min(-1.0, killtimer)
                                        blinktimer = -10.0
                                        If (local10\Field6 <> $00) Then
                                            stopchannel(local10\Field6)
                                        EndIf
                                        deathmsg = (((chr($22) + scplang_getphrase("events.room9141_1")) + " ") + "Subject D-9341")
                                        deathmsg = ((((((((((((((deathmsg + scplang_getphrase("events.room9141_2")) + " ") + chr($22)) + scplang_getphrase("events.room9141_3")) + chr($22)) + " ") + scplang_getphrase("events.room9141_4")) + " ") + chr($22)) + scplang_getphrase("events.room9141_5")) + chr($22)) + " ") + scplang_getphrase("events.room9141_6")) + chr($22))
                                    Case "coarse"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - local23\Field3[$01])) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                    Case "1:1"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - local23\Field3[$01])) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                    Case "fine","very fine"
                                        blinktimer = -10.0
                                        If (210.0 > (local10\Field2 - local23\Field3[$01])) Then
                                            playsound_strict(use914sfx)
                                        EndIf
                                End Select
                            EndIf
                        EndIf
                        If (420.0 < local10\Field2) Then
                            rotateentity(local10\Field1\Field19[$00], entitypitch(local10\Field1\Field19[$00], $00), entityyaw(local10\Field1\Field19[$00], $00), curveangle(0.0, entityroll(local10\Field1\Field19[$00], $00), 10.0), $00)
                        Else
                            rotateentity(local10\Field1\Field19[$00], entitypitch(local10\Field1\Field19[$00], $00), entityyaw(local10\Field1\Field19[$00], $00), 180.0, $00)
                        EndIf
                        If (840.0 < local10\Field2) Then
                            For local12 = Each items
                                If (((local12\Field1 <> $00) And (local12\Field15 = $00)) <> 0) Then
                                    If ((180.0 * roomscale) > distance(entityx(local12\Field1, $00), entityz(local12\Field1, $00), entityx(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01))) Then
                                        use914(local12, local94, entityx(local10\Field1\Field19[$03], $01), entityy(local10\Field1\Field19[$03], $01), entityz(local10\Field1\Field19[$03], $01))
                                    EndIf
                                EndIf
                            Next
                            If ((160.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01))) Then
                                Select local94
                                    Case "coarse"
                                        injuries = 4.0
                                        msg = scplang_getphrase("events.room9142")
                                        msgtimer = 560.0
                                    Case "1:1"
                                        invertmouse = (invertmouse = $00)
                                    Case "fine","very fine"
                                        superman = $01
                                End Select
                                blurtimer = 1000.0
                                positionentity(collider, entityx(local10\Field1\Field19[$03], $01), (entityy(local10\Field1\Field19[$03], $01) + 1.0), entityz(local10\Field1\Field19[$03], $01), $00)
                                resetentity(collider)
                                dropspeed = 0.0
                            EndIf
                            local10\Field1\Field21[$00]\Field5 = $01
                            local10\Field1\Field21[$01]\Field5 = $01
                            rotateentity(local10\Field1\Field19[$00], 0.0, 0.0, 0.0, $00)
                            local10\Field2 = 0.0
                            local98 = loadtempsound(scpmodding_processfilepath("SFX\SCP\914\DoorOpen.ogg"))
                            local10\Field1\Field21[$00]\Field16 = playsound2(local98, camera, local10\Field1\Field21[$00]\Field0, 10.0, 1.0)
                            local10\Field1\Field21[$01]\Field16 = playsound2(local98, camera, local10\Field1\Field21[$01]\Field0, 10.0, 1.0)
                        EndIf
                    EndIf
                EndIf
                updatesoundorigin(local10\Field6, camera, local10\Field1\Field19[$01], 10.0, 1.0)
            Case "1048a"
                If (local10\Field1\Field19[$00] = $00) Then
                    If (((playerroom <> local10\Field1) And (-10.0 > blinktimer)) <> 0) Then
                        local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))
                        If (16.0 > local0) Then
                            For local11 = Each events
                                If (local11\Field0 = local10\Field0) Then
                                    If (local11\Field1 <> local10\Field1) Then
                                        If (local11\Field1\Field19[$00] <> $00) Then
                                            local10\Field1\Field19[$00] = copyentity(local11\Field1\Field19[$00], $00)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local10\Field1\Field19[$00] = $00) Then
                                local10\Field1\Field19[$00] = copyentity(local22\Field0[$11], $00)
                            EndIf
                            scaleentity(local10\Field1\Field19[$00], 0.05, 0.05, 0.05, $00)
                            setanimtime(local10\Field1\Field19[$00], 2.0, $00)
                            positionentity(local10\Field1\Field19[$00], entityx(local10\Field1\Field2, $00), 0.0, entityz(local10\Field1\Field2, $00), $00)
                            rotateentity(local10\Field1\Field19[$00], -90.0, rnd(0.0, 360.0), 0.0, $00)
                            local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1048A\Shriek.ogg"))
                            local10\Field10 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1048A\Growth.ogg"))
                            local10\Field2 = 1.0
                        EndIf
                    EndIf
                Else
                    local10\Field4 = 1.0
                    Select local10\Field2
                        Case 1.0
                            animate2(local10\Field1\Field19[$00], animtime(local10\Field1\Field19[$00]), $02, $18B, 1.0, $01)
                            If (2.5 > entitydistance(collider, local10\Field1\Field19[$00])) Then
                                local10\Field2 = 2.0
                            EndIf
                        Case 2.0
                            local100 = animtime(local10\Field1\Field19[$00])
                            animate2(local10\Field1\Field19[$00], local100, $02, $287, 1.0, $00)
                            If (((400.0 >= local100) And (400.0 < animtime(local10\Field1\Field19[$00]))) <> 0) Then
                                local10\Field6 = playsound_strict(local10\Field9)
                            EndIf
                            local101 = max((1.0 - ((Abs (local100 - 600.0)) / 100.0)), 0.0)
                            blurtimer = (local101 * 1000.0)
                            camerashake = (local101 * 10.0)
                            pointentity(local10\Field1\Field19[$00], collider, 0.0)
                            rotateentity(local10\Field1\Field19[$00], -90.0, entityyaw(local10\Field1\Field19[$00], $00), 0.0, $00)
                            If (646.0 < local100) Then
                                If (playerroom = local10\Field1) Then
                                    local10\Field2 = 3.0
                                    playsound_strict(local10\Field10)
                                    msg = scplang_getphrase("events.room10481")
                                    msgtimer = 210.0
                                Else
                                    local10\Field4 = 2100.0
                                EndIf
                            EndIf
                        Case 3.0
                            local10\Field3 = (local10\Field3 + local23\Field3[$00])
                            blurtimer = (local10\Field3 * 2.0)
                            If (((250.0 < local10\Field3) And (250.0 >= (local10\Field3 - local23\Field3[$00]))) <> 0) Then
                                Select rand($03, $01)
                                    Case $01
                                        msg = scplang_getphrase("events.room10482")
                                    Case $02
                                        msg = scplang_getphrase("events.room10483")
                                    Case $03
                                        msg = scplang_getphrase("events.room10484")
                                End Select
                                msgtimer = 210.0
                            ElseIf (((600.0 < local10\Field3) And (600.0 >= (local10\Field3 - local23\Field3[$00]))) <> 0) Then
                                Select rand($04, $01)
                                    Case $01
                                        msg = scplang_getphrase("events.room10485")
                                    Case $02
                                        msg = scplang_getphrase("events.room10486")
                                    Case $03
                                        msg = scplang_getphrase("events.room10487")
                                    Case $04
                                        msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                                End Select
                                msgtimer = 350.0
                            EndIf
                            If (1050.0 < local10\Field3) Then
                                deathmsg = scplang_getphrase("events.room10489")
                                kill($00, $00)
                                local10\Field2 = 4.0
                                removeevent(local10)
                            EndIf
                    End Select
                    If (local10 <> Null) Then
                        If (playerroom <> local10\Field1) Then
                            If (0.0 < local10\Field4) Then
                                local10\Field4 = (local10\Field4 + local23\Field3[$00])
                                If (1750.0 < local10\Field4) Then
                                    freeentity(local10\Field1\Field19[$00])
                                    local10\Field1\Field19[$00] = $00
                                    removeevent(local10)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room4tunnels"
                If (((10.0 > local10\Field1\Field8) And (0.0 < local10\Field1\Field8)) <> 0) Then
                    local10\Field1\Field22[$00] = createnpc($12, (entityx(local10\Field1\Field2, $01) + 1.0), 0.5, (entityz(local10\Field1\Field2, $01) + 1.0))
                    changenpctextureid(local10\Field1\Field22[$00], $08)
                    rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (entityyaw(local10\Field1\Field2, $00) - (Float rand($14, $3C))), 0.0, $01)
                    setnpcframe(local10\Field1\Field22[$00], 19.0)
                    local10\Field1\Field22[$00]\Field9 = 8.0
                    removeevent(local10)
                EndIf
            Case "room2gw_b"
                If (8.0 > local10\Field1\Field8) Then
                    If (0.0 = local10\Field2) Then
                        local10\Field1\Field22[$00] = createnpc($13, entityx(local10\Field1\Field19[$02], $01), (entityy(local10\Field1\Field19[$02], $01) + 0.5), entityz(local10\Field1\Field19[$02], $01))
                        pointentity(local10\Field1\Field22[$00]\Field4, local10\Field1\Field2, 0.0)
                        rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, entityyaw(local10\Field1\Field22[$00]\Field4, $00), 0.0, $01)
                        setnpcframe(local10\Field1\Field22[$00], 288.0)
                        local10\Field1\Field22[$00]\Field9 = 8.0
                        local10\Field2 = 1.0
                    EndIf
                    local7 = createparticle(entityx(local10\Field1\Field19[$00], $01), entityy(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01), $06, 0.2, 0.0, $0A)
                    local7\Field8 = 0.01
                    rotateentity(local7\Field1, -60.0, (Float (local10\Field1\Field6 - $5A)), 0.0, $00)
                    local7\Field14 = -0.02
                    local10\Field6 = loopsound2(alarmsfx($03), local10\Field6, camera, local10\Field1\Field19[$03], 5.0, 1.0)
                EndIf
            Case "room2scps2"
                If (15.0 > local10\Field1\Field8) Then
                    If (contained106 <> 0) Then
                        local10\Field2 = 2.0
                    EndIf
                    If (0.0 > curr106\Field9) Then
                        local10\Field2 = 2.0
                    EndIf
                    If (selecteddifficulty\Field10 = $00) Then
                        local10\Field1\Field21[$01]\Field4 = $01
                    EndIf
                    If (2.0 > local10\Field2) Then
                        If (0.0 = local10\Field2) Then
                            loadeventsound(local10, scpmodding_processfilepath("SFX\Character\Scientist\EmilyScream.ogg"), $00)
                            local10\Field6 = playsound2(local10\Field9, camera, local10\Field1\Field19[$00], 100.0, 1.0)
                            local30 = createdecal($00, entityx(local10\Field1\Field19[$00], $01), (local10\Field1\Field4 + (1.8 * roomscale)), entityz(local10\Field1\Field19[$00], $01), 90.0, (Float rand($168, $01)), 0.0)
                            local30\Field2 = 0.5
                            entityalpha(local30\Field0, 0.8)
                            entityfx(local30\Field0, $01)
                            local10\Field2 = 1.0
                            If (rand($0A, $01) = $01) Then
                                msg = scplang_getphrase("events.room2scps")
                                msgtimer = 350.0
                            EndIf
                        ElseIf (1.0 = local10\Field2) Then
                            If (channelplaying(local10\Field6) = $00) Then
                                local10\Field2 = 2.0
                                local10\Field1\Field21[$00]\Field4 = $00
                            Else
                                updatesoundorigin(local10\Field6, camera, local10\Field1\Field19[$00], 100.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        local10\Field1\Field21[$00]\Field4 = $00
                        removeevent(local10)
                    EndIf
                EndIf
            Case "room1162"
                If (playerroom = local10\Field1) Then
                    grabbedentity = $00
                    local10\Field2 = 0.0
                    local104 = $01
                    local105 = createpivot(local10\Field1\Field2)
                    positionentity(local105, 976.0, 128.0, -622.0, $00)
                    For local12 = Each items
                        If (local12\Field15 = $00) Then
                            If (0.75 > entitydistance(local12\Field1, local10\Field1\Field19[$00])) Then
                                local104 = $00
                            EndIf
                        EndIf
                    Next
                    If (((0.75 > entitydistance(local10\Field1\Field19[$00], collider)) And local104) <> 0) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local10\Field1\Field19[$00]
                        EndIf
                    EndIf
                    If (grabbedentity <> $00) Then
                        local10\Field3 = (Float rand($00, (maxitemamount - $01)))
                        If (inventory((Int local10\Field3)) <> Null) Then
                            local10\Field4 = 1.0
                        Else
                            For local1 = $00 To (maxitemamount - $01) Step $01
                                local106 = (inventory((Int ((local10\Field3 + (Float local1)) Mod (Float maxitemamount)))) = Null)
                                If (local106 = $00) Then
                                    local10\Field3 = ((local10\Field3 + (Float local1)) Mod (Float maxitemamount))
                                EndIf
                                If (rand($08, $01) = $01) Then
                                    If (local106 <> 0) Then
                                        local10\Field4 = 3.1
                                    Else
                                        local10\Field4 = 3.0
                                    EndIf
                                    local10\Field2 = (Float rand($01, $06))
                                    local107 = ""
                                    Select local10\Field2
                                        Case 1.0
                                            local107 = "Lost Key"
                                        Case 2.0
                                            local107 = "Disciplinary Hearing DH-S-4137-17092"
                                        Case 3.0
                                            local107 = "Coin"
                                        Case 4.0
                                            local107 = "Movie Ticket"
                                        Case 5.0
                                            local107 = "Old Badge"
                                        Case 6.0
                                            local107 = "Document SCP-XXX"
                                    End Select
                                    local109 = $00
                                    For local12 = Each items
                                        If (local12\Field0 = local107) Then
                                            local109 = $01
                                            local10\Field4 = 1.0
                                            local10\Field2 = 0.0
                                            Exit
                                        EndIf
                                    Next
                                    If (((local109 = $00) And (local106 = $00)) <> 0) Then
                                        Exit
                                    EndIf
                                ElseIf (local106 <> 0) Then
                                    local10\Field4 = 2.0
                                Else
                                    local10\Field4 = 1.0
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                    If (1.0 = local10\Field4) Then
                        local110 = $00
                        For local75 = Each itemtemplates
                            If (isitemgoodfor1162(local75) <> 0) Then
                                Select inventory((Int local10\Field3))\Field3\Field1
                                    Case "key"
                                        If ((((local75\Field1 = "key1") Or (local75\Field1 = "key2")) And (rand($02, $01) = $01)) <> 0) Then
                                            local110 = $01
                                        EndIf
                                    Case "paper","oldpaper"
                                        If (((local75\Field1 = "paper") And (rand($0C, $01) = $01)) <> 0) Then
                                            local110 = $01
                                        EndIf
                                    Case "gasmask","gasmask3","supergasmask"
                                        If ((((((((local75\Field1 = "gasmask") Or (local75\Field1 = "gasmask3")) Or (local75\Field1 = "supergasmask")) Or (local75\Field1 = "hazmatsuit")) Or (local75\Field1 = "hazmatsuit2")) Or (local75\Field1 = "hazmatsuit3")) And (rand($02, $01) = $01)) <> 0) Then
                                            local110 = $01
                                        EndIf
                                    Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
                                        If ((((((((local75\Field1 = "gasmask") Or (local75\Field1 = "gasmask3")) Or (local75\Field1 = "supergasmask")) Or (local75\Field1 = "hazmatsuit")) Or (local75\Field1 = "hazmatsuit2")) Or (local75\Field1 = "hazmatsuit3")) And (rand($02, $01) = $01)) <> 0) Then
                                            local110 = $01
                                        EndIf
                                    Case "key1","key2","key3"
                                        If ((((((local75\Field1 = "key1") Or (local75\Field1 = "key2")) Or (local75\Field1 = "key3")) Or (local75\Field1 = "misc")) And (rand($06, $01) = $01)) <> 0) Then
                                            local110 = $01
                                        EndIf
                                    Case "vest","finevest"
                                        If ((((local75\Field1 = "vest") Or (local75\Field1 = "finevest")) And (rand($01, $01) = $01)) <> 0) Then
                                            local110 = $01
                                        EndIf
                                    Case "scp198"
                                        local3 = createpivot($00)
                                        positionentity(local3, entityx(collider, $00), (entityy(collider, $00) - 0.05), entityz(collider, $00), $00)
                                        turnentity(local3, 90.0, 0.0, 0.0, $00)
                                        entitypick(local3, 0.3)
                                        local30 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
                                        local30\Field2 = 0.75
                                        scalesprite(local30\Field0, local30\Field2, local30\Field2)
                                        freeentity(local3)
                                        removeitem(inventory((Int local10\Field3)))
                                        local10\Field2 = (local10\Field2 + 1.0)
                                        local10\Field4 = 0.0
                                        deathmsg = scplang_getphrase("events.room11621")
                                        playsound_strict(loadtempsound((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg")))
                                        lightflash = 5.0
                                        kill($01, $00)
                                        msg = scplang_getphrase("events.room11622")
                                        msgtimer = 350.0
                                        Exit
                                    Case "scp357"
                                        If (56.0 <= i_357\Field0) Then
                                            local3 = createpivot($00)
                                            positionentity(local3, entityx(collider, $00), (entityy(collider, $00) - 0.05), entityz(collider, $00), $00)
                                            turnentity(local3, 90.0, 0.0, 0.0, $00)
                                            entitypick(local3, 0.3)
                                            local30 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
                                            local30\Field2 = 0.75
                                            scalesprite(local30\Field0, local30\Field2, local30\Field2)
                                            freeentity(local3)
                                            removeitem(inventory((Int local10\Field3)))
                                            local10\Field2 = (local10\Field2 + 1.0)
                                            local10\Field4 = 0.0
                                            deathmsg = ("Subject D-9341" + scplang_getphrase("events.room11623"))
                                            blurtimer = 1000.0
                                            kill($01, $00)
                                            msg = scplang_getphrase("events.room11624")
                                            msgtimer = 350.0
                                            Exit
                                        Else
                                            removeitem(inventory((Int local10\Field3)))
                                            local110 = $01
                                            Exit
                                        EndIf
                                    Default
                                        If (((local75\Field1 = "misc") And (rand($06, $01) = $01)) <> 0) Then
                                            local110 = $01
                                        EndIf
                                End Select
                            EndIf
                            If (local110 <> 0) Then
                                removeitem(inventory((Int local10\Field3)))
                                local12 = createitem(local75\Field0, local75\Field1, entityx(local105, $01), entityy(local105, $01), entityz(local105, $01), $00, $00, $00, 1.0, $00)
                                entitytype(local12\Field1, $03, $00)
                                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg"))))
                                local10\Field4 = 0.0
                                giveachievement($1B, $01)
                                mousehit1 = $00
                                Exit
                            EndIf
                        Next
                    ElseIf (2.0 = local10\Field4) Then
                        injuries = (injuries + 5.0)
                        local3 = createpivot($00)
                        positionentity(local3, entityx(collider, $00), (entityy(collider, $00) - 0.05), entityz(collider, $00), $00)
                        turnentity(local3, 90.0, 0.0, 0.0, $00)
                        entitypick(local3, 0.3)
                        local30 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
                        local30\Field2 = 0.75
                        scalesprite(local30\Field0, local30\Field2, local30\Field2)
                        freeentity(local3)
                        For local75 = Each itemtemplates
                            If ((isitemgoodfor1162(local75) And (rand($06, $01) = $01)) <> 0) Then
                                local12 = createitem(local75\Field0, local75\Field1, entityx(local105, $01), entityy(local105, $01), entityz(local105, $01), $00, $00, $00, 1.0, $00)
                                entitytype(local12\Field1, $03, $00)
                                giveachievement($1B, $01)
                                mousehit1 = $00
                                local10\Field4 = 0.0
                                If (15.0 < injuries) Then
                                    deathmsg = scplang_getphrase("events.room11625")
                                    playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"))))
                                    lightflash = 5.0
                                    kill($01, $00)
                                Else
                                    playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"))))
                                    lightflash = 5.0
                                    msg = scplang_getphrase("events.room11626")
                                    msgtimer = 350.0
                                EndIf
                                Exit
                            EndIf
                        Next
                    ElseIf (3.0 <= local10\Field4) Then
                        If (3.1 > local10\Field4) Then
                            playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\Exchange" + (Str rand($00, $04))) + ".ogg"))))
                            removeitem(inventory((Int local10\Field3)))
                        Else
                            injuries = (injuries + 5.0)
                            local3 = createpivot($00)
                            positionentity(local3, entityx(collider, $00), (entityy(collider, $00) - 0.05), entityz(collider, $00), $00)
                            turnentity(local3, 90.0, 0.0, 0.0, $00)
                            entitypick(local3, 0.3)
                            local30 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
                            local30\Field2 = 0.75
                            scalesprite(local30\Field0, local30\Field2, local30\Field2)
                            freeentity(local3)
                            If (15.0 < injuries) Then
                                deathmsg = scplang_getphrase("events.room11627")
                                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"))))
                                lightflash = 5.0
                                kill($01, $00)
                            Else
                                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\BodyHorrorExchange" + (Str rand($01, $04))) + ".ogg"))))
                                lightflash = 5.0
                                msg = scplang_getphrase("events.room11628")
                                msgtimer = 350.0
                            EndIf
                            local10\Field3 = 0.0
                        EndIf
                        Select local10\Field2
                            Case 1.0
                                local12 = createitem("Lost Key", "key", entityx(local105, $01), entityy(local105, $01), entityz(local105, $01), $00, $00, $00, 1.0, $00)
                            Case 2.0
                                local12 = createitem("Disciplinary Hearing DH-S-4137-17092", "oldpaper", entityx(local105, $01), entityy(local105, $01), entityz(local105, $01), $00, $00, $00, 1.0, $00)
                            Case 3.0
                                local12 = createitem("Coin", "coin", entityx(local105, $01), entityy(local105, $01), entityz(local105, $01), $00, $00, $00, 1.0, $00)
                            Case 4.0
                                local12 = createitem("Movie Ticket", "ticket", entityx(local105, $01), entityy(local105, $01), entityz(local105, $01), $00, $00, $00, 1.0, $00)
                            Case 5.0
                                local12 = createitem("Old Badge", "badge", entityx(local105, $01), entityy(local105, $01), entityz(local105, $01), $00, $00, $00, 1.0, $00)
                            Case 6.0
                                local12 = createitem("Document SCP-XXX", "paper", entityx(local105, $01), entityy(local105, $01), entityz(local105, $01), $00, $00, $00, 1.0, $00)
                        End Select
                        entitytype(local12\Field1, $03, $00)
                        giveachievement($1B, $01)
                        mousehit1 = $00
                        local10\Field4 = 0.0
                    EndIf
                    freeentity(local105)
                EndIf
            Case "room2gw"
                local10\Field1\Field21[$00]\Field4 = $01
                local10\Field1\Field21[$01]\Field4 = $01
                local113 = $00
                If (local10\Field1\Field19[$01] <> $00) Then
                    local113 = $01
                EndIf
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field2) Then
                        If (((1.4 > entitydistance(local10\Field1\Field19[$00], collider)) And (0.0 = local10\Field4)) <> 0) Then
                            local10\Field2 = 1.0
                            If (local113 <> 0) Then
                                If (local10\Field10 <> $00) Then
                                    freesound_strict(local10\Field10)
                                    local10\Field10 = $00
                                EndIf
                                local10\Field10 = loadsound_strict(scpmodding_processfilepath("SFX\Door\DoorSparks.ogg"))
                                local10\Field7 = playsound2(local10\Field10, camera, local10\Field1\Field19[$01], 5.0, 1.0)
                            EndIf
                            stopchannel(local10\Field6)
                            local10\Field6 = $00
                            If (local10\Field9 <> $00) Then
                                freesound_strict(local10\Field9)
                                local10\Field9 = $00
                            EndIf
                            local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Door\Airlock.ogg"))
                            local10\Field1\Field21[$00]\Field4 = $00
                            local10\Field1\Field21[$01]\Field4 = $00
                            usedoor(local10\Field1\Field21[$00], $01, $01)
                            usedoor(local10\Field1\Field21[$01], $01, $01)
                            playsound_strict(alarmsfx($04))
                        ElseIf (2.4 < entitydistance(local10\Field1\Field19[$00], collider)) Then
                            local10\Field4 = 0.0
                        EndIf
                    ElseIf (490.0 > local10\Field3) Then
                        local10\Field3 = (local10\Field3 + local23\Field3[$00])
                        local10\Field1\Field21[$00]\Field5 = $00
                        local10\Field1\Field21[$01]\Field5 = $00
                        If (70.0 > local10\Field3) Then
                            If (local113 <> 0) Then
                                local3 = createpivot($00)
                                local114 = local10\Field1\Field19[$01]
                                positionentity(local3, entityx(local114, $01), (entityy(local114, $01) + rnd(0.0, 0.05)), entityz(local114, $01), $00)
                                rotateentity(local3, 0.0, (entityyaw(local114, $01) + 90.0), 0.0, $00)
                                moveentity(local3, 0.0, 0.0, 0.2)
                                If (particleamount > $00) Then
                                    For local1 = $00 To (((particleamount - $01) Shl $01) + $01) Step $01
                                        local7 = createparticle(entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $07, 0.002, 0.0, $19)
                                        local7\Field8 = rnd(0.01, 0.05)
                                        rotateentity(local7\Field1, rnd(-45.0, 0.0), (entityyaw(local3, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                                        local7\Field7 = 0.0075
                                        scalesprite(local7\Field0, local7\Field7, local7\Field7)
                                        local7\Field14 = -0.05
                                    Next
                                EndIf
                                freeentity(local3)
                            EndIf
                        ElseIf (((210.0 < local10\Field3) And (385.0 > local10\Field2)) <> 0) Then
                            local3 = createpivot(local10\Field1\Field2)
                            For local1 = $00 To $01 Step $01
                                If (local1 = $00) Then
                                    positionentity(local3, 312.0, 416.0, -128.0, $00)
                                Else
                                    positionentity(local3, 312.0, 416.0, 224.0, $00)
                                EndIf
                                local7 = createparticle(entityx(local3, $01), entityy(local3, $01), entityz(local3, $01), $06, 0.8, 0.0, $32)
                                local7\Field8 = 0.025
                                rotateentity(local7\Field1, 90.0, 0.0, 0.0, $00)
                                local7\Field14 = -0.02
                            Next
                            freeentity(local3)
                            If (local10\Field6 = $00) Then
                                local10\Field6 = playsound2(local10\Field9, camera, local10\Field1\Field19[$00], 5.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        local10\Field2 = 0.0
                        local10\Field3 = 0.0
                        local10\Field4 = 1.0
                        If (local10\Field1\Field21[$00]\Field5 = $00) Then
                            local10\Field1\Field21[$00]\Field4 = $00
                            local10\Field1\Field21[$01]\Field4 = $00
                            usedoor(local10\Field1\Field21[$00], $01, $01)
                            usedoor(local10\Field1\Field21[$01], $01, $01)
                            playsound_strict(alarmsfx($05))
                        EndIf
                    EndIf
                    If (local113 <> 0) Then
                        If (channelplaying(local10\Field7) <> 0) Then
                            updatesoundorigin(local10\Field7, camera, local10\Field1\Field19[$01], 5.0, 1.0)
                        EndIf
                    EndIf
                    If (channelplaying(local10\Field6) <> 0) Then
                        updatesoundorigin(local10\Field6, camera, local10\Field1\Field19[$00], 5.0, 1.0)
                    EndIf
                Else
                    local10\Field4 = 0.0
                EndIf
            Case "room2sl"
                If (playerroom = local10\Field1) Then
                    If (((local10\Field15 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                        quickloadpercent = $00
                        quickload_currevent = local10
                        local10\Field15 = "0"
                    EndIf
                EndIf
                If (1.0 = local10\Field2) Then
                    If (0.0 > local10\Field3) Then
                        If (-350.0 = local10\Field3) Then
                            For local15 = Each securitycams
                                If (local15\Field19 = local10\Field1) Then
                                    If (5.0 > entitydistance(local15\Field4, camera)) Then
                                        If (entityvisible(local15\Field4, camera) <> 0) Then
                                            local10\Field3 = min((local10\Field3 + local23\Field3[$00]), 0.0)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Else
                            local10\Field3 = min((local10\Field3 + local23\Field3[$00]), 0.0)
                        EndIf
                    ElseIf (0.0 = local10\Field3) Then
                        If (local10\Field1\Field22[$00] <> Null) Then
                            local115 = 0.0
                            local116 = 0.0
                            local117 = $FFFFFFFF
                            local118 = $FFFFFFFF
                            For local1 = $00 To $03 Step $01
                                If (local10\Field1\Field25[local1] <> Null) Then
                                    If (local117 = $FFFFFFFF) Then
                                        local115 = entitydistance(local10\Field1\Field19[$07], local10\Field1\Field25[local1]\Field2)
                                        local117 = local1
                                    Else
                                        local116 = entitydistance(local10\Field1\Field19[$07], local10\Field1\Field25[local1]\Field2)
                                        local118 = local1
                                    EndIf
                                EndIf
                            Next
                            If (local116 < local115) Then
                                positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field25[local117]\Field2, $00), entityy(local10\Field1\Field19[$07], $01), entityz(local10\Field1\Field25[local117]\Field2, $00), $00)
                            Else
                                positionentity(local10\Field1\Field22[$00]\Field4, entityx(local10\Field1\Field25[local118]\Field2, $00), entityy(local10\Field1\Field19[$07], $01), entityz(local10\Field1\Field25[local118]\Field2, $00), $00)
                            EndIf
                            pointentity(local10\Field1\Field22[$00]\Field4, local10\Field1\Field2, 0.0)
                            moveentity(local10\Field1\Field22[$00]\Field4, 0.0, 0.0, -1.0)
                            resetentity(local10\Field1\Field22[$00]\Field4)
                            local10\Field1\Field22[$00]\Field68 = $00
                            local10\Field1\Field22[$00]\Field62 = entityx(local10\Field1\Field22[$00]\Field4, $00)
                            local10\Field1\Field22[$00]\Field63 = entityz(local10\Field1\Field22[$00]\Field4, $00)
                            local10\Field1\Field22[$00]\Field9 = 5.0
                            local10\Field3 = 1.0
                        EndIf
                    ElseIf (1.0 = local10\Field3) Then
                        If (local10\Field1\Field22[$00]\Field37 <> $01) Then
                            local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], entityx(local10\Field1\Field19[$0F], $01), entityy(local10\Field1\Field19[$0F], $01), entityz(local10\Field1\Field19[$0F], $01))
                        Else
                            local10\Field3 = 2.0
                        EndIf
                    ElseIf (2.0 = local10\Field3) Then
                        If (local10\Field1\Field22[$00]\Field37 <> $01) Then
                            local10\Field1\Field22[$00]\Field11 = 1.0
                            local10\Field3 = 3.0
                            local10\Field1\Field22[$00]\Field38 = 0.0
                        Else
                            If (5.0 > entitydistance(local10\Field1\Field22[$00]\Field4, local10\Field1\Field21[$00]\Field2)) Then
                                local10\Field1\Field21[$00]\Field4 = $01
                                local10\Field1\Field21[$01]\Field4 = $01
                                If (0.0 = local10\Field1\Field22[$00]\Field25) Then
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\DoorOpen079.ogg")))
                                    local10\Field1\Field22[$00]\Field25 = 1.0
                                EndIf
                                If (local10\Field1\Field21[$00]\Field5 = $00) Then
                                    local10\Field1\Field21[$00]\Field5 = $01
                                    local119 = rand($00, $02)
                                    playsound2(opendoorsfx($00, local119), camera, local10\Field1\Field21[$00]\Field0, 10.0, 1.0)
                                EndIf
                                If (local10\Field1\Field21[$01]\Field5 = $00) Then
                                    local10\Field1\Field21[$01]\Field5 = $01
                                    local119 = rand($00, $02)
                                    playsound2(opendoorsfx($00, local119), camera, local10\Field1\Field21[$01]\Field0, 10.0, 1.0)
                                EndIf
                            EndIf
                            If (1.0 = local10\Field1\Field22[$00]\Field25) Then
                                local10\Field1\Field22[$00]\Field7 = 0.0
                            EndIf
                        EndIf
                        If (5.0 <> local10\Field1\Field22[$00]\Field9) Then
                            local10\Field3 = 7.0
                        EndIf
                    ElseIf (3.0 = local10\Field3) Then
                        If (5.0 <> local10\Field1\Field22[$00]\Field9) Then
                            local10\Field3 = 7.0
                        EndIf
                        If (menpcseesplayer(local10\Field1\Field22[$00], $01) = $02) Then
                            local10\Field3 = 4.0
                        EndIf
                        If (local10\Field1\Field22[$00]\Field37 <> $01) Then
                            If (0.0 = local10\Field1\Field22[$00]\Field38) Then
                                If (local10\Field1\Field22[$00]\Field12 = $01) Then
                                    If (local10\Field1\Field22[$00]\Field20 = $00) Then
                                        local10\Field1\Field22[$00]\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\049\Room2SL1.ogg"))
                                        local10\Field1\Field22[$00]\Field20 = playsound2(local10\Field1\Field22[$00]\Field19, camera, local10\Field1\Field22[$00]\Field4, 10.0, 1.0)
                                    ElseIf (channelplaying(local10\Field1\Field22[$00]\Field20) = $00) Then
                                        local10\Field1\Field22[$00]\Field38 = 1.0
                                        local10\Field1\Field22[$00]\Field20 = $00
                                    EndIf
                                ElseIf (local10\Field1\Field22[$00]\Field12 = $02) Then
                                    If (3.0 = local10\Field1\Field22[$00]\Field11) Then
                                        If (local10\Field1\Field22[$00]\Field20 = $00) Then
                                            local10\Field1\Field22[$00]\Field19 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\049\Room2SL2.ogg"))
                                            local10\Field1\Field22[$00]\Field20 = playsound2(local10\Field1\Field22[$00]\Field19, camera, local10\Field1\Field22[$00]\Field4, 10.0, 1.0)
                                        ElseIf (channelplaying(local10\Field1\Field22[$00]\Field20) = $00) Then
                                            local10\Field1\Field22[$00]\Field38 = 1.0
                                            local10\Field1\Field22[$00]\Field20 = $00
                                        EndIf
                                    ElseIf (1118.0 <= local10\Field1\Field22[$00]\Field14) Then
                                        local10\Field1\Field22[$00]\Field38 = 1.0
                                    EndIf
                                EndIf
                            Else
                                Select local10\Field1\Field22[$00]\Field11
                                    Case 1.0
                                        local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], entityx(local10\Field1\Field19[$10], $01), entityy(local10\Field1\Field19[$10], $01), entityz(local10\Field1\Field19[$10], $01))
                                        local10\Field1\Field22[$00]\Field12 = $01
                                    Case 2.0
                                        local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], entityx(local10\Field1\Field19[$0F], $01), entityy(local10\Field1\Field19[$0F], $01), entityz(local10\Field1\Field19[$0F], $01))
                                        local10\Field1\Field22[$00]\Field12 = $02
                                    Case 3.0
                                        local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], entityx(local10\Field1\Field19[$11], $01), entityy(local10\Field1\Field19[$11], $01), entityz(local10\Field1\Field19[$11], $01))
                                        local10\Field1\Field22[$00]\Field12 = $02
                                    Case 4.0
                                        local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], local10\Field1\Field22[$00]\Field62, 0.1, local10\Field1\Field22[$00]\Field63)
                                        local10\Field1\Field22[$00]\Field12 = $02
                                    Case 5.0
                                        local10\Field3 = 5.0
                                End Select
                                local10\Field1\Field22[$00]\Field38 = 0.0
                                local10\Field1\Field22[$00]\Field11 = (local10\Field1\Field22[$00]\Field11 + 1.0)
                            EndIf
                        EndIf
                    ElseIf (4.0 = local10\Field3) Then
                        If (5.0 <> local10\Field1\Field22[$00]\Field9) Then
                            local10\Field3 = 7.0
                            local10\Field1\Field22[$00]\Field11 = 6.0
                        EndIf
                    ElseIf (5.0 = local10\Field3) Then
                        local10\Field1\Field22[$00]\Field9 = 2.0
                        For local9 = Each rooms
                            If (local9 <> playerroom) Then
                                If ((((hidedistance * 2.0) > entitydistance(local9\Field2, local10\Field1\Field22[$00]\Field4)) And (hidedistance < entitydistance(local9\Field2, local10\Field1\Field22[$00]\Field4))) <> 0) Then
                                    local10\Field1\Field22[$00]\Field37 = findpath(local10\Field1\Field22[$00], entityx(local9\Field2, $00), entityy(local9\Field2, $00), entityz(local9\Field2, $00))
                                    local10\Field1\Field22[$00]\Field38 = 0.0
                                    If (local10\Field1\Field22[$00]\Field37 = $01) Then
                                        local10\Field3 = 6.0
                                    EndIf
                                    Exit
                                EndIf
                            EndIf
                        Next
                    ElseIf (6.0 = local10\Field3) Then
                        If (((menpcseesplayer(local10\Field1\Field22[$00], $01) Or (0.0 < local10\Field1\Field22[$00]\Field10)) Or (local10\Field1\Field22[$00]\Field26 > $00)) <> 0) Then
                            local10\Field3 = 7.0
                        Else
                            If (playerroom = local10\Field1) Then
                                shouldplay = $14
                            EndIf
                            If (local10\Field1\Field22[$00]\Field37 <> $01) Then
                                local10\Field1\Field22[$00]\Field24 = 4200.0
                                positionentity(local10\Field1\Field22[$00]\Field4, 0.0, 500.0, 0.0, $00)
                                resetentity(local10\Field1\Field22[$00]\Field4)
                                local10\Field3 = 7.0
                            EndIf
                        EndIf
                    EndIf
                    If (local10\Field1\Field22[$00] <> Null) Then
                        If (7.0 > local10\Field3) Then
                            If (2.0 < local10\Field3) Then
                                If (1.0 < (Abs (entityy(local10\Field1\Field21[$00]\Field2, $00) - entityy(local10\Field1\Field22[$00]\Field4, $00)))) Then
                                    If (1.0 > (Abs (entityy(local10\Field1\Field21[$00]\Field2, $00) - entityy(collider, $00)))) Then
                                        If (local10\Field1\Field21[$00]\Field5 <> 0) Then
                                            local10\Field1\Field21[$00]\Field5 = $00
                                            local10\Field1\Field21[$00]\Field8 = $01
                                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\DoorClose079.ogg")))
                                        EndIf
                                    EndIf
                                ElseIf (local10\Field1\Field21[$00]\Field5 = $00) Then
                                    local10\Field1\Field21[$00]\Field8 = $00
                                    local10\Field1\Field21[$00]\Field5 = $01
                                    local119 = rand($00, $02)
                                    playsound2(opendoorsfx($00, local119), camera, local10\Field1\Field21[$00]\Field0, 10.0, 1.0)
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\DoorOpen079.ogg")))
                                EndIf
                            EndIf
                        ElseIf (local10\Field1\Field21[$00]\Field5 = $00) Then
                            local10\Field1\Field21[$00]\Field8 = $00
                            local10\Field1\Field21[$00]\Field5 = $01
                            local119 = rand($00, $02)
                            playsound2(opendoorsfx($00, local119), camera, local10\Field1\Field21[$00]\Field0, 10.0, 1.0)
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Door\DoorOpen079.ogg")))
                        EndIf
                    EndIf
                EndIf
                If (playerroom = local10\Field1) Then
                    local10\Field4 = (Float updatelever(local10\Field1\Field20[$00], $00))
                    If (1.0 = local10\Field4) Then
                        updatecheckpointmonitors($00)
                        If (50.0 > monitortimer) Then
                            entitytexture(local10\Field1\Field19[$14], local10\Field1\Field27[$00], $01, $00)
                        Else
                            entitytexture(local10\Field1\Field19[$14], local10\Field1\Field27[$00], $00, $00)
                        EndIf
                    Else
                        turncheckpointmonitorsoff($00)
                        entitytexture(local10\Field1\Field19[$14], local10\Field1\Field27[$00], $00, $00)
                    EndIf
                    If (1.0 < (Abs (entityy(local10\Field1\Field21[$00]\Field2, $00) - entityy(collider, $00)))) Then
                        For local1 = $00 To $0E Step $01
                            If (((local10\Field1\Field19[local1] <> $00) And (local1 <> $07)) <> 0) Then
                                showentity(local10\Field1\Field19[local1])
                            EndIf
                        Next
                        For local15 = Each securitycams
                            If (local15\Field19 = local10\Field1) Then
                                If (local15\Field4 <> $00) Then
                                    showentity(local15\Field4)
                                EndIf
                                If (local15\Field10 <> $00) Then
                                    showentity(local15\Field10)
                                EndIf
                                Exit
                            EndIf
                        Next
                        For local1 = $00 To $03 Step $01
                            If (playerroom\Field24[local1] <> Null) Then
                                entityalpha(getchild(playerroom\Field24[local1]\Field2, $02), 0.0)
                            EndIf
                        Next
                    Else
                        For local1 = $00 To $0E Step $01
                            If (((local10\Field1\Field19[local1] <> $00) And (local1 <> $07)) <> 0) Then
                                hideentity(local10\Field1\Field19[local1])
                            EndIf
                        Next
                        For local15 = Each securitycams
                            If (local15\Field19 = local10\Field1) Then
                                If (local15\Field4 <> $00) Then
                                    hideentity(local15\Field4)
                                EndIf
                                If (local15\Field10 <> $00) Then
                                    hideentity(local15\Field10)
                                EndIf
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                For local11 = Each events
                    If (local11\Field0 = "room008") Then
                        If (2.0 = local11\Field2) Then
                            entitytexture(local10\Field1\Field19[$15], local10\Field1\Field27[$00], $03, $00)
                        Else
                            entitytexture(local10\Field1\Field19[$15], local10\Field1\Field27[$01], $06, $00)
                        EndIf
                    EndIf
                Next
            Case "096spawn"
                If (hidedistance > local10\Field1\Field8) Then
                    If (2.0 <> local10\Field2) Then
                        If (curr096 <> Null) Then
                            If (40.0 > entitydistance(curr096\Field4, collider)) Then
                                local10\Field2 = 2.0
                            EndIf
                            For local11 = Each events
                                If (local11\Field0 = "room2servers") Then
                                    If (((0.0 < local11\Field2) And (local11\Field1\Field22[$00] <> Null)) <> 0) Then
                                        local10\Field2 = 2.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            For local9 = Each rooms
                                If (local9\Field7\Field10 = "checkpoint1") Then
                                    If (10.0 > local9\Field8) Then
                                        local10\Field2 = 2.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (5.0 <> curr096\Field9) Then
                                local10\Field2 = 2.0
                            EndIf
                            If (entitydistance(curr096\Field4, collider) < entitydistance(curr096\Field4, local10\Field1\Field2)) Then
                                local10\Field2 = 2.0
                            EndIf
                        EndIf
                        For local11 = Each events
                            If (local11\Field0 = "room2servers") Then
                                If (0.0 = local11\Field2) Then
                                    local10\Field2 = 2.0
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (playerroom = local10\Field1) Then
                            local10\Field2 = 2.0
                        EndIf
                    EndIf
                    If (0.0 = local10\Field2) Then
                        Select local10\Field1\Field7\Field10
                            Case "room4pit","room3pit","room3z2","room4tunnels","room3tunnel"
                                If (((local10\Field1\Field7\Field10 = "room4pit") Or (local10\Field1\Field7\Field10 = "room4tunnels")) <> 0) Then
                                    local123 = rand($00, $03)
                                Else
                                    local123 = rand($00, $02)
                                EndIf
                                If (local123 = $00) Then
                                    local121 = -608.0
                                    local122 = 0.0
                                ElseIf (local123 = $01) Then
                                    local121 = 0.0
                                    local122 = -608.0
                                ElseIf (local123 = $02) Then
                                    local121 = 608.0
                                    local122 = 0.0
                                Else
                                    local121 = 0.0
                                    local122 = 608.0
                                EndIf
                            Default
                                local121 = rnd(-100.0, 100.0)
                                local122 = rnd(-100.0, 100.0)
                        End Select
                        local3 = createpivot(local10\Field1\Field2)
                        positionentity(local3, local121, 0.0, local122, $00)
                        If (curr096 = Null) Then
                            curr096 = createnpc($06, entityx(local3, $01), (local10\Field1\Field4 + 0.5), entityz(local3, $01))
                        Else
                            positionentity(curr096\Field4, entityx(local3, $01), (local10\Field1\Field4 + 0.5), entityz(local3, $01), $00)
                            resetentity(curr096\Field4)
                        EndIf
                        pointentity(curr096\Field4, collider, 0.0)
                        rotateentity(curr096\Field4, 0.0, (entityyaw(curr096\Field4, $00) + 180.0), 0.0, $00)
                        freeentity(local3)
                        curr096\Field9 = 5.0
                        local10\Field2 = 1.0
                    ElseIf (1.0 = local10\Field2) Then
                        pointentity(curr096\Field4, collider, 0.0)
                        rotateentity(curr096\Field4, 0.0, (entityyaw(curr096\Field4, $00) + 180.0), 0.0, $00)
                        If ((hidedistance * 0.5) > entitydistance(curr096\Field4, collider)) Then
                            If (entityvisible(curr096\Field4, camera) <> 0) Then
                                pointentity(curr096\Field4, collider, 0.0)
                                rotateentity(curr096\Field4, 0.0, (entityyaw(curr096\Field4, $00) + rnd(170.0, 190.0)), 0.0, $00)
                                local10\Field2 = 2.0
                            EndIf
                        EndIf
                    ElseIf (3.0 = local10\Field2) Then
                        local10\Field2 = 2.0
                    EndIf
                ElseIf (2.0 = local10\Field2) Then
                    If (rand($FFFFFFFF, ((selecteddifficulty\Field3 Shl $01) + $01)) > $00) Then
                        local10\Field2 = 0.0
                    Else
                        local10\Field2 = 3.0
                    EndIf
                EndIf
            Case "medibay"
                If (playerroom <> local10\Field1) Then
                    hideentity(local10\Field1\Field19[$00])
                Else
                    showentity(local10\Field1\Field19[$00])
                    If (0.0 = local10\Field2) Then
                        local10\Field1\Field22[$00] = createnpc($01, entityx(local10\Field1\Field19[$03], $01), 0.5, entityz(local10\Field1\Field19[$03], $01))
                        rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 - $5A)), 0.0, $00)
                        local10\Field2 = 1.0
                    EndIf
                    If (1.2 > entitydistance(local10\Field1\Field22[$00]\Field4, collider)) Then
                        If (0.0 = local10\Field3) Then
                            lightblink = 12.0
                            playsound_strict(lightsfx)
                            local10\Field1\Field22[$00]\Field9 = 1.0
                            local10\Field3 = 1.0
                        EndIf
                    EndIf
                EndIf
                If (0.5 > entitydistance(local10\Field1\Field19[$04], collider)) Then
                    drawhandicon = $01
                    If (mousehit1 <> 0) Then
                        msg = scplang_getphrase("events.medibay")
                        msgtimer = 350.0
                        injuries = 0.0
                        bloodloss = 0.0
                        local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\Joke\Quack.ogg"))
                        local10\Field6 = playsound2(local10\Field9, camera, local10\Field1\Field19[$04], 10.0, 0.8)
                        giveachievement($35, $01)
                    EndIf
                EndIf
            Case "dimension1499"
                If (playerroom <> local10\Field1) Then
                    If (local10\Field1\Field19[$00] <> $00) Then
                        For local1 = $01 To $0F Step $01
                            hideentity(local10\Field1\Field19[local1])
                        Next
                    EndIf
                    If ((entityy(local10\Field1\Field2, $00) - 0.5) < entityy(collider, $00)) Then
                        playerroom = local10\Field1
                    EndIf
                EndIf
                If (2.0 = local10\Field2) Then
                    If (local10\Field6 <> $00) Then
                        stopstream_strict(local10\Field6)
                        stopchannel(local10\Field7)
                        local10\Field6 = $00
                        local10\Field7 = $00
                    EndIf
                    hideentity(i_1499\Field8)
                    hidechunks()
                    For local8 = Each npcs
                        If (local8\Field5 = $0F) Then
                            removenpc(local8)
                        EndIf
                    Next
                    For local125 = Each dummy1499
                        freeentity(local125\Field1)
                        Delete local125
                    Next
                    If (2100.0 > local10\Field4) Then
                        local10\Field4 = 0.0
                    EndIf
                    local10\Field2 = 1.0
                    If (local10\Field10 <> $00) Then
                        freesound_strict(local10\Field10)
                        local10\Field10 = $00
                    EndIf
                EndIf
            Case "room2offices035"
                local126 = $00
                For local11 = Each events
                    If (((local11 <> local10) And (local11\Field0 = "room035")) <> 0) Then
                        If (0.0 > local11\Field2) Then
                            local126 = $01
                            Exit
                        EndIf
                    EndIf
                Next
                If (local126 <> 0) Then
                    If (8.0 > local10\Field1\Field8) Then
                        If (local10\Field1\Field22[$00] = Null) Then
                            local10\Field1\Field22[$00] = createnpc($12, local10\Field1\Field3, 0.5, local10\Field1\Field5)
                            rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $B4)), 0.0, $00)
                            moveentity(local10\Field1\Field22[$00]\Field4, 0.0, 0.0, -0.5)
                            local10\Field1\Field22[$00]\Field9 = 3.0
                            local10\Field1\Field22[$00]\Field23 = scpmodding_processfilepath("GFX\npcs\scp_035_victim.png")
                            changenpctextureid(local10\Field1\Field22[$00], $06)
                            setnpcframe(local10\Field1\Field22[$00], 19.0)
                        EndIf
                        If (local10\Field1\Field22[$01] = Null) Then
                            If (2.5 > entitydistance(local10\Field1\Field22[$00]\Field4, collider)) Then
                                local10\Field1\Field22[$01] = createnpc($02, entityx(local10\Field1\Field22[$00]\Field4, $00), 0.13, entityz(local10\Field1\Field22[$00]\Field4, $00))
                                rotateentity(local10\Field1\Field22[$01]\Field4, 0.0, (Float local10\Field1\Field6), 0.0, $00)
                                moveentity(local10\Field1\Field22[$01]\Field4, 0.0, 0.0, 0.6)
                            EndIf
                        EndIf
                    ElseIf (hidedistance < local10\Field1\Field8) Then
                        If (local10\Field1\Field22[$01] <> Null) Then
                            If ((local10\Field1\Field22[$01]\Field48 = $01) = $00) Then
                                removenpc(local10\Field1\Field22[$01])
                                local10\Field1\Field22[$01] = Null
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room1archive"
                If (0.0 = local10\Field2) Then
                    local10\Field2 = (Float rand($03, $05))
                Else
                    local10\Field1\Field21[$00]\Field12 = (Int local10\Field2)
                EndIf
            Case "room2shaft"
                If (0.0 = local10\Field2) Then
                    local10\Field1\Field22[$00] = createnpc($13, entityx(local10\Field1\Field19[$01], $01), (entityy(local10\Field1\Field19[$01], $01) + 0.5), entityz(local10\Field1\Field19[$01], $01))
                    rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $B4)), 0.0, $01)
                    setnpcframe(local10\Field1\Field22[$00], 286.0)
                    local10\Field1\Field22[$00]\Field9 = 8.0
                    local10\Field2 = 1.0
                EndIf
                If (playerroom = local10\Field1) Then
                    updatebutton(local10\Field1\Field19[$02])
                    If (((closestbutton = local10\Field1\Field19[$02]) And mousehit1) <> 0) Then
                        msg = scplang_getphrase("events.elevatorbroken")
                        playsound2(buttonsfx2, camera, local10\Field1\Field19[$02], 10.0, 1.0)
                        msgtimer = 350.0
                        mousehit1 = $00
                    EndIf
                EndIf
            Case "room1lifts"
                If (playerroom = local10\Field1) Then
                    For local1 = $00 To $01 Step $01
                        updatebutton(local10\Field1\Field19[local1])
                        If (((closestbutton = local10\Field1\Field19[local1]) And mousehit1) <> 0) Then
                            msg = scplang_getphrase("events.elevatorbroken")
                            playsound2(buttonsfx2, camera, local10\Field1\Field19[local1], 10.0, 1.0)
                            msgtimer = 350.0
                            mousehit1 = $00
                        EndIf
                    Next
                EndIf
            Case "medibay2"
                If (playerroom <> local10\Field1) Then
                    hideentity(local10\Field1\Field19[$00])
                Else
                    showentity(local10\Field1\Field19[$00])
                    local0 = entitydistance(collider, local10\Field1\Field19[$04])
                    If (0.0 = local10\Field2) Then
                        local8 = createnpc($16, entityx(local10\Field1\Field19[$05], $01), entityy(local10\Field1\Field19[$05], $01), entityz(local10\Field1\Field19[$05], $01))
                        positionentity(local8\Field4, entityx(local10\Field1\Field19[$05], $01), (entityy(local10\Field1\Field19[$05], $01) + 0.4), entityz(local10\Field1\Field19[$05], $01), $01)
                        pointentity(local8\Field4, local10\Field1\Field2, 0.0)
                        local10\Field1\Field22[$00] = local8
                        turnentity(local8\Field4, 0.0, -20.0, 0.0, $00)
                        rotateentity(local8\Field4, 0.0, entityyaw(local8\Field4, $01), 0.0, $01)
                        local30 = createdecal($15, entityx(local10\Field1\Field19[$04], $01), (entityy(local10\Field1\Field19[$04], $01) + 0.01), entityz(local10\Field1\Field19[$04], $01), 90.0, (Float rand($168, $01)), 0.0)
                        local30\Field2 = 0.05
                        local30\Field1 = 0.001
                        entityalpha(local30\Field0, 0.8)
                        updatedecals()
                        local10\Field2 = 1.0
                    ElseIf (1.5 > local0) Then
                        If (0.0 = local10\Field3) Then
                            If (0.0 = local10\Field1\Field22[$00]\Field9) Then
                                local10\Field1\Field22[$00]\Field9 = 1.0
                                setnpcframe(local10\Field1\Field22[$00], 155.0)
                                local10\Field3 = 1.0
                                removeevent(local10)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room650"
                local0 = entitydistance(collider, local10\Field1\Field19[$00])
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field2) Then
                        curr650 = createnpc($1A, entityx(local10\Field1\Field19[$00], $01), 0.5, entityz(local10\Field1\Field19[$00], $01))
                        curr650\Field24 = 1.0
                        positionentity(curr650\Field4, entityx(local10\Field1\Field19[$00], $01), (entityy(local10\Field1\Field19[$00], $01) + 0.4), entityz(local10\Field1\Field19[$00], $01), $01)
                        turnentity(curr650\Field4, 0.0, (Float (local10\Field1\Field6 - $28)), 0.0, $00)
                        local10\Field2 = 1.0
                    Else
                        If (1.0 > local0) Then
                            curr650\Field24 = 0.0
                            removeevent(local10)
                        EndIf
                        If (((entityinview(curr650\Field0, camera) And entityvisible(curr650\Field0, camera)) And (1.0 = curr650\Field24)) <> 0) Then
                            shouldplay = $1B
                            giveachievement($32, $01)
                            heartbeatrate = max(heartbeatrate, 140.0)
                            heartbeatvolume = 1.0
                        EndIf
                    EndIf
                EndIf
            Case "room457"
                local18 = (Float updatelever(local10\Field1\Field20[$00], $00))
                If (playerroom = local10\Field1) Then
                    local10\Field5 = updateelevators(local10\Field5, local10\Field1\Field21[$00], local10\Field1\Field21[$02], local10\Field1\Field19[$05], local10\Field1\Field19[$07], local10, $01)
                    local10\Field4 = updateelevators(local10\Field4, local10\Field1\Field21[$01], local10\Field1\Field21[$03], local10\Field1\Field19[$06], local10\Field1\Field19[$08], local10, $01)
                    If ((-2400.0 * roomscale) > entityy(collider, $00)) Then
                        giveachievement($31, $01)
                        For local9 = Each rooms
                            hideentity(local9\Field2)
                        Next
                        showentity(local10\Field1\Field2)
                        If (((((0.0 = local18) And (local10\Field1\Field21[$04]\Field5 = $00)) And (local10\Field1\Field21[$05]\Field5 = $00)) And (local10\Field1\Field21[$06]\Field5 = $00)) <> 0) Then
                            usedoor(local10\Field1\Field21[$04], $01, $01)
                            usedoor(local10\Field1\Field21[$05], $01, $01)
                            usedoor(local10\Field1\Field21[$06], $01, $01)
                            playsound_strict(alarmsfx($04))
                        ElseIf (((((1.0 = local18) And (local10\Field1\Field21[$04]\Field5 = $01)) And (local10\Field1\Field21[$04]\Field5 = $01)) And (local10\Field1\Field21[$04]\Field5 = $01)) <> 0) Then
                            usedoor(local10\Field1\Field21[$04], $01, $01)
                            usedoor(local10\Field1\Field21[$05], $01, $01)
                            usedoor(local10\Field1\Field21[$06], $01, $01)
                            playsound_strict(alarmsfx($04))
                        EndIf
                        shouldplay = $1C
                        If (local10\Field1\Field22[$00] = Null) Then
                            If (quickloadpercent = $FFFFFFFF) Then
                                quickloadpercent = $00
                                quickload_currevent = local10
                            EndIf
                        Else
                            local0 = entitydistance(local10\Field1\Field19[$04], local10\Field1\Field22[$00]\Field4)
                            If (0.0 = local10\Field2) Then
                                local10\Field1\Field22[$00]\Field9 = 0.0
                                local10\Field2 = (Float rand($01, $05))
                            Else
                                local10\Field1\Field22[$00]\Field76 = local10\Field1\Field19[(Int (local10\Field2 - 1.0))]
                            EndIf
                            If (local10\Field1\Field22[$00]\Field37 <> $01) Then
                                local10\Field2 = (Float rand($01, $05))
                            EndIf
                            If (((((3.3 > local0) And (local10\Field1\Field21[$04]\Field5 = $00)) And (local10\Field1\Field21[$05]\Field5 = $00)) And (local10\Field1\Field21[$06]\Field5 = $00)) <> 0) Then
                                contained457 = $01
                            Else
                                contained457 = $00
                            EndIf
                            If (0.0 = local10\Field1\Field22[$00]\Field9) Then
                                If (0.7 > entitydistance(local10\Field1\Field22[$00]\Field4, local10\Field1\Field21[$07]\Field0)) Then
                                    local10\Field1\Field21[$07]\Field5 = $01
                                Else
                                    local10\Field1\Field21[$07]\Field5 = $00
                                EndIf
                            EndIf
                        EndIf
                    Else
                        local10\Field2 = 0.0
                        If (local10\Field1\Field22[$00] <> Null) Then
                            local10\Field1\Field22[$00]\Field9 = 3.0
                        EndIf
                    EndIf
                ElseIf (local10\Field1\Field22[$00] <> Null) Then
                    local10\Field1\Field22[$00]\Field9 = 3.0
                EndIf
            Case "room4info"
                If (0.0 = local10\Field2) Then
                    local10\Field1\Field22[$00] = createnpc($11, entityx(local10\Field1\Field19[$00], $01), entityy(local10\Field1\Field19[$00], $01), entityz(local10\Field1\Field19[$00], $01))
                    rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $10E)), 0.0, $00)
                    local10\Field1\Field22[$00]\Field9 = 3.0
                    setnpcframe(local10\Field1\Field22[$00], 40.0)
                    local10\Field1\Field22[$00]\Field48 = $01
                    local73 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\body_c.png"), $01)
                    entitytexture(local10\Field1\Field22[$00]\Field0, local73, $00, $00)
                    freetexture(local73)
                    local10\Field2 = 1.0
                Else
                    local10\Field6 = loopsound2(scientistradiosfx(rand($00, $01)), local10\Field6, camera, local10\Field1\Field19[$02], 4.0, 0.5)
                EndIf
            Case "room009"
                If (playerroom = local10\Field1) Then
                    giveachievement($26, $01)
                    If (0.0 = local10\Field5) Then
                        If (((local10\Field15 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field15 = "load0"
                        EndIf
                    ElseIf (1.0 = local10\Field5) Then
                        local10\Field6 = loopsound2(alarmsfx($00), local10\Field6, camera, local10\Field1\Field19[$01], 8.0, 2.0)
                        If (0.0 = local10\Field4) Then
                            If (((-1.4 >= entityy(collider, $00)) And (wearinghazmat = $00)) <> 0) Then
                                local10\Field2 = (local10\Field2 + local23\Field3[$00])
                            Else
                                local10\Field2 = max((local10\Field2 - (local23\Field3[$00] * 0.5)), 0.0)
                            EndIf
                        EndIf
                        If (((300.0 <= local10\Field2) And (0.0 = local10\Field4)) <> 0) Then
                            local10\Field4 = 1.0
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\294\burn.ogg")))
                            If (rand($02, $01) = $01) Then
                                msg = scplang_getphrase("events.room0091")
                            Else
                                msg = scplang_getphrase("events.room0092")
                            EndIf
                            msgtimer = 350.0
                            camerashake = 5.0
                        EndIf
                        If (3.0 < local10\Field3) Then
                            local10\Field3 = max((local10\Field3 - local23\Field3[$00]), 3.0)
                        Else
                            local10\Field3 = (local10\Field3 - local23\Field3[$00])
                        EndIf
                    EndIf
                    If (300.0 <= local10\Field2) Then
                        local10\Field2 = (local10\Field2 + local23\Field3[$00])
                        injuries = max(injuries, ((local10\Field2 - 300.0) / 1000.0))
                        If (4300.0 > local10\Field2) Then
                            heartbeatvolume = min(1.0, ((local10\Field2 - 300.0) / 4000.0))
                        Else
                            heartbeatvolume = 0.0
                            blinktimer = 3.0
                        EndIf
                    EndIf
                    If (((4290.0 <= local10\Field2) And (1.0 = local10\Field4)) <> 0) Then
                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\009\IceCracking.ogg")))
                        local10\Field4 = 2.0
                    EndIf
                    If (((4300.0 <= local10\Field2) And (2.0 <= local10\Field4)) <> 0) Then
                        playable = $00
                        local127 = $00
                        showentity(at\Field4[$09])
                        entityalpha(at\Field4[$09], min(0.1, ((local10\Field2 - 4300.0) / 400.0)))
                        blurtimer = 4.0
                        If (4350.0 <= local10\Field2) Then
                            blinktimer = max(-10.0, ((4350.0 - local10\Field2) / 20.0))
                        EndIf
                    Else
                        hideentity(at\Field4[$09])
                    EndIf
                    If (((4502.0 <= local10\Field2) And (2.0 = local10\Field4)) <> 0) Then
                        If (playerroom = local10\Field1) Then
                            deathmsg = scplang_getphrase("events.room0093")
                        ElseIf (128.0 > entitydistance(collider, local10\Field1\Field2)) Then
                            deathmsg = scplang_getphrase("events.room0094")
                        Else
                            deathmsg = scplang_getphrase("events.room0095")
                        EndIf
                        kill($00, $00)
                        local10\Field4 = 3.0
                    EndIf
                EndIf
            Case "room096"
                If (0.0 = local10\Field2) Then
                    If (playerroom = local10\Field1) Then
                        If (((curr096 = Null) And remotedooron) <> 0) Then
                            local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Door\DoorClose079.ogg"))
                            local10\Field6 = playsound2(local10\Field9, camera, local10\Field1\Field21[$00]\Field0, 30.0, 0.5)
                            local10\Field1\Field21[$00]\Field5 = $00
                            local10\Field1\Field21[$00]\Field4 = $01
                            local10\Field10 = loadsound_strict(scpmodding_processfilepath("SFX\Room\096Chamber\096ChamberEvent.ogg"))
                            local10\Field7 = playsound2(local10\Field10, camera, local10\Field1\Field19[$03], 30.0, 1.5)
                            local12 = createitem("Level 2 Key Card", "key2", entityx(local10\Field1\Field19[$02], $01), entityy(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01), $00, $00, $00, 1.0, $00)
                            entitytype(local12\Field1, $03, $00)
                            local12 = createitem("Unknown Document", "paper", entityx(local10\Field1\Field19[$04], $01), entityy(local10\Field1\Field19[$04], $01), entityz(local10\Field1\Field19[$04], $01), $00, $00, $00, 1.0, $00)
                            entitytype(local12\Field1, $03, $00)
                            giveachievement($06, $01)
                            local10\Field2 = 1.0
                        Else
                            removeevent(local10)
                        EndIf
                    EndIf
                ElseIf (2380.0 > local10\Field2) Then
                    If (((1.0 < local10\Field2) And (2240.0 > local10\Field2)) <> 0) Then
                        If (((rand($C8, $01) < $05) And (playerroom = local10\Field1)) <> 0) Then
                            lightblink = rnd(3.0, 6.0)
                        EndIf
                    EndIf
                    local10\Field2 = min((local10\Field2 + local23\Field3[$00]), 2310.0)
                    If (((1470.0 < local10\Field2) And (1540.0 > local10\Field2)) <> 0) Then
                        If (0.0 = local10\Field5) Then
                            local30 = createdecal($11, entityx(local10\Field1\Field19[$01], $01), entityy(local10\Field1\Field19[$01], $01), entityz(local10\Field1\Field19[$01], $01), 90.0, (Float (local10\Field1\Field6 + $168)), 0.0)
                            local30\Field2 = 0.05
                            local30\Field1 = 0.001
                            entityalpha(local30\Field0, 0.6)
                            updatedecals()
                            local10\Field5 = 1.0
                        EndIf
                    ElseIf ((((2240.0 < local10\Field2) And (2310.0 > local10\Field2)) And (0.0 = local10\Field3)) <> 0) Then
                        local10\Field1\Field21[$00]\Field4 = $00
                        local10\Field3 = 1.0
                    EndIf
                    If (playerroom = local10\Field1) Then
                        If (curr096 = Null) Then
                            If (1.0 = local10\Field3) Then
                                If (0.0 = local10\Field4) Then
                                    local10\Field4 = 1.0
                                Else
                                    local10\Field11 = loadsound_strict(scpmodding_processfilepath("SFX\Music\096.ogg"))
                                    local10\Field8 = loopsound2(local10\Field11, local10\Field8, camera, local10\Field1\Field19[$03], 4.0, 1.0)
                                EndIf
                            EndIf
                        Else
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room409"
                If (playerroom = local10\Field1) Then
                    If ((-4000.0 * roomscale) > entityy(collider, $00)) Then
                        For local9 = Each rooms
                            hideentity(local9\Field2)
                        Next
                        showentity(local10\Field1\Field2)
                        shouldplay = $1D
                        If (0.0 = local10\Field2) Then
                            If (((local10\Field15 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                                quickloadpercent = $00
                                quickload_currevent = local10
                                local10\Field15 = "load0"
                            EndIf
                        ElseIf (1.0 = local10\Field2) Then
                            If (local10\Field1\Field21[$02]\Field5 = $01) Then
                                giveachievement($2F, $01)
                            EndIf
                            local0 = entitydistance(collider, local10\Field1\Field22[$00]\Field4)
                            If (((1.0 > local0) And (1.0 > i_409\Field0)) <> 0) Then
                                i_409\Field0 = 1.0
                            EndIf
                            If (0.6 > entitydistance(local10\Field1\Field19[$04], collider)) Then
                                If (1.0 > i_409\Field0) Then
                                    drawhandicon = $01
                                    If (mousehit1 <> 0) Then
                                        msg = scplang_getphrase("events.room409")
                                        msgtimer = 420.0
                                        blurtimer = 2000.0
                                        i_409\Field0 = (i_409\Field0 + 1.0)
                                        giveachievement($2F, $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    local10\Field3 = updateelevators(local10\Field3, local10\Field1\Field21[$00], local10\Field1\Field21[$01], local10\Field1\Field19[$01], local10\Field1\Field19[$03], local10, $01)
                EndIf
            Case "room005"
                If (contained106 = $00) Then
                    If (playerroom = local10\Field1) Then
                        local128 = entitydistance(collider, local10\Field1\Field19[$00])
                        If (1.5 > local128) Then
                            If (((0.0 = local10\Field2) And ((chancetospawn005 = $02) = $00)) <> 0) Then
                                playsound_strict(horrorsfx($0A))
                                local72 = createdecal($00, entityx(local10\Field1\Field19[$01], $01), entityy(local10\Field1\Field19[$01], $01), entityz(local10\Field1\Field19[$01], $01), 0.0, (Float (local10\Field1\Field6 + $168)), (Float rand($168, $01)))
                                local72\Field2 = 0.1
                                local72\Field1 = 0.003
                                local72\Field5 = 0.01
                                local72\Field4 = 0.005
                                local72\Field8 = $01
                                scalesprite(local72\Field0, local72\Field2, local72\Field2)
                                positionentity(curr106\Field4, entityx(local10\Field1\Field19[$02], $01), entityy(local10\Field1\Field19[$02], $01), entityz(local10\Field1\Field19[$02], $01), $00)
                                curr106\Field9 = -11.0
                                local10\Field2 = 1.0
                                showentity(curr106\Field0)
                            Else
                                removeevent(local10)
                            EndIf
                        EndIf
                    EndIf
                Else
                    removeevent(local10)
                EndIf
            Case "room3scps"
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field2) Then
                        If (local10\Field1\Field21[$00]\Field5 = $01) Then
                            If (180.0 = local10\Field1\Field21[$00]\Field7) Then
                                local10\Field2 = 1.0
                            EndIf
                        ElseIf (((1.0 > entitydistance(collider, local10\Field1\Field21[$00]\Field0)) And remotedooron) <> 0) Then
                            blurtimer = 1000.0
                            local10\Field1\Field21[$00]\Field5 = $01
                            playsound_strict(horrorsfx($0A))
                            local10\Field1\Field22[$00] = createnpc($12, entityx(local10\Field1\Field19[$00], $01), 0.5, entityz(local10\Field1\Field19[$00], $01))
                            rotateentity(local10\Field1\Field22[$00]\Field4, 0.0, (Float (local10\Field1\Field6 + $168)), 0.0, $00)
                            local10\Field1\Field22[$00]\Field48 = $01
                            changenpctextureid(local10\Field1\Field22[$00], $0F)
                            setnpcframe(local10\Field1\Field22[$00], 40.0)
                            local10\Field1\Field22[$00]\Field9 = 3.0
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case "room066"
                If (playerroom = local10\Field1) Then
                    If (0.0 = local10\Field2) Then
                        If (curr066 = Null) Then
                            curr066 = createnpc($05, entityx(local10\Field1\Field19[$01], $01), entityy(local10\Field1\Field19[$01], $01), entityz(local10\Field1\Field19[$01], $01))
                        Else
                            positionentity(curr066\Field4, entityx(local10\Field1\Field19[$01], $01), entityy(local10\Field1\Field19[$01], $01), entityz(local10\Field1\Field19[$01], $01), $00)
                        EndIf
                        resetentity(curr066\Field4)
                        local10\Field2 = 1.0
                    Else
                        If (65.0 > local10\Field2) Then
                            local10\Field2 = max(local10\Field2, 65.0)
                            local10\Field1\Field21[$00]\Field5 = $00
                        EndIf
                        If (7.0 < local10\Field2) Then
                            If (rand($00, $6E) = $01) Then
                                local10\Field1\Field21[$00]\Field5 = (local10\Field1\Field21[$00]\Field5 = $00)
                                If (local10\Field9 = $00) Then
                                    local10\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\Door\DoorSparks.ogg"))
                                EndIf
                                local10\Field6 = playsound2(local10\Field9, camera, local10\Field1\Field19[$00], 3.0, 1.0)
                                local3 = createpivot($00)
                                local114 = local10\Field1\Field19[$00]
                                positionentity(local3, entityx(local114, $01), entityy(local114, $01), entityz(local114, $01), $00)
                                rotateentity(local3, 90.0, (entityyaw(local114, $01) + 90.0), 0.0, $00)
                                If (particleamount > $00) Then
                                    For local1 = $00 To (((particleamount - $01) Shl $01) + $01) Step $01
                                        local7 = createparticle(entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $07, 0.002, 0.0, $19)
                                        local7\Field8 = rnd(0.01, 0.05)
                                        rotateentity(local7\Field1, rnd(-20.0, 0.0), (entityyaw(local3, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                                        local7\Field7 = 0.0075
                                        scalesprite(local7\Field0, local7\Field7, local7\Field7)
                                        local7\Field14 = -0.05
                                    Next
                                EndIf
                                freeentity(local3)
                            EndIf
                        EndIf
                    EndIf
                EndIf
        End Select
    Next
    If (0.0 < explosiontimer) Then
        explosiontimer = (local23\Field3[$00] + explosiontimer)
        If (140.0 > explosiontimer) Then
            If (5.0 > (explosiontimer - local23\Field3[$00])) Then
                explosionsfx = loadsound_strict(scpmodding_processfilepath("SFX\Ending\GateB\Nuke1.ogg"))
                playsound_strict(explosionsfx)
                camerashake = 10.0
                explosiontimer = 5.0
            EndIf
            camerashake = curvevalue((explosiontimer / 60.0), camerashake, 50.0)
        Else
            camerashake = min((explosiontimer / 20.0), 20.0)
            If (140.0 > (explosiontimer - local23\Field3[$00])) Then
                blinktimer = 1.0
                explosionsfx = loadsound_strict(scpmodding_processfilepath("SFX\Ending\GateB\Nuke2.ogg"))
                playsound_strict(explosionsfx)
                For local1 = $00 To (((particleamount + $01) * $0A) + $0A) Step $01
                    local7 = createparticle((entityx(collider, $00) + rnd(-0.5, 0.5)), (entityy(collider, $00) - rnd(0.2, 1.5)), (entityz(collider, $00) + rnd(-0.5, 0.5)), $00, rnd(0.2, 0.6), 0.0, $15E)
                    rotateentity(local7\Field1, -90.0, 0.0, 0.0, $01)
                    local7\Field8 = rnd(0.05, 0.07)
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
