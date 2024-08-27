Function updatesecuritycams%()
    Local local0.securitycams
    Local local1.fps_settings
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6%
    local1 = (First fps_settings)
    local2 = loadtexture_strict(scpmodding_processfilepath("GFX\map\CameraTexture1.png"), $01)
    local3 = loadtexture_strict(scpmodding_processfilepath("GFX\map\CameraTexture2.png"), $01)
    For local0 = Each securitycams
        local4 = $00
        If (local0\Field19 = Null) Then
            hideentity(local0\Field8)
        Else
            If (((6.0 > local0\Field19\Field8) Or (playerroom = local0\Field19)) <> 0) Then
                local4 = $01
            ElseIf (local0\Field8 <> $00) Then
                hideentity(local0\Field8)
            EndIf
            If (local0\Field19 <> Null) Then
                If (local0\Field19\Field7\Field10 = "room2sl") Then
                    local0\Field21 = $00
                EndIf
            EndIf
            If ((local4 Or (local0 = coffincam)) <> 0) Then
                If (local0\Field20 <> 0) Then
                    If (local0 <> coffincam) Then
                        If (entityvisible(local0\Field3, camera) <> 0) Then
                            If (0.0 < mtf_camerachecktimer) Then
                                mtf_cameracheckdetected = $01
                            EndIf
                        EndIf
                    EndIf
                    pointentity(local0\Field3, camera, 0.0)
                    local5 = entitypitch(local0\Field3, $00)
                    rotateentity(local0\Field0, 0.0, curveangle(entityyaw(local0\Field3, $00), entityyaw(local0\Field0, $00), 75.0), 0.0, $00)
                    If (40.0 > local5) Then
                        local5 = 40.0
                    EndIf
                    If (70.0 < local5) Then
                        local5 = 70.0
                    EndIf
                    rotateentity(local0\Field3, curveangle(local5, entitypitch(local0\Field3, $00), 75.0), entityyaw(local0\Field0, $00), 0.0, $00)
                    positionentity(local0\Field3, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) - 0.083), entityz(local0\Field0, $01), $00)
                    rotateentity(local0\Field3, entitypitch(local0\Field3, $00), entityyaw(local0\Field0, $00), 0.0, $00)
                Else
                    If (0.0 < local0\Field12) Then
                        If (local0\Field25 = $00) Then
                            local0\Field13 = (local0\Field13 + (local1\Field3[$00] * 0.2))
                            If ((local0\Field12 * 1.3) < local0\Field13) Then
                                local0\Field25 = $01
                            EndIf
                        Else
                            local0\Field13 = (local0\Field13 - (local1\Field3[$00] * 0.2))
                            If (((- local0\Field12) * 1.3) > local0\Field13) Then
                                local0\Field25 = $00
                            EndIf
                        EndIf
                    EndIf
                    rotateentity(local0\Field0, 0.0, (((Float local0\Field19\Field6) + local0\Field11) + max(min(local0\Field13, local0\Field12), (- local0\Field12))), 0.0, $00)
                    If ((entityinview(local0\Field3, camera) And entityvisible(local0\Field3, camera)) <> 0) Then
                        If ((millisecs2() Mod $4E2) < $320) Then
                            entitytexture(local0\Field3, local3, $00, $00)
                        Else
                            entitytexture(local0\Field3, local2, $00, $00)
                        EndIf
                    EndIf
                    positionentity(local0\Field3, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) - 0.083), entityz(local0\Field0, $01), $00)
                    rotateentity(local0\Field3, entitypitch(local0\Field3, $00), entityyaw(local0\Field0, $00), 0.0, $00)
                    If (local0\Field8 <> $00) Then
                        positionentity(local0\Field8, entityx(local0\Field3, $01), entityy(local0\Field3, $01), entityz(local0\Field3, $01), $00)
                        rotateentity(local0\Field8, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), 0.0, $00)
                        moveentity(local0\Field8, 0.0, 0.0, 0.1)
                    EndIf
                    If (local0 <> coffincam) Then
                        If (60.0 > (Abs deltayaw(local0\Field3, camera))) Then
                            If (entityvisible(local0\Field3, camera) <> 0) Then
                                If (0.0 < mtf_camerachecktimer) Then
                                    mtf_cameracheckdetected = $01
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (local4 = $01) Then
                If (local0\Field7 <> 0) Then
                    local0\Field14 = (local0\Field14 + local1\Field3[$00])
                    If (((-5.0 < blinktimer) And entityinview(local0\Field4, camera)) <> 0) Then
                        If (entityvisible(camera, local0\Field4) <> 0) Then
                            If ((((((local0\Field21 = $01) Or (local0\Field21 = $03)) And (i_714\Field0 = $00)) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                                If (-5.0 < blinktimer) Then
                                    sanity = (sanity - local1\Field3[$00])
                                    restoresanity = $00
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (-1000.0 > sanity) Then
                        deathmsg = ((chr($22) + scplang_getphrase("ingame.scp895")) + chr($22))
                        If (-10.0 > vomittimer) Then
                            kill($00, $00)
                        EndIf
                    EndIf
                    If (((0.0 > vomittimer) And (-800.0 > sanity)) <> 0) Then
                        restoresanity = $00
                        sanity = -1010.0
                    EndIf
                    If ((((-5.0 < blinktimer) And entityinview(local0\Field4, camera)) And entityvisible(camera, local0\Field4)) <> 0) Then
                        local0\Field17 = $01
                    Else
                        local0\Field17 = $00
                    EndIf
                    If (local0\Field18 <= local0\Field14) Then
                        If (((-5.0 < blinktimer) And entityinview(local0\Field4, camera)) <> 0) Then
                            If (entityvisible(camera, local0\Field4) <> 0) Then
                                If ((((coffincam = Null) Or (rand($05, $01) = $05)) Or (local0\Field21 <> $03)) <> 0) Then
                                    hideentity(camera)
                                    showentity(local0\Field8)
                                    cls()
                                    updateroomlights(local0\Field8)
                                    setbuffer(backbuffer())
                                    renderworld(1.0)
                                    copyrect($00, $00, $200, $200, $00, $00, backbuffer(), texturebuffer(screentexs[local0\Field9], $00))
                                    hideentity(local0\Field8)
                                    showentity(camera)
                                Else
                                    hideentity(camera)
                                    showentity(coffincam\Field19\Field2)
                                    entityalpha(getchild(coffincam\Field19\Field2, $02), 1.0)
                                    showentity(coffincam\Field8)
                                    cls()
                                    updateroomlights(coffincam\Field8)
                                    setbuffer(backbuffer())
                                    renderworld(1.0)
                                    copyrect($00, $00, $200, $200, $00, $00, backbuffer(), texturebuffer(screentexs[local0\Field9], $00))
                                    hideentity(coffincam\Field19\Field2)
                                    hideentity(coffincam\Field8)
                                    showentity(camera)
                                EndIf
                            EndIf
                        EndIf
                        local0\Field14 = 0.0
                    EndIf
                    If ((((((local0\Field21 = $01) Or (local0\Field21 = $03)) And (i_714\Field0 = $00)) And (wearinghazmat < $03)) And (wearinggasmask < $03)) <> 0) Then
                        If (local0\Field17 <> 0) Then
                            local6 = createpivot($00)
                            positionentity(local6, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                            pointentity(local6, local0\Field4, 0.0)
                            rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local6, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 20.0), 200.0)), 0.0, $00)
                            turnentity(local6, 90.0, 0.0, 0.0, $00)
                            user_camera_pitch = curveangle(entitypitch(local6, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 20.0), 200.0))
                            user_camera_pitch = (user_camera_pitch - 90.0)
                            freeentity(local6)
                            If ((((local0\Field21 = $01) Or (local0\Field21 = $03)) And (i_714\Field0 = $00)) <> 0) Then
                                If (-800.0 > sanity) Then
                                    If (rand($03, $01) = $01) Then
                                        entitytexture(local0\Field10, at\Field5[$10], $00, $00)
                                    EndIf
                                    If (rand($06, $01) < $05) Then
                                        entitytexture(local0\Field10, at\Field1[rand($0A, $14)], $00, $00)
                                        If (local0\Field15 = $01) Then
                                            playsound_strict(horrorsfx($01))
                                        EndIf
                                        local0\Field15 = $02
                                        If (local0\Field16 = $00) Then
                                            local0\Field16 = playsound_strict(horrorsfx($04))
                                        ElseIf (channelplaying(local0\Field16) = $00) Then
                                            local0\Field16 = playsound_strict(horrorsfx($04))
                                        EndIf
                                        If (((local0\Field21 = $03) And (rand($C8, $01) = $01)) <> 0) Then
                                            local0\Field21 = $02
                                            local0\Field15 = rand($2710, $4E20)
                                        EndIf
                                    EndIf
                                    blurtimer = 1000.0
                                    If (0.0 = vomittimer) Then
                                        vomittimer = 1.0
                                    EndIf
                                ElseIf (-500.0 > sanity) Then
                                    If (rand($07, $01) = $01) Then
                                        entitytexture(local0\Field10, at\Field5[$10], $00, $00)
                                    EndIf
                                    If (rand($32, $01) = $01) Then
                                        entitytexture(local0\Field10, at\Field1[rand($0A, $14)], $00, $00)
                                        If (local0\Field15 = $00) Then
                                            playsound_strict(horrorsfx($00))
                                        EndIf
                                        local0\Field15 = (Int max((Float local0\Field15), 1.0))
                                        If (((local0\Field21 = $03) And (rand($64, $01) = $01)) <> 0) Then
                                            local0\Field21 = $02
                                            local0\Field15 = rand($2710, $4E20)
                                        EndIf
                                    EndIf
                                Else
                                    entitytexture(local0\Field10, at\Field5[$10], $00, $00)
                                EndIf
                            EndIf
                        EndIf
                    ElseIf (local0\Field17 <> 0) Then
                        If (((i_714\Field0 Or (wearinghazmat = $03)) Or (wearinggasmask = $03)) <> 0) Then
                            entitytexture(local0\Field10, at\Field5[$10], $00, $00)
                        EndIf
                    EndIf
                    If (((local0\Field17 And (local0\Field21 = $00)) Or (local0\Field21 = $02)) <> 0) Then
                        If (local0\Field15 = $00) Then
                            local0\Field15 = rand($EA60, $FDE8)
                        EndIf
                        If (rand($1F4, $01) = $01) Then
                            entitytexture(local0\Field10, at\Field1[$03], $00, $00)
                        EndIf
                        If ((millisecs2() Mod local0\Field15) >= rand($258, $01)) Then
                            entitytexture(local0\Field10, at\Field5[$10], $00, $00)
                        Else
                            If (local0\Field16 = $00) Then
                                local0\Field16 = playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\079\Broadcast" + (Str rand($01, $03))) + ".ogg"))))
                                If (local0\Field21 = $02) Then
                                    local0\Field21 = $03
                                    local0\Field15 = $00
                                EndIf
                            ElseIf (channelplaying(local0\Field16) = $00) Then
                                local0\Field16 = playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\079\Broadcast" + (Str rand($01, $03))) + ".ogg"))))
                                If (local0\Field21 = $02) Then
                                    local0\Field21 = $03
                                    local0\Field15 = $00
                                EndIf
                            EndIf
                            entitytexture(local0\Field10, at\Field1[$03], $00, $00)
                        EndIf
                    EndIf
                EndIf
                If (local0\Field17 = $00) Then
                    local0\Field16 = loopsound2(camerasfx, local0\Field16, camera, local0\Field3, 4.0, 1.0)
                EndIf
            EndIf
        EndIf
    Next
    cls()
    Return $00
End Function
