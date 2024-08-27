Function updatedimension1499%()
    Local local0.events
    Local local1.npcs
    Local local2.npcs
    Local local3.rooms
    Local local4.items
    Local local5%
    Local local6%
    Local local7.dummy1499
    Local local8%
    Local local9%
    Local local10#
    Local local11%
    Local local12%
    Local local13.fps_settings
    Local local14.objects
    Local local15%
    Local local16%
    Local local17%
    local13 = (First fps_settings)
    local14 = (First objects)
    For local0 = Each events
        If (local0\Field0 = "dimension1499") Then
            If (playerroom = local0\Field1) Then
                If (2.0 > local0\Field2) Then
                    If (0.0 = local0\Field2) Then
                        If (((local0\Field15 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local0
                            local0\Field15 = "load0"
                        EndIf
                    Else
                        local0\Field2 = 2.0
                    EndIf
                    local15 = rand($02, $03)
                    If ((((Float local15) = local0\Field3) Or (4.0 = local0\Field3)) <> 0) Then
                        For local5 = $FFFFFFFF To $01 Step $01
                            For local6 = $FFFFFFFF To $01 Step $01
                                If (((local5 <> $00) And (local6 <> $00)) <> 0) Then
                                    local1 = createnpc($0F, (entityx(collider, $00) + (0.75 * (Float local5))), (entityy(collider, $00) + 0.05), (entityz(collider, $00) + (0.75 * (Float local6))))
                                    pointentity(local1\Field4, collider, 0.0)
                                    rotateentity(local1\Field4, 0.0, entityyaw(local1\Field4, $00), 0.0, $00)
                                    local1\Field9 = 2.0
                                ElseIf (((local5 <> $00) Or (local6 <> $00)) <> 0) Then
                                    local1 = createnpc($0F, (entityx(collider, $00) + (Float local5)), (entityy(collider, $00) + 0.05), (entityz(collider, $00) + (Float local6)))
                                    pointentity(local1\Field4, collider, 0.0)
                                    rotateentity(local1\Field4, 0.0, entityyaw(local1\Field4, $00), 0.0, $00)
                                    local1\Field9 = 2.0
                                EndIf
                            Next
                        Next
                        local0\Field3 = 5.0
                    EndIf
                    If (2100.0 > local0\Field4) Then
                        local1 = createnpc($0F, (local0\Field1\Field3 + (4055.0 * roomscale)), (local0\Field1\Field4 + (240.0 * roomscale)), (local0\Field1\Field5 + (1884.0 * roomscale)))
                        local1\Field12 = $03
                        local1\Field15 = 270.0
                        rotateentity(local1\Field4, 0.0, local1\Field15, 0.0, $00)
                        local2 = createnpc($0F, (local0\Field1\Field3 + (4055.0 * roomscale)), (local0\Field1\Field4 + (240.0 * roomscale)), (local0\Field1\Field5 + (2876.0 * roomscale)))
                        local2\Field12 = $03
                        local2\Field15 = 270.0
                        rotateentity(local2\Field4, 0.0, local2\Field15, 0.0, $00)
                        local1\Field31 = local2
                        local2\Field31 = local1
                        local0\Field1\Field22[$02] = local1
                        local0\Field1\Field22[$03] = local2
                        local1 = createnpc($0F, (local0\Field1\Field3 - (1877.0 * roomscale)), (local0\Field1\Field4 + (192.0 * roomscale)), (local0\Field1\Field5 + (1071.0 * roomscale)))
                        local1\Field12 = $03
                        local1\Field15 = 270.0
                        rotateentity(local1\Field4, 0.0, local1\Field15, 0.0, $00)
                        local2 = createnpc($0F, (local0\Field1\Field3 - (1877.0 * roomscale)), (local0\Field1\Field4 + (192.0 * roomscale)), (local0\Field1\Field5 + (3503.0 * roomscale)))
                        local2\Field12 = $03
                        local2\Field15 = 270.0
                        rotateentity(local2\Field4, 0.0, local2\Field15, 0.0, $00)
                        local1\Field31 = local2
                        local2\Field31 = local1
                        local0\Field1\Field22[$04] = local1
                        local0\Field1\Field22[$05] = local2
                        local1 = createnpc($0F, (local0\Field1\Field3 - (2761.0 * roomscale)), (local0\Field1\Field4 + (240.0 * roomscale)), (local0\Field1\Field5 + (3204.0 * roomscale)))
                        local1\Field12 = $01
                        local1\Field15 = 180.0
                        rotateentity(local1\Field4, 0.0, local1\Field15, 0.0, $00)
                        local1\Field21 = 0.0
                        local1 = createnpc($0F, (local0\Field1\Field3 - (1917.0 * roomscale)), (local0\Field1\Field4 + (1904.0 * roomscale)), (local0\Field1\Field5 + (2308.0 * roomscale)))
                        local1\Field12 = $02
                        local1\Field15 = 270.0
                        rotateentity(local1\Field4, 0.0, local1\Field15, 0.0, $00)
                        local16 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_1499_1_king.png"), $01)
                        entitytexture(local1\Field0, local16, $00, $00)
                        freetexture(local16)
                        local0\Field1\Field22[$00] = local1
                        local1 = createnpc($0F, (local0\Field1\Field3 - (1917.0 * roomscale)), (local0\Field1\Field4 + (1904.0 * roomscale)), (local0\Field1\Field5 + (2052.0 * roomscale)))
                        local1\Field12 = $01
                        local1\Field15 = 270.0
                        rotateentity(local1\Field4, 0.0, local1\Field15, 0.0, $00)
                        local0\Field1\Field22[$01] = local1
                        For local11 = $00 To $07 Step $01
                            For local12 = $00 To $02 Step $01
                                local7 = (New dummy1499)
                                local7\Field1 = copyentity(local0\Field1\Field22[$01]\Field0, $00)
                                local10 = ((getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-1499-1", "scale", 0.0) / 4.0) * rnd(0.8, 1.0))
                                scaleentity(local7\Field1, local10, local10, local10, $00)
                                entityfx(local7\Field1, $01)
                                local7\Field0 = rand($00, $01)
                                positionentity(local7\Field1, max(min(((local0\Field1\Field3 + ((1887.0 - (365.7143 * (Float local11))) * roomscale)) + rnd(-0.5, 0.5)), (local0\Field1\Field3 + (1887.0 * roomscale))), (local0\Field1\Field3 - (873.0 * roomscale))), local0\Field1\Field4, max(min(((local0\Field1\Field5 + ((1796.0 - (384.0 * (Float local12))) * roomscale)) + rnd(-0.5, 0.5)), (local0\Field1\Field5 + (1796.0 * roomscale))), (local0\Field1\Field5 + (1028.0 * roomscale))), $00)
                                rotateentity(local7\Field1, 0.0, 270.0, 0.0, $00)
                                entityautofade(local7\Field1, 25.0, 39.0)
                            Next
                        Next
                        For local11 = $00 To $06 Step $01
                            For local12 = $00 To $02 Step $01
                                local7 = (New dummy1499)
                                local7\Field1 = copyentity(local0\Field1\Field22[$01]\Field0, $00)
                                local10 = ((getinifloat(scpmodding_processfilepath("Data\NPCs.ini"), "SCP-1499-1", "scale", 0.0) / 4.0) * rnd(0.8, 1.0))
                                scaleentity(local7\Field1, local10, local10, local10, $00)
                                entityfx(local7\Field1, $01)
                                local7\Field0 = rand($00, $01)
                                positionentity(local7\Field1, max(min(((local0\Field1\Field3 + ((1375.0 - (341.3333 * (Float local11))) * roomscale)) + rnd(-0.5, 0.5)), (local0\Field1\Field3 + (1375.0 * roomscale))), (local0\Field1\Field3 - (873.0 * roomscale))), local0\Field1\Field4, max(min(((local0\Field1\Field5 + ((3588.0 - (384.0 * (Float local12))) * roomscale)) + rnd(-0.5, 0.5)), (local0\Field1\Field5 + (3588.0 * roomscale))), (local0\Field1\Field5 + (2820.0 * roomscale))), $00)
                                rotateentity(local7\Field1, 0.0, 270.0, 0.0, $00)
                                entityautofade(local7\Field1, 25.0, 39.0)
                            Next
                        Next
                    Else
                        hideentity(local0\Field1\Field20[$01])
                    EndIf
                    For local5 = $00 To $0E Step $01
                        local1 = createnpc($0F, (entityx(collider, $00) + rnd(-20.0, 20.0)), (entityy(collider, $00) + 0.1), (entityz(collider, $00) + rnd(-20.0, 20.0)))
                        If (rand($02, $01) = $01) Then
                            local1\Field10 = 1500.0
                        EndIf
                        local1\Field15 = rnd(360.0, 0.0)
                        local1\Field10 = 0.0
                        If (10.0 > entitydistance(local1\Field4, collider)) Then
                            local1\Field9 = 2.0
                        EndIf
                    Next
                EndIf
                If (debughud = $00) Then
                    camerafogrange(camera, 40.0, 80.0)
                    camerafogcolor(camera, 96.0, 97.0, 104.0)
                    cameraclscolor(camera, 96.0, 97.0, 104.0)
                    camerarange(camera, 0.05, 90.0)
                Else
                    camerafogrange(camera, 120.0, 120.0)
                    camerafogcolor(camera, 96.0, 97.0, 104.0)
                    cameraclscolor(camera, 96.0, 97.0, 104.0)
                    camerarange(camera, 0.05, 120.0)
                EndIf
                For local3 = Each rooms
                    hideentity(local3\Field2)
                Next
                showentity(local0\Field1\Field2)
                If (((quickloadpercent = $64) Or (quickloadpercent = $FFFFFFFF)) <> 0) Then
                    updatechunks(local0\Field1, $0F, $01)
                    showentity(i_1499\Field8)
                    update1499sky()
                    shouldplay = $12
                    If (800.0 > entityy(collider, $00)) Then
                        positionentity(collider, entityx(collider, $00), 800.5, entityz(collider, $00), $01)
                        resetentity(collider)
                    EndIf
                    For local4 = Each items
                        If (750.0 < entityy(local4\Field1, $00)) Then
                            If (800.0 > entityy(local4\Field1, $00)) Then
                                positionentity(local4\Field1, entityx(local4\Field1, $00), 800.5, entityz(local4\Field1, $00), $00)
                                resetentity(local4\Field1)
                            EndIf
                        EndIf
                    Next
                    For local7 = Each dummy1499
                        If (2100.0 > local0\Field4) Then
                            If (local7\Field0 = $00) Then
                                If (360.5 >= animtime(local7\Field1)) Then
                                    animate2(local7\Field1, animtime(local7\Field1), $141, $169, 0.2, $00)
                                ElseIf (((361.5 < animtime(local7\Field1)) And (401.5 >= animtime(local7\Field1))) <> 0) Then
                                    animate2(local7\Field1, animtime(local7\Field1), $16A, $192, 0.2, $00)
                                Else
                                    local9 = rand($00, $01)
                                    If (local9 = $00) Then
                                        setanimtime(local7\Field1, 321.0, $00)
                                    Else
                                        setanimtime(local7\Field1, 362.0, $00)
                                    EndIf
                                EndIf
                            ElseIf (452.5 >= animtime(local7\Field1)) Then
                                animate2(local7\Field1, animtime(local7\Field1), $19D, $1C5, 0.2, $00)
                            ElseIf (((453.5 < animtime(local7\Field1)) And (497.5 >= animtime(local7\Field1))) <> 0) Then
                                animate2(local7\Field1, animtime(local7\Field1), $1C6, $1F2, 0.2, $00)
                            Else
                                local9 = rand($00, $01)
                                If (local9 = $00) Then
                                    setanimtime(local7\Field1, 413.0, $00)
                                Else
                                    setanimtime(local7\Field1, 454.0, $00)
                                EndIf
                            EndIf
                        Else
                            If (local7\Field0 = $00) Then
                                If (((411.5 >= animtime(local7\Field1)) And (320.5 < animtime(local7\Field1))) <> 0) Then
                                    animate2(local7\Field1, animtime(local7\Field1), $193, $19C, 0.2, $00)
                                Else
                                    animate2(local7\Field1, animtime(local7\Field1), $128, $140, 0.2, $01)
                                EndIf
                            ElseIf (((507.5 >= animtime(local7\Field1)) And (320.5 < animtime(local7\Field1))) <> 0) Then
                                animate2(local7\Field1, animtime(local7\Field1), $1F3, $1FC, 0.2, $00)
                            Else
                                animate2(local7\Field1, animtime(local7\Field1), $128, $140, 0.2, $01)
                            EndIf
                            local17 = createpivot($00)
                            positionentity(local17, entityx(local7\Field1, $00), entityy(local7\Field1, $00), entityz(local7\Field1, $00), $01)
                            pointentity(local17, collider, 0.0)
                            rotateentity(local7\Field1, 0.0, (curveangle(entityyaw(local17, $00), (entityyaw(local7\Field1, $00) - 180.0), 10.0) + 180.0), 0.0, $00)
                            freeentity(local17)
                        EndIf
                    Next
                    If (700.0 > local0\Field4) Then
                        If ((2160.0 * roomscale) > (Abs (entityx(collider, $00) - (local0\Field1\Field3 - (56.0 * roomscale))))) Then
                            If ((1408.0 * roomscale) > (Abs (entityz(collider, $00) - (local0\Field1\Field5 + (2287.0 * roomscale))))) Then
                                local0\Field4 = (local0\Field4 + local13\Field3[$00])
                            EndIf
                        EndIf
                    ElseIf (((700.0 <= local0\Field4) And (1400.0 > local0\Field4)) <> 0) Then
                        For local5 = $00 To $01 Step $01
                            local0\Field1\Field22[local5]\Field25 = 1.0
                        Next
                        local0\Field4 = 1400.0
                    ElseIf (1400.0 = local0\Field4) Then
                        If (854.5 < local0\Field1\Field22[$00]\Field14) Then
                            For local5 = $02 To $05 Step $01
                                If (local5 = $02) Then
                                    If (local0\Field1\Field22[local5]\Field16 <> $00) Then
                                        freesound_strict(local0\Field1\Field22[local5]\Field16)
                                        local0\Field1\Field22[local5]\Field16 = $00
                                    EndIf
                                    local0\Field1\Field22[local5]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1499\Triggered.ogg"))
                                    local0\Field1\Field22[local5]\Field17 = playsound2(local0\Field1\Field22[local5]\Field16, camera, local0\Field1\Field22[local5]\Field4, 50.0, 1.0)
                                EndIf
                                local0\Field1\Field22[local5]\Field9 = 1.0
                                local0\Field1\Field22[local5]\Field14 = 203.0
                            Next
                            local0\Field4 = 2100.0
                        EndIf
                    EndIf
                    If (local0\Field1\Field22[$00] <> Null) Then
                        showentity(local0\Field1\Field20[$01])
                        If (2100.0 > local0\Field4) Then
                            shouldplay = $42
                            If (nowplaying = $42) Then
                                If (local0\Field6 = $00) Then
                                    local0\Field10 = loadsound_strict(scpmodding_processfilepath("SFX\Music\HaveMercyOnMe(Choir).ogg"))
                                    local0\Field6 = streamsound_strict(scpmodding_processfilepath("SFX\Music\HaveMercyOnMe(NoChoir).ogg"), musicvolume, $02)
                                    local0\Field12 = $01
                                EndIf
                            EndIf
                            If (local0\Field10 <> $00) Then
                                local0\Field7 = loopsound2(local0\Field10, local0\Field7, camera, local0\Field1\Field20[$00], 10.0, musicvolume)
                            EndIf
                        Else
                            shouldplay = $13
                            If (local0\Field6 <> $00) Then
                                stopstream_strict(local0\Field6)
                                stopchannel(local0\Field7)
                                local0\Field6 = $00
                                local0\Field7 = $00
                            EndIf
                            If (local0\Field10 <> $00) Then
                                freesound_strict(local0\Field10)
                                local0\Field10 = $00
                            EndIf
                        EndIf
                    EndIf
                    If (40.0 < entitydistance(collider, local0\Field1\Field2)) Then
                        For local7 = Each dummy1499
                            hideentity(local7\Field1)
                        Next
                    Else
                        For local7 = Each dummy1499
                            showentity(local7\Field1)
                        Next
                    EndIf
                Else
                    dropspeed = 0.0
                EndIf
                currstepsfx = $03
                playerfallingpickdistance = 0.0
            ElseIf (2.0 = local0\Field2) Then
                If (local0\Field6 <> $00) Then
                    stopstream_strict(local0\Field6)
                    stopchannel(local0\Field7)
                    local0\Field6 = $00
                    local0\Field7 = $00
                EndIf
                hideentity(i_1499\Field8)
                hidechunks()
                For local1 = Each npcs
                    If (local1\Field5 = $0F) Then
                        removenpc(local1)
                    EndIf
                Next
                For local7 = Each dummy1499
                    freeentity(local7\Field1)
                    Delete local7
                Next
                If (2100.0 > local0\Field4) Then
                    local0\Field4 = 0.0
                EndIf
                local0\Field2 = 1.0
                If (local0\Field10 <> $00) Then
                    freesound_strict(local0\Field10)
                    local0\Field10 = $00
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
