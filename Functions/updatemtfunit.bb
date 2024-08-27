Function updatemtfunit%(arg0.npcs)
    Local local0.fps_settings
    Local local1$
    Local local3#
    Local local4#
    Local local5#
    Local local6.rooms
    Local local7#
    Local local8#
    Local local9.npcs
    Local local10.particles
    Local local11%
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22#
    Local local23%
    Local local24#
    Local local25%
    Local local26.waypoints
    Local local27#
    Local local28#
    local0 = (First fps_settings)
    If (arg0\Field5 <> $14) Then
        local1 = ""
        Select arg0\Field5
            Case $08
                local1 = "173"
            Case $07
                local1 = "106"
            Case $13
                local1 = "guard"
            Case $12
                local1 = "d"
            Case $09
                local1 = "372"
            Case $10
                local1 = "apache"
            Case $06
                local1 = "096"
            Case $03
                local1 = "049"
            Case $04
                local1 = "049-2"
            Case $0A
                local1 = "513-1"
            Case $02
                local1 = "035-Tentacle"
            Case $0B
                local1 = "860-2"
            Case $0C
                local1 = "939"
            Case $05
                local1 = "066"
            Case $15
                local1 = "PDPlane"
            Case $0D
                local1 = "966"
            Case $0E
                local1 = "1048-A"
            Case $0F
                local1 = "1499-1"
            Case $1A
                local1 = "650"
            Case $19
                local1 = "457"
            Case $17
                local1 = "049-3"
            Case $16
                local1 = "008-2"
            Case $18
                local1 = "178-1"
            Case $1B
                local1 = "CI"
            Case $1C
                local1 = "MTF2"
            Case $1D
                local1 = "Vehicle"
        End Select
        runtimeerror(("Called UpdateMTFUnit on " + local1))
    EndIf
    If (arg0\Field48 <> 0) Then
        arg0\Field49 = -1.0
        setnpcframe(arg0, 532.0)
        If (channelplaying(arg0\Field20) <> 0) Then
            stopchannel(arg0\Field20)
        EndIf
        Return $00
    EndIf
    arg0\Field45 = 0.03
    arg0\Field49 = (arg0\Field49 - local0\Field3[$00])
    If (-5.0 >= arg0\Field49) Then
        If (2.0 = arg0\Field9) Then
            If ((othernpcseesmenpc(curr173, arg0) Or (3.0 > entitydistance(arg0\Field4, curr173\Field4))) <> 0) Then
                playmtfsound(loadtempsound(scpmodding_processfilepath("SFX\Character\MTF\173\BLINKING.ogg")), arg0)
            EndIf
        EndIf
        arg0\Field49 = (rnd(10.0, 15.0) * 70.0)
    EndIf
    arg0\Field25 = (arg0\Field25 - local0\Field3[$00])
    local15 = arg0\Field14
    arg0\Field53 = ""
    arg0\Field51 = $00
    arg0\Field52 = $00
    arg0\Field57 = "MTF"
    If ((Int arg0\Field9) <> $01) Then
        arg0\Field12 = $00
    EndIf
    arg0\Field20 = loopsound2(mtfsfx($06), arg0\Field20, camera, arg0\Field4, 10.0, 1.0)
    If (0.0 < arg0\Field24) Then
        finishwalking(arg0, 488.0, 522.0, 0.39)
        arg0\Field24 = (arg0\Field24 - local0\Field3[$00])
        If (0.0 >= arg0\Field24) Then
            arg0\Field24 = 0.0
        EndIf
    Else
        Select (Int arg0\Field9)
            Case $00
                arg0\Field21 = 0.015
                If (0.0 >= arg0\Field38) Then
                    If (arg0\Field47 <> Null) Then
                        arg0\Field37 = findpath(arg0, entityx(arg0\Field47\Field4, $01), (entityy(arg0\Field47\Field4, $01) + 0.1), entityz(arg0\Field47\Field4, $01))
                    Else
                        If (2.0 <> curr173\Field24) Then
                            For local6 = Each rooms
                                If ((((12.0 < (Abs (local6\Field3 - entityx(arg0\Field4, $01)))) Or (12.0 < (Abs (local6\Field5 - entityz(arg0\Field4, $01))))) And (rand($01, (Int max((Float ($04 - (Int (Abs (local6\Field5 - (entityz(arg0\Field4, $01) / 8.0)))))), 2.0))) = $01)) <> 0) Then
                                    local3 = local6\Field3
                                    local4 = 0.1
                                    local5 = local6\Field5
                                    Exit
                                EndIf
                            Next
                        Else
                            local17 = $00
                            If (4.0 < entitydistance(arg0\Field4, curr173\Field4)) Then
                                If (entityvisible(arg0\Field4, curr173\Field4) = $00) Then
                                    local17 = $01
                                EndIf
                            EndIf
                            If (local17 = $00) Then
                                For local6 = Each rooms
                                    If (local6\Field7\Field10 = "room173") Then
                                        local18 = $00
                                        local19 = createpivot($00)
                                        positionentity(local19, (entityx(local6\Field2, $01) + (4736.0 * roomscale)), 0.5, (entityz(local6\Field2, $01) + (1692.0 * roomscale)), $00)
                                        If (3.5 > distance(entityx(local19, $00), entityz(local19, $00), entityx(arg0\Field4, $00), entityz(arg0\Field4, $00))) Then
                                            local18 = $01
                                        EndIf
                                        If (((3.0 = curr173\Field24) And (4.0 < distance(entityx(local19, $00), entityz(local19, $00), entityx(arg0\Field4, $00), entityz(arg0\Field4, $00)))) <> 0) Then
                                            If (local6\Field21[$01]\Field5 = $01) Then
                                                usedoor(local6\Field21[$01], $00, $01)
                                            EndIf
                                        EndIf
                                        freeentity(local19)
                                        If (((1.6 < distance(entityx(arg0\Field4, $00), entityz(arg0\Field4, $00), (entityx(local6\Field2, $01) + (4736.0 * roomscale)), (entityz(local6\Field2, $01) + (1692.0 * roomscale)))) And (local18 = $00)) <> 0) Then
                                            local3 = (entityx(local6\Field2, $01) + (4736.0 * roomscale))
                                            local4 = 0.1
                                            local5 = (entityz(local6\Field2, $01) + (1692.0 * roomscale))
                                            Exit
                                        ElseIf (((1.6 < distance(entityx(arg0\Field4, $00), entityz(arg0\Field4, $00), (entityx(local6\Field2, $01) + (4736.0 * roomscale)), (entityz(local6\Field2, $01) + (1692.0 * roomscale)))) And local18) <> 0) Then
                                            arg0\Field62 = (entityx(local6\Field2, $01) + (4736.0 * roomscale))
                                            arg0\Field63 = (entityz(local6\Field2, $01) + (1692.0 * roomscale))
                                            Exit
                                        Else
                                            curr173\Field24 = 3.0
                                            curr173\Field31 = Null
                                            curr173\Field48 = $01
                                            If (arg0\Field16 <> $00) Then
                                                freesound_strict(arg0\Field16)
                                                arg0\Field16 = $00
                                            EndIf
                                            arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\173\Cont" + (Str rand($01, $04))) + ".ogg")))
                                            playmtfsound(arg0\Field16, arg0)
                                            playannouncement(scpmodding_processfilepath("SFX\Character\MTF\Announc173Contain.ogg"))
                                            local6\Field21[$01]\Field24 = $01
                                            usedoor(local6\Field21[$01], $00, $01)
                                            local6\Field21[$01]\Field5 = $00
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            Else
                                local3 = entityx(curr173\Field4, $00)
                                local4 = 0.1
                                local5 = entityz(curr173\Field4, $00)
                            EndIf
                        EndIf
                        If (0.0 = arg0\Field62) Then
                            arg0\Field37 = findpath(arg0, local3, local4, local5)
                        EndIf
                    EndIf
                    If (arg0\Field37 = $01) Then
                        While (arg0\Field36[arg0\Field39] = Null)
                            If (arg0\Field39 > $13) Then
                                Exit
                            EndIf
                            arg0\Field39 = (arg0\Field39 + $01)
                        Wend
                        If (arg0\Field39 < $13) Then
                            If (((arg0\Field36[arg0\Field39] <> Null) And (arg0\Field36[(arg0\Field39 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field4, arg0\Field36[(arg0\Field39 + $01)]\Field0)) < (Abs deltayaw(arg0\Field4, arg0\Field36[arg0\Field39]\Field0))) Then
                                        arg0\Field39 = (arg0\Field39 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                ElseIf (((175.0 >= arg0\Field38) And (arg0\Field47 = Null)) <> 0) Then
                    arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                    arg0\Field22 = 0.0
                    If (rand($01, $23) = $01) Then
                        rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                    EndIf
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                ElseIf (arg0\Field37 = $02) Then
                    arg0\Field38 = (arg0\Field38 - (local0\Field3[$00] * 2.0))
                    arg0\Field22 = 0.0
                    If (rand($01, $23) = $01) Then
                        rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                    EndIf
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                ElseIf (arg0\Field37 = $01) Then
                    If (arg0\Field36[arg0\Field39] = Null) Then
                        If (arg0\Field39 > $13) Then
                            arg0\Field39 = $00
                            arg0\Field37 = $00
                        Else
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    Else
                        local7 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        local8 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        If (((1.0 > local8) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                            If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                local20 = $00
                                If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                    local20 = $00
                                Else
                                    local20 = rand($00, $02)
                                EndIf
                                playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local20), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                playmtfsound(mtfsfx($05), arg0)
                            EndIf
                            arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                            If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                            EndIf
                        EndIf
                        If (((0.2 > local8) Or ((local8 > local7) And (1.0 > local7))) <> 0) Then
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    EndIf
                    arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                ElseIf (0.0 <> arg0\Field62) Then
                    local19 = createpivot($00)
                    positionentity(local19, arg0\Field62, 0.5, arg0\Field63, $00)
                    pointentity(arg0\Field4, local19, 0.0)
                    rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                    arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                    translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                    animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                    If (0.2 > distance(entityx(arg0\Field4, $00), entityz(arg0\Field4, $00), arg0\Field62, arg0\Field63)) Then
                        arg0\Field62 = 0.0
                        arg0\Field63 = 0.0
                        arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                    EndIf
                    freeentity(local19)
                Else
                    arg0\Field38 = (arg0\Field38 - (local0\Field3[$00] * 2.0))
                    If (arg0\Field47 = Null) Then
                        If (rand($01, $23) = $01) Then
                            rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field22 = 0.0
                    ElseIf (1.0 < entitydistance(arg0\Field4, arg0\Field47\Field4)) Then
                        pointentity(arg0\Field4, arg0\Field47\Field4, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                    Else
                        If (rand($01, $23) = $01) Then
                            rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field22 = 0.0
                    EndIf
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                EndIf
                local21 = menpcseesplayer(arg0, $00)
                If (chs\Field2 <> 0) Then
                    local21 = $00
                EndIf
                If (local21 > $00) Then
                    If (((arg0\Field26 > $00) And (arg0\Field26 < $41A)) <> 0) Then
                        If (local21 < $02) Then
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\ThereHeIs" + (Str rand($01, $06))) + ".ogg")))
                            playmtfsound(arg0\Field16, arg0)
                        EndIf
                    ElseIf (local21 = $01) Then
                        If (arg0\Field16 <> $00) Then
                            freesound_strict(arg0\Field16)
                            arg0\Field16 = $00
                        EndIf
                        arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\Stop" + (Str rand($01, $06))) + ".ogg")))
                        playmtfsound(arg0\Field16, arg0)
                    ElseIf (local21 = $02) Then
                        playmtfsound(mtfsfx(rand($00, $03)), arg0)
                    EndIf
                    arg0\Field26 = (Int (rnd(30.0, 40.0) * 70.0))
                    arg0\Field27 = 1.0
                    arg0\Field9 = 1.0
                    arg0\Field33 = entityx(collider, $01)
                    arg0\Field34 = entityy(collider, $01)
                    arg0\Field35 = entityz(collider, $01)
                    arg0\Field10 = ((15.0 * (Float local21)) * 70.0)
                    arg0\Field38 = 0.0
                    arg0\Field37 = $00
                    arg0\Field25 = (Float ($C8 - (selecteddifficulty\Field3 * $64)))
                EndIf
                If (2.0 > curr173\Field24) Then
                    local22 = max(min((distance(entityx(curr173\Field4, $00), entityz(curr173\Field4, $00), curr173\Field28, curr173\Field30) * 2.5), 1.0), 0.0)
                    If ((othernpcseesmenpc(curr173, arg0) Or ((0.0 < local22) And (6.0 > entitydistance(arg0\Field4, curr173\Field4)))) <> 0) Then
                        If ((entityvisible(arg0\Field4, curr173\Field4) Or (0.0 < local22)) <> 0) Then
                            arg0\Field9 = 2.0
                            arg0\Field33 = entityx(curr173\Field4, $01)
                            arg0\Field34 = entityy(curr173\Field4, $01)
                            arg0\Field35 = entityz(curr173\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\173\Spotted" + (Str rand($01, $02))) + ".ogg")))
                            playmtfsound(arg0\Field16, arg0)
                        EndIf
                    EndIf
                EndIf
                If (0.0 >= curr106\Field9) Then
                    If ((othernpcseesmenpc(curr106, arg0) Or (3.0 > entitydistance(arg0\Field4, curr106\Field4))) <> 0) Then
                        If (entityvisible(arg0\Field4, curr106\Field4) <> 0) Then
                            arg0\Field9 = 4.0
                            arg0\Field33 = entityx(curr106\Field4, $01)
                            arg0\Field34 = entityy(curr106\Field4, $01)
                            arg0\Field35 = entityz(curr106\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            arg0\Field31 = curr106
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\106\Spotted" + (Str rand($01, $04))) + ".ogg")))
                            playmtfsound(arg0\Field16, arg0)
                        EndIf
                    EndIf
                EndIf
                If (curr096 <> Null) Then
                    If (othernpcseesmenpc(curr096, arg0) <> 0) Then
                        If (entityvisible(arg0\Field4, curr096\Field4) <> 0) Then
                            arg0\Field9 = 8.0
                            arg0\Field33 = entityx(curr096\Field4, $01)
                            arg0\Field34 = entityy(curr096\Field4, $01)
                            arg0\Field35 = entityz(curr096\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\096\Spotted" + (Str rand($01, $02))) + ".ogg")))
                            playmtfsound(arg0\Field16, arg0)
                        EndIf
                    EndIf
                EndIf
                For local9 = Each npcs
                    If (local9\Field5 = $03) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 4.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\049\Spotted" + (Str rand($01, $05))) + ".ogg")))
                                playmtfsound(arg0\Field16, arg0)
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $04) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\049\Player0492_1.ogg"))
                                playmtfsound(arg0\Field16, arg0)
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $01) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $17) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $16) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $02) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            Case $01
                local14 = entitydistance(collider, arg0\Field4)
                arg0\Field21 = 0.015
                arg0\Field10 = (arg0\Field10 - local0\Field3[$00])
                If (menpcseesplayer(arg0, $00) = $01) Then
                    If (5.2 > (Float local23)) Then
                        local24 = vectoryaw((entityx(collider, $00) - entityx(arg0\Field4, $00)), 0.0, (entityz(collider, $00) - entityz(arg0\Field4, $00)))
                        rotateentity(arg0\Field4, 0.0, curveangle(local24, entityyaw(arg0\Field4, $00), 10.0), 0.0, $01)
                        arg0\Field15 = entityyaw(arg0\Field4, $00)
                        If (((0.0 >= arg0\Field25) And (0.0 = killtimer)) <> 0) Then
                            If (entityvisible(arg0\Field4, camera) <> 0) Then
                                local24 = wrapangle((local24 - entityyaw(arg0\Field4, $00)))
                                If (((5.0 > local24) Or (355.0 < local24)) <> 0) Then
                                    local25 = (Int killtimer)
                                    playsound2(gunshotsfx, camera, arg0\Field4, 15.0, 1.0)
                                    local19 = createpivot($00)
                                    rotateentity(local19, entitypitch(arg0\Field4, $00), entityyaw(arg0\Field4, $00), 0.0, $01)
                                    positionentity(local19, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                                    moveentity(local19, 0.0632, 0.84925, 0.5451)
                                    shoot(entityx(local19, $00), entityy(local19, $00), entityz(local19, $00), ((25.0 / local14) * (1.0 / local14)), $01, $00)
                                    arg0\Field25 = 7.0
                                    freeentity(local19)
                                    deathmsg = scplang_getphrase("events.ntf1")
                                    If (((local25 >= $00) And (0.0 > killtimer)) <> 0) Then
                                        deathmsg = scplang_getphrase("events.ntf2")
                                        playmtfsound(loadtempsound(scpmodding_processfilepath((("SFX\Character\MTF\Targetterminated" + (Str rand($01, $04))) + ".ogg"))), arg0)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        For local9 = Each npcs
                            If (((local9\Field5 = $14) And (local9 <> arg0)) <> 0) Then
                                If (0.0 = local9\Field9) Then
                                    If (6.0 > entitydistance(arg0\Field4, local9\Field4)) Then
                                        arg0\Field12 = $01
                                        local9\Field26 = (Int (rnd(30.0, 40.0) * 70.0))
                                        local9\Field27 = 1.0
                                        local9\Field9 = 1.0
                                        local9\Field33 = entityx(collider, $01)
                                        local9\Field34 = entityy(collider, $01)
                                        local9\Field35 = entityz(collider, $01)
                                        local9\Field10 = arg0\Field10
                                        local9\Field38 = 0.0
                                        local9\Field37 = $00
                                        local9\Field25 = (Float ($C8 - (selecteddifficulty\Field3 * $64)))
                                        local9\Field12 = $00
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If (arg0\Field12 = $01) Then
                            setnpcframe(arg0, 423.0)
                            arg0\Field12 = $02
                        ElseIf (arg0\Field12 = $02) Then
                            If (200.0 < arg0\Field14) Then
                                arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                                animatenpc(arg0, 423.0, 463.0, 0.4, $00)
                                If (462.9 < arg0\Field14) Then
                                    arg0\Field14 = 78.0
                                EndIf
                            Else
                                animatenpc(arg0, 78.0, 193.0, 0.2, $00)
                                arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                            EndIf
                        ElseIf (958.0 < arg0\Field14) Then
                            animatenpc(arg0, 1374.0, 1383.0, 0.3, $00)
                            arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                            If (1382.9 < arg0\Field14) Then
                                arg0\Field14 = 78.0
                            EndIf
                        Else
                            animatenpc(arg0, 78.0, 193.0, 0.2, $00)
                            arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                        EndIf
                    Else
                        positionentity(arg0\Field0, arg0\Field33, arg0\Field34, arg0\Field35, $01)
                        pointentity(arg0\Field4, arg0\Field0, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                    EndIf
                Else
                    arg0\Field26 = (Int ((Float arg0\Field26) - local0\Field3[$00]))
                    If (7.0 >= arg0\Field25) Then
                        arg0\Field25 = 7.0
                    EndIf
                    If (0.0 >= arg0\Field38) Then
                        arg0\Field37 = findpath(arg0, arg0\Field33, (arg0\Field34 + 0.1), arg0\Field35)
                        arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                    ElseIf (175.0 >= arg0\Field38) Then
                        arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                        arg0\Field22 = 0.0
                        If (rand($01, $23) = $01) Then
                            rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                    ElseIf (arg0\Field37 = $02) Then
                        arg0\Field38 = (arg0\Field38 - (local0\Field3[$00] * 2.0))
                        arg0\Field22 = 0.0
                        If (rand($01, $23) = $01) Then
                            rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                        EndIf
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                    ElseIf (arg0\Field37 = $01) Then
                        If (arg0\Field36[arg0\Field39] = Null) Then
                            If (arg0\Field39 > $13) Then
                                arg0\Field39 = $00
                                arg0\Field37 = $00
                            Else
                                arg0\Field39 = (arg0\Field39 + $01)
                            EndIf
                        Else
                            local7 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                            arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                            translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                            local8 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            If (((1.0 > local8) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                    local20 = $00
                                    If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                        local20 = $00
                                    Else
                                        local20 = rand($00, $02)
                                    EndIf
                                    playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local20), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                    playmtfsound(mtfsfx($05), arg0)
                                EndIf
                                arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                                If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                    arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                                EndIf
                            EndIf
                            If (((0.2 > local8) Or ((local8 > local7) And (1.0 > local7))) <> 0) Then
                                arg0\Field39 = (arg0\Field39 + $01)
                            EndIf
                        EndIf
                        arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                    Else
                        positionentity(arg0\Field0, arg0\Field33, arg0\Field34, arg0\Field35, $01)
                        If (((0.2 > distance(entityx(arg0\Field4, $01), entityz(arg0\Field4, $01), arg0\Field33, arg0\Field35)) Or (entityvisible(arg0\Field0, arg0\Field4) = $00)) <> 0) Then
                            If (rand($01, $23) = $01) Then
                                rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            If (rand($01, $23) = $01) Then
                                For local26 = Each waypoints
                                    If (rand($01, $03) = $01) Then
                                        If (6.0 > entitydistance(local26\Field0, arg0\Field4)) Then
                                            arg0\Field33 = entityx(local26\Field0, $01)
                                            arg0\Field34 = entityy(local26\Field0, $01)
                                            arg0\Field35 = entityz(local26\Field0, $01)
                                            arg0\Field38 = 0.0
                                            Exit
                                        EndIf
                                    EndIf
                                Next
                            EndIf
                            arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                        Else
                            pointentity(arg0\Field4, arg0\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                            arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                            translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        EndIf
                    EndIf
                    If ((((arg0\Field47 = Null) And (arg0\Field26 < $834)) And (2100.0 <= ((Float arg0\Field26) + local0\Field3[$00]))) <> 0) Then
                        If (rand($02, $01) = $01) Then
                            playmtfsound(loadtempsound(scpmodding_processfilepath((("SFX\Character\MTF\Searching" + (Str rand($01, $06))) + ".ogg"))), arg0)
                        EndIf
                    EndIf
                EndIf
                If (((0.0 >= arg0\Field10) And (0.0 < (arg0\Field10 + local0\Field3[$00]))) <> 0) Then
                    If (arg0\Field47 = Null) Then
                        playmtfsound(loadtempsound(scpmodding_processfilepath((("SFX\Character\MTF\Targetlost" + (Str rand($01, $03))) + ".ogg"))), arg0)
                        If (0.0 = mtf_camerachecktimer) Then
                            If (rand(($0F - (selecteddifficulty\Field3 * $07)), $01) = $01) Then
                                playannouncement(scpmodding_processfilepath("SFX\Character\MTF\AnnouncCameraCheck.ogg"))
                                mtf_camerachecktimer = local0\Field3[$00]
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field9 = 0.0
                EndIf
                If (2.0 > curr173\Field24) Then
                    local22 = max(min((distance(entityx(curr173\Field4, $00), entityz(curr173\Field4, $00), curr173\Field28, curr173\Field30) * 2.5), 1.0), 0.0)
                    If ((othernpcseesmenpc(curr173, arg0) Or ((0.0 < local22) And (6.0 > entitydistance(arg0\Field4, curr173\Field4)))) <> 0) Then
                        If ((entityvisible(arg0\Field4, curr173\Field4) Or (0.0 < local22)) <> 0) Then
                            arg0\Field9 = 2.0
                            arg0\Field33 = entityx(curr173\Field4, $01)
                            arg0\Field34 = entityy(curr173\Field4, $01)
                            arg0\Field35 = entityz(curr173\Field4, $01)
                            arg0\Field10 = 1050.0
                            If (arg0\Field16 <> $00) Then
                                freesound_strict(arg0\Field16)
                                arg0\Field16 = $00
                            EndIf
                            arg0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\173\Spotted3.ogg"))
                            playmtfsound(arg0\Field16, arg0)
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                        EndIf
                    EndIf
                EndIf
                If (0.0 >= curr106\Field9) Then
                    If ((othernpcseesmenpc(curr106, arg0) Or (3.0 > entitydistance(arg0\Field4, curr106\Field4))) <> 0) Then
                        If (entityvisible(arg0\Field4, curr106\Field4) <> 0) Then
                            arg0\Field9 = 4.0
                            arg0\Field33 = entityx(curr106\Field4, $01)
                            arg0\Field34 = entityy(curr106\Field4, $01)
                            arg0\Field35 = entityz(curr106\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            arg0\Field31 = curr106
                            If (arg0\Field47 = Null) Then
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\106\Spotted5.ogg"))
                                playmtfsound(arg0\Field16, arg0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (curr096 <> Null) Then
                    If (othernpcseesmenpc(curr096, arg0) <> 0) Then
                        If (entityvisible(arg0\Field4, curr096\Field4) <> 0) Then
                            arg0\Field9 = 8.0
                            arg0\Field33 = entityx(curr096\Field4, $01)
                            arg0\Field34 = entityy(curr096\Field4, $01)
                            arg0\Field35 = entityz(curr096\Field4, $01)
                            arg0\Field10 = 1050.0
                            arg0\Field11 = 0.0
                            arg0\Field38 = 0.0
                            arg0\Field37 = $00
                            If (arg0\Field47 = Null) Then
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\096\Spotted" + (Str rand($01, $02))) + ".ogg")))
                                playmtfsound(arg0\Field16, arg0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
                For local9 = Each npcs
                    If (local9\Field5 = $03) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 4.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\049\Spotted" + (Str rand($01, $05))) + ".ogg")))
                                playmtfsound(arg0\Field16, arg0)
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $04) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                If (arg0\Field16 <> $00) Then
                                    freesound_strict(arg0\Field16)
                                    arg0\Field16 = $00
                                EndIf
                                arg0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\049\Player0492_1.ogg"))
                                playmtfsound(arg0\Field16, arg0)
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $17) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $16) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                Exit
                            EndIf
                        EndIf
                    ElseIf (((local9\Field5 = $02) And (local9\Field48 = $00)) <> 0) Then
                        If (othernpcseesmenpc(local9, arg0) <> 0) Then
                            If (entityvisible(arg0\Field4, local9\Field4) <> 0) Then
                                arg0\Field9 = 9.0
                                arg0\Field33 = entityx(local9\Field4, $01)
                                arg0\Field34 = entityy(local9\Field4, $01)
                                arg0\Field35 = entityz(local9\Field4, $01)
                                arg0\Field10 = 1050.0
                                arg0\Field11 = 0.0
                                arg0\Field38 = 0.0
                                arg0\Field37 = $00
                                arg0\Field31 = local9
                                arg0\Field25 = 350.0
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            Case $02
                If (2.0 = curr173\Field24) Then
                    arg0\Field9 = 0.0
                Else
                    For local9 = Each npcs
                        If (local9 <> arg0) Then
                            If (local9\Field5 = $14) Then
                                local9\Field9 = 2.0
                            EndIf
                        EndIf
                    Next
                    local27 = distance(entityx(arg0\Field4, $01), entityz(arg0\Field4, $01), entityx(curr173\Field4, $01), entityz(curr173\Field4, $01))
                    If (5.0 > local27) Then
                        If (2.0 <> curr173\Field24) Then
                            curr173\Field24 = 1.0
                        EndIf
                        arg0\Field10 = 1050.0
                        arg0\Field38 = 0.0
                        local28 = 1.0
                        If (arg0\Field47 <> Null) Then
                            local28 = 2.0
                        EndIf
                        If (local28 > local27) Then
                            If (arg0\Field47 = Null) Then
                                arg0\Field11 = (arg0\Field11 + local0\Field3[$00])
                                If (1050.0 <= arg0\Field11) Then
                                    curr173\Field24 = 2.0
                                    If (arg0\Field47 = Null) Then
                                        curr173\Field31 = arg0
                                    EndIf
                                    If (arg0\Field16 <> $00) Then
                                        freesound_strict(arg0\Field16)
                                        arg0\Field16 = $00
                                    EndIf
                                    arg0\Field16 = loadsound_strict(scpmodding_processfilepath((("SFX\Character\MTF\173\Box" + (Str rand($01, $03))) + ".ogg")))
                                    playmtfsound(arg0\Field16, arg0)
                                EndIf
                            EndIf
                            positionentity(arg0\Field0, entityx(curr173\Field4, $01), entityy(curr173\Field4, $01), entityz(curr173\Field4, $01), $01)
                            pointentity(arg0\Field4, arg0\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        Else
                            positionentity(arg0\Field0, entityx(curr173\Field4, $01), entityy(curr173\Field4, $01), entityz(curr173\Field4, $01), $01)
                            pointentity(arg0\Field4, arg0\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                            arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                            translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        EndIf
                    Else
                        If (2.0 <> curr173\Field24) Then
                            curr173\Field24 = 0.0
                        EndIf
                        If (0.0 >= arg0\Field38) Then
                            arg0\Field37 = findpath(arg0, entityx(curr173\Field4, $01), (entityy(curr173\Field4, $01) + 0.1), entityz(curr173\Field4, $01))
                            arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                        ElseIf (175.0 >= arg0\Field38) Then
                            arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                            arg0\Field22 = 0.0
                            If (rand($01, $23) = $01) Then
                                rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        ElseIf (arg0\Field37 = $02) Then
                            arg0\Field38 = (arg0\Field38 - (local0\Field3[$00] * 2.0))
                            arg0\Field22 = 0.0
                            If (rand($01, $23) = $01) Then
                                rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        ElseIf (arg0\Field37 = $01) Then
                            If (arg0\Field36[arg0\Field39] = Null) Then
                                If (arg0\Field39 > $13) Then
                                    arg0\Field39 = $00
                                    arg0\Field37 = $00
                                Else
                                    arg0\Field39 = (arg0\Field39 + $01)
                                EndIf
                            Else
                                local7 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                                pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                                rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                                arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                                rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                                arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                                translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                                animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                                local8 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                                If (((1.0 > local8) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                                    If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                        local20 = $00
                                        If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                            local20 = $00
                                        Else
                                            local20 = rand($00, $02)
                                        EndIf
                                        playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local20), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                        playmtfsound(mtfsfx($05), arg0)
                                    EndIf
                                    arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                                    If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                        arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                                    EndIf
                                EndIf
                                If (((0.2 > local8) Or ((local8 > local7) And (1.0 > local7))) <> 0) Then
                                    arg0\Field39 = (arg0\Field39 + $01)
                                EndIf
                            EndIf
                            arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                        Else
                            arg0\Field38 = (arg0\Field38 - (local0\Field3[$00] * 2.0))
                            arg0\Field22 = 0.0
                            If (rand($01, $23) = $01) Then
                                rotateentity(arg0\Field4, 0.0, rnd(360.0, 0.0), 0.0, $01)
                            EndIf
                            finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        EndIf
                    EndIf
                EndIf
            Case $03
                arg0\Field15 = curvevalue(0.0, arg0\Field15, 40.0)
                If (arg0\Field37 = $02) Then
                    arg0\Field9 = 5.0
                    arg0\Field22 = 0.0
                ElseIf (arg0\Field37 = $01) Then
                    If (arg0\Field36[arg0\Field39] = Null) Then
                        If (arg0\Field39 > $13) Then
                            arg0\Field39 = $00
                            arg0\Field37 = $00
                            If (arg0\Field26 > $00) Then
                                arg0\Field9 = 5.0
                            EndIf
                        Else
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    Else
                        If (arg0\Field36[arg0\Field39]\Field1 <> Null) Then
                            If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                                arg0\Field36[arg0\Field39]\Field1\Field11 = 560.0
                                playmtfsound(mtfsfx($05), arg0)
                            EndIf
                        EndIf
                        If (local12 < (hidedistance * 0.7)) Then
                            local13 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            pointentity(arg0\Field0, arg0\Field36[arg0\Field39]\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field4, $00), 10.0), 0.0, $00)
                            If (0.0 = arg0\Field24) Then
                                arg0\Field22 = curvevalue((arg0\Field21 * max(min(local13, 1.0), 0.1)), arg0\Field22, 20.0)
                                moveentity(arg0\Field4, 0.0, 0.0, (arg0\Field22 * local0\Field3[$00]))
                                If (0.5 > entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)) Then
                                    arg0\Field39 = (arg0\Field39 + $01)
                                EndIf
                            EndIf
                        ElseIf (rand($14, $01) = $01) Then
                            positionentity(arg0\Field4, entityx(arg0\Field36[arg0\Field39]\Field0, $01), (entityy(arg0\Field36[arg0\Field39]\Field0, $01) + 0.25), entityz(arg0\Field36[arg0\Field39]\Field0, $01), $01)
                            arg0\Field39 = (arg0\Field39 + $01)
                            resetentity(arg0\Field4)
                        EndIf
                    EndIf
                Else
                    arg0\Field22 = 0.0
                    arg0\Field9 = 5.0
                EndIf
                If (((0.0 = arg0\Field24) And (arg0\Field37 = $01)) <> 0) Then
                    If (hidedistance > local12) Then
                        If (959.0 < arg0\Field14) Then
                            animatenpc(arg0, 1376.0, 1383.0, 0.2, $00)
                            If (1382.9 < arg0\Field14) Then
                                arg0\Field14 = 488.0
                            EndIf
                        Else
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 30.0), $01)
                        EndIf
                    EndIf
                Else
                    If (hidedistance > local12) Then
                        If (arg0\Field26 > $00) Then
                            animatenpc(arg0, 78.0, 312.0, 0.2, $01)
                        ElseIf (962.0 > arg0\Field14) Then
                            If (487.0 < arg0\Field14) Then
                                arg0\Field14 = 463.0
                            EndIf
                            animatenpc(arg0, 463.0, 487.0, 0.3, $00)
                            If (486.9 < arg0\Field14) Then
                                arg0\Field14 = 962.0
                            EndIf
                        Else
                            animatenpc(arg0, 962.0, 1259.0, 0.3, $01)
                        EndIf
                    EndIf
                    arg0\Field22 = curvevalue(0.0, arg0\Field22, 20.0)
                EndIf
                arg0\Field15 = entityyaw(arg0\Field4, $00)
            Case $04
                arg0\Field21 = 0.03
                arg0\Field10 = (arg0\Field10 - local0\Field3[$00])
                If (0.0 < arg0\Field10) Then
                    If (othernpcseesmenpc(arg0\Field31, arg0) <> 0) Then
                        arg0\Field10 = 1050.0
                    EndIf
                    If (hidedistance < entitydistance(arg0\Field31\Field4, arg0\Field4)) Then
                        If (70.0 < arg0\Field10) Then
                            arg0\Field10 = 70.0
                        EndIf
                    EndIf
                    If (((3.0 > entitydistance(arg0\Field31\Field4, arg0\Field4)) And (0.0 <= arg0\Field11)) <> 0) Then
                        arg0\Field11 = 350.0
                    EndIf
                    If (0.0 < arg0\Field11) Then
                        arg0\Field37 = $00
                        arg0\Field39 = $00
                        arg0\Field21 = 0.02
                        pointentity(arg0\Field4, arg0\Field31\Field4, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue((- arg0\Field21), arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                        animatenpc(arg0, 522.0, 488.0, (arg0\Field22 * 26.0), $01)
                        arg0\Field38 = 1.0
                        arg0\Field11 = max((arg0\Field11 - local0\Field3[$00]), 0.0)
                        hideentity(arg0\Field4)
                        turnentity(arg0\Field4, 0.0, 180.0, 0.0, $00)
                        entitypick(arg0\Field4, 1.0)
                        If (pickedentity() <> $00) Then
                            arg0\Field11 = -140.0
                        EndIf
                        showentity(arg0\Field4)
                        turnentity(arg0\Field4, 0.0, 180.0, 0.0, $00)
                    ElseIf (0.0 > arg0\Field11) Then
                        arg0\Field11 = min((arg0\Field11 + local0\Field3[$00]), 0.0)
                    EndIf
                    If (0.0 >= arg0\Field38) Then
                        If (arg0\Field47 <> Null) Then
                            arg0\Field37 = findpath(arg0, entityx(arg0\Field47\Field4, $01), (entityy(arg0\Field47\Field4, $01) + 0.1), entityz(arg0\Field47\Field4, $01))
                        Else
                            For local6 = Each rooms
                                If ((((12.0 < (Abs (local6\Field3 - entityx(arg0\Field4, $01)))) Or (12.0 < (Abs (local6\Field5 - entityz(arg0\Field4, $01))))) And (rand($01, (Int max((Float ($04 - (Int (Abs (local6\Field5 - (entityz(arg0\Field4, $01) / 8.0)))))), 2.0))) = $01)) <> 0) Then
                                    If (6.0 < entitydistance(local6\Field2, arg0\Field31\Field4)) Then
                                        local3 = local6\Field3
                                        local4 = 0.1
                                        local5 = local6\Field5
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            arg0\Field37 = findpath(arg0, local3, local4, local5)
                        EndIf
                        If (arg0\Field37 = $01) Then
                            While (arg0\Field36[arg0\Field39] = Null)
                                If (arg0\Field39 > $13) Then
                                    Exit
                                EndIf
                                arg0\Field39 = (arg0\Field39 + $01)
                            Wend
                            If (arg0\Field39 < $13) Then
                                If (((arg0\Field36[arg0\Field39] <> Null) And (arg0\Field36[(arg0\Field39 + $01)] <> Null)) <> 0) Then
                                    If (arg0\Field36[arg0\Field39]\Field1 = Null) Then
                                        If ((Abs deltayaw(arg0\Field4, arg0\Field36[(arg0\Field39 + $01)]\Field0)) < (Abs deltayaw(arg0\Field4, arg0\Field36[arg0\Field39]\Field0))) Then
                                            arg0\Field39 = (arg0\Field39 + $01)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        arg0\Field38 = 700.0
                    ElseIf (arg0\Field37 = $01) Then
                        If (arg0\Field36[arg0\Field39] = Null) Then
                            If (arg0\Field39 > $13) Then
                                arg0\Field39 = $00
                                arg0\Field37 = $00
                            Else
                                arg0\Field39 = (arg0\Field39 + $01)
                            EndIf
                        Else
                            local7 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                            rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                            arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                            rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                            arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                            translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                            animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                            local8 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                            If (((2.0 > local8) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                    local20 = $00
                                    If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                        local20 = $00
                                    Else
                                        local20 = rand($00, $02)
                                    EndIf
                                    playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local20), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                    playmtfsound(mtfsfx($05), arg0)
                                EndIf
                                arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                                If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                    arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                                EndIf
                            EndIf
                            If (((0.2 > local8) Or ((local8 > local7) And (1.0 > local7))) <> 0) Then
                                arg0\Field39 = (arg0\Field39 + $01)
                            EndIf
                        EndIf
                        arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                    Else
                        arg0\Field38 = 0.0
                    EndIf
                Else
                    arg0\Field9 = 0.0
                EndIf
            Case $05
                local11 = createpivot($00)
                positionentity(local11, arg0\Field33, arg0\Field34, arg0\Field35, $01)
                If (hidedistance > local12) Then
                    animatenpc(arg0, 346.0, 351.0, 0.2, $00)
                EndIf
                If ((((55.0 > (Abs (entityx(local11, $00) - entityx(arg0\Field4, $00)))) And (55.0 > (Abs (entityz(local11, $00) - entityz(arg0\Field4, $00))))) And (20.0 > (Abs (entityy(local11, $00) - entityy(arg0\Field4, $00))))) <> 0) Then
                    pointentity(arg0\Field0, local11, 0.0)
                    rotateentity(arg0\Field4, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field4, $00), 30.0), 0.0, $01)
                    If (0.0 = arg0\Field38) Then
                        arg0\Field37 = entityvisible(arg0\Field4, local11)
                        arg0\Field38 = (Float rand($64, $C8))
                    Else
                        arg0\Field38 = min((arg0\Field38 - local0\Field3[$00]), 0.0)
                    EndIf
                    If (((arg0\Field37 = $01) And (0.0 >= arg0\Field25)) <> 0) Then
                        local12 = distance(entityx(local11, $00), entityz(local11, $00), entityx(arg0\Field4, $00), entityz(arg0\Field4, $00))
                    EndIf
                EndIf
                freeentity(local11)
                arg0\Field15 = entityyaw(arg0\Field4, $00)
            Case $06
                pointentity(arg0\Field0, collider, 0.0)
                rotateentity(arg0\Field4, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field4, $00), 20.0), 0.0, $00)
                arg0\Field15 = entityyaw(arg0\Field4, $00)
                animatenpc(arg0, 346.0, 351.0, 0.2, $00)
                If (((0.0 >= arg0\Field25) And (0.0 = killtimer)) <> 0) Then
                    If (entityvisible(arg0\Field4, collider) <> 0) Then
                        If (50.0 > (Abs deltayaw(arg0\Field4, collider))) Then
                            playsound2(gunshotsfx, camera, arg0\Field4, 15.0, 1.0)
                            local19 = createpivot($00)
                            rotateentity(local19, entitypitch(arg0\Field4, $00), entityyaw(arg0\Field4, $00), 0.0, $01)
                            positionentity(local19, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                            moveentity(local19, 0.0632, 0.84925, 0.5451)
                            shoot(entityx(local19, $00), entityy(local19, $00), entityz(local19, $00), 0.9, $01, $00)
                            arg0\Field25 = 7.0
                            freeentity(local19)
                        EndIf
                    EndIf
                EndIf
            Case $07
                animatenpc(arg0, 346.0, 351.0, 0.2, $00)
                rotateentity(arg0\Field4, 0.0, curveangle(arg0\Field10, entityyaw(arg0\Field4, $00), 20.0), 0.0, $00)
                arg0\Field15 = entityyaw(arg0\Field4, $00)
                If (0.0 >= arg0\Field25) Then
                    lightvolume = (templightvolume * 1.2)
                    playsound2(gunshotsfx, camera, arg0\Field4, 20.0, 1.0)
                    local19 = createpivot($00)
                    rotateentity(local19, entitypitch(arg0\Field4, $00), entityyaw(arg0\Field4, $00), 0.0, $01)
                    positionentity(local19, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                    moveentity(local19, 0.0632, 0.84925, 0.5451)
                    local10 = createparticle(entityx(local19, $00), entityy(local19, $00), entityz(local19, $00), $01, rnd(0.08, 0.1), 0.0, $05)
                    turnentity(local10\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
                    local10\Field14 = -0.15
                    freeentity(local19)
                    arg0\Field25 = 7.0
                EndIf
            Case $08
                arg0\Field21 = 0.015
                arg0\Field53 = "head"
                arg0\Field51 = $01
                arg0\Field52 = $02
                If (0.0 >= arg0\Field38) Then
                    If (arg0\Field47 <> Null) Then
                        arg0\Field37 = findpath(arg0, entityx(arg0\Field47\Field4, $01), (entityy(arg0\Field47\Field4, $01) + 0.1), entityz(arg0\Field47\Field4, $01))
                    Else
                        For local6 = Each rooms
                            If ((((12.0 < (Abs (local6\Field3 - entityx(arg0\Field4, $01)))) Or (12.0 < (Abs (local6\Field5 - entityz(arg0\Field4, $01))))) And (rand($01, (Int max((Float ($04 - (Int (Abs (local6\Field5 - (entityz(arg0\Field4, $01) / 8.0)))))), 2.0))) = $01)) <> 0) Then
                                local3 = local6\Field3
                                local4 = 0.1
                                local5 = local6\Field5
                                Exit
                            EndIf
                        Next
                        arg0\Field37 = findpath(arg0, local3, local4, local5)
                    EndIf
                    If (arg0\Field37 = $01) Then
                        While (arg0\Field36[arg0\Field39] = Null)
                            If (arg0\Field39 > $13) Then
                                Exit
                            EndIf
                            arg0\Field39 = (arg0\Field39 + $01)
                        Wend
                        If (arg0\Field39 < $13) Then
                            If (((arg0\Field36[arg0\Field39] <> Null) And (arg0\Field36[(arg0\Field39 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field4, arg0\Field36[(arg0\Field39 + $01)]\Field0)) < (Abs deltayaw(arg0\Field4, arg0\Field36[arg0\Field39]\Field0))) Then
                                        arg0\Field39 = (arg0\Field39 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field38 = (rnd(6.0, 10.0) * 70.0)
                ElseIf (((175.0 >= arg0\Field38) And (arg0\Field47 = Null)) <> 0) Then
                    arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                    arg0\Field22 = 0.0
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                ElseIf (arg0\Field37 = $02) Then
                    arg0\Field38 = (arg0\Field38 - (local0\Field3[$00] * 2.0))
                    arg0\Field22 = 0.0
                    finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                ElseIf (arg0\Field37 = $01) Then
                    If (arg0\Field36[arg0\Field39] = Null) Then
                        If (arg0\Field39 > $13) Then
                            arg0\Field39 = $00
                            arg0\Field37 = $00
                        Else
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    Else
                        local7 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        local8 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        If (((1.0 > local8) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                            If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                local20 = $00
                                If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                    local20 = $00
                                Else
                                    local20 = rand($00, $02)
                                EndIf
                                playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local20), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                playmtfsound(mtfsfx($05), arg0)
                            EndIf
                            arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                            If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                            EndIf
                        EndIf
                        If (((0.2 > local8) Or ((local8 > local7) And (1.0 > local7))) <> 0) Then
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    EndIf
                    arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                Else
                    arg0\Field38 = (arg0\Field38 - (local0\Field3[$00] * 2.0))
                    If (arg0\Field47 = Null) Then
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field22 = 0.0
                    ElseIf (1.0 < entitydistance(arg0\Field4, arg0\Field47\Field4)) Then
                        pointentity(arg0\Field4, arg0\Field47\Field4, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                    Else
                        finishwalking(arg0, 488.0, 522.0, (arg0\Field21 * 26.0))
                        arg0\Field22 = 0.0
                    EndIf
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                EndIf
                If (((entityvisible(arg0\Field4, curr096\Field4) = $00) Or (6.0 < entitydistance(arg0\Field4, curr096\Field4))) <> 0) Then
                    arg0\Field9 = 0.0
                EndIf
            Case $09
                If (entityvisible(arg0\Field4, arg0\Field31\Field4) <> 0) Then
                    pointentity(arg0\Field0, arg0\Field31\Field4, 0.0)
                    rotateentity(arg0\Field4, 0.0, curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field4, $00), 20.0), 0.0, $00)
                    arg0\Field15 = entityyaw(arg0\Field4, $00)
                    If (1.3 > entitydistance(arg0\Field31\Field4, arg0\Field4)) Then
                        arg0\Field11 = 140.0
                    EndIf
                    If (0.0 < arg0\Field11) Then
                        arg0\Field37 = $00
                        arg0\Field39 = $00
                        arg0\Field21 = 0.02
                        arg0\Field22 = curvevalue((- arg0\Field21), arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                        animatenpc(arg0, 522.0, 488.0, (arg0\Field22 * 26.0), $01)
                        arg0\Field38 = 1.0
                        arg0\Field11 = max((arg0\Field11 - local0\Field3[$00]), 0.0)
                    Else
                        arg0\Field11 = 0.0
                        animatenpc(arg0, 346.0, 351.0, 0.2, $00)
                    EndIf
                    If (((0.0 >= arg0\Field25) And (arg0\Field31\Field48 = $00)) <> 0) Then
                        If (50.0 > (Abs deltayaw(arg0\Field4, arg0\Field31\Field4))) Then
                            playsound2(gunshotsfx, camera, arg0\Field4, 15.0, 1.0)
                            local19 = createpivot($00)
                            rotateentity(local19, entitypitch(arg0\Field4, $00), entityyaw(arg0\Field4, $00), 0.0, $01)
                            positionentity(local19, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00), $00)
                            moveentity(local19, 0.0632, 0.84925, 0.5451)
                            local10 = createparticle(entityx(local19, $00), entityy(local19, $00), entityz(local19, $00), $01, rnd(0.08, 0.1), 0.0, $05)
                            turnentity(local10\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
                            local10\Field14 = -0.15
                            If (arg0\Field31\Field61 > $00) Then
                                arg0\Field31\Field61 = (Int max((Float (arg0\Field31\Field61 - rand($05, $0A))), 0.0))
                            Else
                                If (arg0\Field31\Field48 = $00) Then
                                    If (arg0\Field16 <> $00) Then
                                        freesound_strict(arg0\Field16)
                                        arg0\Field16 = $00
                                    EndIf
                                    If (arg0\Field5 = $04) Then
                                        arg0\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Character\MTF\049\Player0492_2.ogg"))
                                        playmtfsound(arg0\Field16, arg0)
                                    EndIf
                                EndIf
                                setnpcframe(arg0\Field31, 133.0)
                                arg0\Field31\Field48 = $01
                                arg0\Field31 = Null
                                arg0\Field9 = 0.0
                                Return $00
                            EndIf
                            arg0\Field25 = 7.0
                            freeentity(local19)
                        EndIf
                    EndIf
                    arg0\Field37 = $00
                ElseIf (0.0 >= arg0\Field38) Then
                    arg0\Field37 = findpath(arg0, entityx(arg0\Field31\Field4, $00), entityy(arg0\Field31\Field4, $00), entityz(arg0\Field31\Field4, $00))
                    If (arg0\Field37 = $01) Then
                        While (arg0\Field36[arg0\Field39] = Null)
                            If (arg0\Field39 > $13) Then
                                Exit
                            EndIf
                            arg0\Field39 = (arg0\Field39 + $01)
                        Wend
                        If (arg0\Field39 < $13) Then
                            If (((arg0\Field36[arg0\Field39] <> Null) And (arg0\Field36[(arg0\Field39 + $01)] <> Null)) <> 0) Then
                                If (arg0\Field36[arg0\Field39]\Field1 = Null) Then
                                    If ((Abs deltayaw(arg0\Field4, arg0\Field36[(arg0\Field39 + $01)]\Field0)) < (Abs deltayaw(arg0\Field4, arg0\Field36[arg0\Field39]\Field0))) Then
                                        arg0\Field39 = (arg0\Field39 + $01)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    arg0\Field38 = 700.0
                ElseIf (arg0\Field37 = $01) Then
                    If (arg0\Field36[arg0\Field39] = Null) Then
                        If (arg0\Field39 > $13) Then
                            arg0\Field39 = $00
                            arg0\Field37 = $00
                        Else
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    Else
                        local7 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        pointentity(arg0\Field4, arg0\Field36[arg0\Field39]\Field0, 0.0)
                        rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                        arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
                        arg0\Field22 = curvevalue(arg0\Field21, arg0\Field22, 20.0)
                        translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * arg0\Field22) * local0\Field3[$00]), $01)
                        animatenpc(arg0, 488.0, 522.0, (arg0\Field22 * 26.0), $01)
                        local8 = entitydistance(arg0\Field4, arg0\Field36[arg0\Field39]\Field0)
                        If (((1.0 > local8) And (arg0\Field36[arg0\Field39]\Field1 <> Null)) <> 0) Then
                            If (arg0\Field36[arg0\Field39]\Field1\Field5 = $00) Then
                                local20 = $00
                                If (arg0\Field36[arg0\Field39]\Field1\Field9 = $01) Then
                                    local20 = $00
                                Else
                                    local20 = rand($00, $02)
                                EndIf
                                playsound2(opendoorsfx(arg0\Field36[arg0\Field39]\Field1\Field9, local20), camera, arg0\Field36[arg0\Field39]\Field1\Field0, 10.0, 1.0)
                                playmtfsound(mtfsfx($05), arg0)
                            EndIf
                            arg0\Field36[arg0\Field39]\Field1\Field5 = $01
                            If (arg0\Field36[arg0\Field39]\Field1\Field24 <> 0) Then
                                arg0\Field36[arg0\Field39]\Field1\Field11 = 350.0
                            EndIf
                        EndIf
                        If (((0.2 > local8) Or ((local8 > local7) And (1.0 > local7))) <> 0) Then
                            arg0\Field39 = (arg0\Field39 + $01)
                        EndIf
                    EndIf
                    arg0\Field38 = (arg0\Field38 - local0\Field3[$00])
                Else
                    arg0\Field38 = 0.0
                EndIf
                If (arg0\Field31\Field48 = $01) Then
                    arg0\Field31 = Null
                    arg0\Field9 = 0.0
                EndIf
        End Select
        If (0.01 < arg0\Field22) Then
            If (((500.0 < local15) And (495.0 > arg0\Field14)) <> 0) Then
                playsound2(stepsfx($02, $00, rand($00, $02)), camera, arg0\Field4, 8.0, rnd(0.5, 0.7))
            ElseIf (((505.0 > local15) And (505.0 <= arg0\Field14)) <> 0) Then
                playsound2(stepsfx($02, $00, rand($00, $02)), camera, arg0\Field4, 8.0, rnd(0.5, 0.7))
            EndIf
        EndIf
        If ((chs\Field2 And (1.0 = arg0\Field9)) <> 0) Then
            arg0\Field9 = 0.0
        EndIf
        If (((((3.0 <> arg0\Field9) And (5.0 <> arg0\Field9)) And (6.0 <> arg0\Field9)) And (7.0 <> arg0\Field9)) <> 0) Then
            If (arg0\Field47 <> Null) Then
                If (0.7 > entitydistance(arg0\Field4, arg0\Field47\Field4)) Then
                    pointentity(arg0\Field4, arg0\Field47\Field4, 0.0)
                    rotateentity(arg0\Field4, 0.0, entityyaw(arg0\Field4, $01), 0.0, $01)
                    arg0\Field15 = curveangle(entityyaw(arg0\Field4, $01), arg0\Field15, 20.0)
                    translateentity(arg0\Field4, ((cos((entityyaw(arg0\Field4, $01) - 45.0)) * 0.01) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) - 45.0)) * 0.01) * local0\Field3[$00]), $01)
                EndIf
            Else
                For local9 = Each npcs
                    If (((local9 <> arg0) And (local9\Field48 = $00)) <> 0) Then
                        If (80.0 > (Abs deltayaw(arg0\Field4, local9\Field4))) Then
                            If (0.7 > entitydistance(arg0\Field4, local9\Field4)) Then
                                translateentity(local9\Field4, ((cos((entityyaw(arg0\Field4, $01) + 90.0)) * 0.01) * local0\Field3[$00]), 0.0, ((sin((entityyaw(arg0\Field4, $01) + 90.0)) * 0.01) * local0\Field3[$00]), $01)
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        EndIf
        If (((6.0 <> arg0\Field9) And (7.0 <> arg0\Field9)) <> 0) Then
            If (-10.0 > entityy(arg0\Field4, $00)) Then
                teleportcloser(arg0)
            EndIf
        EndIf
        rotateentity(arg0\Field0, -90.0, arg0\Field15, 0.0, $01)
        positionentity(arg0\Field0, entityx(arg0\Field4, $01), (entityy(arg0\Field4, $01) - 0.15), entityz(arg0\Field4, $01), $01)
    EndIf
    Return $00
End Function
