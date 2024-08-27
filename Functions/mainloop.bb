Function mainloop%()
    Local local0.fps_settings
    Local local1.fonts
    Local local2%
    Local local3.events
    Local local5$
    Local local6%
    Local local7%
    Local local8#
    Local local10$
    Local local11#
    Local local12%
    local0 = (First fps_settings)
    local1 = (First fonts)
    updatestreamsounds()
    shouldplay = (Int min((Float playerzone), 2.0))
    drawhandicon = $00
    restoresanity = $01
    shouldentitiesfall = $01
    If (((0.0 < local0\Field3[$00]) And (playerroom\Field7\Field10 <> "dimension1499")) <> 0) Then
        updatesecuritycams()
    EndIf
    If (((((((playerroom\Field7\Field10 <> "pocketdimension") And (playerroom\Field7\Field10 <> "gatea")) And (playerroom\Field7\Field10 <> "gateb")) And (ms\Field1 = $00)) And (consoleopen = $00)) And (invopen = $00)) <> 0) Then
        If (rand($5DC, $01) = $01) Then
            For local2 = $00 To $05 Step $01
                If (ambientsfx(local2, currambientsfx) <> $00) Then
                    If (channelplaying(ambientsfxchn) = $00) Then
                        freesound_strict(ambientsfx(local2, currambientsfx))
                        ambientsfx(local2, currambientsfx) = $00
                    EndIf
                EndIf
            Next
            positionentity(soundemitter, (entityx(camera, $00) + rnd(-1.0, 1.0)), 0.0, (entityz(camera, $00) + rnd(-1.0, 1.0)), $00)
            If (rand($03, $01) = $01) Then
                playerzone = $03
            EndIf
            If (playerroom\Field7\Field10 = "room173intro") Then
                playerzone = $04
            ElseIf (playerroom\Field7\Field10 = "room860") Then
                For local3 = Each events
                    If (local3\Field0 = "room860") Then
                        If (1.0 = local3\Field2) Then
                            playerzone = $05
                            positionentity(soundemitter, entityx(soundemitter, $00), 30.0, entityz(soundemitter, $00), $00)
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            currambientsfx = rand($00, (ambientsfxamount(playerzone) - $01))
            Select playerzone
                Case $00
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict(scpmodding_processfilepath((((("SFX\Ambient\Zone" + (Str (playerzone + $01))) + "\ambient") + (Str (currambientsfx + $01))) + ".ogg")))
                    EndIf
                Case $01
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict(scpmodding_processfilepath((((("SFX\Ambient\Zone" + (Str (playerzone + $01))) + "\ambient") + (Str (currambientsfx + $01))) + ".ogg")))
                    EndIf
                Case $02
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict(scpmodding_processfilepath((((("SFX\Ambient\Zone" + (Str (playerzone + $01))) + "\ambient") + (Str (currambientsfx + $01))) + ".ogg")))
                    EndIf
                Case $03
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict(scpmodding_processfilepath((("SFX\Ambient\General\ambient" + (Str (currambientsfx + $01))) + ".ogg")))
                    EndIf
                Case $04
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict(scpmodding_processfilepath((("SFX\Ambient\Pre-breach\ambient" + (Str (currambientsfx + $01))) + ".ogg")))
                    EndIf
                Case $05
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict(scpmodding_processfilepath((("SFX\Ambient\Forest\ambient" + (Str (currambientsfx + $01))) + ".ogg")))
                    EndIf
            End Select
            ambientsfxchn = playsound2(ambientsfx(playerzone, currambientsfx), camera, soundemitter, 10.0, 1.0)
        EndIf
        updatesoundorigin(ambientsfxchn, camera, soundemitter, 10.0, 1.0)
        If (rand($C350, $01) = $03) Then
            local5 = playerroom\Field7\Field10
            If (((((local5 <> "room860") And (local5 <> "room1123")) And (local5 <> "room173intro")) And (local5 <> "dimension1499")) <> 0) Then
                If (0.0 < local0\Field3[$00]) Then
                    lightblink = rnd(1.0, 2.0)
                EndIf
                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\079\Broadcast" + (Str rand($01, $08))) + ".ogg"))))
            EndIf
        EndIf
    EndIf
    updatecheckpoint1 = $00
    updatecheckpoint2 = $00
    If (((((((((ms\Field1 = $00) And (invopen = $00)) And (otheropen = Null)) And (selecteddoor = Null)) And (consoleopen = $00)) And (using294 = $00)) And (selectedscreen = Null)) And (0.0 <= i_end\Field0)) <> 0) Then
        lightvolume = curvevalue(templightvolume, lightvolume, 50.0)
        camerafogrange(camera, (camerafognear * lightvolume), (camerafogfar * lightvolume))
        camerafogcolor(camera, (Float fogr), (Float local6), (Float local7))
        camerafogmode(camera, $01)
        camerarange(camera, 0.01, min(((camerafogfar * lightvolume) * 1.5), 28.0))
        If (playerroom\Field7\Field10 <> "pocketdimension") Then
            cameraclscolor(camera, 0.0, 0.0, 0.0)
        EndIf
        ambientlight((Float brightness), (Float brightness), (Float brightness))
        playersoundvolume = curvevalue(0.0, playersoundvolume, 5.0)
        cansave = $01
        updatedeafplayer()
        updateemitters()
        mouselook()
        If ((((playerroom\Field7\Field10 = "dimension1499") And (quickloadpercent > $00)) And (quickloadpercent < $64)) <> 0) Then
            shouldentitiesfall = $00
        EndIf
        moveplayer()
        infacility = checkforplayerinfacility()
        If (playerroom\Field7\Field10 = "dimension1499") Then
            If (((quickloadpercent = $FFFFFFFF) Or (quickloadpercent = $64)) <> 0) Then
                updatedimension1499()
            EndIf
            updateleave1499()
        ElseIf (((playerroom\Field7\Field10 = "gatea") Or ((playerroom\Field7\Field10 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00)))) <> 0) Then
            updatedoors()
            If (((quickloadpercent = $FFFFFFFF) Or (quickloadpercent = $64)) <> 0) Then
                updateendings()
            EndIf
            updatescreens()
            updateroomlights(camera)
        Else
            updatedoors()
            If (((quickloadpercent = $FFFFFFFF) Or (quickloadpercent = $64)) <> 0) Then
                updateevents()
            EndIf
            updatescreens()
            timecheckpointmonitors()
            update294()
            updateroomlights(camera)
        EndIf
        updatedecals()
        updatemtf()
        updatemtf2()
        updatenpcs()
        updateitems()
        updateparticles()
        use427()
        use215()
        use207()
        use402()
        use357()
        updatemonitorsaving()
        updateparticles_time = min(1.0, (local0\Field3[$00] + updateparticles_time))
        If (1.0 = updateparticles_time) Then
            updatedevilemitters()
            updateparticles_devil()
            updateparticles_time = 0.0
        EndIf
    EndIf
    If (chs\Field4 <> 0) Then
        stamina = min(100.0, ((((100.0 - stamina) * 0.01) * local0\Field3[$00]) + stamina))
    EndIf
    If (chs\Field5 <> 0) Then
        blinktimer = min(blinkfreq, ((((blinkfreq - blinktimer) * 0.01) * local0\Field3[$00]) + blinktimer))
    EndIf
    If (0.0 = local0\Field3[$00]) Then
        updateworld(0.0)
    Else
        updateworld(1.0)
        manipulatenpcbones()
    EndIf
    renderworld2()
    blurvolume = min(curvevalue(0.0, blurvolume, 20.0), 0.95)
    If (0.0 < blurtimer) Then
        blurvolume = max(min(0.95, (blurtimer / 1000.0)), blurvolume)
        blurtimer = max((blurtimer - local0\Field3[$00]), 0.0)
    EndIf
    updateblur(blurvolume)
    local8 = 0.0
    If (ms\Field1 = $00) Then
        If (0.0 > sanity) Then
            If (restoresanity <> 0) Then
                sanity = min((local0\Field3[$00] + sanity), 0.0)
            EndIf
            If (-200.0 > sanity) Then
                local8 = max(min((((- sanity) - 200.0) / 700.0), 0.6), local8)
                If (0.0 <= killtimer) Then
                    heartbeatvolume = min(((Abs (sanity + 200.0)) / 500.0), 1.0)
                    heartbeatrate = max((((Abs (sanity + 200.0)) / 6.0) + 70.0), heartbeatrate)
                EndIf
            EndIf
        EndIf
        If (0.0 < eyestuck) Then
            blinktimer = blinkfreq
            eyestuck = max((eyestuck - local0\Field3[$00]), 0.0)
            If (9000.0 > eyestuck) Then
                blurtimer = max(blurtimer, ((9000.0 - eyestuck) * 0.5))
            EndIf
            If (6000.0 > eyestuck) Then
                local8 = min(max(local8, ((6000.0 - eyestuck) / 5000.0)), 1.0)
            EndIf
            If (((9000.0 > eyestuck) And (9000.0 <= (local0\Field3[$00] + eyestuck))) <> 0) Then
                msg = scplang_getphrase("ingame.eyedropstear")
                msgtimer = 420.0
            EndIf
        EndIf
        If (0.0 > blinktimer) Then
            If (-5.0 < blinktimer) Then
                local8 = max(local8, sin((Abs (blinktimer * 18.0))))
            ElseIf (-15.0 < blinktimer) Then
                local8 = 1.0
            Else
                local8 = max(local8, (Abs sin((blinktimer * 18.0))))
            EndIf
            If (-20.0 >= blinktimer) Then
                Select selecteddifficulty\Field5
                    Case $00
                        blinkfreq = rnd(490.0, 700.0)
                    Case $01
                        blinkfreq = rnd(455.0, 665.0)
                    Case $02
                        blinkfreq = rnd(420.0, 630.0)
                End Select
                blinktimer = blinkfreq
            EndIf
            blinktimer = (blinktimer - local0\Field3[$00])
        Else
            blinktimer = (blinktimer - ((local0\Field3[$00] * 0.6) * blinkeffect))
            If (wearingnightvision = $00) Then
                If (0.0 < eyeirritation) Then
                    blinktimer = (blinktimer - (min(((eyeirritation / 100.0) + 1.0), 4.0) * local0\Field3[$00]))
                EndIf
            EndIf
            local8 = max(local8, 0.0)
        EndIf
        eyeirritation = max(0.0, (eyeirritation - local0\Field3[$00]))
        If (0.0 < blinkeffecttimer) Then
            blinkeffecttimer = (blinkeffecttimer - (local0\Field3[$00] / 70.0))
        ElseIf (1.0 <> blinkeffect) Then
            blinkeffect = 1.0
        EndIf
        lightblink = max((lightblink - (local0\Field3[$00] / 35.0)), 0.0)
        If (((0.0 < lightblink) And (wearingnightvision = $00)) <> 0) Then
            local8 = min(max(local8, (rnd(0.3, 0.8) * lightblink)), 1.0)
        EndIf
        If (using294 <> 0) Then
            local8 = 1.0
        EndIf
        If (wearingnightvision = $00) Then
            local8 = max(((1.0 - secondarylighton) * 0.9), local8)
        EndIf
        If (0.0 > killtimer) Then
            invopen = $00
            selecteditem = Null
            selectedscreen = Null
            selectedmonitor = Null
            blurtimer = (Abs (killtimer * 5.0))
            killtimer = (killtimer - (local0\Field3[$00] * 0.8))
            If (-360.0 > killtimer) Then
                ms\Field1 = $01
                If (i_end\Field2 <> "") Then
                    i_end\Field0 = min(killtimer, -0.1)
                EndIf
            EndIf
            local8 = max(local8, min((Abs (killtimer / 400.0)), 1.0))
        EndIf
        If (0.0 > falltimer) Then
            If (selecteditem <> Null) Then
                If ((instr(selecteditem\Field3\Field1, "hazmatsuit", $01) Or instr(selecteditem\Field3\Field1, "vest", $01)) <> 0) Then
                    If (((wearinghazmat = $00) And (wearingvest = $00)) <> 0) Then
                        dropitem(selecteditem, $01)
                    EndIf
                EndIf
            EndIf
            invopen = $00
            selecteditem = Null
            selectedscreen = Null
            selectedmonitor = Null
            blurtimer = (Abs (falltimer * 10.0))
            falltimer = (falltimer - local0\Field3[$00])
            local8 = max(local8, min((Abs (falltimer / 400.0)), 1.0))
        EndIf
        If (selecteditem <> Null) Then
            If (((selecteditem\Field3\Field1 = "navigator") Or (selecteditem\Field3\Field1 = "nav")) <> 0) Then
                local8 = max(local8, 0.5)
            EndIf
        EndIf
        If (selectedscreen <> Null) Then
            local8 = max(local8, 0.5)
        EndIf
        entityalpha(at\Field4[$0D], local8)
    EndIf
    If (0.0 < lightflash) Then
        showentity(at\Field4[$0E])
        entityalpha(at\Field4[$0E], max(min((rnd(-0.2, 0.2) + lightflash), 1.0), 0.0))
        lightflash = max((lightflash - (local0\Field3[$00] / 70.0)), 0.0)
    Else
        hideentity(at\Field4[$0E])
    EndIf
    entitycolor(at\Field4[$0E], 255.0, 255.0, 255.0)
    If ((keyhit(key_inv) And (0.0 <= vomittimer)) <> 0) Then
        If ((((unabletomove = $00) And (i_008\Field1 = $00)) And (using294 = $00)) <> 0) Then
            local10 = ""
            local11 = 0.0
            If (selecteditem <> Null) Then
                local10 = selecteditem\Field3\Field1
                local11 = selecteditem\Field13
            EndIf
            If ((((((((local10 <> "vest") And (local10 <> "finevest")) And (local10 <> "hazmatsuit")) And (local10 <> "hazmatsuit2")) And (local10 <> "hazmatsuit3")) Or (0.0 = local11)) Or (100.0 = local11)) <> 0) Then
                If (invopen <> 0) Then
                    resumesounds()
                    mousexspeed()
                    mouseyspeed()
                    mousezspeed()
                    mouse_x_speed_1 = 0.0
                    mouse_y_speed_1 = 0.0
                    mouse_x_leverturn = 0.0
                    mouse_y_leverturn = 0.0
                Else
                    pausesounds()
                EndIf
                invopen = (invopen = $00)
                If (otheropen <> Null) Then
                    otheropen = Null
                EndIf
                selecteditem = Null
            EndIf
        EndIf
    EndIf
    If (keyhit(key_save) <> 0) Then
        If (selecteddifficulty\Field4 = $00) Then
            local5 = playerroom\Field7\Field10
            If ((((local5 = "room173intro") Or ((local5 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00)))) Or (local5 = "gatea")) <> 0) Then
                msg = scplang_getphrase("ingame.save1")
                msgtimer = 280.0
            ElseIf (((cansave = $00) Or (quickloadpercent > $FFFFFFFF)) <> 0) Then
                msg = scplang_getphrase("ingame.save2")
                msgtimer = 280.0
                If (quickloadpercent > $FFFFFFFF) Then
                    msg = ((msg + " ") + scplang_getphrase("ingame.save3"))
                EndIf
            Else
                savegame((("Saves\" + currsave) + "\"))
            EndIf
        ElseIf (selecteddifficulty\Field4 = $02) Then
            If (((selectedscreen = Null) And (selectedmonitor = Null)) <> 0) Then
                msg = scplang_getphrase("ingame.save4")
                msgtimer = 280.0
            Else
                local5 = playerroom\Field7\Field10
                If ((((local5 = "room173intro") Or ((local5 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00)))) Or (local5 = "gatea")) <> 0) Then
                    msg = scplang_getphrase("ingame.save1")
                    msgtimer = 280.0
                ElseIf (((cansave = $00) Or (quickloadpercent > $FFFFFFFF)) <> 0) Then
                    msg = scplang_getphrase("ingame.save2")
                    msgtimer = 280.0
                    If (quickloadpercent > $FFFFFFFF) Then
                        msg = ((msg + " ") + scplang_getphrase("ingame.save3"))
                    EndIf
                Else
                    If (selectedscreen <> Null) Then
                        gamesaved = $00
                        playable = $01
                        dropspeed = 0.0
                    EndIf
                    savegame((("Saves\" + currsave) + "\"))
                EndIf
            EndIf
        Else
            msg = scplang_getphrase("ingame.save6")
            msgtimer = 280.0
        EndIf
    ElseIf (((selecteddifficulty\Field4 = $02) And ((selectedscreen <> Null) Or (selectedmonitor <> Null))) <> 0) Then
        If (((((msg <> scplang_getphrase("ingame.save5")) And (msg <> scplang_getphrase("ingame.save1"))) And (msg <> scplang_getphrase("ingame.save2"))) Or (0.0 >= msgtimer)) <> 0) Then
            msg = ((((scplang_getphrase("events.press") + " ") + keyname(key_save)) + " ") + scplang_getphrase("ingame.save7"))
            msgtimer = 280.0
        EndIf
        If (mousehit2 <> 0) Then
            selectedmonitor = Null
        EndIf
    EndIf
    If (keyhit(key_console) <> 0) Then
        If (canopenconsole <> 0) Then
            If (consoleopen <> 0) Then
                usedconsole = $01
                resumesounds()
                mousexspeed()
                mouseyspeed()
                mousezspeed()
                mouse_x_speed_1 = 0.0
                mouse_y_speed_1 = 0.0
                mouse_x_leverturn = 0.0
                mouse_y_leverturn = 0.0
            Else
                pausesounds()
            EndIf
            consoleopen = (consoleopen = $00)
            flushkeys()
        EndIf
    EndIf
    drawgui()
    If (0.0 > i_end\Field0) Then
        If (i_end\Field2 <> "") Then
            drawending()
        EndIf
    Else
        drawmenu()
    EndIf
    updateconsole()
    If (playerroom <> Null) Then
        If (playerroom\Field7\Field10 = "room173intro") Then
            For local3 = Each events
                If (local3\Field0 = "room173intro") Then
                    If (((40.0 <= local3\Field4) And (50.0 > local3\Field4)) <> 0) Then
                        If (invopen <> 0) Then
                            msg = scplang_getphrase("ingame.doubledoc")
                            msgtimer = 490.0
                            local3\Field4 = 50.0
                        EndIf
                    EndIf
                EndIf
            Next
        EndIf
    EndIf
    If (0.0 < msgtimer) Then
        msgtimer = (msgtimer - local0\Field3[$01])
    EndIf
    If (0.0 < msgtimer) Then
        local12 = $00
        If (invopen = $00) Then
            If (selecteditem <> Null) Then
                If (((selecteditem\Field3\Field1 = "paper") Or (selecteditem\Field3\Field1 = "oldpaper")) <> 0) Then
                    local12 = $01
                EndIf
            EndIf
        EndIf
        If (local12 = $00) Then
            color($00, $00, $00)
            aatext(((graphicwidth Sar $01) + $01), ((graphicheight Sar $01) + $C9), msg, $01, $00, (min((msgtimer / 2.0), 255.0) / 255.0))
            color($FF, $FF, $FF)
            If (left(msg, $0E) = "Blitz3D Error!") Then
                color($FF, $00, $00)
            EndIf
            aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $C8), msg, $01, $00, (min((msgtimer / 2.0), 255.0) / 255.0))
        Else
            color($00, $00, $00)
            aatext(((graphicwidth Sar $01) + $01), (Int (((Float graphicheight) * 0.94) + 1.0)), msg, $01, $00, (min((msgtimer / 2.0), 255.0) / 255.0))
            color($FF, $FF, $FF)
            If (left(msg, $0E) = "Blitz3D Error!") Then
                color($FF, $00, $00)
            EndIf
            aatext((graphicwidth Sar $01), (Int ((Float graphicheight) * 0.94)), msg, $01, $00, (min((msgtimer / 2.0), 255.0) / 255.0))
        EndIf
    EndIf
    color($FF, $FF, $FF)
    If (showfps <> 0) Then
        aasetfont(local1\Field1)
        aatext($14, $14, ("FPS: " + (Str local0\Field7)), $00, $00, 1.0)
        aasetfont(local1\Field0[$00])
    EndIf
    drawquickloading()
    updateachievementmsg()
    renderachievementmsg()
    Return $00
End Function
