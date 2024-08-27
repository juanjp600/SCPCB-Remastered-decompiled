Function mouselook%()
    Local local0%
    Local local1%
    Local local2.fps_settings
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    Local local14.particles
    Local local15.npcs
    Local local16%
    Local local17.waypoints
    Local local18#
    Local local19%
    local2 = (First fps_settings)
    camerashake = max((camerashake - (local2\Field3[$00] / 10.0)), 0.0)
    camerazoom(camera, (min(((currcamerazoom / 400.0) + 1.0), 1.1) / tan(((atan((tan((fov / 2.0)) * ((Float realgraphicwidth) / (Float realgraphicheight)))) * 2.0) / 2.0))))
    currcamerazoom = max((currcamerazoom - local2\Field3[$00]), 0.0)
    If (((0.0 <= killtimer) And (0.0 <= falltimer)) <> 0) Then
        headdropspeed = 0.0
        local3 = 0.0
        local4 = (0.0 / local3)
        If ((Int entityx(collider, $00)) = (Int local4)) Then
            positionentity(collider, entityx(camera, $01), (entityy(camera, $01) - 0.5), entityz(camera, $01), $01)
            msg = ("EntityX(Collider) = NaN, RESETTING COORDINATES    -    New coordinates: " + (Str entityx(collider, $00)))
            msgtimer = 300.0
        EndIf
        local5 = ((sin(shake) / ((crouchstate * 20.0) + 20.0)) * 0.6)
        local6 = max(min(((sin((shake / 2.0)) * 2.5) * min((injuries + 0.25), 3.0)), 8.0), -8.0)
        positionentity(camera, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
        rotateentity(camera, 0.0, entityyaw(collider, $00), (local6 * 0.5), $00)
        moveentity(camera, side, ((local5 + 0.6) + (crouchstate * -0.3)), 0.0)
        local8 = (((((Float local7) + 0.5) * (Float mousexspeed())) * mouselook_x_inc) / (1.0 + (Float wearingvest)))
        local9 = (((((Float local7) + 0.5) * (Float mouseyspeed())) * mouselook_y_inc) / (1.0 + (Float wearingvest)))
        If (0.0 < local2\Field4) Then
            If (1.0 < (Abs ((local2\Field3[$00] / local2\Field4) - 1.0))) Then
                mouse_x_speed_1 = 0.0
                mouse_y_speed_1 = 0.0
            EndIf
        EndIf
        If (mouse_smooth <> 0) Then
            mouse_x_speed_1 = (mouse_x_speed_1 - local8)
            mouse_y_speed_1 = (mouse_y_speed_1 + local9)
        Else
            rotateentity(collider, 0.0, (entityyaw(collider, $00) - local8), 0.0, $00)
            user_camera_pitch = (user_camera_pitch + local9)
        EndIf
        local10 = entityyaw(collider, $00)
        rotateentity(collider, 0.0, curveangle((entityyaw(collider, $00) + mouse_x_speed_1), entityyaw(collider, $00), 12.0), 0.0, $00)
        mouse_x_speed_1 = (mouse_x_speed_1 - wrapangle180((entityyaw(collider, $00) - local10)))
        local11 = user_camera_pitch
        user_camera_pitch = curvevalue((user_camera_pitch + mouse_y_speed_1), user_camera_pitch, 12.0)
        mouse_y_speed_1 = (mouse_y_speed_1 - wrapangle180((user_camera_pitch - local11)))
        mouse_x_leverturn = (curvevalue(0.0, mouse_x_leverturn, 8.0) + local8)
        mouse_y_leverturn = (curvevalue(0.0, mouse_y_leverturn, 8.0) + local9)
        If (70.0 < user_camera_pitch) Then
            user_camera_pitch = 70.0
        EndIf
        If (-70.0 > user_camera_pitch) Then
            user_camera_pitch = -70.0
        EndIf
        rotateentity(camera, wrapangle((rnd((- camerashake), camerashake) + user_camera_pitch)), wrapangle((entityyaw(collider, $00) + rnd((- camerashake), camerashake))), local6, $00)
        If (playerroom\Field7\Field10 = "pocketdimension") Then
            If ((((2000.0 * roomscale) > entityy(collider, $00)) Or ((2608.0 * roomscale) < entityy(collider, $00))) <> 0) Then
                rotateentity(camera, wrapangle(entitypitch(camera, $00)), wrapangle(entityyaw(camera, $00)), (wrapangle((sin(((Float millisecs2()) / 150.0)) * 30.0)) + local6), $00)
            EndIf
        EndIf
    Else
        hideentity(collider)
        positionentity(camera, entityx(head, $00), entityy(head, $00), entityz(head, $00), $00)
        local12 = $00
        For local0 = $01 To countcollisions(head) Step $01
            If ((entityy(head, $00) - 0.01) > collisiony(head, local0)) Then
                local12 = $01
            EndIf
        Next
        If (local12 = $01) Then
            headdropspeed = 0.0
        Else
            If (killanim = $00) Then
                moveentity(head, 0.0, 0.0, headdropspeed)
                rotateentity(head, curveangle(-90.0, entitypitch(head, $00), 20.0), entityyaw(head, $00), entityroll(head, $00), $00)
                rotateentity(camera, curveangle((entitypitch(head, $00) - 40.0), entitypitch(camera, $00), 40.0), entityyaw(camera, $00), entityroll(camera, $00), $00)
            Else
                moveentity(head, 0.0, 0.0, (- headdropspeed))
                rotateentity(head, curveangle(90.0, entitypitch(head, $00), 20.0), entityyaw(head, $00), entityroll(head, $00), $00)
                rotateentity(camera, curveangle((entitypitch(head, $00) + 40.0), entitypitch(camera, $00), 40.0), entityyaw(camera, $00), entityroll(camera, $00), $00)
            EndIf
            headdropspeed = (headdropspeed - (local2\Field3[$00] * 0.002))
        EndIf
        If (invertmouse <> 0) Then
            turnentity(camera, (((Float (- mouseyspeed())) * 0.05) * local2\Field3[$00]), (((Float (- mousexspeed())) * 0.15) * local2\Field3[$00]), 0.0, $00)
        Else
            turnentity(camera, (((Float mouseyspeed()) * 0.05) * local2\Field3[$00]), (((Float (- mousexspeed())) * 0.15) * local2\Field3[$00]), 0.0, $00)
        EndIf
    EndIf
    If (particleamount = $02) Then
        If (rand($23, $01) = $01) Then
            local13 = createpivot($00)
            positionentity(local13, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $00)
            rotateentity(local13, 0.0, rnd(360.0, 0.0), 0.0, $00)
            If (rand($02, $01) = $01) Then
                moveentity(local13, 0.0, rnd(-0.5, 0.5), rnd(0.5, 1.0))
            Else
                moveentity(local13, 0.0, rnd(-0.5, 0.5), rnd(0.5, 1.0))
            EndIf
            local14 = createparticle(entityx(local13, $00), entityy(local13, $00), entityz(local13, $00), $02, 0.002, 0.0, $12C)
            local14\Field8 = 0.001
            rotateentity(local14\Field1, rnd(-20.0, 20.0), rnd(360.0, 0.0), 0.0, $00)
            local14\Field15 = -0.00001
            freeentity(local13)
        EndIf
    EndIf
    If (((((mousex() > mouse_right_limit) Or (mousex() < mouse_left_limit)) Or (mousey() > mouse_bottom_limit)) Or (mousey() < mouse_top_limit)) <> 0) Then
        movemouse(viewport_center_x, viewport_center_y)
    EndIf
    If ((wearingnightvision = $00) = $00) Then
        showentity(at\Field4[$03])
        If (wearingnightvision = $02) Then
            entitycolor(at\Field4[$03], 0.0, 100.0, 255.0)
            ambientlightrooms($0F)
        ElseIf (wearingnightvision = $03) Then
            entitycolor(at\Field4[$03], 255.0, 0.0, 0.0)
            ambientlightrooms($0F)
        Else
            entitycolor(at\Field4[$03], 0.0, 255.0, 0.0)
            ambientlightrooms($0F)
        EndIf
        entitytexture(at\Field4[$00], at\Field5[$04], $00, $00)
    Else
        ambientlightrooms($00)
        hideentity(at\Field4[$03])
        entitytexture(at\Field4[$00], at\Field5[$00], $00, $00)
    EndIf
    If (((wearinggasmask > $00) Or (i_1499\Field0 > $00)) <> 0) Then
        If (i_714\Field0 = $00) Then
            If (((wearinggasmask = $02) Or (i_1499\Field0 = $02)) <> 0) Then
                stamina = min(100.0, ((((100.0 - stamina) * 0.01) * local2\Field3[$00]) + stamina))
            EndIf
        EndIf
        showentity(at\Field4[$01])
        showentity(at\Field4[$0F])
        If (((channelplaying(breathchn) = $00) And (channelplaying(relaxedbreathchn) = $00)) <> 0) Then
            relaxedbreathchn = playsound_strict(relaxedbreathsfx)
        EndIf
        If (0.0 < currspeed) Then
            If (keydown(key_sprint) <> 0) Then
                gasmaskblurtimer = min(((local2\Field3[$00] * 0.06) + gasmaskblurtimer), 90.0)
                If (50.0 > stamina) Then
                    gasmaskblurtimer = min(((local2\Field3[$00] * 0.22) + gasmaskblurtimer), 90.0)
                    If (channelplaying(relaxedbreathchn) = $01) Then
                        stopchannel(relaxedbreathchn)
                    EndIf
                EndIf
            Else
                gasmaskblurtimer = max(0.0, (gasmaskblurtimer - (local2\Field3[$00] * 0.15)))
            EndIf
        Else
            gasmaskblurtimer = max(0.0, (gasmaskblurtimer - (local2\Field3[$00] * 0.18)))
        EndIf
        entityalpha(at\Field4[$0F], min((((gasmaskblurtimer * 0.19) ^ 2.0) / 1000.0), 0.5))
    Else
        If (channelplaying(relaxedbreathchn) = $01) Then
            stopchannel(relaxedbreathchn)
        EndIf
        gasmaskblurtimer = max(0.0, (gasmaskblurtimer - (local2\Field3[$00] * 0.18)))
        hideentity(at\Field4[$01])
        hideentity(at\Field4[$0F])
    EndIf
    If (wearinghazmat > $00) Then
        If (wearinghazmat = $01) Then
            stamina = min(60.0, stamina)
        EndIf
        If (i_714\Field0 = $00) Then
            If (wearinghazmat = $02) Then
                stamina = min(100.0, ((((100.0 - stamina) * 0.01) * local2\Field3[$00]) + stamina))
            EndIf
        EndIf
        showentity(at\Field4[$10])
    Else
        hideentity(at\Field4[$10])
    EndIf
    If (wearinghelmet > $00) Then
        showentity(at\Field4[$06])
    Else
        hideentity(at\Field4[$06])
    EndIf
    If (i_1033ru\Field2 = $01) Then
        i_1033ru\Field0 = ($64 - i_1033ru\Field1)
    ElseIf (i_1033ru\Field2 = $02) Then
        i_1033ru\Field0 = ($C8 - i_1033ru\Field1)
    Else
        i_1033ru\Field0 = $00
    EndIf
    If (((i_1033ru\Field2 > $00) And (i_1033ru\Field0 > $00)) <> 0) Then
        shouldplay = $1F
    EndIf
    If (i_178\Field0 > $00) Then
        showentity(at\Field4[$0B])
        shouldplay = $0E
    Else
        hideentity(at\Field4[$0B])
    EndIf
    i_178\Field1 = $00
    If (i_178\Field0 <> $01) Then
        For local15 = Each npcs
            If (local15\Field5 = $18) Then
                If (0.0 < local15\Field11) Then
                    i_178\Field1 = $01
                EndIf
                If (((0.0 >= local15\Field9) And (0.0 = local15\Field11)) <> 0) Then
                    removenpc(local15)
                ElseIf ((hidedistance * 1.5) < entitydistance(collider, local15\Field4)) Then
                    removenpc(local15)
                EndIf
            EndIf
        Next
    EndIf
    If (((i_178\Field1 = $01) Or (i_178\Field0 = $01)) <> 0) Then
        local16 = $00
        For local15 = Each npcs
            If (local15\Field5 = $18) Then
                local16 = (local16 + $01)
                If ((hidedistance * 1.5) < entitydistance(collider, local15\Field4)) Then
                    removenpc(local15)
                EndIf
            EndIf
        Next
        If (local16 < $0A) Then
            For local17 = Each waypoints
                local18 = entitydistance(collider, local17\Field0)
                If (((((local18 < (hidedistance * 1.5)) And (1.2 < local18)) And (local17\Field1 = Null)) And (rand($00, $01) = $01)) <> 0) Then
                    local19 = $01
                    For local15 = Each npcs
                        If (local15\Field5 = $18) Then
                            If (0.5 > entitydistance(local15\Field4, local17\Field0)) Then
                                local19 = $00
                                Exit
                            EndIf
                        EndIf
                    Next
                    If (local19 <> 0) Then
                        createnpc($18, entityx(local17\Field0, $01), (entityy(local17\Field0, $01) + 0.15), entityz(local17\Field0, $01))
                    EndIf
                EndIf
            Next
        EndIf
    EndIf
    For local0 = $00 To $05 Step $01
        If (0.0 < scp1025state[local0]) Then
            Select local0
                Case $00
                    If (0.0 < local2\Field3[$00]) Then
                        If (rand($3E8, $01) = $01) Then
                            If (coughchn = $00) Then
                                coughchn = playsound_strict(coughsfx(rand($00, $02)))
                            ElseIf (channelplaying(coughchn) = $00) Then
                                coughchn = playsound_strict(coughsfx(rand($00, $02)))
                            EndIf
                        EndIf
                    EndIf
                    stamina = (stamina - (local2\Field3[$00] * 0.3))
                Case $01
                    If (((rand($2328, $01) = $01) And (msg = "")) <> 0) Then
                        msg = scplang_getphrase("ingame.itchy")
                        msgtimer = 280.0
                    EndIf
                Case $02
                    If (0.0 < local2\Field3[$00]) Then
                        If (rand($320, $01) = $01) Then
                            If (coughchn = $00) Then
                                coughchn = playsound_strict(coughsfx(rand($00, $02)))
                            ElseIf (channelplaying(coughchn) = $00) Then
                                coughchn = playsound_strict(coughsfx(rand($00, $02)))
                            EndIf
                        EndIf
                    EndIf
                    stamina = (stamina - (local2\Field3[$00] * 0.1))
                Case $03
                    If ((i_427\Field0 And (25200.0 > i_427\Field1)) = $00) Then
                        scp1025state[local0] = ((local2\Field3[$00] * 0.0005) + scp1025state[local0])
                    EndIf
                    If (20.0 < scp1025state[local0]) Then
                        If (20.0 >= (scp1025state[local0] - local2\Field3[$00])) Then
                            msg = scplang_getphrase("ingame.stomach1")
                        EndIf
                        stamina = (stamina - (local2\Field3[$00] * 0.3))
                    ElseIf (10.0 < scp1025state[local0]) Then
                        If (10.0 >= (scp1025state[local0] - local2\Field3[$00])) Then
                            msg = scplang_getphrase("ingame.stomach2")
                        EndIf
                    EndIf
                Case $04
                    If (35.0 > stamina) Then
                        If (rand((Int ((stamina * 8.0) + 140.0)), $01) = $01) Then
                            If (coughchn = $00) Then
                                coughchn = playsound_strict(coughsfx(rand($00, $02)))
                            ElseIf (channelplaying(coughchn) = $00) Then
                                coughchn = playsound_strict(coughsfx(rand($00, $02)))
                            EndIf
                        EndIf
                        currspeed = curvevalue(0.0, currspeed, ((stamina * 15.0) + 10.0))
                    EndIf
                Case $05
                    If ((i_427\Field0 And (25200.0 > i_427\Field1)) = $00) Then
                        scp1025state[local0] = ((local2\Field3[$00] * 0.35) + scp1025state[local0])
                    EndIf
                    If (110.0 < scp1025state[local0]) Then
                        heartbeatrate = 0.0
                        blurtimer = max(blurtimer, 500.0)
                        If (140.0 < scp1025state[local0]) Then
                            deathmsg = scplang_getphrase("ingame.cardiacarrest")
                            kill($00, $00)
                        EndIf
                    Else
                        heartbeatrate = max(heartbeatrate, (70.0 + scp1025state[local0]))
                        heartbeatvolume = 1.0
                    EndIf
            End Select
        EndIf
    Next
    Return $00
End Function
