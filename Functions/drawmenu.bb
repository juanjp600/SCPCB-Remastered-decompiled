Function drawmenu%()
    Local local0.fps_settings
    Local local1.fonts
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7#
    Local local8%
    Local local9%
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local16#
    Local local17%
    Local local18%
    Local local20.aafont
    Local local21%
    Local local22$
    Local local23%
    Local local24.rooms
    Local local25%
    local0 = (First fps_settings)
    local1 = (First fonts)
    If (api_getfocus() = $00) Then
        If (using294 = $00) Then
            ms\Field1 = $01
            pausesounds()
        EndIf
        delay($3E8)
    EndIf
    If (ms\Field1 <> 0) Then
        If (((playerroom\Field7\Field10 <> "gateb") And (playerroom\Field7\Field10 <> "gatea")) <> 0) Then
            If (0.0 = ms\Field2) Then
                If (((4.0 > entitydistance(curr173\Field4, collider)) Or (4.0 > entitydistance(curr106\Field4, collider))) <> 0) Then
                    ms\Field2 = 1.0
                EndIf
            ElseIf (40.0 > ms\Field2) Then
                If (0.0 <= killtimer) Then
                    ms\Field2 = (ms\Field2 + local0\Field3[$00])
                    If (40.0 <= ms\Field2) Then
                        playsound_strict(horrorsfx($0F))
                        msg = scplang_getphrase("ingame.stophiding")
                        msgtimer = 420.0
                        ms\Field1 = $00
                        Return $00
                    EndIf
                EndIf
            EndIf
        EndIf
        invopen = $00
        local4 = imagewidth(pausemenuimg)
        local5 = imageheight(pausemenuimg)
        local2 = ((graphicwidth Sar $01) - (local4 Sar $01))
        local3 = ((graphicheight Sar $01) - (local5 Sar $01))
        drawimage(pausemenuimg, local2, local3, $00)
        color($FF, $FF, $FF)
        local2 = (Int ((132.0 * menuscale) + (Float local2)))
        local3 = (Int ((122.0 * menuscale) + (Float local3)))
        If (mousedown1 = $00) Then
            onsliderid = $00
        EndIf
        If (achievementsmenu > $00) Then
            aasetfont(local1\Field0[$01])
            aatext(local2, (Int ((Float local3) - (77.0 * menuscale))), scplang_getphrase("menu.achievements"), $00, $01, 1.0)
            aasetfont(local1\Field0[$00])
        ElseIf (optionsmenu > $00) Then
            aasetfont(local1\Field0[$01])
            aatext(local2, (Int ((Float local3) - (77.0 * menuscale))), scplang_getphrase("menu.options"), $00, $01, 1.0)
            aasetfont(local1\Field0[$00])
        ElseIf (quitmsg > $00) Then
            aasetfont(local1\Field0[$01])
            aatext(local2, (Int ((Float local3) - (77.0 * menuscale))), scplang_getphrase("menu.quit2"), $00, $01, 1.0)
            aasetfont(local1\Field0[$00])
        ElseIf (0.0 <= killtimer) Then
            aasetfont(local1\Field0[$01])
            aatext(local2, (Int ((Float local3) - (77.0 * menuscale))), scplang_getphrase("menu.paused"), $00, $01, 1.0)
            aasetfont(local1\Field0[$00])
        Else
            aasetfont(local1\Field0[$01])
            aatext(local2, (Int ((Float local3) - (77.0 * menuscale))), scplang_getphrase("menu.youdied"), $00, $01, 1.0)
            aasetfont(local1\Field0[$00])
        EndIf
        local6 = (Int ((22.0 * menuscale) + (Float local2)))
        local7 = ((Float graphicheight) / 768.0)
        local8 = (Int (76.0 * local7))
        local9 = $40
        If ((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg <= $00)) <> 0) Then
            aasetfont(local1\Field0[$00])
            aatext(local2, local3, ((scplang_getphrase("menu.difficulty") + " ") + selecteddifficulty\Field0), $00, $00, 1.0)
            aatext(local2, (Int ((20.0 * menuscale) + (Float local3))), ((scplang_getphrase("menu.save") + " ") + currsave), $00, $00, 1.0)
            aatext(local2, (Int ((40.0 * menuscale) + (Float local3))), ((scplang_getphrase("menu.seed") + " ") + randomseed), $00, $00, 1.0)
        ElseIf (((((achievementsmenu <= $00) And (optionsmenu > $00)) And (quitmsg <= $00)) And (0.0 <= killtimer)) <> 0) Then
            If (drawbutton((Int ((101.0 * menuscale) + (Float local2))), (Int ((410.0 * menuscale) + (Float local3))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.back2"), $01, $00, $01) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                mousehit1 = $00
                saveoptionsini()
                antialias(opt_antialias)
                texturelodbias(texturefloat)
            EndIf
            color($00, $FF, $00)
            If (optionsmenu = $01) Then
                rect((Int ((Float local2) - (10.0 * menuscale))), (Int ((Float local3) - (5.0 * menuscale))), (Int (110.0 * menuscale)), (Int (40.0 * menuscale)), $01)
            ElseIf (optionsmenu = $02) Then
                rect((Int ((100.0 * menuscale) + (Float local2))), (Int ((Float local3) - (5.0 * menuscale))), (Int (110.0 * menuscale)), (Int (40.0 * menuscale)), $01)
            ElseIf (optionsmenu = $03) Then
                rect((Int ((210.0 * menuscale) + (Float local2))), (Int ((Float local3) - (5.0 * menuscale))), (Int (110.0 * menuscale)), (Int (40.0 * menuscale)), $01)
            ElseIf (optionsmenu = $04) Then
                rect((Int ((320.0 * menuscale) + (Float local2))), (Int ((Float local3) - (5.0 * menuscale))), (Int (110.0 * menuscale)), (Int (40.0 * menuscale)), $01)
            EndIf
            If (drawbutton((Int ((Float local2) - (5.0 * menuscale))), local3, (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.graphics"), $00, $00, $01) <> 0) Then
                optionsmenu = $01
            EndIf
            If (drawbutton((Int ((105.0 * menuscale) + (Float local2))), local3, (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.audio"), $00, $00, $01) <> 0) Then
                optionsmenu = $02
            EndIf
            If (drawbutton((Int ((215.0 * menuscale) + (Float local2))), local3, (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.controls"), $00, $00, $01) <> 0) Then
                optionsmenu = $03
            EndIf
            If (drawbutton((Int ((325.0 * menuscale) + (Float local2))), local3, (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.advanced"), $00, $00, $01) <> 0) Then
                optionsmenu = $04
            EndIf
            local10 = (Float ((graphicwidth Sar $01) + (local4 Sar $01)))
            local11 = (Float local3)
            local12 = (400.0 * menuscale)
            local13 = (150.0 * menuscale)
            color($FF, $FF, $FF)
            Select optionsmenu
                Case $01
                    aasetfont(local1\Field0[$00])
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    color($64, $64, $64)
                    aatext(local2, local3, scplang_getphrase("menu.bumpmapping"), $00, $00, 1.0)
                    bumpenabled = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), bumpenabled, $01)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "bump", 0.0, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.vsync"), $00, $00, 1.0)
                    vsync = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), vsync, $00)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "vsync", 0.0, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.antialiasing"), $00, $00, 1.0)
                    opt_antialias = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), opt_antialias, $00)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "antialias", 0.0, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.roomlights"), $00, $00, 1.0)
                    enableroomlights = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), enableroomlights, $00)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "roomlights", 0.0, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    screengamma = (slidebar((Int ((270.0 * menuscale) + (Float local2))), (Int ((6.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (screengamma * 50.0)) / 50.0)
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.gamma"), $00, $00, 1.0)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((6.0 * menuscale) + (Float local3))), (Int ((100.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "gamma", screengamma, $00)
                    EndIf
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.particleamount"), $00, $00, 1.0)
                    particleamount = slider3((Int ((270.0 * menuscale) + (Float local2))), (Int ((6.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), particleamount, $02, scplang_getphrase("menu.minimal"), scplang_getphrase("menu.reduced"), scplang_getphrase("menu.full"))
                    If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (6.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $02)) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "particleamount", (Float particleamount), $00)
                    EndIf
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.lodbias"), $00, $00, 1.0)
                    texturedetails = slider5((Int ((270.0 * menuscale) + (Float local2))), (Int ((6.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), texturedetails, $03, "0.8", "0.4", "0.0", "-0.4", "-0.8")
                    Select texturedetails
                        Case $00
                            texturefloat = 0.8
                        Case $01
                            texturefloat = 0.4
                        Case $02
                            texturefloat = 0.0
                        Case $03
                            texturefloat = -0.4
                        Case $04
                            texturefloat = -0.8
                    End Select
                    texturelodbias(texturefloat)
                    If (((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (6.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $03)) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int ((100.0 * menuscale) + local13)), "texquality", 0.0, $00)
                    EndIf
                    local3 = (Int ((40.0 * menuscale) + (Float local3)))
                    color($64, $64, $64)
                    aatext(local2, local3, scplang_getphrase("menu.vram"), $00, $00, 1.0)
                    savetexturesinvram = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), savetexturesinvram, $01)
                    If ((mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "vram", 0.0, $00)
                    EndIf
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    local16 = (fov - 40.0)
                    local16 = (slidebar((Int ((270.0 * menuscale) + (Float local2))), (Int ((6.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (local16 * 2.0)) / 2.0)
                    fov = (local16 + 40.0)
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.fov"), $00, $00, 1.0)
                    color($FF, $FF, $00)
                    aatext((Int ((5.0 * menuscale) + (Float local2))), (Int ((25.0 * menuscale) + (Float local3))), ((Str (Int fov)) + " FOV"), $00, $00, 1.0)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((6.0 * menuscale) + (Float local3))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "fov", 0.0, $00)
                    EndIf
                    camerazoom(camera, (min(((currcamerazoom / 400.0) + 1.0), 1.1) / tan(((atan(((tan((fov / 2.0)) * (Float realgraphicwidth)) / (Float realgraphicheight))) * 2.0) / 2.0))))
                Case $02
                    aasetfont(local1\Field0[$00])
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    musicvolume = (slidebar((Int ((250.0 * menuscale) + (Float local2))), (Int ((Float local3) - (4.0 * menuscale))), (Int (100.0 * menuscale)), (musicvolume * 100.0)) / 100.0)
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.musicvolume"), $00, $00, 1.0)
                    If (mouseon((Int ((250.0 * menuscale) + (Float local2))), (Int ((Float local3) - (4.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "musicvol", musicvolume, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    prevsfxvolume = (slidebar((Int ((250.0 * menuscale) + (Float local2))), (Int ((Float local3) - (4.0 * menuscale))), (Int (100.0 * menuscale)), (sfxvolume * 100.0)) / 100.0)
                    If (deafplayer = $00) Then
                        sfxvolume = prevsfxvolume
                    EndIf
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.soundvolume"), $00, $00, 1.0)
                    If (mouseon((Int ((250.0 * menuscale) + (Float local2))), (Int ((Float local3) - (4.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "soundvol", prevsfxvolume, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    color($64, $64, $64)
                    aatext(local2, local3, scplang_getphrase("menu.soundautorelease"), $00, $00, 1.0)
                    enablesfxrelease = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), enablesfxrelease, $01)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int ((220.0 * menuscale) + local13)), "sfxautorelease", 0.0, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    color($64, $64, $64)
                    aatext(local2, local3, scplang_getphrase("menu.usertracks"), $00, $00, 1.0)
                    enableusertracks = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), enableusertracks, $01)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "usertrack", 0.0, $00)
                    EndIf
                    If (enableusertracks <> 0) Then
                        local3 = (Int ((30.0 * menuscale) + (Float local3)))
                        color($FF, $FF, $FF)
                        aatext(local2, local3, scplang_getphrase("menu.trackmode"), $00, $00, 1.0)
                        usertrackmode = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), usertrackmode, $00)
                        If (usertrackmode <> 0) Then
                            aatext(local2, (Int ((20.0 * menuscale) + (Float local3))), scplang_getphrase("menu.repeat"), $00, $00, 1.0)
                        Else
                            aatext(local2, (Int ((20.0 * menuscale) + (Float local3))), scplang_getphrase("menu.random"), $00, $00, 1.0)
                        EndIf
                        If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "usertrackmode", 0.0, $00)
                        EndIf
                    EndIf
                Case $03
                    aasetfont(local1\Field0[$00])
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    mousesensitivity = ((slidebar((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (4.0 * menuscale))), (Int (100.0 * menuscale)), ((mousesensitivity + 0.5) * 100.0)) / 100.0) - 0.5)
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.mousesensitivity"), $00, $00, 1.0)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (4.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "mousesensitivity", mousesensitivity, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.invertmouse"), $00, $00, 1.0)
                    invertmouse = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), invertmouse, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "mouseinvert", 0.0, $00)
                    EndIf
                    local3 = (Int ((40.0 * menuscale) + (Float local3)))
                    mouse_smooth = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), mouse_smooth, $00)
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.mousesmoothing"), $00, $00, 1.0)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) - (4.0 * menuscale))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "mousesmoothing", 0.0, $00)
                    EndIf
                    color($FF, $FF, $FF)
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    aatext(local2, local3, scplang_getphrase("menu.controlconfig"), $00, $00, 1.0)
                    local3 = (Int ((10.0 * menuscale) + (Float local3)))
                    aatext(local2, (Int ((20.0 * menuscale) + (Float local3))), scplang_getphrase("menu.moveforward"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((20.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_up), 210.0))), $05)
                    aatext(local2, (Int ((40.0 * menuscale) + (Float local3))), scplang_getphrase("menu.strafeleft"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((40.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_left), 210.0))), $03)
                    aatext(local2, (Int ((60.0 * menuscale) + (Float local3))), scplang_getphrase("menu.movebackward"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((60.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_down), 210.0))), $06)
                    aatext(local2, (Int ((80.0 * menuscale) + (Float local3))), scplang_getphrase("menu.straferight"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((80.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_right), 210.0))), $04)
                    aatext(local2, (Int ((100.0 * menuscale) + (Float local3))), scplang_getphrase("menu.manualblink"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((100.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_blink), 210.0))), $07)
                    aatext(local2, (Int ((120.0 * menuscale) + (Float local3))), scplang_getphrase("menu.sprint"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((120.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_sprint), 210.0))), $08)
                    aatext(local2, (Int ((140.0 * menuscale) + (Float local3))), scplang_getphrase("menu.inventory"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((140.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_inv), 210.0))), $09)
                    aatext(local2, (Int ((160.0 * menuscale) + (Float local3))), scplang_getphrase("menu.crouch"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((160.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_crouch), 210.0))), $0A)
                    aatext(local2, (Int ((180.0 * menuscale) + (Float local3))), scplang_getphrase("menu.quicksave"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((180.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_save), 210.0))), $0B)
                    If (canopenconsole <> 0) Then
                        aatext(local2, (Int ((200.0 * menuscale) + (Float local3))), scplang_getphrase("menu.console"), $00, $00, 1.0)
                        inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((200.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_console), 210.0))), $0C)
                    EndIf
                    aatext(local2, (Int ((220.0 * menuscale) + (Float local3))), scplang_getphrase("menu.screenshot"), $00, $00, 1.0)
                    inputbox((Int ((200.0 * menuscale) + (Float local2))), (Int ((220.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_screenshot), 210.0))), $0D)
                    If (mouseon(local2, local3, (Int (300.0 * menuscale)), (Int (240.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "controls", 0.0, $00)
                    EndIf
                    For local17 = $00 To $E3 Step $01
                        If (keyhit(local17) <> 0) Then
                            local18 = local17
                            Exit
                        EndIf
                    Next
                    If (local18 <> $00) Then
                        Select selectedinputbox
                            Case $03
                                key_left = local18
                            Case $04
                                key_right = local18
                            Case $05
                                key_up = local18
                            Case $06
                                key_down = local18
                            Case $07
                                key_blink = local18
                            Case $08
                                key_sprint = local18
                            Case $09
                                key_inv = local18
                            Case $0A
                                key_crouch = local18
                            Case $0B
                                key_save = local18
                            Case $0C
                                key_console = local18
                            Case $0D
                                key_screenshot = local18
                        End Select
                        selectedinputbox = $00
                    EndIf
                Case $04
                    aasetfont(local1\Field0[$00])
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.hud"), $00, $00, 1.0)
                    hudenabled = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), hudenabled, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "hud", 0.0, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.enableconsole"), $00, $00, 1.0)
                    canopenconsole = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), canopenconsole, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "consoleenable", 0.0, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    If (canopenconsole <> 0) Then
                        color($FF, $FF, $FF)
                        aatext(local2, local3, scplang_getphrase("menu.consoleonerror"), $00, $00, 1.0)
                        consoleopening = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), consoleopening, $00)
                        If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "consoleerror", 0.0, $00)
                        EndIf
                    Else
                        consoleopening = $00
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    If (canopenconsole <> 0) Then
                        color($FF, $FF, $FF)
                        aatext(local2, local3, scplang_getphrase("menu.consoleversion"), $00, $00, 1.0)
                        consoleversion = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), consoleversion, $00)
                        If (consoleversion = $01) Then
                            aatext((Int ((310.0 * menuscale) + (Float local2))), local3, scplang_getphrase("menu.consolenew"), $00, $00, 1.0)
                        Else
                            aatext((Int ((310.0 * menuscale) + (Float local2))), local3, scplang_getphrase("menu.consoleold"), $00, $00, 1.0)
                        EndIf
                        If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "consoleversion", 0.0, $00)
                        EndIf
                    EndIf
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    local3 = (Int ((50.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.showfps"), $00, $00, 1.0)
                    showfps = drawtick((Int ((270.0 * menuscale) + (Float local2))), local3, showfps, $00)
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "showfps", 0.0, $00)
                    EndIf
                    local3 = (Int ((30.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.framelimit"), $00, $00, 1.0)
                    color($FF, $FF, $FF)
                    If (drawtick((Int ((270.0 * menuscale) + (Float local2))), local3, (0.0 < currframelimit), $00) <> 0) Then
                        currframelimit = (slidebar((Int ((150.0 * menuscale) + (Float local2))), (Int ((30.0 * menuscale) + (Float local3))), (Int (100.0 * menuscale)), (currframelimit * 99.0)) / 99.0)
                        currframelimit = max(currframelimit, 0.01)
                        framelimit = (Int ((currframelimit * 100.0) + 19.0))
                        color($FF, $FF, $00)
                        aatext((Int ((5.0 * menuscale) + (Float local2))), (Int ((25.0 * menuscale) + (Float local3))), ((Str framelimit) + " FPS"), $00, $00, 1.0)
                    Else
                        currframelimit = 0.0
                        framelimit = $00
                    EndIf
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "framelimit", (Float framelimit), $00)
                    EndIf
                    If (mouseon((Int ((150.0 * menuscale) + (Float local2))), (Int ((30.0 * menuscale) + (Float local3))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "framelimit", (Float framelimit), $00)
                    EndIf
                    local3 = (Int ((80.0 * menuscale) + (Float local3)))
                    color($FF, $FF, $FF)
                    aatext(local2, local3, scplang_getphrase("menu.antialiasedtext"), $00, $00, 1.0)
                    aatextenable = drawtick((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), aatextenable, $00)
                    If (aatextenable_prev <> aatextenable) Then
                        For local20 = Each aafont
                            freefont(local20\Field6)
                            If (aatextenable = $00) Then
                                freetexture(local20\Field0)
                                freeimage(local20\Field1)
                            EndIf
                            Delete local20
                        Next
                        If (aatextenable = $00) Then
                            freeentity(aatextcam)
                        EndIf
                        initaafont()
                        local1\Field0[$00] = aaloadfont(scpmodding_processfilepath("GFX\font\cour\Courier New.ttf"), (Int (((Float graphicheight) / 1024.0) * 18.0)), $00, $00, $00, $02)
                        local1\Field0[$01] = aaloadfont(scpmodding_processfilepath("GFX\font\courbd\Courier New.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
                        local1\Field0[$02] = aaloadfont(scpmodding_processfilepath("GFX\font\DS-DIGI\DS-Digital.ttf"), (Int (((Float graphicheight) / 1024.0) * 22.0)), $00, $00, $00, $02)
                        local1\Field0[$03] = aaloadfont(scpmodding_processfilepath("GFX\font\DS-DIGI\DS-Digital.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
                        local1\Field0[$04] = aaloadfont(scpmodding_processfilepath("GFX\font\Journal\Journal.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
                        local1\Field1 = aaloadfont("Blitz", (Int (((Float graphicheight) / 1024.0) * 22.0)), $00, $00, $00, $01)
                        aatextenable_prev = aatextenable
                    EndIf
                    If (mouseon((Int ((270.0 * menuscale) + (Float local2))), (Int ((Float local3) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local10), (Int local11), (Int local12), (Int local13), "antialiastext", 0.0, $00)
                    EndIf
            End Select
        ElseIf (((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg > $00)) And (0.0 <= killtimer)) <> 0) Then
            local21 = $3C
            If (((selecteddifficulty\Field4 = $01) Or (selecteddifficulty\Field4 = $00)) <> 0) Then
                local22 = playerroom\Field7\Field10
                local23 = $01
                If ((((local22 = "room173intro") Or (local22 = "gateb")) Or (local22 = "gatea")) <> 0) Then
                    local23 = $00
                EndIf
                If (cansave = $00) Then
                    local23 = $00
                EndIf
                If (local23 <> 0) Then
                    local21 = $8C
                    If (drawbutton(local2, (Int ((60.0 * menuscale) + (Float local3))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.saveandquit"), $01, $00, $01) <> 0) Then
                        dropspeed = 0.0
                        savegame((("Saves\" + currsave) + "\"))
                        nullgame($01)
                        ms\Field1 = $00
                        ms\Field0 = $01
                        ms\Field3 = $00
                        currsave = ""
                        flushkeys()
                    EndIf
                EndIf
            EndIf
            If (drawbutton(local2, (Int (((Float local21) * menuscale) + (Float local3))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.quit3"), $01, $00, $01) <> 0) Then
                nullgame($01)
                ms\Field1 = $00
                ms\Field0 = $01
                ms\Field3 = $00
                currsave = ""
                flushkeys()
            EndIf
            If (drawbutton((Int ((101.0 * menuscale) + (Float local2))), (Int ((344.0 * menuscale) + (Float local3))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.back2"), $01, $00, $01) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                mousehit1 = $00
            EndIf
        Else
            If (drawbutton((Int ((101.0 * menuscale) + (Float local2))), (Int ((344.0 * menuscale) + (Float local3))), (Int (230.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.back2"), $01, $00, $01) <> 0) Then
                achievementsmenu = $00
                optionsmenu = $00
                quitmsg = $00
                mousehit1 = $00
            EndIf
            If (achievementsmenu > $00) Then
                If (floor(4.833333) >= (Float achievementsmenu)) Then
                    If (drawbutton((Int ((341.0 * menuscale) + (Float local2))), (Int ((344.0 * menuscale) + (Float local3))), (Int (50.0 * menuscale)), (Int (60.0 * menuscale)), ">", $01, $00, $01) <> 0) Then
                        achievementsmenu = (achievementsmenu + $01)
                    EndIf
                EndIf
                If (achievementsmenu > $01) Then
                    If (drawbutton((Int ((41.0 * menuscale) + (Float local2))), (Int ((344.0 * menuscale) + (Float local3))), (Int (50.0 * menuscale)), (Int (60.0 * menuscale)), "<", $01, $00, $01) <> 0) Then
                        achievementsmenu = (achievementsmenu - $01)
                    EndIf
                EndIf
                For local17 = $00 To $0B Step $01
                    If ((((achievementsmenu - $01) * $0C) + local17) < $3B) Then
                        drawachvimg(local6, (Int (((Float ((local17 Sar $02) * $78)) * menuscale) + (Float local3))), (((achievementsmenu - $01) * $0C) + local17))
                    Else
                        Exit
                    EndIf
                Next
                For local17 = $00 To $0B Step $01
                    If ((((achievementsmenu - $01) * $0C) + local17) < $3B) Then
                        If (mouseon((((local17 Mod $04) * local8) + local6), (Int (((Float ((local17 Sar $02) * $78)) * menuscale) + (Float local3))), (Int (64.0 * local7)), (Int (64.0 * local7))) <> 0) Then
                            achievementtooltip((((achievementsmenu - $01) * $0C) + local17))
                            Exit
                        EndIf
                    Else
                        Exit
                    EndIf
                Next
            EndIf
        EndIf
        local3 = (local3 + $0A)
        If ((((achievementsmenu <= $00) And (optionsmenu <= $00)) And (quitmsg <= $00)) <> 0) Then
            If (0.0 <= killtimer) Then
                local3 = (Int ((72.0 * menuscale) + (Float local3)))
                If (drawbutton(local2, local3, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.resume"), $01, $01, $01) <> 0) Then
                    ms\Field1 = $00
                    resumesounds()
                    mousexspeed()
                    mouseyspeed()
                    mousezspeed()
                    mouse_x_speed_1 = 0.0
                    mouse_y_speed_1 = 0.0
                    mouse_x_leverturn = 0.0
                    mouse_y_leverturn = 0.0
                EndIf
                local3 = (Int ((75.0 * menuscale) + (Float local3)))
                If (selecteddifficulty\Field2 = $00) Then
                    If (gamesaved <> 0) Then
                        If (drawbutton(local2, local3, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.loadgame2"), $01, $00, $01) <> 0) Then
                            drawloading($00, $00)
                            ms\Field1 = $00
                            loadgamequick((("Saves\" + currsave) + "\"))
                            movemouse(viewport_center_x, viewport_center_y)
                            aasetfont(local1\Field0[$00])
                            hidepointer()
                            flushkeys()
                            flushmouse()
                            playable = $01
                            updaterooms()
                            For local24 = Each rooms
                                local2 = (Int (Abs (entityx(collider, $00) - entityx(local24\Field2, $00))))
                                local25 = (Int (Abs (entityz(collider, $00) - entityz(local24\Field2, $00))))
                                If (((12.0 > (Float local2)) And (12.0 > (Float local25))) <> 0) Then
                                    mapfound((Int floor((entityx(local24\Field2, $00) / 8.0))), (Int floor((entityz(local24\Field2, $00) / 8.0)))) = (Int max((Float mapfound((Int floor((entityx(local24\Field2, $00) / 8.0))), (Int floor((entityz(local24\Field2, $00) / 8.0))))), 1.0))
                                    If (((4.0 > (Float local2)) And (4.0 > (Float local25))) <> 0) Then
                                        If (1.5 > (Abs (entityy(collider, $00) - entityy(local24\Field2, $00)))) Then
                                            playerroom = local24
                                        EndIf
                                        mapfound((Int floor((entityx(local24\Field2, $00) / 8.0))), (Int floor((entityz(local24\Field2, $00) / 8.0)))) = $01
                                    EndIf
                                EndIf
                            Next
                            drawloading($64, $00)
                            dropspeed = 0.0
                            updateworld(0.0)
                            local0\Field1 = millisecs()
                            local0\Field3[$00] = 0.0
                            resetinput()
                        EndIf
                    Else
                        drawframe(local2, local3, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), $00, $00)
                        color($64, $64, $64)
                        aasetfont(local1\Field0[$01])
                        aatext((Int (((430.0 * menuscale) / 2.0) + (Float local2))), (Int (((60.0 * menuscale) / 2.0) + (Float local3))), scplang_getphrase("menu.loadgame2"), $01, $01, 1.0)
                    EndIf
                    local3 = (Int ((75.0 * menuscale) + (Float local3)))
                EndIf
                If (drawbutton(local2, local3, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.achievements2"), $01, $00, $01) <> 0) Then
                    achievementsmenu = $01
                EndIf
                local3 = (Int ((75.0 * menuscale) + (Float local3)))
                If (selecteddifficulty\Field10 <> 0) Then
                    If (drawbutton(local2, local3, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.options2"), $01, $00, $01) <> 0) Then
                        optionsmenu = $01
                    EndIf
                    local3 = (Int ((75.0 * menuscale) + (Float local3)))
                EndIf
            Else
                local3 = (Int ((104.0 * menuscale) + (Float local3)))
                If ((gamesaved And (selecteddifficulty\Field2 = $00)) <> 0) Then
                    If (drawbutton(local2, local3, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.loadgame2"), $01, $00, $01) <> 0) Then
                        drawloading($00, $00)
                        ms\Field1 = $00
                        loadgamequick((("Saves\" + currsave) + "\"))
                        movemouse(viewport_center_x, viewport_center_y)
                        aasetfont(local1\Field0[$00])
                        hidepointer()
                        flushkeys()
                        flushmouse()
                        playable = $01
                        updaterooms()
                        For local24 = Each rooms
                            local2 = (Int (Abs (entityx(collider, $00) - entityx(local24\Field2, $00))))
                            local25 = (Int (Abs (entityz(collider, $00) - entityz(local24\Field2, $00))))
                            If (((12.0 > (Float local2)) And (12.0 > (Float local25))) <> 0) Then
                                mapfound((Int floor((entityx(local24\Field2, $00) / 8.0))), (Int floor((entityz(local24\Field2, $00) / 8.0)))) = (Int max((Float mapfound((Int floor((entityx(local24\Field2, $00) / 8.0))), (Int floor((entityz(local24\Field2, $00) / 8.0))))), 1.0))
                                If (((4.0 > (Float local2)) And (4.0 > (Float local25))) <> 0) Then
                                    If (1.5 > (Abs (entityy(collider, $00) - entityy(local24\Field2, $00)))) Then
                                        playerroom = local24
                                    EndIf
                                    mapfound((Int floor((entityx(local24\Field2, $00) / 8.0))), (Int floor((entityz(local24\Field2, $00) / 8.0)))) = $01
                                EndIf
                            EndIf
                        Next
                        drawloading($64, $00)
                        dropspeed = 0.0
                        updateworld(0.0)
                        local0\Field1 = millisecs()
                        local0\Field3[$00] = 0.0
                        resetinput()
                    EndIf
                Else
                    drawbutton(local2, local3, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), "", $01, $00, $01)
                    color($32, $32, $32)
                    aatext((Int ((185.0 * menuscale) + (Float local2))), (Int ((30.0 * menuscale) + (Float local3))), scplang_getphrase("menu.loadgame2"), $01, $01, 1.0)
                EndIf
                If (drawbutton(local2, (Int ((80.0 * menuscale) + (Float local3))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.quit4"), $01, $00, $01) <> 0) Then
                    nullgame($01)
                    ms\Field1 = $00
                    ms\Field0 = $01
                    ms\Field3 = $00
                    currsave = ""
                    flushkeys()
                EndIf
                local3 = (Int ((80.0 * menuscale) + (Float local3)))
            EndIf
            If (((0.0 <= killtimer) And (ms\Field0 = $00)) <> 0) Then
                If (drawbutton(local2, local3, (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.quit3"), $01, $00, $01) <> 0) Then
                    quitmsg = $01
                EndIf
            EndIf
            aasetfont(local1\Field0[$00])
            If (0.0 > killtimer) Then
                rowtext(deathmsg, local2, (Int ((80.0 * menuscale) + (Float local3))), (Int (430.0 * menuscale)), (Int (600.0 * menuscale)), $00, 1.0)
            EndIf
        EndIf
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
    EndIf
    aasetfont(local1\Field0[$00])
    Return $00
End Function
