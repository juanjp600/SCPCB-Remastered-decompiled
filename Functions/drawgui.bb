Function drawgui%()
    Local local0.fonts
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11%
    Local local12%
    Local local13%
    Local local14$
    Local local15.objects
    Local local16.fps_settings
    Local local17.events
    Local local18.items
    Local local20%
    Local local21%
    Local local22.events
    Local local23%
    Local local24.npcs
    Local local25%
    Local local26.chunk
    Local local27%
    Local local28%
    Local local29%
    Local local30%
    Local local31#
    Local local32#
    Local local34%
    Local local35.items
    Local local36%
    Local local37%
    Local local38%
    Local local39%
    Local local40%
    Local local41%
    Local local42$
    Local local44$
    Local local48.items
    Local local49$
    Local local50$
    Local local51%
    Local local52%
    Local local55$
    Local local60$
    Local local61.rooms
    Local local64$
    Local local65%
    Local local71%
    Local local72%
    Local local73%
    Local local74%
    Local local75%
    Local local76%
    Local local77%
    Local local78%
    Local local79%
    Local local80%
    Local local81%
    Local local82%
    Local local83#
    Local local84.npcs
    Local local85$
    Local local86$
    Local local90.decals
    Local local91%
    Local local92%
    Local local94$
    Local local95.items
    Local local96$
    local0 = (First fonts)
    local15 = (First objects)
    local16 = (First fps_settings)
    If ((((((ms\Field1 Or consoleopen) Or (selecteddoor <> Null)) Or invopen) Or (otheropen <> Null)) Or (0.0 > i_end\Field0)) <> 0) Then
        showpointer()
    Else
        hidepointer()
    EndIf
    If (playerroom\Field7\Field10 = "pocketdimension") Then
        For local17 = Each events
            If (local17\Field1 = playerroom) Then
                If (1000.0 > (Float local17\Field15)) Then
                    If (600.0 < local17\Field2) Then
                        If (((-3.0 > blinktimer) And (-10.0 < blinktimer)) <> 0) Then
                            If (local17\Field16 = $00) Then
                                If (((-5.0 < blinktimer) And (rand($1E, $01) = $01)) <> 0) Then
                                    playsound_strict(dripsfx(rand($00, $05)))
                                    If (local17\Field16 = $00) Then
                                        local17\Field16 = loadimage_strict(scpmodding_processfilepath("GFX\npcs\scp_106_face.png"))
                                    EndIf
                                EndIf
                            Else
                                drawimage(local17\Field16, ((graphicwidth Sar $01) - rand($186, $136)), ((graphicheight Sar $01) - rand($122, $136)), $00)
                            EndIf
                        ElseIf (local17\Field16 <> $00) Then
                            freeimage(local17\Field16)
                            local17\Field16 = $00
                        EndIf
                        Exit
                    EndIf
                Else
                    If (((-3.0 > blinktimer) And (-10.0 < blinktimer)) <> 0) Then
                        If (local17\Field16 = $00) Then
                            If (-5.0 < blinktimer) Then
                                If (local17\Field16 = $00) Then
                                    local17\Field16 = loadimage_strict(scpmodding_processfilepath("GFX\kneelmortal.pd"))
                                    If (channelplaying(local17\Field6) <> 0) Then
                                        stopchannel(local17\Field6)
                                    EndIf
                                    local17\Field6 = playsound_strict(local17\Field9)
                                EndIf
                            EndIf
                        Else
                            drawimage(local17\Field16, ((graphicwidth Sar $01) - rand($186, $136)), ((graphicheight Sar $01) - rand($122, $136)), $00)
                        EndIf
                    Else
                        If (local17\Field16 <> $00) Then
                            freeimage(local17\Field16)
                            local17\Field16 = $00
                        EndIf
                        If (-3.0 > blinktimer) Then
                            If (channelplaying(local17\Field6) = $00) Then
                                local17\Field6 = playsound_strict(local17\Field9)
                            EndIf
                        ElseIf (channelplaying(local17\Field6) <> 0) Then
                            stopchannel(local17\Field6)
                        EndIf
                    EndIf
                    Exit
                EndIf
            EndIf
        Next
    EndIf
    If ((((((closestbutton <> $00) And (selecteddoor = Null)) And (invopen = $00)) And (ms\Field1 = $00)) And (otheropen = Null)) <> 0) Then
        local1 = createpivot($00)
        positionentity(local1, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        pointentity(local1, closestbutton, 0.0)
        local6 = wrapangle((entityyaw(camera, $00) - entityyaw(local1, $00)))
        If (((90.0 < local6) And (180.0 >= local6)) <> 0) Then
            local6 = 90.0
        EndIf
        If (((180.0 < local6) And (270.0 > local6)) <> 0) Then
            local6 = 270.0
        EndIf
        local7 = wrapangle((entitypitch(camera, $00) - entitypitch(local1, $00)))
        If (((90.0 < local7) And (180.0 >= local7)) <> 0) Then
            local7 = 90.0
        EndIf
        If (((180.0 < local7) And (270.0 > local7)) <> 0) Then
            local7 = 270.0
        EndIf
        freeentity(local1)
        drawimage(handicon, (Int ((((Float (graphicwidth / $03)) * sin(local6)) + (Float (graphicwidth Sar $01))) - 32.0)), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local7))) - 32.0)), $00)
        If (mouseup1 <> 0) Then
            mouseup1 = $00
            If (closestdoor <> Null) Then
                If (closestdoor\Field17 <> "") Then
                    selecteddoor = closestdoor
                ElseIf (playable <> 0) Then
                    playsound2(buttonsfx, camera, closestbutton, 10.0, 1.0)
                    usedoor(closestdoor, $01, $01)
                EndIf
            EndIf
        EndIf
    EndIf
    If (closestitem <> Null) Then
        local6 = (- deltayaw(camera, closestitem\Field1))
        If (((90.0 < local6) And (180.0 >= local6)) <> 0) Then
            local6 = 90.0
        EndIf
        If (((180.0 < local6) And (270.0 > local6)) <> 0) Then
            local6 = 270.0
        EndIf
        local7 = (- deltapitch(camera, closestitem\Field1))
        If (((90.0 < local7) And (180.0 >= local7)) <> 0) Then
            local7 = 90.0
        EndIf
        If (((180.0 < local7) And (270.0 > local7)) <> 0) Then
            local7 = 270.0
        EndIf
        drawimage(handicon2, (Int ((((Float (graphicwidth / $03)) * sin(local6)) + (Float (graphicwidth Sar $01))) - 32.0)), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local7))) - 32.0)), $00)
    EndIf
    If (drawhandicon <> 0) Then
        drawimage(handicon, ((graphicwidth Sar $01) - $20), ((graphicheight Sar $01) - $20), $00)
    EndIf
    For local5 = $00 To $03 Step $01
        If (drawarrowicon(local5) <> 0) Then
            local2 = ((graphicwidth Sar $01) - $20)
            local3 = ((graphicheight Sar $01) - $20)
            Select local5
                Case $00
                    local3 = ((local3 - $40) - $05)
                Case $01
                    local2 = ((local2 + $40) + $05)
                Case $02
                    local3 = ((local3 + $40) + $05)
                Case $03
                    local2 = ((local2 - $05) - $40)
            End Select
            drawimage(handicon, local2, local3, $00)
            drawimage(arrowimg(local5), (local2 + $15), (local3 + $15), $00)
            drawarrowicon(local5) = $00
        EndIf
    Next
    If (using294 <> 0) Then
        use294()
    EndIf
    If (hudenabled <> 0) Then
        local20 = $CC
        local21 = $14
        local2 = $50
        local3 = (graphicheight - $5F)
        color($FF, $FF, $FF)
        rect(local2, local3, local20, local21, $00)
        For local5 = $01 To (Int (((blinktimer / blinkfreq) * (Float (local20 - $02))) / 10.0)) Step $01
            drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
        Next
        color($00, $00, $00)
        rect((local2 - $32), local3, $1E, $1E, $01)
        If ((((550.0 < blurtimer) Or (1.0 < blinkeffect)) Or (0.0 < lightflash)) <> 0) Then
            color($C8, $00, $00)
            rect(((local2 - $32) - $03), (local3 - $03), $24, $24, $01)
        ElseIf (((0.0 < lightblink) And (wearingnightvision = $00)) <> 0) Then
            color($C8, $00, $00)
            rect(((local2 - $32) - $03), (local3 - $03), $24, $24, $01)
        ElseIf (((0.0 < eyeirritation) And (wearingnightvision = $00)) <> 0) Then
            color($C8, $00, $00)
            rect(((local2 - $32) - $03), (local3 - $03), $24, $24, $01)
        ElseIf (1.0 > blinkeffect) Then
            color($00, $C8, $00)
            rect(((local2 - $32) - $03), (local3 - $03), $24, $24, $01)
        EndIf
        If (((((((playerroom\Field7\Field10 = "pocketdimension") Or (i_714\Field0 > $00)) Or (1.5 <= injuries)) Or (1.0 < staminaeffect)) Or (wearinghazmat > $00)) Or (wearingvest = $02)) <> 0) Then
            color($C8, $00, $00)
            rect(((local2 - $32) - $03), (local3 + $25), $24, $24, $01)
        ElseIf (((((chs\Field4 = $01) Or (1.0 > staminaeffect)) Or (wearinggasmask = $02)) Or (i_1499\Field0 = $02)) <> 0) Then
            color($00, $C8, $00)
            rect(((local2 - $32) - $03), (local3 + $25), $24, $24, $01)
        EndIf
        color($FF, $FF, $FF)
        rect(((local2 - $32) - $01), (local3 - $01), $20, $20, $00)
        drawimage(blinkicon, (local2 - $32), local3, $00)
        local3 = (graphicheight - $37)
        color($FF, $FF, $FF)
        rect(local2, local3, local20, local21, $00)
        For local5 = $01 To (Int (((stamina / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
            drawimage(staminameterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
        Next
        color($00, $00, $00)
        rect((local2 - $32), local3, $1E, $1E, $01)
        color($FF, $FF, $FF)
        rect(((local2 - $32) - $01), (local3 - $01), $20, $20, $00)
        If (crouch <> 0) Then
            drawimage(crouchicon, (local2 - $32), local3, $00)
        Else
            drawimage(sprinticon, (local2 - $32), local3, $00)
        EndIf
        If (debughud <> 0) Then
            color($FF, $FF, $FF)
            aasetfont(local0\Field1)
            aatext((local2 - $3C), $28, "*******************************", $00, $00, 1.0)
            aatext((local2 - $3C), $3C, ("Room: " + playerroom\Field7\Field10), $00, $00, 1.0)
            aatext((local2 - $3C), $50, (((((("Room coordinates: (" + (Str floor(((entityx(playerroom\Field2, $00) / 8.0) + 0.5)))) + ", ") + (Str floor(((entityz(playerroom\Field2, $00) / 8.0) + 0.5)))) + ", angle: ") + (Str playerroom\Field6)) + ")"), $00, $00, 1.0)
            For local22 = Each events
                If (local22\Field1 = playerroom) Then
                    aatext((local2 - $3C), $64, ("Room event: " + local22\Field0), $00, $00, 1.0)
                    aatext((local2 - $3C), $78, ("state: " + (Str local22\Field2)), $00, $00, 1.0)
                    aatext((local2 - $3C), $8C, ("state2: " + (Str local22\Field3)), $00, $00, 1.0)
                    aatext((local2 - $3C), $A0, ("state3: " + (Str local22\Field4)), $00, $00, 1.0)
                    aatext((local2 - $3C), $B4, ("state4: " + (Str local22\Field5)), $00, $00, 1.0)
                    aatext((local2 - $3C), $C8, ("str: " + local22\Field15), $00, $00, 1.0)
                    Exit
                EndIf
            Next
            aatext((local2 - $3C), $DC, (((((("Player Position: (" + f2s(entityx(collider, $00), $03)) + ", ") + f2s(entityy(collider, $00), $03)) + ", ") + f2s(entityz(collider, $00), $03)) + ")"), $00, $00, 1.0)
            aatext((local2 - $3C), $F0, (((((("Camera Position: (" + f2s(entityx(camera, $00), $03)) + ", ") + f2s(entityy(camera, $00), $03)) + ", ") + f2s(entityz(camera, $00), $03)) + ")"), $00, $00, 1.0)
            aatext((local2 - $3C), $104, (((((("Player Rotation: (" + f2s(entitypitch(collider, $00), $03)) + ", ") + f2s(entityyaw(collider, $00), $03)) + ", ") + f2s(entityroll(collider, $00), $03)) + ")"), $00, $00, 1.0)
            aatext((local2 - $3C), $118, (((((("Camera Rotation: (" + f2s(entitypitch(camera, $00), $03)) + ", ") + f2s(entityyaw(camera, $00), $03)) + ", ") + f2s(entityroll(camera, $00), $03)) + ")"), $00, $00, 1.0)
            globalmemorystatus(m)
            aatext((local2 - $3C), $12C, (((((((("Memory: " + (Str ((m\Field3 Sar $0A) Sar $0A))) + " MB/") + (Str ((m\Field2 Sar $0A) Sar $0A))) + " MB (") + (Str (m\Field3 Sar $0A))) + " KB/") + (Str (m\Field2 Sar $0A))) + " KB)"), $00, $00, 1.0)
            aatext((local2 - $3C), $140, ("Triangles rendered: " + (Str currtrisamount)), $00, $00, 1.0)
            aatext((local2 - $3C), $154, ("Active textures: " + (Str activetextures())), $00, $00, 1.0)
            If (curr173 <> Null) Then
                aatext((local2 - $3C), $168, (((((("SCP - 173 Position (collider): (" + f2s(entityx(curr173\Field4, $00), $03)) + ", ") + f2s(entityy(curr173\Field4, $00), $03)) + ", ") + f2s(entityz(curr173\Field4, $00), $03)) + ")"), $00, $00, 1.0)
                aatext((local2 - $3C), $17C, (((((("SCP - 173 Position (obj): (" + f2s(entityx(curr173\Field0, $00), $03)) + ", ") + f2s(entityy(curr173\Field0, $00), $03)) + ", ") + f2s(entityz(curr173\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                aatext((local2 - $3C), $190, ("SCP - 173 State: " + (Str curr173\Field9)), $00, $00, 1.0)
            EndIf
            If (curr106 <> Null) Then
                aatext((local2 - $3C), $1A4, (((((("SCP - 106 Position: (" + f2s(entityx(curr106\Field0, $00), $03)) + ", ") + f2s(entityy(curr106\Field0, $00), $03)) + ", ") + f2s(entityz(curr106\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                aatext((local2 - $3C), $1B8, ("SCP - 106 Idle: " + (Str curr106\Field24)), $00, $00, 1.0)
                aatext((local2 - $3C), $1CC, ("SCP - 106 State: " + (Str curr106\Field9)), $00, $00, 1.0)
            EndIf
            local23 = $00
            For local24 = Each npcs
                If (local24\Field5 = $06) Then
                    aatext((local2 - $3C), $1E0, (((((("SCP - 096 Position: (" + f2s(entityx(local24\Field0, $00), $03)) + ", ") + f2s(entityy(local24\Field0, $00), $03)) + ", ") + f2s(entityz(local24\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                    aatext((local2 - $3C), $1F4, ("SCP - 096 Idle: " + (Str local24\Field24)), $00, $00, 1.0)
                    aatext((local2 - $3C), $208, ("SCP - 096 State: " + (Str local24\Field9)), $00, $00, 1.0)
                    aatext((local2 - $3C), $21C, ("SCP - 096 Speed: " + f2s(local24\Field22, $05)), $00, $00, 1.0)
                EndIf
                If (local24\Field5 = $03) Then
                    aatext((local2 - $3C), $230, (((((("SCP - 049 Position: (" + f2s(entityx(local24\Field0, $00), $03)) + ", ") + f2s(entityy(local24\Field0, $00), $03)) + ", ") + f2s(entityz(local24\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                    aatext((local2 - $3C), $244, ("SCP - 049 Idle: " + (Str local24\Field24)), $00, $00, 1.0)
                    aatext((local2 - $3C), $258, ("SCP - 049 State: " + (Str local24\Field9)), $00, $00, 1.0)
                    aatext((local2 - $3C), $26C, ("SCP - 049 Speed: " + f2s(local24\Field22, $05)), $00, $00, 1.0)
                EndIf
                If (local24\Field5 = $1A) Then
                    aatext((local2 - $3C), $280, (((((("SCP - 650 Position: (" + f2s(entityx(local24\Field0, $00), $03)) + ", ") + f2s(entityy(local24\Field0, $00), $03)) + ", ") + f2s(entityz(local24\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                    aatext((local2 - $3C), $294, ("SCP - 650 Idle: " + (Str local24\Field24)), $00, $00, 1.0)
                    aatext((local2 - $3C), $2A8, ("SCP - 650 State: " + (Str local24\Field9)), $00, $00, 1.0)
                    aatext((local2 - $3C), $2BC, ("SCP - 650 Speed: " + f2s(local24\Field22, $05)), $00, $00, 1.0)
                EndIf
                If (local24\Field5 = $05) Then
                    aatext((local2 - $3C), $2D0, (((((("SCP - 066 Position: (" + f2s(entityx(local24\Field0, $00), $03)) + ", ") + f2s(entityy(local24\Field0, $00), $03)) + ", ") + f2s(entityz(local24\Field0, $00), $03)) + ")"), $00, $00, 1.0)
                    aatext((local2 - $3C), $2E4, ("SCP - 066 Idle: " + (Str local24\Field24)), $00, $00, 1.0)
                    aatext((local2 - $3C), $2F8, ("SCP - 066 State: " + (Str local24\Field9)), $00, $00, 1.0)
                    aatext((local2 - $3C), $30C, ("SCP - 066 Speed: " + f2s(local24\Field22, $05)), $00, $00, 1.0)
                EndIf
            Next
            If (playerroom\Field7\Field10 = "dimension1499") Then
                aatext((local2 - $3C), $320, (((("Current Chunk X/Z: (" + (Str (Int ((entityx(collider, $00) + 20.0) / 40.0)))) + ", ") + (Str (Int ((entityz(collider, $00) + 20.0) / 40.0)))) + ")"), $00, $00, 1.0)
                local25 = $00
                For local26 = Each chunk
                    local25 = (local25 + $01)
                Next
                aatext((local2 - $3C), $334, ("Current Chunk Amount: " + (Str local25)), $00, $00, 1.0)
            Else
                aatext((local2 - $3C), $348, (((((("Current Room Position: (" + (Str playerroom\Field3)) + ", ") + (Str playerroom\Field4)) + ", ") + (Str playerroom\Field5)) + ")"), $00, $00, 1.0)
            EndIf
            If (selectedmonitor <> Null) Then
                aatext((local2 - $3C), $35C, ("Current Monitor: " + (Str selectedmonitor\Field4)), $00, $00, 1.0)
            Else
                aatext((local2 - $3C), $370, "Current Monitor: NULL", $00, $00, 1.0)
            EndIf
            aatext((local2 - $3C), $384, "*******************************", $00, $00, 1.0)
            aatext((local2 + $17C), $28, "*******************************", $00, $00, 1.0)
            aatext((local2 + $17C), $3C, ("Stamina: " + f2s(stamina, $03)), $00, $00, 1.0)
            aatext((local2 + $17C), $50, ("Death timer: " + f2s(killtimer, $03)), $00, $00, 1.0)
            aatext((local2 + $17C), $64, ("Blink timer: " + f2s(blinktimer, $03)), $00, $00, 1.0)
            aatext((local2 + $17C), $78, ("Injuries: " + (Str injuries)), $00, $00, 1.0)
            aatext((local2 + $17C), $8C, ("Bloodloss: " + (Str bloodloss)), $00, $00, 1.0)
            aatext((local2 + $17C), $A0, ("Vomit Timer: " + (Str vomittimer)), $00, $00, 1.0)
            aatext((local2 + $17C), $B4, ("Blur Timer: " + (Str blurtimer)), $00, $00, 1.0)
            aatext((local2 + $17C), $C8, ("Light Blink: " + (Str lightblink)), $00, $00, 1.0)
            aatext((local2 + $17C), $DC, ("Light Flash: " + (Str lightflash)), $00, $00, 1.0)
            aatext((local2 + $17C), $F0, ("Sanity: " + (Str sanity)), $00, $00, 1.0)
            aatext((local2 + $17C), $104, ("Blink Effect Timer: " + (Str blinkeffecttimer)), $00, $00, 1.0)
            aatext((local2 + $17C), $118, ("Stamina Effect Timer: " + (Str staminaeffecttimer)), $00, $00, 1.0)
            aatext((local2 + $17C), $12C, ("MTF Timer: " + (Str mtftimer)), $00, $00, 1.0)
            aatext((local2 + $17C), $140, ("SCP-008 Infection: " + (Str i_008\Field0)), $00, $00, 1.0)
            aatext((local2 + $17C), $154, ("SCP-427 State (secs): " + (Str (Int (i_427\Field1 / 70.0)))), $00, $00, 1.0)
            For local5 = $00 To $05 Step $01
                aatext((local2 + $17C), (($14 * local5) + $168), ((("SCP-1025 State " + (Str local5)) + ": ") + (Str scp1025state[local5])), $00, $00, 1.0)
            Next
            aatext((local2 + $17C), $1E0, "*******************************", $00, $00, 1.0)
            aatext((local2 + $2D0), $28, "********** MOD STATS **********", $00, $00, 1.0)
            aatext((local2 + $2D0), $3C, ("BubbleFoam: " + (Str i_1079\Field0)), $00, $00, 1.0)
            aatext((local2 + $2D0), $50, ("BubbleTrigger: " + (Str i_1079\Field1)), $00, $00, 1.0)
            aatext((local2 + $2D0), $64, ("Taken SCP-1079-01: " + (Str i_1079\Field2)), $00, $00, 1.0)
            aatext((local2 + $2D0), $78, ("MTF2 Timer: " + (Str mtf2timer)), $00, $00, 1.0)
            If (i_1033ru\Field2 = $01) Then
                aatext((local2 + $2D0), $8C, (("HP of SCP-1033-RU: " + (Str i_1033ru\Field0)) + "/100"), $00, $00, 1.0)
                aatext((local2 + $2D0), $A0, (("Lost HP of SCP-1033-RU: " + (Str i_1033ru\Field1)) + "/100"), $00, $00, 1.0)
            ElseIf (i_1033ru\Field2 = $02) Then
                aatext((local2 + $2D0), $8C, (("HP of SCP-1033-RU: " + (Str i_1033ru\Field0)) + "/200"), $00, $00, 1.0)
                aatext((local2 + $2D0), $A0, (("Lost HP of SCP-1033-RU: " + (Str i_1033ru\Field1)) + "/200"), $00, $00, 1.0)
            EndIf
            aatext((local2 + $2D0), $B4, ("SCP-409 Crystallization: " + (Str i_409\Field0)), $00, $00, 1.0)
            aatext((local2 + $2D0), $C8, ("SCP-215 Idle State: " + (Str i_215\Field2)), $00, $00, 1.0)
            aatext((local2 + $2D0), $DC, ("SCP-215 State: " + (Str i_215\Field1)), $00, $00, 1.0)
            aatext((local2 + $2D0), $F0, ("SCP-207 State: " + (Str i_207\Field0)), $00, $00, 1.0)
            aatext((local2 + $2D0), $104, ("SCP-402 State: " + (Str i_402\Field1)), $00, $00, 1.0)
            aatext((local2 + $2D0), $118, ("SCP-357 State: " + (Str i_357\Field0)), $00, $00, 1.0)
            aatext((local2 + $2D0), $12C, "*******************************", $00, $00, 1.0)
            aasetfont(local0\Field0[$00])
        EndIf
    EndIf
    If (selectedscreen <> Null) Then
        drawimage(selectedscreen\Field2, ((graphicwidth Sar $01) - (imagewidth(selectedscreen\Field2) Sar $01)), ((graphicheight Sar $01) - (imageheight(selectedscreen\Field2) Sar $01)), $00)
        If ((mouseup1 Or mousehit2) <> 0) Then
            freeimage(selectedscreen\Field2)
            selectedscreen\Field2 = $00
            selectedscreen = Null
            mouseup1 = $00
        EndIf
    EndIf
    local27 = invopen
    local28 = $42
    local29 = $01
    If (selecteddoor <> Null) Then
        If (selecteditem <> Null) Then
            If (selecteditem\Field3\Field1 = "scp005") Then
                local29 = $00
                If (selecteddoor\Field17 <> "ABCD") Then
                    selecteddoor\Field4 = $01
                    If (selecteddoor\Field17 = (Str accesscode)) Then
                        giveachievement($20, $01)
                    ElseIf (selecteddoor\Field17 = "7816") Then
                        giveachievement($1E, $01)
                    ElseIf (selecteddoor\Field17 = "2411") Then
                        giveachievement($38, $01)
                    ElseIf (selecteddoor\Field17 = "1311") Then
                        giveachievement($36, $01)
                    EndIf
                    selecteddoor\Field4 = $00
                    usedoor(selecteddoor, $01, $01)
                    selecteddoor = Null
                    playsound_strict(scannersfx1)
                    msg = scplang_getphrase("ingame.keykeypad")
                    msgtimer = 350.0
                Else
                    selecteddoor = Null
                    playsound_strict(scannersfx2)
                    msg = scplang_getphrase("ingame.keykeypaderr")
                    msgtimer = 350.0
                EndIf
            EndIf
        EndIf
        selecteditem = Null
        If (local29 <> 0) Then
            local30 = createpivot($00)
            positionentity(local30, entityx(closestbutton, $01), entityy(closestbutton, $01), entityz(closestbutton, $01), $00)
            rotateentity(local30, 0.0, (entityyaw(closestbutton, $01) - 180.0), 0.0, $00)
            moveentity(local30, 0.0, 0.0, 0.22)
            positionentity(camera, entityx(local30, $00), entityy(local30, $00), entityz(local30, $00), $00)
            pointentity(camera, closestbutton, 0.0)
            freeentity(local30)
            cameraproject(camera, entityx(closestbutton, $01), (entityy(closestbutton, $01) + (meshheight(local15\Field4[$00]) * 0.015)), entityz(closestbutton, $01))
            local31 = projectedy()
            cameraproject(camera, entityx(closestbutton, $01), (entityy(closestbutton, $01) - (meshheight(local15\Field4[$00]) * 0.015)), entityz(closestbutton, $01))
            local32 = ((projectedy() - local31) / 462.0)
            local2 = (Int ((Float (graphicwidth Sar $01)) - (((Float imagewidth(keypadhud)) * local32) / 2.0)))
            local3 = (Int ((Float (graphicheight Sar $01)) - (((Float imageheight(keypadhud)) * local32) / 2.0)))
            aasetfont(local0\Field0[$02])
            If (keypadmsg <> "") Then
                keypadtimer = (keypadtimer - local16\Field3[$01])
                If (35.0 > (keypadtimer Mod 70.0)) Then
                    aatext((graphicwidth Sar $01), (Int ((124.0 * local32) + (Float local3))), keypadmsg, $01, $01, 1.0)
                EndIf
                If (0.0 >= keypadtimer) Then
                    keypadmsg = ""
                    selecteddoor = Null
                    mousexspeed()
                    mouseyspeed()
                    mousezspeed()
                    mouse_x_speed_1 = 0.0
                    mouse_y_speed_1 = 0.0
                    mouse_x_leverturn = 0.0
                    mouse_y_leverturn = 0.0
                EndIf
            Else
                aatext((graphicwidth Sar $01), (Int ((70.0 * local32) + (Float local3))), (scplang_getphrase("ingame.accesscode") + " "), $01, $01, 1.0)
                aasetfont(local0\Field0[$03])
                aatext((graphicwidth Sar $01), (Int ((124.0 * local32) + (Float local3))), keypadinput, $01, $01, 1.0)
            EndIf
            local2 = (Int ((44.0 * local32) + (Float local2)))
            local3 = (Int ((249.0 * local32) + (Float local3)))
            For local11 = $00 To $03 Step $01
                For local5 = $00 To $02 Step $01
                    local12 = ((Int ((58.5 * local32) * (Float local11))) + local2)
                    local13 = (Int (((67.0 * local32) * (Float local5)) + (Float local3)))
                    local1 = $00
                    If ((mouseon(local12, local13, (Int (54.0 * local32)), (Int (65.0 * local32))) And (keypadmsg = "")) <> 0) Then
                        If (mouseup1 <> 0) Then
                            playsound_strict(buttonsfx)
                            Select ((local11 + $01) + (local5 Shl $02))
                                Case $01,$02,$03
                                    keypadinput = (keypadinput + (Str ((local11 + $01) + (local5 Shl $02))))
                                Case $04
                                    keypadinput = (keypadinput + "0")
                                Case $05,$06,$07
                                    keypadinput = (keypadinput + (Str (((local11 + $01) + (local5 Shl $02)) - $01)))
                                Case $08
                                    If (keypadinput = selecteddoor\Field17) Then
                                        playsound_strict(scannersfx1)
                                        If (selecteddoor\Field17 = (Str accesscode)) Then
                                            giveachievement($20, $01)
                                        ElseIf (selecteddoor\Field17 = "7816") Then
                                            giveachievement($1E, $01)
                                        ElseIf (selecteddoor\Field17 = "2411") Then
                                            giveachievement($38, $01)
                                        ElseIf (selecteddoor\Field17 = "1311") Then
                                            giveachievement($36, $01)
                                        EndIf
                                        selecteddoor\Field4 = $00
                                        usedoor(selecteddoor, $01, $01)
                                        selecteddoor = Null
                                        mousexspeed()
                                        mouseyspeed()
                                        mousezspeed()
                                        mouse_x_speed_1 = 0.0
                                        mouse_y_speed_1 = 0.0
                                        mouse_x_leverturn = 0.0
                                        mouse_y_leverturn = 0.0
                                    Else
                                        playsound_strict(scannersfx2)
                                        keypadmsg = scplang_getphrase("ingame.accessdenied")
                                        keypadtimer = 210.0
                                        keypadinput = ""
                                    EndIf
                                Case $09,$0A,$0B
                                    keypadinput = (keypadinput + (Str (((local11 + $01) + (local5 Shl $02)) - $02)))
                                Case $0C
                                    keypadinput = ""
                            End Select
                            If (len(keypadinput) > $04) Then
                                keypadinput = left(keypadinput, $04)
                            EndIf
                        EndIf
                    Else
                        local1 = $00
                    EndIf
                Next
            Next
            If (fullscreen <> 0) Then
                drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
            EndIf
            If (mousehit2 <> 0) Then
                selecteddoor = Null
                mousexspeed()
                mouseyspeed()
                mousezspeed()
                mouse_x_speed_1 = 0.0
                mouse_y_speed_1 = 0.0
                mouse_x_leverturn = 0.0
                mouse_y_leverturn = 0.0
            EndIf
        Else
            selecteddoor = Null
        EndIf
    Else
        keypadinput = ""
        keypadtimer = 0.0
        keypadmsg = ""
    EndIf
    If (((keyhit($01) And (0.0 = i_end\Field0)) And (using294 = $00)) <> 0) Then
        If ((ms\Field1 Or invopen) <> 0) Then
            resumesounds()
            If (optionsmenu <> $00) Then
                saveoptionsini()
            EndIf
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
        ms\Field1 = (ms\Field1 = $00)
        achievementsmenu = $00
        optionsmenu = $00
        quitmsg = $00
        selecteddoor = Null
        selectedscreen = Null
        selectedmonitor = Null
        If (selecteditem <> Null) Then
            If ((instr(selecteditem\Field3\Field1, "vest", $01) Or instr(selecteditem\Field3\Field1, "hazmatsuit", $01)) <> 0) Then
                If (((wearingvest = $00) And (wearinghazmat = $00)) <> 0) Then
                    dropitem(selecteditem, $01)
                EndIf
                selecteditem = Null
            EndIf
        EndIf
    EndIf
    If (otheropen <> Null) Then
        If (playerroom\Field7\Field10 = "gatea") Then
            hideentity(at\Field4[$00])
            camerafogrange(camera, 5.0, 30.0)
            camerafogcolor(camera, 200.0, 200.0, 200.0)
            cameraclscolor(camera, 200.0, 200.0, 200.0)
            camerarange(camera, 0.05, 30.0)
        ElseIf (((playerroom\Field7\Field10 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
            hideentity(at\Field4[$00])
            camerafogrange(camera, 5.0, 45.0)
            camerafogcolor(camera, 200.0, 200.0, 200.0)
            cameraclscolor(camera, 200.0, 200.0, 200.0)
            camerarange(camera, 0.05, 60.0)
        EndIf
        local35 = otheropen
        local36 = otheropen\Field23
        For local5 = $00 To (local36 - $01) Step $01
            If (otheropen\Field21[local5] <> Null) Then
                local37 = (local37 + $01)
            EndIf
        Next
        invopen = $00
        selecteddoor = Null
        local41 = $00
        local20 = $46
        local21 = $46
        local34 = $23
        local2 = ((graphicwidth Sar $01) - ((((local20 * maxitemamount) Sar $01) + (((maxitemamount Sar $01) - $01) * local34)) Sar $01))
        local3 = ((graphicheight Sar $01) - ((((local21 * local36) / $05) + (((local36 / $05) - $01) * local34)) Sar $01))
        itemamount = $00
        For local11 = $00 To (local36 - $01) Step $01
            local39 = $00
            If (((scaledmousex() > local2) And (scaledmousex() < (local2 + local20))) <> 0) Then
                If (((scaledmousey() > local3) And (scaledmousey() < (local3 + local21))) <> 0) Then
                    local39 = $01
                EndIf
            EndIf
            If (local39 <> 0) Then
                local28 = local11
                color($FF, $00, $00)
                rect((local2 - $01), (local3 - $01), (local20 + $02), (local21 + $02), $01)
            EndIf
            drawframe(local2, local3, local20, local21, (local2 Mod $40), (local2 Mod $40))
            If (otheropen = Null) Then
                Exit
            EndIf
            If (otheropen\Field21[local11] <> Null) Then
                If (((selecteditem <> otheropen\Field21[local11]) Or local39) <> 0) Then
                    drawimage(otheropen\Field21[local11]\Field17, (((local20 Sar $01) + local2) - $20), (((local21 Sar $01) + local3) - $20), $00)
                EndIf
            EndIf
            If (((otheropen\Field21[local11] <> Null) And (selecteditem <> otheropen\Field21[local11])) <> 0) Then
                If (local39 <> 0) Then
                    color($FF, $FF, $FF)
                    aatext(((local20 Sar $01) + local2), (((local3 + local21) + local34) - $0F), otheropen\Field21[local11]\Field3\Field0, $01, $00, 1.0)
                    If (selecteditem = Null) Then
                        If (mousehit1 <> 0) Then
                            selecteditem = otheropen\Field21[local11]
                            mousehit1 = $00
                            If (doubleclick <> 0) Then
                                If (otheropen\Field21[local11]\Field3\Field2 <> $42) Then
                                    playsound_strict(picksfx(otheropen\Field21[local11]\Field3\Field2))
                                EndIf
                                otheropen = Null
                                local40 = $01
                                invopen = $00
                                doubleclick = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
                itemamount = (itemamount + $01)
            ElseIf ((local39 And mousehit1) <> 0) Then
                For local4 = $00 To (local36 - $01) Step $01
                    If (otheropen\Field21[local4] = selecteditem) Then
                        otheropen\Field21[local4] = Null
                    EndIf
                Next
                otheropen\Field21[local11] = selecteditem
            EndIf
            local2 = ((local2 + local20) + local34)
            local41 = (local41 + $01)
            If (local41 = $05) Then
                local41 = $00
                local3 = (local3 + (local21 Shl $01))
                local2 = ((graphicwidth Sar $01) - ((((local20 * maxitemamount) Sar $01) + (((maxitemamount Sar $01) - $01) * local34)) Sar $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mousedown1 <> 0) Then
                If (local28 = $42) Then
                    drawimage(selecteditem\Field17, (scaledmousex() - (imagewidth(selecteditem\Field3\Field7) Sar $01)), (scaledmousey() - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                ElseIf (selecteditem <> local35\Field21[local28]) Then
                    drawimage(selecteditem\Field17, (scaledmousex() - (imagewidth(selecteditem\Field3\Field7) Sar $01)), (scaledmousey() - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                EndIf
            Else
                If (local28 = $42) Then
                    If (selecteditem\Field3\Field2 <> $42) Then
                        playsound_strict(picksfx(selecteditem\Field3\Field2))
                    EndIf
                    showentity(selecteditem\Field1)
                    positionentity(selecteditem\Field1, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                    rotateentity(selecteditem\Field1, entitypitch(camera, $00), entityyaw(camera, $00), 0.0, $00)
                    moveentity(selecteditem\Field1, 0.0, -0.1, 0.1)
                    rotateentity(selecteditem\Field1, 0.0, (Float rand($168, $01)), 0.0, $00)
                    resetentity(selecteditem\Field1)
                    selecteditem\Field4 = 0.0
                    selecteditem\Field15 = $00
                    For local4 = $00 To (local36 - $01) Step $01
                        If (otheropen\Field21[local4] = selecteditem) Then
                            otheropen\Field21[local4] = Null
                        EndIf
                    Next
                    local38 = $01
                    If (otheropen\Field3\Field1 = "wallet") Then
                        If (local38 = $00) Then
                            For local4 = $00 To (local36 - $01) Step $01
                                If (otheropen\Field21[local4] <> Null) Then
                                    local42 = otheropen\Field21[local4]\Field3\Field1
                                    If ((((((((((((local42 <> "25ct") And (local42 <> "coin")) And (local42 <> "key")) And (local42 <> "scp860")) And (local42 <> "scp005")) And (local42 <> "scp500pill")) And (local42 <> "pill")) And (local42 <> "mintscp500pill")) And (local42 <> "scp500pilldeath")) And (local42 <> "mintpill")) And (local42 <> "mintscp500pilldeath")) <> 0) Then
                                        local38 = $00
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    Else
                        For local4 = $00 To (local36 - $01) Step $01
                            If (otheropen\Field21[local4] <> Null) Then
                                local38 = $00
                                Exit
                            EndIf
                        Next
                    EndIf
                    If (local38 <> 0) Then
                        Select otheropen\Field3\Field1
                            Case "clipboard"
                                otheropen\Field17 = otheropen\Field3\Field8
                                setanimtime(otheropen\Field2, 17.0, $00)
                            Case "wallet"
                                setanimtime(otheropen\Field2, 0.0, $00)
                        End Select
                    EndIf
                    selecteditem = Null
                    otheropen = Null
                    local40 = $01
                    movemouse(viewport_center_x, viewport_center_y)
                ElseIf (local35\Field21[local28] = Null) Then
                    For local4 = $00 To (local36 - $01) Step $01
                        If (local35\Field21[local4] = selecteditem) Then
                            local35\Field21[local4] = Null
                        EndIf
                    Next
                    local35\Field21[local28] = selecteditem
                    selecteditem = Null
                ElseIf (local35\Field21[local28] <> selecteditem) Then
                    local44 = selecteditem\Field3\Field1
                    msg = scplang_getphrase("ingame.cannotcombine")
                    msgtimer = 350.0
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
        If ((local40 And (invopen = $00)) <> 0) Then
            resumesounds()
            otheropen = Null
            mousexspeed()
            mouseyspeed()
            mousezspeed()
            mouse_x_speed_1 = 0.0
            mouse_y_speed_1 = 0.0
            mouse_x_leverturn = 0.0
            mouse_y_leverturn = 0.0
        EndIf
    ElseIf (invopen <> 0) Then
        If (playerroom\Field7\Field10 = "gatea") Then
            hideentity(at\Field4[$00])
            camerafogrange(camera, 5.0, 30.0)
            camerafogcolor(camera, 200.0, 200.0, 200.0)
            cameraclscolor(camera, 200.0, 200.0, 200.0)
            camerarange(camera, 0.05, 30.0)
        ElseIf (((playerroom\Field7\Field10 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
            hideentity(at\Field4[$00])
            camerafogrange(camera, 5.0, 45.0)
            camerafogcolor(camera, 200.0, 200.0, 200.0)
            cameraclscolor(camera, 200.0, 200.0, 200.0)
            camerarange(camera, 0.05, 60.0)
        EndIf
        selecteddoor = Null
        local20 = $46
        local21 = $46
        local34 = $23
        local2 = ((graphicwidth Sar $01) - ((((local20 * maxitemamount) Sar $01) + (((maxitemamount Sar $01) - $01) * local34)) Sar $01))
        local3 = ((graphicheight Sar $01) - local21)
        itemamount = $00
        For local11 = $00 To (maxitemamount - $01) Step $01
            local39 = $00
            If (((scaledmousex() > local2) And (scaledmousex() < (local2 + local20))) <> 0) Then
                If (((scaledmousey() > local3) And (scaledmousey() < (local3 + local21))) <> 0) Then
                    local39 = $01
                EndIf
            EndIf
            If (inventory(local11) <> Null) Then
                color($C8, $C8, $C8)
                Select inventory(local11)\Field3\Field1
                    Case "gasmask"
                        If (wearinggasmask = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "supergasmask"
                        If (wearinggasmask = $02) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "gasmask3"
                        If (wearinggasmask = $03) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "hazmatsuit"
                        If (wearinghazmat = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "hazmatsuit2"
                        If (wearinghazmat = $02) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "hazmatsuit3"
                        If (wearinghazmat = $03) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "vest"
                        If (wearingvest = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "finevest"
                        If (wearingvest = $02) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp714"
                        If (i_714\Field0 = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "nvgoggles"
                        If (wearingnightvision = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "supernv"
                        If (wearingnightvision = $02) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp1499"
                        If (i_1499\Field0 = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "super1499"
                        If (i_1499\Field0 = $02) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "finenvgoggles"
                        If (wearingnightvision = $03) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp427"
                        If (i_427\Field0 = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp178"
                        If (i_178\Field0 = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp215"
                        If (i_215\Field0 = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp1033ru"
                        If (i_1033ru\Field2 = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "super1033ru"
                        If (i_1033ru\Field2 = $02) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "scp402"
                        If (i_402\Field0 = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                    Case "helmet"
                        If (wearinghelmet = $01) Then
                            rect((local2 - $03), (local3 - $03), (local20 + $06), (local21 + $06), $01)
                        EndIf
                End Select
            EndIf
            If (local39 <> 0) Then
                local28 = local11
                color($FF, $00, $00)
                rect((local2 - $01), (local3 - $01), (local20 + $02), (local21 + $02), $01)
            EndIf
            color($FF, $FF, $FF)
            drawframe(local2, local3, local20, local21, (local2 Mod $40), (local2 Mod $40))
            If (inventory(local11) <> Null) Then
                If (((selecteditem <> inventory(local11)) Or local39) <> 0) Then
                    drawimage(inventory(local11)\Field17, (((local20 Sar $01) + local2) - $20), (((local21 Sar $01) + local3) - $20), $00)
                EndIf
            EndIf
            If (((inventory(local11) <> Null) And (selecteditem <> inventory(local11))) <> 0) Then
                If (local39 <> 0) Then
                    If (selecteditem = Null) Then
                        If (mousehit1 <> 0) Then
                            selecteditem = inventory(local11)
                            mousehit1 = $00
                            If (doubleclick <> 0) Then
                                If (((wearinghazmat > $00) And (instr(selecteditem\Field3\Field1, "hazmatsuit", $01) = $00)) <> 0) Then
                                    msg = scplang_getphrase("items.hazmaterr9")
                                    msgtimer = 350.0
                                    selecteditem = Null
                                    Return $00
                                EndIf
                                If (inventory(local11)\Field3\Field2 <> $42) Then
                                    playsound_strict(picksfx(inventory(local11)\Field3\Field2))
                                EndIf
                                invopen = $00
                                doubleclick = $00
                            EndIf
                        EndIf
                        aasetfont(local0\Field0[$00])
                        color($00, $00, $00)
                        aatext((((local20 Sar $01) + local2) + $01), ((((local3 + local21) + local34) - $0F) + $01), inventory(local11)\Field0, $01, $00, 1.0)
                        color($FF, $FF, $FF)
                        aatext(((local20 Sar $01) + local2), (((local3 + local21) + local34) - $0F), inventory(local11)\Field0, $01, $00, 1.0)
                    EndIf
                EndIf
                itemamount = (itemamount + $01)
            ElseIf ((local39 And mousehit1) <> 0) Then
                For local4 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local4) = selecteditem) Then
                        inventory(local4) = Null
                    EndIf
                Next
                inventory(local11) = selecteditem
            EndIf
            local2 = ((local2 + local20) + local34)
            If (local11 = $04) Then
                local3 = (local3 + (local21 Shl $01))
                local2 = ((graphicwidth Sar $01) - ((((local20 * maxitemamount) Sar $01) + (((maxitemamount Sar $01) - $01) * local34)) Sar $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mousedown1 <> 0) Then
                If (local28 = $42) Then
                    drawimage(selecteditem\Field17, (scaledmousex() - (imagewidth(selecteditem\Field3\Field7) Sar $01)), (scaledmousey() - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                ElseIf (selecteditem <> inventory(local28)) Then
                    drawimage(selecteditem\Field17, (scaledmousex() - (imagewidth(selecteditem\Field3\Field7) Sar $01)), (scaledmousey() - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                EndIf
            Else
                If (local28 = $42) Then
                    Select selecteditem\Field3\Field1
                        Case "vest","finevest","hazmatsuit","hazmatsuit2","hazmatsuit3"
                            msg = scplang_getphrase("ingame.doubleitem")
                            msgtimer = 350.0
                        Case "scp1499","super1499"
                            If (i_1499\Field0 > $00) Then
                                msg = scplang_getphrase("ingame.doubleitem")
                                msgtimer = 350.0
                            Else
                                dropitem(selecteditem, $01)
                                selecteditem = Null
                                invopen = $00
                            EndIf
                        Case "scp215"
                            For local5 = $00 To (maxitemamount - $01) Step $01
                                If (inventory(local5) <> Null) Then
                                    If (inventory(local5)\Field3\Field0 = "SCP-215") Then
                                        If (86.0 <= i_215\Field1) Then
                                            msg = scplang_getphrase("ingame.cantdropglasses")
                                            msgtimer = 420.0
                                            i_215\Field0 = $01
                                        Else
                                            dropitem(selecteditem, $01)
                                            selecteditem = Null
                                            invopen = $00
                                        EndIf
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        Case "gasmask","gasmask3","supergasmask"
                            If (wearinggasmask > $00) Then
                                msg = scplang_getphrase("ingame.doubleitem")
                                msgtimer = 350.0
                            Else
                                dropitem(selecteditem, $01)
                                selecteditem = Null
                                invopen = $00
                            EndIf
                        Case "scp198"
                            msg = scplang_getphrase("ingame.cant198")
                            msgtimer = 350.0
                        Case "scp402"
                            If (40.0 <= i_402\Field1) Then
                                i_402\Field0 = $01
                                msg = scplang_getphrase("ingame.cant402")
                                msgtimer = 350.0
                            Else
                                dropitem(selecteditem, $01)
                                selecteditem = Null
                                invopen = $00
                            EndIf
                        Case "scp357"
                            If (56.0 <= i_357\Field0) Then
                                msg = scplang_getphrase("ingame.cant357")
                                msgtimer = 350.0
                            Else
                                dropitem(selecteditem, $01)
                                selecteditem = Null
                                invopen = $00
                            EndIf
                        Case "helmet"
                            If (wearinghelmet > $00) Then
                                msg = scplang_getphrase("ingame.doubleitem")
                                msgtimer = 350.0
                            Else
                                dropitem(selecteditem, $01)
                                selecteditem = Null
                                invopen = $00
                            EndIf
                        Default
                            dropitem(selecteditem, $01)
                            selecteditem = Null
                            invopen = $00
                    End Select
                    movemouse(viewport_center_x, viewport_center_y)
                ElseIf (inventory(local28) = Null) Then
                    For local4 = $00 To (maxitemamount - $01) Step $01
                        If (inventory(local4) = selecteditem) Then
                            inventory(local4) = Null
                        EndIf
                    Next
                    inventory(local28) = selecteditem
                    selecteditem = Null
                ElseIf (inventory(local28) <> selecteditem) Then
                    Select selecteditem\Field3\Field1
                        Case "paper","key0","key1","key2","key3","key4","key5","key6","key7","misc","oldpaper","badge","ticket","25ct","coin","key","scp860","scp500pill","scp005","pill","paperstrips","mintscp500pill","scp500pilldeath","mintpill","mintscp500pilldeath"
                            If (inventory(local28)\Field3\Field1 = "clipboard") Then
                                local48 = Null
                                local49 = selecteditem\Field3\Field1
                                local50 = selecteditem\Field3\Field0
                                If ((((((((((((((local49 <> "misc") And (local49 <> "25ct")) And (local49 <> "coin")) And (local49 <> "key")) And (local49 <> "scp860")) And (local49 <> "scp005")) And (local49 <> "scp500pill")) And (local49 <> "pill")) And (local49 <> "mintscp500pill")) And (local49 <> "scp500pilldeath")) And (local49 <> "mintpill")) And (local49 <> "mintscp500pilldeath")) Or ((local50 = "Playing Card") Or (local50 = "Mastercard"))) <> 0) Then
                                    For local51 = $00 To (inventory(local28)\Field23 - $01) Step $01
                                        If (inventory(local28)\Field21[local51] = Null) Then
                                            If (selecteditem <> Null) Then
                                                inventory(local28)\Field21[local51] = selecteditem
                                                inventory(local28)\Field13 = 1.0
                                                setanimtime(inventory(local28)\Field2, 0.0, $00)
                                                inventory(local28)\Field17 = inventory(local28)\Field3\Field7
                                                For local52 = $00 To (maxitemamount - $01) Step $01
                                                    If (inventory(local52) = selecteditem) Then
                                                        inventory(local52) = Null
                                                        playsound_strict(picksfx(selecteditem\Field3\Field2))
                                                    EndIf
                                                Next
                                                local48 = selecteditem
                                                selecteditem = Null
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    If (selecteditem <> Null) Then
                                        msg = scplang_getphrase("ingame.clipboarderr")
                                    ElseIf (((local48\Field3\Field1 = "paper") Or (local48\Field3\Field1 = "oldpaper")) <> 0) Then
                                        msg = scplang_getphrase("ingame.clipboard1")
                                    ElseIf (local48\Field3\Field1 = "badge") Then
                                        msg = ((local48\Field3\Field0 + " ") + scplang_getphrase("ingame.clipboard2"))
                                    Else
                                        msg = ((((scplang_getphrase("ingame.clipboard3") + " ") + local48\Field3\Field0) + " ") + scplang_getphrase("ingame.clipboard2"))
                                    EndIf
                                    msgtimer = 350.0
                                Else
                                    msg = scplang_getphrase("ingame.cannotcombine")
                                    msgtimer = 350.0
                                EndIf
                            ElseIf (inventory(local28)\Field3\Field1 = "wallet") Then
                                local48 = Null
                                local49 = selecteditem\Field3\Field1
                                local50 = selecteditem\Field3\Field0
                                If ((((((local49 <> "misc") And (local49 <> "paper")) And (local49 <> "oldpaper")) And (local49 <> "paperstrips")) Or ((local50 = "Playing Card") Or (local50 = "Mastercard"))) <> 0) Then
                                    For local51 = $00 To (inventory(local28)\Field23 - $01) Step $01
                                        If (inventory(local28)\Field21[local51] = Null) Then
                                            If (selecteditem <> Null) Then
                                                inventory(local28)\Field21[local51] = selecteditem
                                                inventory(local28)\Field13 = 1.0
                                                If ((((((((((((local49 <> "25ct") And (local49 <> "coin")) And (local49 <> "key")) And (local49 <> "scp860")) And (local49 <> "scp005")) And (local49 <> "mintscp500pill")) And (local49 <> "scp500pill")) And (local49 <> "pill")) And (local49 <> "scp500pilldeath")) And (local49 <> "mintpill")) And (local49 <> "mintscp500pilldeath")) <> 0) Then
                                                    setanimtime(inventory(local28)\Field2, 3.0, $00)
                                                EndIf
                                                inventory(local28)\Field17 = inventory(local28)\Field3\Field7
                                                For local52 = $00 To (maxitemamount - $01) Step $01
                                                    If (inventory(local52) = selecteditem) Then
                                                        inventory(local52) = Null
                                                        playsound_strict(picksfx(selecteditem\Field3\Field2))
                                                    EndIf
                                                Next
                                                local48 = selecteditem
                                                selecteditem = Null
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                    If (selecteditem <> Null) Then
                                        msg = scplang_getphrase("ingame.walleterr")
                                    Else
                                        msg = ((((scplang_getphrase("ingame.wallet1") + " ") + local48\Field3\Field0) + " ") + scplang_getphrase("ingame.wallet2"))
                                    EndIf
                                    msgtimer = 350.0
                                Else
                                    msg = scplang_getphrase("ingame.cannotcombine")
                                    msgtimer = 350.0
                                EndIf
                            Else
                                msg = scplang_getphrase("ingame.cannotcombine")
                                msgtimer = 350.0
                            EndIf
                            selecteditem = Null
                        Case "battery","bat","mintbat"
                            Select inventory(local28)\Field3\Field0
                                Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                    If (selecteditem\Field3\Field2 <> $42) Then
                                        playsound_strict(picksfx(selecteditem\Field3\Field2))
                                    EndIf
                                    removeitem(selecteditem)
                                    selecteditem = Null
                                    inventory(local28)\Field13 = 100.0
                                    msg = scplang_getphrase("ingame.nav1")
                                    msgtimer = 350.0
                                Case "S-NAV Navigator Ultimate"
                                    msg = scplang_getphrase("ingame.nav2")
                                    msgtimer = 350.0
                                Case "Radio Transceiver"
                                    Select inventory(local28)\Field3\Field1
                                        Case "fineradio","veryfineradio"
                                            msg = scplang_getphrase("ingame.radio1")
                                            msgtimer = 350.0
                                        Case "18vradio"
                                            msg = scplang_getphrase("ingame.radio2")
                                            msgtimer = 350.0
                                        Case "radio"
                                            If (selecteditem\Field3\Field2 <> $42) Then
                                                playsound_strict(picksfx(selecteditem\Field3\Field2))
                                            EndIf
                                            removeitem(selecteditem)
                                            selecteditem = Null
                                            inventory(local28)\Field13 = 100.0
                                            msg = scplang_getphrase("ingame.radio3")
                                            msgtimer = 350.0
                                    End Select
                                Case "Night Vision Goggles"
                                    local55 = inventory(local28)\Field3\Field1
                                    If (((local55 = "nvgoggles") Or (local55 = "supernv")) <> 0) Then
                                        If (selecteditem\Field3\Field2 <> $42) Then
                                            playsound_strict(picksfx(selecteditem\Field3\Field2))
                                        EndIf
                                        removeitem(selecteditem)
                                        selecteditem = Null
                                        inventory(local28)\Field13 = 1000.0
                                        msg = scplang_getphrase("ingame.goggles1")
                                        msgtimer = 350.0
                                    Else
                                        msg = scplang_getphrase("ingame.goggles2")
                                        msgtimer = 350.0
                                    EndIf
                                Default
                                    msg = scplang_getphrase("ingame.cannotcombine")
                                    msgtimer = 350.0
                            End Select
                        Case "18vbat","mint18vbat"
                            Select inventory(local28)\Field3\Field0
                                Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                    msg = scplang_getphrase("ingame.nav3")
                                    msgtimer = 350.0
                                Case "S-NAV Navigator Ultimate"
                                    msg = scplang_getphrase("ingame.nav2")
                                    msgtimer = 350.0
                                Case "Radio Transceiver"
                                    Select inventory(local28)\Field3\Field1
                                        Case "fineradio","veryfineradio"
                                            msg = scplang_getphrase("ingame.radio1")
                                            msgtimer = 350.0
                                        Case "18vradio"
                                            If (selecteditem\Field3\Field2 <> $42) Then
                                                playsound_strict(picksfx(selecteditem\Field3\Field2))
                                            EndIf
                                            removeitem(selecteditem)
                                            selecteditem = Null
                                            inventory(local28)\Field13 = 100.0
                                            msg = scplang_getphrase("ingame.radio3")
                                            msgtimer = 350.0
                                    End Select
                                Default
                                    msg = scplang_getphrase("ingame.cannotcombine")
                                    msgtimer = 350.0
                            End Select
                        Default
                            msg = scplang_getphrase("ingame.cannotcombine")
                            msgtimer = 350.0
                    End Select
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
        If (invopen = $00) Then
            resumesounds()
            mousexspeed()
            mouseyspeed()
            mousezspeed()
            mouse_x_speed_1 = 0.0
            mouse_y_speed_1 = 0.0
            mouse_x_leverturn = 0.0
            mouse_y_leverturn = 0.0
        EndIf
    ElseIf (selecteditem <> Null) Then
        Select selecteditem\Field3\Field1
            Case "nvgoggles"
                For local5 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local5) <> Null) Then
                        If (((inventory(local5)\Field3\Field0 = "SCP-215") And (86.0 <= i_215\Field1)) <> 0) Then
                            msg = scplang_getphrase("ingame.nvg215")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                            Exit
                        EndIf
                    EndIf
                Next
                If (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg2152")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.nvggas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinghelmet > $00) Then
                    msg = scplang_getphrase("ingame.nvghelmet")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    If (wearingnightvision = $01) Then
                        msg = scplang_getphrase("ingame.nvgoff")
                        camerafogfar = storedcamerafogfar
                        playsound_strict(nvguse($00))
                    Else
                        msg = scplang_getphrase("ingame.nvgon")
                        wearingnightvision = $00
                        storedcamerafogfar = camerafogfar
                        camerafogfar = 30.0
                        playsound_strict(nvguse($01))
                    EndIf
                    wearingnightvision = (wearingnightvision = $00)
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "supernv"
                For local5 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local5) <> Null) Then
                        If (((inventory(local5)\Field3\Field0 = "SCP-215") And (86.0 <= i_215\Field1)) <> 0) Then
                            msg = scplang_getphrase("ingame.nvg215")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                            Exit
                        EndIf
                    EndIf
                Next
                If (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg2152")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.nvggas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinghelmet > $00) Then
                    msg = scplang_getphrase("ingame.nvghelmet")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    If (wearingnightvision = $02) Then
                        msg = scplang_getphrase("ingame.nvgoff")
                        camerafogfar = storedcamerafogfar
                        playsound_strict(nvguse($00))
                    Else
                        msg = scplang_getphrase("ingame.nvgon")
                        wearingnightvision = $00
                        storedcamerafogfar = camerafogfar
                        camerafogfar = 30.0
                        playsound_strict(nvguse($01))
                    EndIf
                    wearingnightvision = ((wearingnightvision = $00) Shl $01)
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "finenvgoggles"
                For local5 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local5) <> Null) Then
                        If (((inventory(local5)\Field3\Field0 = "SCP-215") And (86.0 <= i_215\Field1)) <> 0) Then
                            msg = scplang_getphrase("ingame.nvg215")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                            Exit
                        EndIf
                    EndIf
                Next
                If (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg2152")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.nvggas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.nvg178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinghelmet > $00) Then
                    msg = scplang_getphrase("ingame.nvghelmet")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    If (wearingnightvision = $03) Then
                        msg = scplang_getphrase("ingame.nvgoff")
                        camerafogfar = storedcamerafogfar
                        playsound_strict(nvguse($00))
                    Else
                        msg = scplang_getphrase("ingame.nvgon")
                        wearingnightvision = $00
                        storedcamerafogfar = camerafogfar
                        camerafogfar = 30.0
                        playsound_strict(nvguse($01))
                    EndIf
                    wearingnightvision = ((wearingnightvision = $00) * $03)
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "scp1123"
                If (((((i_714\Field0 = $01) = $00) And ((wearinghazmat = $03) = $00)) Or ((wearinggasmask = $03) = $00)) <> 0) Then
                    If (playerroom\Field7\Field10 <> "room1123") Then
                        showentity(at\Field4[$0E])
                        lightflash = 7.0
                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\1123\Touch.ogg")))
                        If (i_1033ru\Field0 = $00) Then
                            deathmsg = scplang_getphrase("items.itemscp1123d")
                            kill($00, $00)
                        Else
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $32))
                        EndIf
                        Return $00
                    EndIf
                    For local17 = Each events
                        If (local17\Field0 = "room1123") Then
                            If (0.0 = local17\Field2) Then
                                showentity(at\Field4[$0E])
                                lightflash = 3.0
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\1123\Touch.ogg")))
                            EndIf
                            local17\Field2 = max(1.0, local17\Field2)
                            Exit
                        EndIf
                    Next
                EndIf
            Case "key0","key1","key2","key3","key4","key5","key6","key7","keyomni","scp860","hand","hand2","25ct","scp005","hand3"
                drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
            Case "scp513"
                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\513\Bell1.ogg")))
                If (curr5131 = Null) Then
                    curr5131 = createnpc($0A, 0.0, 0.0, 0.0)
                EndIf
                selecteditem = Null
            Case "scp500pill"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.pill1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.pillgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    giveachievement($0E, $01)
                    If (0.0 < i_008\Field0) Then
                        msg = scplang_getphrase("ingame.pill008")
                    ElseIf (0.0 < i_409\Field0) Then
                        msg = scplang_getphrase("ingame.pill409")
                    ElseIf (0.0 < i_357\Field0) Then
                        msg = scplang_getphrase("ingame.pill357")
                    Else
                        msg = scplang_getphrase("ingame.pillnone")
                    EndIf
                    msgtimer = 490.0
                    deathtimer = 0.0
                    i_008\Field0 = 0.0
                    stamina = 100.0
                    i_409\Field0 = 0.0
                    i_207\Field0 = 0.0
                    i_357\Field0 = 0.0
                    i_1079\Field2 = $00
                    i_1079\Field0 = 0.0
                    i_1079\Field1 = $00
                    For local5 = $00 To $05 Step $01
                        scp1025state[local5] = 0.0
                    Next
                    If (1.0 < staminaeffect) Then
                        staminaeffect = 1.0
                        staminaeffecttimer = 0.0
                    EndIf
                    If (1.0 < blinkeffect) Then
                        blinkeffect = 1.0
                        blinkeffecttimer = 0.0
                    EndIf
                    For local17 = Each events
                        If (local17\Field0 = "room009") Then
                            local17\Field2 = 0.0
                            local17\Field4 = 0.0
                        EndIf
                    Next
                    removeitem(selecteditem)
                EndIf
            Case "veryfinefirstaid"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.aid1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.aidgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.aid215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.aid178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.aidnvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    Select rand($05, $01)
                        Case $01
                            injuries = 3.5
                            msg = scplang_getphrase("ingame.bleedheavy")
                            msgtimer = 490.0
                        Case $02
                            injuries = 0.0
                            bloodloss = 0.0
                            i_1079\Field0 = 0.0
                            msg = scplang_getphrase("ingame.bleedheal")
                            msgtimer = 490.0
                        Case $03
                            injuries = max(0.0, (injuries - rnd(0.5, 3.5)))
                            bloodloss = max(0.0, (bloodloss - rnd(10.0, 100.0)))
                            msg = scplang_getphrase("ingame.bleedbetter")
                            msgtimer = 490.0
                        Case $04
                            blurtimer = 10000.0
                            bloodloss = 0.0
                            msg = scplang_getphrase("ingame.bleednaus")
                            msgtimer = 490.0
                        Case $05
                            blinktimer = -10.0
                            local60 = playerroom\Field7\Field10
                            If ((((local60 = "dimension1499") Or (local60 = "gatea")) Or ((local60 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00)))) <> 0) Then
                                injuries = 2.5
                                msg = scplang_getphrase("ingame.bleedheavy")
                                msgtimer = 490.0
                            Else
                                For local61 = Each rooms
                                    If (local61\Field7\Field10 = "pocketdimension") Then
                                        positionentity(collider, entityx(local61\Field2, $00), 0.8, entityz(local61\Field2, $00), $00)
                                        resetentity(collider)
                                        updatedoors()
                                        updaterooms()
                                        playsound_strict(use914sfx)
                                        dropspeed = 0.0
                                        curr106\Field9 = -2500.0
                                        Exit
                                    EndIf
                                Next
                                msg = scplang_getphrase("ingame.pocketdimensionunknown")
                                msgtimer = 560.0
                            EndIf
                    End Select
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("ingame.finefirstaiderr")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "firstaid","finefirstaid","firstaid2"
                If (((0.0 = bloodloss) And (0.0 = injuries)) <> 0) Then
                    msg = scplang_getphrase("ingame.aidnotnow")
                    msgtimer = 350.0
                    selecteditem = Null
                Else
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local3 = ((graphicheight Sar $01) + $50)
                    rect(local2, local3, (local20 + $04), local21, $00)
                    For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + (local16\Field3[$00] / 5.0)), 100.0)
                    If (crouch = $00) Then
                        crouchchn = playsound_strict(crouchsfx)
                    EndIf
                    crouch = $01
                    If (100.0 = selecteditem\Field13) Then
                        If (selecteditem\Field3\Field1 = "finefirstaid") Then
                            bloodloss = 0.0
                            i_1079\Field0 = 0.0
                            injuries = max(0.0, (injuries - 2.0))
                            If (0.0 = injuries) Then
                                msg = scplang_getphrase("ingame.aidpainfine")
                            ElseIf (1.0 < injuries) Then
                                msg = scplang_getphrase("ingame.aidpainbleed")
                            Else
                                msg = scplang_getphrase("ingame.aidpainsore")
                            EndIf
                            msgtimer = 350.0
                            removeitem(selecteditem)
                        Else
                            bloodloss = max(0.0, (bloodloss - (Float rand($0A, $14))))
                            If (2.5 <= injuries) Then
                                msg = scplang_getphrase("ingame.aidbleedsev")
                                injuries = max(2.5, (injuries - rnd(0.3, 0.7)))
                            ElseIf (1.0 < injuries) Then
                                injuries = max(0.5, (injuries - rnd(0.5, 1.0)))
                                If (1.0 < injuries) Then
                                    msg = scplang_getphrase("ingame.aidbleedun")
                                Else
                                    msg = scplang_getphrase("ingame.aidbleedstop")
                                EndIf
                            ElseIf (0.5 < injuries) Then
                                injuries = 0.5
                                msg = scplang_getphrase("ingame.painease")
                            Else
                                injuries = 0.5
                                msg = scplang_getphrase("ingame.painhurt")
                            EndIf
                            If (selecteditem\Field3\Field1 = "firstaid2") Then
                                Select rand($06, $01)
                                    Case $01
                                        superman = $01
                                        msg = scplang_getphrase("ingame.adrenaline")
                                    Case $02
                                        invertmouse = (invertmouse = $00)
                                        msg = scplang_getphrase("ingame.headdif")
                                    Case $03
                                        blurtimer = 5000.0
                                        msg = scplang_getphrase("ingame.bleednaus")
                                    Case $04
                                        blinkeffect = 0.6
                                        blinkeffecttimer = (Float rand($14, $1E))
                                    Case $05
                                        bloodloss = 0.0
                                        injuries = 0.0
                                        msg = scplang_getphrase("ingame.bandfine")
                                    Case $06
                                        msg = scplang_getphrase("ingame.bandheavy")
                                        injuries = 3.5
                                End Select
                            EndIf
                            msgtimer = 350.0
                            removeitem(selecteditem)
                        EndIf
                    EndIf
                EndIf
            Case "eyedrops","eyedrops2"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.dropsgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.dropsnvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    msg = scplang_getphrase("ingame.dropsgood")
                    msgtimer = 350.0
                    blinkeffect = 0.6
                    blinkeffecttimer = (Float rand($14, $1E))
                    blurtimer = 200.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
            Case "fineeyedrops"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.dropsgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.dropsnvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    msg = scplang_getphrase("ingame.dropsgood2")
                    msgtimer = 350.0
                    blinkeffect = 0.4
                    blinkeffecttimer = (Float rand($1E, $28))
                    bloodloss = max((bloodloss - 1.0), 0.0)
                    blurtimer = 200.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
            Case "supereyedrops"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.dropsgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.dropsnvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    msg = scplang_getphrase("ingame.dropsgood2")
                    msgtimer = 350.0
                    blinkeffect = 0.0
                    blinkeffecttimer = 60.0
                    eyestuck = 10000.0
                    blurtimer = 1000.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "paper","ticket"
                If (selecteditem\Field3\Field11 = $00) Then
                    Select selecteditem\Field3\Field0
                        Case "Burnt Note"
                            selecteditem\Field3\Field11 = loadimage_strict(scpmodding_processfilepath("GFX\items\bn.it"))
                            setbuffer(imagebuffer(selecteditem\Field3\Field11, $00))
                            color($00, $00, $00)
                            aatext($115, $1D5, (Str accesscode), $01, $01, 1.0)
                            color($FF, $FF, $FF)
                            setbuffer(backbuffer())
                        Case "Document SCP-372"
                            selecteditem\Field3\Field11 = loadimage_strict(selecteditem\Field3\Field10)
                            selecteditem\Field3\Field11 = resizeimage2(selecteditem\Field3\Field11, (Int ((Float imagewidth(selecteditem\Field3\Field11)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field11)) * menuscale)))
                            setbuffer(imagebuffer(selecteditem\Field3\Field11, $00))
                            color($25, $2D, $89)
                            aasetfont(local0\Field0[$04])
                            local1 = ((accesscode * $03) Mod $2710)
                            If (local1 < $3E8) Then
                                local1 = (local1 + $3E8)
                            EndIf
                            aatext((Int (383.0 * menuscale)), (Int (734.0 * menuscale)), (Str local1), $01, $01, 1.0)
                            color($FF, $FF, $FF)
                            setbuffer(backbuffer())
                        Case "Movie Ticket"
                            selecteditem\Field3\Field11 = loadimage_strict(selecteditem\Field3\Field10)
                            If (0.0 = selecteditem\Field13) Then
                                msg = scplang_getphrase("ingame.ticket")
                                msgtimer = 700.0
                                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($01, $05))) + ".ogg"))))
                                selecteditem\Field13 = 1.0
                            EndIf
                        Case "Document SCP-XXX"
                            selecteditem\Field3\Field11 = loadimage_strict(selecteditem\Field3\Field10)
                            selecteditem\Field3\Field11 = resizeimage2(selecteditem\Field3\Field11, (Int ((Float imagewidth(selecteditem\Field3\Field11)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field11)) * menuscale)))
                            If (0.0 = selecteditem\Field13) Then
                                msg = scplang_getphrase("ingame.strangedoc")
                                msgtimer = 700.0
                                playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($01, $05))) + ".ogg"))))
                                selecteditem\Field13 = 1.0
                            EndIf
                        Default
                            selecteditem\Field3\Field11 = loadimage_strict(selecteditem\Field3\Field10)
                            selecteditem\Field3\Field11 = resizeimage2(selecteditem\Field3\Field11, (Int ((Float imagewidth(selecteditem\Field3\Field11)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field11)) * menuscale)))
                    End Select
                    maskimage(selecteditem\Field3\Field11, $FF, $00, $FF)
                EndIf
                drawimage(selecteditem\Field3\Field11, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field11) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field11) Sar $01)), $00)
            Case "scp1025"
                giveachievement($18, $01)
                If (selecteditem\Field3\Field11 = $00) Then
                    selecteditem\Field13 = (Float rand($00, $05))
                    selecteditem\Field3\Field11 = loadimage_strict(scpmodding_processfilepath((("GFX\items\1025\1025_" + (Str (Int selecteditem\Field13))) + ".png")))
                    selecteditem\Field3\Field11 = resizeimage2(selecteditem\Field3\Field11, (Int ((Float imagewidth(selecteditem\Field3\Field11)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field11)) * menuscale)))
                    maskimage(selecteditem\Field3\Field11, $FF, $00, $FF)
                EndIf
                If ((((i_714\Field0 = $00) And ((wearinggasmask = $03) = $00)) And ((wearinghazmat = $03) = $00)) <> 0) Then
                    scp1025state[(Int selecteditem\Field13)] = max(1.0, scp1025state[(Int selecteditem\Field13)])
                EndIf
                drawimage(selecteditem\Field3\Field11, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field11) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field11) Sar $01)), $00)
            Case "cup"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.cup1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.cupgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    selecteditem\Field0 = trim(lower(selecteditem\Field0))
                    If (left(selecteditem\Field0, (Int min(6.0, (Float len(selecteditem\Field0))))) = "cup of") Then
                        selecteditem\Field0 = right(selecteditem\Field0, (len(selecteditem\Field0) - $07))
                    ElseIf (left(selecteditem\Field0, (Int min(8.0, (Float len(selecteditem\Field0))))) = "a cup of") Then
                        selecteditem\Field0 = right(selecteditem\Field0, (len(selecteditem\Field0) - $09))
                    EndIf
                    local8 = (selecteditem\Field13 + 1.0)
                    local64 = scpmodding_processfilepath("Data\SCP-294.ini")
                    local65 = getinisectionlocation(local64, selecteditem\Field0)
                    local14 = getinistring2(local64, local65, "message", "")
                    If (local14 <> "") Then
                        msg = scplang_getphrase(local14)
                        msgtimer = 420.0
                    EndIf
                    If ((getiniint2(local64, local65, "lethal", "") Or getiniint2(local64, local65, "deathtimer", "")) <> 0) Then
                        deathmsg = getinistring2(local64, local65, "deathmessage", "")
                        If (getiniint2(local64, local65, "lethal", "") <> 0) Then
                            kill($00, $00)
                        EndIf
                    EndIf
                    blurtimer = (Float (getiniint2(local64, local65, "blur", "") * $46))
                    If (0.0 = vomittimer) Then
                        vomittimer = (Float getiniint2(local64, local65, "vomit", ""))
                    EndIf
                    camerashaketimer = (Float getinistring2(local64, local65, "camerashake", ""))
                    injuries = max(((Float getiniint2(local64, local65, "damage", "")) + injuries), 0.0)
                    bloodloss = max(((Float getiniint2(local64, local65, "blood loss", "")) + bloodloss), 0.0)
                    i_1079\Field0 = max((i_1079\Field0 + (Float getiniint2(local64, local65, "bubble foam", ""))), 0.0)
                    local14 = getinistring2(local64, local65, "sound", "")
                    If (local14 <> "") Then
                        playsound_strict(loadtempsound(local14))
                    EndIf
                    If (getiniint2(local64, local65, "stomachache", "") <> 0) Then
                        scp1025state[$03] = 1.0
                    EndIf
                    If (getiniint2(local64, local65, "infection", "") <> 0) Then
                        i_008\Field0 = 1.0
                    EndIf
                    If (getiniint2(local64, local65, "crystallization", "") <> 0) Then
                        i_409\Field0 = 1.0
                    EndIf
                    If (getiniint2(local64, local65, "cola", "") <> 0) Then
                        i_207\Field0 = 1.0
                    EndIf
                    deathtimer = (Float (getiniint2(local64, local65, "deathtimer", "") * $46))
                    blinkeffect = ((Float getinistring2(local64, local65, "blink effect", "1.0")) * local8)
                    blinkeffecttimer = ((Float getinistring2(local64, local65, "blink effect timer", "1.0")) * local8)
                    staminaeffect = ((Float getinistring2(local64, local65, "stamina effect", "1.0")) * local8)
                    staminaeffecttimer = ((Float getinistring2(local64, local65, "stamina effect timer", "1.0")) * local8)
                    local14 = getinistring2(local64, local65, "refusemessage", "")
                    If (local14 <> "") Then
                        msg = local14
                        msgtimer = 420.0
                    Else
                        local18 = createitem("Empty Cup", "emptycup", 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                        local18\Field15 = $01
                        For local5 = $00 To (maxitemamount - $01) Step $01
                            If (inventory(local5) = selecteditem) Then
                                inventory(local5) = local18
                                Exit
                            EndIf
                        Next
                        entitytype(local18\Field1, $03, $00)
                        removeitem(selecteditem)
                    EndIf
                    selecteditem = Null
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
            Case "syringe"
                If (i_402\Field0 = $00) Then
                    healtimer = 30.0
                    staminaeffect = 0.5
                    staminaeffecttimer = 20.0
                    msg = scplang_getphrase("ingame.syringe1")
                    msgtimer = 560.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "finesyringe"
                If (i_402\Field0 = $00) Then
                    healtimer = rnd(20.0, 40.0)
                    staminaeffect = rnd(0.5, 0.8)
                    staminaeffecttimer = rnd(20.0, 30.0)
                    msg = scplang_getphrase("ingame.syringe2")
                    msgtimer = 560.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
            Case "veryfinesyringe"
                If (i_402\Field0 = $00) Then
                    Select rand($03, $01)
                        Case $01
                            healtimer = rnd(40.0, 60.0)
                            staminaeffect = 0.1
                            staminaeffecttimer = 30.0
                            msg = scplang_getphrase("ingame.syringe3")
                        Case $02
                            superman = $01
                            msg = scplang_getphrase("ingame.syringe4")
                        Case $03
                            vomittimer = 30.0
                            msg = scplang_getphrase("ingame.syringe5")
                    End Select
                    msgtimer = 560.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
            Case "radio","18vradio","fineradio","veryfineradio"
                If (100.0 >= selecteditem\Field13) Then
                    selecteditem\Field13 = max(0.0, (selecteditem\Field13 - (local16\Field3[$00] * 0.004)))
                EndIf
                If (selecteditem\Field3\Field11 = $00) Then
                    selecteditem\Field3\Field11 = loadimage_strict(selecteditem\Field3\Field10)
                    maskimage(selecteditem\Field3\Field11, $FF, $00, $FF)
                EndIf
                If (0.0 = radiostate($05)) Then
                    msg = scplang_getphrase("ingame.radiokeys")
                    msgtimer = 350.0
                    radiostate($05) = 1.0
                    radiostate($00) = -1.0
                EndIf
                local14 = ""
                local2 = (graphicwidth - imagewidth(selecteditem\Field3\Field11))
                local3 = (graphicheight - imageheight(selecteditem\Field3\Field11))
                drawimage(selecteditem\Field3\Field11, local2, local3, $00)
                If (0.0 < selecteditem\Field13) Then
                    If (playerroom\Field7\Field10 = "pocketdimension") Then
                        resumechannel(radiochn($05))
                        If (channelplaying(radiochn($05)) = $00) Then
                            radiochn($05) = playsound_strict(radiostatic)
                        EndIf
                    ElseIf (4.0 > coffindistance) Then
                        resumechannel(radiochn($05))
                        If (channelplaying(radiochn($05)) = $00) Then
                            radiochn($05) = playsound_strict(radiostatic895)
                        EndIf
                    Else
                        Select (Int selecteditem\Field14)
                            Case $00
                                resumechannel(radiochn($00))
                                local14 = (("        " + scplang_getphrase("ingame.radiouser")) + " - ")
                                If (enableusertracks = $00) Then
                                    If (channelplaying(radiochn($00)) = $00) Then
                                        radiochn($00) = playsound_strict(radiostatic)
                                    EndIf
                                    local14 = ((local14 + scplang_getphrase("ingame.radionot")) + "     ")
                                ElseIf (usertrackmusicamount < $01) Then
                                    If (channelplaying(radiochn($00)) = $00) Then
                                        radiochn($00) = playsound_strict(radiostatic)
                                    EndIf
                                    local14 = ((local14 + scplang_getphrase("ingame.radionone")) + "     ")
                                Else
                                    If (channelplaying(radiochn($00)) = $00) Then
                                        If (usertrackflag = $00) Then
                                            If (usertrackmode <> 0) Then
                                                If ((Float (usertrackmusicamount - $01)) > radiostate($00)) Then
                                                    radiostate($00) = (radiostate($00) + 1.0)
                                                Else
                                                    radiostate($00) = 0.0
                                                EndIf
                                                usertrackflag = $01
                                            Else
                                                radiostate($00) = (Float rand($00, (usertrackmusicamount - $01)))
                                            EndIf
                                        EndIf
                                        If (currusertrack <> $00) Then
                                            freesound_strict(currusertrack)
                                            currusertrack = $00
                                        EndIf
                                        currusertrack = loadsound_strict(("SFX\Radio\UserTracks" + usertrackname((Int radiostate($00)))))
                                        radiochn($00) = playsound_strict(currusertrack)
                                    Else
                                        local14 = ((local14 + upper(usertrackname((Int radiostate($00))))) + "          ")
                                        usertrackflag = $00
                                    EndIf
                                    If (keyhit($02) <> 0) Then
                                        playsound_strict(radiosquelch)
                                        If (usertrackflag = $00) Then
                                            If (usertrackmode <> 0) Then
                                                If ((Float (usertrackmusicamount - $01)) > radiostate($00)) Then
                                                    radiostate($00) = (radiostate($00) + 1.0)
                                                Else
                                                    radiostate($00) = 0.0
                                                EndIf
                                                usertrackflag = $01
                                            Else
                                                radiostate($00) = (Float rand($00, (usertrackmusicamount - $01)))
                                            EndIf
                                        EndIf
                                        If (currusertrack <> $00) Then
                                            freesound_strict(currusertrack)
                                            currusertrack = $00
                                        EndIf
                                        currusertrack = loadsound_strict(("SFX\Radio\UserTracks" + usertrackname((Int radiostate($00)))))
                                        radiochn($00) = playsound_strict(currusertrack)
                                    EndIf
                                EndIf
                            Case $01
                                resumechannel(radiochn($01))
                                local14 = (("        " + scplang_getphrase("ingame.radiocon")) + "          ")
                                If (channelplaying(radiochn($01)) = $00) Then
                                    If (5.0 <= radiostate($01)) Then
                                        radiochn($01) = playsound_strict(radiosfx($01, $01))
                                        radiostate($01) = 0.0
                                    Else
                                        radiostate($01) = (radiostate($01) + 1.0)
                                        radiochn($01) = playsound_strict(radiosfx($01, $00))
                                    EndIf
                                EndIf
                            Case $02
                                resumechannel(radiochn($02))
                                local14 = (("        " + scplang_getphrase("ingame.radiosite")) + "          ")
                                If (channelplaying(radiochn($02)) = $00) Then
                                    radiostate($02) = (radiostate($02) + 1.0)
                                    If (17.0 = radiostate($02)) Then
                                        radiostate($02) = 1.0
                                    EndIf
                                    If (ceil((radiostate($02) / 2.0)) = floor((radiostate($02) / 2.0))) Then
                                        radiochn($02) = playsound_strict(radiosfx($02, (Int (radiostate($02) / 2.0))))
                                    Else
                                        radiochn($02) = playsound_strict(radiosfx($02, $00))
                                    EndIf
                                EndIf
                            Case $03
                                resumechannel(radiochn($03))
                                local14 = (("             " + scplang_getphrase("ingame.radioem")) + "         ")
                                If (channelplaying(radiochn($03)) = $00) Then
                                    radiochn($03) = playsound_strict(radiostatic)
                                EndIf
                                If (0.0 < mtftimer) Then
                                    radiostate($03) = (max((Float rand($FFFFFFF6, $01)), 0.0) + radiostate($03))
                                    Select radiostate($03)
                                        Case 40.0
                                            If (radiostate3($00) = $00) Then
                                                radiochn($03) = playsound_strict((Int scpmodding_processfilepath((Str loadtempsound("SFX\Character\MTF\Random1.ogg")))))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($00) = $01
                                            EndIf
                                        Case 400.0
                                            If (radiostate3($01) = $00) Then
                                                radiochn($03) = playsound_strict((Int scpmodding_processfilepath((Str loadtempsound("SFX\Character\MTF\Random2.ogg")))))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($01) = $01
                                            EndIf
                                        Case 800.0
                                            If (radiostate3($02) = $00) Then
                                                radiochn($03) = playsound_strict((Int scpmodding_processfilepath((Str loadtempsound("SFX\Character\MTF\Random3.ogg")))))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($02) = $01
                                            EndIf
                                        Case 1200.0
                                            If (radiostate3($03) = $00) Then
                                                radiochn($03) = playsound_strict((Int scpmodding_processfilepath((Str loadtempsound("SFX\Character\MTF\Random4.ogg")))))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($03) = $01
                                            EndIf
                                        Case 1600.0
                                            If (radiostate3($04) = $00) Then
                                                radiochn($03) = playsound_strict((Int scpmodding_processfilepath((Str loadtempsound("SFX\Character\MTF\Random5.ogg")))))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($04) = $01
                                            EndIf
                                        Case 2000.0
                                            If (radiostate3($05) = $00) Then
                                                radiochn($03) = playsound_strict((Int scpmodding_processfilepath((Str loadtempsound("SFX\Character\MTF\Random6.ogg")))))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($05) = $01
                                            EndIf
                                        Case 2400.0
                                            If (radiostate3($06) = $00) Then
                                                radiochn($03) = playsound_strict((Int scpmodding_processfilepath((Str loadtempsound("SFX\Character\MTF\Random7.ogg")))))
                                                radiostate($03) = (radiostate($03) + 1.0)
                                                radiostate3($06) = $01
                                            EndIf
                                    End Select
                                EndIf
                            Case $04
                                resumechannel(radiochn($06))
                                If (channelplaying(radiochn($06)) = $00) Then
                                    radiochn($06) = playsound_strict(radiostatic)
                                EndIf
                                resumechannel(radiochn($04))
                                If (channelplaying(radiochn($04)) = $00) Then
                                    If (((remotedooron = $00) And (0.0 = radiostate($08))) <> 0) Then
                                        radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\Chatter3.ogg")))
                                        radiostate($08) = 1.0
                                    Else
                                        radiostate($04) = (max((Float rand($FFFFFFF6, $01)), 0.0) + radiostate($04))
                                        Select radiostate($04)
                                            Case 10.0
                                                If (contained106 = $00) Then
                                                    If (radiostate4($00) = $00) Then
                                                        radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\OhGod.ogg")))
                                                        radiostate($04) = (radiostate($04) + 1.0)
                                                        radiostate4($00) = $01
                                                    EndIf
                                                EndIf
                                            Case 100.0
                                                If (radiostate4($01) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\Chatter2.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($01) = $01
                                                EndIf
                                            Case 158.0
                                                If (((0.0 = mtftimer) And (radiostate4($02) = $00)) <> 0) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\franklin1.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate($02) = 1.0
                                                EndIf
                                            Case 200.0
                                                If (radiostate4($03) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\Chatter4.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($03) = $01
                                                EndIf
                                            Case 260.0
                                                If (radiostate4($04) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\035\RadioHelp1.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($04) = $01
                                                EndIf
                                            Case 300.0
                                                If (radiostate4($05) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\Chatter1.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($05) = $01
                                                EndIf
                                            Case 350.0
                                                If (radiostate4($06) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\franklin2.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($06) = $01
                                                EndIf
                                            Case 400.0
                                                If (radiostate4($07) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\035\RadioHelp2.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($07) = $01
                                                EndIf
                                            Case 450.0
                                                If (radiostate4($08) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\franklin3.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($08) = $01
                                                EndIf
                                            Case 600.0
                                                If (radiostate4($09) = $00) Then
                                                    radiochn($04) = playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Radio\franklin4.ogg")))
                                                    radiostate($04) = (radiostate($04) + 1.0)
                                                    radiostate4($09) = $01
                                                EndIf
                                        End Select
                                    EndIf
                                EndIf
                            Case $05
                                resumechannel(radiochn($05))
                                If (channelplaying(radiochn($05)) = $00) Then
                                    radiochn($05) = playsound_strict(radiostatic)
                                EndIf
                        End Select
                        local2 = (local2 + $42)
                        local3 = (local3 + $1A3)
                        color($1E, $1E, $1E)
                        If (100.0 >= selecteditem\Field13) Then
                            For local5 = $00 To $04 Step $01
                                rect(local2, ((local5 Shl $03) + local3), ($2B - (local5 * $06)), $04, ((Float ($04 - local5)) < ceil((selecteditem\Field13 / 20.0))))
                            Next
                        EndIf
                        aasetfont(local0\Field0[$02])
                        aatext((local2 + $32), local3, "CHN", $00, $00, 1.0)
                        If (selecteditem\Field3\Field1 = "veryfineradio") Then
                            resumechannel(radiochn($00))
                            If (channelplaying(radiochn($00)) = $00) Then
                                radiochn($00) = playsound_strict(radiostatic)
                            EndIf
                            radiostate($06) = (local16\Field3[$00] + radiostate($06))
                            local1 = (Int mid((Str accesscode), (Int (radiostate($08) + 1.0)), $01))
                            If ((((radiostate($07) * 50.0) >= (radiostate($06) - local16\Field3[$00])) And (radiostate($06) > (radiostate($07) * 50.0))) <> 0) Then
                                playsound_strict(radiobuzz)
                                radiostate($07) = (radiostate($07) + 1.0)
                                If ((Float local1) <= radiostate($07)) Then
                                    radiostate($07) = 0.0
                                    radiostate($06) = -100.0
                                    radiostate($08) = (radiostate($08) + 1.0)
                                    If (4.0 = radiostate($08)) Then
                                        radiostate($08) = 0.0
                                        radiostate($06) = -200.0
                                    EndIf
                                EndIf
                            EndIf
                            local14 = ""
                            For local5 = $00 To rand($05, $1E) Step $01
                                local14 = (local14 + chr(rand($01, $64)))
                            Next
                            aasetfont(local0\Field0[$03])
                            aatext((local2 + $61), (local3 + $10), (Str rand($00, $09)), $01, $01, 1.0)
                        Else
                            For local5 = $02 To $06 Step $01
                                If (keyhit(local5) <> 0) Then
                                    If ((Float (local5 - $02)) <> selecteditem\Field14) Then
                                        playsound_strict(radiosquelch)
                                        If (radiochn((Int selecteditem\Field14)) <> $00) Then
                                            pausechannel(radiochn((Int selecteditem\Field14)))
                                        EndIf
                                    EndIf
                                    selecteditem\Field14 = (Float (local5 - $02))
                                    If (radiochn((Int selecteditem\Field14)) <> $00) Then
                                        resumechannel(radiochn((Int selecteditem\Field14)))
                                    EndIf
                                EndIf
                            Next
                            aasetfont(local0\Field0[$03])
                            aatext((local2 + $61), (local3 + $10), (Str (Int (selecteditem\Field14 + 1.0))), $01, $01, 1.0)
                        EndIf
                        aasetfont(local0\Field0[$02])
                        If (local14 <> "") Then
                            local14 = right(left(local14, ((millisecs2() / $12C) Mod len(local14))), $0A)
                            aatext((local2 + $20), (local3 + $21), local14, $00, $00, 1.0)
                        EndIf
                        aasetfont(local0\Field0[$00])
                    EndIf
                EndIf
            Case "cigarette"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.cig1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.ciggas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    Select rand($06, $01)
                        Case $01
                            msg = scplang_getphrase("ingame.cig1")
                        Case $02
                            msg = scplang_getphrase("ingame.cig2")
                        Case $03
                            msg = scplang_getphrase("ingame.cig3")
                            removeitem(selecteditem)
                        Case $04
                            msg = scplang_getphrase("ingame.cig4")
                        Case $05
                            msg = scplang_getphrase("ingame.cig5")
                        Case $06
                            msg = scplang_getphrase("ingame.cig6")
                            removeitem(selecteditem)
                    End Select
                    msgtimer = 350.0
                EndIf
            Case "scp420j"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.weed1")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.weed2")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    If ((((i_714\Field0 = $01) Or (wearinghazmat = $03)) Or (wearinggasmask = $03)) <> 0) Then
                        msg = ((chr($22) + scplang_getphrase("ingame.weed3")) + chr($22))
                    Else
                        msg = ((chr($22) + scplang_getphrase("ingame.weed4")) + chr($22))
                        injuries = max((injuries - 0.5), 0.0)
                        blurtimer = 500.0
                        giveachievement($0C, $01)
                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Music\Using420J.ogg")))
                    EndIf
                    msgtimer = 350.0
                    removeitem(selecteditem)
                EndIf
            Case "scp420s"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.weed5")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.weed6")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    If ((((i_714\Field0 = $01) Or (wearinghazmat = $03)) Or (wearinggasmask = $03)) <> 0) Then
                        msg = ((chr($22) + scplang_getphrase("ingame.weed3")) + chr($22))
                    Else
                        deathmsg = scplang_getphrase("ingame.weed7")
                        msg = ((chr($22) + scplang_getphrase("ingame.weed8")) + chr($22))
                        killtimer = -1.0
                    EndIf
                    msgtimer = 420.0
                    removeitem(selecteditem)
                EndIf
            Case "scp714"
                If (i_714\Field0 = $01) Then
                    msg = scplang_getphrase("ingame.ringoff")
                    i_714\Field0 = $00
                Else
                    giveachievement($10, $01)
                    msg = scplang_getphrase("ingame.ringon")
                    i_714\Field0 = $01
                EndIf
                msgtimer = 350.0
                selecteditem = Null
            Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
                currspeed = curvevalue(0.0, currspeed, 5.0)
                drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                local20 = $12C
                local21 = $14
                local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                local3 = ((graphicheight Sar $01) + $50)
                rect(local2, local3, (local20 + $04), local21, $00)
                For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                    drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                Next
                selecteditem\Field13 = min((selecteditem\Field13 + (local16\Field3[$00] / 4.0)), 100.0)
                If (100.0 = selecteditem\Field13) Then
                    If (wearinghazmat > $00) Then
                        msg = scplang_getphrase("ingame.hazmatoff")
                        wearinghazmat = $00
                        dropitem(selecteditem, $01)
                    Else
                        If (selecteditem\Field3\Field1 = "hazmatsuit") Then
                            wearinghazmat = $01
                        ElseIf (selecteditem\Field3\Field1 = "hazmatsuit2") Then
                            wearinghazmat = $02
                        Else
                            wearinghazmat = $03
                        EndIf
                        If (selecteditem\Field3\Field2 <> $42) Then
                            playsound_strict(picksfx(selecteditem\Field3\Field2))
                        EndIf
                        msg = scplang_getphrase("ingame.hazmaton")
                    EndIf
                    selecteditem\Field13 = 0.0
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "vest","finevest"
                currspeed = curvevalue(0.0, currspeed, 5.0)
                drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                local20 = $12C
                local21 = $14
                local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                local3 = ((graphicheight Sar $01) + $50)
                rect(local2, local3, (local20 + $04), local21, $00)
                For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                    drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                Next
                selecteditem\Field13 = min(((local16\Field3[$00] / (((Float (selecteditem\Field3\Field1 = "finevest")) * 0.5) + 2.0)) + selecteditem\Field13), 100.0)
                If (100.0 = selecteditem\Field13) Then
                    If (wearingvest > $00) Then
                        msg = scplang_getphrase("ingame.vestoff")
                        wearingvest = $00
                        dropitem(selecteditem, $01)
                    Else
                        If (selecteditem\Field3\Field1 = "vest") Then
                            msg = scplang_getphrase("ingame.veston1")
                            wearingvest = $01
                        Else
                            msg = scplang_getphrase("ingame.veston2")
                            wearingvest = $02
                        EndIf
                        If (selecteditem\Field3\Field2 <> $42) Then
                            playsound_strict(picksfx(selecteditem\Field3\Field2))
                        EndIf
                    EndIf
                    selecteditem\Field13 = 0.0
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "gasmask","supergasmask","gasmask3"
                For local5 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local5) <> Null) Then
                        If (((inventory(local5)\Field3\Field0 = "SCP-215") And (86.0 <= i_215\Field1)) <> 0) Then
                            msg = scplang_getphrase("ingame.gasmaskerr1")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                            Exit
                        EndIf
                    EndIf
                Next
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.gasmaskerr2")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.gasmaskerr3")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.gasmaskerr4")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.gasmaskerr5")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinghelmet > $00) Then
                    msg = scplang_getphrase("ingame.gasmaskerr6")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local3 = ((graphicheight Sar $01) + $50)
                    rect(local2, local3, (local20 + $04), local21, $00)
                    For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + local16\Field3[$00]), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        If (wearinggasmask > $00) Then
                            wearinggasmask = $00
                            msg = scplang_getphrase("ingame.gasmaskoff")
                            If (selecteditem\Field3\Field2 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field3\Field2))
                            EndIf
                        Else
                            If (selecteditem\Field3\Field1 = "supergasmask") Then
                                msg = scplang_getphrase("ingame.gasmaskon1")
                                wearinggasmask = $02
                            ElseIf (selecteditem\Field3\Field1 = "gasmask3") Then
                                msg = scplang_getphrase("ingame.gasmaskon2")
                                wearinggasmask = $03
                            ElseIf (selecteditem\Field3\Field1 = "gasmask") Then
                                msg = scplang_getphrase("ingame.gasmaskon2")
                                wearinggasmask = $01
                            EndIf
                            If (selecteditem\Field3\Field2 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field3\Field2))
                            EndIf
                        EndIf
                        selecteditem\Field13 = 0.0
                        msgtimer = 350.0
                        selecteditem = Null
                    EndIf
                EndIf
            Case "navigator","nav"
                If (selecteditem\Field3\Field11 = $00) Then
                    selecteditem\Field3\Field11 = loadimage_strict(selecteditem\Field3\Field10)
                    maskimage(selecteditem\Field3\Field11, $FF, $00, $FF)
                EndIf
                If (100.0 >= selecteditem\Field13) Then
                    selecteditem\Field13 = max(0.0, (selecteditem\Field13 - (local16\Field3[$00] * 0.005)))
                EndIf
                local2 = (Int (((Float graphicwidth) - ((Float imagewidth(selecteditem\Field3\Field11)) * 0.5)) + 20.0))
                local3 = (Int (((Float graphicheight) - ((Float imageheight(selecteditem\Field3\Field11)) * 0.4)) - 85.0))
                local20 = $11F
                local21 = $100
                drawimage(selecteditem\Field3\Field11, (local2 - (imagewidth(selecteditem\Field3\Field11) Sar $01)), ((local3 - (imageheight(selecteditem\Field3\Field11) Sar $01)) + $55), $00)
                aasetfont(local0\Field0[$02])
                local73 = $01
                If (((playerroom\Field7\Field10 = "pocketdimension") Or (playerroom\Field7\Field10 = "dimension1499")) <> 0) Then
                    local73 = $00
                ElseIf (playerroom\Field7\Field10 = "room860") Then
                    For local17 = Each events
                        If (local17\Field0 = "room860") Then
                            If (1.0 = local17\Field2) Then
                                local73 = $00
                            EndIf
                            Exit
                        EndIf
                    Next
                EndIf
                If (local73 = $00) Then
                    If ((millisecs2() Mod $3E8) > $12C) Then
                        color($C8, $00, $00)
                        aatext(local2, (((local21 Sar $01) + local3) - $50), scplang_getphrase("ingame.naverr1"), $01, $00, 1.0)
                        aatext(local2, (((local21 Sar $01) + local3) - $3C), scplang_getphrase("ingame.naverr2"), $01, $00, 1.0)
                    EndIf
                ElseIf (((0.0 < selecteditem\Field13) And ((1.0 < rnd((coffindistance + 15.0), 0.0)) Or (playerroom\Field7\Field10 <> "room895"))) <> 0) Then
                    local71 = (Int floor((((entityx(playerroom\Field2, $00) + 8.0) / 8.0) + 0.5)))
                    local72 = (Int floor((((entityz(playerroom\Field2, $00) + 8.0) / 8.0) + 0.5)))
                    setbuffer(imagebuffer(navbg, $00))
                    local74 = (local2 - (imagewidth(selecteditem\Field3\Field11) Sar $01))
                    local75 = ((local3 - (imageheight(selecteditem\Field3\Field11) Sar $01)) + $55)
                    drawimage(selecteditem\Field3\Field11, local74, local75, $00)
                    local2 = (Int (((((entityx(collider, $00) - 4.0) + 8.0) Mod 8.0) * 3.0) + (Float (local2 - $0C))))
                    local3 = (Int ((Float (local3 + $0C)) - ((((entityz(collider, $00) - 4.0) + 8.0) Mod 8.0) * 3.0)))
                    For local8 = max(0.0, (Float (local71 - $06))) To min((Float mapwidth), (Float (local71 + $06))) Step 1.0
                        For local10 = max(0.0, (Float (local72 - $06))) To min((Float mapheight), (Float (local72 + $06))) Step 1.0
                            If (((16.0 < coffindistance) Or (coffindistance > rnd(16.0, 0.0))) <> 0) Then
                                If (((maptemp((Int local8), (Int local10)) > $00) And (((mapfound((Int local8), (Int local10)) > $00) Or (selecteditem\Field3\Field0 = "S-NAV 310 Navigator")) Or (selecteditem\Field3\Field0 = "S-NAV Navigator Ultimate"))) <> 0) Then
                                    local76 = (Int ((((Float (local71 - $01)) - local8) * 24.0) + (Float local2)))
                                    local77 = (Int ((Float local3) - (((Float (local72 - $01)) - local10) * 24.0)))
                                    If ((Float mapwidth) >= (local8 + 1.0)) Then
                                        If (maptemp((Int (local8 + 1.0)), (Int local10)) = $00) Then
                                            drawimage(navimages($03), (local76 - $0C), (local77 - $0C), $00)
                                        EndIf
                                    Else
                                        drawimage(navimages($03), (local76 - $0C), (local77 - $0C), $00)
                                    EndIf
                                    If (0.0 <= (local8 - 1.0)) Then
                                        If (maptemp((Int (local8 - 1.0)), (Int local10)) = $00) Then
                                            drawimage(navimages($01), (local76 - $0C), (local77 - $0C), $00)
                                        EndIf
                                    Else
                                        drawimage(navimages($01), (local76 - $0C), (local77 - $0C), $00)
                                    EndIf
                                    If (0.0 <= (local10 - 1.0)) Then
                                        If (maptemp((Int local8), (Int (local10 - 1.0))) = $00) Then
                                            drawimage(navimages($00), (local76 - $0C), (local77 - $0C), $00)
                                        EndIf
                                    Else
                                        drawimage(navimages($00), (local76 - $0C), (local77 - $0C), $00)
                                    EndIf
                                    If ((Float mapheight) >= (local10 + 1.0)) Then
                                        If (maptemp((Int local8), (Int (local10 + 1.0))) = $00) Then
                                            drawimage(navimages($02), (local76 - $0C), (local77 - $0C), $00)
                                        EndIf
                                    Else
                                        drawimage(navimages($02), (local76 - $0C), (local77 - $0C), $00)
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    Next
                    setbuffer(backbuffer())
                    drawimagerect(navbg, (local74 + $50), (local75 + $46), (local74 + $50), (local75 + $46), $10E, $E6, $00)
                    color($1E, $1E, $1E)
                    If (selecteditem\Field3\Field0 = "S-NAV Navigator") Then
                        color($64, $00, $00)
                    EndIf
                    rect((local74 + $50), (local75 + $46), $10E, $E6, $00)
                    local2 = (Int (((Float graphicwidth) - ((Float imagewidth(selecteditem\Field3\Field11)) * 0.5)) + 20.0))
                    local3 = (Int (((Float graphicheight) - ((Float imageheight(selecteditem\Field3\Field11)) * 0.4)) - 85.0))
                    If (selecteditem\Field3\Field0 = "S-NAV Navigator") Then
                        color($64, $00, $00)
                    Else
                        color($1E, $1E, $1E)
                    EndIf
                    If ((millisecs2() Mod $3E8) > $12C) Then
                        If (((selecteditem\Field3\Field0 <> "S-NAV 310 Navigator") And (selecteditem\Field3\Field0 <> "S-NAV Navigator Ultimate")) <> 0) Then
                            aatext(((local2 - (local20 Sar $01)) + $0A), ((local3 - (local21 Sar $01)) + $0A), scplang_getphrase("ingame.naverr3"), $00, $00, 1.0)
                        EndIf
                        local6 = (entityyaw(collider, $00) - 90.0)
                        local78 = (Int ((cos(local6) * 6.0) + (Float local2)))
                        local79 = (Int ((Float local3) - (sin(local6) * 6.0)))
                        local8 = ((cos((local6 - 140.0)) * 5.0) + (Float local2))
                        local9 = ((Float local3) - (sin((local6 - 140.0)) * 5.0))
                        local80 = (Int ((cos((local6 + 140.0)) * 5.0) + (Float local2)))
                        local81 = (Int ((Float local3) - (sin((local6 + 140.0)) * 5.0)))
                        line(local78, local79, (Int local8), (Int local9))
                        line(local78, local79, local80, local81)
                        line((Int local8), (Int local9), local80, local81)
                    EndIf
                    local82 = $00
                    If (((selecteditem\Field3\Field0 = "S-NAV Navigator Ultimate") And ((millisecs2() Mod $258) < $190)) <> 0) Then
                        If (curr173 <> Null) Then
                            local83 = entitydistance(camera, curr173\Field0)
                            local83 = (ceil((local83 / 8.0)) * 8.0)
                            If (32.0 > local83) Then
                                color($64, $00, $00)
                                oval((Int ((Float local2) - (local83 * 3.0))), (Int ((Float (local3 - $07)) - (local83 * 3.0))), (Int ((local83 * 3.0) * 2.0)), (Int ((local83 * 3.0) * 2.0)), $00)
                                aatext(((local2 - (local20 Sar $01)) + $0A), ((local3 - (local21 Sar $01)) + $1E), "SCP-173", $00, $00, 1.0)
                                local82 = (local82 + $01)
                            EndIf
                        EndIf
                        If (curr106 <> Null) Then
                            local83 = entitydistance(camera, curr106\Field0)
                            If (32.0 > local83) Then
                                color($64, $00, $00)
                                oval((Int ((Float local2) - (local83 * 1.5))), (Int ((Float (local3 - $07)) - (local83 * 1.5))), (Int (local83 * 3.0)), (Int (local83 * 3.0)), $00)
                                aatext(((local2 - (local20 Sar $01)) + $0A), (((local3 - (local21 Sar $01)) + $1E) + ($14 * local82)), "SCP-106", $00, $00, 1.0)
                                local82 = (local82 + $01)
                            EndIf
                        EndIf
                        If (curr096 <> Null) Then
                            local83 = entitydistance(camera, curr096\Field0)
                            If (32.0 > local83) Then
                                color($64, $00, $00)
                                oval((Int ((Float local2) - (local83 * 1.5))), (Int ((Float (local3 - $07)) - (local83 * 1.5))), (Int (local83 * 3.0)), (Int (local83 * 3.0)), $00)
                                aatext(((local2 - (local20 Sar $01)) + $0A), (((local3 - (local21 Sar $01)) + $1E) + ($14 * local82)), "SCP-096", $00, $00, 1.0)
                                local82 = (local82 + $01)
                            EndIf
                        EndIf
                        If (curr650 <> Null) Then
                            local83 = entitydistance(camera, curr650\Field0)
                            If (32.0 > local83) Then
                                color($64, $00, $00)
                                oval((Int ((Float local2) - (local83 * 1.5))), (Int ((Float (local3 - $07)) - (local83 * 1.5))), (Int (local83 * 3.0)), (Int (local83 * 3.0)), $00)
                                aatext(((local2 - (local20 Sar $01)) + $0A), (((local3 - (local21 Sar $01)) + $1E) + ($14 * local82)), "SCP-650", $00, $00, 1.0)
                                local82 = (local82 + $01)
                            EndIf
                        EndIf
                        If (curr066 <> Null) Then
                            local83 = entitydistance(camera, curr066\Field0)
                            If (32.0 > local83) Then
                                color($64, $00, $00)
                                oval((Int ((Float local2) - (local83 * 1.5))), (Int ((Float (local3 - $07)) - (local83 * 1.5))), (Int (local83 * 3.0)), (Int (local83 * 3.0)), $00)
                                aatext(((local2 - (local20 Sar $01)) + $0A), (((local3 - (local21 Sar $01)) + $1E) + ($14 * local82)), "SCP-066", $00, $00, 1.0)
                                local82 = (local82 + $01)
                            EndIf
                        EndIf
                        For local84 = Each npcs
                            If (local84\Field5 = $03) Then
                                local83 = entitydistance(camera, local84\Field0)
                                If (32.0 > local83) Then
                                    If (local84\Field68 = $00) Then
                                        color($64, $00, $00)
                                        oval((Int ((Float local2) - (local83 * 1.5))), (Int ((Float (local3 - $07)) - (local83 * 1.5))), (Int (local83 * 3.0)), (Int (local83 * 3.0)), $00)
                                        aatext(((local2 - (local20 Sar $01)) + $0A), (((local3 - (local21 Sar $01)) + $1E) + ($14 * local82)), "SCP-049", $00, $00, 1.0)
                                        local82 = (local82 + $01)
                                    EndIf
                                EndIf
                                Exit
                            EndIf
                        Next
                        If (playerroom\Field7\Field10 = "room895") Then
                            If (8.0 > coffindistance) Then
                                local83 = rnd(4.0, 8.0)
                                color($64, $00, $00)
                                oval((Int ((Float local2) - (local83 * 1.5))), (Int ((Float (local3 - $07)) - (local83 * 1.5))), (Int (local83 * 3.0)), (Int (local83 * 3.0)), $00)
                                aatext(((local2 - (local20 Sar $01)) + $0A), (((local3 - (local21 Sar $01)) + $1E) + ($14 * local82)), "SCP-895", $00, $00, 1.0)
                            EndIf
                        EndIf
                    EndIf
                    color($1E, $1E, $1E)
                    If (selecteditem\Field3\Field0 = "S-NAV Navigator") Then
                        color($64, $00, $00)
                    EndIf
                    If (100.0 >= selecteditem\Field13) Then
                        local12 = ((local2 - (local20 Sar $01)) + $C4)
                        local13 = ((local3 - (local21 Sar $01)) + $0A)
                        rect(local12, local13, $50, $14, $00)
                        For local5 = $01 To (Int ceil((selecteditem\Field13 / 10.0))) Step $01
                            drawimage(navimages($04), (((local5 Shl $03) + local12) - $06), (local13 + $04), $00)
                        Next
                        aasetfont(local0\Field0[$02])
                    EndIf
                EndIf
            Case "scp1499","super1499"
                For local5 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local5) <> Null) Then
                        If (((inventory(local5)\Field3\Field0 = "SCP-215") And (86.0 <= i_215\Field1)) <> 0) Then
                            msg = scplang_getphrase("ingame.scp1499err1")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                            Exit
                        EndIf
                    EndIf
                Next
                If (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.scp1499err2")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.scp1499err3")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp1499err4")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp1499err5")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinghelmet > $00) Then
                    msg = scplang_getphrase("ingame.scp1499err6")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local3 = ((graphicheight Sar $01) + $50)
                    rect(local2, local3, (local20 + $04), local21, $00)
                    For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + local16\Field3[$00]), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        If (i_1499\Field0 > $00) Then
                            i_1499\Field0 = $00
                            If (selecteditem\Field3\Field2 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field3\Field2))
                            EndIf
                        Else
                            If (selecteditem\Field3\Field1 = "scp1499") Then
                                i_1499\Field0 = $01
                            Else
                                i_1499\Field0 = $02
                            EndIf
                            If (selecteditem\Field3\Field2 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field3\Field2))
                            EndIf
                            giveachievement($1C, $01)
                            For local61 = Each rooms
                                If (local61\Field7\Field10 = "dimension1499") Then
                                    blinktimer = -1.0
                                    i_1499\Field4 = playerroom
                                    i_1499\Field1 = entityx(collider, $00)
                                    i_1499\Field2 = entityy(collider, $00)
                                    i_1499\Field3 = entityz(collider, $00)
                                    If ((((0.0 = i_1499\Field5) And (0.0 = i_1499\Field6)) And (0.0 = i_1499\Field7)) <> 0) Then
                                        positionentity(collider, (local61\Field3 + (6086.0 * roomscale)), (local61\Field4 + (304.0 * roomscale)), (local61\Field5 + (2292.5 * roomscale)), $00)
                                        rotateentity(collider, 0.0, 90.0, 0.0, $01)
                                    Else
                                        positionentity(collider, i_1499\Field5, (i_1499\Field6 + 0.05), i_1499\Field7, $00)
                                    EndIf
                                    resetentity(collider)
                                    updatedoors()
                                    updaterooms()
                                    For local18 = Each items
                                        local18\Field12 = 0.0
                                    Next
                                    playerroom = local61
                                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\1499\Enter.ogg")))
                                    i_1499\Field5 = 0.0
                                    i_1499\Field6 = 0.0
                                    i_1499\Field7 = 0.0
                                    If (curr096 <> Null) Then
                                        If (curr096\Field17 <> $00) Then
                                            setstreamvolume_strict(curr096\Field17, 0.0)
                                        EndIf
                                    EndIf
                                    For local17 = Each events
                                        If (local17\Field0 = "dimension1499") Then
                                            If ((8300.0 * roomscale) < entitydistance(local17\Field1\Field2, collider)) Then
                                                If (5.0 > local17\Field3) Then
                                                    local17\Field3 = (local17\Field3 + 1.0)
                                                EndIf
                                            EndIf
                                            Exit
                                        EndIf
                                    Next
                                    Exit
                                EndIf
                            Next
                        EndIf
                        selecteditem\Field13 = 0.0
                        selecteditem = Null
                    EndIf
                EndIf
            Case "badge"
                If (selecteditem\Field3\Field11 = $00) Then
                    selecteditem\Field3\Field11 = loadimage_strict(selecteditem\Field3\Field10)
                    maskimage(selecteditem\Field3\Field11, $FF, $00, $FF)
                EndIf
                drawimage(selecteditem\Field3\Field11, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field11) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field11) Sar $01)), $00)
                If (0.0 = selecteditem\Field13) Then
                    playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg"))))
                    local85 = selecteditem\Field3\Field0
                    If (local85 = "Old Badge") Then
                        msg = ((chr($22) + scplang_getphrase("ingame.badge")) + chr($22))
                        msgtimer = 700.0
                    EndIf
                    selecteditem\Field13 = 1.0
                EndIf
            Case "key"
                If (0.0 = selecteditem\Field13) Then
                    playsound_strict(loadtempsound((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg")))
                    msg = ((chr($22) + scplang_getphrase("ingame.keyshack")) + chr($22))
                    msgtimer = 700.0
                EndIf
                selecteditem\Field13 = 1.0
                selecteditem = Null
            Case "oldpaper"
                If (selecteditem\Field3\Field11 = $00) Then
                    selecteditem\Field3\Field11 = loadimage_strict(selecteditem\Field3\Field10)
                    selecteditem\Field3\Field11 = resizeimage2(selecteditem\Field3\Field11, (Int ((Float imagewidth(selecteditem\Field3\Field11)) * menuscale)), (Int ((Float imageheight(selecteditem\Field3\Field11)) * menuscale)))
                    maskimage(selecteditem\Field3\Field11, $FF, $00, $FF)
                EndIf
                drawimage(selecteditem\Field3\Field11, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field11) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field11) Sar $01)), $00)
                If (0.0 = selecteditem\Field13) Then
                    local86 = selecteditem\Field3\Field0
                    If (local86 = "Disciplinary Hearing DH-S-4137-17092") Then
                        blurtimer = 1000.0
                        msg = ((chr($22) + scplang_getphrase("ingame.oldpaper")) + chr($22))
                        msgtimer = 700.0
                        playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($06, $0A))) + ".ogg"))))
                        selecteditem\Field13 = 1.0
                    EndIf
                EndIf
            Case "coin"
                If (0.0 = selecteditem\Field13) Then
                    playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\SCP\1162\NostalgiaCancer" + (Str rand($01, $05))) + ".ogg"))))
                EndIf
                msg = ""
                selecteditem\Field13 = 1.0
                drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
            Case "scp427"
                If (i_427\Field0 = $01) Then
                    msg = scplang_getphrase("ingame.locketoff")
                    i_427\Field0 = $00
                Else
                    giveachievement($0D, $01)
                    msg = scplang_getphrase("ingame.locketon")
                    i_427\Field0 = $01
                EndIf
                msgtimer = 350.0
                selecteditem = Null
            Case "pill"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.pill1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.pillgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    msg = scplang_getphrase("ingame.pillnone")
                    msgtimer = 490.0
                    removeitem(selecteditem)
                    selecteditem = Null
                EndIf
            Case "scp500pilldeath"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.pill1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.pillgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    msg = scplang_getphrase("ingame.pillnone")
                    msgtimer = 490.0
                    If (25200.0 > i_427\Field1) Then
                        i_427\Field1 = 25200.0
                    EndIf
                    removeitem(selecteditem)
                EndIf
            Case "syringeinf"
                If (i_402\Field0 = $00) Then
                    staminaeffect = 0.5
                    staminaeffecttimer = 20.0
                    msg = scplang_getphrase("ingame.syringe6")
                    msgtimer = 560.0
                    i_008\Field0 = (i_008\Field0 + (Float ((selecteddifficulty\Field3 Shl $00) + $01)))
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "mintveryfinefirstaid"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.weed5")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.weed6")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.aid215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.aid178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.aidnvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    Select rand($03, $01)
                        Case $01
                            injuries = 0.0
                            bloodloss = 0.0
                            i_1079\Field0 = 0.0
                            msg = scplang_getphrase("ingame.aid2heal1")
                            msgtimer = 490.0
                        Case $02
                            injuries = max(0.0, (injuries - rnd(1.0, 3.5)))
                            bloodloss = max(0.0, (bloodloss - rnd(25.0, 100.0)))
                            msg = scplang_getphrase("ingame.aid2heal2")
                            msgtimer = 490.0
                        Case $03
                            injuries = 2.5
                            msg = scplang_getphrase("ingame.aid2heal3")
                            msgtimer = 490.0
                    End Select
                    i_447\Field2 = $01
                    i_447\Field3 = 30000.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "mintfirstaid","mintfinefirstaid","mintfirstaid2"
                If ((((0.0 = bloodloss) And (0.0 = injuries)) And (0.0 = i_1079\Field0)) <> 0) Then
                    msg = scplang_getphrase("ingame.aidnotnow")
                    msgtimer = 350.0
                    selecteditem = Null
                Else
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local3 = ((graphicheight Sar $01) + $50)
                    rect(local2, local3, (local20 + $04), local21, $00)
                    For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + (local16\Field3[$00] / 5.0)), 100.0)
                    If (crouch = $00) Then
                        crouchchn = playsound_strict(crouchsfx)
                    EndIf
                    crouch = $01
                    If (100.0 = selecteditem\Field13) Then
                        If (selecteditem\Field3\Field1 = "mintfinefirstaid") Then
                            bloodloss = 0.0
                            i_1079\Field0 = 0.0
                            injuries = max(0.0, (injuries - 2.5))
                            If (0.0 = injuries) Then
                                msg = scplang_getphrase("ingame.aid2heal4")
                            ElseIf (1.0 < injuries) Then
                                msg = scplang_getphrase("ingame.aid2heal5")
                            Else
                                msg = scplang_getphrase("ingame.aid2heal6")
                            EndIf
                            msgtimer = 350.0
                            removeitem(selecteditem)
                        Else
                            bloodloss = max(0.0, (bloodloss - (Float rand($0F, $19))))
                            If (2.5 <= injuries) Then
                                msg = scplang_getphrase("ingame.aid2heal7")
                                injuries = max(2.5, (injuries - rnd(0.4, 0.8)))
                            ElseIf (1.0 < injuries) Then
                                injuries = max(0.5, (injuries - rnd(0.6, 1.1)))
                                If (1.0 < injuries) Then
                                    msg = scplang_getphrase("ingame.aid2heal8")
                                Else
                                    msg = scplang_getphrase("ingame.aid2heal9")
                                EndIf
                            ElseIf (0.5 < injuries) Then
                                injuries = 0.5
                                msg = scplang_getphrase("ingame.aid2heal10")
                            Else
                                injuries = 0.5
                                msg = scplang_getphrase("ingame.aid2heal11")
                            EndIf
                            If (selecteditem\Field3\Field1 = "mintfirstaid2") Then
                                Select rand($05, $01)
                                    Case $01
                                        superman = $01
                                        msg = scplang_getphrase("ingame.aid2heal12")
                                    Case $02
                                        invertmouse = (invertmouse = $00)
                                        msg = scplang_getphrase("ingame.aid2heal13")
                                    Case $03
                                        blinkeffect = 0.4
                                        blinkeffecttimer = (Float rand($1E, $28))
                                    Case $04
                                        bloodloss = 0.0
                                        i_1079\Field0 = 0.0
                                        injuries = 0.0
                                        msg = scplang_getphrase("ingame.aid2heal14")
                                    Case $05
                                        msg = scplang_getphrase("ingame.aid2heal15")
                                        injuries = 2.5
                                End Select
                            EndIf
                            i_447\Field2 = $01
                            i_447\Field3 = 40000.0
                            msgtimer = 350.0
                            removeitem(selecteditem)
                        EndIf
                    EndIf
                EndIf
            Case "minteyedrops","minteyedrops2"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops21499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.drops2gas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops2215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops2178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.drops2nvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    msg = scplang_getphrase("ingame.drops2good")
                    msgtimer = 350.0
                    blinkeffect = 0.5
                    blinkeffecttimer = (Float rand($1E, $28))
                    blurtimer = 200.0
                    i_447\Field0 = $01
                    i_447\Field1 = 20000.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "mintfineeyedrops"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops21499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.drops2gas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops2215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops2178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.drops2nvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    blinkeffect = 0.3
                    blinkeffecttimer = (Float rand($28, $32))
                    bloodloss = max((bloodloss - 1.5), 0.0)
                    blurtimer = 200.0
                    i_447\Field0 = $01
                    i_447\Field1 = 20000.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "mintsupereyedrops"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops21499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.drops2gas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops2215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.drops2178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.drops2nvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    blinkeffect = 0.1
                    blinkeffecttimer = (Float rand($32, $3C))
                    bloodloss = max((bloodloss - 3.5), 0.0)
                    blurtimer = 200.0
                    i_447\Field0 = $01
                    i_447\Field1 = 20000.0
                    removeitem(selecteditem)
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "morphine"
                If (i_402\Field0 = $00) Then
                    If (0.5 > injuries) Then
                        msg = scplang_getphrase("ingame.morphine1")
                        msgtimer = 350.0
                        selecteditem = Null
                    Else
                        If (3.0 < injuries) Then
                            morphinehealamount = min((morphinehealamount + 2.5), 4.0)
                            injuries = max((injuries - 2.5), 0.5)
                        Else
                            morphinehealamount = min(((injuries - 0.5) + morphinehealamount), 4.0)
                            injuries = max((injuries - 2.5), 0.5)
                        EndIf
                        msg = scplang_getphrase("ingame.morphine2")
                        msgtimer = 350.0
                        morphinetimer = 10000.0
                        usedmorphine = $01
                        removeitem(selecteditem)
                    EndIf
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
            Case "mintscp500pill"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.pillmint1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.pillmintgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    giveachievement($0E, $01)
                    If (0.0 < i_008\Field0) Then
                        msg = scplang_getphrase("ingame.pill008")
                    ElseIf (0.0 < i_409\Field0) Then
                        msg = scplang_getphrase("ingame.pill409")
                    ElseIf (0.0 < i_357\Field0) Then
                        msg = scplang_getphrase("ingame.pill357")
                    Else
                        msg = scplang_getphrase("ingame.pillnone")
                    EndIf
                    msgtimer = 490.0
                    deathtimer = 0.0
                    i_008\Field0 = 0.0
                    i_409\Field0 = 0.0
                    i_207\Field0 = 0.0
                    i_357\Field0 = 0.0
                    i_1079\Field2 = $00
                    i_1079\Field0 = 0.0
                    i_1079\Field1 = $00
                    stamina = 100.0
                    For local5 = $00 To $05 Step $01
                        scp1025state[local5] = 0.0
                    Next
                    For local17 = Each events
                        If (local17\Field0 = "room009") Then
                            local17\Field2 = 0.0
                            local17\Field4 = 0.0
                        EndIf
                    Next
                    If (1.0 < staminaeffect) Then
                        staminaeffect = 1.0
                        staminaeffecttimer = 0.0
                    EndIf
                    If (1.0 < blinkeffect) Then
                        blinkeffect = 1.0
                        blinkeffecttimer = 0.0
                    EndIf
                    i_447\Field4 = $01
                    i_447\Field5 = 40000.0
                    removeitem(selecteditem)
                EndIf
            Case "scp447"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.aid1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.aidgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    If (rand($0A, $01) = $01) Then
                        msg = ((chr($22) + scplang_getphrase("ingame.slime1")) + chr($22))
                    Else
                        msg = ((chr($22) + scplang_getphrase("ingame.slime2")) + chr($22))
                    EndIf
                    msgtimer = 350.0
                    selecteditem = Null
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
            Case "scp178"
                If (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.scp1781")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.scp1782")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp1783")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp1784")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinghelmet > $00) Then
                    msg = scplang_getphrase("ingame.scp1785")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    If (i_178\Field0 = $01) Then
                        msg = scplang_getphrase("ingame.scp1786")
                        i_178\Field0 = $00
                    Else
                        giveachievement($29, $01)
                        msg = scplang_getphrase("ingame.scp1787")
                        i_178\Field0 = $01
                    EndIf
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "scp215"
                If (86.0 <= i_215\Field1) Then
                    i_215\Field0 = $01
                    msg = scplang_getphrase("ingame.scp2151")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
                If (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.scp2152")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.scp2153")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp2154")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp2155")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinghelmet > $00) Then
                    msg = scplang_getphrase("ingame.scp2156")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    If (i_215\Field0 = $01) Then
                        msg = scplang_getphrase("ingame.scp2157")
                        i_215\Field0 = $00
                    Else
                        giveachievement($2C, $01)
                        msg = scplang_getphrase("ingame.scp2158")
                        i_215\Field0 = $01
                    EndIf
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "glassescase"
                If (itemamount < maxitemamount) Then
                    For local11 = $00 To (itemamount + $00) Step $01
                        If (inventory(local11) = Null) Then
                            If (itemamount > maxitemamount) Then
                                msg = scplang_getphrase("events.moreitems")
                                msgtimer = 350.0
                            Else
                                inventory(local11) = createitem("SCP-215", "scp215", 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00)
                                inventory(local11)\Field15 = $01
                                inventory(local11)\Field16 = $FFFFFFFF
                                inventory(local11)\Field3\Field3 = $01
                                i_215\Field4 = (i_215\Field4 + $01)
                                hideentity(inventory(local11)\Field1)
                                entitytype(inventory(local11)\Field1, $03, $00)
                                entityparent(inventory(local11)\Field1, $00, $01)
                            EndIf
                        EndIf
                    Next
                    If (i_215\Field4 >= $01) Then
                        removeitem(selecteditem)
                        i_215\Field4 = $00
                    EndIf
                Else
                    msg = scplang_getphrase("events.moreitems")
                    msgtimer = 350.0
                EndIf
            Case "scp1033ru","super1033ru"
                If (i_1033ru\Field2 > $00) Then
                    msg = scplang_getphrase("ingame.scp10331")
                    i_1033ru\Field2 = $00
                Else
                    giveachievement($33, $01)
                    msg = scplang_getphrase("ingame.scp10332")
                    If (selecteditem\Field3\Field1 = "scp1033ru") Then
                        i_1033ru\Field2 = $01
                    Else
                        i_1033ru\Field2 = $02
                    EndIf
                EndIf
                msgtimer = 350.0
                selecteditem = Null
            Case "scp1079sweet"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp10791")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.scp10792")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    Select rand($02, $01)
                        Case $01
                            msg = scplang_getphrase("ingame.scp10793")
                        Case $02
                            msg = scplang_getphrase("ingame.scp10794")
                    End Select
                    msgtimer = 490.0
                    i_1079\Field2 = (i_1079\Field2 + $01)
                    If (i_1033ru\Field0 = $00) Then
                        injuries = (injuries + 0.05)
                    Else
                        damage1033ru(rand($05, $01))
                    EndIf
                    playsound_strict(sizzsfx(rand($00, $01)))
                    giveachievement($34, $01)
                    removeitem(selecteditem)
                    local30 = createpivot($00)
                    positionentity(local30, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                    turnentity(local30, 90.0, 0.0, 0.0, $00)
                    entitypick(local30, 0.3)
                    local90 = createdecal(rand($16, $17), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
                    local90\Field2 = rnd(0.06, 0.1)
                    entityalpha(local90\Field0, 1.0)
                    scalesprite(local90\Field0, local90\Field2, local90\Field2)
                    channelvolume(local91, (rnd(0.0, 0.8) * sfxvolume))
                    channelpitch(local91, rand($4E20, $7530))
                    freeentity(local30)
                EndIf
                If (i_1079\Field2 >= $04) Then
                    i_1079\Field1 = $01
                    injuries = ((Float rand($02, $03)) + injuries)
                    deathmsg = scplang_getphrase("ingame.scp1079d")
                EndIf
            Case "scp1079"
                If (itemamount < maxitemamount) Then
                    For local11 = $00 To itemamount Step $01
                        If (inventory(local11) = Null) Then
                            If (itemamount > maxitemamount) Then
                                msg = scplang_getphrase("events.moreitems")
                                msgtimer = 350.0
                            Else
                                inventory(local11) = createitem("SCP-1079-01", "scp1079sweet", 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00)
                                inventory(local11)\Field15 = $01
                                inventory(local11)\Field16 = $FFFFFFFF
                                inventory(local11)\Field3\Field3 = $01
                                i_1079\Field3 = (i_1079\Field3 + $01)
                                hideentity(inventory(local11)\Field1)
                                entitytype(inventory(local11)\Field1, $03, $00)
                                entityparent(inventory(local11)\Field1, $00, $01)
                            EndIf
                        EndIf
                    Next
                    If (i_1079\Field3 >= $04) Then
                        removeitem(selecteditem)
                        i_1079\Field3 = $00
                    EndIf
                Else
                    msg = scplang_getphrase("events.moreitems")
                    msgtimer = 350.0
                EndIf
            Case "scp207"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp2071499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.scp207gas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local3 = ((graphicheight Sar $01) + $50)
                    rect(local2, local3, (local20 + $04), local21, $00)
                    For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + (local16\Field3[$00] / 1.2)), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        If (selecteditem\Field3\Field1 = "scp207") Then
                            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\109\Ahh.ogg")))
                            blinkeffect = 0.6
                            blinkeffecttimer = 400.0
                            bloodloss = 0.0
                            injuries = 0.0
                            If (0.0 = i_207\Field0) Then
                                local92 = (local92 Shl $01)
                            EndIf
                            staminaeffect = 0.6
                            staminaeffecttimer = 400.0
                            deathtimer = 0.0
                            i_008\Field0 = 0.0
                            stamina = 100.0
                            i_409\Field0 = 0.0
                            i_207\Field0 = 0.0
                            i_357\Field0 = 0.0
                            i_1079\Field2 = $00
                            i_1079\Field0 = 0.0
                            i_1079\Field1 = $00
                            For local5 = $00 To $05 Step $01
                                scp1025state[local5] = 0.0
                            Next
                            For local17 = Each events
                                If (local17\Field0 = "room009") Then
                                    local17\Field2 = 0.0
                                    local17\Field4 = 0.0
                                EndIf
                            Next
                            i_207\Field0 = 1.0
                            Select rand($01, $04)
                                Case $01
                                    msg = scplang_getphrase("ingame.scp2071")
                                    msgtimer = 420.0
                                Case $02
                                    msg = scplang_getphrase("ingame.scp2072")
                                    msgtimer = 420.0
                                Case $03
                                    msg = scplang_getphrase("ingame.scp2073")
                                    msgtimer = 420.0
                                Case $04
                                    msg = scplang_getphrase("ingame.scp2074")
                                    msgtimer = 420.0
                            End Select
                            selecteditem\Field13 = 0.0
                            removeitem(selecteditem)
                        EndIf
                    EndIf
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "scp198"
                msg = ((chr($22) + scplang_getphrase("ingame.scp1981")) + chr($22))
                msgtimer = 490.0
                selecteditem = Null
            Case "scp109"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.scp1091499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.scp109gas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_402\Field0 = $00) Then
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local3 = ((graphicheight Sar $01) + $50)
                    rect(local2, local3, (local20 + $04), local21, $00)
                    For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + (local16\Field3[$00] / 1.2)), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        If (selecteditem\Field3\Field1 = "scp109") Then
                            giveachievement($28, $01)
                            If (((-11.0 <= stamina) And (25.0 > stamina)) <> 0) Then
                                blurtimer = 10000.0
                                vomittimer = 10.0
                                msg = scplang_getphrase("ingame.scp1091")
                            ElseIf (((25.0 < stamina) And (60.0 > stamina)) <> 0) Then
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\109\ahh.ogg")))
                                injuries = max(0.0, (injuries - rnd(0.09, 0.1)))
                                msg = scplang_getphrase("ingame.scp1092")
                            ElseIf (((60.0 < stamina) And (100.0 > stamina)) <> 0) Then
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\109\ahh.ogg")))
                                injuries = max(0.0, (injuries - rnd(0.1, 0.5)))
                                msg = scplang_getphrase("ingame.scp1093")
                            Else
                                injuries = max(0.0, (injuries - rnd(0.1, 0.5)))
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\109\ahh.ogg")))
                                msg = scplang_getphrase("ingame.scp1094")
                            EndIf
                            stamina = ((Float rand($28, $01)) + stamina)
                            msgtimer = 350.0
                            selecteditem\Field13 = 0.0
                            selecteditem = Null
                        EndIf
                    EndIf
                Else
                    msg = ((chr($22) + scplang_getphrase("events.room10488")) + chr($22))
                    msgtimer = 350.0
                    Return $00
                    selecteditem = Null
                EndIf
            Case "scp500"
                If (itemamount < maxitemamount) Then
                    For local11 = $00 To (itemamount + $00) Step $01
                        If (inventory(local11) = Null) Then
                            If (itemamount > maxitemamount) Then
                                msg = scplang_getphrase("events.moreitems")
                                msgtimer = 350.0
                            Else
                                inventory(local11) = createitem("SCP-500-01", "scp500pill", 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00)
                                inventory(local11)\Field15 = $01
                                inventory(local11)\Field16 = $FFFFFFFF
                                inventory(local11)\Field3\Field3 = $01
                                i_500\Field0 = (i_500\Field0 + $01)
                                hideentity(inventory(local11)\Field1)
                                entitytype(inventory(local11)\Field1, $03, $00)
                                entityparent(inventory(local11)\Field1, $00, $01)
                            EndIf
                        EndIf
                    Next
                    If (i_500\Field0 >= $03) Then
                        removeitem(selecteditem)
                        i_500\Field0 = $00
                    EndIf
                Else
                    msg = scplang_getphrase("events.moreitems")
                    msgtimer = 350.0
                EndIf
            Case "scp402"
                If (40.0 <= i_402\Field1) Then
                    i_402\Field0 = $01
                    msg = scplang_getphrase("ingame.scp4021")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                EndIf
                If (((wearinggasmask = $00) And (i_1499\Field0 = $00)) <> 0) Then
                    If (i_402\Field0 = $01) Then
                        msg = scplang_getphrase("ingame.scp4022")
                        i_402\Field0 = $00
                    Else
                        giveachievement($2E, $01)
                        msg = scplang_getphrase("ingame.scp4023")
                        i_402\Field0 = $01
                    EndIf
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
            Case "helmet"
                For local5 = $00 To (maxitemamount - $01) Step $01
                    If (inventory(local5) <> Null) Then
                        If (((inventory(local5)\Field3\Field0 = "SCP-215") And (86.0 <= i_215\Field1)) <> 0) Then
                            msg = scplang_getphrase("ingame.helmetglasses")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                            Exit
                        EndIf
                    EndIf
                Next
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.helmet1499")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearingnightvision > $00) Then
                    msg = scplang_getphrase("ingame.helmetnvg")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.helmetgas")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_178\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.helmet178")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (i_215\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.helmet215")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    currspeed = curvevalue(0.0, currspeed, 5.0)
                    drawimage(selecteditem\Field3\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field3\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field3\Field7) Sar $01)), $00)
                    local20 = $12C
                    local21 = $14
                    local2 = ((graphicwidth Sar $01) - (local20 Sar $01))
                    local3 = ((graphicheight Sar $01) + $50)
                    rect(local2, local3, (local20 + $04), local21, $00)
                    For local5 = $01 To (Int (((selecteditem\Field13 / 100.0) * (Float (local20 - $02))) / 10.0)) Step $01
                        drawimage(blinkmeterimg, ((local2 + $03) + ((local5 - $01) * $0A)), (local3 + $03), $00)
                    Next
                    selecteditem\Field13 = min((selecteditem\Field13 + local16\Field3[$00]), 100.0)
                    If (100.0 = selecteditem\Field13) Then
                        If (wearinghelmet > $00) Then
                            wearinghelmet = $00
                            msg = scplang_getphrase("ingame.helmetoff")
                            If (selecteditem\Field3\Field2 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field3\Field2))
                            EndIf
                        Else
                            msg = scplang_getphrase("ingame.helmeton")
                            wearinghelmet = $01
                            If (selecteditem\Field3\Field2 <> $42) Then
                                playsound_strict(picksfx(selecteditem\Field3\Field2))
                            EndIf
                        EndIf
                        selecteditem\Field13 = 0.0
                        msgtimer = 350.0
                        selecteditem = Null
                    EndIf
                EndIf
            Case "mintpill"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.mintpill1")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.mintpill2")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    msg = scplang_getphrase("ingame.mintpill3")
                    msgtimer = 490.0
                    removeitem(selecteditem)
                    selecteditem = Null
                EndIf
            Case "mintscp500pilldeath"
                If (i_1499\Field0 > $00) Then
                    msg = scplang_getphrase("ingame.mintpill1")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                ElseIf (wearinggasmask > $00) Then
                    msg = scplang_getphrase("ingame.mintpill2")
                    msgtimer = 350.0
                    selecteditem = Null
                    Return $00
                Else
                    msg = scplang_getphrase("ingame.mintpill3")
                    msgtimer = 490.0
                    If (25200.0 > i_427\Field1) Then
                        i_427\Field1 = 25200.0
                    EndIf
                    removeitem(selecteditem)
                EndIf
            Default
                If (selecteditem\Field23 > $00) Then
                    doubleclick = $00
                    mousehit1 = $00
                    mousedown1 = $00
                    lastmousehit1 = $00
                    otheropen = selecteditem
                    selecteditem = Null
                EndIf
        End Select
        If (selecteditem <> Null) Then
            If (selecteditem\Field3\Field11 <> $00) Then
                local94 = selecteditem\Field3\Field1
                If (((((local94 = "paper") Or (local94 = "badge")) Or (local94 = "oldpaper")) Or (local94 = "ticket")) <> 0) Then
                    For local95 = Each items
                        If (local95 <> selecteditem) Then
                            local96 = local95\Field3\Field1
                            If (((((local96 = "paper") Or (local96 = "badge")) Or (local96 = "oldpaper")) Or (local96 = "ticket")) <> 0) Then
                                If (local95\Field3\Field11 <> $00) Then
                                    If (local95\Field3\Field11 <> selecteditem\Field3\Field11) Then
                                        freeimage(local95\Field3\Field11)
                                        local95\Field3\Field11 = $00
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                EndIf
            EndIf
        EndIf
        If (mousehit2 <> 0) Then
            entityalpha(at\Field4[$0D], 0.0)
            local94 = selecteditem\Field3\Field1
            If (local94 = "scp1025") Then
                If (selecteditem\Field3\Field11 <> $00) Then
                    freeimage(selecteditem\Field3\Field11)
                EndIf
                selecteditem\Field3\Field11 = $00
            ElseIf (((((((((((local94 = "firstaid") Or (local94 = "finefirstaid")) Or (local94 = "firstaid2")) Or (local94 = "mintfirstaid")) Or (local94 = "mintfirstaid2")) Or (local94 = "mintfinefirstaid")) Or (local94 = "scp207")) Or (local94 = "cola")) Or (local94 = "flask")) Or (local94 = "scp109")) <> 0) Then
                selecteditem\Field13 = 0.0
            ElseIf (((local94 = "vest") Or (local94 = "finevest")) <> 0) Then
                selecteditem\Field13 = 0.0
                If (wearingvest = $00) Then
                    dropitem(selecteditem, $00)
                EndIf
            ElseIf ((((local94 = "hazmatsuit") Or (local94 = "hazmatsuit2")) Or (local94 = "hazmatsuit3")) <> 0) Then
                selecteditem\Field13 = 0.0
                If (wearinghazmat = $00) Then
                    dropitem(selecteditem, $00)
                EndIf
            ElseIf (((((((local94 = "scp1499") Or (local94 = "super1499")) Or (local94 = "gasmask")) Or (local94 = "supergasmask")) Or (local94 = "gasmask3")) Or (local94 = "helmet")) <> 0) Then
                selecteditem\Field13 = 0.0
            EndIf
            If (selecteditem\Field3\Field2 <> $42) Then
                playsound_strict(picksfx(selecteditem\Field3\Field2))
            EndIf
            selecteditem = Null
        EndIf
    EndIf
    If (selecteditem = Null) Then
        For local5 = $00 To $05 Step $01
            If (radiochn(local5) <> $00) Then
                If (channelplaying(radiochn(local5)) <> 0) Then
                    pausechannel(radiochn(local5))
                EndIf
            EndIf
        Next
    EndIf
    For local18 = Each items
        If (local18 <> selecteditem) Then
            Select local18\Field3\Field1
                Case "firstaid","finefirstaid","firstaid2","vest","finevest","hazmatsuit","hazmatsuit2","hazmatsuit3","scp1499","super1499","gasmask","supergasmask","gasmask3","scp207","mintfirstaid","mintfirstaid2","mintfinefirstaid","scp109","helmet"
                    local18\Field13 = 0.0
            End Select
        EndIf
    Next
    If ((local27 And (invopen = $00)) <> 0) Then
        movemouse(viewport_center_x, viewport_center_y)
    EndIf
    Return $00
End Function
