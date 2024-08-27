Function drawending%()
    Local local0.fonts
    Local local1.fps_settings
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7.itemtemplates
    Local local8.rooms
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    local0 = (First fonts)
    local1 = (First fps_settings)
    showpointer()
    local1\Field3[$00] = 0.0
    If (-2000.0 < i_end\Field0) Then
        i_end\Field0 = max((i_end\Field0 - local1\Field3[$01]), -1111.0)
    Else
        i_end\Field0 = (i_end\Field0 - local1\Field3[$01])
    EndIf
    giveachievement($04, $01)
    If (usedconsole = $00) Then
        putinivalue("options.ini", "game", "th", "1")
        unlockthaumiel = $01
        giveachievement($3A, $01)
    EndIf
    If (usedconsole = $00) Then
        giveachievement($1D, $01)
    EndIf
    If (selecteddifficulty\Field0 = "Keter") Then
        giveachievement($1F, $01)
    EndIf
    Select lower(i_end\Field2)
        Case "b2","a1"
            clscolor((Int max(((i_end\Field0 * 2.8) + 255.0), 0.0)), (Int max(((i_end\Field0 * 2.8) + 255.0), 0.0)), (Int max(((i_end\Field0 * 2.8) + 255.0), 0.0)))
        Default
            clscolor($00, $00, $00)
    End Select
    shouldplay = $42
    cls()
    If (-200.0 > i_end\Field0) Then
        If (breathchn <> $00) Then
            If (channelplaying(breathchn) <> 0) Then
                stopchannel(breathchn)
                stamina = 100.0
            EndIf
        EndIf
        If (i_end\Field1 = $00) Then
            i_end\Field1 = loadimage_strict(scpmodding_processfilepath("GFX\endingscreen.pt"))
            shouldplay = $17
            currmusicvolume = musicvolume
            currmusicvolume = musicvolume
            stopstream_strict(musicchn)
            musicchn = streamsound_strict(scpmodding_processfilepath((("SFX\Music" + music($17)) + ".ogg")), currmusicvolume, $00)
            nowplaying = shouldplay
            playsound_strict(lightsfx)
        EndIf
        If (-700.0 < i_end\Field0) Then
            If (min(((Abs i_end\Field0) - 200.0), 155.0) > (Float rand($01, $96))) Then
                drawimage(i_end\Field1, ((graphicwidth Sar $01) - $190), ((graphicheight Sar $01) - $190), $00)
            Else
                color($00, $00, $00)
                rect($64, $64, (graphicwidth - $C8), (graphicheight - $C8), $01)
                color($FF, $FF, $FF)
            EndIf
            If (((-450.0 < (i_end\Field0 + local1\Field3[$01])) And (-450.0 >= i_end\Field0)) <> 0) Then
                Select lower(i_end\Field2)
                    Case "a1","a2"
                        playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\Ending\GateA\Ending" + i_end\Field2) + ".ogg"))))
                    Case "b1","b2","b3"
                        playsound_strict(loadtempsound(scpmodding_processfilepath((("SFX\Ending\GateB\Ending" + i_end\Field2) + ".ogg"))))
                End Select
            EndIf
        Else
            drawimage(i_end\Field1, ((graphicwidth Sar $01) - $190), ((graphicheight Sar $01) - $190), $00)
            If (((-1000.0 > i_end\Field0) And (-2000.0 < i_end\Field0)) <> 0) Then
                local4 = imagewidth(pausemenuimg)
                local5 = imageheight(pausemenuimg)
                local2 = ((graphicwidth Sar $01) - (local4 Sar $01))
                local3 = ((graphicheight Sar $01) - (local5 Sar $01))
                drawimage(pausemenuimg, local2, local3, $00)
                color($FF, $FF, $FF)
                aasetfont(local0\Field0[$01])
                aatext((Int ((40.0 * menuscale) + (Float ((local4 Sar $01) + local2)))), (Int ((20.0 * menuscale) + (Float local3))), scplang_getphrase("ingame.theend"), $01, $00, 1.0)
                aasetfont(local0\Field0[$00])
                If (achievementsmenu = $00) Then
                    local2 = (Int ((132.0 * menuscale) + (Float local2)))
                    local3 = (Int ((122.0 * menuscale) + (Float local3)))
                    local11 = $00
                    local12 = $00
                    For local8 = Each rooms
                        local11 = (local11 + $01)
                        local12 = (local12 + local8\Field1)
                    Next
                    local13 = $00
                    local14 = $00
                    For local7 = Each itemtemplates
                        If (local7\Field1 = "paper") Then
                            local13 = (local13 + $01)
                            local14 = (local14 + local7\Field3)
                        EndIf
                    Next
                    local15 = $01
                    For local16 = $00 To $18 Step $01
                        local15 = (local15 + achievements(local16))
                    Next
                    local17 = $00
                    For local16 = $00 To $3A Step $01
                        local17 = (local17 + achievements(local16))
                    Next
                    aatext(local2, local3, ((scplang_getphrase("ingame.scpsencountered") + " ") + (Str local15)), $00, $00, 1.0)
                    aatext(local2, (Int ((20.0 * menuscale) + (Float local3))), ((((scplang_getphrase("ingame.achunlocked") + " ") + (Str local17)) + "/") + "59"), $00, $00, 1.0)
                    aatext(local2, (Int ((40.0 * menuscale) + (Float local3))), ((((scplang_getphrase("ingame.roomsfound") + " ") + (Str local12)) + "/") + (Str local11)), $00, $00, 1.0)
                    aatext(local2, (Int ((60.0 * menuscale) + (Float local3))), ((((scplang_getphrase("ingame.docsdiscovered") + " ") + (Str local14)) + "/") + (Str local13)), $00, $00, 1.0)
                    aatext(local2, (Int ((80.0 * menuscale) + (Float local3))), ((scplang_getphrase("ingame.itemsrefined") + " ") + (Str refineditems)), $00, $00, 1.0)
                    If (((unlockthaumiel = $00) And (usedconsole = $00)) <> 0) Then
                        aatext(local2, (Int ((120.0 * menuscale) + (Float local3))), scplang_getphrase("ingame.apollyonunlock"), $00, $00, 1.0)
                    EndIf
                    local2 = ((graphicwidth Sar $01) - (local4 Sar $01))
                    local3 = ((graphicheight Sar $01) - (local5 Sar $01))
                    local2 = (local2 + (local4 Sar $01))
                    local3 = (Int ((Float (local3 + local5)) - (100.0 * menuscale)))
                    If (drawbutton((Int ((Float local2) - (170.0 * menuscale))), (Int ((Float local3) - (200.0 * menuscale))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.achievements"), $01, $00, $01) <> 0) Then
                        achievementsmenu = $01
                    EndIf
                    If (drawbutton((Int ((Float local2) - (170.0 * menuscale))), (Int ((Float local3) - (100.0 * menuscale))), (Int (430.0 * menuscale)), (Int (60.0 * menuscale)), scplang_getphrase("menu.mainmenu"), $01, $00, $01) <> 0) Then
                        shouldplay = $18
                        nowplaying = shouldplay
                        For local16 = $00 To $09 Step $01
                            If (tempsounds[local16] <> $00) Then
                                freesound_strict(tempsounds[local16])
                                tempsounds[local16] = $00
                            EndIf
                        Next
                        stopstream_strict(musicchn)
                        musicchn = streamsound_strict(scpmodding_processfilepath((("SFX\Music\" + music(nowplaying)) + ".ogg")), 0.0, $02)
                        setstreamvolume_strict(musicchn, (1.0 * musicvolume))
                        flushkeys()
                        i_end\Field0 = -2000.0
                        initcredits()
                    EndIf
                Else
                    shouldplay = $17
                    drawmenu()
                EndIf
            ElseIf (-2000.0 >= i_end\Field0) Then
                shouldplay = $18
                drawcredits()
            EndIf
        EndIf
    EndIf
    If (fullscreen <> 0) Then
        drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
    EndIf
    aasetfont(local0\Field0[$00])
    Return $00
End Function
